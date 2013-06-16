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
            System.out.println("***** Menú Principal *****");           
            System.out.println("1. Artista");
            System.out.println("2. Obra");
            System.out.println("3. Película");
            System.out.println("4. Reportes");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción: ");
            try {
           
                opc = Integer.parseInt(entrada.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Github.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            switch(opc)
            {
                case 1:  //artista
                    menuautor();
                    break;
                case 2:  //obra
                    menuobra("Obra");  
                    break;
                case 3:  // peliculas
                    menupelicula();
                    break;
                case 4: // reportes
                    menureportes();
                    break;
                case 5:
                    System.out.println("Finalizó");
                    break;
                default: 
                    System.out.println("Opción Errada");
            }
        }  
    }
    
    /////////////////////////////////// metodos 
    /////////////////////////////////////////////////////////////////////////
    ////////////////////////  Menu Artista
     public void menuautor() throws IOException
    {
        int opc = 0;
        String nombre;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        
        while (opc != 4)
        {
            System.out.println("***** SubMenú Artista *****");
            System.out.println("1. Registrar Autor");
            System.out.println("2. Consultar Autor");
            System.out.println("3. Listar Autores");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción: ");

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
                case 4:
                    System.out.println("Retorno al Menú Principal");
                    return;
                default: 
                    System.out.println("Opción Errada");
            }
        }  
    
    }
    /////////////////////////////////////////////////////////////////////////
    ////////////////////////  Menu Obra
    public void menuobra(String men) throws IOException
    {
        int opc = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        while (opc != 3)
        {
            System.out.println("***** SubMenú Obra *****");
            System.out.println(men+": 1. Libro");
            System.out.println(men+": 2. Disco");
            System.out.println("\t3. Salir");
            System.out.print("Ingrese la opción: ");
            try {
                opc = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            switch(opc)
            {                        
                case 1://libro
                   
                    break;
                case 2://disco
                   
                    break;
                case 3:
                    System.out.println("Retorno al Menú Principal");
                    return;
                default: 
                    System.out.println("Opción Errada");
            };
            
        }    
    } 
    /////////////////////////////////////////////////////////////////////////
    ////////////////////////  Menu Peliculas
    public void menupelicula() throws IOException
    {
        int opc = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        
        while (opc != 5)
        {
            System.out.println("***** SubMenú Película *****");
            System.out.println("1. Registrar Película");
            System.out.println("2. Consultar Película");
            System.out.println("3. Listar Películas");
            System.out.println("4. Consultar Productora");
            System.out.println("5. Listar Productoras");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción: ");
            try {
                opc = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            switch(opc)
            {
                case 1: //registrar peliculas                    
                    break;
                case 2: //buscar peliculas                   
                    break;
                case 3://listar peliculas                    
                    break;
                case 4: // buscar productora                    
                    break;
                case 5: //listar productoras                    
                    break;
                 case 6:
                    System.out.println("Retorno al Menú Principal");
                    return;                       
                default: 
                    System.out.println("Opción Errada");
            }
        }  
   
    }    
    /////////////////////////////////////////////////////////////////////////
    ////////////////////////  Menu Reportes
    public void menureportes() throws IOException
    {
        int opc = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));  
        
        while (opc!= 5)
        {                    
            System.out.println("***** SubMenú Reportes *****");
            System.out.println("1. Listado de Obras");
            System.out.println("2. Listado de Películas");
            System.out.println("3. Buscar obras por autor");
            System.out.println("4. Buscar películas por autor");
            System.out.println("5. Volver al menu");
            System.out.print("   Ingrese la opción: ");
            try {
                opc = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            switch(opc)
            {                        
                case 1://listado de obras: discos y libros
                    break;
                case 2:// listado de películas  
                    break; 
                case 3://buscar obras por autor(nombre)
                    break;
                case 4://Buscar películas por autor(nombre) 
                    break;
                case 5:
                    System.out.println("Retorno al Menú Principal");
                    break;
                default: 
                    System.out.println("Opción Errada");
            };
        }
    }
    /////////////////////////////////////////////////////////////////////////    
}
