package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import hf.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p1.b;

/* loaded from: classes4.dex */
class UrlRecord {
    private final AtomicLong downloadBytes;
    private int failedTimes;
    private int hashCode;
    final String ip;
    final String ipFamily;
    private boolean isCurrentFailed;
    final boolean isMainUrl;
    private String key;
    private final List<SegmentReader> readers;
    final String url;

    public UrlRecord(String str, boolean z10) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = str;
        this.isMainUrl = z10;
        this.ip = null;
        this.ipFamily = null;
    }

    private String getIpFamily(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(b.f29697h);
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private String getKey() {
        if (this.key == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.url);
            sb2.append(e.f26694a);
            String str = this.ip;
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            sb2.append(e.f26694a);
            sb2.append(this.isMainUrl);
            this.key = sb2.toString();
        }
        return this.key;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UrlRecord) {
            return getKey().equals(((UrlRecord) obj).getKey());
        }
        return false;
    }

    public synchronized int getCurrentUsers() {
        return this.readers.size();
    }

    public long getDownloadBytes() {
        long j10 = this.downloadBytes.get();
        Iterator<SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            j10 += it.next().getReadingBytes();
        }
        return j10;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getKey().hashCode();
        }
        return this.hashCode;
    }

    public void increaseDownloadBytes(long j10) {
        this.downloadBytes.addAndGet(j10);
    }

    public synchronized boolean isCurrentFailed() {
        return this.isCurrentFailed;
    }

    public synchronized void recordFailed() {
        this.failedTimes++;
        this.isCurrentFailed = true;
    }

    public synchronized void recordSucceed() {
        this.isCurrentFailed = false;
    }

    public synchronized void recordUnUse(SegmentReader segmentReader) {
        try {
            this.readers.remove(segmentReader);
        } catch (Throwable unused) {
        }
    }

    public synchronized void recordUse(SegmentReader segmentReader) {
        this.readers.add(segmentReader);
    }

    public String toString() {
        return "UrlRecord{url='" + this.url + "', ip='" + this.ip + "', ipFamily='" + this.ipFamily + "', isMainUrl=" + this.isMainUrl + ", failedTimes=" + this.failedTimes + ", isCurrentFailed=" + this.isCurrentFailed + '}';
    }

    public UrlRecord(String str, String str2) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = str;
        this.isMainUrl = false;
        this.ip = str2;
        this.ipFamily = getIpFamily(str2);
    }
}
