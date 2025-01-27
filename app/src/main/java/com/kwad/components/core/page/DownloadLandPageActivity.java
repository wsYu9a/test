package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.a.e;
import com.kwad.components.core.page.a.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.InputStream;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes2.dex */
public class DownloadLandPageActivity extends com.kwad.components.core.j.b<com.kwad.components.core.page.a.d> {
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String TAG = "DownloadLandPageActivity";
    public static boolean showingAdWebViewLandPage = false;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ImageView mBackIcon;
    private ImageView mCloseIcon;
    private DetailVideoView mDetailVideoView;
    private boolean mIsRewardLandPage;
    private KSRelativeLayout mKsadVideoContainer;
    private com.kwad.components.core.page.b.a mPlayModule;
    private ImageView mVideoBlurBg;
    private ImageView mVideoCover;
    private i mVideoPlayStateListener;

    /* renamed from: com.kwad.components.core.page.DownloadLandPageActivity$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.kwad.sdk.core.report.a.q(DownloadLandPageActivity.this.mAdTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
            DownloadLandPageActivity.this.finish();
        }
    }

    /* renamed from: com.kwad.components.core.page.DownloadLandPageActivity$2 */
    final class AnonymousClass2 extends SimpleImageLoadingListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.core.page.DownloadLandPageActivity$3 */
    final class AnonymousClass3 implements f.a {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.page.a.f.a
        public final void ay(int i2) {
            if (i2 != 1) {
                DownloadLandPageActivity.this.initNativeLandPage();
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.DownloadLandPageActivity$4 */
    final class AnonymousClass4 extends com.kwad.sdk.core.download.kwai.a {
        final /* synthetic */ DownloadProgressBar Ls;
        final /* synthetic */ AdInfo rX;

        AnonymousClass4(DownloadProgressBar downloadProgressBar, AdInfo adInfo) {
            downloadProgressBar = downloadProgressBar;
            adInfo = adInfo;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            downloadProgressBar.setProgress(100.0f);
            downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aw(adInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            downloadProgressBar.setProgress(100.0f);
            downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aH(DownloadLandPageActivity.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            downloadProgressBar.setProgress(100.0f);
            downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aw(adInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            downloadProgressBar.setProgress(100.0f);
            downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.T(adInfo));
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            downloadProgressBar.setProgress(i2);
            downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.bz(i2));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            downloadProgressBar.setProgress(i2);
            downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.by(i2));
        }
    }

    /* renamed from: com.kwad.components.core.page.DownloadLandPageActivity$5 */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.kwad.sdk.core.report.a.q(DownloadLandPageActivity.this.mAdTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META);
            DownloadLandPageActivity.this.mApkDownloadHelper.m(new a.C0172a(DownloadLandPageActivity.this.getActivity()).ao(true).ap(false).I(DownloadLandPageActivity.this.mAdTemplate).ar(false));
            if (DownloadLandPageActivity.this.mIsRewardLandPage) {
                com.kwad.sdk.core.report.a.a(DownloadLandPageActivity.this.mAdTemplate, new com.kwad.sdk.core.report.i(), (JSONObject) null);
            }
        }
    }

    /* renamed from: com.kwad.components.core.page.DownloadLandPageActivity$6 */
    final class AnonymousClass6 extends j {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            DownloadLandPageActivity.this.mVideoCover.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            DownloadLandPageActivity.this.mVideoCover.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.core.page.DownloadLandPageActivity$7 */
    final class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (DownloadLandPageActivity.this.getActivity() == null || DownloadLandPageActivity.this.getActivity().isFinishing()) {
                return;
            }
            DownloadLandPageActivity.this.mCloseIcon.setVisibility(0);
            DownloadLandPageActivity.this.mCloseIcon.setAlpha(0.0f);
            DownloadLandPageActivity.this.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
        }
    }

