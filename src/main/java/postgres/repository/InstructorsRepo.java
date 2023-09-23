package postgres.repository;

import postgres.models.DatabaseModel;
import postgres.models.Instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorsRepo extends CRUDRepository {

    public InstructorsRepo() {
        super("instructor");
    }

    public int insertAll(Connection dbConnection) throws SQLException {
        PreparedStatement insertQuery = buildInsertQuery(
                dbConnection,
                "first_name, last_name, email, phone_number, title",
                new String[] {
                        "'Debbie', 'Lindell', 'dlindell0@topsy.com', '2504630425', 'Professor of Mathematics'",
                        "'Devy', 'Symondson', 'dsymondson1@nbcnews.com', '7685379821', 'English Literature Instructor'",
                        "'Bartel', 'McGruar', 'bmcgruar0@psu.edu', '5738460604', 'Chemistry Lecturer'",
                        "'Diahann', 'Van Cassel', 'dvancassel1@woothemes.com', '1512149080', 'Physics Educator'",
                        "'Mari', 'Keeling', 'mkeeling2@dmoz.org', '7985574518', 'History Professor'",
                        "'Gregorio', 'Sturdy', 'gsturdy3@ebay.co.uk', '2487276326', 'Computer Science Teacher'",
                        "'Tiler', 'Labes', 'tlabes4@artisteer.com', '1547317439', 'Art Studio Instructor'",
                        "'Sergio', 'Totterdell', 'stotterdell5@globo.com', '2583762800', 'Music Theory Tutor'",
                        "'Jacynth', 'Best', 'jbest6@shutterfly.com', '8186932290', 'Physical Education Coach'",
                        "'Gail', 'Hearnshaw', 'ghearnshaw7@paginegialle.it', '4238344547', 'Foreign Language Facilitator'",
                        "'Milka', 'Circuitt', 'mcircuitt8@acquirethisname.com', '2611137925', 'Drama and Theater Instructor'",
                        "'Alana', 'Ringe', 'aringe9@etsy.com', '6834323606', 'Environmental Science Educator'",
                        "'Shurwood', 'Blasik', 'sblasika@cnbc.com', '5908440682', 'Culinary Arts Trainer'",
                        "'Garv', 'Kerswill', 'gkerswillb@virginia.edu', '6502027783', 'Dance Studio Teacher'",
                        "'Frederick', 'Snodden', 'fsnoddenc@exblog.jp', '7862178719', 'Business Ethics Professor'",
                        "'Pansie', 'Lillegard', 'plillegardd@ucoz.com', '7387057664', 'Health and Wellness Educator'",
                        "'Alfreda', 'Tiesman', 'atiesmane@odnoklassniki.ru', '2548545848', 'Psychology Lecturer'",
                        "'Raquela', 'Radnedge', 'rradnedgef@tumblr.com', '6139591444', 'Engineering Workshop Facilitator'",
                        "'Solomon', 'Partener', 'spartenerg@digg.com', '2621289952', 'Graphic Design Instructor'",
                        "'Kaspar', 'Gilliam', 'kgilliamh@goo.gl', '2521052443', 'Early Childhood Education Specialist'"
                });

        return insertQuery.executeUpdate();
    }

    public int updateAll(Connection dbConnection) throws SQLException {
        PreparedStatement updateQuery = buildUpdateQuery(dbConnection, "email = 'ahmed@gmail.com'", null);
        return updateQuery.executeUpdate();
    }

    public int deleteAll(Connection dbConnection) throws SQLException {
        PreparedStatement deleteQuery = buildDeleteQuery(dbConnection, null);
        return deleteQuery.executeUpdate();
    }

    public List<? extends DatabaseModel> selectAll(Connection dbConnection) throws SQLException {
        PreparedStatement selectQuery = buildSelectQuery(dbConnection, new String[]{"*"}, null);
        ResultSet result = selectQuery.executeQuery();

        List<Instructor> instructors = new ArrayList<>();

        while (result.next())
            instructors.add(new Instructor(result));

        return instructors;
    }
}
