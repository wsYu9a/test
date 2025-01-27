package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public class ThreadWithHandler {
    private InnerThread handlerThread;
    private Object lock = new Object();
    private Queue<MessageEntity> mCacheQueue = new ConcurrentLinkedQueue();
    private Handler mHandler;

    private class InnerThread extends HandlerThread {
        InnerThread(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (ThreadWithHandler.this.lock) {
                ThreadWithHandler.this.mHandler = new Handler(looper);
            }
            while (!ThreadWithHandler.this.mCacheQueue.isEmpty()) {
                MessageEntity messageEntity = (MessageEntity) ThreadWithHandler.this.mCacheQueue.poll();
                if (messageEntity != null) {
                    ThreadWithHandler.this.mHandler.postDelayed(messageEntity.target, messageEntity.delayMillis);
                }
            }
        }
    }

    private class MessageEntity {
        public long delayMillis;
        public Runnable target;

        public MessageEntity(Runnable runnable, long j2) {
            this.target = runnable;
            this.delayMillis = j2;
        }
    }

    public ThreadWithHandler(String str) {
        this.handlerThread = new InnerThread(str);
    }

    public void post(Runnable runnable) {
        postDelayed(runnable, 0L);
    }

    public void postDelayed(Runnable runnable, long j2) {
        if (this.mHandler == null) {
            synchronized (this.lock) {
                if (this.mHandler == null) {
                    this.mCacheQueue.add(new MessageEntity(runnable, j2));
                    return;
                }
            }
        }
        this.mHandler.postDelayed(runnable, j2);
    }

    public void quit() {
        this.handlerThread.quit();
    }

    public void start() {
        this.handlerThread.start();
    }
}
