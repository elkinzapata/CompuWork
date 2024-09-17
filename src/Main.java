public class Main {
    public static void main(String[] args) {
        try {
            Empleado empleado1 = new Empleado("1", "Juan", "Perez");
            Empleado empleado2 = new Empleado("2", "Ana", "Gomez");

            Departamento departamento = new Departamento("D1", "Recursos Humanos");
            departamento.agregarEmpleado(empleado1);
            departamento.agregarEmpleado(empleado2);

            ReporteDesempeño reporte1 = new ReporteDesempeño(empleado1, "Excelente", "Gran desempeño en el último trimestre.");
            ReporteDesempeño reporte2 = new ReporteDesempeño(empleado2, "Bueno", "Buen desempeño, pero con áreas de mejora.");

            System.out.println(departamento);
            System.out.println(reporte1);
            System.out.println(reporte2);
        } catch (GestionException e) {
            System.err.println("Error en la gestión: " + e.getMessage());
        }
    }
}