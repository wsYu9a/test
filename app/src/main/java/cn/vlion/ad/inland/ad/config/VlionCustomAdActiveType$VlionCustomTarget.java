package cn.vlion.ad.inland.ad.config;

/* loaded from: classes.dex */
public enum VlionCustomAdActiveType$VlionCustomTarget {
    h5("h5", 1),
    deeplink("deeplink", 2),
    download("download", 3),
    confirm("confirm", 4),
    cancel_download("cancel_download", 5),
    installApp("installApp", 6),
    misclose("misclose", 7),
    downloading("downloading", 8),
    videocontinue("videocontinue", 9),
    exception("exception", 10),
    hmsinstall("hmsinstall", 11),
    marketurl("marketurl", 12),
    WXMiniProgram("WXMiniProgram", 13);

    private int index;
    private String value;

    VlionCustomAdActiveType$VlionCustomTarget(String str, int i10) {
        this.value = str;
        this.index = i10;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
