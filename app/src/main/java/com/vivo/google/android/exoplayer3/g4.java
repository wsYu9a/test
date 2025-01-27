package com.vivo.google.android.exoplayer3;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.google.android.exoplayer3.text.Cue;
import java.util.LinkedList;
import java.util.List;
import kotlin.text.Typography;
import okio.Utf8;

/* loaded from: classes4.dex */
public final class g4 extends h4 {

    /* renamed from: f */
    public final n6 f27423f = new n6();

    /* renamed from: g */
    public final m6 f27424g = new m6();

    /* renamed from: h */
    public final int f27425h;

    /* renamed from: i */
    public final a[] f27426i;

    /* renamed from: j */
    public a f27427j;
    public List<Cue> k;
    public List<Cue> l;
    public b m;
    public int n;

    public static final class a {
        public static final int[] A;
        public static final int[] B;
        public static final boolean[] C;
        public static final int[] D;
        public static final int[] E;
        public static final int[] F;
        public static final int[] G;
        public static final int w = a(2, 2, 2, 0);
        public static final int x;
        public static final int y;
        public static final int[] z;

        /* renamed from: a */
        public final List<SpannableString> f27428a = new LinkedList();

        /* renamed from: b */
        public final SpannableStringBuilder f27429b = new SpannableStringBuilder();

        /* renamed from: c */
        public boolean f27430c;

        /* renamed from: d */
        public boolean f27431d;

        /* renamed from: e */
        public int f27432e;

        /* renamed from: f */
        public boolean f27433f;

        /* renamed from: g */
        public int f27434g;

        /* renamed from: h */
        public int f27435h;

        /* renamed from: i */
        public int f27436i;

        /* renamed from: j */
        public int f27437j;
        public boolean k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;

        static {
            int a2 = a(0, 0, 0, 0);
            x = a2;
            int a3 = a(0, 0, 0, 3);
            y = a3;
            z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{a2, a3, a2, a2, a3, a2, a2};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{a2, a2, a2, a2, a2, a3, a3};
        }

        public a() {
            d();
        }

        public static int a(int i2, int i3, int i4, int i5) {
            g1.a(i2, 0, 4);
            g1.a(i3, 0, 4);
            g1.a(i4, 0, 4);
            g1.a(i5, 0, 4);
            return Color.argb(i5 != 2 ? i5 != 3 ? 255 : 0 : 127, i2 > 1 ? 255 : 0, i3 > 1 ? 255 : 0, i4 > 1 ? 255 : 0);
        }

