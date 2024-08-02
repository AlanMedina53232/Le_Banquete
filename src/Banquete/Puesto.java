package Banquete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Puesto {
    private int clave;
    private String nombre;

    public Puesto(){

    }

    public void setClave(int clave) {
        this.clave = clave;
    }
    public int getClave() {
        return clave;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
public void consultarPuesto(int clave){
    String consultaSQL ="SELECT " +
            "p.clave as Número, " +
            "p.nombre as Puesto " +
            "from puesto as p " +
            "where p.clave=? ";

    try (Connection conexion = ConexionBD.getConnection();
        PreparedStatement psConsulta = conexion.prepareStatement(consultaSQL)) {

        // Establecer el parámetro en la consulta
        psConsulta.setInt(1, clave);

        try (ResultSet resultSet = psConsulta.executeQuery()) {
            if (resultSet.next()) {
                String numero = resultSet.getString("Número");
                String nombre = resultSet.getString("Puesto");

                System.out.println("<---------------------DATOS DEL PUESTO---------------------->");
                System.out.println("numero: " +numero);
                System.out.println("Puesto: " +nombre);
            } else {
                System.out.println("No se encontró un puesto con el número especificado.");
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al consultar el puesto: " + e.getMessage());
    }
}


}


