public class Fil extends Thread{
    String name;
    int delay;
    String end;

    public Fil(String name, int delay, String end) {
        this.name = name;
        this.delay = delay;
        this.end = (end == null) ? "Acaba" : end;
    }

    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%s %d\n", name, i);

            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                long n = 0;
                for (int j = 0; j < 1000; j++) { n++; }
            }
        }
        System.out.printf("%s el fil %s\n", end, name);
    }
}