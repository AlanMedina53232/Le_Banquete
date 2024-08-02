package Banquete;

public class Persona {
    private String nombre;
    private String primerApell;
    private String segApell;
    private String numTel;
    private String email;

public Persona(){
}

public String getNombre(){
    return nombre;
}
public void setNombre(String nombre){
    this.nombre = nombre;
}

public String getPrimerApell(){
    return primerApell;
}
public void setPrimerApell(String primerApell){
    this.primerApell = primerApell;
}

public String getSegApell(){
    return segApell;
}
public void setSegApell(String segApell){
    this.segApell = segApell;
}

public String getNumtel(){
    return numTel;
}
public void setNumtel(String numTel){
    this.numTel = numTel;
}

public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email = email;
}
}
