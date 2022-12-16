import check.Check;
import db.InitDataBase;
import parser.CommandLineParser;
import util.SaveToFile;

public class CheckRunner {
    public static void main(String[] args) {
        InitDataBase.init();
        Check check = new Check();
        CommandLineParser.parse(args, check);
        check.calculate();
        check.printCheck().forEach(System.out::println);
        SaveToFile.saveCheckToFile("Check.txt",check.printCheck());

    }


}