package Banquete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Cita {
    private int numero;
    private String fecha;
    private String hora;
    private int numEmpleado;
    private int numCliente;

    public Cita() {

    }

    public int getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void altaCita() {
        Cliente cliente = new Cliente();
        Empleado empleado = new Empleado();
        Scanner s = new Scanner(System.in);
        String altaCita = "INSERT INTO cita (numero, fecha, hora, empleado, cliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = ConexionBD.getConnection();
                Statement statement = conexion.createStatement();
                PreparedStatement preparedCita = conexion.prepareStatement(altaCita)) {
            System.out.println("El cliente ya se encuentra registrado? A=Si/ cualquier otra tecla=No");
            char opc = s.next().charAt(0);

            if (opc == 'A' || opc == 'a') {
                System.out.print("Ingrese el número de cliente:");
                numCliente = s.nextInt();
                cliente.consultarCliente(numCliente);
                System.out.println("¿Los datos del cliente son correctos? A=Si/ cualquier otra tecla=No");
                opc = s.next().charAt(0);
                if (opc == 'a' || opc == 'A') {
                    // Solicitar información de la cita al usuario
                    System.out.print("Ingrese el número de cita: ");
                    numero = s.nextInt();
                    s.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    fecha = s.nextLine();
                    System.out.print("Hora (HH:MM): ");
                    hora = s.nextLine();
                    System.out.print("Número de empleado: ");
                    numEmpleado = s.nextInt();
                    empleado.consultarEmpleado(numEmpleado);
                    do {
                        System.out.println("¿Los datos del empleado son correctos? A=Si/ cualquier otra tecla=No");
                        opc = s.next().charAt(0);
                        if (opc != 'a' || opc != 'A') {
                            System.out.print("Ingrese de nuevo número de empleado:");
                            numEmpleado = s.nextInt();
                            cliente.consultarCliente(numEmpleado);
                        }
                    } while (opc != 'a' || opc != 'A');

                    preparedCita.setLong(1, numero);
                    preparedCita.setString(2, fecha);
                    preparedCita.setString(3, hora + ":00");
                    preparedCita.setInt(4, numEmpleado);
                    preparedCita.setInt(5, numCliente);

                    // Ejecutar la inserción de la cita
                    preparedCita.executeUpdate();
                    System.out.println("Cita registrada correctamente.");

                } else {
                    do{
                        System.out.print("Ingrese de nuevo número de cliente:");
                        numCliente = s.nextInt();
                        cliente.consultarCliente(numCliente);
                        System.out.println("¿Los datos del cliente son correctos? A=Si/ cualquier otra tecla=No");
                        opc = s.next().charAt(0);
                    } while (opc != 'a' || opc != 'A');
                    // Solicitar información de la cita al usuario

                    System.out.print("Ingrese el número de cita: ");
                    numero = s.nextInt();
                    s.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    fecha = s.nextLine();
                    System.out.print("Hora (HH:MM): ");
                    hora = s.nextLine();
                    System.out.print("Número de empleado: ");
                    numEmpleado = s.nextInt();
                    empleado.consultarEmpleado(numEmpleado);
                    do {
                        System.out.println("¿Los datos del empleado son correctos? A=Si/ cualquier otra tecla=No");
                        opc = s.next().charAt(0);
                        if (opc != 'a' || opc != 'A') {
                            System.out.print("Ingrese de nuevo número de empleado:");
                            numEmpleado = s.nextInt();
                            cliente.consultarCliente(numEmpleado);
                        }
                    } while (opc != 'a' || opc != 'A');

                    preparedCita.setLong(1, numero);
                    preparedCita.setString(2, fecha);
                    preparedCita.setString(3, hora + ":00");
                    preparedCita.setInt(4, numEmpleado);
                    preparedCita.setInt(5, numCliente);

                    // Ejecutar la inserción de la cita
                    preparedCita.executeUpdate();
                    System.out.println("Cita registrada correctamente.");
                }

            } else {
                cliente.altaCliente();
                System.out.println("Ingrese el número de la cita:");
                numero = s.nextInt();
                // Solicitar información de la cita al usuario
                System.out.print("Ingrese el número de cita: ");
                numero = s.nextInt();
                s.nextLine();
                System.out.print("Fecha (YYYY-MM-DD): ");
                fecha = s.nextLine();
                System.out.print("Hora (HH:MM): ");
                hora = s.nextLine();
                System.out.print("Número de empleado: ");
                numEmpleado = s.nextInt();
                empleado.consultarEmpleado(numEmpleado);
                do {
                    System.out.println("¿Los datos del empleado son correctos? A=Si/ cualquier otra tecla=No");
                    opc = s.next().charAt(0);
                    if (opc != 'a' || opc != 'A') {
                        System.out.print("Ingrese de nuevo el número de empleado:");
                        numEmpleado = s.nextInt();
                        cliente.consultarCliente(numEmpleado);
                    }
                } while (opc != 'a' || opc != 'A');
                System.out.print("Número de cliente: ");
                numCliente = s.nextInt();
                cliente.consultarCliente(numCliente);
                do {
                    System.out.println("¿Los datos del cliente son correctos? A=Si/ cualquier otra tecla=No");
                    opc = s.next().charAt(0);
                    if (opc != 'a' || opc != 'A') {
                        System.out.print("Ingrese de nuevo el número de cliente:");
                        numCliente = s.nextInt();
                        cliente.consultarCliente(numCliente);
                    }
                } while (opc != 'a' || opc != 'A');

                preparedCita.setLong(1, numero);
                preparedCita.setString(2, fecha);
                preparedCita.setString(3, hora + ":00");
                preparedCita.setInt(4, numEmpleado);
                preparedCita.setInt(5, numCliente);

                // Ejecutar la inserción de la cita
                preparedCita.executeUpdate();
                System.out.println("Cita registrada correctamente.");

            }

        } catch (SQLException e) {
            System.out.println("Error al dar de alta cita");
        }

    }

    public void modificarCita() {
        Scanner s = new Scanner(System.in);
        String modificarCita = "UPDATE cita SET fecha = ?, hora = ? WHERE numero= ?";
        char opc;
        char opc2;
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement preparedCita = conexion.prepareStatement(modificarCita)) {
            System.out.println("Ingrese el número de la cita que desea modificar:");
            numero = s.nextInt();

            consultarCita(numero);
            System.out.println("¿Los datos de la cita son correctos? A=Si/ cualquier otra tecla=No");
            char opc1 = s.next().charAt(0);
            if (opc1 == 'a' || opc1 == 'A') {
                do {
                    System.out.print("Ingrese el número de cita correcto: ");
                    numero = s.nextInt();
                    consultarCita(numero);
                    System.out.println("¿Los datos de la cita son correctos? A=Si/ cualquier otra tecla=No");
                    opc1 = s.next().charAt(0);
                } while (opc1 != 'a' || opc1 != 'A');
                System.out.println("¿Desea modificar la fecha de la cita? A=Si/ cualquier otra tecla=CANCELAR");
                opc = s.next().charAt(0);
                if (opc == 'A' || opc == 'a') {
                    s.nextLine();
                    System.out.print("Ingrese la nueva fecha (YYYY-MM-DD): ");
                    fecha = s.nextLine();
                }
                System.out.println("¿Desea modificar la hora de la cita? A=Si/ cualquier otra tecla=CANCELAR");
                opc2 = s.next().charAt(0);
                if (opc2 == 'A' || opc2 == 'a') {
                    System.out.print("Ingrese la nueva hora: ");
                    hora = s.nextLine();
                }

                if (opc == 'A' && opc2 == 'A') {
                    preparedCita.setString(1, fecha);
                    preparedCita.setString(2, hora + ":00");
                    preparedCita.setInt(3, numero);

                } else if (opc == 'a' && opc2 == 'a') {
                    preparedCita.setString(1, fecha);
                    preparedCita.setString(2, hora + ":00");
                    preparedCita.setInt(3, numero);

                } else if (opc == 'a' && opc2 == 'A') {
                    preparedCita.setString(1, fecha);
                    preparedCita.setString(2, hora + ":00");
                    preparedCita.setInt(3, numero);

                } else if (opc == 'A' && opc2 == 'a') {
                    preparedCita.setString(1, fecha);
                    preparedCita.setString(2, hora + ":00");
                    preparedCita.setInt(3, numero);

                }
            } else {
                System.out.println("¿Desea modificar la fecha de la cita? A=Si/ cualquier otra tecla=CANCELAR");
                opc = s.next().charAt(0);
                if (opc == 'A' || opc == 'a') {
                    s.nextLine();
                    System.out.print("Ingrese la nueva fecha (YYYY-MM-DD): ");
                    fecha = s.nextLine();
                }
                System.out.println("¿Desea modificar la hora de la cita? A=Si/ cualquier otra tecla=CANCELAR");
                opc2 = s.next().charAt(0);
                if (opc2 == 'A' || opc2 == 'a') {
                    System.out.print("Ingrese la nueva hora: ");
                    hora = s.nextLine();
                }

                if (opc == 'A' && opc2 == 'A') {
                    preparedCita.setString(1, fecha);
                    preparedCita.setString(2, hora + ":00");
                    preparedCita.setInt(3, numero);

                } else if (opc == 'a' && opc2 == 'a') {
                    preparedCita.setString(1, fecha);
                    preparedCita.setString(2, hora + ":00");
                    preparedCita.setInt(3, numero);

                } else if (opc == 'a' && opc2 == 'A') {
                    preparedCita.setString(1, fecha);
                    preparedCita.setString(2, hora + ":00");
                    preparedCita.setInt(3, numero);

                } else if (opc == 'A' && opc2 == 'a') {
                    preparedCita.setString(1, fecha);
                    preparedCita.setString(2, hora + ":00");
                    preparedCita.setInt(3, numero);

                }
            }
            int filasAfectadas = preparedCita.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Cita modificada con éxito.");
            } else {
                System.out.println("No se encontró la cita con el número especificado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al modificar cita");
        }
    }

    public void cancelarCita() {
        Scanner s = new Scanner(System.in);
        String cancelarCita = "DELETE FROM cita WHERE numero=?";
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement preparedCita = conexion.prepareStatement(cancelarCita)) {
            System.out.println("Ingrese el número de la cita que desea modificar:");
            numero = s.nextInt();

            consultarCita(numero);
            System.out.println("¿Desea cancelar la cita? A=Si/ cualquier otra tecla=CANCELAR");
            char opc = s.next().charAt(0);
            if (opc == 'A' || opc == 'a') {
                preparedCita.setInt(1, numero);

                int filasAfectadas = preparedCita.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Cita cancelada con éxito.");
                } else {
                    System.out.println("No se encontró la cita con el número especificado.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al modificar cita");
        }
    }

    public void consultarCita(int numero) {

        String consultaSQL = "SELECT " +
                "DATE_FORMAT(c.fecha, '%d-%m-%y') AS fecha, " +
                "DATE_FORMAT(c.hora, '%H:%i') AS hora, " +
                "CONCAT(cl.nombre, ' ', cl.primerApellido, ' ', cl.segundoApellido) AS cliente, " +
                "CONCAT(e.nombre, ' ', e.primerApellido, ' ', e.segundoApellido) AS empleado " +
                "FROM cita AS c " +
                "INNER JOIN cliente AS cl ON c.cliente = cl.numero " +
                "INNER JOIN empleado AS e ON c.empleado = e.numero " +
                "WHERE c.numero = ?";

        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement psConsulta = conexion.prepareStatement(consultaSQL)) {

            // Establecer el parámetro en la consulta
            psConsulta.setInt(1, numero);

            try (ResultSet resultSet = psConsulta.executeQuery()) {
                if (resultSet.next()) {
                    String fechaCita = resultSet.getString("fecha");
                    String horaCita = resultSet.getString("hora");
                    String cliente = resultSet.getString("cliente");
                    String empleado = resultSet.getString("empleado");

                    System.out.println("<---------------------DATOS DE LA CITA---------------------->");
                    System.out.println("Fecha registrada: " + fechaCita);
                    System.out.println("Hora registrada: " + horaCita);
                    System.out.println("Empleado asignado: " + empleado);
                    System.out.println("Cliente: " + cliente);
                } else {
                    System.out.println("No se encontró una cita con el número especificado.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar la cita: " + e.getMessage());
        }
    }

}
