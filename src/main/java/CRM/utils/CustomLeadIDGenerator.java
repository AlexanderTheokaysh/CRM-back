package CRM.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class CustomLeadIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "L ";
        String query = "SELECT UID FROM leads";
        Connection connection = null;
        try {
            connection = session.getJdbcConnectionAccess().obtainConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.isLast()) {
                    String lastId = rs.getString(1);
                    if (lastId != null) {
                        int number = parseInt(lastId.substring(prefix.length())) + 1;
                        return prefix + number;
                    }
                }
            }
        } catch (SQLException e) {
            throw new HibernateException("Unable to generate ID", e);
        }

        return prefix + 1; // Initial value if no records are present
    }
}