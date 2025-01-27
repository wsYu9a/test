package com.vivo.google.android.exoplayer3.upstream.cache;

import android.os.ConditionVariable;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.a6;
import com.vivo.google.android.exoplayer3.b6;
import com.vivo.google.android.exoplayer3.c6;
import com.vivo.google.android.exoplayer3.d6;
import com.vivo.google.android.exoplayer3.e6;
import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.y5;
import com.vivo.google.android.exoplayer3.z5;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public final class SimpleCache implements y5 {
    public final File cacheDir;
    public final z5 evictor;
    public final c6 index;
    public y5.a initializationException;
    public final HashMap<String, ArrayList<y5.b>> listeners;
    public final HashMap<String, a6> lockedSpans;
    public long totalSpace;

    public class a extends Thread {

        /* renamed from: a */
        public final /* synthetic */ ConditionVariable f28146a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f28146a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (SimpleCache.this) {
                this.f28146a.open();
                try {
                    SimpleCache.this.initialize();
                } catch (y5.a e2) {
                    SimpleCache.this.initializationException = e2;
                }
                SimpleCache.this.evictor.onCacheInitialized();
            }
        }
    }

    public SimpleCache(File file, z5 z5Var) {
        this(file, z5Var, null);
    }

    public SimpleCache(File file, z5 z5Var, byte[] bArr) {
        this.totalSpace = 0L;
        this.cacheDir = file;
        this.evictor = z5Var;
        this.lockedSpans = new HashMap<>();
        this.index = new c6(file, bArr);
        this.listeners = new HashMap<>();
        ConditionVariable conditionVariable = new ConditionVariable();
        new a("SimpleCache.initialize()", conditionVariable).start();
        conditionVariable.block();
    }

    private void addSpan(d6 d6Var) {
        c6 c6Var = this.index;
        String str = d6Var.f27149a;
        b6 b6Var = c6Var.f27258a.get(str);
        if (b6Var == null) {
            b6Var = c6Var.a(str, -1L);
        }
        b6Var.f27229c.add(d6Var);
        this.totalSpace += d6Var.f27151c;
        notifySpanAdded(d6Var);
    }

    private d6 getSpan(String str, long j2) {
        d6 a2;
        b6 b6Var = this.index.f27258a.get(str);
        if (b6Var == null) {
            return new d6(str, j2, -1L, C.TIME_UNSET, null);
        }
        while (true) {
            a2 = b6Var.a(j2);
            if (!a2.f27152d || a2.f27153e.exists()) {
                break;
            }
            removeStaleSpansAndCachedContents();
        }
        return a2;
    }

    public void initialize() {
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
            return;
        }
        c6 c6Var = this.index;
        g1.b(!c6Var.f27263f);
        if (!c6Var.a()) {
            e6 e6Var = c6Var.f27260c;
            e6Var.f27398a.delete();
            e6Var.f27399b.delete();
            c6Var.f27258a.clear();
            c6Var.f27259b.clear();
        }
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (!file.getName().equals("cached_content_index.exi")) {
                d6 a2 = file.length() > 0 ? d6.a(file, this.index) : null;
                if (a2 != null) {
                    addSpan(a2);
                } else {
                    file.delete();
                }
            }
        }
        this.index.b();
        this.index.c();
    }

    private void notifySpanAdded(d6 d6Var) {
        ArrayList<y5.b> arrayList = this.listeners.get(d6Var.f27149a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanAdded(this, d6Var);
            }
        }
        this.evictor.onSpanAdded(this, d6Var);
    }

    private void notifySpanRemoved(a6 a6Var) {
        ArrayList<y5.b> arrayList = this.listeners.get(a6Var.f27149a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanRemoved(this, a6Var);
            }
        }
        this.evictor.onSpanRemoved(this, a6Var);
    }

    private void notifySpanTouched(d6 d6Var, a6 a6Var) {
        ArrayList<y5.b> arrayList = this.listeners.get(d6Var.f27149a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanTouched(this, d6Var, a6Var);
            }
        }
        this.evictor.onSpanTouched(this, d6Var, a6Var);
    }

    private void removeSpan(a6 a6Var, boolean z) {
        boolean z2;
        b6 a2 = this.index.a(a6Var.f27149a);
        if (a2 != null) {
            if (a2.f27229c.remove(a6Var)) {
                a6Var.f27153e.delete();
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.totalSpace -= a6Var.f27151c;
                if (z && a2.f27229c.isEmpty()) {
                    this.index.b(a2.f27228b);
                    this.index.c();
                }
                notifySpanRemoved(a6Var);
            }
        }
    }

    private void removeStaleSpansAndCachedContents() {
        LinkedList linkedList = new LinkedList();
        Iterator<b6> it = this.index.f27258a.values().iterator();
        while (it.hasNext()) {
            Iterator<d6> it2 = it.next().f27229c.iterator();
            while (it2.hasNext()) {
                d6 next = it2.next();
                if (!next.f27153e.exists()) {
                    linkedList.add(next);
                }
            }
        }
        Iterator it3 = linkedList.iterator();
        while (it3.hasNext()) {
            removeSpan((a6) it3.next(), false);
        }
        this.index.b();
        this.index.c();
    }

    public synchronized NavigableSet<a6> addListener(String str, y5.b bVar) {
        ArrayList<y5.b> arrayList = this.listeners.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.listeners.put(str, arrayList);
        }
        arrayList.add(bVar);
        return getCachedSpans(str);
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized void commitFile(File file) {
        d6 a2 = d6.a(file, this.index);
        boolean z = true;
        g1.b(a2 != null);
        g1.b(this.lockedSpans.containsKey(a2.f27149a));
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            Long valueOf = Long.valueOf(getContentLength(a2.f27149a));
            if (valueOf.longValue() != -1) {
                if (a2.f27150b + a2.f27151c > valueOf.longValue()) {
                    z = false;
                }
                g1.b(z);
            }
            addSpan(a2);
            this.index.c();
            notifyAll();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized long getCacheSpace() {
        return this.totalSpace;
    }

    public synchronized long getCachedBytes(String str, long j2, long j3) {
        b6 b6Var;
        b6Var = this.index.f27258a.get(str);
        return b6Var != null ? b6Var.a(j2, j3) : -j3;
    }

    public synchronized NavigableSet<a6> getCachedSpans(String str) {
        b6 b6Var;
        b6Var = this.index.f27258a.get(str);
        return b6Var == null ? null : new TreeSet((Collection) b6Var.f27229c);
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized long getContentLength(String str) {
        b6 b6Var;
        b6Var = this.index.f27258a.get(str);
        return b6Var == null ? -1L : b6Var.f27230d;
    }

    public synchronized Set<String> getKeys() {
        return new HashSet(this.index.f27258a.keySet());
    }

    public synchronized boolean isCached(String str, long j2, long j3) {
        boolean z;
        b6 b6Var = this.index.f27258a.get(str);
        if (b6Var != null) {
            z = b6Var.a(j2, j3) >= j3;
        }
        return z;
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized void releaseHoleSpan(a6 a6Var) {
        g1.b(a6Var == this.lockedSpans.remove(a6Var.f27149a));
        notifyAll();
    }

    public synchronized void removeListener(String str, y5.b bVar) {
        ArrayList<y5.b> arrayList = this.listeners.get(str);
        if (arrayList != null) {
            arrayList.remove(bVar);
            if (arrayList.isEmpty()) {
                this.listeners.remove(str);
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized void removeSpan(a6 a6Var) {
        removeSpan(a6Var, true);
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized void setContentLength(String str, long j2) {
        c6 c6Var = this.index;
        b6 b6Var = c6Var.f27258a.get(str);
        if (b6Var == null) {
            c6Var.a(str, j2);
        } else if (b6Var.f27230d != j2) {
            b6Var.f27230d = j2;
            c6Var.f27263f = true;
        }
        this.index.c();
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized File startFile(String str, long j2, long j3) {
        File file;
        b6 b6Var;
        g1.b(this.lockedSpans.containsKey(str));
        if (!this.cacheDir.exists()) {
            removeStaleSpansAndCachedContents();
            this.cacheDir.mkdirs();
        }
        this.evictor.onStartFile(this, str, j2, j3);
        file = this.cacheDir;
        c6 c6Var = this.index;
        b6Var = c6Var.f27258a.get(str);
        if (b6Var == null) {
            b6Var = c6Var.a(str, -1L);
        }
        return d6.a(file, b6Var.f27227a, j2, System.currentTimeMillis());
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized d6 startReadWrite(String str, long j2) {
        d6 startReadWriteNonBlocking;
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j2);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    @Override // com.vivo.google.android.exoplayer3.y5
    public synchronized d6 startReadWriteNonBlocking(String str, long j2) {
        y5.a aVar = this.initializationException;
        if (aVar != null) {
            throw aVar;
        }
        d6 span = getSpan(str, j2);
        if (!span.f27152d) {
            if (this.lockedSpans.containsKey(str)) {
                return null;
            }
            this.lockedSpans.put(str, span);
            return span;
        }
        b6 b6Var = this.index.f27258a.get(str);
        g1.b(b6Var.f27229c.remove(span));
        int i2 = b6Var.f27227a;
        g1.b(span.f27152d);
        long currentTimeMillis = System.currentTimeMillis();
        d6 d6Var = new d6(span.f27149a, span.f27150b, span.f27151c, currentTimeMillis, d6.a(span.f27153e.getParentFile(), i2, span.f27150b, currentTimeMillis));
        if (span.f27153e.renameTo(d6Var.f27153e)) {
            b6Var.f27229c.add(d6Var);
            notifySpanTouched(span, d6Var);
            return d6Var;
        }
        throw new y5.a("Renaming of " + span.f27153e + " to " + d6Var.f27153e + " failed.");
    }
}
