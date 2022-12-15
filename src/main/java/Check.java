import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Check {
    private List<CheckLine> checkLines;
    private DiscountCard discountCard;
    private int checkNumber;
    private double total;
    private double totalDiscount;
    private double totalWithDiscount;

    public Check() {
        this.checkLines = new ArrayList<>();
        this.checkNumber = 1520;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public void addProductToCheck(CheckLine checkLine) {
        checkLines.add(checkLine);
    }

    public void calculate() {
        int discountedQuantity = 0;
        for (CheckLine checkLine : checkLines) {
            if (checkLine.getProduct().isDiscount()) {
                discountedQuantity = discountedQuantity + checkLine.getProductQuantity();
            }
            if (discountedQuantity > 5) {
                discountedQuantity = 0;
                checkLine.setAmountOfDiscount(10);
            }
            checkLine.calculate();
            total = total + checkLine.getTotal();
        }
        if (discountCard != null) {
            totalDiscount = total / 100 * discountCard.getCardDiscount();
        }
    }


    public void printCheck() {
        System.out.println();
        System.out.println("        CASH RECEIPT");
        System.out.println("      SUPERMARKET 123");
        System.out.println("  12, MILKYWAY, Galaxy/ Earth");
        System.out.println("     Tel :123-456-7890");
        System.out.println("CASHIER: №" + checkNumber + " DATE: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
        System.out.println("              " + " TIME: " + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        System.out.println("___________________________");
        System.out.println("QTY DESCRIPTION  PRICE  TOTAL");
        for (CheckLine checkLine : checkLines) {
            checkLine.print();
        }
        if (discountCard != null) {
            System.out.println(discountCard);
            System.out.printf("Total discount:         $%.2f \n", totalDiscount);
        }
        System.out.printf("TOTAL:                  $%.2f \n", total);

    }

    public void saveCheckToFile(String fileName) {
        //final String fileName = "SampleText.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("        CASH RECEIPT");
            bw.newLine();
            bw.write("      SUPERMARKET 123");
            bw.newLine();
            bw.write("  12, MILKYWAY, Galaxy/ Earth");
            bw.newLine();
            bw.write("     Tel :123-456-7890");
            bw.newLine();
            bw.write("CASHIER: №" + checkNumber + " DATE: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            bw.newLine();
            bw.write("              " + " TIME: " + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            bw.newLine();
            bw.write("_____________________________");
            bw.newLine();
            bw.write("QTY DESCRIPTION  PRICE  TOTAL");
            bw.newLine();
            for (CheckLine checkLine : checkLines) {
                bw.write(checkLine.toString());
            }
            if (discountCard != null) {
                bw.write(discountCard.toString());
                bw.newLine();
                bw.write(String.format("Total discount:         $%.2f \n", totalDiscount));
            }
            bw.write(String.format("TOTAL:                  $%.2f \n", total));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
