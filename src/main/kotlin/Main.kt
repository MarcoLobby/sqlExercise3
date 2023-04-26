import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

fun main(args: Array<String>) {
    try {
        val connection: Connection =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/pinodb", "developer", "developer")
        val statement: Statement = connection.createStatement()

        var surnames : ArrayList <String> = ArrayList<String>()

        val resultSet : ResultSet = statement.executeQuery("select * from students")
        while (resultSet.next()){
            println(resultSet.getString("first_name"))

            surnames.add(resultSet.getString("last_name"))

        }

        println(surnames)

    } catch (e: Exception) {
        e.printStackTrace()
    }
}