    /* renamed from: com.kwad.components.core.page.DownloadLandPageActivity$8 */
    final class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.kwad.components.core.r.c.pL().pM();
            DownloadLandPageActivity.this.finish();
        }
    }

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        if (com.kwad.sdk.core.response.a.a.aU(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            return;
        }
        ((FrameLayout.LayoutParams) complianceTextView.getLayoutParams()).gravity = 80;
        if (!ai.DL()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ksLogoView.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, com.kwad.sdk.c.kwai.a.a(this.mContext, 100.0f));
            ksLogoView.setLayoutParams(marginLayoutParams);
        }
        ksLogoView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kSLinearLayout.getLayoutParams();
        layoutParams.gravity = 17;
        kSLinearLayout.setLayoutParams(layoutParams);
    }

    private i getVideoPlayStateListener() {
        AnonymousClass6 anonymousClass6 = new j() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.6
            AnonymousClass6() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(8);
            }
        };
        this.mVideoPlayStateListener = anonymousClass6;
        return anonymousClass6;
    }

    @NonNull
    private f.a getWebViewStateListener() {
        return new f.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.page.a.f.a
            public final void ay(int i2) {
                if (i2 != 1) {
                    DownloadLandPageActivity.this.initNativeLandPage();
                }
            }
        };
    }

    private void handleCloseBtn() {
        long ad2 = com.kwad.sdk.core.response.a.a.ad(this.mAdInfo);
        if (ad2 == 0) {
            this.mCloseIcon.setVisibility(0);
        } else {
            this.mCloseIcon.postDelayed(new Runnable() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.7
                AnonymousClass7() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (DownloadLandPageActivity.this.getActivity() == null || DownloadLandPageActivity.this.getActivity().isFinishing()) {
                        return;
                    }
                    DownloadLandPageActivity.this.mCloseIcon.setVisibility(0);
                    DownloadLandPageActivity.this.mCloseIcon.setAlpha(0.0f);
                    DownloadLandPageActivity.this.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                }
            }, ad2);
        }
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.8
            AnonymousClass8() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.core.r.c.pL().pM();
                DownloadLandPageActivity.this.finish();
            }
        });
    }

    public void initNativeLandPage() {
        findViewById(R.id.ksad_ad_land_page_native).setVisibility(0);
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_cover);
        TextView textView = (TextView) findViewById(R.id.ksad_ad_title);
        TextView textView2 = (TextView) findViewById(R.id.ksad_ad_info);
        KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.ksad_info_container);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_land_page_logo);
        DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        setAdTitle(textView, cb);
        textView2.setText(cb.adBaseInfo.adDescription);
        roundAngleImageView.setRadius(32.0f);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.bM(cb))) {
            KSImageLoader.loadImage(roundAngleImageView, com.kwad.sdk.core.response.a.a.bM(cb), this.mAdTemplate);
        }
        setAdkDownload(downloadProgressBar, cb);
        buildView(complianceTextView, kSLinearLayout, ksLogoView);
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z) {
        Class cls = ai.DL() ? AdWebViewActivity.class : KsFullScreenLandScapeVideoActivity.class;
        com.kwad.sdk.service.a.a(cls, DownloadLandPageActivity.class);
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_NEED_CLOSE_REWARD, z);
        context.startActivity(intent);
    }

    private void loadBlurImage(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setVisibility(0);
        KSImageLoader.loadImage(imageView, str, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.2
            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }

    private void setAdTitle(TextView textView, AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adBaseInfo.appName)) {
            textView.setText(adInfo.adBaseInfo.appName);
        } else {
            if (TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
                return;
            }
            textView.setText(adInfo.advertiserInfo.rawUserName);
        }
    }

    private void setAdkDownload(DownloadProgressBar downloadProgressBar, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.4
                final /* synthetic */ DownloadProgressBar Ls;
                final /* synthetic */ AdInfo rX;

                AnonymousClass4(DownloadProgressBar downloadProgressBar2, AdInfo adInfo2) {
                    downloadProgressBar = downloadProgressBar2;
                    adInfo = adInfo2;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aw(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aH(DownloadLandPageActivity.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.aw(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.T(adInfo));
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    downloadProgressBar.setProgress(i2);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.bz(i2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    downloadProgressBar.setProgress(i2);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.a.a.by(i2));
                }
            });
            downloadProgressBar2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.5
                AnonymousClass5() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.kwad.sdk.core.report.a.q(DownloadLandPageActivity.this.mAdTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META);
                    DownloadLandPageActivity.this.mApkDownloadHelper.m(new a.C0172a(DownloadLandPageActivity.this.getActivity()).ao(true).ap(false).I(DownloadLandPageActivity.this.mAdTemplate).ar(false));
                    if (DownloadLandPageActivity.this.mIsRewardLandPage) {
                        com.kwad.sdk.core.report.a.a(DownloadLandPageActivity.this.mAdTemplate, new com.kwad.sdk.core.report.i(), (JSONObject) null);
                    }
                }
            });
        }
    }

    private void setVideoData() {
        ViewGroup.LayoutParams layoutParams = this.mKsadVideoContainer.getLayoutParams();
        if (ai.DL()) {
            layoutParams.height = (com.kwad.sdk.c.kwai.a.getScreenWidth(this.mContext) * 9) / 16;
            layoutParams.width = -1;
        } else {
            layoutParams.width = com.kwad.sdk.c.kwai.a.getScreenWidth(this.mContext) / 2;
            layoutParams.height = -1;
        }
        this.mKsadVideoContainer.setLayoutParams(layoutParams);
        this.mKsadVideoContainer.setVisibility(0);
        KSImageLoader.loadImage(this.mVideoCover, com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            if (stringExtra != null) {
                adTemplate.parseJson(new JSONObject(stringExtra));
            }
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        return this.mAdTemplate != null;
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return ai.DL() ? R.layout.ksad_activity_ad_land_page : R.layout.ksad_activity_land_page_horizontal;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return TAG;
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        showingAdWebViewLandPage = true;
        this.mIsRewardLandPage = getIntent().getBooleanExtra(KEY_NEED_CLOSE_REWARD, false);
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.ksad_root_container);
        this.mKsadVideoContainer = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        DetailVideoView detailVideoView = (DetailVideoView) kSRelativeLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.f(true, com.kwad.sdk.core.config.d.uV());
        this.mVideoBlurBg = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_video_blur_bg);
        this.mBackIcon = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_back_icon);
        this.mCloseIcon = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_right_close);
        this.mVideoCover = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_video_cover);
        if (this.mAdTemplate.adInfoList.size() > 0) {
            loadBlurImage(com.kwad.sdk.core.response.a.a.O(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
        }
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.sdk.core.report.a.q(DownloadLandPageActivity.this.mAdTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
                DownloadLandPageActivity.this.finish();
            }
        });
        if (com.kwad.sdk.core.response.a.a.aU(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            setVideoData();
        }
        if (this.mIsRewardLandPage) {
            handleCloseBtn();
        }
    }

    @Override // com.kwad.components.core.j.b
    public com.kwad.components.core.page.a.d onCreateCallerContext() {
        com.kwad.components.core.page.a.d dVar = new com.kwad.components.core.page.a.d(this);
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        if (com.kwad.sdk.core.response.a.a.aU(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(true);
            com.kwad.components.core.page.b.a aVar = new com.kwad.components.core.page.b.a(this.mAdTemplate, this.mDetailVideoView, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
            this.mPlayModule = aVar;
            dVar.mPlayModule = aVar;
            aVar.a(getVideoPlayStateListener());
            dVar.JT.add(this.mPlayModule);
        }
        return dVar;
    }

    @Override // com.kwad.components.core.j.b
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        if (com.kwad.sdk.core.response.a.a.aU(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            presenter.a(new e());
        }
        presenter.a(new f(getWebViewStateListener(), this.mIsRewardLandPage));
        return presenter;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        showingAdWebViewLandPage = false;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        com.kwad.components.core.page.b.a aVar = this.mPlayModule;
        if (aVar != null) {
            aVar.release();
        }
    }
}
