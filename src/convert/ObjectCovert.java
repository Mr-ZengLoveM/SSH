package convert;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;


public class ObjectCovert<T> extends StrutsTypeConverter {

	// ��ҳ���ύ����������תΪ�����󼯺�
	@Override
	public Object convertFromString(Map context, String[] ids, Class target) {
		Field fd = target.getDeclaredFields()[0];//��ô�ת������������ԣ���Ӧ���ݿ�������
		fd.setAccessible(true);//�޸�Ϊ������ֵ
		Object obj = null;
		System.out.println(fd);
		try {
			obj = target.newInstance();//����Ŀ���������ͳ�ʼ����һ������
			                           //�罫 cno��ֵ��Clazz�༶�����������ͨ��Ŀ�����ͻ�ö���

	        fd.set(obj, ids[0]);//��ҳ�洫�ݹ�����ֵ��ͬ��ֵ��Ϊ���飩
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj);
        return obj;//����Ѿ���ʼ�����Ҹ�������ֵ�Ķ��󣬽����ظ����õ�action��������ע�룬
        //��Ϊ��ע��ʱ��student.clazz=ת����������ע�������ص�obj����
       //studentAction.student.clazz��ֵע��
	}

	// �����ݿ����Ķ��󼯺�ת��Ϊҳ���ǩ��Ҫ�������ַ�������
	@Override
	public String convertToString(Map context, Object target) {
		return "";
	}

}
