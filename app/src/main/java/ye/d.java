package ye;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class d extends xe.b {

    /* renamed from: g */
    public final Map<Bitmap, Integer> f33495g;

    public d(int i10) {
        super(i10);
        this.f33495g = Collections.synchronizedMap(new HashMap());
    }

    @Override // xe.a
    public Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // xe.b, xe.a, xe.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.f33495g.put(bitmap, Integer.valueOf(e(bitmap)));
        return true;
    }

    @Override // xe.b, xe.a, xe.d
    public void clear() {
        this.f33495g.clear();
        super.clear();
    }

    @Override // xe.b, xe.a, xe.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.f33495g.remove(bitmap);
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
        Set<Map.Entry<Bitmap, Integer>> entrySet = this.f33495g.entrySet();
        synchronized (this.f33495g) {
            try {
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
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f33495g.remove(bitmap);
        return bitmap;
    }
}
