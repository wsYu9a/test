package ye;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class g extends xe.b {

    /* renamed from: g */
    public final Map<Bitmap, Integer> f33502g;

    public g(int i10) {
        super(i10);
        this.f33502g = Collections.synchronizedMap(new HashMap());
    }

    @Override // xe.a
    public Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // xe.a, xe.d
    /* renamed from: b */
    public Bitmap get(String str) {
        Integer num;
        Bitmap bitmap = super.get(str);
        if (bitmap != null && (num = this.f33502g.get(bitmap)) != null) {
            this.f33502g.put(bitmap, Integer.valueOf(num.intValue() + 1));
        }
        return bitmap;
    }

    @Override // xe.b, xe.a, xe.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.f33502g.put(bitmap, 0);
        return true;
    }

    @Override // xe.b, xe.a, xe.d
    public void clear() {
        this.f33502g.clear();
        super.clear();
    }

    @Override // xe.b, xe.a, xe.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.f33502g.remove(bitmap);
        }
        return super.remove(str);
    }

    @Override // xe.b
    public int e(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // xe.b
    public Bitmap g() {
        Bitmap bitmap;
        Set<Map.Entry<Bitmap, Integer>> entrySet = this.f33502g.entrySet();
        synchronized (this.f33502g) {
            try {
                bitmap = null;
                Integer num = null;
                for (Map.Entry<Bitmap, Integer> entry : entrySet) {
                    if (bitmap == null) {
                        bitmap = entry.getKey();
                        num = entry.getValue();
                    } else {
                        Integer value = entry.getValue();
                        if (value.intValue() < num.intValue()) {
                            bitmap = entry.getKey();
                            num = value;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f33502g.remove(bitmap);
        return bitmap;
    }
}
