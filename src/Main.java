import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    Scanner in = new Scanner(System.in);
    ArrayList<Friend> friend = new ArrayList<>();

    public void run() throws IOException {
        Menu menu = new Menu("MENU", "Choose option", new String[]{"1. Show list of friends", "2. Enter new friend", "3. Delete friend", "4. Save list", "5. Load list", "9. Quit"});
        menu.printMenu();

        boolean flag = true;
        while (flag) {
            switch (menu.readChoice()) {
                case 1:
                    showList();
                    break;
                case 2:
                    enterNewFriend();
                    break;
                case 3:
                    deleteFriend();
                    break;
                case 4:
                    saveList();
                    break;
                case 5:
                    loadList();
                    break;
                case 9:
                    flag = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();

    }

    public void showList() {
        System.out.println("Her er en liste over dine venner: \n");
        for (int i = 0; i <= friend.size() - 1; i++) {
            System.out.println(friend.get(i));
        }
    }

    public void enterNewFriend() {
        System.out.println("Hvad hedder din ven?");
        String name = in.nextLine();

        System.out.println("Hvad er hans/hendes telefonnummer?");
        String phoneNumber = in.nextLine();

        System.out.println("Hvad er hans/hendes email?");
        String email = in.nextLine();

        friend.add(new Friend(name, phoneNumber, email));
    }

    public void deleteFriend() {
        System.out.println("Hvilken ven vil du slette?");
        for (int i = 0; i <= friend.size() - 1; i++) {
            System.out.println(i + " " + friend.get(i));
        }
        int whichFriend = in.nextInt();
        System.out.println("Du har nu slettet " + friend.get(whichFriend).name);
        friend.remove(whichFriend);
    }

    public void saveList() throws IOException {
        //Gemmer kun den sidste
        for (Friend friends: friend) //for (int i = 0; i <= friend.size() - 1; i++) {
            getPrintStream().println(friends);
            System.out.println("Dine venner er blevet udskrevet til filen friendlist.txt");

    }

    public PrintStream getPrintStream() throws IOException {
        PrintStream out = new PrintStream("friendlist.txt");
        return out;
    }

    public void loadList() throws IOException {
        Scanner reader = new Scanner(new File("friendlist.txt"));
        while (reader.hasNextLine()) {
            String saveNextLine = reader.nextLine();
            System.out.println(saveNextLine);
        }
    }
}

