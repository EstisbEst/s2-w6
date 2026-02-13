import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;//mandatory

/**
 * CityPopulationAnalyzer
 * 
 * This program reads city names and population data from a file and stores them
 * in sorted arrays. The data is sorted as it's read in, preparing it for 
 * efficient searching using binary search.
 * 
 * YOUR TASK:
 * Complete the methods marked with todo comments
 */
public class CityPopulationAnalyzer {
    
    private String[] cityNames;      // Array to store city names
    @SuppressWarnings("unused")
    private double[] populations;    // Array to store populations
    private int count;               // Track how many cities we've read
    @SuppressWarnings("unused")
    private static final int INITIAL_CAPACITY = 150; // Start with capacity for ~150 cities
    
    /**
     * Constructor - initializes the arrays
     */
    public CityPopulationAnalyzer() {
        //Initialize cityNames array with INITIAL_CAPACITY
        cityNames = new String [INITIAL_CAPACITY];
        //Initialize populations array with INITIAL_CAPACITY
        populations = new double [INITIAL_CAPACITY];
        //Set count to 0
        count = 0;
    }
    
    /**
     * Reads city data from a file and inserts it into sorted arrays
     * 
     * File format:
     * City Name
     * Population (as number)
     * City Name
     * Population (as number)
     * ... (alternating pattern)
     * 
     * @param filename the path to the data file
     * @throws IOException, InputMismatchException if the file cannot be found or read
     */
    public void readAndSortData(String filename) throws IOException, InputMismatchException {
        
        //Create a File object with the filename
        File f = new File(filename);
        //Create a Scanner to read from the file
        Scanner s = new Scanner(f);
        // Read pairs of city name and population
        // HINT: Use a while loop with scanner.hasNextLine()
        while (s.hasNextLine()) {
            String city = s.nextLine();
            double pop = -1;
            if (s.hasNextLine()) {
                pop = s.nextDouble();
            }
            System.out.println(city + ":" + pop);
        }
        
        // HINT: Read city name first, then check if there's a population line
        // HINT: Parse the population as a double (use Double.parseDouble())
        // HINT: Call insertSorted() for each city/population pair
        // HINT: If array is full, call resizeArrays()
        // TODO: Close the scanner
        
        
        System.out.println("Successfully read " + count + " cities from " + filename);
    }
    
    /**
     * Inserts a city and its population into the arrays in sorted order
     * (sorted by population, highest to lowest)
     * 
     * @param cityName the name of the city
     * @param population the population of the city
     */
    @SuppressWarnings("unused")
    private void insertSorted(String cityName, double population) {
        // TODO: Find the correct position for insertion
        // HINT: Start at 0 and go to count - why count?
        // HINT: Loop through existing elements to find where this population should go
        // HINT: We want highest populations first, so insert before any smaller population
        int x = 0;
        for (int index = 0; index < getCount(); index++) {
            if (populations[index] < population) {
                x = index;
            }
        }
        // TODO: Shift elements to the right to make room
        // HINT: Start from 0 and move to correct position
        // HINT: Move both cityNames and populations arrays
        for (int index = getCount(); index > x; index--) {
            cityNames[index] = cityNames[index-1];
        }
        cityNames[x] = cityName;
        populations [x] = population;
        // TODO: Insert the new city and population at the correct position
        
    }
    
    /**
     * Doubles the size of the arrays when they get full
     */
    @SuppressWarnings("unused")
    private void resizeArrays() {
        // TODO: Create new arrays twice the current size
        
        // TODO: Copy all existing data to the new arrays
        // HINT: Use a loop from 0 to count
        
        // TODO: Update the instance variables to point to the new arrays
        
        System.out.println("Arrays resized to capacity: " + cityNames.length);
    }
    
    /**
     * Displays the top N cities by population
     */
    public void displayTopCities(int n) {
        System.out.println("\n=== Top " + n + " Cities by Population ===");
        // TODO go for it
    }
    
        
    /**
     * Returns the number of cities loaded
     */
    public int getCount() {
        return cityNames.length;
    }

    /**
     * Returns the largest population (arrays are sorted high to low)
     */
    public double getLargestPopulation() {
        int x = 0;
        for (int index = 0; index < populations.length; index++) {
            if (populations[index] > populations[x]) {
                x = index;
            }
        }
        return populations[x];
    }

    /**
     * Returns the city name with the largest population
     */
    public String getCityWithLargestPopulation() {
        int x = 0;
        for (int index = 0; index < populations.length; index++) {
            if (populations[index] > populations[x]) {
                x = index;
            }
        }
        return cityNames[x];
    }

    /**
     * Returns the smallest population (arrays are sorted high to low)
     */
    public double getSmallestPopulation() {
        int x = 0;
        for (int index = 0; index < populations.length; index++) {
            if (populations[index] < populations[x]) {
                x = index;
            }
        }
        return populations[x];
    }

    /**
     * Returns the city name with the smallest population
     */
    public String getCityWithSmallestPopulation() {
        int x = 0;
        for (int index = 0; index < populations.length; index++) {
            if (populations[index] < populations[x]) {
                x = index;
            }
        }
        return cityNames[x];
    }

    /**
     * Returns the population for a given city name
     * @param cityName the city to find
     * @return the population if found, or -1 if not found
     */
    public double findPopulationOfCity(String cityName) {
        for (int index = 0; index < getCount(); index++) {
            if (condition) {
                
            }
        }
        return -1;
    }

    /**
     * Returns true if the city name exists in the array
     * Must use binary search
     * @param cityName the city to search for
     * @return true if found, false otherwise
     */
    public boolean containsCityName(String cityName) {
        //TODO
        return false;
    }

    /**
     * Returns the average population of all cities
     * @return average population, or 0 if no cities
     */
    public double averagePopulationSize() {
        int i = 0;
        double x = 0.0;
        for (double d : populations) {
            i ++;
            x = x+d;
        }
        return x/i;
    }
    
    
}
