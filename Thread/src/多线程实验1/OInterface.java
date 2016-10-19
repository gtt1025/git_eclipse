package 多线程实验1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class OInterface extends JFrame{
	private JButton jbtk5=new JButton("退出系统");
	private JButton jbtk6=new JButton("修改私人信息");
	private JButton jbtk7=new JButton("文件列表");
	private JButton jbtk8=new JButton("下载文件");
	private JButton jbtk9=new JButton("上传文件");
 public OInterface(){
	 JLabel jlb=new JLabel(" 欢 迎 进 入 档 案 录 入 员 系 统 ",JLabel.CENTER);
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
	 jlabel.add(jlb);
	 jlabel.add(jbtk5);
	 jlabel.add(jbtk6);
	 jlabel.add(jbtk7);
	 jlabel.add(jbtk8);
	 jlabel.add(jbtk9);
	 jlb.setBounds(780,5,625,50);
	 jbtk5.setBounds(900,80,150,50);
	 jbtk6.setBounds(900,160,150,50);
	 jbtk7.setBounds(900,240,150,50);
	 jbtk8.setBounds(1100,80,150,50);
	 jbtk9.setBounds(1100,160,150,50);
	JPanel p1=new JPanel();
	p1.add(jlabel);
	/*p1.add(jbtk5);
	p1.add(jbtk6);
	p1.add(jbtk7);
	p1.add(jbtk8);
	p1.add(jbtk9);
	p1.add(jbtk10);
	p1.add(jbtk11);
	p1.add(jbtk12);*/
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
					//	String role=jtf3.getText();
						 try{

		                    	if (DataProcessing.updateUserPsw(name, password))
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
			JLabel jbln0=new JLabel("上传者");
			jbln0.setForeground(Color.blue);
			JLabel jbln1=new JLabel("源文件名");
			jbln1.setForeground(Color.blue);
			JLabel jbln2=new JLabel("档案号");
			jbln2.setForeground(Color.blue);
			JLabel jbln3=new JLabel("档案描述");
			jbln3.setForeground(Color.blue);
			JTextField jtf0=new JTextField(8);
			JTextField jtf1=new JTextField(16);
			JTextField jtf2=new JTextField(8);
			JTextField jtf3=new JTextField(18);
			JFrame frame=new JFrame();
			frame.setTitle("上传文件");
			frame.setSize(470,270);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			JPanel p1=new JPanel();
			p1.setPreferredSize(new Dimension(250,50));
			JLabel jlb=new JLabel("上  传  文  件",JLabel.CENTER);
			jlb.setFont(new Font("宋体",1,20));
			jlb.setForeground(Color.blue);
			p1.add(jlb);
			JPanel p2=new JPanel();
			p2.setLayout(new GridLayout(4,2,5,10));
			p2.add(jbln0);
			p2.add(jtf0);
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
			p3.setBounds(780,305,300,20);
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
						String name=jtf0.getText();
						String sourceFile=jtf1.getText();
						String ID=jtf2.getText();
						String description=jtf3.getText();
						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						 try{

		                    	if (DataProcessing.insertDoc(ID,name,timestamp,description,sourceFile)&&(ID!=null)&&(name!=null)&&(description!=null)&&(sourceFile!=null))
		                    	{
		                    		JFrame fram=new JFrame();
	                        		JButton jbt=new JButton("确定");
	                        		JLabel jla=new JLabel("上传成功");
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
	                        		JLabel jla=new JLabel("上传失败");
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
		                    }catch(SQLException | HeadlessException e1){
		                    	JFrame fram=new JFrame();
               		JButton jbt=new JButton("重试");
               		JLabel jla=new JLabel("上传失败");
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
 }
}
