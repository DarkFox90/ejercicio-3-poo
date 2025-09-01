// agregué 2 matributos, nextID y id que me sirvieron para poder manejar mejor la seleccion de coach y de cambios de rutinas.
public class Miembro {
    private String nombre;
    private String membresia;
    private Entrenador entrenador;
    private Rutina rutina;
    private static int nextId = 1;
    private final int id;

    //constructor que crea un nuevo miembro, agregúe id = nexID++ para que sirva como contador y vaya sumando 1 a cada nuevo mimnebro, cada miembro va a tener un identificador 1....n
    public Miembro(String nombre, String membresia, Rutina rutina) {
        this.nombre = nombre;
        this.membresia = membresia;
        this.rutina = rutina;
        this.id = nextId++;
    }


    //getters para poder jalar los nombres y características de los miembros
    public String getNombre() {
        return nombre;
    }

    public String getMembresia() {
        return membresia;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public Rutina getRutina() {
        return rutina;
    }


    public int getId() {
        return id;
    }

    //agregué un setter para poder modificar las rutinas de los miembros
    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    //agregué un to string para que me aparezca a la hora de hacer sysout a la información
    public String toString() {
        return "Miembro: " +
               "nombre='" + nombre + '\'' +
               ", membresia= '" + membresia + '\'' +
               "   rutina: " + rutina;
    }

    
}