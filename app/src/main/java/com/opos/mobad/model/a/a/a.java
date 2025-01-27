package com.opos.mobad.model.a.a;

import android.content.Context;
import com.baidu.mobads.sdk.api.SplashAd;
import com.opos.mobad.model.b.d;
import com.opos.mobad.model.d.f;
import com.tencent.connect.common.Constants;

/* loaded from: classes4.dex */
public class a implements com.opos.mobad.model.a.a {

    /* renamed from: a */
    private Context f21472a;

    /* renamed from: b */
    private com.opos.mobad.model.a.b f21473b;

    public a(Context context, com.opos.mobad.model.a.b bVar) {
        this.f21472a = context.getApplicationContext();
        this.f21473b = bVar;
    }

    private byte[] a(com.opos.mobad.model.b.c cVar) {
        byte[] bArr;
        com.opos.mobad.model.a.b bVar;
        com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData parser:", this.f21473b, "request:", cVar);
        if (this.f21472a != null && (bVar = this.f21473b) != null && cVar != null) {
            try {
                bArr = bVar.a(cVar);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("FetchAdEngine", "", (Throwable) e2);
            }
            com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData result:", bArr);
            return bArr;
        }
        bArr = null;
        com.opos.cmn.an.f.a.b("FetchAdEngine", "prepareReqData result:", bArr);
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0104, code lost:
    
        if (r7 != null) goto L109;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0145 A[Catch: Exception -> 0x0168, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0168, blocks: (B:3:0x0010, B:5:0x0016, B:6:0x0019, B:9:0x0070, B:10:0x007c, B:47:0x0145, B:67:0x0164, B:68:0x0167, B:53:0x014a, B:13:0x009c, B:15:0x00a6, B:17:0x00b3, B:19:0x00c7, B:21:0x00cb, B:23:0x00d1, B:24:0x00d5, B:26:0x00d9, B:28:0x00f3, B:30:0x00f9, B:33:0x00fc, B:35:0x0100, B:40:0x0109, B:41:0x0116, B:44:0x011d), top: B:2:0x0010, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.opos.mobad.model.b.d b(java.lang.String r7, com.opos.mobad.model.b.c r8, com.opos.mobad.model.d.f r9) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.a.a.a.b(java.lang.String, com.opos.mobad.model.b.c, com.opos.mobad.model.d.f):com.opos.mobad.model.b.d");
    }

    @Override // com.opos.mobad.model.a.a
    public d a(String str, com.opos.mobad.model.b.c cVar, f fVar) {
        com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd start=" + System.currentTimeMillis());
        d bVar = new com.opos.mobad.model.b.b(-1, "unknown error.");
        if (!com.opos.cmn.an.c.a.a(str) && cVar != null) {
            try {
                if (com.opos.cmn.an.h.c.a.d(this.f21472a)) {
                    bVar = b(str, cVar, fVar);
                    com.opos.cmn.an.f.a.a("FetchAdEngine", "fetchAd fetchAdResponse=", bVar);
                } else {
                    bVar = new com.opos.mobad.model.b.b(Constants.REQUEST_API, "no net.");
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("FetchAdEngine", SplashAd.KEY_FETCHAD, e2);
            }
        }
        com.opos.cmn.an.f.a.b("FetchAdEngine", "fetchAd end=" + System.currentTimeMillis());
        return bVar;
    }
}
