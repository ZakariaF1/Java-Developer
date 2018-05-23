/* package Annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                        // Pentru ( Getter , Setter )
@NoArgsConstructor           // Pentru a crea un constructor fara argumente ( prioritati sau parametri )
@AllArgsConstructor          // Pentru a crea un constructor cu toate argumentele create ( prioritati sau parametri )
public class Annotation_Child extends Annotation {        // Arata cu o linie pentru ca e clasa outdated

    private String name;
    private String lastname;
    private int weight;
    private int height;

    @Override
    @Repeat(spuneDinNou = 20)        // Impementam adnotarea creata de noi
    public void speak() {       // Arata cu o linie pentru ca e o clasa outdated si asa este si metoda
        System.out.println("Quack");
    }

    /* public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getLastname() {
        return lastname;
    }

    public void setLastname(int lastname) {
        this.lastname = lastname;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}  */
