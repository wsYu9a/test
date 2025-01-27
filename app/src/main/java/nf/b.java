package nf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.ImageView;
import androidx.annotation.ColorInt;

@SuppressLint({"ViewConstructor", "AppCompatCustomView"})
/* loaded from: classes3.dex */
public class b extends ImageView {

    /* renamed from: c */
    public static final int f28870c = 503316480;

    /* renamed from: d */
    public static final int f28871d = 1023410176;

    /* renamed from: e */
    public static final float f28872e = 0.0f;

    /* renamed from: f */
    public static final float f28873f = 1.75f;

    /* renamed from: g */
    public static final float f28874g = 3.5f;

    /* renamed from: h */
    public static final int f28875h = 4;

    /* renamed from: b */
    public int f28876b;

    public class a extends OvalShape {

        /* renamed from: b */
        public RadialGradient f28877b;

        /* renamed from: c */
        public Paint f28878c = new Paint();

        public a(int i10) {
            b.this.f28876b = i10;
            a((int) super.rect().width());
        }

        public final void a(int i10) {
            float f10 = i10 / 2.0f;
            RadialGradient radialGradient = new RadialGradient(f10, f10, b.this.f28876b, new int[]{b.f28871d, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f28877b = radialGradient;
            this.f28878c.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            b bVar = b.this;
            float width = bVar.getWidth() / 2.0f;
            float height = bVar.getHeight() / 2.0f;
            canvas.drawCircle(width, height, width, this.f28878c);
            canvas.drawCircle(width, height, width - b.this.f28876b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f10, float f11) {
            super.onResize(f10, f11);
            a((int) f10);
        }
    }

    public b(Context context, int i10) {
        super(context);
        float f10 = getResources().getDisplayMetrics().density;
        this.f28876b = (int) (3.5f * f10);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        setElevation(f10 * 4.0f);
        shapeDrawable.getPaint().setColor(i10);
        setBackground(shapeDrawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
        }
    }
}
