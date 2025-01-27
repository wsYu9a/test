package com.sntech.ads;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public interface SNInitializer {

    @Keep
    public interface InitCallback {
        @Keep
        void fail(Exception exc);

        @Keep
        void success();
    }

    @Keep
    public interface InitConfigSupplier {
        @Keep
        <T> T getCachedInitConfig(Class<T> cls);

        @Keep
        <T> T getInitConfig(Class<T> cls);
    }

    @Keep
    public static abstract class InnerInitCallback implements InitCallback {
        @Keep
        public abstract void supplier(InitConfigSupplier initConfigSupplier);
    }

    @Keep
    void addCallback(InitCallback initCallback);

    @Keep
    void init(Context context);

    @Keep
    boolean isInitSuccess();

    @Keep
    void loaderInitSuccess();
}
