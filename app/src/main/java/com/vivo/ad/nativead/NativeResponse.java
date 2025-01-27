package com.vivo.ad.nativead;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.vivo.ad.model.AppElement;
import com.vivo.ad.view.IActionView;
import com.vivo.mobilead.unified.IBidding;
import com.vivo.mobilead.unified.base.view.NativeVideoView;
import com.vivo.mobilead.unified.base.view.VivoNativeAdContainer;
import java.util.List;

/* loaded from: classes4.dex */
public interface NativeResponse extends IBidding {
    public static final int MODE_GROUP = 1;
    public static final int MODE_LARGE = 2;
    public static final int MODE_LARGE_VERTICAL = 6;
    public static final int MODE_SMALL = 3;
    public static final int MODE_UNKNOW = -1;
    public static final int MODE_VIDEO = 4;
    public static final int MODE_VIDEO_VERTICAL = 5;

    void bindLogoView(FrameLayout.LayoutParams layoutParams);

    void bindPrivacyView(FrameLayout.LayoutParams layoutParams);

    int getAPPStatus();

    @Nullable
    IActionView getActionView();

    Bitmap getAdLogo();

    String getAdMarkText();

    String getAdMarkUrl();

    String getAdTag();

    int getAdType();

    AppElement getAppMiitInfo();

    String getDesc();

    String getIconUrl();

    int[] getImgDimensions();

    List<String> getImgUrl();

    int getMaterialMode();

    @Override // com.vivo.mobilead.unified.IBidding
    int getPrice();

    @Override // com.vivo.mobilead.unified.IBidding
    String getPriceLevel();

    String getTitle();

    void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view);

    void registerView(VivoNativeAdContainer vivoNativeAdContainer, View view, NativeVideoView nativeVideoView);

    @Override // com.vivo.mobilead.unified.IBidding
    void sendLossNotification(int i2, int i3);

    @Override // com.vivo.mobilead.unified.IBidding
    void sendWinNotification(int i2);
}
