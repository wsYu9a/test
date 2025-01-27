package com.tencent.bugly.crashreport.crash;

/* loaded from: classes4.dex */
public class b implements Comparable<b> {

    /* renamed from: a */
    public long f24832a = -1;

    /* renamed from: b */
    public long f24833b = -1;

    /* renamed from: c */
    public String f24834c = null;

    /* renamed from: d */
    public boolean f24835d = false;

    /* renamed from: e */
    public boolean f24836e = false;

    /* renamed from: f */
    public int f24837f = 0;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        long j2 = this.f24833b - bVar.f24833b;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }
}
