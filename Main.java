import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to Currency Converter!\n");
        // Loop condition
        boolean is_on = true;
        // InfoAPI object
        InfoAPI api = new InfoAPI();
        // Main loop
        while (is_on){
            // Get the user's option
            int user_option = userOption();
            // Get the amount to convert
            double user_amount = userAmount();
            // Conversion
            double result;
            switch (user_option){
                case 1:
                    result = api.makeConversion("USD", "MXN", user_amount);
                    System.out.println("\nHere's your conversion:\n" + user_amount + " USD =>> " + result + " MXN\n");
                    break;
                case 2:
                    result = api.makeConversion("MXN", "USD", user_amount);
                    System.out.println("\nHere's your conversion:\n" + user_amount + " MXN =>> " + result + " USD\n");
                    break;
                case 3:
                    result = api.makeConversion("USD", "CAD", user_amount);
                    System.out.println("\nHere's your conversion:\n" + user_amount + " USD =>> " + result + " CAD\n");
                    break;
                case 4:
                    result = api.makeConversion("CAD", "USD", user_amount);
                    System.out.println("\nHere's your conversion:\n" + user_amount + " CAD =>> " + result + " USD\n");
                    break;
                case 5:
                    result = api.makeConversion("USD", "JPY", user_amount);
                    System.out.println("\nHere's your conversion:\n" + user_amount + " USD =>> " + result + " JPY\n");
                    break;
                case 6:
                    result = api.makeConversion("JPY", "USD", user_amount);
                    System.out.println("\nHere's your conversion:\n" + user_amount + " JPY =>> " + result + " USD\n");
                    break;
                case 7:
                    is_on = false;
                    break;
                // If user introduces an invalid option
                default:
                    System.out.println("Please, introduce a valid option!\n");
                    break;
            }
        }
    }

    // Function to give the user the options and return one of them
    public static int userOption(){
        Scanner entry = new Scanner(System.in);
        String options = """
                1) Dollar =>> Mexican Peso (MXN)
                2) Mexican Peso =>> Dollar (USD)
                3) Dollar =>> Canadian Dollar (CAD)
                4) Canadian Dollar =>> Dollar (USD)
                5) Dollar =>> Yen (JPY)
                6) Yen =>> Dollar (USD)
                7) Exit
                """;
        System.out.println(options);
        // Return the input option as an integer
        return entry.nextInt();
    }

    // Function for the user to introduce the amount to convert
    public static double userAmount(){
        Scanner entry = new Scanner(System.in);
        System.out.println("Introduce the amount to convert: ");
        // Return the input amount as a double
        return entry.nextDouble();
    }

}