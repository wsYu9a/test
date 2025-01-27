package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager;
import com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.component.AdAnimatableImageView;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.image.util.ScaleMode;
import com.alimm.tanx.core.image.util.TanxDrawable;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxSplashUt;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class tanxc_for extends tanxc_do {
    private LinearLayout tanxc_break;
    private volatile boolean tanxc_catch;
    protected SplashWebViewUtil tanxc_this;
    private AdAnimatableImageView tanxc_void;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for$1 */
    public class AnonymousClass1 implements ImageConfig.ImageBitmapCallback {
        final /* synthetic */ ImageConfig tanxc_do;

        public AnonymousClass1(ImageConfig imageConfig) {
            build = imageConfig;
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onFailure(String str) {
            LogUtils.d("SplashAdImageRenderer", "loadImg: onFailure");
            tanxc_for.this.tanxc_do(UtErrorCode.ERROR_IMG_LOAD.getIntCode(), str);
        }

        @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
        public void onSuccess(Bitmap bitmap) {
            LogUtils.d("SplashAdImageRenderer", "loadImg: Success");
            tanxc_for.this.tanxc_long.onResourceLoadSuccess();
            tanxc_for.this.tanxc_void.setVisibility(0);
            tanxc_for.this.tanxc_void.setImageBitmap(bitmap);
            tanxc_for.this.tanxc_void.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
            tanxc_for.this.tanxc_for();
            tanxc_for.this.tanxc_int();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for$2 */
    public class AnonymousClass2 implements SplashWebViewUtil.SplashWebInterface {
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
            TanxSplashUt.utSplashWebCreate(tanxc_for.this.tanxc_long, 1);
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webDrawStatus(boolean z10) {
            if (z10) {
                LogUtils.d("utLog", "utViewDraw");
            } else {
                if (tanxc_for.this.tanxc_catch) {
                    return;
                }
                TanxBaseUt.utErrorCode(tanxc_for.this.tanxc_long, UtErrorCode.CRASH_H5_ERROR);
                tanxc_for.this.tanxc_catch = true;
            }
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
        public void webError(int i10, String str) {
            LogUtils.e("SplashAdImageRenderer", "webError: cmd :" + i10 + " msg:" + str);
        }
    }

    public tanxc_for(IRenderCallback iRenderCallback, Activity activity, TanxSplashAdView tanxSplashAdView, ITanxAd iTanxAd, boolean z10) {
        super(iRenderCallback, activity, tanxSplashAdView, iTanxAd, z10);
        this.tanxc_catch = false;
        TanxSplashAdView tanxSplashAdView2 = this.tanxc_if;
        if (tanxSplashAdView2 == null) {
            LogUtils.e("SplashAdImageRenderer", "mAdRootView为空终止逻辑");
            return;
        }
        this.tanxc_void = (AdAnimatableImageView) tanxSplashAdView2.findViewById(R.id.xadsdk_splash_ad_image_view);
        this.tanxc_break = (LinearLayout) this.tanxc_if.findViewById(R.id.ll_web_root);
        this.tanxc_void.setVisibility(4);
    }

    private void tanxc_class() {
        ITanxSplashExpressAd iTanxSplashExpressAd = this.tanxc_long;
        if (iTanxSplashExpressAd == null || iTanxSplashExpressAd.getBidInfo() == null || this.tanxc_long.getBidInfo().getTemplateConf() == null || TextUtils.isEmpty(this.tanxc_long.getBidInfo().getTemplateConf().getPidStyleId()) || !this.tanxc_long.getBidInfo().getTemplateConf().getPidStyleId().equals(AdConstants.PID_STYLE_SPLASH_WEB_ID)) {
            return;
        }
        TanxCommonUt.utWebStartLoad(this.tanxc_long);
        SplashWebViewUtil splashWebViewUtil = new SplashWebViewUtil();
        this.tanxc_this = splashWebViewUtil;
        splashWebViewUtil.tanxc_do(this.tanxc_break, this.tanxc_long, this.tanxc_if, new SplashWebViewUtil.SplashWebInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.2
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
                TanxSplashUt.utSplashWebCreate(tanxc_for.this.tanxc_long, 1);
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webDrawStatus(boolean z10) {
                if (z10) {
                    LogUtils.d("utLog", "utViewDraw");
                } else {
                    if (tanxc_for.this.tanxc_catch) {
                        return;
                    }
                    TanxBaseUt.utErrorCode(tanxc_for.this.tanxc_long, UtErrorCode.CRASH_H5_ERROR);
                    tanxc_for.this.tanxc_catch = true;
                }
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface
            public void webError(int i10, String str) {
                LogUtils.e("SplashAdImageRenderer", "webError: cmd :" + i10 + " msg:" + str);
            }
        });
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do
    public void tanxc_char() {
        super.tanxc_char();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do
    public void tanxc_if() {
        if (this.tanxc_for == null) {
            tanxc_do(UtErrorCode.ERROR_NO_BID_INFO.getIntCode());
            return;
        }
        this.tanxc_try = SystemClock.elapsedRealtime();
        SplashAdCacheManager.getInstance();
        String splashCacheFile = SplashAdCacheManager.getSplashCacheFile(this.tanxc_do, this.tanxc_for.getCreativeName());
        if (TextUtils.isEmpty(splashCacheFile) || !SplashAdCacheManager.getInstance().isFileMd5Matched(this.tanxc_for, splashCacheFile)) {
            LogUtils.d("SplashAdImageRenderer", "no cache bitmap Or Md5 not match 校验广告素材，没有缓存路径或者md5验证不通过，走在线URL素材展示");
            splashCacheFile = this.tanxc_for.getCreativePath();
        } else {
            LogUtils.d("SplashAdImageRenderer", "有本地缓存的文件素材，走缓存文件曝光展示");
        }
        if (!TextUtils.isEmpty(splashCacheFile)) {
            tanxc_do(splashCacheFile);
        } else {
            LogUtils.d("SplashAdImageRenderer", "do Start: 实时请求下来的广告素材的url为空，无法进行展示报错");
            tanxc_do(UtErrorCode.ERROR_RS_INVALID.getIntCode());
        }
    }

    private void tanxc_do(String str) {
        LogUtils.d("SplashAdImageRenderer", "showAdView: imgUrl =" + str);
        if (TextUtils.isEmpty(str)) {
            tanxc_do(UtErrorCode.ERROR_RS_INVALID.getIntCode());
            return;
        }
        if (ImageManager.getLoader() != null) {
            ImageConfig build = ImageManager.with(this.tanxc_do).url(str).scaleMode(ScaleMode.CENTER_CROP).build();
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_for.1
                final /* synthetic */ ImageConfig tanxc_do;

                public AnonymousClass1(ImageConfig build2) {
                    build = build2;
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onFailure(String str2) {
                    LogUtils.d("SplashAdImageRenderer", "loadImg: onFailure");
                    tanxc_for.this.tanxc_do(UtErrorCode.ERROR_IMG_LOAD.getIntCode(), str2);
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onSuccess(Bitmap bitmap) {
                    LogUtils.d("SplashAdImageRenderer", "loadImg: Success");
                    tanxc_for.this.tanxc_long.onResourceLoadSuccess();
                    tanxc_for.this.tanxc_void.setVisibility(0);
                    tanxc_for.this.tanxc_void.setImageBitmap(bitmap);
                    tanxc_for.this.tanxc_void.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                    tanxc_for.this.tanxc_for();
                    tanxc_for.this.tanxc_int();
                }
            });
        } else {
            LogUtils.e("SplashAdImageRenderer", "ImageManager.getLoader()为空");
            tanxc_do(UtErrorCode.IMAGE_LOAD_NULL.getIntCode());
        }
        super.tanxc_catch();
        tanxc_class();
    }
}
