package com.vivo.channel.reader;

import android.app.Application;
import android.util.Pair;
import com.kuaishou.weapon.p0.t;
import com.vivo.channel.reader.a;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
public class ChannelReader {

    /* renamed from: a */
    private static final byte[] f27121a = {118, 105, 118, 111, 104, 111, 110, 103};

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) {
        Pair<ByteBuffer, Long> a2 = a.a(randomAccessFile);
        if (a2 != null) {
            return a2;
        }
        throw new a.C0565a("Not an APK file: ZIP End of Central Directory record not found");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
    
        if (r3 == null) goto L90;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00ae: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:49:0x00ae */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(java.io.File r10) {
        /*
            java.lang.String r0 = "ChannelReader"
            java.lang.String r1 = ""
            r2 = 0
            android.util.Pair r3 = b(r10)     // Catch: java.lang.Throwable -> L6e com.vivo.channel.reader.a.C0565a -> L70 java.io.IOException -> L7a
            if (r3 == 0) goto L5e
            java.lang.Object r3 = r3.first     // Catch: java.lang.Throwable -> L6e com.vivo.channel.reader.a.C0565a -> L70 java.io.IOException -> L7a
            java.nio.ByteBuffer r3 = (java.nio.ByteBuffer) r3     // Catch: java.lang.Throwable -> L6e com.vivo.channel.reader.a.C0565a -> L70 java.io.IOException -> L7a
            r4 = 20
            r3.position(r4)     // Catch: java.lang.Throwable -> L6e com.vivo.channel.reader.a.C0565a -> L70 java.io.IOException -> L7a
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L6e com.vivo.channel.reader.a.C0565a -> L70 java.io.IOException -> L7a
            java.lang.String r4 = "r"
            r3.<init>(r10, r4)     // Catch: java.lang.Throwable -> L6e com.vivo.channel.reader.a.C0565a -> L70 java.io.IOException -> L7a
            long r4 = r3.length()     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            byte[] r2 = com.vivo.channel.reader.ChannelReader.f27121a     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            int r6 = r2.length     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            byte[] r6 = new byte[r6]     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            int r2 = r2.length     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            long r7 = (long) r2     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            long r4 = r4 - r7
            r3.seek(r4)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            r3.readFully(r6)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            boolean r2 = a(r6)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            if (r2 == 0) goto L53
            r6 = 2
            long r4 = r4 - r6
            r3.seek(r4)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            short r2 = a(r3)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            if (r2 <= 0) goto L58
            long r6 = (long) r2     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            long r4 = r4 - r6
            r3.seek(r4)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            byte[] r2 = new byte[r2]     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            r3.readFully(r2)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            java.lang.String r4 = new java.lang.String     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            java.lang.String r5 = "UTF-8"
            r4.<init>(r2, r5)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
            r2 = r3
            r1 = r4
            goto L63
        L53:
            java.lang.String r2 = "MagicMatch false"
            android.util.Log.e(r0, r2)     // Catch: com.vivo.channel.reader.a.C0565a -> L5a java.io.IOException -> L5c java.lang.Throwable -> Lad
        L58:
            r2 = r3
            goto L63
        L5a:
            r2 = move-exception
            goto L74
        L5c:
            r2 = move-exception
            goto L7e
        L5e:
            java.lang.String r3 = "eocd is null"
            android.util.Log.e(r0, r3)     // Catch: java.lang.Throwable -> L6e com.vivo.channel.reader.a.C0565a -> L70 java.io.IOException -> L7a
        L63:
            if (r2 == 0) goto L86
            r2.close()     // Catch: java.io.IOException -> L69
            goto L86
        L69:
            r2 = move-exception
            r2.printStackTrace()
            goto L86
        L6e:
            r10 = move-exception
            goto Laf
        L70:
            r3 = move-exception
            r9 = r3
            r3 = r2
            r2 = r9
        L74:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L86
            goto L83
        L7a:
            r3 = move-exception
            r9 = r3
            r3 = r2
            r2 = r9
        L7e:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L86
        L83:
            r3.close()     // Catch: java.io.IOException -> L69
        L86:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L98
            java.lang.String r1 = "readChannel for value = -2012129793"
            android.util.Log.i(r0, r1)
            r1 = -2012129793(0xffffffff881155ff, float:-4.373544E-34)
            java.lang.String r1 = a(r10, r1)
        L98:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "readChannel end channel = "
            r10.append(r2)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            android.util.Log.i(r0, r10)
            return r1
        Lad:
            r10 = move-exception
            r2 = r3
        Laf:
            if (r2 == 0) goto Lb9
            r2.close()     // Catch: java.io.IOException -> Lb5
            goto Lb9
        Lb5:
            r0 = move-exception
            r0.printStackTrace()
        Lb9:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.channel.reader.ChannelReader.a(java.io.File):java.lang.String");
    }

    static String a(File file, int i2) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, t.k);
                try {
                    Pair<ByteBuffer, Long> a2 = a(randomAccessFile2);
                    ByteBuffer byteBuffer = (ByteBuffer) a2.first;
                    long longValue = ((Long) a2.second).longValue();
                    if (a.a(randomAccessFile2, longValue)) {
                        throw new a.C0565a("ZIP64 APK not supported");
                    }
                    String findChannel = findChannel(randomAccessFile2, getCentralDirOffset(byteBuffer, longValue), i2);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return findChannel;
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile == null) {
                        return "";
                    }
                    try {
                        randomAccessFile.close();
                        return "";
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    private static short a(DataInput dataInput) {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    private static boolean a(byte[] bArr) {
        if (bArr.length != f27121a.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f27121a;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static Pair<ByteBuffer, Long> b(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, t.k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Pair<ByteBuffer, Long> a2 = a(randomAccessFile);
            if (a.a(randomAccessFile, ((Long) a2.second).longValue())) {
                throw new a.C0565a("ZIP64 APK not supported");
            }
            try {
                randomAccessFile.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return a2;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String findChannel(RandomAccessFile randomAccessFile, long j2, int i2) {
        if (j2 < 32) {
            throw new IllegalArgumentException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j2);
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        randomAccessFile.seek(j2 - allocate.capacity());
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) != com.bytedance.hume.readapk.a.f5953b || allocate.getLong(16) != com.bytedance.hume.readapk.a.f5952a) {
            throw new IllegalArgumentException("No APK Signing Block before ZIP Central Directory");
        }
        long j3 = allocate.getLong(0);
        if (j3 < allocate.capacity() || j3 > 2147483639) {
            throw new IllegalArgumentException("APK Signing Block size out of range: " + j3);
        }
        long j4 = j2 - ((int) (j3 + 8));
        if (j4 < 0) {
            throw new IllegalArgumentException("APK Signing Block offset out of range: " + j4);
        }
        ByteBuffer allocate2 = ByteBuffer.allocate(12);
        allocate2.order(byteOrder);
        randomAccessFile.seek(j4);
        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
        long j5 = allocate2.getLong(0);
        if (j5 != j3) {
            throw new IllegalArgumentException("APK Signing Block sizes in header and footer do not match: " + j5 + " vs " + j3);
        }
        long j6 = j4 + 8;
        while (j6 <= j2) {
            allocate2.clear();
            randomAccessFile.seek(j6);
            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
            long j7 = allocate2.getLong();
            if (allocate2.getInt() == i2) {
                if (1896449818 == i2) {
                    return "";
                }
                ByteBuffer allocate3 = ByteBuffer.allocate((int) (j7 - 4));
                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.seek(j6 + 12);
                randomAccessFile.readFully(allocate3.array(), allocate3.arrayOffset(), allocate3.capacity());
                return new String(allocate3.array());
            }
            j6 += j7 + 8;
        }
        return "";
    }

    public static long getCentralDirOffset(ByteBuffer byteBuffer, long j2) {
        long a2 = a.a(byteBuffer);
        if (a2 < j2) {
            if (a.b(byteBuffer) + a2 == j2) {
                return a2;
            }
            throw new IllegalArgumentException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new IllegalArgumentException("ZIP Central Directory offset out of range: " + a2 + ". ZIP End of Central Directory offset: " + j2);
    }

    public static String readChannel(Application application) {
        return a(new File(application.getApplicationInfo().sourceDir));
    }
}
