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

/* loaded from: classes4.dex */
public class PM {
    private static final Map<Class<?>, String> q = new b();

    /* renamed from: b */
    private final Context f24019b;

    /* renamed from: c */
    private String f24020c;

    /* renamed from: d */
    private File f24021d;

    /* renamed from: e */
    private volatile int f24022e;

    /* renamed from: f */
    private DexClassLoader f24023f;

    /* renamed from: g */
    private RandomAccessFile f24024g;

    /* renamed from: h */
    private FileLock f24025h;

    /* renamed from: i */
    private boolean f24026i;

    /* renamed from: j */
    private final f f24027j;
    private volatile POFactory k;
    private int l;
    private Future<Boolean> m;
    private boolean o;
    private String p;

    /* renamed from: a */
    final ExecutorService f24018a = Executors.newSingleThreadExecutor();
    private boolean n = false;

    class a implements Callable<Boolean> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            if (!PM.this.f24026i) {
                PM pm = PM.this;
                pm.f24026i = pm.tryLockUpdate();
            }
            if (PM.b(PM.this)) {
                PM.c(PM.this);
            }
            PM.this.l = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    static class b extends HashMap<Class<?>, String> {
        b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.f24019b = context.getApplicationContext();
        this.f24027j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        d();
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.f24020c);
            jSONObject.put("appId", com.qq.e.comm.managers.b.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.f24019b));
            jSONObject.put("ict", this.l);
            jSONObject.put("mup", this.f24026i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean b() {
        if (!this.f24026i) {
            return false;
        }
        try {
            Context context = this.f24019b;
            com.qq.e.comm.managers.plugin.b.a(context, h.e(context), h.f(this.f24019b));
            this.f24020c = Sig.ASSET_PLUGIN_SIG;
            this.f24021d = h.e(this.f24019b);
            this.f24022e = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (r5.b() != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean b(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            r5.getClass()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L32
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r5.c()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L2a
            boolean r5 = r5.b()     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L2c
        L2a:
            r5 = 1
            r1 = 1
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L44
        L32:
            r5 = move-exception
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L56
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L44:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            return r1
        L56:
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
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.b(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    static void c(PM pm) {
        pm.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file = pm.f24021d;
        sb.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (pm.f24020c == null || pm.f24021d == null) {
            pm.f24023f = null;
            return;
        }
        try {
            pm.f24023f = new DexClassLoader(pm.f24021d.getAbsolutePath(), h.a(pm.f24019b).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.f24027j;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            f fVar2 = pm.f24027j;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    private boolean c() {
        if (this.o) {
            return false;
        }
        if (this.f24026i) {
            g gVar = new g(h.c(this.f24019b), h.d(this.f24019b));
            if (gVar.a()) {
                GDTLogger.d("NextExist,Updated=" + gVar.a(h.e(this.f24019b), h.f(this.f24019b)));
            }
        }
        g gVar2 = new g(h.e(this.f24019b), h.f(this.f24019b));
        if (!gVar2.a()) {
            return false;
        }
        if (gVar2.c() >= SDKStatus.getBuildInPluginVersion()) {
            this.f24020c = gVar2.b();
            this.f24022e = gVar2.c();
            this.f24021d = h.e(this.f24019b);
            this.p = gVar2.d();
            this.n = true;
            return true;
        }
        GDTLogger.d("last updated plugin version =" + this.f24022e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
        return false;
    }

    private void d() {
        this.n = false;
        SharedPreferences sharedPreferences = this.f24019b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
        this.m = this.f24018a.submit(new a());
    }

    public <T> T getFactory(Class<T> cls) throws e {
        Future<Boolean> future = this.m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f24023f;
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = q.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.f24019b, a()));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws e {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    try {
                        this.k = (POFactory) getFactory(POFactory.class);
                    } catch (e e2) {
                        if (!this.n) {
                            throw e2;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.o = true;
                        d();
                        this.k = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        return this.k;
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.f24022e;
    }

    public boolean tryLockUpdate() {
        try {
            File b2 = h.b(this.f24019b);
            if (!b2.exists()) {
                b2.createNewFile();
                h.a("lock", b2);
            }
            if (!b2.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(b2, "rw");
            this.f24024g = randomAccessFile;
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            this.f24025h = tryLock;
            if (tryLock == null) {
                return false;
            }
            this.f24024g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
