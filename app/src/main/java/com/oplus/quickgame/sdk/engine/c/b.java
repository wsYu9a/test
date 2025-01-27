package com.oplus.quickgame.sdk.engine.c;

import com.cdo.oaps.ad.OapsKey;
import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends QuickGame.Builder {

    /* renamed from: a */
    Map<String, String> f16195a = new HashMap();

    /* renamed from: b */
    Map<String, String> f16196b = new HashMap();

    /* renamed from: c */
    Map<String, String> f16197c = null;

    /* renamed from: d */
    Map<String, String> f16198d = null;

    /* renamed from: e */
    Callback f16199e;

    /* renamed from: f */
    String f16200f;

    public b(String str, String str2) {
        a(str);
        b(str2);
    }

    private QuickGame.Builder a(String str) {
        this.f16196b.put("origin", str);
        return this;
    }

    private QuickGame.Builder b(String str) {
        this.f16196b.put("secret", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Req build() {
        return new d(this);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder putDeepLink(String str, String str2) {
        if (this.f16195a == null) {
            this.f16195a = new HashMap();
        }
        this.f16195a.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder putExtra(String str, String str2) {
        if (this.f16198d == null) {
            this.f16198d = new HashMap();
        }
        this.f16198d.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder putPlatform(String str, String str2) {
        this.f16196b.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder putStat(String str, String str2) {
        if (this.f16197c == null) {
            this.f16197c = new HashMap();
        }
        this.f16197c.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder setCallback(Callback callback) {
        this.f16199e = callback;
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder setExtra(String str) {
        this.f16195a.put("ext", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder setFrom(String str) {
        this.f16195a.put("f", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    @Deprecated
    public QuickGame.Builder setPackage(String str) {
        this.f16195a.put("pkg", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder setRequestUrl(String str) {
        this.f16200f = str;
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Builder
    public QuickGame.Builder signAsPlatform() {
        this.f16196b.put(OapsKey.KEY_SIGN_TYPE, "1");
        return this;
    }
}
