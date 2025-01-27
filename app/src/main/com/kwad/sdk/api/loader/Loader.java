package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private final AtomicBoolean LB;
    private IKsAdSDK aqs;
    private m aqt;

    public static class a {
        private static final Loader aqu = new Loader((byte) 0);
    }

    public /* synthetic */ Loader(byte b10) {
        this();
    }

    private static void BD() {
        try {
            int Br = com.kwad.sdk.api.c.Br();
            if (Br > 0) {
                try {
                    f.aP(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(f.aP(mContext));
                    f.aP(mContext).bX(Br);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @NonNull
    @MainThread
    public static synchronized IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                Object invoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, null).invoke(null, null);
                if (invoke == null) {
                    throw new RuntimeException("Can not get sdk form " + classLoader);
                }
                iKsAdSDK = (IKsAdSDK) invoke;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
        return iKsAdSDK;
    }

    private boolean aU(Context context) {
        try {
            String aQ = i.aQ(context);
            String aR = i.aR(context);
            if (TextUtils.isEmpty(aQ) && TextUtils.isEmpty(aR)) {
                return false;
            }
            if (!TextUtils.isEmpty(aR) && i.K(aR, aQ)) {
                i.o(context, aR);
                y(context, aQ);
                i.p(context, "");
                aQ = aR;
            }
            return !TextUtils.isEmpty(aQ);
        } catch (Throwable th2) {
            com.kwad.sdk.api.c.m(th2);
            return false;
        }
    }

    private static void aV(Context context) {
        try {
            String aS = i.aS(context);
            boolean b10 = b.b(context, i.apX, false);
            if (!TextUtils.isEmpty(aS) && aS.equals(BuildConfig.VERSION_NAME) && !b10) {
                return;
            }
            String aQ = i.aQ(context);
            i.o(context, "");
            i.p(context, "");
            b.a(context, i.apX, false);
            j.j(j.t(context, aQ));
            i.q(context, BuildConfig.VERSION_NAME);
        } catch (Throwable th2) {
            com.kwad.sdk.api.c.m(th2);
        }
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get()) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        if (context == null) {
            context = c.By();
        }
        KsAdSDK.init(context, SdkConfig.create(b.getString(context, "sdkconfig")));
    }

    public static Loader get() {
        return a.aqu;
    }

    private static void y(Context context, String str) {
        j.x(context, str);
    }

    public Context getContext() {
        return mContext;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        m mVar = this.aqt;
        if (mVar != null) {
            return mVar.getClassLoader();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        m mVar = this.aqt;
        if (mVar != null) {
            return mVar.BA();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        m mVar = this.aqt;
        return mVar != null ? mVar.getClassLoader() : getClass().getClassLoader();
    }

    public IKsAdSDK init(@NonNull Context context, ClassLoader classLoader) {
        if (this.LB.get()) {
            return this.aqs;
        }
        mContext = context.getApplicationContext();
        aV(context);
        if (aU(context)) {
            this.aqt = m.a(context, classLoader, i.aQ(context));
        }
        m mVar = this.aqt;
        if (mVar == null) {
            IKsAdSDK a10 = a(getClass().getClassLoader());
            this.aqs = a10;
            a10.setIsExternal(false);
        } else {
            IKsAdSDK BB = mVar.BB();
            this.aqs = BB;
            BB.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.aqs);
        if (this.aqt != null) {
            BD();
        }
        this.LB.set(true);
        return this.aqs;
    }

    public boolean isExternalLoaded() {
        return this.aqt != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.aqs.newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.aqs.newInstance(cls);
    }

    public void rest() {
        this.LB.set(false);
        mContext = null;
        this.aqs = null;
        this.aqt = null;
    }

    private Loader() {
        this.aqt = null;
        this.LB = new AtomicBoolean(false);
    }
}
