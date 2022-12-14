
package Model;

import view.UI;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileOperations {
    private UI frame;
    public FileOperations(UI frame) {
        this.frame = frame;
    }
 public ArrayList<Header> readFile(){
     String headerPath;
     String itemPath;
        File headerFile ;
        File itemFile;
        List<String> headerLines=null;
        List<String> itemLines=null;
        int result;
        ArrayList<Header> invArray = new ArrayList<>();
  
            JOptionPane.showMessageDialog(frame, "Please insert Headers File then Lines File"); 

            JFileChooser file = new JFileChooser();
            do{
               result = file.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                headerFile = file.getSelectedFile();
                if(headerFile.getName().contains(".csv")){
                    headerPath=headerFile.getAbsolutePath();
                    break;
                }
                else{
                  System.out.println("Wrong Headers File Format");
                 JOptionPane.showMessageDialog(frame, "Wrong Headers File Format please insert the correct file again");  
                }
            }
            }while(true);
            do{
                result = file.showOpenDialog(frame);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    itemFile = file.getSelectedFile();
                    if(itemFile.getName().contains(".csv")){
                        itemPath= itemFile.getAbsolutePath();
                        break;
                    }
                    else{
                    System.out.println("Wrong Items File Format");
                 JOptionPane.showMessageDialog(frame, "Wrong Items File Format");
                }

                }
            }while(true);

            System.out.println(headerPath);
            System.out.println(itemPath);


            try {
                headerLines = Files.lines(Paths.get(headerPath)).collect(Collectors.toList());
            } catch (IOException ex) {
                System.out.println("Wrong Headers File Path");
                 JOptionPane.showMessageDialog(frame, "Wrong Headers File Path");
            }

                
            try {
                itemLines = Files.lines(Paths.get(itemPath)).collect(Collectors.toList());
            } catch (IOException ex) {
                System.out.println("Wrong Items File Path");
                 JOptionPane.showMessageDialog(frame, "Wrong Items File Patth");
            }
            
               
                
                if(headerLines!=null && itemLines !=null){
                for (String headerLine : headerLines) {
                    String[] arr = headerLine.split(",");
                    String numToString = arr[0];
                    String date = arr[1];
                    String customerName = arr[2];
                    int num = Integer.parseInt(numToString);
                    Header invoice = new Header(num, customerName, date);
                    invArray.add(invoice);
                    frame.getInvoices().add(invoice);
                   
                }
                for (String itemLine : itemLines) {
                    String[] arr = itemLine.split(",");
                    int num = Integer.parseInt(arr[0]);
                    String name1 = arr[1];
                    double unitPrice = Double.parseDouble(arr[2]);
                    int quantity = Integer.parseInt(arr[3]);
                    Header invoice=getInvoiceByNum(num);
                    Item line = new Item(name1,quantity,unitPrice,invoice);
                    invoice.getItems().add(line);

                }
                }

                return invArray;        
            }

 public Header getInvoiceByNum(int num){
    for(Header inv : frame.getInvoices()){
        if(inv.getNum()==num){
            return inv;
        }
    } 
        return null;
}

 public void saveFile(ArrayList<Header> headers) {
        String invoices = "";
        String items = "";
        File headerFile;
        File lineFile;
        int result;
        for(Header header: headers){
            String headerLines = header.getInvoicesFromTabel();
            invoices=invoices+headerLines;
            invoices=invoices+"\n";
            
            for(Item item : header.getItems()){
                String itemFile = item.getItemsFromTabel();
                items = items+itemFile;
                items = items+"\n";
            }
        }

        JOptionPane.showMessageDialog(frame, "Kindly choose the Headers file then Lines file");
        JFileChooser file = new  JFileChooser();
        do{
        result = file.showSaveDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION){
            headerFile = file.getSelectedFile();
            if(headerFile.getName().contains(".csv")){
                FileWriter headFileWriter = null;
                try {
                    headFileWriter = new FileWriter(headerFile);
                    headFileWriter.write(invoices);
                    headFileWriter.flush();
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        headFileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }
                else{
                  System.out.println("Wrong Headers File Format");
                 JOptionPane.showMessageDialog(frame, "Wrong Headers File Format");  
                }
        }
        }while(true);
            
           
            do{
            result = file.showSaveDialog(frame);
            if(result == JFileChooser.APPROVE_OPTION){
                lineFile= file.getSelectedFile();
                if(lineFile.getName().contains(".csv")){
                FileWriter lineFileWriter = null;
                    try {
                        lineFileWriter = new FileWriter(lineFile);
                        lineFileWriter.write(items);
                        lineFileWriter.flush();
                        break;
                    } catch (IOException ex) {
                        Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            lineFileWriter.close();
                        } catch (IOException ex) {
                            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            }
            }
            else{
                System.out.println("Wrong Lines File Format");
                 JOptionPane.showMessageDialog(frame, "Wrong Lines File Format");   
            }
        }while(true);
}
}