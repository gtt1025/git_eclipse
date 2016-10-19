
import java.util.*;

/*��һ���������ֽ�������
 * ÿ������������д�ɼ���������˵���ʽ���⼸�������Ͷ��������������������
 */
public class IF {
    
	public static void main(String[] args) {
		long [] p=new long[10];
		primeFactor(p);// ����primeFactor()����
		System.out.print(p[0]);
		System.out.print(p[1]);
	}

	/*
	 * �����������n���зֽ���������Ӧ���ҵ�һ����С������k��Ȼ������������ɣ�
	 * (1)����������ǡ����n����˵���ֽ��������Ĺ����Ѿ���������ӡ�����ɡ�
	 * (2)���n>=k����n�ܱ�k��������Ӧ��ӡ��k��ֵ������n����k����,��Ϊ�µ���������n,�ظ�ִ�е�һ����   
	 * (3)���n���ܱ�k����������k+1��Ϊk��ֵ,�ظ�ִ�е�һ����  
	 */
	public static void primeFactor(long p[]) {// �÷�����һ���������ֽ����������˵���ʽ
        
		Scanner scan = new Scanner(System.in);// ���տ���̨�������Ϣ
		System.out.print("������һ����������");
        p=new long[10];
        int n=0;
		try {
			long num = scan.nextLong();// ȡ������̨�������Ϣ

			if (num < 2) {// ���������С��2,�����ʾ��Ϣ

				System.out.println("�������벻С��2����������");
			} else {

				int primeNumber = 2;// ������С������
				System.out.print(num + " = ");
				
				while (primeNumber <= num) {// ������С���������ʱ������ѭ��

					if (primeNumber == num) {// �����������������ʱ,ֱ�����

						System.out.print(num);
						break;// ����ѭ��

					} else if (num % primeNumber == 0) {// ���������������������Ϊ0ʱ,����������

						System.out.print(primeNumber + " * ");
						p[n++]=primeNumber;
						System.out.print(p[n++]);
						num = num / primeNumber;// ��ʣ�µĽ������num
						
					} else {// ��������Ϊ0ʱ,��������
						primeNumber++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("����������������");// ��׽�쳣,���������������
		}
	}
}

