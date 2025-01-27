package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c {
    public static final String TAG = "c";
    private static int amC;
    private static int amD;
    private static int amE;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> amF = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> amG = new ConcurrentHashMap<>();
    private static long interval;
    private static long startTime;

    /* renamed from: com.kwad.sdk.core.threads.c$1 */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ String amH;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            d cM;
            int i2;
            if (TextUtils.isEmpty(str) || (cM = c.cM(str)) == null || (i2 = cM.amD) == 0) {
                return;
            }
            int unused = c.amD = i2;
            double random = Math.random();
            double d2 = c.amD;
            Double.isNaN(d2);
            if (random * d2 >= 1.0d) {
                return;
            }
            c.a(cM);
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.c$2 */
    static class AnonymousClass2 extends aw {
        final /* synthetic */ Handler amI;

        AnonymousClass2(Handler handler) {
            handler = handler;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            ExecutorService cK;
            for (String str : GlobalThreadPools.xW()) {
                if (str != null && !c.amG.containsValue(str) && (cK = GlobalThreadPools.cK(str)) != null && (cK instanceof ThreadPoolExecutor) && !c.amF.containsKey(cK)) {
                    c.a((ThreadPoolExecutor) cK, str);
                }
            }
            int i2 = 0;
            for (ThreadPoolExecutor threadPoolExecutor : c.amG.keySet()) {
                String str2 = (String) c.amG.get(threadPoolExecutor);
                i2 += threadPoolExecutor.getPoolSize();
                b b2 = c.b(threadPoolExecutor, str2);
                if (b2 != null) {
                    KSLoggerReporter.z(b2.toJson());
                }
            }
            b bVar = new b();
            bVar.ams = "total";
            bVar.amv = i2;
            KSLoggerReporter.z(bVar.toJson());
            c.yc();
            if (c.amC < c.amE) {
                handler.postDelayed(this, c.interval);
            }
        }
    }

    public static void a(d dVar) {
        com.kwad.sdk.core.threads.kwai.b.amK = true;
        com.kwad.sdk.core.threads.kwai.a.amK = true;
        interval = dVar.interval;
        amE = dVar.amJ;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new aw() { // from class: com.kwad.sdk.core.threads.c.2
            final /* synthetic */ Handler amI;

            AnonymousClass2(Handler handler2) {
                handler = handler2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                ExecutorService cK;
                for (String str : GlobalThreadPools.xW()) {
                    if (str != null && !c.amG.containsValue(str) && (cK = GlobalThreadPools.cK(str)) != null && (cK instanceof ThreadPoolExecutor) && !c.amF.containsKey(cK)) {
                        c.a((ThreadPoolExecutor) cK, str);
                    }
                }
                int i2 = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.amG.keySet()) {
                    String str2 = (String) c.amG.get(threadPoolExecutor);
                    i2 += threadPoolExecutor.getPoolSize();
                    b b2 = c.b(threadPoolExecutor, str2);
                    if (b2 != null) {
                        KSLoggerReporter.z(b2.toJson());
                    }
                }
                b bVar = new b();
                bVar.ams = "total";
                bVar.amv = i2;
                KSLoggerReporter.z(bVar.toJson());
                c.yc();
                if (c.amC < c.amE) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        amF.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        amG.put(threadPoolExecutor, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        b bVar = new b();
        bVar.ams = str;
        bVar.amt = threadPoolExecutor.getCorePoolSize();
        bVar.amu = threadPoolExecutor.getMaximumPoolSize();
        bVar.amv = threadPoolExecutor.getPoolSize();
        bVar.amw = threadPoolExecutor.getActiveCount();
        bVar.amz = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = amF;
        long longValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.amy = completedTaskCount - longValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.kwai.c) {
            bVar.amx = ((com.kwad.sdk.core.threads.kwai.c) threadPoolExecutor).yg();
        } else {
            bVar.amx = 0L;
        }
        bVar.amA = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.amB = amD;
        return bVar;
    }

    public static void cL(String str) {
        g.execute(new aw() { // from class: com.kwad.sdk.core.threads.c.1
            final /* synthetic */ String amH;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                d cM;
                int i2;
                if (TextUtils.isEmpty(str) || (cM = c.cM(str)) == null || (i2 = cM.amD) == 0) {
                    return;
                }
                int unused = c.amD = i2;
                double random = Math.random();
                double d2 = c.amD;
                Double.isNaN(d2);
                if (random * d2 >= 1.0d) {
                    return;
                }
                c.a(cM);
            }
        });
    }

    public static d cM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e2) {
            com.kwai.sodler.lib.a.w(TAG, e2.toString());
            return null;
        }
    }

    static /* synthetic */ int yc() {
        int i2 = amC;
        amC = i2 + 1;
        return i2;
    }
}
