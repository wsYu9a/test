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
import com.vivo.advv.Color;

/* loaded from: classes4.dex */
public class BetaOnPreDraw implements ViewTreeObserver.OnPreDrawListener {
    public static final int TYPE_BASE_BTN = 2;
    public static final int TYPE_CONTENT_SCROLL = 3;
    public static final int TYPE_UPGRADE_TITLE = 1;
    final Object[] args;
    long lastTime;
    StringBuilder loadText;
    final int type;

    public BetaOnPreDraw(int i2, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("loading");
        this.loadText = sb;
        this.type = i2;
        this.args = objArr;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        int i2;
        int i3;
        try {
            int i4 = this.type;
            if (i4 == 1) {
                Object[] objArr = this.args;
                UpgradeDialog upgradeDialog = (UpgradeDialog) objArr[0];
                TextView textView = (TextView) objArr[1];
                Bitmap bitmap = (Bitmap) objArr[2];
                int intValue = ((Integer) objArr[3]).intValue();
                int measuredWidth = textView.getMeasuredWidth();
                double d2 = measuredWidth;
                Double.isNaN(d2);
                int i5 = (int) (d2 * 0.42857142857142855d);
                textView.setHeight(i5);
                if (upgradeDialog.titleDrawable == null) {
                    if (intValue == 2) {
                        upgradeDialog.titleDrawable = a.a(bitmap, measuredWidth, i5, a.a(e.f24621b.v, 6.0f));
                    } else {
                        upgradeDialog.titleDrawable = a.a(bitmap, measuredWidth, i5, a.a(e.f24621b.v, 0.0f));
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
                    StringBuilder sb = new StringBuilder();
                    sb.append("loading");
                    this.loadText = sb;
                } else {
                    this.loadText.append(".");
                }
                textView.setText(this.loadText.toString());
                return true;
            }
            if (i4 != 2) {
                if (i4 != 3) {
                    return false;
                }
                ViewGroup viewGroup = (ViewGroup) this.args[0];
                if (viewGroup.getMeasuredHeight() > a.a((Context) this.args[1], 158.0f)) {
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    layoutParams.height = a.a((Context) this.args[1], 200.0f);
                    viewGroup.setLayoutParams(layoutParams);
                }
                return true;
            }
            if (((Integer) this.args[2]).intValue() <= 0) {
                return true;
            }
            int intValue2 = ((Integer) this.args[0]).intValue();
            TextView textView2 = (TextView) this.args[1];
            int measuredWidth2 = textView2.getMeasuredWidth();
            int measuredHeight = textView2.getMeasuredHeight();
            DisplayMetrics displayMetrics = e.f24621b.E;
            int i6 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.4f);
            if (measuredWidth2 == 0 || measuredHeight == 0 || measuredWidth2 * measuredHeight > i6) {
                return true;
            }
            this.args[2] = 0;
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            if (intValue2 == 2) {
                i2 = 8;
                i3 = 7;
            } else {
                i2 = 0;
                i3 = 0;
            }
            paint.setColor(Color.LTGRAY);
            Bitmap createBitmap = Bitmap.createBitmap(measuredWidth2, measuredHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            float f2 = measuredWidth2;
            float f3 = measuredHeight;
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            float f4 = i2;
            canvas.drawRoundRect(rectF, f4, f4, paint);
            paint.setColor(-1);
            float f5 = i3;
            canvas.drawRoundRect(new RectF(2.0f, 2.0f, f2 - 2.0f, f3 - 2.0f), f5, f5, paint);
            paint.setColor(Color.LTGRAY);
            Bitmap createBitmap2 = Bitmap.createBitmap(measuredWidth2, measuredHeight, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap2).drawRoundRect(rectF, f4, f4, paint);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
            textView2.setBackgroundDrawable(bitmapDrawable);
            textView2.setOnTouchListener(new c(1, bitmapDrawable2, bitmapDrawable));
            return true;
        } catch (Exception e2) {
            if (!X.a(e2)) {
                e2.printStackTrace();
            }
            return false;
        }
    }
}
