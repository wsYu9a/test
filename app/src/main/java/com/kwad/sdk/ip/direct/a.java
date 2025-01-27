package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.service.kwai.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class a {
    private static c atB = null;
    private static HandlerThread atC = null;
    private static Handler atD = null;
    private static int ats = -1;
    private static volatile boolean att;
    private static List<HttpDnsInfo.IpInfo> atu = new ArrayList();
    private static List<HttpDnsInfo.IpInfo> atv = new ArrayList();
    private static List<HttpDnsInfo.IpInfo> atw = new ArrayList();
    private static List<c> atx = new ArrayList();
    private static List<c> aty = new ArrayList();
    private static PriorityBlockingQueue<c> atz = new PriorityBlockingQueue<>();
    private static AtomicInteger atA = new AtomicInteger(0);
    private static volatile boolean atE = false;
    private static float atF = -1.0f;
    private static float atG = -1.0f;
    private static float atH = -1.0f;
    private static int atI = 0;
    private static volatile boolean atJ = false;
    private static volatile boolean atK = false;
    private static NetworkMonitor.a atL = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.atK) {
                a.access$002(true);
            } else {
                a.access$102(true);
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            }
        }
    };
    private static Runnable atM = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.AH();
        }
    };

    /* renamed from: com.kwad.sdk.ip.direct.a$1 */
    static class AnonymousClass1 implements NetworkMonitor.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.atK) {
                a.access$002(true);
            } else {
                a.access$102(true);
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.a$2 */
    static class AnonymousClass2 extends Handler {
        AnonymousClass2(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                a.AH();
                a.AI();
            } else {
                if (i2 != 2) {
                    return;
                }
                a.AQ();
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.a$3 */
    static class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.AH();
        }
    }

    private static void AC() {
        Handler handler;
        if (atE || (handler = atD) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String AD() {
        c cVar = atB;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float AE() {
        return atF;
    }

    public static float AF() {
        return atG;
    }

    public static float AG() {
        return atH;
    }

    public static void AH() {
        AM();
        List<HttpDnsInfo.IpInfo> list = atu;
        List<HttpDnsInfo.IpInfo> list2 = atv;
        clear();
        if (atE) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "start pick");
        atE = true;
        w(list);
        x(list2);
        if (atx.isEmpty() && aty.isEmpty()) {
            f fVar = (f) ServiceProvider.get(f.class);
            if (fVar == null) {
                atE = false;
                return;
            } else {
                if (!fVar.sI()) {
                    com.kwad.sdk.core.d.b.d("IpDirect_Helper", "isIpPreferEnable:false");
                    atE = false;
                    return;
                }
                AK();
            }
        }
        atE = false;
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "end pick");
    }

    public static void AI() {
        if (AJ()) {
            return;
        }
        AL();
    }

    private static boolean AJ() {
        List<c> list = atx;
        List<c> list2 = aty;
        if (!list.isEmpty()) {
            atB = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "set from recommend:" + atB);
            atI = 1;
            return true;
        }
        int i2 = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        Iterator<c> it = list2.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getWeight();
        }
        int nextInt = random.nextInt(i3);
        int i4 = 0;
        while (true) {
            if (i4 >= list2.size()) {
                break;
            }
            nextInt -= list2.get(i4).getWeight();
            if (nextInt < 0) {
                i2 = i4;
                break;
            }
            i4++;
        }
        atB = list2.get(i2);
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "set from backUp:" + atB);
        atI = 2;
        return true;
    }

    private static void AK() {
        List<HttpDnsInfo.IpInfo> list = atw;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c f2 = b.f(ipInfo.ip, ats);
                if (f2.isSuccess()) {
                    atz.offer(f2);
                }
            }
        }
        c peek = atz.peek();
        if (peek != null) {
            atH = peek.AY();
        }
    }

    private static void AL() {
        if (atz.isEmpty()) {
            return;
        }
        c peek = atz.peek();
        if (peek.AY() < ats) {
            atB = peek;
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "set from Other:" + atB);
            atI = 3;
        }
    }

    private static void AM() {
        if (ats == -1) {
            f fVar = (f) ServiceProvider.get(f.class);
            if (fVar != null) {
                ats = fVar.sJ();
            } else {
                ats = 200;
            }
        }
    }

    private static boolean AN() {
        if (atJ) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i2 = atA.get();
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "value:" + i2);
        return i2 <= 3;
    }

    private static void AO() {
        atA.getAndIncrement();
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "addFailedTimes:" + atA.intValue());
    }

    public static void AP() {
        c cVar;
        Handler handler;
        if (!att || (cVar = atB) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = atD) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void AQ() {
        AO();
        AR();
        AS();
        atI = 0;
        AI();
        AH();
    }

    private static void AR() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        c cVar = atB;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = atu.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                ipInfo2 = null;
                break;
            }
            ipInfo2 = it.next();
            if (ipInfo2 != null && TextUtils.equals(ip, ipInfo2.ip)) {
                break;
            }
        }
        if (ipInfo2 != null) {
            atu.remove(ipInfo2);
            ipInfo2 = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = atv.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next = it2.next();
            if (next != null && TextUtils.equals(ip, next.ip)) {
                ipInfo2 = next;
                break;
            }
        }
        if (ipInfo2 != null) {
            atv.remove(ipInfo2);
        } else {
            ipInfo = ipInfo2;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = atw.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it3.next();
            if (next2 != null && TextUtils.equals(ip, next2.ip)) {
                ipInfo = next2;
                break;
            }
        }
        if (ipInfo != null) {
            atw.remove(ipInfo);
        }
    }

    private static void AS() {
        c cVar;
        if (atB == null) {
            return;
        }
        List<c> list = atx;
        if (list != null && !list.isEmpty() && atx.contains(atB)) {
            atx.remove(atB);
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sRecommendEntityList remove:" + atB);
        }
        List<c> list2 = aty;
        if (list2 != null && !list2.isEmpty()) {
            if (aty.contains(atB)) {
                aty.remove(atB);
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + atB);
            }
            Iterator<c> it = aty.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (cVar != null && TextUtils.equals(cVar.getIp(), atB.getIp())) {
                    com.kwad.sdk.core.d.b.d("IpDirect_Helper", "set removeEntity:" + cVar.getIp());
                    break;
                }
            }
            if (cVar != null) {
                aty.remove(cVar);
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + cVar);
            }
        }
        c peek = atz.peek();
        if (peek != null && peek == atB) {
            atz.poll();
        }
        atB = null;
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean sH = fVar.sH();
        att = sH;
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", "isEnable:" + sH);
        if (sH) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            atu = list;
            atv = httpDnsInfo.backUpList;
            atw = httpDnsInfo.otherList;
            if (list.isEmpty() && atv.isEmpty() && atw.isEmpty()) {
                com.kwad.sdk.core.d.b.w("IpDirect_Helper", "HttpDnsInfo is empty");
            } else {
                init();
                AC();
            }
        }
    }

    static /* synthetic */ boolean access$002(boolean z) {
        atK = true;
        return true;
    }

    static /* synthetic */ boolean access$102(boolean z) {
        atJ = true;
        return true;
    }

    private static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", ipInfo.toString());
                c f2 = b.f(ipInfo.ip, ats);
                f2.bI(ipInfo.weight);
                if (f2.isSuccess() && f2.AY() < ats) {
                    list2.add(f2);
                }
            }
        }
    }

    private static void clear() {
        atx.clear();
        aty.clear();
        atz.clear();
    }

    @Nullable
    public static String ea(String str) {
        String str2;
        if (!att) {
            str2 = "getIpByHost return by sIpDirectEnable false";
        } else if (eb(str)) {
            str2 = "isHostInvalid:false ：" + str;
        } else {
            if (AN()) {
                String AD = AD();
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "getIpByHost ip:" + AD);
                return AD;
            }
            str2 = "canUseIpDirect:false";
        }
        com.kwad.sdk.core.d.b.d("IpDirect_Helper", str2);
        return "";
    }

    private static boolean eb(String str) {
        boolean z = !TextUtils.equals("https://" + str, com.kwad.sdk.c.sb());
        if (z) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.c.sb() + "try direct host:https://" + str);
        }
        return z;
    }

    public static int getType() {
        return atI;
    }

    private static void init() {
        if (atC != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        atC = handlerThread;
        handlerThread.start();
        atD = new Handler(atC.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            AnonymousClass2(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    a.AH();
                    a.AI();
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    a.AQ();
                }
            }
        };
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            NetworkMonitor.getInstance().a(eVar.getContext(), atL);
        }
    }

    private static void w(List<HttpDnsInfo.IpInfo> list) {
        b(list, atx);
        if (atx.isEmpty()) {
            return;
        }
        Iterator<c> it = atx.iterator();
        float f2 = 0.0f;
        while (it.hasNext()) {
            f2 += it.next().AY();
        }
        atF = f2 / atx.size();
    }

    private static void x(List<HttpDnsInfo.IpInfo> list) {
        b(list, aty);
        if (aty.isEmpty()) {
            return;
        }
        int i2 = 0;
        float f2 = 0.0f;
        for (c cVar : aty) {
            i2 += cVar.getWeight();
            f2 += cVar.getWeight() * cVar.AY();
        }
        if (i2 != 0) {
            atG = f2 / i2;
        }
    }
}
