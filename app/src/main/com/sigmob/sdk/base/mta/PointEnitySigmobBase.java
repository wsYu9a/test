package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityBase;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.a;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class PointEnitySigmobBase extends PointEntityBase {

    /* renamed from: a */
    public String f18260a;

    /* renamed from: b */
    public String f18261b;

    /* renamed from: c */
    public String f18262c;

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public DeviceContext getDeviceContext() {
        return a.e();
    }

    public String getIs_custom_android_id() {
        return this.f18261b;
    }

    public String getIs_custom_imei() {
        return this.f18260a;
    }

    public String getIs_custom_oaid() {
        return this.f18262c;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String getSdkversion() {
        return k.f18179k;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public boolean isAcTypeBlock() {
        if (!f.f().b()) {
            return true;
        }
        Iterator<Integer> it = l.w().y().iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }

    public void setIs_custom_android_id(String str) {
        this.f18261b = str;
    }

    public void setIs_custom_imei(String str) {
        this.f18260a = str;
    }

    public void setIs_custom_oaid(String str) {
        this.f18262c = str;
    }
}
