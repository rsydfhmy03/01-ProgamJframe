/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectApk;

import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ACER
 */
public class ImgUploadDisplay extends javax.swing.JFrame {
File f = null;
String path = null;
private ImageIcon format = null;
String fname = null;
int s = 0;
byte[] pimage = null;
  
    public ImgUploadDisplay() {
        initComponents();
        Connect();
        LoadImageID(); 
    }
Connection conn;
PreparedStatement pst;
ResultSet rs;
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/uploadimg_db","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImgUploadDisplay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImgUploadDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void LoadImageID(){
    try {
        pst = conn.prepareStatement("SELECT Image_id FROM image_tbl");
        rs = pst.executeQuery();
        
        imageID.removeAllItems();
        
        while (rs.next()) {
            
            imageID.addItem(rs.getString(1));
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(ImgUploadDisplay.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void LoadImage(){
    try {
        byte[] imagedata = rs.getBytes("Image_file");
        format = new ImageIcon(imagedata);
        Image mm = format.getImage();
        Image img2 = mm.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        
        lbl_DisplayImg.setIcon(image);
    } catch (SQLException ex) {
        Logger.getLogger(ImgUploadDisplay.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_img = new javax.swing.JLabel();
        txt_ImgPath = new javax.swing.JTextField();
        btnBrowserImg = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lbl_DisplayImg = new javax.swing.JLabel();
        imageID = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_ImgPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ImgPathActionPerformed(evt);
            }
        });

        btnBrowserImg.setText("BrowserImg");
        btnBrowserImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserImgActionPerformed(evt);
            }
        });

        btnSave.setText("jButton1");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        imageID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearch.setText("jButton2");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBrowserImg, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ImgPath, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageID, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_DisplayImg, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txt_ImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_DisplayImg, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBrowserImg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ImgPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ImgPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ImgPathActionPerformed

    private void btnBrowserImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowserImgActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
//        chooser.showOpenDialog(null);
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","png","jpg","jpeg");
        chooser.addChoosableFileFilter(fnef);
        int load = chooser.showOpenDialog(null);
        
        //test 1
        /*
         File file = chooser.getSelectedFile();
        String filename = file.getAbsolutePath();

        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(new File(filename));
            filename = file.getAbsolutePath();
            txt_ImgPath.setText(filename);

            String newpath = "src/Upload/profile/";
            File directory = new File(newpath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File sourceFile = null;
            File destinationFile = null;
            String extension = filename.substring(filename.lastIndexOf('.') + 1);
            sourceFile = new File(filename);
            java.util.Date tanggal_update = new java.util.Date();
            String tampilan = "yyyyMMddhhmmss";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(tanggal_update));
            destinationFile = new File(newpath + "/newImage" + tanggal.toString() + "." + extension);

            Files.copy(sourceFile.toPath(), destinationFile.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Image scaledImage = bufferedImage.getScaledInstance(lbl_img.getWidth(),lbl_img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaledImage);
        lbl_img.setIcon(image);
        */
        //end test1
        if(load==chooser.APPROVE_OPTION){
            f = chooser.getSelectedFile();
            
            path = f.getAbsolutePath();
            txt_ImgPath.setText(path);
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            lbl_img.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_btnBrowserImgActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        System.out.print("Image Path - = "+path);
        System.out.print("Image Name - = "+f.getName());
    try {
 
        InputStream is = new FileInputStream(f);
        pst = conn.prepareStatement("INSERT INTO image_tbl(Image_name, Image_path, Image_file)VALUES (?,?,?)");
        pst.setString(1, f.getName());
        pst.setString(2, path);
        pst.setBlob(3, is);
        
        int inserted = pst.executeUpdate();
        if (inserted > 0) {
            JOptionPane.showMessageDialog(null, "yee Image Successfully inserted");
            LoadImageID();
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(ImgUploadDisplay.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ImgUploadDisplay.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String imgID = imageID.getSelectedItem().toString();
    try {
        pst = conn.prepareStatement("SELECT * FROM image_tbl WHERE Image_id=?");
        pst.setString(1, imgID);
        rs = pst.executeQuery();
        
        if(rs.next()){
            LoadImage();
        }else{
            JOptionPane.showMessageDialog(this, "no Image Found");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ImgUploadDisplay.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(ImgUploadDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImgUploadDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImgUploadDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImgUploadDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImgUploadDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowserImg;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> imageID;
    private javax.swing.JLabel lbl_DisplayImg;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JTextField txt_ImgPath;
    // End of variables declaration//GEN-END:variables
}
