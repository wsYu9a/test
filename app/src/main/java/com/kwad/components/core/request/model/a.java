package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.i;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {

    @NonNull
    public final ImpInfo Oy;

    @NonNull
    public final com.kwad.components.core.request.c Ub;

    @Nullable
    public i Uc;

    @Nullable
    public List<String> Ud;
    public boolean Ue;
    public boolean Uf;

    @Nullable
    public c Ug;
    private String Uh;

    /* renamed from: com.kwad.components.core.request.model.a$a */
    public static class C0445a {
        public ImpInfo Oy;
        public com.kwad.components.core.request.c Ub;
        public boolean Ue;
        public boolean Uf;
        public i Ui;

        public final C0445a a(@NonNull com.kwad.components.core.request.c cVar) {
            this.Ub = cVar;
            return this;
        }

        public final C0445a aJ(boolean z10) {
            this.Ue = true;
            return this;
        }

        public final C0445a aK(boolean z10) {
            this.Uf = z10;
            return this;
        }

        public final C0445a e(ImpInfo impInfo) {
            this.Oy = impInfo;
            return this;
        }

        public final a rA() {
            if (com.kwad.components.ad.f.a.ns.booleanValue() && (this.Oy == null || this.Ub == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }

        public final C0445a a(i iVar) {
            this.Ui = iVar;
            return this;
        }
    }

    public /* synthetic */ a(C0445a c0445a, byte b10) {
        this(c0445a);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z10) {
        d.a(aVar.Oy.adScene, aVar.rz(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.Ub.a(e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.azA.msg : adResultData.testErrorMsg, z10);
        } else {
            aVar.Ub.a(adResultData, z10);
        }
    }

    public final void az(String str) {
        this.Uh = str;
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.Oy.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.Oy.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.Oy.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    public final i ry() {
        return this.Uc;
    }

    public final String rz() {
        return !TextUtils.isEmpty(this.Uh) ? this.Uh : "network_only";
    }

    private a(C0445a c0445a) {
        this.Oy = c0445a.Oy;
        this.Ub = c0445a.Ub;
        this.Ue = c0445a.Ue;
        this.Uf = c0445a.Uf;
        this.Uc = c0445a.Ui;
    }

    public static void a(@NonNull a aVar, int i10, String str, boolean z10) {
        aVar.Ub.a(i10, str, z10);
        d.a(aVar.getAdStyle(), i10, str, aVar.rz());
    }
}
