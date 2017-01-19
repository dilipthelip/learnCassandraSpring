package com.learncassandra.dao;

import com.datastax.driver.core.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by z001qgd on 1/18/17.
 */
@Component
public class LearnCassandraDAO {

    @Autowired
    CassandraOperations cassandraTemplate;


    public String getCourseName() throws SQLException {

        ResultSet rs = (ResultSet) cassandraTemplate.query("SELECT * FROM learncassandra.COURSES WHERE ID='AngularJS-Get-Started' and MODULE_ID=1");

       // System.out.println("Author Name is : " + rs.all());

        List<Row> rowList = rs.all();
        String name="";
        //rowList.stream().forEach(row -> row.getString("id"));
        for (Row row : rowList) {
            System.out.println(row.getString("id"));
            name = row.getString("id");
        }


        return name;
    }

}
