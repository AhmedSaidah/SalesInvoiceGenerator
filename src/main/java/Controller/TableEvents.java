package Controller;

import view.UI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Model.ShowLineTabel;
import Model.Header;
import Model.Item;
import java.util.ArrayList;


public class TableEvents implements ListSelectionListener {
    private UI frame;

    public TableEvents(UI frame) {
        this.frame = frame;
    }

    /*when select an invoice from the header tabel this method finds out which invoice has been selected
        from the header tabel and gets its item lines and update the second table the item table
        */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int invoiceIndex = frame.getTableInvoiceHeader().getSelectedRow();
        if(invoiceIndex!= -1){
            Header selectedRow = frame.getInvoices().get(invoiceIndex);
            ArrayList<Item> items = selectedRow.getItems();
            frame.getLabelCustomerName().setText(selectedRow.getName());
            frame.getLabelInvoiceNum().setText(""+selectedRow.getNum());
            frame.getLabelInvoiceDate().setText(selectedRow.getDate());
            frame.getLabelTostalCost().setText(""+selectedRow.getTotalInvoice());
            ShowLineTabel line = new ShowLineTabel(items);
            frame.getTableInvoiceLines().setModel(line);
            line.fireTableDataChanged();

        }
    }

}
