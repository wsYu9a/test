package com.sigmob.sdk.downloader.core;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.StatFs;
import android.util.Log;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.downloader.core.breakpoint.h;
import com.sigmob.sdk.downloader.core.breakpoint.i;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.connection.b;
import com.sigmob.sdk.downloader.core.connection.c;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static final String f19078a = "HEAD";

    /* renamed from: b */
    public static final String f19079b = "Range";

    /* renamed from: c */
    public static final String f19080c = "If-Match";

    /* renamed from: d */
    public static final String f19081d = "User-Agent";

    /* renamed from: e */
    public static final String f19082e = "Content-Length";

    /* renamed from: f */
    public static final String f19083f = "Content-Range";

    /* renamed from: g */
    public static final String f19084g = "Etag";

    /* renamed from: h */
    public static final String f19085h = "Transfer-Encoding";

    /* renamed from: i */
    public static final String f19086i = "Accept-Ranges";

    /* renamed from: j */
    public static final String f19087j = "Content-Disposition";

    /* renamed from: k */
    public static final String f19088k = "chunked";

    /* renamed from: l */
    public static final int f19089l = -1;

    /* renamed from: m */
    public static final int f19090m = 416;

    /* renamed from: n */
    public static InterfaceC0583c f19091n = new b();

    public class a implements ThreadFactory {

        /* renamed from: a */
        public final /* synthetic */ String f19092a;

        /* renamed from: b */
        public final /* synthetic */ boolean f19093b;

        public a(String str, boolean z10) {
            this.f19092a = str;
            this.f19093b = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f19092a);
            thread.setDaemon(this.f19093b);
            return thread;
        }
    }

    public static class b implements InterfaceC0583c {
        @Override // com.sigmob.sdk.downloader.core.c.InterfaceC0583c
        public void a(String str, String str2) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.InterfaceC0583c
        public void b(String str, String str2) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.InterfaceC0583c
        public void c(String str, String str2) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.InterfaceC0583c
        public void a(String str, String str2, Exception exc) {
        }
    }

    /* renamed from: com.sigmob.sdk.downloader.core.c$c */
    public interface InterfaceC0583c {
        void a(String str, String str2);

        void a(String str, String str2, Exception exc);

        void b(String str, String str2);

        void c(String str, String str2);
    }

    public static void a(com.sigmob.sdk.downloader.core.connection.a aVar) {
    }

    public static void b(Map<String, List<String>> map, com.sigmob.sdk.downloader.core.connection.a aVar) throws IOException {
        a(map);
        a(map, aVar);
    }

    public static InterfaceC0583c c() {
        return f19091n;
    }

    public static boolean d(Uri uri) {
        return uri.getScheme().equals(k.f18193y);
    }

    public static boolean a(long j10, long j11) {
        return j10 == j11;
    }

    public static void b() {
        f19091n = null;
    }

    public static boolean c(Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static long d(String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e10) {
                c("Util", "parse content-length from content-range failed " + e10);
            }
        }
        return -1L;
    }

    public static void a(Map<String, List<String>> map, com.sigmob.sdk.downloader.core.connection.a aVar) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                aVar.a(key, it.next());
            }
        }
    }

    public static long b(Uri uri) {
        Cursor query = g.j().d().getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return 0L;
        }
        try {
            query.moveToFirst();
            return query.getLong(query.getColumnIndex("_size"));
        } finally {
            query.close();
        }
    }

    public static long c(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            a("Util", "parseContentLength failed parse for '" + str + "'");
            return -1L;
        }
    }

    public static void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j10, boolean z10) {
        int a10 = g.j().f().a(z10) ? g.j().f().a(fVar, j10) : 1;
        cVar.o();
        long j11 = a10;
        long j12 = j10 / j11;
        long j13 = 0;
        int i10 = 0;
        long j14 = 0;
        while (i10 < a10) {
            j13 += j14;
            j14 = i10 == 0 ? (j10 % j11) + j12 : j12;
            cVar.a(new com.sigmob.sdk.downloader.core.breakpoint.a(j13, j14));
            i10++;
        }
    }

    public static void b(String str, String str2) {
        InterfaceC0583c interfaceC0583c = f19091n;
        if (interfaceC0583c != null) {
            interfaceC0583c.a(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2) {
        InterfaceC0583c interfaceC0583c = f19091n;
        if (interfaceC0583c != null) {
            interfaceC0583c.b(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static boolean a(String str) {
        return g.j().d().checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean b(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            c("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static a.b a() {
        String name = b.a.class.getName();
        try {
            if (l.w().V()) {
                return (a.b) Class.forName(name).getDeclaredConstructor(null).newInstance(null);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return new c.b();
    }

    public static String b(String str) {
        byte[] bArr;
        try {
            bArr = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            if (i10 < 16) {
                sb2.append('0');
            }
            sb2.append(Integer.toHexString(i10));
        }
        return sb2.toString();
    }

    public static j a(Context context) {
        try {
            return (j) i.class.getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new h();
        }
    }

    public static j a(j jVar) {
        try {
            jVar = (j) jVar.getClass().getMethod("createRemitSelf", null).invoke(jVar, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        a("Util", "Get final download store is " + jVar);
        return jVar;
    }

    public static void a(String str, String str2) {
        InterfaceC0583c interfaceC0583c = f19091n;
        if (interfaceC0583c != null) {
            interfaceC0583c.c(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Exception exc) {
        InterfaceC0583c interfaceC0583c = f19091n;
        if (interfaceC0583c != null) {
            interfaceC0583c.a(str, str2, exc);
        } else {
            Log.e(str, str2, exc);
        }
    }

    public static String a(Uri uri) {
        Cursor query = g.j().d().getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            query.moveToFirst();
            return query.getString(query.getColumnIndex("_display_name"));
        } finally {
            query.close();
        }
    }

    public static long a(StatFs statFs) {
        return statFs.getAvailableBytes();
    }

    public static File a(File file) {
        File parentFile = file.getParentFile();
        return parentFile == null ? new File("/") : parentFile;
    }

    public static String a(long j10, boolean z10) {
        int i10 = z10 ? 1000 : 1024;
        if (j10 < i10) {
            return j10 + " B";
        }
        double d10 = j10;
        double d11 = i10;
        int log = (int) (Math.log(d10) / Math.log(d11));
        StringBuilder sb2 = new StringBuilder();
        sb2.append((z10 ? "kMGTPE" : "KMGTPE").charAt(log - 1));
        sb2.append(z10 ? "" : "i");
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d10 / Math.pow(d11, log)), sb2.toString());
    }

    public static void a(Map<String, List<String>> map) throws IOException {
        if (map.containsKey("If-Match") || map.containsKey("Range")) {
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            c("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void a(com.sigmob.sdk.downloader.core.breakpoint.a aVar) {
        if (aVar.c() >= 0 && aVar.c() <= aVar.b()) {
            return;
        }
        c("resetBlockIfDirty", "block is dirty so have to reset: " + aVar);
        aVar.g();
    }

    public static void a(InterfaceC0583c interfaceC0583c) {
        f19091n = interfaceC0583c;
    }

    public static ThreadFactory a(String str, boolean z10) {
        return new a(str, z10);
    }
}
