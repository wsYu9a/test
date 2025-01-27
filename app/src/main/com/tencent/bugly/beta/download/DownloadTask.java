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
    protected String f22071a;

    /* renamed from: b */
    protected String f22072b;

    /* renamed from: c */
    protected String f22073c;

    /* renamed from: e */
    protected long f22075e;

    /* renamed from: f */
    protected long f22076f;

    /* renamed from: h */
    protected String f22078h;

    /* renamed from: d */
    protected List<DownloadListener> f22074d = new CopyOnWriteArrayList();

    /* renamed from: g */
    protected boolean f22077g = true;

    /* renamed from: i */
    protected int f22079i = 0;

    /* renamed from: j */
    protected int f22080j = 1;

    public DownloadTask(String str, String str2, String str3, String str4) {
        this.f22071a = str;
        this.f22072b = str2;
        this.f22073c = str3;
        this.f22078h = str4;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener == null || this.f22074d.contains(downloadListener)) {
            return;
        }
        this.f22074d.add(downloadListener);
    }

    public abstract void delete(boolean z10);

    public abstract void download();

    public abstract long getCostTime();

    public int getDownloadType() {
        return this.f22080j;
    }

    public String getDownloadUrl() {
        return this.f22071a;
    }

    public String getMD5() {
        return this.f22078h;
    }

    public abstract File getSaveFile();

    public long getSavedLength() {
        return this.f22075e;
    }

    public abstract int getStatus();

    public long getTotalLength() {
        return this.f22076f;
    }

    public boolean isNeededNotify() {
        return this.f22077g;
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return downloadListener != null && this.f22074d.remove(downloadListener);
    }

    public void setDownloadType(int i10) {
        this.f22080j = i10;
    }

    public void setNeededNotify(boolean z10) {
        this.f22077g = z10;
    }

    public void setSavedLength(long j10) {
        this.f22075e = j10;
    }

    public void setTotalLength(long j10) {
        this.f22076f = j10;
    }

    public abstract void stop();
}
