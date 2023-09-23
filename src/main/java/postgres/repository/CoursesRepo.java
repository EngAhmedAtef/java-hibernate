package postgres.repository;

import postgres.models.Course;
import postgres.models.DatabaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesRepo extends CRUDRepository {
    public CoursesRepo() {
        super("courses");
    }

    @Override
    public int insertAll(Connection dbConnection) throws SQLException {
        PreparedStatement insertQuery = buildInsertQuery(
                dbConnection,
                "name, start_date, end_date, course_level, is_started, instructor_id",
                new String[] {
                        "'Calculus I', '2023-09-15 08:00:00', '2023-12-15 10:00:00', 'Beginner', true, 1",
                        "'American Romanticism', '2023-10-01 09:30:00', '2023-12-01 11:30:00', 'Intermediate', true, 2",
                        "'General Chemistry', '2023-09-20 14:00:00', '2024-01-10 16:00:00', 'Beginner', true, 3",
                        "'Mechanics and Kinematics', '2023-09-25 08:30:00', '2023-12-15 11:00:00', 'Intermediate', true, 4",
                        "'World History: Ancient Civilizations', '2023-10-05 10:00:00', '2023-12-10 12:00:00', 'Beginner', true, 5",

                        "'Introduction to Programming', '2023-09-18 13:00:00', '2023-11-18 15:00:00', 'Beginner', true, 6",
                        "'Painting Techniques', '2023-09-22 14:30:00', '2023-12-15 16:30:00', 'Intermediate', true, 7",
                        "'Music Theory Fundamentals', '2023-09-28 16:00:00', '2023-11-28 18:00:00', 'Beginner', true, 8",
                        "'Fitness and Conditioning', '2023-09-16 07:30:00', '2023-11-16 09:30:00', 'Intermediate', true, 9",
                        "'Spanish Language and Culture', '2023-09-19 10:30:00', '2023-11-19 12:30:00', 'Beginner', true, 10",

                        "'Acting Techniques', '2023-09-21 15:15:00', '2023-12-21 17:15:00', 'Intermediate', true, 11",
                        "'Environmental Conservation', '2023-10-02 13:45:00', '2023-12-02 15:45:00', 'Intermediate', true, 12",
                        "'Culinary Fundamentals', '2023-09-26 09:45:00', '2023-11-26 11:45:00', 'Beginner', true, 13",
                        "'Ballet Technique', '2023-09-29 17:30:00', '2023-12-29 19:30:00', 'Intermediate', true, 14",
                        "'Introduction to Psychology', '2023-09-24 08:15:00', '2023-11-24 10:15:00', 'Beginner', true, 15",

                        "'Introduction to British Literature', '2023-10-04 11:30:00', '2023-12-04 13:30:00', 'Beginner', true, 16",
                        "'Data Structures and Algorithms', '2023-09-17 14:45:00', '2023-11-17 16:45:00', 'Intermediate', true, 17",
                        "'Food Safety and Sanitation', '2023-09-23 12:45:00', '2023-11-23 14:45:00', 'Beginner', true, 18",
                        "'Modern Dance Choreography', '2023-09-27 16:30:00', '2023-11-27 18:30:00', 'Intermediate', true, 19",
                        "'Ethical Decision-Making in Business', '2023-10-03 13:00:00', '2023-12-03 15:00:00', 'Advanced', false, 20"
                });

        return insertQuery.executeUpdate();
    }

    @Override
    public int updateAll(Connection dbConnection) throws SQLException {
        PreparedStatement updateQuery = buildUpdateQuery(dbConnection, "is_started = false", null);
        return updateQuery.executeUpdate();
    }

    @Override
    public int deleteAll(Connection dbConnection) throws SQLException {
        PreparedStatement deleteQuery = buildDeleteQuery(dbConnection, null);
        return deleteQuery.executeUpdate();
    }

    @Override
    public List<? extends DatabaseModel> selectAll(Connection dbConnection) throws SQLException {
        PreparedStatement selectQuery = buildSelectQuery(dbConnection, new String[] {"*"}, null);
        ResultSet result = selectQuery.executeQuery();

        List<Course> courses = new ArrayList<>();

        while (result.next())
            courses.add(new Course(result));

        return courses;
    }
}
