package ye;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class a extends xe.b {

    /* renamed from: g */
    public final List<Bitmap> f33489g;

    public a(int i10) {
        super(i10);
        this.f33489g = Collections.synchronizedList(new LinkedList());
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
        this.f33489g.add(bitmap);
        return true;
    }

    @Override // xe.b, xe.a, xe.d
    public void clear() {
        this.f33489g.clear();
        super.clear();
    }

    @Override // xe.b, xe.a, xe.d
    /* renamed from: d */
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.f33489g.remove(bitmap);
        }
        return super.remove(str);
    }

    @Override // xe.b
    public int e(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // xe.b
    public Bitmap g() {
        return this.f33489g.remove(0);
    }
}
