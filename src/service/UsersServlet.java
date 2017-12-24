package service;

import java.util.List;

import dao.EntityDaoI;
import entity.Movies;
import entity.Users;

public  class UsersServlet implements UsersServletImp{
	private EntityDaoI entityDaoI;
	
	public EntityDaoI getEntityDaoI() {
		return entityDaoI;
	}

	public void setEntityDaoI(EntityDaoI entityDaoI) {
		this.entityDaoI = entityDaoI;
	}

	public List usersSelect()throws Exception{
		return entityDaoI.findAllObject(Users.class);
	}
    public void addUsers(Users userr) throws Exception{
    	entityDaoI.addObject(userr);
    }
    public void delUsers(Users userr) throws Exception{
    	entityDaoI.delObject(userr);
    }

    public List addSelt(String name)throws Exception{
		return entityDaoI.mistedSelect(Users.class, name);
	}
    public void updateUsers(Users userr) throws Exception{
    	Users d = (Users) entityDaoI.findObjectByID(Users.class, userr.getUserid());
    	userr.setUserpasswd(d.getUserpasswd());
    	entityDaoI.updateObject(userr);
    }
    
    public void updateUser(Users userr) throws Exception{
    	entityDaoI.updateObject(userr);
    }
    public Users usersSelectId(int id) throws Exception{
		
    	return (Users) entityDaoI.findObjectByID(Users.class, id);
    	
    }
    
  //��Ӱ����ѯ
  public List voidSelt(int name)throws Exception{
    	
    	return entityDaoI.voidSelect(Movies.class, name);
    }
  //��Ӱ���в�ѯ
    public List voidSelect()throws Exception{
    	return entityDaoI.findAllObject(Movies.class);
    }
    //��Ӱ����
    public Movies voidXq(int id) throws Exception{
    	return (Movies) entityDaoI.findObjectByID(Movies.class, id);
    }
/**��ѯ����11.14
 * @throws Exception */
    public List findOrders(int id) throws Exception{
    	return entityDaoI.findAll("From Orders as o where o.users.userid ="+id);
    }
    
    /**ͳ����״ͼ����*/
    public List findorder(int uid) throws Exception{
    	return entityDaoI.finddcd("select sum(o.cost),month(o.scheduledtime) From Orders as o where o.users.userid="+uid+" group by month(o.scheduledtime)");
    }
}
