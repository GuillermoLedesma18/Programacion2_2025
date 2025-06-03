import java.util.Date;

public class Nota {
    private int id;
    private double valor;
    private Date fechaExamen;
    private boolean esRecuperatorio;
    private Catedra catedra;

    public boolean isEsRecuperatorio() {
        return esRecuperatorio;
    }

    public double getValor() {
        return valor;
    }

    public Catedra getCatedra() {
        return catedra;
    }
}
