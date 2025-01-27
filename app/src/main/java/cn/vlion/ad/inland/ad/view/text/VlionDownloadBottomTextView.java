package cn.vlion.ad.inland.ad.view.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.view.web.VLionWebViewActivity;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VlionDownloadBottomTextView extends FrameLayout {

    /* renamed from: a */
    public int f2476a;

    /* renamed from: b */
    public int f2477b;

    /* renamed from: c */
    public TextView f2478c;

    /* renamed from: d */
    public TextView f2479d;

    /* renamed from: e */
    public TextView f2480e;

    /* renamed from: f */
    public TextView f2481f;

    /* renamed from: g */
    public TextView f2482g;

    /* renamed from: h */
    public TextView f2483h;

    /* renamed from: i */
    public View f2484i;

    /* renamed from: j */
    public View f2485j;

    /* renamed from: k */
    public View f2486k;

    /* renamed from: l */
    public View f2487l;

    /* renamed from: m */
    public View f2488m;

    /* renamed from: n */
    public Context f2489n;

    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean f2490a;

        public a(VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
            this.f2490a = appInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VLionWebViewActivity.start(VlionDownloadBottomTextView.this.f2489n, 1, this.f2490a.getPrivacy_policy(), "", "", "", null);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean f2492a;

        public b(VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
            this.f2492a = appInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VLionWebViewActivity.start(VlionDownloadBottomTextView.this.f2489n, 1, this.f2492a.getApp_permissions_link(), "", "", "", null);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean f2494a;

        public c(VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
            this.f2494a = appInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VLionWebViewActivity.start(VlionDownloadBottomTextView.this.f2489n, 1, this.f2494a.getApp_desc_url(), "", "", "", null);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public VlionDownloadBottomTextView(Context context) {
        this(context, null);
    }

    public final void a(TextView textView, boolean z10) {
        try {
            textView.setTextSize(2, this.f2476a);
            textView.setTextColor(this.f2477b);
            if (z10) {
                textView.getPaint().setFlags(8);
                textView.getPaint().setAntiAlias(true);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setAppInfo(VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
        if (appInfoBean == null) {
            return;
        }
        try {
            this.f2478c.setText(String.valueOf(appInfoBean.getApp_name()));
            this.f2479d.setText(String.valueOf(appInfoBean.getDeveloper_name()));
            this.f2480e.setText(String.valueOf(appInfoBean.getVersion_code()));
            this.f2481f.setOnClickListener(new a(appInfoBean));
            this.f2482g.setOnClickListener(new b(appInfoBean));
            this.f2483h.setOnClickListener(new c(appInfoBean));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionDownloadBottomTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public VlionDownloadBottomTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        try {
            this.f2489n = context;
            if (context == null) {
                return;
            }
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_download_bottom_textlayout, (ViewGroup) this, true);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VlionDownloadBottomTextView);
            this.f2476a = obtainStyledAttributes.getInt(R.styleable.VlionDownloadBottomTextView_vlion_style_text_size, 10);
            this.f2477b = obtainStyledAttributes.getColor(R.styleable.VlionDownloadBottomTextView_vlion_style_text_color, R.color.vlion_custom_tran_60_black_font_color);
            this.f2478c = (TextView) findViewById(R.id.vlion_down_bottom_tv_name);
            this.f2479d = (TextView) findViewById(R.id.vlion_down_bottom_tv_company);
            this.f2480e = (TextView) findViewById(R.id.vlion_down_bottom_tv_version);
            this.f2481f = (TextView) findViewById(R.id.vlion_down_bottom_tv_privacy);
            this.f2482g = (TextView) findViewById(R.id.vlion_down_bottom_tv_permission);
            this.f2483h = (TextView) findViewById(R.id.vlion_down_bottom_tv_intro);
            this.f2484i = findViewById(R.id.vlion_view_line1);
            this.f2485j = findViewById(R.id.vlion_view_line2);
            this.f2486k = findViewById(R.id.vlion_view_line3);
            this.f2487l = findViewById(R.id.vlion_view_line4);
            this.f2488m = findViewById(R.id.vlion_view_line5);
            this.f2484i.setBackgroundColor(this.f2477b);
            this.f2485j.setBackgroundColor(this.f2477b);
            this.f2486k.setBackgroundColor(this.f2477b);
            this.f2487l.setBackgroundColor(this.f2477b);
            this.f2488m.setBackgroundColor(this.f2477b);
            a(this.f2478c, false);
            a(this.f2479d, false);
            a(this.f2480e, false);
            a(this.f2481f, true);
            a(this.f2482g, true);
            a(this.f2483h, true);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
