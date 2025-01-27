package com.aggmoread.sdk.z.b.m;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class f implements k {

    /* renamed from: b */
    static final String f4702b = "f";

    /* renamed from: c */
    static k f4703c;

    /* renamed from: a */
    private b f4704a;

    public class b {

        /* renamed from: a */
        private final AtomicLong f4705a;

        /* renamed from: b */
        private final AtomicInteger f4706b;

        /* renamed from: c */
        private final long f4707c;

        /* renamed from: d */
        private final int f4708d;

        /* renamed from: e */
        private final Map<File, Long> f4709e;

        /* renamed from: f */
        protected File f4710f;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles = b.this.f4710f.listFiles();
                if (listFiles != null) {
                    int i10 = 0;
                    int i11 = 0;
                    for (File file : listFiles) {
                        i10 = (int) (i10 + b.this.a(file));
                        i11++;
                        b.this.f4709e.put(file, Long.valueOf(file.lastModified()));
                    }
                    b.this.f4705a.set(i10);
                    b.this.f4706b.set(i11);
                }
            }
        }

        private b(f fVar, File file, long j10, int i10) {
            this.f4709e = Collections.synchronizedMap(new HashMap());
            this.f4710f = file;
            this.f4707c = j10;
            this.f4708d = i10;
            this.f4705a = new AtomicLong();
            this.f4706b = new AtomicInteger();
            a();
        }

        private long b() {
            File file;
            if (this.f4709e.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> entrySet = this.f4709e.entrySet();
            synchronized (this.f4709e) {
                try {
                    file = null;
                    Long l10 = null;
                    for (Map.Entry<File, Long> entry : entrySet) {
                        if (file == null) {
                            file = entry.getKey();
                            l10 = entry.getValue();
                        } else {
                            Long value = entry.getValue();
                            if (value.longValue() < l10.longValue()) {
                                file = entry.getKey();
                                l10 = value;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            long a10 = a(file);
            if (file.delete()) {
                this.f4709e.remove(file);
            }
            return a10;
        }

        public /* synthetic */ b(f fVar, File file, long j10, int i10, a aVar) {
            this(fVar, file, j10, i10);
        }

        public long a(File file) {
            return file.length();
        }

        public File b(String str) {
            return new File(this.f4710f, str + hf.e.f26694a + str.hashCode() + "");
        }

        public boolean c(String str) {
            return a(str).delete();
        }

        public File a(String str) {
            File b10 = b(str);
            long currentTimeMillis = System.currentTimeMillis();
            Long valueOf = Long.valueOf(currentTimeMillis);
            b10.setLastModified(currentTimeMillis);
            this.f4709e.put(b10, valueOf);
            return b10;
        }

        public void b(File file) {
            int i10 = this.f4706b.get();
            while (i10 + 1 > this.f4708d) {
                this.f4705a.addAndGet(-b());
                i10 = this.f4706b.addAndGet(-1);
            }
            this.f4706b.addAndGet(1);
            long a10 = a(file);
            long j10 = this.f4705a.get();
            while (j10 + a10 > this.f4707c) {
                j10 = this.f4705a.addAndGet(-b());
            }
            this.f4705a.addAndGet(a10);
            long currentTimeMillis = System.currentTimeMillis();
            Long valueOf = Long.valueOf(currentTimeMillis);
            file.setLastModified(currentTimeMillis);
            this.f4709e.put(file, valueOf);
        }

        private void a() {
            new Thread(new a()).start();
        }
    }

    public static class c {
        private static int a(byte[] bArr, char c10) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                if (bArr[i10] == c10) {
                    return i10;
                }
            }
            return -1;
        }

        public static String c(String str) {
            return (str == null || !b(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        public static boolean d(String str) {
            return c(str.getBytes());
        }

        private static boolean b(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && a(bArr, b5.a.O) > 14;
        }

        private static boolean c(byte[] bArr) {
            String[] a10 = a(bArr);
            if (a10 != null && a10.length == 2) {
                String str = a10[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(a10[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        private static byte[] a(byte[] bArr, int i10, int i11) {
            int i12 = i11 - i10;
            if (i12 >= 0) {
                byte[] bArr2 = new byte[i12];
                System.arraycopy(bArr, i10, bArr2, 0, Math.min(bArr.length - i10, i12));
                return bArr2;
            }
            throw new IllegalArgumentException(i10 + " > " + i11);
        }

        private static String[] a(byte[] bArr) {
            if (b(bArr)) {
                return new String[]{new String(a(bArr, 0, 13)), new String(a(bArr, 14, a(bArr, b5.a.O)))};
            }
            return null;
        }
    }

    public f(File file, long j10, int i10) {
        if (file.exists() || file.mkdirs()) {
            this.f4704a = new b(file, j10, i10);
            return;
        }
        throw new RuntimeException("can't make dirs in " + file.getAbsolutePath());
    }

    public static f a(File file, long j10, int i10) {
        return new f(file, j10, i10);
    }

    public boolean b(String str) {
        return this.f4704a.c(str);
    }

    public static k a() {
        return f4703c;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    @Override // com.aggmoread.sdk.z.b.m.k
    public String a(String str) {
        BufferedReader bufferedReader;
        File a10 = this.f4704a.a(str);
        ?? exists = a10.exists();
        BufferedReader bufferedReader2 = null;
        try {
            if (exists == 0) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(a10));
                String str2 = "";
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = str2 + readLine;
                    } catch (IOException e10) {
                        e = e10;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                if (c.d(str2)) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    b(str);
                    return null;
                }
                String c10 = c.c(str2);
                try {
                    bufferedReader.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                return c10;
            } catch (IOException e14) {
                e = e14;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = exists;
        }
    }

    public static void a(Context context) {
        File filesDir = context.getFilesDir();
        String str = f4702b;
        File[] fileArr = {new File(filesDir, str), new File(context.getCacheDir(), str)};
        for (int i10 = 0; i10 < 2; i10++) {
            File file = fileArr[i10];
            if (file.exists() || file.mkdirs()) {
                try {
                    f a10 = a(file, 50000000L, Integer.MAX_VALUE);
                    com.aggmoread.sdk.z.b.d.c(f4702b, "init , cache dir = " + file.getAbsolutePath() + " , cacheHelper = " + a10);
                    f4703c = a10;
                    break;
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        if (f4703c == null) {
            f4703c = new g(context);
        }
    }

    @Override // com.aggmoread.sdk.z.b.m.k
    public void a(String str, String str2) {
        File b10 = this.f4704a.b(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(b10), 1024);
                    try {
                        bufferedWriter2.write(str2);
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (IOException e10) {
                        e = e10;
                        bufferedWriter = bufferedWriter2;
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        }
                        this.f4704a.b(b10);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.flush();
                                bufferedWriter.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        this.f4704a.b(b10);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e12) {
                e = e12;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
        this.f4704a.b(b10);
    }
}
