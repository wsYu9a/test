package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.h;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.l;
import com.kwai.CpuMemoryProfiler;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private static boolean LA;
    private static List<Throwable> LD;
    private static Map<String, String> LE;
    private static boolean Lz;
    private static final AtomicBoolean LB = new AtomicBoolean(false);
    private static final AtomicBoolean LC = new AtomicBoolean(false);
    private static final List<b> LF = new CopyOnWriteArrayList();
    private static final List<c> LG = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.d.a$1 */
    public class AnonymousClass1 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (d.b(com.kwad.sdk.core.config.c.aud)) {
                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", PointCategory.INIT);
                com.kwad.sdk.crash.b.a(a.nH());
                a.LB.set(true);
                a.nF();
                a.nG();
            }
        }
    }

    /* renamed from: com.kwad.components.core.d.a$2 */
    public class AnonymousClass2 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (d.b(com.kwad.sdk.core.config.c.aud)) {
                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init Native");
                com.kwad.sdk.crash.b.b(a.nH());
                a.LC.set(true);
            }
        }
    }

    /* renamed from: com.kwad.components.core.d.a$3 */
    public class AnonymousClass3 implements com.kwad.sdk.f.a<Throwable> {
        private static void c(Throwable th2) {
            com.kwad.sdk.crash.b.n(th2);
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(Throwable th2) {
            c(th2);
        }
    }

    /* renamed from: com.kwad.components.core.d.a$4 */
    public class AnonymousClass4 implements f {
        final /* synthetic */ Context LH;

        public AnonymousClass4(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.crash.f
        public final void a(int i10, ExceptionMessage exceptionMessage) {
            n.aJ(context);
            if (i10 == 1 || i10 == 3 || i10 == 4) {
                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i10);
            }
            Iterator it = a.LG.iterator();
            while (it.hasNext()) {
                ((c) it.next()).onCrashOccur(i10, exceptionMessage.mCrashDetail);
            }
        }
    }

    /* renamed from: com.kwad.components.core.d.a$5 */
    public class AnonymousClass5 implements h {
        final /* synthetic */ Context LH;

        public AnonymousClass5(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.crash.h
        public final com.kwad.sdk.crash.model.message.a nQ() {
            com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
            aVar.fH(t.Gz());
            aVar.putString("mKsadAppId", ServiceProvider.MB().appId);
            aVar.putString("mKsadAppName", ServiceProvider.MB().appName);
            aVar.putString("mKsadAppPackageName", context.getPackageName());
            aVar.putString("mKsadAppVersion", l.ch(context));
            aVar.putString("mKsadSdkName", "com.kwad.sdk");
            com.kwad.sdk.l.At();
            aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(com.kwad.sdk.l.getSDKVersion(), 1));
            com.kwad.sdk.l.At();
            aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
            aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(com.kwad.sdk.l.At().getApiVersion(), 1));
            aVar.putInt("mKsadSdKApiVersionCode", com.kwad.sdk.l.At().getApiVersionCode());
            aVar.putInt("mKsadSdkType", 1);
            aVar.putInt("mBuildNumber", 42);
            for (b bVar : a.LF) {
                String key = bVar.getKey();
                JSONObject value = bVar.getValue();
                if (key != null && value != null) {
                    aVar.a(bVar.getKey(), bVar.getValue());
                }
            }
            return aVar;
        }
    }

    /* renamed from: com.kwad.components.core.d.a$a */
    public static class C0422a {
        public static String ak(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                return new File(context.getExternalFilesDir(null).getAbsolutePath());
            }
            File dataDir = i10 >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (!dataDir.exists()) {
                    return new File("/data/data/" + context.getPackageName());
                }
            }
            return dataDir;
        }
    }

    public interface b {
        String getKey();

        JSONObject getValue();
    }

    public interface c {
        void onCrashOccur(int i10, String str);
    }

    public static void a(b bVar) {
        LF.add(bVar);
    }

    private static com.kwad.sdk.crash.model.b ac(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.w("KsAdExceptionCollectorHelper", e10);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    private static String ad(String str) {
        try {
            int indexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return null;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return null;
        }
    }

    public static synchronized void aj(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!LC.get() && !LA) {
                    LA = true;
                    com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.core.d.a.2
                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            if (d.b(com.kwad.sdk.core.config.c.aud)) {
                                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init Native");
                                com.kwad.sdk.crash.b.b(a.nH());
                                a.LC.set(true);
                            }
                        }
                    });
                }
            }
        }
    }

    private static void b(Throwable th2) {
        if (LD == null) {
            LD = new CopyOnWriteArrayList();
        }
        LD.add(th2);
    }

    public static synchronized void initAsync(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!LB.get() && !Lz) {
                    Lz = true;
                    com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.core.d.a.1
                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            if (d.b(com.kwad.sdk.core.config.c.aud)) {
                                com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", PointCategory.INIT);
                                com.kwad.sdk.crash.b.a(a.nH());
                                a.LB.set(true);
                                a.nF();
                                a.nG();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void j(String str, String str2) {
        if (LB.get()) {
            com.kwad.sdk.crash.report.h.ah(str, str2);
        } else {
            k(str, str2);
        }
    }

    private static void k(String str, String str2) {
        if (LE == null) {
            LE = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LE.put(str, str2);
    }

    private static boolean nE() {
        return d.b(com.kwad.sdk.core.config.c.aue);
    }

    public static void nF() {
        if (LD == null || !nE()) {
            return;
        }
        Iterator<Throwable> it = LD.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.crash.b.n(it.next());
        }
        LD.clear();
        LD = null;
        ServiceProvider.f(new com.kwad.sdk.f.a<Throwable>() { // from class: com.kwad.components.core.d.a.3
            private static void c(Throwable th2) {
                com.kwad.sdk.crash.b.n(th2);
            }

            @Override // com.kwad.sdk.f.a
            public final /* synthetic */ void accept(Throwable th2) {
                c(th2);
            }
        });
    }

    public static void nG() {
        Map<String, String> map = LE;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                com.kwad.sdk.crash.report.h.ah(entry.getKey(), entry.getValue());
            }
        }
        LE.clear();
    }

    @NonNull
    public static com.kwad.sdk.crash.c nH() {
        String a10 = d.a(com.kwad.sdk.core.config.c.avy);
        com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "configStr:" + a10);
        com.kwad.sdk.crash.model.b ac2 = ac(a10);
        String str = ac2.aKI;
        String str2 = ac2.aKJ;
        boolean a11 = g.a(ac2);
        boolean b10 = g.b(ac2);
        Context context = ServiceProvider.getContext();
        String ak2 = C0422a.ak(context);
        c.a fl = new c.a().bM(context).bA(a11).bB(b10).bC(com.kwad.sdk.l.At().zB()).fm(str).fl(str2);
        com.kwad.sdk.l.At();
        c.a ft = fl.ft(ExceptionMessage.getSdkCrashVersionName(com.kwad.sdk.l.getSDKVersion(), 1));
        com.kwad.sdk.l.At();
        return ft.dC(BuildConfig.VERSION_CODE).fu(ExceptionMessage.getSdkCrashVersionName(com.kwad.sdk.l.At().getApiVersion(), 1)).dD(com.kwad.sdk.l.At().getApiVersionCode()).dE(1).fs("com.kwad.sdk").fv(context.getPackageName()).fw(ServiceProvider.MB().appId).fx(ServiceProvider.MB().appName).fy(l.ch(context)).fz(ac2.aKE).fA(ac2.aKF).fp(ba.getDeviceId()).fq(ServiceProvider.MB().appId).fo(ac2.version).fB(ac2.aKH).fC(ac2.aKG).fn("Android").fr(ak2).a(new h() { // from class: com.kwad.components.core.d.a.5
            final /* synthetic */ Context LH;

            public AnonymousClass5(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a nQ() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.fH(t.Gz());
                aVar.putString("mKsadAppId", ServiceProvider.MB().appId);
                aVar.putString("mKsadAppName", ServiceProvider.MB().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", l.ch(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                com.kwad.sdk.l.At();
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(com.kwad.sdk.l.getSDKVersion(), 1));
                com.kwad.sdk.l.At();
                aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(com.kwad.sdk.l.At().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", com.kwad.sdk.l.At().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 42);
                for (b bVar : a.LF) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.a(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.4
            final /* synthetic */ Context LH;

            public AnonymousClass4(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.crash.f
            public final void a(int i10, ExceptionMessage exceptionMessage) {
                n.aJ(context);
                if (i10 == 1 || i10 == 3 || i10 == 4) {
                    com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i10);
                }
                Iterator it = a.LG.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onCrashOccur(i10, exceptionMessage.mCrashDetail);
                }
            }
        }).d(nI()).e(nJ()).D(d.Dc()).m(d.a(com.kwad.sdk.core.config.c.awz)).Jj();
    }

    private static String[] nI() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(ad(KsAdSDKImpl.class.getName()));
            arrayList.add(ad(DownloadTask.class.getName()));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        try {
            arrayList.add(ad(CpuMemoryProfiler.class.getName()));
            arrayList.add(ad(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] nJ() {
        String[] strArr = new String[1];
        try {
            String name = com.kwad.sdk.crash.d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf(p1.b.f29697h));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        return strArr;
    }

    public static void reportSdkCaughtException(Throwable th2) {
        com.kwad.sdk.core.d.c.printStackTrace(th2);
        if (!LB.get()) {
            b(th2);
        } else if (nE()) {
            com.kwad.sdk.crash.b.n(th2);
        }
    }

    public static void a(c cVar) {
        LG.add(cVar);
    }
}
