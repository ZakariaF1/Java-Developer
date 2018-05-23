package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)                // Locul unde specificam elementul Adnotarii
@Retention(RetentionPolicy.RUNTIME)        // Locul unde specificam munca adnotari
public @interface Repeat {                 // Cream o adnotare ( Custom )

    int spuneDinNou();

}
