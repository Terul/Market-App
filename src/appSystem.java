import java.util.ArrayList;
import java.util.Collections;

public class appSystem {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> productsOfUser = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> usersOfProduct = new ArrayList<>();
    public void addUser(String firstName, String lastName, int amountOfMoney) {
        int id = users.size();
        users.add(new User(id, firstName, lastName, amountOfMoney));
        productsOfUser.add(new ArrayList<>());
    }

    public void addProduct(String name, int price) {
        int id = products.size();
        products.add(new Product(id, name, price));
        usersOfProduct.add(new ArrayList<>());
    }

    public void showAllUsers() {
        for (var usr : users) {
            System.out.println(usr.getInfo());
        }
    }

    public void showAllProducts() {
        for (var prod : products) {
            System.out.println(prod.getInfo());
        }
    }

    public void processTrade(int userID, int productID) {
        if (users.get(userID).getBalance() < products.get(productID).getPrice()) {
            System.out.println("User doesn't have enough money");
        } else {
            System.out.println("Trade is successful");
            users.get(userID).decreaseMoney(products.get(productID).getPrice());
            productsOfUser.get(userID).add(productID);
            usersOfProduct.get(productID).add(userID);
        }
    }
    
    public void getProductsOfUser(int userID) {
        System.out.println("Products of user:");
        for (Integer productID : productsOfUser.get(userID)) {
            System.out.println(products.get(productID).getInfo());
        }
    }

    public void getUsersOfProduct(int productID) {
        System.out.println("Users that bought this product:");
        for (Integer i : usersOfProduct.get(productID)) {
            System.out.println(users.get(i).getName());
        }
    }

    public void deleteUser(int userID) {
        for (Integer productID : productsOfUser.get(userID)) {
            usersOfProduct.get(productID).removeAll(Collections.singleton(userID));
        }
        productsOfUser.get(userID).clear();
    }

    public void deleteProduct(int productID) {
        for (Integer userID : usersOfProduct.get(productID)) {
            productsOfUser.get(userID).removeAll(Collections.singleton(productID));
        }
        usersOfProduct.get(productID).clear();
    }
}
