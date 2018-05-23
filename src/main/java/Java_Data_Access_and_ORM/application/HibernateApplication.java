package Java_Data_Access_and_ORM.application;

import Java_Data_Access_and_ORM.model.Gender;
import Java_Data_Access_and_ORM.model.Hero;
import Java_Data_Access_and_ORM.model.Profile;
import Java_Data_Access_and_ORM.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@SpringBootConfiguration                // Pentru a putea crea ( application.properties )
@EnableAutoConfiguration                // Pentru a activa ( application.properties )
@EnableJpaRepositories("Java_Data_Access_and_ORM")        // Pentru a localiza folder-ul ( repository )
@EntityScan("Java_Data_Access_and_ORM.model")             // Pentru a localiza entitatea
public class HibernateApplication implements CommandLineRunner {        // Implementeaza o linie de comanda care este ( run )

    private HeroRepository heroRepository;

    @Autowired          // Pentru a lega obiectele cu constructorul sau prioritatea ( heroRepository dar nu e recomandata pentru ca foloseste Reflexia si e lenta )
    public HibernateApplication(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    @Transactional        // Pentru a se lua toate comenzile din comanda ca o unitate si daca una n-a mers nu o sa mearga deloc toata tranzactia
    public void run(String... strings) throws Exception {
      save();

//      List<Hero> heroes = heroRepository.findAll();                  // Pentru a afisa toti eroii

        /*List<Hero> heroes = heroRepository.findDeadHeroes();

        System.out.println(heroes);*/

/*     System.out.println(heroRepository.count());                    // Pentru a afisa numarul de date in Data de Baza

        for(Hero hero: heroes) {                                       // Pentru a afisa toti eroii

            System.out.println(hero);
        }

        //heroes.stream().forEach(System.out::println);        // ( :: ) este pentru referinta si ne afiseaza fiecare erou pe o linie

        //System.out.println(heroRepository.findOne(2L));

        System.out.println(heroRepository.findByName("Xena"));        // Metoda din ( HeroRepository )

        System.out.println(heroRepository.findByManaBetween(50,999)); */

//      showHeroes();
    }

    @Transactional
    protected void showHeroes() {
        List<Hero> heroes;

        heroes = heroRepository.findByName("Superman");

        // System.out.println(hero);

        heroes.stream()
                .forEach(System.out::println);

        // heroes
        // .stream()
        // .map(Hero::getClass)
        // .forEach(System.out::println);            // Pentru maparea eroilor

        /* List<String> names = heroes
                .stream()
                .map(Hero::getName)
                .collect(Collectors.toList());           // Pentru a mapa eroii si a le colecta intr-o lista de colecti
        System.out.println(names); */
    }

    @Transactional
    private void save() {            // Metoda de a salva obiectele( Entitatile ) in Baza de Date

        Profile supermanProfile = new Profile(               // Cream profil-ul lui superman
                "12345",
                Gender.MALE,
                new GregorianCalendar(1938, Calendar.FEBRUARY, 29).getTime());
        Profile batmanProfile = new Profile(
                "849210",
                Gender.MALE,
                new GregorianCalendar(1970, Calendar.MARCH, 20).getTime());
        Profile chuckProfile = new Profile(
                "5748437",
                Gender.MALE,
                new GregorianCalendar(1959, Calendar.APRIL, 05).getTime());
        Profile xenaProfile = new Profile(
                "101011992",
                Gender.FEMALE,
                new GregorianCalendar(1980, Calendar.NOVEMBER, 25).getTime());

        Hero superman = new Hero("Superman", 0, 2000, supermanProfile);
      Hero supermanClone = new Hero("SupermanClone", 0, 2000, supermanProfile);
        Hero batman = new Hero("Batman", 100, 100,batmanProfile);
        Hero chuck = new Hero("Chuck Norris", 999, 999,chuckProfile);
        Hero xena = new Hero("Xena", 500, 500,xenaProfile);

        heroRepository.save(chuck);
      heroRepository.save(supermanClone);
        heroRepository.save(batman);
        heroRepository.save(superman);
        heroRepository.save(xena);
    }

    public static void main(String[] args) {

        SpringApplication.run(HibernateApplication.class, args).close();    // Sintaxa ( run ) standard pentru executarea ( SpringApplication )
    }
}
