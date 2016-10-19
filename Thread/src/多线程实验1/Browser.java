package 多线程实验1;
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
		String tip_system = "档案浏览员菜单";
        String tip_menu = "请选择菜单: ";        
        String infos =  "****欢迎进入" + tip_system + "****\n\t" +
                         "1.下载文件\n\t"+
                         "2.文件列表\n\t"+
                         "3.修改密码\n\t"+
                         "4.退         出\n"+
                         "*****************************";
        String tip_exit = "系统退出, 谢谢使用 ! ";        
       
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
                    case 1://下载文件
                    	System.out.println("下载文件");
                    	System.out.println("请输入档案号：");
                        ID=scanner.next();
                    	try{
                        	if (downloadFile(ID))
                        		System.out.println("下载成功! ");
                        	else
                        		System.out.println("下载失败! ");
                        }catch(SQLException e){
                        	System.out.println("数据库错误"+e.getMessage());   
                        }catch(IOException e){
                        	System.out.println("文件错误"+e.getMessage());   
                        }      
                    	break;
                    case 2://文件列表
                    	System.out.println("文件列表");
                    	try{
                    		showFileList();
                    	}catch(SQLException e){
                    		System.out.println("数据库错误"+e.getMessage());   
                        	//e.printStackTrace();                        	
                        }
                    	break;
                    case 3:
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
