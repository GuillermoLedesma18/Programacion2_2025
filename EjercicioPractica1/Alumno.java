import java.util.Date;
import java.util.List;

public class Alumno {
    private long legajo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private List<Nota> notas;

    public Nota mejorNota(Integer codigoCatedra) {
        return notas.stream()
                .filter(n -> !n.isEsRecuperatorio())
                .filter(n -> codigoCatedra == null || n.getCatedra().getCodigo() == codigoCatedra)
                .max((n1, n2) -> Double.compare(n1.getValor(), n2.getValor()))
                .orElse(null);
    }

    public double promedioNotas(Integer codigoCatedra) {
        return notas.stream()
                .filter(n -> codigoCatedra == null || n.getCatedra().getCodigo() == codigoCatedra)
                .mapToDouble(Nota::getValor)
                .average()
                .orElse(0.0);
    }

    // Getters necesarios
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<Nota> getNotas() {
        return notas;
    }
}
