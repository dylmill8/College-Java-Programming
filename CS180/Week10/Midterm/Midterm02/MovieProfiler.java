import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieProfiler {
    public static final String INPUT_PROMPT = "What is the name of the file you would like to read from?";
    public static final String INPUT_ERROR = "The file doesn't exist!";
    public static final String OUTPUT_PROMPT = "What is the name of the output file?";
    public static final String THRESHOLD_PROMPT = "Enter the ratings threshold filter:";
    public static final String OUTPUT_SUCCESS = "The file was written to!";
    public static final String OUTPUT_ERROR = "There was an error writing to the file.";

    public static String[] readFile(String filename) {
        ArrayList<String> tempMovies = new ArrayList<>();

        try {
            File file = new File(filename);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                tempMovies.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        String[] movies = new String[tempMovies.size()];
        for (int i = 0; i < movies.length; i++) {
            movies[i] = tempMovies.get(i);
        }
        return movies;
    }

    public static boolean writeFile(String[] dataset, double threshold, String filename) {
        try {
            File file = new File(filename);
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            for (String i : dataset) {
                String[] line = i.split(", ");
                if (Double.parseDouble(line[3]) >= threshold) {
                    printWriter.println(i);
                }
            }
            printWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_PROMPT);
        String inputFile = scanner.nextLine();
        String[] movies = readFile(inputFile);
        if (movies != null) {
            System.out.println(THRESHOLD_PROMPT);
            double threshold = scanner.nextDouble();
            scanner.nextLine();
            System.out.println(OUTPUT_PROMPT);
            String outputFile = scanner.nextLine();
            if (writeFile(movies, threshold, outputFile)) {
                System.out.println(OUTPUT_SUCCESS);
            } else {
                System.out.println(OUTPUT_ERROR);
            }
        } else {
            System.out.println(INPUT_ERROR);
        }
    }
}