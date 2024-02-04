import java.io.FileWriter;
import java.io.IOException;

public class Bloodbank {

    Blood [] blood;
    Donor [] donor;
    int size = 0;

    Donor d = new Donor("abc","xzy",086.0,"abc@gmail.com",21);
    Blood b;

    void AcceptBlood(String bloodType,String Dname) throws IOException
    {
        FileWriter fw = new FileWriter("BloodRecord.txt",true);

//			 size++;
//        blood = (Blood[]) new Object[size];
//        donor = (Donor[]) new Object[size];
//
//        for(int i = 0;i< blood.length;i++)
//        {
//            blood[i] = b;
//            fw.write(blood[i].bloodType);
//            fw.write(blood[i].code);
//
//
//            donor[i] = d;
//            String cellNo = Double.toString(donor[i].cell);
//            String Age = Integer.toString(donor[i].age);
//            fw.write(donor[i].name);
//            fw.write(donor[i].Address);
//            fw.write(donor[i].Email);
//            fw.write(cellNo);
// 	       	fw.write(Age);
//            fw.close();
        fw.write(bloodType);
        fw.write(Dname);
        //        }
    }
    void removeBlood()
    {
        Hospital h = new Hospital();
        h.PurchaseBlood(b.bloodType,b.code,d.name);


    }
}