import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
/**
 * @author navidroohibroojeni
 */
 
    public static void main(String[] args){

        String sConvertedResponse = "";
        try {
            HttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
            
            HttpPost httpPost = new HttpPost("http://newjustin.com/translateit.php?action=translations&english_words=" + "book");
            
            httpPost.setHeader("Content-type", "application/json");
            
            HttpResponse response = httpClient.execute(httpPost);
            
            sConvertedResponse = EntityUtils.toString(response.getEntity());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(sConvertedResponse);
        // result:  {"translations": [{"arabic":" الكتاب"},{"chinese":" 本书"},{"danish":" bogen"},{"dutch":" boek"},{"french":" livre"},{"german":" Buch"},{"italian":" libro"},{"portuguese":" livro"},{"russian":" книга"},{"spanish":" libro"}]}{"translations": [{"arabic":" الكتاب"},{"chinese":" 本书"},{"danish":" bogen"},{"dutch":" boek"},{"french":" livre"},{"german":" Buch"},{"italian":" libro"},{"portuguese":" livro"},{"russian":" книга"},{"spanish":" libro"}]}

    }
}
