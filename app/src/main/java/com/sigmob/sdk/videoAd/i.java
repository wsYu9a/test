package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.models.BaseAdUnit;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class i implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final int f20461a;

    /* renamed from: b */
    public final int f20462b;

    /* renamed from: c */
    public final com.sigmob.sdk.base.views.n f20463c;

    /* renamed from: d */
    public final int f20464d;

    /* renamed from: e */
    public String f20465e;

    /* renamed from: f */
    public a f20466f;

    /* renamed from: g */
    public String f20467g;

    /* renamed from: h */
    public String f20468h;

    /* renamed from: i */
    public int f20469i;

    /* renamed from: j */
    public boolean f20470j = false;

    /* renamed from: k */
    public com.sigmob.sdk.videoAd.a f20471k;

    public interface a {
        void a();

        void b();
    }

    public i(int i10, int i11, int i12, String str, String str2, com.sigmob.sdk.base.views.n nVar) {
        this.f20461a = i10;
        this.f20462b = i11;
        this.f20464d = i12;
        this.f20468h = str2;
        this.f20467g = str;
        this.f20463c = nVar;
    }

    public final void a(BaseAdUnit baseAdUnit, String str, String str2, com.sigmob.sdk.base.a aVar) {
    }

    public String b() {
        return this.f20468h;
    }

    public int c() {
        return this.f20462b;
    }

    public int d() {
        return this.f20461a;
    }

    public com.sigmob.sdk.base.views.n a() {
        return this.f20463c;
    }

    public void a(a aVar) {
        this.f20466f = aVar;
    }

    public void a(String str) {
        this.f20468h = str;
    }

    public void a(int i10) {
        this.f20469i = i10;
    }

    public void a(com.sigmob.sdk.videoAd.a aVar) {
        this.f20471k = aVar;
    }
}
