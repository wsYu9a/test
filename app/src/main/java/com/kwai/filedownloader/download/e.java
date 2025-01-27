package com.kwai.filedownloader.download;

import android.os.SystemClock;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class e {
    private final String RZ;
    private final int aGL;
    private final long aGT;
    long aGU;
    private final long aGV;
    private final f aHI;
    private final int aHK;
    private final com.kwai.filedownloader.a.a aHa;
    private final boolean aHi;
    private final c aIa;
    private final com.kwai.filedownloader.kwai.b aIb;
    private com.kwai.filedownloader.d.a aIc;
    private volatile long aId;
    private volatile long aIe;
    private final long contentLength;
    private volatile boolean lh;

    public static class a {
        String RZ;
        Integer aGR;
        com.kwai.filedownloader.download.a aGS;
        Boolean aHF;
        f aHI;
        Integer aHM;
        com.kwai.filedownloader.kwai.b aIb;
        c aIf;

        public final e Ii() {
            com.kwai.filedownloader.kwai.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            if (this.aHF == null || (bVar = this.aIb) == null || (aVar = this.aGS) == null || this.aHI == null || this.RZ == null || (num = this.aGR) == null || this.aHM == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.aIf, num.intValue(), this.aHM.intValue(), this.aHF.booleanValue(), this.aHI, this.RZ, (byte) 0);
        }

        public final a a(c cVar) {
            this.aIf = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.aHI = fVar;
            return this;
        }

        public final a bU(boolean z) {
            this.aHF = Boolean.valueOf(z);
            return this;
        }

        public final a c(com.kwai.filedownloader.download.a aVar) {
            this.aGS = aVar;
            return this;
        }

        public final a cT(int i2) {
            this.aHM = Integer.valueOf(i2);
            return this;
        }

        public final a cU(int i2) {
            this.aGR = Integer.valueOf(i2);
            return this;
        }

        public final a d(com.kwai.filedownloader.kwai.b bVar) {
            this.aIb = bVar;
            return this;
        }

        public final a ft(String str) {
            this.RZ = str;
            return this;
        }
    }

    private e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z, f fVar, String str) {
        this.aId = 0L;
        this.aIe = 0L;
        this.aHI = fVar;
        this.RZ = str;
        this.aIb = bVar;
        this.aHi = z;
        this.aIa = cVar;
        this.aHK = i3;
        this.aGL = i2;
        this.aHa = b.HF().HH();
        this.aGT = aVar.aGT;
        this.aGV = aVar.aGV;
        this.aGU = aVar.aGU;
        this.contentLength = aVar.contentLength;
    }

    /* synthetic */ e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z, f fVar, String str, byte b2) {
        this(bVar, aVar, cVar, i2, i3, z, fVar, str);
    }

    private void Ih() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwai.filedownloader.e.f.h(this.aGU - this.aId, elapsedRealtime - this.aIe)) {
            sync();
            this.aId = this.aGU;
            this.aIe = elapsedRealtime;
        }
    }

    private void sync() {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.aIc.IX();
            z = true;
        } catch (IOException e2) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z = false;
        }
        if (z) {
            if (this.aIa != null) {
                this.aHa.a(this.aGL, this.aHK, this.aGU);
            } else {
                this.aHI.HQ();
            }
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.aGL), Integer.valueOf(this.aHK), Long.valueOf(this.aGU), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public final void pause() {
        this.lh = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x011b, code lost:
    
        if (r13 == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x011d, code lost:
    
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0120, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r8);
        com.kwad.sdk.crash.utils.b.closeQuietly(r13);
        r6 = r16.aGU - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012d, code lost:
    
        if (r2 == (-1)) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0131, code lost:
    
        if (r2 != r6) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0170, code lost:
    
        throw new com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", java.lang.Long.valueOf(r6), java.lang.Long.valueOf(r2), java.lang.Long.valueOf(r16.aGT), java.lang.Long.valueOf(r16.aGV), java.lang.Long.valueOf(r16.aGU), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0171, code lost:
    
        r16.aHI.a(r16.aIa, r16.aGT, r16.aGV);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x017c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.e.run():void");
    }
}
