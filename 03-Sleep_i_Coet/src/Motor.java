public class Motor {
    private int num;
    private int potenciaActual;
    private int potenciaObjectiu;
    static int intervalo = (int) (Math.random() * 2) + 1;

    public Motor(int num) {
        this.num = num;
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
    }
    public int getNum() { return num; }

    public int getPotenciaActual() { return potenciaActual; }

    public int getPotenciaObjectiu() { return potenciaObjectiu; }

    public void setPotenciaObjectiu(int PotenciaObjectiu) { this.potenciaObjectiu = PotenciaObjectiu; }

    public void setPotenciaActual(int potenciaActual) {
        this.potenciaActual += potenciaActual;
        try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
