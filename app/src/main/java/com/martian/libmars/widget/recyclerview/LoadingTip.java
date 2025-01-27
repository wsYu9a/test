package com.martian.libmars.widget.recyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public class LoadingTip extends LinearLayout {

    /* renamed from: a */
    private ImageView f10446a;

    /* renamed from: b */
    private ImageView f10447b;

    /* renamed from: c */
    private TextView f10448c;

    /* renamed from: d */
    private TextView f10449d;

    /* renamed from: e */
    private TextView f10450e;

    /* renamed from: f */
    private LinearLayout f10451f;

    /* renamed from: g */
    private b f10452g;

    /* renamed from: h */
    private String f10453h;

    public enum LoadStatus {
        sereverError,
        error,
        empty,
        loading,
        finish
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f10454a;

        static {
            int[] iArr = new int[LoadStatus.values().length];
            f10454a = iArr;
            try {
                iArr[LoadStatus.empty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10454a[LoadStatus.sereverError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10454a[LoadStatus.error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10454a[LoadStatus.loading.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface b {
        void a();
    }

    public LoadingTip(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.layout_loading_tip, this);
        this.f10446a = (ImageView) findViewById(R.id.img_tip_logo);
        this.f10447b = (ImageView) findViewById(R.id.tv_loading_icon);
        this.f10448c = (TextView) findViewById(R.id.tv_tips);
        this.f10449d = (TextView) findViewById(R.id.tv_tips_retry_hint);
        this.f10451f = (LinearLayout) findViewById(R.id.tv_loading);
        TextView textView = (TextView) findViewById(R.id.bt_operate);
        this.f10450e = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.widget.recyclerview.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadingTip.this.c(view);
            }
        });
        final AnimationDrawable animationDrawable = (AnimationDrawable) this.f10447b.getBackground();
        this.f10447b.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.martian.libmars.widget.recyclerview.b
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return LoadingTip.d(animationDrawable);
            }
        });
        setVisibility(8);
    }

    /* renamed from: b */
    public /* synthetic */ void c(View view) {
        b bVar = this.f10452g;
        if (bVar != null) {
            bVar.a();
        }
    }

    static /* synthetic */ boolean d(final AnimationDrawable mAnimationDrawable) {
        mAnimationDrawable.start();
        return true;
    }

    public void setLoadingTip(LoadStatus loadStatus) {
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f10447b.getBackground();
        int i2 = a.f10454a[loadStatus.ordinal()];
        if (i2 == 1) {
            setVisibility(0);
            this.f10446a.setVisibility(0);
            this.f10449d.setVisibility(8);
            this.f10450e.setVisibility(8);
            this.f10448c.setVisibility(0);
            this.f10451f.setVisibility(8);
            animationDrawable.stop();
            this.f10446a.setImageResource(R.drawable.tip_no_content);
            this.f10448c.setText(getContext().getText(R.string.empty).toString());
            return;
        }
        if (i2 == 2) {
            setVisibility(0);
            this.f10446a.setVisibility(0);
            this.f10449d.setVisibility(0);
            this.f10448c.setVisibility(0);
            this.f10451f.setVisibility(8);
            animationDrawable.stop();
            this.f10446a.setImageResource(R.drawable.tip_content_error);
            if (TextUtils.isEmpty(this.f10453h)) {
                this.f10448c.setText(getContext().getText(R.string.net_error).toString());
            } else {
                this.f10448c.setText(this.f10453h);
            }
            this.f10450e.setVisibility(0);
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f10446a.setVisibility(8);
            this.f10449d.setVisibility(8);
            this.f10448c.setVisibility(8);
            this.f10451f.setVisibility(0);
            this.f10450e.setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f10446a.setVisibility(0);
        this.f10449d.setVisibility(0);
        this.f10448c.setVisibility(0);
        this.f10451f.setVisibility(8);
        animationDrawable.stop();
        this.f10446a.setImageResource(R.drawable.tip_wifi_off);
        if (TextUtils.isEmpty(this.f10453h)) {
            this.f10448c.setText(getContext().getText(R.string.net_error).toString());
        } else {
            this.f10448c.setText(this.f10453h);
        }
        this.f10449d.setText(getContext().getText(R.string.net_error_retry_hint).toString());
        this.f10450e.setVisibility(0);
    }

    public void setOnReloadListener(b onReloadListener) {
        this.f10452g = onReloadListener;
    }

    public void setTips(String tips) {
        TextView textView = this.f10448c;
        if (textView != null) {
            textView.setText(tips);
        }
    }

    public LoadingTip(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    public LoadingTip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context);
    }

    @TargetApi(21)
    public LoadingTip(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        a(context);
    }
}
