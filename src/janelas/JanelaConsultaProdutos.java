/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;


import entidades.Produto;
import inicio.BuscaProduto;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Banco;

/**
 *
 * @author Bruno
 */
public class JanelaConsultaProdutos extends javax.swing.JDialog {
    
    private Produto produto = null;
    private List<Produto> lista;
    private JFrame pai;
        
    /**
     * Creates new form JanelaConsultaProdutos
     * @param parent
     * @param modal
     */
    public JanelaConsultaProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.pai = (JFrame) parent;
        //produto = new Produto();
        this.setLocationRelativeTo(null);

        //this.buscarProduto();
        this.jChave.requestFocus();
        //jbutaoExcluir.setVisible(false);
        jTabelaPesquisa.setAutoCreateRowSorter(true);
        jbutaoadd.setVisible(false);
    }
    
    public JanelaConsultaProdutos(java.awt.Frame parent, boolean modal, Produto produto) {
        super(parent, modal);
        initComponents();
        
        this.pai = (JFrame) parent;
        //produto = new Produto();
        this.setLocationRelativeTo(null);

        //this.buscarProduto();
        this.jChave.requestFocus();
        //jbutaoExcluir.setVisible(false);
        jTabelaPesquisa.setAutoCreateRowSorter(true);
        jbutaoEditar.setVisible(false);
        jbutaoExcluir.setVisible(false);
        this.produto = produto;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jChave = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaPesquisa = new javax.swing.JTable();
        jbutaoEditar = new javax.swing.JButton();
        jbutaoExcluir = new javax.swing.JButton();
        jbutaoadd = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA DE PRODUTOS");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa por Nome"));
        jPanel1.setToolTipText("Pesquisa");

        jChave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChaveActionPerformed(evt);
            }
        });
        jChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jChaveKeyPressed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisa2.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jChave, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

        jTabelaPesquisa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTabelaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Descrição", "Preço", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaPesquisa.setColumnSelectionAllowed(true);
        jTabelaPesquisa.setRowHeight(22);
        jTabelaPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabelaPesquisaFocusGained(evt);
            }
        });
        jTabelaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPesquisaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabelaPesquisaMouseEntered(evt);
            }
        });
        jTabelaPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabelaPesquisaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaPesquisa);
        jTabelaPesquisa.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTabelaPesquisa.getColumnModel().getColumnCount() > 0) {
            jTabelaPesquisa.getColumnModel().getColumn(0).setResizable(false);
            jTabelaPesquisa.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTabelaPesquisa.getColumnModel().getColumn(1).setResizable(false);
            jTabelaPesquisa.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTabelaPesquisa.getColumnModel().getColumn(2).setResizable(false);
            jTabelaPesquisa.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTabelaPesquisa.getColumnModel().getColumn(3).setResizable(false);
            jTabelaPesquisa.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbutaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Editar2.png"))); // NOI18N
        jbutaoEditar.setText("EDITAR");
        jbutaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutaoEditarActionPerformed(evt);
            }
        });

        jbutaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lixeira2.png"))); // NOI18N
        jbutaoExcluir.setText("EXCLUIR");
        jbutaoExcluir.setToolTipText("");
        jbutaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutaoExcluirActionPerformed(evt);
            }
        });

        jbutaoadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jbutaoadd.setText("Adicionar");
        jbutaoadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutaoaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbutaoEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbutaoExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbutaoadd))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbutaoExcluir)
                            .addComponent(jbutaoEditar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbutaoadd)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.buscarProduto();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTabelaPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesquisaMouseClicked
