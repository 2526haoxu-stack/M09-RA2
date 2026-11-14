public class PrincipalIguals {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", 0, null);
        Fil pepe = new Fil("Pepe", 0, null);

        juan.setPriority(Thread.MAX_PRIORITY);
        pepe.setPriority(Thread.MAX_PRIORITY);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");
    }
}