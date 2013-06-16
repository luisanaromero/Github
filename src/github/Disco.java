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
public class Disco extends Obra
{
    private String discografia;
    private int nCanciones;
    private List<Artista> autores;
    private char resp='S';
    
    /** Crea una instancia de Disco */
    public Disco(){}
    
    public Disco(String titulo, Artista autor, int añoEdicion, String discografia, int nCanciones)
    {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setAñoEdicion(añoEdicion);
        this.discografia = discografia;
        this.nCanciones = nCanciones;
    }

    public void registrardiscos(List<Artista> artistas)
    {
       if(artistas==null || artistas.size()==0)
       {
           System.out.println("No puede crear Discos hasta tener al menos un artista");
           return;
       }
       BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));
       try{
            System.out.println("Ingrese el Título del albúm: ");
            this.setTitulo(entrada.readLine());
            boolean valido=false;
            int cancion=0;            
            while(!valido)
            {
              System.out.println("Ingrese Canción: ");
              try{
                cancion=Integer.parseInt(entrada.readLine().trim());
                this.setAñoEdicion(cancion);
                valido=true;
              }catch(Exception e){
                  System.out.println("Dato errado");
              }
            }
            valido=false;
            int limit=artistas.size();
            while(!valido)
            {
                System.out.println("Elija Autor de la canción: ");
                int i=1;
                for (Artista artista: artistas)
                {
                    System.out.println(i+" - "+artista.getNombre());
                    i++;
                }
               try{
                    cancion=Integer.parseInt(entrada.readLine().trim());
                    if(cancion>0 && cancion<=limit)
                    {
                        this.setAutor(artistas.get(cancion-1));
                        valido=true;
                    }
                    else
                    {
                        System.out.println("Dato errado");
                    }          
                }catch(Exception e){
                    System.out.println("Dato errado");
                }
            }
            System.out.println("Ingrese el nombre de Discografía: ");
            this.setDiscografia(entrada.readLine());
            System.out.println("Ingrese número de Canciones del albúm: ");
            valido=false;
            while(!valido)
            {    
                  try{
                     cancion=Integer.parseInt(entrada.readLine().trim());
                     valido=true;  
                     this.setNCanciones(cancion);
                  }catch(Exception e){
                  System.out.println("Dato Errado");
                  valido=false;
                  }
            }       
       }catch(Exception e){}
    }
    // Busqueda de discos
    public List<Disco> buscardiscos (List<Disco> discos, String buscar)
    {
        List<Disco> resultados = new ArrayList<Disco>();
        for (Disco disco: discos) 
        {
            if (disco.getTitulo().compareToIgnoreCase(buscar) == 0 || disco.getAutor().getNombre().compareToIgnoreCase(buscar) == 0 )
            {
                resultados.add(disco);
            }
        }        
        return resultados;
    }
    public void imprimirdiscos(List<Disco> discos)
    {
        if(discos.size()>0)
        {
            for (Disco disco : discos) 
            {
                disco.imprimir();
            }
        }
    }
    // Búsqueda de discografia
    public List<Disco> disco_discografia( String titulo, List<Disco> discos)
    {
        List<Disco> encontrados=new ArrayList<Disco>();

        if(discos!=null)
        {
            for (Disco disco : discos) 
            {
                if(disco.getDiscografia().compareToIgnoreCase(titulo)==0 )
                {
                    encontrados.add(disco);
                }
            }
        }
        return encontrados;
    }
    // busqueda por canciones
    public List<Disco> disco_canciones( String cancion, List<Disco> discos)
    {
        List<Disco> encontrados=new ArrayList<Disco>();
        if(discos!=null)
        {
            for (Disco disco : discos)
            {
                if(disco.getDiscografia().compareToIgnoreCase(cancion)==0 )
                {
                    encontrados.add(disco);
                }
            }
        }
    return encontrados;
    }
    public void imprimir()
    {
        super.imprimirobra();
        System.out.println("\t Discografia: "+this.getDiscografia()+"\tNúmero de Canciones: "+this.getNCanciones()); 
     }
    //Funcion para obtener la discografia
    public String getDiscografia()
    {
        return this.discografia;
    }    
    //Funcion para almacenar la discografia
    public void setDiscografia(String discografia)
    {
        this.discografia = discografia;
    }
    
    //Funcion para obtener el numero de canciones
    public int getNCanciones()
    {
        return this.nCanciones;
    }
    
    //Funcion para almacenar el numero de canciones
    public void setNCanciones(int nCanciones)
    {
        this.nCanciones = nCanciones;
    }
}
