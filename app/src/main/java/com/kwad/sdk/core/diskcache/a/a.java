package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.av;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.kwai.a aeR;

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a */
    static final class C0209a {
        static final a aeS = new a((byte) 0);
    }

    private a() {
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    @Nullable
    private File bJ(String str) {
        if (vt() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.aeR, str);
    }

    private synchronized void init(Context context) {
        if (this.aeR != null || context == null) {
            return;
        }
        try {
            this.aeR = com.kwad.sdk.core.diskcache.kwai.a.a(av.cA(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public static a vs() {
        return C0209a.aeS;
    }

    private boolean vt() {
        init(((e) ServiceProvider.get(e.class)).getContext());
        return this.aeR == null;
    }

    public final boolean a(String str, a.C0217a c0217a) {
        File bJ;
        if (!vt() && !TextUtils.isEmpty(str)) {
            String bK = c.bK(str);
            if (b.a(this.aeR, str, bK, c0217a) && (bJ = bJ(bK)) != null && bJ.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File aX(String str) {
        if (vt() || TextUtils.isEmpty(str)) {
            return null;
        }
        return bJ(c.bK(str));
    }

    public final boolean b(String str, @NonNull String str2, a.C0217a c0217a) {
        File bJ;
        if (!vt() && !TextUtils.isEmpty(str)) {
            String bK = c.bK(str2);
            if (b.a(this.aeR, str, bK, c0217a) && (bJ = bJ(bK)) != null && bJ.exists()) {
                return true;
            }
        }
        return false;
    }

    public final void bI(String str) {
        if (vt() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.aeR, str, c.bK(str));
    }

    public final void delete() {
        if (vt()) {
            return;
        }
        try {
            this.aeR.delete();
        } catch (IOException unused) {
        }
    }

    public final boolean remove(String str) {
        if (vt()) {
            return false;
        }
        try {
            ao.ah(str, "cacheKey is not allowed empty");
            return this.aeR.remove(c.bK(str));
        } catch (IOException unused) {
            return false;
        }
    }
}
