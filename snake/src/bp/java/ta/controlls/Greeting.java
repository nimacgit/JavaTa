package bp.java.ta.controlls;

import bp.java.ta.controlls.DataBase;

import javax.swing.*;

public class Greeting {
    public static String firstName;
    public static void GetName()
    {
        firstName = DataBase.readName();
        while(firstName == null || firstName.equals("")) {
            firstName = JOptionPane.showInputDialog("Enter name");
            if(firstName.equals(""))
                JOptionPane.showMessageDialog(null, "WTF?? Enter a name", "WTF", JOptionPane.PLAIN_MESSAGE);
            else
            {
                JOptionPane.showMessageDialog(null, "Have fun " + firstName + " :)", "good luck", JOptionPane.PLAIN_MESSAGE);
                DataBase.writeName(firstName);
            }
        }
    }
}
