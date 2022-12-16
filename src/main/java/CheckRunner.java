public class CheckRunner {
    public static void main(String[] args) {
        BaseOfCard baseOfCard = new BaseOfCard();
        BaseOfProduct baseOfProduct = new BaseOfProduct();
        InitDataBase.Init(baseOfCard, baseOfProduct);
        Check check = new Check();
        CommandLineParser.parse(args, check, baseOfProduct, baseOfCard);
        check.calculate();
        check.printCheck();
        check.saveCheckToFile("Check.txt");
        DataBaseWorker.DataWrite("BaseOfCard","BaseOfProduct",baseOfCard,baseOfProduct);


    }


}