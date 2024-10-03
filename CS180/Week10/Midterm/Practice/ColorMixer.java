import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ColorMixer {
    public static Color[] readFile(String filename) {
        ArrayList<Color> tempColors = new ArrayList<>();
        Color[] colors;
        int red = -1;
        int green = -1;
        int blue = -1;
        int counter = 0;

        try {
            File file = new File(filename);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                counter++;
                if (counter % 3 == 0) {
                    blue = Integer.parseInt(line);
                    Color color = new Color(red, green, blue);
                    tempColors.add(color);
                    counter = 0;
                } if (counter % 2 == 0) {
                    green = Integer.parseInt(line);
                } else {
                    red = Integer.parseInt(line);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            if (counter != 0) {
                return null;
            }
            colors = new Color[tempColors.size()];
            for (int i = 0; i < tempColors.size(); i++) {
                colors[i] = tempColors.get(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return colors;
    }

    public static boolean writeFile(Color[] colors, String filename) {
        try {
            File file = new File(filename);
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));

            for (Color i : colors) {
                printWriter.println(i.toString());
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
        System.out.println("Enter the filename of the color map.");
        String inputFile = scanner.nextLine();
        System.out.println("Enter the filename to output the colors to.");
        String outputFile = scanner.nextLine();
        Color[] colors = readFile(inputFile);
        if (colors == null) {
            System.out.println("Either the file doesn't exist or the file is in the wrong format!");
        } else {
            if (writeFile(colors, outputFile)) {
                System.out.println("The file was written to!");
            } else {
                System.out.println("There was an error writing to the file.");
            }
        }
    }
}
