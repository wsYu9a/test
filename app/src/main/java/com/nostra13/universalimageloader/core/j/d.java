package com.nostra13.universalimageloader.core.j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public abstract class d implements a {

    /* renamed from: a */
    public static final String f16042a = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";

    /* renamed from: b */
    public static final String f16043b = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";

    /* renamed from: c */
    protected Reference<View> f16044c;

    /* renamed from: d */
    protected boolean f16045d;

    public d(View view) {
        this(view, true);
    }

    protected abstract void a(Bitmap bitmap, View view);

    protected abstract void b(Drawable drawable, View view);

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getHeight() {
        View view = this.f16044c.get();
        int i2 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f16045d && layoutParams != null && layoutParams.height != -2) {
            i2 = view.getHeight();
        }
        return (i2 > 0 || layoutParams == null) ? i2 : layoutParams.height;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getId() {
        View view = this.f16044c.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getWidth() {
        View view = this.f16044c.get();
        int i2 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f16045d && layoutParams != null && layoutParams.width != -2) {
            i2 = view.getWidth();
        }
        return (i2 > 0 || layoutParams == null) ? i2 : layoutParams.width;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public View getWrappedView() {
        return this.f16044c.get();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean isCollected() {
        return this.f16044c.get() == null;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean setImageBitmap(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f16044c.get();
            if (view != null) {
                a(bitmap, view);
                return true;
            }
        } else {
            b.g.a.b.d.i("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean setImageDrawable(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f16044c.get();
            if (view != null) {
                b(drawable, view);
                return true;
            }
        } else {
            b.g.a.b.d.i("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    public d(View view, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.f16044c = new WeakReference(view);
        this.f16045d = z;
    }
}
