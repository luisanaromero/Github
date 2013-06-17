/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelicula;


/**
 *
 * @author Milagros Mendez
 */
    
public class Pelicula extends Obra {
    private String productora;
    private List<Artista> interpretes;

    public Pelicula(){
        this.interpretes=new ArrayList<Artista>();
    }
    public List<Artista> getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(List<Artista> interpretes) {
        this.interpretes = interpretes;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public void agregarInterprete(Artista interprete){
        if(this.interpretes==null)
            this.interpretes=new ArrayList<Artista>();
        this.interpretes.add(interprete);
    }

    public List<Pelicula> buscarPeliculaPorTitulo( String titulo, List<Pelicula> peliculas){
        List<Pelicula> encontrados=new ArrayList<Pelicula>();

        if(peliculas!=null){
            for (Pelicula pelicula : peliculas) {
                if(pelicula.getTitulo().compareToIgnoreCase(titulo)==0 ){
                    encontrados.add(pelicula);
                }
            }
        }
        return encontrados;
    }
    public List<Pelicula> buscarPeliculaPorProductora( String productoraX, List<Pelicula> peliculas){
        List<Pelicula> encontrados=new ArrayList<Pelicula>();

        if(peliculas!=null){
            for (Pelicula pelicula : peliculas) {
                if(pelicula.getTitulo().compareToIgnoreCase(productoraX)==0 ){
                    encontrados.add(pelicula);
                }
            }
        }
        return encontrados;
    }
    
    public void listarProductoras( List<Pelicula> peliculas){
        

        if(peliculas!=null){
            for (Pelicula pelicula : peliculas) {
                System.out.println(" Productora : "+pelicula.getProductora());
            }
        }
        
    }
    
    public List<Pelicula> buscarPeliculaPorAutor( String autorX, List<Pelicula> peliculas){
        List<Pelicula> encontrados=new ArrayList<Pelicula>();

        if(peliculas!=null){
            for (Pelicula pelicula : peliculas) {
                if(pelicula.getAutor().getNombre().compareToIgnoreCase(autorX)==0 ){
                    encontrados.add(pelicula);
                }
            }
        }
        return encontrados;
    }

    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("\t Productora : "+this.productora);
        System.out.println("\t Interpretes : ");
        if(interpretes!=null){
            for (Artista artista : interpretes) {
               artista.mostrarDatosArtista();
            }
        }

    }

    public void mostrarPeliculas(List<Pelicula> peliculas){
        if(peliculas!=null && peliculas.size()>0){
            for (Pelicula pelicula : peliculas) {
                pelicula.mostrarDatos();
            }
        }else{
            System.out.println("No  hay peliculas");
        }
    }
    
    public void cargarDatos(List<Artista> artistas){
       if(artistas==null || artistas.size()==0)
       {
           System.out.println("\n No puede crear peliculas hasta tener al menos un artista");
           return;
       }
       InputStreamReader entrada = new InputStreamReader(System.in);
       BufferedReader buf = new BufferedReader(entrada);
       try{
       System.out.println("\t Ingrese titulo : ");
       this.setTitulo(buf.readLine());
       boolean valido=false;
       int ano=0;
       while(!valido){
         System.out.println("\t Ingrese A#o de Edicion ");
         try{
          ano=Integer.parseInt(buf.readLine().trim());
          this.setAnoEdicion(ano);
          valido=true;
         }catch(Exception e){
             System.out.println("\t Dato invalido");
         }
       }
       
       valido=false;
       int limit=artistas.size();
       while(!valido){
           System.out.println("Elija Autor de la pelicula");
           int iterador=1;
           for (Artista artista : artistas) {
               System.out.println(iterador+" - "+artista.getNombre());
               iterador++;
           }
           
          try{
          ano=Integer.parseInt(buf.readLine().trim());
          if(ano>0 && ano<=limit){
              this.setAutor(artistas.get(ano-1));
              valido=true;
          }else{
              System.out.println("\n valor invalido ");
          }
          
         }catch(Exception e){
             System.out.println("\t Dato invalido");
         }
           
       }
       
           System.out.println("\n Ingrese Productora ");
           this.setProductora(buf.readLine());
           
           System.out.println("\n Asocie interprete(s) a la pelicula ");
           valido=false;
           while(!valido){    
           System.out.println("asocie interpretes");
           int iterador=1;
           for (Artista artista : artistas) {
               System.out.println(iterador+" - "+artista.getNombre());
               iterador++;
           }
           
          try{
          ano=Integer.parseInt(buf.readLine().trim());
         
          if(ano>0 && ano<=limit){
            
              this.agregarInterprete(artistas.get(ano-1));
              
           //   valido=true;
          }else{
              System.out.println("\n Dato invalido");
          }
              System.out.println(" Asociar otro interprete ? S para Si cualquier otra letra para no");    
              String resp=buf.readLine().trim();
              if(resp.compareToIgnoreCase("S")!=0){
                  valido=true;
              }
          
         }catch(Exception e){
             System.out.println("\t Dato invalido");
         }
           
       }
       
       }catch(Exception e){
           
       }
    }

}
