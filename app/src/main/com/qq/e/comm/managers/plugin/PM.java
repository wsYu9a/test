package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PM {
    public static final int CALL_START_BY_DEV = 1;

    /* renamed from: t */
    private static final Map<Class<?>, String> f16570t = new b();

    /* renamed from: b */
    private final Context f16572b;

    /* renamed from: c */
    private String f16573c;

    /* renamed from: d */
    private File f16574d;

    /* renamed from: e */
    private volatile int f16575e;

    /* renamed from: f */
    private DexClassLoader f16576f;

    /* renamed from: g */
    private RandomAccessFile f16577g;

    /* renamed from: h */
    private FileLock f16578h;

    /* renamed from: i */
    private boolean f16579i;

    /* renamed from: j */
    private final f f16580j;

    /* renamed from: k */
    private volatile POFactory f16581k;

    /* renamed from: l */
    private int f16582l;

    /* renamed from: m */
    private int f16583m;

    /* renamed from: n */
    private Future<Boolean> f16584n;

    /* renamed from: p */
    private boolean f16586p;

    /* renamed from: q */
    private String f16587q;

    /* renamed from: r */
    private JSONObject f16588r;

    /* renamed from: s */
    private int f16589s;

    /* renamed from: a */
    final ExecutorService f16571a = Executors.newSingleThreadExecutor();

    /* renamed from: o */
    private boolean f16585o = false;

    public class a implements Callable<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            h.b(PM.this.f16572b);
            PM.b(PM.this);
            if (!PM.this.f16579i) {
                PM pm = PM.this;
                pm.f16579i = pm.tryLockUpdate();
            }
            if (PM.d(PM.this)) {
                PM.this.f16583m = (int) (System.currentTimeMillis() - currentTimeMillis);
                PM.e(PM.this);
            }
            PM.this.f16582l = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    public static class b extends HashMap<Class<?>, String> {
        public b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.f16572b = context.getApplicationContext();
        this.f16580j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        d();
    }

    private boolean c() {
        if (this.f16586p) {
            return false;
        }
        if (this.f16579i) {
            g gVar = new g(h.e(this.f16572b), h.f(this.f16572b));
            if (gVar.a(this.f16572b, false)) {
                this.f16589s = 3;
                h.a(this.f16572b);
                GDTLogger.d("NextExist,Updated=" + gVar.a(h.g(this.f16572b), h.h(this.f16572b), this.f16572b));
            }
        }
        g gVar2 = new g(h.g(this.f16572b), h.h(this.f16572b));
        if (!gVar2.a(this.f16572b, true)) {
            return false;
        }
        if (gVar2.b() < SDKStatus.getBuildInPluginVersion()) {
            GDTLogger.d("last updated plugin version =" + this.f16575e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
            return false;
        }
        if (this.f16589s == 0) {
            this.f16589s = 2;
        }
        this.f16573c = gVar2.a();
        this.f16575e = gVar2.b();
        this.f16574d = h.g(this.f16572b);
        this.f16587q = gVar2.c();
        this.f16585o = true;
        return true;
    }

    private void d() {
        this.f16585o = false;
        this.f16584n = this.f16571a.submit(new a());
    }

    public static void e(PM pm) {
        pm.getClass();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PluginFile:\t");
        File file = pm.f16574d;
        sb2.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sb2.toString());
        if (pm.f16573c == null || pm.f16574d == null) {
            pm.f16576f = null;
            return;
        }
        try {
            pm.f16576f = new DexClassLoader(pm.f16574d.getAbsolutePath(), h.c(pm.f16572b).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.f16580j;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th2) {
            GDTLogger.e("插件ClassLoader构造发生异常", th2);
            f fVar2 = pm.f16580j;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th2, th2.getMessage());
        }
    }

    public <T> T getFactory(Class<T> cls) throws e {
        Future<Boolean> future = this.f16584n;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f16576f;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PluginClassLoader is parent");
        sb2.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb2.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = f16570t.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.f16572b, a()));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th2) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th2);
        }
    }

    public POFactory getPOFactory() throws e {
        return getPOFactory(true, false);
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.f16584n;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.f16575e;
    }

    public JSONObject getStartCaller(int i10) {
        if (this.f16588r == null) {
            this.f16588r = new JSONObject();
        }
        try {
            this.f16588r.put("scr", i10);
        } catch (JSONException unused) {
        }
        return this.f16588r;
    }

    public boolean tryLockUpdate() {
        try {
            File d10 = h.d(this.f16572b);
            if (!d10.exists()) {
                d10.createNewFile();
                h.a("lock", d10);
            }
            if (!d10.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(d10, "rw");
            this.f16577g = randomAccessFile;
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            this.f16578h = tryLock;
            if (tryLock == null) {
                return false;
            }
            this.f16577g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean b() {
        if (!this.f16579i) {
            return false;
        }
        try {
            this.f16589s = 1;
            Context context = this.f16572b;
            com.qq.e.comm.managers.plugin.b.a(context, h.g(context), h.h(this.f16572b));
            this.f16573c = Sig.ASSET_PLUGIN_SIG;
            this.f16574d = h.g(this.f16572b);
            this.f16575e = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th2) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th2, th2.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (r5.b() != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            r5.getClass()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r2.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L2b
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2b
            r2.append(r3)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2b
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L2b
            boolean r2 = r5.c()     // Catch: java.lang.Throwable -> L2b
            if (r2 != 0) goto L2d
            boolean r5 = r5.b()     // Catch: java.lang.Throwable -> L2b
            if (r5 == 0) goto L2e
            goto L2d
        L2b:
            r5 = move-exception
            goto L45
        L2d:
            r1 = 1
        L2e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L33:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            goto L57
        L45:
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L58
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L58
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L33
        L57:
            return r1
        L58:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.d(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    public POFactory getPOFactory(boolean z10, boolean z11) throws e {
        if (this.f16581k == null) {
            synchronized (this) {
                if (this.f16581k == null) {
                    try {
                        this.f16581k = (POFactory) getFactory(POFactory.class);
                    } catch (e e10) {
                        if (!this.f16585o) {
                            throw e10;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.f16586p = true;
                        this.f16585o = false;
                        this.f16584n = this.f16571a.submit(new a());
                        this.f16581k = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z10 && this.f16581k != null) {
            this.f16581k.start(z11 ? getStartCaller(0) : getStartCaller(2));
        }
        return this.f16581k;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.f16587q);
            }
            jSONObject.put(com.umeng.analytics.pro.f.T, pluginVersion);
            jSONObject.put("sig", this.f16573c);
            jSONObject.put("appId", com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.f16572b));
            jSONObject.put("ict", this.f16582l);
            jSONObject.put("mup", this.f16579i);
            jSONObject.put("ifg", this.f16589s);
            jSONObject.put("pct", this.f16583m);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void b(PM pm) {
        SharedPreferences sharedPreferences = pm.f16572b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            pm.f16586p = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
    }
}
