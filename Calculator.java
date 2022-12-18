import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter an arithmetic expression: ");
        String line = s.nextLine();



        char[] symbol = new char[10];
        char oper = ' ';

        for (int i=1; i < line.length(); i++) {
            symbol[i] = line.charAt(i);
            if ( symbol[i] == '+'){
                oper = '+';
            }
            if ( symbol[i] == '-'){
                oper = '-';
            }
            if ( symbol[i] == '*'){
                oper = '*';
            }
            if ( symbol[i] == '/'){
                oper = '/';
            }
        }

        int num1 = 0;
        int num2 = 0;
        int result;

        String[] numbers = line.split(" ");
        if (numbers.length > 3) {
            System.out.println("Cannot have more than 2 variables and action sign");
            System.exit(0);
        }
        try{
            num1 = romanNumbers(numbers[0]);
            num2 = romanNumbers(numbers[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You need to enter two values and an arithmetic sign");
            System.exit(0);
        }
        if (num1 == 0 | num2 == 0) {
            try {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[2]);
                if (num1 > 10 | num2 > 10 | num1 < 0 | num2 <0) {
                    System.out.println("You can only work with integers from 0 to 10");
                    System.exit(0);
                }
                System.out.println(calculate(num1, num2, oper));
            } catch (NumberFormatException e) {
                System.out.println("The calculator can only work with Arabic or Roman numerals at the same time.");
            } catch (ArithmeticException e) {
                System.out.println("Can't divide by zero!");
            }
        } else {
            try {
                result = calculate(num1, num2, oper);
                if (result == 0) {
                    System.out.println("The result of the calculator with Roman numerals can only be positive numbers.");
                    System.exit(0);
                }
                String resultRom = romanSolution(result);
                System.out.println(resultRom);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The result of the calculator with Roman numerals can only be positive numbers.");
            }
        }
    }

    public static int calculate(int x1, int x2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }


    public static String romanSolution(int arabNumbers) {
        String[] romanAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return romanAll[arabNumbers];

    }

    public static int romanNumbers(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }
}
