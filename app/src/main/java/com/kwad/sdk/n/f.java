package com.kwad.sdk.n;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.w;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicBoolean LB;
    private Resources aXM;
    private Resources aXN;
    private i aXO;
    private boolean aXP;
    private ClassLoader aXQ;

    public static class a {
        private static final f aXR = new f((byte) 0);
    }

    public /* synthetic */ f(byte b10) {
        this();
    }

    private static boolean Ac() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ac();
    }

    private static boolean Ad() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ad();
    }

    public static f PU() {
        return a.aXR;
    }

    private boolean PV() {
        Context MA;
        Object a10;
        Resources resources;
        try {
            MA = ServiceProvider.MA();
        } catch (Throwable th2) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th2);
        }
        if (!m.dM(MA)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Object invoke = cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, null).invoke(null, null);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (a10 = w.a(field, invoke)) != null) {
                for (Field field2 : a10.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        String u10 = com.kwad.sdk.n.a.u(MA, s.aQ(MA));
                        if (TextUtils.isEmpty(u10)) {
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "find dynamicFile failed");
                            resources = null;
                        } else {
                            Resources a11 = com.kwad.library.b.b.a.a(MA, MA.getResources(), u10);
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "use merge res ");
                            resources = a11;
                        }
                        if (resources == null) {
                            resources = (Resources) field2.get(a10);
                        }
                        Resources resources2 = MA.getResources();
                        i iVar = new i(resources, resources2);
                        w.a(field2, a10, iVar);
                        this.aXM = resources2;
                        this.aXN = resources;
                        this.aXO = iVar;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean Ow() {
        return this.LB.get();
    }

    public final ClassLoader getClassLoader() {
        return this.aXQ;
    }

    public final Resources getResources() {
        return this.aXO;
    }

    public final void init() {
        if (this.LB.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zB()) {
                if (Ac() && PV()) {
                    this.aXQ = getClass().getClassLoader();
                    j.cm(Ad());
                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", toString());
                    this.aXP = true;
                } else {
                    this.aXP = false;
                }
            }
        } catch (Throwable th2) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th2);
        }
        this.LB.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.aXM + ", mResResources=" + this.aXN + ", mPluginResources=" + this.aXO + ", mEnable=" + this.aXP + '}';
    }

    private f() {
        this.LB = new AtomicBoolean(false);
    }
}
