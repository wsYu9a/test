package com.martian.libcomm.utils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import b.d.c.c.h;
import com.martian.libsupport.l;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public abstract class e implements Handler.Callback {

    private static class b extends AsyncTask<String, Integer, String> {
        private b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... params) {
            String str = "";
            for (int i2 = 0; i2 < 1; i2++) {
                try {
                    URLConnection openConnection = new URL(params[0]).openConnection();
                    openConnection.setReadTimeout(10000);
                    openConnection.setConnectTimeout(10000);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return sb.toString();
                        }
                        sb.append(readLine);
                    }
                } catch (Exception e2) {
                    str = e2.toString();
                }
            }
            return "Error:" + str;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String result) {
            Bundle bundle = new Bundle();
            Message message = new Message();
            if (result == null || result.startsWith("Error:")) {
                message.what = 0;
                if (result == null || !result.startsWith("Error:")) {
                    bundle.putString("error", "Unknown Error");
                } else {
                    bundle.putString("error", result.substring(6));
                }
            } else {
                message.what = 1;
                bundle.putString("result", result);
            }
            message.setData(bundle);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public interface c {
        void a(b.d.c.b.c errorResult);

        void b(int soFarBytes, int totalBytes);

        void c(int totalBytes);

        void onCancel();

        void onStart();
    }

    public static String b(String urls, Hashtable<String, String> paraments) throws Exception {
        String str;
        if (paraments == null) {
            paraments = new Hashtable<>();
        }
        Enumeration<String> keys = paraments.keys();
        if (paraments.size() != 0) {
            urls = urls + "?";
        }
        StringBuilder sb = new StringBuilder(urls);
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            try {
                str = URLEncoder.encode(paraments.get(nextElement), "UTF-8");
            } catch (Exception unused) {
                str = "";
            }
            sb.append(nextElement);
            sb.append("=");
            sb.append(str);
            sb.append("&");
        }
        String sb2 = sb.toString();
        if (paraments.size() != 0) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        URLConnection openConnection = new URL(sb2).openConnection();
        openConnection.setReadTimeout(10000);
        openConnection.setConnectTimeout(10000);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
        StringBuilder sb3 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb3.append(readLine);
        }
        String sb4 = sb3.toString();
        return l.K() ? d.b(sb4) : sb4;
    }

    public static void c(String url, String filepath, c listener) {
        new h(filepath, listener).execute(url);
    }

    public void a(String urls, Hashtable<String, String> parameters) {
        String str;
        if (parameters == null) {
            parameters = new Hashtable<>();
        }
        Enumeration<String> keys = parameters.keys();
        StringBuilder sb = new StringBuilder(urls);
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            try {
                str = URLEncoder.encode(parameters.get(nextElement), "UTF-8");
            } catch (Exception unused) {
                str = "";
            }
            sb.append(nextElement);
            sb.append("=");
            sb.append(str);
            sb.append("&");
        }
        String sb2 = sb.toString();
        if (parameters.size() > 0) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, sb2);
    }
}
