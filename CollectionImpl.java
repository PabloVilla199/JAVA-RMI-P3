import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CollectionImpl extends UnicastRemoteObject implements Collection {
    private String nombre;
    private int numeroLibros;

    public CollectionImpl() throws RemoteException {
        super();
        this.nombre = "Colección de Ejemplo";
        this.numeroLibros = 100;
    }

    @Override
    public String getNombre() throws RemoteException {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) throws RemoteException {
        this.nombre = nombre;
    }

    @Override
    public int getNumeroLibros() throws RemoteException {
        return numeroLibros;
    }

    public static void main(String[] args) {
        // Fijar el directorio donde se encuentra el java.policy
        // El segundo argumento es la ruta al java.policy
        System.setProperty("java.security.policy", "./java.policy");
        // Crear administrador de seguridad
        // System.setSecurityManager(new SecurityManager()); // Deprecated, remove or replace with alternative

        // Nombre o IP del host donde reside el objeto servidor
        String hostName = "IPhostremoto"; // se puede usar "IPhostremoto:puerto"
        // Por defecto, RMI usa el puerto 1099
        try {
            // Crear objeto remoto
            CollectionImpl obj = new CollectionImpl();
            System.out.println("Creado!");
            // Registrar el objeto remoto
            Naming.rebind("//" + hostName + "/MyCollection", obj);
            System.out.println("Estoy registrado!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
