import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String calculatedIncome = "108";
        JOptionPane.showMessageDialog(null, "Calculated income: $" +
                calculatedIncome, "Bookstore", JOptionPane.INFORMATION_MESSAGE);

        /*
        ArrayList<String> test = new ArrayList<>();
        test.add("Test");

        Test.editList(test);

        for (String i : test) {
            System.out.println(i);
        }

        String cart = "test";
        JTextArea textArea = new JTextArea(cart);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(false);
        textArea.setEditable(false);
        scrollPane.setPreferredSize((new Dimension(500, 500)));


        String[] cartOptions = {"Edit Product", "Remove Product", "Go back"};
        int option = JOptionPane.showOptionDialog(null, scrollPane, "Bookstore",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, cartOptions,
                cartOptions[0]);

        String[] sortOptions = {"Quantity", "Price"};
        int sort = JOptionPane.showOptionDialog(null,
                "How would you like to sort the market?", "Bookstore",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, sortOptions,
                sortOptions[0]);

        JOptionPane.showInputDialog(null, "Enter your search:", "Bookstore", JOptionPane.QUESTION_MESSAGE);

        boolean valid = false;
        while (!valid) {
            valid = true;
            String review = JOptionPane.showInputDialog(null, "Enter review:");
            if (review.contains(",")) {
                JOptionPane.showMessageDialog(null,
                        "A book review cannot include any commas!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                valid = false;
            }
        }

        JTextField description = new JTextField();
        JTextField quantity = new JTextField();
        JTextField price = new JTextField();
        JTextField sale = new JTextField();
        Object[] message = {
                "Description:", description,
                "Quantity:", quantity,
                "Price:", price,
                "Sale:", sale
        };

        valid = false;
        while (!valid) {
            valid = true;
            int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if (description.getText().contains(",")) {
                    JOptionPane.showMessageDialog(null,
                            "A book description cannot include any commas!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }

                try {
                    int quantityInt = Integer.parseInt(quantity.getText());
                    if (quantityInt <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid integer!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        valid = false;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid integer!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }

                try {
                    double priceFloat = Float.parseFloat(price.getText());
                    if (priceFloat <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid price!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        valid = false;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid price!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }

                try {
                    double saleFloat = Float.parseFloat(sale.getText());
                    if (saleFloat >= 0 && saleFloat <= 1) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid sale percentage (between 0 and 1)!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        valid = false;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid sale percentage (between 0 and 1)!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
            }
        }
            //var.getTest

        String marketText = "I'm out of ideas";
        JTextArea textArea = new JTextArea(marketText);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(false);
        textArea.setEditable(false);
        scrollPane.setPreferredSize(( new Dimension(500, 500)));

        String[] options = {"1. View a book", "2. Search the bookstore", "3. Sort the bookstore",
                "4. View cart", "5. View store sales statistics", "6. View purchase history" ,
                "7. Export purchase history"};
        Object option = JOptionPane.showInputDialog(null, scrollPane, "Bookstore",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String itemToView = JOptionPane.showInputDialog(null, scrollPane,
                "Which item would you like to view?", JOptionPane.QUESTION_MESSAGE);

        String[] itemMenuOptions = {"Add review", "Buy item", "Add item to cart",};
        int menuOption = JOptionPane.showOptionDialog(null, scrollPane,
                "Bookstore", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, itemMenuOptions, itemMenuOptions[0]);
         */
    }
}
