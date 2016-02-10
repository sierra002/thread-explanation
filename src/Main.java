import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Hijo hijo = new Hijo();
        Hijo hijo1 = new Hijo();
        Hijo hijo2 = new Hijo();
        Hijo hijo3 = new Hijo();
        List<Hijo> hijos = new ArrayList<>();
        hijos.add(hijo);
        hijos.add(hijo1);
        hijos.add(hijo2);
        hijos.add(hijo3);
        Padre Padre = new Padre(hijos);
        Padre.start();
    }

}
