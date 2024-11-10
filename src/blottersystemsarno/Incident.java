package blottersystemsarno;

import java.util.Scanner;

public class Incident {
    
    public void incidentTransaction(){
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
            
        System.out.println("|-------------------|");    
        System.out.println("|WELCOME TO INCIDENT|");
        System.out.println("|-------------------|");
        System.out.println("");
        System.out.println("1. [ADD INCIDENT]");
        System.out.println("2. [VIEW INCIDENT]");
        System.out.println("3. [UPDATE INCIDENT]");
        System.out.println("4. [DELETE INCIDENT]");
        System.out.println("5. [EXIT]");
        
        System.out.print("Enter Action: ");
        int action = sc.nextInt();
        Incident it = new Incident ();

        switch(action){
            case 1:
                it.addIncidents();
                it.viewIncidents();
                break;
            case 2:       
                it.viewIncidents();
                break;
            case 3:
                
                break;
            case 4:
                
                break;
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }
    
            private void addIncidents(){
                Scanner sc = new Scanner (System.in);   
                config conf = new config();
                
            Complainant cn = new Complainant ();
            cn.viewComplainants();         
        
            System.out.print("Enter the ID of the Complainant: ");
            int cid = sc.nextInt();
        
            String csql = "SELECT c_id FROM tbl_complainant WHERE c_id = ?";
            while(conf.getSingleValue(csql, cid) == 0){
            System.out.print("Complainant does not exist, Select Again: ");
            cid = sc.nextInt();
            
        }
        
            Entry en = new Entry ();
            en.viewEntry();
        
            System.out.print("Enter the ID of the Entry: ");
            int eid = sc.nextInt();
            
            String esql = "SELECT e_id FROM tbl_entry WHERE e_id = ?";
            while(conf.getSingleValue(esql, eid) == 0){
            System.out.print("Entry does not exist, Select Again: ");
            eid = sc.nextInt();
        }
            
            Officer off = new Officer ();
            off.viewOfficers();
        
            System.out.print("Enter the ID of the Officer: ");
            int officerid = sc.nextInt();
            String officersql = "SELECT officer_id FROM tbl_officer WHERE officer_id = ?";
            while(conf.getSingleValue(officersql, officerid) == 0){
            System.out.print("Officer does not exist, Select Again: ");
            officerid = sc.nextInt();
        }
            Suspect st = new Suspect ();
            st.viewSuspects();
        
            System.out.print("Enter the ID of the Suspect: ");
            int sid = sc.nextInt();
            String ssql = "SELECT s_id FROM tbl_suspect WHERE s_id = ?";
            while(conf.getSingleValue(ssql, sid) == 0){
            System.out.print("Suspect does not exist, Select Again: ");
            sid = sc.nextInt();
            sc.nextLine();
            
            
        }
            sc.nextLine();
            
            System.out.print("Incident Type: ");
            String type = sc.nextLine();
                
            System.out.print("Incident Date: ");
            String date = sc.nextLine();
                
            System.out.print("Incident Place: ");
            String place = sc.nextLine();
   
            
            String qry = "INSERT INTO tbl_incident (c_id, e_id, officer_id, s_id, i_type, i_date, i_place)"
                 + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            conf.addRecord(qry, cid, eid, officerid, sid, type, date, place);
   
    }  
            public void viewIncidents() {
        
        String qry = "SELECT i.i_id, e.e_id, e.e_time, e.e_date, o.officer_name, o.officer_department, "
           + "c.c_name, c.c_address, s.s_name, s.s_address, i.i_type, i.i_date, i.i_place, e.e_status "
           + "FROM tbl_incident i "
           + "LEFT JOIN tbl_complainant c ON c.c_id = i.c_id "
           + "LEFT JOIN tbl_entry e ON e.e_id = i.e_id "
           + "LEFT JOIN tbl_officer o ON o.officer_id = i.officer_id "
           + "LEFT JOIN tbl_suspect s ON s.s_id = i.s_id";

                
                


        String[] hrds = {"I_ID", "EntryNumber", "EntryTime", "EntryDate", "OfficerName", "Department" ,"Complainant" , "Address", "Suspect", "Address", "Incident Type", "Date", "Place", "EntryStatus"};
        String[] clms = {"i_id", "e_id", "e_time", "e_date", "officer_name", "officer_department", "c_name", "c_address", "s_name", "s_address", "i_type", "i_date", "i_place", "e_status"};
        config conf = new config();
        conf.viewRecords(qry, hrds, clms);
    
    }
}