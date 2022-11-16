import java.io.FileWriter;
import java.io.PrintWriter;

public class TipoTanque{
    // arreglo 2x2 para guardar todo tipo de tanques
    public static TipoTanque tanques[][] = new TipoTanque[2][2];

    
    private int salud;
    private String nombre;

    
    public TipoTanque(int salud, String nombre){
        this.salud=salud;
        this.nombre=nombre;
    }


   
    public int getSalud() {
        return this.salud;
    }

    public String getNombre() {
        return this.nombre;
    }

    // setters 
    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
   
    public static void agregarTanque(TipoTanque tanque){
        boolean validacion = false;
        for(int x=0;x<2;x++){
            if(validacion){
                break;
            }else{
                for(int y=0;y<2;y++){
                    if(tanques[x][y]==null){
                        tanques[x][y] = tanque;
                        validacion=true;
                        break;
                    }
                }
            }
        }
    }

    public static void generarTanques(){
        int cantidadCreados = (int) (Math.random()*4+1);
        int tipoCreado;
        for(int i=1;i<=cantidadCreados;i++){
            tipoCreado = (int) (Math.random()*2+1);
            if(tipoCreado==1){
                agregarTanque(new TanqueNormal());
            }else if(tipoCreado==2){
                agregarTanque(new TanqueAlien());
            }
        }
    }


    // Infomacion para mostrar tablero
    // retorna la cantidad de tanque instanciados
    public static int tanquesEnLista(){
        int numEntrega = 0;
        for(int x=0;x<2;x++){
            for(int y=0;y<2;y++){
                if(!(tanques[x][y]==null)){
                    numEntrega ++;
                }
            }
        }
        return numEntrega;
    }

    // retorna el nombre y la  salud de un tanque en un solo String
     public String nombreTanque(){
        return this.nombre + "-" + this.salud;
    }

    // tablero del juego
    public static String tableroTankWars(){
        int numeroTanque = tanquesEnLista();
        String tablero = "";
        if(numeroTanque==1){
            tablero = "-------------\n"+
                    "|" + tanques[0][0].nombreTanque() +"|" +"     "+ "|\n"+
                    "-------------\n"+
                    "|" +"     "+"|" +"     "+ "|";
        }else if(numeroTanque==2){
            tablero = "-------------\n"+
                    "|" + tanques[0][0].nombreTanque() +"|" + tanques[0][1].nombreTanque()+ "|\n"+
                    "-------------\n"+
                    "|" +"     "+"|" +"     "+ "|";
        }else if(numeroTanque ==3){
            tablero = "-------------\n"+
                    "|" + tanques[0][0].nombreTanque() +"|" + tanques[0][1].nombreTanque()+ "|\n"+
                    "-------------\n"+
                    "|" +tanques[1][0].nombreTanque() +"|" +"     "+ "|";
        }else{
            tablero = "-------------\n"+
                    "|" + tanques[0][0].nombreTanque() +"|" + tanques[0][1].nombreTanque()+ "|\n"+
                    "-------------\n"+
                    "|" +tanques[1][0].nombreTanque() +"|" +tanques[1][1].nombreTanque()+ "|";
        }
        return tablero;
    }


    // metodo para dispara a un tanque especifico
    // obvia aquellos tanque muertos y las posiciones donde no hay tanques 
    public static void dispararBala(int posx, int posy){
        if(posx >=2 || posy >=2){
            System.out.println("\nLa posicion digitada no existe\n");
        }else if(tanques[posx][posy]==null){
            System.out.println("En esta posicion no exite un tanque");
        }else if(tanques[posx][posy].getSalud()>0){
            tanques[posx][posy].setSalud(tanques[posx][posy].getSalud()-5); // Aqui se ejecuta el ataque
        }else if(tanques[posx][posy].getSalud()<=0){
            System.out.println("El tanque ya esta muero");
        }
    }

    // metodo que vuelve 0 la vida de un tanque de forma aleatoria
    public static void bombaAtomica(){
        int posx;
        int posy;
        while(true){
            posx = (int) (Math.random()*2);
            posy = (int) (Math.random()*2);
            if(tanques[posx][posy]==null){
                continue;
            }else if(tanques[posx][posy].getSalud()>0){
                tanques[posx][posy].setSalud(0);
                break;
            }
        }
    } 


    /*
     * hace que el tanque con menos vida se le duplique esta
     * omite las posiciones sin tanque y los tanque muertos
     */
    public static void tanqueMutante(){
        int menor[] = new int[tanquesEnLista()];
        int num = 0;
        // primero se crea una lista con los datos de la salud de los tanque vivos
        for(int x=0;x<2;x++){
            for(int y=0;y<2;y++){
                if(!(tanques[x][y]==null) && tanques[x][y].getSalud()>0){
                    menor[num]= tanques[x][y].getSalud();
                    num++;
                }
            }
        }

        // Se busca en esa lista cual es el menor entre la lista de datos de sangre
        int menor2 = menor[0];
        for(int i=1;i < num;i++){
            if(menor[i]<menor2){
                menor2 = menor[i];
            }
        }

        // Se define cual es el tanque que tiene esa sangre, cuando se encuenta se duplica su sangre y sale del ciclo
        boolean validacion = false;
        for(int x=0;x<2;x++){
            if(validacion){
                break;
            }
            for(int y=0;y<2;y++){
                if(!(tanques[x][y]==null) && tanques[x][y].getSalud()==menor2){
                    tanques[x][y].setSalud(tanques[x][y].getSalud()*2);
                    validacion = true;
                    break;
                }
            }
        }
    }

    public static String mensajeAbuela(){
        return "Me gusta la aguapanela";
    }

    
    // guarda los datos de la sangre en un archivo de tipo txt en un momento determinado
    public static void guardarSangreTXT(){
        try {
            PrintWriter archivo = new PrintWriter(new FileWriter("sangre.txt"));
            
            for(int x = 0;x<2;x++){
                for(int y = 0;y<2;y++){
                    if(!(tanques[x][y]==null)){
                        archivo.println(tanques[x][y].getNombre() + " " + tanques[x][y].getSalud());
                    }
                }
            }
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al guardar en el archivo" + e);
        }
    }

    // retorna un String con la sangre en un momento determinado 
    public static String leerSangre(){
        String salida = "";
        for(int x = 0;x<2;x++){
            for(int y = 0;y<2;y++){
                if(!(tanques[x][y]==null)){
                   salida += tanques[x][y].getNombre() + " " + tanques[x][y].getSalud() ;
                }
            }
        }

        return salida;
    }

    // retorna un numero con la cantidad de tanque muertos
    public static int muertos(){
        int muertos = 0;
        for(int x = 0;x<2;x++){
            for(int y = 0;y<2;y++){
                if(!(TipoTanque.tanques[x][y]==null) && TipoTanque.tanques[x][y].getSalud()<=0){
                    muertos++;
                }
            }
        }

        return muertos;
    }


}