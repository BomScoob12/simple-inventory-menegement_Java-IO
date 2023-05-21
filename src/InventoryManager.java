import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class InventoryManager {

    private List<Product> inventory;
    private String filename;

    public InventoryManager(String filename){
        this.filename = filename;
        inventory = new ArrayList<>();
    }

    public void addProduct(Product product){
        inventory.add(product);
    }

    public void removeProduct(String productName){
        inventory.removeIf( p -> p.getName().equals(productName));
    }

    public void updateQuantity(String productName, int newQuantity){
        for (Product p : inventory){
            if (p.getName().equals(productName)){
                p.setQuantity(newQuantity);
                break;
            }
        }
    }

    public void displayInventory() {
        for (Product p : inventory){
            System.out.println(p);
        }
    }

    public void saveInventory(){
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
            objectOutputStream.writeObject(inventory);
            System.out.println("Save success");
        } catch (IOException e){
            System.out.println("Failed to save inventory");
            e.getStackTrace();
        }
    }

    public void loadInventory(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            inventory = (List<Product>) objectInputStream.readObject();
            System.out.println("Inventory loaded");
        }catch (IOException e){
            System.out.println("Loaded failed.");
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
