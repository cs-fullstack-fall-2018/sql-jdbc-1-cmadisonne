import java.sql.*;
public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Connection connection = DriverManager.getConnection("jdbc:sqlite:teacherDB");
        Statement stmt=connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM Teachers LEFT JOIN Classes ON Teachers.ClassID = Classes.ClassID");
        ResultSet resultSet1 = stmt.executeQuery("SELECT * FROM Classes LEFT JOIN Teachers ON Classes.ClassID = Teachers.ClassID");

        while (resultSet.next())
        {
            String FirstName = resultSet.getString("FirstName");
            Integer TeacherID = resultSet.getInt("TeacherID");
            Integer ClassID = resultSet.getInt("ClassID");
            String ClassName = resultSet.getString("ClassName");
            String Time = resultSet.getString("Time");
            System.out.println(TeacherID + ", " + FirstName + ", " + ClassName + ", " + Time + ", " + ClassID );

            String TName = resultSet1.getString("FirstName");
            Integer TID = resultSet1.getInt("TeacherID");
            Integer CID = resultSet1.getInt("ClassID");
            String CName = resultSet1.getString("ClassName");
            String time = resultSet1.getString("Time");
            System.out.println(CID + ", "  + CName + ", "  + time + ", " + TName );
        }

        stmt.close();
        connection.close();
    }
}
