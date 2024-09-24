public class ReporteDesempenio {
    private Empleado empleado;
    private String evaluacion;
    private String comentarios;

    public ReporteDesempenio(Empleado empleado, String evaluacion, String comentarios) {
        this.empleado = empleado;
        this.evaluacion = evaluacion;
        this.comentarios = comentarios;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    @Override
    public String toString() {
        return "ReporteDesempenio{" +
                "empleado=" + empleado +
                ", evaluacion='" + evaluacion + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
