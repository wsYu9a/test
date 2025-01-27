package com.nostra13.universalimageloader.core.i;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.i.c;

/* loaded from: classes4.dex */
public class d extends c {

    protected static class a extends c.a {
        a(Bitmap bitmap, int i2, int i3) {
            super(bitmap, i2, i3);
        }

        @Override // com.nostra13.universalimageloader.core.i.c.a, android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RadialGradient radialGradient = new RadialGradient(this.f16035c.centerX(), (this.f16035c.centerY() * 1.0f) / 0.7f, 1.3f * this.f16035c.centerX(), new int[]{0, 0, 2130706432}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, 0.7f);
            radialGradient.setLocalMatrix(matrix);
            this.f16038f.setShader(new ComposeShader(this.f16037e, radialGradient, PorterDuff.Mode.SRC_OVER));
        }
    }

    public d(int i2, int i3) {
        super(i2, i3);
    }

    @Override // com.nostra13.universalimageloader.core.i.c, com.nostra13.universalimageloader.core.i.a
    public void a(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom) {
        if (!(aVar instanceof com.nostra13.universalimageloader.core.j.b)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        aVar.setImageDrawable(new a(bitmap, this.f16031a, this.f16032b));
    }
}
