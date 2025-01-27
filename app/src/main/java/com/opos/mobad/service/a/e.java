package com.opos.mobad.service.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.i.a;
import com.opos.mobad.m.a.g;
import com.opos.mobad.m.a.h;
import com.opos.mobad.m.a.i;
import com.opos.mobad.m.a.j;
import com.opos.mobad.m.a.k;
import com.opos.mobad.m.a.l;
import com.opos.mobad.m.a.m;
import com.opos.mobad.m.a.n;
import com.opos.mobad.m.a.o;
import com.opos.mobad.m.a.p;
import com.opos.mobad.m.a.q;
import com.opos.mobad.m.a.r;
import com.opos.mobad.m.a.s;
import com.opos.mobad.m.a.t;
import com.opos.mobad.m.a.w;
import com.opos.mobad.m.a.x;
import com.opos.mobad.provider.strategy.PosInfo;
import com.opos.mobad.service.a.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public static final int f23503a = n.HORIZONTAL.a();

    /* renamed from: b */
    public static final int f23504b = n.VERTICAL.a();

    /* renamed from: c */
    private Context f23505c;

    /* renamed from: d */
    private int f23506d;

    /* renamed from: e */
    private String f23507e;

    /* renamed from: f */
    private String f23508f;

    /* renamed from: g */
    private int f23509g;

    /* renamed from: h */
    private com.opos.mobad.service.a.d f23510h;

    /* renamed from: i */
    private com.opos.cmn.i.a f23511i;
    private d m;
    private Bundle s;

    /* renamed from: j */
    private Integer f23512j = null;
    private volatile c k = new c();
    private AtomicReference<Map<String, f>> l = new AtomicReference<>(null);
    private AtomicBoolean n = new AtomicBoolean(false);
    private long o = 0;
    private Map<String, String> p = new ConcurrentHashMap();
    private Map<String, String> q = new ConcurrentHashMap();
    private Map<String, String> r = new ConcurrentHashMap();

    /* renamed from: com.opos.mobad.service.a.e$1 */
    class AnonymousClass1 implements d.a {

        /* renamed from: a */
        final /* synthetic */ a.InterfaceC0395a f23513a;

        AnonymousClass1(a.InterfaceC0395a interfaceC0395a) {
            interfaceC0395a = interfaceC0395a;
        }

        @Override // com.opos.mobad.service.a.d.a
        public void a() {
            com.opos.cmn.an.f.a.a("DispatchController", "read app info local fail");
            interfaceC0395a.b();
            e.this.a();
        }

        @Override // com.opos.mobad.service.a.d.a
        public void a(r rVar, long j2) {
            com.opos.cmn.an.f.a.a("DispatchController", "read app info local succ:", rVar);
            Long l = rVar.f21409j;
            e.this.a(rVar.f21405f, rVar.f21408i, j2, rVar.f21407h.longValue(), l != null ? l.longValue() : 0L, rVar.k, rVar.l);
            com.opos.mobad.service.c.b.a().a(e.this.v());
            if (e.this.k != null && e.this.k.a()) {
                e.this.b(interfaceC0395a);
            } else {
                com.opos.cmn.an.f.a.a("DispatchController", "do not need to refresh");
                interfaceC0395a.b();
            }
        }
    }

    /* renamed from: com.opos.mobad.service.a.e$2 */
    class AnonymousClass2 implements d.b {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.service.a.d.b
        public void a() {
            com.opos.cmn.an.f.a.a("DispatchController", "read strategy local fail");
        }

        @Override // com.opos.mobad.service.a.d.b
        public void a(Bundle bundle) {
            e.this.a(bundle);
        }
    }

    /* renamed from: com.opos.mobad.service.a.e$3 */
    class AnonymousClass3 implements a.b {
        AnonymousClass3() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            if (e.this.n.get() || !e.this.n.compareAndSet(false, true)) {
                e.this.b(interfaceC0395a);
            } else {
                e.this.a(interfaceC0395a);
            }
        }
    }

    /* renamed from: com.opos.mobad.service.a.e$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ a.InterfaceC0395a f23517a;

        AnonymousClass4(a.InterfaceC0395a interfaceC0395a) {
            interfaceC0395a = interfaceC0395a;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            com.opos.cmn.func.b.b.e a2;
            p.a c2 = new p.a().a(e.this.f23507e).b(e.this.f23508f).a(Integer.valueOf(e.this.f23506d)).b(Integer.valueOf(e.this.f23509g)).a(Long.valueOf(e.this.o)).c(e.this.f23505c.getPackageName());
            try {
                h b2 = new h.a().a(new g.a().b(com.opos.mobad.service.e.a.a().e()).a(com.opos.mobad.service.e.a.a().k()).c(com.opos.cmn.f.a.a(e.this.f23505c)).d(com.opos.mobad.service.e.a.a().f()).e(com.opos.mobad.service.e.a.a().g()).f(com.opos.mobad.service.e.a.a().h()).a(Boolean.valueOf(com.opos.mobad.service.e.a.a().j())).b(Boolean.valueOf(com.opos.mobad.service.e.a.a().d())).g(com.opos.mobad.service.e.a.a().l()).b()).a(new i.a().c(com.opos.cmn.an.b.c.c()).a(com.opos.cmn.an.b.d.b()).b(com.opos.cmn.an.b.d.a()).b()).b(com.opos.cmn.an.b.a.a(e.this.f23505c)).a(com.opos.cmn.an.b.c.a()).b();
                k b3 = new k.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().c())).b(com.opos.mobad.service.f.a.a().b()).a(com.opos.mobad.service.f.a.a().d()).b();
                x b4 = new x.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().e())).b(com.opos.mobad.service.f.a.a().g()).a(com.opos.mobad.service.f.a.a().f()).b();
                m b5 = new m.a().a(Integer.valueOf(com.opos.cmn.i.h.a(e.this.f23505c))).a(com.opos.cmn.i.h.b(e.this.f23505c)).b();
                t tVar = null;
                String c3 = com.opos.mobad.service.a.a().c();
                i2 = -1;
                if (!TextUtils.isEmpty(c3)) {
                    t.a a3 = new t.a().a(c3);
                    int d2 = com.opos.mobad.service.a.a().d();
                    a3.a(d2 != -1 ? d2 != 0 ? d2 != 1 ? w.UNKNOWN_STATUS : w.VIP : w.NORMAL : w.UNKNOWN_STATUS);
                    tVar = a3.b();
                    i2 = d2;
                }
                l.a a4 = new l.a().a(com.opos.cmn.a.a.b());
                try {
                    a4.b(com.opos.cmn.an.b.b.a());
                    a4.c(com.opos.cmn.an.b.b.b());
                } catch (Exception unused) {
                    com.opos.cmn.an.f.a.b("DispatchController", "local fail");
                }
                p b6 = c2.a(b2).a(b3).a(b4).a(b5).a(a4.b()).b(Long.valueOf(e.this.g())).a(tVar).b();
                com.opos.cmn.an.f.a.a("DispatchController", "refresh request", b6);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-protobuf");
                hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(e.this.f23505c));
                d.a b7 = new d.a().a(p.f21375c.b((com.heytap.nearx.a.a.e<p>) b6)).a(hashMap).b(e.this.y());
                b7.a("POST");
                a2 = com.opos.cmn.func.b.b.b.a().a(e.this.f23505c, b7.a());
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("", "", th);
            }
            if (a2 == null || 200 != a2.f17168a) {
                com.opos.cmn.an.f.a.a("DispatchController", "get dispatch fail code:", a2);
                interfaceC0395a.b();
                return;
            }
            q a5 = q.f21391c.a(a2.f17170c);
            if (a5 == null) {
                com.opos.cmn.an.f.a.a("DispatchController", "get dispatch parse fail");
                return;
            }
            com.opos.cmn.an.f.a.a("DispatchController", "response dispatch strategy:", a5);
            e.this.a(a5);
            e.this.f23512j = Integer.valueOf(i2);
            com.opos.mobad.service.c.b.a().a(e.this.v());
            interfaceC0395a.a();
        }
    }

    /* renamed from: com.opos.mobad.service.a.e$5 */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a */
        static final /* synthetic */ int[] f23519a;

        static {
            int[] iArr = new int[j.values().length];
            f23519a = iArr;
            try {
                iArr[j.BIDDING_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23519a[j.PERCENTAGE_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23519a[j.UNKNOWN_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23519a[j.RANKER_MODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class a {

        /* renamed from: a */
        public final int f23520a;

        /* renamed from: b */
        public final String f23521b;

        /* renamed from: c */
        public final long f23522c;

        /* renamed from: d */
        public final int f23523d;

        /* renamed from: e */
        public final int f23524e;

        /* renamed from: f */
        public final int f23525f;

        /* renamed from: g */
        public final int f23526g;

        public a(int i2, String str, int i3, long j2, int i4, int i5) {
            this(i2, str, i3, j2, i4, i5, 0);
        }

        public a(int i2, String str, int i3, long j2, int i4, int i5, int i6) {
            this.f23520a = i2;
            this.f23521b = str;
            this.f23522c = j2;
            this.f23523d = i4;
            this.f23524e = i5;
            this.f23525f = i3;
            this.f23526g = i6;
        }

        public String toString() {
            return "channel:" + this.f23520a + ",posId:" + this.f23521b + ",percnet:" + this.f23525f + ",timeout:" + this.f23522c;
        }
    }

    public static class b {

        /* renamed from: a */
        public final List<a> f23527a;

        /* renamed from: b */
        public final a f23528b;

        /* renamed from: c */
        public final long f23529c;

        /* renamed from: d */
        public final long f23530d;

        /* renamed from: e */
        public final int f23531e;

        public b(List<a> list, int i2, a aVar, long j2, long j3) {
            this.f23527a = list;
            this.f23528b = aVar;
            this.f23529c = j2;
            this.f23530d = j3;
            this.f23531e = i2;
        }

        public b(List<a> list, a aVar, long j2, long j3) {
            this(list, 2, aVar, j2, j3);
        }

        public String toString() {
            return "DispatchChannelStrategy{channelList=" + this.f23527a + ", baseChannel=" + this.f23528b + ", unionTimeout=" + this.f23529c + ", strategyVersion=" + this.f23530d + ", dispatch=" + this.f23531e + '}';
        }
    }

    private static class c {

        /* renamed from: a */
        private final Map<Integer, com.opos.mobad.m.a.e> f23532a;

        /* renamed from: b */
        private final com.opos.mobad.m.a.b f23533b;

        /* renamed from: c */
        private final long f23534c;

        /* renamed from: d */
        private final long f23535d;

        /* renamed from: e */
        private final long f23536e;

        /* renamed from: f */
        private final String f23537f;

        /* renamed from: g */
        private final Map<Integer, String> f23538g;

        public c() {
            this(null, null, Long.MIN_VALUE, Long.MIN_VALUE, 0L, "", null);
        }

        public c(List<com.opos.mobad.m.a.e> list, com.opos.mobad.m.a.b bVar, long j2, long j3, long j4, String str, List<o> list2) {
            this.f23532a = new HashMap();
            if (list != null && list.size() > 0) {
                for (com.opos.mobad.m.a.e eVar : list) {
                    if (e.b(eVar.f21275e)) {
                        this.f23532a.put(Integer.valueOf(eVar.f21275e.a()), eVar);
                    }
                }
            }
            this.f23533b = bVar;
            this.f23534c = j2;
            this.f23535d = j3;
            this.f23536e = j4;
            this.f23537f = str;
            this.f23538g = a(list2);
        }

        private Map<Integer, String> a(List<o> list) {
            Integer num;
            HashMap hashMap = new HashMap();
            if (list != null && list.size() > 0) {
                for (o oVar : list) {
                    if (oVar != null && !TextUtils.isEmpty(oVar.f21372f) && (num = oVar.f21371e) != null) {
                        hashMap.put(num, oVar.f21372f);
                    }
                }
            }
            return hashMap;
        }

        public boolean a() {
            com.opos.cmn.an.f.a.b("DispatchController", "current:" + System.currentTimeMillis() + ", exp:" + this.f23534c);
            return System.currentTimeMillis() >= this.f23534c;
        }

        public boolean b() {
            com.opos.cmn.an.f.a.b("DispatchController", "current:" + System.currentTimeMillis() + ", enable:" + this.f23535d);
            return System.currentTimeMillis() >= this.f23535d;
        }
    }

    public interface d {
        void a();
    }

    public void a(Bundle bundle) {
        com.opos.cmn.an.f.a.a("DispatchController", "read local strategy size:" + bundle.size());
        this.s = bundle;
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            PosInfo posInfo = (PosInfo) bundle.getParcelable(str);
            try {
                hashMap.put(str, new f(posInfo.f23163b, s.f21417c.a(posInfo.f23162a)));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("DispatchController", "decode local fail", e2);
            }
        }
        com.opos.cmn.an.f.a.b("DispatchController", "decode local strategy size:" + hashMap.size());
        if (this.l.compareAndSet(null, hashMap)) {
            com.opos.cmn.an.f.a.b("DispatchController", "local strategy size:" + hashMap.size());
            d dVar = this.m;
            if (dVar != null) {
                dVar.a();
            }
        }
        this.s = null;
    }

    public void a(a.InterfaceC0395a interfaceC0395a) {
        com.opos.cmn.an.f.a.a("DispatchController", "init from local");
        this.f23510h.a(new d.a() { // from class: com.opos.mobad.service.a.e.1

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23513a;

            AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                interfaceC0395a = interfaceC0395a2;
            }

            @Override // com.opos.mobad.service.a.d.a
            public void a() {
                com.opos.cmn.an.f.a.a("DispatchController", "read app info local fail");
                interfaceC0395a.b();
                e.this.a();
            }

            @Override // com.opos.mobad.service.a.d.a
            public void a(r rVar, long j2) {
                com.opos.cmn.an.f.a.a("DispatchController", "read app info local succ:", rVar);
                Long l = rVar.f21409j;
                e.this.a(rVar.f21405f, rVar.f21408i, j2, rVar.f21407h.longValue(), l != null ? l.longValue() : 0L, rVar.k, rVar.l);
                com.opos.mobad.service.c.b.a().a(e.this.v());
                if (e.this.k != null && e.this.k.a()) {
                    e.this.b(interfaceC0395a);
                } else {
                    com.opos.cmn.an.f.a.a("DispatchController", "do not need to refresh");
                    interfaceC0395a.b();
                }
            }
        });
        w();
    }

    public void a(q qVar) throws JSONException {
        String str;
        if (qVar.f21394f.intValue() != 0) {
            str = "response fail ret:" + qVar.f21394f + ",msg:" + qVar.f21395g;
        } else {
            r rVar = qVar.f21396h;
            if (rVar != null) {
                Long l = rVar.f21409j;
                long longValue = l != null ? l.longValue() : 0L;
                HashMap hashMap = new HashMap();
                for (s sVar : rVar.f21406g) {
                    hashMap.put(sVar.l, new f(longValue, sVar));
                }
                this.f23510h.a(rVar, qVar.f21397i.longValue());
                this.k = new c(rVar.f21405f, rVar.f21408i, qVar.f21397i.longValue(), rVar.f21407h.longValue(), longValue, rVar.k, rVar.l);
                a(hashMap);
                return;
            }
            str = "response data null";
        }
        com.opos.cmn.an.f.a.b("DispatchController", str);
    }

    public void a(List<com.opos.mobad.m.a.e> list, com.opos.mobad.m.a.b bVar, long j2, long j3, long j4, String str, List<o> list2) {
        this.k = new c(list, bVar, j2, j3, j4, str, list2);
        d dVar = this.m;
        if (dVar != null) {
            dVar.a();
        }
    }

    private void a(Map<String, f> map) {
        com.opos.cmn.an.f.a.b("DispatchController", "refresh strategy size:" + map.size());
        this.l.set(map);
        d dVar = this.m;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void b(a.InterfaceC0395a interfaceC0395a) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.service.a.e.4

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23517a;

            AnonymousClass4(a.InterfaceC0395a interfaceC0395a2) {
                interfaceC0395a = interfaceC0395a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                com.opos.cmn.func.b.b.e a2;
                p.a c2 = new p.a().a(e.this.f23507e).b(e.this.f23508f).a(Integer.valueOf(e.this.f23506d)).b(Integer.valueOf(e.this.f23509g)).a(Long.valueOf(e.this.o)).c(e.this.f23505c.getPackageName());
                try {
                    h b2 = new h.a().a(new g.a().b(com.opos.mobad.service.e.a.a().e()).a(com.opos.mobad.service.e.a.a().k()).c(com.opos.cmn.f.a.a(e.this.f23505c)).d(com.opos.mobad.service.e.a.a().f()).e(com.opos.mobad.service.e.a.a().g()).f(com.opos.mobad.service.e.a.a().h()).a(Boolean.valueOf(com.opos.mobad.service.e.a.a().j())).b(Boolean.valueOf(com.opos.mobad.service.e.a.a().d())).g(com.opos.mobad.service.e.a.a().l()).b()).a(new i.a().c(com.opos.cmn.an.b.c.c()).a(com.opos.cmn.an.b.d.b()).b(com.opos.cmn.an.b.d.a()).b()).b(com.opos.cmn.an.b.a.a(e.this.f23505c)).a(com.opos.cmn.an.b.c.a()).b();
                    k b3 = new k.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().c())).b(com.opos.mobad.service.f.a.a().b()).a(com.opos.mobad.service.f.a.a().d()).b();
                    x b4 = new x.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().e())).b(com.opos.mobad.service.f.a.a().g()).a(com.opos.mobad.service.f.a.a().f()).b();
                    m b5 = new m.a().a(Integer.valueOf(com.opos.cmn.i.h.a(e.this.f23505c))).a(com.opos.cmn.i.h.b(e.this.f23505c)).b();
                    t tVar = null;
                    String c3 = com.opos.mobad.service.a.a().c();
                    i2 = -1;
                    if (!TextUtils.isEmpty(c3)) {
                        t.a a3 = new t.a().a(c3);
                        int d2 = com.opos.mobad.service.a.a().d();
                        a3.a(d2 != -1 ? d2 != 0 ? d2 != 1 ? w.UNKNOWN_STATUS : w.VIP : w.NORMAL : w.UNKNOWN_STATUS);
                        tVar = a3.b();
                        i2 = d2;
                    }
                    l.a a4 = new l.a().a(com.opos.cmn.a.a.b());
                    try {
                        a4.b(com.opos.cmn.an.b.b.a());
                        a4.c(com.opos.cmn.an.b.b.b());
                    } catch (Exception unused) {
                        com.opos.cmn.an.f.a.b("DispatchController", "local fail");
                    }
                    p b6 = c2.a(b2).a(b3).a(b4).a(b5).a(a4.b()).b(Long.valueOf(e.this.g())).a(tVar).b();
                    com.opos.cmn.an.f.a.a("DispatchController", "refresh request", b6);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/x-protobuf");
                    hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(e.this.f23505c));
                    d.a b7 = new d.a().a(p.f21375c.b((com.heytap.nearx.a.a.e<p>) b6)).a(hashMap).b(e.this.y());
                    b7.a("POST");
                    a2 = com.opos.cmn.func.b.b.b.a().a(e.this.f23505c, b7.a());
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.a("", "", th);
                }
                if (a2 == null || 200 != a2.f17168a) {
                    com.opos.cmn.an.f.a.a("DispatchController", "get dispatch fail code:", a2);
                    interfaceC0395a.b();
                    return;
                }
                q a5 = q.f21391c.a(a2.f17170c);
                if (a5 == null) {
                    com.opos.cmn.an.f.a.a("DispatchController", "get dispatch parse fail");
                    return;
                }
                com.opos.cmn.an.f.a.a("DispatchController", "response dispatch strategy:", a5);
                e.this.a(a5);
                e.this.f23512j = Integer.valueOf(i2);
                com.opos.mobad.service.c.b.a().a(e.this.v());
                interfaceC0395a.a();
            }
        });
    }

    public static boolean b(com.opos.mobad.m.a.c cVar) {
        return cVar == com.opos.mobad.m.a.c.TT || cVar == com.opos.mobad.m.a.c.GDT || cVar == com.opos.mobad.m.a.c.UNION || cVar == com.opos.mobad.m.a.c.MIX || cVar == com.opos.mobad.m.a.c.FB || cVar == com.opos.mobad.m.a.c.GG || cVar == com.opos.mobad.m.a.c.JD;
    }

    private f c(String str) {
        Bundle bundle = this.s;
        if (bundle == null) {
            return null;
        }
        com.opos.cmn.an.f.a.b("DispatchController", "getCacheStrategy");
        PosInfo posInfo = (PosInfo) bundle.getParcelable(str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new f(posInfo.f23163b, s.f21417c.a(posInfo.f23162a));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("DispatchController", "decode pos fail" + str, e2);
            return null;
        }
    }

    private void w() {
        com.opos.cmn.an.f.a.b("DispatchController", "readStrategyFromLocal");
        this.f23510h.a(new d.b() { // from class: com.opos.mobad.service.a.e.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.service.a.d.b
            public void a() {
                com.opos.cmn.an.f.a.a("DispatchController", "read strategy local fail");
            }

            @Override // com.opos.mobad.service.a.d.b
            public void a(Bundle bundle) {
                e.this.a(bundle);
            }
        });
    }

    private void x() {
        this.f23511i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.a.e.3
            AnonymousClass3() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a) {
                if (e.this.n.get() || !e.this.n.compareAndSet(false, true)) {
                    e.this.b(interfaceC0395a);
                } else {
                    e.this.a(interfaceC0395a);
                }
            }
        }, 30000, 300000);
    }

    public String y() {
        return "https://uapi.ads.heytapmobi.com/union/strategy/v3/select";
    }

    private void z() {
        if (this.f23505c == null || !this.k.a() || this.f23511i == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("DispatchController", "refresh");
        this.f23511i.a();
    }

    public int a(String str) {
        f fVar;
        n nVar;
        f c2;
        Map<String, f> map = this.l.get();
        if (map != null ? (fVar = map.get(str)) == null || (nVar = fVar.f23539a.o) == null : (c2 = c(str)) == null || (nVar = c2.f23539a.o) == null) {
            nVar = n.HORIZONTAL;
        }
        return nVar.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00fb, code lost:
    
        if (r3 != 2) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x010a, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0108, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0106, code lost:
    
        if (r3.n.booleanValue() != false) goto L151;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.service.a.e.b a(java.lang.String r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.a.e.a(java.lang.String, boolean):com.opos.mobad.service.a.e$b");
    }

    public void a() {
        com.opos.cmn.i.a aVar;
        if (this.f23505c == null || (aVar = this.f23511i) == null) {
            return;
        }
        aVar.a();
    }

    public void a(Context context, String str, String str2, int i2, int i3, long j2) {
        this.f23505c = context;
        this.f23507e = str;
        this.f23508f = str2;
        this.f23506d = i2;
        this.f23509g = i3;
        this.o = j2;
        this.f23510h = new com.opos.mobad.service.a.d(context, str, str2);
        x();
        this.f23511i.a();
    }

    public void a(d dVar) {
        this.m = dVar;
    }

    public boolean a(int i2) {
        boolean b2 = i2 == 2 ? com.opos.mobad.service.a.c.a().b() : i2 == 3 ? com.opos.mobad.service.a.c.a().c() : i2 == 6 ? com.opos.mobad.service.a.c.a().e() : i2 == 7 ? com.opos.mobad.service.a.c.a().f() : i2 == 8 ? com.opos.mobad.service.a.c.a().g() : true;
        com.opos.cmn.an.f.a.b("DispatchController", "check enable:" + i2 + "," + b2);
        return b2;
    }

    public String b(int i2) {
        if (1 == i2) {
            return this.f23507e;
        }
        com.opos.mobad.m.a.e eVar = (com.opos.mobad.m.a.e) this.k.f23532a.get(Integer.valueOf(i2));
        if (eVar == null) {
            return null;
        }
        return eVar.f21276f;
    }

    public boolean b() {
        return this.k.b();
    }

    public boolean b(String str) {
        Boolean bool;
        Map<String, f> map = this.l.get();
        f c2 = map == null ? c(str) : map.get(str);
        if (c2 == null || (bool = c2.f23539a.u) == null) {
            bool = s.k;
        }
        return bool.booleanValue();
    }

    public String c(int i2) {
        com.opos.mobad.m.a.e eVar = (com.opos.mobad.m.a.e) this.k.f23532a.get(Integer.valueOf(i2));
        if (eVar == null) {
            return null;
        }
        return eVar.f21277g;
    }

    public boolean c() {
        if (this.k.f23533b == null || this.k.f23533b.o == null) {
            return false;
        }
        return this.k.f23533b.o.booleanValue();
    }

    public int d() {
        return ((this.k.f23533b == null || this.k.f23533b.p == null) ? com.opos.mobad.m.a.b.f21245e : this.k.f23533b.p).intValue();
    }

    public boolean e() {
        if (this.k.f23533b == null || this.k.f23533b.q == null) {
            return true;
        }
        return this.k.f23533b.q.booleanValue();
    }

    public boolean f() {
        if (this.k.f23533b == null || this.k.f23533b.r == null) {
            return true;
        }
        return this.k.f23533b.r.booleanValue();
    }

    public long g() {
        if (this.k != null) {
            return this.k.f23536e;
        }
        return 0L;
    }

    public String h() {
        return this.k != null ? this.k.f23537f : "";
    }

    public int i() {
        if (this.k.f23533b == null || this.k.f23533b.m == null) {
            return 30000;
        }
        return this.k.f23533b.m.f21236h.intValue();
    }

    public int j() {
        return ((this.k.f23533b == null || this.k.f23533b.m == null || this.k.f23533b.m.f21237i == null) ? com.opos.mobad.m.a.a.f21233e : this.k.f23533b.m.f21237i).intValue();
    }

    public int k() {
        if (this.k.f23533b == null || this.k.f23533b.n == null) {
            return 30000;
        }
        return this.k.f23533b.n.f21236h.intValue();
    }

    public int l() {
        return ((this.k.f23533b == null || this.k.f23533b.n == null || this.k.f23533b.n.f21237i == null) ? com.opos.mobad.m.a.a.f21233e : this.k.f23533b.n.f21237i).intValue();
    }

    public com.opos.mobad.service.a.a m() {
        return (this.k.f23533b == null || this.k.f23533b.n == null) ? new com.opos.mobad.service.a.a() : new com.opos.mobad.service.a.a(this.k.f23533b.n);
    }

    public int n() {
        if (this.k.f23533b == null || this.k.f23533b.f21248h == null) {
            return 30000;
        }
        return this.k.f23533b.f21248h.f21236h.intValue();
    }

    public int o() {
        return ((this.k.f23533b == null || this.k.f23533b.f21248h == null || this.k.f23533b.f21248h.f21237i == null) ? com.opos.mobad.m.a.a.f21233e : this.k.f23533b.f21248h.f21237i).intValue();
    }

    public int p() {
        if (this.k.f23533b == null || this.k.f23533b.f21249i == null) {
            return 30000;
        }
        return this.k.f23533b.f21249i.f21236h.intValue();
    }

    public int q() {
        if (this.k.f23533b == null || this.k.f23533b.f21250j == null) {
            return 30000;
        }
        return this.k.f23533b.f21250j.f21236h.intValue();
    }

    public int r() {
        return ((this.k.f23533b == null || this.k.f23533b.f21250j == null || this.k.f23533b.f21250j.f21237i == null) ? com.opos.mobad.m.a.a.f21233e : this.k.f23533b.f21250j.f21237i).intValue();
    }

    public int s() {
        if (this.k.f23533b == null || this.k.f23533b.k == null) {
            return 30000;
        }
        return this.k.f23533b.k.f21236h.intValue();
    }

    public int t() {
        return ((this.k.f23533b == null || this.k.f23533b.k == null || this.k.f23533b.k.f21237i == null) ? com.opos.mobad.m.a.a.f21233e : this.k.f23533b.k.f21237i).intValue();
    }

    public int u() {
        if (this.k.f23533b == null || this.k.f23533b.l == null) {
            return 30000;
        }
        return this.k.f23533b.l.f21236h.intValue();
    }

    public Map<Integer, String> v() {
        if (this.k == null) {
            return null;
        }
        return this.k.f23538g;
    }
}
