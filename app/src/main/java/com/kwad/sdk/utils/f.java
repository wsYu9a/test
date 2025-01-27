package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.martian.mibook.application.MiConfigSingleton;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f {
    private static Handler Uk;
    private static ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!f.CE()) {
                    com.kwad.sdk.core.d.b.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = f.ayT;
                try {
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                com.kwad.sdk.service.b.gatherException(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private static Messenger ayT;
    private static volatile ExecutorService ayU;
    private static volatile AppStatusRules ayV;
    private static WeakReference<Context> ayW;
    private static com.kwad.sdk.collector.h ayX;

    /* renamed from: com.kwad.sdk.utils.f$1 */
    static class AnonymousClass1 implements ServiceConnection {
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!f.CE()) {
                    com.kwad.sdk.core.d.b.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = f.ayT;
                try {
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                com.kwad.sdk.service.b.gatherException(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.kwad.sdk.utils.f$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context jN;

        /* renamed from: com.kwad.sdk.utils.f$2$1 */
        final class AnonymousClass1 implements c.a {

            /* renamed from: com.kwad.sdk.utils.f$2$1$1 */
            final class RunnableC02311 implements Runnable {
                RunnableC02311() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.kwad.sdk.collector.j.a(AnonymousClass2.this.jN, f.ayV);
                    } catch (Throwable th) {
                        com.kwad.sdk.service.b.gatherException(th);
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }

            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.collector.c.a
            public final void b(AppStatusRules appStatusRules) {
                appStatusRules.initStatus(AnonymousClass2.this.jN);
                AppStatusRules unused = f.ayV = appStatusRules;
                f.b(AnonymousClass2.this.jN, f.ayV);
                f.by(AnonymousClass2.this.jN);
                boolean dc = bd.dc(AnonymousClass2.this.jN);
                boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.ayV);
                com.kwad.sdk.core.d.b.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + dc);
                if (dc && isAppStatusTargetNotEmpty) {
                    long obtainDefaultScanInterval = f.ayV.obtainDefaultScanInterval();
                    if (obtainDefaultScanInterval > 0) {
                        f.e(AnonymousClass2.this.jN, obtainDefaultScanInterval);
                    } else {
                        f.bA(AnonymousClass2.this.jN);
                    }
                }
                boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.ayV);
                boolean z = f.ayV.obtainUploadConfigFileMaxSize() > 0;
                com.kwad.sdk.core.d.b.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                if (isUploadTargetNotEmpty && z && dc) {
                    f.CF();
                    f.ayU.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                        RunnableC02311() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                com.kwad.sdk.collector.j.a(AnonymousClass2.this.jN, f.ayV);
                            } catch (Throwable th) {
                                com.kwad.sdk.service.b.gatherException(th);
                                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.collector.c.a
            public final void h(int i2, String str) {
                com.kwad.sdk.core.d.b.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i2);
            }
        }

        AnonymousClass2(Context context) {
            this.jN = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.collector.c.a(this.jN, new c.a() { // from class: com.kwad.sdk.utils.f.2.1

                /* renamed from: com.kwad.sdk.utils.f$2$1$1 */
                final class RunnableC02311 implements Runnable {
                    RunnableC02311() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.kwad.sdk.collector.j.a(AnonymousClass2.this.jN, f.ayV);
                        } catch (Throwable th) {
                            com.kwad.sdk.service.b.gatherException(th);
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }

                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.jN);
                    AppStatusRules unused = f.ayV = appStatusRules;
                    f.b(AnonymousClass2.this.jN, f.ayV);
                    f.by(AnonymousClass2.this.jN);
                    boolean dc = bd.dc(AnonymousClass2.this.jN);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.ayV);
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + dc);
                    if (dc && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = f.ayV.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            f.e(AnonymousClass2.this.jN, obtainDefaultScanInterval);
                        } else {
                            f.bA(AnonymousClass2.this.jN);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.ayV);
                    boolean z = f.ayV.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (isUploadTargetNotEmpty && z && dc) {
                        f.CF();
                        f.ayU.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            RunnableC02311() {
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.jN, f.ayV);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.b.gatherException(th);
                                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void h(int i2, String str) {
                    com.kwad.sdk.core.d.b.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i2);
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.utils.f$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ long aza;
        final /* synthetic */ Context jN;

        AnonymousClass3(Context context, long j2) {
            context = context;
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.bA(context);
            f.Uk.postDelayed(this, j2);
        }
    }

    /* renamed from: com.kwad.sdk.utils.f$4 */
    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context azb;
        final /* synthetic */ b azc;

        AnonymousClass4(Context context, b bVar) {
            context = context;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List bB;
            try {
                HashSet hashSet = new HashSet();
                if (!bd.dc(context) || (bB = f.bB(context)) == null) {
                    return;
                }
                Iterator it = bB.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                }
                hashSet.addAll(bB);
                if (bVar != null) {
                    bVar.l(new ArrayList(hashSet));
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                com.kwad.sdk.service.b.gatherException(th);
            }
        }
    }

    public static class a implements com.kwad.sdk.core.b {
        private String appName;
        private List<Long> azd = new ArrayList();
        private String packageName;

        public a() {
        }

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        private static List<a> A(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String b2 = com.kwad.sdk.collector.model.c.b(bVar);
                        if (hashMap.containsKey(b2)) {
                            aVar = (a) hashMap.get(b2);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            hashMap.put(b2, aVar2);
                            aVar = aVar2;
                        }
                        long c2 = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.af(c2);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            }
            return null;
        }

        private void af(long j2) {
            this.azd.add(Long.valueOf(j2));
        }

        @Nullable
        public static JSONArray z(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = A(list);
            } catch (Exception e2) {
                com.kwad.sdk.service.b.gatherException(e2);
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = list2.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            return jSONArray;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString(DBDefinition.PACKAGE_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.azd.clear();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        this.azd.add(Long.valueOf(optJSONArray.getLong(i2)));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "appName", this.appName);
            t.putValue(jSONObject, DBDefinition.PACKAGE_NAME, this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.azd.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            t.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    public interface b {
        void l(List<com.kwad.sdk.collector.model.b> list);
    }

    static class c extends Handler {

        /* renamed from: com.kwad.sdk.utils.f$c$1 */
        final class AnonymousClass1 implements com.kwad.sdk.core.c<a> {
            AnonymousClass1() {
            }

            private static a CO() {
                return new a();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ a tU() {
                return CO();
            }
        }

        /* renamed from: com.kwad.sdk.utils.f$c$2 */
        final class AnonymousClass2 implements com.kwad.sdk.core.c<AppStatusRules.Strategy> {
            AnonymousClass2() {
            }

            private static AppStatusRules.Strategy CP() {
                return new AppStatusRules.Strategy();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ AppStatusRules.Strategy tU() {
                return CP();
            }
        }

        public c(@NonNull Looper looper) {
            super(looper);
        }

        private static void B(List<a> list) {
            if (list == null) {
                return;
            }
            f.ayX.c(t.C(list));
        }

        private static void a(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray z;
            if (arrayList == null || (z = a.z(arrayList)) == null) {
                return;
            }
            f.ayX.c(z);
        }

        private void b(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = t.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.f.c.1
                            AnonymousClass1() {
                            }

                            private static a CO() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a tU() {
                                return CO();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable(MiConfigSingleton.t0);
                        list = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.b.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    a(arrayList);
                }
                if (list != null) {
                    B(list);
                }
            }
            if (f.ayW != null && f.ayW.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = t.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            AnonymousClass2() {
                            }

                            private static AppStatusRules.Strategy CP() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy tU() {
                                return CP();
                            }
                        });
                    }
                } else {
                    list2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (list2 != null) {
                    for (AppStatusRules.Strategy strategy : list2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) f.ayW.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (f.ayW == null || f.ahE == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.a.a.b((Context) f.ayW.get(), f.ahE);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                b(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }

    static class d implements b {
        private b azf = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.f.b
        public final void l(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray z = a.z(list);
            if (z != null) {
                f.ayX.c(z);
            }
            b bVar = this.azf;
            if (bVar != null) {
                bVar.l(list);
            }
        }
    }

    public static AppStatusRules CD() {
        return ayV;
    }

    public static boolean CE() {
        if (ayT == null) {
            try {
                ayT = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return ayT != null;
    }

    public static void CF() {
        if (ayU == null) {
            synchronized (f.class) {
                if (ayU == null) {
                    ExecutorService xT = GlobalThreadPools.xT();
                    ayU = xT;
                    com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) xT, "appStatusHelper");
                }
            }
        }
    }

    private static boolean CG() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            Context context = ServiceProvider.getContext();
            return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
        } catch (ClassNotFoundException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return false;
        }
    }

    @NonNull
    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        return !isNeedLaunch ? new ArrayList() : com.kwad.sdk.collector.b.tD().a(strategy);
    }

    public static void a(Context context, long j2, com.kwad.sdk.collector.h hVar) {
        if (at.Ef() || com.kwad.sdk.core.config.d.E(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || context == null || com.kwad.sdk.utils.c.bw(context)) {
            return;
        }
        ayX = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (isInMainProcess) {
            ayW = new WeakReference<>(context);
            if (Uk == null) {
                Uk = new Handler(Looper.getMainLooper());
            }
            Uk.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    public static void a(Context context, b bVar) {
        if (context == null || at.Ef() || com.kwad.sdk.core.config.d.E(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bw(context)) {
            return;
        }
        CF();
        ayU.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            final /* synthetic */ Context azb;
            final /* synthetic */ b azc;

            AnonymousClass4(Context context2, b bVar2) {
                context = context2;
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List bB;
                try {
                    HashSet hashSet = new HashSet();
                    if (!bd.dc(context) || (bB = f.bB(context)) == null) {
                        return;
                    }
                    Iterator it = bB.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.b.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(bB);
                    if (bVar != null) {
                        bVar.l(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    com.kwad.sdk.service.b.gatherException(th);
                }
            }
        });
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.g(file.getAbsolutePath(), com.kwad.sdk.core.kwai.c.bW(jSONObject), false);
    }

    public static void bA(Context context) {
        if (context == null) {
            return;
        }
        boolean CG = CG();
        com.kwad.sdk.core.d.b.d("AppStatusHelper", "isServiceAvailable: " + CG);
        if (CG) {
            com.kwad.sdk.collector.a.a.a(context, ahE);
        } else {
            a(context, new d(null));
        }
    }

    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> bB(Context context) {
        if (!bd.dc(context)) {
            return new ArrayList();
        }
        if (ayV == null) {
            ayV = bz(context);
        }
        return bC(context);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f9325j)
    private static List<com.kwad.sdk.collector.model.b> bC(Context context) {
        ArrayList arrayList = new ArrayList();
        if (at.Ef() || com.kwad.sdk.core.config.d.E(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bw(context)) {
            return arrayList;
        }
        AppStatusRules CD = CD();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(CD)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy d2 = com.kwad.sdk.collector.i.d(CD);
        arrayList.addAll(a(d2));
        d2.setNeedSaveLaunchTime(System.currentTimeMillis());
        return y(arrayList);
    }

    @WorkerThread
    public static void by(Context context) {
        if (ayV == null) {
            ayV = bz(context);
        }
    }

    @Nullable
    @WorkerThread
    private static AppStatusRules bz(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String D = com.kwad.sdk.crash.utils.h.D(file);
            if (TextUtils.isEmpty(D)) {
                return null;
            }
            if (com.kwad.sdk.core.kwai.c.bY(D)) {
                D = com.kwad.sdk.core.kwai.c.bX(D);
            }
            JSONObject jSONObject = new JSONObject(D);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e(Context context, long j2) {
        if (Uk == null) {
            Uk = new Handler(Looper.getMainLooper());
        }
        Uk.post(new Runnable() { // from class: com.kwad.sdk.utils.f.3
            final /* synthetic */ long aza;
            final /* synthetic */ Context jN;

            AnonymousClass3(Context context2, long j22) {
                context = context2;
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f.bA(context);
                f.Uk.postDelayed(this, j2);
            }
        });
    }

    private static List<com.kwad.sdk.collector.model.b> y(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }
}
