package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public interface InterfaceRemotaBD extends Remote {
    
    public void gravarLog(String log) throws RemoteException;
    
    public boolean getDisponibilidadeBebida(String bebida) throws RemoteException;
    
    public void retiraDoseBebida(String bebida) throws RemoteException;
    
    public void excluirTodosLogs() throws RemoteException;
    
    public List<String> getListaLogs() throws RemoteException;
    
}
