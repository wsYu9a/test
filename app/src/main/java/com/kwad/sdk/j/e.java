package com.kwad.sdk.j;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class e {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicBoolean Ip;
    private Resources aDE;
    private Resources aDF;
    private h aDG;
    private boolean aDH;
    private ClassLoader aDI;

    static class a {
        private static final e aDJ = new e((byte) 0);
    }

    private e() {
        this.Ip = new AtomicBoolean(false);
    }

    /* synthetic */ e(byte b2) {
        this();
    }

    public static e FK() {
        return a.aDJ;
    }

    private boolean FL() {
        Context CA;
        Object a2;
        try {
            CA = ServiceProvider.CA();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
        }
        if (!k.m62do(CA)) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Object invoke = cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(null, new Object[0]);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (a2 = s.a(field, invoke)) != null) {
                for (Field field2 : a2.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        Resources resources = (Resources) field2.get(a2);
                        Resources resources2 = CA.getResources();
                        h hVar = new h(resources, resources2);
                        s.a(field2, a2, hVar);
                        this.aDE = resources2;
                        this.aDF = resources;
                        this.aDG = hVar;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean sO() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sO();
    }

    private static boolean sP() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sP();
    }

    public final boolean Ep() {
        return this.Ip.get();
    }

    public final ClassLoader getClassLoader() {
        return this.aDI;
    }

    public final Resources getResources() {
        return this.aDG;
    }

    public final void init() {
        if (this.Ip.get()) {
            return;
        }
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal()) {
            if (sO() && FL()) {
                this.aDI = getClass().getClassLoader();
                i.bO(sP());
                com.kwad.sdk.core.d.b.d("KSDY/KSPlugin", toString());
                this.aDH = true;
            } else {
                this.aDH = false;
            }
        }
        this.Ip.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.aDE + ", mResResources=" + this.aDF + ", mPluginResources=" + this.aDG + ", mEnable=" + this.aDH + '}';
    }
}