//        if(evt.getClickCount() == 2){
//            if(produto == null){
//                //if(!FachadaControle.getFachadaControle().getUsuarioLogado().getTipo().equals(Usuario.TIPO_VENDEDOR)){
//                    //this.editar();
//                this.ver();
//                //}
//            }else{
//                this.mandarProdutoPraVenda();
//            }
//        }else{
//            this.produtoSelecionado(this.jTabelaPesquisa.getSelectedRow());
//        }
    }//GEN-LAST:event_jTabelaPesquisaMouseClicked

    private void jTabelaPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabelaPesquisaKeyPressed
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
//            if(produto == null){
//                this.ver();
//            }else{
//                this.mandarProdutoPraVenda();
//            }
//        }if(evt.getKeyCode() == KeyEvent.VK_DOWN){
//            int sel = jTabelaPesquisa.getSelectedRow();
//            //if(sel >= 0){
//                this.produtoSelecionado(sel+1);
//            //}else{
//                //this.produtoSelecionado(0);
//            //}
//        }if(evt.getKeyCode() == KeyEvent.VK_UP){
//            int sel = jTabelaPesquisa.getSelectedRow();
//            this.produtoSelecionado(sel - 1);
//        }
        
        
    }//GEN-LAST:event_jTabelaPesquisaKeyPressed

    private void jChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jChaveKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscarProduto();
        }else if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            jTabelaPesquisa.requestFocus();
        }/*else{
            this.buscarProduto();
        }*/
    }//GEN-LAST:event_jChaveKeyPressed

    private void jChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChaveActionPerformed
        
    }//GEN-LAST:event_jChaveActionPerformed

    private void jbutaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutaoEditarActionPerformed
        this.editar();
        this.buscarProduto();
    }//GEN-LAST:event_jbutaoEditarActionPerformed

    private void jTabelaPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabelaPesquisaFocusGained

    }//GEN-LAST:event_jTabelaPesquisaFocusGained

    private void jTabelaPesquisaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPesquisaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabelaPesquisaMouseEntered

    private void jbutaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutaoExcluirActionPerformed
         int v = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este produto?", "Excluir", JOptionPane.YES_NO_OPTION);
         if(v == 0){
            this.excluir();
            this.buscarProduto();
         }
    }//GEN-LAST:event_jbutaoExcluirActionPerformed

    private void jbutaoaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutaoaddActionPerformed
        this.enviarParaVenda();
    }//GEN-LAST:event_jbutaoaddActionPerformed
   
    private void buscarProduto(){
        this.limparTabelas();
        this.lista = new ArrayList<>();
        BuscaProduto busca = new BuscaProduto(jTabelaPesquisa,jChave.getText(), this.lista);
        busca.start();
    }
     
    private void editar(){
         int item = jTabelaPesquisa.getSelectedRow();
         CadastroProduto janela = new CadastroProduto(this.pai, true, this.lista.get(item));
         janela.setVisible(true);
     }//Fim do ver
    
    private void excluir(){
        int item = jTabelaPesquisa.getSelectedRow();
        Produto p = this.lista.get(item);
        p.setStatus(Produto.DESATIVADO);
        Banco.getBanco().editarProduto(p);
    }
    
    private void enviarParaVenda(){
        int item = jTabelaPesquisa.getSelectedRow();
        Produto p = this.lista.get(item);
        this.produto.setId(p.getId());
        this.produto.setCodigoBarras(p.getCodigoBarras());
        this.produto.setDescricao(p.getDescricao());
        this.produto.setEstoque(p.getEstoque());
        this.produto.setPreco(p.getPreco());
        this.produto.setStatus(p.getStatus());
        this.dispose();
    }
       
    private void limparTabelas(){
        DefaultTableModel model = (DefaultTableModel) jTabelaPesquisa.getModel();
        //Limpa a tabela antes de adicionar os novos dados
        int tam = model.getRowCount();
        for(int i=0;i<tam;i++){
            model.removeRow(0);
        }
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /*
//         * Set the Nimbus look and feel
//         */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /*
//         * If Nimbus (introduced in Java SE 6) is not available, stay with the
//         * default look and feel. For details see
//         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /*
//         * Create and display the dialog
//         */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                JanelaConsultaProdutos dialog = new JanelaConsultaProdutos(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton7;
    private javax.swing.JTextField jChave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabelaPesquisa;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbutaoEditar;
    private javax.swing.JButton jbutaoExcluir;
    private javax.swing.JButton jbutaoadd;
    // End of variables declaration//GEN-END:variables
}
