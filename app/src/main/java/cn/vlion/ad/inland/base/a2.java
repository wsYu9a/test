package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.view.web.VLionWebViewActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class a2 {

    /* renamed from: a */
    public TextView f2581a;

    /* renamed from: b */
    public TextView f2582b;

    /* renamed from: c */
    public TextView f2583c;

    /* renamed from: d */
    public TextView f2584d;

    /* renamed from: e */
    public TextView f2585e;

    /* renamed from: f */
    public TextView f2586f;

    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Context f2587a;

        /* renamed from: b */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean f2588b;

        public a(Context context, VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
            this.f2587a = context;
            this.f2588b = appInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VLionWebViewActivity.start(this.f2587a, 1, this.f2588b.getPrivacy_policy(), "", "", "", null);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Context f2589a;

        /* renamed from: b */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean f2590b;

        public b(Context context, VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
            this.f2589a = context;
            this.f2590b = appInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VLionWebViewActivity.start(this.f2589a, 1, this.f2590b.getApp_permissions_link(), "", "", "", null);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Context f2591a;

        /* renamed from: b */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean f2592b;

        public c(Context context, VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
            this.f2591a = context;
            this.f2592b = appInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VLionWebViewActivity.start(this.f2591a, 1, this.f2592b.getApp_desc_url(), "", "", "", null);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public a2(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.f2581a = textView;
        this.f2582b = textView2;
        this.f2583c = textView3;
        this.f2584d = textView4;
        this.f2585e = textView5;
        this.f2586f = textView6;
    }

    public final void a(Context context, VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
        if (appInfoBean == null) {
            return;
        }
        try {
            this.f2581a.setText(String.valueOf(appInfoBean.getApp_name()));
            this.f2582b.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_developer) + appInfoBean.getDeveloper_name());
            this.f2583c.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_code) + appInfoBean.getVersion_code());
            this.f2584d.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_privacy));
            this.f2585e.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_permission));
            this.f2586f.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_intro));
            this.f2584d.setOnClickListener(new a(context, appInfoBean));
            this.f2585e.setOnClickListener(new b(context, appInfoBean));
            this.f2586f.setOnClickListener(new c(context, appInfoBean));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
