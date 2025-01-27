package com.kwad.components.core.n.kwai;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {

    @NonNull
    public final b JW;

    @NonNull
    public final com.kwad.components.core.n.b Or;

    @Nullable
    public List<String> Os;
    public boolean Ot;
    public boolean Ou;

    @Nullable
    public d Ov;

    /* renamed from: com.kwad.components.core.n.kwai.a$a */
    public static class C0180a {
        public b JW;
        public com.kwad.components.core.n.b Or;
        public boolean Ot;
        public boolean Ou;

        public final C0180a a(@NonNull com.kwad.components.core.n.b bVar) {
            this.Or = bVar;
            return this;
        }

        public final C0180a aG(boolean z) {
            this.Ot = true;
            return this;
        }

        public final C0180a aH(boolean z) {
            this.Ou = z;
            return this;
        }

        public final C0180a e(b bVar) {
            this.JW = bVar;
            return this;
        }

        public final a pj() {
            if (com.kwad.components.ad.d.a.bI.booleanValue() && (this.JW == null || this.Or == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }
    }

    private a(C0180a c0180a) {
        this.JW = c0180a.JW;
        this.Or = c0180a.Or;
        this.Ot = c0180a.Ot;
        this.Ou = c0180a.Ou;
    }

    /* synthetic */ a(C0180a c0180a, byte b2) {
        this(c0180a);
    }

    public static void a(@NonNull a aVar, int i2, String str, boolean z) {
        aVar.Or.a(i2, str, z);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z) {
        boolean isAdResultDataEmpty = adResultData.isAdResultDataEmpty();
        com.kwad.components.core.n.b bVar = aVar.Or;
        if (isAdResultDataEmpty) {
            bVar.a(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg, z);
        } else {
            bVar.a(adResultData, z);
        }
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.JW.Ow;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.JW.Ow;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.JW.Ow;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }
}
