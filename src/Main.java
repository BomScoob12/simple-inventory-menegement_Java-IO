import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static InventoryManager inventoryManager = new InventoryManager("BobInventory.txt");

    public static void main(String[] args) {

        inventoryManager.loadInventory();

        while (true) {
            System.out.println("-----Inventory management system -----");
            System.out.println("1. Add a product");
            System.out.println("2. Remove a product");
            System.out.println("3. Update inventory");
            System.out.println("4. Display inventory");
            System.out.println("5. Save inventory");
            System.out.println("6. Exit");
            System.out.println("Enter your option: ");
            int option = scan.nextInt();
            scan.nextLine();

            switch(option){
                case 1 -> menuAddProduct();
                case 2 -> menuRemoveProduct();
                case 3 -> menuUpdateProduct();
                case 4 -> menuDisplayInventory();
                case 5 -> menuSaveInventory();
                case 6 -> {
                    inventoryManager.saveInventory();
                    System.out.println("Exit program");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option, please try again.");
            }

        }
    }

    private static void menuAddProduct(){
        System.out.println("Add a product");
        System.out.println("Enter Product name:");
        String productName = scan.nextLine();
        System.out.println("Enter product quantity:");
        int quantity = scan.nextInt();
        inventoryManager.addProduct(new Product(productName, quantity));
    }

    private static void menuRemoveProduct(){
        System.out.println("Remove product");
        System.out.println("Enter Product name : ");
        String productName = scan.nextLine();
        inventoryManager.removeProduct(productName);
    }

    private static void menuUpdateProduct(){
        System.out.println("Update Product");
        System.out.println("Enter product name:");
        String productName = scan.nextLine();
        System.out.println("Enter new quantity: ");
        int newQuantity = scan.nextInt();
        scan.nextLine();
        inventoryManager.updateQuantity(productName, newQuantity);
    }

    private static void menuDisplayInventory(){
        System.out.println("Display all inventory");
        inventoryManager.displayInventory();
    }

    private static void menuSaveInventory(){
        System.out.println("Save inventory");
        inventoryManager.saveInventory();
    }

}