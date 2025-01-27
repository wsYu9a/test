package com.wbl.ad.yzz.d.a;

import android.content.Context;
import com.wbl.ad.yzz.network.b.b.a0;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.network.bean.request.GetConfReq;
import com.wbl.ad.yzz.network.bean.request.GetPageMsgReq;
import com.wbl.ad.yzz.network.bean.request.LeaveAdPageReq;
import com.wbl.ad.yzz.network.bean.request.UpRpNumbersReq;
import com.wbl.ad.yzz.network.bean.request.UploadFeedbackReq;
import f.b.a.e;

/* loaded from: classes5.dex */
public interface a {
    void a(@e Context context, int i2, int i3, @e com.wbl.ad.yzz.innerconfig.d.d dVar);

    void a(@e Context context, @e GetConfReq getConfReq, @e com.wbl.ad.yzz.b<k> bVar);

    void a(@e Context context, @e GetPageMsgReq getPageMsgReq, @e com.wbl.ad.yzz.b<u> bVar);

    void a(@e Context context, @e LeaveAdPageReq leaveAdPageReq, @e com.wbl.ad.yzz.b<a0> bVar);

    void a(@e Context context, @e UpRpNumbersReq upRpNumbersReq, @e com.wbl.ad.yzz.b<k0> bVar);

    void a(@e Context context, @e UploadFeedbackReq uploadFeedbackReq, @e com.wbl.ad.yzz.b<Boolean> bVar);

    void a(@f.b.a.d com.wbl.ad.yzz.adrequest.c.e eVar);

    void b(@e Context context, @e GetPageMsgReq getPageMsgReq, @e com.wbl.ad.yzz.b<u> bVar);
}
