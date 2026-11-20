public class Motor extends Thread {
    private int id;
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;

    public Motor(int id) {
        super("Motor " + id);
        this.id = id;
    }

    public void setPotenciaObjectiu(int PotenciaObjectiu) { this.potenciaObjectiu = PotenciaObjectiu; }

    @Override 
    public void run() {
        while(true) {
            if (potenciaActual == potenciaObjectiu) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    return;
                } continue;
            }

            int intervalo = (int) (Math.random() * 2) + 1;
            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                return;
            }

            int objectiu = potenciaObjectiu;
            String accio;
            if (potenciaActual < objectiu) {
                potenciaActual++;
                accio = "Incre.";
            } else if (potenciaActual > objectiu) {
                potenciaActual--;
                accio = "Decre.";
            } else continue;

            System.out.printf("Motor %d: %s Objectiu: %d Actual: %d%n", id, accio, objectiu, potenciaActual);

            if (potenciaActual == objectiu) {
                System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d%n", id, objectiu, potenciaActual);

                if (objectiu == 0) return;
            }
        }
    }
}
