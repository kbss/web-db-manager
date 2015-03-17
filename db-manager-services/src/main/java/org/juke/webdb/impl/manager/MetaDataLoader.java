package org.juke.webdb.impl.manager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.juke.webdb.dto.ColumnDto;
import org.juke.webdb.dto.ConnectionInfoDto;
import org.juke.webdb.dto.TableDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author user
 *
 */
public class MetaDataLoader {

    private Logger logger = LoggerFactory.getLogger(MetaDataLoader.class);

    public static void main(String args[]) throws InstantiationException, IllegalAccessException, SQLException {
        new MetaDataLoader().getMetadata(new File("sqlite.jar"));
    }

    private ConnectionInfoDto getConnectionInfo(Connection conection) throws SQLException {
        ConnectionInfoDto info = new ConnectionInfoDto();
        DatabaseMetaData metaData = conection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, "%", null);
        while (rs.next()) {
            info.getTables().add(getTableColumns(metaData, rs));
        }
        return info;
    }

    // Table
    // [TABLE_CAT, TABLE_SCHEM, TABLE_NAME, TABLE_TYPE, REMARKS, TYPE_CAT,
    // TYPE_SCHEM, TYPE_NAME, SELF_REFERENCING_COL_NAME, REF_GENERATION]

    // Column
    // [TABLE_CAT, TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, DATA_TYPE, TYPE_NAME,
    // COLUMN_SIZE, BUFFER_LENGTH, DECIMAL_DIGITS, NUM_PREC_RADIX, NULLABLE,
    // REMARKS, COLUMN_DEF, SQL_DATA_TYPE, SQL_DATETIME_SUB, CHAR_OCTET_LENGTH,
    // ORDINAL_POSITION, IS_NULLABLE, SCOPE_CATLOG, SCOPE_SCHEMA, SCOPE_TABLE,
    // SOURCE_DATA_TYPE]
    private TableDto getTableColumns(DatabaseMetaData metaData, ResultSet tableResultSet) throws SQLException {
        TableDto tableInfo = new TableDto();
        tableInfo.setName(tableResultSet.getString("TABLE_NAME"));
        tableInfo.setSchema(tableResultSet.getString("TABLE_SCHEM"));
        tableInfo.setCategory(tableResultSet.getString("TABLE_CAT"));
        ResultSet rs = metaData.getColumns(tableInfo.getCategory(), tableInfo.getSchema(), tableInfo.getName(), "%");
        while (rs.next()) {
            ColumnDto column = new ColumnDto();
            column.setName(rs.getString("COLUMN_NAME"));
            column.setType(rs.getString("TYPE_NAME"));
            column.setColumnSize(rs.getInt("COLUMN_SIZE"));
            tableInfo.getColumns().add(column);
        }
        System.out.println(tableInfo);
        return tableInfo;
    }

    private void getMetadata(File file) throws InstantiationException, IllegalAccessException, SQLException {

        try {
            URL[] urls = { new URL("jar:file:" + file.getAbsolutePath() + "!/") };
            URLClassLoader cl = URLClassLoader.newInstance(urls);
            Class<?> clazz = cl.loadClass("org.sqlite.JDBC");

            for (Class<?> cls : cl.loadClass("org.sqlite.JDBC").getInterfaces()) {
                System.out.println(cls.equals(java.sql.Driver.class));
                if (cls.equals(java.sql.Driver.class)) {
                    // DriverManager.registerDriver(driver);
                    // Class.forName(cls.getName(), true, cl).newInstance();
                    Driver drv = (Driver) clazz.newInstance();
                    Connection cnn = drv.connect("jdbc:sqlite:test.db", new Properties());
                    System.out.println("Opened!");
                    getConnectionInfo(cnn);
                }
            }
        } catch (MalformedURLException e) {
            logger.trace(e.getMessage(), e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.trace(e.getMessage(), e.getMessage());
        }
    }
}
