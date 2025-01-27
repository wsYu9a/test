package com.martian.ttbook.b.c.a.a.c.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface d extends com.martian.ttbook.b.c.a.a.c.a {

    public interface a extends com.martian.ttbook.b.c.a.a.c.e {
        void onAdClicked();

        void onAdExposed();
    }

    public interface b extends a {
        void onADStatusChanged(int i2);

        void onLoadApkProgress(int i2);
    }

    Map<String, Object> a();

    void a(View view);

    void b();

    int c();

    com.martian.ttbook.b.c.a.a.c.c d();

    int e();

    int f();

    List<String> g();

    int getAdPatternType();

    int getAppStatus();

    String getDesc();

    String getIconUrl();

    String getImageUrl();

    String getTitle();

    String getVideoCoverImage();

    int getVideoCurrentPosition();

    View h(@NonNull Context context, @NonNull View view, Object obj, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull a aVar);

    boolean isAppAd();

    boolean isVideoAd();

    void n(@NonNull ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar);

    void pauseAppDownload();

    void pauseVideo();

    void resume();

    void resumeAppDownload();

    void resumeVideo();

    void setVideoMute(boolean z);

    void startVideo();

    void stopVideo();
}
