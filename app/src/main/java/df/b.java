package df;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a */
    public final int f25539a;

    /* renamed from: b */
    public final boolean f25540b;

    /* renamed from: c */
    public final boolean f25541c;

    /* renamed from: d */
    public final boolean f25542d;

    public b(int i10) {
        this(i10, true, true, true);
    }

    public static void b(View view, int i10) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i10);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaAnimation);
        }
    }

    @Override // df.a
    public void a(Bitmap bitmap, ef.a aVar, LoadedFrom loadedFrom) {
        aVar.setImageBitmap(bitmap);
        if ((this.f25540b && loadedFrom == LoadedFrom.NETWORK) || ((this.f25541c && loadedFrom == LoadedFrom.DISC_CACHE) || (this.f25542d && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
            b(aVar.getWrappedView(), this.f25539a);
        }
    }

    public b(int i10, boolean z10, boolean z11, boolean z12) {
        this.f25539a = i10;
        this.f25540b = z10;
        this.f25541c = z11;
        this.f25542d = z12;
    }
}
