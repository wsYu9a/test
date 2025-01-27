package ye;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class e implements xe.c {

    /* renamed from: a */
    public final xe.c f33496a;

    /* renamed from: b */
    public final long f33497b;

    /* renamed from: c */
    public final Map<String, Long> f33498c = Collections.synchronizedMap(new HashMap());

    public e(xe.c cVar, long j10) {
        this.f33496a = cVar;
        this.f33497b = j10 * 1000;
    }

    @Override // xe.d
    /* renamed from: a */
    public Bitmap get(String str) {
        Long l10 = this.f33498c.get(str);
        if (l10 != null && System.currentTimeMillis() - l10.longValue() > this.f33497b) {
            this.f33496a.remove(str);
            this.f33498c.remove(str);
        }
        return this.f33496a.get(str);
    }

    @Override // xe.d
    /* renamed from: b */
    public boolean put(String str, Bitmap bitmap) {
        boolean put = this.f33496a.put(str, bitmap);
        if (put) {
            this.f33498c.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return put;
    }

    @Override // xe.d
    /* renamed from: c */
    public Bitmap remove(String str) {
        this.f33498c.remove(str);
        return this.f33496a.remove(str);
    }

    @Override // xe.d
    public void clear() {
        this.f33496a.clear();
        this.f33498c.clear();
    }

    @Override // xe.d
    public Collection<String> keys() {
        return this.f33496a.keys();
    }
}
