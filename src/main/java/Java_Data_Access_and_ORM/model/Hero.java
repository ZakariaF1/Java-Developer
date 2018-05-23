package Java_Data_Access_and_ORM.model;

import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.io.Serializable;

@Entity                       // Mapam ( Traducem ) Clasa in ( Entity ) pentru a putea persista in Baza de Date
@Table(name="Hero")           // Specifica ( Tabel-ul ) in care o se persiste clasa
public class Hero implements Serializable {          // Pentru a putea fi ( Serializabil )

    @Id              // Pentru a specifica aceest atribut ca ( ID )
    @GeneratedValue(strategy = GenerationType.IDENTITY)             // Spunem ca e o valoare care Baza de Date o va genera automatic
    private Long id;

    @Column(name = "name")               // Specifica ( coloana ) in care o se persiste atributu
    private String name;

    @Column(name = "life")
    private int life;

    @Column(name = "mana")
    private int mana;

    @OneToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)      // ( Lazy ) pentru a lua informatiile din baza de date( Profile in cazul asta ) numai cand avem nevoie de ele si optiunea ( Eager ) pentru a adauga toate informatiile disponibile din baza de date corespondent al obiectului
    @JoinColumn(name="profile_id")          // Specifica ( coloana ) in care o se persiste atributu SI care are ( cheia externa )
    private Java_Data_Access_and_ORM.model.Profile profile;

    @Override
    public String toString() {
        return name + ',' + life + ',' + mana;       // Pentru a transforma Obiectul in String
    }

    public Hero() {              // Constructor gol pentru a merge ( Spring Boot )
    }

    public Hero(String name, int life, int mana) {          // Constructor pentru ( JsonApplication )
        this.name = name;
        this.life = life;
        this.mana = mana;
    }

    public Hero(String name, int life, int mana, Java_Data_Access_and_ORM.model.Profile profile) {
        this.name = name;
        this.life = life;
        this.mana = mana;
        this.profile = profile;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getMana() {
        return mana;
    }

}
