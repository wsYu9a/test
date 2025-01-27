package com.opos.mobad;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* loaded from: classes4.dex */
public class c implements com.opos.mobad.c.a.b {

    /* renamed from: a */
    private RandomAccessFile f20028a;

    /* renamed from: b */
    private FileChannel f20029b;

    /* renamed from: c */
    private FileLock f20030c;

    public c(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f20028a = randomAccessFile;
            this.f20029b = randomAccessFile.getChannel();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "FileLockEngine", (Throwable) e2);
        }
    }

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = str + File.separator + "lock.lk";
        a(new File(str2));
        return new c(str2);
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        try {
            if (!com.opos.cmn.an.d.b.a.b(com.opos.cmn.an.d.b.a.d(file))) {
                com.opos.cmn.an.d.b.a.c(file);
            }
            file.createNewFile();
        } catch (IOException e2) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.c.a.b
    public boolean a() {
        boolean z;
        FileChannel fileChannel = this.f20029b;
        if (fileChannel != null) {
            try {
                this.f20030c = fileChannel.lock();
                z = true;
            } catch (OverlappingFileLockException unused) {
                com.opos.cmn.an.f.a.a("FileLockedEngine", "acquireFileLock but has acquire by other thread");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("FileLockedEngine", "acquireFileLock", (Throwable) e2);
            }
            com.opos.cmn.an.f.a.b("FileLockedEngine", "acquireFileLock result=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("FileLockedEngine", "acquireFileLock result=" + z);
        return z;
    }

    @Override // com.opos.mobad.c.a.b
    public void b() {
        try {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseFileLock");
            FileLock fileLock = this.f20030c;
            if (fileLock != null) {
                fileLock.release();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseFileLock", (Throwable) e2);
        }
        try {
            FileChannel fileChannel = this.f20029b;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releasemFileChannel", (Throwable) e3);
        }
        try {
            RandomAccessFile randomAccessFile = this.f20028a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception e4) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseRandomAccessFile", (Throwable) e4);
        }
    }
}
