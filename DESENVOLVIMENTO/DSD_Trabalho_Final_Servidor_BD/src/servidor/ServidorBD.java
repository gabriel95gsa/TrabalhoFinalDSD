package servidor;

import controller.Controller_Bebida;
import controller.Controller_Log;
import java.util.ArrayList;
import java.util.List;
import model.Bebida;
import model.Log;

/**
 *
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class ServidorBD implements InterfaceRemotaBD {

    private Controller_Log controllerLog;
    private Controller_Bebida controllerBebida;
    
    public ServidorBD() {
        this.controllerLog = new Controller_Log();
        this.controllerBebida = new Controller_Bebida();
    }

    /**
     * método(s) implementado(s) da(s) interface(s)
     */
    
    @Override
    public void gravarLog(String log) {
        this.controllerLog.adicionarLog(new Log(log));
    }

    @Override
    public boolean getDisponibilidadeBebida(String bebida) {
        if(this.controllerBebida.qtdDosesDisponiveis(bebida) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void retiraDoseBebida(String bebida) {
        this.controllerBebida.diminuiQtdDosesDisponiveis(bebida);
    }

    @Override
    public void excluirTodosLogs() {
        this.controllerLog.excluirTodosLogs();
    }

    @Override
    public List<String> getListaLogs() {
        return this.controllerLog.retornaListaLog();
    }
    
}
