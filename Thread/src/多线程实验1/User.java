package 多线程实验1;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;
public abstract  class User{
 String name;
 String password;                                                            
String role;
String uploadpath="g:\\uploadfile\\";
String downloadpath="g:\\downloadfile\\";
public User(){
	
}
public User(String name,String password,String role){
	this.name=name;
	this.password=password;
	this.role=role;				
}

public boolean changeUserInfo(String password) throws SQLException,IllegalStateException{
	//写用户信息到存储
	if (DataProcessing.updateUser(name, password, role)){
		this.password=password;
		System.out.println("修改成功");
		return true;
	}else
		return false;
}

public boolean downloadFile(String ID) throws SQLException,IOException{
	//boolean result=false;
	byte[] buffer = new byte[1024];
	Doc doc=DataProcessing.searchDoc(ID);
	
	if (doc==null)
		return false;
	
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
    //System.out.println("copy success! ");		
}

public void showFileList() throws SQLException{
	Enumeration<Doc> e= DataProcessing.getAllDocs();
	while( e.hasMoreElements() ){
		 Doc doc=new Doc(((ResultSet) e).getString("ID"),((ResultSet) e).getString("creator"),((ResultSet) e).getTimestamp("timestamp"),((ResultSet) e).getString("description"),((ResultSet) e).getString("filename"));
		System.out.println("ID:"+doc.getID()+" Creator:" +doc.getCreator()+" Time:" +doc.getTimestamp()+" Filename:"+doc.getFilename());
		System.out.println("Description:"+doc.getDescription());
	}
	
}

public abstract void showMenu();

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}
}
