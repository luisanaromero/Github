/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luisana
 */
public class Github 
{
    //variables globales
    public Artista artista;
    public ArrayList<Artista> autor;
    public Disco disco;
    public ArrayList<Disco> discos;
    public Libro libro;
    public ArrayList<Libro> libros;    
    public Pelicula pelicula;
    public ArrayList<Pelicula> peliculas;
    
    public Github()//constructor
    {
        artista = new Artista();
        autor = new ArrayList<Artista>();
        libro = new Libro();
        libros = new ArrayList<Libro>();
        disco = new Disco();
        discos = new ArrayList<Disco>();
        pelicula = new Pelicula();
        peliculas = new ArrayList<Pelicula>();
    }
    public void main(String[] args) throws IOException
    {
        int opc = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        
        while (opc != 5)
        {
            System.out.println("***** Menú *****");
            System.out.println("Seleccione una opción: ");
            System.out.println(" 1. Artista  ");
            System.out.println(" 2. Obra");
            System.out.println(" 3. Película");
            System.out.println(" 4. Reportes");
            System.out.println(" 5. Salir");
            System.out.print(" Ingrese la opción: ");
            try {
           
                opc = Integer.parseInt(entrada.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Github.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            switch(opc)
            {
                case 1:  //artista
                    autor_buscar();
                    break;
                case 2:  //obra
                      break;
                case 3:  // peliculas
                    break;
                case 4: // Reportes
                    break;
                case 5:
                    System.out.println("Finalizó");
                    break;
                default: 
                    System.out.println("Opción Errada");
            }
        }  
    }
    
    /////////////////////////////////// metodos de seleccion Menus
     public void autor_buscar() throws IOException
    {
        int opc = 0;
        String nombre;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        
        while (opc != 4)
        {
            System.out.println("***** Menu Artista *****");
            System.out.println(" 1. Registrar Autor  ");
            System.out.println(" 2. Buscar Autor");
            System.out.println(" 3. Listar todos los Autores");
            System.out.println(" 4. Salir");
            System.out.print(" Ingrese la opción: ");

            try {
           
                opc = Integer.parseInt(entrada.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Github.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            switch(opc)
            {
                case 1: // cargar
                    artista.registrautor(autor);
                    break;
                case 2:// Buscar
                    System.out.println("Introduzca el nombre del artista a consultar:");
                    nombre = entrada.readLine();
                    Artista autorconsultado = artista.buscarautor(nombre, autor);
                    if(autorconsultado == null)
                           System.out.println("No se encuentra registrado ese autor.");
                    else
                           autorconsultado.imprimirautor();                  
                    break;
                case 3: // Listar                   
                    artista.listarautores(autor);
                    break;                
                default: 
                    System.out.println("Opción Errada");
            }
        }  
    
    }
    
    
}
