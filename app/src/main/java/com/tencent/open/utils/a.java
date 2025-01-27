package com.tencent.open.utils;

import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static final j f25515a = new j(101010256);

    /* renamed from: b */
    private static final k f25516b = new k(38651);

    /* renamed from: com.tencent.open.utils.a$a */
    private static class C0534a {

        /* renamed from: a */
        Properties f25517a;

        /* renamed from: b */
        byte[] f25518b;

        private C0534a() {
            this.f25517a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = a.f25516b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!a.f25516b.equals(new k(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int b2 = new k(bArr3).b();
            if ((bArr.length - length) - 2 < b2) {
                return;
            }
            byte[] bArr4 = new byte[b2];
            wrap.get(bArr4);
            this.f25517a.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - b2) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.f25518b = bArr5;
                wrap.get(bArr5);
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f25517a + ", otherData=" + Arrays.toString(this.f25518b) + "]";
        }

        /* synthetic */ C0534a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, t.k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] a2 = a(randomAccessFile);
            if (a2 == null) {
                randomAccessFile.close();
                return null;
            }
            C0534a c0534a = new C0534a();
            c0534a.a(a2);
            String property = c0534a.f25517a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a2 = f25515a.a();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
            if (read == -1) {
                z = false;
                break;
            }
            if (read == a2[0] && randomAccessFile.read() == a2[1] && randomAccessFile.read() == a2[2] && randomAccessFile.read() == a2[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int b2 = new k(bArr).b();
            if (b2 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b2];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
