package com.aggmoread.sdk.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.client.AMAdMediaListener;
import com.aggmoread.sdk.client.AMAdMediaView;
import com.aggmoread.sdk.client.AMAppInfo;
import com.aggmoread.sdk.client.feedlist.AMExpressAd;
import com.aggmoread.sdk.client.feedlist.AMExpressInteractionListener;
import com.aggmoread.sdk.client.feedlist.AMMixFeedAd;
import com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class k extends c implements AMMixFeedAd {

    /* renamed from: b */
    private h f4125b;

    /* renamed from: c */
    private l f4126c;

    public k(com.aggmoread.sdk.z.d.a.a.c.a aVar, d dVar) {
        super(aVar, dVar);
        if (aVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.d) {
            this.f4125b = new h((com.aggmoread.sdk.z.d.a.a.c.o.d) aVar, dVar);
        } else if (aVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.f) {
            this.f4126c = new l((com.aggmoread.sdk.z.d.a.a.c.o.f) aVar, dVar);
        }
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        h hVar = this.f4125b;
        if (hVar != null) {
            return hVar.a();
        }
        l lVar = this.f4126c;
        return lVar != null ? lVar.a() : Collections.emptyMap();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public View bindAdToView(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull AMNativeInteractionListener aMNativeInteractionListener) {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.bindAdToView(context, view, layoutParams, list, view2, aMNativeInteractionListener);
        }
        return null;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void bindCTAViews(List<View> list) {
        l lVar = this.f4126c;
        if (lVar != null) {
            lVar.bindCTAViews(list);
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void bindMediaAdToView(@NonNull AMAdMediaView aMAdMediaView, AMAdMediaListener aMAdMediaListener) {
        l lVar = this.f4126c;
        if (lVar != null) {
            lVar.bindMediaAdToView(aMAdMediaView, aMAdMediaListener);
        }
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        h hVar = this.f4125b;
        if (hVar != null) {
            hVar.destroy();
        } else {
            l lVar = this.f4126c;
            if (lVar != null) {
                lVar.destroy();
            }
        }
        this.f4125b = null;
        this.f4126c = null;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getAdPatternType() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getAdPatternType();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public AMAppInfo getAppInfo() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getAppInfo();
        }
        return null;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public double getAppPrice() {
        l lVar = this.f4126c;
        return lVar != null ? lVar.getAppPrice() : l5.c.f27899e;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getAppScore() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getAppScore();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getAppStatus() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getAppStatus();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getCTAText() {
        l lVar = this.f4126c;
        return lVar != null ? lVar.getCTAText() : "";
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getDesc() {
        l lVar = this.f4126c;
        return lVar != null ? lVar.getDesc() : "";
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public long getDownloadCount() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getDownloadCount();
        }
        return 0L;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMMixFeedAd
    public View getExpressView() {
        h hVar = this.f4125b;
        if (hVar != null) {
            return hVar.getView();
        }
        return null;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getIconUrl() {
        l lVar = this.f4126c;
        return lVar != null ? lVar.getIconUrl() : "";
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getImageUrl() {
        l lVar = this.f4126c;
        return lVar != null ? lVar.getImageUrl() : "";
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public List<String> getImageUrlList() {
        l lVar = this.f4126c;
        return lVar != null ? lVar.getImageUrlList() : Collections.emptyList();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getPictureHeight() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getPictureHeight();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getPictureWidth() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getPictureWidth();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getProgress() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getProgress();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getTitle() {
        l lVar = this.f4126c;
        return lVar != null ? lVar.getTitle() : "";
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getVideoCurrentPosition() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getVideoCurrentPosition();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getVideoDuration() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.getVideoDuration();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public boolean isAppAd() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.isAppAd();
        }
        return false;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMMixFeedAd
    public boolean isExpressAd() {
        return this.f4125b != null;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public boolean isVideoAd() {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.isVideoAd();
        }
        return false;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void pauseVideo() {
        l lVar = this.f4126c;
        if (lVar != null) {
            lVar.pauseVideo();
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMMixFeedAd
    public void renderExpressAd() {
        h hVar = this.f4125b;
        if (hVar != null) {
            hVar.render();
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public View renderView(View view) {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.renderView(view);
        }
        return null;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void resume() {
        l lVar = this.f4126c;
        if (lVar != null) {
            lVar.resume();
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void resumeVideo() {
        l lVar = this.f4126c;
        if (lVar != null) {
            lVar.resumeVideo();
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMMixFeedAd
    public void setExpressInteractionListener(AMExpressInteractionListener aMExpressInteractionListener) {
        h hVar = this.f4125b;
        if (hVar != null) {
            hVar.setInteractionListener(aMExpressInteractionListener);
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMMixFeedAd
    public void setExpressMediaListener(AMExpressAd.ExpressMediaListener expressMediaListener) {
        h hVar = this.f4125b;
        if (hVar != null) {
            hVar.setMediaListener(expressMediaListener);
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void setVideoMute(boolean z10) {
        l lVar = this.f4126c;
        if (lVar != null) {
            lVar.setVideoMute(z10);
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void startVideo() {
        l lVar = this.f4126c;
        if (lVar != null) {
            lVar.startVideo();
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void stopVideo() {
        l lVar = this.f4126c;
        if (lVar != null) {
            lVar.stopVideo();
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public View bindAdToView(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, @NonNull AMNativeInteractionListener aMNativeInteractionListener) {
        l lVar = this.f4126c;
        if (lVar != null) {
            return lVar.bindAdToView(context, view, layoutParams, list, view2, list2, aMNativeInteractionListener);
        }
        return null;
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMMixFeedAd
    public void renderExpressAd(Activity activity) {
        h hVar = this.f4125b;
        if (hVar != null) {
            hVar.renderActivity(activity);
        }
    }
}
