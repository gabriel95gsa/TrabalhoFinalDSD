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
    
    private void preencheTabelaBebida() {
        // INSTANCIANDO O CONTROLLER DE LOG 
        Controller_Log controller_Log = new Controller_Log();

        // INSTANCIANDO O CONTROLLER DE BEBIDAS 
        Controller_Bebida controller_Bebida = new Controller_Bebida();

        // CRIANDO UMA NOVA DESCRIÇÃO PARA O LOG          
        Log log  = new Log("Testando o novo LOG para registro de informações");
        Log log1 = new Log("Testando o novo LOG para registro de informações");
        Log log2 = new Log("Testando o novo LOG para registro de informações");
        Log log3 = new Log("Testando o novo LOG para registro de informações");
        
        // ADICIONANDO O LOG NO BANCO DE DADOS ATRAVÉS DO METODO DO CONTROLLER       
        controller_Log.adicionarLog(log);
        controller_Log.adicionarLog(log1);
        controller_Log.adicionarLog(log2);
        controller_Log.adicionarLog(log3);
        
        // CRIANDO UMA NOVA BEBIDA          
        // CONFORME O BANCO DE DADOS NÃO PODE HAVER DUAS BEBIDAS COM O MESMO NOME, O MENU DE UM BAR NÃO PERMITE 
        Bebida bebida  = new Bebida("Cerveja"       , 10);
        Bebida bebida1 = new Bebida("Refrigerante"  , 20);
        Bebida bebida2 = new Bebida("Suco"          , 30);
        Bebida bebida3 = new Bebida("Agua"          , 40);
       
        // ADICIONANDO A BEBIDA NO BANCO DE DADOS ATRAVÉS DO METODO DO CONTROLLER       
        controller_Bebida.adicionarBebida(bebida);
        controller_Bebida.adicionarBebida(bebida1);
        controller_Bebida.adicionarBebida(bebida2);
        controller_Bebida.adicionarBebida(bebida3);
        
        // ARRAY DE BEBIDAS
        List<Bebida> listaBebidas = new ArrayList();
        
        // ARRAY DE LOG
        List<Log> listaLogs = new ArrayList();

        // RETORNA LISTA DE BEBIDAS DO BANCO DE DADOS ATRAVÉS DO MÉTODO DO CONTROLLER       
        listaBebidas = controller_Bebida.retornaListaBebida();

        // RETORNA LISTA DE LOGS DO BANCO DE DADOS ATRAVÉS DO MÉTODO DO CONTROLLER       
        listaLogs = controller_Log.retornaListaLog();

        // IMPRIME TODAS AS BEBIDAS DA LISTA RETORNADA DO BANCO DE DADOS 
        for (int i = 0; i < listaBebidas.size(); i++) {
            String descricao = listaBebidas.get(i).getDescricao();
            System.out.println(descricao);
        }

        // IMPRIME TODAS AS LOGS DA LISTA RETORNADA DO BANCO DE DADOS 
        for (int i = 0; i < listaLogs.size(); i++) {
            String descricao = listaLogs.get(i).getDescricao();
            System.out.println(descricao);
        }
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
    
}
