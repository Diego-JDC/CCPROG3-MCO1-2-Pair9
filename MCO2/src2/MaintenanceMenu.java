import java.awt.event.ActionListener;

public class MaintenanceMenu extends javax.swing.JFrame{
    public MaintenanceMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Title = new javax.swing.JLabel();
        options = new javax.swing.JPanel();
        addItemBtn = new javax.swing.JButton();
        collectBtn = new javax.swing.JButton();
        setPriceBtn = new javax.swing.JButton();
        replenishBtn = new javax.swing.JButton();
        summaryBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        currentIncome = new javax.swing.JLabel();
        change = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        replenishChange = new javax.swing.JPanel();
        replenishMoney = new javax.swing.JTextField();
        inputR = new javax.swing.JLabel();
        setChangeBtn = new javax.swing.JButton();
        setItemPrice = new javax.swing.JPanel();
        inputPrice = new javax.swing.JTextField();
        itemList = new javax.swing.JComboBox<>();
        priceBtn = new javax.swing.JButton();
        priceMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Maintenance");

        addItemBtn.setText("Add New Items / Restock");

        collectBtn.setText("Collect Income");

        setPriceBtn.setText("Set Item Price");

        replenishBtn.setText("Replenish Change");

        summaryBtn.setText("Print Transaction Summary");

        jLabel4.setText("Success!");

        javax.swing.GroupLayout optionsLayout = new javax.swing.GroupLayout(options);
        options.setLayout(optionsLayout);
        optionsLayout.setHorizontalGroup(
            optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(collectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(replenishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(summaryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setPriceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(optionsLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        optionsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addItemBtn, collectBtn, replenishBtn, setPriceBtn, summaryBtn});

        optionsLayout.setVerticalGroup(
            optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addItemBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(collectBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setPriceBtn)
                .addGap(22, 22, 22)
                .addComponent(replenishBtn)
                .addGap(22, 22, 22)
                .addComponent(summaryBtn)
                .addGap(22, 22, 22))
        );

        optionsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addItemBtn, collectBtn, replenishBtn, setPriceBtn, summaryBtn});

        currentIncome.setText("Current Income:");

        change.setText("Change:");

        Parent.setLayout(new java.awt.CardLayout());

        inputR.setText("Input new change amount:");

        setChangeBtn.setText("Set Change");

        javax.swing.GroupLayout replenishChangeLayout = new javax.swing.GroupLayout(replenishChange);
        replenishChange.setLayout(replenishChangeLayout);
        replenishChangeLayout.setHorizontalGroup(
            replenishChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replenishChangeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(replenishChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setChangeBtn)
                    .addComponent(replenishMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputR, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        replenishChangeLayout.setVerticalGroup(
            replenishChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replenishChangeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(inputR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replenishMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setChangeBtn)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Parent.add(replenishChange, "card2");

        itemList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        priceBtn.setText("Set Price");

        priceMessage.setText("Success!");

        javax.swing.GroupLayout setItemPriceLayout = new javax.swing.GroupLayout(setItemPrice);
        setItemPrice.setLayout(setItemPriceLayout);
        setItemPriceLayout.setHorizontalGroup(
            setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setItemPriceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setItemPriceLayout.createSequentialGroup()
                        .addComponent(itemList, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(setItemPriceLayout.createSequentialGroup()
                        .addComponent(priceBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(priceMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        setItemPriceLayout.setVerticalGroup(
            setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setItemPriceLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceBtn)
                    .addComponent(priceMessage))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Parent.add(setItemPrice, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(currentIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentIncome)
                    .addComponent(change))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    public void setPriceBtn(ActionListener e){
        setPriceBtn.addActionListener(e);
    }

    public void setReplenishBtn(ActionListener e){
        replenishBtn.addActionListener(e);
    }

    public void showPriceMenu(){
        Parent.removeAll();
        Parent.add(setItemPrice);
        Parent.revalidate();
    }

    public void showReplenish(){
        Parent.removeAll();
        Parent.add(replenishChange);
        Parent.revalidate();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel Parent;
    private javax.swing.JLabel Title;
    private javax.swing.JButton addItemBtn;
    private javax.swing.JLabel change;
    private javax.swing.JButton collectBtn;
    private javax.swing.JLabel currentIncome;
    private javax.swing.JTextField inputPrice;
    private javax.swing.JLabel inputR;
    private javax.swing.JComboBox<String> itemList;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel options;
    private javax.swing.JButton priceBtn;
    private javax.swing.JLabel priceMessage;
    private javax.swing.JButton replenishBtn;
    private javax.swing.JPanel replenishChange;
    private javax.swing.JTextField replenishMoney;
    private javax.swing.JButton setChangeBtn;
    private javax.swing.JPanel setItemPrice;
    private javax.swing.JButton setPriceBtn;
    private javax.swing.JButton summaryBtn;
    // End of variables declaration
}
