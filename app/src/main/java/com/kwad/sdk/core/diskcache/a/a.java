package com.kwad.sdk.core.diskcache.a;

import com.kwad.sdk.utils.u;
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

/* loaded from: classes3.dex */
public final class a implements Closeable {
    static final Pattern axA = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream axP = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i10) {
        }
    };
    private final File axB;
    private final File axC;
    private final File axD;
    private final File axE;
    private final int axF;
    private int axG;
    private final int axH;
    private Writer axJ;
    private int axL;
    private long maxSize;
    private long size = 0;
    private int axI = 0;
    private final LinkedHashMap<String, b> axK = new LinkedHashMap<>(0, 0.75f, true);
    private long axM = 0;
    final ThreadPoolExecutor axN = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> axO = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ew */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.axJ == null) {
                        return null;
                    }
                    a.this.trimToSize();
                    a.this.EC();
                    if (a.this.EB()) {
                        a.this.Ez();
                        a.a(a.this, 0);
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$1 */
    public class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$2 */
    public class AnonymousClass2 implements Callable<Void> {
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ew */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.axJ == null) {
                        return null;
                    }
                    a.this.trimToSize();
                    a.this.EC();
                    if (a.this.EB()) {
                        a.this.Ez();
                        a.a(a.this, 0);
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$3 */
    public class AnonymousClass3 extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int i10) {
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a */
    public final class C0487a {
        private final b axR;
        private final boolean[] axS;
        private boolean axT;
        private boolean axU;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a */
        public class C0488a extends FilterOutputStream {
            public /* synthetic */ C0488a(C0487a c0487a, OutputStream outputStream, byte b10) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0487a.b(C0487a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0487a.b(C0487a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i10) {
                try {
                    ((FilterOutputStream) this).out.write(i10);
                } catch (IOException unused) {
                    C0487a.b(C0487a.this, true);
                }
            }

            private C0488a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i10, int i11) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    C0487a.b(C0487a.this, true);
                }
            }
        }

        public /* synthetic */ C0487a(a aVar, b bVar, byte b10) {
            this(bVar);
        }

        public static /* synthetic */ boolean b(C0487a c0487a, boolean z10) {
            c0487a.axT = true;
            return true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.axT) {
                a.this.a(this, false);
                a.this.remove(this.axR.key);
            } else {
                a.this.a(this, true);
            }
            this.axU = true;
        }

        public final OutputStream da(int i10) {
            FileOutputStream fileOutputStream;
            C0488a c0488a;
            synchronized (a.this) {
                try {
                    if (this.axR.axY != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.axR.axX) {
                        this.axS[0] = true;
                    }
                    File dc2 = this.axR.dc(0);
                    try {
                        fileOutputStream = new FileOutputStream(dc2);
                    } catch (FileNotFoundException unused) {
                        a.this.axB.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(dc2);
                        } catch (FileNotFoundException unused2) {
                            return a.axP;
                        }
                    }
                    c0488a = new C0488a(this, fileOutputStream, (byte) 0);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return c0488a;
        }

        private C0487a(b bVar) {
            this.axR = bVar;
            this.axS = bVar.axX ? null : new boolean[a.this.axH];
        }
    }

    public final class b {
        private final long[] axW;
        private boolean axX;
        private C0487a axY;
        private long axZ;
        private final String key;

        public /* synthetic */ b(a aVar, String str, byte b10) {
            this(str);
        }

        public final String EE() {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.axW) {
                sb2.append(b5.a.O);
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final File db(int i10) {
            return new File(a.this.axB, this.key + i10);
        }

        public final File dc(int i10) {
            return new File(a.this.axB, this.key + i10 + ".tmp");
        }

        private b(String str) {
            this.key = str;
            this.axW = new long[a.this.axH];
        }

        public void b(String[] strArr) {
            if (strArr.length != a.this.axH) {
                throw c(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.axW[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public static /* synthetic */ boolean a(b bVar, boolean z10) {
            bVar.axX = true;
            return true;
        }
    }

    public final class c implements Closeable {
        private final long[] axW;
        private final long axZ;
        private File[] aya;
        private final InputStream[] ayb;
        private final String key;

        public /* synthetic */ c(a aVar, String str, long j10, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b10) {
            this(str, j10, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.ayb) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File dd(int i10) {
            return this.aya[0];
        }

        private c(String str, long j10, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.axZ = j10;
            this.aya = fileArr;
            this.ayb = inputStreamArr;
            this.axW = jArr;
        }
    }

    private a(File file, int i10, int i11, long j10, int i12) {
        this.axB = file;
        this.axF = i10;
        this.axC = new File(file, ve.a.f31464r);
        this.axD = new File(file, ve.a.f31465s);
        this.axE = new File(file, ve.a.f31466t);
        this.axH = i11;
        this.maxSize = j10;
        this.axG = i12;
    }

    public boolean EB() {
        int i10 = this.axL;
        return i10 >= 2000 && i10 >= this.axK.size();
    }

    public void EC() {
        while (this.axI > this.axG) {
            remove(this.axK.entrySet().iterator().next().getKey());
        }
    }

    private void Ex() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.axC), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!ve.a.f31467u.equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.axF).equals(readLine3) || !Integer.toString(this.axH).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    dz(bVar.readLine());
                    i10++;
                } catch (EOFException unused) {
                    this.axL = i10 - this.axK.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th2;
        }
    }

    private void Ey() {
        p(this.axD);
        Iterator<b> it = this.axK.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i10 = 0;
            if (next.axY == null) {
                while (i10 < this.axH) {
                    this.size += next.axW[i10];
                    this.axI++;
                    i10++;
                }
            } else {
                next.axY = null;
                while (i10 < this.axH) {
                    p(next.db(i10));
                    p(next.dc(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    public synchronized void Ez() {
        try {
            Writer writer = this.axJ;
            if (writer != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.axD), com.kwad.sdk.crash.utils.a.US_ASCII));
            try {
                bufferedWriter.write(ve.a.f31467u);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.axF));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.axH));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (b bVar : this.axK.values()) {
                    if (bVar.axY != null) {
                        bufferedWriter.write("DIRTY " + bVar.key + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + bVar.key + bVar.EE() + '\n');
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                if (this.axC.exists()) {
                    a(this.axC, this.axE, true);
                }
                a(this.axD, this.axC, false);
                this.axE.delete();
                this.axJ = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.axC, true), com.kwad.sdk.crash.utils.a.US_ASCII));
            } catch (Throwable th2) {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public static /* synthetic */ int a(a aVar, int i10) {
        aVar.axL = 0;
        return 0;
    }

    private void checkNotClosed() {
        if (this.axJ == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void dC(String str) {
        if (axA.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private void dz(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i10);
        if (indexOf2 == -1) {
            substring = str.substring(i10);
            if (indexOf == 6 && str.startsWith(ve.a.A)) {
                this.axK.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i10, indexOf2);
        }
        b bVar = this.axK.get(substring);
        if (bVar == null) {
            bVar = new b(this, substring, (byte) 0);
            this.axK.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(ve.a.f31471y)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.axY = null;
            bVar.b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith(ve.a.f31472z)) {
            bVar.axY = new C0487a(this, bVar, (byte) 0);
        } else {
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith(ve.a.B)) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private static void p(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.axK.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized int EA() {
        return this.axG;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.axJ == null) {
                return;
            }
            Iterator it = new ArrayList(this.axK.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.axY != null) {
                    bVar.axY.abort();
                }
            }
            trimToSize();
            EC();
            com.kwad.sdk.crash.utils.b.closeQuietly(this.axJ);
            this.axJ = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized c dA(String str) {
        InputStream inputStream;
        if (this.axJ == null) {
            return null;
        }
        dC(str);
        b bVar = this.axK.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.axX) {
            return null;
        }
        int i10 = this.axH;
        File[] fileArr = new File[i10];
        InputStream[] inputStreamArr = new InputStream[i10];
        for (int i11 = 0; i11 < this.axH; i11++) {
            try {
                File db2 = bVar.db(i11);
                fileArr[i11] = db2;
                inputStreamArr[i11] = new FileInputStream(db2);
            } catch (FileNotFoundException unused) {
                for (int i12 = 0; i12 < this.axH && (inputStream = inputStreamArr[i12]) != null; i12++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                }
                return null;
            }
        }
        this.axL++;
        this.axJ.append((CharSequence) ("READ " + str + '\n'));
        if (EB()) {
            this.axN.submit(this.axO);
        }
        return new c(this, str, bVar.axZ, fileArr, inputStreamArr, bVar.axW, (byte) 0);
    }

    public final C0487a dB(String str) {
        return e(str, -1L);
    }

    public final void delete() {
        close();
        u.deleteContents(this.axB);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        EC();
        this.axJ.flush();
    }

    public final File getDirectory() {
        return this.axB;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        try {
            checkNotClosed();
            dC(str);
            b bVar = this.axK.get(str);
            if (bVar != null && bVar.axY == null) {
                for (int i10 = 0; i10 < this.axH; i10++) {
                    File db2 = bVar.db(i10);
                    if (db2.exists() && !db2.delete()) {
                        throw new IOException("failed to delete " + db2);
                    }
                    this.size -= bVar.axW[i10];
                    this.axI--;
                    bVar.axW[i10] = 0;
                }
                this.axL++;
                this.axJ.append((CharSequence) ("REMOVE " + str + '\n'));
                this.axK.remove(str);
                if (EB()) {
                    this.axN.submit(this.axO);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    private synchronized C0487a e(String str, long j10) {
        try {
            checkNotClosed();
            dC(str);
            b bVar = this.axK.get(str);
            if (bVar == null) {
                bVar = new b(this, str, (byte) 0);
                this.axK.put(str, bVar);
            } else if (bVar.axY != null) {
                return null;
            }
            C0487a c0487a = new C0487a(this, bVar, (byte) 0);
            bVar.axY = c0487a;
            this.axJ.write("DIRTY " + str + '\n');
            this.axJ.flush();
            return c0487a;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static a a(File file, int i10, int i11, long j10) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i10, int i11, long j10, int i12) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i12 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i11 > 0) {
            File file2 = new File(file, ve.a.f31466t);
            if (file2.exists()) {
                File file3 = new File(file, ve.a.f31464r);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i10, i11, j10, i12);
            if (aVar.axC.exists()) {
                try {
                    aVar.Ex();
                    aVar.Ey();
                    aVar.axJ = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.axC, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                    return aVar;
                } catch (IOException e10) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                    aVar.delete();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i10, i11, j10, i12);
            aVar2.Ez();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file, File file2, boolean z10) {
        if (z10) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized void a(C0487a c0487a, boolean z10) {
        b bVar = c0487a.axR;
        if (bVar.axY == c0487a) {
            if (z10 && !bVar.axX) {
                for (int i10 = 0; i10 < this.axH; i10++) {
                    if (c0487a.axS[i10]) {
                        if (!bVar.dc(i10).exists()) {
                            c0487a.abort();
                            return;
                        }
                    } else {
                        c0487a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    }
                }
            }
            for (int i11 = 0; i11 < this.axH; i11++) {
                File dc2 = bVar.dc(i11);
                if (z10) {
                    if (dc2.exists()) {
                        File db2 = bVar.db(i11);
                        dc2.renameTo(db2);
                        long j10 = bVar.axW[i11];
                        long length = db2.length();
                        bVar.axW[i11] = length;
                        this.size = (this.size - j10) + length;
                        this.axI++;
                    }
                } else {
                    p(dc2);
                }
            }
            this.axL++;
            bVar.axY = null;
            if (!(bVar.axX | z10)) {
                this.axK.remove(bVar.key);
                this.axJ.write("REMOVE " + bVar.key + '\n');
            } else {
                b.a(bVar, true);
                this.axJ.write("CLEAN " + bVar.key + bVar.EE() + '\n');
                if (z10) {
                    long j11 = this.axM;
                    this.axM = 1 + j11;
                    bVar.axZ = j11;
                }
            }
            this.axJ.flush();
            if (this.size > this.maxSize || this.axI > this.axG || EB()) {
                this.axN.submit(this.axO);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
