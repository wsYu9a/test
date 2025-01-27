package com.kwad.sdk.core.diskcache.kwai;

import com.kwad.sdk.utils.q;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class a implements Closeable {
    private final File aeo;
    private final File aep;
    private final File aeq;
    private final File aer;
    private final int aes;
    private int aet;
    private final int aeu;
    private Writer aew;
    private int aey;
    private long maxSize;
    static final Pattern aen = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aeC = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.3
        AnonymousClass3() {
        }

        @Override // java.io.OutputStream
        public final void write(int i2) {
        }
    };
    private long size = 0;
    private int aev = 0;
    private final LinkedHashMap<String, b> aex = new LinkedHashMap<>(0, 0.75f, true);
    private long aez = 0;
    final ThreadPoolExecutor aeA = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.kwai.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> aeB = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: vi */
        public Void call() {
            synchronized (a.this) {
                if (a.this.aew == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.vo();
                if (a.this.vn()) {
                    a.this.vl();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$1 */
    final class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$2 */
    final class AnonymousClass2 implements Callable<Void> {
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: vi */
        public Void call() {
            synchronized (a.this) {
                if (a.this.aew == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.vo();
                if (a.this.vn()) {
                    a.this.vl();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$3 */
    static class AnonymousClass3 extends OutputStream {
        AnonymousClass3() {
        }

        @Override // java.io.OutputStream
        public final void write(int i2) {
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a */
    public final class C0210a {
        private final b aeE;
        private final boolean[] aeF;
        private boolean aeG;
        private boolean aeH;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a */
        class C0211a extends FilterOutputStream {
            private C0211a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C0211a(C0210a c0210a, OutputStream outputStream, byte b2) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0210a.b(C0210a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0210a.b(C0210a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i2) {
                try {
                    ((FilterOutputStream) this).out.write(i2);
                } catch (IOException unused) {
                    C0210a.b(C0210a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i2, int i3) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                } catch (IOException unused) {
                    C0210a.b(C0210a.this, true);
                }
            }
        }

        private C0210a(b bVar) {
            this.aeE = bVar;
            this.aeF = bVar.aeK ? null : new boolean[a.this.aeu];
        }

        /* synthetic */ C0210a(a aVar, b bVar, byte b2) {
            this(bVar);
        }

        static /* synthetic */ boolean b(C0210a c0210a, boolean z) {
            c0210a.aeG = true;
            return true;
        }

        public final OutputStream aW(int i2) {
            FileOutputStream fileOutputStream;
            C0211a c0211a;
            synchronized (a.this) {
                if (this.aeE.aeL != this) {
                    throw new IllegalStateException();
                }
                if (!this.aeE.aeK) {
                    this.aeF[0] = true;
                }
                File aY = this.aeE.aY(0);
                try {
                    fileOutputStream = new FileOutputStream(aY);
                } catch (FileNotFoundException unused) {
                    a.this.aeo.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(aY);
                    } catch (FileNotFoundException unused2) {
                        return a.aeC;
                    }
                }
                c0211a = new C0211a(this, fileOutputStream, (byte) 0);
            }
            return c0211a;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.aeG) {
                a.this.a(this, false);
                a.this.remove(this.aeE.key);
            } else {
                a.this.a(this, true);
            }
            this.aeH = true;
        }
    }

    final class b {
        private final long[] aeJ;
        private boolean aeK;
        private C0210a aeL;
        private long aeM;
        private final String key;

        private b(String str) {
            this.key = str;
            this.aeJ = new long[a.this.aeu];
        }

        /* synthetic */ b(a aVar, String str, byte b2) {
            this(str);
        }

        static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.aeK = true;
            return true;
        }

        public void b(String[] strArr) {
            if (strArr.length != a.this.aeu) {
                throw c(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.aeJ[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File aX(int i2) {
            return new File(a.this.aeo, this.key + i2);
        }

        public final File aY(int i2) {
            return new File(a.this.aeo, this.key + i2 + ".tmp");
        }

        public final String vq() {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.aeJ) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }
    }

    public final class c implements Closeable {
        private final long[] aeJ;
        private final long aeM;
        private File[] aeN;
        private final InputStream[] aeO;
        private final String key;

        private c(String str, long j2, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aeM = j2;
            this.aeN = fileArr;
            this.aeO = inputStreamArr;
            this.aeJ = jArr;
        }

        /* synthetic */ c(a aVar, String str, long j2, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b2) {
            this(str, j2, fileArr, inputStreamArr, jArr);
        }

        public final File aZ(int i2) {
            return this.aeN[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aeO) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
    }

    private a(File file, int i2, int i3, long j2, int i4) {
        this.aeo = file;
        this.aes = i2;
        this.aep = new File(file, "journal");
        this.aeq = new File(file, "journal.tmp");
        this.aer = new File(file, "journal.bkp");
        this.aeu = i3;
        this.maxSize = j2;
        this.aet = i4;
    }

    static /* synthetic */ int a(a aVar, int i2) {
        aVar.aey = 0;
        return 0;
    }

    public static a a(File file, int i2, int i3, long j2) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i2, int i3, long j2, int i4) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i2, i3, j2, i4);
        if (aVar.aep.exists()) {
            try {
                aVar.vj();
                aVar.vk();
                aVar.aew = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.aep, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.delete();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i2, i3, j2, i4);
        aVar2.vl();
        return aVar2;
    }

    public synchronized void a(C0210a c0210a, boolean z) {
        b bVar = c0210a.aeE;
        if (bVar.aeL != c0210a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.aeK) {
            for (int i2 = 0; i2 < this.aeu; i2++) {
                if (!c0210a.aeF[i2]) {
                    c0210a.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                }
                if (!bVar.aY(i2).exists()) {
                    c0210a.abort();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < this.aeu; i3++) {
            File aY = bVar.aY(i3);
            if (!z) {
                k(aY);
            } else if (aY.exists()) {
                File aX = bVar.aX(i3);
                aY.renameTo(aX);
                long j2 = bVar.aeJ[i3];
                long length = aX.length();
                bVar.aeJ[i3] = length;
                this.size = (this.size - j2) + length;
                this.aev++;
            }
        }
        this.aey++;
        bVar.aeL = null;
        if (bVar.aeK || z) {
            b.a(bVar, true);
            this.aew.write("CLEAN " + bVar.key + bVar.vq() + '\n');
            if (z) {
                long j3 = this.aez;
                this.aez = 1 + j3;
                bVar.aeM = j3;
            }
        } else {
            this.aex.remove(bVar.key);
            this.aew.write("REMOVE " + bVar.key + '\n');
        }
        this.aew.flush();
        if (this.size > this.maxSize || this.aev > this.aet || vn()) {
            this.aeA.submit(this.aeB);
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            k(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void bE(String str) {
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
                this.aex.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i2, indexOf2);
        }
        b bVar = this.aex.get(substring);
        if (bVar == null) {
            bVar = new b(this, substring, (byte) 0);
            this.aex.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.aeL = null;
            bVar.b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.aeL = new C0210a(this, bVar, (byte) 0);
        } else {
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private static void bH(String str) {
        if (aen.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private void checkNotClosed() {
        if (this.aew == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private synchronized C0210a e(String str, long j2) {
        checkNotClosed();
        bH(str);
        b bVar = this.aex.get(str);
        if (bVar == null) {
            bVar = new b(this, str, (byte) 0);
            this.aex.put(str, bVar);
        } else if (bVar.aeL != null) {
            return null;
        }
        C0210a c0210a = new C0210a(this, bVar, (byte) 0);
        bVar.aeL = c0210a;
        this.aew.write("DIRTY " + str + '\n');
        this.aew.flush();
        return c0210a;
    }

    private static void k(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.aex.entrySet().iterator().next().getKey());
        }
    }

    private void vj() {
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.aep), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aes).equals(readLine3) || !Integer.toString(this.aeu).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    bE(bVar.readLine());
                    i2++;
                } catch (EOFException unused) {
                    this.aey = i2 - this.aex.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void vk() {
        k(this.aeq);
        Iterator<b> it = this.aex.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.aeL == null) {
                while (i2 < this.aeu) {
                    this.size += next.aeJ[i2];
                    this.aev++;
                    i2++;
                }
            } else {
                next.aeL = null;
                while (i2 < this.aeu) {
                    k(next.aX(i2));
                    k(next.aY(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public synchronized void vl() {
        Writer writer = this.aew;
        if (writer != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aeq), com.kwad.sdk.crash.utils.a.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aes));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aeu));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.aex.values()) {
                bufferedWriter.write(bVar.aeL != null ? "DIRTY " + bVar.key + '\n' : "CLEAN " + bVar.key + bVar.vq() + '\n');
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            if (this.aep.exists()) {
                a(this.aep, this.aer, true);
            }
            a(this.aeq, this.aep, false);
            this.aer.delete();
            this.aew = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aep, true), com.kwad.sdk.crash.utils.a.US_ASCII));
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            throw th;
        }
    }

    public boolean vn() {
        int i2 = this.aey;
        return i2 >= 2000 && i2 >= this.aex.size();
    }

    public void vo() {
        while (this.aev > this.aet) {
            remove(this.aex.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized c bF(String str) {
        checkNotClosed();
        bH(str);
        b bVar = this.aex.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.aeK) {
            return null;
        }
        int i2 = this.aeu;
        File[] fileArr = new File[i2];
        InputStream[] inputStreamArr = new InputStream[i2];
        for (int i3 = 0; i3 < this.aeu; i3++) {
            try {
                File aX = bVar.aX(i3);
                fileArr[i3] = aX;
                inputStreamArr[i3] = new FileInputStream(aX);
            } catch (FileNotFoundException unused) {
                for (int i4 = 0; i4 < this.aeu && inputStreamArr[i4] != null; i4++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamArr[i4]);
                }
                return null;
            }
        }
        this.aey++;
        this.aew.append((CharSequence) ("READ " + str + '\n'));
        if (vn()) {
            this.aeA.submit(this.aeB);
        }
        return new c(this, str, bVar.aeM, fileArr, inputStreamArr, bVar.aeJ, (byte) 0);
    }

    public final C0210a bG(String str) {
        return e(str, -1L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.aew == null) {
            return;
        }
        Iterator it = new ArrayList(this.aex.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.aeL != null) {
                bVar.aeL.abort();
            }
        }
        trimToSize();
        vo();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aew);
        this.aew = null;
    }

    public final void delete() {
        close();
        q.deleteContents(this.aeo);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        vo();
        this.aew.flush();
    }

    public final File getDirectory() {
        return this.aeo;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        bH(str);
        b bVar = this.aex.get(str);
        if (bVar != null && bVar.aeL == null) {
            for (int i2 = 0; i2 < this.aeu; i2++) {
                File aX = bVar.aX(i2);
                if (aX.exists() && !aX.delete()) {
                    throw new IOException("failed to delete " + aX);
                }
                this.size -= bVar.aeJ[i2];
                this.aev--;
                bVar.aeJ[i2] = 0;
            }
            this.aey++;
            this.aew.append((CharSequence) ("REMOVE " + str + '\n'));
            this.aex.remove(str);
            if (vn()) {
                this.aeA.submit(this.aeB);
            }
            return true;
        }
        return false;
    }

    public final synchronized int vm() {
        return this.aet;
    }
}
