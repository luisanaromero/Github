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
public class Libro extends Obra
{
    private String editorial;
    private int nPaginas;
    
    /** Crea una instancia de Libro */
    public Libro() { }
     /** Crea una instancia de Libro con parametros */
    public Libro(String titulo, Artista autor, int añoEdicion, String editorial, int nPaginas) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setAñoEdicion(añoEdicion);
        this.editorial = editorial;
        this.nPaginas = nPaginas;
    }

    public void registrarlibros(List<Artista> autores)
    {
       boolean valido=false;
       int año=0;
       if(autores==null || autores.size()==0)
       {
           System.out.println("No puede crear libros hasta tener al menos un artista");
           return;
       }
       BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
       try{
            System.out.println("Ingrese título del libro: ");
            this.setTitulo(entrada.readLine());
            while(!valido)
            {
              System.out.println("Ingrese Año de Edición: ");
              try{
               año=Integer.parseInt(entrada.readLine().trim());
               this.setAñoEdicion(año);
               valido=true;
              }catch(Exception e){
                  System.out.println("Dato Errado");
              }
            }
            valido=false;
            int limit=autores.size();
            while(!valido)
            {
                System.out.println("Elija Autor del libro: ");
                int i=1;
                for (Artista artista: autores)
                {
                    System.out.println(i+" - "+artista.getNombre());
                    i++;
                 }           
               try{
                     año=Integer.parseInt(entrada.readLine().trim());
                     if(año>0 && año<=limit)
                     {
                         this.setAutor(autores.get(año-1));
                         valido=true;
                     }
                     else{
                       System.out.println("Valor errado");
                     }
                 }catch(Exception e){
                     System.out.println("Valor errado");
                 }
            }
            System.out.println("Ingrese la Editorial: ");
            this.setEditorial(entrada.readLine());
            System.out.println("Ingrese Número de Páginas del libro: ");
            valido=false;
            while(!valido)
            {    
                try{
                    año=Integer.parseInt(entrada.readLine().trim());
                    valido=true;  
                    this.setNPaginas(año);
                }catch(Exception e){
                    System.out.println("Dato errado");
                    valido=false;
                }
            }
        }catch(Exception e){}
    }
    public List<Libro> buscarlibros (List<Libro> libros, String buscar)
    {
        List<Libro> resultados = new ArrayList<Libro>();
        for (Libro libro: libros)
        {
            if ((libro.getTitulo().compareToIgnoreCase(buscar) == 0) || (libro.getAutor().getNombre().compareToIgnoreCase(buscar) == 0 ))
            {
                resultados.add(libro);
            }
        }
        return resultados;
    }
    public void imprimirlibros(List<Libro> libros)
    {
        if(libros.size()>0)
        {
            for (Libro libro: libros) 
            {
                libro.imprimir();
            }
        }
    }
    public List<Libro> libro_editorial (List<Libro> libros, String buscar)
    {
        List<Libro> resultados = new ArrayList<Libro>();
        for (Libro libro: libros) {
            if (libro.getEditorial().compareToIgnoreCase(buscar) == 0 )
            {
                resultados.add(libro);
            }
        }
        return resultados;
    }
    public List<Libro> libros_numpaginas (List<Libro> libros, String buscar)
    {
        List<Libro> resultados = new ArrayList<Libro>();
        for (Libro libro: libros) {
            if (libro.getNPaginas() == Integer.parseInt(buscar) )
            {
                resultados.add(libro);
            }
        }
        return resultados;
    }
    public void imprimir()
    {
        super.imprimirobra();
        System.out.println("Editorial: "+this.getEditorial()+"\t Número de Páginas: "+this.getNPaginas());
    }
    public String getEditorial()
    {
        return this.editorial;
    }
    
    public void setEditorial(String editorial)
    {
        this.editorial =editorial;
    }
    
    public int getNPaginas()
    {
         return this.nPaginas;
    }
    
    public void setNPaginas(int nPaginas)
    {
        this.nPaginas = nPaginas;
    }    
}
