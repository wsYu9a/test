package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> DO;

    public enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache((byte) 0);

        Holder() {
        }

        public final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ AdVideoPlayerViewCache(byte b10) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.DO.put(str, new WeakReference<>(aVar));
    }

    public final a eI(String str) {
        WeakReference<a> weakReference = this.DO.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.DO.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.DO.remove(str);
    }

    private AdVideoPlayerViewCache() {
        this.DO = new HashMap<>(1);
    }
}
