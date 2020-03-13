package impl;

import dao.assigndao;
import jdbc.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class assigndao1 implements assigndao{

    private Connection connection = jdbc.getConnection();

    @Override
    public void assign(int tid, int hid) {

        String sql = "INSERT INTO assign (tid, hid) VALUES (?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, tid);
            pst.setInt(2, hid);

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
