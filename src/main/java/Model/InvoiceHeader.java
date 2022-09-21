package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InvoiceHeader extends JFrame implements ActionListener{

    private JTextArea ta;

    private JMenuBar mb;

    private JMenu fileMenu;

    private JMenuItem loadItem;

    private JMenuItem SaveItem;

    private JMenuItem exitItem;

    private JButton btn;

    private JButton btn2;

    private JTextField InvoiceNumber;
    private JTable table1;
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



    public InvoiceHeader(){
        super (" Sales Invoice Generator");

        //InvoiceNumber = new JTextField(10);
        //add(new JLabel("Invoice Number"));

        ta = new JTextArea();
        mb = new JMenuBar();
        fileMenu = new JMenu("File");
        loadItem = new JMenuItem("Load", 'l');
        loadItem.setAccelerator(KeyStroke.getKeyStroke('l', KeyEvent.CTRL_DOWN_MASK));
        loadItem.addActionListener( this);
        loadItem.setActionCommand("L");
        SaveItem = new JMenuItem("Save", 'S');
        SaveItem.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));
        SaveItem.addActionListener( this);
        SaveItem.setActionCommand("S");
        exitItem = new JMenuItem("Exit", 'x');
        exitItem.setAccelerator(KeyStroke.getKeyStroke('x', KeyEvent.CTRL_DOWN_MASK));
        exitItem.addActionListener( this);
        exitItem.setActionCommand("E");
        setJMenuBar(mb);
        mb.add(fileMenu);
        fileMenu.add(loadItem);
        fileMenu.add(SaveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);


        setLayout(new GridLayout( 2 , 1));
        setLayout(new BorderLayout());
      //  setLayout(new FlowLayout());

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        btn = new JButton("Create Item Voice");
        add(btn);
        btn.addActionListener(this);

        btn2 = new JButton("Delete Item");
        add(btn2);
        btn2.addActionListener(this);



        table1 = new JTable(data1, cols1);
        add(new JScrollPane(table1));

        table2 = new JTable(data2, cols2);
        add(new JScrollPane(table2));

        setBounds(800,700, 1020, 740);



       // setSize( 800 , 700);
        //setLocation( 600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);




    }

    public static void main (String[] args){
        new InvoiceHeader().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "L" :
                loadFile();
                break;

            case "S" :
                saveContent();
                break;

            case "E" :
                System.exit( 0);
                break;


        }

    }
    private void loadFile(){
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog( this);
        if (result == JFileChooser.APPROVE_OPTION){
            String path = fc.getSelectedFile().getPath();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
                int size = fis.available();
                byte[] b = new byte[size];
                fis.read(b);
                ta.setText(new String(b));
            } catch (FileNotFoundException e){

            } catch (IOException e){

            }finally {
                try{fis.close();} catch (IOException e){}
            }

        }

    }
    private void saveContent(){
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(path);
                byte[] b = ta.getText().getBytes();
                fos.write(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {

                }
            }
        }

    }




}


