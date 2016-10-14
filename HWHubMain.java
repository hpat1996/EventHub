import java.util.*;
import java.io.*;

public class HWHubMain implements UserInterface{

   public static void main(String[] args)throws FileNotFoundException {

      HWHubMain hhm = new HWHubMain();
      hhm.run();

   }

   private Scanner consoleIN;
   private PrintStream consoleOUT;
   private HWHub data;
   private ArrayList<HWHub> database;
   private HubInterface HI;

   public HWHubMain() {
      consoleIN = new Scanner(System.in);
      consoleOUT = new PrintStream(System.out);
      database = new ArrayList<HWHub>();
      HI = new HubInterface();
      data = new HWHub(HI);
   }


   public String nextLine() {
      return consoleIN.nextLine();
   }

   public int nextInt() {
      return consoleIN.nextInt();
   }

   public void print(String message) {
      consoleOUT.print(message);
      consoleOUT.print(" ");
   }

   public void println(String message) {
      consoleOUT.println(message);
   }

   public void println() {
      consoleOUT.println();
   }

   public void run() throws FileNotFoundException {
      String choice = "0";
      while (!choice.equals("5")) {
         choice = HI.in(" 1. Add \n 2. Delete \n 3. Join Group \n 4. Leave Group \n 5. Exit ");
         if (choice.equals("1")) {
            data = new HWHub(HI);
            data.add(database.size() + 1);
            database.add(data);
            HI.Dashboard(database.get(database.size()-1).view());
         } else if (choice.equals("2")) {
            int x = Integer.parseInt(HI.in("Enter Hub ID = "));
            for (int i = 0; i < database.size(); i++) {
               if (database.get(i).search(x)) {
                  if (database.get(i).pass(HI.in("Enter the password = "))) {
                     database.remove(database.get(i));
                     i = database.size();
                     HI.off();
                     HI = new HubInterface();
                     for (HWHub t : database) {
                        HI.Dashboard(t.view());
                     }
                  }
                  else
                     HI.print("Access Denied!");
               }
            }
         } else if (choice.equals("3")) {
            int x = Integer.parseInt(HI.in("Enter Hub ID = "));
            for (HWHub t : database) {
               if (t.search(x))
                  t.join();
            }
            HI.off();
            HI = new HubInterface();
            for (HWHub t : database) {
               HI.Dashboard(t.view());
            }
         } else if (choice.equals("4")) {
            int x = Integer.parseInt(HI.in("Enter Hub ID = "));
            for (HWHub t : database) {
               if (t.search(x))
                  t.leave();
            }
            HI.off();
            HI = new HubInterface();
            for (HWHub t : database) {
               HI.Dashboard(t.view());
            }
         }
      }
      File allData = new File("AllData.txt");
      if (allData.exists()) {
         allData.delete();
      }
      PrintStream write = new PrintStream(new File("AllData.data"));
      for (int i = 0; i < database.size(); i++) {
         write.println(database.get(i).view());
      }
   }
}
