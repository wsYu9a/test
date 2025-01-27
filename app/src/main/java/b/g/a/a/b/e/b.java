package b.g.a.a.b.e;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b implements b.g.a.a.b.c {

    /* renamed from: a */
    private final b.g.a.a.b.c f4897a;

    /* renamed from: b */
    private final Comparator<String> f4898b;

    public b(b.g.a.a.b.c cVar, Comparator<String> comparator) {
        this.f4897a = cVar;
        this.f4898b = comparator;
    }

    @Override // b.g.a.a.b.d
    /* renamed from: a */
    public Bitmap get(String str) {
        return this.f4897a.get(str);
    }

    @Override // b.g.a.a.b.d
    /* renamed from: b */
    public boolean put(String str, Bitmap bitmap) {
        synchronized (this.f4897a) {
            String str2 = null;
            Iterator<String> it = this.f4897a.keys().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.f4898b.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.f4897a.remove(str2);
            }
        }
        return this.f4897a.put(str, bitmap);
    }

    @Override // b.g.a.a.b.d
    /* renamed from: c */
    public Bitmap remove(String str) {
        return this.f4897a.remove(str);
    }

    @Override // b.g.a.a.b.d
    public void clear() {
        this.f4897a.clear();
    }

    @Override // b.g.a.a.b.d
    public Collection<String> keys() {
        return this.f4897a.keys();
    }
}
