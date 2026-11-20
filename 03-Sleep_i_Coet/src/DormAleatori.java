public class DormAleatori extends Thread {
    private final long tiempoCreacion;

    public DormAleatori(String nom) {
        super(nom);
        tiempoCreacion = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int valorRandom = (int) (Math.random() * 1000);
            long total = System.currentTimeMillis() - tiempoCreacion;

            System.out.printf("%-4s (%d) a dormir %4dms total %5dms%n", getName(), i, valorRandom, total);
            
            try {
                Thread.sleep(valorRandom);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori pep = new DormAleatori("Pep");
        DormAleatori joan = new DormAleatori("Joan");

        pep.start();
        joan.start();
    }
    
}
