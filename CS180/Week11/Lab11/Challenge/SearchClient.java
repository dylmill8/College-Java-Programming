import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 * This program creates a client to access a search server. The user can connect to the sever using port #4242, they
 * can input a search term and the server will respond with the results that contained the search. The user can
 * search, connect, and disconnect as many times as they want.
 *
 * PORT #4242
 *
 * @author Dylan Miller
 * @version November 4, 2022
 */

public class SearchClient {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome!", "Client",
                JOptionPane.INFORMATION_MESSAGE);

        String hostName = JOptionPane.showInputDialog(null, "Enter a host name", "Client",
                JOptionPane.INFORMATION_MESSAGE);

        boolean repeat = true;
        int port = 0;
        do {
            try {
                port = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Enter a port number?", "Client", JOptionPane.QUESTION_MESSAGE));
                repeat = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!",
                        "Client", JOptionPane.ERROR_MESSAGE);
            }
        } while (repeat);

        try {
            Socket socket = new Socket(hostName, port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            JOptionPane.showMessageDialog(null, "Connection established!", "Client",
                    JOptionPane.INFORMATION_MESSAGE);
            while (true) {
                String search = JOptionPane.showInputDialog(null, "Enter your search", "Client",
                        JOptionPane.QUESTION_MESSAGE);

                if (search == null) {
                    break;
                }

                writer.write(search);
                writer.println();
                writer.flush();


                String line = reader.readLine();
                if (line.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No results!",
                            "Client", JOptionPane.ERROR_MESSAGE);
                    writer.println();
                    writer.flush();
                } else {
                    String[] titles = line.split(";");

                    String option = (String) JOptionPane.showInputDialog(null, "Select title",
                            "Client", JOptionPane.QUESTION_MESSAGE, null, titles, titles[0]);

                    if (option == null) {
                        System.out.println("TEST");
                        break;
                    }
                    for (String i : titles) {
                        if (i.equalsIgnoreCase(option)) {
                            writer.write(i);
                        }
                    }
                    writer.println();
                    writer.flush();

                    String description = reader.readLine();
                    JOptionPane.showMessageDialog(null, description, "Client",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                int option = JOptionPane.showConfirmDialog(null,
                        "Would you like to search again?", "Order Form", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.NO_OPTION) {
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Farewell!", "Client",
                    JOptionPane.INFORMATION_MESSAGE);
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Connection failed!",
                    "Client", JOptionPane.ERROR_MESSAGE);
        }
    }
}
