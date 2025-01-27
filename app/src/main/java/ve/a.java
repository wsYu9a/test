package ve;

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

/* loaded from: classes3.dex */
public final class a implements Closeable {
    public static final String A = "REMOVE";
    public static final String B = "READ";

    /* renamed from: r */
    public static final String f31464r = "journal";

    /* renamed from: s */
    public static final String f31465s = "journal.tmp";

    /* renamed from: t */
    public static final String f31466t = "journal.bkp";

    /* renamed from: u */
    public static final String f31467u = "libcore.io.DiskLruCache";

    /* renamed from: v */
    public static final String f31468v = "1";

    /* renamed from: w */
    public static final long f31469w = -1;

    /* renamed from: y */
    public static final String f31471y = "CLEAN";

    /* renamed from: z */
    public static final String f31472z = "DIRTY";

    /* renamed from: b */
    public final File f31473b;

    /* renamed from: c */
    public final File f31474c;

    /* renamed from: d */
    public final File f31475d;

    /* renamed from: e */
    public final File f31476e;

    /* renamed from: f */
    public final int f31477f;

    /* renamed from: g */
    public long f31478g;

    /* renamed from: h */
    public int f31479h;

    /* renamed from: i */
    public final int f31480i;

    /* renamed from: l */
    public Writer f31483l;

    /* renamed from: n */
    public int f31485n;

    /* renamed from: x */
    public static final Pattern f31470x = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final OutputStream C = new b();

    /* renamed from: j */
    public long f31481j = 0;

    /* renamed from: k */
    public int f31482k = 0;

    /* renamed from: m */
    public final LinkedHashMap<String, d> f31484m = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: o */
    public long f31486o = 0;

    /* renamed from: p */
    public final ThreadPoolExecutor f31487p = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: q */
    public final Callable<Void> f31488q = new CallableC0796a();

