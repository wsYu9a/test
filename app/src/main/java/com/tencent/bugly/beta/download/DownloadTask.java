package com.tencent.bugly.beta.download;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public abstract class DownloadTask {
    public static final int COMPLETE = 1;
    public static final int DELETED = 4;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INIT = 0;
    public static final int PAUSED = 3;
    public static final int TYPE_HOTFIX = 2;
    public static final int TYPE_UPGRADE = 1;

    /* renamed from: a */
    protected String f24592a;

    /* renamed from: b */
    protected String f24593b;

    /* renamed from: c */
    protected String f24594c;

    /* renamed from: e */
    protected long f24596e;

    /* renamed from: f */
    protected long f24597f;

    /* renamed from: h */
    protected String f24599h;

    /* renamed from: d */
    protected List<DownloadListener> f24595d = new CopyOnWriteArrayList();

    /* renamed from: g */
    protected boolean f24598g = true;

    /* renamed from: i */
    protected int f24600i = 0;

    /* renamed from: j */
    protected int f24601j = 1;

    protected DownloadTask(String str, String str2, String str3, String str4) {
        this.f24599h = "";
        this.f24592a = str;
        this.f24593b = str2;
        this.f24594c = str3;
        this.f24599h = str4;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener == null || this.f24595d.contains(downloadListener)) {
            return;
        }
        this.f24595d.add(downloadListener);
    }

    public abstract void delete(boolean z);

    public abstract void download();

    public abstract long getCostTime();

    public int getDownloadType() {
        return this.f24601j;
    }

    public String getDownloadUrl() {
        return this.f24592a;
    }

    public String getMD5() {
        return this.f24599h;
    }

    public abstract File getSaveFile();

    public long getSavedLength() {
        return this.f24596e;
    }

    public abstract int getStatus();

    public long getTotalLength() {
        return this.f24597f;
    }

    public boolean isNeededNotify() {
        return this.f24598g;
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return downloadListener != null && this.f24595d.remove(downloadListener);
    }

    public void setDownloadType(int i2) {
        this.f24601j = i2;
    }

    public void setNeededNotify(boolean z) {
        this.f24598g = z;
    }

    public void setSavedLength(long j2) {
        this.f24596e = j2;
    }

    public void setTotalLength(long j2) {
        this.f24597f = j2;
    }

    public abstract void stop();
}
