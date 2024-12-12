package assignments.ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {

            if (!isNumber(num)) { //if num is invalid
                return -1;
            }
            int bindex = num.indexOf('b'); // Finding the index of b
            int base = 10; // if b doesn't exist the base is 10

            if (bindex != -1) { // if b exists
                String basePart = num.substring(bindex + 1); // string of the base
                 base = Character.digit(basePart.charAt(0), 36); // Converting the char to numerical value
                num = num.substring(0, bindex); // string of the number part
            }
            int decimalnum = 0; //Initializing the decimal number as 0
            for (int i = 0; i < num.length(); i++) { // a loop that passes all the chars of the number part string
                int digit = Character.digit(num.charAt(i), base); //converting all char in ths string to numerical value according to the base
                if (digit == -1) { // if the digit is invalid accordingly to the base
                    return -1;
                }
                decimalnum = decimalnum * base + digit; // calculating the decimal value of the number
            }
            return decimalnum; // return the final decimal value of the number
        }

        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans= true; // Initializing ans as true
            String validChar= "0123456789ABCDEFG"; // the valid chars
            String num= "0123456789"; //the valid digits
            char lastChar = a.charAt(a.length()-1); // the last char in the string a
            int bindex = a.indexOf('b'); //Finding the index of b

            if (bindex != -1) { // if b exists
                if (bindex == 0 || bindex == a.length() - 1) { //if b is located in the first char or the last char of the string
                    return false; // the string is invalid
                }
            }
            if (a.isEmpty()) { // if the string is empty
                return false; // the num is invalid
            }


            if (!a.contains("b") && a.chars().allMatch(Character::isDigit)) { // if b doesn't exist in the string and all the chars are digits
                return true; // the base is 10 and the string is valid
            }

            if (a.length()<2 && num.contains(String.valueOf(lastChar))){ //if the string is only one char and is a digit
                return true;
            }
            else if(a.length()<2){ // if the length of ths string smaller than 2 and the last char is not a digit
                return false; // the string is invalid
            }
            char secondTolast =a.charAt(a.length()-2); // the b char is the char in the second index from the end
            char firstChar = a.charAt(0); // the first char in the string
            if(firstChar =='b' || firstChar == ' '){ //if the string starts in 'b' or ' '
                return false; // the string is invalid
            }
            if (!validChar.contains(String.valueOf(lastChar)) && secondTolast !='b'){ // if the last char is invalid and the previous char is not b
                return false; // the string is not valid
            }
            int baseIndex =validChar.indexOf(lastChar); // the index of the base in the validChar string
            int indexOfb = a.length()-2; // the index of b
            String currentString =validChar.substring(0, baseIndex); // string of the valid chars for the base
            String numPart= a.substring(0,indexOfb); //the number part of the string
            for (int i=0; i< numPart.length(); i++){ // A loop that passes the chars in the numPart string
                char currentChar = a.charAt(i); //The current char in the string
                if (!currentString.contains(String.valueOf(currentChar))){ //if the currentChar doesn't exist in the currentString
                    ans = false; // the string is invalid
                }
            }
            return ans;// the string is valid
        }


        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = ""; // Initializing ans as ""
            if (num==0){ // if the number is 0
                return "0"; // return 0
            }
            if(num>0 && base>=2 && base<=16){ // if the number is greater than 0 and the base is valid
                String result = ""; // Initialize result as an empty string

                while (num > 0) {
                    int remainder = num % base; //Calculating the remainder, the remainder is the last digit of the new number(the converted number)
                    char digitChar = Character.forDigit(remainder, base); //Converting the remainder to a digit according to the base
                    result = digitChar + result; // Adding the digit to the start of the string
                    num /= base; // dividing the number in the base and then updating the value of num
                }
                result = result.toUpperCase(); //Converting to Upper letters
                if (base == 10) { // if the base is 10
                    return result; // return only the number part without 'b' and the base
                }
                char baseChar = (base <= 10) ? (char) ('0' + base) : (char) ('A' + (base - 10)); // if the base smaller than 10 write the base as a digit and if the base is greater than 10 write the base as a big letter(B-G)
                return result + "b" + baseChar; // return the string in format of the converted number then 'b' and then the base
            }
            return ans; // return the string
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true; //Initializing ans as true
         if(number2Int(n1) != number2Int(n2)){ //if the numerical value of n1 is different from the value of n2
             return false;
            }
         return ans; // return true;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int maxIndex=-1; // Initialize the max index as -1
            int maxValue = Integer.MIN_VALUE; //Initialize the max value as the min value of Java

        for(int i=0; i< arr.length; i++){ //A loop passes all the index in the array
            int currentValue = number2Int(arr[i]); //Defining the currentValue to the numerical value of arr[i]
            if(currentValue != -1 && currentValue > maxValue){ // if the current value is valid and the current value greater than the maxValue
                maxValue= currentValue; // Update the maxValue to the currentValue;
                maxIndex=i ; // Update the maxIndex to i
            }
        }
        return maxIndex; // return the maxIndex
        }
}
