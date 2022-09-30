package Model;

public class Item {
    private Header invoice;
    private String itemName;
    private double unitPrice;
    private int quantity;

    public Item() {
    }

    public Item(String itemName, int quantity, double unitPrice, Header header) {
        this.invoice= header;
        this.quantity = quantity;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }
     public double getTotalLine(){
        return unitPrice * quantity;
    }



    public Header getInvoice() {
        return invoice;
    }

    public void setInvoice(Header invoice) {
        this.invoice = invoice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" + "itemName=" + itemName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + '}';
    }
    public double getTotal(){
        return unitPrice * quantity;
    }

   public String getItemsFromTabel(){
       return invoice.getNum() + "," + itemName + "," + unitPrice + "," +quantity;
   }

   
    
}
