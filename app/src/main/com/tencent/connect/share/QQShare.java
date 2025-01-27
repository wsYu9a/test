package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.b;
import com.tencent.open.utils.c;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QQShare extends BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 60;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 45;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_APP = 6;
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public String mViaShareQQType;

    /* renamed from: com.tencent.connect.share.QQShare$1 */
    public class AnonymousClass1 implements c {

        /* renamed from: a */
        final /* synthetic */ Bundle f23015a;

        /* renamed from: b */
        final /* synthetic */ String f23016b;

        /* renamed from: c */
        final /* synthetic */ String f23017c;

        /* renamed from: d */
        final /* synthetic */ IUiListener f23018d;

        /* renamed from: e */
        final /* synthetic */ Activity f23019e;

        public AnonymousClass1(Bundle bundle, String str, String str2, IUiListener iUiListener, Activity activity) {
            bundle = bundle;
            string2 = str;
            string3 = str2;
            iUiListener = iUiListener;
            activity = activity;
        }

        @Override // com.tencent.open.utils.c
        public void a(int i10, ArrayList<String> arrayList) {
        }

        @Override // com.tencent.open.utils.c
        public void a(int i10, String str) {
            if (i10 == 0) {
                bundle.putString("imageLocalUrl", str);
            } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                IUiListener iUiListener = iUiListener;
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                    f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                d.a().a(1, "SHARE_CHECK_SDK", "1000", ((BaseApi) QQShare.this).f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                return;
            }
            QQShare.this.c(activity, bundle, iUiListener);
        }
    }

    /* renamed from: com.tencent.connect.share.QQShare$2 */
    public class AnonymousClass2 implements c {

        /* renamed from: a */
        final /* synthetic */ Bundle f23021a;

        /* renamed from: b */
        final /* synthetic */ String f23022b;

        /* renamed from: c */
        final /* synthetic */ String f23023c;

        /* renamed from: d */
        final /* synthetic */ IUiListener f23024d;

        /* renamed from: e */
        final /* synthetic */ Activity f23025e;

        public AnonymousClass2(Bundle bundle, String str, String str2, IUiListener iUiListener, Activity activity) {
            bundle = bundle;
            string2 = str;
            string3 = str2;
            iUiListener = iUiListener;
            activity = activity;
        }

        @Override // com.tencent.open.utils.c
        public void a(int i10, ArrayList<String> arrayList) {
        }

        @Override // com.tencent.open.utils.c
        public void a(int i10, String str) {
            if (i10 == 0) {
                bundle.putString("imageLocalUrl", str);
            } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                IUiListener iUiListener = iUiListener;
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                    f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                d.a().a(1, "SHARE_CHECK_SDK", "1000", ((BaseApi) QQShare.this).f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                return;
            }
            QQShare.this.c(activity, bundle, iUiListener);
        }
    }

    public QQShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQQType = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.app.Activity r29, android.os.Bundle r30, com.tencent.tauth.IUiListener r31) {
        /*
            Method dump skipped, instructions count: 866
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.c(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        f.c("openSDK_LOG.QQShare", "shareToQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("imageLocalUrl");
        int i10 = bundle.getInt("req_type", 1);
        f.c("openSDK_LOG.QQShare", "shareToQQ -- type: " + i10);
        if (i10 == 1) {
            this.mViaShareQQType = "1";
        } else if (i10 == 2) {
            this.mViaShareQQType = "3";
        } else if (i10 == 5) {
            this.mViaShareQQType = "2";
        } else if (i10 == 6) {
            this.mViaShareQQType = "4";
        }
        if (i10 == 6) {
            if (i.f(activity, "5.0.0")) {
                iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                f.e("openSDK_LOG.QQShare", "shareToQQ, app share is not support below qq5.0.");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, app share is not support below qq5.0.");
                return;
            }
            string4 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", this.f23006b.getAppId(), "mqq");
            bundle.putString("targetUrl", string4);
        }
        if (!i.b() && i.f(activity, "4.5.0")) {
            iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
            f.e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
            return;
        }
        if (i10 == 5) {
            if (i.f(activity, "4.3.0")) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_QQ_VERSION_ERROR, null));
                f.e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                return;
            } else if (!i.h(string5)) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                f.e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR);
                return;
            }
        }
        if (i10 != 5) {
            if (TextUtils.isEmpty(string4) || !(string4.startsWith("http://") || string4.startsWith("https://"))) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_ERROR, null));
                f.e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                return;
            } else if (TextUtils.isEmpty(string2)) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                f.e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                return;
            }
        }
        if (!TextUtils.isEmpty(string) && !string.startsWith("http://") && !string.startsWith("https://") && !new File(string).exists()) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
            f.e("openSDK_LOG.QQShare", "shareToQQ, image url is emprty or illegal.");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
            return;
        }
        if (TextUtils.isEmpty(string2) || string2.length() <= 45) {
            str = null;
        } else {
            str = null;
            bundle.putString("title", i.a(string2, 45, (String) null, (String) null));
        }
        if (!TextUtils.isEmpty(string3) && string3.length() > 60) {
            bundle.putString("summary", i.a(string3, 60, str, str));
        }
        if (i.a(activity)) {
            f.c("openSDK_LOG.QQShare", "shareToQQ, support share");
            b(activity, bundle, iUiListener);
        } else {
            try {
                f.d("openSDK_LOG.QQShare", "shareToQQ, don't support share, will show download dialog");
                str2 = str;
            } catch (RuntimeException e10) {
                e = e10;
                str2 = str;
            }
            try {
                new TDialog(activity, "", a(""), null, this.f23006b).show();
            } catch (RuntimeException e11) {
                e = e11;
                f.b("openSDK_LOG.QQShare", " shareToQQ, TDialog.show not in main thread", e);
                e.printStackTrace();
                iUiListener.onError(new UiError(-6, Constants.MSG_NOT_CALL_ON_MAIN_THREAD, str2));
                f.c("openSDK_LOG.QQShare", "shareToQQ() -- end.");
            }
        }
        f.c("openSDK_LOG.QQShare", "shareToQQ() -- end.");
    }

    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        f.a("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (TextUtils.isEmpty(string)) {
            c(activity, bundle, iUiListener);
        } else if (!i.g(string)) {
            bundle.putString("imageUrl", null);
            if (i.f(activity, "4.3.0")) {
                f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                c(activity, bundle, iUiListener);
            } else {
                f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0 ");
                a.a(activity, string, new c() { // from class: com.tencent.connect.share.QQShare.2

                    /* renamed from: a */
                    final /* synthetic */ Bundle f23021a;

                    /* renamed from: b */
                    final /* synthetic */ String f23022b;

                    /* renamed from: c */
                    final /* synthetic */ String f23023c;

                    /* renamed from: d */
                    final /* synthetic */ IUiListener f23024d;

                    /* renamed from: e */
                    final /* synthetic */ Activity f23025e;

                    public AnonymousClass2(Bundle bundle2, String string22, String string32, IUiListener iUiListener2, Activity activity2) {
                        bundle = bundle2;
                        string2 = string22;
                        string3 = string32;
                        iUiListener = iUiListener2;
                        activity = activity2;
                    }

                    @Override // com.tencent.open.utils.c
                    public void a(int i10, ArrayList<String> arrayList) {
                    }

                    @Override // com.tencent.open.utils.c
                    public void a(int i10, String str) {
                        if (i10 == 0) {
                            bundle.putString("imageLocalUrl", str);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            d.a().a(1, "SHARE_CHECK_SDK", "1000", ((BaseApi) QQShare.this).f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        QQShare.this.c(activity, bundle, iUiListener);
                    }
                });
            }
        } else {
            if (TextUtils.isEmpty(string22) && TextUtils.isEmpty(string32)) {
                if (iUiListener2 != null) {
                    iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                    f.e("openSDK_LOG.QQShare", Constants.MSG_SHARE_NOSD_ERROR);
                }
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
                return;
            }
            if (i.f(activity2, "4.3.0")) {
                new b(activity2).a(string, new c() { // from class: com.tencent.connect.share.QQShare.1

                    /* renamed from: a */
                    final /* synthetic */ Bundle f23015a;

                    /* renamed from: b */
                    final /* synthetic */ String f23016b;

                    /* renamed from: c */
                    final /* synthetic */ String f23017c;

                    /* renamed from: d */
                    final /* synthetic */ IUiListener f23018d;

                    /* renamed from: e */
                    final /* synthetic */ Activity f23019e;

                    public AnonymousClass1(Bundle bundle2, String string22, String string32, IUiListener iUiListener2, Activity activity2) {
                        bundle = bundle2;
                        string2 = string22;
                        string3 = string32;
                        iUiListener = iUiListener2;
                        activity = activity2;
                    }

                    @Override // com.tencent.open.utils.c
                    public void a(int i10, ArrayList<String> arrayList) {
                    }

                    @Override // com.tencent.open.utils.c
                    public void a(int i10, String str) {
                        if (i10 == 0) {
                            bundle.putString("imageLocalUrl", str);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            d.a().a(1, "SHARE_CHECK_SDK", "1000", ((BaseApi) QQShare.this).f23006b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        QQShare.this.c(activity, bundle, iUiListener);
                    }
                });
            } else {
                c(activity2, bundle2, iUiListener2);
            }
        }
        f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }
}
