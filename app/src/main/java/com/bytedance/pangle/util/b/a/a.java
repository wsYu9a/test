package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a {
    public static d a(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, t.k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() < 22) {
                throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
            }
            d dVar = new d(str);
            long length = randomAccessFile.length();
            if (length < 22) {
                throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
            }
            long j2 = length - 22;
            randomAccessFile.seek(j2);
            if (dVar.f6328c.a(randomAccessFile) != 101010256) {
                j2 = b(randomAccessFile, dVar);
            }
            randomAccessFile.seek(j2 + 4);
            com.bytedance.pangle.util.b.b.b bVar = new com.bytedance.pangle.util.b.b.b();
            randomAccessFile.skipBytes(6);
            bVar.f6314a = dVar.f6328c.b(randomAccessFile);
            randomAccessFile.skipBytes(4);
            bVar.f6315b = dVar.f6328c.a(randomAccessFile);
            dVar.f6327b = bVar;
            if (bVar.f6314a == 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                }
                return dVar;
            }
            a(randomAccessFile, dVar);
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            return dVar;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private static long b(RandomAccessFile randomAccessFile, d dVar) {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            randomAccessFile.seek(length);
            if (dVar.f6328c.a(randomAccessFile) == 101010256) {
                return length;
            }
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private static void a(RandomAccessFile randomAccessFile, d dVar) {
        com.bytedance.pangle.util.b.b.a aVar = new com.bytedance.pangle.util.b.b.a();
        ArrayList arrayList = new ArrayList();
        com.bytedance.pangle.util.b.b.b bVar = dVar.f6327b;
        long j2 = bVar.f6315b;
        long j3 = bVar.f6314a;
        randomAccessFile.seek(j2);
        for (int i2 = 0; i2 < j3; i2++) {
            com.bytedance.pangle.util.b.b.c cVar = new com.bytedance.pangle.util.b.b.c();
            if (dVar.f6328c.a(randomAccessFile) == 33639248) {
                randomAccessFile.skipBytes(6);
                cVar.f6316a = dVar.f6328c.b(randomAccessFile);
                randomAccessFile.skipBytes(4);
                cVar.f6317b = dVar.f6328c.a(randomAccessFile);
                cVar.f6318c = dVar.f6328c.a(randomAccessFile);
                cVar.f6319d = dVar.f6328c.a(randomAccessFile);
                int b2 = dVar.f6328c.b(randomAccessFile);
                cVar.f6320e = b2;
                cVar.f6321f = dVar.f6328c.b(randomAccessFile);
                int b3 = dVar.f6328c.b(randomAccessFile);
                randomAccessFile.skipBytes(8);
                cVar.f6324i = dVar.f6328c.a(randomAccessFile);
                if (b2 > 0) {
                    byte[] bArr = new byte[b2];
                    randomAccessFile.readFully(bArr);
                    cVar.f6323h = new String(bArr, Charset.forName("UTF-8"));
                    randomAccessFile.skipBytes(cVar.f6321f);
                    if (b3 > 0) {
                        randomAccessFile.skipBytes(b3);
                    }
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(cVar.f6324i + 28);
                    cVar.f6322g = dVar.f6328c.b(randomAccessFile);
                    randomAccessFile.seek(filePointer);
                    arrayList.add(cVar);
                } else {
                    throw new IOException("Invalid entry name in file header");
                }
            } else {
                throw new IOException("Expected central directory entry not found (#" + (i2 + 1) + ")");
            }
        }
        aVar.f6313a = arrayList;
        dVar.f6326a = aVar;
    }
}
