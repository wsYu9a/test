package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    public static final String TAG = "c";
    private static int aEY;
    private static int aEZ;
    private static int aFa;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> aFb = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> aFc = new ConcurrentHashMap<>();
    private static long interval;
    private static long startTime;

    /* renamed from: com.kwad.sdk.core.threads.c$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String aFd;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            d eG;
            int i10;
            if (TextUtils.isEmpty(str) || (eG = c.eG(str)) == null || (i10 = eG.aEZ) == 0) {
                return;
            }
            int unused = c.aEZ = i10;
            if (Math.random() * c.aEZ >= 1.0d) {
                return;
            }
            c.a(eG);
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.c$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ Handler aFe;

        public AnonymousClass2(Handler handler) {
            handler = handler;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ExecutorService eF;
            for (String str : GlobalThreadPools.Hu()) {
                if (str != null && !c.aFc.containsValue(str) && (eF = GlobalThreadPools.eF(str)) != null && (eF instanceof ThreadPoolExecutor) && !c.aFb.containsKey(eF)) {
                    c.a((ThreadPoolExecutor) eF, str);
                }
            }
            int i10 = 0;
            for (ThreadPoolExecutor threadPoolExecutor : c.aFc.keySet()) {
                String str2 = (String) c.aFc.get(threadPoolExecutor);
                i10 += threadPoolExecutor.getPoolSize();
                b b10 = c.b(threadPoolExecutor, str2);
                if (b10 != null) {
                    com.kwad.sdk.commercial.b.r(b10);
                }
            }
            b bVar = new b();
            bVar.aEO = "total";
            bVar.aER = i10;
            com.kwad.sdk.commercial.b.r(bVar);
            c.HA();
            if (c.aEY < c.aFa) {
                handler.postDelayed(this, c.interval);
            }
        }
    }

    public static /* synthetic */ int HA() {
        int i10 = aEY;
        aEY = i10 + 1;
        return i10;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        aFb.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        aFc.put(threadPoolExecutor, str);
    }

    public static void cO(String str) {
        h.execute(new bd() { // from class: com.kwad.sdk.core.threads.c.1
            final /* synthetic */ String aFd;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                d eG;
                int i10;
                if (TextUtils.isEmpty(str) || (eG = c.eG(str)) == null || (i10 = eG.aEZ) == 0) {
                    return;
                }
                int unused = c.aEZ = i10;
                if (Math.random() * c.aEZ >= 1.0d) {
                    return;
                }
                c.a(eG);
            }
        });
    }

    public static d eG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        b bVar = new b();
        bVar.aEO = str;
        bVar.aEP = threadPoolExecutor.getCorePoolSize();
        bVar.aEQ = threadPoolExecutor.getMaximumPoolSize();
        bVar.aER = threadPoolExecutor.getPoolSize();
        bVar.aES = threadPoolExecutor.getActiveCount();
        bVar.aEV = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = aFb;
        long longValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.aEU = completedTaskCount - longValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.a.c) {
            bVar.aET = ((com.kwad.sdk.core.threads.a.c) threadPoolExecutor).HE();
        } else {
            bVar.aET = 0L;
        }
        bVar.aEW = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.aEX = aEZ;
        return bVar;
    }

    public static void a(d dVar) {
        com.kwad.sdk.core.threads.a.b.aFg = true;
        com.kwad.sdk.core.threads.a.a.aFg = true;
        interval = dVar.interval;
        aFa = dVar.aFf;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new bd() { // from class: com.kwad.sdk.core.threads.c.2
            final /* synthetic */ Handler aFe;

            public AnonymousClass2(Handler handler2) {
                handler = handler2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ExecutorService eF;
                for (String str : GlobalThreadPools.Hu()) {
                    if (str != null && !c.aFc.containsValue(str) && (eF = GlobalThreadPools.eF(str)) != null && (eF instanceof ThreadPoolExecutor) && !c.aFb.containsKey(eF)) {
                        c.a((ThreadPoolExecutor) eF, str);
                    }
                }
                int i10 = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.aFc.keySet()) {
                    String str2 = (String) c.aFc.get(threadPoolExecutor);
                    i10 += threadPoolExecutor.getPoolSize();
                    b b10 = c.b(threadPoolExecutor, str2);
                    if (b10 != null) {
                        com.kwad.sdk.commercial.b.r(b10);
                    }
                }
                b bVar = new b();
                bVar.aEO = "total";
                bVar.aER = i10;
                com.kwad.sdk.commercial.b.r(bVar);
                c.HA();
                if (c.aEY < c.aFa) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }
}
