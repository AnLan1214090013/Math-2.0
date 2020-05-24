package math;

import java.awt.*;
import javax.swing.JWindow;
import java.applet.*;
import java.lang.Object;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JRootPane;

public class Login extends JFrame{
	private JFrame fr=null;
	
	private JButton close=null;
	private JButton reg=null;
	private JLabel jl1;
	private JLabel jl2;
	private JButton b_1;
	private JTextField jtf1;
	private JPasswordField jpf1;
	private CheckboxGroup zu;
	private CreateFormula cf;


 


	Login()
	{
		init();
		setBounds();
		addComps();
		addListeners();
		this.getContentPane().add(new JLabel("Just a test."));
		this.setUndecorated(true); 
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setSize(300, 150);
		
	}

	void init()
	{
		fr=new JFrame("ÊýÑ§Ìâ¿â-ByÅíÓî·«&ÍõìûÁú");
		
		jtf1 = new JTextField(10);

        jpf1 = new JPasswordField(10);
        this.setLayout(new GridLayout(3, 1));

		zu=new CheckboxGroup();
		cf=new CreateFormula();
		jl1 = new JLabel(new ImageIcon(getClass().getResource("/math/1.png")));
		jl2 = new JLabel(new ImageIcon(getClass().getResource("/math/circle.gif")));
		b_1=new JButton(new ImageIcon(getClass().getResource("/math/2.png")));
		close=new JButton(new ImageIcon(getClass().getResource("/math/c.png")));
		reg=new JButton(new ImageIcon(getClass().getResource("/math/reg.png")));
	}
	void addComps()
	{

		fr.add(b_1);
		fr.add(close);
		fr.add(reg);
		fr.add(jtf1);
		fr.add(jpf1);
		fr.add(jl2);
		fr.add(jl1);
		LoginListener ll = new LoginListener(fr,jtf1,jpf1);
		b_1.addActionListener(ll);


	}
	
	
	void setBounds()//
	{
		fr.setBounds(448,200,1024,768);
		
		close.setBounds(980,6,30,30);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		reg.setBounds(797,70,156,156);
		reg.setBorderPainted(false);
		reg.setContentAreaFilled(false);
		fr.setUndecorated(true);
		b_1.setBounds(408,680,224,58);
		b_1.setBorderPainted(false);
		b_1.setContentAreaFilled(false);
		jl2.setBounds(0,-72,1024,768);
		jl1.setBounds(0,0,1024,768);
		
		jtf1.setBounds(240,618,224,35);
		jtf1.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",10,30));
		jpf1.setBounds(565,618,224,35);
		jpf1.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",10,30));
		fr.setLayout(null);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


	}
	
	 
       
	void addListeners()
	{
		close.addActionListener(new ActionListener()

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
					}
					});
		reg.addActionListener(new ActionListener()

				{
					public void actionPerformed(ActionEvent e) {
						Jdbcs d = new Jdbcs();
				        String username = jtf1.getText();
				        String password = jpf1.getText();
				        d.insert(username, password);
					}
					});


	}



	void alert(String title,String message)
	{
		JOptionPane.showMessageDialog(
				fr,message,title,
				JOptionPane.INFORMATION_MESSAGE);
	}







	public static void main(String[] args)  
	{   
	new Login();
	}  
}

 


