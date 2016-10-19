package 多线程实验1;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class DInterface extends JFrame{
	private JButton jbtk3=new JButton("确定");
	private JButton jbtk4=new JButton("取消");
	private JTextField jtfName=new JTextField(8);
	private JTextField jtfPassword=new JTextField(8);
	private JLabel jlb1=new JLabel("用户名");
	private JLabel jlb2=new JLabel("密 码");
public DInterface(){
	
	 jbtk3.setForeground(Color.BLUE);
	 jbtk3.setFont(new Font("宋体", 1, 15));
	 jbtk4.setForeground(Color.BLUE);
	 jbtk4.setFont(new Font("宋体", 1, 15));
	 jlb1.setFont(new Font("宋体", 1, 25));
	 jlb1.setForeground(Color.BLUE);
	 jlb2.setFont(new Font("宋体", 1, 25));
	 jlb2.setForeground(Color.BLUE);
	 JLabel jlb=new JLabel("欢 迎 进 入 登 录 界 面  ！",JLabel.CENTER);
	 jlb.setFont(new Font("宋体",1,35));
	 jlb.setForeground(Color.YELLOW);
	 JLabel jlabel=new JLabel(new ImageIcon("6.jpg"));
	 jlb.setBounds(190,5,625,100);
	 jlb1.setBounds(350,120,100,30);
	 jlb2.setBounds(350,160,100,30);
	 jtfName.setBounds(450,120,100,30);
	 jtfPassword.setBounds(450,160,100,30);
	 jbtk3.setBounds(350,250,80,40);
	 jbtk4.setBounds(550,250,80,40);
	 jlabel.add(jlb);
	jlabel.add(jlb1);
	jlabel.add(jlb2);
	jlabel.add(jtfName);
	jlabel.add(jtfPassword);
	jlabel.add(jbtk3);
	jlabel.add(jbtk4);
	JPanel p1=new JPanel();
	p1.add(jlabel);
	add(p1);
	 jbtk4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
			});	
   jbtk3.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
				try{
				User user=DataProcessing.searchUser(jtfName.getText(),jtfPassword.getText());
				if(user==null){
					JFrame fram=new JFrame();
            		JButton jbt=new JButton("重试");
            		JLabel jla=new JLabel("密码或登录名错误");
            		jla.setFont(new Font("宋体", 1, 15));
        		    jla.setForeground(Color.BLUE);
        		    jbt.setFont(new Font("宋体", 1, 15));
        		    jbt.setForeground(Color.BLUE);
            		fram.setTitle("失败");
        			fram.setSize(220,120);
        			fram.setLocationRelativeTo(null);
        			fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        			fram.setVisible(true);
        			JPanel pn1=new JPanel();
                    pn1.setLayout(new GridLayout(2,1,10,10));
                    JPanel pn2=new JPanel();
                    JPanel pn3=new JPanel();
                    pn2.setSize(120,40);
                    pn3.setSize(80,40);
        			pn2.add(jla);
        			
        			pn3.add(jbt);
        			pn1.add(pn2);
        			pn1.add(pn3);
        		   fram.add(pn1);
        		   jbt.addActionListener(new ActionListener(){
    					public void actionPerformed(ActionEvent e){
    						fram.dispose();
    					}
    					});	
				}
				else if((user.getRole()).equals("administrator"))
				{
					AInterface frame=new AInterface();
					frame.setTitle("管理员");
					frame.setSize(600,400);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				}
				else if((user.getRole()).equals("operator"))
				{
					OInterface frame=new OInterface();
					frame.setTitle("操作者");
					frame.setSize(600,400);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				}
				else if((user.getRole()).equals("browser"))
				{
					BInterface frame=new BInterface();
					frame.setTitle("浏览者");
					frame.setSize(600,400);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				}
				}catch(Exception ex){

					JFrame fram=new JFrame();
            		JButton jbt=new JButton("重试");
            		JLabel jla=new JLabel("登录失败");
            		jla.setFont(new Font("宋体", 1, 15));
        		    jla.setForeground(Color.BLUE);
        		    jbt.setFont(new Font("宋体", 1, 15));
        		    jbt.setForeground(Color.BLUE);
            		fram.setTitle("失败");
        			fram.setSize(220,120);
        			fram.setLocationRelativeTo(null);
        			fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        			fram.setVisible(true);
        			JPanel pn1=new JPanel();
                    pn1.setLayout(new GridLayout(2,1,10,10));
                    JPanel pn2=new JPanel();
                    JPanel pn3=new JPanel();
                    pn2.setSize(120,40);
                    pn3.setSize(80,40);
        			pn2.add(jla);
        			
        			pn3.add(jbt);
        			pn1.add(pn2);
        			pn1.add(pn3);
        		   fram.add(pn1);
        		   jbt.addActionListener(new ActionListener(){
    					public void actionPerformed(ActionEvent e){
    						fram.dispose();
    					}
    					});	
	         	}
				
				
			}
			});	
}
}

