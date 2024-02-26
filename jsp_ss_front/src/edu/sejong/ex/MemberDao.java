package edu.sejong.ex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDao {
	
	public static final int MEMBER_LOGIN_FAIL = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	// 커넥션 풀 객체
	private DataSource dataSource = null;

	public MemberDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberDto> selectMembers() {
		List<MemberDto> memberList = new ArrayList<>();
		
		int result = MemberDao.MEMBER_LOGIN_FAIL; // 0
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from members";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String address = rs.getString("address");
				
				MemberDto member = new MemberDto(id,pw,email,address);
				memberList.add(member);
				result++;
				System.out.println(result + "개의 리스트가 담깁니다.");
			}				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return memberList;
	}
	
	public int userCheck(String id, String pw) {
		int result = MemberDao.MEMBER_LOGIN_FAIL; // 0
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from members where id = ? and pw = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pw = rs.getString("pw");
				id = rs.getString("id");
				System.out.println("로그인 정보 있음. id : " + id + ", pw : "+ pw);
				result = MemberDao.MEMBER_LOGIN_SUCCESS; // 1
			}				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}
	
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from members where id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
			}				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dto;
	}
	
	public int insertMember(MemberDto member) {
		int result = MemberDao.MEMBER_LOGIN_FAIL; // 0
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into members(id,pw,email,address) values (?,?,?,?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddress());
			result = pstmt.executeUpdate();					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(MemberDto member) {
		int result = MemberDao.MEMBER_LOGIN_FAIL; // 0
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update members set pw = ? , email = ? , address = ? where id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getId());
			result = pstmt.executeUpdate();					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(MemberDto member) {
		int result = MemberDao.MEMBER_LOGIN_FAIL; // 0
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete from members where id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			result = pstmt.executeUpdate();					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;		
	}
	
//	public List<MemberDto> empList() {
//		List<MemberDto> emps = new ArrayList<>();
//
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		String sql = "select * from members";
//
//		try {
//			con = dataSource.getConnection();
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//
//				int empno = rs.getInt("empno");
//				String ename = rs.getString("ename");
//				String job = rs.getString("job");
//
//				int mgr = rs.getInt("mgr");
//
//				String hiredate = rs.getString("hiredate");
//				int sal = rs.getInt("sal");
//				String comm = rs.getString("comm");
//				int deptno = rs.getInt("deptno");
//
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (stmt != null)
//					stmt.close();
//				if (con != null)
//					con.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return emps;
//	}
//
//	// 자바 1.7 이상 일때
//	public List<EmpDto> empList2() {
//		List<EmpDto> emps = new ArrayList<>();
//
//		String sql = "select * from emp";
//		// Try-with-resources
//		try (Connection con = dataSource.getConnection();
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);) {
//
//			while (rs.next()) {
//
//				int empno = rs.getInt("empno");
//				String ename = rs.getString("ename");
//				String job = rs.getString("job");
//
//				int mgr = rs.getInt("mgr");
//
//				String hiredate = rs.getString("hiredate");
//				int sal = rs.getInt("sal");
//				String comm = rs.getString("comm");
//				int deptno = rs.getInt("deptno");
//
//				EmpDto dto = new EmpDto(empno, ename, job, mgr, hiredate, sal, deptno);
//
//				emps.add(dto);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return emps;
//	}
//
//   public String getHtml() {
//      String html = "";
//      List<EmpDto> emps = empList();
//      
//      for (EmpDto emp : emps) {
//         html  = html + emp.toString() + "<br>";
//      }
//      
//      return html;
//   }

	// 자바 1.11 이상 일때
//      public List<EmpDto> empList3(){
//         List<EmpDto> emps = new ArrayList<>();   
//         
//         String sql = "select * from emp";
//         //Try-with-resources
//         Connection con =  DriverManager.getConnection(url,id,pw);
//         Statement stmt = con.createStatement();
//         ResultSet rs=stmt.executeQuery(sql);
//         
//         try(con; stmt; rs) {
//            
//               while(rs.next()){
//                
//                  int empno = rs.getInt("empno");
//                String ename = rs.getString("ename");
//                String job = rs.getString("job");
//                
//                int mgr = rs.getInt("mgr");
//                
//                String hiredate = rs.getString("hiredate");
//                int sal = rs.getInt("sal");
//                String comm = rs.getString("comm");
//                int deptno = rs.getInt("deptno");
//                
//                EmpDto dto = new EmpDto(empno, ename,  job, mgr, hiredate, sal, deptno);
//             
//                emps.add(dto);
//             }     
//            
//         } catch (Exception e) {
//            e.printStackTrace();
//         } 
//         
//         return emps;
//      }

}