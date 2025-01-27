package com.opos.exoplayer.core.c.g;

import com.martian.mibook.application.MiConfigSingleton;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.o;

/* loaded from: classes4.dex */
final class c {

    private static final class a {

        /* renamed from: a */
        public final int f18307a;

        /* renamed from: b */
        public final long f18308b;

        private a(int i2, long j2) {
            this.f18307a = i2;
            this.f18308b = j2;
        }

        public static a a(f fVar, m mVar) {
            fVar.c(mVar.f19048a, 0, 8);
            mVar.c(0);
            return new a(mVar.o(), mVar.n());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.exoplayer.core.c.g.b a(com.opos.exoplayer.core.c.f r17) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.g.c.a(com.opos.exoplayer.core.c.f):com.opos.exoplayer.core.c.g.b");
    }

    public static void a(f fVar, b bVar) {
        com.opos.exoplayer.core.i.a.a(fVar);
        com.opos.exoplayer.core.i.a.a(bVar);
        fVar.a();
        m mVar = new m(8);
        while (true) {
            a a2 = a.a(fVar, mVar);
            if (a2.f18307a == u.f(MiConfigSingleton.t0)) {
                fVar.b(8);
                bVar.a(fVar.c(), a2.f18308b);
                return;
            }
            com.opos.cmn.an.f.a.c("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.f18307a);
            long j2 = a2.f18308b + 8;
            if (a2.f18307a == u.f("RIFF")) {
                j2 = 12;
            }
            if (j2 > 2147483647L) {
                throw new o("Chunk is too large (~2GB+) to skip; id: " + a2.f18307a);
            }
            fVar.b((int) j2);
        }
    }
}
