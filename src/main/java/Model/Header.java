


package Model;

import java.util.ArrayList;

public class Header {
   private int num;
   private String date;
   private String name;
   private ArrayList<Item> items;

   
    public Header() {
    }
  

    public Header(int num, String name, String date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }
    public double getTotalInvoice(){
        double total=0.0;
        for(Item item : getItems()){
            total= total + item.getTotalLine();
        }
        return total;
    }
   

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Item> getItems() {
        if(items==null){
            items=new ArrayList();
        }
        return items;
    }

    @Override
    public String toString() {
        return "Header{" + "num=" + num + ", date=" + date + ", name=" + name  + ", items=" + items + '}';
    }
    public double getTotal(){
        double total=0;
        for(Item item: getItems()){
            total= total+ item.getTotal();
        }
        return total;
    }

   public String getInvoicesFromTabel(){
       return num + "," + date + "," + name ;
   }
   

   
 
}
