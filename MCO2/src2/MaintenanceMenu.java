import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

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
        currentIncome = new javax.swing.JLabel();
        change = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        replenishChange = new javax.swing.JPanel();
        replenishMoney = new javax.swing.JTextField();
        inputR = new javax.swing.JLabel();
        confirmChange = new javax.swing.JButton();
        setItemPrice = new javax.swing.JPanel();
        inputPrice = new javax.swing.JTextField();
        itemList = new javax.swing.JComboBox<>();
        submitBtn = new javax.swing.JButton();
        priceMessage = new javax.swing.JLabel();
        currentPrice = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        collectPanel = new javax.swing.JPanel();
        collectedAmt = new javax.swing.JLabel();
        collectedLabel = new javax.swing.JLabel();
        confirmCollect = new javax.swing.JButton();
        AddRestockMenu = new javax.swing.JPanel();
        restockItemList = new javax.swing.JComboBox<>();
        CurrentStock = new javax.swing.JLabel();
        inputStock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        restockBtn = new javax.swing.JButton();
        currentItemStock = new javax.swing.JLabel();
        AddItemsMenu = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        addMessage = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        newNameLabel = new javax.swing.JLabel();
        caloriesLabel = new javax.swing.JLabel();
        newPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SummaryTable = new javax.swing.JTable();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Maintenance");

        addItemBtn.setText("Add New Items / Restock");
        addItemBtn.setFocusable(false);

        collectBtn.setText("Collect Income");
        collectBtn.setFocusable(false);

        setPriceBtn.setText("Set Item Price");
        setPriceBtn.setFocusable(false);

        replenishBtn.setText("Replenish Change");
        replenishBtn.setFocusable(false);

        summaryBtn.setText("Transaction Summary");
        summaryBtn.setFocusable(false);

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
        );

        optionsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addItemBtn, collectBtn, replenishBtn, setPriceBtn, summaryBtn});

        optionsLayout.setVerticalGroup(
            optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addItemBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(collectBtn)
                .addGap(22, 22, 22)
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

        confirmChange.setText("Set Change");
        confirmChange.setFocusable(false);
        confirmChange.setOpaque(true);

        javax.swing.GroupLayout replenishChangeLayout = new javax.swing.GroupLayout(replenishChange);
        replenishChange.setLayout(replenishChangeLayout);
        replenishChangeLayout.setHorizontalGroup(
            replenishChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replenishChangeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(replenishChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmChange)
                    .addComponent(replenishMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputR, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        replenishChangeLayout.setVerticalGroup(
            replenishChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replenishChangeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(inputR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replenishMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmChange)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        Parent.add(replenishChange, "card2");

        submitBtn.setText("Set Price");
        submitBtn.setFocusable(false);

        priceLabel.setText("Input new price:");

        javax.swing.GroupLayout setItemPriceLayout = new javax.swing.GroupLayout(setItemPrice);
        setItemPrice.setLayout(setItemPriceLayout);
        setItemPriceLayout.setHorizontalGroup(
            setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setItemPriceLayout.createSequentialGroup()
                .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setItemPriceLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitBtn)
                            .addGroup(setItemPriceLayout.createSequentialGroup()
                                .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(currentPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(itemList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(setItemPriceLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(priceMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        setItemPriceLayout.setVerticalGroup(
            setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setItemPriceLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(priceMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        Parent.add(setItemPrice, "card3");

        collectedLabel.setText("Collected income:");

        confirmCollect.setText("Confirm");

        javax.swing.GroupLayout collectPanelLayout = new javax.swing.GroupLayout(collectPanel);
        collectPanel.setLayout(collectPanelLayout);
        collectPanelLayout.setHorizontalGroup(
            collectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(collectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(collectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(collectedAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmCollect)
                    .addComponent(collectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        collectPanelLayout.setVerticalGroup(
            collectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(collectPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(collectedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(collectedAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmCollect)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        Parent.add(collectPanel, "card4");

        jLabel1.setText("Input stock amount:");

        restockBtn.setText("Restock");

        currentItemStock.setText("Current item stock:");

        javax.swing.GroupLayout AddRestockMenuLayout = new javax.swing.GroupLayout(AddRestockMenu);
        AddRestockMenu.setLayout(AddRestockMenuLayout);
        AddRestockMenuLayout.setHorizontalGroup(
            AddRestockMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddRestockMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(AddRestockMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddRestockMenuLayout.createSequentialGroup()
                        .addGroup(AddRestockMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddRestockMenuLayout.createSequentialGroup()
                                .addComponent(restockItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentItemStock, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CurrentStock, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(AddRestockMenuLayout.createSequentialGroup()
                        .addGroup(AddRestockMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddRestockMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputStock, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                            .addComponent(restockBtn))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        AddRestockMenuLayout.setVerticalGroup(
            AddRestockMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddRestockMenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(CurrentStock, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddRestockMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restockItemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentItemStock))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(inputStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restockBtn)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        Parent.add(AddRestockMenu, "card6");

        addBtn.setText("Add");
        addBtn.setFocusable(false);

        jRadioButton1.setText("Ingredient");
        jRadioButton1.setFocusable(false);

        jRadioButton2.setText("Regular");
        jRadioButton2.setFocusable(false);

        newNameLabel.setText("Name");

        caloriesLabel.setText("Calories");

        newPrice.setText("Price");

        javax.swing.GroupLayout AddItemsMenuLayout = new javax.swing.GroupLayout(AddItemsMenu);
        AddItemsMenu.setLayout(AddItemsMenuLayout);
        AddItemsMenuLayout.setHorizontalGroup(
            AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddItemsMenuLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddItemsMenuLayout.createSequentialGroup()
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddItemsMenuLayout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddItemsMenuLayout.createSequentialGroup()
                        .addGroup(AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caloriesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68))
        );
        AddItemsMenuLayout.setVerticalGroup(
            AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddItemsMenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caloriesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPrice))
                .addGap(18, 18, 18)
                .addGroup(AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddItemsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        Parent.add(AddItemsMenu, "card7");

        SummaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Init Qty", "Amt Sold", "Profit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(SummaryTable);
        if (SummaryTable.getColumnModel().getColumnCount() > 0) {
            SummaryTable.getColumnModel().getColumn(0).setResizable(false);
            SummaryTable.getColumnModel().getColumn(1).setResizable(false);
            SummaryTable.getColumnModel().getColumn(2).setResizable(false);
            SummaryTable.getColumnModel().getColumn(3).setResizable(false);
        }

        Parent.add(jScrollPane1, "card5");

        back.setText("Back");
        back.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(currentIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addComponent(Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(back)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentIncome)
                    .addComponent(change))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(options, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>

    /**
     * Resets the combo box list
     */

    public void resetList(){
        itemList.removeAllItems();
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setPriceBtn(ActionListener e){
        setPriceBtn.addActionListener(e);
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setReplenishBtn(ActionListener e){
        replenishBtn.addActionListener(e);
    }

    /**
     * Shows the price menu
     */
    
    public void showPriceMenu(){
        Parent.removeAll();
        Parent.add(setItemPrice);
        Parent.revalidate();
        Parent.repaint();
    }

    /**
     * Shows the replenish change menu
     */

    public void showReplenish(){
        Parent.removeAll();
        Parent.add(replenishChange);
        Parent.revalidate();
        Parent.repaint();
    }

    /**
     * Shows collect income menu
     */

    public void showCollect(){
        Parent.removeAll();
        Parent.add(collectPanel);
        Parent.revalidate();
        Parent.repaint();
    }

    /**
     * Sets the combo box to display item names
     * @param list
     */

    public void setItemList(ArrayList<Slot> list){
        DefaultComboBoxModel<Slot> model = new DefaultComboBoxModel<>();

        for (Slot s : list) {
            model.addElement(s);
        }
        itemList.setModel(model);
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setItemListBtn(ActionListener e){
        itemList.addActionListener(e);
    }

    /**
     * Gets selected item in combo box
     * @return Slot object
     */

    public Slot getSelected(){
        return (Slot) itemList.getSelectedItem();
    }

    /**
     * Updates current price of an item
     * @param price price of current item selected
     */

    public void setPriceLabel(int price){
        currentPrice.setText("Current price: " + price + ".00 PHP");
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setSubmitBtn(ActionListener e){
        submitBtn.addActionListener(e);
    }

    /**
     * Gets text field input
     * @return price input of user
     */

    public int getInput(){
        String s = inputPrice.getText();
        return Integer.parseInt(s);
    }

    /**
     * Clears text field
     */

    public void clearField(){
        inputPrice.setText("");
        replenishMoney.setText("");
    }

    /**
     * Shows success message when setting price
     */

    public void showMessage(){
        priceMessage.setVisible(true);
    }

    /**
     * Hides success message
     */

    public void hideMessage(){
        priceMessage.setVisible(false);
    }

    /**
     * Sets the current income label
     * @param income current income of vending machine
     */

    public void setIncomeLabel(int income){
        currentIncome.setText("Current income : " + income);
    }

    /**
     * Sets the amount of change
     * @param amount change in the vending machine
     */

    public void setChangeLabel(int amount){
        inputR.setText("Change : " + amount);
    }

    /**
     * Gets replenish amount inputted by user
     * @return amount to be replenished
     */

    public int getReplenishAmt(){
        String s = replenishMoney.getText();
        return Integer.parseInt(s);
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setChangeBtn(ActionListener e){
        confirmChange.addActionListener(e);
    }

    /**
     * Hides all panels
     */

    public void hideAll(){
        Parent.removeAll();
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setCollectBtn(ActionListener e){
        collectBtn.addActionListener(e);
    }

    /**
     * Shows current income for collect income menu
     */

    public void collectedIncomeLabel(int income){
        collectedLabel.setText("Current income : " + income + ".00 PHP");
    }

    /**
     * Shows collected income message
     * @param income income from vending machine
     */

    public void collectedAmt(int income){
        collectedAmt.setText("Successfully collected " + income + ".00 PHP");
    }

    /**
     * Update current income label
     * @param n current income of vending machine
     */

    public void setCurrentIncome(int n){
        currentIncome.setText("Current Income : " + n + ".00 PHP");
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setBack(ActionListener e){
        back.addActionListener(e);
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setConfirm(ActionListener e){
        confirmCollect.addActionListener(e);
    }

    /**
     * Show transaction summary
     */

    public void showTransactionMenu(){
        Parent.removeAll();
        Parent.add(jScrollPane1);
        Parent.revalidate();
        Parent.repaint();
    }

    /**
     * Sets the action listner
     * @param e action listener created from controller
     */

    public void setSummaryBtn(ActionListener e){
        summaryBtn.addActionListener(e);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel AddItemsMenu;
    private javax.swing.JPanel AddRestockMenu;
    private javax.swing.JLabel CurrentStock;
    private javax.swing.JPanel Parent;
    private javax.swing.JTable SummaryTable;
    private javax.swing.JLabel Title;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addItemBtn;
    private javax.swing.JLabel addMessage;
    private javax.swing.JButton back;
    private javax.swing.JLabel caloriesLabel;
    private javax.swing.JLabel change;
    private javax.swing.JButton collectBtn;
    private javax.swing.JPanel collectPanel;
    private javax.swing.JLabel collectedAmt;
    private javax.swing.JLabel collectedLabel;
    private javax.swing.JButton confirmChange;
    private javax.swing.JButton confirmCollect;
    private javax.swing.JLabel currentIncome;
    private javax.swing.JLabel currentItemStock;
    private javax.swing.JLabel currentPrice;
    private javax.swing.JTextField inputPrice;
    private javax.swing.JLabel inputR;
    private javax.swing.JTextField inputStock;
    private javax.swing.JComboBox<Slot> itemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel newNameLabel;
    private javax.swing.JLabel newPrice;
    private javax.swing.JPanel options;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceMessage;
    private javax.swing.JButton replenishBtn;
    private javax.swing.JPanel replenishChange;
    private javax.swing.JTextField replenishMoney;
    private javax.swing.JButton restockBtn;
    private javax.swing.JComboBox<String> restockItemList;
    private javax.swing.JPanel setItemPrice;
    private javax.swing.JButton setPriceBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JButton summaryBtn;
    // End of variables declaration
}
