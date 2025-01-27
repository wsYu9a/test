package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface TTNativeAd extends TTClientBidding {

    public interface AdInteractionListener {
        void onAdClicked(View view, TTNativeAd tTNativeAd);

        void onAdCreativeClick(View view, TTNativeAd tTNativeAd);

        void onAdShow(TTNativeAd tTNativeAd);
    }

    public interface EasyPlayWidgetListener {
        JSONObject getEstimatedInteractionArea();

        void onCanRenderFail(JSONObject jSONObject);

        void onCanRenderSuccess(JSONObject jSONObject);

        void onClose();

        void onInfo(JSONObject jSONObject);
    }

    public interface ExpressRenderListener {
        void onRenderSuccess(View view, float f10, float f11, boolean z10);
    }

    void destroy();

    Bitmap getAdLogo();

    View getAdView();

    int getAppCommentNum();

    int getAppScore();

    int getAppSize();

    String getButtonText();

    ComplianceInfo getComplianceInfo();

    String getDescription();

    TTAdDislike getDislikeDialog(Activity activity);

    TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    DislikeInfo getDislikeInfo();

    DownloadStatusController getDownloadStatusController();

    TTImage getIcon();

    List<TTImage> getImageList();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    String getSource();

    String getTitle();

    TTImage getVideoCoverImage();

    void registerViewForInteraction(ViewGroup viewGroup, View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, AdInteractionListener adInteractionListener);

    void render();

    void setActivityForDownloadApp(Activity activity);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setEasyPlayWidgetListener(EasyPlayWidgetListener easyPlayWidgetListener);

    void setExpressRenderListener(ExpressRenderListener expressRenderListener);

    void showInteractionExpressAd(Activity activity);

    void uploadDislikeEvent(String str);
}
