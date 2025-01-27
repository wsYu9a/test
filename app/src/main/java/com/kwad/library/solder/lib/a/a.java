package com.kwad.library.solder.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import java.io.File;

/* loaded from: classes3.dex */
public abstract class a {
    protected File amA;
    protected String amB;
    protected String amC;
    private final String amF;
    protected com.kwad.library.solder.lib.c.b amG;
    protected String mVersion;
    private final byte[] amE = new byte[0];
    private boolean amD = false;
    protected com.kwad.library.solder.lib.ext.c amf = i.ym().yg();

    public a(String str) {
        this.amF = str;
        this.amB = str;
    }

    private void yq() {
        if (this.amD) {
            return;
        }
        synchronized (this.amE) {
            this.amD = true;
        }
    }

    public final a a(@NonNull com.kwad.library.solder.lib.c.b bVar) {
        this.amG = bVar;
        return this;
    }

    public final void bN(String str) {
        this.mVersion = str;
    }

    public final void bO(String str) {
        this.amC = str;
    }

    public final void bP(String str) {
        this.amB = str;
    }

    public final String getId() {
        return this.amC;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public abstract void h(Context context, String str);

    public final boolean isLoaded() {
        boolean z10;
        if (this.amD) {
            return true;
        }
        synchronized (this.amE) {
            z10 = this.amD;
        }
        return z10;
    }

    public final void m(Context context, String str) {
        h(context, str);
        yq();
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.amF + "'}";
    }

    public final String yr() {
        return this.amF;
    }

    public final String ys() {
        com.kwad.library.solder.lib.c.b bVar = this.amG;
        if (bVar != null) {
            return bVar.anq;
        }
        return null;
    }
}
