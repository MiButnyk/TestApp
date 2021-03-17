package pack;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository("oracle")
public class DAO {

    public Connection connection;

    public DAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@91.219.60.189:1521/XEPDB1",
                    "butnik_mihail", "Oracle11XE#");
            this.connection = con;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void head(String str) {
        str = str.toLowerCase();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select head_of_department " +
                    "from department " +
                    "where lower(department_name) = '" + str + "'");
            if (res.next()) {
                System.out.println("Head of " + str + " department is " + res.getString("head_of_department"));
            } else {
                System.err.println("There is no such department");
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void salary(String str) {
        str = str.toLowerCase();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select avg(l.salary) as salary " +
                    "from department d, lector l, workplace w " +
                    "where d.department_id = w.department_id AND w.lector_id = l.lector_id AND lower(d.department_name) = '" + str + "'");
            if (res.next()) {
                System.out.println("The average salary of " + str + " department is " + res.getString("salary") + "$");
            } else {
                System.err.println("There is no such department");
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void quantity(String str) {
        str = str.toLowerCase();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select count(l.lector_id) as count " +
                    "from department d, lector l, workplace w " +
                    "where d.department_id = w.department_id AND w.lector_id = l.lector_id AND lower(d.department_name) = '" + str + "'");
            if (res.next()) {
                System.out.println(res.getInt("count"));
            } else {
                System.err.println("There is no such department");
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void statistics(String str) {
        str = str.toLowerCase();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select l.degree as degree " +
                    "from department d, lector l, workplace w " +
                    "where d.department_id = w.department_id AND w.lector_id = l.lector_id AND lower(d.department_name) = '" + str + "'");
            int count = 0;
            int ass = 0;
            int asspr = 0;
            int prof = 0;
            while (res.next()) {
                if (res.getString("degree").equals("Assistant")) {
                    ass++;
                } else if (res.getString("degree").equals("Professor")) {
                    prof++;
                } else {
                    asspr++;
                }
                count++;
            }
            if (count == 0) {
                System.err.println("There is no such department");
            } else {
                System.out.println("assistants - " + ass + "\n" +
                        "associate professors - " + asspr + "\n" +
                        "professors - " + prof);
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void search(String str) {
        str = str.toLowerCase();
        try {
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            ResultSet res1 = statement1.executeQuery("select lector_name " +
                    "from lector " +
                    "where lower(lector_name) like '%" + str + "%'");
            ResultSet res2 = statement2.executeQuery("select department_name " +
                    "from department " +
                    "where lower(department_name) like '%" + str + "%'");
            int count = 0;
            StringBuilder stringBuilder = new StringBuilder();
            String separator = "";
            while (res1.next()) {
                stringBuilder.append(separator);
                separator = ", ";
                stringBuilder.append(res1.getString("lector_name"));
                count++;
            }
            while (res2.next()) {
                stringBuilder.append(separator);
                stringBuilder.append(res2.getString("department_name"));
                count++;
            }
            if (count == 0) {
                System.err.println("There is no such department");
            } else {
                System.out.println(stringBuilder);
            }
            statement1.close();
            statement2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
