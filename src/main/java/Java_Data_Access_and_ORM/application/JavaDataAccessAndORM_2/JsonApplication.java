package Java_Data_Access_and_ORM.application.JavaDataAccessAndORM_2;

import Java_Data_Access_and_ORM.model.Hero;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonApplication {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();             // ( ObjectMapper ) este clasa care este in dependinta ( Jackson ) si are metoda de scriere a obiectelor in fisier

        Hero hero1 = new Hero("Alex", 100, 200);

        mapper.writeValue(new File("target/hero.json"), hero1);    // Pentru a insera ( hero1 ) intr-un fisier

        String json = "{\"name\":\"Alex\",\"life\":100,\"mana\":2000}";

        Hero hero2 = mapper.readValue(json, Hero.class);       // Pentru a citi ( json )
        Hero hero3 = mapper.readValue(new File("target/hero.json"), Hero.class);   // Pentru a citi din fisierul creat

        System.out.println(hero3);
    }
}
