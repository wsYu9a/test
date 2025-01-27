package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class a {
    public static d a(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, t.f11211k);
        } catch (Throwable th2) {
            th = th2;
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
            long j10 = length - 22;
            randomAccessFile.seek(j10);
            if (dVar.f7851c.a(randomAccessFile) != 101010256) {
                j10 = b(randomAccessFile, dVar);
            }
            randomAccessFile.seek(j10 + 4);
            com.bytedance.pangle.util.b.b.b bVar = new com.bytedance.pangle.util.b.b.b();
            randomAccessFile.skipBytes(6);
            bVar.f7837a = dVar.f7851c.b(randomAccessFile);
            randomAccessFile.skipBytes(4);
            bVar.f7838b = dVar.f7851c.a(randomAccessFile);
            dVar.f7850b = bVar;
            if (bVar.f7837a == 0) {
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
        } catch (Throwable th3) {
            th = th3;
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
            if (dVar.f7851c.a(randomAccessFile) == 101010256) {
                return length;
            }
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private static void a(RandomAccessFile randomAccessFile, d dVar) {
        com.bytedance.pangle.util.b.b.a aVar = new com.bytedance.pangle.util.b.b.a();
        ArrayList arrayList = new ArrayList();
        com.bytedance.pangle.util.b.b.b bVar = dVar.f7850b;
        long j10 = bVar.f7838b;
        long j11 = bVar.f7837a;
        randomAccessFile.seek(j10);
        for (int i10 = 0; i10 < j11; i10++) {
            com.bytedance.pangle.util.b.b.c cVar = new com.bytedance.pangle.util.b.b.c();
            if (dVar.f7851c.a(randomAccessFile) == 33639248) {
                randomAccessFile.skipBytes(6);
                cVar.f7839a = dVar.f7851c.b(randomAccessFile);
                randomAccessFile.skipBytes(4);
                cVar.f7840b = dVar.f7851c.a(randomAccessFile);
                cVar.f7841c = dVar.f7851c.a(randomAccessFile);
                cVar.f7842d = dVar.f7851c.a(randomAccessFile);
                int b10 = dVar.f7851c.b(randomAccessFile);
                cVar.f7843e = b10;
                cVar.f7844f = dVar.f7851c.b(randomAccessFile);
                int b11 = dVar.f7851c.b(randomAccessFile);
                randomAccessFile.skipBytes(8);
                cVar.f7847i = dVar.f7851c.a(randomAccessFile);
                if (b10 > 0) {
                    byte[] bArr = new byte[b10];
                    randomAccessFile.readFully(bArr);
                    cVar.f7846h = new String(bArr, Charset.forName("UTF-8"));
                    randomAccessFile.skipBytes(cVar.f7844f);
                    if (b11 > 0) {
                        randomAccessFile.skipBytes(b11);
                    }
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(cVar.f7847i + 28);
                    cVar.f7845g = dVar.f7851c.b(randomAccessFile);
                    randomAccessFile.seek(filePointer);
                    arrayList.add(cVar);
                } else {
                    throw new IOException("Invalid entry name in file header");
                }
            } else {
                throw new IOException("Expected central directory entry not found (#" + (i10 + 1) + ")");
            }
        }
        aVar.f7836a = arrayList;
        dVar.f7849a = aVar;
    }
}
