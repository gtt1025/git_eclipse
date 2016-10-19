package 多线程实验1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;

public class Administrator extends User{
public Administrator(String name,String password,String role){
	this.name=name;
	this.password=password;
	this.role=role;
	}

public boolean changeUserInfo(String name, String password, String role) throws SQLException{		
	return (DataProcessing.updateUser(name, password, role));		
}

public boolean delUser(String name) throws SQLException{
	return (DataProcessing.deleteUser(name));
		 
}

public boolean addUser(String name, String password, String role) throws SQLException{
	return (DataProcessing.insertUser(name, password, role));			
}
public void listUser() throws SQLException{
	Enumeration<User> e  = DataProcessing.getAllUser();
	User user;
	while( e.hasMoreElements() ){
		user=e.nextElement();
		System.out.println("Name:"+user.getName()+"\t Password:" +user.getPassword()+"\t Role:" +user.getRole());
	}
	//return false;
}
public void showMenu(){
	String tip_system = "系统管理员菜单";
    String tip_menu = "请选择菜单: ";        
    String infos =  "****欢迎进入" + tip_system + "****\n\t" +
                     "1.修改用户\n\t"+
                     "2.删除用户\n\t"+
                     "3.新增用户\n\t"+
                     "4.列出用户\n\t"+
                     "5.修改本人密码\n\t"+
                     "6.退         出\n"+
                     "*****************************";
    String tip_exit = "系统退出, 谢谢使用 ! ";
    
    String name,password,role;
    
    System.out.println (infos);
    System.out.print (tip_menu);
     
    Scanner scanner = new Scanner (System.in);

    String input = null;
    while (true)	//(scanner.hasNext ())
    {
        input=scanner.next().trim();
    	if (!(input).matches ("1|2|3|4|5|6")){
    		System.err.print (tip_menu);
        }else{
            int nextInt = Integer.parseInt (input);
            switch (nextInt){
                case 1://修改用户信息
                    System.out.println("修改用户");
                    System.out.println("请输入用户名：");
                    name=scanner.next();
                    System.out.println("请输入口令：");
                    password=scanner.next();
                    System.out.println("请输入角色：");
                    role=scanner.next();
                    
                    try{

                    	if (changeUserInfo(name,password,role))
                        	System.out.println("修改成功");
                        else
                        	System.out.println("修改失败");
                    }catch(SQLException e){
                    	System.out.println("数据库错误"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }
                    break;
                    
                case 2:
                	System.out.println("删除用户");                    	
                	System.out.println("请输入用户名：");
                    name=scanner.next();
                    try{
                    	if (delUser(name))
                    		System.out.println("删除成功");
                    	else
                    		System.out.println("删除失败");
                    	 }catch(SQLException e){
                    	System.out.println("数据库错误"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }
                    break;
                	
                    
                case 3:
                	System.out.println("新增用户");
                	System.out.println("请输入用户名：");
                    name=scanner.next();
                    System.out.println("请输入口令：");
                    password=scanner.next();
                    System.out.println("请输入角色：");
                    role=scanner.next();
                    try{

                    	if (addUser(name,password,role))
                        	System.out.println("新增成功");
                        else
                        	System.out.println("新增失败");
                    }catch(SQLException e){
                    	System.out.println("数据库错误"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }
                    break;
                case 4:
                	System.out.println("列出用户");
                	/*try{
                	
                	}catch(SQLException e){
                		System.out.println("数据库错误"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }*/
                	break;
                case 5:
                	System.out.println("修改本人密码");                
                    System.out.println("请输入新口令：");
                    password=scanner.next();
                    try{
                    	changeUserInfo(password);
                    		
                    }catch(SQLException e){
                    	System.out.println("数据库错误"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }
                    break;
                case 6:
                	System.out.println (tip_exit);
                	scanner.close();
                    System.exit (0);
                    break;    
            }

            System.out.println(infos);
            System.out.print(tip_menu);
        }        
    }
}
}
