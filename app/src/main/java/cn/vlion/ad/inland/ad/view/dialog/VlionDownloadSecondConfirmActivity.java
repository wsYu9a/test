package cn.vlion.ad.inland.ad.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class VlionDownloadSecondConfirmActivity extends Activity {

    /* renamed from: i */
    public static WeakReference<d> f2450i;

    /* renamed from: j */
    public static WeakReference<VlionDownloadSecondConfirmActivity> f2451j;

    /* renamed from: a */
    public ImageView f2452a;

    /* renamed from: b */
    public TextView f2453b;

    /* renamed from: c */
    public TextView f2454c;

    /* renamed from: d */
    public TextView f2455d;

    /* renamed from: e */
    public VlionDownloadProgressBar f2456e;

    /* renamed from: f */
    public VlionDownloadBottomTextView f2457f;

    /* renamed from: g */
    public VlionCustomParseAdData f2458g;

    /* renamed from: h */
    public c f2459h = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                if (VlionDownloadSecondConfirmActivity.f2450i.get() != null) {
                    VlionDownloadSecondConfirmActivity.f2450i.get().a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            VlionDownloadSecondConfirmActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ i0 f2461a;

        public b(i0 i0Var) {
            this.f2461a = i0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                if (VlionDownloadSecondConfirmActivity.f2450i.get() != null) {
                    VlionDownloadSecondConfirmActivity.f2450i.get().a(new VlionADClickType("click", this.f2461a.b(), "download", "button", ""));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            VlionDownloadSecondConfirmActivity.this.finish();
        }
    }

    public class c implements ImageCallback {
        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        }
    }

    public interface d {
        void a();

        void a(VlionADClickType vlionADClickType);
    }

    public static void a(Context context, VlionCustomParseAdData vlionCustomParseAdData, d dVar) {
        try {
            Intent intent = new Intent(context, (Class<?>) VlionDownloadSecondConfirmActivity.class);
            f2450i = new WeakReference<>(dVar);
            intent.putExtra("VlionCustomParseAdDataString", vlionCustomParseAdData);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getWindow().setLayout(-1, -2);
            getWindow().setGravity(17);
            setContentView(R.layout.vlion_cn_ad_activity_feed_download);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() * 0.9d);
            attributes.height = -2;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            VlionAppInfo.getInstance().hideNavigationBar(this);
            f2451j = new WeakReference<>(this);
            VlionCustomParseAdData vlionCustomParseAdData = (VlionCustomParseAdData) getIntent().getSerializableExtra("VlionCustomParseAdDataString");
            this.f2458g = vlionCustomParseAdData;
            if (vlionCustomParseAdData == null) {
                finish();
                return;
            }
            this.f2452a = (ImageView) findViewById(R.id.vlion_ad_app_icon);
            this.f2453b = (TextView) findViewById(R.id.vlion_ad_app_name);
            this.f2454c = (TextView) findViewById(R.id.vlion_ad_app_title);
            this.f2455d = (TextView) findViewById(R.id.vlion_ad_app_des);
            this.f2456e = (VlionDownloadProgressBar) findViewById(R.id.vlion_ad_app_action);
            this.f2457f = (VlionDownloadBottomTextView) findViewById(R.id.vlion_ad_app_detal);
            ((VlionAdClosedView) findViewById(R.id.vlion_ad_closed)).setOnClickListener(new a());
            a(this.f2458g);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            if (this.f2459h != null) {
                this.f2459h = null;
            }
            WeakReference<VlionDownloadSecondConfirmActivity> weakReference = f2451j;
            if (weakReference != null) {
                weakReference.clear();
                f2451j = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData) {
        VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean;
        try {
            if (isFinishing() || (appInfoBean = vlionCustomParseAdData.getAppInfoBean()) == null) {
                return;
            }
            this.f2456e.setTextDetail(getResources().getString(R.string.vlion_custom_ad_download_now));
            if (appInfoBean.getApp_logo() != null) {
                try {
                    HttpRequestUtil.downloadBitmap(this.f2452a, appInfoBean.getApp_logo().getUrl(), this.f2459h);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            this.f2453b.setText(String.valueOf(appInfoBean.getApp_name()));
            this.f2454c.setText(String.valueOf(appInfoBean.getApp_desc()));
            this.f2455d.setVisibility(8);
            this.f2457f.setAppInfo(appInfoBean);
            this.f2456e.setOnClickListener(new b(new i0(this.f2456e)));
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
