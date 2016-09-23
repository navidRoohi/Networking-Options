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
        JSONObject jsonObjectMain = null;
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        String chineseTranslation;

        try {
            // Networking
            HttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
            HttpPost httpPost = new HttpPost("http://newjustin.com/translateit.php?action=translations&english_words=" + "book");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpPost);
            sConvertedResponse = EntityUtils.toString(response.getEntity());

            // read the JSON
            jsonObjectMain = new JSONObject(sConvertedResponse);
            jsonArray = new JSONArray ( jsonObjectMain.optString("translations"));
            jsonObject = jsonArray.getJSONObject(1);
            chineseTranslation  = jsonObject.optString("chinese");

            // desire result
            System.out.println( jsonObjectMain );
            //{"translations":[{"arabic":" الكتاب"},{"chinese":" 本书"},{"danish":" bogen"},{"dutch":" boek"},{"french":" livre"},{"german":" Buch"},{"italian":" libro"},{"portuguese":" livro"},{"russian":" книга"},{"spanish":" libro"}]}
            System.out.println( jsonArray );
            // [{"arabic":" الكتاب"},{"chinese":" 本书"},{"danish":" bogen"},{"dutch":" boek"},{"french":" livre"},{"german":" Buch"},{"italian":" libro"},{"portuguese":" livro"},{"russian":" книга"},{"spanish":" libro"}]
            System.out.println( jsonObject );
            // {"chinese":" 本书"}
            System.out.println( chineseTranslation );
            //  本书;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
