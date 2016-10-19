package 多线程实验1;
import java.util.Scanner;
import java.io.*;
import java.sql.*;

import javax.swing.JFrame;
public class Test{
	
public static void main(String[] args){
	Interface frame=new Interface();
	frame.setTitle("档案管理系统");
	frame.setSize(650,425);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	// TODO Auto-generated method stub
/*String tip_system = "档案系统";
    String tip_menu = "请选择菜单: ";       
    String tip_exit = "系统退出, 谢谢使用 ! ";
    String infos =  "****欢迎进入" + tip_system + "****\n\t    " +
                     "1.登录\n  \t    2.退出\n" +
                     "*****************************";
    String name,password;       
    
    System.out.println (infos);
    System.out.print (tip_menu);
    
	//用户登录
    Scanner scanner = new Scanner (System.in);

    String input = null;
    try{
        while (true)	//(scanner.hasNext ())
        {
            input=scanner.next().trim();
        	if (!(input).matches ("1|2")){
        		System.err.print (tip_menu);
            }else{
                int nextInt = Integer.parseInt (input);
                switch (nextInt){
                    case 1://登录
                        System.out.print("请输入用户名：");		
                        name=scanner.next();
                        System.out.println("请输入口令：");	
                        password=scanner.next();
					User user=DataProcessing.searchUser(name, password);
					if (user==null)
						System.out.println("用户名口令错误");
					else
						user.showMenu();
                        break;
		
                        
                    case 2://退出
                    	System.out.println (tip_exit);
                    	scanner.close();
                        System.exit (0);
                        break;    
                }

                System.out.println(infos);
                System.out.print(tip_menu);
            } 
        }
    }catch(IllegalStateException e){
    	System.out.println(e.getMessage());
    	System.exit (0);        	
    } catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}*/
}
}
