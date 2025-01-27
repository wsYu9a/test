package ef;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public abstract class d implements a {

    /* renamed from: c */
    public static final String f25904c = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";

    /* renamed from: d */
    public static final String f25905d = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";

    /* renamed from: a */
    public Reference<View> f25906a;

    /* renamed from: b */
    public boolean f25907b;

    public d(View view) {
        this(view, true);
    }

    public abstract void a(Bitmap bitmap, View view);

    public abstract void b(Drawable drawable, View view);

    @Override // ef.a
    public int getHeight() {
        View view = this.f25906a.get();
        int i10 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f25907b && layoutParams != null && layoutParams.height != -2) {
            i10 = view.getHeight();
        }
        return (i10 > 0 || layoutParams == null) ? i10 : layoutParams.height;
    }

    @Override // ef.a
    public int getId() {
        View view = this.f25906a.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    @Override // ef.a
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    @Override // ef.a
    public int getWidth() {
        View view = this.f25906a.get();
        int i10 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f25907b && layoutParams != null && layoutParams.width != -2) {
            i10 = view.getWidth();
        }
        return (i10 > 0 || layoutParams == null) ? i10 : layoutParams.width;
    }

    @Override // ef.a
    public View getWrappedView() {
        return this.f25906a.get();
    }

    @Override // ef.a
    public boolean isCollected() {
        return this.f25906a.get() == null;
    }

    @Override // ef.a
    public boolean setImageBitmap(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f25906a.get();
            if (view != null) {
                a(bitmap, view);
                return true;
            }
        } else {
            hf.d.i("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    @Override // ef.a
    public boolean setImageDrawable(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f25906a.get();
            if (view != null) {
                b(drawable, view);
                return true;
            }
        } else {
            hf.d.i("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    public d(View view, boolean z10) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.f25906a = new WeakReference(view);
        this.f25907b = z10;
    }
}
