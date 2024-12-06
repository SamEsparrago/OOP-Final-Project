import java.util.ArrayList;
import java.util.Scanner;

abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayRole();
}

class Customer extends User {
    public Customer(String name) {
        super(name);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Customer");
    }
}

interface DonationRecipient {
    void receiveDonation(double amount);
    double getTotalDonations();
}

class CharityDonation implements DonationRecipient {
    private double totalDonations;

    @Override
    public void receiveDonation(double amount) {
        totalDonations += amount;
    }

    @Override
    public double getTotalDonations() {
        return totalDonations;
    }

    public void displayThankYou() {
        System.out.println("Thank you for your generosity! Your donation makes a difference.");
    }
}

class Book {
    private String title;
    private String author;
    private double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return title + " by " + author + " - $" + price + " (" + stock + " in stock)";
    }
}

class Cart {
    private ArrayList<Book> cartItems;
    private ArrayList<Integer> quantities;

    public Cart() {
        cartItems = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addBook(Book book, int quantity) {
        cartItems.add(book);
        quantities.add(quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            total += cartItems.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Your Cart:");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println(cartItems.get(i).getTitle() + " - " + quantities.get(i) + " copies");
        }
    }
}

class Store {
    private ArrayList<Book> inventory;
    private CharityDonation charityDonation;

    public Store() {
        inventory = new ArrayList<>();
        charityDonation = new CharityDonation();
        inventory.add(new Book("Book of Bliss", "Anggolt", 10.99, 10));
        inventory.add(new Book("Book of Rupture", "Kiaron", 15.50, 5));
        inventory.add(new Book("Book of Erosion", "Grish", 7.25, 20));
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }

    public boolean purchaseBook(int bookIndex, int quantity, Cart cart) {
        if (bookIndex >= 0 && bookIndex < inventory.size()) {
            Book selectedBook = inventory.get(bookIndex);
            if (selectedBook.getStock() >= quantity) {
                selectedBook.setStock(selectedBook.getStock() - quantity);
                cart.addBook(selectedBook, quantity);
                System.out.println("Added to cart: " + selectedBook.getTitle());
                return true;
            } else {
                System.out.println("Not enough stock available.");
            }
        } else {
            System.out.println("Invalid book selection.");
        }
        return false;
    }

    public CharityDonation getCharityDonation() {
        return charityDonation;
    }
}

// Main Class
public class Bookstore {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our N.C. Bookstore!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);
        customer.displayRole();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View Books");
            System.out.println("2. Add Book to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.displayBooks();
                    break;
                case 2:
                    store.displayBooks();
                    System.out.print("Enter the book number to add to cart: ");
                    int bookIndex = scanner.nextInt() - 1;
                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    store.purchaseBook(bookIndex, quantity, cart);
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    double total = cart.calculateTotal();
                    System.out.printf("Total: $%.2f\n", total);

                    System.out.print("Would you like to donate? (yes/no): ");
                    String donateResponse = scanner.next();
                    if (donateResponse.equalsIgnoreCase("yes")) {
                        System.out.print("Enter donation amount: ");
                        double donation = scanner.nextDouble();
                        store.getCharityDonation().receiveDonation(donation);
                        store.getCharityDonation().displayThankYou();
                    }

                    System.out.printf("Final Total: $%.2f\n", total);
                    System.out.println("Thank you for shopping!");
                    running = false;
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.printf("Total Donations: $%.2f\n", store.getCharityDonation().getTotalDonations());
        System.out.println("Goodbye!");
        scanner.close();
    }
}
