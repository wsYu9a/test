package com.jd.ad.sdk.jad_zm;

import com.jd.ad.sdk.logger.Logger;
import java.net.URL;

/* loaded from: classes2.dex */
public abstract class jad_dq {
    public jad_ly jad_an;
    public jad_an jad_bo;

    public jad_dq(jad_ly jad_lyVar) {
        try {
            this.jad_an = jad_lyVar;
            String protocol = new URL(jad_lyVar.jad_an()).getProtocol();
            if (jad_bo(protocol)) {
                this.jad_bo = jad_an(protocol);
                return;
            }
            throw new IllegalArgumentException("Invalid protocol: " + protocol);
        } catch (Throwable th2) {
            Logger.w("Exception while creating base task", th2.getMessage());
            throw new com.jd.ad.sdk.jad_do.jad_an(th2);
        }
    }

    public final jad_an jad_an(String str) {
        if ("http".equalsIgnoreCase(str)) {
            return new jad_jt();
        }
        if ("https".equalsIgnoreCase(str)) {
            return new jad_iv();
        }
        throw new IllegalArgumentException("Unsupported protocol: " + str);
    }

    public final boolean jad_bo(String str) {
        return "http".equalsIgnoreCase(str) || "https".equalsIgnoreCase(str);
    }
}
