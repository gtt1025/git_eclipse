package ���߳�ʵ��1;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Browser extends User{
	public Browser(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;
	}
	
	public void showMenu(){
		String tip_system = "�������Ա�˵�";
        String tip_menu = "��ѡ��˵�: ";        
        String infos =  "****��ӭ����" + tip_system + "****\n\t" +
                         "1.�����ļ�\n\t"+
                         "2.�ļ��б�\n\t"+
                         "3.�޸�����\n\t"+
                         "4.��         ��\n"+
                         "*****************************";
        String tip_exit = "ϵͳ�˳�, ллʹ�� ! ";        
       
        String password;
        String ID;
        
        System.out.println (infos);
        System.out.print (tip_menu);
         
        Scanner scanner = new Scanner (System.in);

        String input = null;
        while (true)	//(scanner.hasNext ())
        {
            input=scanner.next().trim();
        	if (!(input).matches ("1|2|3|4")){
        		System.err.print (tip_menu);
            }else{
                int nextInt = Integer.parseInt (input);
                switch (nextInt){
                    case 1://�����ļ�
                    	System.out.println("�����ļ�");
                    	System.out.println("�����뵵���ţ�");
                        ID=scanner.next();
                    	try{
                        	if (downloadFile(ID))
                        		System.out.println("���سɹ�! ");
                        	else
                        		System.out.println("����ʧ��! ");
                        }catch(SQLException e){
                        	System.out.println("���ݿ����"+e.getMessage());   
                        }catch(IOException e){
                        	System.out.println("�ļ�����"+e.getMessage());   
                        }      
                    	break;
                    case 2://�ļ��б�
                    	System.out.println("�ļ��б�");
                    	try{
                    		showFileList();
                    	}catch(SQLException e){
                    		System.out.println("���ݿ����"+e.getMessage());   
                        	//e.printStackTrace();                        	
                        }
                    	break;
                    case 3:
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
                        
                    case 4:
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
