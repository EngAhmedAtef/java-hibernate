package hibernate.entities;

import hibernate.dtos.InstructorDetailsDTO;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {
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
    private Instructor instructor;

    public InstructorDetails() {}

    public InstructorDetails(InstructorDetailsDTO dto) {
        id = dto.getId();
        youtubeChannel = dto.getYoutubeChannel();
        hobbies = dto.getHobbies();
        instructor = dto.getInstructor();
    }

    public UUID getId() {  return id; }
    public String getYoutubeChannel() { return youtubeChannel; }
    public String[] getHobbies() { return hobbies; }
    public Instructor getInstructor() { return instructor; }

    public void setId(UUID id) { this.id = id; }
    public void setHobbies(String[] hobbies) { this.hobbies = hobbies; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public void setYoutubeChannel(String youtubeChannel) { this.youtubeChannel = youtubeChannel; }
}