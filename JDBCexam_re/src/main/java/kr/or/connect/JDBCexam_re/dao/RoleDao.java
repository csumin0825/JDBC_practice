package kr.or.connect.JDBCexam_re.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.JDBCexam_re.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbPassword = "connect123!@#";
	
	public int addRole(Role role) {
		int insertCount = 0; // 리턴값 
		
		// insert문이라서 ResultSet은 없다.
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbPassword);
			
			String sql = "INSERT INTO role(role_id, description) values (?,?)";
			ps = conn.prepareStatement(sql);
			
			// ? 자리 채우기 
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			//  insert에서는 executeUpate 사용 
			insertCount = ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return insertCount;
		
	}
	
	
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로딩 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// DriverManager라는 클래스가 가지고 있는 getConnection메서드 이용해서 connection 객체 얻어오기 
			conn = DriverManager.getConnection(dburl, dbUser, dbPassword);
			
			// ?는 계속 바뀌면서 바인딩 
			String sql = "select description,role_id from role where role_id = ?";
			ps = conn.prepareStatement(sql);
			// 1: 첫 번째 물음표에  // roleId: roleId를 넣는다 
			ps.setInt(1, roleId);
			rs = ps.executeQuery(); // 실
			
			// next: 결과값이 있으면 첫 번째 레코드로 커서를 이동 후 true 리턴 / 없으면 false 리턴 
			if(rs.next()) {
				// 컬럼 순서대로 
				// column 나열 순서대로 description이 첫 번째라서 1 (description으로 입력해도됨 )
				String description = rs.getString(1); 
				// role_id 라고 직접 지명해도됨 (2로 입력해도됨 )
				int id = rs.getInt("role_id");
				role = new Role(id, description);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	}

}
