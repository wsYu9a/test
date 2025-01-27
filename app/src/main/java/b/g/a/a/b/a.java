package b.g.a.a.b;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class a implements c {

    /* renamed from: a */
    private final Map<String, Reference<Bitmap>> f4890a = Collections.synchronizedMap(new HashMap());

    protected abstract Reference<Bitmap> a(Bitmap bitmap);

    @Override // b.g.a.a.b.d
    /* renamed from: b */
    public Bitmap get(String str) {
        Reference<Bitmap> reference = this.f4890a.get(str);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // b.g.a.a.b.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        this.f4890a.put(str, a(bitmap));
        return true;
    }

    @Override // b.g.a.a.b.d
    public void clear() {
        this.f4890a.clear();
    }

    @Override // b.g.a.a.b.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Reference<Bitmap> remove = this.f4890a.remove(str);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    @Override // b.g.a.a.b.d
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this.f4890a) {
            hashSet = new HashSet(this.f4890a.keySet());
        }
        return hashSet;
    }
}
