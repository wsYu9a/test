package cn.vlion.ad.inland.base;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView;
import cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView;
import cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class k3 extends x3 {

    /* renamed from: b */
    public VlionDownloadVideoLayout f3026b;

    /* renamed from: c */
    public FrameLayout f3027c;

    /* renamed from: d */
    public VlionButtonSolidBgView f3028d;

    /* renamed from: e */
    public VlionAdClosedView f3029e;

    /* renamed from: f */
    public VlionVideoEndCardView f3030f;

    /* renamed from: g */
    public w3 f3031g;

    /* renamed from: h */
    public LinearLayout f3032h;

    /* renamed from: i */
    public VlionDownloadBottomTextView f3033i;

    /* renamed from: j */
    public ImageView f3034j;

    /* renamed from: k */
    public TextView f3035k;

    /* renamed from: l */
    public TextView f3036l;

    /* renamed from: m */
    public TextView f3037m;

    /* renamed from: n */
    public FrameLayout f3038n;

    /* renamed from: o */
    public TextView f3039o;

    /* renamed from: p */
    public a f3040p;

    public class a implements ImageCallback {
        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        }
    }

    public k3(Context context, int i10) {
        super(context);
        this.f3040p = new a();
        try {
            LayoutInflater.from(getContext()).inflate(R.layout.vlion_cn_ad_custom_style_video_download_horizontal, (ViewGroup) this, true);
            e();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(int i10) {
        try {
            if (i10 <= 0) {
                FrameLayout frameLayout = this.f3038n;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                VlionAdClosedView vlionAdClosedView = this.f3029e;
                if (vlionAdClosedView != null) {
                    vlionAdClosedView.setVisibility(0);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.f3038n;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            VlionAdClosedView vlionAdClosedView2 = this.f3029e;
            if (vlionAdClosedView2 != null) {
                vlionAdClosedView2.setVisibility(8);
            }
            TextView textView = this.f3039o;
            if (textView != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.valueOf(i10 + " "));
                sb2.append(getContext().getResources().getString(R.string.vlion_custom_ad_close_title));
                textView.setText(sb2.toString());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void b() {
        try {
            VlionDownloadVideoLayout vlionDownloadVideoLayout = this.f3026b;
            if (vlionDownloadVideoLayout != null) {
                vlionDownloadVideoLayout.c();
            }
            VlionButtonSolidBgView vlionButtonSolidBgView = this.f3028d;
            if (vlionButtonSolidBgView != null) {
                vlionButtonSolidBgView.onDestroy();
            }
            if (this.f3040p != null) {
                this.f3040p = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void c() {
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void d() {
    }

    public final void e() {
        try {
            this.f3026b = (VlionDownloadVideoLayout) findViewById(R.id.vlion_download_videolayout);
            this.f3027c = (FrameLayout) findViewById(R.id.ll_vlion_ad_view);
            this.f3028d = (VlionButtonSolidBgView) findViewById(R.id.vlion_button_solidbg_view);
            this.f3029e = (VlionAdClosedView) findViewById(R.id.vlion_ad_closed);
            this.f3030f = (VlionVideoEndCardView) findViewById(R.id.vlionVideoEndcardView);
            this.f3032h = (LinearLayout) findViewById(R.id.vlion_ad_inter_model_container);
            this.f3033i = (VlionDownloadBottomTextView) findViewById(R.id.vlionDownloadBottomTextView);
            this.f3034j = (ImageView) findViewById(R.id.vlion_iv_icon);
            this.f3035k = (TextView) findViewById(R.id.vlion_tv_title);
            this.f3036l = (TextView) findViewById(R.id.vlion_ad_des_title);
            this.f3037m = (TextView) findViewById(R.id.vlion_tv_des);
            this.f3038n = (FrameLayout) findViewById(R.id.vilon_cn_timer_ll);
            this.f3039o = (TextView) findViewById(R.id.vilon_cn_timer_text);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public ViewGroup getAdViewContainer() {
        return this.f3027c;
    }

    @Override // cn.vlion.ad.inland.base.x3
    public void setImageGravity(int i10) {
        VlionVideoEndCardView vlionVideoEndCardView = this.f3030f;
        if (vlionVideoEndCardView != null) {
            vlionVideoEndCardView.setImageGravity(i10);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public void setProgress(int i10) {
        try {
            VlionButtonSolidBgView vlionButtonSolidBgView = this.f3028d;
            if (vlionButtonSolidBgView != null) {
                vlionButtonSolidBgView.setProgress(i10);
            }
            VlionVideoEndCardView vlionVideoEndCardView = this.f3030f;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.setProgress(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(String str) {
        try {
            if (this.f3026b != null) {
                ImageView imageView = (ImageView) findViewById(R.id.vlion_doingsimage);
                LogVlion.e("VlionMovieDrawable - init- videoLayout.getWidth() =" + this.f3026b.getWidth());
                int width = ((double) this.f3026b.getWidth()) / 2.2d > l5.c.f27899e ? (int) (this.f3026b.getWidth() / 2.2d) : 300;
                LogVlion.e("VlionMovieDrawable - init- mViewWidth =" + width);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = width;
                imageView.setLayoutParams(layoutParams);
                HttpRequestUtil.downloadDrawableNeedCache(imageView, str, null);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void b(int i10) {
        try {
            if (i10 <= 0) {
                FrameLayout frameLayout = this.f3038n;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.f3038n;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            TextView textView = this.f3039o;
            if (textView != null) {
                textView.setText(String.valueOf(i10 + "s"));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(String str, boolean z10) {
        try {
            VlionButtonSolidBgView vlionButtonSolidBgView = this.f3028d;
            if (vlionButtonSolidBgView != null) {
                vlionButtonSolidBgView.setShakeStyle(str, z10);
            }
            VlionVideoEndCardView vlionVideoEndCardView = this.f3030f;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.a(str, z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(String str, boolean z10, boolean z11) {
        try {
            this.f3490a = z11;
            this.f3029e.a(str, z10, new b());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final boolean a() {
        try {
            VlionVideoEndCardView vlionVideoEndCardView = this.f3030f;
            if (vlionVideoEndCardView != null) {
                if (vlionVideoEndCardView.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public class b implements VlionAdClosedView.d {
        public b() {
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a() {
            try {
                k3 k3Var = k3.this;
                VlionDownloadVideoLayout vlionDownloadVideoLayout = k3Var.f3026b;
                if (vlionDownloadVideoLayout.f2523m) {
                    ((VlionCustomInterstitialActivity.e) k3Var.f3031g).a(vlionDownloadVideoLayout.getCurrent(), true);
                } else {
                    w3 w3Var = k3Var.f3031g;
                    if (w3Var != null) {
                        ((VlionCustomInterstitialActivity.e) w3Var).a(vlionDownloadVideoLayout.getCurrent(), true);
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a(boolean z10) {
            try {
                k3 k3Var = k3.this;
                VlionDownloadVideoLayout vlionDownloadVideoLayout = k3Var.f3026b;
                if (vlionDownloadVideoLayout.f2523m) {
                    ((VlionCustomInterstitialActivity.e) k3Var.f3031g).a(vlionDownloadVideoLayout.getCurrent(), z10);
                } else {
                    w3 w3Var = k3Var.f3031g;
                    if (w3Var != null) {
                        ((VlionCustomInterstitialActivity.e) w3Var).a(vlionDownloadVideoLayout.getCurrent(), z10);
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(VlionCustomParseAdData vlionCustomParseAdData, View view, boolean z10, boolean z11, int i10, boolean z12, boolean z13, VlionCustomInterstitialActivity.e eVar) {
        if (view == null || vlionCustomParseAdData == null) {
            return;
        }
        try {
            this.f3031g = eVar;
            if (z10) {
                VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean = vlionCustomParseAdData.getAppInfoBean();
                if (appInfoBean == null) {
                    return;
                }
                if (appInfoBean.getApp_logo() != null) {
                    HttpRequestUtil.downloadBitmap(this.f3034j, appInfoBean.getApp_logo().getUrl(), this.f3040p);
                }
                this.f3035k.setText(String.valueOf(appInfoBean.getApp_name()));
                this.f3037m.setText(String.valueOf(appInfoBean.getApp_desc()));
                this.f3033i.setVisibility(0);
                this.f3033i.setAppInfo(vlionCustomParseAdData.getAppInfoBean());
            } else {
                HttpRequestUtil.downloadBitmap(this.f3034j, vlionCustomParseAdData.getBrand_logo(), this.f3040p);
                this.f3035k.setText(String.valueOf(vlionCustomParseAdData.getBrand_name()));
                this.f3036l.setText(String.valueOf(vlionCustomParseAdData.getTitle()));
                this.f3036l.setVisibility(0);
                if (TextUtils.isEmpty(vlionCustomParseAdData.getDes())) {
                    this.f3037m.setVisibility(8);
                } else {
                    this.f3037m.setText(String.valueOf(vlionCustomParseAdData.getDes()));
                }
                this.f3033i.setVisibility(8);
            }
            this.f3026b.a(view, z11, this.f3490a, i10, z12, z13, vlionCustomParseAdData.getmDefaultVal(), vlionCustomParseAdData.getMacroValues(), new i3(this, eVar, vlionCustomParseAdData, z10, i10));
            this.f3028d.setButtonClickListener(new j3(this, eVar, new i0(this.f3028d), vlionCustomParseAdData));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
