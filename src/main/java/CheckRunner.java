import model.check.Check;
import db.DAO;
import db.LocalFileDAO;
import parser.CommandLineParser;
import service.CheckRequest;
import service.CheckService;
import util.SaveToFile;

public class CheckRunner {

    public static void main(String[] args) {
        DAO daoObject = LocalFileDAO.getInstance();
        CheckRequest request = CommandLineParser.parse(args);
        CheckService service = CheckService.getInstance();
        Check check = service.generateCheck(request,daoObject);
        service.getDataBaseForPrint(request,daoObject).forEach(System.out::println);
        check.getCheckForPrint().forEach(System.out::println);
        SaveToFile.saveListToFile("Check.txt",check.getCheckForPrint());
    }


}