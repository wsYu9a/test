package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.ApicFrame;
import com.opos.exoplayer.core.metadata.id3.CommentFrame;
import com.opos.exoplayer.core.metadata.id3.Id3Frame;
import com.opos.exoplayer.core.metadata.id3.TextInformationFrame;
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
final class j {

    /* renamed from: a */
    private static final int f17965a = u.f("nam");

    /* renamed from: b */
    private static final int f17966b = u.f("trk");

    /* renamed from: c */
    private static final int f17967c = u.f("cmt");

    /* renamed from: d */
    private static final int f17968d = u.f("day");

    /* renamed from: e */
    private static final int f17969e = u.f("ART");

    /* renamed from: f */
    private static final int f17970f = u.f("too");

    /* renamed from: g */
    private static final int f17971g = u.f("alb");

    /* renamed from: h */
    private static final int f17972h = u.f("com");

    /* renamed from: i */
    private static final int f17973i = u.f("wrt");

    /* renamed from: j */
    private static final int f17974j = u.f("lyr");
    private static final int k = u.f("gen");
    private static final int l = u.f("covr");
    private static final int m = u.f("gnre");
    private static final int n = u.f("grp");
    private static final int o = u.f("disk");
    private static final int p = u.f("trkn");
    private static final int q = u.f("tmpo");
    private static final int r = u.f("cpil");
    private static final int s = u.f("aART");
    private static final int t = u.f("sonm");
    private static final int u = u.f("soal");
    private static final int v = u.f("soar");
    private static final int w = u.f("soaa");
    private static final int x = u.f("soco");
    private static final int y = u.f("rtng");
    private static final int z = u.f("pgap");
    private static final int A = u.f("sosn");
    private static final int B = u.f("tvsh");
    private static final int C = u.f("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static Metadata.Entry a(com.opos.exoplayer.core.i.m mVar) {
        String str;
        Metadata.Entry a2;
        String str2;
        int o2 = mVar.o() + mVar.d();
        int o3 = mVar.o();
        int i2 = (o3 >> 24) & 255;
        try {
            if (i2 == 169 || i2 == 65533) {
                int i3 = 16777215 & o3;
                if (i3 == f17967c) {
                    a2 = a(o3, mVar);
                } else {
                    if (i3 != f17965a && i3 != f17966b) {
                        if (i3 != f17972h && i3 != f17973i) {
                            if (i3 == f17968d) {
                                str = "TDRC";
                            } else if (i3 == f17969e) {
                                str = "TPE1";
                            } else if (i3 == f17970f) {
                                str = "TSSE";
                            } else if (i3 == f17971g) {
                                str = "TALB";
                            } else if (i3 == f17974j) {
                                str = "USLT";
                            } else if (i3 == k) {
                                str = "TCON";
                            } else {
                                if (i3 == n) {
                                    str = "TIT1";
                                }
                                com.opos.cmn.an.f.a.b("MetadataUtil", "Skipped unknown metadata entry: " + g.c(o3));
                                a2 = null;
                            }
                            a2 = a(o3, str, mVar);
                        }
                        str = "TCOM";
                        a2 = a(o3, str, mVar);
                    }
                    str = "TIT2";
                    a2 = a(o3, str, mVar);
                }
            } else if (o3 == m) {
                a2 = b(mVar);
            } else {
                if (o3 == o) {
                    str2 = "TPOS";
                } else if (o3 == p) {
                    str2 = "TRCK";
                } else if (o3 == q) {
                    a2 = a(o3, "TBPM", mVar, true, false);
                } else if (o3 == r) {
                    a2 = a(o3, "TCMP", mVar, true, true);
                } else if (o3 == l) {
                    a2 = c(mVar);
                } else {
                    if (o3 == s) {
                        str = "TPE2";
                    } else if (o3 == t) {
                        str = "TSOT";
                    } else if (o3 == u) {
                        str = "TSO2";
                    } else if (o3 == v) {
                        str = "TSOA";
                    } else if (o3 == w) {
                        str = "TSOP";
                    } else if (o3 == x) {
                        str = "TSOC";
                    } else if (o3 == y) {
                        a2 = a(o3, "ITUNESADVISORY", mVar, false, false);
                    } else if (o3 == z) {
                        a2 = a(o3, "ITUNESGAPLESS", mVar, false, true);
                    } else if (o3 == A) {
                        str = "TVSHOWSORT";
                    } else if (o3 == B) {
                        str = "TVSHOW";
                    } else {
                        if (o3 == C) {
                            a2 = a(mVar, o2);
                        }
                        com.opos.cmn.an.f.a.b("MetadataUtil", "Skipped unknown metadata entry: " + g.c(o3));
                        a2 = null;
                    }
                    a2 = a(o3, str, mVar);
                }
                a2 = b(o3, str2, mVar);
            }
            return a2;
        } finally {
            mVar.c(o2);
        }
    }

