
/*********************************************************************************************************
This class is ReaderAndWriter. The mean function of this class is reading the input file, processing data
and generate the output file. There are four methods in this class. 

1. readerAndWriter: this method reads the input file and generate output file. This function read file and
write file at same time.
2. lineSeparator: it split line in tokens, so the input of this method is the line read from file and 
output is tokens in form of ArrayList.

3. superRateGenerator: it transform the super rate from String to float. The String is in form of 10%, so
in the program, the "%" need to be removed from String and the number need to be divided by 100, after it
transform to float.

4. outputGenerator: this is the detailed method which process the data. the input of this method is data 
which are read from input file and output of this method is a string which will be written output file.
*********************************************************************************************************/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReaderAndWriter {

	public static void readerAndWriter(File inputFileName, File outputFileName) {
		try {
			String line = "";
			String outputLine = "";
			ArrayList<String> itemsInLine = new ArrayList<String>();

			BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

			writer.write(Settings.OUTPUT_HEADER); // write the header of output file.
			writer.newLine(); // after writing the header, start a new line.
			reader.readLine(); /*
								 * This step is reading the header of input file
								 * which do not need to be processed later.
								 */

			while ((line = reader.readLine()) != null) {
				// while there still has line, do the following step.
				itemsInLine = lineSeparator(line);
				outputLine = outputGenerator(itemsInLine);
				writer.write(outputLine);
				writer.newLine();
			}
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			;
		}
	}

	/*
	 * Input: line which is read from input file 
	 * Output: tokens of line in form of ArrayList
	 */
	public static ArrayList<String> lineSeparator(String line) {
		String[] item = {};

		item = line.split("\\s*,\\s*");
		// .csv file is Comma-Separated Values, so the value can be split by ","
		/* "\\s*" means 0 or more space, here aim to the solve the problems may 
		 caused by the space around ","
		 */
		ArrayList<String> itemsInLine = new ArrayList<String>(Arrays.asList(item));

		return itemsInLine;
	}

	/*
	 * Input: super rate gotten from input file which is in form of string
	 * Output: spuer rate in form of folat
	 */
	public static float superRateGenerator(String inputSuperRate) {
		float superRate = 0;
		float temSuperRate = 0;
		int lengthOfStr = 0;
		int NumPartOfSuperRate;

		lengthOfStr = inputSuperRate.length();
		NumPartOfSuperRate = lengthOfStr - 1;
		String temSuperRateStr = inputSuperRate.substring(0, NumPartOfSuperRate);
		temSuperRate = Float.parseFloat(temSuperRateStr);
		superRate = temSuperRate / 100;
		/*
		 * In this case, the super rate for input file is 10% (for example), so
		 * we need to get the number part of the data and divided by 100, that
		 * is the actual super rate.
		 */

		return superRate;
	}

	/*
	 * Input: tokens of line gotten from input file in form of ArrayList 
	 * Output: outputLin which can be written in the output file
	 */
	public static String outputGenerator(ArrayList<String> itemsInLine) {
		String nameStr = "";
		String payPeriodStr = "";
		String grossIncomeStr = "";
		String incomeTaxStr = "";
		String netIncomeStr = "";
		String superAmountStr = "";
		String outputLine = "";
		float superRate = 0;
		long annualSalary = 0;

		// First, get all the values transform them from String to number and calculate the result
		annualSalary = Long.parseLong(itemsInLine.get(Settings.INDEX_OF_ANNUAL_SALARY));
		superRate = superRateGenerator(itemsInLine.get(Settings.INDEX_OF_SUPER_RATE));

		// Then, calculate the results using the data gotten from first step.
		long grossIncome = Calculator.grossIncome(annualSalary);
		long incomeTax = Calculator.incomeTax(annualSalary);
		long netIncome = Calculator.netIncome(annualSalary);
		long superAmount = Calculator.superOfIncome(annualSalary, superRate);

		// Next, transform the result into String.
		nameStr = itemsInLine.get(Settings.INDEX_OF_FIRST_NAME) + " " + itemsInLine.get(Settings.INDEX_OF_LAST_NAME);
		payPeriodStr = itemsInLine.get(Settings.INDEX_OF_PAYMENT_START_DATE);
		grossIncomeStr = Long.toString(grossIncome);
		incomeTaxStr = Long.toString(incomeTax);
		netIncomeStr = Long.toString(netIncome);
		superAmountStr = Long.toString(superAmount);

		// Finally, generate results(String) into one string where each token separated by ","
		// This form can be written in the output file.
		outputLine = nameStr + "," + payPeriodStr + "," + grossIncomeStr + "," + incomeTaxStr + "," + netIncomeStr + ","
				+ superAmountStr + ",";

		return outputLine;
	}

}
