package com.vivo.ic.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import java.io.File;

/* loaded from: classes4.dex */
public class HTMLFileUploader {
    private static final String CAMERA_PACKAGE_NAME = "com.android.camera";
    private static final String CAMERA_PACKAGE_NAME1 = "com.android.attachcamera";
    private static final String FILE_PACKAGE_NAME = "com.android.filemanager.MESSAGE_FILE_SELECTOR";
    private static final String FILE_SYSTEM_RETURN = "MESSAGE_CHOOSED_FILE_URI";
    private static final String TAG = "HTMLFileUploader";
    private static final String TYPE_AUTIO_ACCEPT = "audio/";
    private static final String TYPE_AUTIO_CAPTURE = "microphone";
    private static final String TYPE_AUTIO_FILTER = "audio/*";
    private static final int TYPE_AUTIO_FLAG = 5;
    private static final String TYPE_IMAGE_ACCEPT = "image/";
    private static final String TYPE_IMAGE_CAPTURE = "camera";
    private static final int TYPE_IMAGE_FLAG = 1;
    private static final String TYPE_VIDEO_ACCEPT = "video/";
    private static final String TYPE_VIDEO_CAPTURE = "camcorder";
    private static final String TYPE_VIDEO_FILTER = "video/*";
    private static final int TYPE_VIDEO_FLAG = 3;
    private static final int WEBVIEW_FILE_SELECT = 243;
    private static final int WEBVIEW_FILE_SYSTEM = 244;
    private static final int WEBVIEW_IMG_PICK = 241;
    private static final int WEBVIEW_TAKE_PICK = 242;
    private Context mContext;
    private File mPhotoFile = null;
    private ValueCallback<Uri> mUploadMsg;
    private ValueCallback<Uri[]> mUploadMsgs;
    private HtmlWebChromeClient mWebChromeClient;

    public HTMLFileUploader(Context context, HtmlWebChromeClient htmlWebChromeClient) {
        this.mContext = context;
        this.mWebChromeClient = htmlWebChromeClient;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    private static int calAcceptType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        ?? contains = str.contains(TYPE_IMAGE_ACCEPT);
        int i2 = contains;
        if (str.contains(TYPE_VIDEO_ACCEPT)) {
            i2 = contains + 3;
        }
        int i3 = i2;
        if (str.contains(TYPE_AUTIO_ACCEPT)) {
            i3 = i2 + 5;
        }
        if (i3 % 2 == 0 || i3 > 5) {
            return 0;
        }
        return i3;
    }

