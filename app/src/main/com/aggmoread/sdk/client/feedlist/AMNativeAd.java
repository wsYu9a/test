package com.aggmoread.sdk.client.feedlist;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.client.AMAdInterface;
import com.aggmoread.sdk.client.AMAdMediaListener;
import com.aggmoread.sdk.client.AMAdMediaView;
import com.aggmoread.sdk.client.AMAppInfo;
import java.util.List;

/* loaded from: classes.dex */
public interface AMNativeAd extends AMAdInterface {
    View bindAdToView(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull AMNativeInteractionListener aMNativeInteractionListener);

    View bindAdToView(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, @NonNull AMNativeInteractionListener aMNativeInteractionListener);

    void bindCTAViews(List<View> list);

    void bindMediaAdToView(@NonNull AMAdMediaView aMAdMediaView, AMAdMediaListener aMAdMediaListener);

    @Override // com.aggmoread.sdk.client.AMAdInterface
    void destroy();

    int getAdPatternType();

    AMAppInfo getAppInfo();

    double getAppPrice();

    int getAppScore();

    int getAppStatus();

    String getCTAText();

    String getDesc();

    long getDownloadCount();

    String getIconUrl();

    String getImageUrl();

    List<String> getImageUrlList();

    int getPictureHeight();

    int getPictureWidth();

    int getProgress();

    String getTitle();

    int getVideoCurrentPosition();

    int getVideoDuration();

    boolean isAppAd();

    boolean isVideoAd();

    void pauseVideo();

    View renderView(View view);

    void resume();

    void resumeVideo();

    void setVideoMute(boolean z10);

    void startVideo();

    void stopVideo();
}
