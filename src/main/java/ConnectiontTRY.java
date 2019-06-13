import java.sql.*;

public class ConnectiontTRY {

    public static void main(String[] args) throws SQLException {


        Connection connection = null;

        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db", "root", "");


            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM beers WHERE Alcohol > ?", ResultSet.TYPE_SCROLL_INSENSITIVE);

            //PreparedStatement preparedStatement =
                //    connection.prepareStatement("SELECT * FROM beers WHERE Alcohol > ?");
            

            preparedStatement1.setInt(1, 10);

            ResultSet rs1 = preparedStatement1.executeQuery();

            while (rs1.next()) {
                System.out.print(rs1.getString("NAME") + "   ");
                System.out.println(rs1.getString("Alcohol"));

            }
        }
    }
}
