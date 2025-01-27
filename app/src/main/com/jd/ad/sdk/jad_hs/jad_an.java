package com.jd.ad.sdk.jad_hs;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import b5.a;
import com.jd.ad.sdk.jad_gr.jad_ly;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

/* loaded from: classes2.dex */
public final class jad_an implements Closeable {
    public final File jad_an;
    public final File jad_bo;
    public final File jad_cp;
    public final File jad_dq;
    public final int jad_er;
    public long jad_fs;
    public Writer jad_iv;
    public final int jad_jt;
    public int jad_kx;
    public long jad_hu = 0;
    public final LinkedHashMap<String, jad_dq> jad_jw = new LinkedHashMap<>(0, 0.75f, true);
    public long jad_ly = 0;
    public final ThreadPoolExecutor jad_mz = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new jad_bo(null));
    public final Callable<Void> jad_na = new CallableC0323jad_an();

    /* renamed from: com.jd.ad.sdk.jad_hs.jad_an$jad_an */
    public class CallableC0323jad_an implements Callable<Void> {
        public CallableC0323jad_an() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (jad_an.this) {
                try {
                    jad_an jad_anVar = jad_an.this;
                    if (jad_anVar.jad_iv != null) {
                        jad_anVar.jad_jt();
                        if (jad_an.this.jad_cp()) {
                            jad_an.this.jad_fs();
                            jad_an.this.jad_kx = 0;
                        }
                    }
                } finally {
                }
            }
            return null;
        }
    }

    public static final class jad_bo implements ThreadFactory {
        public jad_bo() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ jad_bo(CallableC0323jad_an callableC0323jad_an) {
            this();
        }
    }

    public final class jad_cp {
        public final jad_dq jad_an;
        public final boolean[] jad_bo;
        public boolean jad_cp;

        public jad_cp(jad_dq jad_dqVar) {
            this.jad_an = jad_dqVar;
            this.jad_bo = jad_dqVar.jad_er ? null : new boolean[jad_an.this.jad_jt];
        }

        public void jad_an() {
            jad_an.jad_an(jad_an.this, this, false);
        }

        public File jad_an(int i10) {
            File jad_bo;
            synchronized (jad_an.this) {
                try {
                    jad_dq jad_dqVar = this.jad_an;
                    if (jad_dqVar.jad_fs != this) {
                        throw new IllegalStateException();
                    }
                    if (!jad_dqVar.jad_er) {
                        this.jad_bo[i10] = true;
                    }
                    jad_bo = jad_dqVar.jad_bo(i10);
                    jad_an.this.jad_an.mkdirs();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return jad_bo;
        }
    }

    public final class jad_dq {
        public final String jad_an;
        public final long[] jad_bo;
        public File[] jad_cp;
        public File[] jad_dq;
        public boolean jad_er;
        public jad_cp jad_fs;
        public long jad_jt;

        public jad_dq(String str) {
            this.jad_an = str;
            this.jad_bo = new long[jad_an.this.jad_jt];
            this.jad_cp = new File[jad_an.this.jad_jt];
            this.jad_dq = new File[jad_an.this.jad_jt];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i10 = 0; i10 < jad_an.this.jad_jt; i10++) {
                sb2.append(i10);
                this.jad_cp[i10] = new File(jad_an.this.jad_an, sb2.toString());
                sb2.append(".tmp");
                this.jad_dq[i10] = new File(jad_an.this.jad_an, sb2.toString());
                sb2.setLength(length);
            }
        }

        public File jad_an(int i10) {
            return this.jad_cp[i10];
        }

        public File jad_bo(int i10) {
            return this.jad_dq[i10];
        }

        public String jad_an() {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.jad_bo) {
                sb2.append(a.O);
                sb2.append(j10);
            }
            return sb2.toString();
        }
    }

    public final class jad_er {
        public final File[] jad_an;

        public jad_er(jad_an jad_anVar, String str, long j10, File[] fileArr, long[] jArr) {
            this.jad_an = fileArr;
        }

        public File jad_an(int i10) {
            return this.jad_an[i10];
        }
    }

    public jad_an(File file, int i10, int i11, long j10) {
        this.jad_an = file;
        this.jad_er = i10;
        this.jad_bo = new File(file, ve.a.f31464r);
        this.jad_cp = new File(file, ve.a.f31465s);
        this.jad_dq = new File(file, ve.a.f31466t);
        this.jad_jt = i11;
        this.jad_fs = j10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.jad_iv == null) {
                return;
            }
            Iterator it = new ArrayList(this.jad_jw.values()).iterator();
            while (it.hasNext()) {
                jad_cp jad_cpVar = ((jad_dq) it.next()).jad_fs;
                if (jad_cpVar != null) {
                    jad_cpVar.jad_an();
                }
            }
            jad_jt();
            jad_an(this.jad_iv);
            this.jad_iv = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean jad_cp() {
        int i10 = this.jad_kx;
        return i10 >= 2000 && i10 >= this.jad_jw.size();
    }

    public final void jad_dq() {
        jad_an(this.jad_cp);
        Iterator<jad_dq> it = this.jad_jw.values().iterator();
        while (it.hasNext()) {
            jad_dq next = it.next();
            int i10 = 0;
            if (next.jad_fs == null) {
                while (i10 < this.jad_jt) {
                    this.jad_hu += next.jad_bo[i10];
                    i10++;
                }
            } else {
                next.jad_fs = null;
                while (i10 < this.jad_jt) {
                    jad_an(next.jad_an(i10));
                    jad_an(next.jad_bo(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void jad_er() {
        com.jd.ad.sdk.jad_hs.jad_bo jad_boVar = new com.jd.ad.sdk.jad_hs.jad_bo(new FileInputStream(this.jad_bo), 8192, com.jd.ad.sdk.jad_hs.jad_cp.jad_an);
        try {
            String jad_cp2 = jad_boVar.jad_cp();
            String jad_cp3 = jad_boVar.jad_cp();
            String jad_cp4 = jad_boVar.jad_cp();
            String jad_cp5 = jad_boVar.jad_cp();
            String jad_cp6 = jad_boVar.jad_cp();
            if (!ve.a.f31467u.equals(jad_cp2) || !"1".equals(jad_cp3) || !Integer.toString(this.jad_er).equals(jad_cp4) || !Integer.toString(this.jad_jt).equals(jad_cp5) || !"".equals(jad_cp6)) {
                throw new IOException("unexpected journal header: [" + jad_cp2 + ", " + jad_cp3 + ", " + jad_cp5 + ", " + jad_cp6 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    jad_cp(jad_boVar.jad_cp());
                    i10++;
                } catch (EOFException unused) {
                    this.jad_kx = i10 - this.jad_jw.size();
                    if (jad_boVar.jad_er == -1) {
                        jad_fs();
                    } else {
                        this.jad_iv = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_bo, true), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
                    }
                    try {
                        jad_boVar.close();
                        return;
                    } catch (RuntimeException e10) {
                        throw e10;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            try {
                jad_boVar.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused3) {
            }
            throw th2;
        }
    }

    public final synchronized void jad_fs() {
        StringBuilder sb2;
        try {
            Writer writer = this.jad_iv;
            if (writer != null) {
                jad_an(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_cp), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
            try {
                bufferedWriter.write(ve.a.f31467u);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.jad_er));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.jad_jt));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (jad_dq jad_dqVar : this.jad_jw.values()) {
                    if (jad_dqVar.jad_fs != null) {
                        sb2 = new StringBuilder();
                        sb2.append("DIRTY ");
                        sb2.append(jad_dqVar.jad_an);
                        sb2.append('\n');
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(jad_dqVar.jad_an);
                        sb2.append(jad_dqVar.jad_an());
                        sb2.append('\n');
                    }
                    bufferedWriter.write(sb2.toString());
                }
                jad_an(bufferedWriter);
                if (this.jad_bo.exists()) {
                    jad_an(this.jad_bo, this.jad_dq, true);
                }
                jad_an(this.jad_cp, this.jad_bo, false);
                this.jad_dq.delete();
                this.jad_iv = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_bo, true), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
            } catch (Throwable th2) {
                jad_an(bufferedWriter);
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final void jad_jt() {
        while (this.jad_hu > this.jad_fs) {
            String key = this.jad_jw.entrySet().iterator().next().getKey();
            synchronized (this) {
                try {
                    jad_bo();
                    jad_dq jad_dqVar = this.jad_jw.get(key);
                    if (jad_dqVar != null && jad_dqVar.jad_fs == null) {
                        for (int i10 = 0; i10 < this.jad_jt; i10++) {
                            File jad_an = jad_dqVar.jad_an(i10);
                            if (jad_an.exists() && !jad_an.delete()) {
                                throw new IOException("failed to delete " + jad_an);
                            }
                            long j10 = this.jad_hu;
                            long[] jArr = jad_dqVar.jad_bo;
                            this.jad_hu = j10 - jArr[i10];
                            jArr[i10] = 0;
                        }
                        this.jad_kx++;
                        this.jad_iv.append((CharSequence) ve.a.A);
                        this.jad_iv.append(a.O);
                        this.jad_iv.append((CharSequence) key);
                        this.jad_iv.append('\n');
                        this.jad_jw.remove(key);
                        if (jad_cp()) {
                            this.jad_mz.submit(this.jad_na);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void jad_an(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final void jad_bo() {
        if (this.jad_iv == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final void jad_cp(String str) {
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
                this.jad_jw.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i10, indexOf2);
        }
        jad_dq jad_dqVar = this.jad_jw.get(substring);
        if (jad_dqVar == null) {
            jad_dqVar = new jad_dq(substring);
            this.jad_jw.put(substring, jad_dqVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith(ve.a.f31471y)) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith(ve.a.f31472z)) {
                jad_dqVar.jad_fs = new jad_cp(jad_dqVar);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith(ve.a.B)) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        jad_dqVar.jad_er = true;
        jad_dqVar.jad_fs = null;
        if (split.length != jad_an.this.jad_jt) {
            StringBuilder jad_an = jad_ly.jad_an("unexpected journal line: ");
            jad_an.append(Arrays.toString(split));
            throw new IOException(jad_an.toString());
        }
        for (int i11 = 0; i11 < split.length; i11++) {
            try {
                jad_dqVar.jad_bo[i11] = Long.parseLong(split[i11]);
            } catch (NumberFormatException unused) {
                StringBuilder jad_an2 = jad_ly.jad_an("unexpected journal line: ");
                jad_an2.append(Arrays.toString(split));
                throw new IOException(jad_an2.toString());
            }
        }
    }

    public static void jad_an(File file, File file2, boolean z10) {
        if (z10) {
            jad_an(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void jad_bo(Writer writer) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @TargetApi(26)
    public static void jad_an(Writer writer) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized jad_er jad_bo(String str) {
        jad_bo();
        jad_dq jad_dqVar = this.jad_jw.get(str);
        if (jad_dqVar == null) {
            return null;
        }
        if (!jad_dqVar.jad_er) {
            return null;
        }
        for (File file : jad_dqVar.jad_cp) {
            if (!file.exists()) {
                return null;
            }
        }
        this.jad_kx++;
        this.jad_iv.append((CharSequence) ve.a.B);
        this.jad_iv.append(a.O);
        this.jad_iv.append((CharSequence) str);
        this.jad_iv.append('\n');
        if (jad_cp()) {
            this.jad_mz.submit(this.jad_na);
        }
        return new jad_er(this, str, jad_dqVar.jad_jt, jad_dqVar.jad_cp, jad_dqVar.jad_bo);
    }

    public static void jad_an(jad_an jad_anVar, jad_cp jad_cpVar, boolean z10) {
        synchronized (jad_anVar) {
            jad_dq jad_dqVar = jad_cpVar.jad_an;
            if (jad_dqVar.jad_fs != jad_cpVar) {
                throw new IllegalStateException();
            }
            if (z10 && !jad_dqVar.jad_er) {
                for (int i10 = 0; i10 < jad_anVar.jad_jt; i10++) {
                    if (!jad_cpVar.jad_bo[i10]) {
                        jad_cpVar.jad_an();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    }
                    if (!jad_dqVar.jad_bo(i10).exists()) {
                        jad_cpVar.jad_an();
                        return;
                    }
                }
            }
            for (int i11 = 0; i11 < jad_anVar.jad_jt; i11++) {
                File jad_bo2 = jad_dqVar.jad_bo(i11);
                if (!z10) {
                    jad_an(jad_bo2);
                } else if (jad_bo2.exists()) {
                    File jad_an = jad_dqVar.jad_an(i11);
                    jad_bo2.renameTo(jad_an);
                    long j10 = jad_dqVar.jad_bo[i11];
                    long length = jad_an.length();
                    jad_dqVar.jad_bo[i11] = length;
                    jad_anVar.jad_hu = (jad_anVar.jad_hu - j10) + length;
                }
            }
            jad_anVar.jad_kx++;
            jad_dqVar.jad_fs = null;
            if (jad_dqVar.jad_er | z10) {
                jad_dqVar.jad_er = true;
                jad_anVar.jad_iv.append((CharSequence) ve.a.f31471y);
                jad_anVar.jad_iv.append(a.O);
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an);
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an());
                jad_anVar.jad_iv.append('\n');
                if (z10) {
                    long j11 = jad_anVar.jad_ly;
                    jad_anVar.jad_ly = 1 + j11;
                    jad_dqVar.jad_jt = j11;
                }
            } else {
                jad_anVar.jad_jw.remove(jad_dqVar.jad_an);
                jad_anVar.jad_iv.append((CharSequence) ve.a.A);
                jad_anVar.jad_iv.append(a.O);
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an);
                jad_anVar.jad_iv.append('\n');
            }
            jad_bo(jad_anVar.jad_iv);
            if (jad_anVar.jad_hu > jad_anVar.jad_fs || jad_anVar.jad_cp()) {
                jad_anVar.jad_mz.submit(jad_anVar.jad_na);
            }
        }
    }

    public jad_cp jad_an(String str) {
        synchronized (this) {
            try {
                jad_bo();
                jad_dq jad_dqVar = this.jad_jw.get(str);
                if (jad_dqVar == null) {
                    jad_dqVar = new jad_dq(str);
                    this.jad_jw.put(str, jad_dqVar);
                } else if (jad_dqVar.jad_fs != null) {
                    return null;
                }
                jad_cp jad_cpVar = new jad_cp(jad_dqVar);
                jad_dqVar.jad_fs = jad_cpVar;
                this.jad_iv.append((CharSequence) ve.a.f31472z);
                this.jad_iv.append(a.O);
                this.jad_iv.append((CharSequence) str);
                this.jad_iv.append('\n');
                jad_bo(this.jad_iv);
                return jad_cpVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
