package com.opos.exoplayer.core.c.d;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
abstract class g {
    public final int aP;

    /* renamed from: a */
    public static final int f17919a = u.f("ftyp");

    /* renamed from: b */
    public static final int f17921b = u.f("avc1");

    /* renamed from: c */
    public static final int f17922c = u.f("avc3");

    /* renamed from: d */
    public static final int f17923d = u.f("hvc1");

    /* renamed from: e */
    public static final int f17924e = u.f("hev1");

    /* renamed from: f */
    public static final int f17925f = u.f("s263");

    /* renamed from: g */
    public static final int f17926g = u.f("d263");

    /* renamed from: h */
    public static final int f17927h = u.f("mdat");

    /* renamed from: i */
    public static final int f17928i = u.f("mp4a");

    /* renamed from: j */
    public static final int f17929j = u.f(".mp3");
    public static final int k = u.f("wave");
    public static final int l = u.f("lpcm");
    public static final int m = u.f("sowt");
    public static final int n = u.f("ac-3");
    public static final int o = u.f("dac3");
    public static final int p = u.f("ec-3");
    public static final int q = u.f("dec3");
    public static final int r = u.f("dtsc");
    public static final int s = u.f("dtsh");
    public static final int t = u.f("dtsl");
    public static final int u = u.f("dtse");
    public static final int v = u.f("ddts");
    public static final int w = u.f("tfdt");
    public static final int x = u.f("tfhd");
    public static final int y = u.f("trex");
    public static final int z = u.f("trun");
    public static final int A = u.f("sidx");
    public static final int B = u.f("moov");
    public static final int C = u.f("mvhd");
    public static final int D = u.f("trak");
    public static final int E = u.f("mdia");
    public static final int F = u.f("minf");
    public static final int G = u.f("stbl");
    public static final int H = u.f("avcC");
    public static final int I = u.f("hvcC");
    public static final int J = u.f("esds");
    public static final int K = u.f("moof");
    public static final int L = u.f("traf");
    public static final int M = u.f("mvex");
    public static final int N = u.f("mehd");
    public static final int O = u.f("tkhd");
    public static final int P = u.f("edts");
    public static final int Q = u.f("elst");
    public static final int R = u.f("mdhd");
    public static final int S = u.f("hdlr");
    public static final int T = u.f("stsd");
    public static final int U = u.f("pssh");
    public static final int V = u.f("sinf");
    public static final int W = u.f("schm");
    public static final int X = u.f("schi");
    public static final int Y = u.f("tenc");
    public static final int Z = u.f("encv");
    public static final int aa = u.f("enca");
    public static final int ab = u.f("frma");
    public static final int ac = u.f("saiz");

    /* renamed from: ad */
    public static final int f17920ad = u.f("saio");
    public static final int ae = u.f("sbgp");
    public static final int af = u.f("sgpd");
    public static final int ag = u.f("uuid");
    public static final int ah = u.f("senc");
    public static final int ai = u.f("pasp");
    public static final int aj = u.f("TTML");
    public static final int ak = u.f("vmhd");
    public static final int al = u.f("mp4v");
    public static final int am = u.f("stts");
    public static final int an = u.f("stss");
    public static final int ao = u.f("ctts");
    public static final int ap = u.f("stsc");
    public static final int aq = u.f("stsz");
    public static final int ar = u.f("stz2");
    public static final int as = u.f("stco");
    public static final int at = u.f("co64");
    public static final int au = u.f("tx3g");
    public static final int av = u.f("wvtt");
    public static final int aw = u.f("stpp");
    public static final int ax = u.f("c608");
    public static final int ay = u.f("samr");
    public static final int az = u.f("sawb");
    public static final int aA = u.f("udta");
    public static final int aB = u.f(TTDownloadField.TT_META);
    public static final int aC = u.f("ilst");
    public static final int aD = u.f("mean");
    public static final int aE = u.f("name");
    public static final int aF = u.f(MiConfigSingleton.t0);
    public static final int aG = u.f("emsg");
    public static final int aH = u.f("st3d");
    public static final int aI = u.f("sv3d");
    public static final int aJ = u.f("proj");
    public static final int aK = u.f("vp08");
    public static final int aL = u.f("vp09");
    public static final int aM = u.f("vpcC");
    public static final int aN = u.f("camm");
    public static final int aO = u.f("alac");

    static final class a extends g {
        public final long aQ;
        public final List<b> aR;
        public final List<a> aS;

        public a(int i2, long j2) {
            super(i2);
            this.aQ = j2;
            this.aR = new ArrayList();
            this.aS = new ArrayList();
        }

        public void a(a aVar) {
            this.aS.add(aVar);
        }

        public void a(b bVar) {
            this.aR.add(bVar);
        }

        public b d(int i2) {
            int size = this.aR.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.aR.get(i3);
                if (bVar.aP == i2) {
                    return bVar;
                }
            }
            return null;
        }

        public a e(int i2) {
            int size = this.aS.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.aS.get(i3);
                if (aVar.aP == i2) {
                    return aVar;
                }
            }
            return null;
        }

        @Override // com.opos.exoplayer.core.c.d.g
        public String toString() {
            return g.c(this.aP) + " leaves: " + Arrays.toString(this.aR.toArray()) + " containers: " + Arrays.toString(this.aS.toArray());
        }
    }

    static final class b extends g {
        public final com.opos.exoplayer.core.i.m aQ;

        public b(int i2, com.opos.exoplayer.core.i.m mVar) {
            super(i2);
            this.aQ = mVar;
        }
    }

    public g(int i2) {
        this.aP = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public static String c(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public String toString() {
        return c(this.aP);
    }
}
