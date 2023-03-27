package kr.or.connect.JDBCexam_re;

import java.util.List;

import kr.or.connect.JDBCexam_re.dao.RoleDao;
import kr.or.connect.JDBCexam_re.dto.Role;

public class JDBCExam_re2 {

	public static void main(String[] args) {
//		// insert
//		int roleId_insert = 500;
//		String description_insert = "CTO";
//		
//		Role role_insert = new Role(roleId_insert, description_insert);
//		
//		RoleDao dao = new RoleDao();
//		int insertCount = dao.addRole(role_insert);
//		
//		System.out.println(insertCount);
//		
//		
//		// delete
//		int roleId_delete = 501;
//		
//		Role role_delete = new Role(roleId_delete);
//		
//		RoleDao dao_delete = new RoleDao();
//		int delteCount = dao_delete.deleteRole(role_delete);
//		
//		System.out.println(delteCount);
		
		
		
		
		// updateRole
		int roldId_update = 500;
		String description_update = " TEST";
		
		Role role_update = new Role(roldId_update, description_update);
		RoleDao dao_update = new RoleDao();
		
		int updateCount = dao_update.updateRole(role_update);
		System.out.println(updateCount);
		
		
		// getRole
		RoleDao dao_get = new RoleDao();
		List<Role> list = dao_get.getRoles();
		for(Role role:list) {
			System.out.println(role);
		}
	}

}
