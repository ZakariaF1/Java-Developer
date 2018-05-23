package Java_Data_Access_and_ORM.application.JavaDataAccessAndORM_2;

import Java_Data_Access_and_ORM.model.Hero;

import java.io.*;

public class SerializationPersistenceApplication {                  // Este recomandat se le numim asa

    public static void main(String[] args) {

        save();
        load();
    }

    private static void save() {                    // Metoda pentru a salva datele facute sa nu se piarda

        Hero batman = new Hero("Batman", 100, 100);
        Hero chuck = new Hero("Chuck Norris", 999, 999);
        Hero xena = new Hero("Xena", 500, 500);

        try {
            FileOutputStream writer = new FileOutputStream("heroes.bin");
            ObjectOutputStream ob = new ObjectOutputStream(writer);
            ob.writeObject(batman);
            ob.writeObject(chuck);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  static  void  load()  {                 // Metoda pentru a incarca datele salvate

        try {
            FileInputStream reader = new FileInputStream("heroes.bin");
            ObjectInputStream ob = new ObjectInputStream(reader);           // Punem Stream-ul adus in ( ObjectInputStream )
            Hero hero = (Hero) ob.readObject();         // Facem ( Casting ) la obiectul adus in ( Hero )
            System.out.println(hero);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
