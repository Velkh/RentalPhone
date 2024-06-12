package rentPhone;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class mainMenu extends mainRun{
        
    public void mainMenu() {
        System.out.println("Main Menu ");
        System.out.println("1. Phone List ");
        System.out.println("2. Rent a Phone ");
        System.out.println("3. Rent Info ");
        System.out.println("4. Exit Page ");
        Scanner mainMenu = new Scanner(System.in);
        choice = mainMenu.nextInt();
    }
    public void operatorMenu(){
        System.out.println(" Operator Menu ");
        System.out.println("1. Phone List ");
        System.out.println("2. Add Phone ");
        System.out.println("3. Delete Phone ");
        System.out.println("4. Exit Page ");
        Scanner mainMenu =  new Scanner(System.in);
        choice = mainMenu.nextInt();
    }   
    public void listPhone(){
        System.out.println("Phone List : ");
        try{
            readPhoneList();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void bookRent() throws IOException {
        String temp;
        String hP;
        String [] phoneCheck = null ;
        ArrayList<String> list = main.readPhone();
        System.out.println("Phone ID Based on Phone Order");
        System.out.println("Input Phone ID : ");
        Scanner fill = new Scanner(System.in);
        temp = fill.nextLine();
        if (Integer.valueOf(temp) <= list.size()){
            setPhoneID(list.get(Integer.valueOf(temp)-1));
        }else{
            temp = fill.nextLine();
        }
        System.out.println("Order Phone Daily/Week : ");
        hP = fill.nextLine();
        setRent(hP);
        phone [0] = main.getName();
        phone [1] = getPhoneID();
        phone [2] = main.getTelephone();
        phone [3] = getRent();
        phone [4] = String.valueOf(getPrice(getRent()));
        rent.writeRent();
    }
    public void addPhoneMenu() throws IOException {
        System.out.println(" Add a Phone ");
        System.out.println(" Phone Name : ");
        Scanner addPhone = new Scanner(System.in);
        String phone = addPhone.nextLine();
        addPhone(phone);
    }
    public void printRent() throws FileNotFoundException{
        System.out.println("================");
        readRent();
        System.out.println("================");
        System.out.println("Press any Button to move ");
        Scanner fill = new Scanner(System.in);
        String temp = fill.nextLine();
    }
}
    
///Public void deletePhoneMenu