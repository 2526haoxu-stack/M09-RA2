import java.util.Scanner;

public class Coet {
    static Scanner sc = new Scanner(System.in);
    static Motor motor1 = new Motor(0);
    static Motor motor2 = new Motor(1);
    static Motor motor3 = new Motor(2);
    static Motor motor4 = new Motor(3);
    static boolean incrementar;
    static boolean stop = true;
    static boolean firstTime = true;

    public void passaAPotencia(int p) {
        try {
            if (p >= 0 && p <= 10) {
                incrementar = (motor1.getPotenciaActual() < p);
                motor1.setPotenciaObjectiu(p);
                motor2.setPotenciaObjectiu(p);
                motor3.setPotenciaObjectiu(p);
                motor4.setPotenciaObjectiu(p);
            }
        } catch (Exception e) {
            System.out.println("Potencia inválida, introduce un valor entre 0 i 10");
            passaAPotencia(sc.nextInt());
        }
    }

    public void arranca() {
        while (stop || firstTime) {
            if (motor1.getPotenciaActual() + motor2.getPotenciaActual() + motor3.getPotenciaActual() + motor4.getPotenciaActual() == 0) {
                if (stop) stop = false;
                else firstTime = false; 
            }
            if (motor1.getPotenciaActual() < motor1.getPotenciaObjectiu()) {
                if (incrementar) motor1.setPotenciaActual(1);
                else motor1.setPotenciaActual(-1);
            } if (motor2.getPotenciaActual() < motor2.getPotenciaObjectiu()) {
                if (incrementar) motor2.setPotenciaActual(1);
                else motor2.setPotenciaActual(-1);
            } if (motor3.getPotenciaActual() < motor3.getPotenciaObjectiu()) {
                if (incrementar) motor3.setPotenciaActual(1);
                else motor3.setPotenciaActual(-1);
            } if (motor4.getPotenciaActual() < motor4.getPotenciaObjectiu()) {
                if (incrementar) motor4.setPotenciaActual(1);
                else motor4.setPotenciaActual(-1);
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