    private static CommentFrame a(int i2, com.opos.exoplayer.core.i.m mVar) {
        int o2 = mVar.o();
        if (mVar.o() == g.aF) {
            mVar.d(8);
            String f2 = mVar.f(o2 - 16);
            return new CommentFrame("und", f2, f2);
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse comment attribute: " + g.c(i2));
        return null;
    }

    private static Id3Frame a(int i2, String str, com.opos.exoplayer.core.i.m mVar, boolean z2, boolean z3) {
        int d2 = d(mVar);
        if (z3) {
            d2 = Math.min(1, d2);
        }
        if (d2 >= 0) {
            return z2 ? new TextInformationFrame(str, null, Integer.toString(d2)) : new CommentFrame("und", str, Integer.toString(d2));
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse uint8 attribute: " + g.c(i2));
        return null;
    }

    private static Id3Frame a(com.opos.exoplayer.core.i.m mVar, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (mVar.d() < i2) {
            int d2 = mVar.d();
            int o2 = mVar.o();
            int o3 = mVar.o();
            mVar.d(4);
            if (o3 == g.aD) {
                str = mVar.f(o2 - 12);
            } else if (o3 == g.aE) {
                str2 = mVar.f(o2 - 12);
            } else {
                if (o3 == g.aF) {
                    i3 = d2;
                    i4 = o2;
                }
                mVar.d(o2 - 12);
            }
        }
        if (!"com.apple.iTunes".equals(str) || !"iTunSMPB".equals(str2) || i3 == -1) {
            return null;
        }
        mVar.c(i3);
        mVar.d(16);
        return new CommentFrame("und", str2, mVar.f(i4 - 16));
    }

    private static TextInformationFrame a(int i2, String str, com.opos.exoplayer.core.i.m mVar) {
        int o2 = mVar.o();
        if (mVar.o() == g.aF) {
            mVar.d(8);
            return new TextInformationFrame(str, null, mVar.f(o2 - 16));
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse text attribute: " + g.c(i2));
        return null;
    }

    private static TextInformationFrame b(int i2, String str, com.opos.exoplayer.core.i.m mVar) {
        int o2 = mVar.o();
        if (mVar.o() == g.aF && o2 >= 22) {
            mVar.d(10);
            int h2 = mVar.h();
            if (h2 > 0) {
                String str2 = "" + h2;
                int h3 = mVar.h();
                if (h3 > 0) {
                    str2 = str2 + "/" + h3;
                }
                return new TextInformationFrame(str, null, str2);
            }
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse index/count attribute: " + g.c(i2));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.opos.exoplayer.core.metadata.id3.TextInformationFrame b(com.opos.exoplayer.core.i.m r3) {
        /*
            int r3 = d(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = com.opos.exoplayer.core.c.d.j.D
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1d
            com.opos.exoplayer.core.metadata.id3.TextInformationFrame r1 = new com.opos.exoplayer.core.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            r0 = r1
            goto L24
        L1d:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.opos.cmn.an.f.a.c(r3, r1)
        L24:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.d.j.b(com.opos.exoplayer.core.i.m):com.opos.exoplayer.core.metadata.id3.TextInformationFrame");
    }

    private static ApicFrame c(com.opos.exoplayer.core.i.m mVar) {
        String str;
        int o2 = mVar.o();
        if (mVar.o() == g.aF) {
            int b2 = g.b(mVar.o());
            String str2 = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
            if (str2 != null) {
                mVar.d(4);
                int i2 = o2 - 16;
                byte[] bArr = new byte[i2];
                mVar.a(bArr, 0, i2);
                return new ApicFrame(str2, null, 3, bArr);
            }
            str = "Unrecognized cover art flags: " + b2;
        } else {
            str = "Failed to parse cover art attribute";
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", str);
        return null;
    }

    private static int d(com.opos.exoplayer.core.i.m mVar) {
        mVar.d(4);
        if (mVar.o() == g.aF) {
            mVar.d(8);
            return mVar.g();
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
