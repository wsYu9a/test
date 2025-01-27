package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ErrorInterface;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_for;
import com.alimm.tanx.core.ad.bean.CreativeItem;
import com.alimm.tanx.core.ad.bean.MediaRenderingMode;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.image.util.ScaleMode;
import com.alimm.tanx.core.image.util.ShapeMode;
import com.alimm.tanx.core.image.util.TanxDrawable;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class TanxFeedAdView extends TanxAdView {
    private static final String TAG = "TanxFeedAdView";
    private final BottomView bottomView;
    protected FrameLayout flAdContentRoot;
    protected ITanxFeedAd iTanxFeedAd;
    TanxImageView ivAd;
    protected ImageView ivAdLogo;
    private final LinearLayout llRoot;
    protected MediaRenderingMode nowMediaRenderingMode;
    private final TitleTextView tvTitle;

    /* renamed from: v */
    protected View f6310v;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView$1 */
    public class AnonymousClass1 implements ImageConfig.ImageBitmapCallback {
        final /* synthetic */ ImageConfig tanxc_do;

        public AnonymousClass1(ImageConfig imageConfig) {
            build = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(String str) {
            TanxFeedUt.utViewDraw(TanxFeedAdView.this.iTanxFeedAd, 0);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(Bitmap bitmap) {
            LogUtils.d(TanxFeedAdView.TAG, "loadImg:" + TanxFeedAdView.this.ivAd.getMeasuredWidth() + ":bm:" + bitmap.getWidth());
            TanxFeedAdView.this.ivAd.setImageBitmap(bitmap);
            TanxFeedAdView.this.ivAd.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
            TanxFeedUt.utViewDraw(TanxFeedAdView.this.iTanxFeedAd, 1);
            TanxFeedAdView.this.iTanxFeedAd.onResourceLoadSuccess();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView$2 */
    public class AnonymousClass2 implements ImageConfig.ImageBitmapCallback {
        final /* synthetic */ ImageConfig tanxc_do;

        public AnonymousClass2(ImageConfig imageConfig) {
            build = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(String str) {
            TanxFeedAdView.this.ivAdLogo.setVisibility(8);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(Bitmap bitmap) {
            TanxFeedAdView.this.ivAdLogo.setImageBitmap(bitmap);
            TanxFeedAdView.this.ivAdLogo.setVisibility(0);
            TanxFeedAdView.this.ivAdLogo.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView$3 */
    public class AnonymousClass3 implements ErrorInterface {
        final /* synthetic */ ITanxFeedExpressAd.OnFeedAdListener tanxc_do;

        public AnonymousClass3(ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
            onFeedAdListener = onFeedAdListener;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ErrorInterface
        public void error(String str) {
            ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener = onFeedAdListener;
            if (onFeedAdListener != null) {
                onFeedAdListener.onAdClose(TanxFeedAdView.this.iTanxFeedAd);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView$4 */
    public class AnonymousClass4 implements ITanxFeedAd.DislikeOnClickListener {
        final /* synthetic */ tanxc_for tanxc_do;

        public AnonymousClass4(tanxc_for tanxc_forVar) {
            tanxc_forVar = tanxc_forVar;
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener
        public void onClick(View view) {
            tanxc_forVar.tanxc_for();
        }
    }

    public TanxFeedAdView(Context context) {
        this(context, null);
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView
    public boolean allowSettingViewSize() {
        return true;
    }

    public View getCloseView() {
        return this.bottomView.getCloseView();
    }

    public void loadAdContent(String str) {
        LogUtils.d(TAG, str + "\n");
        if (ImageManager.getLoader() != null) {
            ImageConfig build = ImageManager.with(this.ivAd.getContext()).url(str).radius(this.nowMediaRenderingMode.getPicRadius2Int(this.ivAd.getContext())).shapeMode(ShapeMode.RECT_ROUND).scaleMode(ScaleMode.FIT_CENTER).build();
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.1
                final /* synthetic */ ImageConfig tanxc_do;

                public AnonymousClass1(ImageConfig build2) {
                    build = build2;
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onFailure(String str2) {
                    TanxFeedUt.utViewDraw(TanxFeedAdView.this.iTanxFeedAd, 0);
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onSuccess(Bitmap bitmap) {
                    LogUtils.d(TanxFeedAdView.TAG, "loadImg:" + TanxFeedAdView.this.ivAd.getMeasuredWidth() + ":bm:" + bitmap.getWidth());
                    TanxFeedAdView.this.ivAd.setImageBitmap(bitmap);
                    TanxFeedAdView.this.ivAd.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                    TanxFeedUt.utViewDraw(TanxFeedAdView.this.iTanxFeedAd, 1);
                    TanxFeedAdView.this.iTanxFeedAd.onResourceLoadSuccess();
                }
            });
        }
    }

    public void loadAdLogo(String str) {
        LogUtils.d(TAG, "loadAdLogo:" + str);
        if (ImageManager.getLoader() != null) {
            ImageConfig build = ImageManager.with(this.ivAdLogo.getContext()).url(str).scaleMode(ScaleMode.FIT_CENTER).build();
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.2
                final /* synthetic */ ImageConfig tanxc_do;

                public AnonymousClass2(ImageConfig build2) {
                    build = build2;
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onFailure(String str2) {
                    TanxFeedAdView.this.ivAdLogo.setVisibility(8);
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onSuccess(Bitmap bitmap) {
                    TanxFeedAdView.this.ivAdLogo.setImageBitmap(bitmap);
                    TanxFeedAdView.this.ivAdLogo.setVisibility(0);
                    TanxFeedAdView.this.ivAdLogo.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                }
            });
        }
    }

    public void loadAdStyle() {
        LogUtils.d(TAG, this.nowMediaRenderingMode.toString());
        if (TanxCoreSdk.getConfig().getSettingConfig().isCustomTextSizeDpSwitch()) {
            this.tvTitle.setTextSize(1, this.nowMediaRenderingMode.getTitleSize2Int());
        } else {
            this.tvTitle.setTextSize(0, DimenUtil.dp2px(r0.getContext(), this.nowMediaRenderingMode.getTitleSize2Int()));
        }
        this.tvTitle.setBackgroundColor(Color.parseColor(this.nowMediaRenderingMode.getBgColor()));
        this.tvTitle.setTextColor(Color.parseColor(this.nowMediaRenderingMode.getTitleColor()));
        this.llRoot.setBackgroundColor(Color.parseColor(this.nowMediaRenderingMode.getBgColor()));
        this.bottomView.setViewStyle(this.nowMediaRenderingMode);
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.d(TAG, "onAttachedToWindow");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && iTanxFeedAd.getBidInfo() != null) {
            this.ivAd.setViewSize(this.iTanxFeedAd.getBidInfo().getTemplateHeight2Int() / this.iTanxFeedAd.getBidInfo().getTemplateWidth2Int());
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(setViewSize(this.iTanxFeedAd, i10), 1073741824), i11);
        LogUtils.d(TAG, "onMeasure-> w:" + View.MeasureSpec.getSize(i10) + " h:" + View.MeasureSpec.getSize(i11));
    }

    public void renderAd() {
        CreativeItem creativeItem;
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || (creativeItem = this.iTanxFeedAd.getBidInfo().getCreativeItem()) == null) {
            return;
        }
        loadAdContent(creativeItem.getImageUrl());
        loadAdLogo(creativeItem.getAdvLogo());
        this.tvTitle.setText(creativeItem.getTitle());
        loadAdStyle();
    }

    public void setTanxFeedAd(ITanxFeedAd iTanxFeedAd, ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        this.iTanxFeedAd = iTanxFeedAd;
        this.bottomView.setTanxFeedAd(iTanxFeedAd);
        LogUtils.d(TAG, "setTanxFeedAd()");
        if (iTanxFeedAd.getBidInfo().getTemplateConf() != null) {
            LogUtils.d(TAG, "setTanxFeedAd()iTanxFeedAd.getBidInfo().getTemplateConf() != null");
            this.nowMediaRenderingMode = iTanxFeedAd.getBidInfo().getTemplateConf().getNowConfig(TanxCoreSdk.getConfig().getSettingConfig().isNightSwitch(), TanxCoreSdk.getConfig().getSettingConfig().isCustomTitleSizeSwitch(), TanxCoreSdk.getConfig().getSettingConfig().getCustomTitleSize());
        }
        if (this.nowMediaRenderingMode != null || onFeedAdListener == null) {
            renderAd();
        } else {
            LogUtils.d(TAG, "日夜间模式对象nowConfig为空");
            onFeedAdListener.onError("日夜间模式对象nowConfig为空");
        }
    }

    public void showDislikeView(Context context, ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener) {
        tanxc_for tanxc_forVar = new tanxc_for(context, this.nowMediaRenderingMode);
        tanxc_forVar.tanxc_do(getCloseView(), new ErrorInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.3
            final /* synthetic */ ITanxFeedExpressAd.OnFeedAdListener tanxc_do;

            public AnonymousClass3(ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener2) {
                onFeedAdListener = onFeedAdListener2;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ErrorInterface
            public void error(String str) {
                ITanxFeedExpressAd.OnFeedAdListener onFeedAdListener2 = onFeedAdListener;
                if (onFeedAdListener2 != null) {
                    onFeedAdListener2.onAdClose(TanxFeedAdView.this.iTanxFeedAd);
                }
            }
        });
        this.iTanxFeedAd.bindDislikeView(tanxc_forVar.tanxc_do(), new ITanxFeedAd.DislikeOnClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView.4
            final /* synthetic */ tanxc_for tanxc_do;

            public AnonymousClass4(tanxc_for tanxc_forVar2) {
                tanxc_forVar = tanxc_forVar2;
            }

            @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd.DislikeOnClickListener
            public void onClick(View view) {
                tanxc_forVar.tanxc_for();
            }
        });
    }

    public TanxFeedAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nowMediaRenderingMode = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tanx_layout_ad_feed, (ViewGroup) this, true);
        this.f6310v = inflate;
        this.tvTitle = (TitleTextView) inflate.findViewById(R.id.tv_title);
        this.llRoot = (LinearLayout) this.f6310v.findViewById(R.id.ll_root);
        this.bottomView = (BottomView) this.f6310v.findViewById(R.id.bottomView);
        this.ivAd = (TanxImageView) this.f6310v.findViewById(R.id.iv_ad);
        this.ivAdLogo = (ImageView) this.f6310v.findViewById(R.id.iv_ad_logo);
        this.flAdContentRoot = (FrameLayout) this.f6310v.findViewById(R.id.fl_ad_content_root);
    }
}
