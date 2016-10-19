package 多线程实验1;
import java.util.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public  class DataProcessing extends Socket{
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
//	private int numberofRows;
	private static boolean connectToDB=false;
	
	private static final String SERVER_IP ="127.0.0.1";
	private static final int SERVER_PORT =9100;

	private static Socket client;
	private static FileInputStream fis;
	private static DataOutputStream dos;
	private static DataInputStream dis;
	static Hashtable<String, Doc> docs;
	/*static {
		users = new Hashtable<String, User>();
		users.put("jack", new Operator("jack","123","operator"));
		users.put("rose", new Browser("rose","123","browser"));
		users.put("kate", new Administrator("kate","123","administrator"));
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		docs = new Hashtable<String,Doc>();
		docs.put("0001",new Doc("0001","jack",timestamp,"Age Source Java","Age.java"));
		
		
	}*/
	public static Doc searchDoc(String ID) throws SQLException,IllegalStateException {
		/*rs = st.executeQuery("SELECT * FROM docs WHERE IDs = '"+ID+"'");
		if(rs.next()){
		Doc we=new Doc(rs.getString("IDs"),rs.getString("uncreator"),rs.getTimestamp("times"),rs.getString("descriptions"),rs.getString("fileunname"));
		return we;  
		}
		else{
			return null;
		}*/
	if(ID==null){
		return null;
	}
	else{
	try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());
			dos.writeInt(2);
			dos.flush();
			dos.writeUTF(ID);
			dos.flush();
			dis =new DataInputStream(client.getInputStream());
			String uncreator= dis.readUTF();
			String time= dis.readUTF();
			String descriptions= dis.readUTF();
			String fileunname= dis.readUTF();
			Doc we=new Doc(ID,uncreator,Timestamp.valueOf(time),descriptions,fileunname);
			return we;
			}catch (Exception e) {
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
			//e.printStackTrace();
			return null;
			}}
	}
	
	public static Enumeration<Doc> getAllDocs() throws SQLException,IllegalStateException{		
		/*rs = st.executeQuery("SELECT * FROM docs");
		return rs;*/
		//Hashtable<String, Doc> docs = null;
		Hashtable<String, Doc> docs = null;
		docs = new Hashtable<String,Doc>();
		try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());
			dos.writeInt(3);
			dos.flush();
			String IDe="";
			dis =new DataInputStream(client.getInputStream());
			while(!(IDe=dis.readUTF()).equals("close")){
				Doc eex=new Doc(IDe,dis.readUTF(),Timestamp.valueOf(dis.readUTF()),dis.readUTF(),dis.readUTF());
				docs.put(IDe,eex);
			}
			}catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			client.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
			Enumeration<Doc> e  = docs.elements();
			return e;
	} 
	
	public static boolean insertDoc(String ID, String creator,Timestamp timestamp, String description, String filename) throws SQLException,IllegalStateException{
	/*	try {
            try {
            	String uploadpath="d:\\uploadfile\\";
                Socket client =new Socket(SERVER_IP, SERVER_PORT);
                //向服务端传送文件
                File file =new File(uploadpath+filename);
                FileInputStream fis =new FileInputStream(file);
                dis =new DataInputStream(client.getInputStream());
                DataOutputStream dos =new DataOutputStream(client.getOutputStream());
                dos.writeInt(1);
                dos.flush();
                dos.writeUTF(filename);
                dos.flush();
                dos.writeUTF(ID);
                dos.flush();
                dos.writeUTF(creator);
                dos.flush();
                dos.writeUTF(description);
                dos.flush();
                dos.writeUTF(file.getName());
                dos.flush();
                //dos.writeLong(file.length());
                //dos.flush();
                 //dos.writeUTF(filename.trim());
                 //dos.flush();
                 dos.writeLong(file.length());
                 dos.flush();
                //传输文件
                byte[] sendBytes =new byte[1024];
               int length =0;
               while((length = fis.read(sendBytes,0, sendBytes.length)) >0){
                   dos.write(sendBytes,0, length);
                   dos.flush();
               }
             
               //String str=dis.readUTF();
               //System.out.println(str);
            }catch (Exception e) {
                e.printStackTrace();
            }finally{
                
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
		return true;*/
		if((ID!=null)&&(creator!=null)&&(description!=null)&&(filename!=null))
		{
		try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			                //向服务端传送文件
			File file =new File("g:\\uploadfile\\"+filename);
			fis =new FileInputStream(file);
			dos =new DataOutputStream(client.getOutputStream());

			                //文件名和长度
			dos.writeInt(1);
			dos.flush();
			//String unname=file.getName();
			byte[] ch=filename.getBytes();
			dos.writeInt(ch.length);
			dos.flush();
			for(int i=0;i<ch.length;i++){
				dos.writeByte(ch[i]);
				dos.flush();
			}	
			dos.writeUTF(ID);
			dos.flush();
			dos.writeUTF(creator);
			dos.flush();
			dos.writeUTF(description);
			dos.flush();
			dos.writeLong(file.length());
			dos.flush();
			dis =new DataInputStream(client.getInputStream());
			if(dis.readUTF().equals("exsit")){
				return false;
			}
			byte[] sendBytes =new byte[1024];
			int length =0;
			while((length = fis.read(sendBytes,0, sendBytes.length)) >0){
			dos.write(sendBytes,0, length);
			dos.flush();
			                }
			}catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			client.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
			return true;
		}
		else
		{
			return false;
		}
	} 
	public static boolean deleteDoc(String ID) throws SQLException,IllegalStateException{
		try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());
			dos.writeInt(4);
			dos.flush();
			byte[] ch = ID.getBytes();
			dos.writeUTF(ID);
			dos.flush();
			}catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			client.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
			return true;
		
	}
	
	public static User searchUser(String name, String password) throws SQLException,IllegalStateException {
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Query" );	
	
		/*rs = st.executeQuery("SELECT * FROM users WHERE unname = '"+name+"' AND pds = '"+password+"'");
		if(rs.next()){
			User we=new User();
			if(rs.getInt("role")==1)
				we=new Administrator(rs.getString("unname"),rs.getString("pds"),"administrator");
			else if(rs.getInt("role")==2)
				we=new Operator(rs.getString("unname"),rs.getString("pds"),"operator");
			else if(rs.getInt("role")==3)
				we=new Browser(rs.getString("unname"),rs.getString("pds"),"browser");
			return we;  
		}
		else{
			disconnectFromDB();
			return null;
		}*/
		User we;
		try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());

			dos.writeInt(9);
			dos.flush();
			dos.writeUTF(name);
			dos.flush();
			dos.writeUTF(password);
			dos.flush();
			dis =new DataInputStream(client.getInputStream());
			int i=dis.readInt();
			if(i==1)
			{
				we=new Administrator(name,password,"administrator");
				return we;
			}
			else if(i==2)
			{
				we=new Operator(name,password,"operator");
				return we;
			}
			else if(i==3){
				
			
				we=new Browser(name,password,"browser");
				return we;
			}
			else if(i==4)
				return null;
			}catch (Exception e) {
			     return null;
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
		
			return null;
		
	}
	//public static void getAlUser(){
	public static Enumeration<User> getAllUser() throws SQLException,IllegalStateException{
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Query" );
	/*	Hashtable<String, User> users=null;
		users = new Hashtable<String, User>();
		try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());
			dos.writeInt(7);
			dos.flush();
			dis =new DataInputStream(client.getInputStream());
			boolean junge=dis.readBoolean();
			while(junge){
				String namee=dis.readUTF();
				String password=dis.readUTF();
				String role=dis.readUTF();
				//System.out.println(namee+password+role);
				if(role.equals("adminstrator"))
				{
				User eex=new Administrator(namee,password,role);
				System.out.println(eex.getRole());
				users.put(namee,eex);
				}
				else if(role.equals("operator")){
					User eex=new Operator(namee,password,role);
					System.out.println(eex.getRole());
					users.put(namee,eex);
					System.out.println(eex.getRole());
				}
				else if(role.equals("browser"))
				{
					User eex=new Browser(namee,password,role);
					System.out.println(eex.getRole());
					users.put(namee,eex);
				}
				junge=dis.readBoolean();
				
			}
			}catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			client.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
		Enumeration<User> e  = users.elements();
		return e;*/
		//return false;
		Hashtable<String, User> users=null;
		users = new Hashtable<String, User>();
		try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());
			dos.writeInt(7);
			dos.flush();
			String namee="";
			dis =new DataInputStream(client.getInputStream());
			while(!(namee=dis.readUTF()).equals("close")){
				String password=dis.readUTF();
				String role=dis.readUTF();
				if(role.equals("adminstrator"))
				{
				User eex=new Administrator(namee,password,role);
				users.put(namee,eex);
				}
				else if(role.equals("operator")){
					User eex=new Operator(namee,password,role);
					users.put(namee,eex);
				}
				else if(role.equals("browser"))
				{
					User eex=new Browser(namee,password,role);
					users.put(namee,eex);
				}
			}
			}catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			client.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
		Enumeration<User> e  = users.elements();
		return e;
	}
	
	
	
	public static boolean updateUserPsw(String name, String password) throws SQLException,IllegalStateException{
		User user;
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Update" );
	/*	int t=0;
		if(role.equals("administrator"))
			t=1;
		else if(role.equals("operator"))
			t=2;
		else if(role.equals("browser"))
			t=3;		
		int i = st.executeUpdate("update users set pds = '"+password+"' WHERE unname ='"+name+"'"); 
		int k = st.executeUpdate("update users set role = "+t+" WHERE unname ='"+name+"'"); 
		if(i==1&&k==1){
			return true;
		}
		else {
			return false;
		}*/
		if((name!=null)&&(password!=null))
		{try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());
			dos.writeInt(10);
			dos.flush();
			dos.writeUTF(name);
			dos.flush();
			dos.writeUTF(password);
			dos.flush();
			//dos.writeUTF(role);
			//dos.flush();
			}catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			client.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
		return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean insertUser(String name, String password, String role) throws SQLException,IllegalStateException{
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Insert" );
	/*	int t=0;
		rs = st.executeQuery("SELECT * FROM users");
		while(rs.next()){
			if(rs.getString("unname").equals(name))
				return false;
		}
		if(role.equals("administrator"))
			t=1;
		else if(role.equals("operator"))
			t=2;
		else if(role.equals("browser"))
			t=3;	
		int i = st.executeUpdate("insert into users (unname,pds,role) values ('"+name+"','"+password+"',"+t+")");
		if(i==1)
			return true;
		else
			return false;*/
		
		if((name!=null)&&(password!=null)&&(role.equals("administrator")||role.equals("operator")||role.equals("browser")))
		{try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());
			dos.writeInt(5);
			dos.flush();
			dos.writeUTF(name);
			dos.flush();
			dos.writeUTF(password);
			dos.flush();
			dos.writeUTF(role);
			dos.flush();		
			dis =new DataInputStream(client.getInputStream());
			if(dis.readUTF().equals("exsit")){
				return false;
			}
			}catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			client.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
		
		return true;}
		else
		{
			return false;
		}
		}
	
	public static boolean deleteUser(String name) throws SQLException,IllegalStateException{
//		if ( !connectToDB ) 
//	        throw new IllegalStateException( "Not Connected to Database" );
//		
//		if (Math.random()>0.7)
//			throw new SQLException( "Error in excecuting Delete" );
	/*	int i = st.executeUpdate("delete from users where unname = '"+name+"'");
		if(i==1)
			return true;
		else
			return false;*/
		if(name!=null){
		try {
			try {
			client =new Socket(SERVER_IP, SERVER_PORT);
			dos =new DataOutputStream(client.getOutputStream());
			dos.writeInt(8);
			dos.flush();
			dos.writeUTF(name);
			dos.flush();
			dis =new DataInputStream(client.getInputStream());
			int i=dis.readInt();
			if(i==0)
			{
				return false;
			}
			}catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(fis !=null)
			fis.close();
			if(dos !=null)
			dos.close();
			client.close();
			            }
			}catch (Exception e) {
			e.printStackTrace();
			        }
		return true;
		}
		else
		{
			return false;
		}
	}	
	public static boolean DownloadFile(String ID) throws SQLException,IOException{
		//boolean result=false;
		
		byte[] buffer = new byte[1024];
		Doc doc=DataProcessing.searchDoc(ID);
		
		if (doc==null)
		{
			return false;
		}
		else{
		String uploadpath="g:\\uploadfile\\";
        String downloadpath="g:\\downloadfile\\";
		File tempFile =new File(uploadpath+doc.getFilename());
		String filename = tempFile.getName();
		
		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));
		BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(downloadpath+filename)); 

		while (true) {
			int byteRead=infile.read(buffer); //从文件读数据给字节数组
	        if (byteRead==-1) //在文件尾，无数据可读
	            break;  //退出循环           
	        targetfile.write(buffer,0,byteRead);  //将读到的数据写入目标文件
	    }
		infile.close();
		targetfile.close();
		
		return true;
		}

	    //System.out.println("copy success! ");		
	}	
