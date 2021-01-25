package learn.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	
	//annotated the class as an entity and map to db table
	
	@Id //Annotate for pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") //name column table
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "hobby")
	private String hobby;

	//add new field for instrauctor (aslo add getter/setters)
	
	//add @OneToOne annotation
	
	@OneToOne(mappedBy = "instructorDetail" , cascade = CascadeType.ALL) 
	private Instructor instructor;
	
	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	
	public InstructorDetail() {}

}
