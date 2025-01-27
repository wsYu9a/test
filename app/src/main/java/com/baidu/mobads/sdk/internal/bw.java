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

/* loaded from: classes.dex */
public class bw {

    /* renamed from: a */
    public static final String f5668a = "ApkLoader";

    /* renamed from: b */
    protected static Thread.UncaughtExceptionHandler f5669b = null;

    /* renamed from: c */
    public static final String f5670c = "__badApkVersion__9.29";

    /* renamed from: d */
    public static final String f5671d = "previousProxyVersion";

    /* renamed from: e */
    protected static final String f5672e = "__xadsdk__remote__final__";

    /* renamed from: f */
    protected static final String f5673f = "bdxadsdk.jar";

    /* renamed from: g */
    protected static final String f5674g = "__xadsdk__remote__final__builtin__.jar";

    /* renamed from: h */
    protected static final String f5675h = "__xadsdk__remote__final__builtinversion__.jar";

    /* renamed from: i */
    protected static final String f5676i = "__xadsdk__remote__final__downloaded__.jar";

    /* renamed from: j */
    protected static final String f5677j = "__xadsdk__remote__final__running__.jar";
    public static final String k = "OK";
    public static final String l = "ERROR";
    public static final String m = "APK_INFO";
    public static final String n = "CODE";
    public static final String o = "success";
    protected static volatile bl p = null;
    protected static volatile bl q = null;
    protected static volatile Class r = null;
    protected static String s = null;
    protected static final Handler t = new bx(Looper.getMainLooper());
    private static final String x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;
    protected Handler u;

    @SuppressLint({"HandlerLeak"})
    protected final Handler v;
    private bu w;
    private final Context y;
    private bq z;

    public static final class a extends Exception {

        /* renamed from: a */
        private static final long f5678a = 2978543166232984104L;

        public a(String str) {
            bq.a().c(str);
        }
    }

    protected static final class b extends Exception {

        /* renamed from: a */
        private static final long f5679a = -7838296421993681751L;

        public b(String str) {
            bq.a().c(str);
        }
    }

    public interface c {
        void a(boolean z);
    }

    public bw(Activity activity) {
        this(activity.getApplicationContext());
    }

    public void l() {
        try {
            File[] listFiles = this.y.getFilesDir().listFiles();
            int i2 = 0;
            while (listFiles != null) {
                if (i2 >= listFiles.length) {
                    return;
                }
                if (listFiles[i2].getAbsolutePath().contains(f5672e) && listFiles[i2].getAbsolutePath().endsWith(TinkerManager.PATCH_DIR)) {
                    listFiles[i2].delete();
                }
                i2++;
            }
        } catch (Exception e2) {
            bq.a().c(e2);
        }
    }

    public SharedPreferences m() {
        return this.y.getSharedPreferences(w.az, 0);
    }

    private boolean n() {
        String string = m().getString(f5671d, null);
        return string == null || !string.equals(a());
    }

