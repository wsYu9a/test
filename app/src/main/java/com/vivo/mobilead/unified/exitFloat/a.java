package com.vivo.mobilead.unified.exitFloat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.mobilead.i.m;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.y0;
import com.vivo.mobilead.util.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class a extends com.vivo.mobilead.unified.a {
    private volatile AtomicLong A;
    private com.vivo.mobilead.unified.exitFloat.b B;
    private com.vivo.mobilead.unified.exitFloat.d t;
    private List<com.vivo.mobilead.unified.exitFloat.c> u;
    private volatile AtomicBoolean v;
    private String w;
    private long x;
    private long y;
    private List<com.vivo.ad.model.b> z;

    /* renamed from: com.vivo.mobilead.unified.exitFloat.a$a */
    class C0639a extends com.vivo.mobilead.util.f1.b {
        C0639a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            a.this.t.onAdFailed(new VivoAdError(402137, "广告不可用，请重新请求"));
        }
    }

    class b implements DialogInterface.OnDismissListener {

        /* renamed from: com.vivo.mobilead.unified.exitFloat.a$b$a */
        class C0640a extends com.vivo.mobilead.util.f1.b {
            C0640a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                a.this.t.onAdClose();
            }
        }

        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            k0.a((List<com.vivo.ad.model.b>) a.this.z, "4", 17, ((com.vivo.mobilead.unified.a) a.this).f29668h, ((com.vivo.mobilead.unified.a) a.this).o);
            com.vivo.mobilead.unified.exitFloat.e.c().b();
            z.b().a(new C0640a());
        }
    }

    private static class d implements Callable {

        /* renamed from: a */
        private Semaphore f30269a;

        /* renamed from: b */
        private List<com.vivo.ad.model.b> f30270b;

        /* renamed from: c */
        private List<com.vivo.mobilead.unified.exitFloat.c> f30271c;

        /* renamed from: d */
        private long f30272d;

        /* renamed from: e */
        private CountDownLatch f30273e;

        public d(Semaphore semaphore, List<com.vivo.ad.model.b> list, List<com.vivo.mobilead.unified.exitFloat.c> list2, long j2, CountDownLatch countDownLatch) {
            this.f30269a = semaphore;
            this.f30270b = list;
            this.f30271c = list2;
            this.f30272d = j2;
            this.f30273e = countDownLatch;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            for (int i2 = 0; i2 < this.f30270b.size(); i2++) {
                com.vivo.ad.model.b bVar = this.f30270b.get(i2);
                if (bVar != null) {
                    try {
                        this.f30269a.acquire();
                    } catch (Exception unused) {
                    }
                    bVar.a().a(4);
                    com.vivo.mobilead.unified.exitFloat.c cVar = new com.vivo.mobilead.unified.exitFloat.c(bVar);
                    cVar.a(i2);
                    this.f30271c.add(cVar);
                    String b2 = com.vivo.mobilead.util.f.b(bVar);
                    if (TextUtils.isEmpty(b2)) {
                        cVar.a(false);
                        a.b(this.f30273e, this.f30269a);
                    } else {
                        y0.a(bVar, b2, this.f30272d, new c(cVar, this.f30273e, this.f30269a));
                    }
                }
            }
            return null;
        }
    }

    private static class e implements Callable {

        /* renamed from: a */
        private CountDownLatch f30274a;

        /* renamed from: b */
        private long f30275b;

        /* renamed from: c */
        private WeakReference<com.vivo.mobilead.unified.exitFloat.d> f30276c;

        /* renamed from: d */
        private int f30277d;

        /* renamed from: e */
        private List<com.vivo.mobilead.unified.exitFloat.c> f30278e;

        /* renamed from: f */
        private AtomicBoolean f30279f;

        /* renamed from: g */
        private AtomicLong f30280g;

        /* renamed from: com.vivo.mobilead.unified.exitFloat.a$e$a */
        class C0641a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ com.vivo.mobilead.unified.exitFloat.d f30281a;

            C0641a(e eVar, com.vivo.mobilead.unified.exitFloat.d dVar) {
                this.f30281a = dVar;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                this.f30281a.onAdReady();
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ com.vivo.mobilead.unified.exitFloat.d f30282a;

            b(e eVar, com.vivo.mobilead.unified.exitFloat.d dVar) {
                this.f30282a = dVar;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                this.f30282a.onAdFailed(new VivoAdError(40214, "下载广告素材失败，请检查网络是否良好，是否具有文件存储权限"));
            }
        }

        public e(CountDownLatch countDownLatch, long j2, com.vivo.mobilead.unified.exitFloat.d dVar, int i2, List<com.vivo.mobilead.unified.exitFloat.c> list, AtomicBoolean atomicBoolean, AtomicLong atomicLong) {
            this.f30274a = countDownLatch;
            this.f30275b = j2;
            this.f30276c = new WeakReference<>(dVar);
            this.f30277d = i2;
            this.f30278e = list;
            this.f30279f = atomicBoolean;
            this.f30280g = atomicLong;
        }

        private void a(List<com.vivo.mobilead.unified.exitFloat.c> list) {
            Context c2 = com.vivo.mobilead.manager.f.j().c();
            w.a(list, "", c2 == null ? "" : c2.getPackageName(), String.valueOf(1), "3001000", String.valueOf(4), String.valueOf(0), String.valueOf(5), String.valueOf(43));
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            try {
                this.f30274a.await(this.f30275b, TimeUnit.MILLISECONDS);
                int i2 = 0;
                for (int i3 = 0; i3 < this.f30278e.size(); i3++) {
                    com.vivo.mobilead.unified.exitFloat.c cVar = this.f30278e.get(i3);
                    if (cVar != null && cVar.b()) {
                        i2++;
                    }
                }
                com.vivo.mobilead.unified.exitFloat.d dVar = this.f30276c.get();
                if (dVar == null) {
                    return null;
                }
                if (i2 >= this.f30277d) {
                    this.f30279f.set(true);
                    this.f30280g.set(System.currentTimeMillis());
                    k0.a("4", this.f30278e, 1);
                    z.b().a(new C0641a(this, dVar));
                    return null;
                }
                this.f30279f.set(false);
                k0.a("4", this.f30278e, 0);
                z.b().a(new b(this, dVar));
                a(this.f30278e);
                return null;
            } catch (Exception unused) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.f30278e.size(); i5++) {
                    com.vivo.mobilead.unified.exitFloat.c cVar2 = this.f30278e.get(i5);
                    if (cVar2 != null && cVar2.b()) {
                        i4++;
                    }
                }
                com.vivo.mobilead.unified.exitFloat.d dVar2 = this.f30276c.get();
                if (dVar2 == null) {
                    return null;
                }
                if (i4 >= this.f30277d) {
                    this.f30279f.set(true);
                    this.f30280g.set(System.currentTimeMillis());
                    k0.a("4", this.f30278e, 1);
                    z.b().a(new C0641a(this, dVar2));
                    return null;
                }
                this.f30279f.set(false);
                k0.a("4", this.f30278e, 0);
                z.b().a(new b(this, dVar2));
                a(this.f30278e);
                return null;
            } catch (Throwable th) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.f30278e.size(); i7++) {
                    com.vivo.mobilead.unified.exitFloat.c cVar3 = this.f30278e.get(i7);
                    if (cVar3 != null && cVar3.b()) {
                        i6++;
                    }
                }
                com.vivo.mobilead.unified.exitFloat.d dVar3 = this.f30276c.get();
                if (dVar3 != null) {
                    if (i6 >= this.f30277d) {
                        this.f30279f.set(true);
                        this.f30280g.set(System.currentTimeMillis());
                        k0.a("4", this.f30278e, 1);
                        z.b().a(new C0641a(this, dVar3));
                    } else {
                        this.f30279f.set(false);
                        k0.a("4", this.f30278e, 0);
                        z.b().a(new b(this, dVar3));
                        a(this.f30278e);
                    }
                }
                throw th;
            }
        }
    }

    public a(Context context, AdParams adParams, com.vivo.mobilead.unified.exitFloat.d dVar) {
        super(context, adParams);
        this.u = new CopyOnWriteArrayList();
        this.v = new AtomicBoolean(false);
        this.x = 1800L;
        this.z = new ArrayList();
        this.A = new AtomicLong(0L);
        this.t = dVar;
    }

    @Override // com.vivo.mobilead.unified.a
    protected void c() {
    }

    @Override // com.vivo.mobilead.unified.a
    protected int f() {
        return 5;
    }

    @Override // com.vivo.mobilead.unified.a
    protected long g() {
        return 5000L;
    }

    @Override // com.vivo.mobilead.unified.a
    protected String k() {
        return "4";
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        a(1, 4, 43);
    }

    @Override // com.vivo.mobilead.unified.a
    protected void n() {
        if (this.l) {
            return;
        }
        this.l = true;
        List<com.vivo.ad.model.b> list = this.z;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<com.vivo.ad.model.b> it = this.z.iterator();
        while (it.hasNext()) {
            k0.a(it.next(), a.EnumC0603a.LOADED, "");
        }
    }

    public boolean o() {
        return !this.v.get() || System.currentTimeMillis() - this.y >= this.x * 1000;
    }

    private static class c implements m {

        /* renamed from: a */
        private com.vivo.mobilead.unified.exitFloat.c f30266a;

        /* renamed from: b */
        private CountDownLatch f30267b;

        /* renamed from: c */
        private Semaphore f30268c;

        public c(com.vivo.mobilead.unified.exitFloat.c cVar, CountDownLatch countDownLatch, Semaphore semaphore) {
            this.f30266a = cVar;
            this.f30267b = countDownLatch;
            this.f30268c = semaphore;
        }

        @Override // com.vivo.mobilead.i.m
        public void a() {
            this.f30266a.a(true);
            a.b(this.f30267b, this.f30268c);
        }

        @Override // com.vivo.mobilead.i.m
        public void a(AdError adError) {
            this.f30266a.a(false);
            a.b(this.f30267b, this.f30268c);
        }
    }

    private void b(List<com.vivo.ad.model.b> list, long j2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Semaphore semaphore = new Semaphore(3);
        int i2 = list.size() == 6 ? 4 : list.size() == 9 ? 6 : list.size() == 8 ? 5 : 1;
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        this.u.clear();
        a1.a(new e(countDownLatch, j2, this.t, i2, this.u, this.v, this.A));
        a1.a(new d(semaphore, list, this.u, j2, countDownLatch));
    }

    public void a(Activity activity) {
        if (activity == null || activity.isFinishing() || this.t == null) {
            return;
        }
        if (o()) {
            z.b().a(new C0639a());
            return;
        }
        if (this.B == null) {
            com.vivo.mobilead.unified.exitFloat.b bVar = new com.vivo.mobilead.unified.exitFloat.b(activity);
            this.B = bVar;
            bVar.a(this.z, this.t, this.A.get());
            this.B.setOnDismissListener(new b());
        }
        this.B.show();
        this.v.set(false);
    }

    public static void b(CountDownLatch countDownLatch, Semaphore semaphore) {
        try {
            countDownLatch.countDown();
        } catch (Exception unused) {
        }
        try {
            semaphore.release();
        } catch (Exception unused2) {
        }
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull List<com.vivo.ad.model.b> list, long j2) {
        if (list.size() != 6 && list.size() != 9) {
            a(new AdError(40218, "没有广告，建议过一会儿重试", null, null));
            return;
        }
        if (com.vivo.mobilead.util.m.c(this.f29661a) == 2 && list.size() == 9) {
            try {
                list.remove(list.size() - 1);
            } catch (Exception unused) {
            }
        }
        this.z = list;
        com.vivo.ad.model.b bVar = list.get(0);
        if (bVar != null && bVar.c() != null) {
            com.vivo.ad.model.e c2 = bVar.c();
            this.w = c2.f() == null ? this.w : c2.f();
            this.x = c2.c() == 0 ? this.x : c2.c();
        }
        this.y = System.currentTimeMillis();
        k0.a(list, 1, 0, c.a.f28912a.intValue(), this.f29663c, "", "", k(), this.n, this.f29668h, 1);
        n();
        b(list, j2);
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        super.a(adError);
        this.v.set(false);
        this.y = 0L;
        com.vivo.mobilead.unified.base.h.a.a(this.t, new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
    }
}
