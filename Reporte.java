import java.util.ArrayList;

public class Reporte {
    private Rutina rutinaMasPracticada;
    private int totalRutinas;
    private String entrenadorMasSolicitado;

    public Reporte(Rutina rutinaMasPracticada, int totalRutinas, String entrenadorMasSolicitado) {
        this.rutinaMasPracticada = rutinaMasPracticada;
        this.totalRutinas = totalRutinas;
        this.entrenadorMasSolicitado = entrenadorMasSolicitado;
    }

    public Rutina getRutinaMasPracticada() {
        return rutinaMasPracticada;
    }

    public int getTotalRutinas() {
        return totalRutinas;
    }

    public String getEntrenadorMasSolicitado() {
        return entrenadorMasSolicitado;
    }

    public static Reporte generar(ArrayList<Miembro> miembros, ArrayList<Entrenador> entrenadoores){
        int bajarP = 0, aumentarM = 0, resistencia = 0;

        ArrayList<String> claves = new ArrayList<>();

        for (Miembro m : miembros) {
            Rutina r = m.getRutina();
            if(r == null){
                continue;
            }

            
        }
    }

    
  
}
