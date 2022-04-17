public class App {
    public static void main(String[] args) throws Exception {
        SchoolGradingSystem curso = new SchoolGradingSystem();
        curso.loadData();
        System.out.printf("%.2f\n",curso.stat1());
        System.out.println(curso.stat2());
        System.out.println(curso.stat3());
        System.out.println(curso.stat4());
    }
}
