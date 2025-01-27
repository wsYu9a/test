package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class a {
    private final Map<String, String> ahl;
    private final com.kwad.sdk.core.network.idc.kwai.a ahm;
    private final Random ahn;
    private final Map<String, AtomicBoolean> aho;
    private Context mContext;

    /* renamed from: com.kwad.sdk.core.network.idc.a$1 */
    final class AnonymousClass1 extends aw {
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            a.this.ahl.putAll(b.aQ(context));
            a.this.wn();
            if (a.this.ahm.isEmpty()) {
                return;
            }
            Iterator<String> it = a.this.ahm.wq().iterator();
            while (it.hasNext()) {
                a.this.cf(it.next());
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.network.idc.a$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(a.this.mContext, a.this.ahm);
        }
    }

    /* renamed from: com.kwad.sdk.core.network.idc.a$3 */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(a.this.mContext, (Map<String, String>) a.this.ahl);
        }
    }

    /* renamed from: com.kwad.sdk.core.network.idc.a$a */
    static final class C0216a {
        private static final a ahq = new a((byte) 0);
    }

    private a() {
        this.ahl = new ConcurrentHashMap(8);
        this.ahm = new com.kwad.sdk.core.network.idc.kwai.a();
        this.ahn = new Random(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        this.aho = hashMap;
        hashMap.put("api", new AtomicBoolean(false));
        hashMap.put("ulog", new AtomicBoolean(false));
        hashMap.put("zt", new AtomicBoolean(false));
        hashMap.put("cdn", new AtomicBoolean(false));
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    @WorkerThread
    private void B(@NonNull String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> ci = this.ahm.ci(str2);
        if (ci.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.b.d("IdcManager", ">>> switchHost start, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.aho.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String cg = cg(str2);
                if ((TextUtils.isEmpty(cg) || host.equals(cg)) ? false : true) {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                } else {
                    int size = ci.size();
                    int indexOf = ci.indexOf(host);
                    boolean z = indexOf >= 0;
                    if (z) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int nextInt = this.ahn.nextInt(size) + 1;
                        if (z) {
                            nextInt += indexOf;
                        }
                        int size2 = nextInt % ci.size();
                        String str3 = ci.get(size2);
                        com.kwad.sdk.core.d.b.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + ci + ", key = " + size2);
                        D(str2, str3);
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                }
                sb.append(str2);
                sb.append(", old host = ");
                sb.append(host);
                com.kwad.sdk.core.d.b.d("IdcManager", sb.toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                com.kwad.sdk.core.d.b.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private void D(String str, String str2) {
        this.ahl.put(str, str2);
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.mContext, (Map<String, String>) a.this.ahl);
            }
        });
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }

    @WorkerThread
    public void cf(String str) {
        String cg = cg(str);
        List<String> ci = this.ahm.ci(str);
        if (ci.isEmpty()) {
            return;
        }
        String str2 = ci.get(0);
        if (!TextUtils.equals(str2, cg) && ag.eH(str2)) {
            D(str, str2);
        }
    }

    private String cg(String str) {
        return this.ahl.get(str);
    }

    public static a wm() {
        return C0216a.ahq;
    }

    @WorkerThread
    public void wn() {
        com.kwad.sdk.core.network.idc.kwai.a aP = b.aP(this.mContext);
        if (aP.isEmpty()) {
            aP = b.aO(this.mContext);
        }
        this.ahm.b(aP);
    }

    @Nullable
    public final String C(String str, String str2) {
        String str3 = this.ahl.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public final String E(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String cg = cg(str2);
        if (cg == null || cg.isEmpty()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getPath()) || cg.equals(parse.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(cg);
        builder.scheme(TextUtils.isEmpty(parse.getScheme()) ? b.b.a.b.b.f4198a : parse.getScheme());
        builder.path(parse.getPath());
        if (!TextUtils.isEmpty(parse.getQuery())) {
            builder.query(parse.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }

    public final void a(com.kwad.sdk.core.network.idc.kwai.a aVar) {
        this.ahm.b(aVar);
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.network.idc.a.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.a(a.this.mContext, a.this.ahm);
            }
        });
    }

    public final void a(String str, int i2, Throwable th) {
        a(str, "ulog", new DomainException(i2, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            B(str, str2);
        }
    }

    public final String ch(String str) {
        return E(str, "cdn");
    }

    public final void d(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public final void init(Context context) {
        this.mContext = context.getApplicationContext();
        g.execute(new aw() { // from class: com.kwad.sdk.core.network.idc.a.1
            final /* synthetic */ Context jN;

            AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                a.this.ahl.putAll(b.aQ(context));
                a.this.wn();
                if (a.this.ahm.isEmpty()) {
                    return;
                }
                Iterator<String> it = a.this.ahm.wq().iterator();
                while (it.hasNext()) {
                    a.this.cf(it.next());
                }
            }
        });
    }
}
