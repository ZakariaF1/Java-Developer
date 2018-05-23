package Java_Data_Access_and_ORM.repository;

import Java_Data_Access_and_ORM.model.Gender;
import Java_Data_Access_and_ORM.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository        // Este un fel de deposit pentru obiecte
public interface HeroRepository extends JpaRepository<Hero, Long> {

    List<Hero> findByName(String name);                 // ( findByName ) e metoda standard pentru a cauta un obiect dupa nume

    List<Hero> findByManaBetween (Integer min, Integer max);   // ( findByManaBetween ) e metoda standard pentru a cauta un obiect dupa Mana intr-un numar si altul

    List<Hero> findFirstByName(String name);

    List<Hero> findByNameContaining(String part);

    @Query("SELECT h FROM Hero h WHERE h.life = 0")      // JQL ( Java Query Language ) si inseamna ( SELECT obiectul h din clasa Hero care va fi numita h ca Alias WHERE viata obiectului = 0) care este un fel de SQL bazat pe obiecte
    List<Hero> findDeadHeroes();

    @Query("SELECT h FROM Hero h WHERE upper(h.name) = upper(:heroName)")       // @Param pentru a lega upper(:heroName) cu numele care il punem in parametru
    List<Hero> FindByNameCaseInsensitive(@Param("heroName") String name);

    @Query("SELECT h FROM Hero h WHERE h.profile.gender = 'FEMALE'")
    List<Hero> findAllGirls();

    @Query("SELECT h FROM Hero h WHERE upper(h.profile.gender) = upper(:gender)")
    List<Hero> FindByGender(@Param("gender") Gender gender);
}
