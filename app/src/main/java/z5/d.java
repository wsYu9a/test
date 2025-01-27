package z5;

import java.util.List;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a */
    public final byte[] f33656a;

    /* renamed from: b */
    public int f33657b;

    /* renamed from: c */
    public final String f33658c;

    /* renamed from: d */
    public final List<byte[]> f33659d;

    /* renamed from: e */
    public final String f33660e;

    /* renamed from: f */
    public Integer f33661f;

    /* renamed from: g */
    public Integer f33662g;

    /* renamed from: h */
    public Object f33663h;

    /* renamed from: i */
    public final int f33664i;

    /* renamed from: j */
    public final int f33665j;

    public d(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f33659d;
    }

    public String b() {
        return this.f33660e;
    }

    public Integer c() {
        return this.f33662g;
    }

    public Integer d() {
        return this.f33661f;
    }

    public int e() {
        return this.f33657b;
    }

    public Object f() {
        return this.f33663h;
    }

    public byte[] g() {
        return this.f33656a;
    }

    public int h() {
        return this.f33664i;
    }

    public int i() {
        return this.f33665j;
    }

    public String j() {
        return this.f33658c;
    }

    public boolean k() {
        return this.f33664i >= 0 && this.f33665j >= 0;
    }

    public void l(Integer num) {
        this.f33662g = num;
    }

    public void m(Integer num) {
        this.f33661f = num;
    }

    public void n(int i10) {
        this.f33657b = i10;
    }

    public void o(Object obj) {
        this.f33663h = obj;
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i10, int i11) {
        this.f33656a = bArr;
        this.f33657b = bArr == null ? 0 : bArr.length * 8;
        this.f33658c = str;
        this.f33659d = list;
        this.f33660e = str2;
        this.f33664i = i11;
        this.f33665j = i10;
    }
}
