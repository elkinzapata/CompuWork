/*public class Main {
    public static void main(String[] args) {
        try {
            Empleado empleado1 = new Empleado("1", "Juan", "Perez");
            Empleado empleado2 = new Empleado("2", "Ana", "Gomez");
            Empleado empleado3 = new Empleado("3", "Luis", "Martinez");

            Departamento departamento = new Departamento("D1", "Recursos Humanos", 2);

            departamento.agregarEmpleado(empleado1);
            departamento.agregarEmpleado(empleado2);
            departamento.agregarEmpleado(empleado3);

            ReporteDesempenio reporte1 = new ReporteDesempenio(empleado1, "Excelente", "Gran desempeño en el último trimestre.");
            ReporteDesempenio reporte2 = new ReporteDesempenio(empleado2, "Bueno", "Buen desempeño, pero con áreas de mejora.");

            System.out.println(departamento);
            System.out.println(reporte1);
            System.out.println(reporte2);

        } catch (GestionException e) {
            System.err.println("Error en la gestión: " + e.getMessage());
        }
    }
}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Departamento departamento;  // Usaremos un departamento global para gestionar los empleados
    private static List<ReporteDesempenio> reportes = new ArrayList<>();  // Lista para almacenar los reportes de desempeño

    public static void main(String[] args) {
        // Inicializamos el departamento
        departamento = new Departamento("D1", "Recursos Humanos", 10);

        // Crear la ventana
        JFrame frame = new JFrame("Gestión de Empleados y Departamentos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear el panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // Crear componentes para la ventana
        JLabel label = new JLabel("Seleccione una acción:");
        JButton botonAgregarEmpleado = new JButton("Agregar Empleado");
        JButton botonGenerarReporte = new JButton("Generar Reporte");
        JTextArea areaTexto = new JTextArea(10, 30);  // Área de texto para mostrar información
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        // Agregar componentes al panel
        panel.add(label);
        panel.add(botonAgregarEmpleado);
        panel.add(botonGenerarReporte);
        panel.add(scrollPane);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Mostrar la ventana
        frame.setVisible(true);

        // Acción al presionar el botón de agregar empleado
        botonAgregarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });

        // Acción al presionar el botón de generar reporte
        botonGenerarReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte(areaTexto);
            }
        });
    }

    // Método para agregar empleado
    public static void agregarEmpleado() {
        // Crear ventana de diálogo para ingresar los datos del empleado
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField apellidoField = new JTextField();
        String[] tipoEmpleado = {"Permanente", "Temporal"};
        JComboBox<String> tipoEmpleadoBox = new JComboBox<>(tipoEmpleado);

        // Crear formulario para el diálogo
        Object[] inputFields = {
                "ID:", idField,
                "Nombre:", nombreField,
                "Apellido:", apellidoField,
                "Tipo de Empleado:", tipoEmpleadoBox
        };

        int option = JOptionPane.showConfirmDialog(null, inputFields, "Agregar Empleado", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String id = idField.getText();
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String tipo = (String) tipoEmpleadoBox.getSelectedItem();

            Empleado empleado;
            if (tipo.equals("Permanente")) {
                empleado = new EmpleadoPermanente(id, nombre, apellido, 50000);  // Salario fijo para ejemplo
            } else {
                empleado = new EmpleadoTemporal(id, nombre, apellido, 12);  // Contrato de 12 meses para ejemplo
            }

            // Intentar agregar el empleado al departamento
            try {
                departamento.agregarEmpleado(empleado);
                JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente.");
            } catch (GestionException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para generar reporte
    public static void generarReporte(JTextArea areaTexto) {
        // Seleccionar un empleado para generar el reporte
        List<Empleado> empleados = departamento.getEmpleados();
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados en el departamento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] empleadosArray = empleados.stream().map(Empleado::getNombre).toArray(String[]::new);
        JComboBox<String> empleadoBox = new JComboBox<>(empleadosArray);

        JTextField evaluacionField = new JTextField();
        JTextField comentariosField = new JTextField();

        // Crear formulario para el diálogo
        Object[] inputFields = {
                "Seleccione Empleado:", empleadoBox,
                "Evaluación:", evaluacionField,
                "Comentarios:", comentariosField
        };

        int option = JOptionPane.showConfirmDialog(null, inputFields, "Generar Reporte", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            Empleado empleadoSeleccionado = empleados.get(empleadoBox.getSelectedIndex());
            String evaluacion = evaluacionField.getText();
            String comentarios = comentariosField.getText();

            // Crear el reporte de desempeño
            ReporteDesempenio reporte = new ReporteDesempenio(empleadoSeleccionado, evaluacion, comentarios);
            reportes.add(reporte);

            // Mostrar el reporte en el área de texto
            areaTexto.append(reporte.toString() + "\n");
        }
    }
}
