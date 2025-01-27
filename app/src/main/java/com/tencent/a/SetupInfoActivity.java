package com.tencent.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gason.C0107;
import com.google.gason.C0108;
import com.google.gason.Gson;
import com.google.gason.GsonBuilder;
import com.google.gason.internal.C0104;
import com.google.gason.reflect.C0105;
import com.google.gason.stream.C0106;
import com.martian.ttbook.sdk.client.SdkConfiguration;
import com.tencent.a.model.C0519;
import com.tencent.a.model.ConfigBean;
import com.tencent.a.model.LocalInfo;
import com.tencent.a.utils.AssetsViewHelper;
import com.tencent.a.utils.C0520;
import com.tencent.a.utils.HttpUtils;
import com.tencent.as.C0523;
import com.tencent.as.javask;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes7.dex */
public class SetupInfoActivity extends Activity {
    public static boolean resumeDialogStarted;

    /* renamed from: short */
    private static final short[] f109short;
    private CheckBox checkBoxAgreement;
    private View lastView;
    private TextView mBtnTaskEnter;
    private TextView mBtnTaskOpenUrl;
    private TextView mBtnTemplateTwoButtonFour;
    private TextView mBtnTemplateTwoButtonOne;
    private TextView mBtnTemplateTwoButtonThree;
    private TextView mBtnTemplateTwoButtonTwo;
    private ConfigBean.DataInfo mConfig;
    private View mContactAuthor;
    private View mContainerContactAuthor;
    private View mContainerJoinGroup;
    private View mContainerShare;
    private EditText mEdTaskAnswer;
    private ImageView mImgAd;
    private ImageView mIvTaskImage;
    private ImageView mIvTaskImageOne;
    private ImageView mIvTaskImageThree;
    private ImageView mIvTaskImageTwo;
    private ImageView mIvTemplateTwoAdImage;
    private View mJoinGroup;
    private String mRequestUrl;
    private View mShare;
    private String mSubBundle;
    private TextView mTextOne;
    private TextView mTextTwo;
    private TextView mTvRollText;
    private TextView mTvShareCount;
    private TextView mTvTaskName;
    private TextView mTvTaskTip;
    private TextView mTvTaskTipOne;
    private TextView mTvTaskTipThree;
    private TextView mTvTaskTipTwo;
    private TextView mTvTemplateTwoNotice;
    private int openCount;
    private String pack;
    private LinearLayout rootContainer;
    private View rootView;
    private long startTime;
    private AlertDialog taskDialog;
    private final String ACTION_APP_CONTACT_AUTHOR = C0106.m46(f109short, 1753667 ^ C0008.m27((Object) "ۦۧۤ"), 56499 ^ C0008.m27((Object) "ۥۦ"), C0008.m27((Object) "ۢۨ۟") ^ 1751242);
    private final String ACTION_APP_CONTACT_GROUP = C0107.m50(f109short, 1752474 ^ C0008.m27((Object) "ۥ۟ۢ"), 1747671 ^ C0008.m27((Object) "۠۟ۥ"), C0008.m27((Object) "ۦۡ") ^ 54666);
    private final String ACTION_APP_OPEN = C0007.m23(f109short, 56478 ^ C0008.m27((Object) "ۦۣ"), 56333 ^ C0008.m27((Object) "۠ۥ"), C0008.m27((Object) "ۣۦۡ") ^ 1752875);
    private final String ACTION_APP_SHARE = C0006.m19(f109short, 1750698 ^ C0008.m27((Object) "ۣۣۡ"), 1750804 ^ C0008.m27((Object) "ۣۨۢ"), C0008.m27((Object) "ۧۡۡ") ^ 1753703);
    private boolean ACTIVE = true;
    private final String AUTH_FAILED = C0521.m71(f109short, 1749651 ^ C0008.m27((Object) "ۢۢۧ"), 1747922 ^ C0008.m27((Object) "۠ۨۢ"), C0008.m27((Object) "ۡۢۢ") ^ 1746394);
    private final String NO_QQ = C0003.m11(f109short, 1751574 ^ C0008.m27((Object) "ۤۢۨ"), 1753682 ^ C0008.m27((Object) "ۦۨ۠"), C0008.m27((Object) "ۨۥۧ") ^ 1755378);
    private int mNeedShareCount = 0;
    private int mShareCount = 0;
    private boolean isShowed = false;
    private int adIndex = 0;
    private boolean taskCanReturn = false;

    /* renamed from: com.tencent.a.SetupInfoActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Integer num = new Integer(8978511);
            SetupInfoActivity.this.taskCanReturn = true;
            SetupInfoActivity.this.taskDialog.getWindow().getDecorView().setVisibility(((Integer) new Object[]{num}[0]).intValue() ^ 8978503);
            if (SetupInfoActivity.this.mConfig.getIs_to_url() != 1) {
                SetupInfoActivity.this.gotoTask();
            } else {
                SetupInfoActivity setupInfoActivity = SetupInfoActivity.this;
                setupInfoActivity.openUrl(setupInfoActivity.mConfig.getTo_url());
            }
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$10 */
    class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SetupInfoActivity.this.showAgreementDialog();
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$11 */
    class AnonymousClass11 implements HttpUtils.ImageCallback {
        AnonymousClass11() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void failed() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void success(Bitmap bitmap) {
            SetupInfoActivity.this.rootView.setBackground(new BitmapDrawable(bitmap));
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$12 */
    class AnonymousClass12 implements HttpUtils.ImageCallback {

        /* renamed from: com.tencent.a.SetupInfoActivity$12$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ Bitmap val$bitmap;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                SetupInfoActivity.this.mIvTaskImage.setImageBitmap(bitmap);
            }
        }

        AnonymousClass12() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void failed() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void success(Bitmap bitmap) {
            if (bitmap != null) {
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.12.1
                    final /* synthetic */ Bitmap val$bitmap;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.mIvTaskImage.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$13 */
    class AnonymousClass13 implements HttpUtils.ImageCallback {

        /* renamed from: com.tencent.a.SetupInfoActivity$13$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SetupInfoActivity.this.mIvTaskImageOne.setVisibility(((Integer) new Object[]{new Integer(2904298)}[0]).intValue() ^ 2904290);
            }
        }

        /* renamed from: com.tencent.a.SetupInfoActivity$13$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ Bitmap val$bitmap;

            AnonymousClass2(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                SetupInfoActivity.this.mIvTaskImageOne.setImageBitmap(bitmap);
            }
        }

        AnonymousClass13() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void failed() {
            SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.13.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageOne.setVisibility(((Integer) new Object[]{new Integer(2904298)}[0]).intValue() ^ 2904290);
                }
            });
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void success(Bitmap bitmap) {
            if (bitmap != null) {
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.13.2
                    final /* synthetic */ Bitmap val$bitmap;

                    AnonymousClass2(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.mIvTaskImageOne.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$14 */
    class AnonymousClass14 implements HttpUtils.ImageCallback {

        /* renamed from: com.tencent.a.SetupInfoActivity$14$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SetupInfoActivity.this.mIvTaskImageTwo.setVisibility(((Integer) new Object[]{new Integer(3741613)}[0]).intValue() ^ 3741605);
            }
        }

        /* renamed from: com.tencent.a.SetupInfoActivity$14$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ Bitmap val$bitmap;

            AnonymousClass2(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                SetupInfoActivity.this.mIvTaskImageTwo.setImageBitmap(bitmap);
            }
        }

        AnonymousClass14() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void failed() {
            SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.14.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageTwo.setVisibility(((Integer) new Object[]{new Integer(3741613)}[0]).intValue() ^ 3741605);
                }
            });
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void success(Bitmap bitmap) {
            if (bitmap != null) {
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.14.2
                    final /* synthetic */ Bitmap val$bitmap;

                    AnonymousClass2(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.mIvTaskImageTwo.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$15 */
    class AnonymousClass15 implements HttpUtils.ImageCallback {

        /* renamed from: com.tencent.a.SetupInfoActivity$15$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SetupInfoActivity.this.mIvTaskImageThree.setVisibility(((Integer) new Object[]{new Integer(8398575)}[0]).intValue() ^ 8398567);
            }
        }

        /* renamed from: com.tencent.a.SetupInfoActivity$15$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ Bitmap val$bitmap;

            AnonymousClass2(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                SetupInfoActivity.this.mIvTaskImageThree.setImageBitmap(bitmap);
            }
        }

        AnonymousClass15() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void failed() {
            SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.15.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageThree.setVisibility(((Integer) new Object[]{new Integer(8398575)}[0]).intValue() ^ 8398567);
                }
            });
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void success(Bitmap bitmap) {
            if (bitmap != null) {
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.15.2
                    final /* synthetic */ Bitmap val$bitmap;

                    AnonymousClass2(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.mIvTaskImageThree.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$16 */
    class AnonymousClass16 implements Runnable {

        /* renamed from: short */
        private static final short[] f110short;
        final /* synthetic */ NetworkState val$networkState;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(6629129)}[0]).intValue() ^ 6629148];
            sArr[0] = 978;
            sArr[1] = 974;
            sArr[2] = 974;
            sArr[3] = 970;
            sArr[4] = 969;
            sArr[5] = 896;
            sArr[6] = 917;
            sArr[7] = 917;
            sArr[8] = 973;
            sArr[9] = 973;
            sArr[10] = 973;
            sArr[11] = 916;
            sArr[12] = 984;
            sArr[13] = 987;
            sArr[14] = 979;
            sArr[15] = 990;
            sArr[16] = 975;
            sArr[17] = 916;
            sArr[18] = 985;
            sArr[19] = 981;
            sArr[20] = 983;
            f110short = sArr;
        }

        AnonymousClass16(NetworkState networkState) {
            networkState = networkState;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (((HttpURLConnection) new URL(C0000.m1(f110short, 1751500 ^ C0008.m27((Object) "ۤ۟ۧ"), 1748628 ^ C0008.m27((Object) "ۡ۟۟"), C0008.m27((Object) "ۢ۠ۧ") ^ 1749459)).openConnection()).getResponseCode() == 200) {
                    networkState.success();
                } else {
                    networkState.error();
                }
            } catch (MalformedURLException e2) {
                networkState.error();
                e2.printStackTrace();
            } catch (IOException e3) {
                networkState.error();
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$17 */
    class AnonymousClass17 implements NetworkState {

        /* renamed from: short */
        private static final short[] f111short;

        /* renamed from: com.tencent.a.SetupInfoActivity$17$1 */
        class AnonymousClass1 implements HttpUtils.Callback {

            /* renamed from: com.tencent.a.SetupInfoActivity$17$1$1 */
            class RunnableC05151 implements Runnable {

                /* renamed from: short */
                private static final short[] f112short;

                static {
                    short[] sArr = new short[((Integer) new Object[]{new Integer(525063)}[0]).intValue() ^ 525106];
                    sArr[0] = 2595;
                    sArr[1] = 2613;
                    sArr[2] = 2596;
                    sArr[3] = 2597;
                    sArr[4] = 2592;
                    sArr[5] = 2575;
                    sArr[6] = 2595;
                    sArr[7] = 2612;
                    sArr[8] = 2619;
                    sArr[9] = 2575;
                    sArr[10] = 2595;
                    sArr[11] = 2616;
                    sArr[12] = 2609;
                    sArr[13] = 2594;
                    sArr[14] = 2613;
                    sArr[15] = 2575;
                    sArr[16] = 2617;
                    sArr[17] = 2622;
                    sArr[18] = 2614;
                    sArr[19] = 2623;
                    sArr[20] = 2658;
                    sArr[21] = 2686;
                    sArr[22] = 2600;
                    sArr[23] = 2621;
                    sArr[24] = 2620;
                    sArr[25] = 1198;
                    sArr[26] = 1208;
                    sArr[27] = 1193;
                    sArr[28] = 1192;
                    sArr[29] = 1197;
                    sArr[30] = 1154;
                    sArr[31] = 1198;
                    sArr[32] = 1209;
                    sArr[33] = 1206;
                    sArr[34] = 1154;
                    sArr[35] = 1198;
                    sArr[36] = 1205;
                    sArr[37] = 1212;
                    sArr[38] = 1199;
                    sArr[39] = 1208;
                    sArr[40] = 1154;
                    sArr[41] = 1204;
                    sArr[42] = 1203;
                    sArr[43] = 1211;
                    sArr[44] = 1202;
                    sArr[45] = 1154;
                    sArr[46] = 1193;
                    sArr[47] = 1194;
                    sArr[48] = 1202;
                    sArr[49] = 1267;
                    sArr[50] = 1189;
                    sArr[51] = 1200;
                    sArr[52] = 1201;
                    f112short = sArr;
                }

                RunnableC05151() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    switch (SetupInfoActivity.this.mConfig.getTemplate()) {
                        case 2:
                            SetupInfoActivity.this.rootView = AssetsViewHelper.width(SetupInfoActivity.this).getAssetsLayout(C0522.m72(f112short, 1749660 ^ C0008.m27((Object) "ۢۡۤ"), 1754454 ^ C0008.m27((Object) "ۧۡۤ"), C0008.m27((Object) "۟ۦ۠") ^ 1745668));
                            SetupInfoActivity.this.lastView = SetupInfoActivity.this.rootView;
                            SetupInfoActivity.this.templateTwoInit();
                            break;
                        default:
                            SetupInfoActivity.this.rootView = AssetsViewHelper.width(SetupInfoActivity.this).getAssetsLayout(C0104.m40(f112short, 1749725 ^ C0008.m27((Object) "ۢۤ۟"), 1749764 ^ C0008.m27((Object) "ۢۦۡ"), C0008.m27((Object) "ۡۡۨ") ^ 1746072));
                            SetupInfoActivity.this.lastView = SetupInfoActivity.this.rootView;
                            SetupInfoActivity.this.templateOneInit();
                            break;
                    }
                    SetupInfoActivity.this.setContentView(SetupInfoActivity.this.rootView);
                    SetupInfoActivity.this.initData();
                    SetupInfoActivity.this.showAlertDialog(SetupInfoActivity.this);
                    SetupInfoActivity.this.rootView.setVisibility(0);
                    SetupInfoActivity.this.showBindingDialog();
                }
            }

            AnonymousClass1() {
            }

            @Override // com.tencent.a.utils.HttpUtils.Callback
            public void failed() {
                SetupInfoActivity.this.gotoNext();
            }

            @Override // com.tencent.a.utils.HttpUtils.Callback
            public void success(String str) {
                ConfigBean configBean = (ConfigBean) new Gson().fromJson(str, ConfigBean.class);
                if (configBean == null) {
                    SetupInfoActivity.this.gotoNext();
                    return;
                }
                if (configBean.getCode() != 1) {
                    SetupInfoActivity.this.showErrorDialog(configBean.getMsg());
                    return;
                }
                if (configBean.getData() == null) {
                    SetupInfoActivity.this.gotoNext();
                    return;
                }
                SetupInfoActivity.this.mConfig = configBean.getData().getDataInfo();
                if (SetupInfoActivity.this.mConfig == null || SetupInfoActivity.this.mConfig.getOpen() == 0) {
                    SetupInfoActivity.this.gotoNext();
                    return;
                }
                if (SetupInfoActivity.this.mConfig.getPage_show() == 2) {
                    SetupInfoActivity.this.gotoNext();
                    SetupInfoActivity.this.triggerShowAlter();
                    return;
                }
                int display_share_count = SetupInfoActivity.this.mConfig.getDisplay_share_count();
                if (display_share_count == 0) {
                    display_share_count = 1;
                }
                if (SetupInfoActivity.this.openCount < display_share_count) {
                    SetupInfoActivity.this.gotoNext();
                } else {
                    SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.17.1.1

                        /* renamed from: short */
                        private static final short[] f112short;

                        static {
                            short[] sArr = new short[((Integer) new Object[]{new Integer(525063)}[0]).intValue() ^ 525106];
                            sArr[0] = 2595;
                            sArr[1] = 2613;
                            sArr[2] = 2596;
                            sArr[3] = 2597;
                            sArr[4] = 2592;
                            sArr[5] = 2575;
                            sArr[6] = 2595;
                            sArr[7] = 2612;
                            sArr[8] = 2619;
                            sArr[9] = 2575;
                            sArr[10] = 2595;
                            sArr[11] = 2616;
                            sArr[12] = 2609;
                            sArr[13] = 2594;
                            sArr[14] = 2613;
                            sArr[15] = 2575;
                            sArr[16] = 2617;
                            sArr[17] = 2622;
                            sArr[18] = 2614;
                            sArr[19] = 2623;
                            sArr[20] = 2658;
                            sArr[21] = 2686;
                            sArr[22] = 2600;
                            sArr[23] = 2621;
                            sArr[24] = 2620;
                            sArr[25] = 1198;
                            sArr[26] = 1208;
                            sArr[27] = 1193;
                            sArr[28] = 1192;
                            sArr[29] = 1197;
                            sArr[30] = 1154;
                            sArr[31] = 1198;
                            sArr[32] = 1209;
                            sArr[33] = 1206;
                            sArr[34] = 1154;
                            sArr[35] = 1198;
                            sArr[36] = 1205;
                            sArr[37] = 1212;
                            sArr[38] = 1199;
                            sArr[39] = 1208;
                            sArr[40] = 1154;
                            sArr[41] = 1204;
                            sArr[42] = 1203;
                            sArr[43] = 1211;
                            sArr[44] = 1202;
                            sArr[45] = 1154;
                            sArr[46] = 1193;
                            sArr[47] = 1194;
                            sArr[48] = 1202;
                            sArr[49] = 1267;
                            sArr[50] = 1189;
                            sArr[51] = 1200;
                            sArr[52] = 1201;
                            f112short = sArr;
                        }

                        RunnableC05151() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            switch (SetupInfoActivity.this.mConfig.getTemplate()) {
                                case 2:
                                    SetupInfoActivity.this.rootView = AssetsViewHelper.width(SetupInfoActivity.this).getAssetsLayout(C0522.m72(f112short, 1749660 ^ C0008.m27((Object) "ۢۡۤ"), 1754454 ^ C0008.m27((Object) "ۧۡۤ"), C0008.m27((Object) "۟ۦ۠") ^ 1745668));
                                    SetupInfoActivity.this.lastView = SetupInfoActivity.this.rootView;
                                    SetupInfoActivity.this.templateTwoInit();
                                    break;
                                default:
                                    SetupInfoActivity.this.rootView = AssetsViewHelper.width(SetupInfoActivity.this).getAssetsLayout(C0104.m40(f112short, 1749725 ^ C0008.m27((Object) "ۢۤ۟"), 1749764 ^ C0008.m27((Object) "ۢۦۡ"), C0008.m27((Object) "ۡۡۨ") ^ 1746072));
                                    SetupInfoActivity.this.lastView = SetupInfoActivity.this.rootView;
                                    SetupInfoActivity.this.templateOneInit();
                                    break;
                            }
                            SetupInfoActivity.this.setContentView(SetupInfoActivity.this.rootView);
                            SetupInfoActivity.this.initData();
                            SetupInfoActivity.this.showAlertDialog(SetupInfoActivity.this);
                            SetupInfoActivity.this.rootView.setVisibility(0);
                            SetupInfoActivity.this.showBindingDialog();
                        }
                    });
                }
            }
        }

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(5516246)}[0]).intValue() ^ 5516238];
            sArr[0] = 1733;
            sArr[1] = 1748;
            sArr[2] = 1731;
            sArr[3] = 1752;
            sArr[4] = 1746;
            sArr[5] = 1754;
            sArr[6] = 1747;
            sArr[7] = 2619;
            sArr[8] = 2604;
            sArr[9] = 2615;
            sArr[10] = 2621;
            sArr[11] = 2613;
            sArr[12] = 2620;
            sArr[13] = 2634;
            sArr[14] = 2575;
            sArr[15] = 2566;
            sArr[16] = 2634;
            sArr[17] = 2564;
            sArr[18] = 2581;
            sArr[19] = 2581;
            sArr[20] = 2635;
            sArr[21] = 2581;
            sArr[22] = 2573;
            sArr[23] = 2581;
            f111short = sArr;
        }

        AnonymousClass17() {
        }

        @Override // com.tencent.a.SetupInfoActivity.NetworkState
        public void error() {
            SetupInfoActivity.this.showNetworkErrorDialog();
        }

