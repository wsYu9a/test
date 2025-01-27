package b.g.a.a.a.c.d;

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
import java.io.InputStreamReader;
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
final class a implements Closeable {

    /* renamed from: a */
    static final String f4839a = "journal";

    /* renamed from: b */
    static final String f4840b = "journal.tmp";

    /* renamed from: c */
    static final String f4841c = "journal.bkp";

    /* renamed from: d */
    static final String f4842d = "libcore.io.DiskLruCache";

    /* renamed from: e */
    static final String f4843e = "1";

    /* renamed from: f */
    static final long f4844f = -1;

    /* renamed from: h */
    private static final String f4846h = "CLEAN";

    /* renamed from: i */
    private static final String f4847i = "DIRTY";

    /* renamed from: j */
    private static final String f4848j = "REMOVE";
    private static final String k = "READ";
    private final File m;
    private final File n;
    private final File o;
    private final File p;
    private final int q;
    private long r;
    private int s;
    private final int t;
    private Writer w;
    private int y;

    /* renamed from: g */
    static final Pattern f4845g = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream l = new b();
    private long u = 0;
    private int v = 0;
    private final LinkedHashMap<String, d> x = new LinkedHashMap<>(0, 0.75f, true);
    private long z = 0;
    final ThreadPoolExecutor A = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> B = new CallableC0051a();

