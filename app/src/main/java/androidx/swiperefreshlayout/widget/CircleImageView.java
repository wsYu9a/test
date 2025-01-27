package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class CircleImageView extends ImageView {

    /* renamed from: a */
    private static final int f3622a = 503316480;

    /* renamed from: b */
    private static final int f3623b = 1023410176;

    /* renamed from: c */
    private static final float f3624c = 0.0f;

    /* renamed from: d */
    private static final float f3625d = 1.75f;

    /* renamed from: e */
    private static final float f3626e = 3.5f;

    /* renamed from: f */
    private static final int f3627f = 4;

    /* renamed from: g */
    private Animation.AnimationListener f3628g;

    /* renamed from: h */
    int f3629h;

    private class OvalShadow extends OvalShape {

        /* renamed from: a */
        private RadialGradient f3630a;

        /* renamed from: b */
        private Paint f3631b = new Paint();

        OvalShadow(int i2) {
            CircleImageView.this.f3629h = i2;
            a((int) rect().width());
        }

        private void a(int i2) {
            float f2 = i2 / 2;
            RadialGradient radialGradient = new RadialGradient(f2, f2, CircleImageView.this.f3629h, new int[]{CircleImageView.f3623b, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f3630a = radialGradient;
            this.f3631b.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = CircleImageView.this.getWidth() / 2;
            float height = CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f3631b);
            canvas.drawCircle(width, height, r0 - CircleImageView.this.f3629h, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    CircleImageView(Context context, int i2) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (f3625d * f2);
        int i4 = (int) (0.0f * f2);
        this.f3629h = (int) (f3626e * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this.f3629h));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f3629h, i4, i3, f3622a);
            int i5 = this.f3629h;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f3628g;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f3628g;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f3629h * 2), getMeasuredHeight() + (this.f3629h * 2));
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f3628g = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    public void setBackgroundColorRes(int i2) {
        setBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }
}
