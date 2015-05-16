
package halfage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;


public class HalfAge {
    

    public static void main(String[] args) {
        
        HalfAge halfAge = new HalfAge();
        String halfDate = halfAge.methodCalls();
        
        System.out.println("The younger person will be half the age of the older person on " + halfDate);
    }
    
    public String methodCalls(){
        
        Date[] dates = captureDates();
        dates = dateOrderOlderFirst(dates);
        Date date = calculations(dates);
        return makeDateReadable(date);
     
    }
        
    public Date convertToDate(int day, int month, int year) {

        Calendar cal = new GregorianCalendar();
        
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month-1);
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
    
    public Date[] dateOrderOlderFirst(Date[] dates){
        
        Date date1 = dates[0];
        Date date2 = dates[1];
      
       
        if(date1.getTime() > date2.getTime()) {
            
             dates[0] = date2;
             dates[1] = date1;
        }
        
        return dates;

    }
    
    public Date calculations(Date[] dates){
        
        
        
        long old = dates[0].getTime();
        long young = dates[1].getTime();
        
        long difference = old - young;
        long finalMill = difference + young;
        
        return new Date(finalMill);
         
    }
    
    public String makeDateReadable(Date date){
        
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
        
        return sdt.format(date);
    
    }
        
}