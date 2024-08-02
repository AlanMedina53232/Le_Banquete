import java.util.Scanner;
import Banquete.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        char Opcion;
        Boolean Bandera = false;
        do{
            System.out.print("\nº~º~º~º~º~º~ Menú principal ~º~º~º~º~º~º");
            System.out.println("\nA) Citas \nB) Reservación\nC) Pago \nD) Clientes \nE) Empleados \nF) Paquetes \nG) Tipo de Paquete"+
                                "\nH) Tipo de Evento \nI) Puestos \nJ) Menú");
            System.out.println("¿A qué desea ingresar?");  
            do {
                Bandera = false;
                    switch (s.next().charAt(0)) {
                        case 'A':
                        case 'a':
                        Cita cita = new Cita();
                        System.out.println("\nA) Registrar cita \nB) Modificar cita \nC) Cancelar cita \nD) Consultar cita ");
                            switch (s.next().charAt(0)) {
                                case 'A':
                                case 'a':
                                cita.altaCita();
                                break;
                                case 'B':
                                case 'b':
                                cita.modificarCita();
                                    break;
                                case 'C':
                                case 'c':
                                cita.cancelarCita();
                                    break;
                                case 'D':
                                case 'd':
                                System.out.print("Ingrese el número de cita: ");
                                int numero = s.nextInt();
                                cita.consultarCita(numero);
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                break;
                            }

                            break;
                            case 'B':
                            case 'b':
                                System.out.println("\nA) Registrar reservación \nB) Modificar reservación \nC) Cancelar cita \nD) Consultar reservación");
                                System.out.println("¿A qué desea ingresar?");
                                    switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                        System.out.println("\nIngrese fecha: ");
                                    break;
                                    case 'B':
                                    case 'b':
                                        System.out.println("\nIngrese nueva fecha: ");
                                    break;
                                    case 'C':
                                    case 'c':
                                        System.out.println("¿Desea cancelar la reservación?");
                                    break;
                                    case 'D':
                                    case 'd':
                                        System.out.println("¿Desea consultar la reservación?");
                                    break;
                                    default:
                                        System.out.println("Opción no válida");
                                    break;
                                }
                            break;
                            case 'C':
                            case 'c':
                            Pago pag = new Pago();
                            System.out.println("\nA) Registrar pago \nB) Modificar pago \nC) Cancelar pago \nD) Concultar pago");
                            System.out.println("¿A qué desea ingresar?");
                                switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                        System.out.println("\nIngrese pago: ");

                                    break;
                                    case 'B':
                                    case 'b':
                                        System.out.println("\nIngrese nuevo pago: ");
                                    break;
                                    case 'C':
                                    case 'c':
                                        System.out.println("¿Desea cancelar el pago?");
                                    break;
                                    case 'D':
                                    case 'd':
                                    System.out.println("Ingrese el numero de pago: ");
                                    int numero = s.nextInt();
                                    pag.consultarPago(numero);
                                    break;
                                    default:
                                        System.out.println("Opción inválida");
                                    break;
                                }
                            break;
                            case 'D':
                            case 'd':
                            Cliente c = new Cliente();
                            System.out.println("\nA) Registrar cliente \nB) Modificar cliente \nC) Dar de baja cliente \nD) Consular cliente");
                            System.out.println("¿A qué desea ingresar?");
                                switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                        c.altaCliente();
                                        break;
                                    case 'B':
                                    case 'b':
                                        System.out.println("\nIngrese nuevo nombre: ");
                                        break;
                                    case 'C':
                                    case 'c':
                                        System.out.println("¿Desea dar de baja al cliente?");
                                    break;
                                    case 'D':
                                    case 'd':
                                        System.out.println("¿Desea consultar al cliente?");
                                    break;
                                    default:
                                    System.out.print("Ingrese el número de cliente: ");
                                    int numero = s.nextInt();
                                    c.consultarCliente(numero);
                                    break;
                                }
                            break;
                            case 'E':
                            case 'e':
                            Empleado emp =  new Empleado();
                            System.out.println("¿A qué desea ingresar?");
                            System.out.println("\nA) Registrar empleado \nB) Modificar información de empleado \nC) Dar de baja empleado \nD) Asistencias \nE) Consultar empleado");
                                switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                        emp.altaEmpleado();
                                    break;
                                    case 'B':
                                    case 'b':
                                        emp.editarEmpleado();
                                    break;
                                    case 'C':
                                    case 'c':
                                        emp.bajaEmpleado();
                                    break;
                                    case 'D':
                                    case 'd':
                                        System.out.println("Ingrese fecha de asistencia: ");
                                    break;
                                    case 'E':
                                    case 'e':
                                        System.out.print("Ingrese el número de empleado: ");
                                        int numero = s.nextInt();
                                        emp.consultarEmpleado(numero);
                                    break;
                                    default:
                                        System.out.println("Opción no válida");
                                    break;
                                }
                            break;
                            case 'F':
                            case 'f':
                            Paquete tipoPpaq = new Paquete();
                            System.out.println("\nA) Registrar paquete \nB) Modificar paquete \nC) Eliminar paquete \nD) Consultar paquete");
                            System.out.println("¿A qué desea ingresar?");
                                switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                        tipoPpaq.altaPaquete();
                                    break;
                                    case 'B':
                                    case 'b':
                                        tipoPpaq.modificarPaquete();
                                    break;
                                    case 'C':
                                    case 'c':
                                        tipoPpaq.eliminarPaquete();
                                    break;
                                    case 'D':
                                    case 'd':
                                        System.out.print("Ingrese el número de paquete: ");
                                        int numero = s.nextInt();
                                        tipoPpaq.consultarPaquete(numero);
                                    break;
                                    default:
                                        System.out.println("Opción no válida");
                                    break;
                                }
                            break;
                            case 'G':
                            case 'g':
                            Tipo_paqu paq = new Tipo_paqu();
                            System.out.println("\nA) Registrar Tipo de Paquete \nB) Modificar Tipo de Paquete \nC) Eliminar Tipo de paquete \nD) Consultar paquetes");
                            System.out.println("¿A qué desea ingresar?");
                                switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                    paq.altaTipo_paqu();
                                    break;
                                    case 'B':
                                    case 'b':
                                        System.out.println("\nIngrese nuevo nombre del tipo de paquete: ");
                                    break;
                                    case 'C':
                                    case 'c':
                                        System.out.println("¿Desea eliminar el tipo de paquete?");
                                    break;
                                    case 'D':
                                    case 'd':
                                        System.out.println("¿Desea consultar paquete?");
                                    break;
                                    default:
                                        System.out.println("Opción no válida");
                                    break;
                                }
                            break;
                            case 'H':
                            case 'h':
                            System.out.println("\nA) Registrar Tipo de evento \nB) Modificar Tipo de evento \nC) Eliminar Tipo de evento \nD) Consultar Tipo de evento");
                            System.out.println("¿A qué desea ingresar?");
                                switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                        System.out.println("\nIngrese nombre del tipo de evento: ");
                                    break;
                                    case 'B':
                                    case 'b':
                                        System.out.println("\nIngrese nuevo nombre del tipo de evento: ");
                                    break;
                                    case 'C':
                                    case 'c':
                                        System.out.println("¿Desea eliminar el tipo de evento?");
                                    break;
                                    case 'D':
                                    case 'd':
                                        System.out.println("¿Desea consultar tipo evento?");
                                    break;
                                    default:
                                        System.out.println("Opción no válida");
                                    break;
                                }
                            break;
                            case 'I':
                            case 'i':
                            Puesto puesto = new Puesto();
                            System.out.println("\nA) Registrar puesto \nB) Modificar puesto \nC) Eliminar puesto \nD) Consultar puestos");
                            System.out.println("¿A qué desea ingresar?");
                                switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                        System.out.println("\nIngrese nombre del puesto: ");
                                    break;
                                    case 'B':
                                    case 'b':
                                        System.out.println("\nIngrese nuevo nombre del puesto: ");
                                    break;
                                    case 'C':
                                    case 'c':
                                        System.out.println("\nEliminar puesto");
                                    break;
                                    case 'D':
                                    case 'd':
                                    System.out.print("Ingrese el puesto a consultar: ");
                                    int clave = s.nextInt();
                                        puesto.consultarPuesto(clave);
                                    break;
                                    default:
                                        System.out.println("Opción no válida");
                                    break;
                                }
                            break;
                            case 'J':
                            case 'j':
                            System.out.println("¿A qué desea ingresar?");
                            System.out.println("\nA) Registrar complemento  \nB) Modificar complemento \nC) Eliminar complemento \nD) Consultar menú");
                                switch (s.next().charAt(0)) {
                                    case 'A':
                                    case 'a':
                                        System.out.println("\nIngrese nombre del complemento: ");
                                    break;
                                    case 'B':
                                    case 'b':
                                        System.out.println("\nIngrese nuevo nombre del complemento: ");
                                    break;
                                    case 'C':
                                    case 'c':
                                        System.out.println("\nEliminar complemento");
                                    break;
                                    case 'D':
                                    case 'd':
                                        System.out.println("Consultar menú");
                                    break;
                                    default:
                                        System.out.println("Opción no válida");
                                    break;
                                }
                        break;
                        default:
                        System.out.println("Opción no válida");
                        break;
                    }
            } while (Bandera == true);
            
            System.out.print("\nPresiona 'A' para regresar al mneú principal o cualquier otra letra para terminar el programa ");
            Opcion = s.next().charAt(0);

        } while (Opcion == 'A' || Opcion == 'a');

    }

}


















