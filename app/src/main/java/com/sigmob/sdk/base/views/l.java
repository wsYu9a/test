package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.WebSettings;
import com.czhj.sdk.common.utils.ReflectionUtil;

/* loaded from: classes4.dex */
public class l extends g {

    /* renamed from: h */
    public float f18730h;

    /* renamed from: i */
    public int f18731i;

    /* renamed from: j */
    public int f18732j;

    /* renamed from: k */
    public int f18733k;

    /* renamed from: l */
    public int f18734l;

    /* renamed from: m */
    public Paint f18735m;

    /* renamed from: n */
    public Paint f18736n;

    public l(Context context) {
        this(context, null);
    }

    @Override // com.sigmob.sdk.base.views.g
    public void a(boolean z10) {
    }

    public final void b(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.f18733k, this.f18730h);
        path.lineTo(this.f18733k, this.f18734l);
        path.lineTo(this.f18730h, this.f18734l);
        float f10 = this.f18733k;
        float f11 = this.f18734l;
        float f12 = this.f18730h * 2.0f;
        path.arcTo(new RectF(f10, f11, f10 + f12, f12 + f11), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f18735m);
    }

    public final void c(Canvas canvas) {
        Path path = new Path();
        path.moveTo((this.f18733k + this.f18731i) - this.f18730h, this.f18734l + this.f18732j);
        path.lineTo(this.f18733k + this.f18731i, this.f18734l + this.f18732j);
        path.lineTo(this.f18733k + this.f18731i, (this.f18734l + this.f18732j) - this.f18730h);
        float f10 = this.f18733k + this.f18731i;
        float f11 = this.f18730h * 2.0f;
        float f12 = this.f18734l + this.f18732j;
        path.arcTo(new RectF(f10 - f11, f12 - f11, f10, f12), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f18735m);
    }

    public final void d(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.f18733k + this.f18731i, this.f18734l + this.f18730h);
        path.lineTo(this.f18733k + this.f18731i, this.f18734l);
        path.lineTo((this.f18733k + this.f18731i) - this.f18730h, this.f18734l);
        float f10 = this.f18733k + this.f18731i;
        float f11 = this.f18730h * 2.0f;
        float f12 = this.f18734l;
        path.arcTo(new RectF(f10 - f11, f12, f10, f11 + f12), -90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f18735m);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f18733k = getScrollX();
        int scrollY = getScrollY();
        this.f18734l = scrollY;
        Bitmap createBitmap = Bitmap.createBitmap(this.f18733k + this.f18731i, scrollY + this.f18732j, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        b(canvas2);
        d(canvas2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.f18736n);
        createBitmap.recycle();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f18731i = getMeasuredWidth();
        this.f18732j = getMeasuredHeight();
    }

    public void setRadius(float f10) {
        this.f18730h = f10;
    }

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Canvas canvas) {
        Path path = new Path();
        path.moveTo(this.f18733k, (this.f18734l + this.f18732j) - this.f18730h);
        path.lineTo(this.f18733k, this.f18734l + this.f18732j);
        path.lineTo(this.f18733k + this.f18730h, this.f18734l + this.f18732j);
        float f10 = this.f18733k;
        float f11 = this.f18734l + this.f18732j;
        float f12 = this.f18730h * 2.0f;
        path.arcTo(new RectF(f10, f11 - f12, f12 + f10, f11), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f18735m);
    }

    public final void c(Context context) {
        Paint paint = new Paint();
        this.f18735m = paint;
        paint.setColor(-1);
        this.f18735m.setAntiAlias(true);
        this.f18735m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f18736n = paint2;
        paint2.setXfermode(null);
    }

    public l(Context context, AttributeSet attributeSet, int i10) {
        super(context);
        this.f18730h = 40.0f;
        a(getSettings());
        c(context);
    }

    private void a(WebSettings webSettings) {
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setCacheMode(-1);
        int i10 = Build.VERSION.SDK_INT;
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAllowContentAccess(true);
        if (i10 >= 26) {
            webSettings.setSafeBrowsingEnabled(false);
        }
        webSettings.setMixedContentMode(0);
    }
}
