package b.g.a.a.b.e;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends b.g.a.a.b.b {

    /* renamed from: g */
    private final List<Bitmap> f4896g;

    public a(int i2) {
        super(i2);
        this.f4896g = Collections.synchronizedList(new LinkedList());
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
        this.f4896g.add(bitmap);
        return true;
    }

    @Override // b.g.a.a.b.b, b.g.a.a.b.a, b.g.a.a.b.d
    public void clear() {
        this.f4896g.clear();
        super.clear();
    }

    @Override // b.g.a.a.b.b, b.g.a.a.b.a, b.g.a.a.b.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.f4896g.remove(bitmap);
        }
        return super.remove(str);
    }

    @Override // b.g.a.a.b.b
    protected int e(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // b.g.a.a.b.b
    protected Bitmap g() {
        return this.f4896g.remove(0);
    }
}
