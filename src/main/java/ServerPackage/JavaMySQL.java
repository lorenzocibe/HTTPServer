
package ServerPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;


public class JavaMySQL {
    ArrayList <Impiegati> impiegati=new ArrayList<>();
    public void start(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connessione=DriverManager.getConnection("jdbc:mysql://localhost:3306/TPSIT?user=root&password=LC-23-dscrd&serverTimezone=Europe/Rome");
            Statement statement= connessione.createStatement();
            ResultSet resultset= statement.executeQuery("SELECT * FROM Impiegati");
            while(resultset.next()){
                String nome=resultset.getString("nome");
                String cognome=resultset.getString("cognome");
                impiegati.add(new Impiegati(nome, cognome));
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }

    public ArrayList<Impiegati> getImpiegati() {
        return impiegati;
    }

    public JavaMySQL() {
        start();
    }
    
    
}
