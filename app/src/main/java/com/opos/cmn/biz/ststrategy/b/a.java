package com.opos.cmn.biz.ststrategy.b;

import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;

/* loaded from: classes4.dex */
public interface a {
    STConfigEntity a();

    void a(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener);

    void a(String str, UpdateSTConfigListener updateSTConfigListener);
}
