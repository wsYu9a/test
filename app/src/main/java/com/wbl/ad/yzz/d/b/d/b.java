package com.wbl.ad.yzz.d.b.d;

import android.content.Context;
import com.wbl.ad.yzz.innerconfig.d.d;
import com.wbl.ad.yzz.network.bean.request.GetConfReq;
import com.wbl.ad.yzz.network.bean.request.GetPageMsgReq;
import com.wbl.ad.yzz.network.bean.request.LeaveAdPageReq;
import com.wbl.ad.yzz.network.bean.request.UpRpNumbersReq;
import com.wbl.ad.yzz.network.bean.request.UploadFeedbackReq;
import f.b.a.e;

/* loaded from: classes5.dex */
public interface b<V, M> extends com.wbl.ad.yzz.d.b.b<V, M> {
    void a(@e Context context, int i2, int i3, @e d dVar);

    void a(@e Context context, @e GetConfReq getConfReq);

    void a(@e Context context, @e GetPageMsgReq getPageMsgReq);

    void a(@e Context context, @e LeaveAdPageReq leaveAdPageReq);

    void a(@e Context context, @e UpRpNumbersReq upRpNumbersReq, boolean z);

    void a(@e Context context, @e UploadFeedbackReq uploadFeedbackReq);

    void a(@f.b.a.d com.wbl.ad.yzz.adrequest.c.e eVar);

    void a(@e Object obj, @e Context context, @e GetPageMsgReq getPageMsgReq);

    void a(@e Object obj, @f.b.a.d com.wbl.ad.yzz.adrequest.c.e eVar);

    void b(@e Context context, @e GetPageMsgReq getPageMsgReq);
}
