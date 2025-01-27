package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.tencent.bugly.beta.tinker.TinkerManager;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* loaded from: classes2.dex */
public class bz {

    /* renamed from: a */
    public static final String f6983a = "ApkLoader";

    /* renamed from: b */
    protected static Thread.UncaughtExceptionHandler f6984b = null;

    /* renamed from: c */
    public static final String f6985c = "__badApkVersion__9.3711";

    /* renamed from: d */
    public static final String f6986d = "previousProxyVersion";

    /* renamed from: e */
    protected static final String f6987e = "__xadsdk__remote__final__";

    /* renamed from: f */
    protected static final String f6988f = "bdxadsdk.jar";

    /* renamed from: g */
    protected static final String f6989g = "__xadsdk__remote__final__builtin__.jar";

    /* renamed from: h */
    protected static final String f6990h = "__xadsdk__remote__final__builtinversion__.jar";

    /* renamed from: i */
    protected static final String f6991i = "__xadsdk__remote__final__downloaded__.jar";

    /* renamed from: j */
    protected static final String f6992j = "__xadsdk__remote__final__running__.jar";

    /* renamed from: k */
    public static final String f6993k = "OK";

    /* renamed from: l */
    public static final String f6994l = "ERROR";

    /* renamed from: m */
    public static final String f6995m = "APK_INFO";

    /* renamed from: n */
    public static final String f6996n = "CODE";

    /* renamed from: o */
    public static final String f6997o = "success";

    /* renamed from: p */
    protected static volatile bo f6998p = null;

    /* renamed from: q */
    protected static volatile bo f6999q = null;

    /* renamed from: r */
    protected static volatile Class f7000r = null;

    /* renamed from: s */
    protected static String f7001s = null;

    /* renamed from: t */
    protected static final Handler f7002t = new ca(Looper.getMainLooper());

    /* renamed from: x */
    private static final String f7003x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;

    /* renamed from: u */
    protected Handler f7004u;

    /* renamed from: v */
    @SuppressLint({"HandlerLeak"})
    protected final Handler f7005v;

    /* renamed from: w */
    private bx f7006w;

    /* renamed from: y */
    private final Context f7007y;

    /* renamed from: z */
    private bt f7008z;

    public static final class a extends Exception {

        /* renamed from: a */
        private static final long f7009a = 2978543166232984104L;

        public a(String str) {
            bt.a().c(str);
        }
    }

    public static final class b extends Exception {

        /* renamed from: a */
        private static final long f7010a = -7838296421993681751L;

        public b(String str) {
            bt.a().c(str);
        }
    }

    public interface c {
        void a(boolean z10);
    }

    public bz(Activity activity) {
        this(activity.getApplicationContext());
    }

    public void l() {
        try {
            File[] listFiles = this.f7007y.getFilesDir().listFiles();
            int i10 = 0;
            while (listFiles != null) {
                if (i10 >= listFiles.length) {
                    return;
                }
                if (listFiles[i10].getAbsolutePath().contains(f6987e) && listFiles[i10].getAbsolutePath().endsWith(TinkerManager.PATCH_DIR)) {
                    listFiles[i10].delete();
                }
                i10++;
            }
        } catch (Exception e10) {
            bt.a().c(e10);
        }
    }

    public SharedPreferences m() {
        return this.f7007y.getSharedPreferences(z.aK, 0);
    }

    private boolean n() {
        String string = m().getString(f6986d, null);
        return string == null || !string.equals(a());
    }

