package manage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.studentmanagement.CP;


public class StudentDao {
	
	public static boolean InsertStudentToDB(Student st) {
		boolean f = false;
		// jdbc code
		try {

			Connection con = CP.createc();
			String q = "insert into student(sname,sphone,scity) values(?,?,?)";
			// preparedstatement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			// execute;
			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return f;

	}

	public static boolean deleteStudent(int userid) {

		// TODO Auto-generated method stub
		boolean f = false;
		// jdbc code
		try {

			Connection con = CP.createc();
			String q = "delete from student where sid=?";
			// preparedstatement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the values of parameters
			pstmt.setInt(1, userid);
			
			

			// execute;
			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return f;
		
	}

	public static void showAllStudent() {
		boolean f = false;
		// jdbc code
		try {

			Connection con = CP.createc();
			String q = "select * from student;";
			// preparedstatement
			java.sql.Statement stmt=con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString("scity");
				System.out.println("ID : "+id);
				System.out.println("NAME : "+name);
				System.out.println("PHONE : "+phone);
				System.out.println("CITY : "+city);
				System.out.println("++++++++++++++++++++++++++++++");
			}
			

			
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public static boolean updateStudent(Student st) {
	    boolean f = false;
	    try {
	        Connection con = CP.createc();
	        String q = "update student set sname=?, sphone=?, scity=? where sid=?";
	        PreparedStatement pstmt = con.prepareStatement(q);

	        pstmt.setString(1, st.getStudentName());  // Bind the parameters
	        pstmt.setString(2, st.getStudentPhone());
	        pstmt.setString(3, st.getStudentCity());
	        pstmt.setInt(4, st.getStudentid());

	        int rowsUpdated = pstmt.executeUpdate();  // Execute the update statement
	        if (rowsUpdated > 0) {
	            System.out.println("Table updated");
	            f = true;
	        } else {
	            System.out.println("No rows updated. Student may not exist.");
	        }
	        pstmt.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}

		
		
	}


