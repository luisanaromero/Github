﻿/*
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
                    menulibro();
                    break;
                case 2://disco
                    menudisco();
                    break;
                case 3:
                    System.out.println("Retorno al Menú Principal");
                    return;
                default: 
                    System.out.println("Opción Errada");
            };
            
        }    
    } 
    ////////////////////////  Submenu Libro
    public void menulibro() throws IOException
    {
        int opc = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        
        while (opc != 4)
        {
            System.out.println("***** SubMenu Libro *****");
            System.out.println("1. Cargar Libro");
            System.out.println("2. Buscar Libro");
            System.out.println("3. Listar Libros");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción: ");

            try {
                opc = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            
            switch(opc)
            {
                case 1: 
                    libro.registrarlibros(autor);
                    libros.add(libro);
                    libro = new Libro();
                    break;
                case 2:
                    consultarlibro();
                    break;
                case 3:
                    libro.imprimirlibros(libros);
                    break;
                case 4: 
                    System.out.println("Retorno al Menú Principal");
                    return;
                default: 
                    System.out.println("Opción Errada");
            }
        }  
    
    }
    public void consultarlibro() throws IOException
    {
        int opc = 0;
        String titulo;
        List<Libro> libros_listados;
        int numpaginas;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        while (opc != 3)
        {
            System.out.println("***** Consultar Libros ** ");
            System.out.println("1. Por Título");
            System.out.println("2. Por Editorial");
            System.out.println("3. Por Número de Páginas");
            try {
                opc = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            switch(opc)
            {                        
                case 1:
                    System.out.println("Introduzca el título a consultar:");
                    titulo = entrada.readLine();
                    libros_listados = libro.buscarlibros(libros, titulo);
                    if(libros_listados == null || libros_listados.isEmpty())
                    {
                           System.out.println("No se encontro ningun libro con ese nombre.");
                    }
                    else
                    {
                        libro.imprimirlibros(libros_listados);
                    }
                    break;
                case 2:
                    System.out.println("Introduzca la editorial a consultar:");
                    titulo = entrada.readLine();
                    libros_listados = libro.libro_editorial(libros, titulo);
                    if(libros_listados == null || libros_listados.isEmpty())
                    {
                           System.out.println("No se encontro ningun libro con esa editorial.");
                    }
                    else
                    {
                        libro.imprimirlibros(libros_listados);
                    }
                    break; 
                case 3:
                    System.out.println("Introduzca un Número de Páginas a consultar:");
                    try {
                        numpaginas = Integer.parseInt(entrada.readLine());
                        libros_listados = libro.libros_numpaginas(libros, String.valueOf(numpaginas));
                        if(libros_listados == null || libros_listados.isEmpty())
                        {
                               System.out.println("No se encontro ningun libro con ese número de páginas.");
                        }
                        else
                        {
                            libro.imprimirlibros(libros_listados);
                        }
                    } catch (NumberFormatException ex) {
                        numpaginas = 0;     
                        System.out.println("Dato errado");
                    }
                    break; 
                default: 
                    System.out.println("Opción Errada");
            };
        }
    }
    ////////////////////////  Submenu Disco
    public void menudisco() throws IOException
    {
        int opc = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        
        while (opc != 4)
        {
            System.out.println("***** SubMenú Disco *****");
            System.out.println("1. Cargar Disco");
            System.out.println("2. Consultar Disco");
            System.out.println("3. Listar Discos");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción: ");

            try {
                opc = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            
            switch(opc)
            {
                case 1: 
                    disco.registrardiscos(autor);
                    discos.add(disco);
                    disco = new Disco();
                    break;
                case 2:
                    consultardisco();
                    break;
                case 3:
                    disco.imprimirdiscos(discos);
                    break;
                case 4: 
                    System.out.println("Retorno al Menú Principal");
                    return;
                default: 
                    System.out.println("Opción Errada");
            }
        }      
    }
    public void consultardisco() throws IOException
    {
        int opc = 0;
        String titulo;
        List<Disco> discos_listados;
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
        while (opc != 3)
        {
            System.out.println("***** Consultar Disco *****");
            System.out.println("1. Por Título  ");
            System.out.println("2. Por Discografía");
            System.out.println("3. Por Canciones");
            try {
                opc = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            switch(opc)
            {                        
                case 1:
                    System.out.println("Introduzca el Título del album:");
                    titulo = entrada.readLine();
                    discos_listados = disco.buscardiscos(discos, titulo);
                    if(discos_listados == null || discos_listados.isEmpty())
                    {
                           System.out.println("No se encontro ningun disco con ese titulo.");
                    }
                    else
                    {
                        disco.imprimirdiscos(discos_listados);
                    }
                    break;
                case 2:
                    System.out.println("Introduzca un nombre para buscar por Discografia:");
                    titulo = entrada.readLine();
                    discos_listados = disco.disco_discografia(titulo, discos);
                    if(discos_listados == null || discos_listados.isEmpty())
                    {
                           System.out.println("No se encontro ningun libro con esa editorial.");
                    }
                    else
                    {
                        disco.imprimirdiscos(discos_listados);
                    }
                    break; 
                case 3:
                    System.out.println("Introduzca un nombre para buscar por Discografia:");
                    titulo = entrada.readLine();
                    discos_listados = disco.disco_canciones(titulo, discos);
                    if(discos_listados == null || discos_listados.isEmpty())
                    {
                           System.out.println("No se encontro ningun libro con esa editorial.");
                    }
                    else
                    {
                        disco.imprimirdiscos(discos_listados);
                    }
                    break; 
                default: 
                    System.out.println("Opción Errada");
            }            
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
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción: ");
            try {
                opc = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            switch(opc)
            {
                case 1: //registrar peliculas                    
                  pelicula.cargarDatos(artistas);
                    peliculas.add(pelicula);
                    pelicula = new Pelicula();
		  break;
                case 2: //buscar peliculas                   
             
                    subMenuBuscarPeliuclas();
                    break;
    
                case 3://listar peliculas                    
                    break;
                case 4: // buscar productora                    
                   pelicula.mostrarPeliculas(peliculas);
  
break;
                                 case 5:
                    System.out.println("Retorno al Menú Principal");
                    return;                       
                default: 
                    System.out.println("Opción Errada");
            }
        }  
   
    }    
    public void subMenuBuscarPeliuclas() throws IOException
    {
        int opc = 0;
        String tituloParaBuscar;
        List<Pelicula> peliculasEncontradas;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(entrada);
        while (opc != 3)
        {
            System.out.println("\n\t   ** Busquedas: ** ");
            System.out.println(" \t Por Titulo  ");
            System.out.println(" \t Por Prodcutora");
            System.out.println(" \t Por Autor");
            try {
                opc = Integer.parseInt(buf.readLine());
            } catch (NumberFormatException ex) {
                opc = 0;               
            }
            switch(opc)
            {                        
                case 1:
                    System.out.println("Introduzca un nombre para buscar por titulo:");
                    tituloParaBuscar = buf.readLine();
                    peliculasEncontradas = pelicula.buscarPeliculaPorTitulo(tituloParaBuscar, peliculas);
                    if(peliculasEncontradas == null || peliculasEncontradas.isEmpty())
                    {
                           System.out.println("No se encontro ninguna pelicula con ese nombre.");
                    }
                    else
                    {
                        pelicula.mostrarPeliculas(peliculasEncontradas);
                    }
                    break;
                case 2:
                    System.out.println("Introduzca un nombre para buscar por productora:");
                    tituloParaBuscar = buf.readLine();
                    peliculasEncontradas = pelicula.buscarPeliculaPorProductora(tituloParaBuscar, peliculas);
                    if(peliculasEncontradas == null || peliculasEncontradas.isEmpty())
                    {
                           System.out.println("No se encontro ningun libro con esa editorial.");
                    }
                    else
                    {
                    pelicula.mostrarPeliculas(peliculasEncontradas);
                    }
                    break; 
                case 3:
                    System.out.println("Introduzca un nombre para buscar por autor:");
                    tituloParaBuscar = buf.readLine();
                    peliculasEncontradas = pelicula.buscarPeliculaPorAutor(tituloParaBuscar, peliculas);
                    if(peliculasEncontradas == null || peliculasEncontradas.isEmpty())
                    {
                           System.out.println("No se encontro ningun libro con esa editorial.");
                    }
                    else
                    {
                        pelicula.mostrarPeliculas(peliculasEncontradas);
                    }
                    break; 
                default: 
                    System.out.println("\n  ** Opción Errada **");
            }            
        }    
    
    }
/////////////////////////////////////////////////////////////////////////
    ////////////////////////  Menu Reportes
   public void menuReportes() throws IOException
    {
        int crear_reporte = 0;
        String nombre_busqueda;
        List<Pelicula> resultado_busqueda;
	 List<Obra> resultado_busqueda1;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(entrada);
        while (crear_reporte != 5)
        {                    
            System.out.println("\n   ** Reportes **");
            System.out.println("   1. Lista de Obras");
            System.out.println("   2. Lista de Películas");
            System.out.println("   3. Busqueda obras por autor");
            System.out.println("   4. Busqueda películas por autor");
            System.out.println("   5. Volver al menu");
            System.out.print("   Ingrese la opción: ");

            try {
                crear_reporte = Integer.parseInt(buf.readLine());
            } catch (NumberFormatException ex) {
                crear_reporte = 0;               
            }
            switch(crear_reporte)
            {                        
                case 1:
                    System.out.println("     Listado de Obras  ");
                    System.out.println("        Listado de Libros  ");
                    libro.imprimirLibros(libros);
                    System.out.println("        Listado de Discos  ");
                    disco.imprimirDisco(discos)
                    break;
                case 2:
                    System.out.println("     Listado de Películas  ");
                    pelicula.mostrarPeliculas(peliculas);
                    break; 
                case 3:
                    System.out.println("     Buscar obras por autor ");
		    System.out.println("Introduzca un nombre de la obra:");
                    nombre_busqueda = buf.readLine();
                    resultado_busqueda1 = obra.buscarObraPorAutor(nombre_busqueda, obras);
                    if(resultado_busqueda1 == null || resultado_busqueda1.isEmpty())
                    {
                           System.out.println("No se encontro ninguna obra de ese autor.");
                    }
                    else
                    {
                        obra.mostrarObras(resultado_busqueda1);
                    }                                       
                    break;
                    break;
                case 4:
                    System.out.println("     Buscar películas por autor ");
                    System.out.println("Introduzca un nombre para buscar por autor:");
                    nombre_busqueda = buf.readLine();
                    resultado_busqueda = pelicula.buscarPeliculaPorAutor(nombre_busqueda, peliculas);
                    if(resultado_busqueda == null || resultado_busqueda.isEmpty())
                    {
                           System.out.println("No se encontro ninguna pelicula de ese autor.");
                    }
                    else
                    {
                        pelicula.mostrarPeliculas(resultado_busqueda);
                    }                                       
                    break;
                case 5:
                    System.out.println("\n  Volver al menu");
                    break;
                default: 
                    System.out.println("\n  ** Opción Errada **");
            };
        }
    }
    /////////////////////////////////////////////////////////////////////////    
}