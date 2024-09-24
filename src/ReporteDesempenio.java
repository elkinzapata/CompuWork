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
        return "\nReporte de Desempeño del Empleado:\n" +
                empleado +  // Esto invocará el toString() del Empleado
                "Evaluación: " + evaluacion +
                "\nComentarios: " + comentarios + "\n";
    }

}

