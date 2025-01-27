package y0;

import android.os.AsyncTask;
import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public String f32942a = null;

    /* renamed from: b */
    public a f32943b = null;

    /* renamed from: c */
    public Object f32944c = null;

    /* renamed from: d */
    public Map<String, String> f32945d = new HashMap();

    /* renamed from: e */
    public Map<String, String> f32946e = new HashMap();

    /* renamed from: f */
    public Map<String, String> f32947f = new HashMap();

    /* renamed from: g */
    public String f32948g = "GET";

    public interface a {
    }

    public class b {

        /* renamed from: a */
        public Exception f32949a;

        public b(String str, Exception exc, int i10) {
            this.f32949a = exc;
        }
    }

    /* renamed from: y0.c$c */
    public class AsyncTaskC0846c extends AsyncTask<Void, Void, b> {

        /* renamed from: a */
        public c f32950a;

        public AsyncTaskC0846c() {
            this.f32950a = c.this;
        }

        @Override // android.os.AsyncTask
        public final b doInBackground(Void[] voidArr) {
            return this.f32950a.f32948g.equalsIgnoreCase("GET") ? c.b(c.this) : c.d(c.this);
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(b bVar) {
            b bVar2 = bVar;
            super.onPostExecute(bVar2);
            if (c.this.f32943b != null && bVar2 == null) {
                new Exception("Unknown Error");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public static b b(c cVar) {
        cVar.getClass();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(cVar.a()).openConnection();
            if (httpURLConnection != null) {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(10000);
            }
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", y0.a.a());
            for (String str : cVar.f32945d.keySet()) {
                if (!str.isEmpty()) {
                    httpURLConnection.setRequestProperty(str, (String) cVar.f32945d.get(str));
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            PrintStream printStream = System.out;
            printStream.println("\nSending 'GET' request to URL : " + cVar.f32942a);
            printStream.println("Response Code : " + responseCode);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return new b(sb2.toString(), null, responseCode);
                }
                sb2.append(readLine);
            }
        } catch (Exception e10) {
            return new b(null, e10, -1);
        }
    }

    public static void c(@NonNull String str) {
        jh.c.a(c.class.getSimpleName(), str);
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public static b d(c cVar) {
        String obj;
        StringBuilder sb2;
        cVar.getClass();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(cVar.a()).openConnection();
            if (httpURLConnection != null) {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(10000);
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", y0.a.a());
            httpURLConnection.setRequestProperty(m5.c.f28319k, "en-US,en;q=0.5");
            StringBuilder sb3 = new StringBuilder("");
            if (cVar.f32946e.isEmpty()) {
                Object obj2 = cVar.f32944c;
                if (obj2 != null) {
                    if (!(obj2 instanceof JSONObject) && !(obj2 instanceof JSONArray)) {
                        if (obj2 instanceof String) {
                            obj = (String) obj2;
                            sb2 = sb3;
                            sb2.append(obj);
                        } else {
                            obj = null;
                            sb2 = null;
                            sb2.append(obj);
                        }
                    }
                    obj = obj2.toString();
                    sb2 = sb3;
                    sb2.append(obj);
                }
            } else {
                for (String str : cVar.f32946e.keySet()) {
                    sb3.append(str);
                    sb3.append("=");
                    sb3.append(URLEncoder.encode((String) cVar.f32946e.get(str), "UTF-8"));
                    sb3.append("&");
                }
            }
            for (String str2 : cVar.f32945d.keySet()) {
                if (!str2.isEmpty()) {
                    httpURLConnection.setRequestProperty(str2, (String) cVar.f32945d.get(str2));
                }
            }
            String sb4 = sb3.toString();
            httpURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(sb4);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    String sb6 = sb5.toString();
                    c("\nPOST RESPONSE : " + sb6);
                    return new b(sb6, null, responseCode);
                }
                sb5.append(readLine);
            }
        } catch (Exception e10) {
            return new b(null, e10, -1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public final String a() {
        String str = "?";
        if (this.f32942a == null) {
            throw new NullPointerException("URL IS NULL");
        }
        StringBuilder sb2 = new StringBuilder("");
        try {
            if (this.f32942a.trim().endsWith("?")) {
                str = "&";
            }
            sb2.append(str);
            for (String str2 : this.f32947f.keySet()) {
                if (!str2.isEmpty()) {
                    sb2.append(str2.trim());
                    sb2.append("=");
                    sb2.append(URLEncoder.encode((String) this.f32947f.get(str2), "UTF-8"));
                    sb2.append("&");
                }
            }
        } catch (Exception unused) {
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f32942a);
        sb3.append(sb2.toString().contains("&") ? sb2.substring(0, sb2.lastIndexOf("&")) : sb2.toString());
        return sb3.toString();
    }

    public final c e() {
        new AsyncTaskC0846c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }
}
