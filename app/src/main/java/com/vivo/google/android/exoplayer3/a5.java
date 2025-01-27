package com.vivo.google.android.exoplayer3;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.vivo.google.android.exoplayer3.text.Cue;

/* loaded from: classes4.dex */
public final class a5 extends Cue {

    /* renamed from: a */
    public final long f27136a;

    /* renamed from: b */
    public final long f27137b;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27138a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f27138a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27138a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27138a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class b {

        /* renamed from: a */
        public long f27139a;

        /* renamed from: b */
        public long f27140b;

        /* renamed from: c */
        public SpannableStringBuilder f27141c;

        /* renamed from: d */
        public Layout.Alignment f27142d;

        /* renamed from: e */
        public float f27143e;

        /* renamed from: f */
        public int f27144f;

        /* renamed from: g */
        public int f27145g;

        /* renamed from: h */
        public float f27146h;

        /* renamed from: i */
        public int f27147i;

        /* renamed from: j */
        public float f27148j;

        public b() {
            b();
        }

        public a5 a() {
            if (this.f27146h != Float.MIN_VALUE) {
                int i2 = Integer.MIN_VALUE;
                if (this.f27147i == Integer.MIN_VALUE) {
                    Layout.Alignment alignment = this.f27142d;
                    if (alignment != null) {
                        int i3 = a.f27138a[alignment.ordinal()];
                        i2 = 0;
                        if (i3 != 1) {
                            if (i3 == 2) {
                                this.f27147i = 1;
                            } else if (i3 != 3) {
                                String str = "Unrecognized alignment: " + this.f27142d;
                            } else {
                                this.f27147i = 2;
                            }
                        }
                    }
                    this.f27147i = i2;
                }
            }
            return new a5(this.f27139a, this.f27140b, this.f27141c, this.f27142d, this.f27143e, this.f27144f, this.f27145g, this.f27146h, this.f27147i, this.f27148j);
        }

        public void b() {
            this.f27139a = 0L;
            this.f27140b = 0L;
            this.f27141c = null;
            this.f27142d = null;
            this.f27143e = Float.MIN_VALUE;
            this.f27144f = Integer.MIN_VALUE;
            this.f27145g = Integer.MIN_VALUE;
            this.f27146h = Float.MIN_VALUE;
            this.f27147i = Integer.MIN_VALUE;
            this.f27148j = Float.MIN_VALUE;
        }
    }

    public a5(long j2, long j3, CharSequence charSequence) {
        this(j2, j3, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public a5(long j2, long j3, CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4);
        this.f27136a = j2;
        this.f27137b = j3;
    }
}
