package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
class BufferQueue implements IBufferPool, IInput, IOutput {
    private static final int MIN_BUFFER_COUNT = 64;
    private static final int MIN_BUFFER_SIZE = 8192;
    private int bufferCount;
    private final int bufferSize;
    private volatile boolean closed;
    private final int maxBufferCount;
    private Buffer rHead;
    private Buffer rSafe;
    private Buffer rTail;
    private Buffer wHead;
    private Buffer wTail;
    private final Object wLock = new Object();
    private final Object rLock = new Object();

    public BufferQueue(int i10, int i11) {
        i10 = i10 < 64 ? 64 : i10;
        i11 = i11 < 8192 ? 8192 : i11;
        this.maxBufferCount = i10;
        this.bufferSize = i11;
    }

    public void close() {
        this.closed = true;
        synchronized (this.wLock) {
            this.wLock.notifyAll();
        }
        synchronized (this.rLock) {
            this.rLock.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    @NonNull
    public Buffer obtain() throws StreamClosedException, InterruptedException {
        synchronized (this.wLock) {
            try {
                if (this.closed) {
                    throw new StreamClosedException("obtain");
                }
                Buffer buffer = this.wHead;
                if (buffer == null) {
                    int i10 = this.bufferCount;
                    if (i10 < this.maxBufferCount) {
                        this.bufferCount = i10 + 1;
                        return new Buffer(this.bufferSize);
                    }
                    do {
                        this.wLock.wait();
                        if (this.closed) {
                            throw new StreamClosedException("obtain");
                        }
                        buffer = this.wHead;
                    } while (buffer == null);
                }
                this.wHead = buffer.next;
                if (buffer == this.wTail) {
                    this.wTail = null;
                }
                buffer.next = null;
                return buffer;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.IInput
    @NonNull
    public Buffer read() throws StreamClosedException, InterruptedException {
        Buffer buffer;
        Buffer buffer2 = this.rSafe;
        if (buffer2 != null) {
            this.rSafe = buffer2.next;
            buffer2.next = null;
            return buffer2;
        }
        synchronized (this.rLock) {
            try {
                buffer = this.rHead;
                while (buffer == null) {
                    if (this.closed) {
                        throw new StreamClosedException("read");
                    }
                    this.rLock.wait();
                    buffer = this.rHead;
                }
                this.rSafe = buffer.next;
                this.rTail = null;
                this.rHead = null;
                buffer.next = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return buffer;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IBufferPool
    public void recycle(@NonNull Buffer buffer) {
        synchronized (this.wLock) {
            try {
                Buffer buffer2 = this.wTail;
                if (buffer2 == null) {
                    this.wTail = buffer;
                    this.wHead = buffer;
                } else {
                    buffer2.next = buffer;
                    this.wTail = buffer;
                }
                this.wLock.notify();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(@NonNull Buffer buffer) {
        synchronized (this.rLock) {
            try {
                Buffer buffer2 = this.rTail;
                if (buffer2 == null) {
                    this.rTail = buffer;
                    this.rHead = buffer;
                    this.rLock.notify();
                } else {
                    buffer2.next = buffer;
                    this.rTail = buffer;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
