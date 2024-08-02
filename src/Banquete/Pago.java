package Banquete;

import java.sql.*;
import java.util.*;

public class Pago extends Reservacion{
    protected int clave;
    private int numPago;
    private String consepto;
    private double saldo;
    private double monto;
    private String fechaPago;
    
    public Pago(){

    }
    
    public int getClave() {
        return clave;
    }
    public int getNumPago() {
        return numPago;
    }
    public void setNumPago(int numPago) {
        this.numPago = numPago;
    }
    public String getConsepto() {
        return consepto;
    }
    public void setConsepto(String consepto) {
        this.consepto = consepto;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double motno) {
        this.monto = motno;
    }
    public String getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    public void consultarPago(int clave) {

        String consultaSQL = "SELECT " +
                "DATE_FORMAT(p.fechaDePago, '%d-%m-%y') AS fecha, " +
                "CONCAT(cl.nombre, ' ', cl.primerApellido, ' ', cl.segundoApellido) AS nombre, " +
                "p.clave AS clave, " +
                "p.numPago AS Número, " +
                "p.concePago AS Concepto, " +
                "p.saldoDePago AS Saldo, " +
                "p.montoDePago AS Monto, " +
                "p.reservacion AS reservacion " +
                "FROM pago AS p " +
                "INNER JOIN reservacion AS r ON p.reservacion = r.folio " +
                "INNER JOIN cliente AS cl ON r.cliente = cl.numero " +
                "WHERE p.clave = ?";
    
        try (Connection conexion = ConexionBD.getConnection();
            PreparedStatement psConsulta = conexion.prepareStatement(consultaSQL)) {
    
            // Establecer el parámetro en la consulta
            psConsulta.setInt(1, clave);
    
            try (ResultSet resultSet = psConsulta.executeQuery()) {
                if (resultSet.next()) {
                    int PagoClave = resultSet.getInt("clave");
                    int numPago = resultSet.getInt("Número");
                    String fechaPago = resultSet.getString("fecha");
                    String cliente = resultSet.getString("nombre");
                    String conceptoDePago = resultSet.getString("Concepto");
                    double montoPago = resultSet.getDouble("Monto");
                    double saldo = resultSet.getDouble("Saldo");
                    int reservacion = resultSet.getInt("reservacion");
    
                    System.out.println("<---------------------DATOS DEL PAGO---------------------->");
                    System.out.println("Clave del pago: " + PagoClave);
                    System.out.println("Número del pago: " + numPago);
                    System.out.println("Número de la reservación: " + reservacion);
                    System.out.println("Cliente: " + cliente);
                    System.out.println("Fecha de Pago: " + fechaPago);
                    System.out.println("Concepto del Pago: " + conceptoDePago);
                    System.out.println("Monto de pago: " + montoPago);
                    System.out.println("Saldo del cliente: " + saldo);
    
                } else {
                    System.out.println("No se encontró un pago con el número especificado.");
                }
            }
    
        } catch (SQLException e) {
            System.out.println("Error al consultar el pago: " + e.getMessage());
    }
    }
}
