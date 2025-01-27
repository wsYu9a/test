package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.am;
import com.baidu.mobads.sdk.internal.c;

/* loaded from: classes2.dex */
public class an {

    /* renamed from: a */
    private static final String f6753a = "PluginLoader";

    /* renamed from: b */
    private static ClassLoader f6754b;

    public interface a {
        void a();
    }

    public static void a(double d10, am.b bVar, a aVar) {
        u uVar = (u) c.a().a(c.a.f7012a).a();
        if (uVar != null) {
            uVar.startLoadRemotePhp(d10, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static void b(int i10) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.b(i10);
        }
    }

    public static Activity c() {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            return vVar.c();
        }
        return null;
    }

    public static boolean d() {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            return vVar.d();
        }
        return false;
    }

    public static boolean e() {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            return vVar.e();
        }
        return false;
    }

    public static boolean f() {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            return vVar.f();
        }
        ay.c().e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
        return false;
    }

    public static void g() {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.g();
        }
    }

    public static void h() {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a();
        }
    }

    public static void b() {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.b();
        }
    }

    public static boolean a() {
        return cm.f7058d.booleanValue();
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        u uVar;
        if (!a()) {
            return classLoader;
        }
        if (f6754b == null && (uVar = (u) c.a().a(c.a.f7012a).a()) != null) {
            f6754b = uVar.getClassLoaderFromJar(str, str2, str3, classLoader);
        }
        return f6754b;
    }

    public static void b(int i10, int i11) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a(i10, i11);
        }
    }

    public static void a(Context context, String str, String str2) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a(context, str, str2);
        }
    }

    public static void a(w wVar) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a(wVar);
        }
    }

    public static void a(int i10) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a(i10);
        }
    }

    public static void a(int i10, boolean z10) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a(i10, z10);
        }
    }

    public static View a(Context context) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            return vVar.a(context);
        }
        return null;
    }

    public static void a(Context context, String str) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a(context, str);
        }
    }

    public static void a(boolean z10) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a(z10);
        }
    }

    public static void a(int i10, int i11) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.b(i10, i11);
        }
    }

    public static void a(boolean z10, int i10, int i11, int i12) {
        v vVar = (v) c.a().a(c.a.f7013b).a();
        if (vVar != null) {
            vVar.a(z10, i10, i11, i12);
        }
    }
}