    /* renamed from: b.g.a.a.a.c.d.a$a */
    class CallableC0051a implements Callable<Void> {
        CallableC0051a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.w == null) {
                    return null;
                }
                a.this.I();
                a.this.H();
                if (a.this.x()) {
                    a.this.C();
                    a.this.y = 0;
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
        private final d f4850a;

        /* renamed from: b */
        private final boolean[] f4851b;

        /* renamed from: c */
        private boolean f4852c;

        /* renamed from: d */
        private boolean f4853d;

        /* renamed from: b.g.a.a.a.c.d.a$c$a */
        private class C0052a extends FilterOutputStream {
            /* synthetic */ C0052a(c cVar, OutputStream outputStream, CallableC0051a callableC0051a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f4852c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f4852c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    c.this.f4852c = true;
                }
            }

            private C0052a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    c.this.f4852c = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0051a callableC0051a) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.n(this, false);
        }

        public void b() {
            if (this.f4853d) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void f() throws IOException {
            if (this.f4852c) {
                a.this.n(this, false);
                a.this.D(this.f4850a.f4856a);
            } else {
                a.this.n(this, true);
            }
            this.f4853d = true;
        }

        public String g(int i2) throws IOException {
            InputStream h2 = h(i2);
            if (h2 != null) {
                return a.w(h2);
            }
            return null;
        }

        public InputStream h(int i2) throws IOException {
            synchronized (a.this) {
                if (this.f4850a.f4859d != this) {
                    throw new IllegalStateException();
                }
                if (!this.f4850a.f4858c) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f4850a.j(i2));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public OutputStream i(int i2) throws IOException {
            FileOutputStream fileOutputStream;
            C0052a c0052a;
            synchronized (a.this) {
                if (this.f4850a.f4859d != this) {
                    throw new IllegalStateException();
                }
                if (!this.f4850a.f4858c) {
                    this.f4851b[i2] = true;
                }
                File k = this.f4850a.k(i2);
                try {
                    fileOutputStream = new FileOutputStream(k);
                } catch (FileNotFoundException unused) {
                    a.this.m.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(k);
                    } catch (FileNotFoundException unused2) {
                        return a.l;
                    }
                }
                c0052a = new C0052a(this, fileOutputStream, null);
            }
            return c0052a;
        }

        public void j(int i2, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(i(i2), b.g.a.a.a.c.d.d.f4887b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                b.g.a.a.a.c.d.d.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                b.g.a.a.a.c.d.d.a(outputStreamWriter2);
                throw th;
            }
        }

        private c(d dVar) {
            this.f4850a = dVar;
            this.f4851b = dVar.f4858c ? null : new boolean[a.this.t];
        }
    }

    private final class d {

        /* renamed from: a */
        private final String f4856a;

        /* renamed from: b */
        private final long[] f4857b;

        /* renamed from: c */
        private boolean f4858c;

        /* renamed from: d */
        private c f4859d;

        /* renamed from: e */
        private long f4860e;

        /* synthetic */ d(a aVar, String str, CallableC0051a callableC0051a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public void n(String[] strArr) throws IOException {
            if (strArr.length != a.this.t) {
                throw m(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f4857b[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i2) {
            return new File(a.this.m, this.f4856a + "." + i2);
        }

        public File k(int i2) {
            return new File(a.this.m, this.f4856a + "." + i2 + ".tmp");
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f4857b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        private d(String str) {
            this.f4856a = str;
            this.f4857b = new long[a.this.t];
        }
    }

    public final class e implements Closeable {

        /* renamed from: a */
        private final String f4862a;

        /* renamed from: b */
        private final long f4863b;

        /* renamed from: c */
        private File[] f4864c;

        /* renamed from: d */
        private final InputStream[] f4865d;

        /* renamed from: e */
        private final long[] f4866e;

        /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, CallableC0051a callableC0051a) {
            this(str, j2, fileArr, inputStreamArr, jArr);
        }

        public c a() throws IOException {
            return a.this.q(this.f4862a, this.f4863b);
        }

        public File b(int i2) {
            return this.f4864c[i2];
        }

        public InputStream c(int i2) {
            return this.f4865d[i2];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f4865d) {
                b.g.a.a.a.c.d.d.a(inputStream);
            }
        }

        public long d(int i2) {
            return this.f4866e[i2];
        }

        public String getString(int i2) throws IOException {
            return a.w(c(i2));
        }

        private e(String str, long j2, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.f4862a = str;
            this.f4863b = j2;
            this.f4864c = fileArr;
            this.f4865d = inputStreamArr;
            this.f4866e = jArr;
        }
    }

    private a(File file, int i2, int i3, long j2, int i4) {
        this.m = file;
        this.q = i2;
        this.n = new File(file, f4839a);
        this.o = new File(file, f4840b);
        this.p = new File(file, f4841c);
        this.t = i3;
        this.r = j2;
        this.s = i4;
    }

    private void A() throws IOException {
        b.g.a.a.a.c.d.c cVar = new b.g.a.a.a.c.d.c(new FileInputStream(this.n), b.g.a.a.a.c.d.d.f4886a);
        try {
            String c2 = cVar.c();
            String c3 = cVar.c();
            String c4 = cVar.c();
            String c5 = cVar.c();
            String c6 = cVar.c();
            if (!f4842d.equals(c2) || !"1".equals(c3) || !Integer.toString(this.q).equals(c4) || !Integer.toString(this.t).equals(c5) || !"".equals(c6)) {
                throw new IOException("unexpected journal header: [" + c2 + ", " + c3 + ", " + c5 + ", " + c6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    B(cVar.c());
                    i2++;
                } catch (EOFException unused) {
                    this.y = i2 - this.x.size();
                    b.g.a.a.a.c.d.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            b.g.a.a.a.c.d.d.a(cVar);
            throw th;
        }
    }

    private void B(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i2);
        if (indexOf2 == -1) {
            substring = str.substring(i2);
            if (indexOf == 6 && str.startsWith(f4848j)) {
                this.x.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i2, indexOf2);
        }
        d dVar = this.x.get(substring);
        if (dVar == null) {
            dVar = new d(this, substring, null);
            this.x.put(substring, dVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(f4846h)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            dVar.f4858c = true;
            dVar.f4859d = null;
            dVar.n(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith(f4847i)) {
            dVar.f4859d = new c(this, dVar, null);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith(k)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public synchronized void C() throws IOException {
        Writer writer = this.w;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.o), b.g.a.a.a.c.d.d.f4886a));
        try {
            bufferedWriter.write(f4842d);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.q));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.t));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.x.values()) {
                if (dVar.f4859d != null) {
                    bufferedWriter.write("DIRTY " + dVar.f4856a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f4856a + dVar.l() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.n.exists()) {
                E(this.n, this.p, true);
            }
            E(this.o, this.n, false);
            this.p.delete();
            this.w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.n, true), b.g.a.a.a.c.d.d.f4886a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void E(File file, File file2, boolean z) throws IOException {
        if (z) {
            o(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public void H() throws IOException {
        while (this.v > this.s) {
            D(this.x.entrySet().iterator().next().getKey());
        }
    }

    public void I() throws IOException {
        while (this.u > this.r) {
            D(this.x.entrySet().iterator().next().getKey());
        }
    }

    private void J(String str) {
        if (f4845g.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private void m() {
        if (this.w == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void n(c cVar, boolean z) throws IOException {
        d dVar = cVar.f4850a;
        if (dVar.f4859d != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.f4858c) {
            for (int i2 = 0; i2 < this.t; i2++) {
                if (!cVar.f4851b[i2]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                }
                if (!dVar.k(i2).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.t; i3++) {
            File k2 = dVar.k(i3);
            if (!z) {
                o(k2);
            } else if (k2.exists()) {
                File j2 = dVar.j(i3);
                k2.renameTo(j2);
                long j3 = dVar.f4857b[i3];
                long length = j2.length();
                dVar.f4857b[i3] = length;
                this.u = (this.u - j3) + length;
                this.v++;
            }
        }
        this.y++;
        dVar.f4859d = null;
        if (dVar.f4858c || z) {
            dVar.f4858c = true;
            this.w.write("CLEAN " + dVar.f4856a + dVar.l() + '\n');
            if (z) {
                long j4 = this.z;
                this.z = 1 + j4;
                dVar.f4860e = j4;
            }
        } else {
            this.x.remove(dVar.f4856a);
            this.w.write("REMOVE " + dVar.f4856a + '\n');
        }
        this.w.flush();
        if (this.u > this.r || this.v > this.s || x()) {
            this.A.submit(this.B);
        }
    }

    private static void o(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized c q(String str, long j2) throws IOException {
        m();
        J(str);
        d dVar = this.x.get(str);
        if (j2 != -1 && (dVar == null || dVar.f4860e != j2)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, null);
            this.x.put(str, dVar);
        } else if (dVar.f4859d != null) {
            return null;
        }
        c cVar = new c(this, dVar, null);
        dVar.f4859d = cVar;
        this.w.write("DIRTY " + str + '\n');
        this.w.flush();
        return cVar;
    }

    public static String w(InputStream inputStream) throws IOException {
        return b.g.a.a.a.c.d.d.c(new InputStreamReader(inputStream, b.g.a.a.a.c.d.d.f4887b));
    }

    public boolean x() {
        int i2 = this.y;
        return i2 >= 2000 && i2 >= this.x.size();
    }

    public static a y(File file, int i2, int i3, long j2, int i4) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, f4841c);
        if (file2.exists()) {
            File file3 = new File(file, f4839a);
            if (file3.exists()) {
                file2.delete();
            } else {
                E(file2, file3, false);
            }
        }
        a aVar = new a(file, i2, i3, j2, i4);
        if (aVar.n.exists()) {
            try {
                aVar.A();
                aVar.z();
                aVar.w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.n, true), b.g.a.a.a.c.d.d.f4886a));
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.delete();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i2, i3, j2, i4);
        aVar2.C();
        return aVar2;
    }

    private void z() throws IOException {
        o(this.o);
        Iterator<d> it = this.x.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f4859d == null) {
                while (i2 < this.t) {
                    this.u += next.f4857b[i2];
                    this.v++;
                    i2++;
                }
            } else {
                next.f4859d = null;
                while (i2 < this.t) {
                    o(next.j(i2));
                    o(next.k(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public synchronized boolean D(String str) throws IOException {
        m();
        J(str);
        d dVar = this.x.get(str);
        if (dVar != null && dVar.f4859d == null) {
            for (int i2 = 0; i2 < this.t; i2++) {
                File j2 = dVar.j(i2);
                if (j2.exists() && !j2.delete()) {
                    throw new IOException("failed to delete " + j2);
                }
                this.u -= dVar.f4857b[i2];
                this.v--;
                dVar.f4857b[i2] = 0;
            }
            this.y++;
            this.w.append((CharSequence) ("REMOVE " + str + '\n'));
            this.x.remove(str);
            if (x()) {
                this.A.submit(this.B);
            }
            return true;
        }
        return false;
    }

    public synchronized void F(long j2) {
        this.r = j2;
        this.A.submit(this.B);
    }

    public synchronized long G() {
        return this.u;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.w == null) {
            return;
        }
        Iterator it = new ArrayList(this.x.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f4859d != null) {
                dVar.f4859d.a();
            }
        }
        I();
        H();
        this.w.close();
        this.w = null;
    }

    public void delete() throws IOException {
        close();
        b.g.a.a.a.c.d.d.b(this.m);
    }

    public synchronized void flush() throws IOException {
        m();
        I();
        H();
        this.w.flush();
    }

    public synchronized boolean isClosed() {
        return this.w == null;
    }

    public c p(String str) throws IOException {
        return q(str, -1L);
    }

    public synchronized long r() {
        return this.v;
    }

    public synchronized e s(String str) throws IOException {
        m();
        J(str);
        d dVar = this.x.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f4858c) {
            return null;
        }
        int i2 = this.t;
        File[] fileArr = new File[i2];
        InputStream[] inputStreamArr = new InputStream[i2];
        for (int i3 = 0; i3 < this.t; i3++) {
            try {
                File j2 = dVar.j(i3);
                fileArr[i3] = j2;
                inputStreamArr[i3] = new FileInputStream(j2);
            } catch (FileNotFoundException unused) {
                for (int i4 = 0; i4 < this.t && inputStreamArr[i4] != null; i4++) {
                    b.g.a.a.a.c.d.d.a(inputStreamArr[i4]);
                }
                return null;
            }
        }
        this.y++;
        this.w.append((CharSequence) ("READ " + str + '\n'));
        if (x()) {
            this.A.submit(this.B);
        }
        return new e(this, str, dVar.f4860e, fileArr, inputStreamArr, dVar.f4857b, null);
    }

    public File t() {
        return this.m;
    }

    public synchronized int u() {
        return this.s;
    }

    public synchronized long v() {
        return this.r;
    }
}
