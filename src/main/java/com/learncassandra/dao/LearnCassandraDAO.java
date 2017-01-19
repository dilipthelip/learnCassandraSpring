package com.learncassandra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.ResultSet;
import java.sql.SQLException;

/**
 * Created by z001qgd on 1/18/17.
 */
@Component
public class LearnCassandraDAO {

    @Autowired
    CassandraOperations cassandraTemplate;


    public String getCourseName() throws SQLException {

        ResultSet rs = (ResultSet) cassandraTemplate.query("SELECT * FROM learncassandra.COURSES WHERE ID='AngularJS-Get-Started' and MODULE_ID=1");

        System.out.println("Author Name is : " + rs.all());

        return "";
    }

}
