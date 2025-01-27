package com.aggmoread.sdk.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.client.AMAdMediaListener;
import com.aggmoread.sdk.client.AMAdMediaView;
import com.aggmoread.sdk.client.AMAppInfo;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.feedlist.AMNativeAd;
import com.aggmoread.sdk.client.feedlist.AMNativeInteractionListener;
import com.aggmoread.sdk.z.d.a.a.c.c;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class l extends c implements AMNativeAd {

    /* renamed from: b */
    private com.aggmoread.sdk.z.d.a.a.c.o.f f4127b;

    public class a implements f.b {

        /* renamed from: a */
        final /* synthetic */ AMNativeInteractionListener f4128a;

        public a(l lVar, AMNativeInteractionListener aMNativeInteractionListener) {
            this.f4128a = aMNativeInteractionListener;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            this.f4128a.onAdError(new AMError(dVar.a(), dVar.b()));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.f.b
        public void onADStatusChanged(int i10) {
            this.f4128a.onADStatusChanged(i10);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.f.a
        public void onAdClicked() {
            this.f4128a.onAdClicked();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.f.a
        public void onAdExposed() {
            this.f4128a.onAdExposed();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.f.b
        public void onLoadApkProgress(int i10) {
            this.f4128a.onLoadApkProgress(i10);
        }
    }

    public class b implements com.aggmoread.sdk.z.d.a.a.c.t.a {

        /* renamed from: a */
        final /* synthetic */ AMAdMediaListener f4129a;

        public b(l lVar, AMAdMediaListener aMAdMediaListener) {
            this.f4129a = aMAdMediaListener;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoError(new AMError(dVar.a(), dVar.b()));
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoClicked() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoClicked();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoCompleted() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoCompleted();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoInit() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoInit();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoLoaded(int i10) {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoLoaded(i10);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoLoading() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoLoading();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoPause() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoPause();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoReady() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoReady();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoResume() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoResume();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoStart() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoStart();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.t.a
        public void onVideoStop() {
            AMAdMediaListener aMAdMediaListener = this.f4129a;
            if (aMAdMediaListener != null) {
                aMAdMediaListener.onVideoStop();
            }
        }
    }

    public l(com.aggmoread.sdk.z.d.a.a.c.o.f fVar, d dVar) {
        super(fVar, dVar);
        this.f4127b = fVar;
    }

    @Override // com.aggmoread.sdk.b.c
    public Map<String, Object> a() {
        return this.f4127b.h();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public View bindAdToView(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, @NonNull AMNativeInteractionListener aMNativeInteractionListener) {
        return bindAdToView(context, view, layoutParams, list, view2, null, aMNativeInteractionListener);
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void bindCTAViews(List<View> list) {
        this.f4127b.bindCTAViews(list);
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void bindMediaAdToView(@NonNull AMAdMediaView aMAdMediaView, AMAdMediaListener aMAdMediaListener) {
        this.f4127b.a(aMAdMediaView, new b(this, aMAdMediaListener));
    }

    @Override // com.aggmoread.sdk.client.AMAdInterface
    public void destroy() {
        this.f4127b.destroy();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getAdPatternType() {
        switch (this.f4127b.getAdPatternType()) {
            case 1:
            case 3:
            case 6:
                return 3;
            case 2:
                return 2;
            case 4:
            case 5:
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public AMAppInfo getAppInfo() {
        if (this.f4127b.g() == null) {
            return null;
        }
        com.aggmoread.sdk.z.d.a.a.c.c g10 = this.f4127b.g();
        ArrayList arrayList = new ArrayList();
        if (g10.g() != null && g10.g().size() > 0) {
            for (int i10 = 0; i10 < g10.g().size(); i10++) {
                c.a aVar = g10.g().get(i10);
                arrayList.add(new AMAppInfo.Permission(aVar.f5219a, aVar.f5220b));
            }
        }
        return new AMAppInfo(g10.a(), g10.b(), g10.e(), g10.h(), arrayList, g10.i(), g10.k(), g10.f(), g10.c(), g10.d(), g10.j());
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public double getAppPrice() {
        return this.f4127b.getAppPrice();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getAppScore() {
        return this.f4127b.getAppScore();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getAppStatus() {
        return this.f4127b.getAppStatus();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getCTAText() {
        return this.f4127b.getCTAText();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getDesc() {
        return this.f4127b.getDesc();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public long getDownloadCount() {
        return this.f4127b.getDownloadCount();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getIconUrl() {
        return this.f4127b.getIconUrl();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getImageUrl() {
        return this.f4127b.getImageUrl();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public List<String> getImageUrlList() {
        return this.f4127b.getImageUrlList();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getPictureHeight() {
        return this.f4127b.getPictureHeight();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getPictureWidth() {
        return this.f4127b.getPictureWidth();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getProgress() {
        return this.f4127b.getProgress();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public String getTitle() {
        return this.f4127b.getTitle();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getVideoCurrentPosition() {
        return this.f4127b.getVideoCurrentPosition();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public int getVideoDuration() {
        return this.f4127b.f();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public boolean isAppAd() {
        return this.f4127b.isAppAd();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public boolean isVideoAd() {
        return this.f4127b.isVideoAd();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void pauseVideo() {
        this.f4127b.pauseVideo();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public View renderView(View view) {
        return this.f4127b.renderView(view);
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void resume() {
        this.f4127b.resume();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void resumeVideo() {
        this.f4127b.resumeVideo();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void setVideoMute(boolean z10) {
        this.f4127b.setVideoMute(z10);
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void startVideo() {
        this.f4127b.startVideo();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public void stopVideo() {
        this.f4127b.stopVideo();
    }

    @Override // com.aggmoread.sdk.client.feedlist.AMNativeAd
    public View bindAdToView(@NonNull Context context, @NonNull View view, FrameLayout.LayoutParams layoutParams, List<View> list, View view2, List<View> list2, @NonNull AMNativeInteractionListener aMNativeInteractionListener) {
        return this.f4127b.a(context, view, layoutParams, list, view2, list2, new a(this, aMNativeInteractionListener));
    }
}
