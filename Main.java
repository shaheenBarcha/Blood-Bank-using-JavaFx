import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[]args)
    {

       Receptionist r = new Receptionist("murk","abc",0334214,"matlani@gmail.com",22);
        System.out.println("DONOR DETAILS");

        try {
            r.register();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // Doctor d = new Doctor("murk","abc",0334512,"matlani@gmail.com",22);
       // d.CheckDonor();
       lab_technician lt = new lab_technician("murk","zyx",0334214.4,"murkmatlani@gmail.com","positive");
        lt.test_blood();
        lt.accept_blood("murk");
        try {
            lt.provideDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bloodbank bb = new Bloodbank();
        try {
            bb.AcceptBlood("B","Ehsan");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bloodbank bb1 = new Bloodbank();
        bb1.removeBlood();

        System.out.println("RECIEVER  WITHDRAWS THE BLOOD GROUP");
        Seeker s = new Seeker();
        try {
            s.viewDetails();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}


class Donor {

    String name;
    String Address;
    double cell;
    String Email;
    int age;
    Donor(String name, String Address,double cell,String Email,int age)
    {
        this.name = name;
        this.Address = Address;
        this.cell = cell;
        this.Email = Email;
        this.age = age;

    }


   Scanner sc = new Scanner(System.in);
   void input(){
       System.out.println("enter the name");
       name = sc.next();

       System.out.println("enter the address");
       Address = sc.next();

       System.out.println("enter the Email");
       Email = sc.next();

       System.out.println("Enter your Age");
       age = sc.nextInt();

   }

    void details()
    {
        System.out.println("Name : "+name);
        System.out.println("String Address : "+Address);
        System.out.println("Cell : "+cell);
        System.out.println("Email : "+Email);
    }

    boolean donate(int age) throws InputMismatchException, Exception
    {
        boolean status = false;
        if(age > 18)
        {
            this.age = age;
            System.out.println("You're Elligible");
            FileWriter file = new FileWriter("DonorsDetails.txt",true);

            String number = Double.toString(cell);
            String ageString = Integer.toString(age);
            file.write(name);
            file.write("\n");
            file.write(Address);
            file.write("\n");
            file.write(Email);
            file.write("\n");
            file.write(age);
            file.write("\n");
            file.write(number);
            file.write("\n");
            file.close();

            status = true;
        }
        else
        {

            throw new InputMismatchException("Not eligible");
        }

        return status;
    }

}


class Receptionist extends Donor {
    int age;
    public Receptionist(String name, String Address,double cell,String Email,int age)
    {
        super(name, Address, cell, Email, age);
        this.age = age;

    }

    void register() throws InputMismatchException, Exception
    {
        super.input();
        super.details();
        super.donate(age);
    }


}


class Doctor extends Receptionist {

    LabStaff l = new LabStaff( "ds", "sead", 03455, "Sdd");
    Donor d = new Donor("abs", "Sda", cell, Email, 20);

    Doctor(String name,String Address,double cell,String Email,int age)
    {
        super(name,Address,cell,Email,age);

    }

    void CheckDonor()
    {
        if(name.equals("xyz"))
        {

            l.takeDonor(d);

        }
    }

}


class LabStaff
{

    String name;
    String address;
   double cell;
    String Email;

    public LabStaff(String name,String Address,double cell,String Email)
    {
        this.name = name;
        this.address = Address;
        this.cell = cell;
        this.Email = Email;
    }
    void takeDonor(Donor d)
    {

    }
}



class lab_technician extends LabStaff {
    String donor;
    String b_test;

    public lab_technician(String name, String Address, double cell, String Email, String b_test) {
        super(name, Address, cell, Email);
        this.b_test = b_test;
    }
    Donor d = new Donor("abc","xzy",086.0,"abc@gmail.com",21);
    Blood b = new Blood();
    Bloodbank bb = new Bloodbank();
    void provideDetails() throws IOException{
        bb.AcceptBlood("A","abc");
    }

    Scanner sc = new Scanner(System.in);

    public void test_blood() throws InputMismatchException {
        System.out.println("enter the blood group");
        donor = sc.next();
        if ((donor.equals("A")) || (donor.equals("B")) || (donor.equals("AB")) || (donor.equals("O"))) {

            System.out.println("your are only illigble when you donate the above mentioned blood group");
        } else {
            System.out.println ("blood group is mismatched so you can not donate");
        }

    }


    public void accept_blood(String donor) throws InputMismatchException {
        float ph = 0;
        float iron = 0;
        System.out.println("enter the ph value");
        ph = sc.nextFloat();
        System.out.println("enter the iron value");
        iron = sc.nextFloat();
        if ((ph >= 2 || ph <= 5) && (iron >= 60 || iron <= 120)) {
            this.donor = donor;
            System.out.println("succefully! donate");
        } else {
            throw new InputMismatchException("Sorry! you should consult with doctor");
        }
    }


}

class Blood
{
    String bloodType;
    String code;
    Donor Donordetails;

    void bloodDetails(String bloodType,String code,Donor d)
    {
        this.bloodType = bloodType;
        this.code = code;

    }
}

class Hospital {

    void PurchaseBlood(String bloodType, String code, String Dname)
    {
        System.out.println("Purchased blood Type : "+bloodType);
        System.out.println("Code : "+code);
        System.out.println("Donar name : "+Dname);

    }

}

