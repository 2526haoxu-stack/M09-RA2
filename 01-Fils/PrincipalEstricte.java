public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 1, "Termina");
        Fil pepe = new Fil("Pepe", 1, "Termina");

        juan.setPriority(Thread.MAX_PRIORITY);
        pepe.setPriority(Thread.MAX_PRIORITY);

        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}