// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 1
// Filename: TempConvert.java (inside tempconvert package)

package mte3.tempconvert;
/**
 * A functional interface that defines a method for converting between 
 * temperature scales, e.g. from Celsius to Fahrenheit.
 */

public interface TempConvert {
    /**
     * Converts temperature from one scale to another.
     * 
     * @param temp The temperature in the original scale.
     * 
     * @return The converted temperature.
     */
    public double convert(double temp);

    public static void main(String[] args) {
        // Example: lambda that converts Celsius to Fahrenheit
        TempConvert cToF = temp -> temp * 9.0 / 5.0 + 32;
        double celsius = 25.0;
        System.out.println("Celsius: " + celsius + " -> Fahrenheit: " + cToF.convert(celsius));
    }
}