    private boolean o() {
        try {
            if (!bo.a(c())) {
                if (!bo.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            this.z.a(e2);
            return false;
        }
    }

    public boolean p() {
        bp bpVar = new bp(f(), this.y);
        if (!bo.a(bpVar)) {
            return false;
        }
        try {
            if (n()) {
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            }
            synchronized (this) {
                this.z.a(f5668a, "loadDownloadedOrBuiltInApk len=" + bpVar.length() + ", path=" + bpVar.getAbsolutePath());
                b(bpVar);
                double d2 = (double) m().getFloat(f5670c, -1.0f);
                this.z.a(f5668a, "downloadedApkFile.getApkVersion(): " + bpVar.c() + ", badApkVersion: " + d2);
                if (bpVar.c() == d2) {
                    throw new a("downloaded file marked bad, drop it and use built-in");
                }
                this.z.a(f5668a, "loaded: " + bpVar.getPath());
            }
            return true;
        } catch (a e2) {
            this.z.a(f5668a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
            if (bpVar.exists()) {
                bpVar.delete();
            }
            k();
            return false;
        }
    }

    public final String a() {
        return "9.29";
    }

    public int h() {
        return this.y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(p);
    }

    public IXAdContainerFactory j() {
        return a(q);
    }

    protected void k() {
        if (p != null) {
            p.b();
            p = null;
        }
    }

    public bw(Context context) {
        this.z = bq.a();
        this.A = false;
        this.u = t;
        this.B = new CopyOnWriteArrayList<>();
        this.v = new by(this, Looper.getMainLooper());
        this.y = context;
        c(context);
        if (f5669b == null) {
            f5669b = ck.a(context);
            ck.a(context).a(new bz(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof ck) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(f5669b);
    }

    protected static String f() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + f5676i;
    }

    protected void e() {
        this.z.a(f5668a, "start load assets file");
        d(this.y);
        String c2 = c();
        bp bpVar = new bp(c2, this.y);
        if (!bo.a(bpVar)) {
            throw new b("loadBuiltInApk failed: " + c2);
        }
        this.z.a(f5668a, "assets file can read ,will use it ");
        if (c(bpVar)) {
            b(true);
        }
    }

    protected void g() {
        if (h() != 2 ? p() : false) {
            this.z.a(f5668a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.z.a(f5668a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            this.z.a(f5668a, "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(s)) {
            s = context.getDir(x, 0).getAbsolutePath() + "/";
        }
    }

    protected static String d() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + f5675h;
    }

    protected void b() {
        new File(f()).delete();
    }

    private static synchronized void d(Context context) {
        synchronized (bw.class) {
            try {
                String c2 = c();
                double b2 = b(c2);
                bq.a().a(f5668a, "copy assets,compare version=" + Double.valueOf("9.29") + "remote=" + b2);
                if (Double.valueOf("9.29").doubleValue() != b2) {
                    bp bpVar = new bp(c2, context);
                    if (bpVar.exists()) {
                        bpVar.delete();
                    }
                    bo.a(context, f5673f, c2);
                }
            } catch (Exception e2) {
                throw new b("loadBuiltInApk failed: " + e2.toString());
            }
        }
    }

    private void b(bp bpVar) {
        this.z.a(f5668a, "len=" + bpVar.length() + ", path=" + bpVar.getAbsolutePath());
        if (p == null) {
            String a2 = a(this.y);
            bp bpVar2 = new bp(a2, this.y);
            if (bpVar2.exists()) {
                bpVar2.delete();
            }
            try {
                bo.a(new FileInputStream(bpVar), a2);
            } catch (Exception e2) {
                this.z.c(e2);
            }
            p = new bl(bpVar2.b(), this.y);
            try {
                IXAdContainerFactory a3 = p.a();
                this.z.a(f5668a, "preloaded apk.version=" + a3.getRemoteVersion());
                return;
            } catch (a e3) {
                this.z.a(f5668a, "preload local apk " + bpVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + p.f5609b);
                a(e3.getMessage());
                throw e3;
            }
        }
        this.z.a(f5668a, "mApkBuilder already initialized, version: " + p.f5609b);
    }

    protected static String c() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + f5674g;
    }

    @TargetApi(9)
    protected void a(String str) {
        if (p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(f5670c, (float) p.f5609b);
            edit.apply();
        }
    }

    private boolean c(bp bpVar) {
        synchronized (this) {
            b(bpVar);
            this.z.a(f5668a, "loaded: " + bpVar.getPath());
        }
        return true;
    }

    public void a(boolean z) {
        Message obtainMessage = this.u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean(o, z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.u.sendMessage(obtainMessage);
    }

    public void c(boolean z) {
        double d2;
        if (z) {
            try {
                d2 = p.f5609b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d2 = 0.0d;
        }
        an.a(d2, new cc(this, d2), new cd(this));
    }

    public void a(bp bpVar) {
        Class<?> b2 = bpVar.b();
        synchronized (this) {
            q = new bl(b2, this.y);
        }
    }

    public synchronized void a(boolean z, String str) {
        try {
            ck.a(this.y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i2 = 0; i2 < this.B.size(); i2++) {
                    c cVar = this.B.get(i2);
                    if (cVar != null) {
                        cVar.a(z);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(boolean z) {
        if (!z && !o()) {
            this.A = true;
        } else {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            ba.a().a((h) new ca(this, z));
        } else {
            ba.a().a(new cb(this, z), 5L, TimeUnit.SECONDS);
        }
    }

    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.u = handler;
        if (p == null) {
            g();
        } else {
            b(true);
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(s)) {
            s = context.getDir(x, 0).getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + f5677j;
    }

    public void a(bu buVar) {
        if (buVar.a().booleanValue()) {
            bs a2 = bs.a(this.y, buVar, s, this.v);
            if (!a2.isAlive()) {
                this.z.a(f5668a, "XApkDownloadThread starting ...");
                a2.start();
            } else {
                this.z.a(f5668a, "XApkDownloadThread already started");
                a2.a(buVar.c());
            }
        }
    }

    public static double b(Context context) {
        try {
            c(context);
            double b2 = b(f());
            String d2 = d();
            if (Double.valueOf("9.29").doubleValue() > b(d2)) {
                bp bpVar = new bp(d2, context);
                if (bpVar.exists()) {
                    bpVar.delete();
                }
                bo.a(context, f5673f, d2);
            }
            return Math.max(b2, b(d()));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        ba.a().a((h) new ce(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, t);
    }

    private IXAdContainerFactory a(bl blVar) {
        if (blVar == null) {
            return null;
        }
        try {
            return blVar.a();
        } catch (Exception unused) {
            return null;
        }
    }

    public static double b(String str) {
        JarFile jarFile = null;
        try {
            try {
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cj.f5725d.booleanValue()) {
            File file = new File(str);
            if (bo.a(file)) {
                JarFile jarFile2 = new JarFile(file);
                try {
                    double parseDouble = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    if (parseDouble > 0.0d) {
                        try {
                            jarFile2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return parseDouble;
                    }
                    jarFile = jarFile2;
                } catch (Exception unused2) {
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    return 0.0d;
                } catch (Throwable th2) {
                    th = th2;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return 0.0d;
        }
        return Double.valueOf("9.29").doubleValue();
    }
}
