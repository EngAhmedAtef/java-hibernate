package postgres.models;


import enums.CourseLevel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Course implements DatabaseModel {
    private String uuid;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private CourseLevel courseLevel;
    private Boolean isStarted;
    private int instructorId;

    public Course(ResultSet result) throws SQLException {
        uuid = result.getString("id");
        name = result.getString("name");
        startDate = result.getTimestamp("start_date");
        endDate = result.getTimestamp("end_date");
        courseLevel = CourseLevel.valueOf(result.getString("course_level"));
        isStarted = result.getBoolean("is_started");
        instructorId = result.getInt("instructor_id");
    }

    @Override
    public String toString() {
        return "model.Course{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseLevel=" + courseLevel +
                ", isStarted=" + isStarted +
                ", instructorId=" + instructorId +
                '}';
    }
}
