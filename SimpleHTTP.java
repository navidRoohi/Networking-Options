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

           // Another example for networking
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
            //{"translations":[{"arabic":" الكتاب"},{"chinese":" 本书"},{"danish":" bogen"},{"dutch":" boek"},{"french":" livre"},{"german":" Buch"},{"italian":" libro"},{"portuguese":" livro"},{"russian":" книга"},{"spanish":" libro"}]}
            jsonArray = new JSONArray ( jsonObjectMain.optString("translations"));
            // [{"arabic":" الكتاب"},{"chinese":" 本书"},{"danish":" bogen"},{"dutch":" boek"},{"french":" livre"},{"german":" Buch"},{"italian":" libro"},{"portuguese":" livro"},{"russian":" книга"},{"spanish":" libro"}]
            jsonObject = jsonArray.getJSONObject(1);                         // {"chinese":" 本书"}
            chineseTranslation  = jsonObject.optString("chinese");          //  本书

            System.out.println( jsonObjectMain );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
