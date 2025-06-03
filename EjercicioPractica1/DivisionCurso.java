import java.util.List;

public class DivisionCurso {
    private int codigo;
    private int anio;
    private int division;
    private Escuela escuela;
    private List<Catedra> catedras;

    public List<Alumno> getAlumnos() {
        return catedras.stream()
                .flatMap(cat -> cat.getAlumnos().stream())
                .distinct()
                .toList();
    }

    public Alumno mejorAlumnoDivisionCurso() {
        return getAlumnos().stream()
                .filter(alumno -> alumno.getNotas().stream().filter(n -> !n.isEsRecuperatorio()).count() >= 5)
                .filter(alumno -> alumno.getNotas().stream().noneMatch(Nota::isEsRecuperatorio))
                .max((a1, a2) -> Double.compare(a1.promedioNotas(null), a2.promedioNotas(null)))
                .orElse(null);
    }
}
