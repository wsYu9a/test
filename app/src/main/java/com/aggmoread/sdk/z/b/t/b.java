package com.aggmoread.sdk.z.b.t;

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
import com.aggmoread.sdk.z.b.m.j;
import com.aggmoread.sdk.z.b.t.a;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.b.t.a {
    private boolean D;
    private boolean E;

    public class a extends AppCompatSeekBar {
        public a(b bVar, Context context) {
            super(context);
        }

        @Override // android.widget.AbsSeekBar, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }
    }

    public b(Context context) {
        super(context);
        this.D = true;
        this.E = true;
    }

    public void b(boolean z10) {
        this.D = z10;
        Log.i("xxx", "setShowProgress " + z10);
    }

    @Override // com.aggmoread.sdk.z.b.t.a
    public a.i c() {
        Log.i("xxx", "getPlayerControlShowType " + this.D);
        return this.D ? a.i.f4938c : a.i.f4937b;
    }

    @Override // com.aggmoread.sdk.z.b.t.a
    public a.i d() {
        return a.i.f4937b;
    }

    @Override // com.aggmoread.sdk.z.b.t.a
    public ProgressBar g(RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f4924t);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this.f4924t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        a aVar = new a(this, this.f4924t);
        if (Build.VERSION.SDK_INT >= 29) {
            aVar.setMaxHeight(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 2.0d));
            aVar.setMaxWidth(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 2.0d));
        } else {
            try {
                Field declaredField = ProgressBar.class.getDeclaredField("mMaxHeight");
                Field declaredField2 = ProgressBar.class.getDeclaredField("mMaxWidth");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.set(aVar, Integer.valueOf(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 2.0d)));
                declaredField.set(aVar, Integer.valueOf(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 2.0d)));
                aVar.requestLayout();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        aVar.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 5.0d));
        gradientDrawable.setOrientation(j.a(-90));
        gradientDrawable.setColors(j.a(Color.parseColor("#70ffffff"), Color.parseColor("#70ffffff"), Color.parseColor("#70ffffff")));
        gradientDrawable.setGradientCenter(0.5f, 0.75f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 5.0d));
        gradientDrawable2.setOrientation(j.a(-90));
        gradientDrawable2.setColors(j.a(Color.parseColor("#90ffffff"), Color.parseColor("#90ffffff"), Color.parseColor("#90ffffff")));
        gradientDrawable2.setGradientCenter(0.5f, 0.75f);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadius(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 5.0d));
        gradientDrawable3.setOrientation(j.a(-90));
        gradientDrawable3.setColors(j.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff")));
        gradientDrawable3.setGradientCenter(0.5f, 0.75f);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        aVar.setIndeterminateDrawable(layerDrawable);
        aVar.setProgressDrawable(layerDrawable);
        aVar.setThumb(null);
        aVar.setThumbOffset(com.aggmoread.sdk.z.b.m.b.a(this.f4924t, 10.0d));
        linearLayout.addView(aVar, layoutParams2);
        relativeLayout2.addView(linearLayout, layoutParams);
        return aVar;
    }

    @Override // com.aggmoread.sdk.z.b.t.a, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.E) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
