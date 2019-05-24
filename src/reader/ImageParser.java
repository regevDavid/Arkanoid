package reader;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Image;
import java.io.IOException;

/**
 * The class parses images from files.
 *
 * @author - David Regev.
 * @version - 9.6.2018.
 */
public class ImageParser {
    /**
     * The function converts a string to an image.
     *
     * @param path - the image as string.
     * @return - the image.
     */
    public static Image parseImage(String path) {
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Can't open Image");
        }
        return image;
    }
}
