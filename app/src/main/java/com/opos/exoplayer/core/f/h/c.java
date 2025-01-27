package com.opos.exoplayer.core.f.h;

import android.text.Layout;
import android.text.SpannableStringBuilder;

/* loaded from: classes4.dex */
public final class c extends com.opos.exoplayer.core.f.b {
    public final long m;
    public final long n;

    /* renamed from: com.opos.exoplayer.core.f.h.c$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f18775a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f18775a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18775a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18775a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class a {

        /* renamed from: a */
        private long f18776a;

        /* renamed from: b */
        private long f18777b;

        /* renamed from: c */
        private SpannableStringBuilder f18778c;

        /* renamed from: d */
        private Layout.Alignment f18779d;

        /* renamed from: e */
        private float f18780e;

        /* renamed from: f */
        private int f18781f;

        /* renamed from: g */
        private int f18782g;

        /* renamed from: h */
        private float f18783h;

        /* renamed from: i */
        private int f18784i;

        /* renamed from: j */
        private float f18785j;

        public a() {
            a();
        }

        private a c() {
            Layout.Alignment alignment = this.f18779d;
            if (alignment == null) {
                this.f18784i = Integer.MIN_VALUE;
            } else {
                int i2 = AnonymousClass1.f18775a[alignment.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.f18784i = 1;
                    } else if (i2 != 3) {
                        com.opos.cmn.an.f.a.c("WebvttCueBuilder", "Unrecognized alignment: " + this.f18779d);
                    } else {
                        this.f18784i = 2;
                    }
                }
                this.f18784i = 0;
            }
            return this;
        }

        public a a(float f2) {
            this.f18780e = f2;
            return this;
        }

        public a a(int i2) {
            this.f18781f = i2;
            return this;
        }

        public a a(long j2) {
            this.f18776a = j2;
            return this;
        }

        public a a(Layout.Alignment alignment) {
            this.f18779d = alignment;
            return this;
        }

        public a a(SpannableStringBuilder spannableStringBuilder) {
            this.f18778c = spannableStringBuilder;
            return this;
        }

        public void a() {
            this.f18776a = 0L;
            this.f18777b = 0L;
            this.f18778c = null;
            this.f18779d = null;
            this.f18780e = Float.MIN_VALUE;
            this.f18781f = Integer.MIN_VALUE;
            this.f18782g = Integer.MIN_VALUE;
            this.f18783h = Float.MIN_VALUE;
            this.f18784i = Integer.MIN_VALUE;
            this.f18785j = Float.MIN_VALUE;
        }

        public a b(float f2) {
            this.f18783h = f2;
            return this;
        }

        public a b(int i2) {
            this.f18782g = i2;
            return this;
        }

        public a b(long j2) {
            this.f18777b = j2;
            return this;
        }

        public c b() {
            if (this.f18783h != Float.MIN_VALUE && this.f18784i == Integer.MIN_VALUE) {
                c();
            }
            return new c(this.f18776a, this.f18777b, this.f18778c, this.f18779d, this.f18780e, this.f18781f, this.f18782g, this.f18783h, this.f18784i, this.f18785j);
        }

        public a c(float f2) {
            this.f18785j = f2;
            return this;
        }

        public a c(int i2) {
            this.f18784i = i2;
            return this;
        }
    }

    public c(long j2, long j3, CharSequence charSequence) {
        this(j2, j3, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public c(long j2, long j3, CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4);
        this.m = j2;
        this.n = j3;
    }

    public c(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public boolean a() {
        return this.f18619d == Float.MIN_VALUE && this.f18622g == Float.MIN_VALUE;
    }
}
