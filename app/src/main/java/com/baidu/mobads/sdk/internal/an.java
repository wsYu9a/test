package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.am;
import com.baidu.mobads.sdk.internal.c;

/* loaded from: classes.dex */
public class an {

    /* renamed from: a */
    private static final String f5528a = "PluginLoader";

    /* renamed from: b */
    private static ClassLoader f5529b;

    public interface a {
        void a();
    }

    public static void a(double d2, am.b bVar, a aVar) {
        r rVar = (r) c.a().a(c.a.f5683a).a();
        if (rVar != null) {
            rVar.startLoadRemotePhp(d2, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static void b(int i2) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.b(i2);
        }
    }

    public static Activity c() {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public static boolean d() {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            return sVar.d();
        }
        return false;
    }

    public static boolean e() {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            return sVar.e();
        }
        return false;
    }

    public static boolean f() {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            return sVar.f();
        }
        av.c().e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
        return false;
    }

    public static void g() {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.g();
        }
    }

    public static void h() {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a();
        }
    }

    public static void b() {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.b();
        }
    }

    public static boolean a() {
        return cj.f5725d.booleanValue();
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        r rVar;
        if (!a()) {
            return classLoader;
        }
        if (f5529b == null && (rVar = (r) c.a().a(c.a.f5683a).a()) != null) {
            f5529b = rVar.getClassLoaderFromJar(str, str2, str3, classLoader);
        }
        return f5529b;
    }

    public static void b(int i2, int i3) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a(i2, i3);
        }
    }

    public static void a(Context context, String str, String str2) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a(context, str, str2);
        }
    }

    public static void a(t tVar) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a(tVar);
        }
    }

    public static void a(int i2) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a(i2);
        }
    }

    public static void a(int i2, boolean z) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a(i2, z);
        }
    }

    public static View a(Context context) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            return sVar.a(context);
        }
        return null;
    }

    public static void a(Context context, String str) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a(context, str);
        }
    }

    public static void a(boolean z) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a(z);
        }
    }

    public static void a(int i2, int i3) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.b(i2, i3);
        }
    }

    public static void a(boolean z, int i2, int i3, int i4) {
        s sVar = (s) c.a().a(c.a.f5684b).a();
        if (sVar != null) {
            sVar.a(z, i2, i3, i4);
        }
    }
}
