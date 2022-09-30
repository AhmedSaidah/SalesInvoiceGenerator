package Controller;


import Model.FileOperations;
import Model.ShowInvTabel;
import Model.ShowLineTabel;
import Model.Header;
import Model.Item;
import view.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import view.add_invoice_dialog;
import view.add_line_dialog;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Invoice_Controller implements ActionListener, ListSelectionListener {

    private UI frame;
    private Header header;
    private Item item;
    private String name ;
    private add_invoice_dialog invDialog;
    private add_line_dialog itemDialog;

    public Invoice_Controller(UI frame) {
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "New Invoice":
                newInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "New Line":
                newLine();
                break;
            case "Delete Line":
                deleteLine();
                break;

            case "createInvoice":
                addInvOk();
                break;

            case "cancelInvoice":
                cancelInvoice();
                break;
            case "createLine":
                createLine();
                break;
            case "cancelLine":
                cancelLine();
                break;

            case "Open File":

                frame.setInvoices(null);
                FileOperations fileOperations = new FileOperations(frame);
                ArrayList<Header> inv= fileOperations.readFile();
                frame.setInvoices(inv);
                ShowInvTabel invoiceTable = new ShowInvTabel(inv);
                frame.setHeaderTabel(invoiceTable);
                frame.getTableInvoiceHeader().setModel(invoiceTable);
                frame.getHeaderTabel().fireTableDataChanged();

                break;

            case "Save File":
                FileOperations fileOperations1 = new FileOperations(frame);


                fileOperations1.saveFile(frame.getInvoices());


                break;


        }
    }

    private void newInvoice() {
        invDialog = new add_invoice_dialog(frame);
        invDialog.setVisible(true);

    }

    private void deleteInvoice() {
        int row = frame.getTableInvoiceHeader().getSelectedRow();
        if(row!= -1){
            frame.getInvoices().remove(row);
            frame.getHeaderTabel().fireTableDataChanged();

        }
    }

    private void newLine() {
        itemDialog = new add_line_dialog(frame);
        itemDialog.setVisible(true);

    }

    private void deleteLine() {
        int invoiceSelected= frame.getTableInvoiceHeader().getSelectedRow();
        int row = frame.getTableInvoiceLines().getSelectedRow();
        if((invoiceSelected!=-1) && (row!= -1)){
            Header invoice = frame.getInvoices().get(invoiceSelected);
            invoice.getItems().remove(row);
            frame.getHeaderTabel().fireTableDataChanged();
            ShowLineTabel line = new ShowLineTabel(invoice.getItems());
            frame.getTableInvoiceLines().setModel(line);
            line.fireTableDataChanged();
        }
    }

    public void addInvOk() {
        String date= invDialog.getInvoiceDate().getText();
        String customer = invDialog.getCustomerName().getText();
        int num= frame.getTotalInvNum();
        num++;
        Header newInvoice = new Header(num,customer,date);
        frame.getInvoices().add(newInvoice);
        frame.getHeaderTabel().fireTableDataChanged();
        invDialog.setVisible(false);
        invDialog.dispose();
        invDialog=null;

    }

    public Header getInvoiceByNum(int num){
        for(Header inv: frame.getInvoices()){
            if(num==inv.getNum()){
                return inv;
            }
        }
        return null;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void cancelInvoice() {
        invDialog.setVisible(false);
        invDialog.dispose();
        invDialog=null;
    }

    private void createLine() {

        int invoiceSelected= frame.getTableInvoiceHeader().getSelectedRow();
        if(invoiceSelected!=-1){
            Header invoice = frame.getInvoices().get(invoiceSelected);
            String item= itemDialog.getItemName().getText();
            String unitPrice = itemDialog.getUnitPrice().getText();
            String quantity = itemDialog.getQuantity().getText();
            double itemUnitPrice = Double.parseDouble(unitPrice);
            int itemQuantity = Integer.parseInt(quantity);
            Item newLine = new Item(item,itemQuantity,itemUnitPrice,invoice);
            invoice.getItems().add(newLine);
            ShowLineTabel line = new ShowLineTabel(invoice.getItems());
            frame.getHeaderTabel().fireTableDataChanged();
            frame.getTableInvoiceLines().setModel(line);
            line.fireTableDataChanged();

        }
        itemDialog.setVisible(false);
        itemDialog.dispose();
        itemDialog=null;

    }
    private void cancelLine() {
        itemDialog.setVisible(false);
        itemDialog.dispose();
        itemDialog=null;
    }
}



