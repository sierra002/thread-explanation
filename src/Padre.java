import java.util.List;

/**
 * Created by sebastian
 */
public class Padre {
    private List<Hijo> cosases;
    public boolean loop = true;

    public Padre(List<Hijo> cosases) {
        this.cosases = cosases;
    }

    public void start() {
        int cont = 0;
        for (Hijo cosase : cosases) {
            cosase.run(0, this);
        }

        while (cont < 50) {
            cont++;
            cosases.forEach(cosas -> {
                if (!cosas.lol.equals("")) {
                    System.out.println(cosas.lol);
                    cosas.setLol("");
                }
            });
            try {
                /**
                 context must be synchronized so it can execute .wait(), if you want to wait exactly until
                 .notify be called from another place you have to surround this with a loop and set a variable when needed,
                 in this case if you use

                 while(loop){this.wait()}

                 it will wait until son class calls .notify() and update de loop variable
                 */
                synchronized (this) {
                    this.wait(5000);
                }
                loop = true;
            } catch (IllegalMonitorStateException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("durmiendo");
        }
    }
}
