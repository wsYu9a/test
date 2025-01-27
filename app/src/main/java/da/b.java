package da;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: b */
    public Path f25407b;

    /* renamed from: c */
    public Paint f25408c;

    /* renamed from: e */
    public int f25410e;

    /* renamed from: f */
    public int f25411f;

    /* renamed from: g */
    public ColorStateList f25412g;

    /* renamed from: h */
    public int f25413h;

    /* renamed from: i */
    public boolean f25414i;

    /* renamed from: j */
    public Region f25415j;

    /* renamed from: k */
    public RectF f25416k;

    /* renamed from: l */
    public boolean f25417l;

    /* renamed from: m */
    public a f25418m;

    /* renamed from: a */
    public float[] f25406a = new float[8];

    /* renamed from: d */
    public boolean f25409d = false;

    public interface a {
        void a(View view, boolean z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        if (view instanceof da.a) {
            ArrayList arrayList = new ArrayList();
            if (view instanceof Checkable) {
                arrayList.add(Integer.valueOf(R.attr.state_checkable));
                if (((Checkable) view).isChecked()) {
                    arrayList.add(Integer.valueOf(R.attr.state_checked));
                }
            }
            if (view.isEnabled()) {
                arrayList.add(Integer.valueOf(R.attr.state_enabled));
            }
            if (view.isFocused()) {
                arrayList.add(Integer.valueOf(R.attr.state_focused));
            }
            if (view.isPressed()) {
                arrayList.add(Integer.valueOf(R.attr.state_pressed));
            }
            if (view.isHovered()) {
                arrayList.add(Integer.valueOf(R.attr.state_hovered));
            }
            if (view.isSelected()) {
                arrayList.add(Integer.valueOf(R.attr.state_selected));
            }
            if (view.isActivated()) {
                arrayList.add(Integer.valueOf(R.attr.state_activated));
            }
            if (view.hasWindowFocus()) {
                arrayList.add(Integer.valueOf(R.attr.state_window_focused));
            }
            ColorStateList colorStateList = this.f25412g;
            if (colorStateList == null || !colorStateList.isStateful()) {
                return;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Integer) arrayList.get(i10)).intValue();
            }
            ((da.a) view).setStrokeColor(this.f25412g.getColorForState(iArr, this.f25410e));
        }
    }

    public void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.martian.libsupport.R.styleable.MTAttrs);
        this.f25409d = obtainStyledAttributes.getBoolean(com.martian.libsupport.R.styleable.MTAttrs_round_as_circle, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(com.martian.libsupport.R.styleable.MTAttrs_stroke_color);
        this.f25412g = colorStateList;
        if (colorStateList != null) {
            this.f25411f = colorStateList.getDefaultColor();
            this.f25410e = this.f25412g.getDefaultColor();
        } else {
            this.f25411f = -1;
            this.f25410e = -1;
        }
        this.f25413h = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_stroke_width, 0);
        this.f25414i = obtainStyledAttributes.getBoolean(com.martian.libsupport.R.styleable.MTAttrs_clip_background, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner_top_left, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner_top_right, dimensionPixelSize);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner_bottom_left, dimensionPixelSize);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner_bottom_right, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        float[] fArr = this.f25406a;
        float f10 = dimensionPixelSize2;
        fArr[0] = f10;
        fArr[1] = f10;
        float f11 = dimensionPixelSize3;
        fArr[2] = f11;
        fArr[3] = f11;
        float f12 = dimensionPixelSize5;
        fArr[4] = f12;
        fArr[5] = f12;
        float f13 = dimensionPixelSize4;
        fArr[6] = f13;
        fArr[7] = f13;
        this.f25416k = new RectF();
        this.f25407b = new Path();
        this.f25415j = new Region();
        Paint paint = new Paint();
        this.f25408c = paint;
        paint.setColor(-1);
        this.f25408c.setAntiAlias(true);
    }

    public void c(Canvas canvas) {
        if (this.f25413h > 0) {
            this.f25408c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.f25408c.setColor(-1);
            this.f25408c.setStrokeWidth(this.f25413h * 2);
            Paint paint = this.f25408c;
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            canvas.drawPath(this.f25407b, this.f25408c);
            this.f25408c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            this.f25408c.setColor(this.f25411f);
            this.f25408c.setStyle(style);
            canvas.drawPath(this.f25407b, this.f25408c);
        }
        this.f25408c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f25408c.setColor(-1);
        this.f25408c.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.f25407b, this.f25408c);
    }

    public void d(View view, int i10, int i11) {
        this.f25416k.set(0.0f, 0.0f, i10, i11);
        e(view);
    }

    public void e(View view) {
        int width = (int) this.f25416k.width();
        int height = (int) this.f25416k.height();
        RectF rectF = new RectF();
        rectF.left = view.getPaddingLeft();
        rectF.top = view.getPaddingTop();
        rectF.right = width - view.getPaddingRight();
        rectF.bottom = height - view.getPaddingBottom();
        this.f25407b.reset();
        if (this.f25409d) {
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            PointF pointF = new PointF(width / 2.0f, height / 2.0f);
            this.f25407b.addCircle(pointF.x, pointF.y, min, Path.Direction.CW);
        } else {
            this.f25407b.addRoundRect(rectF, this.f25406a, Path.Direction.CW);
        }
        this.f25407b.moveTo(0.0f, 0.0f);
        this.f25407b.moveTo(width, height);
        this.f25415j.setPath(this.f25407b, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }
}
