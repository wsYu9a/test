package com.vivo.google.android.exoplayer3;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.vivo.google.android.exoplayer3.d1;
import com.vivo.google.android.exoplayer3.metadata.Metadata;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class e1 {

    /* renamed from: a */
    public static final int f27331a = Util.getIntegerCodeForString("vide");

    /* renamed from: b */
    public static final int f27332b = Util.getIntegerCodeForString("soun");

    /* renamed from: c */
    public static final int f27333c = Util.getIntegerCodeForString(com.baidu.mobads.sdk.internal.a.f5473b);

    /* renamed from: d */
    public static final int f27334d = Util.getIntegerCodeForString("sbtl");

    /* renamed from: e */
    public static final int f27335e = Util.getIntegerCodeForString("subt");

    /* renamed from: f */
    public static final int f27336f = Util.getIntegerCodeForString("clcp");

    /* renamed from: g */
    public static final int f27337g = Util.getIntegerCodeForString("cenc");

    /* renamed from: h */
    public static final int f27338h = Util.getIntegerCodeForString(TTDownloadField.TT_META);

    public static final class a {

        /* renamed from: a */
        public final int f27339a;

        /* renamed from: b */
        public int f27340b;

        /* renamed from: c */
        public int f27341c;

        /* renamed from: d */
        public long f27342d;

        /* renamed from: e */
        public final boolean f27343e;

        /* renamed from: f */
        public final n6 f27344f;

        /* renamed from: g */
        public final n6 f27345g;

        /* renamed from: h */
        public int f27346h;

        /* renamed from: i */
        public int f27347i;

        public a(n6 n6Var, n6 n6Var2, boolean z) {
            this.f27345g = n6Var;
            this.f27344f = n6Var2;
            this.f27343e = z;
            n6Var2.d(12);
            this.f27339a = n6Var2.o();
            n6Var.d(12);
            this.f27347i = n6Var.o();
            g1.b(n6Var.c() == 1, "first_chunk must be 1");
            this.f27340b = -1;
        }

        public boolean a() {
            int i2 = this.f27340b + 1;
            this.f27340b = i2;
            if (i2 == this.f27339a) {
                return false;
            }
            this.f27342d = this.f27343e ? this.f27344f.p() : this.f27344f.m();
            if (this.f27340b == this.f27346h) {
                this.f27341c = this.f27345g.o();
                this.f27345g.e(4);
                int i3 = this.f27347i - 1;
                this.f27347i = i3;
                this.f27346h = i3 > 0 ? this.f27345g.o() - 1 : -1;
            }
            return true;
        }
    }

    public interface b {
        int a();

        boolean b();

        int c();
    }

    public static final class c {

        /* renamed from: a */
        public final m1[] f27348a;

        /* renamed from: b */
        public Format f27349b;

        /* renamed from: c */
        public int f27350c;

        /* renamed from: d */
        public int f27351d = 0;

        public c(int i2) {
            this.f27348a = new m1[i2];
        }
    }

    public static final class d implements b {

        /* renamed from: a */
        public final int f27352a;

        /* renamed from: b */
        public final int f27353b;

        /* renamed from: c */
        public final n6 f27354c;

        public d(d1.b bVar) {
            n6 n6Var = bVar.P0;
            this.f27354c = n6Var;
            n6Var.d(12);
            this.f27352a = n6Var.o();
            this.f27353b = n6Var.o();
        }

        @Override // com.vivo.google.android.exoplayer3.e1.b
        public int a() {
            int i2 = this.f27352a;
            return i2 == 0 ? this.f27354c.o() : i2;
        }

        @Override // com.vivo.google.android.exoplayer3.e1.b
        public boolean b() {
            return this.f27352a != 0;
        }

        @Override // com.vivo.google.android.exoplayer3.e1.b
        public int c() {
            return this.f27353b;
        }
    }

    public static final class e implements b {

        /* renamed from: a */
        public final n6 f27355a;

        /* renamed from: b */
        public final int f27356b;

        /* renamed from: c */
        public final int f27357c;

        /* renamed from: d */
        public int f27358d;

        /* renamed from: e */
        public int f27359e;

        public e(d1.b bVar) {
            n6 n6Var = bVar.P0;
            this.f27355a = n6Var;
            n6Var.d(12);
            this.f27357c = n6Var.o() & 255;
            this.f27356b = n6Var.o();
        }

        @Override // com.vivo.google.android.exoplayer3.e1.b
        public int a() {
            int i2 = this.f27357c;
            if (i2 == 8) {
                return this.f27355a.l();
            }
            if (i2 == 16) {
                return this.f27355a.q();
            }
            int i3 = this.f27358d;
            this.f27358d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f27359e & 15;
            }
            int l = this.f27355a.l();
            this.f27359e = l;
            return (l & org.mozilla.universalchardet.prober.g.n) >> 4;
        }

        @Override // com.vivo.google.android.exoplayer3.e1.b
        public boolean b() {
            return false;
        }

        @Override // com.vivo.google.android.exoplayer3.e1.b
        public int c() {
            return this.f27356b;
        }
    }

    public static int a(n6 n6Var) {
        int l = n6Var.l();
        int i2 = l & 127;
        while ((l & 128) == 128) {
            l = n6Var.l();
            i2 = (i2 << 7) | (l & 127);
        }
        return i2;
    }

    public static Pair<String, byte[]> a(n6 n6Var, int i2) {
        n6Var.d(i2 + 8 + 4);
        n6Var.e(1);
        a(n6Var);
        n6Var.e(2);
        int l = n6Var.l();
        if ((l & 128) != 0) {
            n6Var.e(2);
        }
        if ((l & 64) != 0) {
            n6Var.e(n6Var.q());
        }
        if ((l & 32) != 0) {
            n6Var.e(2);
        }
        n6Var.e(1);
        a(n6Var);
        int l2 = n6Var.l();
        String str = null;
        if (l2 == 32) {
            str = "video/mp4v-es";
        } else if (l2 == 33) {
            str = "video/avc";
        } else if (l2 != 35) {
            if (l2 != 64) {
                if (l2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (l2 == 165) {
                    str = "audio/ac3";
                } else if (l2 != 166) {
                    switch (l2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (l2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        n6Var.e(12);
        n6Var.e(1);
        int a2 = a(n6Var);
        byte[] bArr = new byte[a2];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, a2);
        n6Var.f27875b += a2;
        return Pair.create(str, bArr);
    }

    public static int a(n6 n6Var, int i2, int i3, c cVar, int i4) {
        int i5 = n6Var.f27875b;
        while (true) {
            if (i5 - i2 >= i3) {
                return 0;
            }
            n6Var.d(i5);
            int c2 = n6Var.c();
            int i6 = 1;
            g1.a(c2 > 0, "childAtomSize should be positive");
            if (n6Var.c() == d1.W) {
                int i7 = i5 + 8;
                Pair pair = null;
                Integer num = null;
                m1 m1Var = null;
                boolean z = false;
                while (i7 - i5 < c2) {
                    n6Var.d(i7);
                    int c3 = n6Var.c();
                    int c4 = n6Var.c();
                    if (c4 == d1.c0) {
                        num = Integer.valueOf(n6Var.c());
                    } else if (c4 == d1.X) {
                        n6Var.e(4);
                        z = n6Var.c() == f27337g;
                    } else if (c4 == d1.Y) {
                        int i8 = i7 + 8;
                        while (true) {
                            if (i8 - i7 >= c3) {
                                m1Var = null;
                                break;
                            }
                            n6Var.d(i8);
                            int c5 = n6Var.c();
                            if (n6Var.c() == d1.Z) {
                                n6Var.e(6);
                                boolean z2 = n6Var.l() == i6;
                                int l = n6Var.l();
                                byte[] bArr = new byte[16];
                                System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, 16);
                                n6Var.f27875b += 16;
                                m1Var = new m1(z2, l, bArr);
                            } else {
                                i8 += c5;
                                i6 = 1;
                            }
                        }
                    }
                    i7 += c3;
                    i6 = 1;
                }
                if (z) {
                    g1.a(num != null, "frma atom is mandatory");
                    g1.a(m1Var != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, m1Var);
                }
                if (pair != null) {
                    cVar.f27348a[i4] = (m1) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            i5 += c2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:408:0x00a0, code lost:
    
        if (r8 == 0) goto L488;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.google.android.exoplayer3.l1 a(com.vivo.google.android.exoplayer3.d1.a r46, com.vivo.google.android.exoplayer3.d1.b r47, long r48, com.vivo.google.android.exoplayer3.drm.DrmInitData r50, boolean r51) {
        /*
            Method dump skipped, instructions count: 1993
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.e1.a(com.vivo.google.android.exoplayer3.d1$a, com.vivo.google.android.exoplayer3.d1$b, long, com.vivo.google.android.exoplayer3.drm.DrmInitData, boolean):com.vivo.google.android.exoplayer3.l1");
    }

    public static Metadata a(d1.b bVar, boolean z) {
        if (z) {
            return null;
        }
        n6 n6Var = bVar.P0;
        n6Var.d(8);
        while (n6Var.a() >= 8) {
            int i2 = n6Var.f27875b;
            int c2 = n6Var.c();
            if (n6Var.c() == d1.B0) {
                n6Var.d(i2);
                int i3 = i2 + c2;
                n6Var.e(12);
                while (true) {
                    int i4 = n6Var.f27875b;
                    if (i4 >= i3) {
                        return null;
                    }
                    int c3 = n6Var.c();
                    if (n6Var.c() == d1.C0) {
                        n6Var.d(i4);
                        int i5 = i4 + c3;
                        n6Var.e(8);
                        ArrayList arrayList = new ArrayList();
                        while (n6Var.f27875b < i5) {
                            Metadata.Entry b2 = i1.b(n6Var);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new Metadata(arrayList);
                    }
                    n6Var.e(c3 - 8);
                }
            } else {
                n6Var.e(c2 - 8);
            }
        }
        return null;
    }
}
