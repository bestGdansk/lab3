import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


public class OknoInterfejsu extends JFrame{
    

   private JButton przyciski[];
   private JTextArea oknoTekstowe;
   private JComboBox wybor;
   private String wybor_str[];
   private double pierwszaLiczba;
   private double drugaLiczba;
   private String wprowadzLiczbe = "";
   private String dzialanie = "";

   private class ObslugaPrzycisku implements ActionListener{

       private JFrame ref_okno;

       ObslugaPrzycisku(JFrame okno){
            ref_okno = okno;
       }

       public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton)e.getSource();
            if(bt==przyciski[0])
            {
                wprowadzLiczbe += "0";
            }
            else if(bt==przyciski[1])
            {
                wprowadzLiczbe += "1";
            }
            else if(bt==przyciski[2])
            {
                wprowadzLiczbe += "2";
            }
            else if(bt==przyciski[3])
            {
                wprowadzLiczbe += "3";
            }
            else if(bt==przyciski[4])
            {
                wprowadzLiczbe += "4";
            }
            else if(bt==przyciski[5])
            {
                wprowadzLiczbe += "5";
            }
            else if(bt==przyciski[6])
            {
                wprowadzLiczbe += "6";
            }
            else if(bt==przyciski[7])
            {
                wprowadzLiczbe += "7";
            }
            else if(bt==przyciski[8])
            {
                wprowadzLiczbe += "8";
            }
            else if(bt==przyciski[9])
            {
                wprowadzLiczbe += "9";
            }
            else if(bt==przyciski[10])
            {
                dzialanie("+");
            }
            else if(bt==przyciski[11])
            {
                dzialanie("-");
            }
            else if(bt==przyciski[12])
            {
                dzialanie("*");
            }
            else if(bt==przyciski[13])
            {
                dzialanie("/");
            }
            else if(bt==przyciski[14])
            {
                wprowadzLiczbe = Double.toString(oblicz());

            }
            else if(bt==przyciski[15])
            {
                wprowadzLiczbe = "";
            }
            oknoTekstowe.setText(wprowadzLiczbe);
        }

   }
   private void dzialanie(String znak)
    {
        pierwszaLiczba = Double.parseDouble(wprowadzLiczbe);
        wprowadzLiczbe = "";
        dzialanie = znak;
    }
    private double oblicz()
    {
        drugaLiczba = Double.parseDouble(wprowadzLiczbe);
        switch (dzialanie) {
            case "+":
                return pierwszaLiczba + drugaLiczba;
            case "-":
                return pierwszaLiczba - drugaLiczba;
            case "*":
                return pierwszaLiczba * drugaLiczba;
            case "/":
                return pierwszaLiczba / drugaLiczba;
            default:
                return drugaLiczba;
        }
    }






   public OknoInterfejsu()
   {
        super("Okno interfejsu");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //-------------------------------------------------------
        przyciski = new JButton[16];
       JPanel panelPrzyciski   = new JPanel(new FlowLayout());
        for(int i = 0; i<10; i++)
        {
            CreateButton(panelPrzyciski, i, Integer.toString(i));
        }
        CreateButton(panelPrzyciski, 10, "+");
        CreateButton(panelPrzyciski, 11, "-");
        CreateButton(panelPrzyciski, 12, "*");
        CreateButton(panelPrzyciski, 13, "/");
        CreateButton(panelPrzyciski, 14, "=");
        CreateButton(panelPrzyciski, 15, "C");


        //-------------------------------------------------------
        oknoTekstowe = new JTextArea("Okno tekstowe\n");


        //-------------------------------------------------------
        Container content       = getContentPane();
        content.setLayout(new BorderLayout());

        content.add(panelPrzyciski,BorderLayout.CENTER);
        content.add(new JScrollPane(oknoTekstowe),BorderLayout.NORTH);
        setVisible(true);
   }
   public void CreateButton(JPanel panel, int i, String content)
   {
       przyciski[i] = new JButton(content);
       przyciski[i].addActionListener(new ObslugaPrzycisku(this));
       panel.add(przyciski[i]);
   }



   public static void main(String args[]){
       new OknoInterfejsu();
   }

}
