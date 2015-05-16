
package halfage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestHalfAge {
    public static void main(String[] args){
        TestHalfAge tha = new TestHalfAge();
        tha.testMakeDateReadable();
        
        tha.testCalculations();
    }
    
    private Date makeDate(int d, int m, int y){
        Calendar cal = new GregorianCalendar();
        
        cal.set(Calendar.DAY_OF_MONTH, d);
        cal.set(Calendar.MONTH, m-1);
        cal.set(Calendar.YEAR, y);
        
        return cal.getTime();
    }
        
    
    public void testMakeDateReadable(){
        
        
        
        HalfAge halfAge = new HalfAge();
        
        String result = halfAge.makeDateReadable(makeDate(2, 10, 1998));
        
        //System.out.println(result);
        
        boolean pass = "02-10-1998".equals(result);
        System.out.println("MakeDateReadable pass: " + pass);
        
    }
    
    public void testCalculations(){
        
        Date[] dates = new Date[2];
                
        dates[0] = makeDate(1,1,1980);
        
        dates[1] = makeDate(1,1,1990);
        
        HalfAge halfAge = new HalfAge();
        
        System.out.println(halfAge.calculations(dates));
        
        
    }
}
