
//
// ------------------------------------------
/*
    @brief This Program:
    This Java Program that involves solving problems using decisions and pre-defined functions.
    1) Ask for a password and if the password is incorrect, issue an error message and terminate the program.
       The correct password is meme and the password is case-sensitive.
    2) If the password is correct, ask for a single character representing the temperature code
       (F,C, K for the 3 types of measurements).
    3) If the temperature code is invalid, issue an error message and terminate the program.
    4) If the temperature code is valid, ask for a number representing the temperature reading.
    5) Ask for the name of the room for which a measurement is taken.
    6) If the temperature reading is invalid (any number below -100 and more than 100), issue an error message
       and set the temperature reading to a random number between -100 and 100.
    7) If the temperature reading is valid, convert the given temperature to the other temperature scales.
    8) Display data as shown in the sample runs.
 */
//
// ------------------------------------------
//
//


import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("java:S106") // Disable the warning about System.out

public class CIT130hw3ch3ch4 {

    // Initiate Variables (Sort of Global Variables)
    static double tempFahrenheit;
    static double tempCelsius;
    static double tempKelvin;
    static double temperatureTemp;
    static String place;
    static String codeName;

    public static void main(String[] args) {

        // Initiate Variables
        String title = "\nTemperature Reading \n";
        final String PASSWORD = "meme";

        // Display Title for the Program
        System.out.println(title);

        // Create Read Input Object
        Scanner inputs = new Scanner(System.in);

        // Password Input
        System.out.println("Enter your password: ");
        String passwordUserInput = inputs.nextLine();

        // Compare Passwords
        if (!passwordUserInput.equals(PASSWORD)) {
            // Invalid Password, Issue an Error Message
            System.out.println("Wrong password - You shall not pass!!");
        }
        else {
            // Valid Password
            // Ask For A Single Character For Temperature Code
            System.out.println("Enter the Temperature Conversion Code (F, C, K): ");
            char tempConversionCode = inputs.next().toUpperCase().charAt(0);

            // Compare Temperature Code, Based On Which Category
            switch (tempConversionCode) {
                // Fahrenheit Case
                case 'F':
                    codeName = "Fahrenheit";
                    // Call proceedPromptings Method
                    proceedPromptings();
                    break;

                // Celsius Case
                case 'C':
                    codeName = "Celsius";
                    // Call proceedPromptings Method
                    proceedPromptings();
                    break;

                // Kelvin Case
                case 'K':
                    codeName = "Kelvin";
                    // Call proceedPromptings Method
                    proceedPromptings();
                    break;

                // The Rest of Cases, Which Not Matching F, C, K
                default:
                    System.out.println("INVALID Temperature Code!!! \n");
            }

            // Call calTemperature Method to Calculation and Display the Results
            calTemperature(tempConversionCode, temperatureTemp, place);
        }

    }

    // Methods / Functions
    public static void proceedPromptings() {
        // Create Read Input Object
        Scanner inputs = new Scanner(System.in);

        // Temperature Input
        System.out.println("Enter the temperature value in degrees " + codeName + ": ");
        temperatureTemp = inputs.nextDouble();

        // Place/Room Input
        inputs.nextLine(); // Avoid Skipping
        System.out.println("Enter the name of the room for which a measurement is taken: ");
        place = inputs.nextLine();
        place = place.substring(0, 1).toUpperCase() + place.substring(1);  // Capitalize the 1st letter

        // Determine the Input Between -100 and 100
        if (temperatureTemp < -100 || temperatureTemp > 100) {
            // Invalid Reading, Issue Error Message
            System.out.println("INVALID Value for Temperature - Setting to a random number ");

            // Call RandomNumber Method to Generate a Random Number
            temperatureTemp = randomNumber();

            // Display the Random Number
            System.out.printf("Randomly generated reading is: %f %n", temperatureTemp);
        }
    }

    // Calculate Temperature and Display the Results
    public static void calTemperature(char chr, double temp, String location) {
        switch (chr) {
            case 'F':
                tempFahrenheit = temp;
                tempCelsius = (tempFahrenheit - 32) * 5.0 / 9;
                tempKelvin = (tempFahrenheit + 459.67) * 5.0 / 9;
                System.out.printf("%nTemperature taken at: %s %n", location);
                System.out.printf("Temperature reading: %.4f Fahrenheit %n", tempFahrenheit);
                System.out.printf("Temperature in degrees Celsius: %.4f Celsius %n", tempCelsius);
                System.out.printf("Temperature in degrees Kelvin: %.4f Kelvin %n", tempKelvin);
                break;

            case 'C':
                tempCelsius = temp;
                tempFahrenheit = tempCelsius * 9.0 / 5 + 32;
                tempKelvin = (9.0 / 5 * tempCelsius + 491.67) * 5.0 / 9;
                System.out.printf("%nTemperature taken at: %s %n", location);
                System.out.printf("Temperature reading: %.4f Celsius %n", tempCelsius);
                System.out.printf("Temperature in degrees Fahrenheit: %.4f Fahrenheit %n", tempFahrenheit);
                System.out.printf("Temperature in degrees Kelvin: %.4f Kelvin %n", tempKelvin);
                break;

            case 'K':
                tempKelvin = temp;
                tempCelsius = (9.0 / 5 * tempKelvin - 491.67) * 5.0 / 9;
                tempFahrenheit = 9.0 / 5 * tempKelvin - 459.67;
                System.out.printf("%nTemperature taken at: %s %n", location);
                System.out.printf("Temperature reading: %.4f Kelvin %n", tempKelvin);
                System.out.printf("Temperature in degrees Celsius: %.4f Celsius %n", tempCelsius);
                System.out.printf("Temperature in degrees Fahrenheit: %.4f Fahrenheit %n", tempFahrenheit);
                break;

            default:
                break;
        }
    }

    // Generate a Random Number From -100 to 100
    public static double randomNumber() {
        final int minNum = -100;
        final int maxNum = 100;
        Random random = new Random();
        double randomNum = random.nextDouble((double)maxNum - minNum + 1) + minNum;
        return randomNum;
    }


}
