package yi;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes4.dex */
public class f extends InputStream {

    /* renamed from: b */
    public final PushbackInputStream f33534b;

    /* renamed from: c */
    public final a f33535c;

    /* renamed from: d */
    public boolean f33536d;

    public static final class a {

        /* renamed from: c */
        public static final a f33537c = new a(new byte[0], "NONE");

        /* renamed from: d */
        public static final a f33538d = new a(new byte[]{-17, -69, -65}, "UTF-8");

        /* renamed from: e */
        public static final a f33539e = new a(new byte[]{-1, -2}, "UTF-16 little-endian");

        /* renamed from: f */
        public static final a f33540f = new a(new byte[]{-2, -1}, "UTF-16 big-endian");

        /* renamed from: g */
        public static final a f33541g = new a(new byte[]{-1, -2, 0, 0}, "UTF-32 little-endian");

        /* renamed from: h */
        public static final a f33542h = new a(new byte[]{0, 0, -2, -1}, "UTF-32 big-endian");

        /* renamed from: i */
        public static final /* synthetic */ boolean f33543i = false;

        /* renamed from: a */
        public final byte[] f33544a;

        /* renamed from: b */
        public final String f33545b;

        public a(byte[] bArr, String str) {
            this.f33544a = bArr;
            this.f33545b = str;
        }

        public final byte[] a() {
            byte[] bArr = this.f33544a;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }

        public final String toString() {
            return this.f33545b;
        }
    }

    public f(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public final a a() {
        return this.f33535c;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f33534b.available();
    }

    public final synchronized f b() throws IOException {
        try {
            if (!this.f33536d) {
                long length = this.f33535c.f33544a.length;
                for (long skip = this.f33534b.skip(length); skip < length; skip++) {
                    this.f33534b.read();
                }
                this.f33536d = true;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f33534b.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i10) {
        this.f33534b.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f33534b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.f33536d = true;
        return this.f33534b.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f33534b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        this.f33536d = true;
        return this.f33534b.skip(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public f(java.io.InputStream r11, boolean r12) throws java.io.IOException {
        /*
            r10 = this;
            r10.<init>()
            r0 = 0
            r10.f33536d = r0
            if (r11 == 0) goto L88
            java.io.PushbackInputStream r1 = new java.io.PushbackInputStream
            r2 = 4
            r1.<init>(r11, r2)
            r10.f33534b = r1
            byte[] r11 = new byte[r2]
            int r3 = r1.read(r11)
            r4 = -2
            r5 = -1
            r6 = 2
            r7 = 1
            if (r3 == r6) goto L61
            r8 = 3
            if (r3 == r8) goto L4a
            if (r3 == r2) goto L22
            goto L79
        L22:
            r2 = r11[r0]
            if (r2 != r5) goto L37
            r9 = r11[r7]
            if (r9 != r4) goto L37
            r9 = r11[r6]
            if (r9 != 0) goto L37
            r9 = r11[r8]
            if (r9 != 0) goto L37
            yi.f$a r2 = yi.f.a.f33541g
            r10.f33535c = r2
            goto L7d
        L37:
            if (r2 != 0) goto L4a
            r2 = r11[r7]
            if (r2 != 0) goto L4a
            r2 = r11[r6]
            if (r2 != r4) goto L4a
            r2 = r11[r8]
            if (r2 != r5) goto L4a
            yi.f$a r2 = yi.f.a.f33542h
            r10.f33535c = r2
            goto L7d
        L4a:
            r2 = r11[r0]
            r8 = -17
            if (r2 != r8) goto L61
            r2 = r11[r7]
            r8 = -69
            if (r2 != r8) goto L61
            r2 = r11[r6]
            r6 = -65
            if (r2 != r6) goto L61
            yi.f$a r2 = yi.f.a.f33538d
            r10.f33535c = r2
            goto L7d
        L61:
            r2 = r11[r0]
            if (r2 != r5) goto L6e
            r6 = r11[r7]
            if (r6 != r4) goto L6e
            yi.f$a r2 = yi.f.a.f33539e
            r10.f33535c = r2
            goto L7d
        L6e:
            if (r2 != r4) goto L79
            r2 = r11[r7]
            if (r2 != r5) goto L79
            yi.f$a r2 = yi.f.a.f33540f
            r10.f33535c = r2
            goto L7d
        L79:
            yi.f$a r2 = yi.f.a.f33537c
            r10.f33535c = r2
        L7d:
            if (r3 <= 0) goto L82
            r1.unread(r11, r0, r3)
        L82:
            if (r12 == 0) goto L87
            r10.b()
        L87:
            return
        L88:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r12 = "invalid input stream: null is not allowed"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: yi.f.<init>(java.io.InputStream, boolean):void");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        this.f33536d = true;
        return this.f33534b.read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        this.f33536d = true;
        return this.f33534b.read(bArr, i10, i11);
    }
}
