package ze;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: j */
    public static final String f33777j = "Display image in ImageAware (loaded from %1$s) [%2$s]";

    /* renamed from: k */
    public static final String f33778k = "ImageAware is reused for another image. Task is cancelled. [%s]";

    /* renamed from: l */
    public static final String f33779l = "ImageAware was collected by GC. Task is cancelled. [%s]";

    /* renamed from: b */
    public final Bitmap f33780b;

    /* renamed from: c */
    public final String f33781c;

    /* renamed from: d */
    public final ef.a f33782d;

    /* renamed from: e */
    public final String f33783e;

    /* renamed from: f */
    public final df.a f33784f;

    /* renamed from: g */
    public final ff.a f33785g;

    /* renamed from: h */
    public final c f33786h;

    /* renamed from: i */
    public final LoadedFrom f33787i;

    public b(Bitmap bitmap, d dVar, c cVar, LoadedFrom loadedFrom) {
        this.f33780b = bitmap;
        this.f33781c = dVar.f33800a;
        this.f33782d = dVar.f33802c;
        this.f33783e = dVar.f33801b;
        this.f33784f = dVar.f33804e.w();
        this.f33785g = dVar.f33805f;
        this.f33786h = cVar;
        this.f33787i = loadedFrom;
    }

    public final boolean a() {
        return !this.f33783e.equals(this.f33786h.h(this.f33782d));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f33782d.isCollected()) {
            hf.d.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f33783e);
            this.f33785g.onLoadingCancelled(this.f33781c, this.f33782d.getWrappedView());
        } else if (a()) {
            hf.d.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f33783e);
            this.f33785g.onLoadingCancelled(this.f33781c, this.f33782d.getWrappedView());
        } else {
            hf.d.a(f33777j, this.f33787i, this.f33783e);
            this.f33784f.a(this.f33780b, this.f33782d, this.f33787i);
            this.f33786h.d(this.f33782d);
            this.f33785g.onLoadingComplete(this.f33781c, this.f33782d.getWrappedView(), this.f33780b);
        }
    }
}
