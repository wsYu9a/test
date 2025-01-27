package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PatchVideoNative {
    private String mAdPlaceId;
    private PrerollVideoResponse mAdResponse;
    private String mAppSid;
    private BaiduNativeManager mBaiduNativeManager;
    private Context mContext;
    private boolean mIsMute;
    private IPatchVideoNativeListener mListener;
    private RelativeLayout mParentView;
    private PatchAdView mPatchView;

    /* renamed from: com.baidu.mobads.sdk.api.PatchVideoNative$1 */
    class AnonymousClass1 implements BaiduNativeManager.FeedAdListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i10, String str, NativeResponse nativeResponse) {
            PatchVideoNative.this.callLoadFail(i10, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(List<NativeResponse> list) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                arrayList.add(new XAdVideoResponse(list.get(i10)));
            }
            PatchVideoNative.this.mAdResponse = (PrerollVideoResponse) arrayList.get(0);
            PatchVideoNative.this.callLoadSucc();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i10, String str, NativeResponse nativeResponse) {
            PatchVideoNative.this.callLoadFail(i10, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.PatchVideoNative$2 */
    class AnonymousClass2 implements IPatchAdListener {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.IPatchAdListener
        public void onAdClicked() {
            PatchVideoNative.this.callAdClick();
        }

        @Override // com.baidu.mobads.sdk.api.IPatchAdListener
        public void onAdShow() {
            PatchVideoNative.this.callAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.IPatchAdListener
        public void playCompletion() {
            PatchVideoNative.this.callPlayCompletion();
        }

        @Override // com.baidu.mobads.sdk.api.IPatchAdListener
        public void playError() {
            PatchVideoNative.this.callPlayError();
        }
    }

    public interface IPatchVideoNativeListener {
        void onAdClick();

        void onAdFailed(int i10, String str);

        void onAdLoad(String str);

        void onAdShow();

        void playCompletion();

        void playError();
    }

    public PatchVideoNative(Context context, String str, RelativeLayout relativeLayout, IPatchVideoNativeListener iPatchVideoNativeListener) {
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mParentView = relativeLayout;
        this.mListener = iPatchVideoNativeListener;
        this.mBaiduNativeManager = new BaiduNativeManager(this.mContext, this.mAdPlaceId);
    }

    public void callAdClick() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdClick();
        }
    }

    public void callAdShow() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdShow();
        }
    }

    public void callLoadFail(int i10, String str) {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdFailed(i10, str);
        }
    }

    public void callLoadSucc() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdLoad(this.mAdResponse.getMaterialType());
        }
        PatchAdView patchAdView = new PatchAdView(this.mContext);
        this.mPatchView = patchAdView;
        patchAdView.setVideoVolume(this.mIsMute);
        this.mParentView.addView(this.mPatchView, new RelativeLayout.LayoutParams(-1, -1));
        this.mPatchView.setPatchAdListener(new IPatchAdListener() { // from class: com.baidu.mobads.sdk.api.PatchVideoNative.2
            public AnonymousClass2() {
            }

            @Override // com.baidu.mobads.sdk.api.IPatchAdListener
            public void onAdClicked() {
                PatchVideoNative.this.callAdClick();
            }

            @Override // com.baidu.mobads.sdk.api.IPatchAdListener
            public void onAdShow() {
                PatchVideoNative.this.callAdShow();
            }

            @Override // com.baidu.mobads.sdk.api.IPatchAdListener
            public void playCompletion() {
                PatchVideoNative.this.callPlayCompletion();
            }

            @Override // com.baidu.mobads.sdk.api.IPatchAdListener
            public void playError() {
                PatchVideoNative.this.callPlayError();
            }
        });
        this.mPatchView.setAdData((XAdVideoResponse) this.mAdResponse);
    }

    public void callPlayCompletion() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.playCompletion();
        }
    }

    public void callPlayError() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.playError();
        }
    }

    public long getCurrentPosition() {
        PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            return patchAdView.getCurrentPosition();
        }
        return 0L;
    }

    public long getDuration() {
        PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            return patchAdView.getDuration();
        }
        return 0L;
    }

    public void requestAd(RequestParameters requestParameters) {
        BaiduNativeManager baiduNativeManager = this.mBaiduNativeManager;
        if (baiduNativeManager != null) {
            baiduNativeManager.setAppSid(this.mAppSid);
            this.mBaiduNativeManager.loadPrerollVideo(requestParameters, new BaiduNativeManager.FeedAdListener() { // from class: com.baidu.mobads.sdk.api.PatchVideoNative.1
                public AnonymousClass1() {
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onLpClosed() {
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNativeFail(int i10, String str, NativeResponse nativeResponse) {
                    PatchVideoNative.this.callLoadFail(i10, str);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNativeLoad(List<NativeResponse> list) {
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        arrayList.add(new XAdVideoResponse(list.get(i10)));
                    }
                    PatchVideoNative.this.mAdResponse = (PrerollVideoResponse) arrayList.get(0);
                    PatchVideoNative.this.callLoadSucc();
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNoAd(int i10, String str, NativeResponse nativeResponse) {
                    PatchVideoNative.this.callLoadFail(i10, str);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onVideoDownloadFailed() {
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onVideoDownloadSuccess() {
                }
            });
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setVideoMute(boolean z10) {
        this.mIsMute = z10;
        PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            patchAdView.setVideoVolume(z10);
        }
    }
}
