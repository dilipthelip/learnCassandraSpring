package com.learncassandra.dao;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.learncassandra.domain.CourseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.ResultSet;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by z001qgd on 1/18/17.
 */
@Component
public class LearnCassandraDAO {

    private static Logger logger= LoggerFactory.getLogger(LearnCassandraDAO.class);

    @Autowired
    CassandraOperations cqlTemplate;


    public String getCourseName(CourseVO selectCourseVO) throws SQLException {


        Select select = QueryBuilder.select().from("COURSES").where(QueryBuilder.eq("ID", selectCourseVO.getId())).and(QueryBuilder.eq("MODULE_ID",selectCourseVO.getModuleId())).orderBy(QueryBuilder.asc("MODULE_ID"));

       ResultSet rs2 = cqlTemplate.query(select);
        List<Row> rowList = rs2.all();
        String name="";

        for (Row row : rowList) {
            name = row.getString("id");
            break;
        }

        return name;
    }

    /**
     * This method fetches you the author name of the course.
     * @param selectCourseVO
     * @return - String - author name
     * @throws SQLException
     */
    public String getAuthorName(CourseVO selectCourseVO) throws SQLException {


        Select select = QueryBuilder.select().from("COURSES").where(QueryBuilder.eq("ID", selectCourseVO.getId())).and(QueryBuilder.eq("MODULE_ID",selectCourseVO.getModuleId())).orderBy(QueryBuilder.asc("MODULE_ID"));

        ResultSet rs2 = cqlTemplate.query(select);
        List<Row> rowList = rs2.all();
        String name="";

        for (Row row : rowList) {
            name = row.getString("author");
            break;
        }

        return name;
    }

    /**
     * This method is to insert the data in to the courses table.
     * @return
     * @throws SQLException
     * @param courseVO
     */
    public Boolean insertCourseName(CourseVO courseVO) throws SQLException {
        Boolean result= false;

        try{

            String insertCourseSql =  "INSERT INTO learncassandra.COURSES (ID,NAME,AUTHOR,AUDIENCE,DURATION,CC,RELEASED,MODULE_ID,MODULE_NAME,MODULE_DURATION) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)";
            Statement insert2 = cqlTemplate.getSession().prepare(insertCourseSql).bind(courseVO.getId(),courseVO.getCourseName(),courseVO.getAuthor(),courseVO.getAudience(),courseVO.getDuration(),courseVO.isCc(),courseVO.getReleaseDate() ,courseVO.getModuleId(),courseVO.getCourseName(),courseVO.getModuleDuration());

            cqlTemplate.execute(insert2);

            return true;

        }catch (Exception e ){
            logger.error("Exception in insertCourseName : " + e);
            throw e;
        }


    }


    /**
     * This method is to update the course Author in the courses table.
     * @return
     * @throws SQLException
     */
    public Boolean updateCourseAuthor(CourseVO updateCourseVO) throws SQLException {

        Boolean result= false;

        try {
            String updateCourseSql = "update  learncassandra.courses set author =? where id =? and module_id =?";

            Statement updateStmt = cqlTemplate.getSession().prepare(updateCourseSql).bind(updateCourseVO.getAuthor(), updateCourseVO.getId(), updateCourseVO.getModuleId());

            cqlTemplate.execute(updateStmt);

            return true;

        }catch (Exception e){
            logger.error("Exception in updateCourseAuthor : " + e);
            throw e;
        }
    }

    /**
     * This method is to update the course Author in the courses table.
     * @return
     * @throws SQLException
     * @param deleteCourseVO
     */
    public Boolean deleteCourse(CourseVO deleteCourseVO) throws SQLException {


        Boolean result= false;

        try {
            String deleteCourseSql =  "DELETE FROM  learncassandra.courses where id =? and module_id =?";

            Statement deleteStmt = cqlTemplate.getSession().prepare(deleteCourseSql).bind(deleteCourseVO.getId(),deleteCourseVO.getModuleId());

            cqlTemplate.execute(deleteStmt);

            return true;

        }catch (Exception e){
            logger.error("Exception in deleteCourseAuthor : " + e);
            throw e;
        }

    }



}
