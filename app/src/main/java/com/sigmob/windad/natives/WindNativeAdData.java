package com.sigmob.windad.natives;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.windad.WindAdError;
import java.util.List;

/* loaded from: classes4.dex */
public interface WindNativeAdData {

    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i10, String str, boolean z10);

        void onShow();
    }

    public interface NativeADMediaListener {
        void onVideoCompleted();

        void onVideoError(WindAdError windAdError);

        void onVideoLoad();

        void onVideoPause();

        void onVideoResume();

        void onVideoStart();
    }

    void bindImageViews(List<ImageView> list, int i10);

    void bindMediaView(ViewGroup viewGroup, NativeADMediaListener nativeADMediaListener);

    void bindMediaViewWithoutAppInfo(ViewGroup viewGroup, NativeADMediaListener nativeADMediaListener);

    void bindViewForInteraction(View view, List<View> list, List<View> list2, View view2, NativeADEventListener nativeADEventListener);

    void destroy();

    AdAppInfo getAdAppInfo();

    Bitmap getAdLogo();

    int getAdPatternType();

    String getCTAText();

    String getDesc();

    String getEcpm();

    String getIconUrl();

    List<SigImage> getImageList();

    String getTitle();

    int getVideoHeight();

    int getVideoWidth();

    View getWidgetView(int i10, int i11);

    void pauseVideo();

    void resumeVideo();

    void setDislikeInteractionCallback(Activity activity, DislikeInteractionCallback dislikeInteractionCallback);

    void startVideo();

    void stopVideo();
}
