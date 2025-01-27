package com.sigmob.sdk.downloader.core.breakpoint;

import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class h implements j {

    /* renamed from: g */
    public static final int f19051g = 1;

    /* renamed from: a */
    public final SparseArray<c> f19052a;

    /* renamed from: b */
    public final HashMap<String, String> f19053b;

    /* renamed from: c */
    public final k f19054c;

    /* renamed from: d */
    public final SparseArray<com.sigmob.sdk.downloader.core.a> f19055d;

    /* renamed from: e */
    public final List<Integer> f19056e;

    /* renamed from: f */
    public final List<Integer> f19057f;

    public h() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void b(int i10) {
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean c(int i10) {
        if (this.f19057f.contains(Integer.valueOf(i10))) {
            return false;
        }
        synchronized (this.f19057f) {
            try {
                if (this.f19057f.contains(Integer.valueOf(i10))) {
                    return false;
                }
                this.f19057f.add(Integer.valueOf(i10));
                return true;
            } finally {
            }
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean e(int i10) {
        boolean remove;
        synchronized (this.f19057f) {
            remove = this.f19057f.remove(Integer.valueOf(i10));
        }
        return remove;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public synchronized void g(int i10) {
        try {
            this.f19052a.remove(i10);
            if (this.f19055d.get(i10) == null) {
                this.f19056e.remove(Integer.valueOf(i10));
            }
            this.f19054c.a(i10);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c h(int i10) {
        return this.f19052a.get(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c i(int i10) {
        return null;
    }

    public h(SparseArray<c> sparseArray, List<Integer> list, HashMap<String, String> hashMap) {
        this.f19055d = new SparseArray<>();
        this.f19052a = sparseArray;
        this.f19057f = list;
        this.f19053b = hashMap;
        this.f19054c = new k();
        int size = sparseArray.size();
        this.f19056e = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            this.f19056e.add(Integer.valueOf(sparseArray.valueAt(i10).f19005a));
        }
        Collections.sort(this.f19056e);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar) {
        int b10 = fVar.b();
        c cVar = new c(b10, fVar.e(), fVar.c(), fVar.a());
        synchronized (this) {
            this.f19052a.put(b10, cVar);
            this.f19055d.remove(b10);
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int b() {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            r2 = 0
        L4:
            java.util.List<java.lang.Integer> r3 = r5.f19056e     // Catch: java.lang.Throwable -> L2f
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L2f
            r4 = 1
            if (r1 >= r3) goto L23
            java.util.List<java.lang.Integer> r3 = r5.f19056e     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L2f
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L1a
            int r0 = r2 + 1
            goto L31
        L1a:
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L2f
            if (r2 != 0) goto L25
            if (r3 == r4) goto L2b
            r0 = 1
        L23:
            r1 = 0
            goto L31
        L25:
            int r2 = r2 + 1
            if (r3 == r2) goto L2b
            r0 = r2
            goto L31
        L2b:
            int r1 = r1 + 1
            r2 = r3
            goto L4
        L2f:
            r0 = move-exception
            goto L61
        L31:
            if (r0 != 0) goto L55
            java.util.List<java.lang.Integer> r0 = r5.f19056e     // Catch: java.lang.Throwable -> L2f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L3c
            goto L56
        L3c:
            java.util.List<java.lang.Integer> r0 = r5.f19056e     // Catch: java.lang.Throwable -> L2f
            int r1 = r0.size()     // Catch: java.lang.Throwable -> L2f
            int r1 = r1 - r4
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L2f
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L2f
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L2f
            int r4 = r4 + r0
            java.util.List<java.lang.Integer> r0 = r5.f19056e     // Catch: java.lang.Throwable -> L2f
            int r1 = r0.size()     // Catch: java.lang.Throwable -> L2f
            goto L56
        L55:
            r4 = r0
        L56:
            java.util.List<java.lang.Integer> r0 = r5.f19056e     // Catch: java.lang.Throwable -> L2f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L2f
            r0.add(r1, r2)     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r5)
            return r4
        L61:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2f
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.breakpoint.h.b():int");
    }

    public h(SparseArray<c> sparseArray, List<Integer> list, HashMap<String, String> hashMap, SparseArray<com.sigmob.sdk.downloader.core.a> sparseArray2, List<Integer> list2, k kVar) {
        this.f19055d = sparseArray2;
        this.f19057f = list;
        this.f19052a = sparseArray;
        this.f19053b = hashMap;
        this.f19056e = list2;
        this.f19054c = kVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar, c cVar) {
        SparseArray<c> clone;
        synchronized (this) {
            clone = this.f19052a.clone();
        }
        int size = clone.size();
        for (int i10 = 0; i10 < size; i10++) {
            c valueAt = clone.valueAt(i10);
            if (valueAt != cVar && valueAt.a(fVar)) {
                return valueAt;
            }
        }
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public synchronized int b(com.sigmob.sdk.downloader.f fVar) {
        Integer b10 = this.f19054c.b(fVar);
        if (b10 != null) {
            return b10.intValue();
        }
        int size = this.f19052a.size();
        for (int i10 = 0; i10 < size; i10++) {
            c valueAt = this.f19052a.valueAt(i10);
            if (valueAt != null && valueAt.a(fVar)) {
                return valueAt.f19005a;
            }
        }
        int size2 = this.f19055d.size();
        for (int i11 = 0; i11 < size2; i11++) {
            com.sigmob.sdk.downloader.core.a valueAt2 = this.f19055d.valueAt(i11);
            if (valueAt2 != null && valueAt2.a(fVar)) {
                return valueAt2.b();
            }
        }
        int b11 = b();
        this.f19055d.put(b11, fVar.b(b11));
        this.f19054c.a(fVar, b11);
        return b11;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String str) {
        return this.f19053b.get(str);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(int i10) {
        return this.f19057f.contains(Integer.valueOf(i10));
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c cVar, int i10, long j10) throws IOException {
        c cVar2 = this.f19052a.get(cVar.f19005a);
        if (cVar != cVar2) {
            throw new IOException("Info not on store!");
        }
        cVar2.b(i10).a(j10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int i10, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            g(i10);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c cVar) {
        String e10 = cVar.e();
        if (cVar.n() && e10 != null) {
            this.f19053b.put(cVar.k(), e10);
        }
        c cVar2 = this.f19052a.get(cVar.f19005a);
        if (cVar2 == null) {
            return false;
        }
        if (cVar2 == cVar) {
            return true;
        }
        synchronized (this) {
            this.f19052a.put(cVar.f19005a, cVar.a());
        }
        return true;
    }
}
