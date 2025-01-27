package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface TTNativeExpressAd extends TTClientBidding {

    public interface AdInteractionListener extends ExpressAdInteractionListener {
        void onAdDismiss();
    }

    public interface ExpressAdInteractionListener {
        void onAdClicked(View view, int i10);

        void onAdShow(View view, int i10);

        void onRenderFail(View view, String str, int i10);

        void onRenderSuccess(View view, float f10, float f11);
    }

    public interface ExpressVideoAdListener {
        void onClickRetry();

        void onProgressUpdate(long j10, long j11);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i10, int i11);

        void onVideoLoad();
    }

    void destroy();

    TTAdDislike getDislikeDialog(Activity activity);

    DislikeInfo getDislikeInfo();

    View getExpressAdView();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void registerClickableRects(JSONObject jSONObject);

    void render();

    void setCanInterruptVideoPlay(boolean z10);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener);

    void setSlideIntervalTime(int i10);

    void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener);

    void showInteractionExpressAd(Activity activity);

    void unRegisterRects();

    void uploadDislikeEvent(String str);
}
