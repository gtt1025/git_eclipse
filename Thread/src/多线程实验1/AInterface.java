package 多线程实验1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

import com.mysql.fabric.Server;
public class AInterface extends JFrame{
	private JButton jbtk5=new JButton("退出系统");
	private JButton jbtk6=new JButton("修改用户");
	private JButton jbtk7=new JButton("文件列表");
	private JButton jbtk8=new JButton("下载文件");
	private JButton jbtk9=new JButton("增加用户");
	private JButton jbtk10=new JButton("删减用户");
	private JButton jbtk11=new JButton("修改本人密码");
	private JButton jbtk12=new JButton("用户列表");
public AInterface(){
	JLabel jlb=new JLabel(" 欢 迎 进 入 档 案 管 理 员 系 统 ",JLabel.CENTER);
	 jlb.setFont(new Font("宋体",1,28));
	 jlb.setForeground(Color.yellow);
	 JLabel jlabel=new JLabel(new ImageIcon("4.jpg"));
	 jbtk5.setForeground(Color.BLUE);
	 jbtk5.setFont(new Font("宋体", 1, 15));
	 jbtk6.setForeground(Color.BLUE);
	 jbtk6.setFont(new Font("宋体", 1, 15));
	 jbtk7.setForeground(Color.BLUE);
	 jbtk7.setFont(new Font("宋体", 1, 15));
	 jbtk8.setForeground(Color.BLUE);
	 jbtk8.setFont(new Font("宋体", 1, 15));
	 jbtk9.setForeground(Color.BLUE);
	 jbtk9.setFont(new Font("宋体", 1, 15));
	 jbtk10.setForeground(Color.BLUE);
	 jbtk10.setFont(new Font("宋体", 1, 15));
	 jbtk11.setForeground(Color.BLUE);
	 jbtk11.setFont(new Font("宋体", 1, 15));
	 jbtk12.setForeground(Color.BLUE);
	 jbtk12.setFont(new Font("宋体", 1, 15));
	 jlabel.add(jlb);
	 jlabel.add(jbtk5);
	 jlabel.add(jbtk6);
	 jlabel.add(jbtk7);
	 jlabel.add(jbtk8);
	 jlabel.add(jbtk9);
	 jlabel.add(jbtk10);
	 jlabel.add(jbtk11);
	 jlabel.add(jbtk12);
	 jlb.setBounds(780,5,625,50);
	 jbtk5.setBounds(900,60,150,50);
	 jbtk6.setBounds(900,120,150,50);
	 jbtk7.setBounds(900,180,150,50);
	 jbtk8.setBounds(900,240,150,50);
	 jbtk9.setBounds(1100,60,150,50);
	 jbtk10.setBounds(1100,120,150,50);
	 jbtk11.setBounds(1100,180,150,50);
	 jbtk12.setBounds(1100,240,150,50);
	JPanel p1=new JPanel();
	p1.add(jlabel);
	add(p1);
	
	
	 jbtk5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
			});	
	 
	 
	jbtk6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			JButton jbkn1=new JButton("确定");
			jbkn1.setForeground(Color.blue);
			JButton jbkn2=new JButton("取消");
			jbkn2.setForeground(Color.blue);
			JLabel jbln1=new JLabel("用户名");
			jbln1.setForeground(Color.blue);
			JLabel jbln2=new JLabel("密码");
			jbln2.setForeground(Color.blue);
			JLabel jbln3=new JLabel("角色");
			jbln3.setForeground(Color.blue);
			JTextField jtf1=new JTextField(8);
			JTextField jtf2=new JTextField(8);
			JTextField jtf3=new JTextField(8);
			JFrame frame=new JFrame();
			frame.setTitle("修改用户");
			frame.setSize(250,275);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			JPanel p1=new JPanel();
			p1.setPreferredSize(new Dimension(250,50));
			JLabel jlb=new JLabel("修 改 用 户 信 息",JLabel.CENTER);
			jlb.setFont(new Font("宋体",1,20));
			jlb.setForeground(Color.blue);
			p1.add(jlb);
			JPanel p2=new JPanel();
			p2.setLayout(new GridLayout(3,2,5,10));
			p2.add(jbln1);
			p2.add(jtf1);
			p2.add(jbln2);
			p2.add(jtf2);
			p2.add(jbln3);
			p2.add(jtf3);
			JPanel p3=new JPanel();
			p3.setPreferredSize(new Dimension(250,50));
			p3.add(jbkn1);
			p3.add(jbkn2);
			p1.setBounds(780,5,300,20);
			p2.setBounds(880,105,150,20);
			p2.setBounds(780,305,300,20);
			JPanel p4=new JPanel();
			p4.add(p1);
			p4.add(p2);
			p4.add(p3);
			frame.add(p4);
			 jbkn2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						frame.dispose();
					}
					});	
			 jbkn1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String name=jtf1.getText();
						String password=jtf2.getText();
						String role=jtf3.getText();
						 try{

		                    	if (DataProcessing.updateUser(name, password, role)&&(name!=null)&&(password!=null)&&(role!=null))
		                    	{
		                    		JFrame fram=new JFrame();
	                        		JButton jbt=new JButton("确定");
	                        		JLabel jla=new JLabel("修改成功");
	                        		jla.setFont(new Font("宋体", 1, 15));
	                    		    jla.setForeground(Color.BLUE);
	                    		    jbt.setFont(new Font("宋体", 1, 15));
	                    		    jbt.setForeground(Color.BLUE);
		                    		fram.setTitle("成功");
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
		            						frame.dispose();
		            					}
		            					});	
		                    	}
		                        else
		                        {

		                        	JFrame fram=new JFrame();
	                        		JButton jbt=new JButton("重试");
	                        		JLabel jla=new JLabel("修改失败");
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
		                    }catch(SQLException e1){
		                    	JFrame fram=new JFrame();
                        		JButton jbt=new JButton("重试");
                        		JLabel jla=new JLabel("修改失败");
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
			
			});	
	
	
	 jbtk7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame frame1=new JFrame();
        		frame1.setTitle("文件列表");
    			frame1.setSize(400,80);
    			frame1.setLocationRelativeTo(null);
    			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			frame1.setVisible(true);
    			//JScrollBar jscb1=new JScrollBar(JScrollBar.HORIZONTAL);
    			//JScrollBar jscb2=new JScrollBar(JScrollBar.VERTICAL);
    			//JTextField jtf3=new JTextField();
    			JComboBox xxx=new JComboBox();
    			ResultSet e1;
				try {
					Enumeration<Doc> e11= DataProcessing.getAllDocs();
					while( e11.hasMoreElements() ){
						Doc doc=e11.nextElement();
	    				 //Doc doc1=new Doc(e11.nextElement().getID(),e11.nextElement().getCreator(),e11.nextElement().getTimestamp(),e11.nextElement().getDescription(),e11.nextElement().getFilename());
	    				
						xxx.addItem(doc.getID()+"  "+doc.getCreator()+"  "+doc.getTimestamp()+"  "+doc.getDescription()+"  "+doc.getFilename());
	    				 //jtf3.setText("ID:"+doc1.getID()+" Creator:" +doc1.getCreator()+"Time:" +doc1.getTimestamp()+" Filename:"+doc1.getFilename()+"\tDescription:"+doc1.getDescription()+"\t");
	    			//xxx.addItem(e11.nextElement());
					}
				} catch (IllegalStateException e2) {
					JFrame fram=new JFrame();
            		JButton jbt=new JButton("重试");
            		JLabel jla=new JLabel("查询失败");
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
				} catch (SQLException e2) {
					JFrame fram=new JFrame();
            		JButton jbt=new JButton("重试");
            		JLabel jla=new JLabel("查询失败");
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
    			
    			JPanel pn2=new JPanel();
    			pn2.setLayout(new BorderLayout());
    			pn2.add(xxx);
    			//pn2.add(jtf3,BorderLayout.CENTER);
    			//pn2.add(jscb2,BorderLayout.EAST);
    			//pn2.add(jscb1,BorderLayout.SOUTH);
    			frame1.add(pn2);
			}
			});	
	 
	 
	 jbtk8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame frame3=new JFrame();
        		frame3.setTitle("下载");
    			frame3.setSize(250,150);
    			frame3.setLocationRelativeTo(null);
    			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			frame3.setVisible(true);
    			JPanel panel3=new JPanel();
    			JLabel jlb3=new JLabel("档案号");
    			jlb3.setForeground(Color.BLUE);
    			 jlb3.setFont(new Font("宋体", 1, 15));
    			JButton jbkn4=new JButton("确定");
    			jbkn4.setForeground(Color.BLUE);
   			 jbkn4.setFont(new Font("宋体", 1, 15));
    			JButton jbkn5=new JButton("取消");
    			jbkn5.setForeground(Color.BLUE);
      			 jbkn5.setFont(new Font("宋体", 1, 15));
    			JTextField jtf4=new JTextField(8);
    			panel3.setLayout(new GridLayout(2,2,20,20));
    			JPanel P1=new JPanel();
    			JPanel P2=new JPanel();
    			JPanel P3=new JPanel();
    			JPanel P4=new JPanel();
    			P1.add(jlb3);
    			P2.add(jtf4);
    			P3.add(jbkn4);
    			P4.add(jbkn5);
    			P1.setSize(100, 40);
    			P2.setSize(100, 40);
    			P3.setSize(80,40);
    			P4.setSize(80,40);
    			panel3.add(P1);
    			panel3.add(P2);
    			panel3.add(P3);
    			panel3.add(P4);
    			frame3.add(panel3);
    			 jbkn5.addActionListener(new ActionListener(){
 					public void actionPerformed(ActionEvent e){
 						frame3.dispose();
 					}
 					});	
    			 jbkn4.addActionListener(new ActionListener(){
 					public void actionPerformed(ActionEvent e){
 						String ID=jtf4.getText();
 						try{
                        	if (DataProcessing.DownloadFile(ID))
                        	{
                        		JFrame fram=new JFrame();
                        		JButton jbt=new JButton("确定");
                        		JLabel jla=new JLabel("下载成功");
                        		jla.setFont(new Font("宋体", 1, 15));
                    		    jla.setForeground(Color.BLUE);
                    		    jbt.setFont(new Font("宋体", 1, 15));
                    		    jbt.setForeground(Color.BLUE);
	                    		fram.setTitle("成功");
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
	            						frame3.dispose();
	            					}
	            					});	
                        	}
                        	else
                        		{
                        		JFrame fram=new JFrame();
                        		JButton jbt=new JButton("重试");
                        		JLabel jla=new JLabel("下载失败");
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
                        }catch(SQLException e1){
                        	JFrame fram=new JFrame();
                    		JButton jbt=new JButton("重试");
                    		JLabel jla=new JLabel("下载失败");
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
                        }catch(IOException e1){
                        	JFrame fram=new JFrame();
                    		JButton jbt=new JButton("重试");
                    		JLabel jla=new JLabel("下载失败");
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
			});	
	 jbtk9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			JButton jbkn1=new JButton("确定");
			jbkn1.setForeground(Color.blue);
			JButton jbkn2=new JButton("取消");
			jbkn2.setForeground(Color.blue);
			JLabel jbln1=new JLabel("用户名");
			jbln1.setForeground(Color.blue);
			JLabel jbln2=new JLabel("密码");
			jbln2.setForeground(Color.blue);
			JLabel jbln3=new JLabel("角色");
			jbln3.setForeground(Color.blue);
			JTextField jtf1=new JTextField(8);
			JTextField jtf2=new JTextField(8);
			JTextField jtf3=new JTextField(8);
			JFrame frame4=new JFrame();
			frame4.setTitle("添加用户");
			frame4.setSize(250,275);
			frame4.setLocationRelativeTo(null);
			frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame4.setVisible(true);
			JPanel p1=new JPanel();
			p1.setPreferredSize(new Dimension(250,50));
			JLabel jlb=new JLabel("添  加  用  户 ",JLabel.CENTER);
			jlb.setFont(new Font("宋体",1,20));
			jlb.setForeground(Color.blue);
			p1.add(jlb);
			JPanel p2=new JPanel();
			p2.setLayout(new GridLayout(3,2,5,10));
			p2.add(jbln1);
			p2.add(jtf1);
			p2.add(jbln2);
			p2.add(jtf2);
			p2.add(jbln3);
			p2.add(jtf3);
			JPanel p3=new JPanel();
			p3.setPreferredSize(new Dimension(250,50));
			p3.add(jbkn1);
			p3.add(jbkn2);
			p1.setBounds(780,5,300,20);
			p2.setBounds(880,105,150,20);
			p2.setBounds(780,305,300,20);
			JPanel p4=new JPanel();
			p4.add(p1);
			p4.add(p2);
			p4.add(p3);
			frame4.add(p4);
			 jbkn2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						frame4.dispose();
					}
					});	
			 jbkn1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String name=jtf1.getText();
						String password=jtf2.getText();
						String role=jtf3.getText();
						 try{

		                    	if (DataProcessing.insertUser(name, password, role))
		                    	{
		                    		JFrame fram=new JFrame();
	                        		JButton jbt=new JButton("确定");
	                        		JLabel jla=new JLabel("添加成功");
	                        		jla.setFont(new Font("宋体", 1, 15));
	                    		    jla.setForeground(Color.BLUE);
	                    		    jbt.setFont(new Font("宋体", 1, 15));
	                    		    jbt.setForeground(Color.BLUE);
		                    		fram.setTitle("成功");
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
		            						frame4.dispose();
		            					}
		            					});	
		                    	}
		                        else
		                        {
		                        	JFrame fram=new JFrame();
	                        		JButton jbt=new JButton("重试");
	                        		JLabel jla=new JLabel("添加失败");
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
		                    }catch(SQLException e1){
		                    	JFrame fram=new JFrame();
                        		JButton jbt=new JButton("重试");
                        		JLabel jla=new JLabel("添加失败");
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
			
			});	
	
	 jbtk10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame frame5=new JFrame();
     		frame5.setTitle("删减");
 			frame5.setSize(250,150);
 			frame5.setLocationRelativeTo(null);
 			frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 			frame5.setVisible(true);
 			JPanel panel3=new JPanel();
 			JLabel jlb3=new JLabel("用户名");
 			jlb3.setForeground(Color.BLUE);
 			 jlb3.setFont(new Font("宋体", 1, 15));
 			JButton jbkn4=new JButton("确定");
 			jbkn4.setForeground(Color.BLUE);
			 jbkn4.setFont(new Font("宋体", 1, 15));
 			JButton jbkn5=new JButton("取消");
 			jbkn5.setForeground(Color.BLUE);
   			 jbkn5.setFont(new Font("宋体", 1, 15));
 			JTextField jtf4=new JTextField(8);
 			panel3.setLayout(new GridLayout(2,2,20,20));
 			JPanel P1=new JPanel();
 			JPanel P2=new JPanel();
 			JPanel P3=new JPanel();
 			JPanel P4=new JPanel();
 			P1.add(jlb3);
 			P2.add(jtf4);
 			P3.add(jbkn4);
 			P4.add(jbkn5);
 			P1.setSize(100, 40);
 			P2.setSize(100, 40);
 			P3.setSize(80,40);
 			P4.setSize(80,40);
 			panel3.add(P1);
 			panel3.add(P2);
 			panel3.add(P3);
 			panel3.add(P4);
 			frame5.add(panel3);
 			 jbkn5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						frame5.dispose();
					}
					});	
 			 jbkn4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String name=jtf4.getText();
						try{
                     	if (DataProcessing.deleteUser(name))
                     	{JFrame fram=new JFrame();
                		JButton jbt=new JButton("确定");
                		JLabel jla=new JLabel("删减成功");
                		jla.setFont(new Font("宋体", 1, 15));
            		    jla.setForeground(Color.BLUE);
            		    jbt.setFont(new Font("宋体", 1, 15));
            		    jbt.setForeground(Color.BLUE);
                		fram.setTitle("成功");
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
        						frame5.dispose();
        					}
        					});	
                     	}
                     	else
                     		{
                     		JFrame fram=new JFrame();
                    		JButton jbt=new JButton("重试");
                    		JLabel jla=new JLabel("删减失败");
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
                     }catch(SQLException e1){
                    	 JFrame fram=new JFrame();
                 		JButton jbt=new JButton("重试");
                 		JLabel jla=new JLabel("删减失败");
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
			});	
	 jbtk11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			JButton jbkn1=new JButton("确定");
			jbkn1.setForeground(Color.blue);
			JButton jbkn2=new JButton("取消");
			jbkn2.setForeground(Color.blue);
			JLabel jbln1=new JLabel("姓名");
			jbln1.setForeground(Color.blue);
			JLabel jbln2=new JLabel("新密码");
			jbln2.setForeground(Color.blue);
			//JLabel jbln3=new JLabel("角色");
			//jbln3.setForeground(Color.blue);
			JTextField jtf1=new JTextField(8);
			JTextField jtf2=new JTextField(8);
			//JTextField jtf3=new JTextField(8);
			JFrame frame=new JFrame();
			frame.setTitle("修改用户密码");
			frame.setSize(250,275);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			JPanel p1=new JPanel();
			p1.setPreferredSize(new Dimension(250,50));
			JLabel jlb=new JLabel("修 改 用 户 密 码",JLabel.CENTER);
			jlb.setFont(new Font("宋体",1,20));
			jlb.setForeground(Color.blue);
			p1.add(jlb);
			JPanel p2=new JPanel();
			p2.setLayout(new GridLayout(3,2,5,10));
			p2.add(jbln1);
			p2.add(jtf1);
			p2.add(jbln2);
			p2.add(jtf2);
			//p2.add(jbln3);
			//p2.add(jtf3);
			JPanel p3=new JPanel();
			p3.setPreferredSize(new Dimension(250,50));
			p3.add(jbkn1);
			p3.add(jbkn2);
			p1.setBounds(780,5,300,20);
			p2.setBounds(880,105,150,20);
			p2.setBounds(780,305,300,20);
			JPanel p4=new JPanel();
			p4.add(p1);
			p4.add(p2);
			p4.add(p3);
			frame.add(p4);
			 jbkn2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						frame.dispose();
					}
					});	
			 jbkn1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String name=jtf1.getText();
						String password=jtf2.getText();
						//String role=jtf3.getText();
						 try{

		                    	if (DataProcessing.updateUserPsw(name, password)&&(name!=null)&&(password!=null))
		                    	{
		                    		JFrame fram=new JFrame();
	                        		JButton jbt=new JButton("确定");
	                        		JLabel jla=new JLabel("修改密码成功");
	                        		jla.setFont(new Font("宋体", 1, 15));
	                    		    jla.setForeground(Color.BLUE);
	                    		    jbt.setFont(new Font("宋体", 1, 15));
	                    		    jbt.setForeground(Color.BLUE);
		                    		fram.setTitle("成功");
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
		            						frame.dispose();
		            					}
		            					});	
		                    	}
		                        else
		                        {

		                        	JFrame fram=new JFrame();
	                        		JButton jbt=new JButton("重试");
	                        		JLabel jla=new JLabel("修改密码失败");
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
		                    }catch(SQLException e1){
		                    	JFrame fram=new JFrame();
                        		JButton jbt=new JButton("重试");
                        		JLabel jla=new JLabel("修改密码失败");
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
			
			});	
	 jbtk12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame frame1=new JFrame();
     		frame1.setTitle("用户列表");
 			frame1.setSize(300,80);
 			frame1.setLocationRelativeTo(null);
 			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 			frame1.setVisible(true);
 			//JScrollBar jscb1=new JScrollBar(JScrollBar.HORIZONTAL);
 			//JScrollBar jscb2=new JScrollBar(JScrollBar.VERTICAL);
 			JComboBox<String> xx=new JComboBox();
 			
 			//JTextField jtf3=new JTextField();
 			//ResultSet e1;
				try {
					Enumeration<User> e11= DataProcessing.getAllUser();
					//String role=e11.nextElement().getRole();
					while( e11.hasMoreElements() ){
						//System.out.println(e11.nextElement().getName());
						//System.out.println(e11.nextElement().getPassword());
						//String role=e11.nextElement().getRole();
						//String name=e11.nextElement().getName();
						//String password=e11.nextElement().getPassword();
						//System.out.println(role);
						User user=e11.nextElement();
						xx.addItem(user.getRole()+"  "+user.getName()+"  "+user.getPassword());
						//xx.addItem(e11.nextElement().getName()+e11.nextElement().getPassword()+e11.nextElement().getRole());
						//User user=e11.nextElement();
					  //  xx.addItem(user);
						/*if((role).equals("browser")) 
						{
						User temp1 = e11.nextElement();
						xx.addItem(name+password+role);
						 //jtf3.setText("name:"+temp1.getName()+" password:" +temp1.getPassword()+"role"+temp1.getRole()+"\t");
						 }
						else if((role).equals("administrator"))
						{
							//Administrator temp1 = new Administrator(name,password,role);
								xx.addItem(name+password+role);
								 //jtf3.setText("name:"+temp1.getName()+" password:" +temp1.g
						}
						else if((role).equals("operator"))
						{
							//Operator temp1 = new Operator(name,password,role);
								xx.addItem(name+password+role);
								 //jtf3.setText("name:"+temp1.getName()+" password:" +temp1.g
						}*/
					}
				} catch (IllegalStateException e2) {
					JFrame fram=new JFrame();
            		JButton jbt=new JButton("重试");
            		JLabel jla=new JLabel("查询失败");
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
				} catch (SQLException e2) {
					JFrame fram=new JFrame();
            		JButton jbt=new JButton("重试");
            		JLabel jla=new JLabel("查询失败");
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
 			
 			JPanel pn2=new JPanel();
 			
 			pn2.setLayout(new BorderLayout());
 			pn2.add(xx);
 			frame1.add(pn2);
			}
			});	
	 
	 
}
}
