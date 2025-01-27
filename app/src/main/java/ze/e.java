package ze;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.LoadAndDisplayImageTask;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* loaded from: classes3.dex */
public final class e implements Runnable {

    /* renamed from: f */
    public static final String f33808f = "PostProcess image before displaying [%s]";

    /* renamed from: b */
    public final c f33809b;

    /* renamed from: c */
    public final Bitmap f33810c;

    /* renamed from: d */
    public final d f33811d;

    /* renamed from: e */
    public final Handler f33812e;

    public e(c cVar, Bitmap bitmap, d dVar, Handler handler) {
        this.f33809b = cVar;
        this.f33810c = bitmap;
        this.f33811d = dVar;
        this.f33812e = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        hf.d.a("PostProcess image before displaying [%s]", this.f33811d.f33801b);
        LoadAndDisplayImageTask.s(new b(this.f33811d.f33804e.D().process(this.f33810c), this.f33811d, this.f33809b, LoadedFrom.MEMORY_CACHE), this.f33811d.f33804e.J(), this.f33812e, this.f33809b);
    }
}
