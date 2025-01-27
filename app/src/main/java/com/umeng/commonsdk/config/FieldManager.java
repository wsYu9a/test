package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class FieldManager {

    /* renamed from: a */
    private static final String f26109a = "cfgfd";

    /* renamed from: b */
    private static b f26110b = b.b();

    /* renamed from: c */
    private static boolean f26111c = false;

    /* renamed from: d */
    private static Object f26112d = new Object();

    private static class a {

        /* renamed from: a */
        private static final FieldManager f26113a = new FieldManager();

        private a() {
        }
    }

    /* synthetic */ FieldManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static FieldManager a() {
        return a.f26113a;
    }

    public static boolean allow(String str) {
        synchronized (f26112d) {
            if (!f26111c) {
                return false;
            }
            return b.a(str);
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f26112d) {
            z = f26111c;
        }
        return z;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0541d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f26112d) {
            Pair<Long, String> a2 = a(imprintProperty);
            if (((Long) a2.first).longValue() > 1000 && (str = (String) a2.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i2)).a(split[i2], f26110b, d.b(strArr[i2]));
                }
            }
            f26111c = true;
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0541d.class.getName()};
        synchronized (f26112d) {
            f26110b.a();
            if (str != null) {
                Pair<Long, String> a2 = a(str);
                if (((Long) a2.first).longValue() > 1000 && (str2 = (String) a2.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            String[] split = str3.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i2)).a(split[i2], f26110b, d.b(strArr[i2]));
                }
            }
            f26111c = true;
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
