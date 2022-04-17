public class App {
    public static void main(String[] args) throws Exception {
        SchoolGradingSystem grupo = new SchoolGradingSystem();
        grupo.readData();
        System.out.printf("%.2f\n",grupo.question1());
        System.out.println(grupo.question2());
        System.out.println(grupo.question3());
        System.out.println(grupo.question4());
    }
}
