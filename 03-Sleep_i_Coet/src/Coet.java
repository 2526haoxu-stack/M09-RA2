import java.util.Scanner;

public class Coet {
    static Scanner sc = new Scanner(System.in);
    private final Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) { motors[i] = new Motor(i); }
    }

    static boolean incrementar;
    static boolean stop = true;
    static boolean firstTime = true;

    public void passaAPotencia(int p) {
        if (p >= 0 && p <= 10) {
            System.out.printf("Passant a potència %d%n", p);
            for (Motor m : motors) { m.setPotenciaObjectiu(p); }
        } else throw new IllegalArgumentException ("Potencia inválida, introduce un valor entre 0 i 10");
    }

    public void arranca() {
        for (Motor m : motors) {
            m.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        int p;
        do {
            p = sc.nextInt();
            try {
                coet.passaAPotencia(p);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                p = -1;
            }
        } while (p != 0);
    }
}
