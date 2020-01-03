/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinar.Interface;

import cinar.Basket;
import cinar.Command;
import cinar.Services;
import cinar.Session;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dervis
 */
public class index extends javax.swing.JFrame {
    
    Session session = new Session();
    Basket bsk = new Basket();
    
    /**
     * Creates new form index
     */
    public index() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        token.setVisible(false);
        clear.setVisible(false);
        buy.setVisible(false);
        Command cmd = new Command();
        cmd.setIndex(jTable1);
        
        this.selector(homepage,"Anasayfa","Hoşgeldin "+ session.get("name"));
        
        if (session.get("role").contains("user")) {
            adminBook.setVisible(false);
            adminAuthor.setVisible(false);
            adminCategory.setVisible(false);
            adminPublisher.setVisible(false);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        homepage = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        basket = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        adminBook = new javax.swing.JLabel();
        adminCategory = new javax.swing.JLabel();
        adminAuthor = new javax.swing.JLabel();
        adminPublisher = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        homePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        token = new javax.swing.JLabel();
        addBasket = new javax.swing.JLabel();
        buy = new javax.swing.JLabel();
        clear = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        header.setBackground(new java.awt.Color(102, 102, 255));

        title.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 48)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Anasayfa");

        description.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        description.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        homepage.setBackground(new java.awt.Color(102, 51, 255));
        homepage.setForeground(new java.awt.Color(255, 255, 255));
        homepage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homepage.setText("Anasayfa");
        homepage.setOpaque(true);
        homepage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homepageMouseClicked(evt);
            }
        });

        category.setBackground(new java.awt.Color(102, 102, 255));
        category.setForeground(new java.awt.Color(255, 255, 255));
        category.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        category.setText("Kategoriler");
        category.setOpaque(true);
        category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryMouseClicked(evt);
            }
        });

        author.setBackground(new java.awt.Color(102, 102, 255));
        author.setForeground(new java.awt.Color(255, 255, 255));
        author.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        author.setText("Yazarlar");
        author.setOpaque(true);
        author.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorMouseClicked(evt);
            }
        });

        basket.setBackground(new java.awt.Color(102, 102, 255));
        basket.setForeground(new java.awt.Color(255, 255, 255));
        basket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        basket.setText("Sepet");
        basket.setOpaque(true);
        basket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                basketMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 51, 255));

        adminBook.setForeground(new java.awt.Color(255, 255, 255));
        adminBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminBook.setText("Kitap");
        adminBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminBookMouseClicked(evt);
            }
        });

        adminCategory.setForeground(new java.awt.Color(255, 255, 255));
        adminCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminCategory.setText("Kategori");
        adminCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminCategoryMouseClicked(evt);
            }
        });

        adminAuthor.setForeground(new java.awt.Color(255, 255, 255));
        adminAuthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminAuthor.setText("Yazar");
        adminAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminAuthorMouseClicked(evt);
            }
        });

        adminPublisher.setForeground(new java.awt.Color(255, 255, 255));
        adminPublisher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminPublisher.setText("Yayın Evi");
        adminPublisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminPublisherMouseClicked(evt);
            }
        });

        profile.setBackground(new java.awt.Color(102, 102, 255));
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setText("Profil");
        profile.setOpaque(true);
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(adminBook, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(adminCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(adminAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(adminPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(homepage, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(basket, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(description)
                            .addComponent(title))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(title)
                .addGap(0, 0, 0)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homepage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(basket, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        homePanel.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        addBasket.setBackground(new java.awt.Color(255, 255, 255));
        addBasket.setForeground(new java.awt.Color(51, 51, 51));
        addBasket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addBasket.setText("Sepete Ekle");
        addBasket.setOpaque(true);
        addBasket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBasketMouseClicked(evt);
            }
        });

        buy.setBackground(new java.awt.Color(255, 255, 255));
        buy.setForeground(new java.awt.Color(51, 51, 51));
        buy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buy.setText("Satın Al");
        buy.setOpaque(true);
        buy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyMouseClicked(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setForeground(new java.awt.Color(51, 51, 51));
        clear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clear.setText("Sepeti Boşalt");
        clear.setOpaque(true);
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(token, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buy, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(token)
                    .addComponent(addBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryMouseClicked
        // TODO add your handling code here:
        Command cmd = new Command();
        cmd.setCategory(jTable1);
        this.selector(category,"Kategori","Burada kategorilere göre seçenekler bulunmaktadır.");
        
        addBasket.setVisible(true);
        buy.setVisible(false);
        clear.setVisible(false);
    }//GEN-LAST:event_categoryMouseClicked

    private void homepageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepageMouseClicked
        // TODO add your handling code here:
        Command cmd = new Command();
        cmd.setIndex(jTable1);
        this.selector(homepage,"Anasayfa","Hoşgeldin "+ session.get("name"));
        
        addBasket.setVisible(true);
        buy.setVisible(false);
        clear.setVisible(false);
    }//GEN-LAST:event_homepageMouseClicked

    private void authorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorMouseClicked
        // TODO add your handling code here:
        Command cmd = new Command();
        cmd.setAuthor(jTable1);
        this.selector(author,"Yazar","Burada yazarlara göre seçenekler bulunmaktadır.");
        
        
        addBasket.setVisible(true);
        buy.setVisible(false);
        clear.setVisible(false);
    }//GEN-LAST:event_authorMouseClicked

    private void basketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basketMouseClicked
        // TODO add your handling code here:
        this.selector(basket,"Sepet","Sepetinizdeki ürünleri görmektesiniz.");
        Command cmd = new Command();
        cmd.setBasket(jTable1);
        
        addBasket.setVisible(false);
        buy.setVisible(true);
        clear.setVisible(true);
    }//GEN-LAST:event_basketMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selected = jTable1.getSelectedRow();
        if(selected > -1)
        {
            token.setText(String.valueOf(selected));
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void adminCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminCategoryMouseClicked
        // TODO add your handling code here:
        category cnt = new category();
        cnt.setVisible(true);
    }//GEN-LAST:event_adminCategoryMouseClicked

    private void adminBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminBookMouseClicked
        // TODO add your handling code here:
        books bk = new books();
        bk.setVisible(true);
    }//GEN-LAST:event_adminBookMouseClicked

    private void adminAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminAuthorMouseClicked
        // TODO add your handling code here:
        author aut = new author();
        aut.setVisible(true);
    }//GEN-LAST:event_adminAuthorMouseClicked

    private void adminPublisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminPublisherMouseClicked
        // TODO add your handling code here:
        publisher pub = new publisher();
        pub.setVisible(true);
    }//GEN-LAST:event_adminPublisherMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        // TODO add your handling code here:
        profile prf = new profile();
        prf.setVisible(true);
    }//GEN-LAST:event_profileMouseClicked

    private void addBasketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBasketMouseClicked
        // TODO add your handling code here:
        Services service = new Services();
        
        if (!token.getText().isEmpty()) {
            int selected = Integer.valueOf(token.getText());
            if (selected > -1) {
                String barcode = jTable1.getModel().getValueAt(selected, 0).toString();
                String[] split = barcode.split("_");
                String id = split[1];
                String title = jTable1.getModel().getValueAt(selected, 1).toString();
                bsk.set(id,title);
            }
        }
        else
        {
            service.alert("warning", "Bir ürün seçiniz.");
        }
    }//GEN-LAST:event_addBasketMouseClicked

    private void buyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyMouseClicked
        // TODO add your handling code here:
        Basket bsk = new Basket();
        Services service = new Services();
        if (bsk.count() > 0) 
        {
            credit crd = new credit();
            crd.setVisible(true);
        }
        else {
            service.alert("warnin", "Sepetiniz şuan boş, devam etmek için ürün ekleyiniz!");
        }
    }//GEN-LAST:event_buyMouseClicked

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        // TODO add your handling code here:
        bsk.clear();
        // TODO add your handling code here:
        this.selector(basket,"Sepet","Sepetinizdeki ürünleri görmektesiniz.");
        Command cmd = new Command();
        cmd.setBasket(jTable1);
        
        addBasket.setVisible(false);
        buy.setVisible(true);
        clear.setVisible(true);
    }//GEN-LAST:event_clearMouseClicked

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }
    
    
    private void selector(JLabel label, String title, String description)
    {
        homepage.setBackground(new java.awt.Color(102,102,255));
        category.setBackground(new java.awt.Color(102,102,255));
        author.setBackground(new java.awt.Color(102,102,255));
        basket.setBackground(new java.awt.Color(102,102,255));
        label.setBackground(new java.awt.Color(102,51,255));
        
        this.title.setText(title);
        this.description.setText(description);
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBasket;
    private javax.swing.JLabel adminAuthor;
    private javax.swing.JLabel adminBook;
    private javax.swing.JLabel adminCategory;
    private javax.swing.JLabel adminPublisher;
    private javax.swing.JLabel author;
    private javax.swing.JLabel basket;
    private javax.swing.JLabel buy;
    private javax.swing.JLabel category;
    private javax.swing.JLabel clear;
    private javax.swing.JLabel description;
    private javax.swing.JPanel header;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel homepage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel title;
    private javax.swing.JLabel token;
    // End of variables declaration//GEN-END:variables
}
