package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.d;
import com.tencent.tauth.IUiListener;

/* loaded from: classes4.dex */
public class UserInfo extends BaseApi {
    public static final String GRAPH_OPEN_ID = "oauth2.0/m_me";

    public UserInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void getOpenId(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.f25282b, d.a(), GRAPH_OPEN_ID, a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void getTenPayAddr(IUiListener iUiListener) {
        Bundle a2 = a();
        a2.putString("ver", "1");
        HttpUtils.requestAsync(this.f25282b, d.a(), "cft_info/get_tenpay_addr", a2, "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void getUserInfo(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.f25282b, d.a(), "user/get_simple_userinfo", a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void getVipUserInfo(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.f25282b, d.a(), "user/get_vip_info", a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void getVipUserRichInfo(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.f25282b, d.a(), "user/get_vip_rich_info", a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public UserInfo(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }
}
