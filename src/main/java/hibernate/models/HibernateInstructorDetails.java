package hibernate.models;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "instructor_details")
public class HibernateInstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobbies")
    private String[] hobbies;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private HibernateInstructor instructor;

    public HibernateInstructorDetails() {}
    public HibernateInstructorDetails(UUID id, String youtubeChannel, String[] hobbies, HibernateInstructor instructor) {
        this.id = id;
        this.youtubeChannel = youtubeChannel;
        this.hobbies = hobbies;
        this.instructor = instructor;
    }

    public void setYoutubeChannel(String youtubeChannel) { this.youtubeChannel = youtubeChannel; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HibernateInstructorDetails{");
        stringBuilder.append("id=").append(id)
                .append(", youtubeChannel='")
                .append(youtubeChannel)
                .append(", hobbies=")
                .append(Arrays.toString(hobbies));
//        if (instructor != null)
//            stringBuilder.append(", instructor=").append(instructor);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
