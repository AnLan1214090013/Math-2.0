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


public class TestFrame {
	private JFrame fr=null;
	private Button next=null;
	private JButton tong=null;
	private JButton nandu=null;
	private JLabel  formula;

	private Checkbox a_0;
	private JLabel jl1;
	private JButton ne;
	private JButton middle;
	private JButton en;
	private Checkbox a_1;
	private Checkbox a_2;
	private Checkbox a_3;
	private CheckboxGroup zu;

	private JLabel b_ans0;
	private JLabel b_ans1;
	private JLabel b_ans2;
	private JLabel b_ans3;


	private CreateFormula cf;

	private Checkbox c_0;
	private Checkbox c_1;
	private JButton close=null;
	private Checkbox c_2;


	private JLabel d_ans0;
	private JLabel d_ans1;
	private JLabel d_ans2;

	private JLabel tongji0;
	private JLabel tongji1;
	private JLabel tongji2;

	int all=0,r=0,xx=0;


	TestFrame()
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


		next=new Button("下一题");
		formula=new JLabel("formula------");
		b_ans0=new JLabel("formula0");
		b_ans1=new JLabel("formula1");
		b_ans2=new JLabel("formula2");
		b_ans3=new JLabel("formula3");
		d_ans0=new JLabel("简单");
		d_ans1=new JLabel("中等");
		d_ans2=new JLabel("困难");
		tongji0=new JLabel(""+all+"题");
		tongji1=new JLabel(""+r+"题");
		tongji2=new JLabel(""+(all-r)+"题");

