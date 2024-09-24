import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String id;
    private String nombre;
    private List<Empleado> empleados;

        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

        empleados.add(empleado);
        empleado.setDepartamentoId(this.id);
    }

        empleados.remove(empleado);
        empleado.setDepartamentoId(null);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}