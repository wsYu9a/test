package com.czhj.wire.okio;

/* loaded from: classes2.dex */
final class Segment {

    /* renamed from: h */
    public static final int f8948h = 8192;

    /* renamed from: i */
    public static final int f8949i = 1024;

    /* renamed from: a */
    public final byte[] f8950a;

    /* renamed from: b */
    public int f8951b;

    /* renamed from: c */
    public int f8952c;

    /* renamed from: d */
    public boolean f8953d;

    /* renamed from: e */
    public boolean f8954e;

    /* renamed from: f */
    public Segment f8955f;

    /* renamed from: g */
    public Segment f8956g;

    public Segment() {
        this.f8950a = new byte[8192];
        this.f8954e = true;
        this.f8953d = false;
    }

    public void compact() {
        Segment segment = this.f8956g;
        if (segment == this) {
            throw new IllegalStateException();
        }
        if (segment.f8954e) {
            int i10 = this.f8952c - this.f8951b;
            if (i10 > (8192 - segment.f8952c) + (segment.f8953d ? 0 : segment.f8951b)) {
                return;
            }
            writeTo(segment, i10);
            pop();
            SegmentPool.a(this);
        }
    }

    public Segment pop() {
        Segment segment = this.f8955f;
        Segment segment2 = segment != this ? segment : null;
        Segment segment3 = this.f8956g;
        segment3.f8955f = segment;
        this.f8955f.f8956g = segment3;
        this.f8955f = null;
        this.f8956g = null;
        return segment2;
    }

    public Segment push(Segment segment) {
        segment.f8956g = this;
        segment.f8955f = this.f8955f;
        this.f8955f.f8956g = segment;
        this.f8955f = segment;
        return segment;
    }

    public Segment split(int i10) {
        Segment a10;
        if (i10 <= 0 || i10 > this.f8952c - this.f8951b) {
            throw new IllegalArgumentException();
        }
        if (i10 >= 1024) {
            a10 = new Segment(this);
        } else {
            a10 = SegmentPool.a();
            System.arraycopy(this.f8950a, this.f8951b, a10.f8950a, 0, i10);
        }
        a10.f8952c = a10.f8951b + i10;
        this.f8951b += i10;
        this.f8956g.push(a10);
        return a10;
    }

    public void writeTo(Segment segment, int i10) {
        if (!segment.f8954e) {
            throw new IllegalArgumentException();
        }
        int i11 = segment.f8952c;
        int i12 = i11 + i10;
        if (i12 > 8192) {
            if (segment.f8953d) {
                throw new IllegalArgumentException();
            }
            int i13 = segment.f8951b;
            if (i12 - i13 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.f8950a;
            System.arraycopy(bArr, i13, bArr, 0, i11 - i13);
            segment.f8952c -= segment.f8951b;
            segment.f8951b = 0;
        }
        System.arraycopy(this.f8950a, this.f8951b, segment.f8950a, segment.f8952c, i10);
        segment.f8952c += i10;
        this.f8951b += i10;
    }

    public Segment(Segment segment) {
        this(segment.f8950a, segment.f8951b, segment.f8952c);
        segment.f8953d = true;
    }

    public Segment(byte[] bArr, int i10, int i11) {
        this.f8950a = bArr;
        this.f8951b = i10;
        this.f8952c = i11;
        this.f8954e = false;
        this.f8953d = true;
    }
}
