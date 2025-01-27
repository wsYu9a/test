package com.opos.mobad.i.a;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes4.dex */
public class e implements f {

    /* renamed from: a */
    private RandomAccessFile f21009a;

    /* renamed from: b */
    private FileChannel f21010b;

    /* renamed from: c */
    private FileLock f21011c;

    public e(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f21009a = randomAccessFile;
            this.f21010b = randomAccessFile.getChannel();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "FileLockEngine", (Throwable) e2);
        }
    }

    public e(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f21009a = randomAccessFile;
            this.f21010b = randomAccessFile.getChannel();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "FileLockEngine", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.i.a.f
    public boolean a() {
        boolean z;
        FileChannel fileChannel = this.f21010b;
        if (fileChannel != null) {
            try {
                this.f21011c = fileChannel.lock();
                z = true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("FileLockEngine", "acquireFileLock", (Throwable) e2);
            }
            com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
        return z;
    }

    @Override // com.opos.mobad.i.a.f
    public void b() {
        try {
            FileLock fileLock = this.f21011c;
            if (fileLock != null) {
                fileLock.release();
            }
            FileChannel fileChannel = this.f21010b;
            if (fileChannel != null) {
                fileChannel.close();
            }
            RandomAccessFile randomAccessFile = this.f21009a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "releaseFileLock", (Throwable) e2);
        }
    }
}
