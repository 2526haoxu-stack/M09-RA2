public class Futbolista extends Thread {
    final static int NUM_JUGADORS = 11;
    final static int NUM_TIRADES = 20;
    final static float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        ngols = 0;
        ntirades = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            if (Math.random() < PROBABILITAT) ngols++;
            ntirades++;
        }
    }

    public static void main(String[] args) {
        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};
        
        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

        for (int i = 0; i < NUM_JUGADORS; i++) { jugadors[i] = new Futbolista(noms[i]); }
        
        System.out.println("Inici dels xuts --------------------");
        for (int i = 0; i < NUM_JUGADORS; i++) { jugadors[i].start(); }

        for (Futbolista f : jugadors) {
            try {
                f.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } System.out.println("Fi dels xuts -----------------------");

        System.out.println("--- Estadístiques ------");
        for (Futbolista f : jugadors) {
            System.out.printf("%-10s -> %d gols%n", f.getName(), f.ngols);
        }

    }
} 