		zu=new CheckboxGroup();
		a_0=new Checkbox(null,false,zu);
		a_1=new Checkbox(null,false,zu);
		a_2=new Checkbox(null,false,zu);
		a_3=new Checkbox(null,false,zu);
		c_0=new Checkbox(null,false,zu);
		c_1=new Checkbox(null,false,zu);
		c_2=new Checkbox(null,false,zu);
		cf=new CreateFormula();
		jl1 = new JLabel(new ImageIcon(getClass().getResource("/math/3.png")));
		close=new JButton(new ImageIcon(getClass().getResource("/math/c.png")));
		ne=new JButton(new ImageIcon(getClass().getResource("/math/ne.png")));
		tong=new JButton(new ImageIcon(getClass().getResource("/math/tong.png")));
		nandu=new JButton(new ImageIcon(getClass().getResource("/math/queren.png")));
		en=new JButton(new ImageIcon(getClass().getResource("/math/en.png")));
		middle=new JButton(new ImageIcon(getClass().getResource("/math/middle.png")));
	}
	void addComps()//添加组件，将标签,按钮添加到frame中
	{

		fr.add(next);
		fr.add(close);
		fr.add(ne);
		fr.add(tong);
		fr.add(nandu);
		fr.add(formula);
		fr.add(a_0);
		fr.add(a_1);
		fr.add(en);
		fr.add(middle);
		fr.add(a_2);
		fr.add(a_3);
		fr.add(b_ans0);
		fr.add(b_ans1);
		fr.add(b_ans2);
		fr.add(b_ans3);
		fr.add(c_0);
		fr.add(c_1);
		fr.add(c_2);
		fr.add(d_ans0);
		fr.add(d_ans1);
		fr.add(d_ans2);
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
		formula.setBounds(390,300,150,50);
		b_ans0.setBounds(230,370,140,50);
		b_ans1.setBounds(570,370,140,50);
		b_ans2.setBounds(230,520,140,50);
		b_ans3.setBounds(570,520,140,50);
		a_0.setBounds(210,385,20,20);
		a_1.setBounds(550,385,20,20);
		a_2.setBounds(210,535,20,20);
		a_3.setBounds(550,535,20,20);
		c_0.setBounds(160,240,20,20);
		c_1.setBounds(320,240,20,20);
		c_2.setBounds(480,240,20,20);
		d_ans0.setFont(new java.awt.Font("微软雅黑",10,30));
		d_ans1.setFont(new java.awt.Font("微软雅黑",10,30));
		d_ans2.setFont(new java.awt.Font("微软雅黑",10,30));
		d_ans0.setBounds(140,200,90,30);
		d_ans1.setBounds(300,200,90,30);
		d_ans2.setBounds(460,200,90,30);
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
		b_ans0.setFont(new java.awt.Font("Dialog",1,24));
		b_ans1.setFont(new java.awt.Font("Dialog",1,24));
		b_ans2.setFont(new java.awt.Font("Dialog",1,24));
		b_ans3.setFont(new java.awt.Font("Dialog",1,24));
		formula.setFont(new java.awt.Font("Dialog",1,24));		
		en.setBounds(6,190,48,48);
		en.setBorderPainted(false);
		en.setContentAreaFilled(false);
		middle.setBounds(6,125,48,48);
		middle.setBorderPainted(false);
		middle.setContentAreaFilled(false);
		
		

	}

	void addListeners()//添加事件监听器
	{
		close.addActionListener(new ActionListener()//下一题

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						
						
						
					}
					});
		middle.addActionListener(new ActionListener()//下一题

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						new Mathframe();
						
					}
					});
		en.addActionListener(new ActionListener()//下一题

				{
					public void actionPerformed(ActionEvent e) {
						fr.dispose();
						new Enframe();
						
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


		nandu.addActionListener(new ActionListener()//调整难度
		{      public void actionPerformed(ActionEvent e){

			if(c_0.getState()) xx=0;
			if(c_1.getState()) xx=1;
			if(c_2.getState()) xx=2;
			cf.tiaozhennandu(xx);
			refresh();
		}
		});


		ne.addActionListener(new ActionListener()//下一题

		{
			public void actionPerformed(ActionEvent e) {
				String rightMessage="恭喜你!答对啦!";
				String wrongMessage="答错喽~正确答案应该是"+cf.getResult();
				//判断是否答题
				int c=-1;
				if(a_0.getState()) c=0;
				if(a_1.getState()) c=1;
				if(a_2.getState()) c=2;
				if(a_3.getState()) c=3;
				if(c==-1)
				{alert("请选择","您还没有选择");
				}
				else
				{if(c==cf.getRight())
				{
					alert("正确",rightMessage);
					r++;
				}
				else alert("错误",wrongMessage);
					all++;
					refresh();
					tongji0.setText(""+all+"题");
					tongji1.setText(""+r+"题");
					tongji2.setText(""+(all-r)+"题");
				}
			}
		});
	}


	void refresh()
	{
		cf.run();//调用run方法给出题目和答案
		formula.setText((all+1)+".   "+cf.getFormula());
		b_ans0.setText("A     "+cf.getAnswers(0));
		b_ans1.setText("B     "+cf.getAnswers(1));
		b_ans2.setText("C     "+cf.getAnswers(2));
		b_ans3.setText("D     "+cf.getAnswers(3));
		zu.setSelectedCheckbox(null);
		a_0.setState(false);
		a_1.setState(false);
		a_2.setState(false);
		a_3.setState(false);
		if(xx==0) {d_ans0.setForeground(Color.red);d_ans1.setForeground(Color.black);d_ans2.setForeground(Color.black);}
		if(xx==1) {d_ans0.setForeground(Color.black);d_ans1.setForeground(Color.red);d_ans2.setForeground(Color.black);}
		if(xx==2) {d_ans0.setForeground(Color.black);d_ans1.setForeground(Color.black);d_ans2.setForeground(Color.red);}

	}

	void alert(String title,String message)//设计窗口格式
	{
		JOptionPane.showMessageDialog(
				fr,message,title,
				JOptionPane.INFORMATION_MESSAGE);
	}

	int st()
	{
		double s;
		String hint;
		if(all>0)//根据相应得分给出相应评价并统计信息
		{
			s=(double)r/all*100;
			s=(double)((int)(s*10+0.5))/10; //保留一位小数
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
		new TestFrame();//调用TestFrame方法


	}
}
