import java.util.List;

public class Escuela {
    private int numero;
    private String denominacion;
    private List<DivisionCurso> divisiones;

    public Alumno getMejorAlumnoEscuela(int anioNacimientoAlumno) {
        return divisiones.stream()
                .flatMap(div -> div.getAlumnos().stream())
                .filter(alumno -> alumno.getFechaNacimiento().getYear() + 1900 == anioNacimientoAlumno)
                .filter(alumno -> alumno.getNotas().stream().allMatch(n -> n.getValor() >= 6))
                .max((a1, a2) -> Double.compare(a1.promedioNotas(null), a2.promedioNotas(null)))
                .orElse(null);
    }

    public List<Alumno> getMejoresAlumnos(int anioNacimientoAlumno) {
        return divisiones.stream()
                .flatMap(div -> div.getAlumnos().stream())
                .filter(alumno -> alumno.getFechaNacimiento().getYear() + 1900 == anioNacimientoAlumno)
                .filter(alumno -> alumno.getNotas().stream().allMatch(n -> n.getValor() >= 6))
                .sorted((a1, a2) -> Double.compare(a2.promedioNotas(null), a1.promedioNotas(null)))
                .limit(3)
                .toList();
    }
}
