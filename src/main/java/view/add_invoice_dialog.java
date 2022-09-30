package view;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class add_invoice_dialog extends JDialog {
    private JTextField customerName;
    private JTextField invoiceDate;
    private JLabel custNameLabel;
    private JLabel dateLabel;
    private JButton ok;
    private JButton cancel;

    public add_invoice_dialog(UI frame) {
        custNameLabel= new JLabel("Customer Name:");
        customerName = new JTextField(30);
        dateLabel = new JLabel("Date:");
        invoiceDate = new JTextField(30);
        getContentPane().setBackground(Color.white);
        ok= new JButton("OK");
        cancel = new JButton("Cancel");
        ok.setActionCommand("createInvoice");
        cancel.setActionCommand("cancelInvoice");
        ok.addActionListener(frame.getController());
        cancel.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 4));
        add(custNameLabel);
        add(customerName);
        add(dateLabel);
        add(invoiceDate);
        add(ok);
        add(cancel);


        pack();


    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getInvoiceDate() {
        return invoiceDate;
    }


}
