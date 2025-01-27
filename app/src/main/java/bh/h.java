package bh;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.at.api.ClassHandler;
import com.at.api.Module;
import com.at.sdk.AdConfigWrapper;
import com.sn.catpie.IClassHandler;
import com.sn.catpie.IModule;
import com.sntech.ads.SNAdConfig;
import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public final class h<T> implements IModule {

    /* renamed from: n */
    public static final /* synthetic */ boolean f1616n = true;

    /* renamed from: a */
    public final String f1617a;

    /* renamed from: b */
    public final String f1618b;

    /* renamed from: c */
    public final String f1619c;

    /* renamed from: d */
    public final String f1620d;

    /* renamed from: e */
    public final String f1621e;

    /* renamed from: f */
    public final int f1622f;

    /* renamed from: g */
    public final String f1623g;

    /* renamed from: h */
    public final String f1624h;

    /* renamed from: i */
    public final T f1625i;

    /* renamed from: j */
    public IModule f1626j;

    /* renamed from: k */
    public Module f1627k;

    /* renamed from: l */
    public transient l f1628l;

    /* renamed from: m */
    public final transient Object f1629m = new Object();

    public h(String str, String str2, T t10) {
        this.f1623g = str;
        w b10 = w.b(str);
        this.f1617a = b10.c();
        this.f1618b = b10.e();
        this.f1619c = b10.a();
        this.f1620d = b10.g();
        this.f1621e = b10.d();
        this.f1622f = b10.f();
        this.f1624h = str2;
        this.f1625i = t10;
        b();
    }

    public static void c(l lVar, List list) {
        lVar.f1632b = list;
    }

    public static void e(l lVar, List list) {
        lVar.f1632b = list;
    }

    public final l a(Context context) {
        synchronized (this.f1629m) {
            try {
                if (this.f1628l == null) {
                    context.getApplicationInfo();
                    File parentFile = new File(this.f1623g).getParentFile();
                    this.f1628l = new l(this.f1623g, parentFile.getAbsolutePath(), parentFile.getAbsolutePath());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (f1616n || this.f1628l != null) {
            return this.f1628l;
        }
        throw new AssertionError();
    }

    public final void b() {
        if (TextUtils.isEmpty(this.f1617a) && TextUtils.isEmpty(this.f1619c)) {
            throw new AssertionError("mImplClassName or mPluginClassName failed");
        }
        if (TextUtils.isEmpty(this.f1621e)) {
            throw new AssertionError("mId failed");
        }
        if (this.f1622f < 0) {
            throw new AssertionError("mVersion failed");
        }
        if (TextUtils.isEmpty(this.f1624h)) {
            throw new AssertionError("mMd5 failed");
        }
        File file = new File(this.f1623g);
        if (TextUtils.isEmpty(this.f1623g) || !file.exists() || !file.isFile() || !file.canRead()) {
            throw new AssertionError("mLocalPath failed");
        }
    }

    public final void d(Context context) {
        if (!TextUtils.isEmpty(this.f1619c)) {
            if (this.f1627k == null) {
                l a10 = a(context);
                String str = this.f1620d;
                if (str != null) {
                    ClassHandler classHandler = (ClassHandler) a10.loadClass(str).newInstance();
                    if (classHandler.getHostClasses() != null) {
                        a10.f1633c = classHandler.getHostClasses();
                    }
                    classHandler.getExtraClassLoader(new ClassHandler.ClassLoaderListener() { // from class: bh.f
                        public /* synthetic */ f() {
                        }

                        @Override // com.at.api.ClassHandler.ClassLoaderListener
                        public final void onExtraClassLoaderAvailable(List list) {
                            h.c(l.this, list);
                        }
                    });
                }
                this.f1627k = (Module) a10.loadClass(this.f1619c).newInstance();
                return;
            }
            return;
        }
        if (this.f1626j != null || TextUtils.isEmpty(this.f1617a)) {
            return;
        }
        l a11 = a(context);
        String str2 = this.f1618b;
        if (str2 != null) {
            IClassHandler iClassHandler = (IClassHandler) a11.loadClass(str2).newInstance();
            if (iClassHandler.getHostClasses() != null) {
                a11.f1633c = iClassHandler.getHostClasses();
            }
            iClassHandler.getExtraClassLoader(new IClassHandler.ClassLoaderListener() { // from class: bh.g
                public /* synthetic */ g() {
                }

                @Override // com.sn.catpie.IClassHandler.ClassLoaderListener
                public final void onExtraClassLoaderAvailable(List list) {
                    h.e(l.this, list);
                }
            });
        }
        this.f1626j = (IModule) a11.loadClass(this.f1617a).newInstance();
    }

    @Override // com.sn.catpie.IModule
    public final Object getService(Class<?> cls) {
        Module module = this.f1627k;
        if (module != null) {
            return module.getService(cls);
        }
        IModule iModule = this.f1626j;
        if (iModule != null) {
            return iModule.getService(cls);
        }
        return null;
    }

    @Override // com.sn.catpie.IModule
    public final void onApplicationAttachBaseContext(Application application) {
        Module module = this.f1627k;
        if (module != null) {
            module.onApplicationAttachBaseContext(application);
            return;
        }
        IModule iModule = this.f1626j;
        if (iModule != null) {
            iModule.onApplicationAttachBaseContext(application);
        }
    }

    @Override // com.sn.catpie.IModule
    public final void onApplicationCreate(Application application) {
        Module module = this.f1627k;
        if (module != null) {
            module.onApplicationCreate(application);
            return;
        }
        IModule iModule = this.f1626j;
        if (iModule != null) {
            iModule.onApplicationCreate(application);
        }
    }

    @Override // com.sn.catpie.IModule
    public final void onApplicationLowMemory(Application application) {
        Module module = this.f1627k;
        if (module != null) {
            module.onApplicationLowMemory(application);
            return;
        }
        IModule iModule = this.f1626j;
        if (iModule != null) {
            iModule.onApplicationLowMemory(application);
        }
    }

    @Override // com.sn.catpie.IModule
    public final void onLoad(Application application, SNAdConfig sNAdConfig) {
        Module module = this.f1627k;
        if (module != null) {
            module.onLoad(application, new AdConfigWrapper.a(sNAdConfig));
            return;
        }
        IModule iModule = this.f1626j;
        if (iModule != null) {
            iModule.onLoad(application, sNAdConfig);
        }
    }

    @Override // com.sn.catpie.IModule
    public final void onUnload(Application application) {
        Module module = this.f1627k;
        if (module != null) {
            module.onUnload(application);
            return;
        }
        IModule iModule = this.f1626j;
        if (iModule != null) {
            iModule.onUnload(application);
        }
    }
}
