package com.vivo.mobilead.lottie.d;

import android.content.Context;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.am;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.LottieCompositionFactory;
import com.vivo.mobilead.lottie.f.d;
import com.vivo.mobilead.lottie.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private final Context f29416a;

    /* renamed from: b */
    private final String f29417b;

    /* renamed from: c */
    private final b f29418c;

    private c(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f29416a = applicationContext;
        this.f29417b = str;
        this.f29418c = new b(applicationContext, str);
    }

    public static h<LottieComposition> a(Context context, String str) {
        return new c(context, str).a();
    }

    private String a(HttpURLConnection httpURLConnection) {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    private LottieComposition b() {
        Pair<a, InputStream> a2 = this.f29418c.a();
        if (a2 == null) {
            return null;
        }
        a aVar = (a) a2.first;
        InputStream inputStream = (InputStream) a2.second;
        h<LottieComposition> fromZipStreamSync = aVar == a.ZIP ? LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.f29417b) : LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.f29417b);
        if (fromZipStreamSync.a() != null) {
            return fromZipStreamSync.a();
        }
        return null;
    }

    private h<LottieComposition> b(HttpURLConnection httpURLConnection) {
        a aVar;
        h<LottieComposition> fromZipStreamSync;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = am.f5520d;
        }
        char c2 = 65535;
        int hashCode = contentType.hashCode();
        if (hashCode != -1248325150) {
            if (hashCode == -43840953 && contentType.equals(am.f5520d)) {
                c2 = 1;
            }
        } else if (contentType.equals("application/zip")) {
            c2 = 0;
        }
        if (c2 != 0) {
            d.a("Received json response.");
            aVar = a.JSON;
            fromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.f29418c.a(httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f29417b);
        } else {
            d.a("Handling zip response.");
            aVar = a.ZIP;
            fromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.f29418c.a(httpURLConnection.getInputStream(), aVar))), this.f29417b);
        }
        if (fromZipStreamSync.a() != null) {
            this.f29418c.a(aVar);
        }
        return fromZipStreamSync;
    }

    private h<LottieComposition> c() {
        try {
            return d();
        } catch (IOException e2) {
            return new h<>((Throwable) e2);
        }
    }

    private h d() {
        d.a("Fetching " + this.f29417b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f29417b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                h<LottieComposition> b2 = b(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(b2.a() != null);
                d.a(sb.toString());
                return b2;
            }
            return new h((Throwable) new IllegalArgumentException("Unable to fetch " + this.f29417b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + a(httpURLConnection)));
        } catch (Exception e2) {
            return new h((Throwable) e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public h<LottieComposition> a() {
        LottieComposition b2 = b();
        if (b2 != null) {
            return new h<>(b2);
        }
        d.a("Animation for " + this.f29417b + " not found in cache. Fetching from network.");
        return c();
    }
}
