package bh;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/* loaded from: classes4.dex */
public final class w {

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, w> f1653b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1654c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Manifest f1655a;

    public w(String str) {
        JarFile jarFile = new JarFile(str, false);
        try {
            this.f1655a = jarFile.getManifest();
            jarFile.close();
        } catch (Throwable th2) {
            try {
                jarFile.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<java.lang.String, bh.w>] */
    public static w b(String str) {
        w wVar;
        synchronized (f1654c) {
            try {
                ?? r12 = f1653b;
                wVar = (w) r12.get(str);
                if (wVar == null) {
                    wVar = new w(str);
                    r12.put(str, wVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return wVar;
    }

    public final String a() {
        return this.f1655a.getMainAttributes().getValue("Plugin-ClassName");
    }

    public final String c() {
        return this.f1655a.getMainAttributes().getValue("Impl-ClassName");
    }

    public final String d() {
        return this.f1655a.getMainAttributes().getValue("Module-Id");
    }

    public final String e() {
        return this.f1655a.getMainAttributes().getValue("Module-ClassHandler");
    }

    public final int f() {
        String value = this.f1655a.getMainAttributes().getValue("Module-Version");
        if (TextUtils.isDigitsOnly(value)) {
            return Integer.parseInt(value);
        }
        return -1;
    }

    public final String g() {
        return this.f1655a.getMainAttributes().getValue("Plugin-ClassHandler");
    }
}
