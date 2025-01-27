package com.kwad.components.core.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.ksad.download.DownloadTask;
import com.kuaishou.aegon.Aegon;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.w;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.h;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.k;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class a {
    private static boolean Io;
    private static final AtomicBoolean Ip = new AtomicBoolean(false);
    private static List<Throwable> Iq;

    /* renamed from: com.kwad.components.core.c.a$1 */
    static class AnonymousClass1 extends aw {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            if (d.b(c.abI)) {
                b.d("KsAdExceptionCollectorHelper", "init");
                com.kwad.sdk.crash.b.a(a.mu());
                a.Ip.set(true);
                a.mt();
            }
        }
    }

    /* renamed from: com.kwad.components.core.c.a$2 */
    static class AnonymousClass2 implements com.kwad.sdk.e.a<Throwable> {
        AnonymousClass2() {
        }

        private static void d(Throwable th) {
            com.kwad.sdk.crash.b.g(th);
        }

        @Override // com.kwad.sdk.e.a
        public final /* synthetic */ void accept(Throwable th) {
            d(th);
        }
    }

    /* renamed from: com.kwad.components.core.c.a$3 */
    static class AnonymousClass3 implements f {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.crash.f
        public final void a(int i2, ExceptionMessage exceptionMessage) {
            g.sS();
            if (i2 == 1 || i2 == 3 || i2 == 4) {
                b.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.c.a$4 */
    static class AnonymousClass4 implements h {
        final /* synthetic */ Context Ir;

        AnonymousClass4(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.crash.h
        public final com.kwad.sdk.crash.model.message.a mA() {
            com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
            aVar.dD(w.xi());
            aVar.putString("mKsadAppId", ServiceProvider.CB().appId);
            aVar.putString("mKsadAppName", ServiceProvider.CB().appName);
            aVar.putString("mKsadAppPackageName", context.getPackageName());
            aVar.putString("mKsadAppVersion", k.bH(context));
            aVar.putString("mKsadSdkName", "com.kwad.sdk");
            aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1));
            aVar.putInt("mKsadSdKVersionCode", KsAdSDKImpl.get().getSDKVersionCode());
            aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1));
            aVar.putInt("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
            aVar.putInt("mKsadSdkType", 1);
            aVar.putInt("mBuildNumber", 463);
            return aVar;
        }
    }

    /* renamed from: com.kwad.components.core.c.a$a */
    static class C0169a {
        public static String Y(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = i2 >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!dataDir.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return dataDir;
        }
    }

    private static String al(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
            return null;
        }
    }

    public static void b(Throwable th) {
        b.printStackTrace(th);
        if (Ip.get()) {
            com.kwad.sdk.crash.b.g(th);
        } else {
            c(th);
        }
    }

    private static void c(Throwable th) {
        if (Iq == null) {
            Iq = new CopyOnWriteArrayList();
        }
        Iq.add(th);
    }

    public static synchronized void initAsync(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!Ip.get() && !Io) {
                    Io = true;
                    com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.components.core.c.a.1
                        AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.utils.aw
                        public final void doTask() {
                            if (d.b(c.abI)) {
                                b.d("KsAdExceptionCollectorHelper", "init");
                                com.kwad.sdk.crash.b.a(a.mu());
                                a.Ip.set(true);
                                a.mt();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void mt() {
        List<Throwable> list = Iq;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.crash.b.g(it.next());
        }
        Iq.clear();
        Iq = null;
        ServiceProvider.b(new com.kwad.sdk.e.a<Throwable>() { // from class: com.kwad.components.core.c.a.2
            AnonymousClass2() {
            }

            private static void d(Throwable th) {
                com.kwad.sdk.crash.b.g(th);
            }

            @Override // com.kwad.sdk.e.a
            public final /* synthetic */ void accept(Throwable th) {
                d(th);
            }
        });
    }

    @NonNull
    public static com.kwad.sdk.crash.c mu() {
        Context context = ServiceProvider.getContext();
        return new c.a().bm(context).bf(d.b(com.kwad.sdk.core.config.c.acS)).bg(d.b(com.kwad.sdk.core.config.c.acT)).bh(KsAdSDKImpl.get().getIsExternal()).dr(d.a(com.kwad.sdk.core.config.c.acU)).dq(d.a(com.kwad.sdk.core.config.c.acV)).dx(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1)).bF(KsAdSDKImpl.get().getSDKVersionCode()).dy(ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1)).bG(KsAdSDKImpl.get().getApiVersionCode()).bH(1).dw("com.kwad.sdk").dz(context.getPackageName()).dA(ServiceProvider.CB().appId).dB(ServiceProvider.CB().appName).dC(k.bH(context)).dt(au.getDeviceId()).du(ServiceProvider.CB().appId).ds("Android").dv(C0169a.Y(context)).a(new h() { // from class: com.kwad.components.core.c.a.4
            final /* synthetic */ Context Ir;

            AnonymousClass4(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a mA() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.dD(w.xi());
                aVar.putString("mKsadAppId", ServiceProvider.CB().appId);
                aVar.putString("mKsadAppName", ServiceProvider.CB().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", k.bH(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getSDKVersion(), 1));
                aVar.putInt("mKsadSdKVersionCode", KsAdSDKImpl.get().getSDKVersionCode());
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(KsAdSDKImpl.get().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 463);
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.c.a.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.crash.f
            public final void a(int i2, ExceptionMessage exceptionMessage) {
                g.sS();
                if (i2 == 1 || i2 == 3 || i2 == 4) {
                    b.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i2);
                }
            }
        }).d(mv()).e(mw()).u(d.tY()).j(d.a(com.kwad.sdk.core.config.c.adO)).zx();
    }

    private static String[] mv() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(al(KsAdSDKImpl.class.getName()));
            arrayList.add(al(DownloadTask.class.getName()));
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
        }
        try {
            arrayList.add(al(CpuMemoryProfiler.class.getName()));
            arrayList.add(al(Aegon.class.getName()));
        } catch (Throwable th2) {
            b.printStackTraceOnly(th2);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] mw() {
        String[] strArr = new String[1];
        try {
            String name = com.kwad.sdk.crash.d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf("."));
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
        }
        return strArr;
    }
}
