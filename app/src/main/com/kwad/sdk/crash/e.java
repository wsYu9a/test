package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* loaded from: classes3.dex */
public final class e {
    private com.kwad.sdk.crash.b.b aKf;
    private c aKg;
    private long aKh;

    public static class a {
        private static final e aKi = new e((byte) 0);
    }

    public /* synthetic */ e(byte b10) {
        this();
    }

    public static e Jk() {
        return a.aKi;
    }

    public final String[] Jl() {
        return this.aKf.Jx();
    }

    public final String[] Jm() {
        return this.aKf.Jm();
    }

    public final String Jn() {
        return this.aKg.aJD.aKK;
    }

    public final int Jo() {
        return this.aKg.aJD.aKO;
    }

    public final c Jp() {
        return this.aKg;
    }

    public final h Jq() {
        return this.aKg.aJF;
    }

    public final long Jr() {
        return SystemClock.elapsedRealtime() - this.aKh;
    }

    public final void a(@NonNull c cVar) {
        this.aKg = cVar;
        this.aKh = SystemClock.elapsedRealtime();
        this.aKf.a(cVar.aJG, cVar.aJH);
    }

    public final void b(int i10, ExceptionMessage exceptionMessage) {
        f Jg = this.aKg.Jg();
        if (Jg != null) {
            Jg.a(i10, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.aKg.aJE.aKA;
    }

    public final Context getContext() {
        return this.aKg.context;
    }

    public final String getSdkVersion() {
        return this.aKg.aJD.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aKg.Jh();
    }

    private e() {
        this.aKf = new com.kwad.sdk.crash.b.b();
        this.aKg = new c.a().Jj();
    }
}
