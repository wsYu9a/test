package a;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: classes.dex */
public class a {
    private List<BasicNameValuePair> b(String str, String str2, String str3, boolean z) {
        if (str2 == null) {
            return null;
        }
        try {
            String o = z ? com.alipay.mobilesecuritysdk.c.a.o(str2) : Base64.encodeToString(str2.getBytes(), 8);
            if (com.alipay.mobilesecuritysdk.c.a.i(o)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            if (!com.alipay.mobilesecuritysdk.c.a.i(str)) {
                arrayList.add(new BasicNameValuePair("serviceId", str));
                sb.append("serviceId=");
                sb.append(str);
                sb.append("&");
            }
            if (!com.alipay.mobilesecuritysdk.c.a.i(str3)) {
                arrayList.add(new BasicNameValuePair("version", str3));
                sb.append("version=");
                sb.append(str3);
                sb.append("&");
            }
            arrayList.add(new BasicNameValuePair(MiConfigSingleton.t0, o));
            sb.append("data=");
            sb.append(o);
            sb.append(com.alipay.mobilesecuritysdk.constant.a.M);
            arrayList.add(new BasicNameValuePair("sign", com.alipay.mobilesecuritysdk.c.a.d(sb.toString())));
            Log.i(com.alipay.mobilesecuritysdk.constant.a.t, String.valueOf(sb.toString()) + arrayList.toString());
            return arrayList;
        } catch (Exception e2) {
            Log.i(com.alipay.mobilesecuritysdk.constant.a.t, e2.getMessage());
            return null;
        }
    }

    public HttpClient a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 5000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 5000);
        return new DefaultHttpClient(basicHttpParams);
    }

    public HttpResponse c(Context context, String str, String str2, String str3, String str4, boolean z) {
        if (str3 == null) {
            return null;
        }
        try {
            HttpPost httpPost = new HttpPost(str);
            List<BasicNameValuePair> b2 = b(str2, str3, str4, z);
            if (b2 == null) {
                return null;
            }
            httpPost.setEntity(new UrlEncodedFormEntity(b2, "UTF-8"));
            return a().execute(httpPost);
        } catch (Exception e2) {
            Log.i(com.alipay.mobilesecuritysdk.constant.a.t, e2.getMessage());
            return null;
        }
    }
}
