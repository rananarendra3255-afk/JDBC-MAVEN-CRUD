package demo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Insert Data
    public void insertStudent(Student s) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "insert into student values(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getAddress());

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Data Inserted");
            } else {
                System.out.println("Failed");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Select Data
    public void getAllStudents() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "select * from student";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("course") + " " +
                        rs.getString("email") + " " +
                        rs.getString("address")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Data
    public void updateStudent(int id, String course) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "update student set course=? where id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, course);
            ps.setInt(2, id);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Data Updated");
            } else {
                System.out.println("Record Not Found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete Data
    public void deleteStudent(int id) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "delete from student where id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Data Deleted");
            } else {
                System.out.println("Record Not Found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
