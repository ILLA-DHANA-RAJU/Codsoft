import java.util.Scanner;
public class CurrencyConverter
{
    public static void main(String [] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Currency Converter");
        System.out.println("Select base currency:");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.println("Select target currency:");
        String targetCurrency = scanner.nextLine().toUpperCase();
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();
        double convertedAmount = amount * exchangeRate;
        System.out.printf("%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        scanner.close();
    }
    private static double getExchangeRate(String baseCurrency, String targetCurrency) 
    {
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) 
        {
            return 0.85; // 1 USD = 0.85 EUR
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) 
        {
            return 1.18; // 1 EUR = 1.18 USD
        } else if (baseCurrency.equals("IND") && targetCurrency.equals("USD")) 
        {
            return 0.012; // 1 IND = 0.012 USD
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("IND")) 
        {
            return 83.59; // 1 USD = 83.59 IND
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("IND")) 
        {
            return 89.07; // 1 EUR = 89.07 IND
        } else if (baseCurrency.equals("IND") && targetCurrency.equals("EUR")) 
        {
            return 0.011; // 1 IND = 0.011 EUR
        } else if (baseCurrency.equals("CNY") && targetCurrency.equals("IND")) 
        {
            return 11.78; // 1 CNY = 11.78 IND
        } else if (baseCurrency.equals("IND") && targetCurrency.equals("CNY")) 
        {
            return 0.085; // 1 IND = 0.085 CNY
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("CNY")) 
        {
            return 7.24; // 1 USD = 7.24 CNY
        } else if (baseCurrency.equals("CNY") && targetCurrency.equals("USD")) 
        {
            return 0.14; // 1 CNY = 0.14 USD
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("CNY")) 
        {
            return 7.71; // 1 EUR = 7.71 CNY
        } else if (baseCurrency.equals("CNY") && targetCurrency.equals("EUR")) 
        {
            return 0.13; // 1 CNY = 0.13 EUR
        } else 
        {
            System.out.println("Exchange rate not available for the selected currencies.\t");
            System.exit(1);
            return 0.0;
        }
    }
}