package com.bytedance.sdk.openadsdk.live.core;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import java.util.Map;

/* loaded from: classes.dex */
public class zx implements IHostTokenInjectionAuth {

    /* renamed from: j */
    private ITTLiveTokenInjectionAuth f6480j;

    /* renamed from: com.bytedance.sdk.openadsdk.live.core.zx$1 */
    class AnonymousClass1 implements TTLiveAuthCallback {

        /* renamed from: j */
        final /* synthetic */ TokenRefreshCallback f6481j;

        AnonymousClass1(TokenRefreshCallback tokenRefreshCallback) {
            tokenRefreshCallback = tokenRefreshCallback;
        }

        @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
        public void onAuth(TTLiveToken tTLiveToken) {
            tokenRefreshCallback.onSuccess(new TokenInfo(tTLiveToken.name, tTLiveToken.openId, tTLiveToken.accessToken, tTLiveToken.expireAt));
        }

        @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
        public void onFailed(Throwable th) {
            tokenRefreshCallback.onFailed(th);
        }
    }

    public zx(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f6480j = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public TokenInfo getTokenInfo() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f6480j;
        if (iTTLiveTokenInjectionAuth == null) {
            return null;
        }
        TTLiveToken tokenInfo = iTTLiveTokenInjectionAuth.getTokenInfo();
        return tokenInfo == null ? new TokenInfo("", "", "", 0L) : new TokenInfo(tokenInfo.name, tokenInfo.openId, tokenInfo.accessToken, tokenInfo.expireAt);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public boolean isLogin() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f6480j;
        return iTTLiveTokenInjectionAuth != null && iTTLiveTokenInjectionAuth.isLogin();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public void onTokenInvalid(TokenInfo tokenInfo, TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map) {
        if (this.f6480j == null) {
            return;
        }
        this.f6480j.onTokenInvalid(tokenInfo == null ? null : new TTLiveToken(TTLiveConstants.DOUYIN_AUTH_NAME, tokenInfo.getAccessToken(), tokenInfo.getOpenId(), tokenInfo.getExpireAt(), tokenInfo.getName()), new TTLiveAuthCallback() { // from class: com.bytedance.sdk.openadsdk.live.core.zx.1

            /* renamed from: j */
            final /* synthetic */ TokenRefreshCallback f6481j;

            AnonymousClass1(TokenRefreshCallback tokenRefreshCallback2) {
                tokenRefreshCallback = tokenRefreshCallback2;
            }

            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onAuth(TTLiveToken tTLiveToken) {
                tokenRefreshCallback.onSuccess(new TokenInfo(tTLiveToken.name, tTLiveToken.openId, tTLiveToken.accessToken, tTLiveToken.expireAt));
            }

            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onFailed(Throwable th) {
                tokenRefreshCallback.onFailed(th);
            }
        }, activity, map);
    }
}
