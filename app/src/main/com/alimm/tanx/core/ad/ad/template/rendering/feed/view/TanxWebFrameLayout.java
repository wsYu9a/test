package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class TanxWebFrameLayout extends FrameLayout implements NotConfused {
    private final String TAG;
    protected WebView addView;
    protected Button btnReLoadH5;
    private boolean errorCreateViewUtUpload;
    protected ITanxAd iTanxFeedAd;
    private volatile boolean isH5Ut;
    private boolean isShowWebStatusUi;
    private boolean isTemplateRender;
    protected ImageView ivLoading;
    protected LinearLayout llWeb;
    protected LinearLayout llWebError;
    protected LinearLayout llWebLoading;
    protected TanxAdView parentTanxAdView;
    float radio;
    protected RelativeLayout rlRoot;

    /* renamed from: v */
    protected View f6311v;
    protected FeedWebViewUtil webViewUtil;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout$1 */
    public class AnonymousClass1 extends ViewClickListener {
        final /* synthetic */ boolean val$clickable;

        public AnonymousClass1(boolean z10) {
            z10 = z10;
        }

        @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
        public void viewClick(View view) {
            TanxWebFrameLayout.this.showErrorUi(false);
            TanxWebFrameLayout.this.loadWeb(z10);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout$2 */
    public class AnonymousClass2 implements FeedWebViewUtil.FeedWebInterface {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adClose() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void adSkip(boolean z10) {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void h5NotifyDrawSuccess() {
            TanxWebFrameLayout.this.showErrorUi(false);
            TanxFeedUt.utViewDraw(TanxWebFrameLayout.this.iTanxFeedAd, 1);
            TanxWebFrameLayout.this.iTanxFeedAd.onResourceLoadSuccess();
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z10) {
            if (z10) {
                LogUtils.d("utLog", "utViewDraw");
            } else {
                if (!TanxWebFrameLayout.this.isH5Ut) {
                    TanxBaseUt.utErrorCode(TanxWebFrameLayout.this.iTanxFeedAd, UtErrorCode.CRASH_H5_ERROR);
                    TanxWebFrameLayout.this.isH5Ut = true;
                }
                TanxWebFrameLayout.this.showErrorUi(true);
            }
            TanxWebFrameLayout.this.loading(false);
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i10, String str) {
            LogUtils.e("TanxWebFrameLayout", "webError: cmd :" + i10 + " msg:" + str);
            TanxWebFrameLayout.this.showErrorUi(true);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout$3 */
    public class AnonymousClass3 implements ImageConfig.GifCallback {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
        public void onFailure(String str) {
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
        public void onSuccess() {
        }
    }

    public TanxWebFrameLayout(Context context) {
        this(context, null);
    }

    private void errorCreateViewUt() {
        if (this.errorCreateViewUtUpload) {
            return;
        }
        this.errorCreateViewUtUpload = true;
        TanxFeedUt.utViewDraw(this.iTanxFeedAd, 0);
    }

    private void initClick(boolean z10) {
        this.btnReLoadH5.setOnClickListener(new ViewClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.1
            final /* synthetic */ boolean val$clickable;

            public AnonymousClass1(boolean z102) {
                z10 = z102;
            }

            @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
            public void viewClick(View view) {
                TanxWebFrameLayout.this.showErrorUi(false);
                TanxWebFrameLayout.this.loadWeb(z10);
            }
        });
    }

    public /* synthetic */ void lambda$loading$2(boolean z10) {
        if (this.isShowWebStatusUi) {
            if (!z10) {
                this.llWebLoading.setVisibility(8);
                return;
            }
            TanxCoreSdk.getConfig().getImageLoader().loadGif(new GifConfig(this.ivLoading, R.drawable.tanx_loading), new ImageConfig.GifCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.3
                public AnonymousClass3() {
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
                public void onFailure(String str) {
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
                public void onSuccess() {
                }
            });
            this.llWebLoading.setVisibility(0);
        }
    }

    public /* synthetic */ void lambda$showErrorUi$1(boolean z10) {
        if (!z10) {
            this.llWebError.setVisibility(8);
            return;
        }
        if (this.isShowWebStatusUi) {
            this.llWebError.setVisibility(0);
        } else {
            setVisibility(8);
        }
        errorCreateViewUt();
    }

    public void loadWeb(boolean z10) {
        loading(true);
        TanxCommonUt.utWebStartLoad(this.iTanxFeedAd);
        FeedWebViewUtil feedWebViewUtil = new FeedWebViewUtil();
        this.webViewUtil = feedWebViewUtil;
        feedWebViewUtil.tanxc_do(this.llWeb, z10, this.iTanxFeedAd, this.parentTanxAdView, new FeedWebViewUtil.FeedWebInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.2
            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void adClose() {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void adSkip(boolean z102) {
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void h5NotifyDrawSuccess() {
                TanxWebFrameLayout.this.showErrorUi(false);
                TanxFeedUt.utViewDraw(TanxWebFrameLayout.this.iTanxFeedAd, 1);
                TanxWebFrameLayout.this.iTanxFeedAd.onResourceLoadSuccess();
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webDrawStatus(boolean z102) {
                if (z102) {
                    LogUtils.d("utLog", "utViewDraw");
                } else {
                    if (!TanxWebFrameLayout.this.isH5Ut) {
                        TanxBaseUt.utErrorCode(TanxWebFrameLayout.this.iTanxFeedAd, UtErrorCode.CRASH_H5_ERROR);
                        TanxWebFrameLayout.this.isH5Ut = true;
                    }
                    TanxWebFrameLayout.this.showErrorUi(true);
                }
                TanxWebFrameLayout.this.loading(false);
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webError(int i10, String str) {
                LogUtils.e("TanxWebFrameLayout", "webError: cmd :" + i10 + " msg:" + str);
                TanxWebFrameLayout.this.showErrorUi(true);
            }
        });
    }

    public void loading(boolean z10) {
        this.llWebLoading.post(new Runnable() { // from class: q1.a

            /* renamed from: c */
            public final /* synthetic */ boolean f29935c;

            public /* synthetic */ a(boolean z102) {
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TanxWebFrameLayout.this.lambda$loading$2(z10);
            }
        });
    }

    public void showErrorUi(boolean z10) {
        this.llWebError.post(new Runnable() { // from class: q1.b

            /* renamed from: c */
            public final /* synthetic */ boolean f29937c;

            public /* synthetic */ b(boolean z102) {
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TanxWebFrameLayout.this.lambda$showErrorUi$1(z10);
            }
        });
    }

    public void loadAd(ITanxAd iTanxAd, boolean z10, TanxAdView tanxAdView) {
        this.iTanxFeedAd = iTanxAd;
        this.parentTanxAdView = tanxAdView;
        this.errorCreateViewUtUpload = false;
        loadWeb(z10);
        initClick(z10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.isTemplateRender) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * this.radio), 1073741824));
        } else {
            super.onMeasure(i10, i11);
        }
    }

    public void setShowWebStatusUi(boolean z10) {
        this.isShowWebStatusUi = z10;
    }

    public void setTemplateRender(boolean z10) {
        this.isTemplateRender = z10;
    }

    public void setViewSize(float f10) {
        this.radio = f10;
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.TAG = "TanxWebFrameLayout";
        this.isH5Ut = false;
        this.errorCreateViewUtUpload = false;
        this.isShowWebStatusUi = true;
        this.isTemplateRender = true;
        this.radio = 0.56f;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tanx_layout_ad_feed_item_web, (ViewGroup) this, true);
        this.f6311v = inflate;
        this.rlRoot = (RelativeLayout) inflate.findViewById(R.id.rl_root);
        this.llWeb = (LinearLayout) this.f6311v.findViewById(R.id.ll_web);
        this.llWebError = (LinearLayout) this.f6311v.findViewById(R.id.ll_web_error);
        this.llWebLoading = (LinearLayout) this.f6311v.findViewById(R.id.ll_web_loading);
        this.ivLoading = (ImageView) this.f6311v.findViewById(R.id.iv_loading);
        this.btnReLoadH5 = (Button) this.f6311v.findViewById(R.id.btn_re_load_h5);
    }
}
