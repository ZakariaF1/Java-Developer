package Java_Data_Access_and_ORM.application.JavaDataAccessAndORM_2;

import Java_Data_Access_and_ORM.model.Hero;

import java.io.*;

public class FilePersistenceApplication {                  // Este recomandat se le numim asa

    public static void main(String[] args) {

        save();
        load();
    }

    private static void save() {                    // Metoda pentru a salva datele facute sa nu se piarda

        Hero batman = new Hero("Batman", 100, 100);
        Hero chuck = new Hero("Chuck Norris", 999, 999);
        Hero xena = new Hero("Xena", 500, 500);

        try {
            FileWriter writer = new FileWriter("heroes.txt");        // Cream un fisier.txt pentru al pune ca ( FileWriter )
            writer.write(batman.toString() + "\n");             // Pentru a scrie in ( heroes.txt ) String-ul rezultat
            writer.write(xena.toString() + "\n");
            writer.flush();                                   // Pentru sa se vada rezultatul in ( heroes.txt )
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  static  void  load()  {                 // Metoda pentru a incarca datele salvate

        try {
            BufferedReader reader = new BufferedReader(new FileReader("heroes.txt"));
            String[] parts = reader.readLine().split(",");     // Split ne returneaza ( Array de String ) si le despartim cu ( , )
            Hero hero = new Hero(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));    // Trebuie creat obiectul din nou dupa datele aduse si datele de tip ( int ) se creaza cu ( Integer.parseInt )
            System.out.println(hero);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
