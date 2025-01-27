package com.at.sdk;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public interface Initializer {

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
}
