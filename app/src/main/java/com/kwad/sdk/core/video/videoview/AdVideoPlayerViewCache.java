package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> BF;

    enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache((byte) 0);

        Holder() {
        }

        final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    private AdVideoPlayerViewCache() {
        this.BF = new HashMap<>(1);
    }

    /* synthetic */ AdVideoPlayerViewCache(byte b2) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.BF.put(str, new WeakReference<>(aVar));
    }

    public final a cO(String str) {
        WeakReference<a> weakReference = this.BF.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.BF.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.BF.remove(str);
    }
}