    public static boolean getiIsCaptureEnabled(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int calAcceptType = calAcceptType(str);
            if (calAcceptType == 1 && str2.equals(TYPE_IMAGE_CAPTURE)) {
                return true;
            }
            if (calAcceptType == 3 && str2.equals(TYPE_VIDEO_CAPTURE)) {
                return true;
            }
            if (calAcceptType == 5 && str2.equals(TYPE_AUTIO_CAPTURE)) {
                return true;
            }
        }
        return false;
    }

    static boolean isWebViewCode(int i2) {
        return i2 >= 241 && i2 <= 244;
    }

    public void launchCamera() {
        try {
            try {
                launchCamera(CAMERA_PACKAGE_NAME);
            } catch (Exception unused) {
                launchCamera(CAMERA_PACKAGE_NAME1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (r3 != null) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r3, int r4, android.content.Intent r5) {
        /*
            r2 = this;
            r0 = 0
            r1 = -1
            if (r4 != r1) goto L50
            switch(r3) {
                case 241: goto L48;
                case 242: goto L1d;
                case 243: goto L48;
                case 244: goto L8;
                default: goto L7;
            }
        L7:
            goto L50
        L8:
            android.os.Bundle r3 = r5.getExtras()
            if (r3 == 0) goto L50
            android.os.Bundle r3 = r5.getExtras()
            java.lang.String r4 = "MESSAGE_CHOOSED_FILE_URI"
            android.os.Parcelable r3 = r3.getParcelable(r4)
            android.net.Uri r3 = (android.net.Uri) r3
            if (r3 == 0) goto L50
            goto L51
        L1d:
            java.io.File r3 = r2.mPhotoFile
            if (r3 == 0) goto L50
            boolean r3 = r3.exists()
            if (r3 == 0) goto L50
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r3.<init>(r4)
            com.vivo.ic.webview.HtmlWebChromeClient r4 = r2.mWebChromeClient
            java.io.File r5 = r2.mPhotoFile
            android.net.Uri r4 = r4.generateFileUri(r5)
            r3.setData(r4)
            android.content.Context r5 = r2.mContext
            if (r5 == 0) goto L46
            boolean r1 = r5 instanceof android.app.Activity
            if (r1 == 0) goto L46
            android.app.Activity r5 = (android.app.Activity) r5
            r5.sendBroadcast(r3)
        L46:
            r3 = r4
            goto L51
        L48:
            if (r5 != 0) goto L4b
            goto L50
        L4b:
            android.net.Uri r3 = r5.getData()
            goto L51
        L50:
            r3 = r0
        L51:
            android.webkit.ValueCallback<android.net.Uri> r4 = r2.mUploadMsg
            java.lang.String r5 = ""
            if (r4 == 0) goto L63
            if (r3 != 0) goto L5d
            android.net.Uri r3 = android.net.Uri.parse(r5)
        L5d:
            r4.onReceiveValue(r3)
            r2.mUploadMsg = r0
            goto L76
        L63:
            android.webkit.ValueCallback<android.net.Uri[]> r4 = r2.mUploadMsgs
            if (r4 == 0) goto L76
            r0 = 1
            android.net.Uri[] r0 = new android.net.Uri[r0]
            r1 = 0
            if (r3 != 0) goto L71
            android.net.Uri r3 = android.net.Uri.parse(r5)
        L71:
            r0[r1] = r3
            r4.onReceiveValue(r0)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.webview.HTMLFileUploader.onActivityResult(int, int, android.content.Intent):void");
    }

    public void setUploadMsgs(ValueCallback<Uri[]> valueCallback) {
        this.mUploadMsgs = valueCallback;
    }

    public void startActivity(ValueCallback<Uri> valueCallback, String[] strArr, boolean z) {
        Intent intent;
        this.mUploadMsg = valueCallback;
        int i2 = 0;
        if (strArr != null && strArr.length == 1) {
            i2 = calAcceptType(strArr[0]);
        }
        int i3 = 243;
        if (i2 != 1) {
            if (i2 == 3) {
                intent = new Intent("android.intent.action.PICK");
                intent.setType(TYPE_VIDEO_FILTER);
            } else if (i2 != 5) {
                intent = new Intent(FILE_PACKAGE_NAME);
                intent.setFlags(524288);
                i3 = 244;
            } else if (z) {
                intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
            } else {
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType(TYPE_AUTIO_FILTER);
                intent.addCategory("android.intent.category.OPENABLE");
            }
        } else if (z) {
            if (this.mWebChromeClient.checkCameraPermission()) {
                return;
            }
            launchCamera();
            return;
        } else {
            intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            i3 = 241;
        }
        Log.i(TAG, "startActivity acceptType:" + strArr);
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).startActivityForResult(intent, i3);
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e(TAG, "startActivity err", e2);
            }
        }
    }

    private void launchCamera(String str) {
        Activity activity;
        if (this.mContext != null) {
            Intent intent = new Intent();
            if (this.mContext.getPackageManager().getLaunchIntentForPackage(str) != null) {
                intent.setPackage(str);
            }
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            File createCamerPhoto = this.mWebChromeClient.createCamerPhoto();
            this.mPhotoFile = createCamerPhoto;
            intent.putExtra("output", this.mWebChromeClient.generateFileUri(createCamerPhoto));
            Context context = this.mContext;
            if (!(context instanceof Activity) || (activity = (Activity) context) == null) {
                return;
            }
            activity.startActivityForResult(intent, WEBVIEW_TAKE_PICK);
        }
    }
}
