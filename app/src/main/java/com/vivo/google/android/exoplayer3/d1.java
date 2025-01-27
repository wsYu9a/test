package com.vivo.google.android.exoplayer3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.application.MiConfigSingleton;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class d1 {
    public static final int A0;
    public static final int B0;
    public static final int C0;
    public static final int D0;
    public static final int E0;
    public static final int F0;
    public static final int G0;
    public static final int H0;
    public static final int I0;
    public static final int J0;
    public static final int K0;
    public static final int L0;
    public static final int M0;
    public static final int N0;
    public static final int O0;
    public static final int l0;
    public static final int m0;
    public static final int n0;
    public static final int o0;
    public static final int p0;
    public static final int q0;
    public static final int r0;
    public static final int s0;
    public static final int t0;
    public static final int u0;
    public static final int v0;
    public static final int w0;
    public static final int x0;
    public static final int y0;
    public static final int z0;

    /* renamed from: a */
    public final int f27281a;

    /* renamed from: b */
    public static final int f27272b = Util.getIntegerCodeForString("ftyp");

    /* renamed from: c */
    public static final int f27273c = Util.getIntegerCodeForString("avc1");

    /* renamed from: d */
    public static final int f27274d = Util.getIntegerCodeForString("avc3");

    /* renamed from: e */
    public static final int f27275e = Util.getIntegerCodeForString("hvc1");

    /* renamed from: f */
    public static final int f27276f = Util.getIntegerCodeForString("hev1");

    /* renamed from: g */
    public static final int f27277g = Util.getIntegerCodeForString("s263");

    /* renamed from: h */
    public static final int f27278h = Util.getIntegerCodeForString("d263");

    /* renamed from: i */
    public static final int f27279i = Util.getIntegerCodeForString("mdat");

    /* renamed from: j */
    public static final int f27280j = Util.getIntegerCodeForString("mp4a");
    public static final int k = Util.getIntegerCodeForString(".mp3");
    public static final int l = Util.getIntegerCodeForString("wave");
    public static final int m = Util.getIntegerCodeForString("lpcm");
    public static final int n = Util.getIntegerCodeForString("sowt");
    public static final int o = Util.getIntegerCodeForString("ac-3");
    public static final int p = Util.getIntegerCodeForString("dac3");
    public static final int q = Util.getIntegerCodeForString("ec-3");
    public static final int r = Util.getIntegerCodeForString("dec3");
    public static final int s = Util.getIntegerCodeForString("dtsc");
    public static final int t = Util.getIntegerCodeForString("dtsh");
    public static final int u = Util.getIntegerCodeForString("dtsl");
    public static final int v = Util.getIntegerCodeForString("dtse");
    public static final int w = Util.getIntegerCodeForString("ddts");
    public static final int x = Util.getIntegerCodeForString("tfdt");
    public static final int y = Util.getIntegerCodeForString("tfhd");
    public static final int z = Util.getIntegerCodeForString("trex");
    public static final int A = Util.getIntegerCodeForString("trun");
    public static final int B = Util.getIntegerCodeForString("sidx");
    public static final int C = Util.getIntegerCodeForString("moov");
    public static final int D = Util.getIntegerCodeForString("mvhd");
    public static final int E = Util.getIntegerCodeForString("trak");
    public static final int F = Util.getIntegerCodeForString("mdia");
    public static final int G = Util.getIntegerCodeForString("minf");
    public static final int H = Util.getIntegerCodeForString("stbl");
    public static final int I = Util.getIntegerCodeForString("avcC");
    public static final int J = Util.getIntegerCodeForString("hvcC");
    public static final int K = Util.getIntegerCodeForString("esds");
    public static final int L = Util.getIntegerCodeForString("moof");
    public static final int M = Util.getIntegerCodeForString("traf");
    public static final int N = Util.getIntegerCodeForString("mvex");
    public static final int O = Util.getIntegerCodeForString("mehd");
    public static final int P = Util.getIntegerCodeForString("tkhd");
    public static final int Q = Util.getIntegerCodeForString("edts");
    public static final int R = Util.getIntegerCodeForString("elst");
    public static final int S = Util.getIntegerCodeForString("mdhd");
    public static final int T = Util.getIntegerCodeForString("hdlr");
    public static final int U = Util.getIntegerCodeForString("stsd");
    public static final int V = Util.getIntegerCodeForString("pssh");
    public static final int W = Util.getIntegerCodeForString("sinf");
    public static final int X = Util.getIntegerCodeForString("schm");
    public static final int Y = Util.getIntegerCodeForString("schi");
    public static final int Z = Util.getIntegerCodeForString("tenc");
    public static final int a0 = Util.getIntegerCodeForString("encv");
    public static final int b0 = Util.getIntegerCodeForString("enca");
    public static final int c0 = Util.getIntegerCodeForString("frma");
    public static final int d0 = Util.getIntegerCodeForString("saiz");
    public static final int e0 = Util.getIntegerCodeForString("saio");
    public static final int f0 = Util.getIntegerCodeForString("sbgp");
    public static final int g0 = Util.getIntegerCodeForString("sgpd");
    public static final int h0 = Util.getIntegerCodeForString("uuid");
    public static final int i0 = Util.getIntegerCodeForString("senc");
    public static final int j0 = Util.getIntegerCodeForString("pasp");
    public static final int k0 = Util.getIntegerCodeForString("TTML");

    public static final class a extends d1 {
        public final long P0;
        public final List<b> Q0;
        public final List<a> R0;

        public a(int i2, long j2) {
            super(i2);
            this.P0 = j2;
            this.Q0 = new ArrayList();
            this.R0 = new ArrayList();
        }

        public a d(int i2) {
            int size = this.R0.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.R0.get(i3);
                if (aVar.f27281a == i2) {
                    return aVar;
                }
            }
            return null;
        }

        public b e(int i2) {
            int size = this.Q0.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.Q0.get(i3);
                if (bVar.f27281a == i2) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // com.vivo.google.android.exoplayer3.d1
        public String toString() {
            return d1.a(this.f27281a) + " leaves: " + Arrays.toString(this.Q0.toArray()) + " containers: " + Arrays.toString(this.R0.toArray());
        }
    }

    public static final class b extends d1 {
        public final n6 P0;

        public b(int i2, n6 n6Var) {
            super(i2);
            this.P0 = n6Var;
        }
    }

    static {
        Util.getIntegerCodeForString("vmhd");
        l0 = Util.getIntegerCodeForString("mp4v");
        m0 = Util.getIntegerCodeForString("stts");
        n0 = Util.getIntegerCodeForString("stss");
        o0 = Util.getIntegerCodeForString("ctts");
        p0 = Util.getIntegerCodeForString("stsc");
        q0 = Util.getIntegerCodeForString("stsz");
        r0 = Util.getIntegerCodeForString("stz2");
        s0 = Util.getIntegerCodeForString("stco");
        t0 = Util.getIntegerCodeForString("co64");
        u0 = Util.getIntegerCodeForString("tx3g");
        v0 = Util.getIntegerCodeForString("wvtt");
        w0 = Util.getIntegerCodeForString("stpp");
        x0 = Util.getIntegerCodeForString("c608");
        y0 = Util.getIntegerCodeForString("samr");
        z0 = Util.getIntegerCodeForString("sawb");
        A0 = Util.getIntegerCodeForString("udta");
        B0 = Util.getIntegerCodeForString(TTDownloadField.TT_META);
        C0 = Util.getIntegerCodeForString("ilst");
        D0 = Util.getIntegerCodeForString("mean");
        E0 = Util.getIntegerCodeForString("name");
        F0 = Util.getIntegerCodeForString(MiConfigSingleton.t0);
        G0 = Util.getIntegerCodeForString("emsg");
        H0 = Util.getIntegerCodeForString("st3d");
        I0 = Util.getIntegerCodeForString("sv3d");
        J0 = Util.getIntegerCodeForString("proj");
        K0 = Util.getIntegerCodeForString("vp08");
        L0 = Util.getIntegerCodeForString("vp09");
        M0 = Util.getIntegerCodeForString("vpcC");
        N0 = Util.getIntegerCodeForString("camm");
        O0 = Util.getIntegerCodeForString("alac");
    }

    public d1(int i2) {
        this.f27281a = i2;
    }

    public static String a(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public static int c(int i2) {
        return (i2 >> 24) & 255;
    }

    public String toString() {
        return a(this.f27281a);
    }
}
