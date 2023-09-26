package hibernate.dtos;

import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;

import java.util.Arrays;
import java.util.UUID;

public class InstructorDetailsDTO {
    private UUID id;
    private String youtubeChannel;
    private String[] hobbies;
    private Instructor instructor;

    public InstructorDetailsDTO(UUID id, String youtubeChannel, String[] hobbies, Instructor instructor) {
        this.id = id;
        this.youtubeChannel = youtubeChannel;
        this.hobbies = hobbies;
        this.instructor = instructor;
    }

    public InstructorDetailsDTO(InstructorDetails instructorDetails) {
        id = instructorDetails.getId();
        youtubeChannel = instructorDetails.getYoutubeChannel();
        hobbies = instructorDetails.getHobbies();
        instructor = instructorDetails.getInstructor();
    }

    public UUID getId() {  return id; }
    public String getYoutubeChannel() { return youtubeChannel; }
    public String[] getHobbies() { return hobbies; }
    public Instructor getInstructor() { return instructor; }

    public void setId(UUID id) { this.id = id; }
    public void setHobbies(String[] hobbies) { this.hobbies = hobbies; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
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
