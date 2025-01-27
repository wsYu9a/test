package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: classes3.dex */
final class e extends k {
    private final p aGk;
    private final com.kwad.sdk.core.videocache.a.b aGl;
    private b aGm;

    public e(p pVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(pVar, bVar);
        this.aGl = bVar;
        this.aGk = pVar;
    }

    private String b(d dVar) {
        String In = this.aGk.In();
        boolean z10 = !TextUtils.isEmpty(In);
        long Id = this.aGl.isCompleted() ? this.aGl.Id() : this.aGk.length();
        boolean z11 = Id >= 0;
        boolean z12 = dVar.aGj;
        long j10 = z12 ? Id - dVar.aGi : Id;
        boolean z13 = z11 && z12;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dVar.aGj ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb2.append("Accept-Ranges: bytes\n");
        sb2.append(z11 ? format("Content-Length: %d\n", Long.valueOf(j10)) : "");
        sb2.append(z13 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.aGi), Long.valueOf(Id - 1), Long.valueOf(Id)) : "");
        sb2.append(z10 ? format("Content-Type: %s\n", In) : "");
        sb2.append("\n");
        return sb2.toString();
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(b bVar) {
        this.aGm = bVar;
    }

    @Override // com.kwad.sdk.core.videocache.k
    public final void dv(int i10) {
        b bVar = this.aGm;
        if (bVar != null) {
            bVar.a(this.aGl.file, i10);
        }
    }

    public final void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j10 = dVar.aGi;
        if (a(dVar)) {
            a(bufferedOutputStream, j10);
        } else {
            b(bufferedOutputStream, j10);
        }
    }

    private boolean a(d dVar) {
        long length = this.aGk.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.aGj && ((float) dVar.aGi) > ((float) this.aGl.Id()) + (((float) length) * 0.2f)) ? false : true;
    }

    private void a(OutputStream outputStream, long j10) {
        byte[] bArr = new byte[1024];
        while (true) {
            int a10 = a(bArr, j10, 1024);
            if (a10 == -1) {
                break;
            }
            try {
                outputStream.write(bArr, 0, a10);
                j10 += a10;
            } catch (Exception unused) {
            }
        }
        outputStream.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[Catch: all -> 0x0030, LOOP:0: B:8:0x0024->B:10:0x002b, LOOP_END, TryCatch #0 {all -> 0x0030, blocks: (B:7:0x001d, B:8:0x0024, B:10:0x002b, B:12:0x0032), top: B:6:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.io.OutputStream r3, long r4) {
        /*
            r2 = this;
            com.kwad.sdk.core.videocache.p r0 = r2.aGk
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.h
            if (r1 == 0) goto Lf
            com.kwad.sdk.core.videocache.h r1 = new com.kwad.sdk.core.videocache.h
            com.kwad.sdk.core.videocache.h r0 = (com.kwad.sdk.core.videocache.h) r0
            r1.<init>(r0)
        Ld:
            r0 = r1
            goto L1b
        Lf:
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.j
            if (r1 == 0) goto L1b
            com.kwad.sdk.core.videocache.j r1 = new com.kwad.sdk.core.videocache.j
            com.kwad.sdk.core.videocache.j r0 = (com.kwad.sdk.core.videocache.j) r0
            r1.<init>(r0)
            goto Ld
        L1b:
            int r5 = (int) r4
            long r4 = (long) r5
            r0.aC(r4)     // Catch: java.lang.Throwable -> L30
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L30
        L24:
            int r5 = r0.read(r4)     // Catch: java.lang.Throwable -> L30
            r1 = -1
            if (r5 == r1) goto L32
            r1 = 0
            r3.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L30
            goto L24
        L30:
            r3 = move-exception
            goto L39
        L32:
            r3.flush()     // Catch: java.lang.Throwable -> L30
            r0.close()
            return
        L39:
            r0.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.e.b(java.io.OutputStream, long):void");
    }
}
