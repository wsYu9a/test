package com.alimm.tanx.core.view.player.cache.videocache;

import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class ProxyCache {
    private static final Logger LOG = LoggerFactory.getLogger("ProxyCache");
    private static final int MAX_READ_SOURCE_ATTEMPTS = 1;
    private final Cache cache;
    private final Source source;
    private volatile Thread sourceReaderThread;
    private volatile boolean stopped;

    /* renamed from: wc */
    private final Object f6323wc = new Object();
    private final Object stopLock = new Object();
    private volatile int percentsAvailable = -1;
    private final AtomicInteger readSourceErrorsCount = new AtomicInteger();

    public class SourceReaderRunnable implements Runnable {
        private SourceReaderRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProxyCache.this.readSource();
        }

        public /* synthetic */ SourceReaderRunnable(ProxyCache proxyCache, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public ProxyCache(Source source, Cache cache) {
        this.source = (Source) Preconditions.checkNotNull(source);
        this.cache = (Cache) Preconditions.checkNotNull(cache);
    }

    private void checkReadSourceErrorsCount() throws ProxyCacheException {
        int i10 = this.readSourceErrorsCount.get();
        if (i10 < 1) {
            return;
        }
        this.readSourceErrorsCount.set(0);
        throw new ProxyCacheException("Error reading source " + i10 + " times");
    }

    private void closeSource() {
        try {
            this.source.close();
        } catch (ProxyCacheException e10) {
            onError(new ProxyCacheException("Error closing source " + this.source, e10));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.stopped;
    }

    private void notifyNewCacheDataAvailable(long j10, long j11) {
        onCacheAvailable(j10, j11);
        synchronized (this.f6323wc) {
            this.f6323wc.notifyAll();
        }
    }

    private void onSourceRead() {
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(this.percentsAvailable);
    }

    public void readSource() {
        long j10 = -1;
        long j11 = 0;
        try {
            LOG.info("开始读取网络数据");
            j11 = this.cache.available();
            this.source.open(j11);
            j10 = this.source.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.source.read(bArr);
                if (read == -1) {
                    tryComplete();
                    onSourceRead();
                    LOG.info("读取网络数据结束");
                    break;
                } else {
                    synchronized (this.stopLock) {
                        if (isStopped()) {
                            return;
                        } else {
                            this.cache.append(bArr, read);
                        }
                    }
                    j11 += read;
                    notifyNewCacheDataAvailable(j11, j10);
                }
            }
        } catch (Throwable th2) {
            try {
                Logger logger = LOG;
                logger.info("读取网络数据异常");
                this.readSourceErrorsCount.incrementAndGet();
                onError(th2);
                logger.info("读取网络数据结束");
            } finally {
                LOG.info("读取网络数据结束");
                closeSource();
                notifyNewCacheDataAvailable(j11, j10);
            }
        }
        closeSource();
        notifyNewCacheDataAvailable(j11, j10);
    }

    private synchronized void readSourceAsync() throws ProxyCacheException {
        try {
            LOG.info("一步读取网络数据");
            boolean z10 = (this.sourceReaderThread == null || this.sourceReaderThread.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.stopped && !this.cache.isCompleted() && !z10) {
                this.sourceReaderThread = new Thread(new SourceReaderRunnable(), "Source reader for " + this.source);
                this.sourceReaderThread.start();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void tryComplete() throws ProxyCacheException {
        synchronized (this.stopLock) {
            try {
                if (!isStopped() && this.cache.available() == this.source.length()) {
                    this.cache.complete();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void waitForSourceData() throws ProxyCacheException {
        synchronized (this.f6323wc) {
            try {
                try {
                    this.f6323wc.wait(1000L);
                } catch (InterruptedException e10) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void onCacheAvailable(long j10, long j11) {
        int i10 = j11 == 0 ? 100 : (int) ((j10 / j11) * 100.0f);
        boolean z10 = i10 != this.percentsAvailable;
        if (j11 >= 0 && z10) {
            onCachePercentsAvailableChanged(i10);
        }
        this.percentsAvailable = i10;
    }

    public void onCachePercentsAvailableChanged(int i10) {
    }

    public final void onError(Throwable th2) {
        if (th2 instanceof InterruptedProxyCacheException) {
            LOG.debug("ProxyCache is interrupted");
        } else {
            LOG.error("ProxyCache error", th2);
        }
    }

    public int read(byte[] bArr, long j10, int i10) throws ProxyCacheException {
        ProxyCacheUtils.assertBuffer(bArr, j10, i10);
        while (!this.cache.isCompleted() && this.cache.available() < i10 + j10 && !this.stopped) {
            readSourceAsync();
            waitForSourceData();
            checkReadSourceErrorsCount();
        }
        LOG.info("开始从缓存中读取数据");
        int read = this.cache.read(bArr, j10, i10);
        if (this.cache.isCompleted() && this.percentsAvailable != 100) {
            this.percentsAvailable = 100;
            onCachePercentsAvailableChanged(100);
        }
        return read;
    }

    public void shutdown() {
        synchronized (this.stopLock) {
            try {
                LOG.info("Shutdown proxy for " + this.source);
                try {
                    this.stopped = true;
                    if (this.sourceReaderThread != null) {
                        this.sourceReaderThread.interrupt();
                    }
                    this.cache.close();
                } catch (ProxyCacheException e10) {
                    onError(e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
