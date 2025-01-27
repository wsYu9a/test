package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.google.android.exoplayer3.drm.DrmInitData;
import com.vivo.google.android.exoplayer3.extractor.ExtractorsFactory;
import com.vivo.google.android.exoplayer3.m0;
import com.vivo.google.android.exoplayer3.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
public final class w0 implements g0 {
    public static final byte[] Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, org.mozilla.universalchardet.prober.g.s, 45, 45, 62, org.mozilla.universalchardet.prober.g.s, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] a0 = {org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s, org.mozilla.universalchardet.prober.g.s};
    public static final UUID b0 = new UUID(72057594037932032L, -9223371306706625679L);
    public j6 B;
    public j6 C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public i0 Y;

    /* renamed from: a */
    public final u0 f28195a;

    /* renamed from: b */
    public final y0 f28196b;

    /* renamed from: c */
    public final SparseArray<c> f28197c;

    /* renamed from: d */
    public final boolean f28198d;

    /* renamed from: e */
    public final n6 f28199e;

    /* renamed from: f */
    public final n6 f28200f;

    /* renamed from: g */
    public final n6 f28201g;

    /* renamed from: h */
    public final n6 f28202h;

    /* renamed from: i */
    public final n6 f28203i;

    /* renamed from: j */
    public final n6 f28204j;
    public final n6 k;
    public final n6 l;
    public final n6 m;
    public ByteBuffer n;
    public long o;
    public c t;
    public boolean u;
    public int v;
    public long w;
    public boolean x;
    public long p = -1;
    public long q = C.TIME_UNSET;
    public long r = C.TIME_UNSET;
    public long s = C.TIME_UNSET;
    public long y = -1;
    public long z = -1;
    public long A = C.TIME_UNSET;

    public static class a implements ExtractorsFactory {
    }

    public static final class c {
        public boolean L;
        public n0 O;
        public int P;

        /* renamed from: a */
        public String f28206a;

        /* renamed from: b */
        public int f28207b;

        /* renamed from: c */
        public int f28208c;

        /* renamed from: d */
        public int f28209d;

        /* renamed from: e */
        public boolean f28210e;

        /* renamed from: f */
        public byte[] f28211f;

        /* renamed from: g */
        public byte[] f28212g;

        /* renamed from: h */
        public byte[] f28213h;

        /* renamed from: i */
        public DrmInitData f28214i;

        /* renamed from: j */
        public int f28215j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = 0;
        public byte[] o = null;
        public int p = -1;
        public boolean q = false;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = 1000;
        public int v = 200;
        public float w = -1.0f;
        public float x = -1.0f;
        public float y = -1.0f;
        public float z = -1.0f;
        public float A = -1.0f;
        public float B = -1.0f;
        public float C = -1.0f;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 1;
        public int H = -1;
        public int I = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
        public long J = 0;
        public long K = 0;
        public boolean M = true;
        public String N = "eng";
    }

    public w0(u0 u0Var, int i2) {
        this.f28195a = u0Var;
        ((t0) u0Var).a(new b(this, null));
        this.f28198d = (i2 & 1) == 0;
        this.f28196b = new y0();
        this.f28197c = new SparseArray<>();
        this.f28201g = new n6(4);
        this.f28202h = new n6(ByteBuffer.allocate(4).putInt(-1).array());
        this.f28203i = new n6(4);
        this.f28199e = new n6(l6.f27726a);
        this.f28200f = new n6(4);
        this.f28204j = new n6();
        this.k = new n6();
        this.l = new n6(8);
        this.m = new n6();
    }

    public static int[] a(int[] iArr, int i2) {
        return iArr == null ? new int[i2] : iArr.length >= i2 ? iArr : new int[Math.max(iArr.length * 2, i2)];
    }

    public final int a(h0 h0Var, n0 n0Var, int i2) {
        int a2;
        int a3 = this.f28204j.a();
        if (a3 > 0) {
            a2 = Math.min(i2, a3);
            n0Var.a(this.f28204j, a2);
        } else {
            a2 = n0Var.a(h0Var, i2, false);
        }
        this.N += a2;
        this.V += a2;
        return a2;
    }

    public final long a(long j2) {
        long j3 = this.q;
        if (j3 != C.TIME_UNSET) {
            return Util.scaleLargeTimestamp(j2, j3, 1000L);
        }
        throw new f("Can't scale timecode prior to timecodeScale being set.");
    }

    public final void a() {
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        this.f28204j.r();
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        this.Y = i0Var;
    }

    public final void a(c cVar, long j2) {
        byte[] utf8Bytes;
        if ("S_TEXT/UTF8".equals(cVar.f28206a)) {
            byte[] bArr = this.k.f27874a;
            long j3 = this.G;
            if (j3 == C.TIME_UNSET) {
                utf8Bytes = a0;
            } else {
                int i2 = (int) (j3 / 3600000000L);
                long j4 = j3 - (i2 * 3600000000L);
                int i3 = (int) (j4 / 60000000);
                long j5 = j4 - (60000000 * i3);
                utf8Bytes = Util.getUtf8Bytes(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) (j5 / C.MICROS_PER_SECOND)), Integer.valueOf((int) ((j5 - (1000000 * r4)) / 1000))));
            }
            System.arraycopy(utf8Bytes, 0, bArr, 19, 12);
            n0 n0Var = cVar.O;
            n6 n6Var = this.k;
            n0Var.a(n6Var, n6Var.f27876c);
            this.V += this.k.f27876c;
        }
        cVar.O.a(j2, this.M, this.V, 0, cVar.f28212g);
        this.W = true;
        a();
    }

    public final boolean a(l0 l0Var, long j2) {
        if (this.x) {
            this.z = j2;
            l0Var.f27602a = this.y;
            this.x = false;
            return true;
        }
        if (this.u) {
            long j3 = this.z;
            if (j3 != -1) {
                l0Var.f27602a = j3;
                this.z = -1L;
                return true;
            }
        }
        return false;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0635, code lost:
    
        if (r1.i() == r11.getLeastSignificantBits()) goto L949;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0887, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0a1d, code lost:
    
        if (r5 == false) goto L1115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0a1f, code lost:
    
        r4 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0a2c, code lost:
    
        if (r4.a(r34, ((com.vivo.google.android.exoplayer3.d0) r3).f27268c) == false) goto L1148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0a2e, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0a34, code lost:
    
        r1 = r3;
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0a30, code lost:
    
        r4 = r32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:173:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x065a  */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    @Override // com.vivo.google.android.exoplayer3.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.vivo.google.android.exoplayer3.h0 r33, com.vivo.google.android.exoplayer3.l0 r34) {
        /*
            Method dump skipped, instructions count: 3136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.w0.a(com.vivo.google.android.exoplayer3.h0, com.vivo.google.android.exoplayer3.l0):int");
    }

    public final class b implements v0 {
        public b() {
        }

        public /* synthetic */ b(w0 w0Var, a aVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:102:0x01fb, code lost:
        
            throw new com.vivo.google.android.exoplayer3.f("EBML lacing sample size out of range.");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r23, int r24, com.vivo.google.android.exoplayer3.h0 r25) {
            /*
                Method dump skipped, instructions count: 675
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.w0.b.a(int, int, com.vivo.google.android.exoplayer3.h0):void");
        }

        public void a(int i2, double d2) {
            w0 w0Var = w0.this;
            w0Var.getClass();
            if (i2 == 181) {
                w0Var.t.I = (int) d2;
            }
            if (i2 == 17545) {
                w0Var.r = (long) d2;
                return;
            }
            switch (i2) {
                case 21969:
                    w0Var.t.w = (float) d2;
                    break;
                case 21970:
                    w0Var.t.x = (float) d2;
                    break;
                case 21971:
                    w0Var.t.y = (float) d2;
                    break;
                case 21972:
                    w0Var.t.z = (float) d2;
                    break;
                case 21973:
                    w0Var.t.A = (float) d2;
                    break;
                case 21974:
                    w0Var.t.B = (float) d2;
                    break;
                case 21975:
                    w0Var.t.C = (float) d2;
                    break;
                case 21976:
                    w0Var.t.D = (float) d2;
                    break;
                case 21977:
                    w0Var.t.E = (float) d2;
                    break;
                case 21978:
                    w0Var.t.F = (float) d2;
                    break;
            }
        }

        public void a(int i2, long j2) {
            w0 w0Var = w0.this;
            w0Var.getClass();
            if (i2 == 20529) {
                if (j2 == 0) {
                    return;
                }
                throw new f("ContentEncodingOrder " + j2 + " not supported");
            }
            if (i2 == 20530) {
                if (j2 == 1) {
                    return;
                }
                throw new f("ContentEncodingScope " + j2 + " not supported");
            }
            switch (i2) {
                case TTAdConstant.IMAGE_MODE_SPLASH /* 131 */:
                    w0Var.t.f28208c = (int) j2;
                    return;
                case 136:
                    w0Var.t.L = j2 == 1;
                    return;
                case TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND /* 155 */:
                    w0Var.G = w0Var.a(j2);
                    return;
                case 159:
                    w0Var.t.G = (int) j2;
                    return;
                case 176:
                    w0Var.t.f28215j = (int) j2;
                    return;
                case 179:
                    w0Var.B.a(w0Var.a(j2));
                    return;
                case 186:
                    w0Var.t.k = (int) j2;
                    return;
                case 215:
                    w0Var.t.f28207b = (int) j2;
                    return;
                case 231:
                    w0Var.A = w0Var.a(j2);
                    return;
                case org.mozilla.universalchardet.prober.n.c.o /* 241 */:
                    if (w0Var.D) {
                        return;
                    }
                    w0Var.C.a(j2);
                    w0Var.D = true;
                    return;
                case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
                    w0Var.X = true;
                    return;
                case 16980:
                    if (j2 == 3) {
                        return;
                    }
                    throw new f("ContentCompAlgo " + j2 + " not supported");
                case 17029:
                    if (j2 < 1 || j2 > 2) {
                        throw new f("DocTypeReadVersion " + j2 + " not supported");
                    }
                    return;
                case 17143:
                    if (j2 == 1) {
                        return;
                    }
                    throw new f("EBMLReadVersion " + j2 + " not supported");
                case 18401:
                    if (j2 == 5) {
                        return;
                    }
                    throw new f("ContentEncAlgo " + j2 + " not supported");
                case 18408:
                    if (j2 == 1) {
                        return;
                    }
                    throw new f("AESSettingsCipherMode " + j2 + " not supported");
                case 21420:
                    w0Var.w = j2 + w0Var.p;
                    return;
                case 21432:
                    int i3 = (int) j2;
                    if (i3 == 0) {
                        w0Var.t.p = 0;
                        return;
                    }
                    if (i3 == 1) {
                        w0Var.t.p = 2;
                        return;
                    } else if (i3 == 3) {
                        w0Var.t.p = 1;
                        return;
                    } else {
                        if (i3 != 15) {
                            return;
                        }
                        w0Var.t.p = 3;
                        return;
                    }
                case 21680:
                    w0Var.t.l = (int) j2;
                    return;
                case 21682:
                    w0Var.t.n = (int) j2;
                    return;
                case 21690:
                    w0Var.t.m = (int) j2;
                    return;
                case 21930:
                    w0Var.t.M = j2 == 1;
                    return;
                case 22186:
                    w0Var.t.J = j2;
                    return;
                case 22203:
                    w0Var.t.K = j2;
                    return;
                case 25188:
                    w0Var.t.H = (int) j2;
                    return;
                case 2352003:
                    w0Var.t.f28209d = (int) j2;
                    return;
                case 2807729:
                    w0Var.q = j2;
                    return;
                default:
                    switch (i2) {
                        case 21945:
                            int i4 = (int) j2;
                            if (i4 == 1) {
                                w0Var.t.t = 2;
                                return;
                            } else {
                                if (i4 != 2) {
                                    return;
                                }
                                w0Var.t.t = 1;
                                return;
                            }
                        case 21946:
                            int i5 = (int) j2;
                            if (i5 != 1) {
                                if (i5 == 16) {
                                    w0Var.t.s = 6;
                                    return;
                                } else if (i5 == 18) {
                                    w0Var.t.s = 7;
                                    return;
                                } else if (i5 != 6 && i5 != 7) {
                                    return;
                                }
                            }
                            w0Var.t.s = 3;
                            return;
                        case 21947:
                            c cVar = w0Var.t;
                            cVar.q = true;
                            int i6 = (int) j2;
                            if (i6 == 1) {
                                cVar.r = 1;
                                return;
                            }
                            if (i6 == 9) {
                                cVar.r = 6;
                                return;
                            } else {
                                if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                    cVar.r = 2;
                                    return;
                                }
                                return;
                            }
                        case 21948:
                            w0Var.t.u = (int) j2;
                            return;
                        case 21949:
                            w0Var.t.v = (int) j2;
                            return;
                        default:
                            return;
                    }
            }
        }

        public boolean a(int i2) {
            w0.this.getClass();
            return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
        }

        public void a(int i2, long j2, long j3) {
            w0 w0Var = w0.this;
            w0Var.getClass();
            if (i2 == 160) {
                w0Var.X = false;
                return;
            }
            if (i2 == 174) {
                w0Var.t = new c();
                return;
            }
            if (i2 == 187) {
                w0Var.D = false;
                return;
            }
            if (i2 == 19899) {
                w0Var.v = -1;
                w0Var.w = -1L;
                return;
            }
            if (i2 == 20533) {
                w0Var.t.f28210e = true;
                return;
            }
            if (i2 == 21968) {
                w0Var.t.q = true;
                return;
            }
            if (i2 == 408125543) {
                long j4 = w0Var.p;
                if (j4 != -1 && j4 != j2) {
                    throw new f("Multiple Segment elements not supported");
                }
                w0Var.p = j2;
                w0Var.o = j3;
                return;
            }
            if (i2 != 475249515) {
                if (i2 == 524531317 && !w0Var.u) {
                    if (w0Var.f28198d && w0Var.y != -1) {
                        w0Var.x = true;
                        return;
                    }
                    l3 l3Var = (l3) w0Var.Y;
                    l3Var.q = new m0.a(w0Var.s);
                    l3Var.n.post(l3Var.l);
                    w0Var.u = true;
                    return;
                }
                return;
            }
            w0Var.B = new j6(32);
            w0Var.C = new j6(32);
        }

        public void a(int i2, String str) {
            w0 w0Var = w0.this;
            w0Var.getClass();
            if (i2 == 134) {
                w0Var.t.f28206a = str;
                return;
            }
            if (i2 != 17026) {
                if (i2 != 2274716) {
                    return;
                }
                w0Var.t.N = str;
            } else {
                if ("webm".equals(str) || "matroska".equals(str)) {
                    return;
                }
                throw new f("DocType " + str + " not supported");
            }
        }
    }

    public final void a(h0 h0Var, int i2) {
        n6 n6Var = this.f28201g;
        if (n6Var.f27876c >= i2) {
            return;
        }
        if (n6Var.b() < i2) {
            n6 n6Var2 = this.f28201g;
            byte[] bArr = n6Var2.f27874a;
            n6Var2.a(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i2)), this.f28201g.f27876c);
        }
        n6 n6Var3 = this.f28201g;
        byte[] bArr2 = n6Var3.f27874a;
        int i3 = n6Var3.f27876c;
        ((d0) h0Var).b(bArr2, i3, i2 - i3, false);
        this.f28201g.c(i2);
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        this.A = C.TIME_UNSET;
        this.E = 0;
        t0 t0Var = (t0) this.f28195a;
        t0Var.f28079e = 0;
        t0Var.f28076b.clear();
        y0 y0Var = t0Var.f28077c;
        y0Var.f28289b = 0;
        y0Var.f28290c = 0;
        y0 y0Var2 = this.f28196b;
        y0Var2.f28289b = 0;
        y0Var2.f28290c = 0;
        a();
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public boolean a(h0 h0Var) {
        x0 x0Var = new x0();
        d0 d0Var = (d0) h0Var;
        long j2 = d0Var.f27267b;
        long j3 = 1024;
        if (j2 != -1 && j2 <= 1024) {
            j3 = j2;
        }
        int i2 = (int) j3;
        d0Var.a(x0Var.f28256a.f27874a, 0, 4, false);
        x0Var.f28257b = 4;
        for (long m = x0Var.f28256a.m(); m != 440786851; m = ((m << 8) & (-256)) | (x0Var.f28256a.f27874a[0] & 255)) {
            int i3 = x0Var.f28257b + 1;
            x0Var.f28257b = i3;
            if (i3 == i2) {
                return false;
            }
            d0Var.a(x0Var.f28256a.f27874a, 0, 1, false);
        }
        long a2 = x0Var.a(h0Var);
        long j4 = x0Var.f28257b;
        if (a2 == Long.MIN_VALUE) {
            return false;
        }
        if (j2 != -1 && j4 + a2 >= j2) {
            return false;
        }
        while (true) {
            long j5 = x0Var.f28257b;
            long j6 = j4 + a2;
            if (j5 >= j6) {
                return j5 == j6;
            }
            if (x0Var.a(h0Var) == Long.MIN_VALUE) {
                return false;
            }
            long a3 = x0Var.a(h0Var);
            if (a3 < 0 || a3 > 2147483647L) {
                return false;
            }
            if (a3 != 0) {
                d0Var.a((int) a3, false);
                x0Var.f28257b = (int) (x0Var.f28257b + a3);
            }
        }
    }

    public final void a(h0 h0Var, c cVar, int i2) {
        int i3;
        if ("S_TEXT/UTF8".equals(cVar.f28206a)) {
            byte[] bArr = Z;
            int length = bArr.length + i2;
            if (this.k.b() < length) {
                this.k.f27874a = Arrays.copyOf(bArr, length + i2);
            }
            ((d0) h0Var).b(this.k.f27874a, bArr.length, i2, false);
            this.k.d(0);
            this.k.c(length);
            return;
        }
        n0 n0Var = cVar.O;
        if (!this.O) {
            if (cVar.f28210e) {
                this.M &= -1073741825;
                if (!this.P) {
                    ((d0) h0Var).b(this.f28201g.f27874a, 0, 1, false);
                    this.N++;
                    byte[] bArr2 = this.f28201g.f27874a;
                    if ((bArr2[0] & ByteCompanionObject.MIN_VALUE) == 128) {
                        throw new f("Extension bit is set in signal byte");
                    }
                    this.S = bArr2[0];
                    this.P = true;
                }
                byte b2 = this.S;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.M |= 1073741824;
                    if (!this.Q) {
                        ((d0) h0Var).b(this.l.f27874a, 0, 8, false);
                        this.N += 8;
                        this.Q = true;
                        n6 n6Var = this.f28201g;
                        n6Var.f27874a[0] = (byte) ((z ? 128 : 0) | 8);
                        n6Var.d(0);
                        n0Var.a(this.f28201g, 1);
                        this.V++;
                        this.l.d(0);
                        n0Var.a(this.l, 8);
                        this.V += 8;
                    }
                    if (z) {
                        if (!this.R) {
                            ((d0) h0Var).b(this.f28201g.f27874a, 0, 1, false);
                            this.N++;
                            this.f28201g.d(0);
                            this.T = this.f28201g.l();
                            this.R = true;
                        }
                        int i4 = this.T * 4;
                        this.f28201g.b(i4);
                        ((d0) h0Var).b(this.f28201g.f27874a, 0, i4, false);
                        this.N += i4;
                        short s = (short) ((this.T / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.n;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.n = ByteBuffer.allocate(i5);
                        }
                        this.n.position(0);
                        this.n.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i3 = this.T;
                            if (i6 >= i3) {
                                break;
                            }
                            int o = this.f28201g.o();
                            if (i6 % 2 == 0) {
                                this.n.putShort((short) (o - i7));
                            } else {
                                this.n.putInt(o - i7);
                            }
                            i6++;
                            i7 = o;
                        }
                        int i8 = (i2 - this.N) - i7;
                        int i9 = i3 % 2;
                        ByteBuffer byteBuffer2 = this.n;
                        if (i9 == 1) {
                            byteBuffer2.putInt(i8);
                        } else {
                            byteBuffer2.putShort((short) i8);
                            this.n.putInt(0);
                        }
                        this.m.a(this.n.array(), i5);
                        n0Var.a(this.m, i5);
                        this.V += i5;
                    }
                }
            } else {
                byte[] bArr3 = cVar.f28211f;
                if (bArr3 != null) {
                    this.f28204j.a(bArr3, bArr3.length);
                }
            }
            this.O = true;
        }
        int i10 = i2 + this.f28204j.f27876c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f28206a) && !"V_MPEGH/ISO/HEVC".equals(cVar.f28206a)) {
            while (true) {
                int i11 = this.N;
                if (i11 >= i10) {
                    break;
                } else {
                    a(h0Var, n0Var, i10 - i11);
                }
            }
        } else {
            byte[] bArr4 = this.f28200f.f27874a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i12 = cVar.P;
            int i13 = 4 - i12;
            while (this.N < i10) {
                int i14 = this.U;
                if (i14 == 0) {
                    int min = Math.min(i12, this.f28204j.a());
                    ((d0) h0Var).b(bArr4, i13 + min, i12 - min, false);
                    if (min > 0) {
                        n6 n6Var2 = this.f28204j;
                        System.arraycopy(n6Var2.f27874a, n6Var2.f27875b, bArr4, i13, min);
                        n6Var2.f27875b += min;
                    }
                    this.N += i12;
                    this.f28200f.d(0);
                    this.U = this.f28200f.o();
                    this.f28199e.d(0);
                    n0Var.a(this.f28199e, 4);
                    this.V += 4;
                } else {
                    this.U = i14 - a(h0Var, n0Var, i14);
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f28206a)) {
            this.f28202h.d(0);
            n0Var.a(this.f28202h, 4);
            this.V += 4;
        }
    }
}
