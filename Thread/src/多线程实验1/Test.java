package ���߳�ʵ��1;
import java.util.Scanner;
import java.io.*;
import java.sql.*;

import javax.swing.JFrame;
public class Test{
	
public static void main(String[] args){
	Interface frame=new Interface();
	frame.setTitle("��������ϵͳ");
	frame.setSize(650,425);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	// TODO Auto-generated method stub
/*String tip_system = "����ϵͳ";
    String tip_menu = "��ѡ��˵�: ";       
    String tip_exit = "ϵͳ�˳�, ллʹ�� ! ";
    String infos =  "****��ӭ����" + tip_system + "****\n\t    " +
                     "1.��¼\n  \t    2.�˳�\n" +
                     "*****************************";
    String name,password;       
    
    System.out.println (infos);
    System.out.print (tip_menu);
    
	//�û���¼
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
                    case 1://��¼
                        System.out.print("�������û�����");		
                        name=scanner.next();
                        System.out.println("��������");	
                        password=scanner.next();
					User user=DataProcessing.searchUser(name, password);
					if (user==null)
						System.out.println("�û����������");
					else
						user.showMenu();
                        break;
		
                        
                    case 2://�˳�
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
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}*/
}
}
