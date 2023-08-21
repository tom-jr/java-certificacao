public class Teste {
    public String msg = "Hello World!";

    public void m1() {
        System.out.println(msg);
        String var1 = "T1";
        if (1 == 1) {
            System.out.println(var1);
        }
    }

    public Teste() {
        System.out.println(msg);
    }

    public static String msg2 = "Hello World!";

    public void m1(String msg) {
        System.out.println(Teste.msg2 += msg);

    }
    public static void main(String[] args) {

        Teste teste =  new Teste();
        System.out.println("----");
        teste.m1();
        teste.m1(" in Java language!");
    }
}
