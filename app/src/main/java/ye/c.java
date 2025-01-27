package ye;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class c extends xe.b {

    /* renamed from: h */
    public static final int f33492h = 10;

    /* renamed from: i */
    public static final float f33493i = 1.1f;

    /* renamed from: g */
    public final Map<String, Bitmap> f33494g;

    public c(int i10) {
        super(i10);
        this.f33494g = Collections.synchronizedMap(new LinkedHashMap(10, 1.1f, true));
    }

    @Override // xe.a
    public Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // xe.a, xe.d
    /* renamed from: b */
    public Bitmap get(String str) {
        this.f33494g.get(str);
        return super.get(str);
    }

    @Override // xe.b, xe.a, xe.d
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.f33494g.put(str, bitmap);
        return true;
    }

    @Override // xe.b, xe.a, xe.d
    public void clear() {
        this.f33494g.clear();
        super.clear();
    }

    @Override // xe.b, xe.a, xe.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        this.f33494g.remove(str);
        return super.remove(str);
    }

    @Override // xe.b
    public int e(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // xe.b
    public Bitmap g() {
        Bitmap bitmap;
        synchronized (this.f33494g) {
            try {
                Iterator<Map.Entry<String, Bitmap>> it = this.f33494g.entrySet().iterator();
                if (it.hasNext()) {
                    bitmap = it.next().getValue();
                    it.remove();
                } else {
                    bitmap = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bitmap;
    }
}
