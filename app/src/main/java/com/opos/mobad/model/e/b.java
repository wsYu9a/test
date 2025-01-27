package com.opos.mobad.model.e;

import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private Map<String, Long> f21748a = new ConcurrentHashMap();

    /* renamed from: b */
    private Map<String, Integer> f21749b = new ConcurrentHashMap();

    public void a(String str) {
        this.f21748a.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public void a(String str, int i2) {
        this.f21749b.put(str, Integer.valueOf(i2));
    }

    public boolean b(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.f21748a.get(str);
        long longValue = l != null ? l.longValue() : 0L;
        Integer num = this.f21749b.get(str);
        return elapsedRealtime >= ((long) Integer.valueOf(num != null ? num.intValue() : 0).intValue()) + Long.valueOf(longValue).longValue();
    }
}
