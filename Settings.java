
/*********************************************************************************************************
This class is used to set all the variables which will not be changed in whole program. There are 20
variables in it:
	
 1. NUMBER_OF_MONTHS: means how many months in a year, which are used when calculate gross income and income
   tax for each month.	 
 2. OUTPUT_HEADER: the header in the output file (result will be write on this file).
 3. INPUT_FILE: the path of file which is read to get the data.
 4. OUTPUT_FILE: the path of file which is used to record the result.
 5. INDEX_OF_FIRST_NAME: the index of first name column in input file. 
 6. INDEX_OF_LAST_NAME: the index of last name column in input file. 
 7. INDEX_OF_ANNUAL_SALARY: the index of annual salary column in input file.
 8. INDEX_OF_SUPER_RATE: the index of super rate column in input file. 
 9. INDEX_OF_PAYMENT_START_DATE: the index of payment start date in input file.
 --------------------------------------------------------------------------------
Level 0 |   0 - $18,200        |    Nil                                        |
Level 1 |   $18,201 - $37,000  |    19c for each $1 over $18,200               | 
Level 2 |   $37,001 - $80,000  |    $3,572 plus 32.5c for each $1 over $37,000 |
Level 3 |   $80,001 - $180,000 |    $17,547 plus 37c for each $1 over $80,000  |
Level 4 |   $180,001 and over  |    $54,547 plus 45c for each $1 over $180,000 |
--------------------------------------------------------------------------------
According to the table above, the BASELINE means the part people don't need to pay the tax, TAX_RATE is 
the percent of tax they need to pay for the part over the BASELINE , BSAE_TAX is the part of tax under the 
baseline, so:
10. LEVEL1_BASELINE: 18200
11. LEVEL1_TAX_RATE: 0.19
 
12. LEVEL2_BASELINE: 37000
13. LEVEL2_TAX_RATE: 0.325
14. LEVEL2_BASE_TAX: 3572
 
15. LEVEL3_BASELINE: 80000
16. LEVEL3_TAX_RATE: 0.37
17. LEVEL3_BASE_TAX: 17547
 
18. LEVEL4_BASELINE: 180000
19. LEVEL4_TAX_RATE: 0.45
20. LEVEL4_BASE_TAX: 54547
*********************************************************************************************************/

public class Settings {

	public static final int NUMBER_OF_MONTHS = 12;
	public static final String OUTPUT_HEADER = "name,pay period,gross income,income tax,net income,super";
	public static final String INPUT_FILE = "src/payslip.csv";
	public static final String OUTPUT_FILE = "src/payslipNew.csv";
	public static final int INDEX_OF_FIRST_NAME = 0;
	public static final int INDEX_OF_LAST_NAME = 1;
	public static final int INDEX_OF_ANNUAL_SALARY = 2;
	public static final int INDEX_OF_SUPER_RATE = 3;
	public static final int INDEX_OF_PAYMENT_START_DATE = 4;
	public static final int LEVEL1_BASELINE = 18200;
	public static final int LEVEL2_BASELINE = 37000;
	public static final int LEVEL3_BASELINE = 80000;
	public static final int LEVEL4_BASELINE = 180000;
	public static final int LEVEL2_BASE_TAX = 3572;
	public static final int LEVEL3_BASE_TAX = 17547;
	public static final int LEVEL4_BASE_TAX = 54547;
	public static final double LEVEL1_TAX_RATE = 0.19;
	public static final double LEVEL2_TAX_RATE = 0.325;
	public static final double LEVEL3_TAX_RATE = 0.37;
	public static final double LEVEL4_TAX_RATE = 0.45;
}
