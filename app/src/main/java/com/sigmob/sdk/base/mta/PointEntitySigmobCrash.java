package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityCrash;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.a;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class PointEntitySigmobCrash extends PointEntityCrash {
    public static PointEntitySigmobCrash WindCrash(String str) {
        PointEntitySigmobCrash pointEntitySigmobCrash = new PointEntitySigmobCrash();
        pointEntitySigmobCrash.setAc_type(PointType.SIGMOB_CRASH);
        pointEntitySigmobCrash.setCategory(PointCategory.CRASH);
        pointEntitySigmobCrash.setCrashMessage(str);
        return pointEntitySigmobCrash;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public DeviceContext getDeviceContext() {
        return a.e();
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
}
