
package calendar_assgn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class calendarGUI extends javax.swing.JFrame {
    
    //CALL ON THE FUNCTIONS IN HAVE USED IN HERE
    RequiredFunctions require = new RequiredFunctions();
    NewD1 d = new NewD1();
    
    //VARIABLES USED IN THIS CLASS
    static int currYear, currDOM, currentMonth;
    String startUpDate, startUpTime;
    String formattedRefDate, formattedCurrentDate;
    List<Integer> gatherAsInt = new ArrayList<>();
    int nod, som;
    
    public calendarGUI() 
    {
        initComponents();
    JPanel borderPanel2 = new JPanel();
    borderPanel2.setLayout(new BorderLayout());
    getContentPane().add(borderPanel2);
    
    GregorianCalendar cal = new GregorianCalendar();
    int currYear = cal.get(GregorianCalendar.YEAR);
    int currDOM = cal.get(GregorianCalendar.DAY_OF_MONTH);
    int currMnth = cal.get(GregorianCalendar.MONTH);
    
    
    int second = cal.get(GregorianCalendar.SECOND);
    int minute = cal.get(GregorianCalendar.MINUTE);
    int hour = cal.get(GregorianCalendar.HOUR_OF_DAY);
    
    currentMonth = currMnth;
    String StringMnth = "";
        switch(currMnth) 
        {
            case 0: StringMnth = "January"; break;
            case 1: StringMnth = "February"; break;
            case 2: StringMnth = "March"; break;
            case 3: StringMnth = "April"; break;
            case 4: StringMnth = "May"; break;
            case 5: StringMnth = "June"; break;
            case 6: StringMnth = "July"; break;
            case 7: StringMnth = "August"; break;
            case 8: StringMnth = "September"; break;
            case 9: StringMnth = "October"; break;
            case 10: StringMnth = "November"; break;
            case 11: StringMnth = "December"; break;
        }
    cal.set(GregorianCalendar.DATE, 1);
    nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH); //Number of Days
    som = (cal.get(GregorianCalendar.DAY_OF_WEEK) - GregorianCalendar.SUNDAY + 7)%7; // Start of the Month
    
    // Button Layout
    final int ROWS = 7;
    final int COLS = 7;
    JButton[][] days;
    JPanel calendar = new JPanel();
    calendar.setLayout(new GridLayout(7,7));
    days = new JButton[ROWS][COLS];
    for(int row = 0; row < ROWS; row++) 
    {
        for(int col = 0; col < COLS; col++) 
        {
            days[row][col] = new JButton("");
            calendar.add(days[row][col]);
        }
    }

    // Add Some Number to the Buttons
    int[] tableMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    int startDay = som + 7;
    days[0][0].setText("SUN");
    days[0][1].setText("MON");
    days[0][2].setText("TUE");
    days[0][3].setText("WED");
    days[0][4].setText("THU");
    days[0][5].setText("FRI");
    days[0][6].setText("SAT");
    int daysInMonth = tableMonth[currMnth];
    for(int i = 0; i < daysInMonth; i++)
    {
        days[(startDay + i)/7][(startDay + i) % 7].setText("" + (i + 1));
        
        //TRYING TO HIGHLIGHT THE CURRENTLY DISPLAYED DATE
        if(days[(startDay + i)/7][(startDay + i) % 7].getText().equalsIgnoreCase(Integer.toString(currDOM)))
        {
             days[(startDay + i)/7][(startDay + i) % 7].setBackground(new Color(255, 255, 153));
        }
    }
    borderPanel2.add(calendar, BorderLayout.SOUTH);
    
    //SET FIELDS IN THE GUI
    //FORMAT THE REFERENCE DATE AND CURRENT DATE TO BE OF THE FORM "YYYY-MM-WW-DD(0.0.0)"
    int currMont = currMnth + 1;
    gatherAsInt.add(currYear);
    gatherAsInt.add(currMont);
    gatherAsInt.add(currDOM);
    formattedCurrentDate = currYear + "-" + currMont + "-" + currDOM;
    formattedRefDate = currYear + "-" + currMont + "-" + currDOM;
    
    
    startUpDate = StringMnth + " " + currDOM + ", " + currYear;
    startUpTime = hour + " : " + minute + " : " + second;
    currentDate.setText(startUpDate);
    referenceDate.setText(startUpDate +"    ("+ startUpTime +")");
    
    }
    
    //THIS IS USED FOR CHECKING IF A PARSED DATE IS VALID
    class GregorianDateMatcher implements DateMatcher 
    {
        public Pattern DATE_PATTERN = Pattern.compile(
          "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
          + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
          + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
          + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");
 
        @Override
        public boolean matches(String date) 
        {
            return DATE_PATTERN.matcher(date).matches();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borderPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        referenceDate = new javax.swing.JTextField();
        gotoButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        elapsedTime = new javax.swing.JTextField();
        currentDate = new javax.swing.JTextField();
        setReference = new javax.swing.JButton();
        goButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calendar");
        setPreferredSize(new java.awt.Dimension(450, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        borderPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("DATE:");
        borderPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));
        borderPanel.add(referenceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 220, 30));

        gotoButton.setText("GOTO A DATE");
        gotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoButtonActionPerformed(evt);
            }
        });
        borderPanel.add(gotoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 3, 120, 40));

        jLabel2.setText("TIME FROM REFERENCE DATE:");
        borderPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 30));

        elapsedTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        borderPanel.add(elapsedTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 220, 30));

        currentDate.setEditable(false);
        currentDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        currentDate.setBorder(null);
        borderPanel.add(currentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 140, 30));

        setReference.setText("SET AS REF.");
        setReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setReferenceActionPerformed(evt);
            }
        });
        borderPanel.add(setReference, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 110, 30));

        goButton.setText("GO");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        borderPanel.add(goButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 100, 60, 30));

        getContentPane().add(borderPanel, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //DISPLAYS THE DIFFERENCE IN DISPLAY TIME AND REFERENCE TIME ON STARTUP
        require.setElapsedTime(formattedRefDate, formattedCurrentDate);
        elapsedTime.setText(require.defFormatted);
        
    }//GEN-LAST:event_formWindowOpened

    private void gotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoButtonActionPerformed
        GregorianDateMatcher GDM = new GregorianDateMatcher();
        String temp;
        if(referenceDate != null)
        {
            temp = referenceDate.getText().replaceAll("//s", "");
            if(GDM.matches(temp))
            {
                String inputtedYear = temp.substring(0, 4);
                String inputtedMonth = temp.substring(5, 7);
                String inputtedDay = temp.substring(8, 10);
                
                int newYear = Integer.parseInt(inputtedYear);
                int newMonth = Integer.parseInt(inputtedMonth);
                int newDay = Integer.parseInt(inputtedDay);
                
                d.dateChanger(newMonth, newDay, newYear);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "PATTERN MISMATCH, INPUTS SHOULD BE OF THE FORM YYYY-MM-DD");
                currentDate.setText(startUpDate);
                referenceDate.setText(startUpDate +"    ("+ startUpTime +")");
            }
        }
    }//GEN-LAST:event_gotoButtonActionPerformed

    private void setReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setReferenceActionPerformed
        GregorianDateMatcher GDM = new GregorianDateMatcher();
        if(referenceDate != null)
        {
            String temp = referenceDate.getText().replaceAll("//s", "");
            if(GDM.matches(temp))
            {
                //SPLIT INPUT AND GET READY FOR COMPARISM
                String inputtedYear = temp.substring(0, 4);
                String inputtedMonth = temp.substring(5, 7);
                String inputtedDay = temp.substring(8, 10);
                
                if(currDOM == Integer.parseInt(inputtedDay) && currentMonth == (Integer.parseInt(inputtedMonth) - 1)
                        && currYear == Integer.parseInt(inputtedYear))
                {
                    JOptionPane.showMessageDialog(this, "CANNOT SAVE DATE, AS NO CHANGES HAVE BEEN MADE");
                }
                else
                {
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.set(GregorianCalendar.YEAR, Integer.parseInt(inputtedYear));
                    cal.set(GregorianCalendar.MONTH, Integer.parseInt(inputtedMonth));
                    cal.set(GregorianCalendar.DATE, Integer.parseInt(inputtedDay));
                    
                    String saveDay = Integer.toString(cal.get(GregorianCalendar.DATE));
                    String saveMonth = Integer.toString(cal.get(GregorianCalendar.MONTH));
                    String saveYear = Integer.toString(cal.get(GregorianCalendar.YEAR));
                    
                    String StringMnth = "";
                        switch((Integer.parseInt(saveMonth) - 1)) 
                        {
                            case 0: StringMnth = "January"; break;
                            case 1: StringMnth = "February"; break;
                            case 2: StringMnth = "March"; break;
                            case 3: StringMnth = "April"; break;
                            case 4: StringMnth = "May"; break;
                            case 5: StringMnth = "June"; break;
                            case 6: StringMnth = "July"; break;
                            case 7: StringMnth = "August"; break;
                            case 8: StringMnth = "September"; break;
                            case 9: StringMnth = "October"; break;
                            case 10: StringMnth = "November"; break;
                            case 11: StringMnth = "December"; break;
                        }
                    
                    String startUpDate1 = StringMnth + " " + saveDay + ", " + saveYear;
                    String startUpTime1 = "00 : 00 : 00";
                    referenceDate.setText(startUpDate1 +"    ("+ startUpTime1 +")");
                    JOptionPane.showMessageDialog(this, "YOU HAVE SUCCESSFULLY CHANGED YOUR REFERENCE DATE");
                    
                    //GETTING THE TWO DIFFERENT TIMES READY FOR CONVERSION
                    String formattedRefDate = saveYear +"-"+ saveMonth +"-"+ saveDay;
                    //GETTING DIFFERENCE WITH RESPECT TO CURRENT DATE
                    require.setElapsedTime(formattedRefDate, formattedCurrentDate);
                    elapsedTime.setText(require.formattedDiff);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "PATTERN MISMATCH, INPUTS SHOULD BE OF THE FORM YYYY-MM-DD");
                currentDate.setText(startUpDate);
                referenceDate.setText(startUpDate +"    ("+ startUpTime +")");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "NO INPUTS RECEIVED, INPUTS SHOULD BE OF THE FORM YYYY-MM-DD");
            currentDate.setText(startUpDate);
            referenceDate.setText(startUpDate +"    ("+ startUpTime +")");
        }
    }//GEN-LAST:event_setReferenceActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        //BEGIN
        NewD d = new NewD();
        String temp;
        String dateInputPattern1 = "^\\d{3}-\\d{2}-\\d{2}-\\d{2}$";
        String dateInputPattern2 = "^\\d{2}-\\d{2}-\\d{2}-\\d{2}$";
        if(elapsedTime != null)
        {
            temp = elapsedTime.getText().replaceAll("//s", "");
            if(temp.matches(dateInputPattern1))
            {
                //SPLIT INPUT AND GET READY FOR COMPARISM
                String inputtedYears = temp.substring(0, 3);
                String inputtedMonth = temp.substring(4, 6);
                String inputtedWeek = temp.substring(7, 9);
                String inputtedDay = temp.substring(10, 12);
                
                //CONVERT THESE INPUTS TO INTEGERS
                int newYear = Integer.parseInt(inputtedYears);
                int newMonth = Integer.parseInt(inputtedMonth);
                int newWeek = Integer.parseInt(inputtedWeek);
                int newDay = Integer.parseInt(inputtedDay);
                
                require.validateEntryInElapseDate(newYear, newMonth, newWeek, newDay, gatherAsInt);
                this.dispose();
            }
            else if(temp.matches(dateInputPattern2))
            {
                //SPLIT INPUT AND GET READY FOR COMPARISM
                String inputtedYears = temp.substring(0, 2);
                String inputtedMonth = temp.substring(3, 5);
                String inputtedWeek = temp.substring(6, 8);
                String inputtedDay = temp.substring(9, 11);
                
                //CONVERT THESE INPUTS TO INTEGERS
                int newYear = Integer.parseInt(inputtedYears);
                int newMonth = Integer.parseInt(inputtedMonth);
                int newWeek = Integer.parseInt(inputtedWeek);
                int newDay = Integer.parseInt(inputtedDay);
                
                require.validateEntryInElapseDate(newYear, newMonth, newWeek, newDay, gatherAsInt);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "PATTERN MISMATCH, INPUTS SHOULD BE OF THE FORM: \n"
                                                    + "yyy-mm-ww-dd \nOR \nyy-mm-ww-dd");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "PATTERN MISMATCH, INPUTS SHOULD BE OF THE FORM: \n"
                                                    + "yyy-mm-ww-dd \nOR \nyy-mm-ww-dd");
        }
    }//GEN-LAST:event_goButtonActionPerformed

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calendarGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel borderPanel;
    public javax.swing.JTextField currentDate;
    public javax.swing.JTextField elapsedTime;
    private javax.swing.JButton goButton;
    public javax.swing.JButton gotoButton;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JTextField referenceDate;
    private javax.swing.JButton setReference;
    // End of variables declaration//GEN-END:variables
}
