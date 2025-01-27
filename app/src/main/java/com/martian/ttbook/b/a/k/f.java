package com.martian.ttbook.b.a.k;

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

/* loaded from: classes4.dex */
public class f implements k {

    /* renamed from: a */
    static final String f15049a = "f";

    /* renamed from: b */
    static k f15050b;

    /* renamed from: c */
    private b f15051c;

    public class b {

        /* renamed from: a */
        private final AtomicLong f15052a;

        /* renamed from: b */
        private final AtomicInteger f15053b;

        /* renamed from: c */
        private final long f15054c;

        /* renamed from: d */
        private final int f15055d;

        /* renamed from: e */
        private final Map<File, Long> f15056e;

        /* renamed from: f */
        protected File f15057f;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles = b.this.f15057f.listFiles();
                if (listFiles != null) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file : listFiles) {
                        i2 = (int) (i2 + b.this.b(file));
                        i3++;
                        b.this.f15056e.put(file, Long.valueOf(file.lastModified()));
                    }
                    b.this.f15052a.set(i2);
                    b.this.f15053b.set(i3);
                }
            }
        }

        private b(f fVar, File file, long j2, int i2) {
            this.f15056e = Collections.synchronizedMap(new HashMap());
            this.f15057f = file;
            this.f15054c = j2;
            this.f15055d = i2;
            this.f15052a = new AtomicLong();
            this.f15053b = new AtomicInteger();
            f();
        }

        /* synthetic */ b(f fVar, File file, long j2, int i2, a aVar) {
            this(fVar, file, j2, i2);
        }

        public long b(File file) {
            return file.length();
        }

        public File d(String str) {
            File h2 = h(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            h2.setLastModified(valueOf.longValue());
            this.f15056e.put(h2, valueOf);
            return h2;
        }

        private void f() {
            new Thread(new a()).start();
        }

        private long g() {
            File file;
            if (this.f15056e.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> entrySet = this.f15056e.entrySet();
            synchronized (this.f15056e) {
                file = null;
                Long l = null;
                for (Map.Entry<File, Long> entry : entrySet) {
                    if (file == null) {
                        file = entry.getKey();
                        l = entry.getValue();
                    } else {
                        Long value = entry.getValue();
                        if (value.longValue() < l.longValue()) {
                            file = entry.getKey();
                            l = value;
                        }
                    }
                }
            }
            long b2 = b(file);
            if (file.delete()) {
                this.f15056e.remove(file);
            }
            return b2;
        }

        public File h(String str) {
            return new File(this.f15057f, str + "_" + str.hashCode() + "");
        }

        public void k(File file) {
            int i2 = this.f15053b.get();
            while (i2 + 1 > this.f15055d) {
                this.f15052a.addAndGet(-g());
                i2 = this.f15053b.addAndGet(-1);
            }
            this.f15053b.addAndGet(1);
            long b2 = b(file);
            long j2 = this.f15052a.get();
            while (j2 + b2 > this.f15054c) {
                j2 = this.f15052a.addAndGet(-g());
            }
            this.f15052a.addAndGet(b2);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.f15056e.put(file, valueOf);
        }

        public boolean o(String str) {
            return d(str).delete();
        }
    }

    private static class c {
        private static int a(byte[] bArr, char c2) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] == c2) {
                    return i2;
                }
            }
            return -1;
        }

        private static byte[] c(byte[] bArr, int i2, int i3) {
            int i4 = i3 - i2;
            if (i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
                return bArr2;
            }
            throw new IllegalArgumentException(i2 + " > " + i3);
        }

        private static String[] d(byte[] bArr) {
            if (f(bArr)) {
                return new String[]{new String(c(bArr, 0, 13)), new String(c(bArr, 14, a(bArr, ' ')))};
            }
            return null;
        }

        private static boolean f(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && a(bArr, ' ') > 14;
        }

        public static String g(String str) {
            return (str == null || !f(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        private static boolean h(byte[] bArr) {
            String[] d2 = d(bArr);
            if (d2 != null && d2.length == 2) {
                String str = d2[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(d2[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean i(String str) {
            return h(str.getBytes());
        }
    }

    public f(File file, long j2, int i2) {
        if (file.exists() || file.mkdirs()) {
            this.f15051c = new b(file, j2, i2);
            return;
        }
        throw new RuntimeException("can't make dirs in " + file.getAbsolutePath());
    }

    static f a(File file, long j2, int i2) {
        return new f(file, j2, i2);
    }

    public static k b() {
        return f15050b;
    }

    public static void c(Context context) {
        File filesDir = context.getFilesDir();
        String str = f15049a;
        File file = new File(filesDir, str);
        File[] fileArr = {file, new File(context.getCacheDir(), str)};
        for (int i2 = 0; i2 < 2; i2++) {
            File file2 = fileArr[i2];
            if (file2.exists() || file2.mkdirs()) {
                try {
                    f a2 = a(file2, 50000000L, Integer.MAX_VALUE);
                    b.d.e.c.a.d.k(f15049a, "init , cache dir = " + file2.getAbsolutePath() + " , cacheHelper = " + a2);
                    f15050b = a2;
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (f15050b == null) {
            f15050b = new g(context);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    @Override // com.martian.ttbook.b.a.k.k
    public String a(String str) {
        BufferedReader bufferedReader;
        File d2 = this.f15051c.d(str);
        ?? exists = d2.exists();
        BufferedReader bufferedReader2 = null;
        try {
            if (exists == 0) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(d2));
                String str2 = "";
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str2 = str2 + readLine;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                if (c.i(str2)) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    d(str);
                    return null;
                }
                String g2 = c.g(str2);
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return g2;
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = exists;
        }
    }

    @Override // com.martian.ttbook.b.a.k.k
    public void a(String str, String str2) {
        File h2 = this.f15051c.h(str);
        BufferedWriter bufferedWriter = null;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(h2), 1024);
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                } catch (IOException e3) {
                    e = e3;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    }
                    this.f15051c.k(h2);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    this.f15051c.k(h2);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
            this.f15051c.k(h2);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean d(String str) {
        return this.f15051c.o(str);
    }
}
