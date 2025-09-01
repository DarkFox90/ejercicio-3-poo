import java.util.ArrayList;

//agregué un constructor para que pudiera funcionar mis funciones en Main
//agregué también un atributo de gimnasio para oder inicializar un gimnasio en controlador y usarlo en main
public class Controlador {
    private Gimnasio gimnasio;

    public Controlador(Gimnasio gimnasio){
        this.gimnasio = gimnasio;
    }

    //cambié el parametro de verMIembros a un array para que pudiera retornar el valor correcto
    public ArrayList<Miembro> verMiembros(){
        return gimnasio.getMiembrosActivos();
    }

    public ArrayList<Entrenador> verEntrenadores() {
        return gimnasio.getEntrenadoresActivos();
    }

    //agregué esta función para poder buscar mimbros por ID y así poder añadirles las rutinas, esta función busca enre los miembros el id de cada uno y los compara, si son iguales retorna el miemrbo y si no retorna null
    public Miembro buscarMiembroPorId(int id) {
        for (Miembro m : verMiembros()) {
            if (m.getId() == id) {
                return m;
            }
        } return null;
    }

    //agruegé esta funcion para poder buscar entrenadores por ID y poder asignarlos a los miembros, esta funcion busca entre los entrenadores si coinciden los ID y retorna el entrenador, si no retorna null
    public Entrenador buscarEntrenadorPorID(int id) {
        for (Entrenador e : verEntrenadores()) {
            if (e.getId() == id){
                return e;
            }
        }return null;
    }

    //cambié el retorno de void a boolean para poder utilizarlo en main
    public boolean agregarMiembroAEntrenador(int idEntrenador, int idMiembro) {
        Entrenador e = buscarEntrenadorPorID(idEntrenador);
        Miembro m = buscarMiembroPorId(idMiembro);

        if(e == null || m == null){
            return false;
        } return e.asignarMiembro(m);
    }


    //por cuestiones de tiempo no utilicé eliminarMiembro, eliminarEntrenador, verRutinas y eliminarRutina


    
}
