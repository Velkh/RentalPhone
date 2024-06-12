package rentPhone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainRun extends Algorithm {
    static File readPhone = new File("listPhone.txt");
    static File rentFile = new File("Rent.txt");

    public static void main(String [] args) throws IOException {
        
        if (phoneList.exists() == false) {
            try{
                phoneList.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (phoneList.exists() == false){
            phoneList.createNewFile();
        }
        login();
        if (main.getName().equalsIgnoreCase("Op")) {
            while (true) {
                menu.operatorMenu();
                switch (menu.returnValue()) {
                    case 1:
                        menu.listPhone();
                        break;
                    case 2:
                        menu.addPhoneMenu();
                        break;
                    case 3:
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Enter Phone to Delete");
                        String phoneID = sc.nextLine();
                        deletePhone(phoneID);
                        break;
                    case 4:
                        System.out.println(" Thanks for Visiting :)) ");
                        System.exit(0);
                }
            }           
        }
        while (true) {
            menu.mainMenu();
            switch (menu.returnValue()) {
                case 1:
                    menu.listPhone();
                    break;
                case 2:
                    menu.bookRent();
                    break;
                case 3:
                    menu.printRent();
                    break;
                case 4:
                    System.out.println("Thanks for Renting");
                    System.exit(0);
                }
            }
        }
        public static void login() {
            System.out.println("Input Your Name : ");
            Scanner input = new Scanner(System.in);
            main.setName(input.nextLine());
            System.out.println("Insert Your Phone Number : ");
            main.setTelephone(input.nextLine());
        }
        public static ArrayList<String> readPhone() throws FileNotFoundException {
            ArrayList<String> phoneChecker = new ArrayList<>();
            Scanner phone = new Scanner(readPhone);
                while(phone.hasNextLine() != false){
                    phoneChecker.add(phone.nextLine());
                }
                return phoneChecker;
            }
        public static void addPhone(String phone) throws IOException {
            FileWriter addPhone = new FileWriter(readPhone, true);
            Scanner ph = new Scanner(phone);
            String phoneList = "";
            while (ph.hasNextLine() == true){
                phoneList = phoneList + ph.nextLine() + "\n";
                phoneList = phoneList + phone;
                addPhone.write(phone + "\n");
                addPhone.close();
            }
        }
        public static void deletePhone(String phoneID) throws IOException {
            ArrayList<String> phones = readPhone();

            boolean found = false;
            for (int i = 0; i < phones.size(); i++) {
                String[] phone = phones.get(i).split(",");
                if (phone[0].equals(phoneID)) {
                    phones.remove(i);
                    found = true;
                    break;
                }
            }
            if (found) {
                FileWriter fw = new FileWriter(phoneList, false);
                for (String phone : phones) {
                    fw.write(phone + "\n");
                }
                fw.close();
                System.out.println( phoneID + " has been deleted.");
            } else {
                System.out.println( phoneID + " was not found.");
            }
        }        
}