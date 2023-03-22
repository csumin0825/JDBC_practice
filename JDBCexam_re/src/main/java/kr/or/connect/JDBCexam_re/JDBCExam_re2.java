package kr.or.connect.JDBCexam_re;

import kr.or.connect.JDBCexam_re.dao.RoleDao;
import kr.or.connect.JDBCexam_re.dto.Role;

public class JDBCExam_re2 {

	public static void main(String[] args) {
		int roleId = 500;
		String description = "CTO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);
		
		System.out.println(insertCount);

	}

}
