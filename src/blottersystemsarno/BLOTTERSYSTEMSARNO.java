package blottersystemsarno;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Scanner;


public class BLOTTERSYSTEMSARNO {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);    
        boolean exit = true;
        do{
        System.out.println("|----------------------------------------------------------|");    
        System.out.println("|                 WELCOME TO BLOTTER SYSTEM                |");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("");
        System.out.println("1. [COMPLAINANT]");
        System.out.println("2. [ENTRY]");
        System.out.println("3. [OFFICER]");
        System.out.println("4. [SUSPECT]");
        System.out.println("5. [INCIDENT]");
        System.out.println("6. [EXIT]");
        
        System.out.print("Enter Action: ");
        int act = sc.nextInt();
        
        switch(act){
            case 1:
                Complainant cn = new Complainant ();
                cn.cTransaction();
            break;
                
            case 2:
                Entry en = new Entry ();
                en.entryTransaction();
            break;
                
            case 3:
                Officer off = new Officer ();
                off.officerTransaction();
            break;
          
            case 4:
                Suspect st = new Suspect ();
                st.sTransaction();
            break;
            
            case 5:
                Incident it = new Incident ();
                it.incidentTransaction();
            break;
            
            case 6:
                System.out.println("ARE YOU SURE? (yes/no): ");
                String resp = sc.next();
                    if(resp.equalsIgnoreCase("yes")){
                           exit = false;
                }
            break;   
            
        }
        }while (exit);
        System.out.print("Thankyouu, See you soon!");               
    
    }
} 