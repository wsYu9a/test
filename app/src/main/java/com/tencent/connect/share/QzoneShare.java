package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.utils.c;
import com.tencent.open.utils.d;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_APP = 6;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;

    /* renamed from: c */
    private boolean f25310c;

    /* renamed from: d */
    private boolean f25311d;

    /* renamed from: e */
    private boolean f25312e;

    /* renamed from: f */
    private boolean f25313f;
    public String mViaShareQzoneType;

    /* renamed from: com.tencent.connect.share.QzoneShare$1 */
    class AnonymousClass1 implements c {

        /* renamed from: a */
        final /* synthetic */ Bundle f25314a;

        /* renamed from: b */
        final /* synthetic */ Activity f25315b;

        /* renamed from: c */
        final /* synthetic */ IUiListener f25316c;

        AnonymousClass1(Bundle bundle, Activity activity, IUiListener iUiListener) {
            r2 = bundle;
            r3 = activity;
            r4 = iUiListener;
        }

        @Override // com.tencent.open.utils.c
        public void a(int i2, String str) {
        }

        @Override // com.tencent.open.utils.c
        public void a(int i2, ArrayList<String> arrayList) {
            if (i2 == 0) {
                r2.putStringArrayList("imageUrl", arrayList);
            }
            QzoneShare.this.b(r3, r2, r4);
        }
    }

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.f25310c = true;
        this.f25311d = false;
        this.f25312e = false;
        this.f25313f = false;
    }

    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        String string4 = bundle.getString("audio_url");
        int i2 = bundle.getInt("req_type", 1);
        String string5 = bundle.getString("appName");
        int i3 = bundle.getInt("cflag", 0);
        String string6 = bundle.getString("share_qq_ext_str");
        String appId = this.f25282b.getAppId();
        String openId = this.f25282b.getOpenId();
        f.a("openSDK_LOG.QzoneShare", "openId:" + openId);
        if (stringArrayList != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int size = stringArrayList.size() <= 9 ? stringArrayList.size() : 9;
            int i4 = 0;
            while (i4 < size) {
                ArrayList<String> arrayList = stringArrayList;
                stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i4)));
                if (i4 != size - 1) {
                    stringBuffer2.append(";");
                }
                i4++;
                stringArrayList = arrayList;
            }
            stringBuffer.append("&image_url=" + Base64.encodeToString(i.i(stringBuffer2.toString()), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + Base64.encodeToString(i.i(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + Base64.encodeToString(i.i(string2), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + Base64.encodeToString(i.i(string3), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(i.i(string5), 2));
        }
        if (!i.e(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(i.i(openId), 2));
        }
        if (!i.e(string4)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(i.i(string4), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(i.i(String.valueOf(i2)), 2));
        if (!i.e(string6)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(i.i(string6), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(i.i(String.valueOf(i3)), 2));
        f.a("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(d.a(), this.f25282b, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra(MonitorConstants.PKG_NAME, activity.getPackageName());
        if (i.f(activity, "4.6.0")) {
            if (a(intent)) {
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_QZSHARE, iUiListener);
                a(activity, intent, Constants.REQUEST_OLD_QZSHARE);
            }
            f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
            }
            if (a(intent)) {
                a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
            }
        }
        if (a(intent)) {
            com.tencent.open.b.d.a().a(this.f25282b.getOpenId(), this.f25282b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
            com.tencent.open.b.d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f25282b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            com.tencent.open.b.d.a().a(this.f25282b.getOpenId(), this.f25282b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f25282b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        f.c("openSDK_LOG", "doShareToQzone() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void shareToQzone(android.app.Activity r29, android.os.Bundle r30, com.tencent.tauth.IUiListener r31) {
        /*
            Method dump skipped, instructions count: 1090
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.shareToQzone(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }
}
