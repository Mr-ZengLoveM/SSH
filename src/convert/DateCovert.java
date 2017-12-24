package convert;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateCovert<T> extends StrutsTypeConverter {

	// ��ҳ���ύ����������תΪ�����󼯺�
	@Override
	public Object convertFromString(Map context, String[] ids, Class target) {
		Field[] fd = target.getDeclaredFields();
		Object obj = null;
		for (Field zd : fd) {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			try {
				return sdf.parse(ids[0]);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			zd.setAccessible(true);// �޸�Ϊ������ֵ
			try {
				obj = target.newInstance();
				zd.set(obj, ids);// ��ҳ�洫�ݹ�����ֵ��ͬ��ֵ��Ϊ���飩
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ����Ŀ���������ͳ�ʼ����һ������

		}
		return obj;// ����Ѿ���ʼ�����Ҹ�������ֵ�Ķ��󣬽����ظ����õ�action��������ע�룬
		// ��Ϊ��ע��ʱ��student.clazz=ת����������ע�������ص�obj����
		// studentAction.student.clazz��ֵע��
	}

	// �����ݿ����Ķ��󼯺�ת��Ϊҳ���ǩ��Ҫ�������ַ�������
	@Override
	public String convertToString(Map context, Object target) {
		return "";
	}

}
