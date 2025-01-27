package com.ksad.download;

/* loaded from: classes.dex */
public abstract class a {
    protected int mTaskId;

    public abstract void a(DownloadTask downloadTask);

    public abstract void a(DownloadTask downloadTask, int i2, int i3);

    public abstract void a(DownloadTask downloadTask, Throwable th);

    public abstract void b(DownloadTask downloadTask);

    public abstract void c(DownloadTask downloadTask);

    public abstract void d(DownloadTask downloadTask);

    public abstract void e(DownloadTask downloadTask);

    public abstract void f(DownloadTask downloadTask);

    public final void setId(int i2) {
        this.mTaskId = i2;
    }
}
