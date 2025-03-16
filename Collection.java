import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Collection extends Remote {
    String getNombre() throws RemoteException;
    void setNombre(String nombre) throws RemoteException;
    int getNumeroLibros() throws RemoteException;
}
