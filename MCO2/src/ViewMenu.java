
public class ViewMenu extends javax.swing.JFrame {

    public ViewMenu() {
        initComponents();
    }

    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        Create = new javax.swing.JButton();
        Features = new javax.swing.JButton();
        Maintenance = new javax.swing.JButton();
        Menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(231, 245, 252));
        setBounds(new java.awt.Rectangle(0, 0, 477, 310));

        Create.setBackground(new java.awt.Color(140, 133, 245));
        Create.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        Create.setForeground(new java.awt.Color(255, 255, 255));
        Create.setText("Create Vending Machine");
        Create.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Create.setBorderPainted(false);
        Create.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Create.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Create.setPreferredSize(null);
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        Features.setBackground(new java.awt.Color(140, 133, 245));
        Features.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        Features.setForeground(new java.awt.Color(255, 255, 255));
        Features.setText("Vending Features");
        Features.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Features.setBorderPainted(false);
        Features.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Features.setPreferredSize(null);
        Features.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeaturesActionPerformed(evt);
            }
        });

        Maintenance.setBackground(new java.awt.Color(140, 133, 245));
        Maintenance.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        Maintenance.setForeground(new java.awt.Color(255, 255, 255));
        Maintenance.setText("Maintenance Features");
        Maintenance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Maintenance.setBorderPainted(false);
        Maintenance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Maintenance.setPreferredSize(null);
        Maintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaintenanceActionPerformed(evt);
            }
        });

        Menu.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        Menu.setForeground(new java.awt.Color(215, 92, 181));
        Menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu.setText("MENU");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Features, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Create, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Create, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Features, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Maintenance, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void FeaturesActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void MaintenanceActionPerformed(java.awt.event.ActionEvent evt) {

    }

   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenu().setVisible(true);
            }
        });
    }

    // Variable declarations
    private javax.swing.JButton Create;
    private javax.swing.JButton Features;
    private javax.swing.JButton Maintenance;
    private javax.swing.JLabel Menu;
    private javax.swing.JPanel menuPanel;
}
