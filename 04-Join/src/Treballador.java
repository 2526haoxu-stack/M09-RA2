import java.util.Random;

public class Treballador extends Thread {
    private final float sou_anual_brut;
    private final int edat_inici_treball;
    private final int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(String nom, float sou_anual_brut, int edat_inici_treball, int edat_fi_treball) {
        super(nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        edat_actual = 0;
        cobrat = 0.0f;
        this.rnd = new Random();
    }

    public void cobra() { cobrat+=sou_anual_brut/12.0f; }

    public void pagaImpostos() { cobrat-=(sou_anual_brut/12.0f)*0.24f; }

    @Override
    public void run() {
        int interval = rnd.nextInt(100);

        for (edat_actual = edat_inici_treball; edat_actual < edat_fi_treball; edat_actual++) {
            for (int i = 0; i < 12; i++) {
                cobra();
                pagaImpostos();
            }

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public int getEdat() { return edat_actual; }

    public float getCobrat() { return cobrat; }
}
