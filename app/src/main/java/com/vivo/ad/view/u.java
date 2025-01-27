package com.vivo.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vivo.mobilead.util.d1.c;

/* loaded from: classes4.dex */
public class u extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private int f27095a;

    /* renamed from: b */
    private int f27096b;

    /* renamed from: c */
    private int f27097c;

    /* renamed from: d */
    private int f27098d;

    /* renamed from: e */
    private Context f27099e;

    /* renamed from: f */
    private k f27100f;

    /* renamed from: g */
    private ImageView f27101g;

    class a implements c.d {
        a() {
        }

        @Override // com.vivo.mobilead.util.d1.c.d
        public void a(com.vivo.mobilead.util.d1.c cVar) {
            int a2 = cVar.a(0);
            if (a2 == 0) {
                u.this.c();
                return;
            }
            int alpha = Color.alpha(a2);
            int red = Color.red(a2);
            int green = Color.green(a2);
            int blue = Color.blue(a2);
            double d2 = alpha;
            Double.isNaN(d2);
            int argb = Color.argb((int) (0.8d * d2), red, green, blue);
            Double.isNaN(d2);
            int argb2 = Color.argb((int) (0.6d * d2), red, green, blue);
            Double.isNaN(d2);
            int argb3 = Color.argb((int) (0.4d * d2), red, green, blue);
            Double.isNaN(d2);
            u.this.setGradientBackground(new int[]{argb, argb2, argb3, Color.argb((int) (d2 * 0.2d), red, green, blue)});
        }
    }

    public u(Context context) {
        this(context, null);
    }

    private void b() {
        a();
    }

    public void c() {
        int parseColor = Color.parseColor("#ffcccccc");
        int alpha = Color.alpha(parseColor);
        int red = Color.red(parseColor);
        int green = Color.green(parseColor);
        int blue = Color.blue(parseColor);
        int argb = Color.argb(alpha * 1, red, green, blue);
        double d2 = alpha;
        Double.isNaN(d2);
        setGradientBackground(new int[]{argb, Color.argb((int) (d2 * 0.35d), red, green, blue)});
    }

    public void setGradientBackground(int[] iArr) {
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr));
    }

    private void setMainColorBackground(Bitmap bitmap) {
        new c.b(bitmap).a(new a());
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.f27100f;
        if (kVar != null) {
            kVar.a(view, this.f27097c, this.f27098d, this.f27095a, this.f27096b, false);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f27097c = (int) motionEvent.getRawX();
            this.f27098d = (int) motionEvent.getRawY();
            this.f27095a = (int) motionEvent.getX();
            this.f27096b = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnADWidgetClickListener(k kVar) {
        this.f27100f = kVar;
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public u(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f27095a = 0;
        this.f27096b = 0;
        this.f27097c = 0;
        this.f27098d = 0;
        this.f27099e = context;
        setOnClickListener(this);
        b();
    }

    private void a() {
        this.f27101g = new ImageView(this.f27099e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f27101g, layoutParams);
    }

    public void a(Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f27101g.setImageBitmap(bitmap);
        if (z) {
            setMainColorBackground(bitmap);
        } else {
            c();
        }
    }
}
