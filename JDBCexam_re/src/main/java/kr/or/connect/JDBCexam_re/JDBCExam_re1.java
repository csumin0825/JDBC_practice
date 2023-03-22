package kr.or.connect.JDBCexam_re;

import kr.or.connect.JDBCexam_re.dao.RoleDao;
import kr.or.connect.JDBCexam_re.dto.Role;

public class JDBCExam_re1 {

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);

	}

}
