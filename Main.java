/*
 * Universidad del Valle de Guatemala
 * Programacion Orientada a Objetos
 * Ejercicio 3: sistema de organización de gimnasios
 * fecha de creación: 30 de agosto de 2025
 * ultima modificación: 1 de septiembre de 2025
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gimnasio gimnasio = new Gimnasio(); //inicialicé un gimnasio en main para poder ir metiendo los valores de miembros y entrenadores a las listas creadas en la clase Gimnasio
        Controlador controlador = new Controlador(gimnasio); //inicialicé un controlador

        int opcion;
        //ciclo do while para poder utilizar scanner de manera correcta
        do { 
            System.out.println("1. registrar un miembro");
            System.out.println("2. registrar un entrenador");
            System.out.println("3. consultar información de Staff y miembros");
            System.out.println("4. modificar rutina");
            System.out.println("5. obtener reporte");
            System.out.println("6. salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: //aqui necesitaba crear una rutina de una vez para que funcionara bien
                    System.out.println("ingrese el nombre de la persona que desea registrar");
                    String nombre = scanner.nextLine();

                    System.out.println("ingrese la membresía (basic, gold, diamond): ");
                    String membresia = scanner.nextLine();

                    System.out.println("ingrese el tipo de rutina que practica (bajar peso, aumentar musculo, resistencia): ");
                    String tipoRutina = scanner.nextLine();

                    System.out.println("ingrese el nombre de la rutina: ");
                    String nombreRutina = scanner.nextLine();

                    Rutina rutina = new Rutina(tipoRutina, nombreRutina);
                    Miembro miembro = new Miembro(nombre, membresia, rutina); //miembro y rutina son creados con las variables que scanner guarda

                    gimnasio.agregarMiembro(miembro);

                    System.out.println("miembro registrado existosamente \n");
                    break;


                case 2:
                    System.out.println("ingrese el nombre del entrenador: ");
                    String nombreEn = scanner.nextLine();
                    
                    System.out.println("ingrese la especialidad del entrenador: ");
                    String especialidad = scanner.nextLine();

                    Entrenador entrenador = new Entrenador(nombreEn, especialidad, null);

                    System.out.println("que miembros desea agregar al entrenador? ");

                    //cree una arrayList para poder ver otra vez los miembros junto con el índice para elegir el coach
                    ArrayList<Miembro> todos = controlador.verMiembros();
                    if (todos.isEmpty()){
                        System.out.println("no hay miembros inscritos");
                    } else {
                        System.out.println("miembros: ");
                        for(Miembro m : todos) {
                            System.out.println(" id " + m.getId() + m.getNombre());
                        }
                    }

                    int opcion2 = 0;
                    
                    //while loop que permite ir agregando un miembro a cada coach que se vaya creando y se termina hasta que el usuario presione -1
                    while (opcion2 != 1) {
                        System.out.println("ingrese el id del miembro que desea asignar a un entrenador (presione -1 para acabar): ");
                        int idMiembro = scanner.nextInt();
                        scanner.nextLine();

                        if (idMiembro == -1) {
                            
                            break;
                        }
                        
                        //aquí se chequea que exista el id del miembro
                        Miembro mi = controlador.buscarMiembroPorId(idMiembro);
                        if(mi == null) {
                            System.out.println("id no encontrado");
                            break;
                        }
                        
                        //si si existe el id se asigna el miembro al entrenador
                        boolean asignado = entrenador.asignarMiembro(mi);
                        if (asignado) {
                            System.out.println(mi.getNombre() + " asignado a " + nombreEn);
                        } else {
                            System.out.println("no se pudo asignar");
                        }
                    }
                    
                    //aqui se agrega el entrenador junto con su miembro al gimnasio
                    gimnasio.agregarEntrenador(entrenador);
                    System.out.println("entrenador registrado");
                    break;



                case 3:

                //aqui cree 2 listas para poder imprimir en pantalla los miembros y los entrenadores. esto es mediante un for que va recorriendo la lista y va imprimiendo cada miembro que encuentra
                    ArrayList<Miembro> lista = controlador.verMiembros();
                    if (lista.isEmpty()) {
                        System.out.println("no hay miembros inscritos");
                    } else {
                        for (Miembro m : lista) {
                            System.out.println(m + "id: " + m.getId() + "\n");
                        }
                    }

                    ArrayList<Entrenador> lista2 = controlador.verEntrenadores();
                    if (lista2.isEmpty()) {
                        System.out.println("no hay entrenadores");
                    } else {
                        for (Entrenador e : lista2) {
                            System.out.println(e + "id: " + e.getId());
                        }
                    }
                    break;


                case 4:
                    System.out.println("que miembro desea modificar (id del miembro)? ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    //aqui se inicializa un objeto llamado objetivo de tipo Miembro que es necesario para poder añadirle la nueva rutina utilizando el metodo buscarMiemrboPorID
                    Miembro objetivo = controlador.buscarMiembroPorId(id);

                    //aqui se inicializa una nueva rutina cada vez que el usuario decida modificar la rutina, los nuevos parametros se añaden al constructor de rutina y tilizando el setRutina se asignan al miembro.
                    if (objetivo != null) {
                        System.out.println("ingrese el tipo de rutina (bajar peso, aumentar músculo, resistencia): ");
                        String nuevoTipo = scanner.nextLine();

                        System.out.println("ingrese el nombre de la rutina nueva: ");
                        String nuevoNommbre = scanner.nextLine();

                        Rutina nuevaRutina = new Rutina(nuevoTipo, nuevoNommbre);
                        objetivo.setRutina(nuevaRutina);

                        System.out.println("rutina actualizada exitosamente para: " + objetivo.getNombre());
                    } else {
                        System.out.println("no existe ningun miembro con ese ID");
                    }

                    break;
                case 5:
                    System.out.println("ddd");
                    break;
                case 6:
                    System.out.println("gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }
}
