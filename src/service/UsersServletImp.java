package service;

import java.util.List;

import entity.Movies;
import entity.Users;


public interface UsersServletImp {
	public List<Users> usersSelect()throws Exception;//��ѯ�����û��ӿ�
	public void addUsers(Users userr) throws Exception;//����û��ӿ�
	public void delUsers(Users userr) throws Exception;//ɾ���û��ӿ�
	public List<Users> addSelt(String name)throws Exception;//ģ����ѯ
	public void updateUsers(Users userr) throws Exception;//�����û���Ϣ
	public Users usersSelectId(int id) throws Exception;//ͨ��������ѯĳһ���û�����Ϣ,��ʾ�ڸ���ҳ��
	
	public List voidSelt(int name)throws Exception;
	public List voidSelect()throws Exception;
	public void updateUser(Users userr) throws Exception;
	 public Movies voidXq(int id) throws Exception;
	/**��ѯ����*/
	public List findOrders(int id) throws Exception;
	/**��ѯ����ÿ��������״ͼ��������*/
	public List findorder(int uid) throws Exception;
}
