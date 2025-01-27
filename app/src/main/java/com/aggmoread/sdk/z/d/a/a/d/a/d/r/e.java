package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.client.AMConst;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class e<T> {

    /* renamed from: a */
    private final SortedSet<a<T>> f5559a = Collections.synchronizedSortedSet(new TreeSet());

    public static class a<T> implements Comparable<a> {

        /* renamed from: b */
        public T f5560b;

        /* renamed from: c */
        public int f5561c;

        /* renamed from: e */
        private long f5563e = 1800000;

        /* renamed from: d */
        private long f5562d = System.currentTimeMillis();

        public a(T t10, int i10) {
            this.f5560b = t10;
            this.f5561c = i10;
        }

        @Override // java.lang.Comparable
        /* renamed from: b */
        public int compareTo(a aVar) {
            int i10 = aVar.f5561c - this.f5561c;
            if (i10 != 0) {
                return i10;
            }
            long j10 = this.f5562d - aVar.f5562d;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        public boolean a() {
            return this.f5563e > System.currentTimeMillis() - this.f5562d;
        }

        public void b() {
            com.aggmoread.sdk.z.d.a.a.e.e.b("ACCDTAG", "nr ");
            T t10 = this.f5560b;
            if (t10 instanceof com.aggmoread.sdk.z.d.a.a.c.a) {
                ((com.aggmoread.sdk.z.d.a.a.c.a) t10).a(1, this.f5561c + 10, "");
            }
        }
    }

    public e(String str) {
    }

    public void a() {
        SortedSet<a<T>> sortedSet = this.f5559a;
        if (sortedSet != null) {
            synchronized (sortedSet) {
                try {
                    com.aggmoread.sdk.z.d.a.a.e.e.b("ACCDTAG", "checkExpire, size " + this.f5559a.size());
                    Iterator<a<T>> it = this.f5559a.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        if (next != null && !next.a()) {
                            it.remove();
                            next.b();
                            a("checkExpire", next);
                        }
                    }
                } finally {
                }
            }
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACCDTAG", "checkExpire end , size = " + this.f5559a.size());
    }

    public a<T> b() {
        synchronized (this.f5559a) {
            try {
                if (this.f5559a.isEmpty()) {
                    return null;
                }
                com.aggmoread.sdk.z.d.a.a.e.e.b("ACCDTAG", "pollFirst data  " + Thread.currentThread().getName());
                a<T> first = this.f5559a.first();
                this.f5559a.remove(first);
                return first;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007d A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:6:0x0007, B:8:0x0021, B:10:0x002d, B:12:0x0035, B:13:0x006c, B:14:0x006e, B:16:0x007d, B:17:0x0046, B:19:0x004a, B:21:0x0056, B:23:0x005e, B:29:0x008a), top: B:5:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.d.r.e.a<T> r6) {
        /*
            r5 = this;
            java.util.SortedSet<com.aggmoread.sdk.z.d.a.a.d.a.d.r.e$a<T>> r0 = r5.f5559a
            monitor-enter(r0)
            if (r6 == 0) goto L8a
            java.lang.String r1 = "ACCDTAG"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r2.<init>()     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "addAdData   "
            r2.append(r3)     // Catch: java.lang.Throwable -> L44
            r2.append(r6)     // Catch: java.lang.Throwable -> L44
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L44
            com.aggmoread.sdk.z.d.a.a.e.e.b(r1, r2)     // Catch: java.lang.Throwable -> L44
            T r1 = r6.f5560b     // Catch: java.lang.Throwable -> L44
            boolean r2 = r1 instanceof com.aggmoread.sdk.z.d.a.a.d.b.a     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L46
            r2 = r1
            com.aggmoread.sdk.z.d.a.a.d.b.a r2 = (com.aggmoread.sdk.z.d.a.a.d.b.a) r2     // Catch: java.lang.Throwable -> L44
            com.aggmoread.sdk.z.d.a.a.d.b.d r2 = r2.f5842g     // Catch: java.lang.Throwable -> L44
            r3 = r1
            com.aggmoread.sdk.z.d.a.a.d.b.a r3 = (com.aggmoread.sdk.z.d.a.a.d.b.a) r3     // Catch: java.lang.Throwable -> L44
            com.aggmoread.sdk.z.d.a.a.d.b.e r3 = r3.f5843h     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L6e
            java.lang.Object r2 = r2.b()     // Catch: java.lang.Throwable -> L44
            boolean r4 = r2 instanceof com.aggmoread.sdk.z.d.a.a.d.b.d     // Catch: java.lang.Throwable -> L44
            if (r4 == 0) goto L6e
            com.aggmoread.sdk.z.d.a.a.d.b.d r2 = (com.aggmoread.sdk.z.d.a.a.d.b.d) r2     // Catch: java.lang.Throwable -> L44
            android.content.Context r4 = com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q     // Catch: java.lang.Throwable -> L44
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L44
            r2.f5858d = r4     // Catch: java.lang.Throwable -> L44
            com.aggmoread.sdk.z.d.a.a.d.b.a r1 = (com.aggmoread.sdk.z.d.a.a.d.b.a) r1     // Catch: java.lang.Throwable -> L44
            r1.f5842g = r2     // Catch: java.lang.Throwable -> L44
            goto L6c
        L44:
            r6 = move-exception
            goto L8c
        L46:
            boolean r2 = r1 instanceof com.aggmoread.sdk.z.d.a.a.d.a.a     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L6e
            r2 = r1
            com.aggmoread.sdk.z.d.a.a.d.a.a r2 = (com.aggmoread.sdk.z.d.a.a.d.a.a) r2     // Catch: java.lang.Throwable -> L44
            com.aggmoread.sdk.z.d.a.a.d.b.d r2 = r2.f5275h     // Catch: java.lang.Throwable -> L44
            r3 = r1
            com.aggmoread.sdk.z.d.a.a.d.a.a r3 = (com.aggmoread.sdk.z.d.a.a.d.a.a) r3     // Catch: java.lang.Throwable -> L44
            com.aggmoread.sdk.z.d.a.a.d.b.e r3 = r3.f5276i     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L6e
            java.lang.Object r2 = r2.b()     // Catch: java.lang.Throwable -> L44
            boolean r4 = r2 instanceof com.aggmoread.sdk.z.d.a.a.d.b.d     // Catch: java.lang.Throwable -> L44
            if (r4 == 0) goto L6e
            com.aggmoread.sdk.z.d.a.a.d.b.d r2 = (com.aggmoread.sdk.z.d.a.a.d.b.d) r2     // Catch: java.lang.Throwable -> L44
            android.content.Context r4 = com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q     // Catch: java.lang.Throwable -> L44
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L44
            r2.f5858d = r4     // Catch: java.lang.Throwable -> L44
            com.aggmoread.sdk.z.d.a.a.d.a.a r1 = (com.aggmoread.sdk.z.d.a.a.d.a.a) r1     // Catch: java.lang.Throwable -> L44
            r1.f5275h = r2     // Catch: java.lang.Throwable -> L44
        L6c:
            r3.f5905a = r2     // Catch: java.lang.Throwable -> L44
        L6e:
            java.util.SortedSet<com.aggmoread.sdk.z.d.a.a.d.a.d.r.e$a<T>> r1 = r5.f5559a     // Catch: java.lang.Throwable -> L44
            r1.add(r6)     // Catch: java.lang.Throwable -> L44
            java.util.SortedSet<com.aggmoread.sdk.z.d.a.a.d.a.d.r.e$a<T>> r6 = r5.f5559a     // Catch: java.lang.Throwable -> L44
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L44
            r1 = 9
            if (r6 <= r1) goto L8a
            java.util.SortedSet<com.aggmoread.sdk.z.d.a.a.d.a.d.r.e$a<T>> r6 = r5.f5559a     // Catch: java.lang.Throwable -> L44
            java.lang.Object r6 = r6.last()     // Catch: java.lang.Throwable -> L44
            com.aggmoread.sdk.z.d.a.a.d.a.d.r.e$a r6 = (com.aggmoread.sdk.z.d.a.a.d.a.d.r.e.a) r6     // Catch: java.lang.Throwable -> L44
            java.util.SortedSet<com.aggmoread.sdk.z.d.a.a.d.a.d.r.e$a<T>> r1 = r5.f5559a     // Catch: java.lang.Throwable -> L44
            r1.remove(r6)     // Catch: java.lang.Throwable -> L44
        L8a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            return
        L8c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.a.d.r.e.a(com.aggmoread.sdk.z.d.a.a.d.a.d.r.e$a):void");
    }

    private void a(String str, a<T> aVar) {
        String str2;
        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("ACCDTAG", "dump " + str + ", adData " + aVar);
            T t10 = aVar.f5560b;
            if (t10 instanceof com.aggmoread.sdk.z.d.a.a.c.a) {
                Map<String, Object> h10 = ((com.aggmoread.sdk.z.d.a.a.c.a) t10).h();
                if (h10 != null) {
                    StringBuilder sb2 = new StringBuilder("ExtrasInfo:\n");
                    sb2.append("time = " + ((a) aVar).f5562d);
                    sb2.append("\n\t");
                    sb2.append("slot_id = " + h10.get(AMConst.ExtrasKey.AD_PLACEMENT_ID));
                    sb2.append("\n\t");
                    sb2.append("ecpm = " + h10.get(AMConst.ExtrasKey.AD_PRICE));
                    sb2.append("\n\t End");
                    str2 = sb2.toString();
                } else {
                    str2 = "extrasMap is empty ";
                }
                com.aggmoread.sdk.z.d.a.a.e.e.b("ACCDTAG", str2);
            }
        }
    }
}
