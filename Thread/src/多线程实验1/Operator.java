package ���߳�ʵ��1;
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
			int byteRead=infile.read(buffer); //���ļ������ݸ��ֽ�����
            if (byteRead==-1) //���ļ�β�������ݿɶ�
                break;  //�˳�ѭ��           
            targetfile.write(buffer,0,byteRead);  //������������д��Ŀ���ļ�
        }
		infile.close();
		targetfile.close();
        //System.out.println("copy success! ");
        
        String creator= this.getName();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //insert record into database
        //result=
		if (!DataProcessing.uploadFile(ID, creator,description, filename)){
			//System.out.println("�ϴ��ļ����ִ���");
			tempFile =new File(uploadpath+filename);
			tempFile.delete();
			return false;
		}else
			return true;
		
	}	

	
	public void showMenu(){
		String tip_system = "����¼��Ա�˵�";
        String tip_menu = "��ѡ��˵�: ";        
        String infos =  "****��ӭ����" + tip_system + "****\n\t" +
                         "1.�ϴ��ļ�\n\t"+
                         "2.�����ļ�\n\t"+
                         "3.�ļ��б�\n\t"+
                         "4.�޸�����\n\t"+
                         "5.��         ��\n"+
                         "*****************************";
        String tip_exit = "ϵͳ�˳�, ллʹ�� ! ";        
       
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
                    case 1://�ϴ��ļ�
                    	
                        System.out.println("�ϴ��ļ�");                        
                        System.out.println("������Դ�ļ�����");
                        filename=scanner.next();
                        System.out.println("�����뵵���ţ�");
                        ID=scanner.next();
                        System.out.println("�����뵵��������");
                        description=scanner.next();
                        
                        try{
                        	if(uploadFile(filename, ID, description))
                        		System.out.println("�ϴ��ɹ�! ");
                        	else
                        		System.out.println("�ϴ�����! ");
                        }catch(SQLException e){
                        	System.out.println("���ݿ����"+e.getMessage());   
                        }catch(IOException e){
                        	System.out.println("�ļ�����"+e.getMessage());   
                        }                        
                        break;
                        
                    case 2://�����ļ�
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
                    case 3://�ļ��б�
                    	System.out.println("�ļ��б�");
                    	try{
                    		showFileList();
                    	}catch(SQLException e){
                    		System.out.println("���ݿ����"+e.getMessage());   
                        	//e.printStackTrace();                        	
                        }
                    	break;
                    case 4:
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
