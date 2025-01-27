package cn.vlion.ad.inland.base.natives;

/* loaded from: classes.dex */
public interface VlionNativesAdVideoListener {
    void onAdVideoPlayError(String str);

    void onProgressUpdate(int i10, int i11);

    void onVideoAdComplete();

    void onVideoAdContinuePlay();

    void onVideoAdPaused();

    void onVideoAdStartPlay();

    void onVideoError(int i10, int i11);

    void onVideoLoad();
}
