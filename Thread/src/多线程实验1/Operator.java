package 多线程实验1;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
public class Operator extends User{
	String uploadpath="g:\\uploadfile\\";
	String downloadpath="g:\\downloadfile\\";
	
	
	public Operator(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;	
	}
	
	public boolean uploadFile(String sourcefile, String ID, String description) throws SQLException,IOException{
		
		//boolean result=false;
		byte[] buffer = new byte[1024];
		
		File tempFile =new File(sourcefile.trim());
		String filename = tempFile.getName();
		
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
        
        String creator= this.getName();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //insert record into database
        //result=
		if (!DataProcessing.uploadFile(ID, creator,description, filename)){
			//System.out.println("上传文件出现错误");
			tempFile =new File(uploadpath+filename);
			tempFile.delete();
			return false;
		}else
			return true;
		
	}	

	
	public void showMenu(){
		String tip_system = "档案录入员菜单";
        String tip_menu = "请选择菜单: ";        
        String infos =  "****欢迎进入" + tip_system + "****\n\t" +
                         "1.上传文件\n\t"+
                         "2.下载文件\n\t"+
                         "3.文件列表\n\t"+
                         "4.修改密码\n\t"+
                         "5.退         出\n"+
                         "*****************************";
        String tip_exit = "系统退出, 谢谢使用 ! ";        
       
        String password;
        String filename,ID,description;
        
        System.out.println (infos);
        System.out.print (tip_menu);
         
        Scanner scanner = new Scanner (System.in);

        String input = null;
        while (true)	//(scanner.hasNext ())
        {
            input=scanner.next().trim();
        	if (!(input).matches ("1|2|3|4|5")){
        		System.err.print (tip_menu);
            }else{
                int nextInt = Integer.parseInt (input);
                switch (nextInt){
                    case 1://上传文件
                    	
                        System.out.println("上传文件");                        
                        System.out.println("请输入源文件名：");
                        filename=scanner.next();
                        System.out.println("请输入档案号：");
                        ID=scanner.next();
                        System.out.println("请输入档案描述：");
                        description=scanner.next();
                        
                        try{
                        	if(uploadFile(filename, ID, description))
                        		System.out.println("上传成功! ");
                        	else
                        		System.out.println("上传错误! ");
                        }catch(SQLException e){
                        	System.out.println("数据库错误"+e.getMessage());   
                        }catch(IOException e){
                        	System.out.println("文件错误"+e.getMessage());   
                        }                        
                        break;
                        
                    case 2://下载文件
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
                    case 3://文件列表
                    	System.out.println("文件列表");
                    	try{
                    		showFileList();
                    	}catch(SQLException e){
                    		System.out.println("数据库错误"+e.getMessage());   
                        	//e.printStackTrace();                        	
                        }
                    	break;
                    case 4:
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
                    case 5:
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
