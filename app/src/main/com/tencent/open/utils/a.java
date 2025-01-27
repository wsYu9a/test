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
    private static final j f23249a = new j(101010256);

    /* renamed from: b */
    private static final k f23250b = new k(38651);

    /* renamed from: com.tencent.open.utils.a$a */
    public static class C0663a {

        /* renamed from: a */
        Properties f23251a;

        /* renamed from: b */
        byte[] f23252b;

        private C0663a() {
            this.f23251a = new Properties();
        }

        public void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = a.f23250b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!a.f23250b.equals(new k(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int b10 = new k(bArr3).b();
            if ((bArr.length - length) - 2 < b10) {
                return;
            }
            byte[] bArr4 = new byte[b10];
            wrap.get(bArr4);
            this.f23251a.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - b10) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.f23252b = bArr5;
                wrap.get(bArr5);
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f23251a + ", otherData=" + Arrays.toString(this.f23252b) + "]";
        }

        public /* synthetic */ C0663a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, t.f11211k);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] a10 = a(randomAccessFile);
            if (a10 == null) {
                randomAccessFile.close();
                return null;
            }
            C0663a c0663a = new C0663a();
            c0663a.a(a10);
            String property = c0663a.f23251a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th3) {
            th = th3;
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
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a10 = f23249a.a();
        int read = randomAccessFile.read();
        while (read != -1) {
            if (read == a10[0] && randomAccessFile.read() == a10[1] && randomAccessFile.read() == a10[2] && randomAccessFile.read() == a10[3]) {
                randomAccessFile.seek(length + 20);
                byte[] bArr = new byte[2];
                randomAccessFile.readFully(bArr);
                int b10 = new k(bArr).b();
                if (b10 == 0) {
                    return null;
                }
                byte[] bArr2 = new byte[b10];
                randomAccessFile.read(bArr2);
                return bArr2;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
