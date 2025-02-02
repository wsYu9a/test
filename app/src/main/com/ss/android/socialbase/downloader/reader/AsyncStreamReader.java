package com.ss.android.socialbase.downloader.reader;

import android.os.Process;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.segment.Buffer;
import com.ss.android.socialbase.downloader.segment.StreamClosedException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public class AsyncStreamReader implements IStreamReader {
    private static final String TAG = "AsyncStreamReader";
    private int bufferCount;
    private final int bufferSize;
    private volatile boolean closed;
    private final InputStream inputStream;
    private final int maxBufferCount;
    private volatile Future rFuture;
    private Buffer rHead;
    private Buffer rSafe;
    private Buffer rTail;
    private volatile boolean terminated;
    private volatile Throwable throwable;
    private Buffer wHead;
    private Buffer wSafe;
    private Buffer wTail;
    private final Object rLock = new Object();
    private final Object wLock = new Object();
    private final Runnable rRunnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.reader.AsyncStreamReader.1
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Buffer dequeueReadBuffer;
            Process.setThreadPriority(10);
            do {
                try {
                    dequeueReadBuffer = AsyncStreamReader.this.dequeueReadBuffer();
                    dequeueReadBuffer.size = AsyncStreamReader.this.inputStream.read(dequeueReadBuffer.data);
                    AsyncStreamReader.this.enqueueWriteBuffer(dequeueReadBuffer);
                } catch (Throwable th2) {
                    try {
                        AsyncStreamReader.this.throwable = th2;
                        th2.printStackTrace();
                        synchronized (AsyncStreamReader.this.wLock) {
                            AsyncStreamReader.this.terminated = true;
                            AsyncStreamReader.this.wLock.notify();
                            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
                            return;
                        }
                    } catch (Throwable th3) {
                        synchronized (AsyncStreamReader.this.wLock) {
                            AsyncStreamReader.this.terminated = true;
                            AsyncStreamReader.this.wLock.notify();
                            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
                            throw th3;
                        }
                    }
                }
            } while (dequeueReadBuffer.size != -1);
            synchronized (AsyncStreamReader.this.wLock) {
                AsyncStreamReader.this.terminated = true;
                AsyncStreamReader.this.wLock.notify();
            }
            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
        }
    };

    /* renamed from: com.ss.android.socialbase.downloader.reader.AsyncStreamReader$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Buffer dequeueReadBuffer;
            Process.setThreadPriority(10);
            do {
                try {
                    dequeueReadBuffer = AsyncStreamReader.this.dequeueReadBuffer();
                    dequeueReadBuffer.size = AsyncStreamReader.this.inputStream.read(dequeueReadBuffer.data);
                    AsyncStreamReader.this.enqueueWriteBuffer(dequeueReadBuffer);
                } catch (Throwable th2) {
                    try {
                        AsyncStreamReader.this.throwable = th2;
                        th2.printStackTrace();
                        synchronized (AsyncStreamReader.this.wLock) {
                            AsyncStreamReader.this.terminated = true;
                            AsyncStreamReader.this.wLock.notify();
                            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
                            return;
                        }
                    } catch (Throwable th3) {
                        synchronized (AsyncStreamReader.this.wLock) {
                            AsyncStreamReader.this.terminated = true;
                            AsyncStreamReader.this.wLock.notify();
                            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
                            throw th3;
                        }
                    }
                }
            } while (dequeueReadBuffer.size != -1);
            synchronized (AsyncStreamReader.this.wLock) {
                AsyncStreamReader.this.terminated = true;
                AsyncStreamReader.this.wLock.notify();
            }
            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
        }
    }

    public AsyncStreamReader(InputStream inputStream, int i10, int i11) throws Throwable {
        this.inputStream = inputStream;
        this.bufferSize = i10;
        if (i11 < 1) {
            i11 = 1;
        } else if (i11 > 64) {
            i11 = 64;
        }
        this.maxBufferCount = i11;
        start();
    }

    public Buffer dequeueReadBuffer() throws StreamClosedException, InterruptedException {
        int i10;
        Buffer buffer = this.rSafe;
        if (buffer != null) {
            if (this.closed) {
                throw new StreamClosedException("");
            }
            this.rSafe = buffer.next;
            buffer.next = null;
            return buffer;
        }
        synchronized (this.rLock) {
            try {
                if (this.closed) {
                    throw new StreamClosedException("");
                }
                Buffer buffer2 = this.rHead;
                if (buffer2 == null && (i10 = this.bufferCount) < this.maxBufferCount) {
                    this.bufferCount = i10 + 1;
                    return new Buffer(this.bufferSize);
                }
                while (buffer2 == null) {
                    this.rLock.wait();
                    if (this.closed) {
                        throw new StreamClosedException("");
                    }
                    buffer2 = this.rHead;
                }
                this.rSafe = buffer2.next;
                this.rTail = null;
                this.rHead = null;
                buffer2.next = null;
                return buffer2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private Buffer dequeueWriteBuffer() throws BaseException, InterruptedException {
        Buffer buffer;
        Buffer buffer2 = this.wSafe;
        if (buffer2 != null) {
            this.wSafe = buffer2.next;
            buffer2.next = null;
            return buffer2;
        }
        synchronized (this.wLock) {
            try {
                buffer = this.wHead;
                if (buffer == null) {
                    do {
                        if (this.terminated) {
                            handleTerminated();
                        }
                        this.wLock.wait();
                        buffer = this.wHead;
                    } while (buffer == null);
                }
                this.wSafe = buffer.next;
                this.wTail = null;
                this.wHead = null;
                buffer.next = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return buffer;
    }

    private void enqueueReadBuffer(Buffer buffer) {
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

    public void enqueueWriteBuffer(Buffer buffer) {
        synchronized (this.wLock) {
            try {
                Buffer buffer2 = this.wTail;
                if (buffer2 == null) {
                    this.wTail = buffer;
                    this.wHead = buffer;
                    this.wLock.notify();
                } else {
                    buffer2.next = buffer;
                    this.wTail = buffer;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void handleTerminated() throws BaseException {
        Throwable th2 = this.throwable;
        if (th2 != null) {
            if (th2 instanceof StreamClosedException) {
                throw new BaseException(DownloadErrorCode.ERROR_STREAM_CLOSED, "async reader closed!");
            }
            DownloadUtils.parseException(th2, "async_read");
        }
        throw new BaseException(DownloadErrorCode.ERROR_STREAM_TERMINATED, "async reader terminated!");
    }

    private void start() throws Throwable {
        this.rFuture = DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(this.rRunnable);
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void close() {
        synchronized (this.rLock) {
            this.closed = true;
            this.rLock.notify();
        }
        Future future = this.rFuture;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.rFuture = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public Buffer read() throws BaseException, InterruptedException {
        return dequeueWriteBuffer();
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void recycle(Buffer buffer) {
        enqueueReadBuffer(buffer);
    }
}
