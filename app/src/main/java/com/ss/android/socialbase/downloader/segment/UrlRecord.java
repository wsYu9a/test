package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

    public UrlRecord(String str, boolean z) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = str;
        this.isMainUrl = z;
        this.ip = null;
        this.ipFamily = null;
    }

    private String getIpFamily(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String getKey() {
        if (this.key == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.url);
            sb.append("_");
            String str = this.ip;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.isMainUrl);
            this.key = sb.toString();
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
        long j2 = this.downloadBytes.get();
        Iterator<SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            j2 += it.next().getReadingBytes();
        }
        return j2;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getKey().hashCode();
        }
        return this.hashCode;
    }

    public void increaseDownloadBytes(long j2) {
        this.downloadBytes.addAndGet(j2);
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
