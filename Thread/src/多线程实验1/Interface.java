package ���߳�ʵ��1;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.html.ImageView;
public class Interface extends JFrame{
	

public Interface(){
	 JButton jbtk1=new JButton("��¼");
	 jbtk1.setForeground(Color.BLUE);
	 jbtk1.setFont(new Font("����", 1, 25));
	 JButton jbtk2=new JButton("�˳�");
	 jbtk2.setForeground(Color.BLUE);
	 jbtk2.setFont(new Font("����", 1, 25));
	 JLabel jlb=new JLabel("�� ӭ �� �� �� �� �� �� ϵ ͳ ��",JLabel.CENTER);
	 jlb.setFont(new Font("����",1,35));
	 jlb.setForeground(Color.YELLOW);
	 JLabel jlabel=new JLabel(new ImageIcon("4.jpg"));
	 jlb.setBounds(780,20,625,200);
	 jbtk1.setBounds(900,200,100,60);
	 jbtk2.setBounds(1150,200,100,60);
	 jlabel.add(jlb);
	 jlabel.add(jbtk1);
	 jlabel.add(jbtk2);
	 JPanel p1=new JPanel();
	 p1.add(jlabel);
 
    add(p1);
    jbtk1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			DInterface frame=new DInterface();
			frame.setTitle("��¼ϵͳ");
			frame.setSize(650,425);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		}
		});	
    jbtk2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
		});	
    
}

}