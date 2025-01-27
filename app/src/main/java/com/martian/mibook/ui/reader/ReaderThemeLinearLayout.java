package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class ReaderThemeLinearLayout extends LinearLayout implements g.a, View.OnTouchListener {

    /* renamed from: a */
    private boolean f14838a;

    /* renamed from: b */
    private int f14839b;

    /* renamed from: c */
    private boolean f14840c;

    public ReaderThemeLinearLayout(Context context) {
        super(context);
        this.f14838a = false;
        this.f14840c = false;
        a();
    }

    private void a() {
        if (this.f14840c) {
            setOnTouchListener(this);
            setClickable(true);
        }
        g();
    }

    private void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ReaderThemeLinearLayout);
        this.f14838a = obtainStyledAttributes.getBoolean(1, false);
        this.f14840c = obtainStyledAttributes.getBoolean(3, false);
        this.f14839b = obtainStyledAttributes.getInt(2, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        int i2 = this.f14839b;
        if (i2 <= 0) {
            if (this.f14838a) {
                setBackgroundResource(r.getBorderLineBackgroundLayoutRes());
                return;
            } else {
                setBackgroundColor(MiConfigSingleton.V3().J4.b());
            }
        }
        switch (i2) {
            case 9:
                break;
            case 10:
                setBackgroundColor(r.getItemColorPrimary());
                break;
            case 11:
                setBackgroundColor(r.getBackgroundPrimary());
                break;
            case 12:
                setBackgroundColor(r.getItemColorPrimary());
                setAlpha(0.05f);
                break;
            case 13:
                setBackgroundColor(MiConfigSingleton.V3().J4.E() ? MiConfigSingleton.V3().J4.b() : ContextCompat.getColor(getContext(), com.martian.ttbookhd.R.color.ad_white_alpha_bg));
                break;
            case 14:
                setBackgroundColor(r.getTextColorPrimary());
                break;
            case 15:
                setBackgroundResource(r.getTopRoundBgRes());
                break;
            case 16:
                setBackgroundResource(r.getBorderBackgroundLightButton());
                break;
            case 17:
                setBackgroundResource(r.getRound4DpBgRes());
                break;
            case 18:
                setBackgroundColor(MiConfigSingleton.V3().J4.E() ? MiConfigSingleton.V3().J4.b() : ContextCompat.getColor(getContext(), com.martian.ttbookhd.R.color.white));
                break;
            case 19:
                setBackgroundColor(MiConfigSingleton.V3().J4.b());
                break;
            default:
                setBackgroundColor(r.getItemColorPrimaryLight());
                break;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (!this.f14840c) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            if (this.f14839b != 19) {
                Iterator<View> it = i.a.a(this).iterator();
                while (it.hasNext()) {
                    it.next().setAlpha(0.6f);
                }
                return false;
            }
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.99f, 1.0f, 0.99f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(150L);
            scaleAnimation.setFillAfter(true);
            startAnimation(scaleAnimation);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        if (this.f14839b != 19) {
            Iterator<View> it2 = i.a.a(this).iterator();
            while (it2.hasNext()) {
                it2.next().setAlpha(1.0f);
            }
            return false;
        }
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.99f, 1.0f, 0.99f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(150L);
        scaleAnimation2.setFillAfter(true);
        startAnimation(scaleAnimation2);
        return false;
    }

    public ReaderThemeLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        b(context, attrs);
        a();
    }

    public ReaderThemeLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f14838a = false;
        this.f14840c = false;
        b(context, attrs);
        a();
    }
}
