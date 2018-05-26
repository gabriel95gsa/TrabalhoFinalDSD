package br.udesc.ceavi.deso.dsd.controller;

import br.udesc.ceavi.deso.dsd.dao.exceptions.NonexistentEntityException;
import br.udesc.ceavi.deso.dsd.model.Bebida;
import br.udesc.ceavi.deso.dsd.model.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateus A. Gomes
 */
public class Main {

    public static void main(String[] args) throws NonexistentEntityException, Exception {

//        INSTANCIANDO O CONTROLLER DE LOG 
        Controller_Log controller_Log = new Controller_Log();

//        INSTANCIANDO O CONTROLLER DE BEBIDAS 
        Controller_Bebida controller_Bebida = new Controller_Bebida();

//        CRIANDO UMA NOVA DESCRIÇÃO PARA O LOG          
        Log log  = new Log("Testando o novo LOG para registro de informações");
        Log log1 = new Log("Testando o novo LOG para registro de informações");
        Log log2 = new Log("Testando o novo LOG para registro de informações");
        Log log3 = new Log("Testando o novo LOG para registro de informações");
        
//        ADICIONANDO O LOG NO BANCO DE DADOS ATRAVÉS DO METODO DO CONTROLLER       
        controller_Log.adicionarLog(log);
        controller_Log.adicionarLog(log1);
        controller_Log.adicionarLog(log2);
        controller_Log.adicionarLog(log3);
        
//        CRIANDO UMA NOVA BEBIDA          
//        CONFORME O BANCO DE DADOS NÃO PODE HAVER DUAS BEBIDAS COM O MESMO NOME, O MENU DE UM BAR NÃO PERMITE 
        Bebida bebida  = new Bebida("Cerveja"       , 10);
        Bebida bebida1 = new Bebida("Refrigerante"  , 20);
        Bebida bebida2 = new Bebida("Suco"          , 30);
        Bebida bebida3 = new Bebida("Agua"          , 40);
       
//        ADICIONANDO A BEBIDA NO BANCO DE DADOS ATRAVÉS DO METODO DO CONTROLLER       
        controller_Bebida.adicionarBebida(bebida);
        controller_Bebida.adicionarBebida(bebida1);
        controller_Bebida.adicionarBebida(bebida2);
        controller_Bebida.adicionarBebida(bebida3);
        
//        ARRAY DE BEBIDAS
        List<Bebida> listaBebidas = new ArrayList();
        
//        ARRAY DE LOG
        List<Log> listaLogs = new ArrayList();

//        RETORNA LISTA DE BEBIDAS DO BANCO DE DADOS ATRAVÉS DO MÉTODO DO CONTROLLER       
        listaBebidas = controller_Bebida.retornaListaBebida();

//        RETORNA LISTA DE LOGS DO BANCO DE DADOS ATRAVÉS DO MÉTODO DO CONTROLLER       
        listaLogs = controller_Log.retornaListaLog();

//        IMPRIME TODAS AS BEBIDAS DA LISTA RETORNADA DO BANCO DE DADOS 
        for (int i = 0; i < listaBebidas.size(); i++) {
            String descricao = listaBebidas.get(i).getDescricao();
            System.out.println(descricao);
        }

//        IMPRIME TODAS AS LOGS DA LISTA RETORNADA DO BANCO DE DADOS 
        for (int i = 0; i < listaLogs.size(); i++) {
            String descricao = listaLogs.get(i).getDescricao();
            System.out.println(descricao);
        }
    }

}
