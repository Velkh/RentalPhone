package rentPhone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Algorithm{
	int choice;
	private String placeholdernama;
	private String placeholderPhoneID;
	private String placeholderTelephone;
    private String placeholderrent;
	private final int price = 150000;
	
	static mainMenu menu = new mainMenu();
	static File phoneList = new File("listPhone.txt");
    static String phone[] = new String[5];
	static mainRun main = new mainRun();
	public int returnValue() {
		return choice;
    }
    public static void readPhoneList() throws FileNotFoundException{
        Scanner phone = new Scanner(phoneList);
        String phoneList = "";
        while (phone.hasNextLine() == true) {
            phoneList = phoneList + phone.nextLine() + "\n";
        }
        System.out.println(phoneList);
    }
    public static void readRent() throws FileNotFoundException{
        File rentFile = new File("rent.txt");
        Scanner rent = new Scanner(rentFile);
        String rentList = "";
        while (rent.hasNextLine() == true) {
            rentList = rentList + rent.nextLine() + "\n";
        }
        System.out.println(rentList); 
    }
    public void setName(String newName){
        placeholdernama = newName;
    }
    public String getName(){
        return placeholdernama;
    }
    public void setPhoneID(String newPhoneID){
        placeholderPhoneID = newPhoneID;
    }
    public String getPhoneID(){
        return placeholderPhoneID;
    }
    public void setTelephone(String newHp){
        placeholderTelephone = newHp;
    }
    public String getTelephone(){
        return placeholderTelephone;
    }
    public void setRent(String newRent){
        placeholderrent = newRent;
    }
    public String getRent(){
        return placeholderrent;
    }
    public int getPrice (String q){
        if (q.equalsIgnoreCase("Week")) {
            int week = (int)(price * 5);
            return week;
        } else{
            return price;
        }
    }
}

