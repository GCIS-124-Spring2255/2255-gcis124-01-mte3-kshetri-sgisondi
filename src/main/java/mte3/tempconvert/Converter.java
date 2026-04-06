// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 1
// Filename: Converter.java (inside tempconvert package)

package mte3.tempconvert;
import java.util.Scanner;
import java.io.PrintStream;

public class Converter {
    
    private static final PrintStream OUT = System.out;
    
    private static class CelsiusToFahrenheit implements TempConvert {

        @Override
        public double convert(double temp) {    return temp * 9.0 / 5.0 + 32;    }
        
    } // CelciusToFahrenheit closed

    public static void main(String[] args) {
        
        try(Scanner scanner = new Scanner(System.in)) {
            OUT.print("Please enter a temperature in Celsius: ");
            double tempC = scanner.nextDouble();

            // (part 1) conversion from C to F
            TempConvert c2f = new CelsiusToFahrenheit();
            double f = c2f.convert(tempC);
            OUT.printf("%.2f C = %.2f F%n", tempC, f);

            // (part 2) conversion from F to C
            OUT.print("Please enter a temperature in Fahrenheit (for conversion to Celsius): ");
            double tempF = scanner.nextDouble();
            double c = (tempF - 32) * 5.0 / 9.0;
            OUT.printf("%.2f F = %.2f C%n", tempF, c);

            // (part 3) conversion from F to K
            OUT.print("Please enter a temperature in Fahrenheit (for conversion to Kelvin): ");
            double tempF2 = scanner.nextDouble();
            double k = (tempF2 - 32) * 5.0 / 9.0 + 273.15;
            OUT.printf("%.2f F = %.2f K%n", tempF2, k);

        }

    } // main () method closed

} // Converter { } class closed