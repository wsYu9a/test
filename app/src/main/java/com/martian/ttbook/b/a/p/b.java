package com.martian.ttbook.b.a.p;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.martian.ttbook.b.a.k.j;
import com.martian.ttbook.b.a.p.a;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class b extends com.martian.ttbook.b.a.p.a {
    private boolean B;

    class a extends AppCompatSeekBar {
        a(b bVar, Context context) {
            super(context);
        }

        @Override // android.widget.AbsSeekBar, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }
    }

    public b(Context context) {
        super(context);
        this.B = true;
    }

    @Override // com.martian.ttbook.b.a.p.a
    protected ProgressBar B(RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.t);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this.t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        a aVar = new a(this, this.t);
        if (Build.VERSION.SDK_INT >= 29) {
            aVar.setMaxHeight(com.martian.ttbook.b.a.k.b.b(this.t, 2.0d));
            aVar.setMaxWidth(com.martian.ttbook.b.a.k.b.b(this.t, 2.0d));
        } else {
            try {
                Field declaredField = ProgressBar.class.getDeclaredField("mMaxHeight");
                Field declaredField2 = ProgressBar.class.getDeclaredField("mMaxWidth");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.set(aVar, Integer.valueOf(com.martian.ttbook.b.a.k.b.b(this.t, 2.0d)));
                declaredField.set(aVar, Integer.valueOf(com.martian.ttbook.b.a.k.b.b(this.t, 2.0d)));
                aVar.requestLayout();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        aVar.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.martian.ttbook.b.a.k.b.b(this.t, 5.0d));
        gradientDrawable.setOrientation(j.c(-90));
        gradientDrawable.setColors(j.h(Color.parseColor("#70ffffff"), Color.parseColor("#70ffffff"), Color.parseColor("#70ffffff")));
        gradientDrawable.setGradientCenter(0.5f, 0.75f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(com.martian.ttbook.b.a.k.b.b(this.t, 5.0d));
        gradientDrawable2.setOrientation(j.c(-90));
        gradientDrawable2.setColors(j.h(Color.parseColor("#90ffffff"), Color.parseColor("#90ffffff"), Color.parseColor("#90ffffff")));
        gradientDrawable2.setGradientCenter(0.5f, 0.75f);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadius(com.martian.ttbook.b.a.k.b.b(this.t, 5.0d));
        gradientDrawable3.setOrientation(j.c(-90));
        gradientDrawable3.setColors(j.h(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff")));
        gradientDrawable3.setGradientCenter(0.5f, 0.75f);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        aVar.setIndeterminateDrawable(layerDrawable);
        aVar.setProgressDrawable(layerDrawable);
        aVar.setThumb(null);
        aVar.setThumbOffset(com.martian.ttbook.b.a.k.b.b(this.t, 10.0d));
        linearLayout.addView(aVar, layoutParams2);
        relativeLayout2.addView(linearLayout, layoutParams);
        return aVar;
    }

    public void S(boolean z) {
        this.B = z;
        Log.i("xxx", "setShowProgress " + z);
    }

    @Override // com.martian.ttbook.b.a.p.a
    protected a.h o() {
        Log.i("xxx", "getPlayerControlShowType " + this.B);
        return this.B ? a.h.f15092c : a.h.f15091b;
    }

    @Override // com.martian.ttbook.b.a.p.a
    protected a.h t() {
        return a.h.f15091b;
    }
}
