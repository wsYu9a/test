package b.g.a.a.b.e;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class h extends b.g.a.a.b.a {
    @Override // b.g.a.a.b.a
    protected Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
