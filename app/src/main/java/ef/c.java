package ef;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

/* loaded from: classes3.dex */
public class c implements a {

    /* renamed from: a */
    public final String f25901a;

    /* renamed from: b */
    public final af.c f25902b;

    /* renamed from: c */
    public final ViewScaleType f25903c;

    public c(af.c cVar, ViewScaleType viewScaleType) {
        this(null, cVar, viewScaleType);
    }

    @Override // ef.a
    public int getHeight() {
        return this.f25902b.a();
    }

    @Override // ef.a
    public int getId() {
        return TextUtils.isEmpty(this.f25901a) ? super.hashCode() : this.f25901a.hashCode();
    }

    @Override // ef.a
    public ViewScaleType getScaleType() {
        return this.f25903c;
    }

    @Override // ef.a
    public int getWidth() {
        return this.f25902b.b();
    }

    @Override // ef.a
    public View getWrappedView() {
        return null;
    }

    @Override // ef.a
    public boolean isCollected() {
        return false;
    }

    @Override // ef.a
    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }

    @Override // ef.a
    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }

    public c(String str, af.c cVar, ViewScaleType viewScaleType) {
        if (cVar == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (viewScaleType == null) {
            throw new IllegalArgumentException("scaleType must not be null");
        }
        this.f25901a = str;
        this.f25902b = cVar;
        this.f25903c = viewScaleType;
    }
}
