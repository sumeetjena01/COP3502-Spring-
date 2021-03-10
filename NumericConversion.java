import java.util.Scanner;

public class NumericConversion {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String numericString = ("");
        int option = 0;
        long result = 0;

        while (true) {

            //repeating menu
            System.out.println("Decoding Menu");
            System.out.println("------------- ");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");


            System.out.println("");
            System.out.print("Please enter an option: ");
            option = in.nextInt();
            if (option != 4) {
                System.out.print("Please enter the numeric string to convert: ");
                numericString = in.next();
            }

            if (option == 1) {
                result = hexStringDecode(numericString);
                System.out.println("Result: " + result);
                System.out.println("");
            } else if (option == 2) {
                result = binaryStringDecode(numericString);
                System.out.println("Result: " + result);
                System.out.println("");
            } else if (option == 3) {
                String resultHex = binaryToHex(numericString);
                System.out.println("Result: " + resultHex);
                System.out.println("");
            } else if (option == 4) {
                System.out.println("Goodbye!");
                System.exit(101);
            }
        }
    }//main

    public static long hexStringDecode(String hex) {

        String hexUpper = hex.toUpperCase();
        int len = hex.length();

        byte[] hexArray = reverseStringArray(hexUpper);
        long result = 0;
        int numMultiply = 0;

        for (int i = 0; i < len; i++) {  //Comment for Lab 06 
            char hexChar = (char) hexArray[i];
            int hexValue = hexCharDecode(hexChar);

            long posValue = 1;
            long curValue = 0;
            numMultiply = i;

            if (i == 0) {
                curValue = hexValue;
            } else {
                posValue = 1;
                for (int j = 1; j <= numMultiply; j++) {
                    posValue = posValue * 16;
                }

                curValue = posValue * hexValue;
            }
            result = result + curValue;
        }

        return result;
    } //method for decoding hexadecimal to decimal notation

    public static short hexCharDecode(char ch) {
        // converts hexadecimal to decimal notation

        if (ch == '0') {
            return 0;

        } else if (ch == '1') {
            return 1;

        } else if (ch == '2') {
            return 2;

        } else if (ch == '3') {
            return 3;

        } else if (ch == '4') {
            return 4;

        } else if (ch == '5') {
            return 5;

        } else if (ch == '6') {
            return 6;

        } else if (ch == '7') {
            return 7;

        } else if (ch == '8') {
            return 8;

        } else if (ch == '9') {
            return 9;

        } else if (ch == 'A' || ch == 'a') {
            return 10;

        } else if (ch == 'B' || ch == 'b') {
            return 11;

        } else if (ch == 'C'|| ch == 'c') {
            return 12;

        } else if (ch == 'D'|| ch == 'd') {
            return 13;

        } else if (ch == 'E'|| ch == 'e') {
            return 14;

        } else if (ch == 'F'|| ch == 'f') {
            return 15;
        }

        return 0;
    }

    public static short binaryStringDecode(String binary) {

        int len = binary.length();

        byte[] binaryArray = binary.getBytes();
        short result = 0;
        short numMultiply = 0;

        for (int i = len - 1; i >= 0; i--) {
            char binaryChar = (char) binaryArray[i];
            short binaryVal = binaryCharDecode(binaryChar);

            short posValue = 0;
            short curValue = 0;
            if (i == len - 1) {
                posValue = 1;
                curValue = binaryVal;
            } else {
                posValue = 1;
                for (int j = 1; j <= numMultiply; j++) {
                    posValue = (short) (posValue * (short) 2);
                }

                curValue = (short) (posValue * binaryVal);

            }
            result = (short) (result + curValue);
            numMultiply++;

        }

        return result;
    }

    public static short binaryCharDecode(char ch) {

        if (ch == '0') {
            return 0;
        } else if (ch == '1') {
            return 1;
        }
        return 0;
    }

    public static String binaryToHex(String binary) {
        // convert binary to hex
        String result = "";
        int loopCount = binary.length() / 4;
        int begin = 0;
        int end = 4;

        boolean done = false;

        while (!done) {

            //group 4 characters at a time from binary to hex
            String substr = binary.substring(begin, end);
            String hexChar = binaryToHexString(substr);
            result = result + hexChar;

            begin = begin + 4;
            end = end + 4;
            loopCount--;
            if (loopCount <= 0) {
                done = true;
            }
        }
        return result;
    }


    public static String binaryToHexString(String binary) {
        // convert binary string to hex string

        if (binary.equals("0000")) {
            return "0";
        } else if (binary.equals("0001")) {
            return "1";
        } else if (binary.equals("0010")) {
            return "2";
        } else if (binary.equals("0011")) {
            return "3";
        } else if (binary.equals("0100")) {
            return "4";
        } else if (binary.equals("0101")) {
            return "5";
        } else if (binary.equals("0110")) {
            return "6";
        } else if (binary.equals("0111")) {
            return "7";
        } else if (binary.equals("1000")) {
            return "8";
        } else if (binary.equals("1001")) {
            return "9";
        } else if (binary.equals("1010")) {
            return "A";
        } else if (binary.equals("1011")) {
            return "B";
        } else if (binary.equals("1100")) {
            return "C";
        } else if (binary.equals("1101")) {
            return "D";
        } else if (binary.equals("1110")) {
            return "E";
        } else if (binary.equals("1111")) {
            return "F";
        }
        return "";
    }

    public static byte[] reverseStringArray (String binary) {
        int len = binary.length();

        byte[] origArray = binary.getBytes();
        byte[] newArray = new byte[len];

        int i = 0;
        int j = len - 1;
        while (i < len) {
            newArray[i] = origArray[j];
            i++;
            j--;
        }
        return newArray;
    }


}

