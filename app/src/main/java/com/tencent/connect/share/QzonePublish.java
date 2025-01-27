package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.martian.libmars.widget.FoldedTextView;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QzonePublish extends BaseApi {
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    /* renamed from: com.tencent.connect.share.QzonePublish$1 */
    public class AnonymousClass1 implements MediaPlayer.OnPreparedListener {

        /* renamed from: a */
        final /* synthetic */ String f23027a;

        /* renamed from: b */
        final /* synthetic */ Bundle f23028b;

        /* renamed from: c */
        final /* synthetic */ Activity f23029c;

        /* renamed from: d */
        final /* synthetic */ IUiListener f23030d;

        public AnonymousClass1(String str, Bundle bundle, Activity activity, IUiListener iUiListener) {
            string2 = str;
            bundle = bundle;
            activity = activity;
            iUiListener = iUiListener;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            long length = new File(string2).length();
            int duration = mediaPlayer.getDuration();
            bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, string2);
            bundle.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
            bundle.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
            QzonePublish.this.b(activity, bundle, iUiListener);
            f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
        }
    }

    /* renamed from: com.tencent.connect.share.QzonePublish$2 */
    public class AnonymousClass2 implements MediaPlayer.OnErrorListener {

        /* renamed from: a */
        final /* synthetic */ IUiListener f23032a;

        public AnonymousClass2(IUiListener iUiListener) {
            iUiListener = iUiListener;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            f.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return false;
        }
    }

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        f.c("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string = bundle.getString("summary");
        int i10 = bundle.getInt("req_type", 3);
        String string2 = bundle.getString("appName");
        String string3 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        int i11 = bundle.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
        long j10 = bundle.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
        String appId = this.f23006b.getAppId();
        String openId = this.f23006b.getOpenId();
        f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
        if (3 != i10 || stringArrayList == null) {
            str = "";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            int size = stringArrayList.size();
            int i12 = 0;
            while (i12 < size) {
                ArrayList<String> arrayList = stringArrayList;
                stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i12)));
                if (i12 != size - 1) {
                    stringBuffer2.append(";");
                }
                i12++;
                stringArrayList = arrayList;
            }
            stringBuffer.append("&image_url=" + Base64.encodeToString(i.i(stringBuffer2.toString()), 2));
            str = "7";
        }
        if (4 == i10) {
            stringBuffer.append("&videoPath=" + Base64.encodeToString(i.i(string3), 2));
            stringBuffer.append("&videoDuration=" + Base64.encodeToString(i.i(String.valueOf(i11)), 2));
            stringBuffer.append("&videoSize=" + Base64.encodeToString(i.i(String.valueOf(j10)), 2));
            str = "8";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&description=" + Base64.encodeToString(i.i(string), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(i.i(string2), 2));
        }
        if (!i.e(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(i.i(openId), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(i.i(String.valueOf(i10)), 2));
        f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(d.a(), this.f23006b, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra(MonitorConstants.PKG_NAME, activity.getPackageName());
        if (a(intent)) {
            a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
            com.tencent.open.b.d.a().a(0, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
            com.tencent.open.b.d.a().a(this.f23006b.getOpenId(), this.f23006b.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str2, "0", "1", "0");
        } else {
            f.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
            com.tencent.open.b.d.a().a(this.f23006b.getOpenId(), this.f23006b.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str2, "0", "1", "0");
        }
        f.c("openSDK_LOG", "doPublishToQzone() --end");
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        if (g.c(activity, "5.9.5") < 0) {
            iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new TDialog(activity, "", a(""), null, this.f23006b).show();
            return;
        }
        String string = bundle.getString("summary");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String b10 = i.b(activity);
        if (b10 == null) {
            b10 = bundle.getString("appName");
        } else if (b10.length() > 20) {
            b10 = b10.substring(0, 20) + FoldedTextView.f12585y;
        }
        if (!TextUtils.isEmpty(b10)) {
            bundle.putString("appName", b10);
        }
        bundle.putString("summary", string);
        int i10 = bundle.getInt("req_type");
        if (i10 == 3) {
            if (stringArrayList != null && stringArrayList.size() > 0) {
                for (int i11 = 0; i11 < stringArrayList.size(); i11++) {
                    if (!i.h(stringArrayList.get(i11))) {
                        stringArrayList.remove(i11);
                    }
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            }
            b(activity, bundle, iUiListener);
            f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            return;
        }
        if (i10 != 4) {
            iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
            f.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f23006b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            return;
        }
        String string2 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        if (!i.h(string2)) {
            f.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.connect.share.QzonePublish.1

            /* renamed from: a */
            final /* synthetic */ String f23027a;

            /* renamed from: b */
            final /* synthetic */ Bundle f23028b;

            /* renamed from: c */
            final /* synthetic */ Activity f23029c;

            /* renamed from: d */
            final /* synthetic */ IUiListener f23030d;

            public AnonymousClass1(String string22, Bundle bundle2, Activity activity2, IUiListener iUiListener2) {
                string2 = string22;
                bundle = bundle2;
                activity = activity2;
                iUiListener = iUiListener2;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                long length = new File(string2).length();
                int duration = mediaPlayer2.getDuration();
                bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, string2);
                bundle.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                bundle.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                QzonePublish.this.b(activity, bundle, iUiListener);
                f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.connect.share.QzonePublish.2

            /* renamed from: a */
            final /* synthetic */ IUiListener f23032a;

            public AnonymousClass2(IUiListener iUiListener2) {
                iUiListener = iUiListener2;
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i102, int i112) {
                f.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                return false;
            }
        });
        try {
            mediaPlayer.setDataSource(string22);
            mediaPlayer.prepareAsync();
        } catch (Exception unused) {
            f.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
            iUiListener2.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
        }
    }
}
