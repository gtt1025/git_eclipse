import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
	public class Server {
		private DataInputStream dis;
		private DataOutputStream dos;
		private FileOutputStream fos;
		private Connection con;
		private Statement st;
		private ResultSet rs;
		private PreparedStatement sta;
			Server(){
				Init();
				ServerSocket ss;
				try {
				ss = new ServerSocket(9100);
				boolean listening = true;
				while (listening) {
					    	new ServerThread(ss.accept()).start();
				}
				ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			void Init(){
				String strCon = "jdbc:mysql://127.0.0.1:3306/java";  //连接字符串
			    String strUser = "root";               //数据库用户名
			    String strPwd = "1025"; 
				// connect to database
			    try {  //监控异常
				      Class.forName("com.mysql.jdbc.Driver");  //加载驱动程序
				      con = DriverManager.getConnection(strCon, strUser, strPwd);
				      System.out.println("成功连接到数据库。");
				      st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				    }
			    catch(Exception e){
			    	System.out.println(e);
			    	}

			}
			public static void main(String args[]) throws IOException{
				new Server();
			}
		class ServerThread extends Thread {
				private Socket s;
				ServerThread(Socket s){
					this.s=s;
				}
			    public void run() {
			    	try {
			    		dis =new DataInputStream(s.getInputStream());
						int i=dis.readInt();
						if(i==1){
							uploadfile(dis,s);
						}
						else if(i==2){
							downloadfile(dis,s);
						}
						else if(i==3){
							showfilelist(dis,s);
						}
						else if(i==4){
							deletefile(dis);
						}
						else if(i==5){
							adduser(dis,s);
						}
						else if(i==6){
							updateuser(dis,s);
						}
						else if(i==7){
							showuserlist(dis,s);
						}
						else if(i==8){
							deleteuser(dis,s);
						}
						else if(i==9){
							searchuser(dis,s);
						}
						else if(i==10){
							updateuserPsw(dis,s);
						}
			    	}
			    	catch(Exception e){
			    		
			    	}
			}	
	}
			private void showfilelist(DataInputStream dis,Socket s) {
				try {
					rs = st.executeQuery("SELECT * FROM docs");
					while(rs.next()){
						dos=new DataOutputStream(s.getOutputStream());
						dos.writeUTF(rs.getString("IDs"));
						dos.writeUTF(rs.getString("uncreator"));
						dos.writeUTF(rs.getTimestamp("times").toString());
						dos.writeUTF(rs.getString("descriptions"));
						dos.writeUTF(rs.getString("fileunname"));
					}
					dos.writeUTF("close");
				} catch (Exception e) {
					System.out.println("显示失败");
				}
			}
			public void searchuser(DataInputStream dis2, Socket s) {
				try{
					String name=dis.readUTF();
					String password=dis.readUTF();
					sta = con.prepareStatement("SELECT * FROM users WHERE unname = ? AND pds = ?");
					sta.setString(1, name);
					sta.setString(2, password);
					rs = sta.executeQuery();
					//rs = st.executeQuery("SELECT * FROM users WHERE unname = '"+name+"' AND pds = '"+password+"'");
					dos=new DataOutputStream(s.getOutputStream());
					if(rs.next()){
						dos.writeInt(rs.getInt("role"));
					}
					else{
						dos.writeInt(4);
					}
				} catch (Exception e) {
					System.out.println("登入失败");
				}
			}
			public void deleteuser(DataInputStream dis2,Socket s) {
				try {
					dos=new DataOutputStream(s.getOutputStream());
					String name=dis2.readUTF();
					int i = st.executeUpdate("delete from users where unname = '"+name+"'");
					dos.writeInt(i);
					dos.flush();
				} catch (Exception e) {
					System.out.println("删除失败");
				}
				
			}
			public void showuserlist(DataInputStream dis2, Socket s) {
				/*try {
					dos=new DataOutputStream(s.getOutputStream());
					rs = st.executeQuery("SELECT * FROM users");
					boolean junge=true;
					while(rs.next()){
						dos.writeBoolean(junge);
						String name=rs.getString("unname");
						dos.writeUTF(name);
						dos.writeUTF(rs.getString("pds"));
						String role="";
						if(rs.getInt("role")==1)
						{
								role="administrator";
								dos.writeUTF(role);
						}
						else if(rs.getInt("role")==2)
						{
							role="operator";
							dos.writeUTF(role);
						}
						else if(rs.getInt("role")==3)
						{
							role="browser";
						dos.writeUTF(role);}
					}
					dos.writeBoolean(false);
				} catch (Exception e) {
					System.out.println("显示失败");
				}*/
				// TODO Auto-generated method stub              //口令
				try {
					rs = st.executeQuery("SELECT * FROM users");
					while(rs.next()){
						dos=new DataOutputStream(s.getOutputStream());
						dos.writeUTF(rs.getString("unname"));
						dos.writeUTF(rs.getString("pds"));
						String role="";
						if(rs.getInt("role")==1)
						{
								role="administrator";
						}
						else if(rs.getInt("role")==2)
						{
							role="operator";
						}
						else if(rs.getInt("role")==3)
						{
							role="browser";
						}
						dos.writeUTF(role);
					}
					dos.writeUTF("close");
				} catch (Exception e) {
					System.out.println("显示失败");
				}
			}
			public void updateuser(DataInputStream dis2, Socket s) {
				try {
					String name=dis2.readUTF();
					String password=dis2.readUTF();
					String role=dis2.readUTF();
					int t=0;
					if(role.equals("administrator"))
						t=1;
					else if(role.equals("operator"))
						t=2;
					else if(role.equals("browser"))
						t=3;
					sta = con.prepareStatement("update users set pds = ? WHERE unname = ?");
					sta.setString(1,password);
					sta.setString(2, name);
					sta.executeUpdate();
					sta = con.prepareStatement("update users set role = ? WHERE unname = ?");
					sta.setInt(1, t);
					sta.setString(2, name);
					sta.executeUpdate();
					//int i = st.executeUpdate("update users set pds = '"+password+"' WHERE unname ='"+name+"'"); 
					//int k = st.executeUpdate("update users set role = "+t+" WHERE unname ='"+name+"'"); 
				} catch (Exception e) {
					System.out.println("更新失败");
				}
			}
			public void updateuserPsw(DataInputStream dis2, Socket s) {
				try {
					String name=dis2.readUTF();
					String password=dis2.readUTF();
					//String role=dis2.readUTF();
					//int t=0;
					//if(role.equals("administrator"))
					//	t=1;
					//else if(role.equals("operator"))
					//	t=2;
					//else if(role.equals("browser"))
					//	t=3;
					
					sta = con.prepareStatement("update users set pds = ? WHERE unname = ?");
					sta.setString(1,password);
					sta.setString(2, name);
					sta.executeUpdate();
					//int i = st.executeUpdate("update users set pds = '"+password+"' WHERE unname ='"+name+"'"); 
					//int k = st.executeUpdate("update users set role = "+t+" WHERE unname ='"+name+"'"); 
				} catch (Exception e) {
					/*JFrame fram=new JFrame();
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
    					});	*/
					System.out.println("更新失败");
				}
			}
			public void adduser(DataInputStream dis2, Socket s) {
				try {
					String name=dis2.readUTF();
					String password=dis2.readUTF();
					String role=dis2.readUTF();
					boolean uus=false;
					dos=new DataOutputStream(s.getOutputStream());
					rs = st.executeQuery("SELECT * FROM users");
					while(rs.next()){
						if(rs.getString("unname").equals(name)){
							uus=true;
						}
					}
					if(uus)
						dos.writeUTF("exsit");
					else{
						dos.writeUTF("no");
						int t=0;
						if(role.equals("administrator"))
							t=1;
						else if(role.equals("operator"))
							t=2;
						else if(role.equals("browser"))
							t=3;
						sta = con.prepareStatement("insert into users (unname,pds,role) values (?,?,?)");
						sta.setString(1,name);
						sta.setString(2,password);
						sta.setInt(3, t);
						sta.executeUpdate();
						//int i = st.executeUpdate("insert into users (unname,pds,role) values ('"+name+"','"+password+"',"+t+")");
					}
				} catch (Exception e) {
					System.out.println("增加用户失败");
				}
			}
			public void deletefile(DataInputStream dis) {
				try {
					String ID=dis.readUTF();
					rs = st.executeQuery("SELECT * FROM docs where IDs = '"+ID+"'");
					File dds=new File(ID);
					if(rs.next()){
							File dss=new File(ID+"\\"+rs.getString("fileunname"));
						if(dds.exists()&&dss.exists()){
							dss.delete();
							dds.delete();
							int i =st.executeUpdate("delete from docs where IDs = '"+ID+"'");
						}
						else{
							System.out.println("不存在");
						}
					}
					
				} catch (Exception e) {
					System.out.println("删除失败");
				}
				
			}
			public void uploadfile(DataInputStream dis,Socket s) {
			/*	try {
					// 文件名和长度
					//String filename="d:\\uploadfile\\";
					dos=new DataOutputStream(s.getOutputStream());
					String fileName = dis.readUTF();
					String ID = dis.readUTF();
					String creator = dis.readUTF();
					String description = dis.readUTF();
					String filename = dis.readUTF();
					Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
					long fileLength = dis.readLong();
					fos = new FileOutputStream(new File(filename));
				        
					byte[] sendBytes = new byte[1024];
					int transLen = 0;
					System.out.println("----开始接收文件<" + fileName + ">,文件大小为<"
							+ fileLength + ">----");
					while (true) {
						int read = 0;
						read = dis.read(sendBytes);
						if (read == -1)
							break;
						transLen += read;
						System.out.println("接收文件进度" + 100 * transLen / fileLength
								+ "%...");
						System.out.println("yes");
						
						fos.write(sendBytes, 0, read);
						fos.flush();
						System.out.println("no");
					}
					System.out.println("----接收文件<" + fileName + ">成功-------");
					s.close();

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager
							.getConnection("jdbc:mysql://127.0.0.1:3306/java",
									"root", "1025");
					  Statement sta1 = con.createStatement();
					String strSql = "insert into docs (IDs, uncreator, times, descriptions, fileunname) values ("+ID+", '"+creator+"', '"+timestamp+"', '"+description+"', '"+filename+"')";
					int count = sta1.executeUpdate(strSql);
				} catch (Exception e) {
				}*/
				String uploadpath="g:\\uploadfile";
				try{
					int p=dis.readInt();
					byte[] bg=new byte[p];
					for(int i=0;i<p;i++){
						bg[i]=dis.readByte();
					}
					String fileName=new String(bg);
					String ID=dis.readUTF();
					String creator=dis.readUTF();
					String description=dis.readUTF();
					Long fileLength = dis.readLong();
					dos=new DataOutputStream(s.getOutputStream());
					rs = st.executeQuery("SELECT * FROM docs");
					boolean isID=false;
					while(rs.next()){
						if(ID.equals(rs.getString("IDs")))
							isID=true;										
					}
					if(isID){
						dos.writeUTF("exsit");
					}
					else{
						dos.writeUTF("no");
						File destFile = new File(uploadpath+"\\"+fileName);
						if(!destFile.getParentFile().exists()) {
							if(!destFile.getParentFile().mkdirs()) {
								System.out.println("创建目标文件所在目录失败！");
							}
							destFile.createNewFile(); 
						}
						fos =new FileOutputStream(destFile);
						byte[] buf = new byte[1024];
						int transLen =0;
						while(true){
							int temp=dis.read(buf,0,buf.length);
							if(temp==-1){
								break;
							}
							transLen += temp;
							System.out.println("接收文件进度" +100 * transLen/fileLength +"%...");
							fos.write(buf,0,temp);
							fos.flush();
						}
						
						Timestamp time=new Timestamp(System.currentTimeMillis());
						System.out.println("hello!");
						String times=time.toString();
						/*int i=st.executeUpdate("insert into docs (IDs,uncreator,times,descriptions,fileunname) values ('"+ID+"','"+creator+"','"+times+"','"+description+"','"+fileName+"')");
						 if(i==1)
						 {
							 System.out.println("Yes!");
						 }
						 else
						 {
							 System.out.println("No");
						 }*/
							 
						 String strSql = "insert into docs (IDs, uncreator, times, descriptions, fileunname) values ("+ID+", '"+creator+"', '"+times+"', '"+description+"', '"+fileName+"')";
						 int count = st.executeUpdate(strSql);	
						
					}
				} catch (Exception e) {
					System.out.println("上传失败");
				}finally {
					if(dis !=null)
						try {
							dis.close();
							if(fos !=null)
								fos.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
				}	
			}

			public void downloadfile(DataInputStream dis,Socket s) {
				String ID;
				try {
					dos=new DataOutputStream(s.getOutputStream());
					ID = dis.readUTF();
					rs = st.executeQuery("SELECT * FROM docs where IDs = '"+ID+"'");
					if(rs.next()){
						
						dos.writeUTF(rs.getString("uncreator"));
						dos.writeUTF(rs.getTimestamp("times").toString());
						dos.writeUTF(rs.getString("descriptions"));
						dos.writeUTF(rs.getString("fileunname"));
					}
				} catch (Exception e) {
					/*	JFrame fram=new JFrame();
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
	        					});	*/
					System.out.println("下载失败");
				}
				
			}
}


