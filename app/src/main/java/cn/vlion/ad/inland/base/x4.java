package cn.vlion.ad.inland.base;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity;
import cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.w1;

/* loaded from: classes.dex */
public final class x4 extends PopupWindow {

    /* renamed from: a */
    public Activity f3491a;

    /* renamed from: b */
    public ImageView f3492b;

    /* renamed from: c */
    public TextView f3493c;

    /* renamed from: d */
    public TextView f3494d;

    /* renamed from: e */
    public VlionButtonSolidBgView f3495e;

    /* renamed from: f */
    public VlionDownloadBottomTextView f3496f;

    /* renamed from: g */
    public ImageView f3497g;

    /* renamed from: h */
    public VlionDownloadSecondConfirmActivity.d f3498h;

    /* renamed from: i */
    public f f3499i = new f();

    public class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    public class b implements VlionButtonSolidBgView.e {

        /* renamed from: a */
        public final /* synthetic */ i0 f3500a;

        public b(i0 i0Var) {
            this.f3500a = i0Var;
        }

        @Override // cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView.e
        public final void onClick() {
            try {
                VlionDownloadSecondConfirmActivity.d dVar = x4.this.f3498h;
                if (dVar != null) {
                    dVar.a(new VlionADClickType("click", this.f3500a.b(), "download", "button", ""));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            x4.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VlionDownloadSecondConfirmActivity.d dVar = x4.this.f3498h;
                if (dVar != null) {
                    dVar.a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            x4.this.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VlionDownloadSecondConfirmActivity.d dVar = x4.this.f3498h;
                if (dVar != null) {
                    dVar.a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            x4.this.dismiss();
        }
    }

    public class e implements View.OnKeyListener {
        public e() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (i10 != 4) {
                return false;
            }
            try {
                VlionDownloadSecondConfirmActivity.d dVar = x4.this.f3498h;
                if (dVar != null) {
                    dVar.a();
                }
                x4.this.dismiss();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return false;
            }
        }
    }

    public class f implements ImageCallback {
        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        }
    }

    public x4(Activity activity) {
        this.f3491a = activity;
        a();
    }

    public final void a() {
        try {
            View inflate = LayoutInflater.from(this.f3491a).inflate(R.layout.vlion_cn_ad_download_layout, (ViewGroup) null, false);
            setContentView(inflate);
            setWidth(-1);
            setHeight(-1);
            setFocusable(true);
            setOutsideTouchable(false);
            this.f3492b = (ImageView) inflate.findViewById(R.id.vlion_ad_app_icon);
            this.f3493c = (TextView) inflate.findViewById(R.id.vlion_ad_app_name);
            this.f3494d = (TextView) inflate.findViewById(R.id.vlion_ad_app_des);
            this.f3495e = (VlionButtonSolidBgView) inflate.findViewById(R.id.vlion_button_solidbg_download_view);
            this.f3496f = (VlionDownloadBottomTextView) inflate.findViewById(R.id.vlion_ad_app_detal);
            this.f3497g = (ImageView) inflate.findViewById(R.id.vlion_ad_closed);
            inflate.findViewById(R.id.vlion_ad_endcard_fl).setOnClickListener(new a());
            this.f3495e.setButtonClickListener(new b(new i0(this.f3495e)));
            this.f3497g.setOnClickListener(new c());
            inflate.setOnClickListener(new d());
            inflate.setOnKeyListener(new e());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        try {
            super.dismiss();
            if (this.f3499i != null) {
                this.f3499i = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(View view, VlionCustomParseAdData vlionCustomParseAdData, w1.a aVar) {
        if (view == null || vlionCustomParseAdData == null) {
            return;
        }
        try {
            Activity activity = this.f3491a;
            if (activity != null && !activity.isFinishing()) {
                showAtLocation(view, 80, 0, 0);
                this.f3498h = aVar;
                VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean = vlionCustomParseAdData.getAppInfoBean();
                if (appInfoBean == null) {
                    return;
                }
                this.f3495e.setShakeStyle(this.f3491a.getString(R.string.vlion_custom_ad_download_now), false);
                if (appInfoBean.getApp_logo() != null) {
                    HttpRequestUtil.downloadBitmap(this.f3492b, appInfoBean.getApp_logo().getUrl(), this.f3499i);
                }
                this.f3493c.setText(String.valueOf(appInfoBean.getApp_name()));
                this.f3494d.setText(String.valueOf(appInfoBean.getApp_desc()));
                this.f3496f.setAppInfo(appInfoBean);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
