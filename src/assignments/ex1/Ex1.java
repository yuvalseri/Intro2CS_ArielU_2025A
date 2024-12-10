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

            ////////////////////
            if (num == null || num.isEmpty()) {
                return -1; // the num is invalid
            }
            if(!isNumber(num)){
                return -1;
            }
            int bindex = num.indexOf('b');
            int base = 10; // Difing the defult base as 10

            if (bindex != -1) {
                if (bindex == 0 || bindex == num.length() - 1) {
                    return -1;
                }
                String basePart = num.substring(bindex + 1);
                base = Character.digit(basePart.charAt(0), 36); // Converting the char to numerical value
                if (base < 2 || base > 16) { // if base is not between 2 to 16
                    return -1; // the base is invalid
                }
                num = num.substring(0, bindex); // החלק של המספר עצמו
            }
            // בדיקה של הספרות בבסיס הנבחר
            int decimalnum = 0;
            for (int i = 0; i < num.length(); i++) {
                int digit = Character.digit(num.charAt(i), base);
                if (digit == -1) {
                    return -1; //
                }
                decimalnum = decimalnum * base + digit;
            }
            return decimalnum;
        }
        public static boolean isValidbase(String basePart){
            if (basePart.length() != 1){                     //if the length of the base is different from 1
                return false;                                  // The base is only one char
            }
            char baseChar= basePart.charAt(0);
            int base = Character.digit(baseChar, 36);   //Converting the char to int value
            if( base >= 2 && base <= 16){
                return true;                                // if the value of base is between 2 to 16,the base is valid
            }
            return false;
        }
        public static boolean isValidnum(String num){
            int bindex = num.indexOf('b');
            String numPart = num.substring(0, bindex);
            String basePart = num.substring(bindex + 1);
            char baseChar = basePart.charAt(0);
            int base = Character.digit(baseChar, 36);
            if (numPart.length()==0){
                return false;
            }
            char[] chars= numPart.toCharArray();
            for(int i=0; i<chars.length; i++){
                if(Character.digit(chars[i],base)==-1){ return false;
                }
            }
        return true;
        }


        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans= true;
            String validChar= "0123456789ABCDEFG";
            String num= "0123456789";
            char lastChar = a.charAt(a.length()-1);
            if (a.length()<2 && num.contains(String.valueOf(lastChar))){
                return true;
            }
            else if(a.length()<2){
                return false;}
            char secondTolast =a.charAt(a.length()-2);
            char firstChar =a.charAt(0);
            if(firstChar=='b' || firstChar == ' '){
                return false;
            }
            if (!validChar.contains(String.valueOf(lastChar)) && secondTolast !='b'){
                return false;}
            int baseIndex =validChar.indexOf(lastChar);
            int indexOf2 = a.length()-2;
            String currentString =validChar.substring(0, baseIndex);
            String numPart= a.substring(0,indexOf2);
            for (int i=0; i< numPart.length(); i++){
                char currentChar = a.charAt(i);
                if (!currentString.contains(String.valueOf(currentChar))){
                    ans = false;
                }
            }
            return ans;
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
            String ans = "";
            if (num==0){
                return "0";
            }
            if(num>0 && base>=2 && base<=16){
                String result = ""; // Initialize result as an empty string
                int n = num;

                while (n > 0) {
                    int remainder = n % base; //Calculating the remainder, the remainder is the last digit of the new number(the converted number)
                    char digitChar = Character.forDigit(remainder, base); //Converting the remainder to a digit according to the base
                    result = digitChar + result; // Adding the digit to the start of the string
                    n /= base;
                }
                result = result.toUpperCase(); //Convering to Upper letters
                return result + "b" + base;
            }
            return ans;
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
            int maxIndex = -1; // Initialize the max index as -1
            int maxValue = Integer.MIN_VALUE; //Initialize the max value as the min value of Java

        for(int i=0; i< arr.length; i++){ //A loop passes all the index in the array
            int currentValue = number2Int(arr[i]); //Difining the currentValue to the numerical value of arr[i]
            if(currentValue != -1 && currentValue > maxValue){ // if the current value is valid and the current value greater than the maxValue
                maxValue= currentValue; // Update the maxValue to the currentValue;
                maxIndex=i ; // Update the maxIndex to i
            }
        }
        return maxIndex; // return the maxIndex
        }
}
