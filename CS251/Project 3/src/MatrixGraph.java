import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;

public class MatrixGraph {
    int[][] graph;

    MatrixGraph (int[][] array) {
        graph = array;
    }

    public static MatrixGraph read(String filepath) throws IOException {
        InputStream istr = new FileInputStream(filepath);
        BufferedReader br = new BufferedReader(new InputStreamReader(istr));

        String line = br.readLine();
        int numNodes = Integer.parseInt(line);

        int[][] array = new int[numNodes][];
        for (int i = 0; i < numNodes; i++) {
            int[] nodes = new int[numNodes];
            line = br.readLine();
            if (!line.isEmpty()) {
                for (String value : line.split(" ")) {
                    nodes[Integer.parseInt(value)] = 1;
                }
            }
            array[i] = nodes;
        }

        MatrixGraph graph = new MatrixGraph(array);

        br.close();
        istr.close();
        return graph;
    }
}
