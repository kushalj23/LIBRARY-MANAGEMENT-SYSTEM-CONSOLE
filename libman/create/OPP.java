package create;
import java.sql.*;
import java.util.Scanner;
public class OPP {
public static Connection jdbc() throws SQLException{
    String url = "jdbc:mysql://localhost:3306/libman";
    String user = "root";
    String password = "Jkl@12345";
    Connection con = DriverManager.getConnection(url,user,password);
    return con;
}

public static void create() throws SQLException{
    try{
    Connection con = jdbc();
    System.out.println("------>WELCOME TO CREATE AN ACCOUNNT<-------");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter id:");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter role:");
    String role = sc.nextLine();
    System.out.println("Enter password:");
    String password = sc.nextLine();
    System.out.println("Enter name:");
    String name = sc.nextLine();
    String create_account = "insert into dashboard(id,role,password,name) values(?,?,?,?);";
    PreparedStatement ps = con.prepareStatement(create_account);
    ps.setInt(1,id);
    ps.setString(2,role);
    ps.setString(3,password);
    ps.setString(4,name);
ps.executeUpdate();
    System.out.println("Account created successfully");
    }
    catch(Exception e){
        System.out.println("Error in creating account");
    }

}
public static void delete() throws Exception{
    try{


    Connection con = jdbc();
    System.out.println("------>WELCOME TO DELETE AN ACCOUNNT<-------");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter id to delete account:");
    int id = sc.nextInt();
    String del_query = "delete from  dashboard where id = ?;";
    PreparedStatement ps = con.prepareStatement(del_query);
    ps.setInt(1,id);
    ps.executeUpdate();
    System.out.println("Account deleted successfully");

    }
    catch(Exception e){
        System.out.println("Error in deleting account");
    }

}
public static void List() throws Exception{

    Connection con = jdbc();
     System.out.println("----------WELCOME TO THE LIBRARY MANAGEMENT SYSTEM--------------------");
    System.out.println("------>LIST OF ACCOUNTS<-------");
    String list_query = "select * from dashboard;";
    PreparedStatement ps = con.prepareStatement (list_query);
    ResultSet rs = ps.executeQuery();
    System.out.println("+-----+------------+----------------------+");
    System.out.println("| ID  |   ROLE     |        NAME          |");
    System.out.println("+-----+------------+----------------------+");
    while(rs.next()){
        int id = rs.getInt("id");
        String role = rs.getString("role");
        String name = rs.getString("name"); 
      String password = rs.getString("password");

    
       System.out.printf("| %-3d | %-10s | %-20s |\n", id, role, name);
       
    }
     System.out.println("------------------------------");

}
public static void bookEntry() throws Exception{
Connection con = jdbc();
    System.out.println("------>WELCOME TO BOOK ENTRY<-------");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter book id:");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter book name:");
    String book_title = sc.nextLine();
    String book_entry = "UPDATE dashboard SET book_title=?, book_in=CURRENT_TIMESTAMP WHERE id=?;" ;
    PreparedStatement ps = con.prepareStatement(book_entry);
    ps.setInt(2,id);
    ps.setString(1,book_title);
ps.executeUpdate();
    String book_in = "SELECT book_in FROM dashboard WHERE id = ?";
    PreparedStatement ps1 = con.prepareStatement(book_in);
    ps1.setInt(1, id);
    ResultSet rs = ps1.executeQuery();
    if (rs.next()) {
        book_in = rs.getString("book_in");
    }
    System.out.println("Book entry recorded at: " + book_in);
}
public static void bookdel() throws Exception {
    Connection con = jdbc();
    System.out.println("------>WELCOME TO BOOK DELETE<-------");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter book id:");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter book name:");
    String book_title = sc.nextLine();
    String book_entry = "UPDATE dashboard SET book_title=?, book_out=CURRENT_TIMESTAMP WHERE id=?;";
    PreparedStatement ps = con.prepareStatement(book_entry);
    ps.setString(1, book_title);
    ps.setInt(2, id);
    ps.executeUpdate();
    String book_out = "UPDATE dashboard SET book_title = NULL WHERE id=?;";
    PreparedStatement ps2 = con.prepareStatement(book_out);
    ps2.setInt(1, id);
    ps2.executeUpdate();
    String get_out = "SELECT book_out FROM dashboard WHERE id = ?";
    PreparedStatement ps1 = con.prepareStatement(get_out);
    ps1.setInt(1, id);
    ResultSet rs = ps1.executeQuery();
    String outTime = null;
    if (rs.next()) {
        outTime = rs.getString("book_out");
    }

    System.out.println("Book out recorded at: " + outTime);
}

}

