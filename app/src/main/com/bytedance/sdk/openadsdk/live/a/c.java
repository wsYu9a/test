package com.bytedance.sdk.openadsdk.live.a;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import java.util.Map;

/* loaded from: classes2.dex */
public class c implements IHostTokenInjectionAuth {

    /* renamed from: a */
    private ITTLiveTokenInjectionAuth f8230a;

    /* renamed from: com.bytedance.sdk.openadsdk.live.a.c$1 */
    public class AnonymousClass1 implements TTLiveAuthCallback {

        /* renamed from: a */
        final /* synthetic */ TokenRefreshCallback f8231a;

        public AnonymousClass1(TokenRefreshCallback tokenRefreshCallback) {
            tokenRefreshCallback = tokenRefreshCallback;
        }

        @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
        public void onAuth(TTLiveToken tTLiveToken) {
            tokenRefreshCallback.onSuccess(new TokenInfo(tTLiveToken.name, tTLiveToken.openId, tTLiveToken.accessToken, tTLiveToken.expireAt));
        }

        @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
        public void onFailed(Throwable th2) {
            tokenRefreshCallback.onFailed(th2);
        }
    }

    public c(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f8230a = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public TokenInfo getTokenInfo() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f8230a;
        if (iTTLiveTokenInjectionAuth == null) {
            return null;
        }
        TTLiveToken tokenInfo = iTTLiveTokenInjectionAuth.getTokenInfo();
        return tokenInfo == null ? new TokenInfo("", "", "", 0L) : new TokenInfo(tokenInfo.name, tokenInfo.openId, tokenInfo.accessToken, tokenInfo.expireAt);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public boolean isLogin() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f8230a;
        return iTTLiveTokenInjectionAuth != null && iTTLiveTokenInjectionAuth.isLogin();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public void onTokenInvalid(TokenInfo tokenInfo, TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map) {
        if (this.f8230a == null) {
            return;
        }
        this.f8230a.onTokenInvalid(tokenInfo == null ? null : new TTLiveToken("Venv Test", tokenInfo.getAccessToken(), tokenInfo.getOpenId(), tokenInfo.getExpireAt(), tokenInfo.getName()), new TTLiveAuthCallback() { // from class: com.bytedance.sdk.openadsdk.live.a.c.1

            /* renamed from: a */
            final /* synthetic */ TokenRefreshCallback f8231a;

            public AnonymousClass1(TokenRefreshCallback tokenRefreshCallback2) {
                tokenRefreshCallback = tokenRefreshCallback2;
            }

            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onAuth(TTLiveToken tTLiveToken) {
                tokenRefreshCallback.onSuccess(new TokenInfo(tTLiveToken.name, tTLiveToken.openId, tTLiveToken.accessToken, tTLiveToken.expireAt));
            }

            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onFailed(Throwable th2) {
                tokenRefreshCallback.onFailed(th2);
            }
        }, activity, map);
    }
}
