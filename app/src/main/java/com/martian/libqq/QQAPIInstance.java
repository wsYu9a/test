package com.martian.libqq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.d.i;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class QQAPIInstance {
    private static QQAPIInstance instance;
    private IUiListener mLoginListener;
    private IUiListener mShareListener;
    private Tencent mTencent;

    /* renamed from: com.martian.libqq.QQAPIInstance$1 */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements IUiListener {
        final /* synthetic */ OnLoginListener val$listener;

        AnonymousClass1(final OnLoginListener val$listener) {
            listener = val$listener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            listener.onLoginCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object o) {
            QQAuth qQAuth = (QQAuth) GsonUtils.b().fromJson(o.toString(), QQAuth.class);
            if (qQAuth.hasError()) {
                listener.onLoginError(qQAuth.getErrcode(), qQAuth.getErrMsg());
                return;
            }
            QQAPIInstance.this.mTencent.getQQToken().setOpenId(qQAuth.openid);
            QQAPIInstance.this.mTencent.getQQToken().setAccessToken(qQAuth.access_token, qQAuth.expires_in + "");
            QQAPIInstance.this.mTencent.getQQToken().setAuthSource(2);
            listener.onLoginSuccess(qQAuth);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            listener.onLoginError(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* renamed from: com.martian.libqq.QQAPIInstance$2 */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements IUiListener {
        final /* synthetic */ QQUserInfoReceiver val$listener;

        AnonymousClass2(final QQUserInfoReceiver val$listener) {
            listener = val$listener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            listener.onCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object o) {
            QQUserInfo qQUserInfo = (QQUserInfo) GsonUtils.b().fromJson(o.toString(), QQUserInfo.class);
            if (qQUserInfo.hasError()) {
                listener.onErrorReceived(qQUserInfo.getErrcode(), qQUserInfo.getErrMsg());
            } else {
                listener.onUserInfoReceived(qQUserInfo);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            listener.onErrorReceived(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* renamed from: com.martian.libqq.QQAPIInstance$3 */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements IUiListener {
        final /* synthetic */ QQShareReceiver val$listener;

        AnonymousClass3(final QQShareReceiver val$listener) {
            listener = val$listener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            listener.onCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object o) {
            if (o != null) {
                listener.onShareSuccess(o.toString());
            } else {
                listener.onShareError(-1, "Null result.");
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            listener.onShareError(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* renamed from: com.martian.libqq.QQAPIInstance$4 */
    /* loaded from: classes3.dex */
    class AnonymousClass4 implements IUiListener {
        final /* synthetic */ QQShareReceiver val$listener;

        AnonymousClass4(final QQShareReceiver val$listener) {
            listener = val$listener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            listener.onCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object o) {
            listener.onShareSuccess(o.toString());
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            listener.onShareError(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* renamed from: com.martian.libqq.QQAPIInstance$5 */
    /* loaded from: classes3.dex */
    class AnonymousClass5 implements IUiListener {
        final /* synthetic */ QQShareReceiver val$listener;

        AnonymousClass5(final QQShareReceiver val$listener) {
            listener = val$listener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            listener.onCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object o) {
            listener.onShareSuccess(o.toString());
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            listener.onShareError(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* loaded from: classes3.dex */
    public interface OnLoginListener {
        void onLoginCancelled();

        void onLoginError(int errcode, String errStr);

        void onLoginSuccess(QQAuth auth);
    }

    public interface QQShareReceiver {
        void onCancelled();

        void onShareError(int errcode, String errStr);

        void onShareSuccess(String shareResult);
    }

    /* loaded from: classes3.dex */
    public interface QQUserInfoReceiver {
        void onCancelled();

        void onErrorReceived(int errcode, String errStr);

        void onUserInfoReceived(QQUserInfo user);
    }

    public static QQAPIInstance getInstance() {
        if (instance == null) {
            instance = new QQAPIInstance();
        }
        return instance;
    }

    public void getUserInfo(Context context, final QQUserInfoReceiver listener) {
        new UserInfo(context, this.mTencent.getQQToken()).getUserInfo(new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.2
            final /* synthetic */ QQUserInfoReceiver val$listener;

            AnonymousClass2(final QQUserInfoReceiver listener2) {
                listener = listener2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                listener.onCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object o) {
                QQUserInfo qQUserInfo = (QQUserInfo) GsonUtils.b().fromJson(o.toString(), QQUserInfo.class);
                if (qQUserInfo.hasError()) {
                    listener.onErrorReceived(qQUserInfo.getErrcode(), qQUserInfo.getErrMsg());
                } else {
                    listener.onUserInfoReceived(qQUserInfo);
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                listener.onErrorReceived(uiError.errorCode, uiError.errorMessage);
            }
        });
    }

    public void init(i qqKey, Context context) {
        try {
            this.mTencent = Tencent.createInstance(qqKey.f9892a, context);
        } catch (Exception unused) {
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IUiListener iUiListener = this.mLoginListener;
        if (iUiListener != null) {
            if (requestCode == 11101 || requestCode == 10001) {
                Tencent.onActivityResultData(requestCode, resultCode, data, iUiListener);
                this.mLoginListener = null;
            }
        }
    }

    public void setQQActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode, resultCode, data, this.mShareListener);
        Tencent.handleResultData(data, this.mShareListener);
    }

    public void startLogin(Activity activity, final OnLoginListener listener) {
        AnonymousClass1 anonymousClass1 = new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.1
            final /* synthetic */ OnLoginListener val$listener;

            AnonymousClass1(final OnLoginListener listener2) {
                listener = listener2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                listener.onLoginCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object o) {
                QQAuth qQAuth = (QQAuth) GsonUtils.b().fromJson(o.toString(), QQAuth.class);
                if (qQAuth.hasError()) {
                    listener.onLoginError(qQAuth.getErrcode(), qQAuth.getErrMsg());
                    return;
                }
                QQAPIInstance.this.mTencent.getQQToken().setOpenId(qQAuth.openid);
                QQAPIInstance.this.mTencent.getQQToken().setAccessToken(qQAuth.access_token, qQAuth.expires_in + "");
                QQAPIInstance.this.mTencent.getQQToken().setAuthSource(2);
                listener.onLoginSuccess(qQAuth);
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                listener.onLoginError(uiError.errorCode, uiError.errorMessage);
            }
        };
        this.mLoginListener = anonymousClass1;
        this.mTencent.login(activity, "all", anonymousClass1);
    }

    public void startQQShare(Activity activity, String title, String content, String url, String imgUrl, final QQShareReceiver listener) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", title);
        bundle.putString("summary", content);
        bundle.putString("targetUrl", url);
        bundle.putString("imageUrl", imgUrl);
        bundle.putString("appName", activity.getString(R.string.app_name));
        AnonymousClass3 anonymousClass3 = new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.3
            final /* synthetic */ QQShareReceiver val$listener;

            AnonymousClass3(final QQShareReceiver listener2) {
                listener = listener2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                listener.onCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object o) {
                if (o != null) {
                    listener.onShareSuccess(o.toString());
                } else {
                    listener.onShareError(-1, "Null result.");
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                listener.onShareError(uiError.errorCode, uiError.errorMessage);
            }
        };
        this.mShareListener = anonymousClass3;
        this.mTencent.shareToQQ(activity, bundle, anonymousClass3);
    }

    public void startQQzoneImage(Activity activity, String url, ArrayList<String> imgUrls, final QQShareReceiver listener) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 3);
        bundle.putString("targetUrl", url);
        bundle.putStringArrayList("imageUrl", imgUrls);
        AnonymousClass5 anonymousClass5 = new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.5
            final /* synthetic */ QQShareReceiver val$listener;

            AnonymousClass5(final QQShareReceiver listener2) {
                listener = listener2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                listener.onCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object o) {
                listener.onShareSuccess(o.toString());
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                listener.onShareError(uiError.errorCode, uiError.errorMessage);
            }
        };
        this.mShareListener = anonymousClass5;
        this.mTencent.publishToQzone(activity, bundle, anonymousClass5);
    }

    public void startQzoneShare(Activity activity, String title, String content, String url, ArrayList<String> imgUrls, final QQShareReceiver listener) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", title);
        bundle.putString("summary", content);
        bundle.putString("targetUrl", url);
        bundle.putStringArrayList("imageUrl", imgUrls);
        AnonymousClass4 anonymousClass4 = new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.4
            final /* synthetic */ QQShareReceiver val$listener;

            AnonymousClass4(final QQShareReceiver listener2) {
                listener = listener2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                listener.onCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object o) {
                listener.onShareSuccess(o.toString());
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                listener.onShareError(uiError.errorCode, uiError.errorMessage);
            }
        };
        this.mShareListener = anonymousClass4;
        this.mTencent.shareToQzone(activity, bundle, anonymousClass4);
    }
}
