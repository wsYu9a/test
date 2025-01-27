package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bu;
import com.kuaishou.weapon.p0.t;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static int f26273a;

    /* renamed from: b */
    private static Object f26274b = new Object();

    /* renamed from: com.umeng.commonsdk.stateless.d$1 */
    static class AnonymousClass1 implements Comparator<File> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$2 */
    static class AnonymousClass2 implements Comparator<File> {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$3 */
    static class AnonymousClass3 implements Comparator<File> {
        AnonymousClass3() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$4 */
    static class AnonymousClass4 implements Comparator<File> {
        AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file == null || file2 == null || file.lastModified() >= file2.lastModified()) {
                return (file == null || file2 == null || file.lastModified() != file2.lastModified()) ? 1 : 0;
            }
            return -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$5 */
    static class AnonymousClass5 implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ String f26275a;

        AnonymousClass5(String str) {
            str2 = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(str2);
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$6 */
    static class AnonymousClass6 implements Comparator<File> {
        AnonymousClass6() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file == null || file2 == null || file.lastModified() >= file2.lastModified()) {
                return (file == null || file2 == null || file.lastModified() != file2.lastModified()) ? 1 : 0;
            }
            return -1;
        }
    }

    public static boolean a(long j2, long j3) {
        return j2 > j3;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0101, code lost:
    
        if (r2 == null) goto L118;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r8, java.lang.String r9, java.lang.String r10, byte[] r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.b(android.content.Context, java.lang.String, java.lang.String, byte[]):boolean");
    }

    public static File[] c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f26274b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f26254f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f26274b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.3
                            AnonymousClass3() {
                            }

                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file22) {
                                long lastModified = file2.lastModified() - file22.lastModified();
                                if (lastModified > 0) {
                                    return 1;
                                }
                                return lastModified == 0 ? 0 : -1;
                            }
                        });
                        return listFiles;
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String d(String str) {
        int lastIndexOf;
        int lastIndexOf2;
        return (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (lastIndexOf = str.lastIndexOf("_")) >= 0 && (lastIndexOf2 = str.lastIndexOf(".")) >= 0) ? str.substring(lastIndexOf + 1, lastIndexOf2) : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        if (r1 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0061, code lost:
    
        if (r1 == null) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = 101(0x65, float:1.42E-43)
            if (r6 == 0) goto L75
            r1 = 0
            java.lang.Object r2 = com.umeng.commonsdk.stateless.d.f26274b     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r4.<init>()     // Catch: java.lang.Throwable -> L5a
            java.io.File r5 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            r4.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L5a
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L5a
            boolean r7 = r3.isDirectory()     // Catch: java.lang.Throwable -> L5a
            if (r7 != 0) goto L2e
            r3.mkdir()     // Catch: java.lang.Throwable -> L5a
        L2e:
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r4.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L5a
            r4.append(r3)     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            r4.append(r8)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L5a
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L5a
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L5a
            r8.write(r9)     // Catch: java.lang.Throwable -> L57
            r8.close()     // Catch: java.lang.Throwable -> L57
            r0 = 0
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5a
            goto L75
        L57:
            r7 = move-exception
            r1 = r8
            goto L5b
        L5a:
            r7 = move-exception
        L5b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5a
            throw r7     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
        L5d:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L75
        L63:
            r1.close()     // Catch: java.lang.Throwable -> L75
            goto L75
        L67:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L75
            goto L63
        L6e:
            r6 = move-exception
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.lang.Throwable -> L74
        L74:
            throw r6
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(android.content.Context, java.lang.String, java.lang.String, byte[]):int");
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(b2)));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static String c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] a(String str) throws IOException {
        byte[] bArr;
        synchronized (f26274b) {
            FileChannel fileChannel = null;
            try {
                try {
                    fileChannel = new RandomAccessFile(str, t.k).getChannel();
                    MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                    bArr = new byte[(int) fileChannel.size()];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                    try {
                        fileChannel.close();
                    } catch (Throwable unused) {
                    }
                } catch (IOException e2) {
                    ULog.i("walle", "[stateless] write envelope, e is " + e2.getMessage());
                    throw e2;
                }
            } catch (Throwable th) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        }
        return bArr;
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f26274b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f26254f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f26274b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.2
                            AnonymousClass2() {
                            }

                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file22) {
                                long lastModified = file2.lastModified() - file22.lastModified();
                                if (lastModified > 0) {
                                    return 1;
                                }
                                return lastModified == 0 ? 0 : -1;
                            }
                        });
                        return listFiles[0];
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static File a(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File file = null;
        try {
            synchronized (f26274b) {
                ULog.i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (context != null && context.getApplicationContext() != null) {
                    String str = context.getApplicationContext().getFilesDir() + File.separator + a.f26253e;
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            for (File file3 : listFiles) {
                                if (file3 != null && file3.isDirectory() && (listFiles2 = file3.listFiles()) != null && listFiles2.length > 0) {
                                    Arrays.sort(listFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.1
                                        AnonymousClass1() {
                                        }

                                        @Override // java.util.Comparator
                                        /* renamed from: a */
                                        public int compare(File file4, File file22) {
                                            long lastModified = file4.lastModified() - file22.lastModified();
                                            if (lastModified > 0) {
                                                return 1;
                                            }
                                            return lastModified == 0 ? 0 : -1;
                                        }
                                    });
                                    File file4 = listFiles2[0];
                                    if (file4 != null && (file == null || file.lastModified() > file4.lastModified())) {
                                        file = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                ULog.i("walle", "get last envelope end, thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return file;
    }

    public static byte[] b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, boolean z) {
        String str;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (z) {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f26253e;
            } else {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f26254f;
            }
            str2 = str;
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(Context context, String str, int i2) {
        try {
            if (str == null) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f26274b) {
                File[] listFiles = file.listFiles();
                ULog.i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                if (listFiles.length >= i2) {
                    ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i2) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.4
                            AnonymousClass4() {
                            }

                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file3, File file22) {
                                if (file3 == null || file22 == null || file3.lastModified() >= file22.lastModified()) {
                                    return (file3 == null || file22 == null || file3.lastModified() != file22.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i3)).getPath());
                            }
                        }
                        for (int i4 = 0; i4 <= arrayList.size() - i2; i4++) {
                            if (arrayList.get(i4) != null) {
                                ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i4)).getPath());
                                try {
                                    ((File) arrayList.get(i4)).delete();
                                    arrayList.remove(i4);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    ULog.i("AmapLBS", "[lbs-build] file size < max");
                }
                ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void a(Context context, String str, String str2, int i2) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                synchronized (f26274b) {
                    File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.umeng.commonsdk.stateless.d.5

                        /* renamed from: a */
                        final /* synthetic */ String f26275a;

                        AnonymousClass5(String str22) {
                            str2 = str22;
                        }

                        @Override // java.io.FilenameFilter
                        public boolean accept(File file2, String str3) {
                            return str3.startsWith(str2);
                        }
                    });
                    if (listFiles != null && listFiles.length >= i2) {
                        ULog.i("AmapLBS", "[lbs-build] file size >= max");
                        ArrayList arrayList = new ArrayList();
                        for (File file2 : listFiles) {
                            if (file2 != null) {
                                arrayList.add(file2);
                            }
                        }
                        if (arrayList.size() >= i2) {
                            Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.6
                                AnonymousClass6() {
                                }

                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(File file3, File file22) {
                                    if (file3 == null || file22 == null || file3.lastModified() >= file22.lastModified()) {
                                        return (file3 == null || file22 == null || file3.lastModified() != file22.lastModified()) ? 1 : 0;
                                    }
                                    return -1;
                                }
                            });
                            if (ULog.DEBUG) {
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i3)).getPath());
                                }
                            }
                            for (int i4 = 0; i4 <= arrayList.size() - i2; i4++) {
                                if (arrayList.get(i4) != null) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i4)).getPath());
                                    try {
                                        ((File) arrayList.get(i4)).delete();
                                        arrayList.remove(i4);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    } else {
                        ULog.i("AmapLBS", "[lbs-build] file size < max");
                    }
                    ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f26273a = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f26273a += deflate;
                    byteArrayOutputStream2.write(bArr2, 0, deflate);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(UMUtils.genIv()));
        return cipher.doFinal(bArr);
    }
}
