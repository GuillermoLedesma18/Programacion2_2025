import java.util.List;

public class Catedra {
    private int codigo;
    private String denominacion;
    private DivisionCurso divisionCurso;
    private List<Alumno> alumnos;

    public Alumno mejorAlumnoCatedra() {
        return alumnos.stream()
                .max((a1, a2) -> Double.compare(
                        a1.promedioNotas(this.codigo),
                        a2.promedioNotas(this.codigo)))
                .orElse(null);
    }
}
