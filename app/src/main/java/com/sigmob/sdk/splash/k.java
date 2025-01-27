package com.sigmob.sdk.splash;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.d0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class k implements d0 {

    /* renamed from: a */
    public final HashSet<j> f20388a;

    /* renamed from: d */
    public boolean f20391d;

    /* renamed from: e */
    public int f20392e;

    /* renamed from: b */
    public int f20389b = 0;

    /* renamed from: c */
    public BaseAdUnit f20390c = null;

    /* renamed from: f */
    public int f20393f = 0;

    public k() {
        HashSet<j> hashSet = new HashSet<>();
        this.f20388a = hashSet;
        hashSet.add(new j());
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<j> it = this.f20388a.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
        this.f20390c = baseAdUnit;
        baseAdUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a() {
        if (this.f20390c == null) {
            SigmobLog.e("endDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<j> it = this.f20388a.iterator();
        while (it.hasNext()) {
            it.next().b(this.f20390c);
        }
        this.f20390c.setSessionManager(null);
        this.f20390c.destroy();
        this.f20390c = null;
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a(String str, int i10) {
        if (this.f20390c == null) {
            SigmobLog.e("recordDisplayEvent() called  mAdUnit is null");
            return;
        }
        Iterator<j> it = this.f20388a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f20390c, str, i10);
        }
    }
}
