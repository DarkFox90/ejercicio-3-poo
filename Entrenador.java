import java.util.ArrayList;
// agregué nextID y Id al igual que en miemrbo para poder gestionar mejor los entrenadores y la asignación de miembros
public class Entrenador {
    private String nombre;
    private String especialidad;
    private ArrayList<Miembro> miembros;
    private static int nextId = 1;
    private final int id;
    
    //agregué nextId++ para poder darle un indice a cada entrenador como a los miembros
    public Entrenador(String nombre, String especialidad, ArrayList<Miembro> miembros) { //cambié un parametro por el arraylist para que hiciera sentido crear un entrendor
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.miembros = new ArrayList<>();
        this.id = nextId++;
    }
    
    //getters 
    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }

    public int getId() {
        return id;
    }


    //cambié el valor de retorno a boolean para poder utilizarlo en controlador
    public boolean asignarMiembro(Miembro m) { //cambie alumno por m (miembro) para evitar confusión 
            if (m == null) {
                return false;
            } else if (miembros.contains(m)) {
                return false;
            } miembros.add(m);
            return true;
        }

        
        //no hice la función eliminarAlumno por cuestiones de tiempo


    //agregué un to string para que me aparezca a la hora de hacer sysout a la información
    public String toString() {
        return "Entrenador: " +
               "nombre='" + nombre + '\'' +
               ", especialidad= '" + especialidad + '\'' +
               "   miembros: " + miembros;
    }
}
