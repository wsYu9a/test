package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bb;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a aye;

    /* renamed from: com.kwad.sdk.core.diskcache.b.a$a */
    public static final class C0489a {
        static final a ayf = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a EG() {
        return C0489a.ayf;
    }

    private boolean EH() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        return this.aye == null;
    }

    @Nullable
    private File dE(String str) {
        if (EH() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.aye, str);
    }

    private synchronized void init(Context context) {
        if (this.aye != null || context == null) {
            return;
        }
        try {
            this.aye = com.kwad.sdk.core.diskcache.a.a.a(bb.dd(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public final boolean a(String str, a.C0497a c0497a) {
        File dE;
        if (!EH() && !TextUtils.isEmpty(str)) {
            String dF = c.dF(str);
            if (b.a(this.aye, str, dF, c0497a) && (dE = dE(dF)) != null && dE.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, @NonNull String str2, a.C0497a c0497a) {
        File dE;
        if (!EH() && !TextUtils.isEmpty(str)) {
            String dF = c.dF(str2);
            if (b.a(this.aye, str, dF, c0497a) && (dE = dE(dF)) != null && dE.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File ca(String str) {
        if (EH() || TextUtils.isEmpty(str)) {
            return null;
        }
        return dE(c.dF(str));
    }

    public final void dD(String str) {
        if (EH() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.aye, str, c.dF(str));
    }

    public final void delete() {
        if (EH()) {
            return;
        }
        try {
            this.aye.delete();
        } catch (IOException unused) {
        }
    }

    public final boolean remove(String str) {
        if (EH()) {
            return false;
        }
        try {
            au.av(str, "cacheKey is not allowed empty");
            return this.aye.remove(c.dF(str));
        } catch (IOException unused) {
            return false;
        }
    }

    private a() {
    }
}
