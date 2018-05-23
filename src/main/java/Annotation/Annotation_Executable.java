/* package Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotation_Executable {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Annotation_Child mic = new Annotation_Child("Alex","Madaceanu",60,165);   // Costructorul care la facut ( Adnotarea Lombok )
        mic.getHeight();

        //Class micClas = mic.getClass();
        try {
            Method method = Annotation_Child.class.getMethod("speak");     // Cream o metoda care este metoda clasei Annotation.Annotation_Child

            Repeat annotation = method.getAnnotation(Repeat.class);          // Cream o annotatie care este annotatia clasei Annotation.Repeat

            for(int i = 0; i < annotation.spuneDinNou(); i++ ) {
                method.invoke(mic);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
} */
