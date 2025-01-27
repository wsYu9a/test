package com.martian.mibook.ui.reader;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class ReaderLoadingTip extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f14819a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f14820b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f14821c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f14822d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f14823e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f14824f;

    /* renamed from: g, reason: collision with root package name */
    private b f14825g;

    /* renamed from: h, reason: collision with root package name */
    private String f14826h;

    public enum LoadStatus {
        serverError,
        error,
        empty,
        loading,
        finish
    }

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14827a;

        static {
            int[] iArr = new int[LoadStatus.values().length];
            f14827a = iArr;
            try {
                iArr[LoadStatus.empty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14827a[LoadStatus.serverError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14827a[LoadStatus.error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14827a[LoadStatus.loading.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface b {
        void a();
    }

    public ReaderLoadingTip(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.layout_reader_loading_tip, this);
        this.f14819a = (ImageView) findViewById(R.id.img_tip_logo);
        this.f14820b = (ImageView) findViewById(R.id.tv_loading_icon);
        this.f14821c = (TextView) findViewById(R.id.tv_tips);
        this.f14822d = (TextView) findViewById(R.id.tv_tips_retry_hint);
        this.f14824f = (LinearLayout) findViewById(R.id.tv_loading);
        TextView textView = (TextView) findViewById(R.id.bt_operate);
        this.f14823e = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.reader.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderLoadingTip.this.c(view);
            }
        });
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(View view) {
        b bVar = this.f14825g;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void setLoadingTip(LoadStatus loadStatus) {
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f14820b.getBackground();
        int i2 = a.f14827a[loadStatus.ordinal()];
        if (i2 == 1) {
            setVisibility(0);
            this.f14819a.setVisibility(0);
            this.f14822d.setVisibility(8);
            this.f14823e.setVisibility(8);
            this.f14821c.setVisibility(0);
            this.f14824f.setVisibility(8);
            animationDrawable.stop();
            this.f14819a.setImageResource(R.drawable.tip_no_content);
            this.f14821c.setText(getContext().getText(R.string.empty).toString());
            return;
        }
        if (i2 == 2) {
            setVisibility(0);
            this.f14819a.setVisibility(0);
            this.f14822d.setVisibility(0);
            this.f14821c.setVisibility(0);
            this.f14824f.setVisibility(8);
            animationDrawable.stop();
            this.f14819a.setImageResource(R.drawable.tip_content_error);
            if (TextUtils.isEmpty(this.f14826h)) {
                this.f14821c.setText(getContext().getText(R.string.net_error).toString());
            } else {
                this.f14821c.setText(this.f14826h);
            }
            this.f14823e.setVisibility(0);
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f14819a.setVisibility(8);
            this.f14822d.setVisibility(8);
            this.f14821c.setVisibility(8);
            this.f14824f.setVisibility(0);
            animationDrawable.start();
            this.f14823e.setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f14819a.setVisibility(0);
        this.f14822d.setVisibility(0);
        this.f14821c.setVisibility(0);
        this.f14824f.setVisibility(8);
        animationDrawable.stop();
        this.f14819a.setImageResource(R.drawable.tip_wifi_off);
        if (TextUtils.isEmpty(this.f14826h)) {
            this.f14821c.setText(getContext().getText(R.string.net_error).toString());
        } else {
            this.f14821c.setText(this.f14826h);
        }
        this.f14822d.setText(getContext().getText(R.string.net_error_retry_hint).toString());
        this.f14823e.setVisibility(0);
    }

    public void setOnReloadListener(b onReloadListener) {
        this.f14825g = onReloadListener;
    }

    public void setTips(String tips) {
        TextView textView = this.f14821c;
        if (textView != null) {
            textView.setText(tips);
        }
    }

    public ReaderLoadingTip(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    public ReaderLoadingTip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context);
    }

    @TargetApi(21)
    public ReaderLoadingTip(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        a(context);
    }
}
