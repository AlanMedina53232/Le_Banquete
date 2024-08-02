package Banquete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Tipo_paqu {
    private int codigo;
    private String nombre;

    public Tipo_paqu(){

    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getDescripcion() {
        return nombre;
    }
    public void setDescripcion(String nombre) {
        this.nombre = nombre;
    }
    

    public void altaTipo_paqu(){
        Tipo_paqu paquete = new Tipo_paqu();
        Scanner s = new Scanner(System.in);
        String altapaquete =  "INSERT INTO tipo_paquete (codigo, nombre) VALUES (?, ?)";
        try(Connection conexion = ConexionBD.getConnection();
        Statement statement = conexion.createStatement();
        PreparedStatement preparedTipo_paqu = conexion.prepareStatement(altapaquete)){
            // Solicitar información del tipo de paquete
        System.out.print("Código del tipo de paquete");
        codigo = s.nextInt();
        s.nextLine();
        System.out.print("Nombre del Tipo de paquete: ");
        nombre = s.nextLine();
        

        // Establecer los parámetros de la consulta del tipo de paquete
        preparedTipo_paqu.setInt(1, codigo);
        preparedTipo_paqu.setString(2, nombre);
            
        preparedTipo_paqu.executeUpdate();
        System.out.println("Paquete registrado exitosamente");    

        } catch(SQLException e){
            System.out.println("Error al dar de alta el tipo de paquete"+e);
    }
    
    }
    public void eliminarPaquete(){
        Scanner s = new Scanner(System.in);
            String cancelarpaq = "DELETE FROM tipo_paquete WHERE codigo=?";
            try(Connection conexion = ConexionBD.getConnection();
            PreparedStatement preparedPaquete = conexion.prepareStatement(cancelarpaq)){
                System.out.println("Ingrese el código del tipo de paquete que desea eliminar:");
                codigo = s.nextInt();
    
                consultarPaquete(codigo);
                System.out.println("¿Desea eliminar? A=Si/ cualquier otra tecla=CANCELAR");
                char opc = s.next().charAt(0);
                if(opc == 'A'|| opc =='a'){
                    preparedPaquete.setInt(1, codigo);
    
                    int filasAfectadas = preparedPaquete.executeUpdate();
    
            if (filasAfectadas > 0) {
                System.out.println("Tipo de paquete eliminado con éxito.");
             } else {
                System.out.println("No se encontró el tipo de paquete con el número especificado.");
            }
                }
    
            } catch(SQLException e){
                System.out.println("Error al modificar el tipo de paquete");
            }
        s.close();
        }
    public void consultarPaquete(int codigo){
        String consultaSQL ="SELECT " +
                "p.nombre as paquete, " +
                "c.descripcion as descripcion, " +
                "p.codigo as Número,"+
                "p.costo as Costo," +
                "tp.nombre as TipoPak " +
                "from paquete as p " +
                "inner join menu as m on p.codigo=m.paquete " +
                "inner join contenido as c on m.contenido=c.codigo " +
                "inner join tipo_paquete as tp on p.TipoPaquete=tp.codigo " +
                "where p.codigo=? ";
    
        try (Connection conexion = ConexionBD.getConnection();
            PreparedStatement psConsulta = conexion.prepareStatement(consultaSQL)) {
    
            // Establecer el parámetro en la consulta
            psConsulta.setInt(1, codigo);
    
            try (ResultSet resultSet = psConsulta.executeQuery()) {
                if (resultSet.next()) {
                    String numero = resultSet.getString("Número");
                    String nombre = resultSet.getString("Paquete");
                    String costo = resultSet.getString("Costo");
                    String TipoPak = resultSet.getString("TipoPak");
    
                    System.out.println("<---------------------DATOS DEL PAQUETE---------------------->");
                    System.out.println("numero: " +numero);
                    System.out.println("Paquete: " +nombre);
                    System.out.println("costo: " +costo);
                    System.out.println("Tipo de paquete: " +TipoPak);
                } else {
                    System.out.println("No se encontró un paquete con el número especificado.");
                }
            }
    
        } catch (SQLException e) {
            System.out.println("Error al consultar el paquete: " + e.getMessage());
        }
    }

    public void modificarPaquete(){
        Scanner s = new Scanner(System.in);
        String modificarPaquete = "UPDATE tipo_paquete SET codigo = ?, nombre = ?, WHERE codigo= ?";
        try(Connection conexion = ConexionBD.getConnection();
        PreparedStatement preparedPaquete = conexion.prepareStatement(modificarPaquete)){
            System.out.println("Ingrese el código del paquete que desea modificar (valores numéricos): ");
            codigo = s.nextInt();

            consultarPaquete(codigo);
            System.out.println("¿Desea modificar el nombre del Tipo de paquete? A=Si/ cualquier otra tecla=CANCELAR");
            char opc = s.next().charAt(0);
            if(opc == 'A'|| opc =='a'){
                s.nextLine();
                System.out.print("Ingrese el nuevo código del tipo de paquete (valores numéricos): ");
                codigo = s.nextInt();
                System.out.print("Ingrese el nuevo nombre del tipo de paquete: ");
                nombre = s.nextLine();

                preparedPaquete.setInt(1, codigo);
                preparedPaquete.setString(2, nombre);

                int filasAfectadas = preparedPaquete.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Tipo de paquete modificado con éxito.");
                 } else {
                    System.out.println("No se encontró el tipo de paquete con el número especificado.");
                }
                    }
        
                } catch(SQLException e){
                    System.out.println("Error al modificar el tipo de paquete");
                }
            s.close();
        }
        
}
