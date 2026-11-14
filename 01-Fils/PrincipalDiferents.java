public class PrincipalDiferents {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 0, null);
        Fil pepe = new Fil("Pepe", 0, null);

        juan.setPriority(Thread.MAX_PRIORITY);
        pepe.setPriority(Thread.MIN_PRIORITY);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}