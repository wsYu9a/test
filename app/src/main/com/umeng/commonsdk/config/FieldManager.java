package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class FieldManager {

    /* renamed from: a */
    private static final String f24334a = "cfgfd";

    /* renamed from: b */
    private static b f24335b = b.b();

    /* renamed from: c */
    private static boolean f24336c = false;

    /* renamed from: d */
    private static Object f24337d = new Object();

    public static class a {

        /* renamed from: a */
        private static final FieldManager f24338a = new FieldManager();

        private a() {
        }
    }

    public /* synthetic */ FieldManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static FieldManager a() {
        return a.f24338a;
    }

    public static boolean allow(String str) {
        synchronized (f24337d) {
            try {
                if (!f24336c) {
                    return false;
                }
                return b.a(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean b() {
        boolean z10;
        synchronized (f24337d) {
            z10 = f24336c;
        }
        return z10;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0671d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f24337d) {
            try {
                Pair<Long, String> a10 = a(imprintProperty);
                if (((Long) a10.first).longValue() > 1000 && (str = (String) a10.second) != null && str.length() > 0) {
                    str2 = str;
                }
                String[] split = str2.split(",");
                int length = split.length;
                if (length > 0) {
                    ArrayList arrayList = new ArrayList();
                    g gVar = new g();
                    for (int i10 = 0; i10 < length; i10++) {
                        arrayList.add(gVar);
                        ((e) arrayList.get(i10)).a(split[i10], f24335b, d.b(strArr[i10]));
                    }
                }
                f24336c = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0671d.class.getName()};
        synchronized (f24337d) {
            try {
                f24335b.a();
                if (str != null) {
                    Pair<Long, String> a10 = a(str);
                    if (((Long) a10.first).longValue() > 1000 && (str2 = (String) a10.second) != null && str2.length() > 0) {
                        str3 = str2;
                    }
                }
                String[] split = str3.split(",");
                int length = split.length;
                if (length > 0) {
                    ArrayList arrayList = new ArrayList();
                    g gVar = new g();
                    for (int i10 = 0; i10 < length; i10++) {
                        arrayList.add(gVar);
                        ((e) arrayList.get(i10)).a(split[i10], f24335b, d.b(strArr[i10]));
                    }
                }
                f24336c = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
