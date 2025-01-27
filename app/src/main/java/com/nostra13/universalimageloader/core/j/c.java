package com.nostra13.universalimageloader.core.j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a */
    protected final String f16039a;

    /* renamed from: b */
    protected final com.nostra13.universalimageloader.core.assist.c f16040b;

    /* renamed from: c */
    protected final ViewScaleType f16041c;

    public c(com.nostra13.universalimageloader.core.assist.c cVar, ViewScaleType viewScaleType) {
        this(null, cVar, viewScaleType);
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getHeight() {
        return this.f16040b.a();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getId() {
        return TextUtils.isEmpty(this.f16039a) ? super.hashCode() : this.f16039a.hashCode();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public ViewScaleType getScaleType() {
        return this.f16041c;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getWidth() {
        return this.f16040b.b();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public View getWrappedView() {
        return null;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean isCollected() {
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }

    public c(String str, com.nostra13.universalimageloader.core.assist.c cVar, ViewScaleType viewScaleType) {
        if (cVar == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (viewScaleType == null) {
            throw new IllegalArgumentException("scaleType must not be null");
        }
        this.f16039a = str;
        this.f16040b = cVar;
        this.f16041c = viewScaleType;
    }
}
