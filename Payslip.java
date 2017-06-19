
/*********************************************************************************************************
 Author: Lan Yang
 Date: 19 June 2017

The program aim to calculate the gross income, income tax,net income, and super of each employee.There are
four classes in this program, Payslip, ReaderAndWriter, Calculator, Settings.

1. Payslip: contains the main method of the program.
2. ReaderAndWriter: read the input file and processing the data the write the result to output file.
3. Calculator: detailed function of calculating the gross income, income tax,net income, and super by the 
 annual salary and super rate of each employee.
4. Settings: set the static variables which will not be changed in whole program.

The format of Input file and output file are both .csv which are set in Setting class. 
*********************************************************************************************************/

import java.io.File;

public class Payslip {
	public static void main(String[] args) {

		File readFile = new File(Settings.INPUT_FILE);
		File writeFile = new File(Settings.OUTPUT_FILE);

		ReaderAndWriter.readerAndWriter(readFile, writeFile);
	}

}
