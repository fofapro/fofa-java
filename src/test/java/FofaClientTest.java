import com.r4v3zn.fofa.core.client.FofaClient;

/**
 * Title: FofaClientTest
 * Descrption: TODO
 * Date:2019-06-08 13:38
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class FofaClientTest {
    public static void main(String[] args) throws Exception {
        String email = "xxx";
        // FOFA Pro key
        String key = "xxx";
        String q = "app=\"Solr\"";
        FofaClient client = new FofaClient(email, key);
        System.out.println(client.getData(q));
    }
}