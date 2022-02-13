import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean login = false;
        ShoppingCart cart = new ShoppingCart();
        String username;
        Login usernameLogin = new Login();
//  --------------------------------------------------------------------------------------------    SPECIFY DIRECTORY OF CART

        System.out.println("Specify your cart directory or hit enter to continue:");
        Scanner dir = new Scanner(System.in);
        String dirStr = dir.nextLine().trim().toLowerCase();
        String userDir;

        if (dirStr.contains(" ")) {
            System.out.println("No spaces please!");
            return;
        }

        if (dirStr.isEmpty()) {
            userDir = "src/db/";
        } else {
            String dbDir = "src/db/";
            userDir = dbDir + dirStr + "/" ;
        }

        File file = new File(userDir);
        if (file.mkdir()) {
//            System.out.println("New directory created");
        } else {
//            System.out.println("Directory already exists");
        }

//  --------------------------------------------------------------------------------------------    START OF PROGRAM
//        create shopping cart
        System.out.println("Welcome to your cart!");
//        listen for initial user inputs
        Scanner userInput = new Scanner(System.in);

//        assigning action and arguments variable to user input
        String action = userInput.next();
        action = action.toLowerCase();
        String arguments = userInput.nextLine().trim().toLowerCase();


        while(!action.equals("exit")){

//            check if input is legal
            while (!action.equals("add") && !action.equals("list") && !action.equals("exit") && !action.equals("remove") && !action.equals("login")&& !action.equals("users")&& !action.equals("save")) {
                System.out.println("Please only the following: \n1. input \n2. add \n3. list \n4. remove \n5. login \n6. save \n7. users \n8. exit");
                userInput = new Scanner(System.in);
                action = userInput.next();
                arguments = userInput.nextLine().trim();
            }

//            creating ArrayList and checking if there is multiple inputs
            List<String> argumentsArray = new ArrayList<>() {};
            if(!arguments.isBlank() && arguments.contains(",")) {
                argumentsArray = Arrays.asList(arguments.split(","));
//                System.out.println(argumentsArray);

//                trim item inputs
                int i = 0;
                for (String item : argumentsArray) {
                    argumentsArray.set(i,item.trim());
                    i += 1;
                }

            } else if(!arguments.isBlank()) {
                argumentsArray = List.of(arguments);
            }

//  --------------------------------------------------------------------------------------------    ADD FUNCTION
//        check if there is duplicate and add items to cart
            if(action.equals("add")) {
                for (String item : argumentsArray) {
                    if (!cart.contents().contains(item)) {
                        cart.addToCart(item);
                        System.out.printf("%s added to cart %n", item);
                    } else {
                        System.out.printf("You have %s in your cart %n", item);
                    }
                }
            }

//  --------------------------------------------------------------------------------------------    REMOVE FUNCTION
//        remove items from  cart
            if(action.equals("remove")) {
//                set index as -1 initially so that we can ensure the position is correctly given by the user.
                int index = Integer.parseInt(arguments);

//                use try catch exception for NumberFormatException
                if (index <= cart.contents().size()) {
                    String removedItem = cart.contents().get(index-1);
                    cart.deleteFromCart(index);
                    System.out.printf("%s removed from cart %n", removedItem);
                } else if (index > cart.contents().size()) {
                    System.out.println("Incorrect item index");
                }
            }

//  --------------------------------------------------------------------------------------------    LIST FUNCTION
//        list command for  cart
            if (action.equals("list") && cart.contents().isEmpty()) {
                System.out.println("Your cart is empty");
            } else if (action.equals("list") && !cart.contents().isEmpty()) {
                cart.list();
            }

//  --------------------------------------------------------------------------------------------    LOGIN FUNCTION
            if (action.equals("login") && (arguments.contains(" ") || arguments.isBlank()) ) {
                System.out.println("no spaces or blanks please!");
                return;
            }

            if ((action.equals("login") && login)) {
                System.out.println("already logged in");
            }

            if (action.equals("login") && !login) {
                usernameLogin.setUsername(arguments);
//                .exists() creates a db if the username doesn't exist yet
                if (usernameLogin.exists(arguments,userDir)) {
                    System.out.println("username already exists");
                } else {
                    System.out.println("creating new account");
                }

                login = true;
                cart.loadCart(arguments);
            }

//  --------------------------------------------------------------------------------------------    SAVE FUNCTION
            if (action.equals("save") && login) {
                Save userSave = new Save();
                userSave.save(usernameLogin.getUsername(),userDir,cart.contents());
            }

//  --------------------------------------------------------------------------------------------    USERS FUNCTION
            if (action.equals("users")) {
                PrintUsers printUsers = new PrintUsers();
                printUsers.printUsers();
            }

            userInput = new Scanner(System.in);
            action = userInput.next();
            arguments = userInput.nextLine().trim();
        }
    }
}