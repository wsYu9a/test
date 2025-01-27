package z8;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import p3.i;

/* loaded from: classes3.dex */
public abstract class e implements Handler.Callback {

    public static class a extends AsyncTask<String, Integer, String> {
        public /* synthetic */ a(d dVar) {
            this();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            String str = "";
            for (int i10 = 0; i10 < 1; i10++) {
                try {
                    URLConnection openConnection = new URL(strArr[0]).openConnection();
                    openConnection.setReadTimeout(10000);
                    openConnection.setConnectTimeout(10000);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return sb2.toString();
                        }
                        sb2.append(readLine);
                    }
                } catch (Exception e10) {
                    str = e10.toString();
                }
            }
            return "Error:" + str;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            Bundle bundle = new Bundle();
            Message message = new Message();
            if (str == null || str.startsWith("Error:")) {
                message.what = 0;
                if (str == null || !str.startsWith("Error:")) {
                    bundle.putString("error", "Unknown Error");
                } else {
                    bundle.putString("error", str.substring(6));
                }
            } else {
                message.what = 1;
                bundle.putString(i.f29758c, str);
            }
            message.setData(bundle);
        }

        public a() {
        }
    }

    public interface b {
        void a(int i10, int i11);

        void b(int i10);

        void c(x8.c cVar);

        void onCancel();

        void onStart();
    }

    public static String b(String str, Hashtable<String, String> hashtable) throws Exception {
        String str2;
        if (hashtable == null) {
            hashtable = new Hashtable<>();
        }
        Enumeration<String> keys = hashtable.keys();
        if (hashtable.size() != 0) {
            str = str + "?";
        }
        StringBuilder sb2 = new StringBuilder(str);
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            try {
                str2 = URLEncoder.encode(hashtable.get(nextElement), "UTF-8");
            } catch (Exception unused) {
                str2 = "";
            }
            sb2.append(nextElement);
            sb2.append("=");
            sb2.append(str2);
            sb2.append("&");
        }
        String sb3 = sb2.toString();
        if (hashtable.size() != 0) {
            sb3 = sb3.substring(0, sb3.length() - 1);
        }
        URLConnection openConnection = new URL(sb3).openConnection();
        openConnection.setReadTimeout(10000);
        openConnection.setConnectTimeout(10000);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
        StringBuilder sb4 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb4.toString();
            }
            sb4.append(readLine);
        }
    }

    public static y8.c c(String str, String str2, b bVar) {
        y8.c cVar = new y8.c(str2, bVar);
        cVar.execute(str);
        return cVar;
    }

    public void a(String str, Hashtable<String, String> hashtable) {
        String str2;
        if (hashtable == null) {
            hashtable = new Hashtable<>();
        }
        Enumeration<String> keys = hashtable.keys();
        StringBuilder sb2 = new StringBuilder(str);
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            try {
                str2 = URLEncoder.encode(hashtable.get(nextElement), "UTF-8");
            } catch (Exception unused) {
                str2 = "";
            }
            sb2.append(nextElement);
            sb2.append("=");
            sb2.append(str2);
            sb2.append("&");
        }
        String sb3 = sb2.toString();
        if (hashtable.size() > 0) {
            sb3 = sb3.substring(0, sb3.length() - 1);
        }
        new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, sb3);
    }
}
