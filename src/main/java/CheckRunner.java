import check.Check;
import db.DataBaseWorker;
import db.InitDataBase;
import model.BaseOfCard;
import model.BaseOfProduct;
import parser.CommandLineParser;
import util.SaveToFile;

public class CheckRunner {
    public static void main(String[] args) {
        BaseOfCard baseOfCard = new BaseOfCard();
        BaseOfProduct baseOfProduct = new BaseOfProduct();
        InitDataBase.Init(baseOfCard, baseOfProduct);
        Check check = new Check();
        CommandLineParser.parse(args, check, baseOfProduct, baseOfCard);
        check.calculate();
        check.printCheck().forEach(System.out::println);
        SaveToFile.saveCheckToFile("Check.txt",check.printCheck());
        DataBaseWorker.DataWrite("BaseOfCard","BaseOfProduct",baseOfCard,baseOfProduct);
    }


}