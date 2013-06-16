/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github;
import java.io.*;
import java.util.*;
/**
 *
 * @author Luisana
 */
public class Artista
{
    private String nombre;    
    private int añoNacimiento;       
    private char resp='S';   
    //Contructor sin parametros de la clase Artista
    public Artista(){}
    
    //Constructor con parametros de la clase Artista
    public Artista(String nom, int ano)
    {
        this.nombre = nom;
        this.añoNacimiento = ano;
    }
    
    //Funcion para obtener el ano de nacimiento del autor
    public int getAnoNacimiento()
    {
        return this.añoNacimiento;
    }
    
    //Funcion para almacenar el ano de nacimiento del autor
    public void setAnoNacimiento(int ano)
    {
        this.añoNacimiento = ano;
    }
    
    //Funcion para obtener el nombre del autor
    public String getNombre()
    {
        return this.nombre;
    }
    
    //Funcion para guardar el nombre del autor
    public void setNombre(String nom)
    {
        this.nombre = nom;
    }
    
    //Funcion para registar autor
    public void registrautor(List<Artista> autores) throws IOException
    {
       String nom;
       int ano=0;
       BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
       
       if(autores == null){
           autores = new ArrayList<Artista>();
       }              
       do{
            System.out.print("Ingrese el nombre del autor: ");
            nom = entrada.readLine();
            System.out.print("Ingrese el año de nacimiento del autor: ");
            try {
                ano = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
            System.out.println("  Error el año de nacimiento, intentelo de nuevo.");
            }
            Artista artista = new Artista(nom,ano);
            autores.add(artista);
            System.out.println("Desea agregar otro artista? S/N");
            resp = entrada.readLine().toUpperCase().charAt(0);
       } while(resp=='S');       
    }
    //Funcion para registar autor
    public Artista buscarautor(String nom, List<Artista> autores)
    {
      for(Artista aut:autores)
      {
           if(aut.nombre.equals(nom))
            return aut;  
       }
      return null;
    }

    public void imprimirautor()
    {
        System.out.println("\t Autor: "+this.nombre+"\tAño de Nacimiento: "+this.añoNacimiento);
    }
   
    public void listarautores(List<Artista> autores)
    {
    
        for(Artista aut:autores){
            System.out.println("\tAutor: "+aut.nombre+"\tAño de Nacimiento: "+aut.añoNacimiento);
        }
    }
}
