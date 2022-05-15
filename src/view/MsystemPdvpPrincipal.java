/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.VendaBS;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author IBBN
 */
public class MsystemPdvpPrincipal extends javax.swing.JFrame {
 CadCliente NovoCliente = new CadCliente();
 ListadeClientes ViewListaCliente = new ListadeClientes();
 Venda ralizarvenda = new Venda();
 VendaBS vendasMensal =  new VendaBS();
 ListaVendas historico = new ListaVendas();
 
    /**
     * Creates new form MsystemPdvPrincipal
     */
    public MsystemPdvpPrincipal() throws Exception  { 
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ManoelSystem.png")));
        initComponents();
        vendasMensal();
     
    }
    
    
   public void vendasMensal() throws Exception {
     
       String[] datas = ObterPrimeiroUltimoDIaDoMesPorDataJcalendar();
       
       double total =  vendasMensal.vendaMensal(datas);
       double totalpendente = vendasMensal.totalpendente(datas);
       
       jLabelAmarelototalmensal1.setText(NumberFormat.getCurrencyInstance().format(Double.parseDouble(Double.toString(total))));
       jLabeltotalpagar.setText(NumberFormat.getCurrencyInstance().format(Double.parseDouble(Double.toString(totalpendente))));
   }
   
    public String[] ObterPrimeiroUltimoDIaDoMesPorDataJcalendar(){
       String[] ArrayData = new String[2];
       
        SimpleDateFormat sdfJcalendar = new SimpleDateFormat("M");
        SimpleDateFormat dia = new SimpleDateFormat("YYYY-MM-dd");
       
                Calendar dataAtual = Calendar.getInstance();
		Calendar primeiroDia = Calendar.getInstance();
		Calendar ultimoDia = Calendar.getInstance();
		//1º dia do mês atual
                String MesSelectCalendario = sdfJcalendar.format(jCalendar1.getDate());
                
                primeiroDia.add(Calendar.MONTH,Integer.parseInt(MesSelectCalendario)-2);
		primeiroDia.add(Calendar.DAY_OF_MONTH, -dataAtual.get(Calendar.DAY_OF_MONTH));
		primeiroDia.add(Calendar.DAY_OF_YEAR, 1);
                
		//Ultimo dia do mês atual
		ultimoDia.add(Calendar.MONTH, Integer.parseInt(MesSelectCalendario)-1);
		ultimoDia.add(Calendar.DAY_OF_MONTH, -dataAtual.get(Calendar.DAY_OF_MONTH));
		//System.out.println(ultimoDia.getTime());
                
       SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
       ArrayData[0] = sdf.format(primeiroDia.getTime());
       ArrayData[1] = sdf.format(ultimoDia.getTime());
       
       return ArrayData;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabeltotalapagar = new javax.swing.JLabel();
        jLabeltotalpagar = new javax.swing.JLabel();
        buttonaupdatemensal = new javax.swing.JToggleButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabelMensal1 = new javax.swing.JLabel();
        jLabelAmarelototalmensal1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Canal Modas PDV");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(1024, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setForeground(new java.awt.Color(238, 238, 34));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icone-clientes.png"))); // NOI18N
        jButton1.setText("   Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Venda");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda.png"))); // NOI18N
        jButton2.setText("  Relizar Venda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Cadastro");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 58, -1, -1));

        jLabeltotalapagar.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabeltotalapagar.setForeground(new java.awt.Color(255, 0, 0));
        jLabeltotalapagar.setText("Total a Pagar Mensal :");
        getContentPane().add(jLabeltotalapagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        jLabeltotalpagar.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabeltotalpagar.setForeground(new java.awt.Color(255, 0, 0));
        jLabeltotalpagar.setText("R$ 0,00");
        getContentPane().add(jLabeltotalpagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, -1, -1));

        buttonaupdatemensal.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        buttonaupdatemensal.setText("Atualizar");
        buttonaupdatemensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonaupdatemensalActionPerformed(evt);
            }
        });
        getContentPane().add(buttonaupdatemensal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        jCalendar1.setBackground(new java.awt.Color(255, 204, 51));
        getContentPane().add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 290, -1));

        jLabelMensal1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabelMensal1.setForeground(new java.awt.Color(48, 186, 48));
        jLabelMensal1.setText("Vendas Mensal  :");
        getContentPane().add(jLabelMensal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, -1, -1));

        jLabelAmarelototalmensal1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabelAmarelototalmensal1.setForeground(new java.awt.Color(255, 153, 0));
        jLabelAmarelototalmensal1.setText("R$ 0,00");
        getContentPane().add(jLabelAmarelototalmensal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, -1, -1));

        jMenuBar1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jMenu4.setText("Cliente");
        jMenu4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jMenu4.setHideActionText(true);

        jMenuItem2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jMenuItem2.setText("Lista de Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Vendas");
        jMenu5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jMenuItem4.setText("Histórico de Vendas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("Configurações");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu3);

        jMenu6.setText("Sobre");
        jMenu6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          NovoCliente.setVisible(true);
          NovoCliente.setAlwaysOnTop(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ViewListaCliente.setVisible(true);
        ViewListaCliente.setAlwaysOnTop(true);
        ViewListaCliente.CarregarGrid();
        ViewListaCliente.ativamuseclik = true;
        ViewListaCliente.jButtonExlcuir.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
       ralizarvenda.setVisible(true);
        ralizarvenda.setAlwaysOnTop(true);
        ViewListaCliente.idClienteSelecionado = null;
       ViewListaCliente.ClienteSelecionado = null;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        historico.setVisible(true);
        historico.setAlwaysOnTop(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void buttonaupdatemensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonaupdatemensalActionPerformed
     try {
         // TODO add your handling code here:
         vendasMensal();
     } catch (Exception ex) {
         Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_buttonaupdatemensalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
          
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
     try {
         /* Create and display the form */
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
         Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
         Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     } catch (UnsupportedLookAndFeelException ex) {
         Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(Level.SEVERE, null, ex);
     }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MsystemPdvpPrincipal().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MsystemPdvpPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
          
       
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonaupdatemensal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAmarelototalmensal1;
    private javax.swing.JLabel jLabelMensal1;
    private javax.swing.JLabel jLabeltotalapagar;
    private javax.swing.JLabel jLabeltotalpagar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

   
}