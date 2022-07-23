import java.util.ArrayList;
import java.util.Collections;

public class AppSystem {
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Product> products = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> productsOfUser = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> usersOfProduct = new ArrayList<>();

    public void addUser(String firstName, String lastName, int amountOfMoney) {
        int userID = users.size();
        users.add(new User(userID, firstName, lastName, amountOfMoney));
        productsOfUser.add(new ArrayList<>());
        System.out.println("User added with id = " + userID);
    }

    public void addProduct(String name, int price) {
        int productID = products.size();
        products.add(new Product(productID, name, price));
        usersOfProduct.add(new ArrayList<>());
        System.out.println("Product added with id = " + productID);
    }

    public void showAllUsers() {
        System.out.println("List of all users:");
        for (var usr : users) {
            if (usr == null) {
                continue;
            }
            System.out.println(usr.getInfo());
        }
    }

    public void showAllProducts() {
        System.out.println("List of all products:");
        for (var prod : products) {
            if (prod == null) {
                continue;
            }
            System.out.println(prod.getInfo());
        }
    }

    public void processTrade(int userID, int productID) {
        if (userID < 0 || userID >= users.size() || users.get(userID) == null) {
            System.out.println("Such user doesn't exist");
        } else if (productID < 0 || productID >= products.size() || products.get(productID) == null) {
            System.out.println("Such product doesn't exist");
        } else if (users.get(userID).getBalance() < products.get(productID).getPrice()) {
            System.out.println("User doesn't have enough money");
        } else {
            users.get(userID).decreaseMoney(products.get(productID).getPrice());
            productsOfUser.get(userID).add(productID);
            usersOfProduct.get(productID).add(userID);
            System.out.println("Trade is successful");
        }
    }
    
    public void getProductsOfUser(int userID) {
        if (userID < 0 || userID >= users.size() || users.get(userID) == null) {
            System.out.println("Such user doesn't exist");
            return;
        }
        System.out.println("Products of user with id " + userID + ":");
        for (Integer productID : productsOfUser.get(userID)) {
            System.out.println(products.get(productID).getInfo());
        }
    }

    public void getUsersOfProduct(int productID) {
        if (productID < 0 || productID >= products.size() || products.get(productID) == null) {
            System.out.println("Such product doesn't exist");
            return;
        }
        System.out.println("Users that bought product with id " + productID + ":");
        for (Integer i : usersOfProduct.get(productID)) {
            System.out.println(users.get(i).getName());
        }
    }

    public void deleteUser(int userID) {
        if (userID < 0 || userID >= users.size() || users.get(userID) == null) {
            System.out.println("Such user already doesn't exist");
            return;
        }
        for (Integer productID : productsOfUser.get(userID)) {
            usersOfProduct.get(productID).removeAll(Collections.singleton(userID));
        }
        productsOfUser.get(userID).clear();
        users.set(userID, null);
        System.out.println("User with id " + userID + " deleted successfully");
    }

    public void deleteProduct(int productID) {
        if (productID < 0 || productID >= products.size() || products.get(productID) == null) {
            System.out.println("Such product doesn't exist");
            return;
        }
        for (Integer userID : usersOfProduct.get(productID)) {
            productsOfUser.get(userID).removeAll(Collections.singleton(productID));
        }
        usersOfProduct.get(productID).clear();
        products.set(productID, null);
        System.out.println("Product with id " + productID + " deleted successfully");
    }
}
