package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.metadata.id3.ApicFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.CommentFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.Id3Frame;
import com.vivo.google.android.exoplayer3.metadata.id3.TextInformationFrame;
import com.vivo.google.android.exoplayer3.util.Util;
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
public final class i1 {

    /* renamed from: a */
    public static final int f27492a = Util.getIntegerCodeForString("nam");

    /* renamed from: b */
    public static final int f27493b = Util.getIntegerCodeForString("trk");

    /* renamed from: c */
    public static final int f27494c = Util.getIntegerCodeForString("cmt");

    /* renamed from: d */
    public static final int f27495d = Util.getIntegerCodeForString("day");

    /* renamed from: e */
    public static final int f27496e = Util.getIntegerCodeForString("ART");

    /* renamed from: f */
    public static final int f27497f = Util.getIntegerCodeForString("too");

    /* renamed from: g */
    public static final int f27498g = Util.getIntegerCodeForString("alb");

    /* renamed from: h */
    public static final int f27499h = Util.getIntegerCodeForString("com");

    /* renamed from: i */
    public static final int f27500i = Util.getIntegerCodeForString("wrt");

    /* renamed from: j */
    public static final int f27501j = Util.getIntegerCodeForString("lyr");
    public static final int k = Util.getIntegerCodeForString("gen");
    public static final int l = Util.getIntegerCodeForString("covr");
    public static final int m = Util.getIntegerCodeForString("gnre");
    public static final int n = Util.getIntegerCodeForString("grp");
    public static final int o = Util.getIntegerCodeForString("disk");
    public static final int p = Util.getIntegerCodeForString("trkn");
    public static final int q = Util.getIntegerCodeForString("tmpo");
    public static final int r = Util.getIntegerCodeForString("cpil");
    public static final int s = Util.getIntegerCodeForString("aART");
    public static final int t = Util.getIntegerCodeForString("sonm");
    public static final int u = Util.getIntegerCodeForString("soal");
    public static final int v = Util.getIntegerCodeForString("soar");
    public static final int w = Util.getIntegerCodeForString("soaa");
    public static final int x = Util.getIntegerCodeForString("soco");
    public static final int y = Util.getIntegerCodeForString("rtng");
    public static final int z = Util.getIntegerCodeForString("pgap");
    public static final int A = Util.getIntegerCodeForString("sosn");
    public static final int B = Util.getIntegerCodeForString("tvsh");
    public static final int C = Util.getIntegerCodeForString("----");
    public static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static ApicFrame a(n6 n6Var) {
        int c2 = n6Var.c();
        if (n6Var.c() != d1.F0) {
            return null;
        }
        int c3 = n6Var.c() & 16777215;
        String str = c3 == 13 ? "image/jpeg" : c3 == 14 ? "image/png" : null;
        if (str == null) {
            String str2 = "Unrecognized cover art flags: " + c3;
            return null;
        }
        n6Var.e(4);
        int i2 = c2 - 16;
        byte[] bArr = new byte[i2];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i2);
        n6Var.f27875b += i2;
        return new ApicFrame(str, null, 3, bArr);
    }

    public static Id3Frame a(int i2, String str, n6 n6Var, boolean z2, boolean z3) {
        int c2 = c(n6Var);
        if (z3) {
            c2 = Math.min(1, c2);
        }
        if (c2 >= 0) {
            return z2 ? new TextInformationFrame(str, null, Integer.toString(c2)) : new CommentFrame("und", str, Integer.toString(c2));
        }
        String str2 = "Failed to parse uint8 attribute: " + d1.a(i2);
        return null;
    }

    public static TextInformationFrame a(int i2, String str, n6 n6Var) {
        int c2 = n6Var.c();
        if (n6Var.c() == d1.F0 && c2 >= 22) {
            n6Var.e(10);
            int q2 = n6Var.q();
            if (q2 > 0) {
                String str2 = "" + q2;
                int q3 = n6Var.q();
                if (q3 > 0) {
                    str2 = str2 + "/" + q3;
                }
                return new TextInformationFrame(str, null, str2);
            }
        }
        String str3 = "Failed to parse index/count attribute: " + d1.a(i2);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[Catch: all -> 0x01fa, TRY_LEAVE, TryCatch #0 {all -> 0x01fa, blocks: (B:6:0x001d, B:8:0x0022, B:10:0x0028, B:12:0x002d, B:14:0x0034, B:20:0x003e, B:22:0x0042, B:25:0x004c, B:27:0x0050, B:30:0x005a, B:32:0x005f, B:35:0x0069, B:37:0x006d, B:40:0x0077, B:42:0x007b, B:45:0x0083, B:47:0x0087, B:50:0x0091, B:52:0x0095, B:55:0x009f, B:57:0x00a3, B:60:0x00ad, B:62:0x00b1, B:65:0x00bb, B:67:0x00bf, B:70:0x00c9, B:72:0x00cd, B:75:0x00d7, B:77:0x00db, B:80:0x00e5, B:82:0x00e9, B:85:0x00f3, B:87:0x00f7, B:90:0x0101, B:92:0x0105, B:95:0x010f, B:97:0x0113, B:100:0x01ce, B:104:0x011f, B:106:0x0123, B:108:0x012f, B:111:0x0142, B:112:0x015a, B:114:0x015e, B:117:0x0164, B:119:0x0168, B:122:0x016e, B:124:0x0172, B:127:0x017c, B:129:0x0180, B:132:0x018a, B:134:0x018e, B:137:0x0198, B:139:0x019c, B:142:0x01a6, B:144:0x01aa, B:147:0x01b4, B:149:0x01b8, B:152:0x01c0, B:154:0x01c4, B:157:0x01e6, B:160:0x01f0), top: B:2:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.google.android.exoplayer3.metadata.Metadata.Entry b(com.vivo.google.android.exoplayer3.n6 r7) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.i1.b(com.vivo.google.android.exoplayer3.n6):com.vivo.google.android.exoplayer3.metadata.Metadata$Entry");
    }

    public static TextInformationFrame b(int i2, String str, n6 n6Var) {
        int c2 = n6Var.c();
        if (n6Var.c() == d1.F0) {
            n6Var.e(8);
            return new TextInformationFrame(str, null, n6Var.a(c2 - 16));
        }
        String str2 = "Failed to parse text attribute: " + d1.a(i2);
        return null;
    }

    public static int c(n6 n6Var) {
        n6Var.e(4);
        if (n6Var.c() != d1.F0) {
            return -1;
        }
        n6Var.e(8);
        return n6Var.l();
    }

    public static Id3Frame a(n6 n6Var, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            int i5 = n6Var.f27875b;
            if (i5 >= i2) {
                break;
            }
            int c2 = n6Var.c();
            int c3 = n6Var.c();
            n6Var.e(4);
            if (c3 == d1.D0) {
                str = n6Var.a(c2 - 12);
            } else if (c3 == d1.E0) {
                str2 = n6Var.a(c2 - 12);
            } else {
                if (c3 == d1.F0) {
                    i3 = i5;
                    i4 = c2;
                }
                n6Var.e(c2 - 12);
            }
        }
        if (!"com.apple.iTunes".equals(str) || !"iTunSMPB".equals(str2) || i3 == -1) {
            return null;
        }
        n6Var.d(i3);
        n6Var.e(16);
        return new CommentFrame("und", str2, n6Var.a(i4 - 16));
    }
}