        public SpannableString a() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f27429b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, length, 33);
                }
                if (this.r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.r, length, 33);
                }
                if (this.t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.u), this.t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void a(char c2) {
            if (c2 != '\n') {
                this.f27429b.append(c2);
                return;
            }
            this.f27428a.add(a());
            this.f27429b.clear();
            if (this.p != -1) {
                this.p = 0;
            }
            if (this.q != -1) {
                this.q = 0;
            }
            if (this.r != -1) {
                this.r = 0;
            }
            if (this.t != -1) {
                this.t = 0;
            }
            while (true) {
                if ((!this.k || this.f27428a.size() < this.f27437j) && this.f27428a.size() < 15) {
                    return;
                } else {
                    this.f27428a.remove(0);
                }
            }
        }

        public void a(int i2, int i3) {
            if (this.r != -1 && this.s != i2) {
                this.f27429b.setSpan(new ForegroundColorSpan(this.s), this.r, this.f27429b.length(), 33);
            }
            if (i2 != w) {
                this.r = this.f27429b.length();
                this.s = i2;
            }
            if (this.t != -1 && this.u != i3) {
                this.f27429b.setSpan(new BackgroundColorSpan(this.u), this.t, this.f27429b.length(), 33);
            }
            if (i3 != x) {
                this.t = this.f27429b.length();
                this.u = i3;
            }
        }

        public void a(boolean z2, boolean z3) {
            if (this.p != -1) {
                if (!z2) {
                    this.f27429b.setSpan(new StyleSpan(2), this.p, this.f27429b.length(), 33);
                    this.p = -1;
                }
            } else if (z2) {
                this.p = this.f27429b.length();
            }
            if (this.q == -1) {
                if (z3) {
                    this.q = this.f27429b.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.f27429b.setSpan(new UnderlineSpan(), this.q, this.f27429b.length(), 33);
                this.q = -1;
            }
        }

        public void b() {
            this.f27428a.clear();
            this.f27429b.clear();
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.t = -1;
            this.v = 0;
        }

        public boolean c() {
            return !this.f27430c || (this.f27428a.isEmpty() && this.f27429b.length() == 0);
        }

        public void d() {
            b();
            this.f27430c = false;
            this.f27431d = false;
            this.f27432e = 4;
            this.f27433f = false;
            this.f27434g = 0;
            this.f27435h = 0;
            this.f27436i = 0;
            this.f27437j = 15;
            this.k = true;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            int i2 = x;
            this.o = i2;
            this.s = w;
            this.u = i2;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f27438a;

        /* renamed from: b */
        public final int f27439b;

        /* renamed from: c */
        public final byte[] f27440c;

        /* renamed from: d */
        public int f27441d = 0;

        public b(int i2, int i3) {
            this.f27438a = i2;
            this.f27439b = i3;
            this.f27440c = new byte[(i3 * 2) - 1];
        }
    }

    public g4(int i2) {
        this.f27425h = i2 == -1 ? 1 : i2;
        this.f27426i = new a[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f27426i[i3] = new a();
        }
        this.f27427j = this.f27426i[0];
        g();
    }

    @Override // com.vivo.google.android.exoplayer3.h4
    public void a(c4 c4Var) {
        this.f27423f.a(c4Var.f28192c.array(), c4Var.f28192c.limit());
        while (this.f27423f.a() >= 3) {
            int l = this.f27423f.l() & 7;
            int i2 = l & 3;
            boolean z = (l & 4) == 4;
            byte l2 = (byte) this.f27423f.l();
            byte l3 = (byte) this.f27423f.l();
            if (i2 == 2 || i2 == 3) {
                if (z) {
                    if (i2 == 3) {
                        e();
                        int i3 = (l2 & 192) >> 6;
                        int i4 = l2 & Utf8.REPLACEMENT_BYTE;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        b bVar = new b(i3, i4);
                        this.m = bVar;
                        byte[] bArr = bVar.f27440c;
                        int i5 = bVar.f27441d;
                        bVar.f27441d = i5 + 1;
                        bArr[i5] = l3;
                    } else {
                        g1.a(i2 == 2);
                        b bVar2 = this.m;
                        if (bVar2 != null) {
                            byte[] bArr2 = bVar2.f27440c;
                            int i6 = bVar2.f27441d;
                            int i7 = i6 + 1;
                            bVar2.f27441d = i7;
                            bArr2[i6] = l2;
                            bVar2.f27441d = i7 + 1;
                            bArr2[i7] = l3;
                        }
                    }
                    b bVar3 = this.m;
                    if (bVar3.f27441d == (bVar3.f27439b * 2) - 1) {
                        e();
                    }
                }
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void e() {
        a aVar;
        char c2;
        m6 m6Var;
        int i2;
        a aVar2;
        char c3;
        a aVar3;
        char c4;
        b bVar = this.m;
        if (bVar == null) {
            return;
        }
        int i3 = bVar.f27441d;
        if (i3 != (bVar.f27439b * 2) - 1) {
            String str = "DtvCcPacket ended prematurely; size is " + ((this.m.f27439b * 2) - 1) + ", but current index is " + this.m.f27441d + " (sequence number " + this.m.f27438a + "); ignoring packet";
        } else {
            m6 m6Var2 = this.f27424g;
            m6Var2.f27770a = bVar.f27440c;
            m6Var2.f27771b = 0;
            m6Var2.f27772c = 0;
            m6Var2.f27773d = i3;
            int a2 = m6Var2.a(3);
            int a3 = this.f27424g.a(5);
            int i4 = 7;
            int i5 = 6;
            if (a2 == 7) {
                this.f27424g.c(2);
                a2 += this.f27424g.a(6);
            }
            if (a3 == 0) {
                if (a2 != 0) {
                    String str2 = "serviceNumber is non-zero (" + a2 + ") when blockSize is 0";
                }
            } else if (a2 == this.f27425h) {
                boolean z = false;
                while (this.f27424g.b() > 0) {
                    int a4 = this.f27424g.a(8);
                    if (a4 == 16) {
                        int a5 = this.f27424g.a(8);
                        if (a5 <= 31) {
                            if (a5 > 7) {
                                if (a5 <= 15) {
                                    this.f27424g.c(8);
                                } else if (a5 <= 23) {
                                    this.f27424g.c(16);
                                } else if (a5 <= 31) {
                                    this.f27424g.c(24);
                                }
                            }
                        } else if (a5 <= 127) {
                            if (a5 == 32) {
                                aVar2 = this.f27427j;
                                c3 = ' ';
                            } else if (a5 == 33) {
                                aVar2 = this.f27427j;
                                c3 = Typography.nbsp;
                            } else if (a5 == 37) {
                                aVar2 = this.f27427j;
                                c3 = Typography.ellipsis;
                            } else if (a5 == 42) {
                                aVar2 = this.f27427j;
                                c3 = 352;
                            } else if (a5 == 44) {
                                aVar2 = this.f27427j;
                                c3 = 338;
                            } else if (a5 == 63) {
                                aVar2 = this.f27427j;
                                c3 = 376;
                            } else if (a5 == 57) {
                                aVar2 = this.f27427j;
                                c3 = Typography.tm;
                            } else if (a5 == 58) {
                                aVar2 = this.f27427j;
                                c3 = 353;
                            } else if (a5 == 60) {
                                aVar2 = this.f27427j;
                                c3 = 339;
                            } else if (a5 != 61) {
                                switch (a5) {
                                    case 48:
                                        aVar2 = this.f27427j;
                                        c3 = 9608;
                                        break;
                                    case 49:
                                        aVar2 = this.f27427j;
                                        c3 = Typography.leftSingleQuote;
                                        break;
                                    case 50:
                                        aVar2 = this.f27427j;
                                        c3 = Typography.rightSingleQuote;
                                        break;
                                    case 51:
                                        aVar2 = this.f27427j;
                                        c3 = Typography.leftDoubleQuote;
                                        break;
                                    case 52:
                                        aVar2 = this.f27427j;
                                        c3 = Typography.rightDoubleQuote;
                                        break;
                                    case 53:
                                        aVar2 = this.f27427j;
                                        c3 = Typography.bullet;
                                        break;
                                    default:
                                        switch (a5) {
                                            case 118:
                                                aVar2 = this.f27427j;
                                                c3 = 8539;
                                                break;
                                            case 119:
                                                aVar2 = this.f27427j;
                                                c3 = 8540;
                                                break;
                                            case 120:
                                                aVar2 = this.f27427j;
                                                c3 = 8541;
                                                break;
                                            case 121:
                                                aVar2 = this.f27427j;
                                                c3 = 8542;
                                                break;
                                            case 122:
                                                aVar2 = this.f27427j;
                                                c3 = 9474;
                                                break;
                                            case 123:
                                                aVar2 = this.f27427j;
                                                c3 = 9488;
                                                break;
                                            case 124:
                                                aVar2 = this.f27427j;
                                                c3 = 9492;
                                                break;
                                            case 125:
                                                aVar2 = this.f27427j;
                                                c3 = 9472;
                                                break;
                                            case org.mozilla.universalchardet.prober.o.a.n /* 126 */:
                                                aVar2 = this.f27427j;
                                                c3 = 9496;
                                                break;
                                            case 127:
                                                aVar2 = this.f27427j;
                                                c3 = 9484;
                                                break;
                                            default:
                                                String str3 = "Invalid G2 character: " + a5;
                                                break;
                                        }
                                }
                                z = true;
                            } else {
                                aVar2 = this.f27427j;
                                c3 = 8480;
                            }
                            aVar2.a(c3);
                            z = true;
                        } else if (a5 <= 159) {
                            if (a5 <= 135) {
                                m6Var = this.f27424g;
                                i2 = 32;
                            } else if (a5 <= 143) {
                                m6Var = this.f27424g;
                                i2 = 40;
                            } else if (a5 <= 159) {
                                this.f27424g.c(2);
                                this.f27424g.c(this.f27424g.a(6) * 8);
                            }
                            m6Var.c(i2);
                        } else if (a5 <= 255) {
                            if (a5 == 160) {
                                aVar = this.f27427j;
                                c2 = 13252;
                            } else {
                                String str4 = "Invalid G3 character: " + a5;
                                aVar = this.f27427j;
                                c2 = '_';
                            }
                            aVar.a(c2);
                            z = true;
                        } else {
                            String str5 = "Invalid extended command: " + a5;
                        }
                    } else if (a4 > 31) {
                        if (a4 <= 127) {
                            if (a4 == 127) {
                                aVar3 = this.f27427j;
                                c4 = 9835;
                            } else {
                                aVar3 = this.f27427j;
                                c4 = (char) (a4 & 255);
                            }
                            aVar3.a(c4);
                        } else {
                            if (a4 <= 159) {
                                switch (a4) {
                                    case 128:
                                    case 129:
                                    case org.mozilla.universalchardet.prober.n.c.m /* 130 */:
                                    case TTAdConstant.IMAGE_MODE_SPLASH /* 131 */:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                        int i6 = a4 - 128;
                                        if (this.n != i6) {
                                            this.n = i6;
                                            this.f27427j = this.f27426i[i6];
                                            break;
                                        }
                                        break;
                                    case 136:
                                        for (int i7 = 1; i7 <= 8; i7++) {
                                            if (this.f27424g.d()) {
                                                this.f27426i[8 - i7].b();
                                            }
                                        }
                                        break;
                                    case 137:
                                        for (int i8 = 1; i8 <= 8; i8++) {
                                            if (this.f27424g.d()) {
                                                this.f27426i[8 - i8].f27431d = true;
                                            }
                                        }
                                        break;
                                    case 138:
                                        for (int i9 = 1; i9 <= 8; i9++) {
                                            if (this.f27424g.d()) {
                                                this.f27426i[8 - i9].f27431d = false;
                                            }
                                        }
                                        break;
                                    case 139:
                                        for (int i10 = 1; i10 <= 8; i10++) {
                                            if (this.f27424g.d()) {
                                                this.f27426i[8 - i10].f27431d = !r3.f27431d;
                                            }
                                        }
                                        break;
                                    case 140:
                                        for (int i11 = 1; i11 <= 8; i11++) {
                                            if (this.f27424g.d()) {
                                                this.f27426i[8 - i11].d();
                                            }
                                        }
                                        break;
                                    case 141:
                                        this.f27424g.c(8);
                                        break;
                                    case org.mozilla.universalchardet.prober.n.a.p /* 142 */:
                                        break;
                                    case org.mozilla.universalchardet.prober.n.a.q /* 143 */:
                                        g();
                                        break;
                                    case 144:
                                        if (this.f27427j.f27430c) {
                                            this.f27424g.a(4);
                                            this.f27424g.a(2);
                                            this.f27424g.a(2);
                                            boolean d2 = this.f27424g.d();
                                            boolean d3 = this.f27424g.d();
                                            this.f27424g.a(3);
                                            this.f27424g.a(3);
                                            this.f27427j.a(d2, d3);
                                            break;
                                        }
                                        this.f27424g.c(16);
                                        break;
                                    case 145:
                                        if (this.f27427j.f27430c) {
                                            int a6 = a.a(this.f27424g.a(2), this.f27424g.a(2), this.f27424g.a(2), this.f27424g.a(2));
                                            int a7 = a.a(this.f27424g.a(2), this.f27424g.a(2), this.f27424g.a(2), this.f27424g.a(2));
                                            this.f27424g.c(2);
                                            a.a(this.f27424g.a(2), this.f27424g.a(2), this.f27424g.a(2), 0);
                                            this.f27427j.a(a6, a7);
                                            break;
                                        } else {
                                            this.f27424g.c(24);
                                            break;
                                        }
                                    case 146:
                                        if (this.f27427j.f27430c) {
                                            this.f27424g.c(4);
                                            int a8 = this.f27424g.a(4);
                                            this.f27424g.c(2);
                                            this.f27424g.a(6);
                                            a aVar4 = this.f27427j;
                                            if (aVar4.v != a8) {
                                                aVar4.a('\n');
                                            }
                                            aVar4.v = a8;
                                            break;
                                        }
                                        this.f27424g.c(16);
                                        break;
                                    case 147:
                                    case 148:
                                    case 149:
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE /* 150 */:
                                    default:
                                        String str6 = "Invalid C1 command: " + a4;
                                        break;
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META /* 151 */:
                                        if (this.f27427j.f27430c) {
                                            int a9 = a.a(this.f27424g.a(2), this.f27424g.a(2), this.f27424g.a(2), this.f27424g.a(2));
                                            this.f27424g.a(2);
                                            a.a(this.f27424g.a(2), this.f27424g.a(2), this.f27424g.a(2), 0);
                                            this.f27424g.d();
                                            this.f27424g.d();
                                            this.f27424g.a(2);
                                            this.f27424g.a(2);
                                            int a10 = this.f27424g.a(2);
                                            this.f27424g.c(8);
                                            a aVar5 = this.f27427j;
                                            aVar5.o = a9;
                                            aVar5.l = a10;
                                            break;
                                        } else {
                                            this.f27424g.c(32);
                                            break;
                                        }
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META /* 152 */:
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND /* 153 */:
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND /* 154 */:
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND /* 155 */:
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL /* 156 */:
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META /* 157 */:
                                    case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT /* 158 */:
                                    case 159:
                                        int i12 = a4 - 152;
                                        a aVar6 = this.f27426i[i12];
                                        this.f27424g.c(2);
                                        boolean d4 = this.f27424g.d();
                                        boolean d5 = this.f27424g.d();
                                        this.f27424g.d();
                                        int a11 = this.f27424g.a(3);
                                        boolean d6 = this.f27424g.d();
                                        int a12 = this.f27424g.a(i4);
                                        int a13 = this.f27424g.a(8);
                                        int a14 = this.f27424g.a(4);
                                        int a15 = this.f27424g.a(4);
                                        this.f27424g.c(2);
                                        this.f27424g.a(i5);
                                        this.f27424g.c(2);
                                        int a16 = this.f27424g.a(3);
                                        int a17 = this.f27424g.a(3);
                                        aVar6.f27430c = true;
                                        aVar6.f27431d = d4;
                                        aVar6.k = d5;
                                        aVar6.f27432e = a11;
                                        aVar6.f27433f = d6;
                                        aVar6.f27434g = a12;
                                        aVar6.f27435h = a13;
                                        aVar6.f27436i = a14;
                                        int i13 = a15 + 1;
                                        if (aVar6.f27437j != i13) {
                                            aVar6.f27437j = i13;
                                            while (true) {
                                                if ((d5 && aVar6.f27428a.size() >= aVar6.f27437j) || aVar6.f27428a.size() >= 15) {
                                                    aVar6.f27428a.remove(0);
                                                }
                                            }
                                        }
                                        if (a16 != 0 && aVar6.m != a16) {
                                            aVar6.m = a16;
                                            int i14 = a16 - 1;
                                            int i15 = a.D[i14];
                                            boolean z2 = a.C[i14];
                                            int i16 = a.A[i14];
                                            int i17 = a.B[i14];
                                            int i18 = a.z[i14];
                                            aVar6.o = i15;
                                            aVar6.l = i18;
                                        }
                                        if (a17 != 0 && aVar6.n != a17) {
                                            aVar6.n = a17;
                                            int i19 = a17 - 1;
                                            int i20 = a.F[i19];
                                            int i21 = a.E[i19];
                                            aVar6.a(false, false);
                                            aVar6.a(a.w, a.G[i19]);
                                        }
                                        if (this.n != i12) {
                                            this.n = i12;
                                            this.f27427j = this.f27426i[i12];
                                            break;
                                        }
                                        break;
                                }
                            } else if (a4 <= 255) {
                                this.f27427j.a((char) (a4 & 255));
                            } else {
                                String str7 = "Invalid base command: " + a4;
                            }
                            z = true;
                        }
                        z = true;
                    } else if (a4 != 0) {
                        if (a4 == 3) {
                            this.k = f();
                        } else if (a4 != 8) {
                            switch (a4) {
                                case 12:
                                    g();
                                    break;
                                case 13:
                                    this.f27427j.a('\n');
                                    break;
                                case 14:
                                    break;
                                default:
                                    if (a4 < 17 || a4 > 23) {
                                        if (a4 < 24 || a4 > 31) {
                                            String str8 = "Invalid C0 command: " + a4;
                                            break;
                                        } else {
                                            String str9 = "Currently unsupported COMMAND_P16 Command: " + a4;
                                            this.f27424g.c(16);
                                            break;
                                        }
                                    } else {
                                        String str10 = "Currently unsupported COMMAND_EXT1 Command: " + a4;
                                        this.f27424g.c(8);
                                        break;
                                    }
                            }
                        } else {
                            a aVar7 = this.f27427j;
                            int length = aVar7.f27429b.length();
                            if (length > 0) {
                                aVar7.f27429b.delete(length - 1, length);
                            }
                        }
                    }
                    i4 = 7;
                    i5 = 6;
                }
                if (z) {
                    this.k = f();
                }
            }
        }
        this.m = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.vivo.google.android.exoplayer3.text.Cue> f() {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.g4.f():java.util.List");
    }

    @Override // com.vivo.google.android.exoplayer3.h4, com.vivo.google.android.exoplayer3.v
    public void flush() {
        super.flush();
        this.k = null;
        this.l = null;
        this.n = 0;
        this.f27427j = this.f27426i[0];
        g();
        this.m = null;
    }

    public final void g() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f27426i[i2].d();
        }
    }
}
