/**
 * Created by sebastian
 */
public class Hijo {
    public String lol = "";
    public boolean run = true;

    /**
     * This class changes lol value, it needs to be synchronized, otherwise
     * it can trow a multiple thread access exception
     *
     * @param lol value to set
     */
    public synchronized void setLol(String lol) {
        this.lol = lol;

    }

    public void run(int a, Padre superThread) {
        Thread thread = new Thread() {
            int b = a;
            @Override
            public void run() {
                while (run) {
                    if (lol.equals("")) {
                        setLol(" " + Math.random() * 88 + 1);
                        b++;
                        System.out.println("b: " + b);
                        /**
                         * here im synchronizing the father class this method gets,
                         * and notifying it to stop to wait exactly when
                         * i set lol with it new value.
                         */
                        synchronized (superThread) {
                            superThread.loop = false;
                            superThread.notifyAll();
                        }
                    } else try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (b > 5) break;
                }
            }
        };
        thread.start();
    }
}