    private boolean o() {
        try {
            if (!br.a(c())) {
                if (!br.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            this.f7008z.a(e10);
            return false;
        }
    }

    public boolean p() {
        bs bsVar = new bs(f(), this.f7007y);
        if (!br.a(bsVar)) {
            return false;
        }
        try {
            if (n()) {
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            }
            synchronized (this) {
                try {
                    this.f7008z.a(f6983a, "loadDownloadedOrBuiltInApk len=" + bsVar.length() + ", path=" + bsVar.getAbsolutePath());
                    b(bsVar);
                    double d10 = (double) m().getFloat(f6985c, -1.0f);
                    this.f7008z.a(f6983a, "downloadedApkFile.getApkVersion(): " + bsVar.c() + ", badApkVersion: " + d10);
                    if (bsVar.c() == d10) {
                        throw new a("downloaded file marked bad, drop it and use built-in");
                    }
                    this.f7008z.a(f6983a, "loaded: " + bsVar.getPath());
                } finally {
                }
            }
            return true;
        } catch (a e10) {
            this.f7008z.a(f6983a, "load downloaded apk failed: " + e10.toString() + ", fallback to built-in");
            if (bsVar.exists()) {
                bsVar.delete();
            }
            k();
            return false;
        }
    }

    public int h() {
        return this.f7007y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(f6998p);
    }

    public IXAdContainerFactory j() {
        return a(f6999q);
    }

    public void k() {
        if (f6998p != null) {
            f6998p.b();
            f6998p = null;
        }
    }

    public bz(Context context) {
        this.f7008z = bt.a();
        this.A = false;
        this.f7004u = f7002t;
        this.B = new CopyOnWriteArrayList<>();
        this.f7005v = new cb(this, Looper.getMainLooper());
        this.f7007y = context;
        c(context);
        if (f6984b == null) {
            f6984b = cn.a(context);
            cn.a(context).a(new cc(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cn) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(f6984b);
    }

    public static String f() {
        if (TextUtils.isEmpty(f7001s)) {
            return "";
        }
        return f7001s + f6991i;
    }

    public void e() {
        this.f7008z.a(f6983a, "start load assets file");
        d(this.f7007y);
        String c10 = c();
        bs bsVar = new bs(c10, this.f7007y);
        if (!br.a(bsVar)) {
            throw new b("loadBuiltInApk failed: " + c10);
        }
        this.f7008z.a(f6983a, "assets file can read ,will use it ");
        if (c(bsVar)) {
            b(true);
        }
    }

    public void g() {
        if (h() != 2 ? p() : false) {
            this.f7008z.a(f6983a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.f7008z.a(f6983a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e10) {
            this.f7008z.a(f6983a, "loadBuiltInApk failed: " + e10.toString());
            throw new a("load built-in apk failed" + e10.toString());
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(f7001s)) {
            f7001s = context.getDir(f7003x, 0).getAbsolutePath() + "/";
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f7001s)) {
            return "";
        }
        return f7001s + f6990h;
    }

    public void b() {
        new File(f()).delete();
    }

    private void b(bs bsVar) {
        this.f7008z.a(f6983a, "len=" + bsVar.length() + ", path=" + bsVar.getAbsolutePath());
        if (f6998p == null) {
            String a10 = a(this.f7007y);
            bs bsVar2 = new bs(a10, this.f7007y);
            if (bsVar2.exists()) {
                bsVar2.delete();
            }
            try {
                br.a(new FileInputStream(bsVar), a10);
            } catch (Exception e10) {
                this.f7008z.c(e10);
            }
            f6998p = new bo(bsVar2.b(), this.f7007y);
            try {
                IXAdContainerFactory a11 = f6998p.a();
                this.f7008z.a(f6983a, "preloaded apk.version=" + a11.getRemoteVersion());
                return;
            } catch (a e11) {
                this.f7008z.a(f6983a, "preload local apk " + bsVar.getAbsolutePath() + " failed, msg:" + e11.getMessage() + ", v=" + f6998p.f6920b);
                a(e11.getMessage());
                throw e11;
            }
        }
        this.f7008z.a(f6983a, "mApkBuilder already initialized, version: " + f6998p.f6920b);
    }

    public static String c() {
        if (TextUtils.isEmpty(f7001s)) {
            return "";
        }
        return f7001s + f6989g;
    }

    private static synchronized void d(Context context) {
        synchronized (bz.class) {
            try {
                try {
                    String c10 = c();
                    double b10 = b(c10);
                    bt.a().a(f6983a, "copy assets,compare version=" + Double.valueOf("9.3711") + "remote=" + b10);
                    if (Double.valueOf("9.3711").doubleValue() != b10) {
                        bs bsVar = new bs(c10, context);
                        if (bsVar.exists()) {
                            bsVar.delete();
                        }
                        br.a(context, f6988f, c10);
                    }
                } catch (Exception e10) {
                    throw new b("loadBuiltInApk failed: " + e10.toString());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final String a() {
        return "9.3711";
    }

    @TargetApi(9)
    public void a(String str) {
        if (f6998p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(f6985c, (float) f6998p.f6920b);
            edit.apply();
        }
    }

    private boolean c(bs bsVar) {
        synchronized (this) {
            b(bsVar);
            this.f7008z.a(f6983a, "loaded: " + bsVar.getPath());
        }
        return true;
    }

    public void a(boolean z10) {
        Message obtainMessage = this.f7004u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z10);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f7004u.sendMessage(obtainMessage);
    }

    public void c(boolean z10) {
        double d10;
        if (z10) {
            try {
                d10 = f6998p.f6920b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d10 = l5.c.f27899e;
        }
        an.a(d10, new cf(this, d10), new cg(this));
    }

    public void a(bs bsVar) {
        Class<?> b10 = bsVar.b();
        synchronized (this) {
            f6999q = new bo(b10, this.f7007y);
        }
    }

    public synchronized void a(boolean z10, String str) {
        try {
            cn.a(this.f7007y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i10 = 0; i10 < this.B.size(); i10++) {
                    c cVar = this.B.get(i10);
                    if (cVar != null) {
                        cVar.a(z10);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } finally {
        }
    }

    public void b(boolean z10) {
        if (!z10 && !o()) {
            this.A = true;
        } else {
            a(z10, z10 ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            bd.a().a((j) new cd(this, z10));
        } else {
            bd.a().a(new ce(this, z10), 5L, TimeUnit.SECONDS);
        }
    }

    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.f7004u = handler;
        if (f6998p == null) {
            g();
        } else {
            b(true);
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f7001s)) {
            f7001s = context.getDir(f7003x, 0).getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(f7001s)) {
            return "";
        }
        return f7001s + f6992j;
    }

    public static double b(Context context) {
        try {
            c(context);
            double b10 = b(f());
            String d10 = d();
            if (Double.valueOf("9.3711").doubleValue() > b(d10)) {
                bs bsVar = new bs(d10, context);
                if (bsVar.exists()) {
                    bsVar.delete();
                }
                br.a(context, f6988f, d10);
            }
            return Math.max(b10, b(d()));
        } catch (Exception unused) {
            return l5.c.f27899e;
        }
    }

    public void a(bx bxVar) {
        if (bxVar.a().booleanValue()) {
            bv a10 = bv.a(this.f7007y, bxVar, f7001s, this.f7005v);
            if (!a10.isAlive()) {
                this.f7008z.a(f6983a, "XApkDownloadThread starting ...");
                a10.start();
            } else {
                this.f7008z.a(f6983a, "XApkDownloadThread already started");
                a10.a(bxVar.c());
            }
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        bd.a().a((j) new ch(this, cVar, handler));
    }

    public static double b(String str) {
        JarFile jarFile = null;
        try {
            try {
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (cm.f7058d.booleanValue()) {
            File file = new File(str);
            if (br.a(file)) {
                JarFile jarFile2 = new JarFile(file);
                try {
                    double parseDouble = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    if (parseDouble > l5.c.f27899e) {
                        try {
                            jarFile2.close();
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                        return parseDouble;
                    }
                    jarFile = jarFile2;
                } catch (Exception unused2) {
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    return l5.c.f27899e;
                } catch (Throwable th3) {
                    th = th3;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return l5.c.f27899e;
        }
        return Double.valueOf("9.3711").doubleValue();
    }

    public void a(c cVar) {
        a(cVar, f7002t);
    }

    private IXAdContainerFactory a(bo boVar) {
        if (boVar == null) {
            return null;
        }
        try {
            return boVar.a();
        } catch (Exception unused) {
            return null;
        }
    }
}
