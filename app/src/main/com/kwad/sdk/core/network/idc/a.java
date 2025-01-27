package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bd;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class a {
    private static final int aAH;
    private final Map<String, String> aAC;
    private final com.kwad.sdk.core.network.idc.a.b aAD;
    private final Random aAE;
    private final Map<String, AtomicBoolean> aAF;
    private final Map<String, com.kwad.sdk.core.network.idc.a.a> aAG;
    private volatile int aAI;
    private volatile boolean aAJ;
    private Context mContext;

    /* renamed from: com.kwad.sdk.core.network.idc.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.aAC.putAll(b.bs(context));
            a.this.FA();
            if (!a.this.aAD.isEmpty()) {
                Iterator<String> it = a.this.aAD.FG().iterator();
                while (it.hasNext()) {
                    a.this.ee(it.next());
                }
            }
            c.d("IdcManager", "idc prepare done.");
            a.a(a.this, false);
        }
    }

    /* renamed from: com.kwad.sdk.core.network.idc.a$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.a(a.this.mContext, a.this.aAD);
        }
    }

    /* renamed from: com.kwad.sdk.core.network.idc.a$3 */
    public class AnonymousClass3 extends bd {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.a(a.this.mContext, (Map<String, String>) a.this.aAC);
        }
    }

    /* renamed from: com.kwad.sdk.core.network.idc.a$4 */
    public class AnonymousClass4 extends d {
        final /* synthetic */ String aAL;

        public AnonymousClass4(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
        public final void buildBaseBody() {
        }

        @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
        public final void buildBaseHeader() {
        }

        @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
        public final String getUrl() {
            return h.bZ("https://" + str);
        }
    }

    /* renamed from: com.kwad.sdk.core.network.idc.a$a */
    public static final class C0498a {
        private static final a aAM = new a((byte) 0);
    }

    static {
        aAH = com.kwad.framework.a.a.ns.booleanValue() ? 0 : 60000;
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    @WorkerThread
    public void FA() {
        com.kwad.sdk.core.network.idc.a.b br = b.br(this.mContext);
        if (br.isEmpty()) {
            br = b.bq(this.mContext);
        }
        this.aAD.a(br);
    }

    public static a Fz() {
        return C0498a.aAM;
    }

    @WorkerThread
    private void V(@NonNull String str, String str2) {
        String host;
        StringBuilder sb2;
        List<String> eh2 = this.aAD.eh(str2);
        if (eh2.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        c.d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.aAF.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String ef2 = ef(str2);
                if (TextUtils.isEmpty(ef2) || host.equals(ef2)) {
                    int size = eh2.size();
                    int indexOf = eh2.indexOf(host);
                    boolean z10 = indexOf >= 0;
                    if (z10) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb2 = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int nextInt = this.aAE.nextInt(size) + 1;
                        if (z10) {
                            nextInt += indexOf;
                        }
                        int size2 = nextInt % eh2.size();
                        String str3 = eh2.get(size2);
                        c.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + eh2 + ", key = " + size2);
                        X(str2, str3);
                        if (p(str2, size2)) {
                            ec(str2);
                        }
                        atomicBoolean.set(false);
                        sb2 = new StringBuilder("<<< switchHost end, type = ");
                    }
                } else {
                    atomicBoolean.set(false);
                    sb2 = new StringBuilder("<<< switchHost end, type = ");
                }
                sb2.append(str2);
                sb2.append(", old host = ");
                sb2.append(host);
                c.d("IdcManager", sb2.toString());
            } catch (Throwable th2) {
                atomicBoolean.set(false);
                c.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th2;
            }
        }
    }

    private void X(String str, String str2) {
        c.d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.aAC.put(str, str2);
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.core.network.idc.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.a(a.this.mContext, (Map<String, String>) a.this.aAC);
            }
        });
    }

    private void ec(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        c.d("IdcManager", "save switched host, type = " + str);
        this.aAG.put(str, new com.kwad.sdk.core.network.idc.a.a(elapsedRealtime, false));
    }

    @WorkerThread
    public boolean ee(String str) {
        boolean gR;
        String ef2 = ef(str);
        List<String> eh2 = this.aAD.eh(str);
        if (eh2.isEmpty()) {
            return false;
        }
        String str2 = eh2.get(0);
        if (TextUtils.equals(str2, ef2)) {
            return true;
        }
        if ("api".equals(str)) {
            gR = c(com.kwad.framework.a.a.ns.booleanValue() ? "beta2-ad-open-api.test.gifshow.com" : str2, this.mContext);
        } else {
            gR = al.gR(str2);
        }
        c.d("IdcManager", "perform ping action for " + str + ",mainHost = " + str2 + ",isSuccess = " + gR);
        if (gR) {
            X(str, str2);
        }
        return gR;
    }

    private String ef(String str) {
        return this.aAC.get(str);
    }

    private boolean p(String str, int i10) {
        return "api".equals(str) && i10 > 0 && !this.aAG.containsKey(str) && this.aAI > 0;
    }

    public final boolean FB() {
        return !this.aAG.isEmpty();
    }

    @Nullable
    public final String W(String str, String str2) {
        String str3 = this.aAC.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String Y(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String ef2 = ef(str2);
        if (ef2 == null || ef2.isEmpty()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getPath())) {
            return str;
        }
        if (ef2.equals(parse.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(ef2);
        if (TextUtils.isEmpty(parse.getScheme())) {
            builder.scheme("https");
        } else {
            builder.scheme(parse.getScheme());
        }
        builder.path(parse.getPath());
        if (!TextUtils.isEmpty(parse.getQuery())) {
            builder.query(parse.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }

    public final void ed(String str) {
        int i10 = this.aAI;
        if (this.aAJ || i10 <= 0) {
            c.d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.aAJ + ",rollbackInterval = " + i10);
            return;
        }
        com.kwad.sdk.core.network.idc.a.a aVar = this.aAG.get(str);
        if (aVar != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - aVar.FE();
            boolean z10 = elapsedRealtime > ((long) Math.max(i10, aAH));
            c.d("IdcManager", "handleHostRollback: isAvailable = " + z10 + ",interval = " + elapsedRealtime + ",rollbackInterval = " + i10 + ",hostType = hostType");
            if (z10) {
                AtomicBoolean atomicBoolean = this.aAF.get(str);
                try {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        try {
                            boolean FD = aVar.FD();
                            c.d("IdcManager", "handleHostRollback: isInRollback = " + FD);
                            if (!FD) {
                                aVar.bn(true);
                                if (ee(str)) {
                                    this.aAG.remove(str);
                                    c.d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                                } else {
                                    c.d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                    ec(str);
                                }
                            }
                            atomicBoolean.set(false);
                            c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                        } catch (Exception e10) {
                            c.e("IdcManager", "handleHostRollback failed by " + e10.getMessage());
                            atomicBoolean.set(false);
                            c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                        }
                    }
                } catch (Throwable th2) {
                    atomicBoolean.set(false);
                    c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                    throw th2;
                }
            }
        }
    }

    public final String eg(String str) {
        return Y(str, "cdn");
    }

    public final void g(String str, Throwable th2) {
        a(str, "cdn", new DomainException(th2));
    }

    public final void init(Context context) {
        this.mContext = context.getApplicationContext();
        this.aAJ = true;
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.core.network.idc.a.1
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.aAC.putAll(b.bs(context));
                a.this.FA();
                if (!a.this.aAD.isEmpty()) {
                    Iterator<String> it = a.this.aAD.FG().iterator();
                    while (it.hasNext()) {
                        a.this.ee(it.next());
                    }
                }
                c.d("IdcManager", "idc prepare done.");
                a.a(a.this, false);
            }
        });
    }

    private a() {
        this.aAC = new ConcurrentHashMap(8);
        this.aAD = new com.kwad.sdk.core.network.idc.a.b();
        this.aAE = new Random(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        this.aAF = hashMap;
        this.aAG = new ConcurrentHashMap(4);
        this.aAI = 0;
        this.aAJ = false;
        hashMap.put("api", new AtomicBoolean(false));
        hashMap.put("ulog", new AtomicBoolean(false));
        hashMap.put("zt", new AtomicBoolean(false));
        hashMap.put("cdn", new AtomicBoolean(false));
    }

    @WorkerThread
    private static boolean c(String str, Context context) {
        boolean isNetworkConnected = al.isNetworkConnected(context);
        c.d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + isNetworkConnected);
        if (isNetworkConnected && str != null) {
            AdHttpProxy zc2 = g.zc();
            AnonymousClass4 anonymousClass4 = new d() { // from class: com.kwad.sdk.core.network.idc.a.4
                final /* synthetic */ String aAL;

                public AnonymousClass4(String str2) {
                    str = str2;
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseHeader() {
                }

                @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return h.bZ("https://" + str);
                }
            };
            com.kwad.sdk.core.network.c doGet = zc2.doGet(anonymousClass4.getUrl(), Collections.emptyMap());
            c.d("IdcManager", "perform connect host:" + anonymousClass4.getUrl());
            if (doGet != null) {
                c.d("IdcManager", "connect host response, rawCode = " + doGet.azs + ",body = " + doGet.azu);
                if (doGet.azs == 200) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.aAJ = false;
        return false;
    }

    public final void a(com.kwad.sdk.core.network.idc.a.b bVar, int i10) {
        this.aAI = i10 * 1000;
        c.d("IdcManager", "updateIdcData,rollback interval = " + i10);
        if (i10 == 0) {
            this.aAG.clear();
        }
        this.aAD.a(bVar);
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.core.network.idc.a.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.a(a.this.mContext, a.this.aAD);
            }
        });
    }

    public final void a(String str, int i10, Throwable th2) {
        a(str, "ulog", new DomainException(i10, th2));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            V(str, str2);
        }
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }
}
