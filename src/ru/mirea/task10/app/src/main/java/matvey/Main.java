package matvey;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Magican m1 = context.getBean(HarryPotter.class);
        Magican m2 = context.getBean(RonWeesly.class);
        Magican m3 = context.getBean(Voldemort.class);

        m1.doMagic();
        m2.doMagic();
        m3.doMagic();
    }
}
