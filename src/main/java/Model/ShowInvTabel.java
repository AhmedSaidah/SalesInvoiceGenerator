


//model of invoices table 

package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ShowInvTabel extends AbstractTableModel {

    private String[] colums = {"Num", "Date", "Customer", "Total"};
    private ArrayList<Header> invoices;

    public ShowInvTabel(ArrayList<Header> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Header invoice = invoices.get(rowIndex);
        switch(columnIndex){
            case 0:
                return invoice.getNum();
                
            case 1:
                return invoice.getDate();
                
            case 2:
                return invoice.getName();
                
            case 3: 
                return invoice.getTotalInvoice();
            
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column];
    }

}
