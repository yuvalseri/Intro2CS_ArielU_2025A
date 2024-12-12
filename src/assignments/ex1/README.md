In this assignment, we will design a number formatting converter and calculator. 
In general, we will use Strings as numbers over the base of binary till Hexa (2-16), 
10-16 are represented by A,B,..G. 
The general representation of the numbers is as a String with the following format: <number><b><base> .

The function:
1. public static boolean isNumber(String a):
The function gets a string and it checks if the string is valid. if the string is valid it returns "true".
For the string will be valid it must have to be a part of number, then the char 'b' and the last char is base between 2-6
, if the base is 10 or more greater it will be represented by A-G.
the part of the number must be according to the base.
If the string contains only digit the function assume the base is 10 and the string is valid.

2. public static int number2Int(String num):
The function gets a string, it uses "isNumber" function to check if the string is valid and if it valid, it converts
the number in the string to his decimal value and return it.

3. public static String int2Number(int num, int base):
The function gets a number and any base and it converts the number accordingly to the base. 
In the end it returns it as a string, first the new value of the num, then 'b' char and the last char is the base.

4. public static boolean equals(String n1, String n2) 
The function gets two string, it uses the "number2Int" function to get the value of the strings, then it compares the 
two values, if they are equal the function returns "true".

5. public static int maxIndex(String[] arr):
The function gets an array of strings. 
There is a loop that passes all the array, it converts the strings to integer values. At first the max value is 
initalized as the minimum value of Jave. The function passes the array and every time it find greater value it updates 
the "max value". After it passes al the indexes in the array it has the maximum value of the array. 
After that it returns the index of the max value.

In the main file the user is asked to enter two numbers (as a string) in the format: <number><b><base>.
If the number is invalid it will print "The number is not in the format" ask the user to enter number again.
If the numbers are valid it will be printed on the terminal, in addition the decimal value of the number will be printed.
After that the addition and multiplication of the two numbers will be printed.
and  the user will get the maximum of the 4 values.