

public class Administracion {
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa;

    public Administracion() {
        poblacio_activa = new Treballador[num_poblacio_activa];

        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-"+i, 25000, 20, 65);
        }
    }

    public void inicia() {
        for (Treballador t : poblacio_activa) {
            t.start();
        }

        for (Treballador t : poblacio_activa) {
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Treballador t : poblacio_activa) {
            System.out.printf("%-11s -> edat: %d / total: %.2f%n", t.getName(), t.getEdat(), t.getCobrat());
        }
    }

    public static void main(String args[]) {
        Administracion adm = new Administracion();
        adm.inicia();
    }
}
