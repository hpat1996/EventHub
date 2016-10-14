import java.util.*;

public class HWHub {
   private int id;
   private String name;
   private String event;
   private String time;
   private String place;
   private int max;
   private String description;
   private ArrayList<String> group;
   private String password;
   private HubInterface screen;

   public HWHub(HubInterface ui) {
      id = 0;
      name = "";
      event = "";
      time = "";
      place = "";
      max = 0;
      description = "";
      group = new ArrayList<String>();
      password = "";
      screen = ui;
   }

   public void add(int x) {
      id = x;
      name = screen.in("Enter your name = ");
      event = screen.in("Name = " + name + "\nEnter the event = ");
      time = screen.in("Name = " + name + "\nEvent = " + event + "\nEnter the time for the event = ");
      place = screen.in("Name = " + name + "\nEvent = " + event + "\nTime = " + time + "\nEnter the place for the event = ");
      max = Integer.parseInt(screen.in("Name = " + name + "\nEvent = " + event + "\nTime = " + time + "\nPlace = " + place + "\nEnter the maximum number of people you want in the group = "));
      description = screen.in("Name = " + name + "\nEvent = " + event + "\nTime = " + time + "\nPlace = " + place + "\nMax = " + max + "\nEnter a description for the event = ");
      password = screen.in("Enter a password = ");
   }

   public String view() {
      return ("\t" + id + "\t" + name + "\t" + event + "\t" + time + "\t" + 
              place +"\t" + max + "\t" + description + "\t\t" + group + "\n");
   }

   public void join() {
      if (group.size() < max) {
         group.add(screen.in("Enter your name = "));
      } else {
         screen.println("Sorry the room is full!");
      }
   }

   public void leave() {
      group.remove(screen.in("Enter your name = "));
   }


   public boolean search(int x) {
      return (id == x);
   }
   
   public boolean pass(String pw) {
      return password.equals(pw);
   }
}
