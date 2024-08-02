package Banquete;
import java.sql.Date;
import java.sql.Time;

public class Reservacion{

    protected int folio;
    private String direccion;
    private int noCalle;
    private int cantCocineros;
    private int cantMeseros;
    private int cantPersonas;
    private int cantBarman;
    private double montoTotal;
    private Date fecha;
    private Time hora;
    private Tipo_evento tipoEvent;
    private Empleado empleado;
    private Cliente cliente;


   public Reservacion(){
    }

    public Reservacion (int folio, String direccion, int noCalle, int cantCocineros, int cantMeseros, int cantBarman, double montoTotal, Date fecha, Time hora){
        this.folio = folio;
        this.direccion = direccion;
        this.noCalle = noCalle;
        this.cantCocineros = cantCocineros;
        this.cantMeseros = cantMeseros;
        this.cantBarman = cantBarman;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int  getFolio (){
        return folio;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion (){
        return direccion;
    }
    
    public void setNoCalle (int noCalle){
        this.noCalle = noCalle;
    }

    public int getNoCalle (){
        return noCalle;
    }

    public void setCantCocineros (int cantCocineros){
        this.cantCocineros = cantCocineros;
    }

    public int getCantCocineros (){
        return cantCocineros;
    }

    public void setCantMeseros (int cantMeseros){
        this.cantMeseros = cantMeseros;
    }

    public int getCantMeseros (){
        return cantMeseros;
    }

    public void setCantBarman (int cantBarman){
        this.cantBarman = cantBarman;
    }
    
    public int  getCantBarman (){
        return cantBarman;
    }

    public void setFecha (Date fecha){
        this.fecha = fecha;
    }

    public Date getFecha (){
        return fecha;
    }

    public void setHora (Time hora){
        this.hora = hora;
    }

    public Time getHora (){
        return hora;
    }
    public double getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

}