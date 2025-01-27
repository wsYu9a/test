package com.opos.cmn.func.a.a;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes4.dex */
public class e implements f {

    /* renamed from: a */
    private RandomAccessFile f17042a;

    /* renamed from: b */
    private FileChannel f17043b;

    /* renamed from: c */
    private FileLock f17044c;

    public e(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f17042a = randomAccessFile;
            this.f17043b = randomAccessFile.getChannel();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("FileLockEngine", "FileLockEngine", e2);
        }
    }

    public e(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f17042a = randomAccessFile;
            this.f17043b = randomAccessFile.getChannel();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("FileLockEngine", "FileLockEngine", e2);
        }
    }

    @Override // com.opos.cmn.func.a.a.f
    public boolean a() {
        boolean z;
        FileChannel fileChannel = this.f17043b;
        if (fileChannel != null) {
            try {
                this.f17044c = fileChannel.lock();
                z = true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("FileLockEngine", "acquireFileLock", e2);
            }
            com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
        return z;
    }

    @Override // com.opos.cmn.func.a.a.f
    public void b() {
        try {
            FileLock fileLock = this.f17044c;
            if (fileLock != null) {
                fileLock.release();
            }
            FileChannel fileChannel = this.f17043b;
            if (fileChannel != null) {
                fileChannel.close();
            }
            RandomAccessFile randomAccessFile = this.f17042a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("FileLockEngine", "releaseFileLock", e2);
        }
    }
}
