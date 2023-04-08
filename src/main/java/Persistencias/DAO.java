package Persistencias;

import java.sql.*;

public abstract class DAO {

    //Para evitar conexion inesperadas

    protected Connection connection = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "qatar2022";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conecctionDatabase() throws Exception{
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/"+ DATABASE + "?useSSL=false";

            connection = DriverManager.getConnection(urlBaseDeDatos, USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar a la base de datos");
            throw ex;
        }
    }

    protected void queryDataBase(String sql) throws Exception{ //SELECT
        try {
            conecctionDatabase();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception ex){
            System.out.println("Error al realizar consulta");
            throw ex;
        }
    }

    protected void insertUpdateDelete(String sql) throws Exception{
        try {
            conecctionDatabase();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex){
            //connection.rollback();
            throw ex;
        } finally {
            disconnectDataBase();
        }
    }

    protected void disconnectDataBase() throws Exception{
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (Exception ex){
            System.out.println("Error al desconectar la base de datos");
            throw ex;
        }
    }
}
