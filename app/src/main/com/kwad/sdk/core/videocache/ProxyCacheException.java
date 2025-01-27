package com.kwad.sdk.core.videocache;

/* loaded from: classes3.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 3.3.69";

    public ProxyCacheException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public ProxyCacheException(String str, Throwable th2) {
        super(str + LIBRARY_VERSION, th2);
    }

    public ProxyCacheException(Throwable th2) {
        super("No explanation error. Version: 3.3.69", th2);
    }
}
