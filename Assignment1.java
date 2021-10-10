package com.company;
import java.util.*;


 class Vaccine {
    private String vaccine;
    private int doses;
    private int gap;
    public Vaccine(){
        this.vaccine=vaccine;
        getVaccine();
    }

    public Vaccine(String vaccine,int doses,int gap){
        this.vaccine=vaccine;
        this.doses=doses;
        this.gap=gap;
    }
    public void displayInfo(){
        System.out.println("Vaccine name: "+this.vaccine+" ,Number of doses: "+this.doses+" ,Gap Between Doses: "+this.gap);
        System.out.println("--------------------------------");

    }

     public int getGap() {
         return gap;
     }

     public int getDoses() {
         return doses;
     }

     public String getVaccine() {
        return vaccine;
    }
}
class RegHospital{

    private String hospital_name;
    private int pincode;
    private int ID;
    public static int x=0;

    public RegHospital(String hospital_name,int pincode){
        this.hospital_name=hospital_name;
        this.pincode=pincode;
        this.ID= 100000+x;
        x+=1;
    }
    public int getID() {
        return ID;
    }

    public int getPincode() {
        return pincode;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void display(){
        System.out.println("Hospital Name: "+this.hospital_name+" ,PinCode: "+this.pincode+" ,Unique ID "+this.ID);
        System.out.println("-------------------------------------");
    }
    public void setSlot(int day_no,int quantity,String vaccine,int slot){
        Slots s=new Slots(this.ID,day_no,quantity,vaccine,slot);
        s.display();
    }
}

 class Citizen {
     private String name;
     private int age;
     private long ID;
     private String status;
     private int due_date;
     private int doses;
     private Vaccine v;
     private String vax_given;

     public Citizen(String name, int age, long ID) {
         this.name = name;
         this.age = age;
         this.ID = ID;
         this.status = "REGISTERED";
     }
     public void setStatus(String status) {
         this.status = status;
     }

     String getName() {
         return name;
     }

     public int getDue_date() {
         return due_date;
     }

     public void setDue_date(int due_date) {
         this.due_date = due_date;
     }

     public String getStatus() {
         return status;
     }

     public long getID() {
         return ID;
     }

     public void display() {
         System.out.println("Citizen Name: " + this.name + " ,Age: " + this.age + " ,Unique ID :" + this.ID);
         if (this.age < 18)
             System.out.println(" \nOnly above 18 are allowed");
         System.out.println("\n--------------------------------- \n");
     }

     public void given_vaccine(Vaccine v,String vax_given) {
         doses++;
         this.v = v;
         this.vax_given=vax_given;

     }

     public String getVax_given() {
         return vax_given;
     }

     public void Status() {
         if (doses == 0) {
             System.out.println("Citizen REGISTERED");
         } else if (doses == v.getDoses()) {
             System.out.println("FULLY VACCINATED");
             System.out.println("Vaccine Given:" + v.getVaccine());
             System.out.println("Number of Doses given:" + doses);
         } else if (doses < v.getDoses()) {
             System.out.println("PARTIALLY VACCINATED");
             System.out.println("Vaccine Given:" + v.getVaccine());
             System.out.println("Number of Doses given:" + doses);
             System.out.println("Next Dose due date:" + this.due_date);
         }

     }
 }

     class Slots {

         private int id;
         private int day_no;
         private int q;
         private String vaccine;
         private int slot;

         Slots(int id, int day_no, int q, String vaccine, int slot) {
             this.id = id;
             this.day_no = day_no;
             this.q = q;
             this.vaccine = vaccine;
             this.slot = slot;

             Main.slots.add(this);
         }

         public int getId() {
             return id;
         }

         public int getDay_no() {
             return day_no;
         }

         public int getQ() {
             return q;
         }

         public void setQ(int q) {
             this.q = q;
         }

         public String getVaccine() {
             return vaccine;
         }

         public int getSlot() {
             return slot;
         }

