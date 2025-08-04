# Bookstore with Charity Donation "N.C. Bookstore"

** Overview
** The "Bookstore with Charity Donation" is a Java Console Program that allows users to purchase books and contribute to a charitable cause. This program demonstrates Object-Oriented Programming (OOP) principles while addressing Sustainable Development Goal 1: No Poverty. Customers can view book details, manage their shopping cart, and donate to charity during checkout, promoting social responsibility.

 OOP Principles Applied

1. Encapsulation:
   - Private fields are used in the `Book` class to store book details, with public getter and setter methods for controlled access.

2. Inheritance:
   - The `Customer` class inherits from the `User` abstract class, showcasing code reuse and hierarchical relationships.

3. Polymorphism:
   - Method overriding is implemented in the `Customer` class by redefining the `displayRole` method from the `User` class.
   - The `CharityDonation` class implements the `DonationRecipient` interface, showcasing polymorphism.

4. Abstraction:
   - Abstract classes (`User`) and interfaces (`DonationRecipient`) are used to hide implementation details while defining core functionality.

---

 Sustainable Development Goal (SDG) Addressed
This project aligns with SDG 1: No Poverty by integrating a feature that allows users to make donations to charitable causes while shopping. It raises awareness of poverty issues and encourages customers to take action through small contributions.

---

 How to Run the Program

1. Prerequisites:
    - Install Visual Studio Code.
    - Install the Java Extension Pack for Visual Studio Code.
    - Ensure you have the Java Development Kit (JDK) installed.

2. Steps:
   - Clone the repository:
     ```bash
     git clone <repository-link>
     ```
   - Navigate to the project directory:
     ```bash
     cd Bookstore
     ```
   - Compile the program:
     ```bash
     javac src/*.java -d bin
     ```
   - Run the program:
     ```bash
     java -cp bin Bookstore
     ```

3. Interaction:
   - Follow the on-screen prompts to:
     - View books.
     - Add books to your cart.
     - Proceed to checkout and make donations.

Video Presentation Link:
https://drive.google.com/drive/folders/1-N1KO4zUDaL-8w2LOLj_fD2xfxtsGkl6?usp=sharing


