package pruebapractica.pkg2;

import java.util.Random;
public class Libro {

    static String Nombre;
    String Autor;
    int ID;
    String estado; 
    String dueno;
    static Random rndm = new Random();

    public Libro(String Nombre, String Autor) {
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.ID = rndm.nextInt(100);
        this.estado = "disponible";
        this.dueno = "";
    }
    
            
    public void Prestar (String NamePersona){
        if (estado.equalsIgnoreCase("disponible")){
            estado="prestado";
            dueno = NamePersona;
        }else {
            System.out.println("El libro no esta disponible");
        }
    }
    
    public void Regresar (){
        if (estado.equalsIgnoreCase("prestado")){
            estado="disponible";
            dueno = "";
        }else{
            System.out.println("El libro no esta prestado");
        }
    }

    public static String getNombre() {
        return Nombre;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Libro{" + "Autor=" + Autor + ", ID=" + ID + ", estado=" + estado + ", dueno=" + dueno + '}';
    }
    
    
}
