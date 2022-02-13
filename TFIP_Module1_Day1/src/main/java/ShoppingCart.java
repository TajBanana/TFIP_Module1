import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private List<String> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public List<String> contents(){
        return cart;
    }

    public void list() {
        cart.forEach(item -> System.out.println((cart.indexOf(item) +1) + ". " + item));
    }

    public List<String> addToCart(String item) {
        cart.add(item.trim());
        return cart;
    }

    public  void deleteFromCart(int i) {
        cart.remove(i - 1);
    }

    public void loadCart(String username) throws FileNotFoundException {
        File userCartFile =  new File("src/db/"+username+".db");
        Scanner scanUserCartFile = new Scanner(userCartFile);
        cart = new ArrayList<>();
        while(scanUserCartFile.hasNextLine()) {
            cart.add(scanUserCartFile.next());
        }
    }
}
