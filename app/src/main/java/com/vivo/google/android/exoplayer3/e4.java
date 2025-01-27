package com.vivo.google.android.exoplayer3;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.o;
import com.vivo.advv.Color;
import com.vivo.google.android.exoplayer3.text.Cue;
import com.vivo.ic.BuildConfig;
import com.vivo.ic.dm.Downloads;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
public final class e4 extends h4 {
    public static final int[] r = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] s = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] t = {-1, Color.GREEN, Color.BLUE, Color.CYAN, -65536, -256, Color.MAGENTA};
    public static final int[] u = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, org.mozilla.universalchardet.prober.g.k, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, org.mozilla.universalchardet.prober.n.c.o, 9632};
    public static final int[] v = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, org.mozilla.universalchardet.prober.g.f35436i, org.mozilla.universalchardet.prober.g.l, org.mozilla.universalchardet.prober.g.p, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION};
    public static final int[] w = {Downloads.Impl.STATUS_PAUSED_BY_APP, 201, AdEventType.VIDEO_LOADING, 218, 220, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 8216, 161, 42, 39, o.a.C, 169, 8480, 8226, 8220, 8221, Downloads.Impl.STATUS_RUNNING, Downloads.Impl.STATUS_WAITING_TO_RETRY, 199, 200, 202, 203, org.mozilla.universalchardet.prober.g.f35437j, 206, 207, 239, AdEventType.VIDEO_PRELOADED, 217, 249, BuildConfig.VERSION_CODE, 171, 187};
    public static final int[] x = {Downloads.Impl.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, 236, 210, 242, AdEventType.VIDEO_PRELOAD_ERROR, org.mozilla.universalchardet.prober.g.q, 123, 125, 92, 94, 95, 124, org.mozilla.universalchardet.prober.o.a.n, 196, 228, 214, org.mozilla.universalchardet.prober.g.r, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: g */
    public final int f27377g;

    /* renamed from: h */
    public final int f27378h;
    public List<Cue> k;
    public List<Cue> l;
    public int m;
    public int n;
    public boolean o;
    public byte p;
    public byte q;

    /* renamed from: f */
    public final n6 f27376f = new n6();

    /* renamed from: i */
    public final LinkedList<a> f27379i = new LinkedList<>();

    /* renamed from: j */
    public a f27380j = new a(0, 4);

    public static class a {

        /* renamed from: a */
        public final List<CharacterStyle> f27381a = new ArrayList();

        /* renamed from: b */
        public final List<C0567a> f27382b = new ArrayList();

        /* renamed from: c */
        public final List<SpannableString> f27383c = new LinkedList();

        /* renamed from: d */
        public final SpannableStringBuilder f27384d = new SpannableStringBuilder();

        /* renamed from: e */
        public int f27385e;

        /* renamed from: f */
        public int f27386f;

        /* renamed from: g */
        public int f27387g;

        /* renamed from: h */
        public int f27388h;

        /* renamed from: i */
        public int f27389i;

        /* renamed from: j */
        public int f27390j;

        /* renamed from: com.vivo.google.android.exoplayer3.e4$a$a */
        public static class C0567a {

            /* renamed from: a */
            public final CharacterStyle f27391a;

            /* renamed from: b */
            public final int f27392b;

            /* renamed from: c */
            public final int f27393c;

            public C0567a(CharacterStyle characterStyle, int i2, int i3) {
                this.f27391a = characterStyle;
                this.f27392b = i2;
                this.f27393c = i3;
            }
        }

        public a(int i2, int i3) {
            a(i2, i3);
        }

        public SpannableString a() {
            int length = this.f27384d.length();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f27381a.size(); i3++) {
                this.f27384d.setSpan(this.f27381a.get(i3), 0, length, 33);
            }
            while (i2 < this.f27382b.size()) {
                C0567a c0567a = this.f27382b.get(i2);
                int size = this.f27382b.size();
                int i4 = c0567a.f27393c;
                this.f27384d.setSpan(c0567a.f27391a, c0567a.f27392b, i2 < size - i4 ? this.f27382b.get(i4 + i2).f27392b : length, 33);
                i2++;
            }
            if (this.f27390j != -1) {
                this.f27384d.setSpan(new UnderlineSpan(), this.f27390j, length, 33);
            }
            return new SpannableString(this.f27384d);
        }

        public void a(int i2, int i3) {
            this.f27381a.clear();
            this.f27382b.clear();
            this.f27383c.clear();
            this.f27384d.clear();
            this.f27385e = 15;
            this.f27386f = 0;
            this.f27387g = 0;
            this.f27388h = i2;
            this.f27389i = i3;
            this.f27390j = -1;
        }

        public boolean b() {
            return this.f27381a.isEmpty() && this.f27382b.isEmpty() && this.f27383c.isEmpty() && this.f27384d.length() == 0;
        }

        public String toString() {
            return this.f27384d.toString();
        }
    }

    public e4(String str, int i2) {
        this.f27377g = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 3 || i2 == 4) {
            this.f27378h = 2;
        } else {
            this.f27378h = 1;
        }
        a(0);
        f();
    }

    public final void a(int i2) {
        int i3 = this.m;
        if (i3 == i2) {
            return;
        }
        this.m = i2;
        f();
        if (i3 == 3 || i2 == 1 || i2 == 0) {
            this.k = null;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.h4
    public void a(c4 c4Var) {
        int i2;
        a aVar;
        int i3;
        this.f27376f.a(c4Var.f28192c.array(), c4Var.f28192c.limit());
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int a2 = this.f27376f.a();
            int i4 = this.f27377g;
            if (a2 < i4) {
                break;
            }
            byte l = i4 == 2 ? (byte) -4 : (byte) this.f27376f.l();
            byte l2 = (byte) (this.f27376f.l() & 127);
            byte l3 = (byte) (this.f27376f.l() & 127);
            if ((l & 6) == 4 && ((i2 = this.f27378h) != 1 || (l & 1) == 0)) {
                if (i2 != 2 || (l & 1) == 1) {
                    if (l2 != 0 || l3 != 0) {
                        if ((l2 & 247) == 17 && (l3 & 240) == 48) {
                            aVar = this.f27380j;
                            i3 = v[l3 & 15];
                        } else if ((l2 & 246) == 18 && (l3 & 224) == 32) {
                            a aVar2 = this.f27380j;
                            int length = aVar2.f27384d.length();
                            if (length > 0) {
                                aVar2.f27384d.delete(length - 1, length);
                            }
                            if ((l2 & 1) == 0) {
                                aVar = this.f27380j;
                                i3 = w[l3 & 31];
                            } else {
                                aVar = this.f27380j;
                                i3 = x[l3 & 31];
                            }
                        } else {
                            if ((l2 & 224) == 0) {
                                z2 = a(l2, l3);
                            } else {
                                a aVar3 = this.f27380j;
                                int i5 = (l2 & ByteCompanionObject.MAX_VALUE) - 32;
                                int[] iArr = u;
                                aVar3.f27384d.append((char) iArr[i5]);
                                if ((l3 & 224) != 0) {
                                    aVar = this.f27380j;
                                    i3 = iArr[(l3 & ByteCompanionObject.MAX_VALUE) - 32];
                                }
                            }
                            z = true;
                        }
                        aVar.f27384d.append((char) i3);
                        z = true;
                    }
                }
            }
        }
        if (z) {
            if (!z2) {
                this.o = false;
            }
            int i6 = this.m;
            if (i6 == 1 || i6 == 3) {
                this.k = e();
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.h4
    public y3 c() {
        List<Cue> list = this.k;
        this.l = list;
        return new j4(list);
    }

    @Override // com.vivo.google.android.exoplayer3.h4
    public boolean d() {
        return this.k != this.l;
    }

    public final List<Cue> e() {
        float f2;
        int i2;
        int i3;
        Cue cue;
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f27379i.size(); i4++) {
            a aVar = this.f27379i.get(i4);
            aVar.getClass();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < aVar.f27383c.size(); i5++) {
                spannableStringBuilder.append((CharSequence) aVar.f27383c.get(i5));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) aVar.a());
            if (spannableStringBuilder.length() == 0) {
                cue = null;
            } else {
                int i6 = aVar.f27386f + aVar.f27387g;
                int length = i6 - ((32 - i6) - spannableStringBuilder.length());
                int i7 = 2;
                if (aVar.f27388h == 2 && Math.abs(length) < 3) {
                    f2 = 0.5f;
                    i2 = 1;
                } else if (aVar.f27388h != 2 || length <= 0) {
                    f2 = ((i6 / 32.0f) * 0.8f) + 0.1f;
                    i2 = 0;
                } else {
                    f2 = (((32 - r6) / 32.0f) * 0.8f) + 0.1f;
                    i2 = 2;
                }
                if (aVar.f27388h == 1 || (i3 = aVar.f27385e) > 7) {
                    i3 = (aVar.f27385e - 15) - 2;
                } else {
                    i7 = 0;
                }
                cue = new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i3, 1, i7, f2, i2, Float.MIN_VALUE);
            }
            if (cue != null) {
                arrayList.add(cue);
            }
        }
        return arrayList;
    }

    public final void f() {
        this.f27380j.a(this.m, this.n);
        this.f27379i.clear();
        this.f27379i.add(this.f27380j);
    }

    @Override // com.vivo.google.android.exoplayer3.h4, com.vivo.google.android.exoplayer3.v
    public void flush() {
        super.flush();
        this.k = null;
        this.l = null;
        a(0);
        f();
        this.n = 4;
        this.o = false;
        this.p = (byte) 0;
        this.q = (byte) 0;
    }

    @Override // com.vivo.google.android.exoplayer3.h4, com.vivo.google.android.exoplayer3.v
    public void release() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d1, code lost:
    
        if (r13 != 3) goto L228;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(byte r13, byte r14) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.e4.a(byte, byte):boolean");
    }
}
