package com.baidu.mobads.sdk.internal;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public class cn {

    /* renamed from: a */
    private static volatile cn f5742a;

    /* renamed from: b */
    private boolean f5743b;

    /* renamed from: c */
    private boolean f5744c;

    private cn() {
    }

    public static cn a() {
        if (f5742a == null) {
            synchronized (cn.class) {
                if (f5742a == null) {
                    f5742a = new cn();
                }
            }
        }
        return f5742a;
    }

    public boolean b() {
        return this.f5744c;
    }

    public String c(String str) {
        return (this.f5743b && a(str).booleanValue()) ? str.replaceFirst("(?i)http", b.b.a.b.b.f4198a) : str;
    }

    public Boolean d(String str) {
        return Boolean.valueOf(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    public String e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public String f(String str) {
        if (str == null) {
            return null;
        }
        return (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public String g(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public void h(String str) {
        new am(str).b();
    }

    public void b(boolean z) {
        this.f5743b = z;
    }

    public Boolean b(String str) {
        return a(str, "https:");
    }

    public void a(boolean z) {
        this.f5744c = z;
    }

    public Boolean a(String str) {
        return a(str, "http:");
    }

    private Boolean a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public HttpURLConnection a(URL url) {
        if (url.getProtocol().toLowerCase().equals(b.b.a.b.b.f4198a)) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                } catch (Exception e2) {
                    bq.a().c(e2);
                }
            }
            return sb.toString().substring(0, r3.length() - 1);
        }
        return sb.toString();
    }

    public void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }
}
