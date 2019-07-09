import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

public class Main {

    public static void main(String[] args) {

        String ACCESS_TOKEN = "<ACCESS TOKEN>";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        MyThread myThread = new MyThread(client);
        myThread.run();

    }

}
