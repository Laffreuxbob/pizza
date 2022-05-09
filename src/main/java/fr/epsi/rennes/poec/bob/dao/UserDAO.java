package fr.epsi.rennes.poec.bob.dao;

import fr.epsi.rennes.poec.bob.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserDAO {

    @Autowired
    private DataSource ds;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByEmail(String username) throws SQLException {

        String sqlSelect = "Select username, password FROM user WHERE username ='" + username + "'";
        Statement stmt = ds.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelect);

        if (rs.next()){
            User user = new User();
            user.setUsername(rs.getString(1));
            user.setPassword(rs.getString(2));
            return user;
        }else{
            return null;
        }
    }

    public void addUser(User user) throws SQLException {
        String password = passwordEncoder.encode(user.getPassword());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        String sql = "INSERT INTO user (username, password) VALUES ('" +
                user.getUsername() + "', '" + password + "');";

        Statement stmt = ds.getConnection().createStatement();
        stmt.executeUpdate(sql);
    }
}
