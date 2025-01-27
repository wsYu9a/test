package com.oplus.instant.router.e;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import com.oplus.instant.router.Instant;
import com.oplus.instant.router.callback.Callback;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends Instant.Builder {

    /* renamed from: a */
    Map<String, String> f16063a = new HashMap();

    /* renamed from: b */
    Map<String, String> f16064b = new HashMap();

    /* renamed from: c */
    Map<String, String> f16065c = null;

    /* renamed from: d */
    Map<String, String> f16066d = null;

    /* renamed from: e */
    Callback f16067e;

    /* renamed from: f */
    String f16068f;

    public b(String str, String str2) {
        b(str);
        a(str2);
    }

    private Instant.Builder a(String str) {
        this.f16064b.put("secret", str);
        return this;
    }

    private Instant.Builder b(String str) {
        this.f16064b.put("origin", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Req build() {
        return (TextUtils.isEmpty(this.f16068f) || this.f16068f.startsWith("oaps://instant/app")) ? new d(this) : new e(this);
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putExtra(String str, String str2) {
        if (this.f16066d == null) {
            this.f16066d = new HashMap();
        }
        this.f16066d.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putParams(String str, String str2) {
        this.f16064b.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putStat(String str, String str2) {
        if (this.f16065c == null) {
            this.f16065c = new HashMap();
        }
        this.f16065c.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setCallback(Callback callback) {
        this.f16067e = callback;
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setExtra(String str) {
        this.f16063a.put("ext", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setFrom(String str) {
        this.f16063a.put("f", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPackage(String str) {
        this.f16063a.put("pkg", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPage(String str) {
        this.f16063a.put("page", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPath(String str) {
        this.f16063a.put(OapsWrapper.KEY_PATH, str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setRequestUrl(String str) {
        this.f16068f = str;
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder signAsPlatform() {
        this.f16064b.put(OapsKey.KEY_SIGN_TYPE, "1");
        return this;
    }
}
