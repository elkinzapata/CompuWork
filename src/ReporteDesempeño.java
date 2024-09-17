public class ReporteDesempeño {
    private Empleado empleado;
    private String evaluacion;
    private String comentarios;

    public ReporteDesempeño(Empleado empleado, String evaluacion, String comentarios) {
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
        return "ReporteDesempeño{" +
                "empleado=" + empleado +
                ", evaluacion='" + evaluacion + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}