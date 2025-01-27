package com.sigmob.sdk.base.common;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public class t implements d0 {

    /* renamed from: a */
    public final Set<s> f18021a;

    /* renamed from: b */
    public BaseAdUnit f18022b;

    public t() {
        HashSet hashSet = new HashSet();
        this.f18021a = hashSet;
        hashSet.add(new c0());
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called  adUnit is null");
            return;
        }
        this.f18022b = baseAdUnit;
        baseAdUnit.setSessionManager(this);
        Iterator<s> it = this.f18021a.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a() {
        SigmobLog.d("endDisplaySession() called");
        if (this.f18022b == null) {
            SigmobLog.e("endDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<s> it = this.f18021a.iterator();
        while (it.hasNext()) {
            it.next().b(this.f18022b);
        }
        this.f18022b.setSessionManager(null);
        this.f18022b.destroy();
        this.f18022b = null;
    }

    public void a(int i10, int i11) {
        if (this.f18022b == null) {
            SigmobLog.e("onVideoPrepared() called  mAdUnit is null");
            return;
        }
        Iterator<s> it = this.f18021a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f18022b, i10, i11);
        }
    }

    public void a(boolean z10, int i10) {
        if (this.f18022b == null) {
            SigmobLog.e("onVideoShowSkip() called  mAdUnit is null");
            return;
        }
        Iterator<s> it = this.f18021a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f18022b, z10, i10);
        }
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a(String str, int i10) {
        if (this.f18022b == null) {
            SigmobLog.e("recordDisplayEvent() called  mAdUnit is null");
            return;
        }
        Iterator<s> it = this.f18021a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f18022b, str, i10);
        }
    }
}
