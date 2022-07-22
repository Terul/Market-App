public class Main {
    public static void main(String[] args) {
        appSystem market = new appSystem();

        market.addUser("Petro", "Shevchenko", 100);
        market.addUser("Mykola", "Bondarenko", 12);
        market.addUser("Volodymyr", "Kovalenko", 43);

        market.addProduct("Laptop", 1000);
        market.addProduct("Phone", 99);
        market.addProduct("Camera", 250);

        market.showAllUsers();
        market.showAllProducts();

        market.processTrade(0, 2);
        market.processTrade(0, 1);

        market.getProductsOfUser(0);
        market.getUsersOfProduct(1);

        market.deleteUser(0);
        market.deleteProduct(1);
    }
}