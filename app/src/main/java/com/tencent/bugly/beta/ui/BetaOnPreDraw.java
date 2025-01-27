package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.c;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.X;
import p1.b;

/* loaded from: classes4.dex */
public class BetaOnPreDraw implements ViewTreeObserver.OnPreDrawListener {
    public static final int TYPE_BASE_BTN = 2;
    public static final int TYPE_CONTENT_SCROLL = 3;
    public static final int TYPE_UPGRADE_TITLE = 1;
    final Object[] args;
    long lastTime;
    StringBuilder loadText;
    final int type;

    public BetaOnPreDraw(int i10, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loading");
        this.loadText = sb2;
        this.type = i10;
        this.args = objArr;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        int i10;
        int i11;
        int i12;
        try {
            i10 = this.type;
        } catch (Exception e10) {
            if (!X.a(e10)) {
                e10.printStackTrace();
            }
        }
        if (i10 == 1) {
            Object[] objArr = this.args;
            UpgradeDialog upgradeDialog = (UpgradeDialog) objArr[0];
            TextView textView = (TextView) objArr[1];
            Bitmap bitmap = (Bitmap) objArr[2];
            int intValue = ((Integer) objArr[3]).intValue();
            int measuredWidth = textView.getMeasuredWidth();
            int i13 = (int) (measuredWidth * 0.42857142857142855d);
            textView.setHeight(i13);
            if (upgradeDialog.titleDrawable == null) {
                if (intValue == 2) {
                    upgradeDialog.titleDrawable = a.a(bitmap, measuredWidth, i13, a.a(e.f22100b.f22126v, 6.0f));
                } else {
                    upgradeDialog.titleDrawable = a.a(bitmap, measuredWidth, i13, a.a(e.f22100b.f22126v, 0.0f));
                }
                if (upgradeDialog.titleDrawable != null) {
                    textView.setText("");
                    textView.setBackgroundDrawable(upgradeDialog.titleDrawable);
                    textView.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastTime <= 300) {
                return true;
            }
            this.lastTime = currentTimeMillis;
            if (this.loadText.length() > 9) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("loading");
                this.loadText = sb2;
            } else {
                this.loadText.append(b.f29697h);
            }
            textView.setText(this.loadText.toString());
            return true;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                ViewGroup viewGroup = (ViewGroup) this.args[0];
                if (viewGroup.getMeasuredHeight() > a.a((Context) this.args[1], 158.0f)) {
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    layoutParams.height = a.a((Context) this.args[1], 200.0f);
                    viewGroup.setLayoutParams(layoutParams);
                }
                return true;
            }
            return false;
        }
        if (((Integer) this.args[2]).intValue() <= 0) {
            return true;
        }
        int intValue2 = ((Integer) this.args[0]).intValue();
        TextView textView2 = (TextView) this.args[1];
        int measuredWidth2 = textView2.getMeasuredWidth();
        int measuredHeight = textView2.getMeasuredHeight();
        DisplayMetrics displayMetrics = e.f22100b.E;
        int i14 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.4f);
        if (measuredWidth2 == 0 || measuredHeight == 0 || measuredWidth2 * measuredHeight > i14) {
            return true;
        }
        this.args[2] = 0;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        if (intValue2 == 2) {
            i11 = 8;
            i12 = 7;
        } else {
            i11 = 0;
            i12 = 0;
        }
        paint.setColor(-3355444);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth2, measuredHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        float f10 = measuredWidth2;
        float f11 = measuredHeight;
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        float f12 = i11;
        canvas.drawRoundRect(rectF, f12, f12, paint);
        paint.setColor(-1);
        RectF rectF2 = new RectF(2.0f, 2.0f, f10 - 2.0f, f11 - 2.0f);
        float f13 = i12;
        canvas.drawRoundRect(rectF2, f13, f13, paint);
        paint.setColor(-3355444);
        Bitmap createBitmap2 = Bitmap.createBitmap(measuredWidth2, measuredHeight, config);
        new Canvas(createBitmap2).drawRoundRect(rectF, f12, f12, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
        textView2.setBackgroundDrawable(bitmapDrawable);
        textView2.setOnTouchListener(new c(1, bitmapDrawable2, bitmapDrawable));
        return true;
    }
}