public static boolean uploadFile(String sourcefile, String ID, String description,String name) throws SQLException,IOException{
		
		//boolean result=false;

	//boolean result=false;
	dos =new DataOutputStream(client.getOutputStream());
	byte[] buffer = new byte[1024];
	String uploadpath="g:\\uploadfile\\";
    String downloadpath="g:\\downloadfile\\";
	File tempFile =new File(sourcefile.trim());
	String filename = tempFile.getName();
	dos.writeUTF(filename);;
	dos.flush();
	BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));
	BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(uploadpath+filename)); 

	while (true) {
		int byteRead=infile.read(buffer); //从文件读数据给字节数组
        if (byteRead==-1) //在文件尾，无数据可读
            break;  //退出循环           
        targetfile.write(buffer,0,byteRead);  //将读到的数据写入目标文件
    }
	infile.close();
	targetfile.close();
    //System.out.println("copy success! ");
    
   //String creator= this.getName();
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //insert record into database
    //result=
	if (!DataProcessing.insertDoc(ID, name,timestamp,description, filename)){
		//System.out.println("上传文件出现错误");
		tempFile =new File(uploadpath+filename);
		tempFile.delete();
		return false;
	}else
		return true;
	
		
	}	
public static boolean updateUser(String name, String password, String role) throws SQLException,IllegalStateException{
	User user;
//	if ( !connectToDB ) 
//        throw new IllegalStateException( "Not Connected to Database" );
//	
//	if (Math.random()>0.7)
//		throw new SQLException( "Error in excecuting Update" );
/*	int t=0;
	if(role.equals("administrator"))
		t=1;
	else if(role.equals("operator"))
		t=2;
	else if(role.equals("browser"))
		t=3;		
	int i = st.executeUpdate("update users set pds = '"+password+"' WHERE unname ='"+name+"'"); 
	int k = st.executeUpdate("update users set role = "+t+" WHERE unname ='"+name+"'"); 
	if(i==1&&k==1){
		return true;
	}
	else {
		return false;
	}*/
	
	try {
		try {
		client =new Socket(SERVER_IP, SERVER_PORT);
		dos =new DataOutputStream(client.getOutputStream());
		dos.writeInt(6);
		dos.flush();
		dos.writeUTF(name);
		dos.flush();
		dos.writeUTF(password);
		dos.flush();
		dos.writeUTF(role);
		dos.flush();
		dis =new DataInputStream(client.getInputStream());
		}catch (Exception e) {
		e.printStackTrace();
		}finally{
		if(fis !=null)
		fis.close();
		if(dos !=null)
		dos.close();
		client.close();
		            }
		}catch (Exception e) {
		e.printStackTrace();
		        }
	if((name!=null)&&(password!=null)&&(role.equals("administrator")||role.equals("operator")||role.equals("browser")))
	{return true;}
	else
	{
		return false;
	}
}
	public static void disconnectFromDB() {
		if ( connectToDB ){
			// close Statement and Connection            
			try{
				rs.close();                        
			    st.close();                        
			    con.close();                       
			}catch ( SQLException sqlException ){                                            
			    sqlException.printStackTrace();           
			}finally{                                            
				connectToDB = false;              
			}                             
		} 
   }           

	
	
}

