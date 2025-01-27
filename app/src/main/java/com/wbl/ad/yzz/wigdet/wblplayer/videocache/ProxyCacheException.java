package com.wbl.ad.yzz.wigdet.wblplayer.videocache;

/* loaded from: classes5.dex */
public class ProxyCacheException extends Exception {
    public ProxyCacheException(String str) {
        super(str + ". Version: ");
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + ". Version: ", th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: ", th);
    }
}
