
package calendar_assgn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NewD1 extends javax.swing.JFrame {
    
    RequiredFunctions require = new RequiredFunctions();
    String formattedCurrentDate, formattedRefDate;
    
    public NewD1() {
        initComponents();
    }
     
    int nod, som;
    public void dateChanger(int month, int day, int year)
    {
        this.setSize(450,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Calendar");
        
        JPanel borderPanel3 = new JPanel();
        borderPanel3.setLayout(new BorderLayout());
        getContentPane().add(borderPanel3);
        
        int monthCheck = (month - 1);
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(GregorianCalendar.YEAR, year);
        cal.set(GregorianCalendar.MONTH, monthCheck);
        cal.set(GregorianCalendar.DATE, 1);
        
        
        int useMonth = cal.get(GregorianCalendar.MONTH);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH); //Number of Days
        som = (cal.get(GregorianCalendar.DAY_OF_WEEK) - GregorianCalendar.SUNDAY + 7)%7; // Start of the Month
        
        String StringMnth = "";
        switch(monthCheck) 
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
    int daysInMonth = tableMonth[useMonth];
    for(int i = 0; i < daysInMonth; i++)
    {
        days[(startDay + i)/7][(startDay + i) % 7].setText("" + (i + 1));
        
        //TRYING TO HIGHLIGHT THE CURRENTLY DISPLAYED DATE
        if(days[(startDay + i)/7][(startDay + i) % 7].getText().equalsIgnoreCase(Integer.toString(day)))
        {
             days[(startDay + i)/7][(startDay + i) % 7].setBackground(new Color(255, 255, 153));
        }
    }
    borderPanel3.add(calendar, BorderLayout.SOUTH);
    
    //SET FIELDS IN THE GUI
    //FORMAT THE REFERENCE DATE AND CURRENT DATE TO BE OF THE FORM "YYYY-MM-WW-DD(0.0.0)"
    int currMont = month;
    formattedCurrentDate = year + "-" + currMont + "-" + day;
    formattedRefDate = year + "-" + currMont + "-" + day;
    
    String startUpDate = StringMnth + " " + day + ", " + year;
    String startUpTime = "(00 : 00 : 00)";
    currentDate.setText(startUpDate);
    referenceDate.setText(startUpDate +"    "+startUpTime);
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
        currentDate = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        currentDate.setEditable(false);
        currentDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        currentDate.setBorder(null);
        borderPanel.add(currentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 130, 30));

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        borderPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 110, 30));

        getContentPane().add(borderPanel, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoButtonActionPerformed
        GregorianDateMatcher GDM = new GregorianDateMatcher();
        NewD d = new NewD();
        String temp;
        //        String dateInputPattern = "^\\d{4}-\\d{2}-\\d{2}$";
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
            }
        }
    }//GEN-LAST:event_gotoButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        calendarGUI calendar = new calendarGUI();
        this.dispose();
        calendar.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(NewD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewD1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    public javax.swing.JPanel borderPanel;
    public javax.swing.JTextField currentDate;
    public javax.swing.JButton gotoButton;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JTextField referenceDate;
    // End of variables declaration//GEN-END:variables
}
