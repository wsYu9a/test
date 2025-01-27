package com.opos.exoplayer.core.f.a;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.opos.exoplayer.core.f.h;
import com.opos.exoplayer.core.f.i;
import com.opos.exoplayer.core.i.l;
import com.opos.exoplayer.core.i.m;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.text.Typography;
import okio.Utf8;

/* loaded from: classes4.dex */
public final class b extends e {

    /* renamed from: a */
    private final m f18582a = new m();

    /* renamed from: b */
    private final l f18583b = new l();

    /* renamed from: c */
    private final int f18584c;

    /* renamed from: d */
    private final a[] f18585d;

    /* renamed from: e */
    private a f18586e;

    /* renamed from: f */
    private List<com.opos.exoplayer.core.f.b> f18587f;

    /* renamed from: g */
    private List<com.opos.exoplayer.core.f.b> f18588g;

    /* renamed from: h */
    private C0411b f18589h;

    /* renamed from: i */
    private int f18590i;

    private static final class a {

        /* renamed from: a */
        public static final int f18591a = a(2, 2, 2, 0);

        /* renamed from: b */
        public static final int f18592b;

        /* renamed from: c */
        public static final int f18593c;

        /* renamed from: d */
        private static final int[] f18594d;

        /* renamed from: e */
        private static final int[] f18595e;

        /* renamed from: f */
        private static final int[] f18596f;

        /* renamed from: g */
        private static final boolean[] f18597g;

        /* renamed from: h */
        private static final int[] f18598h;

        /* renamed from: i */
        private static final int[] f18599i;

        /* renamed from: j */
        private static final int[] f18600j;
        private static final int[] k;
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private final List<SpannableString> l = new LinkedList();
        private final SpannableStringBuilder m = new SpannableStringBuilder();
        private boolean n;
        private boolean o;
        private int p;
        private boolean q;
        private int r;
        private int s;
        private int t;
        private int u;
        private boolean v;
        private int w;
        private int x;
        private int y;
        private int z;

        static {
            int a2 = a(0, 0, 0, 0);
            f18592b = a2;
            int a3 = a(0, 0, 0, 3);
            f18593c = a3;
            f18594d = new int[]{0, 0, 0, 0, 0, 2, 0};
            f18595e = new int[]{0, 0, 0, 0, 0, 0, 2};
            f18596f = new int[]{3, 3, 3, 3, 3, 3, 1};
            f18597g = new boolean[]{false, false, false, true, true, true, false};
            f18598h = new int[]{a2, a3, a2, a2, a3, a2, a2};
            f18599i = new int[]{0, 1, 2, 3, 4, 3, 4};
            f18600j = new int[]{0, 0, 0, 0, 0, 3, 3};
            k = new int[]{a2, a2, a2, a2, a2, a3, a3};
        }

