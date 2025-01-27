package com.shu.priory.download.d;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class a implements Serializable {

    /* renamed from: a */
    private com.shu.priory.download.a.a f17010a;

    /* renamed from: b */
    private com.shu.priory.download.e.a f17011b;

    /* renamed from: c */
    private int f17012c;

    /* renamed from: d */
    private String f17013d;

    /* renamed from: e */
    private String f17014e;

    /* renamed from: f */
    private long f17015f;

    /* renamed from: g */
    private long f17016g;

    /* renamed from: h */
    private volatile int f17017h;

    /* renamed from: i */
    private int f17018i;

    /* renamed from: j */
    private List<b> f17019j;

    /* renamed from: com.shu.priory.download.d.a$a */
    public static final class C0553a {

        /* renamed from: a */
        private String f17020a;

        /* renamed from: b */
        private String f17021b;

        public C0553a a(String str) {
            this.f17020a = str;
            return this;
        }

        public C0553a b(String str) {
            this.f17021b = str;
            return this;
        }

        public a a() {
            a aVar = new a();
            aVar.a(this.f17020a);
            aVar.b(this.f17021b);
            aVar.b(Math.abs(this.f17020a.hashCode()));
            return aVar;
        }
    }

    public com.shu.priory.download.e.a a() {
        return this.f17011b;
    }

    public String b() {
        return this.f17013d;
    }

    public String c() {
        return this.f17014e;
    }

    public long d() {
        return this.f17015f;
    }

    public long e() {
        return this.f17016g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f17012c == ((a) obj).f17012c;
    }

    public com.shu.priory.download.a.a f() {
        return this.f17010a;
    }

    public int g() {
        return this.f17017h;
    }

    public int h() {
        return this.f17012c;
    }

    public int hashCode() {
        return this.f17012c;
    }

    public boolean i() {
        return this.f17018i == 0;
    }

    public List<b> j() {
        return this.f17019j;
    }

    public boolean k() {
        return this.f17017h == 5;
    }

    public void a(int i10) {
        this.f17017h = i10;
    }

    public void b(int i10) {
        this.f17012c = i10;
    }

    public void a(long j10) {
        this.f17015f = j10;
    }

    public void b(long j10) {
        this.f17016g = j10;
    }

    public void a(com.shu.priory.download.a.a aVar) {
        this.f17010a = aVar;
    }

    public void b(String str) {
        this.f17014e = str;
    }

    public void a(com.shu.priory.download.e.a aVar) {
        this.f17011b = aVar;
    }

    public void a(String str) {
        this.f17013d = str;
    }

    public void a(List<b> list) {
        this.f17019j = list;
    }

    public void a(boolean z10) {
        this.f17018i = !z10 ? 1 : 0;
    }
}
