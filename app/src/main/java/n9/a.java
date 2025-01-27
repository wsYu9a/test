package n9;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class a extends BitmapDrawable {

    /* renamed from: a */
    public final WeakReference<b> f28801a;

    /* renamed from: b */
    public String f28802b;

    public a(Resources resources, Bitmap bitmap, b bVar) {
        super(resources, bitmap);
        this.f28802b = null;
        this.f28801a = new WeakReference<>(bVar);
        if (bVar != null) {
            this.f28802b = bVar.e();
        }
    }

    public b a() {
        return this.f28801a.get();
    }

    public String b() {
        return this.f28802b;
    }
}
