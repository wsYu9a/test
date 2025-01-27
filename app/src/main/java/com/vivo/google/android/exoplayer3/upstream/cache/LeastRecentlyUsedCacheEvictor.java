package com.vivo.google.android.exoplayer3.upstream.cache;

import com.vivo.google.android.exoplayer3.a6;
import com.vivo.google.android.exoplayer3.y5;
import com.vivo.google.android.exoplayer3.z5;
import java.util.Comparator;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public final class LeastRecentlyUsedCacheEvictor implements z5, Comparator<a6> {
    public long currentSize;
    public final TreeSet<a6> leastRecentlyUsed = new TreeSet<>(this);
    public final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long j2) {
        this.maxBytes = j2;
    }

    private void evictCache(y5 y5Var, long j2) {
        while (this.currentSize + j2 > this.maxBytes) {
            try {
                y5Var.removeSpan(this.leastRecentlyUsed.first());
            } catch (y5.a unused) {
            }
        }
    }

    @Override // java.util.Comparator
    public int compare(a6 a6Var, a6 a6Var2) {
        long j2 = a6Var.f27154f;
        long j3 = a6Var2.f27154f;
        return j2 - j3 == 0 ? a6Var.compareTo(a6Var2) : j2 < j3 ? -1 : 1;
    }

    @Override // com.vivo.google.android.exoplayer3.z5
    public void onCacheInitialized() {
    }

    @Override // com.vivo.google.android.exoplayer3.y5.b
    public void onSpanAdded(y5 y5Var, a6 a6Var) {
        this.leastRecentlyUsed.add(a6Var);
        this.currentSize += a6Var.f27151c;
        evictCache(y5Var, 0L);
    }

    @Override // com.vivo.google.android.exoplayer3.y5.b
    public void onSpanRemoved(y5 y5Var, a6 a6Var) {
        this.leastRecentlyUsed.remove(a6Var);
        this.currentSize -= a6Var.f27151c;
    }

    @Override // com.vivo.google.android.exoplayer3.y5.b
    public void onSpanTouched(y5 y5Var, a6 a6Var, a6 a6Var2) {
        onSpanRemoved(y5Var, a6Var);
        onSpanAdded(y5Var, a6Var2);
    }

    @Override // com.vivo.google.android.exoplayer3.z5
    public void onStartFile(y5 y5Var, String str, long j2, long j3) {
        evictCache(y5Var, j3);
    }
}
