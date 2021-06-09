/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Senzo Stofile (219345406)
 */
public class Output {
    private ArrayList<Customer> customerArray = new ArrayList<>();
    private ArrayList<Supplier> supplierArray = new ArrayList<>();
    private ListIterator<Customer> nlistIterator; 
    ObjectInputStream objectInputStream;

    
    //Opens the file to read from.
    public void openFile() {
        try{
             objectInputStream = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
         } 
         catch(IOException e) {
             System.out.println("Error!! Could not open file!" + e.getMessage());
         }           
    }
    
    public void closeFile() {
        try{
            objectInputStream.close();
        }
        catch(IOException e) {
            System.out.println("Error!! Could not close file!" + e.getMessage());

        }   
    }
    
    public void readFile() {
        Object object;
            Supplier supplier;
        try{
           
            while (true){
                for (int i = 0; i <10; i++) {
                object = objectInputStream.readObject();
                
                if (object.getClass() == Supplier.class){
                    
                    supplier = (Supplier) object;
                    supplier.getName();
                    supplier.getProductDescription();
                    supplier.getProductType();
                    supplier.getStHolderId();
                    System.out.println(supplier + "\n");
            }   
        }   
            }
   
            }
        catch(IOException | ClassNotFoundException e) {
            System.out.println("Error!! Could not read file!" + e.getMessage());
        }
    }
    
     public static void main(String args[])  {
     Output obj=new Output(); 
        obj.openFile();
        obj.readFile();
        obj.closeFile();
     }
}