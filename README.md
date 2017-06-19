# Payslip
The program aim to calculate the gross income, income tax,net income, and super of each employee.There are four classes in this program, Payslip, ReaderAndWriter, Calculator, Settings. For detailed introduction, you can find in the comment in each class.

Assumptions:
1.It assumes some employees salary is probable extreme high, so for the salary, the data type is long. The long data type can cover the the range for salary, so when strings are changed into long, no boundary are considered.

2. It assumes the tax rate won’t change frequently, so all the number are use static and final type. And when it changes, the number can be modified in Settings class.

Instruction:

1. After unzip the file, basically you don’t need to change anything to run the code. Just run the main method use Eclipse.  

2. There is one test file called “payslip.csv” in the folder, if you want to change to other file:
 * When you use Eclipse, first, copy the folder into your Eclipse workspace, then you need  to copy the input file into the folder and change the file name in Settings class. (Or change the path)
 * When you want to compile it command line/Terminal, you don’t need to copy the file, just change the path in Settings class. 
 * Same way if you want to change the output file.(The default output file is “payslipNew.csv” )

3. DO NOT USE EXCEL to open the .csv file, the format will be messed up after you open it with EXCEL. If you want to modifier test file, use txt edit.(You probably know this. )

If you have any question to run the code, feel free to contact me.

