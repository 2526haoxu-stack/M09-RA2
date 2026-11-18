public class MainDemoFil {
    public static void main(String[] args) {
        Thread fil = Thread.currentThread();
        System.out.printf("MainDemoFil.java:%n");
        System.out.printf("Prioritat -> %d, Nom -> %s%n", fil.getPriority(), fil.getName());
        System.out.printf("toString() -> %s%n", fil.toString());
    }
}
