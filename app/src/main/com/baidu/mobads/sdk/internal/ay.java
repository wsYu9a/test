package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ay {

    /* renamed from: a */
    public static final String f6809a = "bqt_ad_tag";

    /* renamed from: b */
    static volatile a[] f6810b;

    /* renamed from: c */
    private static final a[] f6811c;

    /* renamed from: d */
    private static final Map<String, a> f6812d = new HashMap();

    /* renamed from: e */
    private static final a f6813e = new az();

    public static abstract class a {

        /* renamed from: a */
        private final ThreadLocal<String> f6814a = new ThreadLocal<>();

        private String g(Object[] objArr) {
            StringBuilder sb2 = new StringBuilder();
            for (Object obj : objArr) {
                sb2.append(obj);
                sb2.append(b5.a.O);
            }
            return sb2.toString();
        }

        @NonNull
        public abstract String a();

        public abstract void a(int i10, String str, String str2, Throwable th2);

        public boolean a(int i10) {
            return true;
        }

        public String b() {
            String str = this.f6814a.get();
            if (str != null) {
                this.f6814a.remove();
            }
            return str;
        }

        public void c(String str) {
            b(3, null, str);
        }

        public void d(String str) {
            b(4, null, str);
        }

        public void e(String str) {
            b(5, null, str);
        }

        public void f(String str) {
            b(6, null, str);
        }

        public void c(Object... objArr) {
            b(4, null, g(objArr));
        }

        public void d(Throwable th2, String str) {
            b(5, th2, str);
        }

        public void e(Object... objArr) {
            b(6, null, g(objArr));
        }

        public void f(Object... objArr) {
            b(7, null, g(objArr));
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                c("Empty/Null json content");
                return;
            }
            try {
                String trim = str.trim();
                if (trim.startsWith("{")) {
                    b(3, null, new JSONObject(trim).toString(2));
                } else if (trim.startsWith("[")) {
                    b(3, null, new JSONArray(trim).toString(2));
                } else {
                    f("Invalid Json");
                }
            } catch (Exception unused) {
                f("Invalid Json");
            }
        }

        public String b(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (!obj.getClass().isArray()) {
                return obj.toString();
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            return "Couldn't find a correct type for the object";
        }

        public void c(Throwable th2, String str) {
            b(4, th2, str);
        }

        public void d(Throwable th2) {
            b(5, th2, null);
        }

        public void e(Throwable th2, String str) {
            b(6, th2, str);
        }

        public void f(Throwable th2, String str) {
            b(7, th2, str);
        }

        public void c(Throwable th2) {
            b(4, th2, null);
        }

        public void d(Object... objArr) {
            b(5, null, g(objArr));
        }

        public void e(Throwable th2) {
            b(6, th2, null);
        }

        public void f(Throwable th2) {
            b(7, th2, null);
        }

        public void g(String str) {
            b(7, null, str);
        }

        private String g(Throwable th2) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th2.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        public void a(Object... objArr) {
            b(2, null, g(objArr));
        }

        public void a(Throwable th2, String str) {
            b(2, th2, str);
        }

        public void a(Throwable th2) {
            b(2, th2, null);
        }

        public void a(Object obj) {
            b(3, null, b(obj));
        }

        public void a(int i10, String str) {
            b(i10, null, str);
        }

        public void a(int i10, Object... objArr) {
            b(i10, null, g(objArr));
        }

        public void a(int i10, Throwable th2, String str) {
            b(i10, th2, str);
        }

        public void a(int i10, Throwable th2) {
            b(i10, th2, null);
        }

        public boolean a(String str, int i10) {
            return a(i10);
        }

        public String a(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public void b(String str) {
            b(2, null, str);
        }

        public void b(Throwable th2, String str) {
            b(3, th2, str);
        }

        public void b(Object... objArr) {
            b(3, null, g(objArr));
        }

        public void b(Throwable th2) {
            b(3, th2, null);
        }

        private void b(int i10, Throwable th2, String str) {
            String b10 = b();
            if (a(b10, i10)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str == null) {
                    if (th2 == null) {
                        return;
                    } else {
                        str = g(th2);
                    }
                } else if (th2 != null) {
                    str = str + "\n" + g(th2);
                }
                a(i10, b10, str, th2);
            }
        }
    }

    static {
        a[] aVarArr = new a[0];
        f6811c = aVarArr;
        f6810b = aVarArr;
    }

    public static void a(boolean z10) {
        try {
            a();
            if (cl.f7049a) {
                a((a) new aw());
            } else if (z10) {
                a((a) new av());
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        f6813e.b(str);
    }

    public static void c(String str) {
        f6813e.c(str);
    }

    public static void d(String str) {
        f6813e.d(str);
    }

    public static void e(String str) {
        f6813e.e(str);
    }

    public static void f(String str) {
        f6813e.f(str);
    }

    public static void g(String str) {
        f6813e.g(str);
    }

    public static a h(String str) {
        for (a aVar : f6810b) {
            aVar.f6814a.set(str);
        }
        return f6813e;
    }

    public static void i(String str) {
        Map<String, a> map = f6812d;
        synchronized (map) {
            try {
                if (map.remove(str) == null) {
                    return;
                }
                f6810b = (a[]) map.values().toArray(new a[0]);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b(Object... objArr) {
        f6813e.b(objArr);
    }

    public static void c(Throwable th2, String str) {
        f6813e.c(th2, str);
    }

    public static void d(Throwable th2, String str) {
        f6813e.d(th2, str);
    }

    public static void e(Object... objArr) {
        f6813e.e(objArr);
    }

    public static void f(Object... objArr) {
        f6813e.f(objArr);
    }

    public static void b(Throwable th2, String str) {
        f6813e.b(th2, str);
    }

    public static void c(Object... objArr) {
        f6813e.c(objArr);
    }

    public static void d(Object... objArr) {
        f6813e.d(objArr);
    }

    public static void e(Throwable th2, String str) {
        f6813e.e(th2, str);
    }

    public static void f(Throwable th2, String str) {
        f6813e.f(th2, str);
    }

    public static void b(Throwable th2) {
        f6813e.b(th2);
    }

    public static void c(Throwable th2) {
        f6813e.c(th2);
    }

    public static void d(Throwable th2) {
        f6813e.d(th2);
    }

    public static void e(Throwable th2) {
        f6813e.e(th2);
    }

    public static void f(Throwable th2) {
        f6813e.f(th2);
    }

    public static void a() {
        try {
            i(aw.f6793a);
            i("debug");
        } catch (Throwable unused) {
        }
    }

    public static a b() {
        return f6813e;
    }

    public static a c() {
        for (a aVar : f6810b) {
            aVar.f6814a.set(f6809a);
        }
        return f6813e;
    }

    public static void d() {
        Map<String, a> map = f6812d;
        synchronized (map) {
            map.clear();
            f6810b = f6811c;
        }
    }

    public static List<a> e() {
        List<a> unmodifiableList;
        Map<String, a> map = f6812d;
        synchronized (map) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(map.values()));
        }
        return unmodifiableList;
    }

    public static int f() {
        int size;
        Map<String, a> map = f6812d;
        synchronized (map) {
            size = map.size();
        }
        return size;
    }

    public static void b(a aVar) {
        i(aVar.a());
    }

    public static void a(String str) {
        f6813e.a(str);
    }

    public static void a(Object... objArr) {
        f6813e.a(objArr);
    }

    public static void a(Throwable th2, String str) {
        f6813e.a(th2, str);
    }

    public static void a(Throwable th2) {
        f6813e.a(th2);
    }

    public static void a(Object obj) {
        f6813e.a(obj);
    }

    public static void a(int i10, String str) {
        f6813e.a(i10, str);
    }

    public static void a(int i10, Throwable th2, String str) {
        f6813e.a(i10, th2, str);
    }

    public static void a(int i10, Object... objArr) {
        f6813e.a(i10, objArr);
    }

    public static void a(int i10, Throwable th2) {
        f6813e.a(i10, th2);
    }

    public static void a(a aVar) {
        if (aVar == null || aVar == f6813e) {
            return;
        }
        Map<String, a> map = f6812d;
        synchronized (map) {
            map.put(aVar.a(), aVar);
            f6810b = (a[]) map.values().toArray(new a[0]);
        }
    }
}
