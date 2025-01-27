package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import android.os.CountDownTimer;
import androidx.core.app.NotificationCompat;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.z.d.a.a.d.a.d.r.e;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class b<T> {

    /* renamed from: a */
    protected LinkedHashMap<String, com.aggmoread.sdk.z.d.a.a.d.a.d.r.e<T>> f5521a = new LinkedHashMap<>();

    public class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5522b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5523c;

        public a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
            this.f5522b = dVar;
            this.f5523c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f5522b, this.f5523c);
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.r.b$b */
    public class CountDownTimerC0141b extends CountDownTimer {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5525a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5526b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.a.d.r.e f5527c;

        /* renamed from: d */
        final /* synthetic */ f f5528d;

        /* renamed from: e */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.f f5529e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountDownTimerC0141b(long j10, long j11, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, com.aggmoread.sdk.z.d.a.a.d.a.d.r.e eVar2, f fVar, com.aggmoread.sdk.z.d.a.a.c.f fVar2) {
            super(j10, j11);
            this.f5525a = dVar;
            this.f5526b = eVar;
            this.f5527c = eVar2;
            this.f5528d = fVar;
            this.f5529e = fVar2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            b.this.a(this.f5525a, this.f5526b, this.f5527c, this.f5528d, this.f5529e, false, "onFinish");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5531b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5532c;

        /* renamed from: d */
        final /* synthetic */ f f5533d;

        public c(b bVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, f fVar) {
            this.f5531b = dVar;
            this.f5532c = eVar;
            this.f5533d = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b(this.f5531b, this.f5532c, this.f5533d, null, "timeOut");
        }
    }

    public class d implements g<T> {

        /* renamed from: a */
        int f5534a = 0;

        /* renamed from: b */
        final /* synthetic */ List f5535b;

        /* renamed from: c */
        final /* synthetic */ CountDownTimer f5536c;

        /* renamed from: d */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5537d;

        /* renamed from: e */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5538e;

        /* renamed from: f */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.a.d.r.e f5539f;

        /* renamed from: g */
        final /* synthetic */ f f5540g;

        /* renamed from: h */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.c.f f5541h;

        /* renamed from: i */
        final /* synthetic */ f f5542i;

        /* renamed from: j */
        final /* synthetic */ Runnable f5543j;

        public d(List list, CountDownTimer countDownTimer, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, com.aggmoread.sdk.z.d.a.a.d.a.d.r.e eVar2, f fVar, com.aggmoread.sdk.z.d.a.a.c.f fVar2, f fVar3, Runnable runnable) {
            this.f5535b = list;
            this.f5536c = countDownTimer;
            this.f5537d = dVar;
            this.f5538e = eVar;
            this.f5539f = eVar2;
            this.f5540g = fVar;
            this.f5541h = fVar2;
            this.f5542i = fVar3;
            this.f5543j = runnable;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b.g
        public void a() {
            this.f5534a++;
            com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "err c " + this.f5534a + ",total " + this.f5535b.size());
            if (this.f5534a >= this.f5535b.size()) {
                this.f5536c.cancel();
                b.this.a(this.f5537d, this.f5538e, this.f5539f, this.f5540g, this.f5541h, false, "err end");
                b.b(this.f5537d, this.f5538e, this.f5542i, this.f5543j, NotificationCompat.CATEGORY_ERROR);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b.g
        public void onAdLoaded(List<T> list) {
            if (list != null) {
                for (T t10 : list) {
                    if (t10 != null) {
                        this.f5539f.a(new e.a<>(t10, b.a(t10)));
                    }
                }
            }
            this.f5534a++;
            com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "load c " + this.f5534a + ",total " + this.f5535b.size());
            b.this.a(this.f5537d, this.f5538e, this.f5539f, this.f5540g, this.f5541h, false, "loaded end ");
            if (this.f5534a >= this.f5535b.size()) {
                this.f5536c.cancel();
                b.b(this.f5537d, this.f5538e, this.f5542i, this.f5543j, "load");
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5545b;

        public e(b bVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar) {
            this.f5545b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5545b.f5861g.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001004001, "广告无填充"));
        }
    }

    public static class f {

        /* renamed from: a */
        public boolean f5546a;

        private f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public interface g<K> {
        void a();

        void onAdLoaded(List<K> list);
    }

    public static int a(Object obj) {
        int i10;
        Map<String, Object> h10;
        if ((obj instanceof com.aggmoread.sdk.z.d.a.a.c.a) && (h10 = ((com.aggmoread.sdk.z.d.a.a.c.a) obj).h()) != null && h10.containsKey(AMConst.ExtrasKey.AD_PRICE)) {
            Object obj2 = h10.get(AMConst.ExtrasKey.AD_PRICE);
            if (obj2 instanceof String) {
                try {
                    i10 = Integer.parseInt((String) obj2);
                } catch (Exception e10) {
                    com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "gap error : " + e10.getMessage());
                }
                com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "gap p : " + i10);
                return i10;
            }
        }
        i10 = -1;
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "gap p : " + i10);
        return i10;
    }

    private com.aggmoread.sdk.z.d.a.a.c.f b(com.aggmoread.sdk.z.d.a.a.c.f fVar, g<T> gVar) {
        try {
            return a(fVar, gVar);
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "Exception err " + e10.getMessage());
            e10.printStackTrace();
            return fVar;
        }
    }

    public abstract com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, g<T> gVar);

    public abstract void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<T> list);

    public void b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        com.aggmoread.sdk.z.d.a.a.e.f fVar;
        Map<Object, Object> map;
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "loadAdInner enter ");
        if (eVar == null || (fVar = eVar.f5906b) == null || (map = fVar.f6092a) == null) {
            return;
        }
        List list = (List) map.get(e.c.f5918a);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                com.aggmoread.sdk.z.d.a.a.e.f fVar2 = new com.aggmoread.sdk.z.d.a.a.e.f((Map) list.get(i10));
                if (fVar2.b(e.c.V) > dVar.f5876v) {
                    com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "loadAdInner list " + i10);
                    if (fVar2.b(e.c.f5923c0) == 0) {
                        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "loadAdInner bidAd");
                        arrayList.add(new k(eVar, fVar2, i10));
                    } else {
                        o oVar = new o(i10, (Map) list.get(i10));
                        int b10 = fVar2.b(e.c.Y);
                        if (b10 == 1) {
                            arrayList4.add(oVar);
                        } else if (b10 == 100) {
                            arrayList2.add(oVar);
                        } else if (b10 == 101) {
                            arrayList3.add(oVar);
                        } else if (b10 == 107) {
                            arrayList5.add(oVar);
                        } else {
                            arrayList6.add(oVar);
                        }
                    }
                }
            }
            if (!arrayList6.isEmpty()) {
                arrayList.add(new p(dVar, eVar, arrayList6, -1));
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new p(dVar, eVar, arrayList2, 100));
            }
            if (!arrayList3.isEmpty()) {
                arrayList.add(new p(dVar, eVar, arrayList3, 101));
            }
            if (!arrayList4.isEmpty()) {
                arrayList.add(new p(dVar, eVar, arrayList4, 1));
            }
            if (!arrayList5.isEmpty()) {
                arrayList.add(new p(dVar, eVar, arrayList5, 107));
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "adConcurrentResponseList size : " + arrayList.size());
        }
        if (arrayList.isEmpty()) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new e(this, dVar));
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "loadAdInner placementId : " + dVar.f5863i);
        com.aggmoread.sdk.z.d.a.a.c.f fVar3 = dVar.f5861g;
        f fVar4 = new f(null);
        f fVar5 = new f(null);
        com.aggmoread.sdk.z.d.a.a.d.a.d.r.e<T> eVar2 = this.f5521a.get(dVar.f5863i);
        if (eVar2 == null) {
            eVar2 = new com.aggmoread.sdk.z.d.a.a.d.a.d.r.e<>(dVar.f5863i);
            this.f5521a.put(dVar.f5863i, eVar2);
        } else {
            eVar2.a();
        }
        com.aggmoread.sdk.z.d.a.a.d.a.d.r.e<T> eVar3 = eVar2;
        long j10 = dVar.A;
        if (j10 <= 0) {
            j10 = a();
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "loadAdInner placementId : " + dVar.f5863i + ", requestTimeOut = " + j10);
        CountDownTimerC0141b countDownTimerC0141b = new CountDownTimerC0141b(j10, 500L, dVar, eVar, eVar3, fVar4, fVar3);
        c cVar = new c(this, dVar, eVar, fVar5);
        dVar.f5861g = b(fVar3, new d(arrayList, countDownTimerC0141b, dVar, eVar, eVar3, fVar4, fVar3, fVar5, cVar));
        a(dVar, eVar, eVar3, fVar4, fVar3, true, "bef load");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.aggmoread.sdk.z.d.a.a.d.b.g.a(dVar, (com.aggmoread.sdk.z.d.a.a.d.a.d.r.c) it.next());
        }
        com.aggmoread.sdk.z.d.a.a.e.n.a().postDelayed(cVar, 20000L);
        if (fVar4.f5546a) {
            return;
        }
        countDownTimerC0141b.start();
    }

    public long a() {
        return 3000L;
    }

    public static String a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Object obj) {
        String a10 = obj instanceof com.aggmoread.sdk.z.d.a.a.c.a ? com.aggmoread.sdk.z.d.a.a.e.m.a(dVar, eVar, ((com.aggmoread.sdk.z.d.a.a.c.a) obj).h()) : "-1";
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "grap p : " + a10);
        return a10;
    }

    public static void b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, f fVar, Runnable runnable, String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "try rle , " + fVar.f5546a + ", info : " + str + ", rid : " + (dVar != null ? dVar.f5857c : ""));
        if (fVar.f5546a) {
            return;
        }
        fVar.f5546a = true;
        if (runnable != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a().removeCallbacks(runnable);
        }
        if (eVar != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "tryEnd");
            eVar.k();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
    
        r0.f5905a = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0028, code lost:
    
        if (r0 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r0 != null) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.aggmoread.sdk.z.d.a.a.c.f r6, com.aggmoread.sdk.z.d.a.a.d.b.d r7, com.aggmoread.sdk.z.d.a.a.d.b.e r8, com.aggmoread.sdk.z.d.a.a.d.a.d.r.e.a<T> r9) {
        /*
            r5 = this;
            java.lang.String r0 = "notify "
            java.lang.String r1 = "ACBHTAG"
            com.aggmoread.sdk.z.d.a.a.e.e.b(r1, r0)
            if (r9 == 0) goto L9c
            T r9 = r9.f5560b
            boolean r0 = r9 instanceof com.aggmoread.sdk.z.d.a.a.d.b.a
            if (r0 == 0) goto L1b
            r0 = r9
            com.aggmoread.sdk.z.d.a.a.d.b.a r0 = (com.aggmoread.sdk.z.d.a.a.d.b.a) r0
            com.aggmoread.sdk.z.d.a.a.d.b.d r2 = r0.f5842g
            r0.f5842g = r7
            com.aggmoread.sdk.z.d.a.a.d.b.e r0 = r0.f5843h
            if (r0 == 0) goto L2e
            goto L2a
        L1b:
            boolean r0 = r9 instanceof com.aggmoread.sdk.z.d.a.a.d.a.a
            if (r0 == 0) goto L2d
            r0 = r9
            com.aggmoread.sdk.z.d.a.a.d.a.a r0 = (com.aggmoread.sdk.z.d.a.a.d.a.a) r0
            com.aggmoread.sdk.z.d.a.a.d.b.d r2 = r0.f5275h
            r0.f5275h = r7
            com.aggmoread.sdk.z.d.a.a.d.b.e r0 = r0.f5276i
            if (r0 == 0) goto L2e
        L2a:
            r0.f5905a = r7
            goto L2e
        L2d:
            r2 = 0
        L2e:
            java.lang.String r0 = ""
            if (r2 == 0) goto L35
            java.lang.String r2 = r2.f5857c
            goto L36
        L35:
            r2 = r0
        L36:
            if (r7 == 0) goto L3a
            java.lang.String r0 = r7.f5857c
        L3a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "rca "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = ", cc "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.aggmoread.sdk.z.d.a.a.e.e.b(r1, r0)
            boolean r0 = r9 instanceof com.aggmoread.sdk.z.d.a.a.c.a
            if (r0 == 0) goto L6a
            r0 = r9
            com.aggmoread.sdk.z.d.a.a.c.a r0 = (com.aggmoread.sdk.z.d.a.a.c.a) r0
            java.util.Map r0 = r0.h()
            if (r0 == 0) goto L6a
            java.lang.String r1 = r7.f5857c
            java.lang.String r2 = "EXTRA_network_ad_ID"
            r0.put(r2, r1)
        L6a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r9)
            com.aggmoread.sdk.z.d.a.a.d.b.k r1 = new com.aggmoread.sdk.z.d.a.a.d.b.k
            r1.<init>(r7, r8)
            r2 = 9
            com.aggmoread.sdk.z.d.a.a.d.b.k r1 = r1.a(r2)
            java.lang.Object r2 = com.aggmoread.sdk.z.d.a.a.d.b.k.b.f6049q
            java.lang.String r7 = a(r7, r8, r9)
            com.aggmoread.sdk.z.d.a.a.d.b.k r7 = r1.a(r2, r7)
            java.lang.Object r8 = com.aggmoread.sdk.z.d.a.a.d.b.k.b.B
            int r9 = r0.size()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            com.aggmoread.sdk.z.d.a.a.d.b.k r7 = r7.a(r8, r9)
            r7.b()
            r5.a(r6, r0)
            goto Lb1
        L9c:
            java.lang.String r7 = "notify err"
            com.aggmoread.sdk.z.d.a.a.e.e.b(r1, r7)
            if (r6 == 0) goto Lb1
            com.aggmoread.sdk.z.d.a.a.d.b.i r7 = new com.aggmoread.sdk.z.d.a.a.d.b.i
            r8 = 1001005006(0x3baa1fce, float:0.0051917797)
            java.lang.String r9 = "全部广告请求失败，无合适广告返回!"
            r7.<init>(r8, r9)
            r6.a(r7)
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.a.d.r.b.a(com.aggmoread.sdk.z.d.a.a.c.f, com.aggmoread.sdk.z.d.a.a.d.b.d, com.aggmoread.sdk.z.d.a.a.d.b.e, com.aggmoread.sdk.z.d.a.a.d.a.d.r.e$a):void");
    }

    public void a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "loadAd enter ");
        com.aggmoread.sdk.z.d.a.a.e.n.a(new a(dVar, eVar));
    }

    public void a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, com.aggmoread.sdk.z.d.a.a.d.a.d.r.e<T> eVar2, f fVar, com.aggmoread.sdk.z.d.a.a.c.f fVar2, boolean z10, String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACBHTAG", "try rca ,  : " + fVar.f5546a + ", info : " + str + ", preLoad " + dVar.f5880z);
        if (fVar.f5546a || dVar.f5880z) {
            return;
        }
        e.a<T> b10 = eVar2.b();
        if (z10 && b10 == null) {
            return;
        }
        fVar.f5546a = true;
        a(fVar2, dVar, eVar, b10);
    }
}
