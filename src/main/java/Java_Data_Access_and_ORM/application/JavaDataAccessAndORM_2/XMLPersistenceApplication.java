package Java_Data_Access_and_ORM.application.JavaDataAccessAndORM_2;

import Java_Data_Access_and_ORM.model.Hero;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XMLPersistenceApplication {                  // Este recomandat se le numim asa

    private static String filename = "heroes.xml";

    public static void main(String[] args) {

        //save();
        load();
    }

    private static void save() {                    // Metoda pentru a salva datele facute sa nu se piarda

        Hero batman = new Hero("Batman", 100, 100);
        Hero chuck = new Hero("Chuck Norris", 999, 999);
        Hero xena = new Hero("Xena", 500, 500);

        try {
            FileOutputStream writer = new FileOutputStream(filename);
            XMLEncoder ob = new XMLEncoder(writer);
            ob.writeObject(batman);
            ob.writeObject(chuck);
            ob.close();                    // ( close() ) este un fel de ( flush() ) si pentru a inchide ( XML Encoder )

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  static  void  load()  {                 // Metoda pentru a incarca datele salvate

        try {
            FileInputStream reader = new FileInputStream(filename);
            XMLDecoder ob = new XMLDecoder(reader);
            Hero hero = (Hero) ob.readObject();         // Facem ( Casting ) la obiectul adus in ( Hero )
            System.out.println(hero);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
