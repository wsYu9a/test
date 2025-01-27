package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.WindAds;

/* loaded from: classes4.dex */
public class a extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener, View.OnClickListener {

    /* renamed from: a */
    public Context f18425a;

    /* renamed from: b */
    public Window f18426b;

    /* renamed from: c */
    public int f18427c;

    /* renamed from: d */
    public int f18428d;

    /* renamed from: e */
    public int f18429e;

    /* renamed from: f */
    public int f18430f;

    /* renamed from: g */
    public String f18431g;

    /* renamed from: h */
    public String f18432h;

    /* renamed from: i */
    public ImageView f18433i;

    /* renamed from: com.sigmob.sdk.base.views.a$a */
    public class ViewOnClickListenerC0578a implements View.OnClickListener {
        public ViewOnClickListenerC0578a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "appid:" + WindAds.sharedAds().getAppId();
            String str2 = "p_id:" + a.this.f18432h;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("req_id:");
            sb2.append(a.this.f18431g);
            com.sigmob.sdk.base.common.g0.makeText(view.getContext(), a.this.a(view.getContext(), String.format("%s,%s,%s", str, str2, sb2.toString())) ? "广告信息复制完成" : "广告信息复制失败，请检查权限", 0).show();
        }
    }

    public a(Context context, String str, String str2) {
        super(context, com.sigmob.sdk.base.g.i());
        this.f18426b = null;
        this.f18425a = context.getApplicationContext();
        this.f18431g = str;
        this.f18432h = str2;
        this.f18433i = c();
        this.f18428d = this.f18425a.getResources().getDisplayMetrics().widthPixels;
        this.f18427c = Dips.dipsToIntPixels(120.0f, context);
    }

    public final ImageView c() {
        ImageView imageView = new ImageView(this.f18425a);
        this.f18433i = imageView;
        imageView.setImageBitmap(s.CLOSE.b());
        this.f18433i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f18433i.setImageAlpha(127);
        this.f18433i.setClickable(true);
        this.f18433i.setOnClickListener(this);
        return this.f18433i;
    }

    public final TextView d() {
        TextView textView = new TextView(getContext());
        textView.setText("复制广告信息");
        textView.setTextColor(-16776961);
        textView.setOnClickListener(new ViewOnClickListenerC0578a());
        return textView;
    }

    public final void e() {
        Window window = getWindow();
        this.f18426b = window;
        if (window != null) {
            window.setGravity(80);
            int k10 = com.sigmob.sdk.base.g.k();
            if (k10 != 0) {
                this.f18426b.setWindowAnimations(k10);
            }
            this.f18426b.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = this.f18426b.getAttributes();
            attributes.width = this.f18428d;
            attributes.height = this.f18427c;
            this.f18426b.setAttributes(attributes);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        float dipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.f18425a);
        gradientDrawable.setCornerRadii(new float[]{dipsToIntPixels, dipsToIntPixels, dipsToIntPixels, dipsToIntPixels, 0.0f, 0.0f, 0.0f, 0.0f});
        int dipsToIntPixels2 = Dips.dipsToIntPixels(10.0f, this.f18425a);
        relativeLayout.setPadding(dipsToIntPixels2, dipsToIntPixels2, dipsToIntPixels2, dipsToIntPixels2);
        relativeLayout.setBackground(gradientDrawable);
        setContentView(relativeLayout);
        setOnShowListener(this);
        setOnDismissListener(this);
        SigmobLog.i("AdInfoDialog onCreate:" + this.f18428d + ":" + this.f18427c);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(18.0f, this.f18425a);
        if (this.f18433i != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels3, dipsToIntPixels3);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, dipsToIntPixels3 / 4, dipsToIntPixels3 / 2, 0);
            relativeLayout.addView(this.f18433i, layoutParams);
        }
        TextView d10 = d();
        d10.setId(ClientMetadata.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, dipsToIntPixels3);
        layoutParams2.addRule(10);
        layoutParams2.addRule(9);
        layoutParams2.setMargins(0, dipsToIntPixels3 / 4, dipsToIntPixels3 / 2, 0);
        relativeLayout.addView(d10, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(3, d10.getId());
        layoutParams3.addRule(9);
        relativeLayout.addView(b(), layoutParams3);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        e();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        SigmobLog.i("AdInfoDialog  onDismiss");
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("AdInfoDialog  onShow");
    }

    public final View b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.setMargins(0, dipsToIntPixels / 4, 0, 0);
        TextView textView = new TextView(getContext());
        textView.setText("appid: " + WindAds.sharedAds().getAppId());
        textView.setTextColor(-16777216);
        textView.setTextSize(12.0f);
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        textView2.setText("p_id: " + this.f18432h);
        textView2.setTextColor(-16777216);
        textView2.setTextSize(12.0f);
        linearLayout.addView(textView2, layoutParams);
        TextView textView3 = new TextView(getContext());
        String str = "req_id: " + this.f18431g;
        textView3.setTextSize(12.0f);
        textView3.setText(str);
        textView3.setTextColor(-16777216);
        linearLayout.addView(textView3, layoutParams);
        return linearLayout;
    }

    public void a() {
        ImageView imageView = this.f18433i;
        if (imageView != null) {
            com.sigmob.sdk.base.utils.e.e(imageView);
            this.f18433i = null;
        }
        if (this.f18425a != null) {
            this.f18425a = null;
        }
    }

    public final boolean a(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
