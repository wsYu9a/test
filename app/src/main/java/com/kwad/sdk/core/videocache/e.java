package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: classes2.dex */
final class e extends j {
    private final h anC;
    private final com.kwad.sdk.core.videocache.kwai.b anD;
    private b anE;

    public e(h hVar, com.kwad.sdk.core.videocache.kwai.b bVar) {
        super(hVar, bVar);
        this.anD = bVar;
        this.anC = hVar;
    }

    private void a(OutputStream outputStream, long j2) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j2, 8192);
            if (a2 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a2);
                j2 += a2;
            }
        }
    }

    private boolean a(d dVar) {
        long length = this.anC.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.anB && ((float) dVar.anA) > ((float) this.anD.yw()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String yF = this.anC.yF();
        boolean z = !TextUtils.isEmpty(yF);
        long yw = this.anD.isCompleted() ? this.anD.yw() : this.anC.length();
        boolean z2 = yw >= 0;
        boolean z3 = dVar.anB;
        long j2 = z3 ? yw - dVar.anA : yw;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.anB ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? format("Content-Length: %d\n", Long.valueOf(j2)) : "");
        sb.append(z4 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.anA), Long.valueOf(yw - 1), Long.valueOf(yw)) : "");
        sb.append(z ? format("Content-Type: %s\n", yF) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j2) {
        h hVar = new h(this.anC);
        try {
            hVar.V((int) j2);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = hVar.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            hVar.close();
        }
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(b bVar) {
        this.anE = bVar;
    }

    public final void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j2 = dVar.anA;
        if (a(dVar)) {
            a(bufferedOutputStream, j2);
        } else {
            b(bufferedOutputStream, j2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.j
    protected final void bC(int i2) {
        b bVar = this.anE;
        if (bVar != null) {
            bVar.a(this.anD.file, i2);
        }
    }
}
