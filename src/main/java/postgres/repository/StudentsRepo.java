package postgres.repository;

import postgres.models.DatabaseModel;
import postgres.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsRepo extends CRUDRepository {

    public StudentsRepo() {
        super("students");
    }

    @Override
    public int insertAll(Connection dbConnection) throws SQLException {
        PreparedStatement insertQuery = buildInsertQuery(
                dbConnection,
                "first_name, last_name, age, gender, email, phone_number, national_id",
                new String[] {
                        "'John', 'Doe', 20, 'Male', 'john.doe@example.com', '+1 123-456-7890', 'US1234567890'",
                        "'Jane', 'Smith', 19, 'Female', 'jane.smith@example.com', '+1 987-654-3210', 'US0987654321'",
                        "'Alice', 'Johnson', 21, 'Female', 'alice.johnson@example.com', '+1 555-123-4567', 'US5551234567'",
                        "'Bob', 'Williams', 22, 'Male', 'bob.williams@example.com', '+1 777-888-9999', 'US7778889999'",
                        "'Eva', 'Brown', 18, 'Female', 'eva.brown@example.com', '+1 111-222-3333', 'US1112223333'",
                        "'Michael', 'Lee', 23, 'Male', 'michael.lee@example.com', '+1 222-333-4444', 'US2223334444'",
                        "'Sophia', 'Garcia', 20, 'Female', 'sophia.garcia@example.com', '+1 333-444-5555', 'US3334445555'",
                        "'William', 'Smith', 21, 'Male', 'william.smith@example.com', '+1 444-555-6666', 'US4445556666'",
                        "'Olivia', 'Martinez', 19, 'Female', 'olivia.martinez@example.com', '+1 555-666-7777', 'US5556667777'",
                        "'James', 'Johnson', 22, 'Male', 'james.johnson@example.com', '+1 666-777-8888', 'US6667778888'",
                        "'Sophia', 'Lee', 20, 'Female', 'sophia.lee@example.com', '+1 777-888-9999', 'US7778889999'",
                        "'Benjamin', 'Gonzalez', 24, 'Male', 'benjamin.gonzalez@example.com', '+1 888-999-0000', 'US8889990000'",
                        "'Emily', 'Taylor', 21, 'Female', 'emily.taylor@example.com', '+1 999-000-1111', 'US9990001111'",
                        "'Liam', 'Hernandez', 19, 'Male', 'liam.hernandez@example.com', '+1 000-111-2222', 'US0001112222'",
                        "'Ava', 'Lopez', 22, 'Female', 'ava.lopez@example.com', '+1 111-222-3333', 'US1112223333'",
                        "'Noah', 'Perez', 20, 'Male', 'noah.perez@example.com', '+1 222-333-4444', 'US2223334444'",
                        "'Isabella', 'Gonzalez', 21, 'Female', 'isabella.gonzalez@example.com', '+1 333-444-5555', 'US3334445555'",
                        "'Oliver', 'Rodriguez', 23, 'Male', 'oliver.rodriguez@example.com', '+1 444-555-6666', 'US4445556666'",
                        "'Mia', 'Brown', 20, 'Female', 'mia.brown@example.com', '+1 555-666-7777', 'US5556667777'",
                        "'Ethan', 'Williams', 24, 'Male', 'ethan.williams@example.com', '+1 666-777-8888', 'US6667778888'",
                        "'Charlotte', 'Harris', 19, 'Female', 'charlotte.harris@example.com', '+1 777-888-9999', 'US7778889999'",
                        "'Liam', 'Davis', 25, 'Male', 'liam.davis@example.com', '+1 888-999-0000', 'US8889990000'",
                        "'Amelia', 'Smith', 20, 'Female', 'amelia.smith@example.com', '+1 999-000-1111', 'US9990001111'",
                        "'Lucas', 'Jackson', 19, 'Male', 'lucas.jackson@example.com', '+1 000-111-2222', 'US0001112222'",
                        "'Harper', 'Anderson', 21, 'Female', 'harper.anderson@example.com', '+1 111-222-3333', 'US1112223333'",
                        "'Henry', 'Lopez', 20, 'Male', 'henry.lopez@example.com', '+1 222-333-4444', 'US2223334444'",
                        "'Ava', 'Hernandez', 22, 'Female', 'ava.hernandez@example.com', '+1 333-444-5555', 'US3334445555'",
                        "'Benjamin', 'Garcia', 24, 'Male', 'benjamin.garcia@example.com', '+1 444-555-6666', 'US4445556666'",
                        "'Sophia', 'Perez', 19, 'Female', 'sophia.perez@example.com', '+1 555-666-7777', 'US5556667777'",
                        "'Oliver', 'Smith', 23, 'Male', 'oliver.smith@example.com', '+1 666-777-8888', 'US6667778888'",
                        "'Emma', 'Martinez', 20, 'Female', 'emma.martinez@example.com', '+1 777-888-9999', 'US7778889999'",
                        "'Liam', 'Gonzalez', 24, 'Male', 'liam.gonzalez@example.com', '+1 888-999-0000', 'US8889990000'",
                        "'Olivia', 'Davis', 19, 'Female', 'olivia.davis@example.com', '+1 999-000-1111', 'US9990001111'",
                        "'Lucas', 'Jones', 22, 'Male', 'lucas.jones@example.com', '+1 000-111-2222', 'US0001112222'",
                        "'Charlotte', 'Taylor', 20, 'Female', 'charlotte.taylor@example.com', '+1 111-222-3333', 'US1112223333'",
                        "'Noah', 'Brown', 24, 'Male', 'noah.brown@example.com', '+1 222-333-4444', 'US2223334444'",
                        "'Amelia', 'Williams', 19, 'Female', 'amelia.williams@example.com', '+1 333-444-5555', 'US3334445555'",
                        "'Harper', 'Smith', 25, 'Male', 'harper.smith@example.com', '+1 444-555-6666', 'US4445556666'",
                        "'Henry', 'Gonzalez', 20, 'Female', 'henry.gonzalez@example.com', '+1 555-666-7777', 'US5556667777'",
                        "'Mia', 'Hernandez', 22, 'Male', 'mia.hernandez@example.com', '+1 666-777-8888', 'US6667778888'",
                        "'Liam', 'Smith', 20, 'Female', 'liam.smith@example.com', '+1 777-888-9999', 'US7778889999'",
                        "'Emily', 'Lopez', 24, 'Male', 'emily.lopez@example.com', '+1 888-999-0000', 'US8889990000'",
                        "'Oliver', 'Garcia', 19, 'Female', 'oliver.garcia@example.com', '+1 999-000-1111', 'US9990001111'",
                        "'Ava', 'Perez', 23, 'Male', 'ava.perez@example.com', '+1 000-111-2222', 'US0001112222'",
                        "'Benjamin', 'Jackson', 20, 'Female', 'benjamin.jackson@example.com', '+1 111-222-3333', 'US1112223333'",
                        "'Lucas', 'Anderson', 21, 'Male', 'lucas.anderson@example.com', '+1 222-333-4444', 'US2223334444'",
                        "'Harper', 'Smith', 22, 'Female', 'harper.smith@example.com', '+1 333-444-5555', 'US3334445555'"
                });

        return insertQuery.executeUpdate();
    }

    @Override
    public int updateAll(Connection dbConnection) throws SQLException {
        PreparedStatement updateQuery = buildUpdateQuery(dbConnection, "email = 'ahmed.atef@gmail.com'", null);
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

        List<Student> students = new ArrayList<>();

        while (result.next())
            students.add(new Student(result));

        return students;
    }
}
