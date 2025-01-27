package com.opos.exoplayer.core.h;

import android.net.Uri;
import android.util.Base64;
import com.martian.mibook.application.MiConfigSingleton;
import java.net.URLDecoder;

/* loaded from: classes4.dex */
public final class f implements g {

    /* renamed from: a */
    private i f18914a;

    /* renamed from: b */
    private int f18915b;

    /* renamed from: c */
    private byte[] f18916c;

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int length = this.f18916c.length - this.f18915b;
        if (length == 0) {
            return -1;
        }
        int min = Math.min(i3, length);
        System.arraycopy(this.f18916c, this.f18915b, bArr, i2, min);
        this.f18915b += min;
        return min;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        this.f18914a = iVar;
        Uri uri = iVar.f18918a;
        String scheme = uri.getScheme();
        if (!MiConfigSingleton.t0.equals(scheme)) {
            throw new com.opos.exoplayer.core.o("Unsupported scheme: " + scheme);
        }
        String[] split = uri.getSchemeSpecificPart().split(",");
        if (split.length > 2) {
            throw new com.opos.exoplayer.core.o("Unexpected URI format: " + uri);
        }
        String str = split[1];
        if (split[0].contains(";base64")) {
            try {
                this.f18916c = Base64.decode(str, 0);
            } catch (IllegalArgumentException e2) {
                throw new com.opos.exoplayer.core.o("Error while parsing Base64 encoded string: " + str, e2);
            }
        } else {
            this.f18916c = URLDecoder.decode(str, "US-ASCII").getBytes();
        }
        return this.f18916c.length;
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        i iVar = this.f18914a;
        if (iVar != null) {
            return iVar.f18918a;
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f18914a = null;
        this.f18916c = null;
    }
}
