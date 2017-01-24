package com.learncassandra;

import com.learncassandra.dao.LearnCassandraDAO;
import com.learncassandra.domain.CourseVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class LearnCassandraDaoTest {

	private static Logger logger= LoggerFactory.getLogger(LearnCassandraDaoTest.class);

	/*@Autowired
	CassandraTemplate cassandraTemplate;*/

	@Autowired
	Environment environment;

	@Autowired
	LearnCassandraDAO learnCassandraDAO;

	CourseVO insertCourseVO;

	CourseVO updateCourseVO;

	CourseVO deleteCourseVO;
	CourseVO selectCourseVO;

	@Before
	public void  setUpData(){

		//INSERT INTO learncassandra.COURSES (ID,NAME,AUTHOR,AUDIENCE,DURATION,CC,RELEASED,MODULE_ID,MODULE_NAME,MODULE_DURATION) " +
		//      "VALUES (?,?,?,?,?,?,?,?,?,?)
		//  "Node-JS-Started","NodeJS","Benny Jonhson",1,1033,true,new Date() ,1,"Why Node Js.",23);

		insertCourseVO = new CourseVO();
		insertCourseVO.setId("Node-JS-Started");
		insertCourseVO.setCourseName("NodeJS");
		insertCourseVO.setAuthor("Benny Jonhson");
		insertCourseVO.setAudience(1);
		insertCourseVO.setDuration(1033);
		insertCourseVO.setCc(Boolean.TRUE);
		insertCourseVO.setReleaseDate(new Date());
		insertCourseVO.setModuleId(1);
		insertCourseVO.setModuleName("Why Node Js.");
		insertCourseVO.setModuleDuration(23);

		updateCourseVO = new CourseVO();
		updateCourseVO.setAuthor("Samuel Jackson");
		updateCourseVO.setId("Node-JS-Started");
		updateCourseVO.setModuleId(1);

		deleteCourseVO = new CourseVO();
		deleteCourseVO.setId("Node-JS-Started");
		deleteCourseVO.setModuleId(1);

		selectCourseVO = new CourseVO();
		selectCourseVO.setId("AngularJS-Get-Started");
		selectCourseVO.setModuleId(1);



	}

	@Test
	public void insertCourseName(){
		Boolean result;
		try {

			result = learnCassandraDAO.insertCourseName(insertCourseVO);

			System.out.println("The Boolean return value  of insertCourseName is :  " + result);

			assertTrue(result);

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Exception in InsertCourseName : " + e);
		}
	}

	@Test
	public void updateCourseAuthor(){

		Boolean result;
		try {

			result = learnCassandraDAO.updateCourseAuthor(updateCourseVO);
			System.out.println("The boolean return value of updateCourseAuthor is :  " + result);


		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Exception in InsertCourseName : " + e);
		}
	}

	@Test
	public void getCourseName() throws SQLException {


		String courseName = learnCassandraDAO.getCourseName(selectCourseVO);

		System.out.println("courseName : "+ courseName);

		assertNotNull(courseName);
	}

	@Test
	public void deleteCourseAuthor(){

		Boolean result;
		try {

			result =  learnCassandraDAO.deleteCourse(deleteCourseVO);
			System.out.println("The boolean value of deleteCourseAuthor is :  " + result);


		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Exception in deleteCourseAuthor : " + e);
		}
	}

}
