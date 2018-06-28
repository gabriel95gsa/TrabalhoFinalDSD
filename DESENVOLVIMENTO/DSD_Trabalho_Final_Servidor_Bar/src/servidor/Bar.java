package servidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Bar implements InterfaceRemotaBar {

    private InterfaceRemotaBD repositorioBD;
    
    public Bar() {
        try {
            this.repositorioBD = (InterfaceRemotaBD) Naming.lookup("rmi://0.0.0.0:1541/ServidorBD");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void gravarLog(String log) throws RemoteException {
        this.repositorioBD.gravarLog(log);
    }

    @Override
    public boolean getDisponibilidadeBebida(String bebida) throws RemoteException {
        return this.repositorioBD.getDisponibilidadeBebida(bebida);
    }

    @Override
    public void retiraDoseBebida(String bebida) throws RemoteException {
        this.repositorioBD.retiraDoseBebida(bebida);
    }
    
}
