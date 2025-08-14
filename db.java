import java.sql.*;
import java.util.Scanner;

public class TaskConsoleApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/taskdb";
        String user = "root";
        String pwd = "your_password";

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add 2.View 3.Update 4.Delete 5.Exit");
            System.out.print("Select: ");
            int opt = sc.nextInt();
            sc.nextLine();

            if (opt == 1) {
                System.out.print("Enter title: ");
                String txt = sc.nextLine();
                try {
                    Connection conn = DriverManager.getConnection(url, user, pwd);
                    String sql = "INSERT INTO tasks (title, status) VALUES (?, ?)";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, txt);
                    pst.setString(2, "pending");
                    pst.executeUpdate();
                    pst.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opt == 2) {
                try {
                    Connection conn = DriverManager.getConnection(url, user, pwd);
                    String sql = "SELECT * FROM tasks";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String t = rs.getString("title");
                        String s = rs.getString("status");
                        System.out.println(id + " | " + t + " | " + s);
                    }
                    rs.close();
                    pst.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opt == 3) {
                System.out.print("Enter ID: ");
                int tid = sc.nextInt();
                sc.nextLine();
                System.out.print("New Title: ");
                String newTitle = sc.nextLine();
                try {
                    Connection conn = DriverManager.getConnection(url, user, pwd);
                    String sql = "UPDATE tasks SET title = ? WHERE id = ?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, newTitle);
                    pst.setInt(2, tid);
                    pst.executeUpdate();
                    pst.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opt == 4) {
                System.out.print("Enter ID: ");
                int tid = sc.nextInt();
                try {
                    Connection conn = DriverManager.getConnection(url, user, pwd);
                    String sql = "DELETE FROM tasks WHERE id = ?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setInt(1, tid);
                    pst.executeUpdate();
                    pst.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opt == 5) {
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
        sc.close();
    }
}