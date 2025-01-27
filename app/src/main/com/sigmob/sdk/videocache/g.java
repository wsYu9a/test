package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: classes4.dex */
public class g extends p {

    /* renamed from: m */
    public static final float f20602m = 0.2f;

    /* renamed from: j */
    public final u f20603j;

    /* renamed from: k */
    public final com.sigmob.sdk.videocache.file.b f20604k;

    /* renamed from: l */
    public d f20605l;

    public g(u uVar, com.sigmob.sdk.videocache.file.b bVar) {
        super(uVar, bVar);
        this.f20604k = bVar;
        this.f20603j = uVar;
    }

    public final String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final String b(f fVar) {
        return "HTTP/1.1 404 Not Found\n";
    }

    public final String c(f fVar) throws IOException, q {
        String a10 = this.f20603j.a();
        boolean z10 = !TextUtils.isEmpty(a10);
        long a11 = this.f20604k.b() ? this.f20604k.a() : this.f20603j.d();
        boolean z11 = a11 >= 0;
        boolean z12 = fVar.f20591c;
        long j10 = z12 ? a11 - fVar.f20590b : a11;
        boolean z13 = z11 && z12;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(fVar.f20591c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb2.append("Accept-Ranges: bytes\n");
        sb2.append(z11 ? a("Content-Length: %d\n", Long.valueOf(j10)) : "");
        sb2.append(z13 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(fVar.f20590b), Long.valueOf(a11 - 1), Long.valueOf(a11)) : "");
        sb2.append(z10 ? a("Content-Type: %s\n", a10) : "");
        sb2.append("\n");
        return sb2.toString();
    }

    public final boolean a(f fVar) throws q {
        long d10 = this.f20603j.d();
        return (((d10 > 0L ? 1 : (d10 == 0L ? 0 : -1)) > 0) && fVar.f20591c && ((float) fVar.f20590b) > ((float) this.f20604k.a()) + (((float) d10) * 0.2f)) ? false : true;
    }

    public final void b(OutputStream outputStream, long j10) throws q, IOException {
        u a10 = t.a(this.f20603j);
        try {
            a10.a((int) j10);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = a10.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    a10.close();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            a10.close();
            throw th2;
        }
    }

    @Override // com.sigmob.sdk.videocache.p
    public void c(Throwable th2) {
        super.c(th2);
        d dVar = this.f20605l;
        if (dVar != null) {
            dVar.a(this.f20603j.c(), th2);
        }
    }

    @Override // com.sigmob.sdk.videocache.p
    public void a(int i10) {
        d dVar = this.f20605l;
        if (dVar != null) {
            dVar.a(this.f20604k.f20594b, this.f20603j.c(), i10);
        }
    }

    public void a(f fVar, Socket socket) throws IOException, q {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(c(fVar).getBytes("UTF-8"));
        long j10 = fVar.f20590b;
        if (a(fVar)) {
            a(bufferedOutputStream, j10);
        } else {
            b(bufferedOutputStream, j10);
        }
    }

    public void a(d dVar) {
        this.f20605l = dVar;
    }

    public final void a(OutputStream outputStream, long j10) throws q, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int a10 = a(bArr, j10, 8192);
            if (a10 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a10);
                j10 += a10;
            }
        }
    }
}
