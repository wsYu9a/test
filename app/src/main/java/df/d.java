package df;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import df.c;

/* loaded from: classes3.dex */
public class d extends c {

    public static class a extends c.a {
        public a(Bitmap bitmap, int i10, int i11) {
            super(bitmap, i10, i11);
        }

        @Override // df.c.a, android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RadialGradient radialGradient = new RadialGradient(this.f25547c.centerX(), (this.f25547c.centerY() * 1.0f) / 0.7f, 1.3f * this.f25547c.centerX(), new int[]{0, 0, 2130706432}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, 0.7f);
            radialGradient.setLocalMatrix(matrix);
            this.f25550f.setShader(new ComposeShader(this.f25549e, radialGradient, PorterDuff.Mode.SRC_OVER));
        }
    }

    public d(int i10, int i11) {
        super(i10, i11);
    }

    @Override // df.c, df.a
    public void a(Bitmap bitmap, ef.a aVar, LoadedFrom loadedFrom) {
        if (!(aVar instanceof ef.b)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        aVar.setImageDrawable(new a(bitmap, this.f25543a, this.f25544b));
    }
}
