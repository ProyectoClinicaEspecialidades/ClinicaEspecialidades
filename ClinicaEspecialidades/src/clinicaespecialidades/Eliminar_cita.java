/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clinicaespecialidades;

/**
 *
 * @author Anali
 */
public class Eliminar_cita extends javax.swing.JFrame {

     /**
     * Creates new form Eliminar_cita
     */
    BaseDatos base = new BaseDatos();
    
    public Eliminar_cita() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        IDpaciente = new javax.swing.JTextField();
        Consultar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        paciente = new javax.swing.JLabel();
        cita = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        eliminartodas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID paciente:");

        IDpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDpacienteActionPerformed(evt);
            }
        });
        IDpaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IDpacienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IDpacienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDpacienteKeyTyped(evt);
            }
        });

        Consultar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Consultar.setText("Consultar");
        Consultar.setEnabled(false);
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        regresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        eliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminar.setText("Eliminar cita");
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Adriana\\Documents\\NetBeansProjects\\ClinicaEspecialidades\\src\\clinicaespecialidades\\recepcion.jpg")); // NOI18N

        eliminartodas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eliminartodas.setText("Eliminar todas las citas");
        eliminartodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminartodasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminar)
                .addGap(117, 117, 117)
                .addComponent(eliminartodas, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(regresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IDpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196)
                        .addComponent(Consultar))
                    .addComponent(cita, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IDpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Consultar))
                .addGap(39, 39, 39)
                .addComponent(paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cita, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar)
                    .addComponent(regresar)
                    .addComponent(eliminartodas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        paciente.setText("Paciente: "+base.buscarPaciente(IDpaciente.getText()));
        cita.setText("Cita programada: "+base.consultarCita(IDpaciente.getText()));
        eliminar.setEnabled(true);
        Consultar.setEnabled(false);
        IDpaciente.setEnabled(false);//consultar los atributos de la tabla cita
       //delete los atributos de ese paciente de la tabla citas
    }//GEN-LAST:event_ConsultarActionPerformed

    private void IDpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDpacienteActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_IDpacienteActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        base.eliminarCita(IDpaciente.getText());
        IDpaciente.setText("");
        paciente.setText("");
        cita.setText("");
        eliminar.setEnabled(false);
        IDpaciente.setEnabled(true);// TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        new Administrar_citas().setVisible(true);        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void IDpacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDpacienteKeyPressed
    Consultar.setEnabled(true);          // TODO add your handling code here:
    }//GEN-LAST:event_IDpacienteKeyPressed

    private void IDpacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDpacienteKeyReleased
        if(IDpaciente.getText().isEmpty()){ 
          Consultar.setEnabled(false); 
    }// TODO add your handling code here:
    }//GEN-LAST:event_IDpacienteKeyReleased

    private void IDpacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDpacienteKeyTyped
         
        char c=evt.getKeyChar();
        
        if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
               
               
          } // TODO add your handling code here:
    }//GEN-LAST:event_IDpacienteKeyTyped

    private void eliminartodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminartodasActionPerformed
        base.eliminarCitas(IDpaciente.getText());
        IDpaciente.setText("");
        paciente.setText("");
        cita.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_eliminartodasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Eliminar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar_cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Consultar;
    private javax.swing.JTextField IDpaciente;
    private javax.swing.JLabel cita;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton eliminartodas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel paciente;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
