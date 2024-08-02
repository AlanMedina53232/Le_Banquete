package Banquete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

public class Cliente extends Persona{
    protected int numero;
    private String numTel;
    private String email;

    public Cliente (){

    }
    
    public int getNumero(){
        return numero;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getEmail (){
        return email;
    }
    public String getNumTel() {
        return numTel;
    }
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void altaCliente(){
        Scanner s = new Scanner(System.in);
        String verificarClienteSQL = "SELECT COUNT(*) FROM cliente WHERE nombre = ? AND primerApellido = ? AND segundoApellido = ? AND numTelefono = ? AND email = ?";
        String altaCliente =  "INSERT INTO cliente (numero, nombre, primerApellido, segundoApellido, numTelefono, email) VALUES (DEFAULT, ?, ?, ?, ?, ?)";
        try(Connection conexion = ConexionBD.getConnection();
        Statement statement = conexion.createStatement();
        PreparedStatement psVerificarCliente = conexion.prepareStatement(verificarClienteSQL);
        PreparedStatement preparedCliente = conexion.prepareStatement(altaCliente, PreparedStatement.RETURN_GENERATED_KEYS)){
            // Solicitar información del cliente al usuario
        System.out.print("Nombre: ");
        super.setNombre(s.nextLine());
        System.out.print("Primer Apellido: ");
        super.setPrimerApell(s.nextLine());
        System.out.print("Segundo Apellido: ");
        super.setSegApell(s.nextLine());
        System.out.print("Número de Teléfono: ");
        numTel = s.nextLine();
        System.out.print("Email: ");
        email =  s.nextLine();

        // Verificar si el cliente ya existe
        psVerificarCliente.setString(1, super.getNombre());
        psVerificarCliente.setString(2, super.getPrimerApell());
        psVerificarCliente.setString(3, super.getSegApell());
        psVerificarCliente.setString(4, numTel);
        psVerificarCliente.setString(5, email);

        ResultSet rs = psVerificarCliente.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        if (count > 0) {
            System.out.println("El cliente ya existe en la base de datos.");
        } else {

        // Establecer los parámetros de la consulta de cliente
        preparedCliente.setString(1, super.getNombre());
        preparedCliente.setString(2, super.getPrimerApell());
        preparedCliente.setString(3, super.getSegApell());
        preparedCliente.setString(4, numTel);
        preparedCliente.setString(5, email);

        int filasAfectadas = preparedCliente.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Cliente añadido con éxito.");

            // Obtener el ID del nuevo cliente
            ResultSet generatedKeys = preparedCliente.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idCliente = generatedKeys.getInt(1);
                System.out.println("Número del nuevo cliente: " + idCliente);
            }
        } else {
            System.out.println("Error al añadir el cliente.");
        }
        }
    }
     catch(SQLException e){
            System.out.println("Error al dar de alta cliente");
    }
}   
public void consultarCliente(int numero){

String consultaSQL = "SELECT " +
        "c.numero as Número, " +
        "CONCAT(c.nombre, ' ', c.primerApellido, ' ', c.segundoApellido) AS cliente, " +
        "c.numTelefono as telefono, " +
        "c.email as email " +
        "FROM cliente AS c " +
        "WHERE c.numero = ?";

try (Connection conexion = ConexionBD.getConnection();
    PreparedStatement psConsulta = conexion.prepareStatement(consultaSQL)) {

    // Establecer el parámetro en la consulta
    psConsulta.setInt(1, numero);

    try (ResultSet resultSet = psConsulta.executeQuery()) {
        if (resultSet.next()) {
            String num = resultSet.getString("Número");
            String nombre = resultSet.getString("cliente");
            String telefono = resultSet.getString("telefono");
            String email = resultSet.getString("email");

            System.out.println("<---------------------DATOS DEl CLIENTE---------------------->");
            System.out.println("Número de cliente: " + num);
            System.out.println("Nombre: "+nombre);
            System.out.println("Telefono: "+telefono);
            System.out.println("E-mail: "+email);
        } else {
            System.out.println("No se encontró un cliente con el número especificado.");
        }
    }

} catch (SQLException e) {
    System.out.println("Error al consultar al cliente: " + e.getMessage());
    }
}
}
















