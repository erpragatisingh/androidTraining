package pragati.day;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

public class DiffDate extends WindowAdapter implements ActionListener
{

	Frame f;
	Button b2;
	TextField t1;
	  DiffDate(String s)
	  {
		   f=new Frame(s);
		   b2=new Button("Show Dif");
		   t1=new TextField();
		 
		   b2.setBounds(150, 200,50, 50);
		   t1.setBounds(200, 250,50, 50);
		   
		
		   f.add(b2);
		   f.add(t1);
		
		   b2.addActionListener(this);
		   f.addWindowListener(this);
		   f.setLayout(null);
		   f.setSize(200, 200);
		   f.setVisible(true);
	  }
	 Date a=new Date();
	  long old=a.getTime();
	public void actionPerformed(ActionEvent e)
	{
		Date d=new Date();
		
		long dif=0;
	       
	   if(b2==e.getSource())
	   {
		    
		   long l=d.getTime();
		   dif=old-l;
		   
		   double d1=(double)Math.floor(dif);
		   t1.setText(""+d1);
		   old=l;
		    
	      }
	   
		
	}
 @Override
public void windowClosing(WindowEvent e) {

	  System.exit(0);
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DiffDate d=new DiffDate("Frm");
		
		
		

	}

	



}
