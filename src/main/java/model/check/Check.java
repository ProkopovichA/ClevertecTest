package model.check;

import model.DiscountCard;

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

    public Check(int checkNumber) {
        this.checkLines = new ArrayList<>();
        this.checkNumber = checkNumber;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public List<CheckLine> getCheckLines() {
        return checkLines;
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
            totalWithDiscount = total;
        }
        if (discountCard != null) {
            totalDiscount = total / 100 * discountCard.getCardDiscount();
            totalWithDiscount = total - totalDiscount;
        }
    }

    public List<String> getCheckForPrint() {
        List<String> printArr = new ArrayList<>();
        printArr.add("        CASH RECEIPT");
        printArr.add("      SUPERMARKET 123");
        printArr.add("  12, MILKYWAY, Galaxy/ Earth");
        printArr.add("     Tel :123-456-7890");
        printArr.add("CASHIER: №" + checkNumber + " DATE: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
        printArr.add("              " + " TIME: " + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        printArr.add("___________________________");
        printArr.add("QTY DESCRIPTION  PRICE  TOTAL");
        for (CheckLine checkLine : checkLines) {
            printArr.add(checkLine.toString());
        }
        if (discountCard != null) {
            printArr.add(discountCard.toString());
            printArr.add(String.format("Total discount:         $%.2f", totalDiscount));
        }
        printArr.add(String.format("TOTAL:                  $%.2f", totalWithDiscount));
        return printArr;
    }

    public double getTotal() {
        return total;
    }
}
