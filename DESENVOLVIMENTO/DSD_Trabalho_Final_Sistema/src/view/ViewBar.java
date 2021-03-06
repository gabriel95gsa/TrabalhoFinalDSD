package view;

import assets.Bartender;
import assets.Cliente;
import assets.Garcom;
import assets.MenuBebida;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @authores Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 * Singleton aplicado para a criação do objeto da classe
 */
public class ViewBar extends javax.swing.JInternalFrame {
    
    private static ViewBar telaAplicacao;
    private MenuBebida menu;
    
    private ViewBar() {
        this.menu = new MenuBebida();
        initComponents();
    }
    
    /**
     * método que verifica se tela aplicacao ja esta aberta, caso contrário, cria uma nova
     * 
     * @return - retorna uma nova instancia caso a tela não ter sido aberta
     */
    public static ViewBar getInstanciaAplicacao() {
        if (telaAplicacao == null) {
            telaAplicacao = new ViewBar();
        }
        return telaAplicacao;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputNroBartenders = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputNroGarcons = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputNroClientes = new javax.swing.JTextField();
        botaoComecar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLogs = new javax.swing.JTable();

        setClosable(true);
        setTitle("Bar");

        jLabel1.setText("Nº de cachaceiros");

        jLabel2.setText("Nº de garçons");

        jLabel3.setText("Nº de bartenders");

        botaoComecar.setText("Começar");
        botaoComecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComecarActionPerformed(evt);
            }
        });

        tabelaLogs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Logs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaLogs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputNroClientes)
                            .addComponent(inputNroBartenders)
                            .addComponent(inputNroGarcons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botaoComecar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(inputNroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputNroGarcons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputNroBartenders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addComponent(botaoComecar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoComecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComecarActionPerformed
        // validações dos campos
        if (this.inputNroClientes.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o número de clientes");
            return;
        }
        if (this.inputNroGarcons.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o número de garçons");
            return;
        }
        if (this.inputNroBartenders.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o número de bartenders");
            return;
        }
        
        // cria objeto para manipular a tabela de logs e a sua thread
        TabelaLogs t = new TabelaLogs((DefaultTableModel)tabelaLogs.getModel(), botaoComecar);
        Thread threadTabela = new Thread(t);
        threadTabela.setDaemon(true);
        threadTabela.start();
        
        // cria lista de bartenders de acordo com o informado no input
        List<Bartender> bartenders = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(this.inputNroBartenders.getText()); i++) {
            bartenders.add(new Bartender("Bartender " + i));
        }
        // cria lista de garçons de acordo com o informado no input
        List<Garcom> garcons = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(this.inputNroGarcons.getText()); i++) {
            garcons.add(new Garcom(bartenders, "Garçom " + i));
        }
        // cria lista de clientes de acordo com o informado no input
        for (int i = 1; i <= Integer.parseInt(this.inputNroClientes.getText()); i++) {
            Cliente oCliente = new Cliente(garcons, this.menu);
            
            Thread cliente = new Thread(oCliente, "Cliente" + i);
            
            if(oCliente.isVip() == true) {
                cliente.setPriority(Thread.MAX_PRIORITY);
            }
            
            cliente.start();
        }
    }//GEN-LAST:event_botaoComecarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoComecar;
    private javax.swing.JTextField inputNroBartenders;
    private javax.swing.JTextField inputNroClientes;
    private javax.swing.JTextField inputNroGarcons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLogs;
    // End of variables declaration//GEN-END:variables
}
