package cn.vlion.ad.inland.base.natives;

/* loaded from: classes.dex */
public interface VlionNativesAppDownloadListener {
    void onDownloadApkProgress(int i10);

    void onDownloadFailed();

    void onDownloadPaused();

    void onDownloadSuccess(String str);

    void onInstallComplete();
}
