package data.interfaces;

import java.sql.Connection;

public interface IDataBase {
    Connection getConnection();
}
