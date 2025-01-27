package cn.vlion.ad.inland.ad.view.download;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.w4;
import cn.vlion.ad.inland.base.z1;

/* loaded from: classes.dex */
public class VlionDownLoadSecondConfirmView extends LinearLayout {

    /* renamed from: a */
    public Context f2463a;

    /* renamed from: b */
    public ImageView f2464b;

    /* renamed from: c */
    public TextView f2465c;

    /* renamed from: d */
    public TextView f2466d;

    /* renamed from: e */
    public TextView f2467e;

    /* renamed from: f */
    public VlionDownloadProgressBar f2468f;

    /* renamed from: g */
    public VlionDownloadBottomTextView f2469g;

    /* renamed from: h */
    public VlionAdClosedView f2470h;

    public class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ z1 f2471a;

        /* renamed from: b */
        public final /* synthetic */ i0 f2472b;

        public b(z1 z1Var, i0 i0Var) {
            this.f2471a = z1Var;
            this.f2472b = i0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VlionDownLoadSecondConfirmView.this.setVisibility(8);
                z1 z1Var = this.f2471a;
                if (z1Var != null) {
                    z1Var.a(new VlionADClickType("click", this.f2472b.b(), "download", "button", ""));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements VlionAdClosedView.d {

        /* renamed from: a */
        public final /* synthetic */ z1 f2474a;

        public c(z1 z1Var) {
            this.f2474a = z1Var;
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a() {
            try {
                VlionDownLoadSecondConfirmView.this.setVisibility(8);
                z1 z1Var = this.f2474a;
                if (z1Var != null) {
                    z1Var.a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a(boolean z10) {
            try {
                VlionDownLoadSecondConfirmView.this.setVisibility(8);
                z1 z1Var = this.f2474a;
                if (z1Var != null) {
                    z1Var.a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public VlionDownLoadSecondConfirmView(Context context) {
        this(context, null);
    }

    public final void a() {
        try {
            LayoutInflater.from(this.f2463a).inflate(R.layout.vlion_cn_ad_download_second_comfirm, (ViewGroup) this, true);
            this.f2464b = (ImageView) findViewById(R.id.vlion_ad_app_icon);
            this.f2465c = (TextView) findViewById(R.id.vlion_ad_app_name);
            this.f2466d = (TextView) findViewById(R.id.vlion_ad_app_title);
            this.f2467e = (TextView) findViewById(R.id.vlion_ad_app_des);
            this.f2468f = (VlionDownloadProgressBar) findViewById(R.id.vlion_ad_app_action);
            this.f2469g = (VlionDownloadBottomTextView) findViewById(R.id.vlion_ad_app_detal);
            this.f2470h = (VlionAdClosedView) findViewById(R.id.vlion_ad_closed);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionDownLoadSecondConfirmView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData, z1 z1Var) {
        try {
            if (this.f2463a == null) {
                return;
            }
            setVisibility(0);
            VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean = vlionCustomParseAdData.getAppInfoBean();
            if (appInfoBean == null) {
                return;
            }
            this.f2468f.setTextDetail(getResources().getString(R.string.vlion_custom_ad_download_now));
            if (appInfoBean.getApp_logo() != null) {
                try {
                    HttpRequestUtil.downloadBitmap(this.f2464b, appInfoBean.getApp_logo().getUrl(), new w4());
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            this.f2465c.setText(String.valueOf(appInfoBean.getApp_name()));
            this.f2466d.setText(String.valueOf(appInfoBean.getApp_desc()));
            this.f2467e.setVisibility(8);
            this.f2469g.setAppInfo(appInfoBean);
            setOnClickListener(new a());
            this.f2468f.setOnClickListener(new b(z1Var, new i0(this.f2468f)));
            this.f2470h.a("X", true, new c(z1Var));
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public VlionDownLoadSecondConfirmView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2463a = context;
        a();
    }
}