        public a() {
            b();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int a(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.opos.exoplayer.core.i.a.a(r4, r0, r1)
                com.opos.exoplayer.core.i.a.a(r5, r0, r1)
                com.opos.exoplayer.core.i.a.a(r6, r0, r1)
                com.opos.exoplayer.core.i.a.a(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L21
                if (r7 == r1) goto L21
                r3 = 2
                if (r7 == r3) goto L1e
                r3 = 3
                if (r7 == r3) goto L1c
                goto L21
            L1c:
                r7 = 0
                goto L23
            L1e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L23
            L21:
                r7 = 255(0xff, float:3.57E-43)
            L23:
                if (r4 <= r1) goto L28
                r4 = 255(0xff, float:3.57E-43)
                goto L29
            L28:
                r4 = 0
            L29:
                if (r5 <= r1) goto L2e
                r5 = 255(0xff, float:3.57E-43)
                goto L2f
            L2e:
                r5 = 0
            L2f:
                if (r6 <= r1) goto L33
                r0 = 255(0xff, float:3.57E-43)
            L33:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.a.b.a.a(int, int, int, int):int");
        }

        public static int b(int i2, int i3, int i4) {
            return a(i2, i3, i4, 0);
        }

        public void a(char c2) {
            if (c2 != '\n') {
                this.m.append(c2);
                return;
            }
            this.l.add(g());
            this.m.clear();
            if (this.A != -1) {
                this.A = 0;
            }
            if (this.B != -1) {
                this.B = 0;
            }
            if (this.C != -1) {
                this.C = 0;
            }
            if (this.E != -1) {
                this.E = 0;
            }
            while (true) {
                if ((!this.v || this.l.size() < this.u) && this.l.size() < 15) {
                    return;
                } else {
                    this.l.remove(0);
                }
            }
        }

        public void a(int i2, int i3) {
            if (this.G != i2) {
                a('\n');
            }
            this.G = i2;
        }

        public void a(int i2, int i3, int i4) {
            if (this.C != -1 && this.D != i2) {
                this.m.setSpan(new ForegroundColorSpan(this.D), this.C, this.m.length(), 33);
            }
            if (i2 != f18591a) {
                this.C = this.m.length();
                this.D = i2;
            }
            if (this.E != -1 && this.F != i3) {
                this.m.setSpan(new BackgroundColorSpan(this.F), this.E, this.m.length(), 33);
            }
            if (i3 != f18592b) {
                this.E = this.m.length();
                this.F = i3;
            }
        }

        public void a(int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
            if (this.A != -1) {
                if (!z) {
                    this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
                    this.A = -1;
                }
            } else if (z) {
                this.A = this.m.length();
            }
            if (this.B == -1) {
                if (z2) {
                    this.B = this.m.length();
                }
            } else {
                if (z2) {
                    return;
                }
                this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
                this.B = -1;
            }
        }

        public void a(int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
            this.z = i2;
            this.w = i7;
        }

        public void a(boolean z) {
            this.o = z;
        }

        public void a(boolean z, boolean z2, boolean z3, int i2, boolean z4, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.n = true;
            this.o = z;
            this.v = z2;
            this.p = i2;
            this.q = z4;
            this.r = i3;
            this.s = i4;
            this.t = i7;
            int i10 = i5 + 1;
            if (this.u != i10) {
                this.u = i10;
                while (true) {
                    if ((!z2 || this.l.size() < this.u) && this.l.size() < 15) {
                        break;
                    } else {
                        this.l.remove(0);
                    }
                }
            }
            if (i8 != 0 && this.x != i8) {
                this.x = i8;
                int i11 = i8 - 1;
                a(f18598h[i11], f18593c, f18597g[i11], 0, f18595e[i11], f18596f[i11], f18594d[i11]);
            }
            if (i9 == 0 || this.y == i9) {
                return;
            }
            this.y = i9;
            int i12 = i9 - 1;
            a(0, 1, 1, false, false, f18600j[i12], f18599i[i12]);
            a(f18591a, k[i12], f18592b);
        }

        public boolean a() {
            return !d() || (this.l.isEmpty() && this.m.length() == 0);
        }

        public void b() {
            c();
            this.n = false;
            this.o = false;
            this.p = 4;
            this.q = false;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 15;
            this.v = true;
            this.w = 0;
            this.x = 0;
            this.y = 0;
            int i2 = f18592b;
            this.z = i2;
            this.D = f18591a;
            this.F = i2;
        }

        public void c() {
            this.l.clear();
            this.m.clear();
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.E = -1;
            this.G = 0;
        }

        public boolean d() {
            return this.n;
        }

        public boolean e() {
            return this.o;
        }

        public void f() {
            int length = this.m.length();
            if (length > 0) {
                this.m.delete(length - 1, length);
            }
        }

        public SpannableString g() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.A, length, 33);
                }
                if (this.B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.B, length, 33);
                }
                if (this.C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, length, 33);
                }
                if (this.E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.opos.exoplayer.core.f.a.d h() {
            /*
                Method dump skipped, instructions count: 195
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.a.b.a.h():com.opos.exoplayer.core.f.a.d");
        }
    }

    /* renamed from: com.opos.exoplayer.core.f.a.b$b */
    private static final class C0411b {

        /* renamed from: a */
        public final int f18601a;

        /* renamed from: b */
        public final int f18602b;

        /* renamed from: c */
        public final byte[] f18603c;

        /* renamed from: d */
        int f18604d = 0;

        public C0411b(int i2, int i3) {
            this.f18601a = i2;
            this.f18602b = i3;
            this.f18603c = new byte[(i3 * 2) - 1];
        }
    }

    public b(int i2) {
        this.f18584c = i2 == -1 ? 1 : i2;
        this.f18585d = new a[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f18585d[i3] = new a();
        }
        this.f18586e = this.f18585d[0];
        p();
    }

    private void a(int i2) {
        l lVar;
        if (i2 != 0) {
            if (i2 == 3) {
                this.f18587f = o();
            }
            int i3 = 8;
            if (i2 == 8) {
                this.f18586e.f();
                return;
            }
            switch (i2) {
                case 12:
                    p();
                    break;
                case 13:
                    this.f18586e.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i2 >= 17 && i2 <= 23) {
                        com.opos.cmn.an.f.a.c("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i2);
                        lVar = this.f18583b;
                    } else if (i2 < 24 || i2 > 31) {
                        com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid C0 command: " + i2);
                        break;
                    } else {
                        com.opos.cmn.an.f.a.c("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i2);
                        lVar = this.f18583b;
                        i3 = 16;
                    }
                    lVar.b(i3);
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(int i2) {
        a aVar;
        l lVar;
        int i3 = 16;
        int i4 = 1;
        switch (i2) {
            case 128:
            case 129:
            case org.mozilla.universalchardet.prober.n.c.m /* 130 */:
            case TTAdConstant.IMAGE_MODE_SPLASH /* 131 */:
            case 132:
            case 133:
            case 134:
            case 135:
                int i5 = i2 - 128;
                if (this.f18590i != i5) {
                    this.f18590i = i5;
                    aVar = this.f18585d[i5];
                    this.f18586e = aVar;
                    break;
                }
                break;
            case 136:
                while (i4 <= 8) {
                    if (this.f18583b.e()) {
                        this.f18585d[8 - i4].c();
                    }
                    i4++;
                }
                break;
            case 137:
                for (int i6 = 1; i6 <= 8; i6++) {
                    if (this.f18583b.e()) {
                        this.f18585d[8 - i6].a(true);
                    }
                }
                break;
            case 138:
                while (i4 <= 8) {
                    if (this.f18583b.e()) {
                        this.f18585d[8 - i4].a(false);
                    }
                    i4++;
                }
                break;
            case 139:
                for (int i7 = 1; i7 <= 8; i7++) {
                    if (this.f18583b.e()) {
                        this.f18585d[8 - i7].a(!r0.e());
                    }
                }
                break;
            case 140:
                while (i4 <= 8) {
                    if (this.f18583b.e()) {
                        this.f18585d[8 - i4].b();
                    }
                    i4++;
                }
                break;
            case 141:
                this.f18583b.b(8);
                break;
            case org.mozilla.universalchardet.prober.n.a.p /* 142 */:
                break;
            case org.mozilla.universalchardet.prober.n.a.q /* 143 */:
                p();
                break;
            case 144:
                if (this.f18586e.d()) {
                    k();
                    break;
                }
                lVar = this.f18583b;
                lVar.b(i3);
                break;
            case 145:
                if (this.f18586e.d()) {
                    l();
                    break;
                } else {
                    lVar = this.f18583b;
                    i3 = 24;
                    lVar.b(i3);
                    break;
                }
            case 146:
                if (this.f18586e.d()) {
                    m();
                    break;
                }
                lVar = this.f18583b;
                lVar.b(i3);
                break;
            case 147:
            case 148:
            case 149:
            case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE /* 150 */:
            default:
                com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid C1 command: " + i2);
                break;
            case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META /* 151 */:
                if (this.f18586e.d()) {
                    n();
                    break;
                } else {
                    lVar = this.f18583b;
                    i3 = 32;
                    lVar.b(i3);
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
                int i8 = i2 - 152;
                i(i8);
                if (this.f18590i != i8) {
                    this.f18590i = i8;
                    aVar = this.f18585d[i8];
                    this.f18586e = aVar;
                    break;
                }
                break;
        }
    }

    private void c(int i2) {
        l lVar;
        int i3;
        if (i2 <= 7) {
            return;
        }
        if (i2 <= 15) {
            lVar = this.f18583b;
            i3 = 8;
        } else if (i2 <= 23) {
            lVar = this.f18583b;
            i3 = 16;
        } else {
            if (i2 > 31) {
                return;
            }
            lVar = this.f18583b;
            i3 = 24;
        }
        lVar.b(i3);
    }

    private void d(int i2) {
        l lVar;
        int i3;
        if (i2 <= 135) {
            lVar = this.f18583b;
            i3 = 32;
        } else {
            if (i2 > 143) {
                if (i2 <= 159) {
                    this.f18583b.b(2);
                    this.f18583b.b(this.f18583b.c(6) * 8);
                    return;
                }
                return;
            }
            lVar = this.f18583b;
            i3 = 40;
        }
        lVar.b(i3);
    }

    private void e(int i2) {
        if (i2 == 127) {
            this.f18586e.a((char) 9835);
        } else {
            this.f18586e.a((char) (i2 & 255));
        }
    }

    private void f(int i2) {
        this.f18586e.a((char) (i2 & 255));
    }

    private void g(int i2) {
        a aVar;
        char c2 = ' ';
        if (i2 == 32) {
            aVar = this.f18586e;
        } else if (i2 == 33) {
            aVar = this.f18586e;
            c2 = Typography.nbsp;
        } else if (i2 == 37) {
            aVar = this.f18586e;
            c2 = Typography.ellipsis;
        } else if (i2 == 42) {
            aVar = this.f18586e;
            c2 = 352;
        } else if (i2 == 44) {
            aVar = this.f18586e;
            c2 = 338;
        } else if (i2 == 63) {
            aVar = this.f18586e;
            c2 = 376;
        } else if (i2 == 57) {
            aVar = this.f18586e;
            c2 = Typography.tm;
        } else if (i2 == 58) {
            aVar = this.f18586e;
            c2 = 353;
        } else if (i2 == 60) {
            aVar = this.f18586e;
            c2 = 339;
        } else if (i2 != 61) {
            switch (i2) {
                case 48:
                    aVar = this.f18586e;
                    c2 = 9608;
                    break;
                case 49:
                    aVar = this.f18586e;
                    c2 = Typography.leftSingleQuote;
                    break;
                case 50:
                    aVar = this.f18586e;
                    c2 = Typography.rightSingleQuote;
                    break;
                case 51:
                    aVar = this.f18586e;
                    c2 = Typography.leftDoubleQuote;
                    break;
                case 52:
                    aVar = this.f18586e;
                    c2 = Typography.rightDoubleQuote;
                    break;
                case 53:
                    aVar = this.f18586e;
                    c2 = Typography.bullet;
                    break;
                default:
                    switch (i2) {
                        case 118:
                            aVar = this.f18586e;
                            c2 = 8539;
                            break;
                        case 119:
                            aVar = this.f18586e;
                            c2 = 8540;
                            break;
                        case 120:
                            aVar = this.f18586e;
                            c2 = 8541;
                            break;
                        case 121:
                            aVar = this.f18586e;
                            c2 = 8542;
                            break;
                        case 122:
                            aVar = this.f18586e;
                            c2 = 9474;
                            break;
                        case 123:
                            aVar = this.f18586e;
                            c2 = 9488;
                            break;
                        case 124:
                            aVar = this.f18586e;
                            c2 = 9492;
                            break;
                        case 125:
                            aVar = this.f18586e;
                            c2 = 9472;
                            break;
                        case org.mozilla.universalchardet.prober.o.a.n /* 126 */:
                            aVar = this.f18586e;
                            c2 = 9496;
                            break;
                        case 127:
                            aVar = this.f18586e;
                            c2 = 9484;
                            break;
                        default:
                            com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid G2 character: " + i2);
                            return;
                    }
            }
        } else {
            aVar = this.f18586e;
            c2 = 8480;
        }
        aVar.a(c2);
    }

    private void h(int i2) {
        a aVar;
        char c2;
        if (i2 == 160) {
            aVar = this.f18586e;
            c2 = 13252;
        } else {
            com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid G3 character: " + i2);
            aVar = this.f18586e;
            c2 = '_';
        }
        aVar.a(c2);
    }

    private void i() {
        if (this.f18589h == null) {
            return;
        }
        j();
        this.f18589h = null;
    }

    private void i(int i2) {
        a aVar = this.f18585d[i2];
        this.f18583b.b(2);
        boolean e2 = this.f18583b.e();
        boolean e3 = this.f18583b.e();
        boolean e4 = this.f18583b.e();
        int c2 = this.f18583b.c(3);
        boolean e5 = this.f18583b.e();
        int c3 = this.f18583b.c(7);
        int c4 = this.f18583b.c(8);
        int c5 = this.f18583b.c(4);
        int c6 = this.f18583b.c(4);
        this.f18583b.b(2);
        int c7 = this.f18583b.c(6);
        this.f18583b.b(2);
        aVar.a(e2, e3, e4, c2, e5, c3, c4, c6, c7, c5, this.f18583b.c(3), this.f18583b.c(3));
    }

    private void j() {
        StringBuilder sb;
        String str;
        String str2;
        C0411b c0411b = this.f18589h;
        int i2 = c0411b.f18604d;
        if (i2 != (c0411b.f18602b * 2) - 1) {
            str2 = "DtvCcPacket ended prematurely; size is " + ((this.f18589h.f18602b * 2) - 1) + ", but current index is " + this.f18589h.f18604d + " (sequence number " + this.f18589h.f18601a + "); ignoring packet";
        } else {
            this.f18583b.a(c0411b.f18603c, i2);
            int c2 = this.f18583b.c(3);
            int c3 = this.f18583b.c(5);
            if (c2 == 7) {
                this.f18583b.b(2);
                c2 += this.f18583b.c(6);
            }
            if (c3 != 0) {
                if (c2 == this.f18584c) {
                    boolean z = false;
                    while (this.f18583b.a() > 0) {
                        int c4 = this.f18583b.c(8);
                        if (c4 == 16) {
                            c4 = this.f18583b.c(8);
                            if (c4 <= 31) {
                                c(c4);
                            } else {
                                if (c4 <= 127) {
                                    g(c4);
                                } else if (c4 <= 159) {
                                    d(c4);
                                } else if (c4 <= 255) {
                                    h(c4);
                                } else {
                                    sb = new StringBuilder();
                                    str = "Invalid extended command: ";
                                    sb.append(str);
                                    sb.append(c4);
                                    com.opos.cmn.an.f.a.c("Cea708Decoder", sb.toString());
                                }
                                z = true;
                            }
                        } else if (c4 <= 31) {
                            a(c4);
                        } else {
                            if (c4 <= 127) {
                                e(c4);
                            } else if (c4 <= 159) {
                                b(c4);
                            } else if (c4 <= 255) {
                                f(c4);
                            } else {
                                sb = new StringBuilder();
                                str = "Invalid base command: ";
                                sb.append(str);
                                sb.append(c4);
                                com.opos.cmn.an.f.a.c("Cea708Decoder", sb.toString());
                            }
                            z = true;
                        }
                    }
                    if (z) {
                        this.f18587f = o();
                        return;
                    }
                    return;
                }
                return;
            }
            if (c2 == 0) {
                return;
            }
            str2 = "serviceNumber is non-zero (" + c2 + ") when blockSize is 0";
        }
        com.opos.cmn.an.f.a.c("Cea708Decoder", str2);
    }

    private void k() {
        this.f18586e.a(this.f18583b.c(4), this.f18583b.c(2), this.f18583b.c(2), this.f18583b.e(), this.f18583b.e(), this.f18583b.c(3), this.f18583b.c(3));
    }

    private void l() {
        int a2 = a.a(this.f18583b.c(2), this.f18583b.c(2), this.f18583b.c(2), this.f18583b.c(2));
        int a3 = a.a(this.f18583b.c(2), this.f18583b.c(2), this.f18583b.c(2), this.f18583b.c(2));
        this.f18583b.b(2);
        this.f18586e.a(a2, a3, a.b(this.f18583b.c(2), this.f18583b.c(2), this.f18583b.c(2)));
    }

    private void m() {
        this.f18583b.b(4);
        int c2 = this.f18583b.c(4);
        this.f18583b.b(2);
        this.f18586e.a(c2, this.f18583b.c(6));
    }

    private void n() {
        int a2 = a.a(this.f18583b.c(2), this.f18583b.c(2), this.f18583b.c(2), this.f18583b.c(2));
        int c2 = this.f18583b.c(2);
        int b2 = a.b(this.f18583b.c(2), this.f18583b.c(2), this.f18583b.c(2));
        if (this.f18583b.e()) {
            c2 |= 4;
        }
        boolean e2 = this.f18583b.e();
        int c3 = this.f18583b.c(2);
        int c4 = this.f18583b.c(2);
        int c5 = this.f18583b.c(2);
        this.f18583b.b(8);
        this.f18586e.a(a2, b2, e2, c2, c3, c4, c5);
    }

    private List<com.opos.exoplayer.core.f.b> o() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f18585d[i2].a() && this.f18585d[i2].e()) {
                arrayList.add(this.f18585d[i2].h());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void p() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f18585d[i2].b();
        }
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.f.e
    public /* bridge */ /* synthetic */ void a(long j2) {
        super.a(j2);
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected void a(h hVar) {
        this.f18582a.a(hVar.f17739b.array(), hVar.f17739b.limit());
        while (this.f18582a.b() >= 3) {
            int g2 = this.f18582a.g() & 7;
            int i2 = g2 & 3;
            boolean z = (g2 & 4) == 4;
            byte g3 = (byte) this.f18582a.g();
            byte g4 = (byte) this.f18582a.g();
            if (i2 == 2 || i2 == 3) {
                if (z) {
                    if (i2 == 3) {
                        i();
                        int i3 = g3 & Utf8.REPLACEMENT_BYTE;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        C0411b c0411b = new C0411b((g3 & 192) >> 6, i3);
                        this.f18589h = c0411b;
                        byte[] bArr = c0411b.f18603c;
                        int i4 = c0411b.f18604d;
                        c0411b.f18604d = i4 + 1;
                        bArr[i4] = g4;
                    } else {
                        com.opos.exoplayer.core.i.a.a(i2 == 2);
                        C0411b c0411b2 = this.f18589h;
                        if (c0411b2 == null) {
                            com.opos.cmn.an.f.a.d("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0411b2.f18603c;
                            int i5 = c0411b2.f18604d;
                            int i6 = i5 + 1;
                            c0411b2.f18604d = i6;
                            bArr2[i5] = g3;
                            c0411b2.f18604d = i6 + 1;
                            bArr2[i6] = g4;
                        }
                    }
                    C0411b c0411b3 = this.f18589h;
                    if (c0411b3.f18604d == (c0411b3.f18602b * 2) - 1) {
                        i();
                    }
                }
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
        this.f18587f = null;
        this.f18588g = null;
        this.f18590i = 0;
        this.f18586e = this.f18585d[0];
        p();
        this.f18589h = null;
    }

    @Override // com.opos.exoplayer.core.f.a.e, com.opos.exoplayer.core.b.c
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected boolean e() {
        return this.f18587f != this.f18588g;
    }

    @Override // com.opos.exoplayer.core.f.a.e
    protected com.opos.exoplayer.core.f.d f() {
        List<com.opos.exoplayer.core.f.b> list = this.f18587f;
        this.f18588g = list;
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
