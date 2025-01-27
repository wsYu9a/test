package xe;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class a implements c {

    /* renamed from: a */
    public final Map<String, Reference<Bitmap>> f32001a = Collections.synchronizedMap(new HashMap());

    public abstract Reference<Bitmap> a(Bitmap bitmap);

    @Override // xe.d
    /* renamed from: b */
    public Bitmap get(String str) {
        Reference<Bitmap> reference = this.f32001a.get(str);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // xe.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        this.f32001a.put(str, a(bitmap));
        return true;
    }

    @Override // xe.d
    public void clear() {
        this.f32001a.clear();
    }

    @Override // xe.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Reference<Bitmap> remove = this.f32001a.remove(str);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    @Override // xe.d
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this.f32001a) {
            hashSet = new HashSet(this.f32001a.keySet());
        }
        return hashSet;
    }
}
