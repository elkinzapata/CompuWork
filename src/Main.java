public class Main {
    public static void main(String[] args) {
        try {
            Empleado empleado1 = new Empleado("1", "Juan", "Perez");
            Empleado empleado2 = new Empleado("2", "Ana", "Gomez");
            Empleado empleado3 = new Empleado("3", "Luis", "Martinez");

            // Creamos un departamento con capacidad máxima de 2 empleados
            Departamento departamento = new Departamento("D1", "Recursos Humanos", 2);

            // Agregar empleados al departamento
            departamento.agregarEmpleado(empleado1);
            departamento.agregarEmpleado(empleado2);

            // Intentar agregar un tercer empleado (esto lanzará una excepción)
            departamento.agregarEmpleado(empleado3);  // Esto lanzará GestionException

            // Generar reportes de desempeño
            ReporteDesempenio reporte1 = new ReporteDesempenio(empleado1, "Excelente", "Gran desempeño en el último trimestre.");
            ReporteDesempenio reporte2 = new ReporteDesempenio(empleado2, "Bueno", "Buen desempeño, pero con áreas de mejora.");

            System.out.println(departamento);
            System.out.println(reporte1);
            System.out.println(reporte2);

        } catch (GestionException e) {
            System.err.println("Error en la gestión: " + e.getMessage());
        }
    }
}
