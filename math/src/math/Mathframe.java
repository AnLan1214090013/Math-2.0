package math;

import java.awt.*;
import java.applet.*;
import java.lang.Object;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Mathframe {
	Jdbcs_2 timu = new Jdbcs_2();
	private JFrame fr=null;
	private Button next=null;
	int id = 1;
	private JButton tong=null;
	private JButton chou=null;
	private JButton nandu=null;
	private JTextField a1;
	private JLabel  formula;
	private JLabel jl1;
	private JButton ne;
	private JButton en;
	private JButton xiao;
	private CheckboxGroup zu;
	private JLabel shuru;
	private CreateFormula cf;
	private JButton close=null;

	private JLabel tongji0;
	private JLabel tongji1;
	private JLabel tongji2;

	int all=0,r=0,xx=0;
	

	Mathframe()
	{
		init();
		setBounds();
		addComps();
		addListeners();
		refresh();
	}

	void init()//初始化
	{
		fr=new JFrame("中小学生习题库");//标题
		cf=new CreateFormula();
		a1=new JTextField();
		next=new Button("下一题");
		formula=new JLabel("<html>1.关于x的一元二次方程2x(平方)-4x+m-1=0有两个相等的实数根,则m的值为____</html>");
		shuru=new JLabel("我的答案：");

		tongji0=new JLabel(""+all+"题");
		tongji1=new JLabel(""+r+"题");
		tongji2=new JLabel(""+(all-r)+"题");

		zu=new CheckboxGroup();

		cf=new CreateFormula();
		jl1 = new JLabel(new ImageIcon(getClass().getResource("/math/middleb.png")));
		close=new JButton(new ImageIcon(getClass().getResource("/math/c.png")));
		ne=new JButton(new ImageIcon(getClass().getResource("/math/ne.png")));
		tong=new JButton(new ImageIcon(getClass().getResource("/math/tong.png")));
		chou=new JButton(new ImageIcon(getClass().getResource("/math/chou.png")));
		nandu=new JButton(new ImageIcon(getClass().getResource("/math/queren.png")));
		en=new JButton(new ImageIcon(getClass().getResource("/math/en.png")));
		xiao=new JButton(new ImageIcon(getClass().getResource("/math/xiao.png")));
	}
	void addComps()//添加组件，将标签,按钮添加到frame中
	{

		fr.add(next);
		fr.add(close);
		fr.add(ne);
		fr.add(tong);
		fr.add(formula);
		fr.add(chou);
		fr.add(en);
		fr.add(a1);
		fr.add(shuru);
        fr.add(xiao);


		fr.add(tongji0);
		fr.add(tongji1);
		fr.add(tongji2);
		fr.add(jl1);


	}
	void setBounds()//
	{
		fr.setBounds(448,140,1024,768);
		fr.getContentPane().setBackground( Color.WHITE );
		jl1.setBounds(0,0,1024,768);
		fr.setUndecorated(true);
		nandu.setBounds(600,190,200,70);
		nandu.setBorderPainted(false);
		nandu.setContentAreaFilled(false);
		ne.setBounds(350,650,200,70);
		ne.setBorderPainted(false);
		ne.setContentAreaFilled(false);
		tong.setBounds(5,710,50,50);
		tong.setBorderPainted(false);
		tong.setContentAreaFilled(false);
		close.setBounds(980,6,30,30);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		formula.setBounds(200,50,550,350);

		
		a1.setBounds(390,360,300,40);
		a1.setFont(new java.awt.Font("微软雅黑",10,30));
		tongji0.setBounds(880,160,150,60);
		tongji1.setBounds(880,418,150,60);
		tongji2.setBounds(880,686,150,60);
		tongji0.setOpaque(false);
		fr.setLayout(null);
		fr.setVisible(true);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		tongji0.setFont(new java.awt.Font("微软雅黑",10,20));
		tongji0.setForeground(Color.white);
		tongji1.setFont(new java.awt.Font("微软雅黑",10,20));
		tongji1.setForeground(Color.white);
		tongji2.setFont(new java.awt.Font("微软雅黑",10,20));
		tongji2.setForeground(Color.white);
		formula.setFont(new java.awt.Font("微软雅黑",10,24));	
		shuru.setBounds(270,360,300,40);
		shuru.setFont(new java.awt.Font("微软雅黑",10,24));	
		en.setBounds(6,180,48,48);
		en.setBorderPainted(false);
		en.setContentAreaFilled(false);
		xiao.setBounds(6,55,48,48);
		xiao.setBorderPainted(false);
		xiao.setContentAreaFilled(false);

		

	}

	void addListeners()//添加事件监听器
	{
		close.addActionListener(new ActionListener()//下一题

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						
						
					}
					});
		en.addActionListener(new ActionListener()//下一题

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						new Enframe();
						
					}
					});
		xiao.addActionListener(new ActionListener()//下一题

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						new TestFrame();
						
						
					}
					});
		tong.addActionListener(new ActionListener()//下一题

				{
					public void actionPerformed(ActionEvent e) {
						int c=st();
						
					}
					});
		fr.addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent e){
			int c=st();
			if(c==JOptionPane.YES_OPTION)
				System.exit(0);//退出
		}
		});


		ne.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent e) {
				all++;
				tongji0.setText(""+all+"题");
				tongji2.setText(""+(all-r)+"题");
				
				Jdbcs_2 d = new Jdbcs_2();
				String answer = a1.getText();
				String shuxueti = formula.getText();
				
		        if (d.compare(answer, id)) 
					
				{	
		        	JOptionPane.showMessageDialog(null, "答案正确！");
		        	r++;
		        	id++;
		        	tongji1.setText(""+r+"题");
		        	final Jdbcs_2 timu1 = timu.chou(id);
	                String   str="<html>"+timu1.getshuxue()+"</html>";
	                formula.setText(str);
		        	
				}
			}
			});
	}

	void refresh()
	{


	}

	void alert(String title,String message)
	{
		JOptionPane.showMessageDialog(
				fr,message,title,
				JOptionPane.INFORMATION_MESSAGE);
	}

	int st()
	{
		double s;
		String hint;
		if(all>0)
		{
			s=(double)r/all*100;
			s=(double)((int)(s*10+0.5))/10; 
		}
		else
			s=-1;
		if(s==-1)
			hint="快点做题啦~";
		else if(s<60)
			hint="你要努力哦~";
		else if(s<80)
			hint="还可以哦~";
		else if(s<90)
			hint="真的很不错哦~";
		else hint="太棒啦~";
		String str="统计信息:\n您总共做题:  "+all+"\n共计正确数:  "+r+"\n共计错误数:  "+(all-r)+"\n正确率:  "+
				(all==0?"-":s+"%")+"\n"+hint;
		return JOptionPane.showConfirmDialog(fr,str,"统计信息",JOptionPane.YES_OPTION);
	}





	public static void main(String[] args)
	{
		new TestFrame();


	}
}
