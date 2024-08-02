package Banquete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Paquete extends Tipo_paqu {
    protected int codigo;
    private String nombre;
    private float costo;

    public Paquete(){

    }

    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getCosto() {
        return costo;
    }
    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void altaPaquete() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Código: ");
            codigo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nombre: ");
            setNombre(scanner.nextLine());
            System.out.print("Costo: ");
            setCosto(scanner.nextFloat());
            scanner.nextLine();
        }

        String altaPaq = "INSERT INTO paquete (codigo, nombre, costo) VALUES (?, ?, ?)";
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement preparedPaquete = conexion.prepareStatement(altaPaq,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedPaquete.setInt(1, getCodigo());
            preparedPaquete.setString(2, getNombre());
            preparedPaquete.setFloat(3, getCosto());

            preparedPaquete.executeUpdate();
            System.out.println("El paquete se dio de alta con exito");

        } catch (SQLException e) {
            System.out.println("No se pudo dar de alta el paquete" + e);
    }
    }

}
