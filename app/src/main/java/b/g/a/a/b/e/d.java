package b.g.a.a.b.e;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class d extends b.g.a.a.b.b {

    /* renamed from: g */
    private final Map<Bitmap, Integer> f4902g;

    public d(int i2) {
        super(i2);
        this.f4902g = Collections.synchronizedMap(new HashMap());
    }

    @Override // b.g.a.a.b.a
    protected Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // b.g.a.a.b.b, b.g.a.a.b.a, b.g.a.a.b.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.f4902g.put(bitmap, Integer.valueOf(e(bitmap)));
        return true;
    }

    @Override // b.g.a.a.b.b, b.g.a.a.b.a, b.g.a.a.b.d
    public void clear() {
        this.f4902g.clear();
        super.clear();
    }

    @Override // b.g.a.a.b.b, b.g.a.a.b.a, b.g.a.a.b.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.f4902g.remove(bitmap);
        }
        return super.remove(str);
    }

    @Override // b.g.a.a.b.b
    protected int e(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // b.g.a.a.b.b
    protected Bitmap g() {
        Bitmap bitmap;
        Set<Map.Entry<Bitmap, Integer>> entrySet = this.f4902g.entrySet();
        synchronized (this.f4902g) {
            bitmap = null;
            Integer num = null;
            for (Map.Entry<Bitmap, Integer> entry : entrySet) {
                if (bitmap == null) {
                    bitmap = entry.getKey();
                    num = entry.getValue();
                } else {
                    Integer value = entry.getValue();
                    if (value.intValue() > num.intValue()) {
                        bitmap = entry.getKey();
                        num = value;
                    }
                }
            }
        }
        this.f4902g.remove(bitmap);
        return bitmap;
    }
}
