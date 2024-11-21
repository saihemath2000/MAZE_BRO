package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door extends SuperObject {
    public OBJ_Door() {
        name="Door";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../Objects/door.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        collision=true;
    }
}
