package com.opos.exoplayer.core.c.b;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.o;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes4.dex */
public final class a implements com.opos.exoplayer.core.c.e {

    /* renamed from: a */
    public static final h f17789a = new h() { // from class: com.opos.exoplayer.core.c.b.a.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    };

    /* renamed from: b */
    private static final byte[] f17790b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, g.s, 45, 45, 62, g.s, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: c */
    private static final byte[] f17791c = {g.s, g.s, g.s, g.s, g.s, g.s, g.s, g.s, g.s, g.s, g.s, g.s};

    /* renamed from: d */
    private static final byte[] f17792d = u.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: e */
    private static final byte[] f17793e = {68, 105, 97, 108, 111, 103, 117, 101, 58, g.s, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: f */
    private static final byte[] f17794f = {g.s, g.s, g.s, g.s, g.s, g.s, g.s, g.s, g.s, g.s};

    /* renamed from: g */
    private static final UUID f17795g = new UUID(72057594037932032L, -9223371306706625679L);
    private b A;
    private boolean B;
    private int C;
    private long D;
    private boolean E;
    private long F;
    private long G;
    private long H;
    private com.opos.exoplayer.core.i.h I;
    private com.opos.exoplayer.core.i.h J;
    private boolean K;
    private int L;
    private long M;
    private long N;
    private int O;
    private int P;
    private int[] Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private byte Z;
    private int aa;
    private int ab;
    private int ac;

    /* renamed from: ad */
    private boolean f17796ad;
    private boolean ae;
    private com.opos.exoplayer.core.c.g af;

    /* renamed from: h */
    private final com.opos.exoplayer.core.c.b.c f17797h;

    /* renamed from: i */
    private final f f17798i;

    /* renamed from: j */
    private final SparseArray<b> f17799j;
    private final boolean k;
    private final m l;
    private final m m;
    private final m n;
    private final m o;
    private final m p;
    private final m q;
    private final m r;
    private final m s;
    private final m t;
    private ByteBuffer u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* renamed from: com.opos.exoplayer.core.c.b.a$1 */
    static final class AnonymousClass1 implements h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    }

    /* renamed from: com.opos.exoplayer.core.c.b.a$a */
    private final class C0399a implements d {
        private C0399a() {
        }

        /* synthetic */ C0399a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public int a(int i2) {
            return a.this.a(i2);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i2, double d2) {
            a.this.a(i2, d2);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i2, int i3, com.opos.exoplayer.core.c.f fVar) {
            a.this.a(i2, i3, fVar);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i2, long j2) {
            a.this.a(i2, j2);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i2, long j2, long j3) {
            a.this.a(i2, j2, j3);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i2, String str) {
            a.this.a(i2, str);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public boolean b(int i2) {
            return a.this.b(i2);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void c(int i2) {
            a.this.c(i2);
        }
    }

    private static final class b {
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public long J;
        public long K;

        @Nullable
        public c L;
        public boolean M;
        public boolean N;
        public n O;
        public int P;
        private String Q;

        /* renamed from: a */
        public String f17801a;

        /* renamed from: b */
        public int f17802b;

        /* renamed from: c */
        public int f17803c;

        /* renamed from: d */
        public int f17804d;

        /* renamed from: e */
        public boolean f17805e;

        /* renamed from: f */
        public byte[] f17806f;

        /* renamed from: g */
        public n.a f17807g;

        /* renamed from: h */
        public byte[] f17808h;

        /* renamed from: i */
        public DrmInitData f17809i;

        /* renamed from: j */
        public int f17810j;
        public int k;
        public int l;
        public int m;
        public int n;
        public byte[] o;
        public int p;
        public boolean q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public float w;
        public float x;
        public float y;
        public float z;

        private b() {
            this.f17810j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = null;
            this.p = -1;
            this.q = false;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 1000;
            this.v = 200;
            this.w = -1.0f;
            this.x = -1.0f;
            this.y = -1.0f;
            this.z = -1.0f;
            this.A = -1.0f;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 1;
            this.H = -1;
            this.I = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
            this.J = 0L;
            this.K = 0L;
            this.N = true;
            this.Q = "eng";
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        private static List<byte[]> a(m mVar) {
            try {
                mVar.d(16);
                if (mVar.n() != 826496599) {
                    return null;
                }
                byte[] bArr = mVar.f19048a;
                for (int d2 = mVar.d() + 20; d2 < bArr.length - 4; d2++) {
                    if (bArr[d2] == 0 && bArr[d2 + 1] == 0 && bArr[d2 + 2] == 1 && bArr[d2 + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, d2, bArr.length));
                    }
                }
                throw new o("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing FourCC VC1 codec private");
            }
        }

        private static List<byte[]> a(byte[] bArr) {
            try {
                if (bArr[0] != 2) {
                    throw new o("Error parsing vorbis codec private");
                }
                int i2 = 1;
                int i3 = 0;
                while (bArr[i2] == -1) {
                    i2++;
                    i3 += 255;
                }
                int i4 = i2 + 1;
                int i5 = i3 + bArr[i2];
                int i6 = 0;
                while (bArr[i4] == -1) {
                    i6 += 255;
                    i4++;
                }
                int i7 = i4 + 1;
                int i8 = bArr[i4];
                if (bArr[i7] != 1) {
                    throw new o("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, i7, bArr2, 0, i5);
                int i9 = i5 + i7;
                if (bArr[i9] != 3) {
                    throw new o("Error parsing vorbis codec private");
                }
                int i10 = i6 + i8 + i9;
                if (bArr[i10] != 5) {
                    throw new o("Error parsing vorbis codec private");
                }
                byte[] bArr3 = new byte[bArr.length - i10];
                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing vorbis codec private");
            }
        }

        private static boolean b(m mVar) {
            try {
                int i2 = mVar.i();
                if (i2 != 1) {
                    if (i2 != 65534) {
                        return false;
                    }
                    mVar.c(24);
                    if (mVar.q() != a.f17795g.getMostSignificantBits()) {
                        return false;
                    }
                    if (mVar.q() != a.f17795g.getLeastSignificantBits()) {
                        return false;
                    }
                }
                return true;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing MS/ACM codec private");
            }
        }

        private byte[] c() {
            if (this.w == -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
            wrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
            wrap.putShort((short) (this.E + 0.5f));
            wrap.putShort((short) (this.F + 0.5f));
            wrap.putShort((short) this.u);
            wrap.putShort((short) this.v);
            return bArr;
        }

        public void a() {
            c cVar = this.L;
            if (cVar != null) {
                cVar.a(this);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0330  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x033b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0361  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0332  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(com.opos.exoplayer.core.c.g r44, int r45) {
            /*
                Method dump skipped, instructions count: 1314
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.b.a.b.a(com.opos.exoplayer.core.c.g, int):void");
        }

        public void b() {
            c cVar = this.L;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    private static final class c {

        /* renamed from: a */
        private final byte[] f17811a = new byte[12];

        /* renamed from: b */
        private boolean f17812b;

        /* renamed from: c */
        private int f17813c;

        /* renamed from: d */
        private int f17814d;

        /* renamed from: e */
        private long f17815e;

        /* renamed from: f */
        private int f17816f;

        public void a() {
            this.f17812b = false;
        }

        public void a(b bVar) {
            if (!this.f17812b || this.f17813c <= 0) {
                return;
            }
            bVar.O.a(this.f17815e, this.f17816f, this.f17814d, 0, bVar.f17807g);
            this.f17813c = 0;
        }

        public void a(b bVar, long j2) {
            if (this.f17812b) {
                int i2 = this.f17813c;
                int i3 = i2 + 1;
                this.f17813c = i3;
                if (i2 == 0) {
                    this.f17815e = j2;
                }
                if (i3 >= 8) {
                    bVar.O.a(this.f17815e, this.f17816f, this.f17814d, 0, bVar.f17807g);
                    this.f17813c = 0;
                }
            }
        }

        public void a(com.opos.exoplayer.core.c.f fVar, int i2, int i3) {
            if (!this.f17812b) {
                fVar.c(this.f17811a, 0, 12);
                fVar.a();
                if (com.opos.exoplayer.core.a.a.b(this.f17811a) == -1) {
                    return;
                }
                this.f17812b = true;
                this.f17813c = 0;
            }
            if (this.f17813c == 0) {
                this.f17816f = i2;
                this.f17814d = 0;
            }
            this.f17814d += i3;
        }
    }

    public a() {
        this(0);
    }

    public a(int i2) {
        this(new com.opos.exoplayer.core.c.b.b(), i2);
    }

    a(com.opos.exoplayer.core.c.b.c cVar, int i2) {
        this.w = -1L;
        this.x = C.TIME_UNSET;
        this.y = C.TIME_UNSET;
        this.z = C.TIME_UNSET;
        this.F = -1L;
        this.G = -1L;
        this.H = C.TIME_UNSET;
        this.f17797h = cVar;
        cVar.a(new C0399a());
        this.k = (i2 & 1) == 0;
        this.f17798i = new f();
        this.f17799j = new SparseArray<>();
        this.n = new m(4);
        this.o = new m(ByteBuffer.allocate(4).putInt(-1).array());
        this.p = new m(4);
        this.l = new m(k.f19027a);
        this.m = new m(4);
        this.q = new m();
        this.r = new m();
        this.s = new m(8);
        this.t = new m();
    }

    private int a(com.opos.exoplayer.core.c.f fVar, n nVar, int i2) {
        int a2;
        int b2 = this.q.b();
        if (b2 > 0) {
            a2 = Math.min(i2, b2);
            nVar.a(this.q, a2);
        } else {
            a2 = nVar.a(fVar, i2, false);
        }
        this.U += a2;
        this.ac += a2;
        return a2;
    }

    private long a(long j2) {
        long j3 = this.x;
        if (j3 != C.TIME_UNSET) {
            return u.d(j2, j3, 1000L);
        }
        throw new o("Can't scale timecode prior to timecodeScale being set.");
    }

    private void a(b bVar, long j2) {
        c cVar = bVar.L;
        if (cVar != null) {
            cVar.a(bVar, j2);
        } else {
            if ("S_TEXT/UTF8".equals(bVar.f17801a)) {
                a(bVar, "%02d:%02d:%02d,%03d", 19, 1000L, f17791c);
            } else if ("S_TEXT/ASS".equals(bVar.f17801a)) {
                a(bVar, "%01d:%02d:%02d:%02d", 21, 10000L, f17794f);
            }
            bVar.O.a(j2, this.T, this.ac, 0, bVar.f17807g);
        }
        this.f17796ad = true;
        d();
    }

    private void a(b bVar, String str, int i2, long j2, byte[] bArr) {
        a(this.r.f19048a, this.N, str, i2, j2, bArr);
        n nVar = bVar.O;
        m mVar = this.r;
        nVar.a(mVar, mVar.c());
        this.ac += this.r.c();
    }

    private void a(com.opos.exoplayer.core.c.f fVar, int i2) {
        if (this.n.c() >= i2) {
            return;
        }
        if (this.n.e() < i2) {
            m mVar = this.n;
            byte[] bArr = mVar.f19048a;
            mVar.a(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i2)), this.n.c());
        }
        m mVar2 = this.n;
        fVar.b(mVar2.f19048a, mVar2.c(), i2 - this.n.c());
        this.n.b(i2);
    }

    private void a(com.opos.exoplayer.core.c.f fVar, b bVar, int i2) {
        int i3;
        if ("S_TEXT/UTF8".equals(bVar.f17801a)) {
            a(fVar, f17790b, i2);
            return;
        }
        if ("S_TEXT/ASS".equals(bVar.f17801a)) {
            a(fVar, f17793e, i2);
            return;
        }
        n nVar = bVar.O;
        if (!this.V) {
            if (bVar.f17805e) {
                this.T &= -1073741825;
                if (!this.W) {
                    fVar.b(this.n.f19048a, 0, 1);
                    this.U++;
                    if ((this.n.f19048a[0] & ByteCompanionObject.MIN_VALUE) == 128) {
                        throw new o("Extension bit is set in signal byte");
                    }
                    this.Z = r1[0];
                    this.W = true;
                }
                byte b2 = this.Z;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.T |= 1073741824;
                    if (!this.X) {
                        fVar.b(this.s.f19048a, 0, 8);
                        this.U += 8;
                        this.X = true;
                        m mVar = this.n;
                        mVar.f19048a[0] = (byte) ((z ? 128 : 0) | 8);
                        mVar.c(0);
                        nVar.a(this.n, 1);
                        this.ac++;
                        this.s.c(0);
                        nVar.a(this.s, 8);
                        this.ac += 8;
                    }
                    if (z) {
                        if (!this.Y) {
                            fVar.b(this.n.f19048a, 0, 1);
                            this.U++;
                            this.n.c(0);
                            this.aa = this.n.g();
                            this.Y = true;
                        }
                        int i4 = this.aa * 4;
                        this.n.a(i4);
                        fVar.b(this.n.f19048a, 0, i4);
                        this.U = i4 + this.U;
                        short s = (short) ((this.aa / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.u;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.u = ByteBuffer.allocate(i5);
                        }
                        this.u.position(0);
                        this.u.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i3 = this.aa;
                            if (i6 >= i3) {
                                break;
                            }
                            int u = this.n.u();
                            if (i6 % 2 == 0) {
                                this.u.putShort((short) (u - i7));
                            } else {
                                this.u.putInt(u - i7);
                            }
                            i6++;
                            i7 = u;
                        }
                        int i8 = (i2 - this.U) - i7;
                        int i9 = i3 % 2;
                        ByteBuffer byteBuffer2 = this.u;
                        if (i9 == 1) {
                            byteBuffer2.putInt(i8);
                        } else {
                            byteBuffer2.putShort((short) i8);
                            this.u.putInt(0);
                        }
                        this.t.a(this.u.array(), i5);
                        nVar.a(this.t, i5);
                        this.ac += i5;
                    }
                }
            } else {
                byte[] bArr = bVar.f17806f;
                if (bArr != null) {
                    this.q.a(bArr, bArr.length);
                }
            }
            this.V = true;
        }
        int c2 = this.q.c() + i2;
        if (!"V_MPEG4/ISO/AVC".equals(bVar.f17801a) && !"V_MPEGH/ISO/HEVC".equals(bVar.f17801a)) {
            if (bVar.L != null) {
                com.opos.exoplayer.core.i.a.b(this.q.c() == 0);
                bVar.L.a(fVar, this.T, c2);
            }
            while (true) {
                int i10 = this.U;
                if (i10 >= c2) {
                    break;
                } else {
                    a(fVar, nVar, c2 - i10);
                }
            }
        } else {
            byte[] bArr2 = this.m.f19048a;
            byte b3 = (byte) 0;
            bArr2[0] = b3;
            bArr2[1] = b3;
            bArr2[2] = b3;
            int i11 = bVar.P;
            while (this.U < c2) {
                int i12 = this.ab;
                if (i12 == 0) {
                    a(fVar, bArr2, 4 - i11, i11);
                    this.m.c(0);
                    this.ab = this.m.u();
                    this.l.c(0);
                    nVar.a(this.l, 4);
                    this.ac += 4;
                } else {
                    this.ab = i12 - a(fVar, nVar, i12);
                }
            }
        }
        if ("A_VORBIS".equals(bVar.f17801a)) {
            this.o.c(0);
            nVar.a(this.o, 4);
            this.ac += 4;
        }
    }

    private void a(com.opos.exoplayer.core.c.f fVar, byte[] bArr, int i2) {
        int length = bArr.length + i2;
        if (this.r.e() < length) {
            this.r.f19048a = Arrays.copyOf(bArr, length + i2);
        } else {
            System.arraycopy(bArr, 0, this.r.f19048a, 0, bArr.length);
        }
        fVar.b(this.r.f19048a, bArr.length, i2);
        this.r.a(length);
    }

    private void a(com.opos.exoplayer.core.c.f fVar, byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, this.q.b());
        fVar.b(bArr, i2 + min, i3 - min);
        if (min > 0) {
            this.q.a(bArr, i2, min);
        }
        this.U += i3;
    }

    private static void a(byte[] bArr, long j2, String str, int i2, long j3, byte[] bArr2) {
        byte[] c2;
        byte[] bArr3;
        if (j2 == C.TIME_UNSET) {
            c2 = bArr2;
            bArr3 = c2;
        } else {
            long j4 = j2 - ((r2 * SdkConfigData.DEFAULT_REQUEST_INTERVAL) * C.MICROS_PER_SECOND);
            int i3 = (int) (j4 / 60000000);
            long j5 = j4 - ((i3 * 60) * C.MICROS_PER_SECOND);
            int i4 = (int) (j5 / C.MICROS_PER_SECOND);
            c2 = u.c(String.format(Locale.US, str, Integer.valueOf((int) (j2 / 3600000000L)), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j5 - (i4 * C.MICROS_PER_SECOND)) / j3))));
            bArr3 = bArr2;
        }
        System.arraycopy(c2, 0, bArr, i2, bArr3.length);
    }

    private boolean a(com.opos.exoplayer.core.c.k kVar, long j2) {
        if (this.E) {
            this.G = j2;
            kVar.f18323a = this.F;
            this.E = false;
        } else {
            if (!this.B) {
                return false;
            }
            long j3 = this.G;
            if (j3 == -1) {
                return false;
            }
            kVar.f18323a = j3;
            this.G = -1L;
        }
        return true;
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] a(int[] iArr, int i2) {
        return iArr == null ? new int[i2] : iArr.length < i2 ? new int[Math.max(iArr.length * 2, i2)] : iArr;
    }

    private void d() {
        this.U = 0;
        this.ac = 0;
        this.ab = 0;
        this.V = false;
        this.W = false;
        this.Y = false;
        this.aa = 0;
        this.Z = (byte) 0;
        this.X = false;
        this.q.a();
    }

    private l e() {
        com.opos.exoplayer.core.i.h hVar;
        com.opos.exoplayer.core.i.h hVar2;
        if (this.w == -1 || this.z == C.TIME_UNSET || (hVar = this.I) == null || hVar.a() == 0 || (hVar2 = this.J) == null || hVar2.a() != this.I.a()) {
            this.I = null;
            this.J = null;
            return new l.b(this.z);
        }
        int a2 = this.I.a();
        int[] iArr = new int[a2];
        long[] jArr = new long[a2];
        long[] jArr2 = new long[a2];
        long[] jArr3 = new long[a2];
        int i2 = 0;
        for (int i3 = 0; i3 < a2; i3++) {
            jArr3[i3] = this.I.a(i3);
            jArr[i3] = this.w + this.J.a(i3);
        }
        while (true) {
            int i4 = a2 - 1;
            if (i2 >= i4) {
                iArr[i4] = (int) ((this.w + this.v) - jArr[i4]);
                jArr2[i4] = this.z - jArr3[i4];
                this.I = null;
                this.J = null;
                return new com.opos.exoplayer.core.c.a(iArr, jArr, jArr2, jArr3);
            }
            int i5 = i2 + 1;
            iArr[i2] = (int) (jArr[i5] - jArr[i2]);
            jArr2[i2] = jArr3[i5] - jArr3[i2];
            i2 = i5;
        }
    }

    int a(int i2) {
        switch (i2) {
            case TTAdConstant.IMAGE_MODE_SPLASH /* 131 */:
            case 136:
            case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND /* 155 */:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case org.mozilla.universalchardet.prober.n.c.o /* 241 */:
            case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case TinkerReport.KEY_APPLIED_LIB_EXTRACT /* 183 */:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT /* 181 */:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        this.f17796ad = false;
        boolean z = true;
        while (z && !this.f17796ad) {
            z = this.f17797h.a(fVar);
            if (z && a(kVar, fVar.c())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f17799j.size(); i2++) {
            this.f17799j.valueAt(i2).a();
        }
        return -1;
    }

    void a(int i2, double d2) {
        if (i2 == 181) {
            this.A.I = (int) d2;
        }
        if (i2 == 17545) {
            this.y = (long) d2;
            return;
        }
        switch (i2) {
            case 21969:
                this.A.w = (float) d2;
                break;
            case 21970:
                this.A.x = (float) d2;
                break;
            case 21971:
                this.A.y = (float) d2;
                break;
            case 21972:
                this.A.z = (float) d2;
                break;
            case 21973:
                this.A.A = (float) d2;
                break;
            case 21974:
                this.A.B = (float) d2;
                break;
            case 21975:
                this.A.C = (float) d2;
                break;
            case 21976:
                this.A.D = (float) d2;
                break;
            case 21977:
                this.A.E = (float) d2;
                break;
            case 21978:
                this.A.F = (float) d2;
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f1, code lost:
    
        throw new com.opos.exoplayer.core.o("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(int r20, int r21, com.opos.exoplayer.core.c.f r22) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.b.a.a(int, int, com.opos.exoplayer.core.c.f):void");
    }

    void a(int i2, long j2) {
        if (i2 == 20529) {
            if (j2 == 0) {
                return;
            }
            throw new o("ContentEncodingOrder " + j2 + " not supported");
        }
        if (i2 == 20530) {
            if (j2 == 1) {
                return;
            }
            throw new o("ContentEncodingScope " + j2 + " not supported");
        }
        switch (i2) {
            case TTAdConstant.IMAGE_MODE_SPLASH /* 131 */:
                this.A.f17803c = (int) j2;
                return;
            case 136:
                this.A.M = j2 == 1;
                return;
            case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND /* 155 */:
                this.N = a(j2);
                return;
            case 159:
                this.A.G = (int) j2;
                return;
            case 176:
                this.A.f17810j = (int) j2;
                return;
            case 179:
                this.I.a(a(j2));
                return;
            case 186:
                this.A.k = (int) j2;
                return;
            case 215:
                this.A.f17802b = (int) j2;
                return;
            case 231:
                this.H = a(j2);
                return;
            case org.mozilla.universalchardet.prober.n.c.o /* 241 */:
                if (this.K) {
                    return;
                }
                this.J.a(j2);
                this.K = true;
                return;
            case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
                this.ae = true;
                return;
            case 16980:
                if (j2 == 3) {
                    return;
                }
                throw new o("ContentCompAlgo " + j2 + " not supported");
            case 17029:
                if (j2 < 1 || j2 > 2) {
                    throw new o("DocTypeReadVersion " + j2 + " not supported");
                }
                return;
            case 17143:
                if (j2 == 1) {
                    return;
                }
                throw new o("EBMLReadVersion " + j2 + " not supported");
            case 18401:
                if (j2 == 5) {
                    return;
                }
                throw new o("ContentEncAlgo " + j2 + " not supported");
            case 18408:
                if (j2 == 1) {
                    return;
                }
                throw new o("AESSettingsCipherMode " + j2 + " not supported");
            case 21420:
                this.D = this.w + j2;
                return;
            case 21432:
                int i3 = (int) j2;
                if (i3 == 0) {
                    this.A.p = 0;
                    return;
                }
                if (i3 == 1) {
                    this.A.p = 2;
                    return;
                } else if (i3 == 3) {
                    this.A.p = 1;
                    return;
                } else {
                    if (i3 != 15) {
                        return;
                    }
                    this.A.p = 3;
                    return;
                }
            case 21680:
                this.A.l = (int) j2;
                return;
            case 21682:
                this.A.n = (int) j2;
                return;
            case 21690:
                this.A.m = (int) j2;
                return;
            case 21930:
                this.A.N = j2 == 1;
                return;
            case 22186:
                this.A.J = j2;
                return;
            case 22203:
                this.A.K = j2;
                return;
            case 25188:
                this.A.H = (int) j2;
                return;
            case 2352003:
                this.A.f17804d = (int) j2;
                return;
            case 2807729:
                this.x = j2;
                return;
            default:
                switch (i2) {
                    case 21945:
                        int i4 = (int) j2;
                        if (i4 == 1) {
                            this.A.t = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.A.t = 1;
                            return;
                        }
                    case 21946:
                        int i5 = (int) j2;
                        if (i5 != 1) {
                            if (i5 == 16) {
                                this.A.s = 6;
                                return;
                            } else if (i5 == 18) {
                                this.A.s = 7;
                                return;
                            } else if (i5 != 6 && i5 != 7) {
                                return;
                            }
                        }
                        this.A.s = 3;
                        return;
                    case 21947:
                        b bVar = this.A;
                        bVar.q = true;
                        int i6 = (int) j2;
                        if (i6 == 1) {
                            bVar.r = 1;
                            return;
                        }
                        if (i6 == 9) {
                            bVar.r = 6;
                            return;
                        } else {
                            if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                bVar.r = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.A.u = (int) j2;
                        return;
                    case 21949:
                        this.A.v = (int) j2;
                        return;
                    default:
                        return;
                }
        }
    }

    void a(int i2, long j2, long j3) {
        if (i2 == 160) {
            this.ae = false;
            return;
        }
        if (i2 == 174) {
            this.A = new b();
            return;
        }
        if (i2 == 187) {
            this.K = false;
            return;
        }
        if (i2 == 19899) {
            this.C = -1;
            this.D = -1L;
            return;
        }
        if (i2 == 20533) {
            this.A.f17805e = true;
            return;
        }
        if (i2 == 21968) {
            this.A.q = true;
            return;
        }
        if (i2 == 408125543) {
            long j4 = this.w;
            if (j4 != -1 && j4 != j2) {
                throw new o("Multiple Segment elements not supported");
            }
            this.w = j2;
            this.v = j3;
            return;
        }
        if (i2 == 475249515) {
            this.I = new com.opos.exoplayer.core.i.h();
            this.J = new com.opos.exoplayer.core.i.h();
        } else if (i2 == 524531317 && !this.B) {
            if (this.k && this.F != -1) {
                this.E = true;
            } else {
                this.af.a(new l.b(this.z));
                this.B = true;
            }
        }
    }

    void a(int i2, String str) {
        if (i2 == 134) {
            this.A.f17801a = str;
            return;
        }
        if (i2 != 17026) {
            if (i2 != 2274716) {
                return;
            }
            this.A.Q = str;
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            throw new o("DocType " + str + " not supported");
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        this.H = C.TIME_UNSET;
        this.L = 0;
        this.f17797h.a();
        this.f17798i.a();
        d();
        for (int i2 = 0; i2 < this.f17799j.size(); i2++) {
            this.f17799j.valueAt(i2).b();
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.af = gVar;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return new e().a(fVar);
    }

    boolean b(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }

    void c(int i2) {
        if (i2 == 160) {
            if (this.L == 2) {
                if (!this.ae) {
                    this.T |= 1;
                }
                a(this.f17799j.get(this.R), this.M);
                this.L = 0;
                return;
            }
            return;
        }
        if (i2 == 174) {
            if (a(this.A.f17801a)) {
                b bVar = this.A;
                bVar.a(this.af, bVar.f17802b);
                SparseArray<b> sparseArray = this.f17799j;
                b bVar2 = this.A;
                sparseArray.put(bVar2.f17802b, bVar2);
            }
            this.A = null;
            return;
        }
        if (i2 == 19899) {
            int i3 = this.C;
            if (i3 != -1) {
                long j2 = this.D;
                if (j2 != -1) {
                    if (i3 == 475249515) {
                        this.F = j2;
                        return;
                    }
                    return;
                }
            }
            throw new o("Mandatory element SeekID or SeekPosition not found");
        }
        if (i2 == 25152) {
            b bVar3 = this.A;
            if (bVar3.f17805e) {
                if (bVar3.f17807g == null) {
                    throw new o("Encrypted Track found but ContentEncKeyID was not found");
                }
                bVar3.f17809i = new DrmInitData(new DrmInitData.SchemeData(com.opos.exoplayer.core.b.f17711b, "video/webm", this.A.f17807g.f18332b));
                return;
            }
            return;
        }
        if (i2 == 28032) {
            b bVar4 = this.A;
            if (bVar4.f17805e && bVar4.f17806f != null) {
                throw new o("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i2 == 357149030) {
            if (this.x == C.TIME_UNSET) {
                this.x = C.MICROS_PER_SECOND;
            }
            long j3 = this.y;
            if (j3 != C.TIME_UNSET) {
                this.z = a(j3);
                return;
            }
            return;
        }
        if (i2 == 374648427) {
            if (this.f17799j.size() == 0) {
                throw new o("No valid tracks were found");
            }
            this.af.a();
        } else if (i2 == 475249515 && !this.B) {
            this.af.a(e());
            this.B = true;
        }
    }
}
