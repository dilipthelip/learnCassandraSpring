package com.learncassandra;

import com.learncassandra.dao.LearnCassandraDAO;
import com.learncassandra.domain.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.Date;

@SpringBootApplication
public class LearnCassandraApplication {



	public static void main(String[] args) {

		//SpringApplication.run(LearnCassandraApplication.class, args);

        ConfigurableApplicationContext ctx = SpringApplication.run(LearnCassandraApplication.class, args);
        new LearnCassandraApplication().launch(ctx);


	}

	public void launch(ConfigurableApplicationContext ctx){

        LearnCassandraDAO learnCassandraDAO = ctx.getBean(LearnCassandraDAO.class);
        System.out.println("******* Reading the Data from Users Table *******");

        CourseVO courseVO = null;
        Boolean flag;
        String courseName;



        try {

            courseVO  = buildCourseVO(courseVO);
           courseName = learnCassandraDAO.getCourseName(courseVO);

            printCourse(courseName,courseVO);

            flag = learnCassandraDAO.insertCourseName(courseVO);

            if (flag) {
                System.out.println("******* Inserted the course for the Course id :" + courseVO.getId());
                flag = false;
            }

            courseName = learnCassandraDAO.getCourseName(courseVO);

            printCourse(courseName,courseVO);

            courseVO.setAuthor("Samuel Jackson");
            courseVO.setId("Node-JS-Started");
            courseVO.setModuleId(1);

            flag = learnCassandraDAO.updateCourseAuthor(courseVO);

            if(flag){
                System.out.println("Successfully Updated the author name to : "+ courseVO.getAuthor());
                flag=false;

                String authorName = learnCassandraDAO.getAuthorName(courseVO);

                printCourse(authorName,courseVO);
            }

            flag = learnCassandraDAO.deleteCourse(courseVO);

            if(flag)
                System.out.println("Deleted Course is : "+courseVO.getId());



            System.exit(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

	/**
	 * This method is to build the courseVO.
	 * @param courseVO
	 * @return
     */
	public CourseVO buildCourseVO(CourseVO courseVO) {

        courseVO=new CourseVO();
		courseVO.setId("Node-JS-Started");
		courseVO.setCourseName("NodeJS");
		courseVO.setAuthor("Benny Jonhson");
		courseVO.setAudience(1);
		courseVO.setDuration(1033);
		courseVO.setCc(Boolean.TRUE);
		courseVO.setReleaseDate(new Date());
		courseVO.setModuleId(1);
		courseVO.setModuleName("Why Node Js.");
		courseVO.setModuleDuration(23);

		return  courseVO;

	}

	public static void printCourse(String input, CourseVO courseVO){

		if (StringUtils.isEmpty(input))
			System.out.println("******* No courses available for the provided Course id : " + courseVO.getId());
		else
			System.out.println("Selected value from DB is : "+ input);

	}

}
