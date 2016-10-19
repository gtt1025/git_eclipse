package ���߳�ʵ��1;

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
	String tip_system = "ϵͳ����Ա�˵�";
    String tip_menu = "��ѡ��˵�: ";        
    String infos =  "****��ӭ����" + tip_system + "****\n\t" +
                     "1.�޸��û�\n\t"+
                     "2.ɾ���û�\n\t"+
                     "3.�����û�\n\t"+
                     "4.�г��û�\n\t"+
                     "5.�޸ı�������\n\t"+
                     "6.��         ��\n"+
                     "*****************************";
    String tip_exit = "ϵͳ�˳�, ллʹ�� ! ";
    
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
                case 1://�޸��û���Ϣ
                    System.out.println("�޸��û�");
                    System.out.println("�������û�����");
                    name=scanner.next();
                    System.out.println("��������");
                    password=scanner.next();
                    System.out.println("�������ɫ��");
                    role=scanner.next();
                    
                    try{

                    	if (changeUserInfo(name,password,role))
                        	System.out.println("�޸ĳɹ�");
                        else
                        	System.out.println("�޸�ʧ��");
                    }catch(SQLException e){
                    	System.out.println("���ݿ����"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }
                    break;
                    
                case 2:
                	System.out.println("ɾ���û�");                    	
                	System.out.println("�������û�����");
                    name=scanner.next();
                    try{
                    	if (delUser(name))
                    		System.out.println("ɾ���ɹ�");
                    	else
                    		System.out.println("ɾ��ʧ��");
                    	 }catch(SQLException e){
                    	System.out.println("���ݿ����"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }
                    break;
                	
                    
                case 3:
                	System.out.println("�����û�");
                	System.out.println("�������û�����");
                    name=scanner.next();
                    System.out.println("��������");
                    password=scanner.next();
                    System.out.println("�������ɫ��");
                    role=scanner.next();
                    try{

                    	if (addUser(name,password,role))
                        	System.out.println("�����ɹ�");
                        else
                        	System.out.println("����ʧ��");
                    }catch(SQLException e){
                    	System.out.println("���ݿ����"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }
                    break;
                case 4:
                	System.out.println("�г��û�");
                	/*try{
                	
                	}catch(SQLException e){
                		System.out.println("���ݿ����"+e.getMessage());   
                    	//e.printStackTrace();                        	
                    }*/
                	break;
                case 5:
                	System.out.println("�޸ı�������");                
                    System.out.println("�������¿��");
                    password=scanner.next();
                    try{
                    	changeUserInfo(password);
                    		
                    }catch(SQLException e){
                    	System.out.println("���ݿ����"+e.getMessage());   
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
