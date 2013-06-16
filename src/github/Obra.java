/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

/**
 *
 * @author Luisana
 */
public class Obra
{
    private String titulo;
    private Artista autor;
    private int añoEdicion;
    
    //Constructor sin parametros de la clase Obra
    public Obra(){}
    
    //Funcion para obtener el titulo de la obra
    public String getTitulo(){
        return this.titulo;
    }
    
    //Funcion para guardar el titulo de la obra
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    //Funcion para obtener el autor de la obra
    public Artista getAutor(){
        return this.autor;
    }
    
    //Funcion para guardar el autor de la obra
    public void setAutor(Artista autor){
        this.autor = autor;
    }
    
    //Funcion para obtener el ano de edicion de la obra
    public int getAnoEdicion(){
        return this.añoEdicion;
    }
    
    //Funcion para guardar el ano de edicion de la obra
    public void setAñoEdicion(int año){
        this.añoEdicion = año;
    }
    public void imprimirobra(){
        System.out.println("Título: "+this.titulo+"\tAutor: "+this.autor.getNombre()+"\tAño de Edición: "+this.añoEdicion);
    }
}