         void display() {
             System.out.println("Slot added by Hospital " + this.id + " for Day: " + this.day_no + " ,Available Quantity: " + this.q + " of Vaccine " + this.vaccine);

         }
         Slots(RegHospital h) {
             this.id = h.getID();
         }
     }

     public class Main {
         public static ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
         public static ArrayList<RegHospital> hospitals = new ArrayList<RegHospital>();
         public static ArrayList<Citizen> citizens = new ArrayList<Citizen>();
         public static ArrayList<Slots> slots = new ArrayList<Slots>();

          static boolean checkID(long ID){
             for(int i=0;i<citizens.size();i++){
                 Citizen c=citizens.get(i);
                 if(ID == c.getID())
                     return false;
             }
             return true;
         }
         static boolean checkvax(String vax){
             for(int i=0;i<vaccines.size();i++){
                 Vaccine v=vaccines.get(i);
                 if(vax.equals(v.getVaccine()))
                     return false;
             }
             return true;
         }

         public static void main(String[] args) {
             Scanner scn = new Scanner(System.in);
             System.out.println("CoWin Portal initialized.... ");
             System.out.println("---------------------------------");
             while (true) {
                 System.out.println("1. Add Vaccine \n" + "2. Register Hospital \n" + "3. Register Citizen \n" + "4. Add Slot for Vaccination \n" + "5. Book Slot for Vaccination \n" + "6. List all slots for a hospital \n" + "7. Check Vaccination Status \n" + "8. Exit\n");
                 int n = scn.nextInt();
                 if (n == 8)
                     break;
                 if (n == 1) {
                     System.out.print("Vaccine Name: ");
                     String vaccine = scn.next();
                     Boolean flag=checkvax(vaccine);
                     if(flag){
                         System.out.print("Number of doses: ");
                         int doses = scn.nextInt();
                         int gap;
                         if(doses==1)
                             gap=0;
                         else {
                             System.out.print("Gap between Doses: ");
                             gap = scn.nextInt();
                         }
                         Vaccine vax = new Vaccine(vaccine, doses, gap);
                         vaccines.add(vax);
                         vax.displayInfo();
                     }
                     else {
                         System.out.println("Vaccine was already registered");
                         continue;
                     }
                 }
                 if (n == 2) {
                     System.out.print("Hospital Name: ");
                     String hospital_name = scn.next();
                     System.out.print("PinCode: ");
                     int pincode = scn.nextInt();
                     RegHospital hospital = new RegHospital(hospital_name, pincode);
                     hospitals.add(hospital);
                     hospital.display();
                 }
                 if (n == 3) {
                     System.out.print("Citizen Name : ");
                     String name = scn.next();
                     System.out.print("Age: ");
                     int age = scn.nextInt();
                     System.out.print("Unique ID: ");
                     long ID = scn.nextLong();
                     boolean check = checkID(ID);
                     if(check) {
                         Citizen cit = new Citizen(name, age, ID);
                         citizens.add(cit);
                         cit.display();
                     }
                     else
                     {
                         System.out.println("Citizen was already registered");
                     }
                 }
                 if (n == 4) {
                     System.out.print("Enter Hospital ID: ");
                     int ID = scn.nextInt();
                     System.out.print("Enter number of Slots to be added: ");
                     int slot_no = scn.nextInt();
                     int a = 1;
                     while (a++ <= slot_no) {
                         System.out.print("Enter Day Number: ");
                         int day_no = scn.nextInt();
                         System.out.print("Enter Quantity: ");
                         int q = scn.nextInt();
                         System.out.println("Select vaccine: ");
                         for (int i = 0; i < vaccines.size(); i++) {
                             Vaccine vax = vaccines.get(i);
                             System.out.println(i + ". " + vax.getVaccine());
                         }
                         int choice = scn.nextInt();
                         Vaccine vax = vaccines.get(choice);
                         String v = vax.getVaccine();


                         for (int i = 0; i < hospitals.size(); i++) {
                             RegHospital h = hospitals.get(i);
                             if (h.getID() == ID)
                                 h.setSlot(day_no, q, v, a);
                         }
                     }
                     System.out.println("-----------------------");
                 }
                 if (n == 5) {
                     System.out.print("Enter patient Unique ID: ");
                     long ID = scn.nextLong();
                     String name_;

                     System.out.println("1. Search by area \n" + "2. Search by Vaccine \n" + "3. Exit");
                     System.out.println("Enter option: ");
                     int choice = scn.nextInt();
                     if (choice == 3)
                         continue;
                     else if (choice == 1) {
                         System.out.print("Enter PinCode: ");
                         int code = scn.nextInt();
                         for (int i = 0; i < hospitals.size(); i++) {
                             RegHospital h = hospitals.get(i);
                             if (h.getPincode() == code) {
                                 System.out.println(h.getID() + ". " + h.getHospital_name());
                             }
                         }

                         System.out.print("Enter hospital ID: ");
                         int id = scn.nextInt();
                         ArrayList<Slots> potential_slots = new ArrayList<Slots>();
                         int l = 0;
                         for (int j = 0; j < slots.size(); j++) {

                             boolean flag = true;
                             boolean flag2=true;
                             boolean flag3=true;
                             Slots s = slots.get(j);
                             if (s.getId() == id) {
                                 for (int i = 0; i < citizens.size(); i++) {
                                     Citizen c = citizens.get(i);
                                     if (c.getID() == ID) {
                                         String status = c.getStatus();
                                         if (status.equals("PARTIALLY VACCINATED") ) {
                                             if (c.getDue_date() > s.getDay_no()) {
                                                 flag = false;
                                             }
                                             if(c.getStatus().equals("PARTIALLY VACCINATED") && !c.getVax_given().equals(s.getVaccine())){
                                                 flag =false;
                                             }
                                             if(s.getQ()==0)
                                                 flag = false;
                                         }

                                         if (status.equals("FULLY VACCINATED")){
                                             System.out.println("Citizen is fully vaccinated");
                                             flag =false;
                                             flag2=false;
                                             flag3=false;
                                             break;
                                         }
                                     }
                                     if(!flag2)
                                         break;
                                 }
                                 if (flag == true) {
                                     System.out.println(l + "-> " + "Day: " + s.getDay_no() + " Available quantity " + s.getQ() + " Vaccine " + s.getVaccine());
                                     potential_slots.add(s);
                                     l++;
                                 }
                             }
                             if(!flag3)
                                 break;
                         }
                         if (potential_slots.size() == 0) {
                             System.out.println("No slots available");

                         } else {
                             System.out.println("Choose slot :");
                             int res = scn.nextInt();
                             Slots s_ = potential_slots.get(res);

                             s_.setQ(s_.getQ() - 1);
                             for (int i = 0; i < citizens.size(); i++) {
                                 Citizen c = citizens.get(i);
                                 if (c.getID() == ID) {
                                     name_ = c.getName();
                                     System.out.println(name_ + " vaccinated with " + s_.getVaccine());

                                     for (int k = 0; k < vaccines.size(); k++) {
                                         Vaccine v = vaccines.get(k);
                                         if (v.getVaccine() == s_.getVaccine()) {
                                             c.setDue_date(s_.getDay_no() + v.getGap());
                                             c.given_vaccine(v,s_.getVaccine());
                                         }
                                     }
                                 }
                             }
                             for (int j = 0; j < citizens.size(); j++) {
                                 Citizen c = citizens.get(j);
                                 if (c.getID() == ID) {
                                     if (c.getStatus() .equals( "REGISTERED")) {
                                         c.setStatus("PARTIALLY VACCINATED");
                                     } else if (c.getStatus().equals( "PARTIALLY VACCINATED"))
                                         c.setStatus("FULLY VACCINATED");
                                 }
                             }
                         }
                     } else if (choice == 2) {
                         System.out.print("Enter Vaccine name: ");
                         String vax = scn.next();
                         for (int i = 0; i < slots.size(); i++) {
                             Slots s = slots.get(i);

                             if (s.getVaccine().equals(vax)) {
                                 int id = s.getId();
                                 for (int j = 0; j < hospitals.size(); j++) {
                                     RegHospital h = hospitals.get(j);
                                     if (id == h.getID()) {
                                         System.out.println(id + " " + h.getHospital_name());
                                     }
                                 }
                             }
                         }
                         System.out.print("Enter hospital ID: ");
                         int id = scn.nextInt();
                         ArrayList<Slots> potential_slots = new ArrayList<Slots>();
                         int l = 0;
                         for (int j = 0; j < slots.size(); j++) {

                             boolean flag = true;
                             boolean flag2 = true;
                             boolean flag3 = true;
                             Slots s = slots.get(j);
                             if (s.getId() == id) {
                                 for (int i = 0; i < citizens.size(); i++) {
                                     Citizen c = citizens.get(i);
                                     if (c.getID() == ID) {
                                         String status = c.getStatus();
                                         if (status.equals("PARTIALLY VACCINATED")) {
                                             if (c.getDue_date() > s.getDay_no()) {
                                                 flag = false;
                                             }
                                             if (c.getStatus().equals("PARTIALLY VACCINATED") && !c.getVax_given().equals(s.getVaccine())) {
                                                 flag = false;
                                             }
                                             if(s.getQ()==0)
                                                 flag = false;
                                         }
                                         if (status.equals("FULLY VACCINATED")) {
                                             System.out.println("Citizen is fully vaccinated");
                                             flag = false;
                                             flag2 = false;
                                             flag3 = false;
                                             break;
                                         }
                                     }
                                     if (!flag2)
                                         break;
                                 }
                                 if (flag == true && s.getVaccine().equals(vax)) {
                                     System.out.println(l + "-> " + "Day: " + s.getDay_no() + " Available quantity " + s.getQ() + " Vaccine " + s.getVaccine());
                                     potential_slots.add(s);
                                     l++;
                                 }
                             }
                             if (!flag3)
                                 break;
                         }
                         if (potential_slots.size() == 0) {
                             System.out.println("No slots available");

                         } else {
                             System.out.print("Choose slot :");
                             int res = scn.nextInt();
                             Slots s_ = potential_slots.get(res);
                             s_.setQ(s_.getQ() - 1);
                             for (int i = 0; i < citizens.size(); i++) {
                                 Citizen c = citizens.get(i);
                                 if (c.getID() == ID) {
                                     name_ = c.getName();
                                     System.out.println(name_ + " vaccinated with " + s_.getVaccine());

                                     for (int k = 0; k < vaccines.size(); k++) {
                                         Vaccine v = vaccines.get(k);
                                         if (v.getVaccine() == s_.getVaccine()) {
                                             c.setDue_date(s_.getDay_no() + v.getGap());
                                             c.given_vaccine(v, s_.getVaccine());
                                         }
                                     }
                                 }
                             }
                             for (int j = 0; j < citizens.size(); j++) {
                                 Citizen c = citizens.get(j);
                                 if (c.getID() == ID) {
                                     if (c.getStatus().equals("REGISTERED")) {
                                         c.setStatus("PARTIALLY VACCINATED");
                                     } else if (c.getStatus().equals("PARTIALLY VACCINATED"))
                                         c.setStatus("FULLY VACCINATED");
                                 }
                             }
                         }
                     }
                     System.out.println("----------------------------");
                 }
                 if (n == 6) {
                     System.out.print("Enter Hospital Id: ");
                     int id = scn.nextInt();
                     for (int i = 0; i < slots.size(); i++) {
                         Slots s = slots.get(i);
                         if (s.getId() == id) {
                             System.out.println("Day: " + s.getDay_no() + " Vaccine: " + s.getVaccine() + " Available Qty: " + s.getQ());

                         }
                     }
                     System.out.println("----------------------------");
                 }
                 if (n == 7) {
                     System.out.print("Enter Patient ID: ");
                     long id = scn.nextLong();

                     for (int i = 0; i < citizens.size(); i++) {
                         Citizen c = citizens.get(i);
                         if (id == c.getID())
                             c.Status();

                     }
                     System.out.println("------------------------------");
                 }
             }
         }
     }


