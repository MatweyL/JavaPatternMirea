package matvey;

import org.springframework.stereotype.Component;

@Component
public class RonWeesly implements Magican {
    RonWeesly() {
    }

    @Override
    public void doMagic() {
        System.out.println("It's a Ron Weesly!");
    }
}
