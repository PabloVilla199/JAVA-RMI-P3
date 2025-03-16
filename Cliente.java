import java.rmi.Naming;
//import java.rmi.RemoteException;

public class Cliente {
    public static void main(String[] args) {
        try {
            String hostname = "IPremotehost"; // se puede usar "IP:puerto"
            Collection collection = (Collection) Naming.lookup(hostname+"/Coleccion");
            
            // Interactuar con el servidor
            System.out.println("Nombre de la colección: " + collection.getNombre());
            System.out.println("Número de libros: " + collection.getNumeroLibros());

            // Cambiar el nombre de la colección
            collection.setNombre("Colección Nueva");
            System.out.println("Nuevo nombre de la colección: " + collection.getNombre());
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}


    
