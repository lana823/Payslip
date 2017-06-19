/*********************************************************************************************************
This class is Calculator. The mean function of this class is calculating the gross income, income tax, net
income and super according to annual salary and super rate of each employee. There are four methods in this
class:

1. grossIncome: this method calculates gross income = annual salary / 12 months. 

2. incomeTax: income tax is calculated according to table below:
--------------------------------------------------------------------------------
Level 0 |   0 - $18,200        |    Nil                                        |
Level 1 |   $18,201 - $37,000  |    19c for each $1 over $18,200               | 
Level 2 |   $37,001 - $80,000  |    $3,572 plus 32.5c for each $1 over $37,000 |
Level 3 |   $80,001 - $180,000 |    $17,547 plus 37c for each $1 over $80,000  |
Level 4 |   $180,001 and over  |    $54,547 plus 45c for each $1 over $180,000 |
--------------------------------------------------------------------------------

3. netIncome: this method calculates net income = gross income - income tax.

4. superOfIncome: this method calculates super = gross income x super rate.

* All calculation results should be rounded to the whole dollar. If >= 50 cents round up to the next 
  dollar increment, otherwise round down.
*********************************************************************************************************/

public class Calculator {
	
	/*
	 * Input: annualSalary 
	 * Output: gross income which is rounded to the whole dollar
	 */
	public static long grossIncome (long annualSalary) {
		double grossIncome;
		long grossIncomeInt;
		
		grossIncome = (double) annualSalary / Settings.NUMBER_OF_MONTHS;
		//gross income = annual salary / 12 months. 
		grossIncomeInt = Math.round(grossIncome);
		//round gross income to the whole dollar
		
		return grossIncomeInt;
	}
	
	
	/*
	 * Input: annualSalary 
	 * Output: income tax which is rounded to the whole dollar
	 */
	public static long incomeTax (long annualSalary) {
		double annualTax = 0;
		long incomeTaxInt;
		double averageTax = 0;
		
		//Level 0: 0 - $18,200: Nil 
		if (annualSalary >= 0 && annualSalary <= 18200) {
			annualTax = 0;
		} 
		//Level 1: $18,201 - $37,000: 19c for each $1 over $18,200 
		else if (annualSalary > 18200 && annualSalary <= 37000) {
			
			annualTax = (annualSalary - Settings.LEVEL1_BASELINE) * Settings.LEVEL1_TAX_RATE;
		} 
		//Level 2: $37,001 - $80,000: $3,572 plus 32.5c for each $1 over $37,000
		else if (annualSalary > 37000 && annualSalary <= 80000) {
			
			annualTax = Settings.LEVEL2_BASE_TAX + (annualSalary - Settings.LEVEL2_BASELINE) * Settings.LEVEL2_TAX_RATE;
		}
		//$80,001 - $180,000: $17,547 plus 37c for each $1 over $80,000 
		else if (annualSalary > 80000 && annualSalary <= 180000) {
			
			annualTax = Settings.LEVEL3_BASE_TAX + (annualSalary - Settings.LEVEL3_BASELINE) * Settings.LEVEL3_TAX_RATE;
		}
		//$180,001 and over: $54,547 plus 45c for each $1 over $180,000 
		else if (annualSalary > 180000) {
			
			annualTax = Settings.LEVEL4_BASE_TAX + (annualSalary - Settings.LEVEL4_BASELINE) * Settings.LEVEL4_TAX_RATE;
		}
		
		averageTax = annualTax / Settings.NUMBER_OF_MONTHS;
		incomeTaxInt = Math.round(averageTax);		
		//round income tax to the whole dollar
		
		return incomeTaxInt;     
	}
	
	
	/*
	 * Input: annualSalary 
	 * Output: net income
	 */
	public static long netIncome (long annualSalary) {
		long netIncomeInt;
		netIncomeInt = grossIncome(annualSalary) - incomeTax(annualSalary);
		//net income = gross income - income tax
		
		return netIncomeInt;
	}
	
	
	/*
	 * Input: annualSalary and super rate
	 * Output: super which is rounded to the whole dollar
	 */
	public static long superOfIncome (long annualSalary, float superRate) {
		long superAmountInt;
		double superAmount;
		
		superAmount = grossIncome(annualSalary) * superRate;
		//super = gross income x super rate
		superAmountInt = Math.round(superAmount);
		//round income tax to the whole dollar
		
		return superAmountInt;
	}
 
}
