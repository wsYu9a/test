package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class e {
    private final String Yx;
    private final int aiP;
    private final long aiX;
    long aiY;
    private final long aiZ;
    private final f ajM;
    private final int ajO;
    private final com.kwad.framework.filedownloader.b.a aje;
    private final boolean ajm;
    private final c ake;
    private final com.kwad.framework.filedownloader.a.b akf;
    private com.kwad.framework.filedownloader.e.a akg;
    private volatile long akh;
    private volatile long aki;
    private final long contentLength;
    private volatile boolean lW;

    public static class a {
        String Yx;
        Integer aiV;
        com.kwad.framework.filedownloader.download.a aiW;
        Boolean ajJ;
        f ajM;
        Integer ajQ;
        com.kwad.framework.filedownloader.a.b akf;
        c akj;

        public final a a(c cVar) {
            this.akj = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.ajM = fVar;
            return this;
        }

        public final a bg(boolean z10) {
            this.ajJ = Boolean.valueOf(z10);
            return this;
        }

        public final a bp(String str) {
            this.Yx = str;
            return this;
        }

        public final a bw(int i10) {
            this.ajQ = Integer.valueOf(i10);
            return this;
        }

        public final a bx(int i10) {
            this.aiV = Integer.valueOf(i10);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.aiW = aVar;
            return this;
        }

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.akf = bVar;
            return this;
        }

        public final e xa() {
            com.kwad.framework.filedownloader.a.b bVar;
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num;
            if (this.ajJ == null || (bVar = this.akf) == null || (aVar = this.aiW) == null || this.ajM == null || this.Yx == null || (num = this.aiV) == null || this.ajQ == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.akj, num.intValue(), this.ajQ.intValue(), this.ajJ.booleanValue(), this.ajM, this.Yx, (byte) 0);
        }
    }

    public /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i10, int i11, boolean z10, f fVar, String str, byte b10) {
        this(bVar, aVar, cVar, i10, i11, z10, fVar, str);
    }

    private void sync() {
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.akg.xQ();
            if (this.ake != null) {
                this.aje.a(this.aiP, this.ajO, this.aiY);
            } else {
                this.ajM.wI();
            }
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.aiP), Integer.valueOf(this.ajO), Long.valueOf(this.aiY), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        } catch (IOException e10) {
            if (com.kwad.framework.filedownloader.f.d.alt) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e10);
            }
        }
    }

    private void wZ() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.aiY - this.akh, elapsedRealtime - this.aki)) {
            sync();
            this.akh = this.aiY;
            this.aki = elapsedRealtime;
        }
    }

    public final void pause() {
        this.lW = true;
    }

    public final void run() {
        com.kwad.framework.filedownloader.e.a aVar;
        InputStream inputStream;
        if (this.lW) {
            return;
        }
        long b10 = com.kwad.framework.filedownloader.f.f.b(this.ajO, this.akf);
        if (b10 == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.aiP), Integer.valueOf(this.ajO)));
        }
        long j10 = this.contentLength;
        if (j10 > 0 && b10 != j10) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.aiZ == 0 ? com.kwad.framework.filedownloader.f.f.b("range[%d-)", Long.valueOf(this.aiY)) : com.kwad.framework.filedownloader.f.f.b("range[%d-%d)", Long.valueOf(this.aiY), Long.valueOf(this.aiZ)), Long.valueOf(this.contentLength), Long.valueOf(b10), Integer.valueOf(this.aiP), Integer.valueOf(this.ajO)));
        }
        long j11 = this.aiY;
        try {
            boolean wA = b.ww().wA();
            if (this.ake != null && !wA) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            com.kwad.framework.filedownloader.e.a bE = com.kwad.framework.filedownloader.f.f.bE(this.Yx);
            try {
                this.akg = bE;
                if (wA) {
                    bE.seek(this.aiY);
                }
                if (com.kwad.framework.filedownloader.f.d.alt) {
                    aVar = bE;
                    try {
                        com.kwad.framework.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.ajO), Long.valueOf(this.aiX), Long.valueOf(this.aiZ), Long.valueOf(this.aiY));
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        throw th;
                    }
                } else {
                    aVar = bE;
                }
                inputStream = this.akf.getInputStream();
                try {
                    byte[] bArr = new byte[4096];
                    if (this.lW) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        return;
                    }
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        aVar.write(bArr, 0, read);
                        long j12 = read;
                        this.aiY += j12;
                        this.ajM.onProgress(j12);
                        wZ();
                        if (this.lW) {
                            break;
                        } else if (this.ajm && com.kwad.framework.filedownloader.f.f.ya()) {
                            throw new FileDownloadNetworkPolicyException();
                        }
                    }
                    if (aVar != null) {
                        sync();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    long j13 = this.aiY - j11;
                    if (b10 != -1 && b10 != j13) {
                        throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", Long.valueOf(j13), Long.valueOf(b10), Long.valueOf(this.aiX), Long.valueOf(this.aiZ), Long.valueOf(this.aiY), Long.valueOf(j11)));
                    }
                    this.ajM.a(this.ake, this.aiX, this.aiZ);
                } catch (Throwable th3) {
                    th = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                aVar = bE;
            }
        } catch (Throwable th5) {
            th = th5;
            aVar = null;
        }
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i10, int i11, boolean z10, f fVar, String str) {
        this.akh = 0L;
        this.aki = 0L;
        this.ajM = fVar;
        this.Yx = str;
        this.akf = bVar;
        this.ajm = z10;
        this.ake = cVar;
        this.ajO = i11;
        this.aiP = i10;
        this.aje = b.ww().wy();
        this.aiX = aVar.aiX;
        this.aiZ = aVar.aiZ;
        this.aiY = aVar.aiY;
        this.contentLength = aVar.contentLength;
    }
}
