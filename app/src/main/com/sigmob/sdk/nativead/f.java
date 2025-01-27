package com.sigmob.sdk.nativead;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class f implements com.sigmob.sdk.base.common.d0 {

    /* renamed from: a */
    public final HashSet<e> f19952a;

    /* renamed from: d */
    public boolean f19955d;

    /* renamed from: e */
    public int f19956e;

    /* renamed from: b */
    public int f19953b = 0;

    /* renamed from: c */
    public BaseAdUnit f19954c = null;

    /* renamed from: f */
    public int f19957f = 0;

    public f() {
        HashSet<e> hashSet = new HashSet<>();
        this.f19952a = hashSet;
        hashSet.add(new e());
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<e> it = this.f19952a.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
        this.f19954c = baseAdUnit;
        baseAdUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a() {
        if (this.f19954c == null) {
            SigmobLog.e("endDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<e> it = this.f19952a.iterator();
        while (it.hasNext()) {
            it.next().b(this.f19954c);
        }
        this.f19954c.setSessionManager(null);
        this.f19954c.destroy();
        this.f19954c = null;
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a(String str, int i10) {
        if (this.f19954c == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<e> it = this.f19952a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f19954c, str, i10);
        }
    }
}
