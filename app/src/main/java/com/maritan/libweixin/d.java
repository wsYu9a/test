package com.maritan.libweixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/* loaded from: classes2.dex */
public class d extends Activity implements IWXAPIEventHandler {
    public void a(SendAuth.Resp resp) {
        int i2 = resp.errCode;
        if (i2 == -2) {
            c.g().j();
        } else if (i2 != 0) {
            c.g().k(resp.errStr);
        } else {
            c.g().l(resp.code);
        }
    }

    public void b(BaseResp resp) {
        int i2 = resp.errCode;
        if (i2 == -2) {
            c.g().m(((PayResp) resp).prepayId);
            return;
        }
        if (i2 == -1) {
            c.g().n(((PayResp) resp).prepayId, resp.errStr);
        } else if (i2 != 0) {
            c.g().n(((PayResp) resp).prepayId, resp.errStr);
        } else {
            c.g().p(((PayResp) resp).prepayId);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c.g().f9552c.handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        c.g().f9552c.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp resp) {
        if (resp.getType() == 5) {
            b(resp);
            finish();
            return;
        }
        if (resp.getType() == 1) {
            if (resp instanceof SendAuth.Resp) {
                a((SendAuth.Resp) resp);
            }
            finish();
        } else {
            if (resp.getType() == 19) {
                finish();
                return;
            }
            int i2 = resp.errCode;
            if (i2 == -2) {
                c.g().q(resp.transaction);
            } else if (i2 != 0) {
                c.g().r(resp.transaction, resp.errStr);
            } else {
                c.g().s(resp.transaction);
            }
            finish();
        }
    }
}
