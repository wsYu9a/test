package com.opos.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: classes4.dex */
class n extends r {

    /* renamed from: a */
    private final d f23829a;

    /* renamed from: b */
    private final com.opos.videocache.a.b f23830b;

    /* renamed from: c */
    private b f23831c;

    public n(d dVar, com.opos.videocache.a.b bVar) {
        super(dVar, bVar);
        this.f23830b = bVar;
        this.f23829a = dVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
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

    private boolean a(m mVar) {
        long a2 = this.f23829a.a();
        return (((a2 > 0L ? 1 : (a2 == 0L ? 0 : -1)) > 0) && mVar.f23828c && ((float) mVar.f23827b) > ((float) this.f23830b.a()) + (((float) a2) * 0.2f)) ? false : true;
    }

    private String b(m mVar) {
        String c2 = this.f23829a.c();
        boolean z = !TextUtils.isEmpty(c2);
        long a2 = this.f23830b.d() ? this.f23830b.a() : this.f23829a.a();
        boolean z2 = a2 >= 0;
        boolean z3 = mVar.f23828c;
        long j2 = z3 ? a2 - mVar.f23827b : a2;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(mVar.f23828c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j2)) : "");
        sb.append(z4 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(mVar.f23827b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : "");
        sb.append(z ? a("Content-Type: %s\n", c2) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j2) {
        d dVar = new d(this.f23829a);
        try {
            dVar.a((int) j2);
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = dVar.a(bArr);
                if (a2 == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, a2);
            }
        } finally {
            dVar.b();
        }
    }

    @Override // com.opos.videocache.r
    protected void a(int i2) {
        b bVar = this.f23831c;
        if (bVar != null) {
            bVar.a(this.f23830b.f23785a, this.f23829a.d(), i2);
        }
    }

    public void a(b bVar) {
        this.f23831c = bVar;
    }

    public void a(m mVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(mVar).getBytes("UTF-8"));
        long j2 = mVar.f23827b;
        if (a(mVar)) {
            a(bufferedOutputStream, j2);
        } else {
            b(bufferedOutputStream, j2);
        }
    }
}
