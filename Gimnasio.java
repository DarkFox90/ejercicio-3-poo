import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Miembro> miembrosActivos;
    private ArrayList<Entrenador> entrenadoresActivos;
    private ArrayList<Rutina> rutinas;

    public Gimnasio() {
        this.miembrosActivos = new ArrayList<>();
        this.entrenadoresActivos = new ArrayList<>();
        this.rutinas = new ArrayList<>();
    }

    //funciones que agregan todos los miembros, entrenadores y rutinas a las listas correspondientes que componen el gimnasio
    public void agregarMiembro(Miembro miembro){
        miembrosActivos.add(miembro);
    }

    public void agregarEntrenador(Entrenador entrenador){
        entrenadoresActivos.add(entrenador);
    }

    public void agregarRutina(Rutina rutina){
        rutinas.add(rutina);
    }

    //añadí getters para poder utilizarlos en main y controlador
   public ArrayList<Miembro> getMiembrosActivos() {
        return miembrosActivos;
   }

    public ArrayList<Entrenador> getEntrenadoresActivos() {
        return entrenadoresActivos;
    }

    public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }

}