    /* renamed from: ve.a$a */
    public class CallableC0796a implements Callable<Void> {
        public CallableC0796a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                try {
                    if (a.this.f31483l == null) {
                        return null;
                    }
                    a.this.I();
                    a.this.H();
                    if (a.this.x()) {
                        a.this.C();
                        a.this.f31485n = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final class c {

        /* renamed from: a */
        public final d f31490a;

        /* renamed from: b */
        public final boolean[] f31491b;

        /* renamed from: c */
        public boolean f31492c;

        /* renamed from: d */
        public boolean f31493d;

        /* renamed from: ve.a$c$a */
        public class C0797a extends FilterOutputStream {
            public /* synthetic */ C0797a(c cVar, OutputStream outputStream, CallableC0796a callableC0796a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f31492c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f31492c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i10) {
                try {
                    ((FilterOutputStream) this).out.write(i10);
                } catch (IOException unused) {
                    c.this.f31492c = true;
                }
            }

            public C0797a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    c.this.f31492c = true;
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0796a callableC0796a) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.n(this, false);
        }

        public void b() {
            if (this.f31493d) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void f() throws IOException {
            if (this.f31492c) {
                a.this.n(this, false);
                a.this.D(this.f31490a.f31496a);
            } else {
                a.this.n(this, true);
            }
            this.f31493d = true;
        }

        public String g(int i10) throws IOException {
            InputStream h10 = h(i10);
            if (h10 != null) {
                return a.w(h10);
            }
            return null;
        }

        public InputStream h(int i10) throws IOException {
            synchronized (a.this) {
                if (this.f31490a.f31499d != this) {
                    throw new IllegalStateException();
                }
                if (!this.f31490a.f31498c) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f31490a.j(i10));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public OutputStream i(int i10) throws IOException {
            FileOutputStream fileOutputStream;
            C0797a c0797a;
            synchronized (a.this) {
                try {
                    if (this.f31490a.f31499d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f31490a.f31498c) {
                        this.f31491b[i10] = true;
                    }
                    File k10 = this.f31490a.k(i10);
                    try {
                        fileOutputStream = new FileOutputStream(k10);
                    } catch (FileNotFoundException unused) {
                        a.this.f31473b.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(k10);
                        } catch (FileNotFoundException unused2) {
                            return a.C;
                        }
                    }
                    c0797a = new C0797a(this, fileOutputStream, null);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return c0797a;
        }

        public void j(int i10, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(i(i10), ve.d.f31528b);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                outputStreamWriter.write(str);
                ve.d.a(outputStreamWriter);
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter2 = outputStreamWriter;
                ve.d.a(outputStreamWriter2);
                throw th;
            }
        }

        public c(d dVar) {
            this.f31490a = dVar;
            this.f31491b = dVar.f31498c ? null : new boolean[a.this.f31480i];
        }
    }

    public final class d {

        /* renamed from: a */
        public final String f31496a;

        /* renamed from: b */
        public final long[] f31497b;

        /* renamed from: c */
        public boolean f31498c;

        /* renamed from: d */
        public c f31499d;

        /* renamed from: e */
        public long f31500e;

        public /* synthetic */ d(a aVar, String str, CallableC0796a callableC0796a) {
            this(str);
        }

        public File j(int i10) {
            return new File(a.this.f31473b, this.f31496a + p1.b.f29697h + i10);
        }

        public File k(int i10) {
            return new File(a.this.f31473b, this.f31496a + p1.b.f29697h + i10 + ".tmp");
        }

        public String l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f31497b) {
                sb2.append(b5.a.O);
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != a.this.f31480i) {
                throw m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f31497b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public d(String str) {
            this.f31496a = str;
            this.f31497b = new long[a.this.f31480i];
        }
    }

    public final class e implements Closeable {

        /* renamed from: b */
        public final String f31502b;

        /* renamed from: c */
        public final long f31503c;

        /* renamed from: d */
        public File[] f31504d;

        /* renamed from: e */
        public final InputStream[] f31505e;

        /* renamed from: f */
        public final long[] f31506f;

        public /* synthetic */ e(a aVar, String str, long j10, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, CallableC0796a callableC0796a) {
            this(str, j10, fileArr, inputStreamArr, jArr);
        }

        public c a() throws IOException {
            return a.this.q(this.f31502b, this.f31503c);
        }

        public File b(int i10) {
            return this.f31504d[i10];
        }

        public InputStream c(int i10) {
            return this.f31505e[i10];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f31505e) {
                ve.d.a(inputStream);
            }
        }

        public long d(int i10) {
            return this.f31506f[i10];
        }

        public String getString(int i10) throws IOException {
            return a.w(c(i10));
        }

        public e(String str, long j10, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.f31502b = str;
            this.f31503c = j10;
            this.f31504d = fileArr;
            this.f31505e = inputStreamArr;
            this.f31506f = jArr;
        }
    }

    public a(File file, int i10, int i11, long j10, int i12) {
        this.f31473b = file;
        this.f31477f = i10;
        this.f31474c = new File(file, f31464r);
        this.f31475d = new File(file, f31465s);
        this.f31476e = new File(file, f31466t);
        this.f31480i = i11;
        this.f31478g = j10;
        this.f31479h = i12;
    }

    public static void E(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            o(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void o(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static String w(InputStream inputStream) throws IOException {
        return ve.d.c(new InputStreamReader(inputStream, ve.d.f31528b));
    }

    public static a y(File file, int i10, int i11, long j10, int i12) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i12 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, f31466t);
        if (file2.exists()) {
            File file3 = new File(file, f31464r);
            if (file3.exists()) {
                file2.delete();
            } else {
                E(file2, file3, false);
            }
        }
        a aVar = new a(file, i10, i11, j10, i12);
        if (aVar.f31474c.exists()) {
            try {
                aVar.A();
                aVar.z();
                aVar.f31483l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.f31474c, true), ve.d.f31527a));
                return aVar;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                aVar.delete();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i10, i11, j10, i12);
        aVar2.C();
        return aVar2;
    }

    public final void A() throws IOException {
        ve.c cVar = new ve.c(new FileInputStream(this.f31474c), ve.d.f31527a);
        try {
            String c10 = cVar.c();
            String c11 = cVar.c();
            String c12 = cVar.c();
            String c13 = cVar.c();
            String c14 = cVar.c();
            if (!f31467u.equals(c10) || !"1".equals(c11) || !Integer.toString(this.f31477f).equals(c12) || !Integer.toString(this.f31480i).equals(c13) || !"".equals(c14)) {
                throw new IOException("unexpected journal header: [" + c10 + ", " + c11 + ", " + c13 + ", " + c14 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    B(cVar.c());
                    i10++;
                } catch (EOFException unused) {
                    this.f31485n = i10 - this.f31484m.size();
                    ve.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            ve.d.a(cVar);
            throw th2;
        }
    }

    public final void B(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i10);
        if (indexOf2 == -1) {
            substring = str.substring(i10);
            if (indexOf == 6 && str.startsWith(A)) {
                this.f31484m.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i10, indexOf2);
        }
        d dVar = this.f31484m.get(substring);
        if (dVar == null) {
            dVar = new d(this, substring, null);
            this.f31484m.put(substring, dVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(f31471y)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            dVar.f31498c = true;
            dVar.f31499d = null;
            dVar.n(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith(f31472z)) {
            dVar.f31499d = new c(this, dVar, null);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith(B)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void C() throws IOException {
        try {
            Writer writer = this.f31483l;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f31475d), ve.d.f31527a));
            try {
                bufferedWriter.write(f31467u);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f31477f));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f31480i));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f31484m.values()) {
                    if (dVar.f31499d != null) {
                        bufferedWriter.write("DIRTY " + dVar.f31496a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f31496a + dVar.l() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f31474c.exists()) {
                    E(this.f31474c, this.f31476e, true);
                }
                E(this.f31475d, this.f31474c, false);
                this.f31476e.delete();
                this.f31483l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f31474c, true), ve.d.f31527a));
            } catch (Throwable th2) {
                bufferedWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public synchronized boolean D(String str) throws IOException {
        try {
            m();
            J(str);
            d dVar = this.f31484m.get(str);
            if (dVar != null && dVar.f31499d == null) {
                for (int i10 = 0; i10 < this.f31480i; i10++) {
                    File j10 = dVar.j(i10);
                    if (j10.exists() && !j10.delete()) {
                        throw new IOException("failed to delete " + j10);
                    }
                    this.f31481j -= dVar.f31497b[i10];
                    this.f31482k--;
                    dVar.f31497b[i10] = 0;
                }
                this.f31485n++;
                this.f31483l.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f31484m.remove(str);
                if (x()) {
                    this.f31487p.submit(this.f31488q);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public synchronized void F(long j10) {
        this.f31478g = j10;
        this.f31487p.submit(this.f31488q);
    }

    public synchronized long G() {
        return this.f31481j;
    }

    public final void H() throws IOException {
        while (this.f31482k > this.f31479h) {
            D(this.f31484m.entrySet().iterator().next().getKey());
        }
    }

    public final void I() throws IOException {
        while (this.f31481j > this.f31478g) {
            D(this.f31484m.entrySet().iterator().next().getKey());
        }
    }

    public final void J(String str) {
        if (f31470x.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f31483l == null) {
                return;
            }
            Iterator it = new ArrayList(this.f31484m.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f31499d != null) {
                    dVar.f31499d.a();
                }
            }
            I();
            H();
            this.f31483l.close();
            this.f31483l = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void delete() throws IOException {
        close();
        ve.d.b(this.f31473b);
    }

    public synchronized void flush() throws IOException {
        m();
        I();
        H();
        this.f31483l.flush();
    }

    public synchronized boolean isClosed() {
        return this.f31483l == null;
    }

    public final void m() {
        if (this.f31483l == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void n(c cVar, boolean z10) throws IOException {
        d dVar = cVar.f31490a;
        if (dVar.f31499d != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f31498c) {
            for (int i10 = 0; i10 < this.f31480i; i10++) {
                if (!cVar.f31491b[i10]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.k(i10).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f31480i; i11++) {
            File k10 = dVar.k(i11);
            if (!z10) {
                o(k10);
            } else if (k10.exists()) {
                File j10 = dVar.j(i11);
                k10.renameTo(j10);
                long j11 = dVar.f31497b[i11];
                long length = j10.length();
                dVar.f31497b[i11] = length;
                this.f31481j = (this.f31481j - j11) + length;
                this.f31482k++;
            }
        }
        this.f31485n++;
        dVar.f31499d = null;
        if (dVar.f31498c || z10) {
            dVar.f31498c = true;
            this.f31483l.write("CLEAN " + dVar.f31496a + dVar.l() + '\n');
            if (z10) {
                long j12 = this.f31486o;
                this.f31486o = 1 + j12;
                dVar.f31500e = j12;
            }
        } else {
            this.f31484m.remove(dVar.f31496a);
            this.f31483l.write("REMOVE " + dVar.f31496a + '\n');
        }
        this.f31483l.flush();
        if (this.f31481j > this.f31478g || this.f31482k > this.f31479h || x()) {
            this.f31487p.submit(this.f31488q);
        }
    }

    public c p(String str) throws IOException {
        return q(str, -1L);
    }

    public final synchronized c q(String str, long j10) throws IOException {
        m();
        J(str);
        d dVar = this.f31484m.get(str);
        if (j10 != -1 && (dVar == null || dVar.f31500e != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, null);
            this.f31484m.put(str, dVar);
        } else if (dVar.f31499d != null) {
            return null;
        }
        c cVar = new c(this, dVar, null);
        dVar.f31499d = cVar;
        this.f31483l.write("DIRTY " + str + '\n');
        this.f31483l.flush();
        return cVar;
    }

    public synchronized long r() {
        return this.f31482k;
    }

    public synchronized e s(String str) throws IOException {
        InputStream inputStream;
        m();
        J(str);
        d dVar = this.f31484m.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f31498c) {
            return null;
        }
        int i10 = this.f31480i;
        File[] fileArr = new File[i10];
        InputStream[] inputStreamArr = new InputStream[i10];
        for (int i11 = 0; i11 < this.f31480i; i11++) {
            try {
                File j10 = dVar.j(i11);
                fileArr[i11] = j10;
                inputStreamArr[i11] = new FileInputStream(j10);
            } catch (FileNotFoundException unused) {
                for (int i12 = 0; i12 < this.f31480i && (inputStream = inputStreamArr[i12]) != null; i12++) {
                    ve.d.a(inputStream);
                }
                return null;
            }
        }
        this.f31485n++;
        this.f31483l.append((CharSequence) ("READ " + str + '\n'));
        if (x()) {
            this.f31487p.submit(this.f31488q);
        }
        return new e(this, str, dVar.f31500e, fileArr, inputStreamArr, dVar.f31497b, null);
    }

    public File t() {
        return this.f31473b;
    }

    public synchronized int u() {
        return this.f31479h;
    }

    public synchronized long v() {
        return this.f31478g;
    }

    public final boolean x() {
        int i10 = this.f31485n;
        return i10 >= 2000 && i10 >= this.f31484m.size();
    }

    public final void z() throws IOException {
        o(this.f31475d);
        Iterator<d> it = this.f31484m.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f31499d == null) {
                while (i10 < this.f31480i) {
                    this.f31481j += next.f31497b[i10];
                    this.f31482k++;
                    i10++;
                }
            } else {
                next.f31499d = null;
                while (i10 < this.f31480i) {
                    o(next.j(i10));
                    o(next.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    public static class b extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
        }
    }
}
