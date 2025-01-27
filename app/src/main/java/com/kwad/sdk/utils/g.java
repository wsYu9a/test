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

/* loaded from: classes3.dex */
public class g {
    private static ServiceConnection aBd = new ServiceConnection() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!g.ME()) {
                    com.kwad.sdk.core.d.c.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = g.aSx;
                try {
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                com.kwad.sdk.service.c.gatherException(e10);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private static com.kwad.sdk.collector.h aSA;
    private static Messenger aSx;
    private static volatile ExecutorService aSy;
    private static volatile AppStatusRules aSz;
    private static Handler abi;
    private static WeakReference<Context> abo;

    /* renamed from: com.kwad.sdk.utils.g$1 */
    public class AnonymousClass1 implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (!g.ME()) {
                    com.kwad.sdk.core.d.c.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                obtain.replyTo = g.aSx;
                try {
                    messenger.send(obtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                com.kwad.sdk.service.c.gatherException(e10);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.kwad.sdk.utils.g$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ Context hB;

        /* renamed from: com.kwad.sdk.utils.g$2$1 */
        public class AnonymousClass1 implements c.a {

            /* renamed from: com.kwad.sdk.utils.g$2$1$1 */
            public class RunnableC05171 implements Runnable {
                public RunnableC05171() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.kwad.sdk.collector.j.a(AnonymousClass2.this.hB, g.aSz);
                    } catch (Throwable th2) {
                        com.kwad.sdk.service.c.gatherException(th2);
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.collector.c.a
            public final void b(AppStatusRules appStatusRules) {
                appStatusRules.initStatus(AnonymousClass2.this.hB);
                AppStatusRules unused = g.aSz = appStatusRules;
                g.b(AnonymousClass2.this.hB, g.aSz);
                g.bY(AnonymousClass2.this.hB);
                boolean dC = bo.dC(AnonymousClass2.this.hB);
                boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(g.aSz);
                com.kwad.sdk.core.d.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + dC);
                if (dC && isAppStatusTargetNotEmpty) {
                    long obtainDefaultScanInterval = g.aSz.obtainDefaultScanInterval();
                    if (obtainDefaultScanInterval > 0) {
                        g.c(AnonymousClass2.this.hB, obtainDefaultScanInterval);
                    } else {
                        g.ca(AnonymousClass2.this.hB);
                    }
                }
                boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(g.aSz);
                boolean z10 = g.aSz.obtainUploadConfigFileMaxSize() > 0;
                com.kwad.sdk.core.d.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z10);
                if (isUploadTargetNotEmpty && z10 && dC) {
                    g.MF();
                    g.aSy.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.2.1.1
                        public RunnableC05171() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                com.kwad.sdk.collector.j.a(AnonymousClass2.this.hB, g.aSz);
                            } catch (Throwable th2) {
                                com.kwad.sdk.service.c.gatherException(th2);
                                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.collector.c.a
            public final void s(int i10, String str) {
                com.kwad.sdk.core.d.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i10);
            }
        }

        public AnonymousClass2(Context context) {
            this.hB = context;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.collector.c.a(this.hB, new c.a() { // from class: com.kwad.sdk.utils.g.2.1

                /* renamed from: com.kwad.sdk.utils.g$2$1$1 */
                public class RunnableC05171 implements Runnable {
                    public RunnableC05171() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.kwad.sdk.collector.j.a(AnonymousClass2.this.hB, g.aSz);
                        } catch (Throwable th2) {
                            com.kwad.sdk.service.c.gatherException(th2);
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                        }
                    }
                }

                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.hB);
                    AppStatusRules unused = g.aSz = appStatusRules;
                    g.b(AnonymousClass2.this.hB, g.aSz);
                    g.bY(AnonymousClass2.this.hB);
                    boolean dC = bo.dC(AnonymousClass2.this.hB);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(g.aSz);
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + dC);
                    if (dC && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = g.aSz.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            g.c(AnonymousClass2.this.hB, obtainDefaultScanInterval);
                        } else {
                            g.ca(AnonymousClass2.this.hB);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(g.aSz);
                    boolean z10 = g.aSz.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z10);
                    if (isUploadTargetNotEmpty && z10 && dC) {
                        g.MF();
                        g.aSy.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.2.1.1
                            public RunnableC05171() {
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.hB, g.aSz);
                                } catch (Throwable th2) {
                                    com.kwad.sdk.service.c.gatherException(th2);
                                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void s(int i10, String str) {
                    com.kwad.sdk.core.d.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i10);
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.utils.g$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ long aSD;
        final /* synthetic */ Context hB;

        public AnonymousClass3(Context context, long j10) {
            context = context;
            j10 = j10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            g.ca(context);
            g.abi.postDelayed(this, j10);
        }
    }

    /* renamed from: com.kwad.sdk.utils.g$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context aSE;
        final /* synthetic */ b aSF;

        public AnonymousClass4(Context context, b bVar) {
            context = context;
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List cb2;
            try {
                HashSet hashSet = new HashSet();
                if (!bo.dC(context) || (cb2 = g.cb(context)) == null) {
                    return;
                }
                Iterator it = cb2.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                }
                hashSet.addAll(cb2);
                if (bVar != null) {
                    bVar.u(new ArrayList(hashSet));
                }
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                com.kwad.sdk.service.c.gatherException(th2);
            }
        }
    }

    public interface b {
        void u(List<com.kwad.sdk.collector.model.b> list);
    }

    public static class c extends Handler {

        /* renamed from: com.kwad.sdk.utils.g$c$1 */
        public class AnonymousClass1 implements com.kwad.sdk.core.c<a> {
            public AnonymousClass1() {
            }

            private static a MP() {
                return new a();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ a Ct() {
                return MP();
            }
        }

        /* renamed from: com.kwad.sdk.utils.g$c$2 */
        public class AnonymousClass2 implements com.kwad.sdk.core.c<AppStatusRules.Strategy> {
            public AnonymousClass2() {
            }

            private static AppStatusRules.Strategy MQ() {
                return new AppStatusRules.Strategy();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ AppStatusRules.Strategy Ct() {
                return MQ();
            }
        }

        public c(@NonNull Looper looper) {
            super(looper);
        }

        private static void M(List<a> list) {
            if (list == null) {
                return;
            }
            g.aSA.c(x.N(list));
        }

        private static void b(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray K;
            if (arrayList == null || (K = a.K(arrayList)) == null) {
                return;
            }
            g.aSA.c(K);
        }

        private void c(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> list2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = x.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.g.c.1
                            public AnonymousClass1() {
                            }

                            private static a MP() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a Ct() {
                                return MP();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable(h3.e.f26408m);
                        list = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    b(arrayList);
                }
                if (list != null) {
                    M(list);
                }
            }
            if (g.abo != null && g.abo.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        list2 = x.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.g.c.2
                            public AnonymousClass2() {
                            }

                            private static AppStatusRules.Strategy MQ() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy Ct() {
                                return MQ();
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
                            com.kwad.sdk.collector.i.a((Context) g.abo.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (g.abo == null || g.aBd == null) {
                return;
            }
            com.kwad.sdk.core.d.c.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.b.a.b((Context) g.abo.get(), g.aBd);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                c(message);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
    }

    public static class d implements b {
        private b aSI = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.g.b
        public final void u(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray K = a.K(list);
            if (K != null) {
                g.aSA.c(K);
            }
            b bVar = this.aSI;
            if (bVar != null) {
                bVar.u(list);
            }
        }
    }

    private static List<com.kwad.sdk.collector.model.b> J(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static AppStatusRules MD() {
        return aSz;
    }

    public static boolean ME() {
        if (aSx == null) {
            try {
                aSx = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return aSx != null;
    }

    public static void MF() {
        if (aSy == null) {
            synchronized (g.class) {
                try {
                    if (aSy == null) {
                        ExecutorService Hr = GlobalThreadPools.Hr();
                        aSy = Hr;
                        com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) Hr, "appStatusHelper");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private static boolean MG() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            Context context = ServiceProvider.getContext();
            return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
        } catch (ClassNotFoundException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return false;
        }
    }

    public static void a(Context context, long j10, com.kwad.sdk.collector.h hVar) {
        if (az.Ol() || com.kwad.sdk.core.config.d.ac(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || context == null || com.kwad.sdk.utils.d.bW(context)) {
            return;
        }
        aSA = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (isInMainProcess) {
            abo = new WeakReference<>(context);
            if (abi == null) {
                abi = new Handler(Looper.getMainLooper());
            }
            abi.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.k(file.getAbsolutePath(), com.kwad.sdk.core.a.c.dT(jSONObject), false);
    }

    @WorkerThread
    public static void bY(Context context) {
        if (aSz == null) {
            aSz = bZ(context);
        }
    }

    @Nullable
    @WorkerThread
    private static AppStatusRules bZ(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String J = com.kwad.sdk.crash.utils.h.J(file);
            if (TextUtils.isEmpty(J)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.dV(J)) {
                J = com.kwad.sdk.core.a.c.dU(J);
            }
            JSONObject jSONObject = new JSONObject(J);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ca(Context context) {
        if (context == null) {
            return;
        }
        boolean MG = MG();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isServiceAvailable: " + MG);
        if (MG) {
            com.kwad.sdk.collector.b.a.a(context, aBd);
        } else {
            a(context, new d(null));
        }
    }

    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> cb(Context context) {
        if (!bo.dC(context)) {
            return new ArrayList();
        }
        if (aSz == null) {
            aSz = bZ(context);
        }
        return cc(context);
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    private static List<com.kwad.sdk.collector.model.b> cc(Context context) {
        ArrayList arrayList = new ArrayList();
        if (az.Ol() || com.kwad.sdk.core.config.d.ac(PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            return arrayList;
        }
        if (com.kwad.sdk.utils.d.bW(context)) {
            return arrayList;
        }
        AppStatusRules MD = MD();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(MD)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy d10 = com.kwad.sdk.collector.i.d(MD);
        arrayList.addAll(a(d10));
        d10.setNeedSaveLaunchTime(System.currentTimeMillis());
        return J(arrayList);
    }

    public static void c(Context context, long j10) {
        if (abi == null) {
            abi = new Handler(Looper.getMainLooper());
        }
        abi.post(new bd() { // from class: com.kwad.sdk.utils.g.3
            final /* synthetic */ long aSD;
            final /* synthetic */ Context hB;

            public AnonymousClass3(Context context2, long j102) {
                context = context2;
                j10 = j102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                g.ca(context);
                g.abi.postDelayed(this, j10);
            }
        });
    }

    public static class a implements com.kwad.sdk.core.b {
        private List<Long> aSG = new ArrayList();
        private String appName;
        private String packageName;

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        public static JSONArray K(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = L(list);
            } catch (Exception e10) {
                com.kwad.sdk.service.c.gatherException(e10);
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

        @Nullable
        private static List<a> L(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String b10 = com.kwad.sdk.collector.model.c.b(bVar);
                        if (hashMap.containsKey(b10)) {
                            aVar = (a) hashMap.get(b10);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            hashMap.put(b10, aVar2);
                            aVar = aVar2;
                        }
                        long c10 = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.aN(c10);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e10) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                }
            }
            return null;
        }

        private void aN(long j10) {
            this.aSG.add(Long.valueOf(j10));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.aSG.clear();
                int length = optJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    try {
                        this.aSG.add(Long.valueOf(optJSONArray.getLong(i10)));
                    } catch (JSONException e10) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            x.putValue(jSONObject, "appName", this.appName);
            x.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.aSG.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            x.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public a() {
        }
    }

    public static void a(Context context, b bVar) {
        if (context == null || az.Ol() || com.kwad.sdk.core.config.d.ac(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.d.bW(context)) {
            return;
        }
        MF();
        aSy.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.4
            final /* synthetic */ Context aSE;
            final /* synthetic */ b aSF;

            public AnonymousClass4(Context context2, b bVar2) {
                context = context2;
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List cb2;
                try {
                    HashSet hashSet = new HashSet();
                    if (!bo.dC(context) || (cb2 = g.cb(context)) == null) {
                        return;
                    }
                    Iterator it = cb2.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(cb2);
                    if (bVar != null) {
                        bVar.u(new ArrayList(hashSet));
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    com.kwad.sdk.service.c.gatherException(th2);
                }
            }
        });
    }

    @NonNull
    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        if (!isNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.BS().a(strategy);
    }
}
