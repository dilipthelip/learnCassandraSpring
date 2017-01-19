package com.learncassandra;

import com.learncassandra.dao.LearnCassandraDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class LearnCassandraApplicationTests {

	/*@Autowired
	CassandraTemplate cassandraTemplate;*/

	@Autowired
	LearnCassandraDAO learnCassandraDAO;

	@Test
	public void contextLoads() throws SQLException {

		String courseName = learnCassandraDAO.getCourseName();

		System.out.println("courseName : "+ courseName);

		assertNotNull(courseName);
	}

}
