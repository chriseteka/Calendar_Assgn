
package calendar_assgn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RequiredFunctions {
    
    public String formattedDiff;
    public String defFormatted;
    
    
    //FUNCTION I USED FOR MY DATE DIFFERENCE AND CONVERSIONS
    public void setElapsedTime(String refDate, String currentDate)
    {
        int diffDays;
        String date1 = refDate;
        String date2 = currentDate;
        String format = "yyyy-mm-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dateObj1;
        Date dateObj2;
        try 
        {
            dateObj1 = sdf.parse(date1);
            dateObj2 = sdf.parse(date2);
            long diff = dateObj2.getTime() - dateObj1.getTime();
            
            diffDays =  (int) Math.round((float)diff / (24* 1000 * 60 * 60));
            
            //CONVERT THE NUMBER OF DAYS PICKED TO YY:MM:DD(HH:mm:ss)
            int yearDiff, monthDiff, daysDiff, weekDiff, tempHolder, tempHolder2;
            if(diffDays != 0)
            {
                yearDiff = (diffDays / 365);
                tempHolder = (diffDays % (360));
                monthDiff = (tempHolder / 30);
                tempHolder2 = (tempHolder % 30);
                weekDiff = (tempHolder2 / 7);
                daysDiff = (tempHolder2 % 7);
                formattedDiff = yearDiff + " : " + monthDiff + " : " + weekDiff + " : " + daysDiff + " (0. 0. 0)";
            }
            else
            {
                defFormatted = "00 : 00 : 00 (0. 0. 0)";
            }
        } catch (ParseException ex) {
            Logger.getLogger(calendarGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //FUNCTION THAT SETS THE DATE BASED ON ELAPSED TIME ENTERED
    public void setDateByElapsedTime(List<Integer> userEntries, List<Integer> currentDate)
    {
        NewD d = new NewD();
        int yearDiff, monthDiff, dayDiff;
        
        if((currentDate.get(2) < userEntries.get(2)) || (currentDate.get(1) < userEntries.get(1)))
        {
            
            if((currentDate.get(2) < userEntries.get(2)) && (currentDate.get(1) < userEntries.get(1)))
            {
                int yearTempHolder = (currentDate.get(0) - 1);
                int monthTempHolder = (currentDate.get(1) + 11);
                int dayTempHolder = (currentDate.get(2) + 30);
                
                yearDiff = (yearTempHolder - userEntries.get(0));
                monthDiff = (monthTempHolder - userEntries.get(1));
                dayDiff = (dayTempHolder - userEntries.get(2));
                
                d.dateChanger(monthDiff, dayDiff, yearDiff);
                d.setVisible(true);
            }
            else if((currentDate.get(2) < userEntries.get(2)))
            {
                int dayTempHolder = (currentDate.get(2) + 30);
                int monthTempHolder = (currentDate.get(1) - 1);

                yearDiff = (currentDate.get(0) - userEntries.get(0));
                monthDiff = (monthTempHolder - userEntries.get(1));
                dayDiff = (dayTempHolder - userEntries.get(2));
                
                d.dateChanger(monthDiff, dayDiff, yearDiff);
                d.setVisible(true);
                
            }
            else if((currentDate.get(1) < userEntries.get(1)))
            {
                int monthTempHolder = (currentDate.get(1) + 12);
                int yearTempHolder = (currentDate.get(0) - 1);
                
                yearDiff = (yearTempHolder - userEntries.get(0));
                monthDiff = (monthTempHolder - userEntries.get(1));
                dayDiff = (currentDate.get(2) - userEntries.get(2));
                
                d.dateChanger(monthDiff, dayDiff, yearDiff);
                d.setVisible(true);
            }
        }
        else
        {
            yearDiff = (currentDate.get(0) - userEntries.get(0));
            monthDiff = (currentDate.get(1) - userEntries.get(1));
            dayDiff = (currentDate.get(2) - userEntries.get(2));
            
            d.dateChanger(monthDiff, dayDiff, yearDiff);
            d.setVisible(true);
        }
        
        
    }
    
    //THIS CHECKS THE VALUE ENTERED BY USER AND SETS IT INTO A LIST
    public List<Integer> validateEntryInElapseDate(int years, int months, int weeks, int days, List<Integer> Date)
    {
        List<Integer> userEnteries = new ArrayList<>();
        
        //CHANGE WEEKS TO DAYS
        days += (weeks * 7);

        //ADD THE ENTERIES TO A LIST
        userEnteries.add(years);
        userEnteries.add(months);
        userEnteries.add(days);

        //INFORM THE USER HIS INPUTS WERE ACCEPTED AND BEING PROCESSED
        JOptionPane.showMessageDialog(null, "YOU INPUTS ARE CURRENTLY BEING PROCESSED");

        //CALL TO THE METHOD THAT DOES THE COMPUTATION AND OUTPUTTING
        setDateByElapsedTime(userEnteries, Date);

        return userEnteries;
    }
    
}
