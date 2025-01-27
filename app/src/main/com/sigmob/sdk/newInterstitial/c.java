package com.sigmob.sdk.newInterstitial;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.d0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class c implements d0 {

    /* renamed from: a */
    public final HashSet<b> f20195a;

    /* renamed from: d */
    public boolean f20198d;

    /* renamed from: e */
    public int f20199e;

    /* renamed from: b */
    public int f20196b = 0;

    /* renamed from: c */
    public BaseAdUnit f20197c = null;

    /* renamed from: f */
    public int f20200f = 0;

    public c() {
        HashSet<b> hashSet = new HashSet<>();
        this.f20195a = hashSet;
        hashSet.add(new b());
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<b> it = this.f20195a.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
        this.f20197c = baseAdUnit;
        baseAdUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a() {
        if (this.f20197c == null) {
            SigmobLog.e("endDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<b> it = this.f20195a.iterator();
        while (it.hasNext()) {
            it.next().b(this.f20197c);
        }
        this.f20197c.setSessionManager(null);
        this.f20197c.destroy();
        com.sigmob.sdk.base.common.h.d(this.f20197c);
        this.f20197c = null;
    }

    @Override // com.sigmob.sdk.base.common.d0
    public void a(String str, int i10) {
        if (this.f20197c == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<b> it = this.f20195a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f20197c, str, i10);
        }
    }
}
