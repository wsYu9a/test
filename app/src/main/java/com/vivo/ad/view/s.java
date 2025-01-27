package com.vivo.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class s extends ImageView implements View.OnClickListener {

    /* renamed from: a */
    private int f27076a;

    /* renamed from: b */
    private int f27077b;

    /* renamed from: c */
    private int f27078c;

    /* renamed from: d */
    private int f27079d;

    /* renamed from: e */
    private k f27080e;

    /* renamed from: f */
    private Paint f27081f;

    /* renamed from: g */
    private int f27082g;

    /* renamed from: h */
    private float[] f27083h;

    /* renamed from: i */
    private boolean f27084i;

    public s(Context context, int i2) {
        super(context);
        this.f27076a = 0;
        this.f27077b = 0;
        this.f27078c = 0;
        this.f27079d = 0;
        this.f27084i = false;
        this.f27082g = i2;
        a();
    }

    private void a() {
        setOnClickListener(this);
        this.f27081f = new Paint(5);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.f27080e;
        if (kVar != null) {
            kVar.a(view, this.f27078c, this.f27079d, this.f27076a, this.f27077b, false);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f27084i) {
            super.onDraw(canvas);
            return;
        }
        Drawable drawable = getDrawable();
        Matrix imageMatrix = getImageMatrix();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            return;
        }
        if (imageMatrix == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
            drawable.draw(canvas);
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 16 && getCropToPadding()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
        }
        canvas.translate(getPaddingLeft(), getPaddingTop());
        Bitmap a2 = a(drawable);
        Paint paint = this.f27081f;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(a2, tileMode, tileMode));
        if (this.f27082g > 0) {
            RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            float f2 = this.f27082g;
            canvas.drawRoundRect(rectF, f2, f2, this.f27081f);
        } else {
            float[] fArr = this.f27083h;
            if (fArr != null && fArr.length == 8) {
                Path path = new Path();
                path.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f27083h, Path.Direction.CW);
                canvas.clipPath(path);
            }
            canvas.drawPaint(this.f27081f);
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f27078c = (int) motionEvent.getRawX();
            this.f27079d = (int) motionEvent.getRawY();
            this.f27076a = (int) motionEvent.getX();
            this.f27077b = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setGif(boolean z) {
        this.f27084i = z;
    }

    public void setOnADWidgetClickListener(k kVar) {
        this.f27080e = kVar;
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix imageMatrix = getImageMatrix();
        if (imageMatrix != null) {
            canvas.concat(imageMatrix);
        }
        drawable.draw(canvas);
        return createBitmap;
    }

    public s(Context context, float[] fArr) {
        super(context);
        this.f27076a = 0;
        this.f27077b = 0;
        this.f27078c = 0;
        this.f27079d = 0;
        this.f27084i = false;
        this.f27083h = fArr;
        a();
    }
}
