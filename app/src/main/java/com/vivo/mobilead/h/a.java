package com.vivo.mobilead.h;

import com.vivo.mobilead.util.VOpenLog;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class a implements Closeable {
    static final Pattern o = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final OutputStream p = new b();

    /* renamed from: a */
    private final File f28849a;

    /* renamed from: b */
    private final File f28850b;

    /* renamed from: c */
    private final File f28851c;

    /* renamed from: d */
    private final File f28852d;

    /* renamed from: e */
    private final int f28853e;

    /* renamed from: f */
    private long f28854f;

    /* renamed from: g */
    private final int f28855g;

    /* renamed from: i */
    private Writer f28857i;
    private int k;

    /* renamed from: h */
    private long f28856h = 0;

    /* renamed from: j */
    private final LinkedHashMap<String, d> f28858j = new LinkedHashMap<>(0, 0.75f, true);
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new CallableC0593a();

    /* renamed from: com.vivo.mobilead.h.a$a */
    class CallableC0593a implements Callable<Void> {
        CallableC0593a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f28857i == null) {
                    return null;
                }
                a.this.i();
                if (a.this.e()) {
                    a.this.h();
                    a.this.k = 0;
                }
                return null;
            }
        }
    }

    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
        }
    }

    public final class c {

        /* renamed from: a */
        private final d f28860a;

        /* renamed from: b */
        private final boolean[] f28861b;

        /* renamed from: c */
        private boolean f28862c;

        /* renamed from: com.vivo.mobilead.h.a$c$a */
        private class C0594a extends FilterOutputStream {
            /* synthetic */ C0594a(c cVar, OutputStream outputStream, CallableC0593a callableC0593a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (Exception unused) {
                    c.this.f28862c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f28862c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (Exception unused) {
                    c.this.f28862c = true;
                }
            }

            private C0594a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (Exception unused) {
                    c.this.f28862c = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0593a callableC0593a) {
            this(dVar);
        }

        private c(d dVar) {
            this.f28860a = dVar;
            this.f28861b = dVar.f28867c ? null : new boolean[a.this.f28855g];
        }

        public void b() throws IOException {
            if (!this.f28862c) {
                a.this.a(this, true);
            } else {
                a.this.a(this, false);
                a.this.c(this.f28860a.f28865a);
            }
        }

        public OutputStream a(int i2) throws IOException {
            FileOutputStream fileOutputStream;
            C0594a c0594a;
            if (i2 < 0 || i2 >= a.this.f28855g) {
                throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + a.this.f28855g);
            }
            synchronized (a.this) {
                if (this.f28860a.f28868d == this) {
                    if (!this.f28860a.f28867c) {
                        this.f28861b[i2] = true;
                    }
                    File b2 = this.f28860a.b(i2);
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused) {
                        a.this.f28849a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused2) {
                            return a.p;
                        }
                    }
                    c0594a = new C0594a(this, fileOutputStream, null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0594a;
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    private final class d {

        /* renamed from: a */
        private final String f28865a;

        /* renamed from: b */
        private final long[] f28866b;

        /* renamed from: c */
        private boolean f28867c;

        /* renamed from: d */
        private c f28868d;

        /* renamed from: e */
        private long f28869e;

        /* synthetic */ d(a aVar, String str, CallableC0593a callableC0593a) {
            this(str);
        }

        private d(String str) {
            this.f28865a = str;
            this.f28866b = new long[a.this.f28855g];
        }

        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.f28855g) {
                a(strArr);
                throw null;
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f28866b[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    a(strArr);
                    throw null;
                }
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f28866b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public File b(int i2) {
            return new File(a.this.f28849a, this.f28865a + "." + i2 + ".tmp");
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return new File(a.this.f28849a, this.f28865a + "." + i2);
        }
    }

    public final class e implements Closeable {

        /* renamed from: a */
        private final InputStream[] f28871a;

        /* renamed from: b */
        private final long[] f28872b;

        /* synthetic */ e(a aVar, String str, long j2, InputStream[] inputStreamArr, long[] jArr, CallableC0593a callableC0593a) {
            this(aVar, str, j2, inputStreamArr, jArr);
        }

        public InputStream a(int i2) {
            return this.f28871a[i2];
        }

        public long b(int i2) {
            return this.f28872b[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f28871a) {
                com.vivo.mobilead.h.d.a(inputStream);
            }
        }

        private e(a aVar, String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            this.f28871a = inputStreamArr;
            this.f28872b = jArr;
        }
    }

    private a(File file, int i2, int i3, long j2) {
        this.f28849a = file;
        this.f28853e = i2;
        this.f28850b = new File(file, "journal");
        this.f28851c = new File(file, "journal.tmp");
        this.f28852d = new File(file, "journal.bkp");
        this.f28855g = i3;
        this.f28854f = j2;
    }

    private void g() throws IOException {
        com.vivo.mobilead.h.c cVar = new com.vivo.mobilead.h.c(new FileInputStream(this.f28850b), com.vivo.mobilead.h.d.f28884a);
        try {
            String b2 = cVar.b();
            String b3 = cVar.b();
            String b4 = cVar.b();
            String b5 = cVar.b();
            String b6 = cVar.b();
            if (!"libcore.io.DiskLruCache".equals(b2) || !"1".equals(b3) || !Integer.toString(this.f28853e).equals(b4) || !Integer.toString(this.f28855g).equals(b5) || !"".equals(b6)) {
                throw new IOException("unexpected journal header: [" + b2 + ", " + b3 + ", " + b5 + ", " + b6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    d(cVar.b());
                    i2++;
                } catch (EOFException unused) {
                    this.k = i2 - this.f28858j.size();
                    if (cVar.a()) {
                        h();
                    } else {
                        this.f28857i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28850b, true), com.vivo.mobilead.h.d.f28884a));
                    }
                    com.vivo.mobilead.h.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.vivo.mobilead.h.d.a(cVar);
            throw th;
        }
    }

    public synchronized void h() throws IOException {
        Writer writer = this.f28857i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28851c), com.vivo.mobilead.h.d.f28884a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f28853e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f28855g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f28858j.values()) {
                if (dVar.f28868d != null) {
                    bufferedWriter.write("DIRTY " + dVar.f28865a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f28865a + dVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f28850b.exists()) {
                a(this.f28850b, this.f28852d, true);
            }
            a(this.f28851c, this.f28850b, false);
            this.f28852d.delete();
            this.f28857i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28850b, true), com.vivo.mobilead.h.d.f28884a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public void i() throws IOException {
        while (this.f28856h > this.f28854f) {
            c(this.f28858j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f28857i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f28858j.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f28868d != null) {
                dVar.f28868d.a();
            }
        }
        i();
        this.f28857i.close();
        this.f28857i = null;
    }

    private void d(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i2);
        if (indexOf2 == -1) {
            substring = str.substring(i2);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.f28858j.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i2, indexOf2);
        }
        d dVar = this.f28858j.get(substring);
        if (dVar == null) {
            dVar = new d(this, substring, null);
            this.f28858j.put(substring, dVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            dVar.f28867c = true;
            dVar.f28868d = null;
            dVar.b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f28868d = new c(this, dVar, null);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public boolean e() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.f28858j.size();
    }

    private void f() throws IOException {
        a(this.f28851c);
        Iterator<d> it = this.f28858j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f28868d == null) {
                while (i2 < this.f28855g) {
                    this.f28856h += next.f28866b[i2];
                    i2++;
                }
            } else {
                next.f28868d = null;
                while (i2 < this.f28855g) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public synchronized e b(String str) throws IOException {
        d();
        e(str);
        d dVar = this.f28858j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f28867c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f28855g];
        for (int i2 = 0; i2 < this.f28855g; i2++) {
            try {
                inputStreamArr[i2] = new FileInputStream(dVar.a(i2));
            } catch (FileNotFoundException unused) {
                for (int i3 = 0; i3 < this.f28855g && inputStreamArr[i3] != null; i3++) {
                    com.vivo.mobilead.h.d.a(inputStreamArr[i3]);
                }
                return null;
            }
        }
        this.k++;
        this.f28857i.append((CharSequence) ("READ " + str + '\n'));
        if (e()) {
            this.m.submit(this.n);
        }
        return new e(this, str, dVar.f28869e, inputStreamArr, dVar.f28866b, null);
    }

    public synchronized boolean c(String str) throws IOException {
        d();
        e(str);
        d dVar = this.f28858j.get(str);
        if (dVar != null && dVar.f28868d == null) {
            for (int i2 = 0; i2 < this.f28855g; i2++) {
                File a2 = dVar.a(i2);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.f28856h -= dVar.f28866b[i2];
                dVar.f28866b[i2] = 0;
            }
            this.k++;
            this.f28857i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f28858j.remove(str);
            if (e()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public static a a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2);
            if (aVar.f28850b.exists()) {
                try {
                    aVar.g();
                    aVar.f();
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.a();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.h();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void e(String str) {
        if (o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized void b() throws IOException {
        d();
        i();
        this.f28857i.flush();
    }

    private void d() {
        if (this.f28857i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized File a(String str, int i2) throws IOException {
        d();
        e(str);
        d dVar = this.f28858j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f28867c) {
            return null;
        }
        if (i2 >= this.f28855g) {
            return null;
        }
        this.k++;
        this.f28857i.append((CharSequence) ("READ " + str + '\n'));
        if (e()) {
            this.m.submit(this.n);
        }
        return dVar.a(i2);
    }

    public c a(String str) throws IOException {
        return a(str, -1L);
    }

    private synchronized c a(String str, long j2) throws IOException {
        d();
        e(str);
        d dVar = this.f28858j.get(str);
        if (j2 != -1 && (dVar == null || dVar.f28869e != j2)) {
            return null;
        }
        if (dVar != null) {
            if (dVar.f28868d != null) {
                return null;
            }
        } else {
            dVar = new d(this, str, null);
            this.f28858j.put(str, dVar);
        }
        c cVar = new c(this, dVar, null);
        dVar.f28868d = cVar;
        this.f28857i.write("DIRTY " + str + '\n');
        this.f28857i.flush();
        return cVar;
    }

    public synchronized void a(c cVar, boolean z) throws IOException {
        d dVar = cVar.f28860a;
        if (dVar.f28868d == cVar) {
            if (z && !dVar.f28867c) {
                for (int i2 = 0; i2 < this.f28855g; i2++) {
                    if (cVar.f28861b[i2]) {
                        if (!dVar.b(i2).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f28855g; i3++) {
                File b2 = dVar.b(i3);
                if (z) {
                    if (b2.exists()) {
                        File a2 = dVar.a(i3);
                        b2.renameTo(a2);
                        long j2 = dVar.f28866b[i3];
                        long length = a2.length();
                        dVar.f28866b[i3] = length;
                        this.f28856h = (this.f28856h - j2) + length;
                    }
                } else {
                    a(b2);
                }
            }
            this.k++;
            dVar.f28868d = null;
            if (!(dVar.f28867c | z)) {
                this.f28858j.remove(dVar.f28865a);
                this.f28857i.write("REMOVE " + dVar.f28865a + '\n');
            } else {
                dVar.f28867c = true;
                this.f28857i.write("CLEAN " + dVar.f28865a + dVar.a() + '\n');
                if (z) {
                    long j3 = this.l;
                    this.l = 1 + j3;
                    dVar.f28869e = j3;
                }
            }
            this.f28857i.flush();
            if (this.f28856h > this.f28854f || e()) {
                this.m.submit(this.n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void a() throws IOException {
        close();
        com.vivo.mobilead.h.d.a(this.f28849a);
    }

    public static void a(e eVar) {
        if (eVar != null) {
            try {
                eVar.close();
            } catch (Exception e2) {
                VOpenLog.w("DiskLruCache", "error: " + e2.getMessage());
            }
        }
    }
}
