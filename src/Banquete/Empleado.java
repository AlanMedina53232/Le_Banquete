package Banquete;


import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Empleado extends Persona{
    protected int numero;
    private int supervisor;

    public Empleado(){

    }
    public int getNumero() {
        return numero;
    }


    public String getNombre() {
        return super.getNombre();
    }
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }


    public String getPrimerApell() {
        return super.getPrimerApell();
    }
    public void setPrimerApell(String primerApell) {
        super.setPrimerApell(primerApell);
    }


    public String getSegApell() {
        return super.getSegApell();
    }
    public void setSegApell(String segApell) {
        super.setSegApell(segApell);
    }

    
    public int getSupervisor() {
        return supervisor;
    }
    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }
    public void altaEmpleado() {
        Scanner scanner = new Scanner(System.in);
        Puesto puesto = new Puesto();

        System.out.println("Numero: ");
        numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        setNombre(scanner.nextLine());
        System.out.print("Primer Apellido: ");
        setPrimerApell(scanner.nextLine());
        System.out.print("Segundo Apellido: ");
        setSegApell(scanner.nextLine());
        System.out.print("Número de empleado del upervisor: ");
        supervisor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Codigo de puesto: ");
        puesto.setClave(scanner.nextInt());

        String altaEmpleado = "INSERT INTO empleado (numero, nombre, primerApellido, segundoApellido, supervisor, puesto) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement preparedEmpleado = conexion.prepareStatement(altaEmpleado,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedEmpleado.setInt(1, getNumero());
            preparedEmpleado.setString(2, getNombre());
            preparedEmpleado.setString(3, getPrimerApell());
            preparedEmpleado.setString(4, getSegApell());
            preparedEmpleado.setInt(5, getSupervisor());
            preparedEmpleado.setInt(6, puesto.getClave());

            preparedEmpleado.executeUpdate();
            System.out.println("Empleado registrado con exito");
        } catch (SQLException e) {
            System.out.println("No se pudo dar de alta al empleado"+e);
    }
    }


public void consultarEmpleado(int empleado){
    String consultaSQL = "SELECT " +
            "e.numero as Número, " +
            "CONCAT(e.nombre, ' ', e.primerApellido, ' ', e.segundoApellido) AS empleado, " +
            "p.nombre as Puesto, " +
            "e.supervisor as Supervisor " +
            "FROM empleado AS e " +
            "INNER JOIN puesto AS p ON e.puesto = p.clave " +
            "WHERE e.numero = ?";

    try (Connection conexion = ConexionBD.getConnection();
        PreparedStatement psConsulta = conexion.prepareStatement(consultaSQL)) {

        // Establecer el parámetro en la consulta
        psConsulta.setInt(1, empleado);

        try (ResultSet resultSet = psConsulta.executeQuery()) {
            if (resultSet.next()) {
                String num = resultSet.getString("Número");
                String nombre = resultSet.getString("empleado");
                String puesto = resultSet.getString("Puesto");
                String supervisor = resultSet.getString("Supervisor");

                System.out.println("<---------------------DATOS DEl EMPLEADO---------------------->");
                System.out.println("Número de empleado: " + num);
                System.out.println("Nombre: "+nombre);
                System.out.println("Puesto: "+puesto);
                System.out.println("Supervisor: "+supervisor);
            } else {
                System.out.println("No se encontró un empleado con el número especificado.");
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al consultar al empleado: " + e.getMessage());
    }
}
    public void editarEmpleado(){
        Scanner s = new Scanner(System.in);
            String modificarEmp = "UPDATE empleado SET  supervisor = ?, puesto = ?  WHERE numero= ?";
            try(Connection conexion = ConexionBD.getConnection();
            PreparedStatement preparedEmp = conexion.prepareStatement(modificarEmp)){
                System.out.println("Ingrese el número del empleado que desea modificar:");
                numero = s.nextInt();
                consultarEmpleado(numero);
                System.out.println("¿Desea modificar la información del empleado? A=Si/ cualquier otra tecla=CANCELAR");
                char opc = s.next().charAt(0);
                if(opc == 'A'|| opc =='a'){
                    System.out.println("Ingrese el nuevo númerdo de empleado del supervisor:");
                    int supervisor = s.nextInt();
                    System.out.println("Ingrese la clave del nuevo puesto:");
                    int puesto = s.nextInt();

                    preparedEmp.setInt(1, supervisor);
                    preparedEmp.setInt(2, puesto);
                    preparedEmp.setInt(3, numero);

                    int filasAfectadas = preparedEmp.executeUpdate();


                if (filasAfectadas > 0) {
                System.out.println("Empleado modificado con éxito.");
                } else {
                System.out.println("No se encontró el empleado con el número especificado.");
                 }
            }
        }
             catch(SQLException e){
                System.out.println("Error al modificar empleado");
            }
    }

    public void bajaEmpleado(){
        Scanner s = new Scanner(System.in);
            String bajaEmp = "DELETE FROM empleado WHERE numero= ?";
            try(Connection conexion = ConexionBD.getConnection();
            PreparedStatement preparedEmp = conexion.prepareStatement(bajaEmp)){
                System.out.println("Ingrese el número del empleado que desea dar de baja:");
                numero = s.nextInt();
                consultarEmpleado(numero);
                System.out.println("¿Desea dar de baja este empleado? A=Si/ cualquier otra tecla=CANCELAR");
                char opc = s.next().charAt(0);
                if(opc == 'A'|| opc =='a'){
                    
                    preparedEmp.setInt(1, numero);
                    preparedEmp.executeUpdate();

                    System.out.println("Empleado eliminado con exito");
                
            }
        }
             catch(SQLException e){
                System.out.println("Error al modificar empleado");
            }
    }

}