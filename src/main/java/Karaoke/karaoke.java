/* package Karaoke;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class karaoke {

    static ArrayList<Song> songs = new ArrayList<Song>();


    public static void main(String[] args) {

        karaoke music = new karaoke();
        karaoke.run();
    }

    public static void run() {
        File file = new File("src/main/java/Karaoke/Songs.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) !=null) {      // Instantiam ( line ) in while pentru prevenirea buclei infinite
                addSong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(songs);

        System.out.println(songs);
    }

    private static void addSong(String line) {
        String[] parts = line.split("/");      // Cream un Array de Stringuri care ( / ) desparta intre ele
        //songs.add(parts[0]);                       // Adaugam prima parte adica Stringul de
        songs.add(new Song(parts[0], parts[1]));
    }
} */
