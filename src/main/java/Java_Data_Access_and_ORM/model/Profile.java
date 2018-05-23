package Java_Data_Access_and_ORM.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="hero_profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)                                // Pentru a spune bazei de date ca ( Gender ) e de tip String sau el nu il va putea mapa ( pentru ca este un obiect )
    private Gender gender;
    private Date birth;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "profile")     // ( MappedBy ) este pentru a spune programului ca relatia intre ( Hero si Profile ) e ( Bidirectionala )
    private Hero owner;

    private Profile() {
    }

    public Profile(String phoneNumber, Gender gender, Date birth) {
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}
