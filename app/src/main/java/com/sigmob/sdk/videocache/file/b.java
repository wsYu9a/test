package com.sigmob.sdk.videocache.file;

import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.videocache.q;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public class b implements com.sigmob.sdk.videocache.c {

    /* renamed from: d */
    public static final String f20592d = ".download";

    /* renamed from: a */
    public final a f20593a;

    /* renamed from: b */
    public File f20594b;

    /* renamed from: c */
    public RandomAccessFile f20595c;

    public b(File file) throws q {
        this(file, new i());
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void a(byte[] bArr, int i10) throws q {
        try {
            if (b()) {
                throw new q("Error append cache: cache file " + this.f20594b + " is completed!");
            }
            this.f20595c.seek(a());
            this.f20595c.write(bArr, 0, i10);
        } catch (IOException e10) {
            throw new q(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i10), this.f20595c, Integer.valueOf(bArr.length)), e10);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized boolean b() {
        return !a(this.f20594b);
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void c() throws q {
        if (b()) {
            return;
        }
        close();
        File file = new File(this.f20594b.getParentFile(), this.f20594b.getName().substring(0, this.f20594b.getName().length() - 9));
        if (!this.f20594b.renameTo(file)) {
            throw new q("Error renaming file " + this.f20594b + " to " + file + " for completion!");
        }
        this.f20594b = file;
        try {
            this.f20595c = new RandomAccessFile(this.f20594b, t.f11211k);
            this.f20593a.a(this.f20594b);
        } catch (IOException e10) {
            throw new q("Error opening " + this.f20594b + " as disc cache", e10);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void close() throws q {
        try {
            this.f20595c.close();
            this.f20593a.a(this.f20594b);
        } catch (IOException e10) {
            throw new q("Error closing file " + this.f20594b, e10);
        }
    }

    public File d() {
        return this.f20594b;
    }

    public b(File file, a aVar) throws q {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f20593a = aVar;
            d.b(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + f20592d);
            }
            this.f20594b = file2;
            this.f20595c = new RandomAccessFile(this.f20594b, exists ? t.f11211k : "rw");
        } catch (IOException e10) {
            throw new q("Error using file " + file + " as disc cache", e10);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized long a() throws q {
        try {
        } catch (IOException e10) {
            throw new q("Error reading length of file " + this.f20594b, e10);
        }
        return (int) this.f20595c.length();
    }

    public final boolean a(File file) {
        return file.getName().endsWith(f20592d);
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized int a(byte[] bArr, long j10, int i10) throws q {
        try {
            this.f20595c.seek(j10);
        } catch (IOException e10) {
            throw new q(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(a()), Integer.valueOf(bArr.length)), e10);
        }
        return this.f20595c.read(bArr, 0, i10);
    }
}
