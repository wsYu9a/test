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
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class a {
    private static int aMD = -1;
    private static volatile boolean aME;
    private static c aMM;
    private static HandlerThread aMN;
    private static Handler aMO;
    private static List<HttpDnsInfo.IpInfo> aMF = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aMG = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aMH = new CopyOnWriteArrayList();
    private static List<c> aMI = new CopyOnWriteArrayList();
    private static List<c> aMJ = new CopyOnWriteArrayList();
    private static PriorityBlockingQueue<c> aMK = new PriorityBlockingQueue<>();
    private static AtomicInteger aML = new AtomicInteger(0);
    private static volatile boolean aMP = false;
    private static float aMQ = -1.0f;
    private static float aMR = -1.0f;
    private static float aMS = -1.0f;
    private static int aMT = 0;
    private static volatile boolean aMU = false;
    private static volatile boolean aMV = false;
    private static NetworkMonitor.a aMW = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.aMV) {
                a.access$002(true);
            } else {
                a.access$102(true);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            }
        }
    };
    private static Runnable aMX = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.Kp();
        }
    };

    /* renamed from: com.kwad.sdk.ip.direct.a$1 */
    public class AnonymousClass1 implements NetworkMonitor.a {
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.aMV) {
                a.access$002(true);
            } else {
                a.access$102(true);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.a$2 */
    public class AnonymousClass2 extends Handler {
        public AnonymousClass2(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                a.Kp();
                a.Kq();
            } else {
                if (i10 != 2) {
                    return;
                }
                a.Ky();
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.a$3 */
    public class AnonymousClass3 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            a.Kp();
        }
    }

    private static void F(List<HttpDnsInfo.IpInfo> list) {
        b(list, aMI);
        if (aMI.isEmpty()) {
            return;
        }
        Iterator<c> it = aMI.iterator();
        float f10 = 0.0f;
        while (it.hasNext()) {
            f10 += it.next().KG();
        }
        aMQ = f10 / aMI.size();
    }

    private static void G(List<HttpDnsInfo.IpInfo> list) {
        b(list, aMJ);
        if (aMJ.isEmpty()) {
            return;
        }
        int i10 = 0;
        float f10 = 0.0f;
        for (c cVar : aMJ) {
            if (cVar != null) {
                i10 += cVar.getWeight();
                f10 += cVar.getWeight() * cVar.KG();
            }
        }
        if (i10 != 0) {
            aMR = f10 / i10;
        }
    }

    private static void KA() {
        c cVar;
        if (aMM == null) {
            return;
        }
        List<c> list = aMI;
        if (list != null && !list.isEmpty() && aMI.contains(aMM)) {
            aMI.remove(aMM);
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + aMM);
        }
        List<c> list2 = aMJ;
        if (list2 != null && !list2.isEmpty()) {
            if (aMJ.contains(aMM)) {
                aMJ.remove(aMM);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aMM);
            }
            Iterator<c> it = aMJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (cVar != null && TextUtils.equals(cVar.getIp(), aMM.getIp())) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set removeEntity:" + cVar.getIp());
                    break;
                }
            }
            if (cVar != null) {
                aMJ.remove(cVar);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + cVar);
            }
        }
        c peek = aMK.peek();
        if (peek != null && peek == aMM) {
            aMK.poll();
        }
        aMM = null;
    }

    private static void Kk() {
        Handler handler;
        if (aMP || (handler = aMO) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String Kl() {
        c cVar = aMM;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float Km() {
        return aMQ;
    }

    public static float Kn() {
        return aMR;
    }

    public static float Ko() {
        return aMS;
    }

    public static void Kp() {
        Ku();
        List<HttpDnsInfo.IpInfo> list = aMF;
        List<HttpDnsInfo.IpInfo> list2 = aMG;
        clear();
        if (aMP) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "start pick");
        aMP = true;
        F(list);
        G(list2);
        if (aMI.isEmpty() && aMJ.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                aMP = false;
                return;
            } else {
                if (!hVar.zX()) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                    aMP = false;
                    return;
                }
                Ks();
            }
        }
        aMP = false;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "end pick");
    }

    public static void Kq() {
        if (Kr()) {
            return;
        }
        Kt();
    }

    private static boolean Kr() {
        List<c> list = aMI;
        List<c> list2 = aMJ;
        if (!list.isEmpty()) {
            aMM = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from recommend:" + aMM);
            aMT = 1;
            return true;
        }
        int i10 = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int i11 = 0;
        for (c cVar : list2) {
            if (cVar != null) {
                i11 += cVar.getWeight();
            }
        }
        if (i11 <= 0) {
            return false;
        }
        int nextInt = random.nextInt(i11);
        int i12 = 0;
        while (true) {
            if (i12 >= list2.size()) {
                break;
            }
            if (list2.get(i12) != null) {
                nextInt -= list2.get(i12).getWeight();
            }
            if (nextInt < 0) {
                i10 = i12;
                break;
            }
            i12++;
        }
        aMM = list2.get(i10);
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from backUp:" + aMM);
        aMT = 2;
        return true;
    }

    private static void Ks() {
        List<HttpDnsInfo.IpInfo> list = aMH;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c f10 = b.f(ipInfo.ip, aMD);
                if (f10.isSuccess()) {
                    aMK.offer(f10);
                }
            }
        }
        c peek = aMK.peek();
        if (peek != null) {
            aMS = peek.KG();
        }
    }

    private static void Kt() {
        if (aMK.isEmpty()) {
            return;
        }
        c peek = aMK.peek();
        if (peek.KG() < aMD) {
            aMM = peek;
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from Other:" + aMM);
            aMT = 3;
        }
    }

    private static void Ku() {
        if (aMD == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                aMD = hVar.zY();
            } else {
                aMD = 200;
            }
        }
    }

    private static boolean Kv() {
        if (aMU) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i10 = aML.get();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "value:" + i10);
        return i10 <= 3;
    }

    private static void Kw() {
        aML.getAndIncrement();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "addFailedTimes:" + aML.intValue());
    }

    public static void Kx() {
        c cVar;
        Handler handler;
        if (!aME || (cVar = aMM) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = aMO) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void Ky() {
        Kw();
        Kz();
        KA();
        aMT = 0;
        Kq();
        Kp();
    }

    private static void Kz() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        c cVar = aMM;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = aMF.iterator();
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
            aMF.remove(ipInfo2);
            ipInfo2 = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = aMG.iterator();
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
            aMG.remove(ipInfo2);
        } else {
            ipInfo = ipInfo2;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = aMH.iterator();
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
            aMH.remove(ipInfo);
        }
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean zW = hVar.zW();
        aME = zW;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isEnable:" + zW);
        if (zW) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            aMF = list;
            aMG = httpDnsInfo.backUpList;
            aMH = httpDnsInfo.otherList;
            if (list.isEmpty() && aMG.isEmpty() && aMH.isEmpty()) {
                com.kwad.sdk.core.d.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
            } else {
                init();
                Kk();
            }
        }
    }

    public static /* synthetic */ boolean access$002(boolean z10) {
        aMV = true;
        return true;
    }

    public static /* synthetic */ boolean access$102(boolean z10) {
        aMU = true;
        return true;
    }

    private static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", ipInfo.toString());
                c f10 = b.f(ipInfo.ip, aMD);
                f10.dF(ipInfo.weight);
                if (f10.isSuccess() && f10.KG() < aMD) {
                    list2.add(f10);
                }
            }
        }
    }

    private static void clear() {
        aMI.clear();
        aMJ.clear();
        aMK.clear();
    }

    @Nullable
    public static String gb(String str) {
        if (!aME) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        }
        if (gc(str)) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isHostInvalid:false ：" + str);
            return "";
        }
        if (!Kv()) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        }
        String Kl = Kl();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost ip:" + Kl);
        return Kl;
    }

    private static boolean gc(String str) {
        boolean z10 = !TextUtils.equals("https://" + str, com.kwad.sdk.h.ze());
        if (z10) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.h.ze() + "try direct host:https://" + str);
        }
        return z10;
    }

    public static int getType() {
        return aMT;
    }

    private static void init() {
        if (aMN != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        aMN = handlerThread;
        handlerThread.start();
        aMO = new Handler(aMN.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            public AnonymousClass2(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i10 = message.what;
                if (i10 == 1) {
                    a.Kp();
                    a.Kq();
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    a.Ky();
                }
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), aMW);
        }
    }
}
