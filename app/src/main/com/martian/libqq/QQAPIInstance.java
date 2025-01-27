package com.martian.libqq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.martian.libcomm.utils.GsonUtils;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import g9.i;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class QQAPIInstance {
    private static QQAPIInstance instance;
    private IUiListener mLoginListener;
    private IUiListener mShareListener;
    private Tencent mTencent;

    /* renamed from: com.martian.libqq.QQAPIInstance$1 */
    public class AnonymousClass1 implements IUiListener {
        final /* synthetic */ OnLoginListener val$listener;

        public AnonymousClass1(OnLoginListener onLoginListener) {
            onLoginListener = onLoginListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            onLoginListener.onLoginCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            QQAuth qQAuth = (QQAuth) GsonUtils.b().fromJson(obj.toString(), QQAuth.class);
            if (qQAuth.hasError()) {
                onLoginListener.onLoginError(qQAuth.getErrcode(), qQAuth.getErrMsg());
                return;
            }
            QQAPIInstance.this.mTencent.getQQToken().setOpenId(qQAuth.openid);
            QQAPIInstance.this.mTencent.getQQToken().setAccessToken(qQAuth.access_token, qQAuth.expires_in + "");
            QQAPIInstance.this.mTencent.getQQToken().setAuthSource(2);
            onLoginListener.onLoginSuccess(qQAuth);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            onLoginListener.onLoginError(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* renamed from: com.martian.libqq.QQAPIInstance$2 */
    public class AnonymousClass2 implements IUiListener {
        final /* synthetic */ QQUserInfoReceiver val$listener;

        public AnonymousClass2(QQUserInfoReceiver qQUserInfoReceiver) {
            qQUserInfoReceiver = qQUserInfoReceiver;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            qQUserInfoReceiver.onCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            QQUserInfo qQUserInfo = (QQUserInfo) GsonUtils.b().fromJson(obj.toString(), QQUserInfo.class);
            if (qQUserInfo.hasError()) {
                qQUserInfoReceiver.onErrorReceived(qQUserInfo.getErrcode(), qQUserInfo.getErrMsg());
            } else {
                qQUserInfoReceiver.onUserInfoReceived(qQUserInfo);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            qQUserInfoReceiver.onErrorReceived(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* renamed from: com.martian.libqq.QQAPIInstance$3 */
    public class AnonymousClass3 implements IUiListener {
        final /* synthetic */ QQShareReceiver val$listener;

        public AnonymousClass3(QQShareReceiver qQShareReceiver) {
            qQShareReceiver = qQShareReceiver;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            qQShareReceiver.onCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj != null) {
                qQShareReceiver.onShareSuccess(obj.toString());
            } else {
                qQShareReceiver.onShareError(-1, "Null result.");
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            qQShareReceiver.onShareError(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* renamed from: com.martian.libqq.QQAPIInstance$4 */
    public class AnonymousClass4 implements IUiListener {
        final /* synthetic */ QQShareReceiver val$listener;

        public AnonymousClass4(QQShareReceiver qQShareReceiver) {
            qQShareReceiver = qQShareReceiver;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            qQShareReceiver.onCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            qQShareReceiver.onShareSuccess(obj.toString());
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            qQShareReceiver.onShareError(uiError.errorCode, uiError.errorMessage);
        }
    }

    /* renamed from: com.martian.libqq.QQAPIInstance$5 */
    public class AnonymousClass5 implements IUiListener {
        final /* synthetic */ QQShareReceiver val$listener;

        public AnonymousClass5(QQShareReceiver qQShareReceiver) {
            qQShareReceiver = qQShareReceiver;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            qQShareReceiver.onCancelled();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            qQShareReceiver.onShareSuccess(obj.toString());
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            qQShareReceiver.onShareError(uiError.errorCode, uiError.errorMessage);
        }
    }

    public interface OnLoginListener {
        void onLoginCancelled();

        void onLoginError(int i10, String str);

        void onLoginSuccess(QQAuth qQAuth);
    }

    public interface QQShareReceiver {
        void onCancelled();

        void onShareError(int i10, String str);

        void onShareSuccess(String str);
    }

    public interface QQUserInfoReceiver {
        void onCancelled();

        void onErrorReceived(int i10, String str);

        void onUserInfoReceived(QQUserInfo qQUserInfo);
    }

    public static QQAPIInstance getInstance() {
        if (instance == null) {
            instance = new QQAPIInstance();
        }
        return instance;
    }

    public void getUserInfo(Context context, QQUserInfoReceiver qQUserInfoReceiver) {
        new UserInfo(context, this.mTencent.getQQToken()).getUserInfo(new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.2
            final /* synthetic */ QQUserInfoReceiver val$listener;

            public AnonymousClass2(QQUserInfoReceiver qQUserInfoReceiver2) {
                qQUserInfoReceiver = qQUserInfoReceiver2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                qQUserInfoReceiver.onCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                QQUserInfo qQUserInfo = (QQUserInfo) GsonUtils.b().fromJson(obj.toString(), QQUserInfo.class);
                if (qQUserInfo.hasError()) {
                    qQUserInfoReceiver.onErrorReceived(qQUserInfo.getErrcode(), qQUserInfo.getErrMsg());
                } else {
                    qQUserInfoReceiver.onUserInfoReceived(qQUserInfo);
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                qQUserInfoReceiver.onErrorReceived(uiError.errorCode, uiError.errorMessage);
            }
        });
    }

    public void init(i iVar, Context context) {
        try {
            this.mTencent = Tencent.createInstance(iVar.f26194a, context);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        IUiListener iUiListener = this.mLoginListener;
        if (iUiListener != null) {
            if (i10 == 11101 || i10 == 10001) {
                Tencent.onActivityResultData(i10, i11, intent, iUiListener);
                this.mLoginListener = null;
            }
        }
    }

    public void startLogin(Activity activity, OnLoginListener onLoginListener) {
        AnonymousClass1 anonymousClass1 = new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.1
            final /* synthetic */ OnLoginListener val$listener;

            public AnonymousClass1(OnLoginListener onLoginListener2) {
                onLoginListener = onLoginListener2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                onLoginListener.onLoginCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                QQAuth qQAuth = (QQAuth) GsonUtils.b().fromJson(obj.toString(), QQAuth.class);
                if (qQAuth.hasError()) {
                    onLoginListener.onLoginError(qQAuth.getErrcode(), qQAuth.getErrMsg());
                    return;
                }
                QQAPIInstance.this.mTencent.getQQToken().setOpenId(qQAuth.openid);
                QQAPIInstance.this.mTencent.getQQToken().setAccessToken(qQAuth.access_token, qQAuth.expires_in + "");
                QQAPIInstance.this.mTencent.getQQToken().setAuthSource(2);
                onLoginListener.onLoginSuccess(qQAuth);
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                onLoginListener.onLoginError(uiError.errorCode, uiError.errorMessage);
            }
        };
        this.mLoginListener = anonymousClass1;
        this.mTencent.login(activity, "all", anonymousClass1);
    }

    public void startQQShare(Activity activity, String str, String str2, String str3, String str4, QQShareReceiver qQShareReceiver) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", str);
        bundle.putString("summary", str2);
        bundle.putString("targetUrl", str3);
        bundle.putString("imageUrl", str4);
        bundle.putString("appName", activity.getString(R.string.app_name));
        AnonymousClass3 anonymousClass3 = new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.3
            final /* synthetic */ QQShareReceiver val$listener;

            public AnonymousClass3(QQShareReceiver qQShareReceiver2) {
                qQShareReceiver = qQShareReceiver2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                qQShareReceiver.onCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                if (obj != null) {
                    qQShareReceiver.onShareSuccess(obj.toString());
                } else {
                    qQShareReceiver.onShareError(-1, "Null result.");
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                qQShareReceiver.onShareError(uiError.errorCode, uiError.errorMessage);
            }
        };
        this.mShareListener = anonymousClass3;
        this.mTencent.shareToQQ(activity, bundle, anonymousClass3);
    }

    public void startQQzoneImage(Activity activity, String str, ArrayList<String> arrayList, QQShareReceiver qQShareReceiver) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 3);
        bundle.putString("targetUrl", str);
        bundle.putStringArrayList("imageUrl", arrayList);
        AnonymousClass5 anonymousClass5 = new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.5
            final /* synthetic */ QQShareReceiver val$listener;

            public AnonymousClass5(QQShareReceiver qQShareReceiver2) {
                qQShareReceiver = qQShareReceiver2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                qQShareReceiver.onCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                qQShareReceiver.onShareSuccess(obj.toString());
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                qQShareReceiver.onShareError(uiError.errorCode, uiError.errorMessage);
            }
        };
        this.mShareListener = anonymousClass5;
        this.mTencent.publishToQzone(activity, bundle, anonymousClass5);
    }

    public void startQzoneShare(Activity activity, String str, String str2, String str3, ArrayList<String> arrayList, QQShareReceiver qQShareReceiver) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", str);
        bundle.putString("summary", str2);
        bundle.putString("targetUrl", str3);
        bundle.putStringArrayList("imageUrl", arrayList);
        AnonymousClass4 anonymousClass4 = new IUiListener() { // from class: com.martian.libqq.QQAPIInstance.4
            final /* synthetic */ QQShareReceiver val$listener;

            public AnonymousClass4(QQShareReceiver qQShareReceiver2) {
                qQShareReceiver = qQShareReceiver2;
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                qQShareReceiver.onCancelled();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                qQShareReceiver.onShareSuccess(obj.toString());
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                qQShareReceiver.onShareError(uiError.errorCode, uiError.errorMessage);
            }
        };
        this.mShareListener = anonymousClass4;
        this.mTencent.shareToQzone(activity, bundle, anonymousClass4);
    }
}
