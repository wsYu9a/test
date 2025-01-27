package com.kwad.components.core.offline.init;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.core.n.f;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.y;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;

/* loaded from: classes2.dex */
public abstract class a {
    private long mLoadStartTime;

    /* renamed from: com.kwad.components.core.offline.init.a$1 */
    final class AnonymousClass1 implements f.a {
        final /* synthetic */ boolean Kd;
        final /* synthetic */ Context jN;

        AnonymousClass1(boolean z, Context context) {
            h2 = z;
            context = context;
        }

        @Override // com.kwad.components.core.n.f.a
        public final void a(@NonNull SdkConfigData sdkConfigData) {
            com.kwad.sdk.core.d.b.d(a.this.getTag(), "init onConfigRefresh  isSuccessLoaded:" + h2);
            if (!a.this.nH() || h2) {
                return;
            }
            a.this.ad(context);
        }

        @Override // com.kwad.components.core.n.f.a
        public final void nP() {
            com.kwad.sdk.core.d.b.d(a.this.getTag(), "init onCacheLoaded  isSuccessLoaded:" + h2);
            if (!a.this.nH() || h2) {
                a.this.ad(context);
            }
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.a$2 */
    final class AnonymousClass2 extends b.a {
        final /* synthetic */ Context jN;

        AnonymousClass2(Context context) {
            context = context;
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public void a(com.kwai.sodler.lib.b.a aVar, PluginError pluginError) {
            super.a((AnonymousClass2) aVar, pluginError);
            com.kwad.sdk.core.d.b.d(a.this.getTag(), "loadComponents failed error: " + pluginError);
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public void a(com.kwai.sodler.lib.b.a aVar, com.kwai.sodler.lib.kwai.a aVar2) {
            super.a((AnonymousClass2) aVar, (com.kwai.sodler.lib.b.a) aVar2);
            String tag = a.this.getTag();
            if (aVar2 == null) {
                com.kwad.sdk.core.d.b.d(tag, "loadComponents failed plugin null");
            } else {
                com.kwad.sdk.core.d.b.d(tag, "loadComponents success");
                a.this.a(context, aVar2.Jv());
            }
        }
    }

    public void a(Context context, ClassLoader classLoader) {
        boolean z;
        try {
            z = b(context, classLoader);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            z = false;
        }
        y.b(context, nJ(), nK(), z);
    }

    public void ad(Context context) {
        String tag = getTag();
        StringBuilder sb = new StringBuilder("initReal disableOfflineComponents: ");
        Boolean bool = com.kwad.components.core.a.Hl;
        sb.append(bool);
        sb.append(" , isDevelopEnable: ");
        sb.append(com.kwad.components.core.a.bI);
        sb.append(" , DEBUG: false");
        com.kwad.sdk.core.d.b.d(tag, sb.toString());
        if (bool.booleanValue()) {
            a(context, getClass().getClassLoader());
        } else {
            ae(context);
        }
        com.kwad.sdk.core.d.b.d(getTag(), "initReal end");
    }

    private void ae(Context context) {
        com.kwai.sodler.lib.c.b nI = nI();
        com.kwad.sdk.core.d.b.d(getTag(), "loadComponents pluginInfo: " + nI);
        com.kwai.sodler.kwai.a.a(context, nI, new b.a() { // from class: com.kwad.components.core.offline.init.a.2
            final /* synthetic */ Context jN;

            AnonymousClass2(Context context2) {
                context = context2;
            }

            @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass2) aVar, pluginError);
                com.kwad.sdk.core.d.b.d(a.this.getTag(), "loadComponents failed error: " + pluginError);
            }

            @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.a aVar, com.kwai.sodler.lib.kwai.a aVar2) {
                super.a((AnonymousClass2) aVar, (com.kwai.sodler.lib.b.a) aVar2);
                String tag = a.this.getTag();
                if (aVar2 == null) {
                    com.kwad.sdk.core.d.b.d(tag, "loadComponents failed plugin null");
                } else {
                    com.kwad.sdk.core.d.b.d(tag, "loadComponents success");
                    a.this.a(context, aVar2.Jv());
                }
            }
        });
    }

    private com.kwai.sodler.lib.c.b nI() {
        com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
        bVar.aKT = nJ();
        bVar.Ig = true;
        bVar.aKX = false;
        bVar.aKU = com.kwad.sdk.core.network.idc.a.wm().ch(nL());
        bVar.version = nK();
        bVar.aKW = nM();
        if (com.kwad.components.core.a.Ho.booleanValue()) {
            bVar.aKB = nN();
            bVar.aKC = true;
        }
        return bVar;
    }

    public final <T extends IOfflineCompo> T a(ClassLoader classLoader, String str) {
        T t;
        com.kwad.sdk.core.d.b.d(getTag(), "onOfflineComponentsLoaded classLoader:" + classLoader);
        try {
            t = (T) classLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e(getTag(), "loadClass or instance failed: " + str, th);
            t = null;
        }
        com.kwad.sdk.core.d.b.d(getTag(), "onOfflineComponentsLoaded components: " + t);
        return t;
    }

    protected abstract boolean b(Context context, ClassLoader classLoader);

    protected abstract String getTag();

    public final void init(Context context) {
        if (!isEnabled()) {
            com.kwad.sdk.core.d.b.d(getTag(), "initReal disable");
            return;
        }
        this.mLoadStartTime = SystemClock.elapsedRealtime();
        com.kwad.components.core.offline.a.at(nG());
        boolean h2 = y.h(context, nJ(), nK());
        com.kwad.sdk.core.d.b.d(getTag(), "init isSuccessLoaded: getCompoName()" + nJ() + h2);
        f.a(new f.a() { // from class: com.kwad.components.core.offline.init.a.1
            final /* synthetic */ boolean Kd;
            final /* synthetic */ Context jN;

            AnonymousClass1(boolean h22, Context context2) {
                h2 = h22;
                context = context2;
            }

            @Override // com.kwad.components.core.n.f.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.d.b.d(a.this.getTag(), "init onConfigRefresh  isSuccessLoaded:" + h2);
                if (!a.this.nH() || h2) {
                    return;
                }
                a.this.ad(context);
            }

            @Override // com.kwad.components.core.n.f.a
            public final void nP() {
                com.kwad.sdk.core.d.b.d(a.this.getTag(), "init onCacheLoaded  isSuccessLoaded:" + h2);
                if (!a.this.nH() || h2) {
                    a.this.ad(context);
                }
            }
        });
    }

    public abstract boolean isEnabled();

    public abstract int nG();

    protected boolean nH() {
        return true;
    }

    protected abstract String nJ();

    protected abstract String nK();

    protected abstract String nL();

    protected abstract String nM();

    protected abstract String nN();

    public final void nO() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLoadStartTime;
        com.kwad.sdk.core.d.b.d(getTag(), "init success cost: " + elapsedRealtime);
        com.kwad.components.core.offline.a.b(nG(), elapsedRealtime);
    }
}
