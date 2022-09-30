package view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Controller.Invoice_Controller ;
import Controller.TableEvents;
import Model.FileOperations;
import Model.ShowInvTabel;
import Model.Header;
import Model.Item;

import javax.swing.JTable;




public class UI extends JFrame{

    private JTextArea ta;

    private JMenuBar mb;

    private JMenu fileMenu;

    private JMenuItem loadItem;

    private JMenuItem SaveItem;

    private JMenuItem exitItem;

    private JButton btn;

    private JButton btn2;

    private JTextField InvoiceNumber;
    public JTable table1;
    private JTable table2;
    private String[] cols1 = {"No.", "Date", "Customer","Total"};
    private String[] cols2 = {"No.", "ItemName", "ItemPrice","Count", "ItemTotal"};

    private String [][] data1 = {
            {"2", "Ali", "Excellent","120"},
            {"3", " Ibrahim", "Good", "150"},
            {"4","Maher","Very Good", "160"}


    };
    private String [][] data2 ={
            {"2", "Mobile", "4000", "1", "4000"},
            {"2", "Headphones", "300", "1", "300"},
            {"2", "Cover", "200","1","200"}


    };
    public UI() throws InterruptedException {
        super (" Sales Invoice Generator");
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInvoiceHeader = new javax.swing.JTable();
        tableInvoiceHeader.getSelectionModel().addListSelectionListener(tableAction);
        jScrollPane2 = new javax.swing.JScrollPane();
        tableInvoiceLines = new javax.swing.JTable();
        invoiceNum = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        invoiceTotalCost = new javax.swing.JLabel();
        labelCustomerName = new javax.swing.JLabel();
        labelTostalCost = new javax.swing.JLabel();
        labelInvoiceDate = new javax.swing.JLabel();
        labelInvoiceNum = new javax.swing.JLabel();
        btnNewInvoice = new javax.swing.JButton();
        btnNewInvoice.addActionListener(controller);
        btnDeleteInvoice = new javax.swing.JButton();
        btnDeleteInvoice.addActionListener(controller);
        btnNewLine = new javax.swing.JButton();
        btnNewLine.addActionListener(controller);
        btnDeleteLine = new javax.swing.JButton();
        btnDeleteLine.addActionListener(controller);
        JMenuBar = new javax.swing.JMenuBar();
        MenuBar = new javax.swing.JMenu();
        OpenMenuItem = new javax.swing.JMenuItem();
        OpenMenuItem.addActionListener(controller);
        SaveMenuItem = new javax.swing.JMenuItem();
        SaveMenuItem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableInvoiceHeader.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        tableInvoiceHeader.setShowGrid(true);
        jScrollPane1.setViewportView(tableInvoiceHeader);

        tableInvoiceLines.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        tableInvoiceLines.setShowGrid(true);
        jScrollPane2.setViewportView(tableInvoiceLines);
        tableInvoiceLines.getAccessibleContext().setAccessibleName("");

        invoiceNum.setText("Invoice Num:");

        invoiceDate.setText("Invoice Date:");

        customerName.setText("Customer Name:");

        invoiceTotalCost.setText("Invoice Total Cost:");

        labelCustomerName.setText("-");

        labelTostalCost.setText("-");

        labelInvoiceDate.setText("-");

        labelInvoiceNum.setText("-");

        btnNewInvoice.setText("New Invoice");

        btnDeleteInvoice.setText("Delete Invoice");

        btnNewLine.setText("New Line");

        btnDeleteLine.setText("Delete Line");

        MenuBar.setText("File");

        OpenMenuItem.setText("Open File");
        OpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                OpenMenuItemActionPerformed(evt);
            }
        });
        MenuBar.add(OpenMenuItem);

        SaveMenuItem.setText("Save File");
        MenuBar.add(SaveMenuItem);

        JMenuBar.add(MenuBar);

        setJMenuBar(JMenuBar);
        JMenuBar.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.white);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(invoiceNum))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(invoiceTotalCost)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(labelTostalCost))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(customerName)
                                                                                        .addComponent(invoiceDate))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(labelInvoiceDate)
                                                                                        .addComponent(labelCustomerName)
                                                                                        .addComponent(labelInvoiceNum)))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(btnNewInvoice)
                                                .addGap(37, 37, 37)
                                                .addComponent(btnDeleteInvoice)
                                                .addGap(68, 68, 68)
                                                .addComponent(btnNewLine)
                                                .addGap(118, 118, 118)
                                                .addComponent(btnDeleteLine)))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceNum)
                                                        .addComponent(labelInvoiceNum))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceDate)
                                                        .addComponent(labelInvoiceDate))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(customerName)
                                                        .addComponent(labelCustomerName))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceTotalCost)
                                                        .addComponent(labelTostalCost))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnNewInvoice)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnDeleteInvoice)
                                                .addComponent(btnNewLine)
                                                .addComponent(btnDeleteLine)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );


        invoiceDate.getAccessibleContext().setAccessibleName("jLabel2");

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }

    public void runUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UI frame= null;
                try {
                    frame = new UI();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                frame.setVisible(true);
                FileOperations fileOperations = new FileOperations(frame);
                ArrayList<Header> inv= fileOperations.readFile();
                frame.setInvoices(inv);
                ShowInvTabel invoiceTable = new ShowInvTabel(inv);
                frame.setHeaderTabel(invoiceTable);
                frame.getTableInvoiceHeader().setModel(invoiceTable);
                frame.getHeaderTabel().fireTableDataChanged();

            }
        });
    }
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JMenu MenuBar;
    private javax.swing.JMenuItem OpenMenuItem;
    private javax.swing.JMenuItem SaveMenuItem;
    private javax.swing.JButton btnDeleteInvoice;
    private javax.swing.JButton btnDeleteLine;
    private javax.swing.JButton btnNewInvoice;
    private javax.swing.JButton btnNewLine;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceNum;
    private javax.swing.JLabel invoiceTotalCost;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCustomerName;
    private javax.swing.JLabel labelInvoiceDate;
    private javax.swing.JLabel labelInvoiceNum;
    private javax.swing.JLabel labelTostalCost;
    private javax.swing.JTable tableInvoiceHeader;
    private javax.swing.JTable tableInvoiceLines;
    private Invoice_Controller controller = new Invoice_Controller( this);
    private TableEvents tableAction = new TableEvents(this);
    public SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<Header> invoices;
    private ArrayList<Item> lines;


    public JLabel getLabelInvoiceDate() {
        return labelInvoiceDate;
    }

    public Invoice_Controller getController() {
        return controller;
    }

    public void setLabelInvoiceDate(JLabel labelInvoiceDate) {
        this.labelInvoiceDate = labelInvoiceDate;
    }

    public JLabel getLabelInvoiceNum() {
        return labelInvoiceNum;
    }

    public void setLabelInvoiceNum(JLabel labelInvoiceNum) {
        this.labelInvoiceNum = labelInvoiceNum;
    }

    public void setLines(ArrayList<Item> lines) {
        this.lines = lines;
    }
    private ShowInvTabel headerTabel;

    public ShowInvTabel getHeaderTabel() {
        return headerTabel;
    }
    public void setHeaderTabel(ShowInvTabel headerTabel){
        this.headerTabel= headerTabel;
    }
    public ArrayList<Header> getInvoices(){
        if(invoices==null){
            invoices= new ArrayList<>();
        }
        return invoices;
    }

    public void setInvoices(ArrayList<Header> invoices) {
        this.invoices= invoices;
    }

    public JLabel getCustomerName() {
        return customerName;
    }

    public JLabel getInvoiceDate() {
        return invoiceDate;
    }

    public JLabel getInvoiceNum() {
        return invoiceNum;
    }

    public JLabel getInvoiceTotalCost() {
        return invoiceTotalCost;
    }

    public JLabel getLabelCustomerName() {
        return labelCustomerName;
    }

    public JLabel getLabelTostalCost() {
        return labelTostalCost;
    }

    public JTable getTableInvoiceHeader() {
        return tableInvoiceHeader;
    }

    public JTable getTableInvoiceLines() {
        return tableInvoiceLines;
    }

    public Invoice_Controller getLisener(){
        return controller;
    }
    public void setCustomerLabel(String name){
        labelCustomerName.setText(name);
    }


    public void setCustomerName(String name){
        tableInvoiceHeader.setName(name);

    }
    public int getTotalInvNum(){
        int num=0;
        for(Header invoice: invoices){
            if(invoice.getNum()>num){
                num= invoice.getNum();
            }
        }

        return num;
    }
}


