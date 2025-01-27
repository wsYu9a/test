package com.at.sdk;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.at.sdk.Initializer;
import com.sntech.ads.SNAdSdk;
import com.sntech.ads.SNInitializer;

@Keep
/* loaded from: classes.dex */
public class AdSdkWrapper {

    public class a extends SNInitializer.InnerInitCallback {

        /* renamed from: a */
        public final /* synthetic */ Initializer.InitCallback f6632a;

        /* renamed from: com.at.sdk.AdSdkWrapper$a$a */
        public class C0218a implements Initializer.InitConfigSupplier {

            /* renamed from: a */
            public final /* synthetic */ SNInitializer.InitConfigSupplier f6633a;

            public C0218a(SNInitializer.InitConfigSupplier initConfigSupplier) {
                this.f6633a = initConfigSupplier;
            }

            @Override // com.at.sdk.Initializer.InitConfigSupplier
            public final <T> T getCachedInitConfig(Class<T> cls) {
                return (T) this.f6633a.getCachedInitConfig(cls);
            }

            @Override // com.at.sdk.Initializer.InitConfigSupplier
            public final <T> T getInitConfig(Class<T> cls) {
                return (T) this.f6633a.getInitConfig(cls);
            }
        }

        public a(Initializer.InitCallback initCallback) {
            this.f6632a = initCallback;
        }

        @Override // com.sntech.ads.SNInitializer.InitCallback
        public final void fail(Exception exc) {
            this.f6632a.fail(exc);
        }

        @Override // com.sntech.ads.SNInitializer.InitCallback
        public final void success() {
            this.f6632a.success();
        }

        @Override // com.sntech.ads.SNInitializer.InnerInitCallback
        public final void supplier(SNInitializer.InitConfigSupplier initConfigSupplier) {
            Initializer.InitCallback initCallback = this.f6632a;
            if (initCallback instanceof Initializer.InnerInitCallback) {
                ((Initializer.InnerInitCallback) initCallback).supplier(new C0218a(initConfigSupplier));
            }
        }
    }

    public class b implements AdManager {
        @Override // com.at.sdk.AdManager
        public final String did(Context context) {
            return SNAdSdk.getAdManager().did(context);
        }

        @Override // com.at.sdk.AdManager
        public final String getSdkVersion() {
            return SNAdSdk.getAdManager().getSdkVersion();
        }
    }

    @Keep
    public static void addInitCallback(@NonNull Initializer.InitCallback initCallback) {
        SNAdSdk.addInitCallback(new a(initCallback));
    }

    @Keep
    public static AdManager getAdManager() {
        return new b();
    }

    @Keep
    public static <T> T getExtService(Class<T> cls) {
        return (T) SNAdSdk.getExtService(cls);
    }
}
