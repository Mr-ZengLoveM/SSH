package dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import entity.Orders;
import page.PageInfo;

public class Test {
public static void main(String[] args) throws Exception {
//	Session session = HibernateSessionFactory.getSession();
//	Query query = session.createQuery("From Student");
//	List<Student> students = query.list();
	//ApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationContext.xml");
	
	//1
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
	//2
	Date now = new Date(); 
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//���Է�����޸����ڸ�ʽ
	String hehe = dateFormat.format( now ); 
	System.out.println(hehe); 
	//3
	Calendar c = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸�
	int year = c.get(Calendar.YEAR); 
	int month = c.get(Calendar.MONTH); 
	int date = c.get(Calendar.DATE); 
	int hour = c.get(Calendar.HOUR_OF_DAY); 
	int minute = c.get(Calendar.MINUTE); 
	int second = c.get(Calendar.SECOND); 
	System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second); 
}
}
