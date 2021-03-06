/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import java.awt.Toolkit;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author LAB
 */
public class FileBrowser extends javax.swing.JFrame {

//    DefaultListModel model = new DefaultListModel();
//        final JList jList1 = new JList(model);

    JFileChooser chooser = new JFileChooser();
    int result;
    String fullpath = "";
//              
//                    File eg = chooser.getSelectedFile();
    String path;
    FilenameFilter fileNameFilter;
    String[] dirList;

    public FileBrowser() {

        initComponents();
    }

    public void execute(String path) {
        try {
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + "\"" + op(path) + "\"");//execute ny file from windows
            p.waitFor();
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public String op(String Test) {
        String path = "";
        char[] g = Test.toCharArray();
        for (int i = 0; i < g.length; i++) {

            path += g[i];
        }

        return path;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pick = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        imageView = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(204, 255, 204));

        pick.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pick.setText("Select Path");
        pick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        imageView.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageView.setForeground(new java.awt.Color(255, 51, 0));
        imageView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageView.setMaximumSize(new java.awt.Dimension(1024, 768));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageView, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Open File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pick, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(pick)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(0, 0, 837, 788);
    }// </editor-fold>//GEN-END:initComponents

    private void pickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickActionPerformed

        chooser.setCurrentDirectory(new java.io.File("."));

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();
            dirList = file.list();
            path = file.getName();
            DefaultListModel model = new DefaultListModel();

            for (int k = 0; k < dirList.length; ++k) {
                model.addElement(dirList[k]);
                System.out.println(dirList[k]);
            }
            jList1.setModel(model);

        }

    }//GEN-LAST:event_pickActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
       
 
        File eg = chooser.getSelectedFile();
        String sname = eg.getAbsolutePath(); 
        String dir = (String) jList1.getSelectedValue();
        fullpath = sname + "\\" + dir;
      fullpath.compareToIgnoreCase(dir);
imageView.setIcon(null);
  if (fullpath.endsWith(".png")|| fullpath.endsWith(".jpg")||fullpath.endsWith(".JPG") ||fullpath.endsWith(".PNG") ||fullpath.endsWith(".TIFF") ) {
       imageView.setText("");
           ImageIcon icon = new ImageIcon(fullpath);
        imageView.setIcon(icon);
        System.out.println(sname + "\\" + dir);

          }
          else{
     
          imageView.setIcon(null);
          imageView.setText("الرجاء الضغط على زر فتح ملف");
          
          }

    }//GEN-LAST:event_jList1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        execute(fullpath);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
//          File eg = chooser.getSelectedFile();
//        String sname = eg.getAbsolutePath(); 
//        String dir = (String) jList1.getSelectedValue();
//        fullpath = sname + "\\" + dir;
//      fullpath.compareToIgnoreCase(dir);
//imageView.setIcon(null);
//  if (fullpath.endsWith(".png")|| fullpath.endsWith(".jpg")||fullpath.endsWith(".JPG") ||fullpath.endsWith(".PNG") ||fullpath.endsWith(".TIFF") ) {
//       imageView.setText("");
//           ImageIcon icon = new ImageIcon(fullpath);
//        imageView.setIcon(icon);
//        System.out.println(sname + "\\" + dir);
//
//          }
//          else{
//     
//          imageView.setIcon(null);
//          imageView.setText("الرجاء الضغط على زر فتح ملف");
//          
//          }

// TODO add your handling code here:
    }//GEN-LAST:event_jList1KeyPressed

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
            java.util.logging.Logger.getLogger(FileBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileBrowser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageView;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pick;
    // End of variables declaration//GEN-END:variables
}
