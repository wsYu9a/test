package com.opos.exoplayer.core.f.a;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.opos.exoplayer.core.f.h;
import com.opos.exoplayer.core.f.i;
import com.opos.exoplayer.core.i.m;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.o;
import com.vivo.advv.Color;
import com.vivo.ic.BuildConfig;
import com.vivo.ic.dm.Downloads;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes4.dex */
public final class a extends e {

    /* renamed from: a */
    private static final int[] f18559a = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: b */
    private static final int[] f18560b = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: c */
    private static final int[] f18561c = {-1, Color.GREEN, Color.BLUE, Color.CYAN, -65536, -256, Color.MAGENTA};

    /* renamed from: d */
    private static final int[] f18562d = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, g.k, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, org.mozilla.universalchardet.prober.n.c.o, 9632};

    /* renamed from: e */
    private static final int[] f18563e = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, g.f35436i, g.l, g.p, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION};

    /* renamed from: f */
    private static final int[] f18564f = {Downloads.Impl.STATUS_PAUSED_BY_APP, 201, AdEventType.VIDEO_LOADING, 218, 220, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 8216, 161, 42, 39, o.a.C, 169, 8480, 8226, 8220, 8221, Downloads.Impl.STATUS_RUNNING, Downloads.Impl.STATUS_WAITING_TO_RETRY, 199, 200, 202, 203, g.f35437j, 206, 207, 239, AdEventType.VIDEO_PRELOADED, 217, 249, BuildConfig.VERSION_CODE, 171, 187};

    /* renamed from: g */
    private static final int[] f18565g = {Downloads.Impl.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, 236, 210, 242, AdEventType.VIDEO_PRELOAD_ERROR, g.q, 123, 125, 92, 94, 95, 124, org.mozilla.universalchardet.prober.o.a.n, 196, 228, 214, g.r, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: i */
    private final int f18567i;

    /* renamed from: j */
    private final int f18568j;
    private List<com.opos.exoplayer.core.f.b> m;
    private List<com.opos.exoplayer.core.f.b> n;
    private int o;
    private int p;
    private boolean q;
    private byte r;
    private byte s;

    /* renamed from: h */
    private final m f18566h = new m();
    private final ArrayList<C0409a> k = new ArrayList<>();
    private C0409a l = new C0409a(0, 4);

    /* renamed from: com.opos.exoplayer.core.f.a.a$a */
    private static class C0409a {

        /* renamed from: a */
        private final List<CharacterStyle> f18569a = new ArrayList();

        /* renamed from: b */
        private final List<C0410a> f18570b = new ArrayList();

        /* renamed from: c */
        private final List<SpannableString> f18571c = new ArrayList();

        /* renamed from: d */
        private final SpannableStringBuilder f18572d = new SpannableStringBuilder();

        /* renamed from: e */
        private int f18573e;

        /* renamed from: f */
        private int f18574f;

        /* renamed from: g */
        private int f18575g;

        /* renamed from: h */
        private int f18576h;

        /* renamed from: i */
        private int f18577i;

        /* renamed from: j */
        private int f18578j;

        /* renamed from: com.opos.exoplayer.core.f.a.a$a$a */
        private static class C0410a {

            /* renamed from: a */
            public final CharacterStyle f18579a;

            /* renamed from: b */
            public final int f18580b;

            /* renamed from: c */
            public final int f18581c;

            public C0410a(CharacterStyle characterStyle, int i2, int i3) {
                this.f18579a = characterStyle;
                this.f18580b = i2;
                this.f18581c = i3;
            }
        }

        public C0409a(int i2, int i3) {
            a(i2);
            b(i3);
        }

        public void a(char c2) {
            this.f18572d.append(c2);
        }

        public void a(int i2) {
            this.f18576h = i2;
            this.f18569a.clear();
            this.f18570b.clear();
            this.f18571c.clear();
            this.f18572d.clear();
            this.f18573e = 15;
            this.f18574f = 0;
            this.f18575g = 0;
            this.f18578j = -1;
        }

        public void a(CharacterStyle characterStyle) {
            this.f18569a.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i2) {
            this.f18570b.add(new C0410a(characterStyle, this.f18572d.length(), i2));
        }

        public void a(boolean z) {
            if (z) {
                this.f18578j = this.f18572d.length();
            } else if (this.f18578j != -1) {
                this.f18572d.setSpan(new UnderlineSpan(), this.f18578j, this.f18572d.length(), 33);
                this.f18578j = -1;
            }
        }

        public boolean a() {
            return this.f18569a.isEmpty() && this.f18570b.isEmpty() && this.f18571c.isEmpty() && this.f18572d.length() == 0;
        }

        public void b() {
            int length = this.f18572d.length();
            if (length > 0) {
                this.f18572d.delete(length - 1, length);
            }
        }

        public void b(int i2) {
            this.f18577i = i2;
        }

        public int c() {
            return this.f18573e;
        }

        public void c(int i2) {
            this.f18573e = i2;
        }

        public void d() {
            this.f18571c.add(e());
            this.f18572d.clear();
            this.f18569a.clear();
            this.f18570b.clear();
            this.f18578j = -1;
            int min = Math.min(this.f18577i, this.f18573e);
            while (this.f18571c.size() >= min) {
                this.f18571c.remove(0);
            }
        }

        public void d(int i2) {
            this.f18574f = i2;
        }

        public SpannableString e() {
            int length = this.f18572d.length();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18569a.size(); i3++) {
                this.f18572d.setSpan(this.f18569a.get(i3), 0, length, 33);
            }
            while (i2 < this.f18570b.size()) {
                C0410a c0410a = this.f18570b.get(i2);
                int size = this.f18570b.size();
                int i4 = c0410a.f18581c;
                this.f18572d.setSpan(c0410a.f18579a, c0410a.f18580b, i2 < size - i4 ? this.f18570b.get(i4 + i2).f18580b : length, 33);
                i2++;
            }
            if (this.f18578j != -1) {
                this.f18572d.setSpan(new UnderlineSpan(), this.f18578j, length, 33);
            }
            return new SpannableString(this.f18572d);
        }

        public void e(int i2) {
            this.f18575g = i2;
        }

        public com.opos.exoplayer.core.f.b f() {
            float f2;
            int i2;
            int i3;
            int i4;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f18571c.size(); i5++) {
                spannableStringBuilder.append((CharSequence) this.f18571c.get(i5));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) e());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i6 = this.f18574f + this.f18575g;
            int length = (32 - i6) - spannableStringBuilder.length();
            int i7 = i6 - length;
            if (this.f18576h == 2 && (Math.abs(i7) < 3 || length < 0)) {
                f2 = 0.5f;
                i2 = 1;
            } else if (this.f18576h != 2 || i7 <= 0) {
                f2 = ((i6 / 32.0f) * 0.8f) + 0.1f;
                i2 = 0;
            } else {
                f2 = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i2 = 2;
            }
            if (this.f18576h == 1 || (i3 = this.f18573e) > 7) {
                i3 = (this.f18573e - 15) - 2;
                i4 = 2;
            } else {
                i4 = 0;
            }
            return new com.opos.exoplayer.core.f.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i3, 1, i4, f2, i2, Float.MIN_VALUE);
        }

        public String toString() {
            return this.f18572d.toString();
        }
    }

    public a(String str, int i2) {
        this.f18567i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 3 || i2 == 4) {
            this.f18568j = 2;
        } else {
            this.f18568j = 1;
        }
        a(0);
        j();
    }

    private void a(byte b2) {
        this.l.a((b2 & 1) == 1);
        int i2 = (b2 >> 1) & 15;
        if (i2 != 7) {
            this.l.a(new ForegroundColorSpan(f18561c[i2]), 1);
        } else {
            this.l.a(new StyleSpan(2), 2);
            this.l.a(new ForegroundColorSpan(-1), 1);
        }
    }

    private void a(int i2) {
        int i3 = this.o;
        if (i3 == i2) {
            return;
        }
        this.o = i2;
        j();
        if (i3 == 3 || i2 == 1 || i2 == 0) {
            this.m = null;
        }
    }

    private boolean a(byte b2, byte b3) {
        boolean g2 = g(b2);
        if (g2) {
            if (this.q && this.r == b2 && this.s == b3) {
                this.q = false;
                return true;
            }
            this.q = true;
            this.r = b2;
            this.s = b3;
        }
        if (c(b2, b3)) {
            a(b3);
            return g2;
        }
        if (d(b2, b3)) {
            b(b2, b3);
            return g2;
        }
        if (e(b2, b3)) {
            this.l.e(b3 - 32);
            return g2;
        }
        if (!f(b2, b3)) {
            return g2;
        }
        b(b3);
        return g2;
    }

    private void b(byte b2) {
        if (b2 == 32) {
            a(2);
        }
        if (b2 == 41) {
            a(3);
            return;
        }
        switch (b2) {
            case 37:
                a(1);
                b(2);
                break;
            case 38:
                a(1);
                b(3);
                break;
            case 39:
                a(1);
                b(4);
                break;
            default:
                int i2 = this.o;
                if (i2 != 0) {
                    if (b2 == 33) {
                        this.l.b();
                        break;
                    } else {
                        switch (b2) {
                            case 44:
                                this.m = null;
                                if (i2 != 1 && i2 != 3) {
                                }
                                break;
                            case 45:
                                if (i2 == 1 && !this.l.a()) {
                                    this.l.d();
                                    break;
                                }
                                break;
                            case 47:
                                this.m = i();
                                break;
                        }
                        j();
                        break;
                    }
                }
                break;
        }
    }

    private void b(byte b2, byte b3) {
        int i2 = f18559a[b2 & 7];
        if ((b3 & g.s) != 0) {
            i2++;
        }
        if (i2 != this.l.c()) {
            if (this.o != 1 && !this.l.a()) {
                C0409a c0409a = new C0409a(this.o, this.p);
                this.l = c0409a;
                this.k.add(c0409a);
            }
            this.l.c(i2);
        }
        if ((b3 & 1) == 1) {
            this.l.a(new UnderlineSpan());
        }
        int i3 = (b3 >> 1) & 15;
        if (i3 > 7) {
            this.l.d(f18560b[i3 & 7]);
        } else if (i3 != 7) {
            this.l.a(new ForegroundColorSpan(f18561c[i3]));
        } else {
            this.l.a(new StyleSpan(2));
            this.l.a(new ForegroundColorSpan(-1));
        }
    }

    private void b(int i2) {
        this.p = i2;
        this.l.b(i2);
    }

    private static char c(byte b2) {
        return (char) f18562d[(b2 & ByteCompanionObject.MAX_VALUE) - 32];
    }

    private static boolean c(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static char d(byte b2) {
        return (char) f18563e[b2 & 15];
    }

    private static boolean d(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static char e(byte b2) {
        return (char) f18564f[b2 & 31];
    }

    private static boolean e(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static char f(byte b2) {
        return (char) f18565g[b2 & 31];
    }

    private static boolean f(byte b2, byte b3) {
        return (b2 & 247) == 20 && (b3 & 240) == 32;
    }

    private static boolean g(byte b2) {
        return (b2 & 240) == 16;
    }

    private List<com.opos.exoplayer.core.f.b> i() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            com.opos.exoplayer.core.f.b f2 = this.k.get(i2).f();
            if (f2 != null) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    private void j() {
        this.l.a(this.o);
        this.k.clear();
        this.k.add(this.l);
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.f.e
    public /* bridge */ /* synthetic */ void a(long j2) {
        super.a(j2);
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected void a(h hVar) {
        int i2;
        C0409a c0409a;
        char c2;
        this.f18566h.a(hVar.f17739b.array(), hVar.f17739b.limit());
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int b2 = this.f18566h.b();
            int i3 = this.f18567i;
            if (b2 < i3) {
                break;
            }
            byte g2 = i3 == 2 ? (byte) -4 : (byte) this.f18566h.g();
            byte g3 = (byte) (this.f18566h.g() & 127);
            byte g4 = (byte) (this.f18566h.g() & 127);
            if ((g2 & 6) == 4 && ((i2 = this.f18568j) != 1 || (g2 & 1) == 0)) {
                if (i2 != 2 || (g2 & 1) == 1) {
                    if (g3 != 0 || g4 != 0) {
                        if ((g3 & 247) == 17 && (g4 & 240) == 48) {
                            c0409a = this.l;
                            c2 = d(g4);
                        } else if ((g3 & 246) == 18 && (g4 & 224) == 32) {
                            this.l.b();
                            if ((g3 & 1) == 0) {
                                c0409a = this.l;
                                c2 = e(g4);
                            } else {
                                c0409a = this.l;
                                c2 = f(g4);
                            }
                        } else {
                            if ((g3 & 224) == 0) {
                                z2 = a(g3, g4);
                            } else {
                                this.l.a(c(g3));
                                if ((g4 & 224) != 0) {
                                    c0409a = this.l;
                                    c2 = c(g4);
                                }
                            }
                            z = true;
                        }
                        c0409a.a(c2);
                        z = true;
                    }
                }
            }
        }
        if (z) {
            if (!z2) {
                this.q = false;
            }
            int i4 = this.o;
            if (i4 == 1 || i4 == 3) {
                this.m = i();
            }
        }
    }

    @Override // com.opos.exoplayer.core.f.a.e
    /* renamed from: b */
    public /* bridge */ /* synthetic */ void a(h hVar) {
        super.a(hVar);
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.b.c
    public void c() {
        super.c();
        this.m = null;
        this.n = null;
        a(0);
        b(4);
        j();
        this.q = false;
        byte b2 = (byte) 0;
        this.r = b2;
        this.s = b2;
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.b.c
    public void d() {
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected boolean e() {
        return this.m != this.n;
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected com.opos.exoplayer.core.f.d f() {
        List<com.opos.exoplayer.core.f.b> list = this.m;
        this.n = list;
        return new f(list);
    }

    @Override // com.opos.exoplayer.core.f.a.e
    /* renamed from: g */
    public /* bridge */ /* synthetic */ i b() {
        return super.b();
    }

    @Override // com.opos.exoplayer.core.f.a.e
    /* renamed from: h */
    public /* bridge */ /* synthetic */ h a() {
        return super.a();
    }
}
