package com.opos.videocache.a;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public class b implements com.opos.videocache.a {

    /* renamed from: a */
    public File f23785a;

    /* renamed from: b */
    private final a f23786b;

    /* renamed from: c */
    private RandomAccessFile f23787c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f23786b = aVar;
            h.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this.f23785a = file2;
            this.f23787c = new RandomAccessFile(this.f23785a, exists ? t.k : "rw");
        } catch (IOException e2) {
            throw new com.opos.videocache.g("Error using file " + file + " as disc cache", e2);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.opos.videocache.a
    public int a(byte[] bArr, long j2, int i2) {
        int read;
        synchronized (this) {
            try {
                this.f23787c.seek(j2);
                read = this.f23787c.read(bArr, 0, i2);
            } catch (IOException e2) {
                throw new com.opos.videocache.g(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(a()), Integer.valueOf(bArr.length)), e2);
            }
        }
        return read;
    }

    @Override // com.opos.videocache.a
    public long a() {
        long length;
        synchronized (this) {
            try {
                length = (int) this.f23787c.length();
            } catch (IOException e2) {
                throw new com.opos.videocache.g("Error reading length of file " + this.f23785a, e2);
            }
        }
        return length;
    }

    @Override // com.opos.videocache.a
    public void a(byte[] bArr, int i2) {
        synchronized (this) {
            try {
                if (d()) {
                    throw new com.opos.videocache.g("Error append cache: cache file " + this.f23785a + " is completed!");
                }
                this.f23787c.seek(a());
                this.f23787c.write(bArr, 0, i2);
            } catch (IOException e2) {
                throw new com.opos.videocache.g(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.f23787c, Integer.valueOf(bArr.length)), e2);
            }
        }
    }

    @Override // com.opos.videocache.a
    public void b() {
        synchronized (this) {
            try {
                this.f23787c.close();
                this.f23786b.a(this.f23785a);
            } catch (IOException e2) {
                throw new com.opos.videocache.g("Error closing file " + this.f23785a, e2);
            }
        }
    }

    @Override // com.opos.videocache.a
    public void c() {
        synchronized (this) {
            if (!d()) {
                b();
                File file = new File(this.f23785a.getParentFile(), this.f23785a.getName().substring(0, this.f23785a.getName().length() - 9));
                if (!this.f23785a.renameTo(file)) {
                    com.opos.cmn.an.f.a.a("FileCache", "Error renaming file " + this.f23785a + " to " + file + " for completion!");
                    throw new com.opos.videocache.g("Error renaming file " + this.f23785a + " to " + file + " for completion!");
                }
                if (!this.f23785a.delete()) {
                    com.opos.cmn.an.f.a.a("FileCache", "delete .download cache file fail!");
                }
                this.f23785a = file;
                try {
                    this.f23787c = new RandomAccessFile(this.f23785a, t.k);
                    this.f23786b.a(this.f23785a);
                } catch (IOException e2) {
                    com.opos.cmn.an.f.a.a("FileCache", "Error opening " + this.f23785a + " as disc cache", (Throwable) e2);
                    throw new com.opos.videocache.g("Error opening " + this.f23785a + " as disc cache", e2);
                }
            }
        }
    }

    @Override // com.opos.videocache.a
    public boolean d() {
        boolean z;
        synchronized (this) {
            z = !a(this.f23785a);
        }
        return z;
    }
}
