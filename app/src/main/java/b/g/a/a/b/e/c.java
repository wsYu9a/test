package b.g.a.a.b.e;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class c extends b.g.a.a.b.b {

    /* renamed from: g */
    private static final int f4899g = 10;

    /* renamed from: h */
    private static final float f4900h = 1.1f;

    /* renamed from: i */
    private final Map<String, Bitmap> f4901i;

    public c(int i2) {
        super(i2);
        this.f4901i = Collections.synchronizedMap(new LinkedHashMap(10, f4900h, true));
    }

    @Override // b.g.a.a.b.a
    protected Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // b.g.a.a.b.a, b.g.a.a.b.d
    /* renamed from: b */
    public Bitmap get(String str) {
        this.f4901i.get(str);
        return super.get(str);
    }

    @Override // b.g.a.a.b.b, b.g.a.a.b.a, b.g.a.a.b.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.f4901i.put(str, bitmap);
        return true;
    }

    @Override // b.g.a.a.b.b, b.g.a.a.b.a, b.g.a.a.b.d
    public void clear() {
        this.f4901i.clear();
        super.clear();
    }

    @Override // b.g.a.a.b.b, b.g.a.a.b.a, b.g.a.a.b.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        this.f4901i.remove(str);
        return super.remove(str);
    }

    @Override // b.g.a.a.b.b
    protected int e(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // b.g.a.a.b.b
    protected Bitmap g() {
        Bitmap bitmap;
        synchronized (this.f4901i) {
            Iterator<Map.Entry<String, Bitmap>> it = this.f4901i.entrySet().iterator();
            if (it.hasNext()) {
                bitmap = it.next().getValue();
                it.remove();
            } else {
                bitmap = null;
            }
        }
        return bitmap;
    }
}