        @Override // com.tencent.a.SetupInfoActivity.NetworkState
        public void success() {
            HashMap hashMap = new HashMap();
            hashMap.put(C0008.m24(f111short, 1747655 ^ C0008.m27((Object) "۠۟ۦ"), 1749604 ^ C0008.m27((Object) "ۢ۠ۡ"), C0008.m27((Object) "ۥۤ۠") ^ 1751191), SetupInfoActivity.this.mSubBundle);
            hashMap.put(C0003.m11(f111short, 1746688 ^ C0008.m27((Object) "۟۟ۧ"), 1748857 ^ C0008.m27((Object) "ۡۧۥ"), C0008.m27((Object) "ۢۤۡ") ^ 1751174), SetupInfoActivity.this.pack);
            HttpUtils.submitPostData(SetupInfoActivity.this.mRequestUrl + C0522.m72(f111short, 1755330 ^ C0008.m27((Object) "ۨ۟ۦ"), 1751564 ^ C0008.m27((Object) "ۤۡۤ"), C0008.m27((Object) "ۢۥۡ") ^ 1751195), hashMap, new HttpUtils.Callback() { // from class: com.tencent.a.SetupInfoActivity.17.1

                /* renamed from: com.tencent.a.SetupInfoActivity$17$1$1 */
                class RunnableC05151 implements Runnable {

                    /* renamed from: short */
                    private static final short[] f112short;

                    static {
                        short[] sArr = new short[((Integer) new Object[]{new Integer(525063)}[0]).intValue() ^ 525106];
                        sArr[0] = 2595;
                        sArr[1] = 2613;
                        sArr[2] = 2596;
                        sArr[3] = 2597;
                        sArr[4] = 2592;
                        sArr[5] = 2575;
                        sArr[6] = 2595;
                        sArr[7] = 2612;
                        sArr[8] = 2619;
                        sArr[9] = 2575;
                        sArr[10] = 2595;
                        sArr[11] = 2616;
                        sArr[12] = 2609;
                        sArr[13] = 2594;
                        sArr[14] = 2613;
                        sArr[15] = 2575;
                        sArr[16] = 2617;
                        sArr[17] = 2622;
                        sArr[18] = 2614;
                        sArr[19] = 2623;
                        sArr[20] = 2658;
                        sArr[21] = 2686;
                        sArr[22] = 2600;
                        sArr[23] = 2621;
                        sArr[24] = 2620;
                        sArr[25] = 1198;
                        sArr[26] = 1208;
                        sArr[27] = 1193;
                        sArr[28] = 1192;
                        sArr[29] = 1197;
                        sArr[30] = 1154;
                        sArr[31] = 1198;
                        sArr[32] = 1209;
                        sArr[33] = 1206;
                        sArr[34] = 1154;
                        sArr[35] = 1198;
                        sArr[36] = 1205;
                        sArr[37] = 1212;
                        sArr[38] = 1199;
                        sArr[39] = 1208;
                        sArr[40] = 1154;
                        sArr[41] = 1204;
                        sArr[42] = 1203;
                        sArr[43] = 1211;
                        sArr[44] = 1202;
                        sArr[45] = 1154;
                        sArr[46] = 1193;
                        sArr[47] = 1194;
                        sArr[48] = 1202;
                        sArr[49] = 1267;
                        sArr[50] = 1189;
                        sArr[51] = 1200;
                        sArr[52] = 1201;
                        f112short = sArr;
                    }

                    RunnableC05151() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        switch (SetupInfoActivity.this.mConfig.getTemplate()) {
                            case 2:
                                SetupInfoActivity.this.rootView = AssetsViewHelper.width(SetupInfoActivity.this).getAssetsLayout(C0522.m72(f112short, 1749660 ^ C0008.m27((Object) "ۢۡۤ"), 1754454 ^ C0008.m27((Object) "ۧۡۤ"), C0008.m27((Object) "۟ۦ۠") ^ 1745668));
                                SetupInfoActivity.this.lastView = SetupInfoActivity.this.rootView;
                                SetupInfoActivity.this.templateTwoInit();
                                break;
                            default:
                                SetupInfoActivity.this.rootView = AssetsViewHelper.width(SetupInfoActivity.this).getAssetsLayout(C0104.m40(f112short, 1749725 ^ C0008.m27((Object) "ۢۤ۟"), 1749764 ^ C0008.m27((Object) "ۢۦۡ"), C0008.m27((Object) "ۡۡۨ") ^ 1746072));
                                SetupInfoActivity.this.lastView = SetupInfoActivity.this.rootView;
                                SetupInfoActivity.this.templateOneInit();
                                break;
                        }
                        SetupInfoActivity.this.setContentView(SetupInfoActivity.this.rootView);
                        SetupInfoActivity.this.initData();
                        SetupInfoActivity.this.showAlertDialog(SetupInfoActivity.this);
                        SetupInfoActivity.this.rootView.setVisibility(0);
                        SetupInfoActivity.this.showBindingDialog();
                    }
                }

                AnonymousClass1() {
                }

                @Override // com.tencent.a.utils.HttpUtils.Callback
                public void failed() {
                    SetupInfoActivity.this.gotoNext();
                }

                @Override // com.tencent.a.utils.HttpUtils.Callback
                public void success(String str) {
                    ConfigBean configBean = (ConfigBean) new Gson().fromJson(str, ConfigBean.class);
                    if (configBean == null) {
                        SetupInfoActivity.this.gotoNext();
                        return;
                    }
                    if (configBean.getCode() != 1) {
                        SetupInfoActivity.this.showErrorDialog(configBean.getMsg());
                        return;
                    }
                    if (configBean.getData() == null) {
                        SetupInfoActivity.this.gotoNext();
                        return;
                    }
                    SetupInfoActivity.this.mConfig = configBean.getData().getDataInfo();
                    if (SetupInfoActivity.this.mConfig == null || SetupInfoActivity.this.mConfig.getOpen() == 0) {
                        SetupInfoActivity.this.gotoNext();
                        return;
                    }
                    if (SetupInfoActivity.this.mConfig.getPage_show() == 2) {
                        SetupInfoActivity.this.gotoNext();
                        SetupInfoActivity.this.triggerShowAlter();
                        return;
                    }
                    int display_share_count = SetupInfoActivity.this.mConfig.getDisplay_share_count();
                    if (display_share_count == 0) {
                        display_share_count = 1;
                    }
                    if (SetupInfoActivity.this.openCount < display_share_count) {
                        SetupInfoActivity.this.gotoNext();
                    } else {
                        SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.17.1.1

                            /* renamed from: short */
                            private static final short[] f112short;

                            static {
                                short[] sArr = new short[((Integer) new Object[]{new Integer(525063)}[0]).intValue() ^ 525106];
                                sArr[0] = 2595;
                                sArr[1] = 2613;
                                sArr[2] = 2596;
                                sArr[3] = 2597;
                                sArr[4] = 2592;
                                sArr[5] = 2575;
                                sArr[6] = 2595;
                                sArr[7] = 2612;
                                sArr[8] = 2619;
                                sArr[9] = 2575;
                                sArr[10] = 2595;
                                sArr[11] = 2616;
                                sArr[12] = 2609;
                                sArr[13] = 2594;
                                sArr[14] = 2613;
                                sArr[15] = 2575;
                                sArr[16] = 2617;
                                sArr[17] = 2622;
                                sArr[18] = 2614;
                                sArr[19] = 2623;
                                sArr[20] = 2658;
                                sArr[21] = 2686;
                                sArr[22] = 2600;
                                sArr[23] = 2621;
                                sArr[24] = 2620;
                                sArr[25] = 1198;
                                sArr[26] = 1208;
                                sArr[27] = 1193;
                                sArr[28] = 1192;
                                sArr[29] = 1197;
                                sArr[30] = 1154;
                                sArr[31] = 1198;
                                sArr[32] = 1209;
                                sArr[33] = 1206;
                                sArr[34] = 1154;
                                sArr[35] = 1198;
                                sArr[36] = 1205;
                                sArr[37] = 1212;
                                sArr[38] = 1199;
                                sArr[39] = 1208;
                                sArr[40] = 1154;
                                sArr[41] = 1204;
                                sArr[42] = 1203;
                                sArr[43] = 1211;
                                sArr[44] = 1202;
                                sArr[45] = 1154;
                                sArr[46] = 1193;
                                sArr[47] = 1194;
                                sArr[48] = 1202;
                                sArr[49] = 1267;
                                sArr[50] = 1189;
                                sArr[51] = 1200;
                                sArr[52] = 1201;
                                f112short = sArr;
                            }

                            RunnableC05151() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                switch (SetupInfoActivity.this.mConfig.getTemplate()) {
                                    case 2:
                                        SetupInfoActivity.this.rootView = AssetsViewHelper.width(SetupInfoActivity.this).getAssetsLayout(C0522.m72(f112short, 1749660 ^ C0008.m27((Object) "ۢۡۤ"), 1754454 ^ C0008.m27((Object) "ۧۡۤ"), C0008.m27((Object) "۟ۦ۠") ^ 1745668));
                                        SetupInfoActivity.this.lastView = SetupInfoActivity.this.rootView;
                                        SetupInfoActivity.this.templateTwoInit();
                                        break;
                                    default:
                                        SetupInfoActivity.this.rootView = AssetsViewHelper.width(SetupInfoActivity.this).getAssetsLayout(C0104.m40(f112short, 1749725 ^ C0008.m27((Object) "ۢۤ۟"), 1749764 ^ C0008.m27((Object) "ۢۦۡ"), C0008.m27((Object) "ۡۡۨ") ^ 1746072));
                                        SetupInfoActivity.this.lastView = SetupInfoActivity.this.rootView;
                                        SetupInfoActivity.this.templateOneInit();
                                        break;
                                }
                                SetupInfoActivity.this.setContentView(SetupInfoActivity.this.rootView);
                                SetupInfoActivity.this.initData();
                                SetupInfoActivity.this.showAlertDialog(SetupInfoActivity.this);
                                SetupInfoActivity.this.rootView.setVisibility(0);
                                SetupInfoActivity.this.showBindingDialog();
                            }
                        });
                    }
                }
            });
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$18 */
    class AnonymousClass18 implements Runnable {
        final /* synthetic */ Bitmap val$bitmap;
        final /* synthetic */ ImageView val$imageView;

        /* renamed from: com.tencent.a.SetupInfoActivity$18$1 */
        class AnonymousClass1 implements View.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetupInfoActivity.this.openUrl(SetupInfoActivity.this.mConfig.getAdurl());
            }
        }

        AnonymousClass18(ImageView imageView, Bitmap bitmap) {
            imageView = imageView;
            bitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            imageView.setVisibility(0);
            imageView.setImageBitmap(bitmap);
            if (TextUtils.isEmpty(SetupInfoActivity.this.mConfig.getAdurl())) {
                return;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.18.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SetupInfoActivity.this.openUrl(SetupInfoActivity.this.mConfig.getAdurl());
                }
            });
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$19 */
    class AnonymousClass19 implements Runnable {

        /* renamed from: short */
        private static final short[] f113short;
        final /* synthetic */ String val$str;

        /* renamed from: com.tencent.a.SetupInfoActivity$19$1 */
        class AnonymousClass1 implements DialogInterface.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.this.finish();
            }
        }

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(6725651)}[0]).intValue() ^ 6725653];
            sArr[0] = 26949;
            sArr[1] = -24892;
            sArr[2] = 25788;
            sArr[3] = 32342;
            sArr[4] = 32538;
            sArr[5] = 23790;
            f113short = sArr;
        }

        AnonymousClass19(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object[] objArr = {new Integer(-6693015), new Integer(-8870767)};
            SetupInfoActivity.this.rootView.setVisibility(0);
            AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0104.m40(f113short, 1753695 ^ C0008.m27((Object) "ۦۨۡ"), 1754442 ^ C0008.m27((Object) "ۧۡۨ"), C0008.m27((Object) "ۡۦۡ") ^ 1746992)).setMessage(str).setPositiveButton(C0005.m17(f113short, 1746904 ^ C0008.m27((Object) "۟ۦۣ"), C0008.m27((Object) "ۨ") ^ 1770, C0008.m27((Object) "ۣۦ۟") ^ 1749416), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.19.1
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SetupInfoActivity.this.finish();
                }
            }).create();
            create.setCancelable(false);
            create.show();
            create.getButton(((Integer) objArr[0]).intValue() ^ 6693014).setTextColor(((Integer) objArr[1]).intValue() ^ 7906449);
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$2 */
    class AnonymousClass2 implements HttpUtils.Callback {
        AnonymousClass2() {
        }

        @Override // com.tencent.a.utils.HttpUtils.Callback
        public void failed() {
        }

        @Override // com.tencent.a.utils.HttpUtils.Callback
        public void success(String str) {
            SetupInfoActivity.resumeDialogStarted = true;
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$20 */
    class AnonymousClass20 implements Runnable {

        /* renamed from: short */
        private static final short[] f114short;

        /* renamed from: com.tencent.a.SetupInfoActivity$20$1 */
        class AnonymousClass1 implements DialogInterface.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.this.finish();
            }
        }

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(3020097)}[0]).intValue() ^ 3020112];
            sArr[0] = 27520;
            sArr[1] = 29034;
            sArr[2] = 32193;
            sArr[3] = 31820;
            sArr[4] = 19613;
            sArr[5] = 31817;
            sArr[6] = 20491;
            sArr[7] = -612;
            sArr[8] = -30361;
            sArr[9] = 27216;
            sArr[10] = 25973;
            sArr[11] = 32193;
            sArr[12] = 31820;
            sArr[13] = -30418;
            sArr[14] = 32254;
            sArr[15] = -25670;
            sArr[16] = 23104;
            f114short = sArr;
        }

        AnonymousClass20() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object[] objArr = {new Integer(-16250890), new Integer(-7313130)};
            AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0007.m23(f114short, 1753697 ^ C0008.m27((Object) "ۦۣۨ"), 1746783 ^ C0008.m27((Object) "۟ۢ۠"), C0008.m27((Object) "ۨۦ۟") ^ 1753585)).setMessage(C0000.m1(f114short, 1748707 ^ C0008.m27((Object) "ۡۢۢ"), 56566 ^ C0008.m27((Object) "ۣۨ"), C0008.m27((Object) "ۨۥۢ") ^ 1755925)).setPositiveButton(C0521.m71(f114short, 1746896 ^ C0008.m27((Object) "۟ۦۦ"), 1753642 ^ C0008.m27((Object) "ۦۦۨ"), C0008.m27((Object) "ۤۥۦ") ^ 1749311), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.20.1
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SetupInfoActivity.this.finish();
                }
            }).create();
            create.setCancelable(false);
            create.show();
            create.getButton(((Integer) objArr[1]).intValue() ^ 7313129).setTextColor(((Integer) objArr[0]).intValue() ^ 526326);
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$21 */
    class AnonymousClass21 implements Runnable {

        /* renamed from: short */
        private static final short[] f115short;

        /* renamed from: com.tencent.a.SetupInfoActivity$21$1 */
        class AnonymousClass1 implements DialogInterface.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.this.finish();
            }
        }

        /* renamed from: com.tencent.a.SetupInfoActivity$21$2 */
        class AnonymousClass2 implements DialogInterface.OnClickListener {
            AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.this.checkBoxAgreement.setChecked(true);
            }
        }

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(5084460)}[0]).intValue() ^ 5084591];
            sArr[0] = 22785;
            sArr[1] = -31377;
            sArr[2] = 20668;
            sArr[3] = 28226;
            sArr[4] = 27816;
            sArr[5] = -31509;
            sArr[6] = 17778;
            sArr[7] = 27873;
            sArr[8] = -30098;
            sArr[9] = 17674;
            sArr[10] = 29909;
            sArr[11] = 30040;
            sArr[12] = -31040;
            sArr[13] = 25876;
            sArr[14] = 28338;
            sArr[15] = -25278;
            sArr[16] = -2936;
            sArr[17] = 17729;
            sArr[18] = 32428;
            sArr[19] = 17674;
            sArr[20] = 26319;
            sArr[21] = -32687;
            sArr[22] = 17674;
            sArr[23] = 17696;
            sArr[24] = 26309;
            sArr[25] = 20706;
            sArr[26] = 17892;
            sArr[27] = -2936;
            sArr[28] = 22915;
            sArr[29] = 22907;
            sArr[30] = 32428;
            sArr[31] = 17674;
            sArr[32] = -25382;
            sArr[33] = 26449;
            sArr[34] = 17761;
            sArr[35] = 22606;
            sArr[36] = 24258;
            sArr[37] = 17822;
            sArr[38] = 32428;
            sArr[39] = -25712;
            sArr[40] = -2939;
            sArr[41] = 24482;
            sArr[42] = 22941;
            sArr[43] = 17659;
            sArr[44] = 32428;
            sArr[45] = 27816;
            sArr[46] = -31509;
            sArr[47] = 17778;
            sArr[48] = -25692;
            sArr[49] = 27028;
            sArr[50] = 32000;
            sArr[51] = 17796;
            sArr[52] = 22915;
            sArr[53] = 24458;
            sArr[54] = 27672;
            sArr[55] = 32002;
            sArr[56] = 32437;
            sArr[57] = 32428;
            sArr[58] = 27059;
            sArr[59] = -30098;
            sArr[60] = -31800;
            sArr[61] = 27131;
            sArr[62] = 26945;
            sArr[63] = -2936;
            sArr[64] = 17802;
            sArr[65] = 27816;
            sArr[66] = 23910;
            sArr[67] = -25189;
            sArr[68] = 28260;
            sArr[69] = 23287;
            sArr[70] = -2936;
            sArr[71] = 20998;
            sArr[72] = -31649;
            sArr[73] = 23265;
            sArr[74] = -31509;
            sArr[75] = 17778;
            sArr[76] = 22941;
            sArr[77] = -31764;
            sArr[78] = 29374;
            sArr[79] = 24456;
            sArr[80] = 27275;
            sArr[81] = 24800;
            sArr[82] = 22731;
            sArr[83] = -32726;
            sArr[84] = -2936;
            sArr[85] = 20998;
            sArr[86] = 17801;
            sArr[87] = 24456;
            sArr[88] = 27275;
            sArr[89] = -32653;
            sArr[90] = -25724;
            sArr[91] = 23166;
            sArr[92] = 22002;
            sArr[93] = 22780;
            sArr[94] = -31495;
            sArr[95] = 24800;
            sArr[96] = -31509;
            sArr[97] = 17778;
            sArr[98] = -2936;
            sArr[99] = 20998;
            sArr[100] = 24800;
            sArr[101] = -31509;
            sArr[102] = 17778;
            sArr[103] = 27789;
            sArr[104] = 17457;
            sArr[105] = 31019;
            sArr[106] = 22964;
            sArr[107] = 17636;
            sArr[108] = 32000;
            sArr[109] = 27847;
            sArr[110] = 32078;
            sArr[111] = -2936;
            sArr[112] = -32653;
            sArr[113] = 29007;
            sArr[114] = 22775;
            sArr[115] = -29744;
            sArr[116] = 30591;
            sArr[117] = 27029;
            sArr[118] = 17768;
            sArr[119] = 22948;
            sArr[120] = -25120;
            sArr[121] = -2936;
            sArr[122] = 28392;
            sArr[123] = -32653;
            sArr[124] = -30847;
            sArr[125] = -32153;
            sArr[126] = -2939;
            sArr[127] = 22081;
            sArr[128] = 25410;
            sArr[129] = 24985;
            sArr[130] = 32150;
            f115short = sArr;
        }

        AnonymousClass21() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0523.m77(f115short, 1753572 ^ C0008.m27((Object) "ۦۤۢ"), 1748863 ^ C0008.m27((Object) "ۡۧۡ"), C0008.m27((Object) "ۣۥ") ^ 54318)).setMessage(C0104.m40(f115short, 56326 ^ C0008.m27((Object) "۠ۢ"), 1755318 ^ C0008.m27((Object) "ۨ۟ۤ"), C0008.m27((Object) "ۢۨۦ") ^ 1751268)).setPositiveButton(C0004.m13(f115short, 1755577 ^ C0008.m27((Object) "ۨۧۥ"), 1752581 ^ C0008.m27((Object) "ۥۣۥ"), C0008.m27((Object) "ۣ۟ۤ") ^ 1750085), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.21.2
                AnonymousClass2() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SetupInfoActivity.this.checkBoxAgreement.setChecked(true);
                }
            }).setNegativeButton(C0003.m11(f115short, 1755527 ^ C0008.m27((Object) "ۨۡ۟"), 1751524 ^ C0008.m27((Object) "ۤ۠ۢ"), C0008.m27((Object) "ۣۡۥ") ^ 1750284), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.21.1
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SetupInfoActivity.this.finish();
                }
            }).create();
            create.setCancelable(false);
            create.show();
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$22 */
    class AnonymousClass22 implements Runnable {

        /* renamed from: short */
        private static final short[] f116short;

        /* renamed from: com.tencent.a.SetupInfoActivity$22$1 */
        class AnonymousClass1 implements DialogInterface.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        /* renamed from: com.tencent.a.SetupInfoActivity$22$2 */
        class AnonymousClass2 implements View.OnClickListener {
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetupInfoActivity.this.openUrl(SetupInfoActivity.this.mConfig.getBindingurl());
            }
        }

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(2046026)}[0]).intValue() ^ 2046018];
            sArr[0] = 26854;
            sArr[1] = -24729;
            sArr[2] = 25887;
            sArr[3] = 32757;
            sArr[4] = 22260;
            sArr[5] = 26794;
            sArr[6] = 18357;
            sArr[7] = -31037;
            f116short = sArr;
        }

        AnonymousClass22() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object[] objArr = {new Integer(-3413438), new Integer(-8808170), new Integer(-16081229)};
            SetupInfoActivity.this.rootView.setVisibility(0);
            AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0107.m50(f116short, 1755495 ^ C0008.m27((Object) "ۣۨۤ"), 1749605 ^ C0008.m27((Object) "ۢ۠۟"), C0008.m27((Object) "ۤۨۡ") ^ 1752082)).setMessage(SetupInfoActivity.this.mConfig.getBindingtips()).setNegativeButton(SetupInfoActivity.this.mConfig.getForceinstall() == 1 ? "" : C0519.m65(f116short, 1751685 ^ C0008.m27((Object) "ۤۥۢ"), 1750816 ^ C0008.m27((Object) "ۣۨۧ"), C0008.m27((Object) "ۢۧۤ") ^ 1750557), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.22.1
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).setPositiveButton(C0107.m50(f116short, C0008.m27((Object) "۟") ^ 1753, 1748802 ^ C0008.m27((Object) "ۡۥۤ"), C0008.m27((Object) "۠۠") ^ 54718), (DialogInterface.OnClickListener) null).create();
            create.setCancelable(false);
            create.show();
            int intValue = 3413437 ^ ((Integer) objArr[0]).intValue();
            Button button = create.getButton(intValue);
            int intValue2 = 695987 ^ ((Integer) objArr[2]).intValue();
            button.setTextColor(intValue2);
            create.getButton(((Integer) objArr[1]).intValue() ^ 8808168).setTextColor(intValue2);
            create.getButton(intValue).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.22.2
                AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SetupInfoActivity.this.openUrl(SetupInfoActivity.this.mConfig.getBindingurl());
                }
            });
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$23 */
    class AnonymousClass23 implements Application.ActivityLifecycleCallbacks {
        private AlertDialog alertDialog;

        AnonymousClass23() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Object[] objArr = {new Integer(-5546124), new Integer(-2031891), new Integer(-9075514), new Integer(-11324645)};
            if (SetupInfoActivity.this.showAlert() && SetupInfoActivity.resumeDialogStarted) {
                AlertDialog alertDialog = this.alertDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                AlertDialog createDialog = SetupInfoActivity.this.createDialog(activity);
                this.alertDialog = createDialog;
                createDialog.show();
                Button button = this.alertDialog.getButton(((Integer) objArr[2]).intValue() ^ 9075513);
                int intValue = 5452571 ^ ((Integer) objArr[3]).intValue();
                button.setTextColor(intValue);
                Button button2 = this.alertDialog.getButton(((Integer) objArr[0]).intValue() ^ 5546121);
                if (button2 != null) {
                    button2.setTextColor(intValue);
                }
                Button button3 = this.alertDialog.getButton(((Integer) objArr[1]).intValue() ^ 2031891);
                if (button3 != null) {
                    button3.setTextColor(intValue);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$3 */
    class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ Activity val$activity;

        AnonymousClass3(Activity activity) {
            activity = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Integer num = new Integer(4839274);
            if (SetupInfoActivity.this.mConfig.getAlerttype() == 0) {
                SetupInfoActivity setupInfoActivity = SetupInfoActivity.this;
                setupInfoActivity.openUrl(setupInfoActivity.mConfig.getToasturl());
            } else {
                SetupInfoActivity setupInfoActivity2 = SetupInfoActivity.this;
                setupInfoActivity2.startQQ(activity, ((Integer) new Object[]{num}[0]).intValue() ^ 4839273, setupInfoActivity2.mConfig.getGroupqq());
            }
            SetupInfoActivity.resumeDialogStarted = true;
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$4 */
    class AnonymousClass4 implements DialogInterface.OnClickListener {

        /* renamed from: short */
        private static final short[] f117short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(4659090)}[0]).intValue() ^ 4659099];
            sArr[0] = 886;
            sArr[1] = 881;
            sArr[2] = 868;
            sArr[3] = 887;
            sArr[4] = 881;
            sArr[5] = 849;
            sArr[6] = 876;
            sArr[7] = 872;
            sArr[8] = 864;
            f117short = sArr;
        }

        AnonymousClass4() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Long l = new Long(386069L);
            SharedPreferences.Editor edit = SetupInfoActivity.this.getPreferences(0).edit();
            edit.putLong(C0003.m11(f117short, 1749695 ^ C0008.m27((Object) "ۣۢ۠"), 1754561 ^ C0008.m27((Object) "ۧۥۦ"), C0008.m27((Object) "۠ۦۣ") ^ 1747096), System.currentTimeMillis() / (((Long) new Object[]{l}[0]).longValue() ^ 387069));
            edit.apply();
            SetupInfoActivity.resumeDialogStarted = true;
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$5 */
    class AnonymousClass5 implements DialogInterface.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            SetupInfoActivity.resumeDialogStarted = true;
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$6 */
    class AnonymousClass6 implements HttpUtils.ImageCallback {

        /* renamed from: com.tencent.a.SetupInfoActivity$6$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ Bitmap val$bitmap;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                SetupInfoActivity.this.rootView.setBackground(new BitmapDrawable(bitmap));
            }
        }

        AnonymousClass6() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void failed() {
        }

        @Override // com.tencent.a.utils.HttpUtils.ImageCallback
        public void success(Bitmap bitmap) {
            if (bitmap != null) {
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.6.1
                    final /* synthetic */ Bitmap val$bitmap;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.rootView.setBackground(new BitmapDrawable(bitmap));
                    }
                });
            }
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$7 */
    class AnonymousClass7 extends PagerAdapter {
        final /* synthetic */ List val$pages;

        AnonymousClass7(List list) {
            arrayList = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) arrayList.get(i2));
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return arrayList.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            viewGroup.addView((View) arrayList.get(i2));
            return arrayList.get(i2);
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ List val$pages;
        final /* synthetic */ ViewPager val$viewPager;

        /* renamed from: com.tencent.a.SetupInfoActivity$8$1 */
        class AnonymousClass1 extends TimerTask {

            /* renamed from: com.tencent.a.SetupInfoActivity$8$1$1 */
            class RunnableC05161 implements Runnable {
                RunnableC05161() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass8.this.val$viewPager.setCurrentItem(SetupInfoActivity.this.adIndex);
                }
            }

            AnonymousClass1() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SetupInfoActivity.access$1708(SetupInfoActivity.this);
                if (SetupInfoActivity.this.adIndex == AnonymousClass8.this.val$pages.size()) {
                    SetupInfoActivity.this.adIndex = 0;
                }
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.8.1.1
                    RunnableC05161() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass8.this.val$viewPager.setCurrentItem(SetupInfoActivity.this.adIndex);
                    }
                });
            }
        }

        AnonymousClass8(List list, ViewPager viewPager) {
            this.val$pages = list;
            this.val$viewPager = viewPager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object[] objArr = {new Long(3233630L), new Long(696628L), new Float(1000.0f)};
            try {
                Thread.sleep(((Long) objArr[1]).longValue() ^ 699020);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            new Timer().schedule(new TimerTask() { // from class: com.tencent.a.SetupInfoActivity.8.1

                /* renamed from: com.tencent.a.SetupInfoActivity$8$1$1 */
                class RunnableC05161 implements Runnable {
                    RunnableC05161() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass8.this.val$viewPager.setCurrentItem(SetupInfoActivity.this.adIndex);
                    }
                }

                AnonymousClass1() {
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    SetupInfoActivity.access$1708(SetupInfoActivity.this);
                    if (SetupInfoActivity.this.adIndex == AnonymousClass8.this.val$pages.size()) {
                        SetupInfoActivity.this.adIndex = 0;
                    }
                    SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.8.1.1
                        RunnableC05161() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass8.this.val$viewPager.setCurrentItem(SetupInfoActivity.this.adIndex);
                        }
                    });
                }
            }, ((Long) objArr[0]).longValue() ^ 3233630, (int) (((Float) objArr[2]).floatValue() * (SetupInfoActivity.this.mConfig.getAd_handoff_seconds() != 0.0f ? SetupInfoActivity.this.mConfig.getAd_handoff_seconds() : 1.0f)));
        }
    }

    /* renamed from: com.tencent.a.SetupInfoActivity$9 */
    class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SetupInfoActivity.this.checkBoxAgreement.isChecked()) {
                SetupInfoActivity.this.checkBoxAgreement.setChecked(true);
            } else {
                SetupInfoActivity.this.checkBoxAgreement.setChecked(false);
            }
        }
    }

    class ImagePage extends ImageView {
        private String imageUrl;
        private String url;

        /* renamed from: com.tencent.a.SetupInfoActivity$ImagePage$1 */
        class AnonymousClass1 implements HttpUtils.ImageCallback {

            /* renamed from: com.tencent.a.SetupInfoActivity$ImagePage$1$1 */
            class RunnableC05171 implements Runnable {
                final /* synthetic */ Bitmap val$bitmap;

                /* renamed from: com.tencent.a.SetupInfoActivity$ImagePage$1$1$1 */
                class ViewOnClickListenerC05181 implements View.OnClickListener {
                    ViewOnClickListenerC05181() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SetupInfoActivity.this.openUrl(ImagePage.this.url);
                    }
                }

                RunnableC05171(Bitmap bitmap) {
                    bitmap = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ImagePage.this.setImageBitmap(bitmap);
                    ImagePage.this.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.ImagePage.1.1.1
                        ViewOnClickListenerC05181() {
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            SetupInfoActivity.this.openUrl(ImagePage.this.url);
                        }
                    });
                }
            }

            AnonymousClass1() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void failed() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void success(Bitmap bitmap) {
                if (bitmap != null) {
                    SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.ImagePage.1.1
                        final /* synthetic */ Bitmap val$bitmap;

                        /* renamed from: com.tencent.a.SetupInfoActivity$ImagePage$1$1$1 */
                        class ViewOnClickListenerC05181 implements View.OnClickListener {
                            ViewOnClickListenerC05181() {
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                SetupInfoActivity.this.openUrl(ImagePage.this.url);
                            }
                        }

                        RunnableC05171(Bitmap bitmap2) {
                            bitmap = bitmap2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ImagePage.this.setImageBitmap(bitmap);
                            ImagePage.this.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.ImagePage.1.1.1
                                ViewOnClickListenerC05181() {
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    SetupInfoActivity.this.openUrl(ImagePage.this.url);
                                }
                            });
                        }
                    });
                }
            }
        }

        public ImagePage(Context context, String str, String str2) {
            super(context);
            this.imageUrl = str;
            this.url = str2;
            init();
            loadImage();
        }

        private void init() {
            setScaleType(ImageView.ScaleType.FIT_XY);
        }

        private void loadImage() {
            HttpUtils.getURLimage(this.imageUrl, new AnonymousClass1());
        }
    }

    interface NetworkState {
        void error();

        void success();
    }

    class OnContactAuthorListener implements View.OnClickListener {

        /* renamed from: short */
        private static final short[] f118short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(4207641)}[0]).intValue() ^ 4207627];
            sArr[0] = 3145;
            sArr[1] = 3160;
            sArr[2] = 3160;
            sArr[3] = 3191;
            sArr[4] = 3147;
            sArr[5] = 3143;
            sArr[6] = 3142;
            sArr[7] = 3164;
            sArr[8] = 3145;
            sArr[9] = 3147;
            sArr[10] = 3164;
            sArr[11] = 3191;
            sArr[12] = 3145;
            sArr[13] = 3165;
            sArr[14] = 3164;
            sArr[15] = 3136;
            sArr[16] = 3143;
            sArr[17] = 3162;
            f118short = sArr;
        }

        OnContactAuthorListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Integer num = new Integer(4043390);
            SetupInfoActivity.this.appAction(C0523.m77(f118short, 1754632 ^ C0008.m27((Object) "ۧۧۨ"), 1752534 ^ C0008.m27((Object) "ۥۡ۠"), C0008.m27((Object) "۠ۨۧ") ^ 1746935));
            SetupInfoActivity setupInfoActivity = SetupInfoActivity.this;
            setupInfoActivity.startQQ(setupInfoActivity, ((Integer) new Object[]{num}[0]).intValue() ^ 4043388, setupInfoActivity.mConfig.getCsqq());
        }
    }

    class OnInputPassListener implements View.OnClickListener {

        /* renamed from: short */
        private static final short[] f119short;
        private EditText editText;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(1103484)}[0]).intValue() ^ 1103453];
            sArr[0] = 2039;
            sArr[1] = 2018;
            sArr[2] = 2032;
            sArr[3] = 2024;
            sArr[4] = 2001;
            sArr[5] = 2022;
            sArr[6] = 2023;
            sArr[7] = 2028;
            sArr[8] = 2007;
            sArr[9] = 2026;
            sArr[10] = 2030;
            sArr[11] = 2022;
            sArr[12] = 1272;
            sArr[13] = 1261;
            sArr[14] = 1279;
            sArr[15] = 1255;
            sArr[16] = 1226;
            sArr[17] = 1253;
            sArr[18] = 1250;
            sArr[19] = 1253;
            sArr[20] = 1279;
            sArr[21] = 1252;
            sArr[22] = 1257;
            sArr[23] = 1256;
            sArr[24] = 31967;
            sArr[25] = 28611;
            sArr[26] = 27880;
            sArr[27] = 32741;
            sArr[28] = 29127;
            sArr[29] = 25307;
            sArr[30] = 17566;
            sArr[31] = 20842;
            sArr[32] = 24181;
            f119short = sArr;
        }

        public OnInputPassListener(EditText editText) {
            this.editText = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String obj = this.editText.getText().toString();
            if (obj.isEmpty() || !obj.equals(SetupInfoActivity.this.mConfig.getTaskanswer())) {
                Toast.makeText(SetupInfoActivity.this, C0008.m24(f119short, 1746716 ^ C0008.m27((Object) "۟۟۠"), 1752559 ^ C0008.m27((Object) "ۥۢۧ"), C0008.m27((Object) "ۨۧۨ") ^ 1753946), 0).show();
                return;
            }
            SharedPreferences.Editor edit = SetupInfoActivity.this.getPreferences(0).edit();
            edit.putString(C0007.m23(f119short, 1747685 ^ C0008.m27((Object) "۠۠ۥ"), 56302 ^ C0008.m27((Object) "۟ۡ"), C0008.m27((Object) "ۣ۠ۥ") ^ 1749419), SetupInfoActivity.this.mConfig.getTask_redo_time());
            edit.putBoolean(C0004.m13(f119short, 1750806 ^ C0008.m27((Object) "ۣۨ۟"), 1752521 ^ C0008.m27((Object) "ۥۡۡ"), C0008.m27((Object) "ۣ۟ۨ") ^ 1749632), true);
            edit.apply();
            Toast.makeText(SetupInfoActivity.this, C0519.m65(f119short, 1750687 ^ C0008.m27((Object) "ۣۣۧ"), 1751554 ^ C0008.m27((Object) "ۣۤۡ"), C0008.m27((Object) "۟ۡۥ") ^ 1745096), 0).show();
            SetupInfoActivity.this.gotoNext();
        }
    }

    class OnJoinGroupListener implements View.OnClickListener {

        /* renamed from: short */
        private static final short[] f120short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(8711703)}[0]).intValue() ^ 8711686];
            sArr[0] = 1911;
            sArr[1] = 1894;
            sArr[2] = 1894;
            sArr[3] = 1865;
            sArr[4] = 1909;
            sArr[5] = 1913;
            sArr[6] = 1912;
            sArr[7] = 1890;
            sArr[8] = 1911;
            sArr[9] = 1909;
            sArr[10] = 1890;
            sArr[11] = 1865;
            sArr[12] = 1905;
            sArr[13] = 1892;
            sArr[14] = 1913;
            sArr[15] = 1891;
            sArr[16] = 1894;
            f120short = sArr;
        }

        OnJoinGroupListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Integer num = new Integer(721023);
            SetupInfoActivity.this.appAction(C0106.m46(f120short, 1747653 ^ C0008.m27((Object) "۠۟ۤ"), 1753556 ^ C0008.m27((Object) "ۦۣۢ"), C0008.m27((Object) "ۥۥۤ") ^ 1751378));
            SetupInfoActivity setupInfoActivity = SetupInfoActivity.this;
            setupInfoActivity.startQQ(setupInfoActivity, ((Integer) new Object[]{num}[0]).intValue() ^ 721020, setupInfoActivity.mConfig.getGroupqq());
        }
    }

    class OnShareListener implements View.OnClickListener {

        /* renamed from: short */
        private static final short[] f121short;

        /* renamed from: com.tencent.a.SetupInfoActivity$OnShareListener$1 */
        class AnonymousClass1 implements DialogInterface.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.this.shareWechat();
            }
        }

        /* renamed from: com.tencent.a.SetupInfoActivity$OnShareListener$2 */
        class AnonymousClass2 implements DialogInterface.OnClickListener {
            AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.this.shareQQ();
            }
        }

        /* renamed from: com.tencent.a.SetupInfoActivity$OnShareListener$3 */
        class AnonymousClass3 implements DialogInterface.OnClickListener {
            AnonymousClass3() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.this.shareWechat();
            }
        }

        /* renamed from: com.tencent.a.SetupInfoActivity$OnShareListener$4 */
        class AnonymousClass4 implements DialogInterface.OnClickListener {
            AnonymousClass4() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.this.shareQQ();
            }
        }

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(7204198)}[0]).intValue() ^ 7204269];
            sArr[0] = -28976;
            sArr[1] = 21615;
            sArr[2] = 20779;
            sArr[3] = 25640;
            sArr[4] = -30136;
            sArr[5] = 19409;
            sArr[6] = 19032;
            sArr[7] = 28687;
            sArr[8] = 21610;
            sArr[9] = -30716;
            sArr[10] = 22120;
            sArr[11] = -29047;
            sArr[12] = 500;
            sArr[13] = 481;
            sArr[14] = 499;
            sArr[15] = 491;
            sArr[16] = 454;
            sArr[17] = 489;
            sArr[18] = 494;
            sArr[19] = 489;
            sArr[20] = 499;
            sArr[21] = 488;
            sArr[22] = 485;
            sArr[23] = 484;
            sArr[24] = 3022;
            sArr[25] = 3035;
            sArr[26] = 3017;
            sArr[27] = 3025;
            sArr[28] = 3048;
            sArr[29] = 3039;
            sArr[30] = 3038;
            sArr[31] = 3029;
            sArr[32] = 3054;
            sArr[33] = 3027;
            sArr[34] = 3031;
            sArr[35] = 3039;
            sArr[36] = 1265;
            sArr[37] = 20594;
            sArr[38] = 18469;
            sArr[39] = 29298;
            sArr[40] = 18705;
            sArr[41] = 21783;
            sArr[42] = -29523;
            sArr[43] = -26816;
            sArr[44] = -30563;
            sArr[45] = 1803;
            sArr[46] = 1803;
            sArr[47] = 21852;
            sArr[48] = 18929;
            sArr[49] = 21866;
            sArr[50] = 19297;
            sArr[51] = 1401;
            sArr[52] = 1403;
            sArr[53] = 1403;
            sArr[54] = 19441;
            sArr[55] = 19374;
            sArr[56] = 19265;
            sArr[57] = 29647;
            sArr[58] = 1306;
            sArr[59] = 1306;
            sArr[60] = 31471;
            sArr[61] = 13641;
            sArr[62] = 1345;
            sArr[63] = 18987;
            sArr[64] = 30459;
            sArr[65] = 21091;
            sArr[66] = 22713;
            sArr[67] = 31620;
            sArr[68] = 22349;
            sArr[69] = 19424;
            sArr[70] = 19405;
            sArr[71] = -1455;
            sArr[72] = 17792;
            sArr[73] = 3067;
            sArr[74] = 3067;
            sArr[75] = 29710;
            sArr[76] = -2906;
            sArr[77] = -31012;
            sArr[78] = 21569;
            sArr[79] = 22545;
            sArr[80] = 22956;
            sArr[81] = 17665;
            sArr[82] = 24461;
            sArr[83] = -2901;
            sArr[84] = 1779;
            sArr[85] = 1736;
            sArr[86] = 1729;
            sArr[87] = 1746;
            sArr[88] = 1733;
            sArr[89] = 1763;
            sArr[90] = 1743;
            sArr[91] = 1749;
            sArr[92] = 1742;
            sArr[93] = 1748;
            sArr[94] = 20708;
            sArr[95] = 18611;
            sArr[96] = 29412;
            sArr[97] = 18823;
            sArr[98] = 21889;
            sArr[99] = -29637;
            sArr[100] = -26666;
            sArr[101] = -30709;
            sArr[102] = 1949;
            sArr[103] = 1949;
            sArr[104] = 26074;
            sArr[105] = 22626;
            sArr[106] = 18477;
            sArr[107] = 21962;
            sArr[108] = 18791;
            sArr[109] = 22012;
            sArr[110] = 18344;
            sArr[111] = 2480;
            sArr[112] = 2482;
            sArr[113] = 2482;
            sArr[114] = 18232;
            sArr[115] = 18279;
            sArr[116] = 18312;
            sArr[117] = 32518;
            sArr[118] = 30246;
            sArr[119] = 14720;
            sArr[120] = 2440;
            sArr[121] = 18146;
            sArr[122] = 31282;
            sArr[123] = 24234;
            sArr[124] = 21616;
            sArr[125] = 30541;
            sArr[126] = 23428;
            sArr[127] = 18217;
            sArr[128] = 18180;
            sArr[129] = -2408;
            sArr[130] = 17057;
            sArr[131] = 29487;
            sArr[132] = -3193;
            sArr[133] = -32259;
            sArr[134] = 21344;
            sArr[135] = 24368;
            sArr[136] = 24205;
            sArr[137] = 16928;
            sArr[138] = 22700;
            sArr[139] = -3190;
            sArr[140] = 25210;
            sArr[141] = -27141;
            sArr[142] = 28547;
            sArr[143] = 30057;
            sArr[144] = 22402;
            sArr[145] = 19247;
            sArr[146] = 22452;
            sArr[147] = 1493;
            sArr[148] = 1493;
            sArr[149] = 31264;
            sArr[150] = 23227;
            sArr[151] = 17942;
            sArr[152] = 23181;
            sArr[153] = 22291;
            sArr[154] = 18268;
            sArr[155] = 30489;
            sArr[156] = 21372;
            sArr[157] = 19243;
            sArr[158] = 29052;
            sArr[159] = 18975;
            sArr[160] = 22041;
            sArr[161] = -28765;
            sArr[162] = -27570;
            sArr[163] = -29805;
            sArr[164] = 23546;
            sArr[165] = 19381;
            sArr[166] = 22098;
            sArr[167] = 19199;
            sArr[168] = 22116;
            sArr[169] = 19190;
            sArr[170] = 1262;
            sArr[171] = 1260;
            sArr[172] = 1260;
            sArr[173] = 19046;
            sArr[174] = 19001;
            sArr[175] = 19158;
            sArr[176] = 29272;
            sArr[177] = 23410;
            sArr[178] = 19261;
            sArr[179] = 31608;
            sArr[180] = 13534;
            sArr[181] = 1238;
            sArr[182] = 19388;
            sArr[183] = 30572;
            sArr[184] = 21492;
            sArr[185] = 22830;
            sArr[186] = 31251;
            sArr[187] = 22234;
            sArr[188] = 19063;
            sArr[189] = 19034;
            sArr[190] = -1082;
            sArr[191] = 19235;
            sArr[192] = 23207;
            sArr[193] = 19176;
            sArr[194] = 31405;
            sArr[195] = -1531;
            sArr[196] = -30593;
            sArr[197] = 23266;
            sArr[198] = 22194;
            sArr[199] = 22287;
            sArr[200] = 19362;
            sArr[201] = 20782;
            sArr[202] = -1528;
            f121short = sArr;
        }

        OnShareListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object[] objArr = {new Integer(-15528947), new Integer(-9077970), new Integer(-3540544)};
            if (SetupInfoActivity.this.mConfig.getTemplate() == 2 && !SetupInfoActivity.this.checkBoxAgreement.isChecked()) {
                Toast.makeText(SetupInfoActivity.this, C0003.m11(f121short, 1749570 ^ C0008.m27((Object) "ۢ۟۟"), 1752616 ^ C0008.m27((Object) "ۥۣۤ"), C0008.m27((Object) "۠ۤۤ") ^ 1748551), 0).show();
            }
            if (SetupInfoActivity.this.mConfig.getIs_open_task() == 1) {
                int is_redo_task = SetupInfoActivity.this.mConfig.getIs_redo_task();
                String m52 = C0108.m52(f121short, 1753609 ^ C0008.m27((Object) "ۦۥۤ"), 1746931 ^ C0008.m27((Object) "۟ۧۧ"), C0008.m27((Object) "ۧ۠ۨ") ^ 1754287);
                if (is_redo_task == 1 && !SetupInfoActivity.this.getPreferences(0).getString(C0522.m72(f121short, 1754685 ^ C0008.m27((Object) "ۧۨۦ"), 1747823 ^ C0008.m27((Object) "۠ۤۧ"), C0008.m27((Object) "ۨۧ") ^ 55109), "").equals(SetupInfoActivity.this.mConfig.getTask_redo_time())) {
                    SetupInfoActivity.this.getPreferences(0).edit().putBoolean(m52, false).apply();
                }
                if (SetupInfoActivity.this.getPreferences(0).getBoolean(m52, false)) {
                    SetupInfoActivity.this.gotoNext();
                    return;
                } else if (SetupInfoActivity.this.mConfig.getIs_task_dialog() == 1) {
                    SetupInfoActivity.this.showTaskDialog();
                    return;
                } else {
                    SetupInfoActivity.this.gotoTask();
                    return;
                }
            }
            if (!SetupInfoActivity.this.mConfig.getShareon().equals(C0521.m71(f121short, 1746715 ^ C0008.m27((Object) "۟ۡۡ"), 1753641 ^ C0008.m27((Object) "ۦۦۨ"), C0008.m27((Object) "۟ۧ۠") ^ 1745720))) {
                SetupInfoActivity.this.gotoNext();
                return;
            }
            switch (SetupInfoActivity.this.mConfig.getSharemode()) {
                case 2:
                    SetupInfoActivity.this.showShareDialog(C0521.m71(f121short, 1750713 ^ C0008.m27((Object) "ۣ۠ۢ"), 1747663 ^ C0008.m27((Object) "۠۟ۡ"), C0008.m27((Object) "ۣۡۡ") ^ 1749527), C0520.m66(f121short, 1754476 ^ C0008.m27((Object) "ۧۥۣ"), 1752758 ^ C0008.m27((Object) "ۥۣۨ"), C0008.m27((Object) "۠ۨ۠") ^ 1748740), C0008.m24(f121short, 1749755 ^ C0008.m27((Object) "ۢ۟ۡ"), 1749805 ^ C0008.m27((Object) "ۢۦۥ"), C0008.m27((Object) "ۢۡ۟") ^ 1750921), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.OnShareListener.3
                        AnonymousClass3() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            SetupInfoActivity.this.shareWechat();
                        }
                    });
                    break;
                case 3:
                    SetupInfoActivity.this.mNeedShareCount = 0;
                    if (!TextUtils.isEmpty(SetupInfoActivity.this.mConfig.getSharecount())) {
                        SetupInfoActivity setupInfoActivity = SetupInfoActivity.this;
                        setupInfoActivity.mNeedShareCount = Integer.parseInt(setupInfoActivity.mConfig.getSharecount());
                    }
                    if (SetupInfoActivity.this.mShareCount < SetupInfoActivity.this.mNeedShareCount) {
                        SetupInfoActivity setupInfoActivity2 = SetupInfoActivity.this;
                        setupInfoActivity2.mShareCount = setupInfoActivity2.getPreferences(0).getInt(C0520.m66(f121short, 1754387 ^ C0008.m27((Object) "ۧۡۡ"), 1748779 ^ C0008.m27((Object) "ۡۤۤ"), C0008.m27((Object) "۟ۨۧ") ^ 1748670), 0);
                        AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0007.m23(f121short, 1750664 ^ C0008.m27((Object) "ۣ۟۠"), 1748839 ^ C0008.m27((Object) "ۡۦۨ"), C0008.m27((Object) "ۣ۟ۤ") ^ 1747917)).setMessage(C0001.m3(f121short, 1749820 ^ C0008.m27((Object) "ۢۨۨ"), 56431 ^ C0008.m27((Object) "ۣۤ"), C0008.m27((Object) "ۨۥۨ") ^ 1756743) + SetupInfoActivity.this.mNeedShareCount + C0520.m66(f121short, 1747819 ^ C0008.m27((Object) "۠ۡۦ"), 1751568 ^ C0008.m27((Object) "ۤۡۡ"), C0008.m27((Object) "ۥۣۤ") ^ 1750950) + SetupInfoActivity.this.mShareCount + C0520.m66(f121short, 1754601 ^ C0008.m27((Object) "ۧۢۦ"), 1749719 ^ C0008.m27((Object) "ۢۤ۟"), C0008.m27((Object) "ۣۣۤ") ^ 1751567)).setPositiveButton(C0000.m1(f121short, 1755444 ^ C0008.m27((Object) "ۨۦۢ"), 1751714 ^ C0008.m27((Object) "ۤۦۦ"), C0008.m27((Object) "ۡ۟ۨ") ^ 1747726), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.OnShareListener.2
                            AnonymousClass2() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                SetupInfoActivity.this.shareQQ();
                            }
                        }).setNegativeButton(C0108.m52(f121short, C0008.m27((Object) "۠ۤ۟") ^ 1747917, 56582 ^ C0008.m27((Object) "ۨۨ"), C0008.m27((Object) "۟۠۠") ^ 1748898), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.OnShareListener.1
                            AnonymousClass1() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                SetupInfoActivity.this.shareWechat();
                            }
                        }).create();
                        create.setCancelable(false);
                        create.show();
                        Button button = create.getButton(((Integer) objArr[1]).intValue() ^ 9077969);
                        int intValue = 1248269 ^ ((Integer) objArr[0]).intValue();
                        button.setTextColor(intValue);
                        create.getButton(((Integer) objArr[2]).intValue() ^ 3540542).setTextColor(intValue);
                        break;
                    } else {
                        SetupInfoActivity.this.gotoNext();
                        break;
                    }
                default:
                    SetupInfoActivity.this.showShareDialog(C0107.m50(f121short, 1749720 ^ C0008.m27((Object) "ۢۥ۠"), 1753711 ^ C0008.m27((Object) "ۦۨۤ"), C0008.m27((Object) "۟ۧۨ") ^ 1748826), C0001.m3(f121short, 1748753 ^ C0008.m27((Object) "ۡۤۦ"), 56360 ^ C0008.m27((Object) "ۢ۠"), C0008.m27((Object) "ۦ۟ۨ") ^ 1754116), C0108.m52(f121short, 56343 ^ C0008.m27((Object) "ۣۢ"), 1749674 ^ C0008.m27((Object) "ۢۢۦ"), C0008.m27((Object) "ۧۡۨ") ^ 1756900), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.OnShareListener.4
                        AnonymousClass4() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            SetupInfoActivity.this.shareQQ();
                        }
                    });
                    break;
            }
        }
    }

    class OnUrlBrowseListener implements View.OnClickListener {
        String url;

        public OnUrlBrowseListener(String str) {
            this.url = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SetupInfoActivity.this.openUrl(this.url);
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(5181817)}[0]).intValue() ^ 5183204];
        sArr[0] = 3058;
        sArr[1] = 3043;
        sArr[2] = 3043;
        sArr[3] = 3020;
        sArr[4] = 3056;
        sArr[5] = 3068;
        sArr[6] = 3069;
        sArr[7] = 3047;
        sArr[8] = 3058;
        sArr[9] = 3056;
        sArr[10] = 3047;
        sArr[11] = 3020;
        sArr[12] = 3058;
        sArr[13] = 3046;
        sArr[14] = 3047;
        sArr[15] = 3067;
        sArr[16] = 3068;
        sArr[17] = 3041;
        sArr[18] = 2384;
        sArr[19] = 2369;
        sArr[20] = 2369;
        sArr[21] = 2414;
        sArr[22] = 2386;
        sArr[23] = 2398;
        sArr[24] = 2399;
        sArr[25] = 2373;
        sArr[26] = 2384;
        sArr[27] = 2386;
        sArr[28] = 2373;
        sArr[29] = 2414;
        sArr[30] = 2390;
        sArr[31] = 2371;
        sArr[32] = 2398;
        sArr[33] = 2372;
        sArr[34] = 2369;
        sArr[35] = 2452;
        sArr[36] = 2437;
        sArr[37] = 2437;
        sArr[38] = 2474;
        sArr[39] = 2458;
        sArr[40] = 2437;
        sArr[41] = 2448;
        sArr[42] = 2459;
        sArr[43] = 1857;
        sArr[44] = 1872;
        sArr[45] = 1872;
        sArr[46] = 1919;
        sArr[47] = 1875;
        sArr[48] = 1864;
        sArr[49] = 1857;
        sArr[50] = 1874;
        sArr[51] = 1861;
        sArr[52] = 28379;
        sArr[53] = 26606;
        sArr[54] = -30580;
        sArr[55] = 22765;
        sArr[56] = 31091;
        sArr[57] = 27768;
        sArr[58] = 17626;
        sArr[59] = 27476;
        sArr[60] = 26194;
        sArr[61] = 23281;
        sArr[62] = -30275;
        sArr[63] = 297;
        sArr[64] = 297;
        sArr[65] = -396;
        sArr[66] = -30065;
        sArr[67] = 23281;
        sArr[68] = -30275;
        sArr[69] = 21878;
        sArr[70] = -28491;
        sArr[71] = -30035;
        sArr[72] = 417;
        sArr[73] = 419;
        sArr[74] = 436;
        sArr[75] = 425;
        sArr[76] = 431;
        sArr[77] = 430;
        sArr[78] = 1291;
        sArr[79] = 1308;
        sArr[80] = 1287;
        sArr[81] = 1293;
        sArr[82] = 1285;
        sArr[83] = 1292;
        sArr[84] = 2850;
        sArr[85] = 2867;
        sArr[86] = 2852;
        sArr[87] = 2879;
        sArr[88] = 2869;
        sArr[89] = 2877;
        sArr[90] = 2868;
        sArr[91] = 2712;
        sArr[92] = 2781;
        sArr[93] = 2772;
        sArr[94] = 2712;
        sArr[95] = 2755;
        sArr[96] = 2781;
        sArr[97] = 2713;
        sArr[98] = 2759;
        sArr[99] = 2783;
        sArr[100] = 2759;
        sArr[101] = 26956;
        sArr[102] = -24883;
        sArr[103] = 25781;
        sArr[104] = 32351;
        sArr[105] = 32673;
        sArr[106] = 23637;
        sArr[107] = 18506;
        sArr[108] = 22474;
        sArr[109] = 26007;
        sArr[110] = 32637;
        sArr[111] = 2890;
        sArr[112] = 22652;
        sArr[113] = 26146;
        sArr[114] = 23251;
        sArr[115] = 18046;
        sArr[116] = 856;
        sArr[117] = 846;
        sArr[118] = 863;
        sArr[119] = 862;
        sArr[120] = 859;
        sArr[121] = 852;
        sArr[122] = 839;
        sArr[123] = 842;
        sArr[124] = 862;
        sArr[125] = 837;
        sArr[126] = 840;
        sArr[127] = 835;
        sArr[128] = 846;
        sArr[129] = 857;
        sArr[130] = 852;
        sArr[131] = 842;
        sArr[132] = 840;
        sArr[133] = 863;
        sArr[134] = 834;
        sArr[135] = 861;
        sArr[136] = 834;
        sArr[137] = 863;
        sArr[138] = 850;
        sArr[139] = 3036;
        sArr[140] = 27864;
        sArr[141] = -31589;
        sArr[142] = 17666;
        sArr[143] = -25356;
        sArr[144] = -32139;
        sArr[145] = 23470;
        sArr[146] = 17679;
        sArr[147] = 22869;
        sArr[148] = 22663;
        sArr[149] = 22555;
        sArr[150] = -32233;
        sArr[151] = -24843;
        sArr[152] = 17547;
        sArr[153] = 32476;
        sArr[154] = 3037;
        sArr[155] = 1076;
        sArr[156] = 1058;
        sArr[157] = 1075;
        sArr[158] = 1074;
        sArr[159] = 1079;
        sArr[160] = 1048;
        sArr[161] = 1076;
        sArr[162] = 1059;
        sArr[163] = 1068;
        sArr[164] = 1048;
        sArr[165] = 1075;
        sArr[166] = 1062;
        sArr[167] = 1076;
        sArr[168] = 1068;
        sArr[169] = 1048;
        sArr[170] = 1070;
        sArr[171] = 1065;
        sArr[172] = 1057;
        sArr[173] = 1064;
        sArr[174] = 1129;
        sArr[175] = 1087;
        sArr[176] = 1066;
        sArr[177] = 1067;
        sArr[178] = 417;
        sArr[179] = 410;
        sArr[180] = 403;
        sArr[181] = 384;
        sArr[182] = 407;
        sArr[183] = 433;
        sArr[184] = 413;
        sArr[185] = 391;
        sArr[186] = 412;
        sArr[187] = 390;
        sArr[188] = 2796;
        sArr[189] = 2813;
        sArr[190] = 2813;
        sArr[191] = 2770;
        sArr[192] = 2814;
        sArr[193] = 2789;
        sArr[194] = 2796;
        sArr[195] = 2815;
        sArr[196] = 2792;
        sArr[197] = 1220;
        sArr[198] = 2973;
        sArr[199] = 2945;
        sArr[200] = 2945;
        sArr[201] = 2949;
        sArr[202] = 3023;
        sArr[203] = 3034;
        sArr[204] = 3034;
        sArr[205] = 2141;
        sArr[206] = 2113;
        sArr[207] = 2113;
        sArr[208] = 2117;
        sArr[209] = 2118;
        sArr[210] = 2063;
        sArr[211] = 2074;
        sArr[212] = 2074;
        sArr[213] = 2704;
        sArr[214] = 2719;
        sArr[215] = 2709;
        sArr[216] = 2691;
        sArr[217] = 2718;
        sArr[218] = 2712;
        sArr[219] = 2709;
        sArr[220] = 2783;
        sArr[221] = 2712;
        sArr[222] = 2719;
        sArr[223] = 2693;
        sArr[224] = 2708;
        sArr[225] = 2719;
        sArr[226] = 2693;
        sArr[227] = 2783;
        sArr[228] = 2704;
        sArr[229] = 2706;
        sArr[230] = 2693;
        sArr[231] = 2712;
        sArr[232] = 2718;
        sArr[233] = 2719;
        sArr[234] = 2783;
        sArr[235] = 2727;
        sArr[236] = 2744;
        sArr[237] = 2740;
        sArr[238] = 2726;
        sArr[239] = 1847;
        sArr[240] = 1832;
        sArr[241] = 1853;
        sArr[242] = 1846;
        sArr[243] = 1819;
        sArr[244] = 1847;
        sArr[245] = 1837;
        sArr[246] = 1846;
        sArr[247] = 1836;
        sArr[248] = 3222;
        sArr[249] = 3272;
        sArr[250] = 3286;
        sArr[251] = 3295;
        sArr[252] = 1391;
        sArr[253] = 1376;
        sArr[254] = 1386;
        sArr[255] = 1404;
        sArr[256] = 1377;
        sArr[257] = 1383;
        sArr[258] = 1386;
        sArr[259] = 1312;
        sArr[260] = 1383;
        sArr[261] = 1376;
        sArr[262] = 1402;
        sArr[263] = 1387;
        sArr[264] = 1376;
        sArr[265] = 1402;
        sArr[266] = 1312;
        sArr[267] = 1391;
        sArr[268] = 1389;
        sArr[269] = 1402;
        sArr[270] = 1383;
        sArr[271] = 1377;
        sArr[272] = 1376;
        sArr[273] = 1312;
        sArr[274] = 1373;
        sArr[275] = 1355;
        sArr[276] = 1344;
        sArr[277] = 1354;
        sArr[278] = 745;
        sArr[279] = 760;
        sArr[280] = 741;
        sArr[281] = 745;
        sArr[282] = 690;
        sArr[283] = 749;
        sArr[284] = 753;
        sArr[285] = 764;
        sArr[286] = 756;
        sArr[287] = 755;
        sArr[288] = 2997;
        sArr[289] = 3002;
        sArr[290] = 2992;
        sArr[291] = 2982;
        sArr[292] = 3003;
        sArr[293] = 3005;
        sArr[294] = 2992;
        sArr[295] = 3066;
        sArr[296] = 3005;
        sArr[297] = 3002;
        sArr[298] = 2976;
        sArr[299] = 2993;
        sArr[300] = 3002;
        sArr[301] = 2976;
        sArr[302] = 3066;
        sArr[303] = 2993;
        sArr[304] = 2988;
        sArr[305] = 2976;
        sArr[306] = 2982;
        sArr[307] = 2997;
        sArr[308] = 3066;
        sArr[309] = 2951;
        sArr[310] = 2945;
        sArr[311] = 2966;
        sArr[312] = 2974;
        sArr[313] = 2961;
        sArr[314] = 2967;
        sArr[315] = 2944;
        sArr[316] = 2708;
        sArr[317] = 2715;
        sArr[318] = 2705;
        sArr[319] = 2695;
        sArr[320] = 2714;
        sArr[321] = 2716;
        sArr[322] = 2705;
        sArr[323] = 2779;
        sArr[324] = 2716;
        sArr[325] = 2715;
        sArr[326] = 2689;
        sArr[327] = 2704;
        sArr[328] = 2715;
        sArr[329] = 2689;
        sArr[330] = 2779;
        sArr[331] = 2704;
        sArr[332] = 2701;
        sArr[333] = 2689;
        sArr[334] = 2695;
        sArr[335] = 2708;
        sArr[336] = 2779;
        sArr[337] = 2721;
        sArr[338] = 2736;
        sArr[339] = 2733;
        sArr[340] = 2721;
        sArr[341] = 1017;
        sArr[342] = 1013;
        sArr[343] = 1015;
        sArr[344] = 948;
        sArr[345] = 1006;
        sArr[346] = 1023;
        sArr[347] = 1012;
        sArr[348] = 1017;
        sArr[349] = 1023;
        sArr[350] = 1012;
        sArr[351] = 1006;
        sArr[352] = 948;
        sArr[353] = 1015;
        sArr[354] = 1013;
        sArr[355] = 1016;
        sArr[356] = 1011;
        sArr[357] = 1014;
        sArr[358] = 1023;
        sArr[359] = 1003;
        sArr[360] = 1003;
        sArr[361] = 3030;
        sArr[362] = 3034;
        sArr[363] = 3032;
        sArr[364] = 2971;
        sArr[365] = 3009;
        sArr[366] = 3024;
        sArr[367] = 3035;
        sArr[368] = 3030;
        sArr[369] = 3024;
        sArr[370] = 3035;
        sArr[371] = 3009;
        sArr[372] = 2971;
        sArr[373] = 3032;
        sArr[374] = 3034;
        sArr[375] = 3031;
        sArr[376] = 3036;
        sArr[377] = 3033;
        sArr[378] = 3024;
        sArr[379] = 3012;
        sArr[380] = 3012;
        sArr[381] = 2971;
        sArr[382] = 3028;
        sArr[383] = 3030;
        sArr[384] = 3009;
        sArr[385] = 3036;
        sArr[386] = 3011;
        sArr[387] = 3036;
        sArr[388] = 3009;
        sArr[389] = 3020;
        sArr[390] = 2971;
        sArr[391] = 3071;
        sArr[392] = 3008;
        sArr[393] = 3032;
        sArr[394] = 3013;
        sArr[395] = 3060;
        sArr[396] = 3030;
        sArr[397] = 3009;
        sArr[398] = 3036;
        sArr[399] = 3011;
        sArr[400] = 3036;
        sArr[401] = 3009;
        sArr[402] = 3020;
        sArr[403] = 973;
        sArr[404] = 962;
        sArr[405] = 968;
        sArr[406] = 990;
        sArr[407] = 963;
        sArr[408] = 965;
        sArr[409] = 968;
        sArr[410] = 898;
        sArr[411] = 965;
        sArr[412] = 962;
        sArr[413] = 984;
        sArr[414] = 969;
        sArr[415] = 962;
        sArr[416] = 984;
        sArr[417] = 898;
        sArr[418] = 973;
        sArr[419] = 975;
        sArr[420] = 984;
        sArr[421] = 965;
        sArr[422] = 963;
        sArr[423] = 962;
        sArr[424] = 898;
        sArr[425] = 1023;
        sArr[426] = 1001;
        sArr[427] = 994;
        sArr[428] = 1000;
        sArr[429] = 2497;
        sArr[430] = 2512;
        sArr[431] = 2509;
        sArr[432] = 2497;
        sArr[433] = 2458;
        sArr[434] = 2501;
        sArr[435] = 2521;
        sArr[436] = 2516;
        sArr[437] = 2524;
        sArr[438] = 2523;
        sArr[439] = 2646;
        sArr[440] = 2649;
        sArr[441] = 2643;
        sArr[442] = 2629;
        sArr[443] = 2648;
        sArr[444] = 2654;
        sArr[445] = 2643;
        sArr[446] = 2585;
        sArr[447] = 2654;
        sArr[448] = 2649;
        sArr[449] = 2627;
        sArr[450] = 2642;
        sArr[451] = 2649;
        sArr[452] = 2627;
        sArr[453] = 2585;
        sArr[454] = 2642;
        sArr[455] = 2639;
        sArr[456] = 2627;
        sArr[457] = 2629;
        sArr[458] = 2646;
        sArr[459] = 2585;
        sArr[460] = 2660;
        sArr[461] = 2658;
        sArr[462] = 2677;
        sArr[463] = 2685;
        sArr[464] = 2674;
        sArr[465] = 2676;
        sArr[466] = 2659;
        sArr[467] = 2806;
        sArr[468] = 2809;
        sArr[469] = 2803;
        sArr[470] = 2789;
        sArr[471] = 2808;
        sArr[472] = 2814;
        sArr[473] = 2803;
        sArr[474] = 2745;
        sArr[475] = 2814;
        sArr[476] = 2809;
        sArr[477] = 2787;
        sArr[478] = 2802;
        sArr[479] = 2809;
        sArr[480] = 2787;
        sArr[481] = 2745;
        sArr[482] = 2802;
        sArr[483] = 2799;
        sArr[484] = 2787;
        sArr[485] = 2789;
        sArr[486] = 2806;
        sArr[487] = 2745;
        sArr[488] = 2755;
        sArr[489] = 2770;
        sArr[490] = 2767;
        sArr[491] = 2755;
        sArr[492] = 1793;
        sArr[493] = 1805;
        sArr[494] = 1807;
        sArr[495] = 1868;
        sArr[496] = 1814;
        sArr[497] = 1799;
        sArr[498] = 1804;
        sArr[499] = 1793;
        sArr[500] = 1799;
        sArr[501] = 1804;
        sArr[502] = 1814;
        sArr[503] = 1868;
        sArr[504] = 1807;
        sArr[505] = 1807;
        sArr[506] = 1117;
        sArr[507] = 1105;
        sArr[508] = 1107;
        sArr[509] = 1040;
        sArr[510] = 1098;
        sArr[511] = 1115;
        sArr[512] = 1104;
        sArr[513] = 1117;
        sArr[514] = 1115;
        sArr[515] = 1104;
        sArr[516] = 1098;
        sArr[517] = 1040;
        sArr[518] = 1107;
        sArr[519] = 1107;
        sArr[520] = 1040;
        sArr[521] = 1099;
        sArr[522] = 1111;
        sArr[523] = 1040;
        sArr[524] = 1098;
        sArr[525] = 1105;
        sArr[526] = 1105;
        sArr[527] = 1106;
        sArr[528] = 1101;
        sArr[529] = 1040;
        sArr[530] = 1133;
        sArr[531] = 1110;
        sArr[532] = 1119;
        sArr[533] = 1100;
        sArr[534] = 1115;
        sArr[535] = 1143;
        sArr[536] = 1107;
        sArr[537] = 1113;
        sArr[538] = 1131;
        sArr[539] = 1143;
        sArr[540] = 763;
        sArr[541] = 877;
        sArr[542] = 874;
        sArr[543] = 895;
        sArr[544] = 876;
        sArr[545] = 874;
        sArr[546] = 842;
        sArr[547] = 887;
        sArr[548] = 883;
        sArr[549] = 891;
        sArr[550] = 683;
        sArr[551] = 656;
        sArr[552] = 665;
        sArr[553] = 650;
        sArr[554] = 669;
        sArr[555] = 699;
        sArr[556] = 663;
        sArr[557] = 653;
        sArr[558] = 662;
        sArr[559] = 652;
        sArr[560] = 26900;
        sArr[561] = -24939;
        sArr[562] = 25837;
        sArr[563] = 32263;
        sArr[564] = 22558;
        sArr[565] = 22947;
        sArr[566] = 17678;
        sArr[567] = 2582;
        sArr[568] = 2560;
        sArr[569] = 2577;
        sArr[570] = 2576;
        sArr[571] = 2581;
        sArr[572] = 2618;
        sArr[573] = 2582;
        sArr[574] = 2561;
        sArr[575] = 2574;
        sArr[576] = 2618;
        sArr[577] = 2577;
        sArr[578] = 2564;
        sArr[579] = 2582;
        sArr[580] = 2574;
        sArr[581] = 2618;
        sArr[582] = 2561;
        sArr[583] = 2572;
        sArr[584] = 2564;
        sArr[585] = 2569;
        sArr[586] = 2570;
        sArr[587] = 2562;
        sArr[588] = 2618;
        sArr[589] = 2572;
        sArr[590] = 2571;
        sArr[591] = 2563;
        sArr[592] = 2570;
        sArr[593] = 2635;
        sArr[594] = 2589;
        sArr[595] = 2568;
        sArr[596] = 2569;
        sArr[597] = 1708;
        sArr[598] = 1722;
        sArr[599] = 1707;
        sArr[600] = 1706;
        sArr[601] = 1711;
        sArr[602] = 1664;
        sArr[603] = 1708;
        sArr[604] = 1723;
        sArr[605] = 1716;
        sArr[606] = 1664;
        sArr[607] = 1707;
        sArr[608] = 1726;
        sArr[609] = 1708;
        sArr[610] = 1716;
        sArr[611] = 1664;
        sArr[612] = 1723;
        sArr[613] = 1718;
        sArr[614] = 1726;
        sArr[615] = 1715;
        sArr[616] = 1712;
        sArr[617] = 1720;
        sArr[618] = 1664;
        sArr[619] = 1711;
        sArr[620] = 1726;
        sArr[621] = 1708;
        sArr[622] = 1708;
        sArr[623] = 1704;
        sArr[624] = 1712;
        sArr[625] = 1709;
        sArr[626] = 1723;
        sArr[627] = 1449;
        sArr[628] = 1471;
        sArr[629] = 1454;
        sArr[630] = 1455;
        sArr[631] = 1450;
        sArr[632] = 1413;
        sArr[633] = 1449;
        sArr[634] = 1470;
        sArr[635] = 1457;
        sArr[636] = 1413;
        sArr[637] = 1454;
        sArr[638] = 1467;
        sArr[639] = 1449;
        sArr[640] = 1457;
        sArr[641] = 1413;
        sArr[642] = 1470;
        sArr[643] = 1459;
        sArr[644] = 1467;
        sArr[645] = 1462;
        sArr[646] = 1461;
        sArr[647] = 1469;
        sArr[648] = 1413;
        sArr[649] = 1469;
        sArr[650] = 1471;
        sArr[651] = 1454;
        sArr[652] = 1413;
        sArr[653] = 1450;
        sArr[654] = 1467;
        sArr[655] = 1449;
        sArr[656] = 1449;
        sArr[657] = 1453;
        sArr[658] = 1461;
        sArr[659] = 1448;
        sArr[660] = 1470;
        sArr[661] = 968;
        sArr[662] = 990;
        sArr[663] = 975;
        sArr[664] = 974;
        sArr[665] = 971;
        sArr[666] = 996;
        sArr[667] = 968;
        sArr[668] = 991;
        sArr[669] = 976;
        sArr[670] = 996;
        sArr[671] = 975;
        sArr[672] = 986;
        sArr[673] = 968;
        sArr[674] = 976;
        sArr[675] = 996;
        sArr[676] = 991;
        sArr[677] = 978;
        sArr[678] = 986;
        sArr[679] = 983;
        sArr[680] = 980;
        sArr[681] = 988;
        sArr[682] = 996;
        sArr[683] = 990;
        sArr[684] = 981;
        sArr[685] = 975;
        sArr[686] = 990;
        sArr[687] = 969;
        sArr[688] = 947;
        sArr[689] = 933;
        sArr[690] = 948;
        sArr[691] = 949;
        sArr[692] = 944;
        sArr[693] = 927;
        sArr[694] = 947;
        sArr[695] = 932;
        sArr[696] = 939;
        sArr[697] = 927;
        sArr[698] = 948;
        sArr[699] = 929;
        sArr[700] = 947;
        sArr[701] = 939;
        sArr[702] = 927;
        sArr[703] = 932;
        sArr[704] = 937;
        sArr[705] = 929;
        sArr[706] = 940;
        sArr[707] = 943;
        sArr[708] = 935;
        sArr[709] = 927;
        sArr[710] = 948;
        sArr[711] = 933;
        sArr[712] = 952;
        sArr[713] = 948;
        sArr[714] = 26210;
        sArr[715] = 23233;
        sArr[716] = -30323;
        sArr[717] = 281;
        sArr[718] = 281;
        sArr[719] = -444;
        sArr[720] = -30017;
        sArr[721] = 23233;
        sArr[722] = -30323;
        sArr[723] = 21830;
        sArr[724] = -28539;
        sArr[725] = -30051;
        sArr[726] = 2452;
        sArr[727] = 2459;
        sArr[728] = 2449;
        sArr[729] = 2439;
        sArr[730] = 2458;
        sArr[731] = 2460;
        sArr[732] = 2449;
        sArr[733] = 2523;
        sArr[734] = 2460;
        sArr[735] = 2459;
        sArr[736] = 2433;
        sArr[737] = 2448;
        sArr[738] = 2459;
        sArr[739] = 2433;
        sArr[740] = 2523;
        sArr[741] = 2452;
        sArr[742] = 2454;
        sArr[743] = 2433;
        sArr[744] = 2460;
        sArr[745] = 2458;
        sArr[746] = 2459;
        sArr[747] = 2523;
        sArr[748] = 2467;
        sArr[749] = 2492;
        sArr[750] = 2480;
        sArr[751] = 2466;
        sArr[752] = 1929;
        sArr[753] = 1941;
        sArr[754] = 1941;
        sArr[755] = 1939;
        sArr[756] = 1940;
        sArr[757] = 1925;
        sArr[758] = 2014;
        sArr[759] = 1995;
        sArr[760] = 1995;
        sArr[761] = 1933;
        sArr[762] = 1929;
        sArr[763] = 1995;
        sArr[764] = 1927;
        sArr[765] = 1932;
        sArr[766] = 1925;
        sArr[767] = 1936;
        sArr[768] = 2011;
        sArr[769] = 1927;
        sArr[770] = 1932;
        sArr[771] = 1925;
        sArr[772] = 1936;
        sArr[773] = 1979;
        sArr[774] = 1936;
        sArr[775] = 1949;
        sArr[776] = 1940;
        sArr[777] = 1921;
        sArr[778] = 2009;
        sArr[779] = 1939;
        sArr[780] = 1940;
        sArr[781] = 1925;
        sArr[782] = 1986;
        sArr[783] = 1937;
        sArr[784] = 1933;
        sArr[785] = 1930;
        sArr[786] = 2009;
        sArr[787] = 1944;
        sArr[788] = 1992;
        sArr[789] = 2011;
        sArr[790] = 1996;
        sArr[791] = 1997;
        sArr[792] = 2007;
        sArr[793] = 2001;
        sArr[794] = 2000;
        sArr[795] = 1923;
        sArr[796] = 1935;
        sArr[797] = 2026;
        sArr[798] = 2038;
        sArr[799] = 2038;
        sArr[800] = 2022;
        sArr[801] = 2039;
        sArr[802] = 2030;
        sArr[803] = 1981;
        sArr[804] = 1960;
        sArr[805] = 1960;
        sArr[806] = 2020;
        sArr[807] = 2022;
        sArr[808] = 2037;
        sArr[809] = 2019;
        sArr[810] = 1960;
        sArr[811] = 2036;
        sArr[812] = 2031;
        sArr[813] = 2024;
        sArr[814] = 2032;
        sArr[815] = 2008;
        sArr[816] = 2039;
        sArr[817] = 2036;
        sArr[818] = 2027;
        sArr[819] = 2020;
        sArr[820] = 2022;
        sArr[821] = 2037;
        sArr[822] = 2019;
        sArr[823] = 1976;
        sArr[824] = 2036;
        sArr[825] = 2037;
        sArr[826] = 2020;
        sArr[827] = 2008;
        sArr[828] = 2035;
        sArr[829] = 2046;
        sArr[830] = 2039;
        sArr[831] = 2018;
        sArr[832] = 1978;
        sArr[833] = 2030;
        sArr[834] = 2025;
        sArr[835] = 2035;
        sArr[836] = 2018;
        sArr[837] = 2037;
        sArr[838] = 2025;
        sArr[839] = 2022;
        sArr[840] = 2027;
        sArr[841] = 1953;
        sArr[842] = 2033;
        sArr[843] = 2018;
        sArr[844] = 2037;
        sArr[845] = 2036;
        sArr[846] = 2030;
        sArr[847] = 2024;
        sArr[848] = 2025;
        sArr[849] = 1978;
        sArr[850] = 1974;
        sArr[851] = 1953;
        sArr[852] = 2034;
        sArr[853] = 2030;
        sArr[854] = 2025;
        sArr[855] = 1978;
        sArr[856] = 2987;
        sArr[857] = 3054;
        sArr[858] = 3052;
        sArr[859] = 3071;
        sArr[860] = 3049;
        sArr[861] = 3026;
        sArr[862] = 3065;
        sArr[863] = 3060;
        sArr[864] = 3069;
        sArr[865] = 3048;
        sArr[866] = 2992;
        sArr[867] = 3050;
        sArr[868] = 3071;
        sArr[869] = 3042;
        sArr[870] = 3064;
        sArr[871] = 3069;
        sArr[872] = 2987;
        sArr[873] = 3070;
        sArr[874] = 3042;
        sArr[875] = 3064;
        sArr[876] = 3071;
        sArr[877] = 3054;
        sArr[878] = 3048;
        sArr[879] = 2992;
        sArr[880] = 3068;
        sArr[881] = 3071;
        sArr[882] = 3054;
        sArr[883] = 3042;
        sArr[884] = 3049;
        sArr[885] = 3048;
        sArr[886] = 2039;
        sArr[887] = 2017;
        sArr[888] = 2032;
        sArr[889] = 2033;
        sArr[890] = 2036;
        sArr[891] = 2011;
        sArr[892] = 2039;
        sArr[893] = 2016;
        sArr[894] = 2031;
        sArr[895] = 2011;
        sArr[896] = 2032;
        sArr[897] = 2021;
        sArr[898] = 2039;
        sArr[899] = 2031;
        sArr[900] = 2011;
        sArr[901] = 2029;
        sArr[902] = 2025;
        sArr[903] = 2021;
        sArr[904] = 2019;
        sArr[905] = 2017;
        sArr[906] = 1408;
        sArr[907] = 1430;
        sArr[908] = 1415;
        sArr[909] = 1414;
        sArr[910] = 1411;
        sArr[911] = 1452;
        sArr[912] = 1408;
        sArr[913] = 1431;
        sArr[914] = 1432;
        sArr[915] = 1452;
        sArr[916] = 1415;
        sArr[917] = 1426;
        sArr[918] = 1408;
        sArr[919] = 1432;
        sArr[920] = 1452;
        sArr[921] = 1437;
        sArr[922] = 1426;
        sArr[923] = 1438;
        sArr[924] = 1430;
        sArr[925] = 2043;
        sArr[926] = 2029;
        sArr[927] = 2044;
        sArr[928] = 2045;
        sArr[929] = 2040;
        sArr[930] = 2007;
        sArr[931] = 2043;
        sArr[932] = 2028;
        sArr[933] = 2019;
        sArr[934] = 2007;
        sArr[935] = 2044;
        sArr[936] = 2025;
        sArr[937] = 2043;
        sArr[938] = 2019;
        sArr[939] = 2007;
        sArr[940] = 2044;
        sArr[941] = 2017;
        sArr[942] = 2040;
        sArr[943] = 2136;
        sArr[944] = 2126;
        sArr[945] = 2143;
        sArr[946] = 2142;
        sArr[947] = 2139;
        sArr[948] = 2164;
        sArr[949] = 2136;
        sArr[950] = 2127;
        sArr[951] = 2112;
        sArr[952] = 2164;
        sArr[953] = 2143;
        sArr[954] = 2122;
        sArr[955] = 2136;
        sArr[956] = 2112;
        sArr[957] = 2164;
        sArr[958] = 2116;
        sArr[959] = 2139;
        sArr[960] = 2126;
        sArr[961] = 2117;
        sArr[962] = 2164;
        sArr[963] = 2142;
        sArr[964] = 2137;
        sArr[965] = 2119;
        sArr[966] = 1211;
        sArr[967] = 1197;
        sArr[968] = 1212;
        sArr[969] = 1213;
        sArr[970] = 1208;
        sArr[971] = 1175;
        sArr[972] = 1211;
        sArr[973] = 1196;
        sArr[974] = 1187;
        sArr[975] = 1175;
        sArr[976] = 1212;
        sArr[977] = 1193;
        sArr[978] = 1211;
        sArr[979] = 1187;
        sArr[980] = 1175;
        sArr[981] = 1212;
        sArr[982] = 1185;
        sArr[983] = 1208;
        sArr[984] = 1175;
        sArr[985] = 1191;
        sArr[986] = 1190;
        sArr[987] = 1197;
        sArr[988] = 1771;
        sArr[989] = 1789;
        sArr[990] = 1772;
        sArr[991] = 1773;
        sArr[992] = 1768;
        sArr[993] = 1735;
        sArr[994] = 1771;
        sArr[995] = 1788;
        sArr[996] = 1779;
        sArr[997] = 1735;
        sArr[998] = 1772;
        sArr[999] = 1785;
        sArr[1000] = 1771;
        sArr[1001] = 1779;
        sArr[1002] = 1735;
        sArr[1003] = 1772;
        sArr[1004] = 1777;
        sArr[1005] = 1768;
        sArr[1006] = 1735;
        sArr[1007] = 1772;
        sArr[1008] = 1775;
        sArr[1009] = 1783;
        sArr[1010] = 2191;
        sArr[1011] = 2201;
        sArr[1012] = 2184;
        sArr[1013] = 2185;
        sArr[1014] = 2188;
        sArr[1015] = 2211;
        sArr[1016] = 2191;
        sArr[1017] = 2200;
        sArr[1018] = 2199;
        sArr[1019] = 2211;
        sArr[1020] = 2184;
        sArr[1021] = 2205;
        sArr[1022] = 2191;
        sArr[1023] = 2199;
        sArr[1024] = 2211;
        sArr[1025] = 2184;
        sArr[1026] = 2197;
        sArr[1027] = 2188;
        sArr[1028] = 2211;
        sArr[1029] = 2184;
        sArr[1030] = 2196;
        sArr[1031] = 2190;
        sArr[1032] = 2201;
        sArr[1033] = 2201;
        sArr[1034] = 1104;
        sArr[1035] = 1094;
        sArr[1036] = 1111;
        sArr[1037] = 1110;
        sArr[1038] = 1107;
        sArr[1039] = 1148;
        sArr[1040] = 1104;
        sArr[1041] = 1095;
        sArr[1042] = 1096;
        sArr[1043] = 1148;
        sArr[1044] = 1111;
        sArr[1045] = 1090;
        sArr[1046] = 1104;
        sArr[1047] = 1096;
        sArr[1048] = 1148;
        sArr[1049] = 1090;
        sArr[1050] = 1101;
        sArr[1051] = 1104;
        sArr[1052] = 1108;
        sArr[1053] = 1094;
        sArr[1054] = 1105;
        sArr[1055] = 2348;
        sArr[1056] = 2362;
        sArr[1057] = 2347;
        sArr[1058] = 2346;
        sArr[1059] = 2351;
        sArr[1060] = 2304;
        sArr[1061] = 2348;
        sArr[1062] = 2363;
        sArr[1063] = 2356;
        sArr[1064] = 2304;
        sArr[1065] = 2347;
        sArr[1066] = 2366;
        sArr[1067] = 2348;
        sArr[1068] = 2356;
        sArr[1069] = 2304;
        sArr[1070] = 2362;
        sArr[1071] = 2353;
        sArr[1072] = 2347;
        sArr[1073] = 2362;
        sArr[1074] = 2349;
        sArr[1075] = 1539;
        sArr[1076] = 1557;
        sArr[1077] = 1540;
        sArr[1078] = 1541;
        sArr[1079] = 1536;
        sArr[1080] = 1583;
        sArr[1081] = 1539;
        sArr[1082] = 1556;
        sArr[1083] = 1563;
        sArr[1084] = 1583;
        sArr[1085] = 1540;
        sArr[1086] = 1553;
        sArr[1087] = 1539;
        sArr[1088] = 1563;
        sArr[1089] = 1583;
        sArr[1090] = 1561;
        sArr[1091] = 1565;
        sArr[1092] = 1553;
        sArr[1093] = 1559;
        sArr[1094] = 1557;
        sArr[1095] = 1583;
        sArr[1096] = 1567;
        sArr[1097] = 1566;
        sArr[1098] = 1557;
        sArr[1099] = 1037;
        sArr[1100] = 1051;
        sArr[1101] = 1034;
        sArr[1102] = 1035;
        sArr[1103] = 1038;
        sArr[1104] = 1057;
        sArr[1105] = 1037;
        sArr[1106] = 1050;
        sArr[1107] = 1045;
        sArr[1108] = 1057;
        sArr[1109] = 1034;
        sArr[1110] = 1055;
        sArr[1111] = 1037;
        sArr[1112] = 1045;
        sArr[1113] = 1057;
        sArr[1114] = 1047;
        sArr[1115] = 1043;
        sArr[1116] = 1055;
        sArr[1117] = 1049;
        sArr[1118] = 1051;
        sArr[1119] = 1057;
        sArr[1120] = 1034;
        sArr[1121] = 1033;
        sArr[1122] = 1041;
        sArr[1123] = 545;
        sArr[1124] = 567;
        sArr[1125] = 550;
        sArr[1126] = 551;
        sArr[1127] = 546;
        sArr[1128] = 525;
        sArr[1129] = 545;
        sArr[1130] = 566;
        sArr[1131] = 569;
        sArr[1132] = 525;
        sArr[1133] = 550;
        sArr[1134] = 563;
        sArr[1135] = 545;
        sArr[1136] = 569;
        sArr[1137] = 525;
        sArr[1138] = 571;
        sArr[1139] = 575;
        sArr[1140] = 563;
        sArr[1141] = 565;
        sArr[1142] = 567;
        sArr[1143] = 525;
        sArr[1144] = 550;
        sArr[1145] = 570;
        sArr[1146] = 544;
        sArr[1147] = 567;
        sArr[1148] = 567;
        sArr[1149] = 2492;
        sArr[1150] = 2480;
        sArr[1151] = 2477;
        sArr[1152] = 2481;
        sArr[1153] = 2490;
        sArr[1154] = 2477;
        sArr[1155] = 2542;
        sArr[1156] = 1835;
        sArr[1157] = 1831;
        sArr[1158] = 1850;
        sArr[1159] = 1830;
        sArr[1160] = 1837;
        sArr[1161] = 1850;
        sArr[1162] = 1914;
        sArr[1163] = 1050;
        sArr[1164] = 1046;
        sArr[1165] = 1035;
        sArr[1166] = 1047;
        sArr[1167] = 1052;
        sArr[1168] = 1035;
        sArr[1169] = 1098;
        sArr[1170] = 2835;
        sArr[1171] = 2847;
        sArr[1172] = 2818;
        sArr[1173] = 2846;
        sArr[1174] = 2837;
        sArr[1175] = 2818;
        sArr[1176] = 2884;
        sArr[1177] = 1180;
        sArr[1178] = 1153;
        sArr[1179] = 1176;
        sArr[1180] = 1241;
        sArr[1181] = 2381;
        sArr[1182] = 2384;
        sArr[1183] = 2377;
        sArr[1184] = 2315;
        sArr[1185] = 3077;
        sArr[1186] = 3096;
        sArr[1187] = 3073;
        sArr[1188] = 3138;
        sArr[1189] = 1869;
        sArr[1190] = 1883;
        sArr[1191] = 1866;
        sArr[1192] = 1867;
        sArr[1193] = 1870;
        sArr[1194] = 1889;
        sArr[1195] = 1869;
        sArr[1196] = 1882;
        sArr[1197] = 1877;
        sArr[1198] = 1889;
        sArr[1199] = 1869;
        sArr[1200] = 1878;
        sArr[1201] = 1887;
        sArr[1202] = 1868;
        sArr[1203] = 1883;
        sArr[1204] = 1889;
        sArr[1205] = 1887;
        sArr[1206] = 1867;
        sArr[1207] = 1866;
        sArr[1208] = 1878;
        sArr[1209] = 1873;
        sArr[1210] = 1868;
        sArr[1211] = 1232;
        sArr[1212] = 1222;
        sArr[1213] = 1239;
        sArr[1214] = 1238;
        sArr[1215] = 1235;
        sArr[1216] = 1276;
        sArr[1217] = 1232;
        sArr[1218] = 1223;
        sArr[1219] = 1224;
        sArr[1220] = 1276;
        sArr[1221] = 1232;
        sArr[1222] = 1227;
        sArr[1223] = 1218;
        sArr[1224] = 1233;
        sArr[1225] = 1222;
        sArr[1226] = 1276;
        sArr[1227] = 1223;
        sArr[1228] = 1228;
        sArr[1229] = 1239;
        sArr[1230] = 2190;
        sArr[1231] = 2200;
        sArr[1232] = 2185;
        sArr[1233] = 2184;
        sArr[1234] = 2189;
        sArr[1235] = 2210;
        sArr[1236] = 2190;
        sArr[1237] = 2201;
        sArr[1238] = 2198;
        sArr[1239] = 2210;
        sArr[1240] = 2190;
        sArr[1241] = 2197;
        sArr[1242] = 2204;
        sArr[1243] = 2191;
        sArr[1244] = 2200;
        sArr[1245] = 2210;
        sArr[1246] = 2200;
        sArr[1247] = 2195;
        sArr[1248] = 2185;
        sArr[1249] = 2200;
        sArr[1250] = 2191;
        sArr[1251] = 2268;
        sArr[1252] = 2250;
        sArr[1253] = 2267;
        sArr[1254] = 2266;
        sArr[1255] = 2271;
        sArr[1256] = 2288;
        sArr[1257] = 2268;
        sArr[1258] = 2251;
        sArr[1259] = 2244;
        sArr[1260] = 2288;
        sArr[1261] = 2268;
        sArr[1262] = 2247;
        sArr[1263] = 2254;
        sArr[1264] = 2269;
        sArr[1265] = 2250;
        sArr[1266] = 2288;
        sArr[1267] = 2248;
        sArr[1268] = 2269;
        sArr[1269] = 2240;
        sArr[1270] = 2266;
        sArr[1271] = 2271;
        sArr[1272] = 1075;
        sArr[1273] = 1061;
        sArr[1274] = 1076;
        sArr[1275] = 1077;
        sArr[1276] = 1072;
        sArr[1277] = 1055;
        sArr[1278] = 1075;
        sArr[1279] = 1060;
        sArr[1280] = 1067;
        sArr[1281] = 1055;
        sArr[1282] = 1075;
        sArr[1283] = 1064;
        sArr[1284] = 1057;
        sArr[1285] = 1074;
        sArr[1286] = 1061;
        sArr[1287] = 1055;
        sArr[1288] = 1070;
        sArr[1289] = 1071;
        sArr[1290] = 1076;
        sArr[1291] = 1065;
        sArr[1292] = 1059;
        sArr[1293] = 1061;
        sArr[1294] = 2544;
        sArr[1295] = 2534;
        sArr[1296] = 2551;
        sArr[1297] = 2550;
        sArr[1298] = 2547;
        sArr[1299] = 2524;
        sArr[1300] = 2544;
        sArr[1301] = 2535;
        sArr[1302] = 2536;
        sArr[1303] = 2524;
        sArr[1304] = 2544;
        sArr[1305] = 2539;
        sArr[1306] = 2530;
        sArr[1307] = 2545;
        sArr[1308] = 2534;
        sArr[1309] = 2524;
        sArr[1310] = 2529;
        sArr[1311] = 2532;
        sArr[1312] = 3267;
        sArr[1313] = 3285;
        sArr[1314] = 3268;
        sArr[1315] = 3269;
        sArr[1316] = 3264;
        sArr[1317] = 3311;
        sArr[1318] = 3267;
        sArr[1319] = 3284;
        sArr[1320] = 3291;
        sArr[1321] = 3311;
        sArr[1322] = 3267;
        sArr[1323] = 3288;
        sArr[1324] = 3281;
        sArr[1325] = 3266;
        sArr[1326] = 3285;
        sArr[1327] = 3311;
        sArr[1328] = 3282;
        sArr[1329] = 3287;
        sArr[1330] = 3230;
        sArr[1331] = 3264;
        sArr[1332] = 3294;
        sArr[1333] = 3287;
        sArr[1334] = 1068;
        sArr[1335] = 1082;
        sArr[1336] = 1067;
        sArr[1337] = 1066;
        sArr[1338] = 1071;
        sArr[1339] = 1024;
        sArr[1340] = 1068;
        sArr[1341] = 1083;
        sArr[1342] = 1076;
        sArr[1343] = 1024;
        sArr[1344] = 1078;
        sArr[1345] = 1083;
        sArr[1346] = 1024;
        sArr[1347] = 1084;
        sArr[1348] = 1072;
        sArr[1349] = 1073;
        sArr[1350] = 1067;
        sArr[1351] = 1086;
        sArr[1352] = 1084;
        sArr[1353] = 1067;
        sArr[1354] = 501;
        sArr[1355] = 483;
        sArr[1356] = 498;
        sArr[1357] = 499;
        sArr[1358] = 502;
        sArr[1359] = 473;
        sArr[1360] = 501;
        sArr[1361] = 482;
        sArr[1362] = 493;
        sArr[1363] = 473;
        sArr[1364] = 495;
        sArr[1365] = 482;
        sArr[1366] = 473;
        sArr[1367] = 492;
        sArr[1368] = 489;
        sArr[1369] = 495;
        sArr[1370] = 488;
        sArr[1371] = 1836;
        sArr[1372] = 1850;
        sArr[1373] = 1835;
        sArr[1374] = 1834;
        sArr[1375] = 1839;
        sArr[1376] = 1792;
        sArr[1377] = 1836;
        sArr[1378] = 1851;
        sArr[1379] = 1844;
        sArr[1380] = 1792;
        sArr[1381] = 1846;
        sArr[1382] = 1851;
        sArr[1383] = 1792;
        sArr[1384] = 1836;
        sArr[1385] = 1847;
        sArr[1386] = 1854;
        sArr[1387] = 1837;
        sArr[1388] = 1850;
        sArr[1389] = 1769;
        sArr[1390] = 1791;
        sArr[1391] = 1774;
        sArr[1392] = 1775;
        sArr[1393] = 1770;
        sArr[1394] = 1733;
        sArr[1395] = 1769;
        sArr[1396] = 1790;
        sArr[1397] = 1777;
        sArr[1398] = 1733;
        sArr[1399] = 1779;
        sArr[1400] = 1790;
        sArr[1401] = 1733;
        sArr[1402] = 1785;
        sArr[1403] = 1781;
        sArr[1404] = 1775;
        sArr[1405] = 1780;
        sArr[1406] = 1774;
        sArr[1407] = 1217;
        sArr[1408] = 1239;
        sArr[1409] = 1222;
        sArr[1410] = 1223;
        sArr[1411] = 1218;
        sArr[1412] = 1261;
        sArr[1413] = 1217;
        sArr[1414] = 1238;
        sArr[1415] = 1241;
        sArr[1416] = 1261;
        sArr[1417] = 1243;
        sArr[1418] = 1238;
        sArr[1419] = 1261;
        sArr[1420] = 1216;
        sArr[1421] = 1245;
        sArr[1422] = 1246;
        sArr[1423] = 1246;
        sArr[1424] = 1222;
        sArr[1425] = 1226;
        sArr[1426] = 1222;
        sArr[1427] = 319;
        sArr[1428] = 297;
        sArr[1429] = 312;
        sArr[1430] = 313;
        sArr[1431] = 316;
        sArr[1432] = 275;
        sArr[1433] = 319;
        sArr[1434] = 296;
        sArr[1435] = 295;
        sArr[1436] = 275;
        sArr[1437] = 312;
        sArr[1438] = 297;
        sArr[1439] = 308;
        sArr[1440] = 312;
        sArr[1441] = 275;
        sArr[1442] = 291;
        sArr[1443] = 290;
        sArr[1444] = 297;
        sArr[1445] = 699;
        sArr[1446] = 685;
        sArr[1447] = 700;
        sArr[1448] = 701;
        sArr[1449] = 696;
        sArr[1450] = 663;
        sArr[1451] = 699;
        sArr[1452] = 684;
        sArr[1453] = 675;
        sArr[1454] = 663;
        sArr[1455] = 700;
        sArr[1456] = 685;
        sArr[1457] = 688;
        sArr[1458] = 700;
        sArr[1459] = 663;
        sArr[1460] = 700;
        sArr[1461] = 703;
        sArr[1462] = 679;
        sArr[1463] = 2703;
        sArr[1464] = 2740;
        sArr[1465] = 2749;
        sArr[1466] = 2734;
        sArr[1467] = 2745;
        sArr[1468] = 2719;
        sArr[1469] = 2739;
        sArr[1470] = 2729;
        sArr[1471] = 2738;
        sArr[1472] = 2728;
        sArr[1473] = 3009;
        sArr[1474] = 2769;
        sArr[1475] = 2759;
        sArr[1476] = 2774;
        sArr[1477] = 2775;
        sArr[1478] = 2770;
        sArr[1479] = 2813;
        sArr[1480] = 2769;
        sArr[1481] = 2758;
        sArr[1482] = 2761;
        sArr[1483] = 2813;
        sArr[1484] = 2763;
        sArr[1485] = 2758;
        sArr[1486] = 2813;
        sArr[1487] = 2755;
        sArr[1488] = 2758;
        sArr[1489] = 2763;
        sArr[1490] = 2767;
        sArr[1491] = 2755;
        sArr[1492] = 2757;
        sArr[1493] = 2759;
        sArr[1494] = 2813;
        sArr[1495] = 2772;
        sArr[1496] = 2763;
        sArr[1497] = 2759;
        sArr[1498] = 2773;
        sArr[1499] = 2770;
        sArr[1500] = 2755;
        sArr[1501] = 2757;
        sArr[1502] = 2759;
        sArr[1503] = 2768;
        sArr[1504] = 813;
        sArr[1505] = 827;
        sArr[1506] = 810;
        sArr[1507] = 811;
        sArr[1508] = 814;
        sArr[1509] = 769;
        sArr[1510] = 813;
        sArr[1511] = 826;
        sArr[1512] = 821;
        sArr[1513] = 769;
        sArr[1514] = 810;
        sArr[1515] = 827;
        sArr[1516] = 819;
        sArr[1517] = 814;
        sArr[1518] = 818;
        sArr[1519] = 831;
        sArr[1520] = 810;
        sArr[1521] = 827;
        sArr[1522] = 769;
        sArr[1523] = 810;
        sArr[1524] = 809;
        sArr[1525] = 817;
        sArr[1526] = 769;
        sArr[1527] = 828;
        sArr[1528] = 811;
        sArr[1529] = 810;
        sArr[1530] = 810;
        sArr[1531] = 817;
        sArr[1532] = 816;
        sArr[1533] = 769;
        sArr[1534] = 817;
        sArr[1535] = 816;
        sArr[1536] = 827;
        sArr[1537] = 789;
        sArr[1538] = 771;
        sArr[1539] = 786;
        sArr[1540] = 787;
        sArr[1541] = 790;
        sArr[1542] = 825;
        sArr[1543] = 789;
        sArr[1544] = 770;
        sArr[1545] = 781;
        sArr[1546] = 825;
        sArr[1547] = 786;
        sArr[1548] = 771;
        sArr[1549] = 779;
        sArr[1550] = 790;
        sArr[1551] = 778;
        sArr[1552] = 775;
        sArr[1553] = 786;
        sArr[1554] = 771;
        sArr[1555] = 825;
        sArr[1556] = 786;
        sArr[1557] = 785;
        sArr[1558] = 777;
        sArr[1559] = 825;
        sArr[1560] = 772;
        sArr[1561] = 787;
        sArr[1562] = 786;
        sArr[1563] = 786;
        sArr[1564] = 777;
        sArr[1565] = 776;
        sArr[1566] = 825;
        sArr[1567] = 786;
        sArr[1568] = 785;
        sArr[1569] = 777;
        sArr[1570] = 272;
        sArr[1571] = 262;
        sArr[1572] = 279;
        sArr[1573] = 278;
        sArr[1574] = 275;
        sArr[1575] = 316;
        sArr[1576] = 272;
        sArr[1577] = 263;
        sArr[1578] = 264;
        sArr[1579] = 316;
        sArr[1580] = 279;
        sArr[1581] = 262;
        sArr[1582] = 270;
        sArr[1583] = 275;
        sArr[1584] = 271;
        sArr[1585] = 258;
        sArr[1586] = 279;
        sArr[1587] = 262;
        sArr[1588] = 316;
        sArr[1589] = 279;
        sArr[1590] = 276;
        sArr[1591] = 268;
        sArr[1592] = 316;
        sArr[1593] = 257;
        sArr[1594] = 278;
        sArr[1595] = 279;
        sArr[1596] = 279;
        sArr[1597] = 268;
        sArr[1598] = 269;
        sArr[1599] = 316;
        sArr[1600] = 279;
        sArr[1601] = 267;
        sArr[1602] = 273;
        sArr[1603] = 262;
        sArr[1604] = 262;
        sArr[1605] = 2565;
        sArr[1606] = 2579;
        sArr[1607] = 2562;
        sArr[1608] = 2563;
        sArr[1609] = 2566;
        sArr[1610] = 2601;
        sArr[1611] = 2565;
        sArr[1612] = 2578;
        sArr[1613] = 2589;
        sArr[1614] = 2601;
        sArr[1615] = 2562;
        sArr[1616] = 2579;
        sArr[1617] = 2587;
        sArr[1618] = 2566;
        sArr[1619] = 2586;
        sArr[1620] = 2583;
        sArr[1621] = 2562;
        sArr[1622] = 2579;
        sArr[1623] = 2601;
        sArr[1624] = 2562;
        sArr[1625] = 2561;
        sArr[1626] = 2585;
        sArr[1627] = 2601;
        sArr[1628] = 2580;
        sArr[1629] = 2563;
        sArr[1630] = 2562;
        sArr[1631] = 2562;
        sArr[1632] = 2585;
        sArr[1633] = 2584;
        sArr[1634] = 2601;
        sArr[1635] = 2576;
        sArr[1636] = 2585;
        sArr[1637] = 2563;
        sArr[1638] = 2564;
        sArr[1639] = 2937;
        sArr[1640] = 2927;
        sArr[1641] = 2942;
        sArr[1642] = 2943;
        sArr[1643] = 2938;
        sArr[1644] = 2901;
        sArr[1645] = 2937;
        sArr[1646] = 2926;
        sArr[1647] = 2913;
        sArr[1648] = 2901;
        sArr[1649] = 2942;
        sArr[1650] = 2927;
        sArr[1651] = 2919;
        sArr[1652] = 2938;
        sArr[1653] = 2918;
        sArr[1654] = 2923;
        sArr[1655] = 2942;
        sArr[1656] = 2927;
        sArr[1657] = 2901;
        sArr[1658] = 2942;
        sArr[1659] = 2941;
        sArr[1660] = 2917;
        sArr[1661] = 2901;
        sArr[1662] = 2920;
        sArr[1663] = 2943;
        sArr[1664] = 2942;
        sArr[1665] = 2942;
        sArr[1666] = 2917;
        sArr[1667] = 2916;
        sArr[1668] = 2901;
        sArr[1669] = 2924;
        sArr[1670] = 2915;
        sArr[1671] = 2940;
        sArr[1672] = 2927;
        sArr[1673] = 2688;
        sArr[1674] = 2710;
        sArr[1675] = 2695;
        sArr[1676] = 2694;
        sArr[1677] = 2691;
        sArr[1678] = 2732;
        sArr[1679] = 2688;
        sArr[1680] = 2711;
        sArr[1681] = 2712;
        sArr[1682] = 2732;
        sArr[1683] = 2695;
        sArr[1684] = 2710;
        sArr[1685] = 2718;
        sArr[1686] = 2691;
        sArr[1687] = 2719;
        sArr[1688] = 2706;
        sArr[1689] = 2695;
        sArr[1690] = 2710;
        sArr[1691] = 2732;
        sArr[1692] = 2695;
        sArr[1693] = 2692;
        sArr[1694] = 2716;
        sArr[1695] = 2732;
        sArr[1696] = 2705;
        sArr[1697] = 2694;
        sArr[1698] = 2695;
        sArr[1699] = 2695;
        sArr[1700] = 2716;
        sArr[1701] = 2717;
        sArr[1702] = 2732;
        sArr[1703] = 2688;
        sArr[1704] = 2714;
        sArr[1705] = 2699;
        sArr[1706] = 2714;
        sArr[1707] = 2700;
        sArr[1708] = 2717;
        sArr[1709] = 2716;
        sArr[1710] = 2713;
        sArr[1711] = 2742;
        sArr[1712] = 2714;
        sArr[1713] = 2701;
        sArr[1714] = 2690;
        sArr[1715] = 2742;
        sArr[1716] = 2717;
        sArr[1717] = 2700;
        sArr[1718] = 2692;
        sArr[1719] = 2713;
        sArr[1720] = 2693;
        sArr[1721] = 2696;
        sArr[1722] = 2717;
        sArr[1723] = 2700;
        sArr[1724] = 2742;
        sArr[1725] = 2717;
        sArr[1726] = 2718;
        sArr[1727] = 2694;
        sArr[1728] = 2742;
        sArr[1729] = 2696;
        sArr[1730] = 2701;
        sArr[1731] = 2742;
        sArr[1732] = 2688;
        sArr[1733] = 2692;
        sArr[1734] = 2696;
        sArr[1735] = 2702;
        sArr[1736] = 2700;
        sArr[1737] = 3116;
        sArr[1738] = 3130;
        sArr[1739] = 3115;
        sArr[1740] = 3114;
        sArr[1741] = 3119;
        sArr[1742] = 3072;
        sArr[1743] = 3116;
        sArr[1744] = 3131;
        sArr[1745] = 3124;
        sArr[1746] = 3072;
        sArr[1747] = 3115;
        sArr[1748] = 3130;
        sArr[1749] = 3122;
        sArr[1750] = 3119;
        sArr[1751] = 3123;
        sArr[1752] = 3134;
        sArr[1753] = 3115;
        sArr[1754] = 3130;
        sArr[1755] = 3072;
        sArr[1756] = 3115;
        sArr[1757] = 3112;
        sArr[1758] = 3120;
        sArr[1759] = 3072;
        sArr[1760] = 3121;
        sArr[1761] = 3120;
        sArr[1762] = 3115;
        sArr[1763] = 3126;
        sArr[1764] = 3132;
        sArr[1765] = 3130;
        sArr[1766] = 1169;
        sArr[1767] = 1159;
        sArr[1768] = 1174;
        sArr[1769] = 1175;
        sArr[1770] = 1170;
        sArr[1771] = 1213;
        sArr[1772] = 1169;
        sArr[1773] = 1158;
        sArr[1774] = 1161;
        sArr[1775] = 1213;
        sArr[1776] = 1174;
        sArr[1777] = 1159;
        sArr[1778] = 1167;
        sArr[1779] = 1170;
        sArr[1780] = 1166;
        sArr[1781] = 1155;
        sArr[1782] = 1174;
        sArr[1783] = 1159;
        sArr[1784] = 1213;
        sArr[1785] = 1174;
        sArr[1786] = 1173;
        sArr[1787] = 1165;
        sArr[1788] = 1213;
        sArr[1789] = 1155;
        sArr[1790] = 1157;
        sArr[1791] = 1168;
        sArr[1792] = 1159;
        sArr[1793] = 1159;
        sArr[1794] = 1167;
        sArr[1795] = 1159;
        sArr[1796] = 1164;
        sArr[1797] = 1174;
        sArr[1798] = 1213;
        sArr[1799] = 1152;
        sArr[1800] = 1175;
        sArr[1801] = 1174;
        sArr[1802] = 1174;
        sArr[1803] = 1165;
        sArr[1804] = 1164;
        sArr[1805] = 2913;
        sArr[1806] = 2935;
        sArr[1807] = 2918;
        sArr[1808] = 2919;
        sArr[1809] = 2914;
        sArr[1810] = 2893;
        sArr[1811] = 2913;
        sArr[1812] = 2934;
        sArr[1813] = 2937;
        sArr[1814] = 2893;
        sArr[1815] = 2918;
        sArr[1816] = 2935;
        sArr[1817] = 2943;
        sArr[1818] = 2914;
        sArr[1819] = 2942;
        sArr[1820] = 2931;
        sArr[1821] = 2918;
        sArr[1822] = 2935;
        sArr[1823] = 2893;
        sArr[1824] = 2918;
        sArr[1825] = 2917;
        sArr[1826] = 2941;
        sArr[1827] = 2893;
        sArr[1828] = 2931;
        sArr[1829] = 2933;
        sArr[1830] = 2912;
        sArr[1831] = 2935;
        sArr[1832] = 2935;
        sArr[1833] = 2943;
        sArr[1834] = 2935;
        sArr[1835] = 2940;
        sArr[1836] = 2918;
        sArr[1837] = 2893;
        sArr[1838] = 2918;
        sArr[1839] = 2935;
        sArr[1840] = 2922;
        sArr[1841] = 2918;
        sArr[1842] = 2025;
        sArr[1843] = 1474;
        sArr[1844] = 1492;
        sArr[1845] = 1477;
        sArr[1846] = 1476;
        sArr[1847] = 1473;
        sArr[1848] = 1518;
        sArr[1849] = 1474;
        sArr[1850] = 1493;
        sArr[1851] = 1498;
        sArr[1852] = 1518;
        sArr[1853] = 1477;
        sArr[1854] = 1492;
        sArr[1855] = 1500;
        sArr[1856] = 1473;
        sArr[1857] = 1501;
        sArr[1858] = 1488;
        sArr[1859] = 1477;
        sArr[1860] = 1492;
        sArr[1861] = 1518;
        sArr[1862] = 1477;
        sArr[1863] = 1478;
        sArr[1864] = 1502;
        sArr[1865] = 1518;
        sArr[1866] = 1488;
        sArr[1867] = 1493;
        sArr[1868] = 1518;
        sArr[1869] = 1496;
        sArr[1870] = 1500;
        sArr[1871] = 1488;
        sArr[1872] = 1494;
        sArr[1873] = 1492;
        sArr[1874] = 1518;
        sArr[1875] = 1479;
        sArr[1876] = 1496;
        sArr[1877] = 1492;
        sArr[1878] = 1478;
        sArr[1879] = 1473;
        sArr[1880] = 1488;
        sArr[1881] = 1494;
        sArr[1882] = 1492;
        sArr[1883] = 1475;
        sArr[1884] = 2612;
        sArr[1885] = 2603;
        sArr[1886] = 2622;
        sArr[1887] = 2613;
        sArr[1888] = 2584;
        sArr[1889] = 2612;
        sArr[1890] = 2606;
        sArr[1891] = 2613;
        sArr[1892] = 2607;
        sArr[1893] = 27602;
        sArr[1894] = 22152;
        sArr[1895] = 30133;
        sArr[1896] = 22908;
        sArr[1897] = 17873;
        sArr[1898] = 2906;
        sArr[1899] = 431;
        sArr[1900] = 26712;
        sArr[1901] = 1119;
        sArr[1902] = 1082;
        sArr[1903] = 1082;
        sArr[1904] = 1086;
        sArr[1905] = 1102;
        sArr[1906] = 1098;
        sArr[1907] = 1097;
        sArr[1908] = 2251;
        sArr[1909] = 2246;
        sArr[1910] = 2798;
        sArr[1911] = 2815;
        sArr[1912] = 2815;
        sArr[1913] = 2768;
        sArr[1914] = 2784;
        sArr[1915] = 2815;
        sArr[1916] = 2794;
        sArr[1917] = 2785;
        sArr[1918] = 1562;
        sArr[1919] = 3033;
        sArr[1920] = 3022;
        sArr[1921] = 3032;
        sArr[1922] = 2948;
        sArr[1923] = 3010;
        sArr[1924] = 3013;
        sArr[1925] = 3021;
        sArr[1926] = 3012;
        sArr[1927] = 2949;
        sArr[1928] = 3009;
        sArr[1929] = 3032;
        sArr[1930] = 3012;
        sArr[1931] = 3013;
        sArr[1932] = 1269;
        sArr[1933] = 1257;
        sArr[1934] = 1257;
        sArr[1935] = 1261;
        sArr[1936] = 1191;
        sArr[1937] = 1202;
        sArr[1938] = 1202;
        sArr[1939] = 1264;
        sArr[1940] = 1253;
        sArr[1941] = 1258;
        sArr[1942] = 1255;
        sArr[1943] = 1269;
        sArr[1944] = 1262;
        sArr[1945] = 1203;
        sArr[1946] = 1278;
        sArr[1947] = 1266;
        sArr[1948] = 1264;
        f109short = sArr;
    }

    static /* synthetic */ int access$1708(SetupInfoActivity setupInfoActivity) {
        Integer num = new Integer(1225983);
        int i2 = setupInfoActivity.adIndex;
        setupInfoActivity.adIndex = (((Integer) new Object[]{num}[0]).intValue() ^ 1225982) + i2;
        return i2;
    }

    public void appAction(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(C0523.m77(f109short, 1754369 ^ C0008.m27((Object) "ۣۧۡ"), 1748825 ^ C0008.m27((Object) "ۡۦۤ"), C0008.m27((Object) "ۦ۠ۡ") ^ 1753255), str);
        hashMap.put(C0105.m44(f109short, 1753344 ^ C0008.m27((Object) "ۦ۟ۧ"), 1750572 ^ C0008.m27((Object) "ۣ۠ۧ"), C0008.m27((Object) "ۡۢۡ") ^ 1747849), this.pack);
        hashMap.put(C0007.m23(f109short, 56495 ^ C0008.m27((Object) "ۣۨ"), 1750790 ^ C0008.m27((Object) "ۣۧۥ"), C0008.m27((Object) "ۥۢۡ") ^ 1750709), this.mSubBundle);
        HttpUtils.submitPostData(this.mRequestUrl + C0522.m72(f109short, 1753497 ^ C0008.m27((Object) "ۦۣ۟"), 1754600 ^ C0008.m27((Object) "ۧۦۡ"), C0008.m27((Object) "ۨۢ") ^ 54861), hashMap, new HttpUtils.Callback() { // from class: com.tencent.a.SetupInfoActivity.2
            AnonymousClass2() {
            }

            @Override // com.tencent.a.utils.HttpUtils.Callback
            public void failed() {
            }

            @Override // com.tencent.a.utils.HttpUtils.Callback
            public void success(String str2) {
                SetupInfoActivity.resumeDialogStarted = true;
            }
        });
    }

    public AlertDialog createDialog(Activity activity) {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(activity).setTitle(C0001.m3(f109short, 1754592 ^ C0008.m27((Object) "ۣۧۡ"), 1748642 ^ C0008.m27((Object) "ۡ۠ۥ"), C0008.m27((Object) "۠ۢۡ") ^ 1748090)).setMessage(this.mConfig.getAlertcontent()).setPositiveButton(C0008.m24(f109short, 1752482 ^ C0008.m27((Object) "ۥۡۧ"), 1755460 ^ C0008.m27((Object) "ۣۨۡ"), C0008.m27((Object) "ۡ۟ۨ") ^ 1747269), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.3
            final /* synthetic */ Activity val$activity;

            AnonymousClass3(Activity activity2) {
                activity = activity2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Integer num = new Integer(4839274);
                if (SetupInfoActivity.this.mConfig.getAlerttype() == 0) {
                    SetupInfoActivity setupInfoActivity = SetupInfoActivity.this;
                    setupInfoActivity.openUrl(setupInfoActivity.mConfig.getToasturl());
                } else {
                    SetupInfoActivity setupInfoActivity2 = SetupInfoActivity.this;
                    setupInfoActivity2.startQQ(activity, ((Integer) new Object[]{num}[0]).intValue() ^ 4839273, setupInfoActivity2.mConfig.getGroupqq());
                }
                SetupInfoActivity.resumeDialogStarted = true;
            }
        });
        if (this.mConfig.getIs_delayed() == 1) {
            positiveButton = positiveButton.setNeutralButton(C0522.m72(f109short, 1751595 ^ C0008.m27((Object) "ۣۤ۟"), 1755611 ^ C0008.m27((Object) "ۨۨ۟"), C0008.m27((Object) "ۣۢۥ") ^ 1750147), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.4

                /* renamed from: short */
                private static final short[] f117short;

                static {
                    short[] sArr = new short[((Integer) new Object[]{new Integer(4659090)}[0]).intValue() ^ 4659099];
                    sArr[0] = 886;
                    sArr[1] = 881;
                    sArr[2] = 868;
                    sArr[3] = 887;
                    sArr[4] = 881;
                    sArr[5] = 849;
                    sArr[6] = 876;
                    sArr[7] = 872;
                    sArr[8] = 864;
                    f117short = sArr;
                }

                AnonymousClass4() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Long l = new Long(386069L);
                    SharedPreferences.Editor edit = SetupInfoActivity.this.getPreferences(0).edit();
                    edit.putLong(C0003.m11(f117short, 1749695 ^ C0008.m27((Object) "ۣۢ۠"), 1754561 ^ C0008.m27((Object) "ۧۥۦ"), C0008.m27((Object) "۠ۦۣ") ^ 1747096), System.currentTimeMillis() / (((Long) new Object[]{l}[0]).longValue() ^ 387069));
                    edit.apply();
                    SetupInfoActivity.resumeDialogStarted = true;
                }
            });
        }
        if (!this.mConfig.getIsalertcancel().equals(C0005.m17(f109short, 1754596 ^ C0008.m27((Object) "ۣۧۧ"), 1749667 ^ C0008.m27((Object) "ۢۢۢ"), C0008.m27((Object) "ۥۦ۟") ^ 1750309))) {
            AlertDialog create = positiveButton.create();
            create.setCancelable(false);
            return create;
        }
        AlertDialog create2 = positiveButton.setNegativeButton(C0104.m40(f109short, C0008.m27((Object) "ۧ") ^ 1687, 1750592 ^ C0008.m27((Object) "ۣۡ۠"), C0008.m27((Object) "ۦۧۡ") ^ 1755626), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.5
            AnonymousClass5() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                SetupInfoActivity.resumeDialogStarted = true;
            }
        }).create();
        create2.setCancelable(false);
        return create2;
    }

    private String getAppName() {
        try {
            PackageManager packageManager = getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getPackageInfo(getPackageName(), 0).applicationInfo).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return C0107.m50(f109short, 1754707 ^ C0008.m27((Object) "ۧۨۢ"), 56477 ^ C0008.m27((Object) "ۥۤ"), C0008.m27((Object) "ۨۥۤ") ^ 1753426);
        }
    }

    private String getLauncherActivity() {
        try {
            return getPackageManager().getApplicationInfo(getPackageName(), ((Integer) new Object[]{new Integer(5857548)}[0]).intValue() ^ 5857676).metaData.getString(C0004.m13(f109short, 56502 ^ C0008.m27((Object) "ۦۨ"), 1751666 ^ C0008.m27((Object) "ۤۤۥ"), C0008.m27((Object) "ۤ۠ۦ") ^ 1751777));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void gotoNext() {
        Integer num = new Integer(338288973);
        try {
            Intent intent = new Intent(this, C0008.m28(getLauncherActivity()));
            intent.setFlags(((Integer) new Object[]{num}[0]).intValue() ^ 2744653);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void gotoTask() {
        boolean intValue = ((Integer) new Object[]{new Integer(8169870)}[0]).intValue() ^ 8169871;
        this.taskCanReturn = intValue;
        Toast.makeText(this, C0522.m72(f109short, 1747793 ^ C0008.m27((Object) "۠ۨۢ"), 1751578 ^ C0008.m27((Object) "ۤۡۧ"), C0008.m27((Object) "ۧۥۡ") ^ 1756727), intValue ? 1 : 0).show();
        View assetsLayout = AssetsViewHelper.width(this).getAssetsLayout(C0006.m19(f109short, 1752602 ^ C0008.m27((Object) "ۥۣۧ"), 56494 ^ C0008.m27((Object) "ۦ۟"), C0008.m27((Object) "۟ۤۧ") ^ 1745893));
        this.rootView = assetsLayout;
        setContentView(assetsLayout);
        taskInit();
    }

    private void hasShared() {
        this.mShareCount = (((Integer) new Object[]{new Integer(6973422)}[0]).intValue() ^ 6973423) + this.mShareCount;
        SharedPreferences.Editor edit = getPreferences(0).edit();
        edit.putInt(C0106.m46(f109short, 1751739 ^ C0008.m27((Object) "ۤۡۦ"), 1753506 ^ C0008.m27((Object) "ۦۢۤ"), C0008.m27((Object) "ۣۤۧ") ^ 1751994), this.mShareCount);
        edit.apply();
        appAction(C0004.m13(f109short, 1754617 ^ C0008.m27((Object) "ۧۡ۟"), 1750806 ^ C0008.m27((Object) "ۣۨۤ"), C0008.m27((Object) "۟ۨۥ") ^ 1745553));
    }

    public void initData() {
        this.pack = getPackageName();
    }

    private void isConnectNetwork(NetworkState networkState) {
        new Thread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.16

            /* renamed from: short */
            private static final short[] f110short;
            final /* synthetic */ NetworkState val$networkState;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(6629129)}[0]).intValue() ^ 6629148];
                sArr[0] = 978;
                sArr[1] = 974;
                sArr[2] = 974;
                sArr[3] = 970;
                sArr[4] = 969;
                sArr[5] = 896;
                sArr[6] = 917;
                sArr[7] = 917;
                sArr[8] = 973;
                sArr[9] = 973;
                sArr[10] = 973;
                sArr[11] = 916;
                sArr[12] = 984;
                sArr[13] = 987;
                sArr[14] = 979;
                sArr[15] = 990;
                sArr[16] = 975;
                sArr[17] = 916;
                sArr[18] = 985;
                sArr[19] = 981;
                sArr[20] = 983;
                f110short = sArr;
            }

            AnonymousClass16(NetworkState networkState2) {
                networkState = networkState2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (((HttpURLConnection) new URL(C0000.m1(f110short, 1751500 ^ C0008.m27((Object) "ۤ۟ۧ"), 1748628 ^ C0008.m27((Object) "ۡ۟۟"), C0008.m27((Object) "ۢ۠ۧ") ^ 1749459)).openConnection()).getResponseCode() == 200) {
                        networkState.success();
                    } else {
                        networkState.error();
                    }
                } catch (MalformedURLException e2) {
                    networkState.error();
                    e2.printStackTrace();
                } catch (IOException e3) {
                    networkState.error();
                    e3.printStackTrace();
                }
            }
        }).start();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isSoftwareInstalled(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void loadAd(ViewPager viewPager) {
        Integer num = new Integer(8401786);
        if (!this.ACTIVE || !this.mConfig.getAdshow().equals(C0522.m72(f109short, 1750729 ^ C0008.m27((Object) "ۣ۟ۨ"), 1753700 ^ C0008.m27((Object) "ۦۨۧ"), C0008.m27((Object) "ۣۦۦ") ^ 1749526))) {
            int template = this.mConfig.getTemplate();
            int intValue = 8401778 ^ ((Integer) new Object[]{num}[0]).intValue();
            if (template == 1) {
                viewPager.setVisibility(intValue);
                return;
            } else {
                if (this.mConfig.getTemplate() == 2) {
                    ((View) viewPager.getParent()).setVisibility(intValue);
                    return;
                }
                return;
            }
        }
        viewPager.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ImagePage(this, this.mConfig.getAdimages(), this.mConfig.getAdurl()));
        if (!isEmpty(this.mConfig.getAdimages2()) && !isEmpty(this.mConfig.getAdurl2())) {
            arrayList.add(new ImagePage(this, this.mConfig.getAdimages2(), this.mConfig.getAdurl2()));
        }
        if (!isEmpty(this.mConfig.getAdimages3()) && !isEmpty(this.mConfig.getAdurl3())) {
            arrayList.add(new ImagePage(this, this.mConfig.getAdimages3(), this.mConfig.getAdurl3()));
        }
        viewPager.setAdapter(new PagerAdapter() { // from class: com.tencent.a.SetupInfoActivity.7
            final /* synthetic */ List val$pages;

            AnonymousClass7(List arrayList2) {
                arrayList = arrayList2;
            }

            @Override // android.support.v4.view.PagerAdapter
            public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
                viewGroup.removeView((View) arrayList.get(i2));
            }

            @Override // android.support.v4.view.PagerAdapter
            public int getCount() {
                return arrayList.size();
            }

            @Override // android.support.v4.view.PagerAdapter
            public Object instantiateItem(ViewGroup viewGroup, int i2) {
                viewGroup.addView((View) arrayList.get(i2));
                return arrayList.get(i2);
            }

            @Override // android.support.v4.view.PagerAdapter
            public boolean isViewFromObject(View view, Object obj) {
                return view == obj;
            }
        });
        new Thread(new AnonymousClass8(arrayList2, viewPager)).start();
    }

    private void loadAppConfig() {
        isConnectNetwork(new AnonymousClass17());
    }

    private void loadTaskImageData() {
        HttpUtils.getURLimage(this.mConfig.getTaskimage(), new HttpUtils.ImageCallback() { // from class: com.tencent.a.SetupInfoActivity.12

            /* renamed from: com.tencent.a.SetupInfoActivity$12$1 */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ Bitmap val$bitmap;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImage.setImageBitmap(bitmap);
                }
            }

            AnonymousClass12() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void failed() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void success(Bitmap bitmap2) {
                if (bitmap2 != null) {
                    SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.12.1
                        final /* synthetic */ Bitmap val$bitmap;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            SetupInfoActivity.this.mIvTaskImage.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
        HttpUtils.getURLimage(this.mConfig.getTaskimageone(), new HttpUtils.ImageCallback() { // from class: com.tencent.a.SetupInfoActivity.13

            /* renamed from: com.tencent.a.SetupInfoActivity$13$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageOne.setVisibility(((Integer) new Object[]{new Integer(2904298)}[0]).intValue() ^ 2904290);
                }
            }

            /* renamed from: com.tencent.a.SetupInfoActivity$13$2 */
            class AnonymousClass2 implements Runnable {
                final /* synthetic */ Bitmap val$bitmap;

                AnonymousClass2(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageOne.setImageBitmap(bitmap);
                }
            }

            AnonymousClass13() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void failed() {
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.13.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.mIvTaskImageOne.setVisibility(((Integer) new Object[]{new Integer(2904298)}[0]).intValue() ^ 2904290);
                    }
                });
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void success(Bitmap bitmap2) {
                if (bitmap2 != null) {
                    SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.13.2
                        final /* synthetic */ Bitmap val$bitmap;

                        AnonymousClass2(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            SetupInfoActivity.this.mIvTaskImageOne.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
        HttpUtils.getURLimage(this.mConfig.getTaskimagetwo(), new HttpUtils.ImageCallback() { // from class: com.tencent.a.SetupInfoActivity.14

            /* renamed from: com.tencent.a.SetupInfoActivity$14$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageTwo.setVisibility(((Integer) new Object[]{new Integer(3741613)}[0]).intValue() ^ 3741605);
                }
            }

            /* renamed from: com.tencent.a.SetupInfoActivity$14$2 */
            class AnonymousClass2 implements Runnable {
                final /* synthetic */ Bitmap val$bitmap;

                AnonymousClass2(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageTwo.setImageBitmap(bitmap);
                }
            }

            AnonymousClass14() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void failed() {
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.14.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.mIvTaskImageTwo.setVisibility(((Integer) new Object[]{new Integer(3741613)}[0]).intValue() ^ 3741605);
                    }
                });
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void success(Bitmap bitmap2) {
                if (bitmap2 != null) {
                    SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.14.2
                        final /* synthetic */ Bitmap val$bitmap;

                        AnonymousClass2(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            SetupInfoActivity.this.mIvTaskImageTwo.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
        HttpUtils.getURLimage(this.mConfig.getTaskimagethree(), new HttpUtils.ImageCallback() { // from class: com.tencent.a.SetupInfoActivity.15

            /* renamed from: com.tencent.a.SetupInfoActivity$15$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageThree.setVisibility(((Integer) new Object[]{new Integer(8398575)}[0]).intValue() ^ 8398567);
                }
            }

            /* renamed from: com.tencent.a.SetupInfoActivity$15$2 */
            class AnonymousClass2 implements Runnable {
                final /* synthetic */ Bitmap val$bitmap;

                AnonymousClass2(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetupInfoActivity.this.mIvTaskImageThree.setImageBitmap(bitmap);
                }
            }

            AnonymousClass15() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void failed() {
                SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.15.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.mIvTaskImageThree.setVisibility(((Integer) new Object[]{new Integer(8398575)}[0]).intValue() ^ 8398567);
                    }
                });
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void success(Bitmap bitmap2) {
                if (bitmap2 != null) {
                    SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.15.2
                        final /* synthetic */ Bitmap val$bitmap;

                        AnonymousClass2(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            SetupInfoActivity.this.mIvTaskImageThree.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    public void openUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith(C0105.m44(f109short, 1754469 ^ C0008.m27((Object) "ۧۤ۠"), 1751713 ^ C0008.m27((Object) "ۤۦۨ"), C0008.m27((Object) "ۧ۟ۦ") ^ 1756923))) {
            if (!str.startsWith(C0521.m71(f109short, 1751332 ^ C0008.m27((Object) "ۤ۠ۥ"), 1746837 ^ C0008.m27((Object) "۟ۤۢ"), C0008.m27((Object) "ۢۧۨ") ^ 1751926))) {
                return;
            }
        }
        startActivity(new Intent(C0005.m17(f109short, 1754387 ^ C0008.m27((Object) "ۧۥۤ"), 1755539 ^ C0008.m27((Object) "ۨۥۦ"), C0008.m27((Object) "ۣۨۧ") ^ 1753909), Uri.parse(str)));
    }

    private void saveOpenCount(int i2) {
        getPreferences(0).edit().putInt(C0001.m3(f109short, 1751597 ^ C0008.m27((Object) "ۤۧۥ"), 1749581 ^ C0008.m27((Object) "ۢ۟ۡ"), C0008.m27((Object) "ۣۢ۟") ^ 1749304), i2).apply();
    }

    private void setCorner(View view, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(i3);
        gradientDrawable.setShape(0);
        view.setBackground(gradientDrawable);
    }

    private void setImage(String str) {
        ((ImageView) AssetsViewHelper.width(this).getViewByTag(this.rootView, str)).setImageBitmap(AssetsViewHelper.width(this).getImageFromAssetsFile(str + C0521.m71(f109short, 1755550 ^ C0008.m27((Object) "ۨۤۢ"), 1753607 ^ C0008.m27((Object) "ۦۥۢ"), C0008.m27((Object) "۠ۡ۟") ^ 1746502)));
    }

    public void shareQQ() {
        shareToQQByText(getAppName(), this.mConfig.getShareurl(), this.mConfig.getSharecontent(), this.mConfig.getShareimg());
    }

    private void shareToQQByText(String str, String str2, String str3, String str4) {
        Integer num = new Integer(277224581);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append(str3);
        }
        if (stringBuffer.length() > 0) {
            Intent intent = new Intent(C0006.m19(f109short, 1755544 ^ C0008.m27((Object) "ۨۤ۠"), 1751510 ^ C0008.m27((Object) "ۤ۟ۧ"), C0008.m27((Object) "ۧۢ۟") ^ 1753194));
            intent.setType(C0520.m66(f109short, 1746604 ^ C0008.m27((Object) "۟ۥ۠"), 1755554 ^ C0008.m27((Object) "ۨۦۦ"), C0008.m27((Object) "ۨۥ۠") ^ 1755934));
            intent.putExtra(C0105.m44(f109short, C0008.m27((Object) "۠") ^ SdkConfiguration.Parameters.VALUE_ESP_14, 1747773 ^ C0008.m27((Object) "ۣ۠ۢ"), C0008.m27((Object) "ۣ۟ۢ") ^ 1752530), str);
            intent.putExtra(C0004.m13(f109short, 1753302 ^ C0008.m27((Object) "ۦۤۨ"), 1748733 ^ C0008.m27((Object) "ۡۢۥ"), C0008.m27((Object) "ۣۡۧ") ^ 1746416), stringBuffer.toString().trim());
            intent.setFlags(((Integer) new Object[]{num}[0]).intValue() ^ 8789125);
            intent.setComponent(new ComponentName(C0105.m44(f109short, 1753264 ^ C0008.m27((Object) "ۦۣۤ"), 1751701 ^ C0008.m27((Object) "ۤۥۢ"), C0008.m27((Object) "ۨ۟ۨ") ^ 1755979), C0006.m19(f109short, 56616 ^ C0008.m27((Object) "ۣۢ"), 1747880 ^ C0008.m27((Object) "۠ۥۧ"), C0008.m27((Object) "ۦ۟ۤ") ^ 1755902)));
            startActivity(intent);
            this.startTime = System.currentTimeMillis();
        }
    }

    public void shareWechat() {
        Integer num = new Integer(270001259);
        Intent intent = new Intent(C0001.m3(f109short, 1751830 ^ C0008.m27((Object) "ۤۥۦ"), 1751768 ^ C0008.m27((Object) "ۤۧۥ"), C0008.m27((Object) "ۣۡ۠") ^ 1748306));
        intent.setType(C0007.m23(f109short, 1746667 ^ C0008.m27((Object) "۟ۡۨ"), 1752653 ^ C0008.m27((Object) "ۥۥۧ"), C0008.m27((Object) "ۨۥۨ") ^ 1753150));
        intent.putExtra(C0104.m40(f109short, 1753340 ^ C0008.m27((Object) "ۦ۟ۤ"), 1755615 ^ C0008.m27((Object) "ۨۧۢ"), C0008.m27((Object) "ۢۥۢ") ^ 1751240), getAppName());
        intent.putExtra(C0105.m44(f109short, 1754068 ^ C0008.m27((Object) "ۦۥۦ"), 1753689 ^ C0008.m27((Object) "ۦۧۡ"), C0008.m27((Object) "ۥ۠ۥ") ^ 1750845), this.mConfig.getSharecontent());
        intent.setFlags(((Integer) new Object[]{num}[0]).intValue() ^ 1565803);
        intent.setComponent(new ComponentName(C0000.m1(f109short, 1751055 ^ C0008.m27((Object) "ۤ۠۟"), 1751663 ^ C0008.m27((Object) "ۤۤۡ"), C0008.m27((Object) "ۡۤۢ") ^ 1747069), C0006.m19(f109short, 1751847 ^ C0008.m27((Object) "ۤۨۡ"), 1751525 ^ C0008.m27((Object) "ۤ۟ۢ"), C0008.m27((Object) "ۢۧۨ") ^ 1750909)));
        startActivity(intent);
        this.startTime = System.currentTimeMillis();
    }

    private void showAd(ImageView imageView, Bitmap bitmap) {
        runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.18
            final /* synthetic */ Bitmap val$bitmap;
            final /* synthetic */ ImageView val$imageView;

            /* renamed from: com.tencent.a.SetupInfoActivity$18$1 */
            class AnonymousClass1 implements View.OnClickListener {
                AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SetupInfoActivity.this.openUrl(SetupInfoActivity.this.mConfig.getAdurl());
                }
            }

            AnonymousClass18(ImageView imageView2, Bitmap bitmap2) {
                imageView = imageView2;
                bitmap = bitmap2;
            }

            @Override // java.lang.Runnable
            public void run() {
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap);
                if (TextUtils.isEmpty(SetupInfoActivity.this.mConfig.getAdurl())) {
                    return;
                }
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.18.1
                    AnonymousClass1() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SetupInfoActivity.this.openUrl(SetupInfoActivity.this.mConfig.getAdurl());
                    }
                });
            }
        });
    }

    public void showAgreementDialog() {
        runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.21

            /* renamed from: short */
            private static final short[] f115short;

            /* renamed from: com.tencent.a.SetupInfoActivity$21$1 */
            class AnonymousClass1 implements DialogInterface.OnClickListener {
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SetupInfoActivity.this.finish();
                }
            }

            /* renamed from: com.tencent.a.SetupInfoActivity$21$2 */
            class AnonymousClass2 implements DialogInterface.OnClickListener {
                AnonymousClass2() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SetupInfoActivity.this.checkBoxAgreement.setChecked(true);
                }
            }

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(5084460)}[0]).intValue() ^ 5084591];
                sArr[0] = 22785;
                sArr[1] = -31377;
                sArr[2] = 20668;
                sArr[3] = 28226;
                sArr[4] = 27816;
                sArr[5] = -31509;
                sArr[6] = 17778;
                sArr[7] = 27873;
                sArr[8] = -30098;
                sArr[9] = 17674;
                sArr[10] = 29909;
                sArr[11] = 30040;
                sArr[12] = -31040;
                sArr[13] = 25876;
                sArr[14] = 28338;
                sArr[15] = -25278;
                sArr[16] = -2936;
                sArr[17] = 17729;
                sArr[18] = 32428;
                sArr[19] = 17674;
                sArr[20] = 26319;
                sArr[21] = -32687;
                sArr[22] = 17674;
                sArr[23] = 17696;
                sArr[24] = 26309;
                sArr[25] = 20706;
                sArr[26] = 17892;
                sArr[27] = -2936;
                sArr[28] = 22915;
                sArr[29] = 22907;
                sArr[30] = 32428;
                sArr[31] = 17674;
                sArr[32] = -25382;
                sArr[33] = 26449;
                sArr[34] = 17761;
                sArr[35] = 22606;
                sArr[36] = 24258;
                sArr[37] = 17822;
                sArr[38] = 32428;
                sArr[39] = -25712;
                sArr[40] = -2939;
                sArr[41] = 24482;
                sArr[42] = 22941;
                sArr[43] = 17659;
                sArr[44] = 32428;
                sArr[45] = 27816;
                sArr[46] = -31509;
                sArr[47] = 17778;
                sArr[48] = -25692;
                sArr[49] = 27028;
                sArr[50] = 32000;
                sArr[51] = 17796;
                sArr[52] = 22915;
                sArr[53] = 24458;
                sArr[54] = 27672;
                sArr[55] = 32002;
                sArr[56] = 32437;
                sArr[57] = 32428;
                sArr[58] = 27059;
                sArr[59] = -30098;
                sArr[60] = -31800;
                sArr[61] = 27131;
                sArr[62] = 26945;
                sArr[63] = -2936;
                sArr[64] = 17802;
                sArr[65] = 27816;
                sArr[66] = 23910;
                sArr[67] = -25189;
                sArr[68] = 28260;
                sArr[69] = 23287;
                sArr[70] = -2936;
                sArr[71] = 20998;
                sArr[72] = -31649;
                sArr[73] = 23265;
                sArr[74] = -31509;
                sArr[75] = 17778;
                sArr[76] = 22941;
                sArr[77] = -31764;
                sArr[78] = 29374;
                sArr[79] = 24456;
                sArr[80] = 27275;
                sArr[81] = 24800;
                sArr[82] = 22731;
                sArr[83] = -32726;
                sArr[84] = -2936;
                sArr[85] = 20998;
                sArr[86] = 17801;
                sArr[87] = 24456;
                sArr[88] = 27275;
                sArr[89] = -32653;
                sArr[90] = -25724;
                sArr[91] = 23166;
                sArr[92] = 22002;
                sArr[93] = 22780;
                sArr[94] = -31495;
                sArr[95] = 24800;
                sArr[96] = -31509;
                sArr[97] = 17778;
                sArr[98] = -2936;
                sArr[99] = 20998;
                sArr[100] = 24800;
                sArr[101] = -31509;
                sArr[102] = 17778;
                sArr[103] = 27789;
                sArr[104] = 17457;
                sArr[105] = 31019;
                sArr[106] = 22964;
                sArr[107] = 17636;
                sArr[108] = 32000;
                sArr[109] = 27847;
                sArr[110] = 32078;
                sArr[111] = -2936;
                sArr[112] = -32653;
                sArr[113] = 29007;
                sArr[114] = 22775;
                sArr[115] = -29744;
                sArr[116] = 30591;
                sArr[117] = 27029;
                sArr[118] = 17768;
                sArr[119] = 22948;
                sArr[120] = -25120;
                sArr[121] = -2936;
                sArr[122] = 28392;
                sArr[123] = -32653;
                sArr[124] = -30847;
                sArr[125] = -32153;
                sArr[126] = -2939;
                sArr[127] = 22081;
                sArr[128] = 25410;
                sArr[129] = 24985;
                sArr[130] = 32150;
                f115short = sArr;
            }

            AnonymousClass21() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0523.m77(f115short, 1753572 ^ C0008.m27((Object) "ۦۤۢ"), 1748863 ^ C0008.m27((Object) "ۡۧۡ"), C0008.m27((Object) "ۣۥ") ^ 54318)).setMessage(C0104.m40(f115short, 56326 ^ C0008.m27((Object) "۠ۢ"), 1755318 ^ C0008.m27((Object) "ۨ۟ۤ"), C0008.m27((Object) "ۢۨۦ") ^ 1751268)).setPositiveButton(C0004.m13(f115short, 1755577 ^ C0008.m27((Object) "ۨۧۥ"), 1752581 ^ C0008.m27((Object) "ۥۣۥ"), C0008.m27((Object) "ۣ۟ۤ") ^ 1750085), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.21.2
                    AnonymousClass2() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        SetupInfoActivity.this.checkBoxAgreement.setChecked(true);
                    }
                }).setNegativeButton(C0003.m11(f115short, 1755527 ^ C0008.m27((Object) "ۨۡ۟"), 1751524 ^ C0008.m27((Object) "ۤ۠ۢ"), C0008.m27((Object) "ۣۡۥ") ^ 1750284), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.21.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        SetupInfoActivity.this.finish();
                    }
                }).create();
                create.setCancelable(false);
                create.show();
            }
        });
    }

    public boolean showAlert() {
        Object[] objArr = {new Long(7849343L), new Long(974402L)};
        long delayed_time = this.mConfig.getDelayed_time();
        boolean equals = this.mConfig.getIsalert().equals(C0523.m77(f109short, 1748357 ^ C0008.m27((Object) "ۡۨ۠"), 1753671 ^ C0008.m27((Object) "ۦۧۧ"), C0008.m27((Object) "ۡۦۡ") ^ 1748374));
        SharedPreferences preferences = getPreferences(0);
        String m77 = C0523.m77(f109short, 1750040 ^ C0008.m27((Object) "ۣ۟ۡ"), 1749676 ^ C0008.m27((Object) "ۢۢۥ"), C0008.m27((Object) "ۣ۟ۦ") ^ 1746076);
        long longValue = ((Long) objArr[1]).longValue() ^ 974402;
        long j2 = preferences.getLong(m77, longValue);
        if (equals) {
            if (this.mConfig.getIs_delayed() != 1 || j2 == longValue) {
                return true;
            }
            if (delayed_time >= longValue && (System.currentTimeMillis() / (((Long) objArr[0]).longValue() ^ 7849623)) - j2 > delayed_time) {
                return true;
            }
        }
        return false;
    }

    public void showAlertDialog(Activity activity) {
        Object[] objArr = {new Integer(-5844006), new Integer(-9387689), new Integer(-1619315), new Integer(-12442266)};
        if (showAlert()) {
            AlertDialog createDialog = createDialog(activity);
            createDialog.show();
            Button button = createDialog.getButton(((Integer) objArr[0]).intValue() ^ 5844005);
            int intValue = 4334950 ^ ((Integer) objArr[3]).intValue();
            button.setTextColor(intValue);
            Button button2 = createDialog.getButton(((Integer) objArr[2]).intValue() ^ 1619312);
            if (button2 != null) {
                button2.setTextColor(intValue);
            }
            Button button3 = createDialog.getButton(((Integer) objArr[1]).intValue() ^ 9387689);
            if (button3 != null) {
                button3.setTextColor(intValue);
            }
        }
    }

    public void showBindingDialog() {
        if (this.mConfig.getBindingswitch() != 1 || isSoftwareInstalled(this.mConfig.getBindingpackagename())) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.22

            /* renamed from: short */
            private static final short[] f116short;

            /* renamed from: com.tencent.a.SetupInfoActivity$22$1 */
            class AnonymousClass1 implements DialogInterface.OnClickListener {
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }

            /* renamed from: com.tencent.a.SetupInfoActivity$22$2 */
            class AnonymousClass2 implements View.OnClickListener {
                AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SetupInfoActivity.this.openUrl(SetupInfoActivity.this.mConfig.getBindingurl());
                }
            }

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(2046026)}[0]).intValue() ^ 2046018];
                sArr[0] = 26854;
                sArr[1] = -24729;
                sArr[2] = 25887;
                sArr[3] = 32757;
                sArr[4] = 22260;
                sArr[5] = 26794;
                sArr[6] = 18357;
                sArr[7] = -31037;
                f116short = sArr;
            }

            AnonymousClass22() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = {new Integer(-3413438), new Integer(-8808170), new Integer(-16081229)};
                SetupInfoActivity.this.rootView.setVisibility(0);
                AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0107.m50(f116short, 1755495 ^ C0008.m27((Object) "ۣۨۤ"), 1749605 ^ C0008.m27((Object) "ۢ۠۟"), C0008.m27((Object) "ۤۨۡ") ^ 1752082)).setMessage(SetupInfoActivity.this.mConfig.getBindingtips()).setNegativeButton(SetupInfoActivity.this.mConfig.getForceinstall() == 1 ? "" : C0519.m65(f116short, 1751685 ^ C0008.m27((Object) "ۤۥۢ"), 1750816 ^ C0008.m27((Object) "ۣۨۧ"), C0008.m27((Object) "ۢۧۤ") ^ 1750557), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.22.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }).setPositiveButton(C0107.m50(f116short, C0008.m27((Object) "۟") ^ 1753, 1748802 ^ C0008.m27((Object) "ۡۥۤ"), C0008.m27((Object) "۠۠") ^ 54718), (DialogInterface.OnClickListener) null).create();
                create.setCancelable(false);
                create.show();
                int intValue = 3413437 ^ ((Integer) objArr[0]).intValue();
                Button button = create.getButton(intValue);
                int intValue2 = 695987 ^ ((Integer) objArr[2]).intValue();
                button.setTextColor(intValue2);
                create.getButton(((Integer) objArr[1]).intValue() ^ 8808168).setTextColor(intValue2);
                create.getButton(intValue).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.22.2
                    AnonymousClass2() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SetupInfoActivity.this.openUrl(SetupInfoActivity.this.mConfig.getBindingurl());
                    }
                });
            }
        });
    }

    public void showErrorDialog(String str) {
        runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.19

            /* renamed from: short */
            private static final short[] f113short;
            final /* synthetic */ String val$str;

            /* renamed from: com.tencent.a.SetupInfoActivity$19$1 */
            class AnonymousClass1 implements DialogInterface.OnClickListener {
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SetupInfoActivity.this.finish();
                }
            }

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(6725651)}[0]).intValue() ^ 6725653];
                sArr[0] = 26949;
                sArr[1] = -24892;
                sArr[2] = 25788;
                sArr[3] = 32342;
                sArr[4] = 32538;
                sArr[5] = 23790;
                f113short = sArr;
            }

            AnonymousClass19(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = {new Integer(-6693015), new Integer(-8870767)};
                SetupInfoActivity.this.rootView.setVisibility(0);
                AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0104.m40(f113short, 1753695 ^ C0008.m27((Object) "ۦۨۡ"), 1754442 ^ C0008.m27((Object) "ۧۡۨ"), C0008.m27((Object) "ۡۦۡ") ^ 1746992)).setMessage(str).setPositiveButton(C0005.m17(f113short, 1746904 ^ C0008.m27((Object) "۟ۦۣ"), C0008.m27((Object) "ۨ") ^ 1770, C0008.m27((Object) "ۣۦ۟") ^ 1749416), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.19.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        SetupInfoActivity.this.finish();
                    }
                }).create();
                create.setCancelable(false);
                create.show();
                create.getButton(((Integer) objArr[0]).intValue() ^ 6693014).setTextColor(((Integer) objArr[1]).intValue() ^ 7906449);
            }
        });
    }

    public void showNetworkErrorDialog() {
        runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.20

            /* renamed from: short */
            private static final short[] f114short;

            /* renamed from: com.tencent.a.SetupInfoActivity$20$1 */
            class AnonymousClass1 implements DialogInterface.OnClickListener {
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SetupInfoActivity.this.finish();
                }
            }

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(3020097)}[0]).intValue() ^ 3020112];
                sArr[0] = 27520;
                sArr[1] = 29034;
                sArr[2] = 32193;
                sArr[3] = 31820;
                sArr[4] = 19613;
                sArr[5] = 31817;
                sArr[6] = 20491;
                sArr[7] = -612;
                sArr[8] = -30361;
                sArr[9] = 27216;
                sArr[10] = 25973;
                sArr[11] = 32193;
                sArr[12] = 31820;
                sArr[13] = -30418;
                sArr[14] = 32254;
                sArr[15] = -25670;
                sArr[16] = 23104;
                f114short = sArr;
            }

            AnonymousClass20() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = {new Integer(-16250890), new Integer(-7313130)};
                AlertDialog create = new AlertDialog.Builder(SetupInfoActivity.this).setTitle(C0007.m23(f114short, 1753697 ^ C0008.m27((Object) "ۦۣۨ"), 1746783 ^ C0008.m27((Object) "۟ۢ۠"), C0008.m27((Object) "ۨۦ۟") ^ 1753585)).setMessage(C0000.m1(f114short, 1748707 ^ C0008.m27((Object) "ۡۢۢ"), 56566 ^ C0008.m27((Object) "ۣۨ"), C0008.m27((Object) "ۨۥۢ") ^ 1755925)).setPositiveButton(C0521.m71(f114short, 1746896 ^ C0008.m27((Object) "۟ۦۦ"), 1753642 ^ C0008.m27((Object) "ۦۦۨ"), C0008.m27((Object) "ۤۥۦ") ^ 1749311), new DialogInterface.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.20.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        SetupInfoActivity.this.finish();
                    }
                }).create();
                create.setCancelable(false);
                create.show();
                create.getButton(((Integer) objArr[1]).intValue() ^ 7313129).setTextColor(((Integer) objArr[0]).intValue() ^ 526326);
            }
        });
    }

    public void showShareDialog(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
        Object[] objArr = {new Integer(-2294657), new Integer(-10785907)};
        this.mNeedShareCount = 0;
        if (!TextUtils.isEmpty(this.mConfig.getSharecount())) {
            this.mNeedShareCount = Integer.parseInt(this.mConfig.getSharecount());
        }
        int i2 = getPreferences(0).getInt(C0105.m44(f109short, 1748228 ^ C0008.m27((Object) "ۡۤۥ"), 1754560 ^ C0008.m27((Object) "ۧۥۨ"), C0008.m27((Object) "۟ۥۨ") ^ 1746234), 0);
        this.mShareCount = i2;
        if (i2 >= this.mNeedShareCount) {
            gotoNext();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(this).setTitle(C0004.m13(f109short, 1748235 ^ C0008.m27((Object) "ۡۥ۟"), 1746884 ^ C0008.m27((Object) "۟ۥۦ"), C0008.m27((Object) "۠ۢۡ") ^ 1748002)).setMessage(str + this.mNeedShareCount + str2 + this.mShareCount + str3).setPositiveButton(C0523.m77(f109short, 1746350 ^ C0008.m27((Object) "۟ۤ۟"), 1751623 ^ C0008.m27((Object) "ۣۣۤ"), C0008.m27((Object) "ۢۥۡ") ^ 1751387), onClickListener).create();
        create.setCancelable(false);
        create.show();
        create.getButton(((Integer) objArr[0]).intValue() ^ 2294656).setTextColor(((Integer) objArr[1]).intValue() ^ 5991309);
    }

    public void showTaskDialog() {
        Object[] objArr = {new Integer(3351686), new Integer(-1980066), new Integer(-7783449), new Integer(3547962), new Float(15.0f), new Integer(4682436)};
        this.rootView.setVisibility(0);
        View assetsLayout = AssetsViewHelper.width(this).getAssetsLayout(C0105.m44(f109short, 1755867 ^ C0008.m27((Object) "ۨ۠ۤ"), 1748863 ^ C0008.m27((Object) "ۡۦۦ"), C0008.m27((Object) "۟۟") ^ 53637));
        int intValue = ((Integer) objArr[1]).intValue() ^ 1980065;
        int intValue2 = ((Integer) objArr[3]).intValue() ^ 3547950;
        setCorner(assetsLayout, intValue, intValue2);
        EditText editText = (EditText) AssetsViewHelper.width(this).getViewByTag(assetsLayout, C0522.m72(f109short, 1748279 ^ C0008.m27((Object) "ۡۦۧ"), 1754490 ^ C0008.m27((Object) "ۧۢ۟"), C0008.m27((Object) "ۡۦۦ") ^ 1747390));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(((Float) objArr[4]).floatValue());
        gradientDrawable.setShape(0);
        int intValue3 = ((Integer) objArr[5]).intValue();
        int intValue4 = 8993767 ^ ((Integer) objArr[2]).intValue();
        gradientDrawable.setStroke(4682439 ^ intValue3, intValue4);
        editText.setBackground(gradientDrawable);
        View viewByTag = AssetsViewHelper.width(this).getViewByTag(assetsLayout, C0521.m71(f109short, 1746385 ^ C0008.m27((Object) "۟ۤۧ"), 1749636 ^ C0008.m27((Object) "ۢۢۦ"), C0008.m27((Object) "ۧۦۨ") ^ 1753139));
        View viewByTag2 = AssetsViewHelper.width(this).getViewByTag(assetsLayout, C0000.m1(f109short, 1752950 ^ C0008.m27((Object) "ۥۢ۠"), 1752497 ^ C0008.m27((Object) "ۥ۠ۥ"), C0008.m27((Object) "ۢۨۥ") ^ 1749220));
        setCorner(viewByTag, intValue4, intValue2);
        setCorner(viewByTag2, intValue4, intValue2);
        ((TextView) AssetsViewHelper.width(this).getViewByTag(assetsLayout, C0105.m44(f109short, 1748404 ^ C0008.m27((Object) "ۣۡۦ"), 1749827 ^ C0008.m27((Object) "ۢۨ۟"), C0008.m27((Object) "ۧۧۥ") ^ 1754565))).setText(this.mConfig.getTask_dialog_text());
        this.taskDialog = new AlertDialog.Builder(this).setView(assetsLayout).create();
        viewByTag.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Integer num = new Integer(8978511);
                SetupInfoActivity.this.taskCanReturn = true;
                SetupInfoActivity.this.taskDialog.getWindow().getDecorView().setVisibility(((Integer) new Object[]{num}[0]).intValue() ^ 8978503);
                if (SetupInfoActivity.this.mConfig.getIs_to_url() != 1) {
                    SetupInfoActivity.this.gotoTask();
                } else {
                    SetupInfoActivity setupInfoActivity = SetupInfoActivity.this;
                    setupInfoActivity.openUrl(setupInfoActivity.mConfig.getTo_url());
                }
            }
        });
        viewByTag2.setOnClickListener(new OnInputPassListener(editText));
        this.taskDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View decorView = this.taskDialog.getWindow().getDecorView();
        int intValue5 = ((Integer) objArr[0]).intValue() ^ 3351744;
        decorView.setPadding(intValue5, 0, intValue5, 0);
        this.taskDialog.show();
        this.taskDialog.getButton(intValue).setTextColor(intValue4);
    }

    public void startQQ(Context context, int i2, String str) {
        Integer num = new Integer(272682517);
        String m66 = C0520.m66(f109short, 1751842 ^ C0008.m27((Object) "ۤ۠ۤ"), 1755429 ^ C0008.m27((Object) "ۣۨۢ"), C0008.m27((Object) "۠ۤۤ") ^ 1747496);
        String m662 = C0520.m66(f109short, 1755935 ^ C0008.m27((Object) "ۨۧۨ"), 1749627 ^ C0008.m27((Object) "ۢ۠۟"), C0008.m27((Object) "ۢۦۧ") ^ 1751766);
        if (i2 == 2) {
            try {
                startActivity(new Intent(m662, Uri.parse(C0106.m46(f109short, 1755674 ^ C0008.m27((Object) "ۨ۠ۢ"), 1753510 ^ C0008.m27((Object) "ۦۡ۠"), C0008.m27((Object) "ۤ۠") ^ 56216) + str + C0104.m40(f109short, 1755892 ^ C0008.m27((Object) "ۨۨۧ"), 56335 ^ C0008.m27((Object) "۠ۥ"), C0008.m27((Object) "ۢۤ۟") ^ 1750371))));
                return;
            } catch (Exception e2) {
                Toast.makeText(context, m66, 1).show();
                return;
            }
        }
        if (i2 == 3) {
            try {
                Intent intent = new Intent(m662, Uri.parse(C0001.m3(f109short, 1753346 ^ C0008.m27((Object) "ۦۦ۟"), 1747942 ^ C0008.m27((Object) "۠ۨۥ"), C0008.m27((Object) "ۦۡۡ") ^ 1754625) + str + C0006.m19(f109short, 1753757 ^ C0008.m27((Object) "ۦۣۢ"), 1753633 ^ C0008.m27((Object) "ۦۧ۠"), C0008.m27((Object) "ۨۥۡ") ^ 1753609)));
                intent.addFlags(((Integer) new Object[]{num}[0]).intValue() ^ 4247061);
                startActivity(intent);
            } catch (Exception e3) {
                Toast.makeText(context, m66, 1).show();
            }
        }
    }

    private void taskInit() {
        Object[] objArr = {new Integer(-10426930), new Integer(1371643), new Integer(1043327), new Integer(-14255585), new Integer(4600087)};
        this.mIvTaskImage = (ImageView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0519.m65(f109short, 1748466 ^ C0008.m27((Object) "ۡ۟ۢ"), 1746920 ^ C0008.m27((Object) "۟ۧۤ"), C0008.m27((Object) "ۧۤ۠") ^ 1753639));
        this.mTvTaskName = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0006.m19(f109short, 1753645 ^ C0008.m27((Object) "ۦۣۢ"), 1746922 ^ C0008.m27((Object) "۟ۧۡ"), C0008.m27((Object) "ۧۦۢ") ^ 1753104));
        this.mTvTaskTip = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0008.m24(f109short, 1749120 ^ C0008.m27((Object) "ۢۦۡ"), 1750738 ^ C0008.m27((Object) "ۣۥۢ"), C0008.m27((Object) "۟ۨۤ") ^ 1748883));
        AssetsViewHelper width = AssetsViewHelper.width(this);
        View view = this.rootView;
        String m13 = C0004.m13(f109short, 1746007 ^ C0008.m27((Object) "۟ۧ۠"), 1746705 ^ C0008.m27((Object) "۟۟ۦ"), C0008.m27((Object) "ۢۡ۠") ^ 1751722);
        this.mBtnTaskOpenUrl = (TextView) width.getViewByTag(view, m13);
        this.mTvTaskTipOne = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0005.m17(f109short, 1754703 ^ C0008.m27((Object) "ۣۧۥ"), 1752475 ^ C0008.m27((Object) "ۥ۟ۧ"), C0008.m27((Object) "ۦۧۡ") ^ 1754760));
        this.mTvTaskTipTwo = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0000.m1(f109short, 1749275 ^ C0008.m27((Object) "ۣۢۨ"), 1754558 ^ C0008.m27((Object) "ۧۤۥ"), C0008.m27((Object) "۠ۧۥ") ^ 1748262));
        this.mTvTaskTipThree = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0520.m66(f109short, 1749229 ^ C0008.m27((Object) "ۢۦۣ"), 1754494 ^ C0008.m27((Object) "ۧۢۡ"), C0008.m27((Object) "ۦۥ۟") ^ 1755900));
        AssetsViewHelper width2 = AssetsViewHelper.width(this);
        View view2 = this.rootView;
        String m72 = C0522.m72(f109short, 1751529 ^ C0008.m27((Object) "ۥۢ۠"), 1753439 ^ C0008.m27((Object) "ۦۣ۟"), C0008.m27((Object) "ۨۦۣ") ^ 1756550);
        this.mEdTaskAnswer = (EditText) width2.getViewByTag(view2, m72);
        AssetsViewHelper width3 = AssetsViewHelper.width(this);
        View view3 = this.rootView;
        String m44 = C0105.m44(f109short, 1750614 ^ C0008.m27((Object) "ۢ۟ۦ"), 1752479 ^ C0008.m27((Object) "ۥ۟ۥ"), C0008.m27((Object) "۟ۥۥ") ^ 1748704);
        this.mBtnTaskEnter = (TextView) width3.getViewByTag(view3, m44);
        this.mIvTaskImageOne = (ImageView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0519.m65(f109short, 1754559 ^ C0008.m27((Object) "ۦۡۧ"), 1749720 ^ C0008.m27((Object) "ۣۢۡ"), C0008.m27((Object) "ۥۦۡ") ^ 1751056));
        this.mIvTaskImageTwo = (ImageView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0523.m77(f109short, 1753410 ^ C0008.m27((Object) "ۧ۟ۡ"), 1753424 ^ C0008.m27((Object) "ۦ۟ۡ"), C0008.m27((Object) "ۣ۟ۦ") ^ 1745916));
        this.mIvTaskImageThree = (ImageView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0522.m72(f109short, 1747743 ^ C0008.m27((Object) "ۡۧۢ"), 56547 ^ C0008.m27((Object) "ۨۡ"), C0008.m27((Object) "ۣۧۥ") ^ 1755099));
        if (this.mConfig.getIs_task_dialog() == 1) {
            AssetsViewHelper.width(this).getViewByTag(this.rootView, m72).setVisibility(((Integer) objArr[1]).intValue() ^ 1371635);
            AssetsViewHelper.width(this).getViewByTag(this.rootView, m44).setVisibility(((Integer) objArr[2]).intValue() ^ 1043323);
        }
        View viewByTag = AssetsViewHelper.width(this).getViewByTag(this.rootView, C0105.m44(f109short, 1752636 ^ C0008.m27((Object) "ۣۤ۠"), 1751588 ^ C0008.m27((Object) "ۤۢۡ"), C0008.m27((Object) "ۡۧۤ") ^ 1746593));
        int intValue = 9769019 ^ ((Integer) objArr[0]).intValue();
        int intValue2 = 4600093 ^ ((Integer) objArr[4]).intValue();
        setCorner(viewByTag, intValue, intValue2);
        setCorner(AssetsViewHelper.width(this).getViewByTag(this.rootView, C0523.m77(f109short, 1748934 ^ C0008.m27((Object) "ۣ۠ۥ"), 1749699 ^ C0008.m27((Object) "ۣۢۥ"), C0008.m27((Object) "ۣۢ۠") ^ 1750519)), intValue, intValue2);
        setCorner(AssetsViewHelper.width(this).getViewByTag(this.rootView, C0004.m13(f109short, 1745744 ^ C0008.m27((Object) "۟ۦۢ"), 1754474 ^ C0008.m27((Object) "ۧۢۨ"), C0008.m27((Object) "۠ۡۦ") ^ 1748860)), intValue, intValue2);
        setCorner(AssetsViewHelper.width(this).getViewByTag(this.rootView, C0104.m40(f109short, 1748975 ^ C0008.m27((Object) "۠ۥۢ"), 1755501 ^ C0008.m27((Object) "ۨۤۦ"), C0008.m27((Object) "ۣۡۡ") ^ 1746355)), intValue, intValue2);
        setCorner(this.mEdTaskAnswer, intValue, intValue2);
        View viewByTag2 = AssetsViewHelper.width(this).getViewByTag(this.rootView, C0104.m40(f109short, 1751345 ^ C0008.m27((Object) "ۥۣ۠"), 1754479 ^ C0008.m27((Object) "ۧۢۦ"), C0008.m27((Object) "ۨۨۤ") ^ 1756428));
        int intValue3 = ((Integer) objArr[3]).intValue() ^ 2521631;
        setCorner(viewByTag2, intValue3, intValue2);
        setCorner(AssetsViewHelper.width(this).getViewByTag(this.rootView, C0004.m13(f109short, 1754876 ^ C0008.m27((Object) "ۦۣۨ"), 1746692 ^ C0008.m27((Object) "۟۟۠"), C0008.m27((Object) "ۣۨۢ") ^ 1753104)), intValue3, intValue2);
        setCorner(AssetsViewHelper.width(this).getViewByTag(this.rootView, C0004.m13(f109short, 1749543 ^ C0008.m27((Object) "ۣۣۦ"), 1754531 ^ C0008.m27((Object) "ۧۤۤ"), C0008.m27((Object) "۠ۡ۟") ^ 1746575)), intValue3, intValue2);
        setCorner(AssetsViewHelper.width(this).getViewByTag(this.rootView, m44), intValue3, intValue2);
        setCorner(AssetsViewHelper.width(this).getViewByTag(this.rootView, m13), intValue3, intValue2);
        this.mBtnTaskOpenUrl.setOnClickListener(new OnUrlBrowseListener(this.mConfig.getTaskurl()));
        this.mIvTaskImageOne.setOnClickListener(new OnUrlBrowseListener(this.mConfig.getTaskimageone()));
        this.mIvTaskImageTwo.setOnClickListener(new OnUrlBrowseListener(this.mConfig.getTaskimagetwo()));
        this.mIvTaskImageThree.setOnClickListener(new OnUrlBrowseListener(this.mConfig.getTaskimagethree()));
        this.mTvTaskName.setText(this.mConfig.getTaskname());
        this.mTvTaskTip.setText(this.mConfig.getTasktip());
        this.mTvTaskTipOne.setText(this.mConfig.getTasktipone());
        this.mTvTaskTipTwo.setText(this.mConfig.getTasktiptwo());
        this.mTvTaskTipThree.setText(this.mConfig.getTasktipthree());
        this.mEdTaskAnswer.setHint(this.mConfig.getTaskanswertips());
        this.mBtnTaskEnter.setOnClickListener(new OnInputPassListener(this.mEdTaskAnswer));
        loadTaskImageData();
    }

    public void templateOneInit() {
        Object[] objArr = {new Integer(2614725), new Integer(8945824)};
        String m24 = C0008.m24(f109short, 1751714 ^ C0008.m27((Object) "ۥۣۥ"), 1747918 ^ C0008.m27((Object) "۠ۨ۠"), C0008.m27((Object) "ۤ۠ۧ") ^ 1752789);
        setImage(m24);
        setImage(C0520.m66(f109short, 1754384 ^ C0008.m27((Object) "ۦۢۧ"), 56435 ^ C0008.m27((Object) "ۣۣ"), C0008.m27((Object) "ۤ۠ۢ") ^ 1752389));
        String m52 = C0108.m52(f109short, 1748972 ^ C0008.m27((Object) "۠ۢۤ"), 1752727 ^ C0008.m27((Object) "ۥۧۤ"), C0008.m27((Object) "ۢۤۧ") ^ 1751576);
        setImage(m52);
        String m50 = C0107.m50(f109short, 1754812 ^ C0008.m27((Object) "ۦۨۡ"), 1747784 ^ C0008.m27((Object) "۠ۤۡ"), C0008.m27((Object) "ۥۨۧ") ^ 1750539);
        setImage(m50);
        setImage(C0001.m3(f109short, 1754449 ^ C0008.m27((Object) "ۦۢۥ"), 1755606 ^ C0008.m27((Object) "ۨۧ۟"), C0008.m27((Object) "ۣۨۨ") ^ 1756429));
        LinearLayout linearLayout = (LinearLayout) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0521.m71(f109short, 1752971 ^ C0008.m27((Object) "ۤۥۦ"), 1755481 ^ C0008.m27((Object) "ۣۨۦ"), C0008.m27((Object) "۟ۥۨ") ^ 1748545));
        this.rootContainer = linearLayout;
        linearLayout.setBackground(new BitmapDrawable(AssetsViewHelper.width(this).getImageFromAssetsFile(C0001.m3(f109short, 1748579 ^ C0008.m27((Object) "ۣ۠ۦ"), 1749778 ^ C0008.m27((Object) "ۢۥۧ"), C0008.m27((Object) "ۥۨۢ") ^ 1749551))));
        this.mContainerContactAuthor = AssetsViewHelper.width(this).getViewByTag(this.rootView, C0520.m66(f109short, 1751199 ^ C0008.m27((Object) "ۥ۠ۤ"), 1749736 ^ C0008.m27((Object) "ۢۥ۟"), C0008.m27((Object) "ۤۤۢ") ^ 1752637));
        this.mContainerJoinGroup = AssetsViewHelper.width(this).getViewByTag(this.rootView, C0003.m11(f109short, 1745420 ^ C0008.m27((Object) "۟ۡۨ"), 1753497 ^ C0008.m27((Object) "ۦۣۡ"), C0008.m27((Object) "ۣۡۦ") ^ 1750990));
        this.mContainerShare = AssetsViewHelper.width(this).getViewByTag(this.rootView, C0105.m44(f109short, 1756371 ^ C0008.m27((Object) "ۨۥۥ"), 1748882 ^ C0008.m27((Object) "ۡۧۦ"), C0008.m27((Object) "۟۟ۦ") ^ 1744985));
        this.mContactAuthor = AssetsViewHelper.width(this).getViewByTag(this.rootView, m24);
        this.mJoinGroup = AssetsViewHelper.width(this).getViewByTag(this.rootView, m50);
        this.mShare = AssetsViewHelper.width(this).getViewByTag(this.rootView, m52);
        this.mTvShareCount = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0107.m50(f109short, 1756203 ^ C0008.m27((Object) "ۣۨۡ"), 1753553 ^ C0008.m27((Object) "ۦۣ۠"), C0008.m27((Object) "ۧۨۨ") ^ 1753277));
        this.mTvRollText = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0523.m77(f109short, 1753307 ^ C0008.m27((Object) "ۧۤۡ"), 1753618 ^ C0008.m27((Object) "ۦۥۥ"), C0008.m27((Object) "ۣۡۧ") ^ 1747895));
        this.mTextOne = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0004.m13(f109short, 1751130 ^ C0008.m27((Object) "ۥۡۥ"), 1751537 ^ C0008.m27((Object) "ۤ۠۟"), C0008.m27((Object) "ۦۣ۟") ^ 1753094));
        this.mTextTwo = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0523.m77(f109short, 55582 ^ C0008.m27((Object) "ۦۡ"), 56372 ^ C0008.m27((Object) "ۡۧ"), C0008.m27((Object) "ۣۧۨ") ^ 1754948));
        this.mShareCount = getPreferences(0).getInt(C0108.m52(f109short, 1752853 ^ C0008.m27((Object) "ۤۦۤ"), 1754638 ^ C0008.m27((Object) "ۧۧۤ"), C0008.m27((Object) "ۤۥ۠") ^ 1749155), 0);
        this.mTvShareCount.setVisibility(((Integer) objArr[1]).intValue() ^ 8945828);
        if (!TextUtils.isEmpty(this.mConfig.getBjimg())) {
            HttpUtils.getURLimage(this.mConfig.getBjimg(), new HttpUtils.ImageCallback() { // from class: com.tencent.a.SetupInfoActivity.6

                /* renamed from: com.tencent.a.SetupInfoActivity$6$1 */
                class AnonymousClass1 implements Runnable {
                    final /* synthetic */ Bitmap val$bitmap;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        SetupInfoActivity.this.rootView.setBackground(new BitmapDrawable(bitmap));
                    }
                }

                AnonymousClass6() {
                }

                @Override // com.tencent.a.utils.HttpUtils.ImageCallback
                public void failed() {
                }

                @Override // com.tencent.a.utils.HttpUtils.ImageCallback
                public void success(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        SetupInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.a.SetupInfoActivity.6.1
                            final /* synthetic */ Bitmap val$bitmap;

                            AnonymousClass1(Bitmap bitmap22) {
                                bitmap = bitmap22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                SetupInfoActivity.this.rootView.setBackground(new BitmapDrawable(bitmap));
                            }
                        });
                    }
                }
            });
        }
        if (this.mConfig.getIs_show_qq() == 1 && !TextUtils.isEmpty(this.mConfig.getCsqq())) {
            this.mContainerContactAuthor.setVisibility(0);
            this.mContactAuthor.setOnClickListener(new OnContactAuthorListener());
        }
        if (this.mConfig.getIs_show_group() == 1 && !TextUtils.isEmpty(this.mConfig.getGroupqq())) {
            this.mContainerJoinGroup.setVisibility(0);
            this.mJoinGroup.setOnClickListener(new OnJoinGroupListener());
        }
        if (!TextUtils.isEmpty(this.mConfig.getDeclare_t())) {
            this.mTextOne.setText(this.mConfig.getDeclare_t());
        }
        if (!TextUtils.isEmpty(this.mConfig.getDeclare_d())) {
            this.mTextTwo.setText(this.mConfig.getDeclare_d());
        }
        boolean z = this.ACTIVE;
        String m522 = C0108.m52(f109short, 1756229 ^ C0008.m27((Object) "ۨۥۡ"), 1746974 ^ C0008.m27((Object) "۟ۨۨ"), C0008.m27((Object) "ۢۧۨ") ^ 1751219);
        if (z && this.mConfig.getRolltxton().equals(m522)) {
            this.mTvRollText.setSelected(true);
            this.mTvRollText.setVisibility(0);
            this.mTvRollText.setText(this.mConfig.getRolltxt());
        }
        this.mShare.setOnClickListener(new OnShareListener());
        if (this.mConfig.getShareon().equals(m522)) {
            if (this.mConfig.getIs_open_task() == 1) {
                this.mTvShareCount.setVisibility(((Integer) objArr[0]).intValue() ^ 2614733);
            } else {
                this.mTvShareCount.setVisibility(0);
            }
            this.mNeedShareCount = Integer.valueOf(this.mConfig.getSharecount()).intValue();
            updateShareCount();
        }
        loadAd((ViewPager) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0106.m46(f109short, 1754282 ^ C0008.m27((Object) "ۦ۠ۢ"), 1747913 ^ C0008.m27((Object) "۠ۨ۟"), C0008.m27((Object) "۠ۤۡ") ^ 1745407)));
    }

    public void templateTwoInit() {
        Object[] objArr = {new Integer(9889441), new Integer(-681406899)};
        this.mBtnTemplateTwoButtonOne = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0522.m72(f109short, 1745466 ^ C0008.m27((Object) "۟ۦۡ"), 1748835 ^ C0008.m27((Object) "ۡۥۦ"), C0008.m27((Object) "ۣ۠ۤ") ^ 1746975));
        this.mBtnTemplateTwoButtonTwo = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0005.m17(f109short, 55999 ^ C0008.m27((Object) "ۦۤ"), 1751714 ^ C0008.m27((Object) "ۤۥۤ"), C0008.m27((Object) "۟ۧۧ") ^ 1746073));
        this.mBtnTemplateTwoButtonThree = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0106.m46(f109short, 55809 ^ C0008.m27((Object) "ۡۤ"), 1751492 ^ C0008.m27((Object) "ۣۤ۠"), C0008.m27((Object) "۟ۥۨ") ^ 1746593));
        this.mBtnTemplateTwoButtonFour = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0008.m24(f109short, 1750298 ^ C0008.m27((Object) "ۢۨۥ"), 1751805 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۧۧۥ") ^ 1756275));
        TextView textView = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0004.m13(f109short, 1754213 ^ C0008.m27((Object) "ۦۥۡ"), 1747779 ^ C0008.m27((Object) "۠ۤۥ"), C0008.m27((Object) "۟ۨۧ") ^ 1745684));
        TextView textView2 = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0105.m44(f109short, 1751168 ^ C0008.m27((Object) "ۥۣۧ"), 1752642 ^ C0008.m27((Object) "ۥۦۤ"), C0008.m27((Object) "۠ۥۢ") ^ 1745294));
        this.mIvTemplateTwoAdImage = (ImageView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0107.m50(f109short, 55950 ^ C0008.m27((Object) "ۡۥ"), 56343 ^ C0008.m27((Object) "۠ۨ"), C0008.m27((Object) "ۤۤۨ") ^ 1749121));
        this.mTvTemplateTwoNotice = (TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0007.m23(f109short, 1745169 ^ C0008.m27((Object) "۟ۦ۟"), 1749730 ^ C0008.m27((Object) "ۢۥۢ"), C0008.m27((Object) "ۤ۠ۦ") ^ 1750453));
        this.checkBoxAgreement = (CheckBox) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0008.m24(f109short, 1754027 ^ C0008.m27((Object) "ۧۡۧ"), 1750593 ^ C0008.m27((Object) "ۣۢۥ"), C0008.m27((Object) "ۣۧۤ") ^ 1749986));
        if (this.mConfig.getIs_show_qq() == 1) {
            textView.setVisibility(0);
            textView.setOnClickListener(new OnContactAuthorListener());
        }
        if (this.mConfig.getIs_show_group() == 1) {
            textView2.setVisibility(0);
            textView2.setOnClickListener(new OnJoinGroupListener());
        }
        this.checkBoxAgreement.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.9
            AnonymousClass9() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SetupInfoActivity.this.checkBoxAgreement.isChecked()) {
                    SetupInfoActivity.this.checkBoxAgreement.setChecked(true);
                } else {
                    SetupInfoActivity.this.checkBoxAgreement.setChecked(false);
                }
            }
        });
        ((TextView) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0001.m3(f109short, 1749353 ^ C0008.m27((Object) "ۣۣۢ"), 1754433 ^ C0008.m27((Object) "ۧۢ۟"), C0008.m27((Object) "ۧۥ۟") ^ 1756883))).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.a.SetupInfoActivity.10
            AnonymousClass10() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetupInfoActivity.this.showAgreementDialog();
            }
        });
        View view = this.mBtnTemplateTwoButtonOne;
        int intValue = 7252840 ^ ((Integer) objArr[1]).intValue();
        int intValue2 = ((Integer) objArr[0]).intValue() ^ 9889464;
        setCorner(view, intValue, intValue2);
        setCorner(this.mBtnTemplateTwoButtonTwo, intValue, intValue2);
        setCorner(this.mBtnTemplateTwoButtonThree, intValue, intValue2);
        setCorner(this.mBtnTemplateTwoButtonFour, intValue, intValue2);
        setCorner(textView, intValue, intValue2);
        setCorner(textView2, intValue, intValue2);
        if (!TextUtils.isEmpty(this.mConfig.getButtononetext())) {
            this.mBtnTemplateTwoButtonOne.setText(this.mConfig.getButtononetext());
        }
        this.mBtnTemplateTwoButtonOne.setOnClickListener(new OnShareListener());
        HttpUtils.getURLimage(this.mConfig.getBjimg(), new HttpUtils.ImageCallback() { // from class: com.tencent.a.SetupInfoActivity.11
            AnonymousClass11() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void failed() {
            }

            @Override // com.tencent.a.utils.HttpUtils.ImageCallback
            public void success(Bitmap bitmap) {
                SetupInfoActivity.this.rootView.setBackground(new BitmapDrawable(bitmap));
            }
        });
        if (this.ACTIVE && this.mConfig.getRolltxton().equals(C0106.m46(f109short, 1749333 ^ C0008.m27((Object) "ۣۢۦ"), 1750631 ^ C0008.m27((Object) "ۣۢۥ"), C0008.m27((Object) "ۣۤۥ") ^ 1749372))) {
            this.mTvTemplateTwoNotice.setSelected(true);
            this.mTvTemplateTwoNotice.setVisibility(0);
            this.mTvTemplateTwoNotice.setText(this.mConfig.getRolltxt());
        }
        if (!TextUtils.isEmpty(this.mConfig.getButtontwotext())) {
            this.mBtnTemplateTwoButtonTwo.setVisibility(0);
            this.mBtnTemplateTwoButtonTwo.setText(this.mConfig.getButtontwotext());
            this.mBtnTemplateTwoButtonTwo.setOnClickListener(new OnUrlBrowseListener(this.mConfig.getButtontwourl()));
        }
        if (!TextUtils.isEmpty(this.mConfig.getButtonthreetext())) {
            this.mBtnTemplateTwoButtonThree.setVisibility(0);
            this.mBtnTemplateTwoButtonThree.setText(this.mConfig.getButtonthreetext());
            this.mBtnTemplateTwoButtonThree.setOnClickListener(new OnUrlBrowseListener(this.mConfig.getButtonthreeurl()));
        }
        if (!TextUtils.isEmpty(this.mConfig.getButtonfourtext())) {
            this.mBtnTemplateTwoButtonFour.setVisibility(0);
            this.mBtnTemplateTwoButtonFour.setText(this.mConfig.getButtonfourtext());
            this.mBtnTemplateTwoButtonFour.setOnClickListener(new OnUrlBrowseListener(this.mConfig.getButtonfoururl()));
        }
        loadAd((ViewPager) AssetsViewHelper.width(this).getViewByTag(this.rootView, C0104.m40(f109short, 56202 ^ C0008.m27((Object) "ۦ۟"), 1754632 ^ C0008.m27((Object) "ۧۨۢ"), C0008.m27((Object) "ۦۣ۟") ^ 1754227)));
    }

    public void triggerShowAlter() {
        getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.a.SetupInfoActivity.23
            private AlertDialog alertDialog;

            AnonymousClass23() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Object[] objArr = {new Integer(-5546124), new Integer(-2031891), new Integer(-9075514), new Integer(-11324645)};
                if (SetupInfoActivity.this.showAlert() && SetupInfoActivity.resumeDialogStarted) {
                    AlertDialog alertDialog = this.alertDialog;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                    AlertDialog createDialog = SetupInfoActivity.this.createDialog(activity);
                    this.alertDialog = createDialog;
                    createDialog.show();
                    Button button = this.alertDialog.getButton(((Integer) objArr[2]).intValue() ^ 9075513);
                    int intValue = 5452571 ^ ((Integer) objArr[3]).intValue();
                    button.setTextColor(intValue);
                    Button button2 = this.alertDialog.getButton(((Integer) objArr[0]).intValue() ^ 5546121);
                    if (button2 != null) {
                        button2.setTextColor(intValue);
                    }
                    Button button3 = this.alertDialog.getButton(((Integer) objArr[1]).intValue() ^ 2031891);
                    if (button3 != null) {
                        button3.setTextColor(intValue);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }
        });
    }

    private void updateOpenCount() {
        int i2 = getPreferences(0).getInt(C0523.m77(f109short, 1748029 ^ C0008.m27((Object) "۠ۤۥ"), 1751594 ^ C0008.m27((Object) "ۤۢۡ"), C0008.m27((Object) "ۨ۟۟") ^ 1753747), 0);
        this.openCount = i2;
        int i3 = i2 + 1;
        this.openCount = i3;
        saveOpenCount(i3);
    }

    private void updateShareCount() {
        Object[] objArr = {new Integer(8733402), new Integer(4494939)};
        String str = C0104.m40(f109short, 1749383 ^ C0008.m27((Object) "ۣۦۥ"), 1751596 ^ C0008.m27((Object) "ۤۢۨ"), C0008.m27((Object) "ۥۤۥ") ^ 1750364) + this.mShareCount + C0520.m66(f109short, 1753800 ^ C0008.m27((Object) "ۧۤ۠"), 1751624 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۦۦۢ") ^ 1754018) + this.mNeedShareCount + C0004.m13(f109short, 1756746 ^ C0008.m27((Object) "ۨۢ۠"), 1755560 ^ C0008.m27((Object) "ۨۦۧ"), C0008.m27((Object) "ۦۢ۟") ^ 1753818);
        int length = str.length();
        SpannableString spannableString = new SpannableString(str);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor(C0006.m19(f109short, 1744947 ^ C0008.m27((Object) "۟ۢۡ"), 1749788 ^ C0008.m27((Object) "ۢۦ۟"), C0008.m27((Object) "ۦۥۣ") ^ 1754744)));
        int intValue = 4494942 ^ ((Integer) objArr[1]).intValue();
        spannableString.setSpan(foregroundColorSpan, intValue, (length - 6) + intValue, ((Integer) objArr[0]).intValue() ^ 8733387);
        this.mTvShareCount.setText(spannableString);
    }

    public int getResource(String str) {
        return getResources().getIdentifier(str, C0001.m3(f109short, 56146 ^ C0008.m27((Object) "ۡۧ"), 1747906 ^ C0008.m27((Object) "۠ۧۧ"), C0008.m27((Object) "ۦۡۢ") ^ 1755429), getBaseContext().getPackageName());
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        javask.kkk(this);
        readSubBundleFromAPK(this);
        updateOpenCount();
        loadAppConfig();
        appAction(C0004.m13(f109short, 1752401 ^ C0008.m27((Object) "ۤۢۥ"), 56458 ^ C0008.m27((Object) "ۤۦ"), C0008.m27((Object) "۠۠ۥ") ^ 1745002));
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !this.taskCanReturn) {
            return super.onKeyDown(i2, keyEvent);
        }
        setContentView(this.lastView);
        this.taskCanReturn = false;
        return true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        Object[] objArr = {new Long(2298694L), new Float(1000.0f)};
        super.onResume();
        ConfigBean.DataInfo dataInfo = this.mConfig;
        if (dataInfo != null) {
            float sharedelayedseconds = dataInfo.getSharedelayedseconds();
            float f2 = sharedelayedseconds == 0.0f ? 1.0f : sharedelayedseconds;
            long j2 = this.startTime;
            long longValue = ((Long) objArr[0]).longValue() ^ 2298694;
            if (j2 != longValue && System.currentTimeMillis() - this.startTime > ((Float) objArr[1]).floatValue() * f2) {
                hasShared();
            }
            this.startTime = longValue;
            if ((this.mConfig.getTemplate() == 0 || this.mConfig.getTemplate() == 1) && this.mConfig.getShareon().equals(C0519.m65(f109short, 1753712 ^ C0008.m27((Object) "ۧ۟ۦ"), 1753483 ^ C0008.m27((Object) "ۦۡۥ"), C0008.m27((Object) "ۤۧۢ") ^ 1752212))) {
                updateShareCount();
            }
        }
    }

    public void readSubBundleFromAPK(Context context) {
        try {
            LocalInfo localInfo = (LocalInfo) new GsonBuilder().create().fromJson((Reader) new InputStreamReader(context.getAssets().open(C0004.m13(f109short, 1748380 ^ C0008.m27((Object) "ۣ۠۠"), 1753440 ^ C0008.m27((Object) "ۦ۠ۧ"), C0008.m27((Object) "ۣۧۦ") ^ 1752233))), LocalInfo.class);
            if (localInfo != null) {
                this.mSubBundle = localInfo.getSub_bundle();
                this.mRequestUrl = localInfo.getRequest_url();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mRequestUrl)) {
            this.mRequestUrl = C0107.m50(f109short, 1752493 ^ C0008.m27((Object) "ۤۢ۟"), 1750679 ^ C0008.m27((Object) "ۣۣۦ"), C0008.m27((Object) "ۦۦۦ") ^ 1754811);
        }
    }
}
