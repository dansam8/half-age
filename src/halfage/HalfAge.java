
package halfage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;


public class HalfAge {
    

    public static void main(String[] args) {
        
        HalfAge halfAge = new HalfAge();
        String halfDate = halfAge.makeDateReadable();
        
        System.out.println("The younger person will be half the age of the older person on " + halfDate);
    }
        
    public Date convertToDate(int day, int month, int year) {

        Calendar cal = new GregorianCalendar();
        
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month+1);
        cal.set(Calendar.YEAR, year);
        
        Date date = cal.getTime();
        
        return date;

    }
    
    public int input(String message){
        
        int input = Integer.parseInt(JOptionPane.showInputDialog(message));
        
        return input;
        
    }
    
    public Date captureDate(String message){
        
        int day = input("Enter "+ message +"'s day of birth");
        
        int month = input("Enter "+ message +"'s month of birth");
        
        int year = input("Enter "+ message +"'s year of birth");
        
        Date date = convertToDate(day, month, year);
        
        return date;
        
    }
    
    public Date[] captureDates(){
    
        Date[] dates = new Date[2];
                
        dates[0] = captureDate("person1");
        
        dates[1] = captureDate("person2");
        
        return dates;

    }
    
    public Date[] dateOrderOlderFirst(){
        
        Date[] dates = captureDates();
        
        Date date1 = dates[0];
        
        Date date2 = dates[1];
      
       
        if(date1.getTime() > date2.getTime()) {
            
             dates[0] = date2;
             dates[1] = date1;
  
        }
        
        return dates;

    }
    
    public Date calculations(){
        
        Date[] dates = dateOrderOlderFirst();
        
        long old = dates[0].getTime();
        long young = dates[0].getTime();
        
        long difference = old - young;
        long finalMill = difference + young;
        
        Date finalDate = new Date(finalMill);
        
        return finalDate;
        
    }
    
    public String makeDateReadable(){
        
        Date date = calculations();
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-mm-yyyy");
        
        String output = sdt.format(date);
        
        return output;
        
    }
    
}