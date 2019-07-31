import java.awt.BorderLayout;      
import java.awt.Container;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.JButton;        
import javax.swing.JFrame;
import javax.swing.JLabel;        
import javax.swing.JPanel;
import javax.swing.JTextField;
   
public class TempConvert implements ActionListener 
{
        private JTextField fahr;
        private JTextField cels;
   
       private TempConvert(JTextField fahr, JTextField cels) {
          this.fahr = fahr; this.cels = cels;
}
   
public void actionPerformed(ActionEvent e) 
{
           if(e.getSource() == fahr) 
	{
               double temp = Double.parseDouble(fahr.getText());
               double val = (temp - 32) / 1.8;
               cels.setText("" + Math.rint(val * 100) / 100);
                   } 
           else if(e.getSource() == cels) 
	{
               double temp = Double.parseDouble(cels.getText());
               double val = 1.8 * temp + 32;
               fahr.setText("" + Math.rint(val * 100) / 100);
                   }
}
   
public static void main(String[] args) 
{
          JTextField fahrField = new JTextField(8);
          JTextField celsField = new JTextField(8);
          JPanel fahrPanel = new JPanel();
          fahrPanel.add(new JLabel("Fahrenheit:"));
          fahrPanel.add(fahrField);
          JPanel celsPanel = new JPanel();
          celsPanel.add(new JLabel("Celsius:"));
          celsPanel.add(celsField);
          TempConvert listener = new TempConvert(fahrField, celsField);
           fahrField.addActionListener(listener);
           celsField.addActionListener(listener);
           JFrame frame = new JFrame("Temperature Conversion");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           Container contents = frame.getContentPane();
           contents.add(fahrPanel, BorderLayout.NORTH);
           contents.add(celsPanel, BorderLayout.SOUTH);
           frame.pack();
          frame.setVisible(true);
      }
   }