package com.opos.mobad.service.a;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.m.a.r;
import com.opos.mobad.m.a.s;
import com.opos.mobad.provider.strategy.AppInfo;
import com.opos.mobad.provider.strategy.StrategyInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private String f23493a;

    /* renamed from: b */
    private String f23494b;

    /* renamed from: c */
    private com.opos.mobad.provider.strategy.b f23495c;

    /* renamed from: com.opos.mobad.service.a.d$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ a f23496a;

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AppInfo b2 = d.this.f23495c.b(d.this.f23493a);
                if (b2 == null) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                    }
                } else {
                    r a2 = r.f21402c.a(b2.f23161b);
                    long j2 = b2.f23160a;
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(a2, j2);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("DispatchController", "readAppInfo fail", e2);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.service.a.d$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ b f23498a;

        AnonymousClass2(b bVar) {
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle a2 = d.this.f23495c.a(d.this.f23493a);
                if (a2 == null) {
                    com.opos.cmn.an.f.a.b("DispatchController", "readPosStrategy fail with strategyInfo null");
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.a();
                    }
                } else {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(a2);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("DispatchController", "readPosStrategy fail", e2);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a();
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.service.a.d$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ r f23500a;

        /* renamed from: b */
        final /* synthetic */ long f23501b;

        AnonymousClass3(r rVar, long j2) {
            rVar = rVar;
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(rVar.c().a(new ArrayList(0)).b(), j2);
            Long l = rVar.f21409j;
            d.this.a(rVar.f21406g, l != null ? l.longValue() : 0L);
        }
    }

    public interface a {
        void a();

        void a(r rVar, long j2);
    }

    public interface b {
        void a();

        void a(Bundle bundle);
    }

    public d(Context context, String str, String str2) {
        this.f23493a = str;
        this.f23494b = str2;
        this.f23495c = new com.opos.mobad.provider.strategy.b(context.getApplicationContext());
    }

    public void a(List<s> list, long j2) {
        com.opos.cmn.an.f.a.b("DispatchController", "write strategy:", list);
        try {
            Bundle bundle = new Bundle();
            for (s sVar : list) {
                bundle.putByteArray(sVar.l, s.f21417c.b((com.heytap.nearx.a.a.e<s>) sVar));
            }
            this.f23495c.a(this.f23493a, new StrategyInfo(j2, bundle));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("DispatchController", "write strategy fail", e2);
        }
    }

    public void b(r rVar, long j2) {
        com.opos.cmn.an.f.a.b("DispatchController", "write app:" + rVar);
        try {
            this.f23495c.a(this.f23494b, this.f23493a, new AppInfo(j2, r.f21402c.b((com.heytap.nearx.a.a.e<r>) rVar)));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("DispatchController", "write app fail", e2);
        }
    }

    public void a(r rVar, long j2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.d.3

            /* renamed from: a */
            final /* synthetic */ r f23500a;

            /* renamed from: b */
            final /* synthetic */ long f23501b;

            AnonymousClass3(r rVar2, long j22) {
                rVar = rVar2;
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.b(rVar.c().a(new ArrayList(0)).b(), j2);
                Long l = rVar.f21409j;
                d.this.a(rVar.f21406g, l != null ? l.longValue() : 0L);
            }
        });
    }

    public void a(a aVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.d.1

            /* renamed from: a */
            final /* synthetic */ a f23496a;

            AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppInfo b2 = d.this.f23495c.b(d.this.f23493a);
                    if (b2 == null) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                    } else {
                        r a2 = r.f21402c.a(b2.f23161b);
                        long j2 = b2.f23160a;
                        a aVar22 = aVar;
                        if (aVar22 != null) {
                            aVar22.a(a2, j2);
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("DispatchController", "readAppInfo fail", e2);
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a();
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.d.2

            /* renamed from: a */
            final /* synthetic */ b f23498a;

            AnonymousClass2(b bVar2) {
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle a2 = d.this.f23495c.a(d.this.f23493a);
                    if (a2 == null) {
                        com.opos.cmn.an.f.a.b("DispatchController", "readPosStrategy fail with strategyInfo null");
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a();
                        }
                    } else {
                        b bVar22 = bVar;
                        if (bVar22 != null) {
                            bVar22.a(a2);
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("DispatchController", "readPosStrategy fail", e2);
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.a();
                    }
                }
            }
        });
    }
}
