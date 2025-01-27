package b.g.a.a.b.e;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class e implements b.g.a.a.b.c {

    /* renamed from: a */
    private final b.g.a.a.b.c f4903a;

    /* renamed from: b */
    private final long f4904b;

    /* renamed from: c */
    private final Map<String, Long> f4905c = Collections.synchronizedMap(new HashMap());

    public e(b.g.a.a.b.c cVar, long j2) {
        this.f4903a = cVar;
        this.f4904b = j2 * 1000;
    }

    @Override // b.g.a.a.b.d
    /* renamed from: a */
    public Bitmap get(String str) {
        Long l = this.f4905c.get(str);
        if (l != null && System.currentTimeMillis() - l.longValue() > this.f4904b) {
            this.f4903a.remove(str);
            this.f4905c.remove(str);
        }
        return this.f4903a.get(str);
    }

    @Override // b.g.a.a.b.d
    /* renamed from: b */
    public boolean put(String str, Bitmap bitmap) {
        boolean put = this.f4903a.put(str, bitmap);
        if (put) {
            this.f4905c.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return put;
    }

    @Override // b.g.a.a.b.d
    /* renamed from: c */
    public Bitmap remove(String str) {
        this.f4905c.remove(str);
        return this.f4903a.remove(str);
    }

    @Override // b.g.a.a.b.d
    public void clear() {
        this.f4903a.clear();
        this.f4905c.clear();
    }

    @Override // b.g.a.a.b.d
    public Collection<String> keys() {
        return this.f4903a.keys();
    }
}
