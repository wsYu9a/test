package com.alimm.tanx.core.view.player.cache.videocache.file;

import com.alimm.tanx.core.view.player.cache.videocache.Cache;
import com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class FileCache implements Cache {
    private static final String TEMP_POSTFIX = ".download";
    private RandomAccessFile dataFile;
    private final DiskUsage diskUsage;
    public File file;

    public FileCache(File file) throws ProxyCacheException {
        this(file, new UnlimitedDiskUsage());
    }

    private boolean isTempFile(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void append(byte[] bArr, int i10) throws ProxyCacheException {
        try {
            if (isCompleted()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
            this.dataFile.seek(available());
            this.dataFile.write(bArr, 0, i10);
        } catch (IOException e10) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i10), this.dataFile, Integer.valueOf(bArr.length)), e10);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e10) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e10);
        }
        return (int) this.dataFile.length();
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void close() throws ProxyCacheException {
        try {
            this.dataFile.close();
            this.diskUsage.touch(this.file);
        } catch (IOException e10) {
            throw new ProxyCacheException("Error closing file " + this.file, e10);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void complete() throws ProxyCacheException {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (!this.file.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
        }
        this.file = file;
        try {
            this.dataFile = new RandomAccessFile(this.file, t.f11211k);
            this.diskUsage.touch(this.file);
        } catch (IOException e10) {
            throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e10);
        }
    }

    public File getFile() {
        return this.file;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized boolean isCompleted() {
        return !isTempFile(this.file);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized int read(byte[] bArr, long j10, int i10) throws ProxyCacheException {
        try {
            this.dataFile.seek(j10);
        } catch (IOException e10) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(available()), Integer.valueOf(bArr.length)), e10);
        }
        return this.dataFile.read(bArr, 0, i10);
    }

    public FileCache(File file, DiskUsage diskUsage) throws ProxyCacheException {
        File file2;
        try {
            if (diskUsage == null) {
                throw new NullPointerException();
            }
            this.diskUsage = diskUsage;
            Files.makeDir(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this.file = file2;
            this.dataFile = new RandomAccessFile(this.file, exists ? t.f11211k : "rw");
        } catch (IOException e10) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e10);
        }
    }
}
