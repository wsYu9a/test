package ef;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class b extends d {
    public b(ImageView imageView) {
        super(imageView);
    }

    public static int c(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e10) {
            hf.d.d(e10);
            return 0;
        }
    }

    @Override // ef.d
    public void a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // ef.d
    public void b(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // ef.d, ef.a
    /* renamed from: d */
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }

    @Override // ef.d, ef.a
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        return (height > 0 || (imageView = (ImageView) this.f25906a.get()) == null) ? height : c(imageView, "mMaxHeight");
    }

    @Override // ef.d, ef.a
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.f25906a.get();
        return imageView != null ? ViewScaleType.fromImageView(imageView) : super.getScaleType();
    }

    @Override // ef.d, ef.a
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        return (width > 0 || (imageView = (ImageView) this.f25906a.get()) == null) ? width : c(imageView, "mMaxWidth");
    }

    public b(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
