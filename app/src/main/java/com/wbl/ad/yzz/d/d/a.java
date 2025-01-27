package com.wbl.ad.yzz.d.d;

import com.wbl.ad.yzz.network.b.b.a0;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.network.b.b.u;
import java.util.List;

/* loaded from: classes5.dex */
public interface a {
    void getConfErr(String str);

    void getConfSucess(k kVar);

    void loadAdError(com.wbl.ad.yzz.d.c.a<Object> aVar);

    void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list);

    void loadLeaveError(String str);

    void loadLeaveSuccess(a0 a0Var);

    void loadPageMsgError(boolean z, String str, String str2);

    void loadPageMsgSuccess(boolean z, Object obj, u uVar);

    void loadUpRpError(int i2, String str, String str2);

    void loadUpRpSuccess(k0 k0Var, int i2, com.wbl.ad.yzz.bean.b bVar);

    void uploadFeedbackError(String str);

    void uploadFeedbackSuccess();
}
