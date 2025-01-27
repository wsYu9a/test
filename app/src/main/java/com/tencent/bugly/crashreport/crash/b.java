package com.tencent.bugly.crashreport.crash;

/* loaded from: classes4.dex */
public class b implements Comparable<b> {

    /* renamed from: a */
    public long f22439a = -1;

    /* renamed from: b */
    public long f22440b = -1;

    /* renamed from: c */
    public String f22441c = null;

    /* renamed from: d */
    public boolean f22442d = false;

    /* renamed from: e */
    public boolean f22443e = false;

    /* renamed from: f */
    public int f22444f = 0;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        long j10 = this.f22440b - bVar.f22440b;
        if (j10 > 0) {
            return 1;
        }
        return j10 < 0 ? -1 : 0;
    }
}
