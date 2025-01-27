package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityCommon;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class a0 extends PointEntityCommon {

    /* renamed from: a */
    public String f17674a;

    /* renamed from: b */
    public String f17675b;

    /* renamed from: c */
    public String f17676c;

    public String a() {
        return this.f17675b;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    public String b() {
        return this.f17674a;
    }

    public String c() {
        return this.f17676c;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public DeviceContext getDeviceContext() {
        return com.sigmob.sdk.a.e();
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String getSdkversion() {
        return com.sigmob.sdk.base.k.f18179k;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public boolean isAcTypeBlock() {
        if (!com.sigmob.sdk.base.f.f().b()) {
            return true;
        }
        Iterator<Integer> it = com.sigmob.sdk.base.l.w().y().iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }

    public void a(String str) {
        this.f17675b = str;
    }

    public void b(String str) {
        this.f17674a = str;
    }

    public void c(String str) {
        this.f17676c = str;
    }
}
