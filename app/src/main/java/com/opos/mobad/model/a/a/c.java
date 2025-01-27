package com.opos.mobad.model.a.a;

import android.content.Context;
import com.opos.mobad.model.b.f;
import com.opos.mobad.model.b.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class c implements com.opos.mobad.model.a.c {

    /* renamed from: a */
    private Context f21477a;

    /* renamed from: com.opos.mobad.model.a.a.c$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.i.a f21478a;

        /* renamed from: b */
        final /* synthetic */ g f21479b;

        /* renamed from: c */
        final /* synthetic */ String f21480c;

        /* renamed from: d */
        final /* synthetic */ CountDownLatch f21481d;

        AnonymousClass1(com.opos.mobad.i.a aVar, g gVar, String str, CountDownLatch countDownLatch) {
            aVar = aVar;
            gVar = gVar;
            str = str;
            countDownLatch = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    gVar.a(str, com.opos.mobad.i.c.a(c.this.f21477a, aVar));
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("FetchMaterialEngine", "", (Throwable) e2);
                }
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    public c(Context context) {
        this.f21477a = context.getApplicationContext();
    }

    private void a(g gVar, CountDownLatch countDownLatch, String str, com.opos.mobad.i.a aVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.a.c.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.i.a f21478a;

            /* renamed from: b */
            final /* synthetic */ g f21479b;

            /* renamed from: c */
            final /* synthetic */ String f21480c;

            /* renamed from: d */
            final /* synthetic */ CountDownLatch f21481d;

            AnonymousClass1(com.opos.mobad.i.a aVar2, g gVar2, String str2, CountDownLatch countDownLatch2) {
                aVar = aVar2;
                gVar = gVar2;
                str = str2;
                countDownLatch = countDownLatch2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        gVar.a(str, com.opos.mobad.i.c.a(c.this.f21477a, aVar));
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("FetchMaterialEngine", "", (Throwable) e2);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
    }

    @Override // com.opos.mobad.model.a.c
    public g a(f fVar) {
        g gVar = null;
        if (fVar == null) {
            return null;
        }
        try {
            ConcurrentHashMap<String, com.opos.mobad.i.a> a2 = fVar.a();
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            g gVar2 = new g();
            try {
                CountDownLatch countDownLatch = new CountDownLatch(a2.size());
                for (Map.Entry<String, com.opos.mobad.i.a> entry : a2.entrySet()) {
                    if (entry != null) {
                        a(gVar2, countDownLatch, entry.getKey(), entry.getValue());
                    } else {
                        countDownLatch.countDown();
                    }
                }
                countDownLatch.await(30L, TimeUnit.MINUTES);
                return gVar2;
            } catch (Exception e2) {
                e = e2;
                gVar = gVar2;
                com.opos.cmn.an.f.a.c("FetchMaterialEngine", "fetchMaterial", e);
                return gVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
