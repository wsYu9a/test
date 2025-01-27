package com.maritan.libweixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import z7.b;

/* loaded from: classes3.dex */
public class WXCallbackActivity extends Activity implements IWXAPIEventHandler {
    public void a(SendAuth.Resp resp) {
        int i10 = resp.errCode;
        if (i10 == -2) {
            b.d().g();
        } else if (i10 != 0) {
            b.d().h(resp.errStr);
        } else {
            b.d().i(resp.code);
        }
    }

    public void b(BaseResp baseResp) {
        int i10 = baseResp.errCode;
        if (i10 == -2) {
            b.d().j();
        } else if (i10 != 0) {
            b.d().k(baseResp.errStr);
        } else {
            b.d().m();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IWXAPI e10 = b.d().e();
        if (e10 != null) {
            e10.handleIntent(getIntent(), this);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        IWXAPI e10 = b.d().e();
        if (e10 != null) {
            e10.handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == 5) {
            b(baseResp);
            finish();
            return;
        }
        if (baseResp.getType() == 1) {
            if (baseResp instanceof SendAuth.Resp) {
                a((SendAuth.Resp) baseResp);
            }
            finish();
        } else {
            if (baseResp.getType() == 19) {
                finish();
                return;
            }
            int i10 = baseResp.errCode;
            if (i10 == -2) {
                b.d().n(baseResp.transaction);
            } else if (i10 != 0) {
                b.d().o(baseResp.transaction, baseResp.errStr);
            } else {
                b.d().p(baseResp.transaction);
            }
            finish();
        }
    }
}
