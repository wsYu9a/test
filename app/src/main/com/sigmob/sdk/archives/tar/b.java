package com.sigmob.sdk.archives.tar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class b extends com.sigmob.sdk.archives.c {

    /* renamed from: j */
    public static final int f17538j = 256;

    /* renamed from: k */
    public static final int f17539k = 8192;

    /* renamed from: d */
    public boolean f17540d;

    /* renamed from: e */
    public long f17541e;

    /* renamed from: f */
    public long f17542f;

    /* renamed from: g */
    public byte[] f17543g;

    /* renamed from: h */
    public final d f17544h;

    /* renamed from: i */
    public com.sigmob.sdk.archives.tar.a f17545i;

    public class a extends InputStreamReader {
        public a(InputStream inputStream, String str) throws UnsupportedEncodingException {
            super(inputStream, str);
        }

        @Override // java.io.InputStreamReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public b(InputStream inputStream) {
        this(inputStream, d.f17548j, 512);
    }

    @Override // com.sigmob.sdk.archives.c
    public boolean a(com.sigmob.sdk.archives.a aVar) {
        if (aVar instanceof com.sigmob.sdk.archives.tar.a) {
            return !((com.sigmob.sdk.archives.tar.a) aVar).u();
        }
        return false;
    }

    @Override // java.io.InputStream
    public int available() {
        long j10 = this.f17541e - this.f17542f;
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }

    @Override // com.sigmob.sdk.archives.c
    public com.sigmob.sdk.archives.a c() throws IOException {
        return e();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f17544h.a();
    }

    public final com.sigmob.sdk.archives.tar.a d() {
        return this.f17545i;
    }

    public com.sigmob.sdk.archives.tar.a e() throws IOException {
        if (this.f17540d) {
            return null;
        }
        if (this.f17545i != null) {
            long j10 = this.f17541e;
            long j11 = this.f17542f;
            do {
                j10 -= j11;
                if (j10 > 0) {
                    j11 = skip(j10);
                } else {
                    this.f17543g = null;
                }
            } while (j11 > 0);
            throw new RuntimeException("failed to skip current tar entry");
        }
        byte[] f10 = f();
        if (this.f17540d) {
            this.f17545i = null;
            return null;
        }
        com.sigmob.sdk.archives.tar.a aVar = new com.sigmob.sdk.archives.tar.a(f10);
        this.f17545i = aVar;
        this.f17542f = 0L;
        this.f17541e = aVar.c();
        if (this.f17545i.t()) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[256];
            while (true) {
                int read = read(bArr);
                if (read < 0) {
                    break;
                }
                stringBuffer.append(new String(bArr, 0, read));
            }
            c();
            if (this.f17545i == null) {
                return null;
            }
            if (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.f17545i.c(stringBuffer.toString());
        }
        if (this.f17545i.x()) {
            i();
        }
        if (this.f17545i.u()) {
            j();
        }
        return this.f17545i;
    }

    public final byte[] f() throws IOException {
        if (this.f17540d) {
            return null;
        }
        byte[] h10 = this.f17544h.h();
        if (h10 == null || this.f17544h.a(h10)) {
            this.f17540d = true;
        }
        if (this.f17540d) {
            return null;
        }
        return h10;
    }

    public int g() {
        return this.f17544h.f();
    }

    public final boolean h() {
        return this.f17540d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        r5 = new java.lang.StringBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r7 = r0.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r7 == (-1)) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r7 != 61) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0067, code lost:
    
        r5.append((char) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r5 = r5.toString();
        r4 = r4 - r3;
        r3 = new char[r4];
        r8 = r0.read(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r8 != r4) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r1.put(r5, new java.lang.String(r3, 0, r4 - 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0066, code lost:
    
        throw new java.io.IOException("Failed to read Paxheader. Expected " + r4 + " chars, read " + r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.archives.tar.b.i():void");
    }

    public final void j() throws IOException {
        byte[] f10;
        if (this.f17545i.q()) {
            do {
                f10 = f();
                if (this.f17540d) {
                    this.f17545i = null;
                    return;
                }
            } while (new c(f10).a());
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        long j10 = this.f17542f;
        long j11 = this.f17541e;
        if (j10 >= j11) {
            return -1;
        }
        if (i11 + j10 > j11) {
            i11 = (int) (j11 - j10);
        }
        byte[] bArr2 = this.f17543g;
        if (bArr2 != null) {
            i12 = i11 > bArr2.length ? bArr2.length : i11;
            System.arraycopy(bArr2, 0, bArr, i10, i12);
            byte[] bArr3 = this.f17543g;
            if (i12 >= bArr3.length) {
                this.f17543g = null;
            } else {
                int length = bArr3.length - i12;
                byte[] bArr4 = new byte[length];
                System.arraycopy(bArr3, i12, bArr4, 0, length);
                this.f17543g = bArr4;
            }
            i11 -= i12;
            i10 += i12;
        } else {
            i12 = 0;
        }
        while (i11 > 0) {
            byte[] h10 = this.f17544h.h();
            if (h10 == null) {
                throw new IOException("unexpected EOF with " + i11 + " bytes unread. Occured at byte: " + a());
            }
            a(h10.length);
            int length2 = h10.length;
            if (length2 > i11) {
                System.arraycopy(h10, 0, bArr, i10, i11);
                int i13 = length2 - i11;
                byte[] bArr5 = new byte[i13];
                this.f17543g = bArr5;
                System.arraycopy(h10, i11, bArr5, 0, i13);
                length2 = i11;
            } else {
                System.arraycopy(h10, 0, bArr, i10, length2);
            }
            i12 += length2;
            i11 -= length2;
            i10 += length2;
        }
        this.f17542f += i12;
        return i12;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        byte[] bArr = new byte[8192];
        long j11 = j10;
        while (j11 > 0) {
            long j12 = 8192;
            if (j11 <= j12) {
                j12 = j11;
            }
            int read = read(bArr, 0, (int) j12);
            if (read == -1) {
                break;
            }
            j11 -= read;
        }
        return j10 - j11;
    }

    public b(InputStream inputStream, int i10) {
        this(inputStream, i10, 512);
    }

    public static boolean a(byte[] bArr, int i10) {
        if (i10 < 265) {
            return false;
        }
        if (com.sigmob.sdk.archives.utils.a.a("ustar\u0000", bArr, 257, 6) && com.sigmob.sdk.archives.utils.a.a(e.S, bArr, e.f17568m, 2)) {
            return true;
        }
        if (com.sigmob.sdk.archives.utils.a.a(e.T, bArr, 257, 6) && (com.sigmob.sdk.archives.utils.a.a(e.U, bArr, e.f17568m, 2) || com.sigmob.sdk.archives.utils.a.a(e.V, bArr, e.f17568m, 2))) {
            return true;
        }
        return com.sigmob.sdk.archives.utils.a.a("ustar\u0000", bArr, 257, 6) && com.sigmob.sdk.archives.utils.a.a(e.X, bArr, e.f17568m, 2);
    }

    public b(InputStream inputStream, int i10, int i11) {
        this.f17544h = new d(inputStream, i10, i11);
        this.f17543g = null;
        this.f17540d = false;
    }

    public final void a(boolean z10) {
        this.f17540d = z10;
    }

    public final void a(com.sigmob.sdk.archives.tar.a aVar) {
        this.f17545i = aVar;
    }
}
