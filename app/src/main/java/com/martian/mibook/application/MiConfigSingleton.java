package com.martian.mibook.application;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.bj;
import com.bytedance.hume.readapk.HumeSDK;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.maritan.libweixin.c;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaseAd;
import com.martian.apptask.data.AppTask;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.libmars.d.h;
import com.martian.libmars.utils.k0;
import com.martian.libqq.QQAPIInstance;
import com.martian.libsliding.slider.SimSlider;
import com.martian.libugrowth.data.UpgradeInfo;
import com.martian.libugrowth.request.CheckUpgradeParams;
import com.martian.mibook.account.MiCompoundUserManager;
import com.martian.mibook.account.request.auth.BookSyncInfoParams;
import com.martian.mibook.activity.EnterActivity;
import com.martian.mibook.activity.EnterRestartActivity;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.client.SplashSwitchClient;
import com.martian.mibook.data.MiBookIdItem;
import com.martian.mibook.data.MiOptions;
import com.martian.mibook.j.v2;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import com.martian.mibook.lib.account.request.auth.UserCommentParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.model.InterfaceAdapter;
import com.martian.mibook.lib.model.data.BookWrapperList;
import com.martian.mibook.lib.model.data.MiBookShelfItemList;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.MiTheme;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mipush.data.PushChannelInfo;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.SdkConfiguration;
import com.martian.ttbookhd.R;
import com.qq.e.comm.managers.GDTAdSdk;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.vivo.mobilead.manager.VInitCallback;
import com.vivo.mobilead.manager.VivoAdManager;
import com.vivo.mobilead.model.VAdConfig;
import com.vivo.mobilead.model.VCustomController;
import com.vivo.mobilead.model.VLocation;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.wbl.ad.yzz.config.AdInitialize;
import com.wbl.ad.yzz.config.IAdEventListener;
import com.wbl.ad.yzz.config.IEventAd;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class MiConfigSingleton extends com.martian.mibook.lib.model.a implements Application.ActivityLifecycleCallbacks {
    public static final String A0;
    public static final int A1 = 1018;
    public static final int A2 = 300;
    public static final String A3 = "TYPEFACE_DIRECTORY_RECORE";
    private static final String A4 = "TestDefaultAd";
    public static final String B0;
    public static final int B1 = 1019;
    public static final int B2 = 100000;
    public static final String B3 = "ADD_BOOK_KNOWN";
    private static final String B4 = "TestVivoAd";
    public static final String C0 = "CurrentUrl";
    public static final int C1 = 1020;
    public static final int C2 = 1001;
    public static final String C3 = "BOOK_VIEW_MODE";
    private static final String C4 = "TestOppoAd";
    public static final String D0 = "SourceName";
    public static final int D1 = 1021;
    public static final int D2 = 1000;
    private static final String D3 = "PREF_EXIT_BOOK_STORE_CATEGORY_POSITION";
    private static final String D4 = "PREF_ACCOUNT_CREATE_ON";
    public static final int E1 = 1022;
    public static final int E2 = 1001;
    private static final String E3 = "PREF_EXIT_BOOK_STORE_CATEGORY";
    public static final String F0 = "SourceId";
    public static final int F1 = 1023;
    public static final int F2 = 1002;
    private static final String F3 = "close_game_center_pref_key";
    public static final String G0 = "intent_source_string";
    public static final int G1 = 1024;
    public static final int G2 = 1003;
    private static final String G3 = "PREF_REVERSE_DIR_ORDER";
    public static final String H0 = "intent_content_property";
    public static final int H1 = 1025;
    public static final int H2 = 1004;
    public static final String H3 = "pref_weixin_shared";
    public static final String I0 = "BookId";
    public static final int I1 = 10024;
    public static final int I2 = 1005;
    private static final String I3 = "PREF_REMOVE_ADS_TIME";
    public static final String J0 = "BookCover";
    public static final int J1 = 10025;
    private static final String J2 = "PREF_RECEIVED_REDPAPER_NOTIFY";
    private static final String J3 = "PREF_HAS_INVITER";
    public static final String K0 = "intent_search_engine_index";
    public static final int K1 = 10026;
    private static final String K2 = "RECEIVED_CAN_SHOW_TUIA";
    private static final String K3 = "PREF_LAST_SYNC_TIME";
    public static final String L0 = "BookName";
    public static final int L1 = 199;
    private static final String L2 = "BONUS_POLL_CHECKINED";
    private static final String L3 = "PREF_NOTIFICATION_LAST_SYNC_TIME";
    public static final String M0 = "intent_reading_chapter_index";
    public static final int M1 = 200;
    private static final String M2 = "RECEIVED_RANDOM_THEME";
    private static final String M3 = "PREF_NOTIFICATION_SETTING_ENABLE";
    public static final String N0 = "intent_author";
    public static final int N1 = 201;
    private static final String N2 = "BOOKRACK_INITIALED";
    public static final String N3 = "pref_gender";
    public static final String O0 = "intent_seed";
    public static final int O1 = 202;
    private static final String O2 = "BOOKRACK_INITIALED_TIME";
    public static final String O3 = "pref_book_mall_gender";
    public static final String P0 = "intent_search_keyword";
    public static final int P1 = 203;
    private static final String P2 = "BOOKRACK_BOODS_RECOMMEND";
    public static final int P3 = 1;
    public static final String Q0 = "intent_yw_free_type";
    public static final int Q1 = 204;
    private static final String Q2 = "TTBOOK_BLACK_DEVICE_CHECK_RUN_TIMES";
    public static final int Q3 = 2;
    public static final String R0 = "intent_yw_category";
    public static final int R1 = 210;
    public static final String R2 = "mibookid.json";
    public static final String R3 = "pref_gender_confirm";
    public static final String S0 = "intent_yw_sub_category_id";
    public static final int S1 = 205;
    public static final String S2 = "pref_screen_orientation";
    public static final String S3 = "pref_gender_guide";
    public static final String T0 = "intent_yw_category_title";
    public static final int T1 = 202;
    public static final String T2 = "pref_init_imei";
    public static final int T3 = 10;
    public static final String U0 = "intent_yw_channel_mcid";
    public static final int U1 = 203;
    public static final String U2 = "pref_brightness_value";
    public static final String U3 = "qrcode_share_link";
    public static final String V0 = "intent_yw_channel_seed";
    public static final int V1 = 0;
    public static final String V2 = "pref_system_brightness";
    private static final String V3 = "PREF_CHECKIN_STATUS";
    public static final String W0 = "intent_yw_channel_title";
    public static final int W1 = 1;
    public static final String W2 = "pref_screen_timeout";
    public static final int W3 = 0;
    public static final String X0 = "intent_yw_channel_page_index";
    public static final int X1 = 2;
    public static final String X2 = "pref_book_active_time";
    public static final int X3 = 1;
    public static final String Y0 = "intent_yw_channel_ext";
    public static final int Y1 = 3;
    public static final String Y2 = "pref_ads_hide_timeout";
    private static final String Y3 = "PREF_RECHARGE_TYPE";
    public static final int Z0 = 199;
    public static final int Z1 = 4;
    public static final String Z2 = "pref_ads_dialog_last_time";
    private static final String Z3 = "PREF_SHOW_WEALTH_STATUS";
    public static final int a1 = 200;
    public static final int a2 = 5;
    public static final String a3 = "pref_auto_read_ads_timeout";
    public static final String a4 = "BIND_USER_DEVICE_TTBOOK";
    public static final int b1 = 201;
    public static final int b2 = 6;
    public static final String b3 = "pref_auto_slide_timeout";
    public static final String b4 = "VIDEO_ADS_COUNT_TTBOOK";
    public static final int c1 = 202;
    public static final int c2 = 7;
    public static final String c3 = "pref_bookrack_ads_hide_timeout";
    public static final String c4 = "VIDEO_ADS_TIME_TTBOOK";
    public static final int d1 = 203;
    public static final int d2 = 8;
    public static final String d3 = "PREF_SLIDER_CACHE_ENABLE";
    public static final String d4 = "ttbook_pref_alipay_install";
    public static final int e1 = 204;
    public static final int e2 = 9;
    public static final String e3 = "PREF_SLIDER_CLICK_SCROLL_ENABLE";
    public static final String e4 = "ttbook_pref_type_withdraw";
    public static final int f1 = 205;
    public static final int f2 = 10;
    public static final String f3 = "pref_reading_slider";
    public static final String f4 = "ttbook_pref_qplay_mission_status";
    public static final int g1 = 206;
    public static final int g2 = 11;
    public static final int g3 = 1;
    public static final String g4 = "MISSION_ITEM_WATCH_VIDEO";
    public static final int h1 = 207;
    public static final int h2 = 13;
    public static final int h3 = 4;
    private static final String h4 = "LAST_AUTHOR_VIDEO_SHOW_TIME";
    public static final int i1 = 1000;
    public static final int i2 = 15;
    public static final int i3 = 0;
    private static final String i4 = "pref_bookshelf_changed";
    public static final int j1 = 1001;
    public static final int j2 = 16;
    public static final int j3 = 2;
    private static final String j4 = "pref_midong_loaded_today";
    public static final int k1 = 1002;
    public static final int k2 = 17;
    public static final int k3 = 3;
    private static final String k4 = "ADS_VIDEO_CLOSE_TIMES";
    public static final int l1 = 1003;
    public static final int l2 = 2000;
    public static final String l3 = "pref_teenager_mode";
    private static final String l4 = "pref_bad_article_books";
    public static final int m1 = 1004;
    public static final int m2 = 2001;
    private static final String m3 = "dontshowagain";
    private static final String m4 = "gategory_new_pwd";
    public static final int n1 = 1005;
    public static final int n2 = 2002;
    private static final String n3 = "apprater";
    private static final String n4 = "pref_duration_upgrade_user";
    public static final int o1 = 1006;
    public static final int o2 = 2008;
    private static final String o3 = "pref_checkin_notify";
    private static final String o4 = "NOTIFICATION_STATUS";
    public static final int p1 = 1007;
    public static final int p2 = 101;
    private static final String p3 = "PREF_IREADER_BIND";
    private static final String p4 = "MONEY_WITHDRAW_WATCH_VIDEO";
    public static final int q1 = 1008;
    public static final int q2 = 102;
    private static final String q3 = "launch_count";
    private static final String q4 = "IS_READINGACTIVITY_DESTORY";
    public static final int r1 = 1009;
    public static final int r2 = 103;
    public static final String r3 = "FAB_READING_MODE";
    private static final String r4 = "PREF_BOOKRACK_RIGHT_MISSION_INDEX";
    public static final String s0 = "novels";
    public static final int s1 = 1010;
    public static final int s2 = 106;
    public static final String s3 = "PREF_PUSH_CHECKED_INDEX";
    private static final String s4 = "TestTTAd";
    public static final String t0 = "data";
    public static final int t1 = 1011;
    public static final int t2 = 107;
    private static final String t3 = "pref_share";
    private static final String t4 = "TestGDTAd";
    public static final String u0 = "image";
    public static final int u1 = 1012;
    public static final int u2 = 108;
    public static final String u3 = "pref_fontsize";
    private static final String u4 = "TestBaeAd";
    public static final String v0 = "backup";
    public static final int v1 = 1013;
    public static final int v2 = 110;
    public static final String v3 = "PREF_AUDO_SLIDE_SPEED";
    private static final String v4 = "TestDxAd";
    public static final String w0;
    public static final int w1 = 1014;
    public static final int w2 = 111;
    private static final String w3 = "PREF_TTS_SPEED";
    private static final String w4 = "TestMiAd";
    public static final String x0;
    public static final int x1 = 1015;
    public static final int x2 = 200;
    private static final String x3 = "pref_line_spacing_multiplier";
    private static final String x4 = "TestHwAd";
    public static final String y0;
    public static final int y1 = 1016;
    public static final int y2 = 201;
    public static final String y3 = "DIRECTORY_RECORE";
    private static final String y4 = "TestKsAd";
    public static final String z0;
    public static final int z1 = 1017;
    public static final int z2 = 202;
    public static final String z3 = "TYPEFACE_SYSTEM_DEFAULT";
    private static final String z4 = "TestApiAd";
    private int B5;
    private MiBookManager E4;
    public MiSearchManager F4;
    private n0 G4;
    public q0 H4;
    public t0 I4;
    public MiReaderThemeManager J4;
    private Boolean J5;
    private p0 K4;
    public o0 L4;
    private int L5;
    public MiCompoundUserManager M4;
    public g0 N4;
    private Boolean N5;
    private w0 O4;
    private boolean O5;
    private AdxManager P4;
    private Boolean P5;
    private boolean d5;
    private boolean e5;
    private boolean f5;
    private boolean g5;
    private boolean h5;
    private boolean i5;
    private boolean j5;
    private boolean k5;
    private boolean l5;
    private boolean m5;
    private SparseBooleanArray o5;
    private Boolean t5;
    public boolean Q4 = false;
    public boolean R4 = false;
    public boolean S4 = false;
    public boolean T4 = false;
    public boolean U4 = false;
    public boolean V4 = false;
    public boolean W4 = false;
    public boolean X4 = false;
    public boolean Y4 = false;
    public boolean Z4 = false;
    public boolean a5 = false;
    private int b5 = 0;
    private long c5 = -1;
    private long n5 = -1;
    private long p5 = -100;
    private long q5 = -1;
    private long r5 = -1;
    private long s5 = -1;
    private long u5 = -1;
    private boolean v5 = true;
    private int w5 = -1;
    private int x5 = -1;
    private int y5 = -1;
    private int z5 = -1;
    private final List<AppTask> A5 = new LinkedList();
    private long C5 = -1;
    private long D5 = -1;
    public final String[] E5 = {"小说", "追书", "阅读", com.martian.mibook.lib.model.manager.d.f14056h, "全本", "搜书"};
    private long F5 = -1;
    private boolean G5 = false;
    private final String H5 = "pref_need_user_active";
    private final String I5 = "pref_user_active_sec";
    private int K5 = -1;
    private int M5 = -1;

    class a implements QQAPIInstance.QQShareReceiver {
        a() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int errcode, String errStr) {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String shareResult) {
        }
    }

    class b implements QQAPIInstance.QQShareReceiver {
        b() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int errcode, String errStr) {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String shareResult) {
        }
    }

    class c implements c.f {

        /* renamed from: a */
        final /* synthetic */ Activity f11308a;

        c(final Activity val$activity) {
            this.f11308a = val$activity;
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            com.martian.mibook.lib.model.g.b.e(this.f11308a, "shared", "friends");
            MiConfigSingleton.this.u6(true);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class d implements c.f {
        d() {
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            MiConfigSingleton.this.u6(true);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class e implements c.f {
        e() {
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            MiConfigSingleton.this.u6(true);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class f implements c.f {
        f() {
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            MiConfigSingleton.this.u6(true);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class g implements c.f {
        g() {
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            MiConfigSingleton.this.u6(true);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class h implements c.f {
        h() {
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            MiConfigSingleton.this.u6(true);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class i implements c.f {

        /* renamed from: a */
        final /* synthetic */ long f11315a;

        i(final long val$redpaperTime) {
            this.f11315a = val$redpaperTime;
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            MiConfigSingleton.this.X6(this.f11315a);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class j extends com.martian.mibook.lib.account.d.q.e0<BookSyncInfoParams, MiBookShelfItemList> {

        /* renamed from: i */
        final /* synthetic */ y f11317i;

        /* renamed from: j */
        final /* synthetic */ j1 f11318j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Class x0, Class x1, Activity x2, final y val$activity, final j1 val$listener) {
            super(x0, x1, x2);
            this.f11317i = val$activity;
            this.f11318j = val$listener;
        }

        @Override // com.martian.mibook.lib.account.d.q.e0, b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f11317i.a(errorResult);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<MiBookShelfItemList> userDetails) {
            this.f11317i.b();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f11317i.onLoading(show);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.d.c.c.c, b.d.c.c.b
        /* renamed from: t */
        public boolean onPreDataReceived(MiBookShelfItemList miBookShelfItemList) {
            MiConfigSingleton.this.U1(((BookSyncInfoParams) k()).getUid() + "_last_sync_backup.tbs");
            return MiConfigSingleton.this.l3().d1(this.f11318j, miBookShelfItemList);
        }
    }

    class k implements TTAdSdk.InitCallback {
        k() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String s) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            MiConfigSingleton.this.d5 = true;
        }
    }

    class l extends com.martian.mibook.lib.account.d.q.a {

        /* renamed from: h */
        final /* synthetic */ j1 f11320h;

        /* loaded from: classes3.dex */
        class a implements h.a {
            a() {
            }

            @Override // com.martian.libmars.d.h.a
            public void a() {
                ((com.martian.mibook.lib.account.d.f) l.this).f13904g.i();
            }

            @Override // com.martian.libmars.d.h.a
            public void b() {
                ((com.martian.mibook.lib.account.d.f) l.this).f13904g.i();
                com.martian.mibook.lib.account.e.d.b(l.this.f11320h, 200, true);
            }
        }

        l(final j1 val$activity) {
            this.f11320h = val$activity;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (errorResult.c() == 205) {
                com.martian.libmars.d.h.F().C1(this.f11320h, new a());
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: s */
        public void onDataReceived(Boolean aBoolean) {
            MiConfigSingleton.this.t8(true);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class m extends com.martian.mibook.lib.account.d.g<UserCommentParams, Integer> {
        m(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        /* renamed from: o */
        public /* synthetic */ void p() {
            MiConfigSingleton.this.J5 = Boolean.TRUE;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.application.t
                @Override // java.lang.Runnable
                public final void run() {
                    MiConfigSingleton.m.this.p();
                }
            }, 60000L);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<Integer> counts) {
            MiConfigSingleton.this.g8();
            if (MiConfigSingleton.this.v4() >= 1800) {
                MiConfigSingleton.this.K7(false);
            } else {
                MiConfigSingleton.this.J5 = Boolean.TRUE;
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class n implements Runnable {

        /* renamed from: a */
        final /* synthetic */ j1 f11324a;

        n(final j1 val$mActivity) {
            this.f11324a = val$mActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            MiConfigSingleton.this.j2(this.f11324a);
        }
    }

    class o implements IAdEventListener {
        o() {
        }

        @Override // com.wbl.ad.yzz.config.IAdEventListener
        public void onAdClicked(List<IEventAd> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            for (IEventAd iEventAd : list) {
                com.martian.libugrowth.b.k().g(iEventAd.getAdId(), AdConfig.Action.CLICK, MiConfigSingleton.this.U2(iEventAd.getAdFrom()), "", 0);
            }
        }

        @Override // com.wbl.ad.yzz.config.IAdEventListener
        public void onAdExposure(List<IEventAd> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            for (IEventAd iEventAd : list) {
                com.martian.libugrowth.b.k().g(iEventAd.getAdId(), AdConfig.Action.SHOW, MiConfigSingleton.this.U2(iEventAd.getAdFrom()), "", 0);
            }
        }

        @Override // com.wbl.ad.yzz.config.IAdEventListener
        public void onAdLoaded(List<IEventAd> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            for (IEventAd iEventAd : list) {
                com.martian.libugrowth.b.k().g(iEventAd.getAdId(), AdConfig.Action.SUCCESS, MiConfigSingleton.this.U2(iEventAd.getAdFrom()), "", 0);
            }
        }
    }

    class p extends SplashSwitchClient {
        p(Context context) {
            super(context);
        }

        @Override // com.martian.mibook.client.SplashSwitchClient
        public void bindService(boolean showSplash) {
            super.bindService(showSplash);
        }

        @Override // com.martian.mibook.client.SplashSwitchClient
        public void c() {
            super.c();
        }
    }

    class q extends VCustomController {

        /* renamed from: a */
        final /* synthetic */ boolean f11328a;

        /* renamed from: b */
        final /* synthetic */ boolean f11329b;

        q(final boolean val$canUseWriteExternal, final boolean val$canUsePhoneState) {
            this.f11328a = val$canUseWriteExternal;
            this.f11329b = val$canUsePhoneState;
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public String getImei() {
            return MiConfigSingleton.this.z();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public VLocation getLocation() {
            return null;
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseLocation() {
            return false;
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUsePhoneState() {
            return this.f11328a;
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseWifiState() {
            return true;
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseWriteExternal() {
            return this.f11329b;
        }
    }

    class r implements VInitCallback {
        r() {
        }

        @Override // com.vivo.mobilead.manager.VInitCallback
        public void failed(@NonNull VivoAdError adError) {
        }

        @Override // com.vivo.mobilead.manager.VInitCallback
        public void suceess() {
            MiConfigSingleton.this.k5 = true;
        }
    }

    class s implements x {
        s() {
        }

        @Override // com.martian.mibook.application.MiConfigSingleton.x
        public void onFailed(String var1) {
        }

        @Override // com.martian.mibook.application.MiConfigSingleton.x
        public void onSuccess() {
            MiConfigSingleton.this.l5 = true;
        }
    }

    class t extends com.martian.mibook.lib.account.d.g<CheckUpgradeParams, UpgradeInfo> {

        /* renamed from: g */
        final /* synthetic */ j1 f11333g;

        /* renamed from: h */
        final /* synthetic */ boolean f11334h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(Class x0, Class x1, Context x2, final j1 val$force, final boolean val$activity) {
            super(x0, x1, x2);
            this.f11333g = val$force;
            this.f11334h = val$activity;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (this.f11334h) {
                com.martian.libmars.utils.w0.a(this.f11333g, errorResult.d());
            }
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<UpgradeInfo> upgradeInfos) {
            if (upgradeInfos == null || upgradeInfos.isEmpty()) {
                return;
            }
            v2.g1(this.f11333g, upgradeInfos.get(0), this.f11334h);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class u extends Thread {
        u() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            MiConfigSingleton.this.l3().r0();
        }
    }

    class v implements QQAPIInstance.QQShareReceiver {
        v() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int errcode, String errStr) {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String shareResult) {
        }
    }

    class w implements QQAPIInstance.QQShareReceiver {
        w() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int errcode, String errStr) {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String shareResult) {
        }
    }

    public interface x {
        void onFailed(String var1);

        void onSuccess();
    }

    public interface y {
        void a(b.d.c.b.c errorResult);

        void b();

        void onLoading(boolean show);
    }

    public interface z {
        void a();
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        String str = File.separator;
        sb.append(str);
        sb.append("martian");
        sb.append(str);
        sb.append("tfbook");
        sb.append(str);
        String sb2 = sb.toString();
        w0 = sb2;
        x0 = sb2 + s0 + str;
        y0 = sb2 + t0 + str;
        z0 = sb2 + u0 + str;
        A0 = sb2 + v0 + str;
        B0 = Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static boolean F5(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private boolean G2() {
        long j5 = this.c5;
        return j5 < 0 || j5 + 10000 < System.currentTimeMillis();
    }

    private void N4() {
        new u().start();
    }

    public String U2(String source) {
        return "百度".equalsIgnoreCase(source) ? AdConfig.UnionType.BQT : "穿山甲".equalsIgnoreCase(source) ? AdConfig.UnionType.CSJ : "腾讯".equalsIgnoreCase(source) ? AdConfig.UnionType.GDT : source;
    }

    public static MiConfigSingleton V3() {
        return (MiConfigSingleton) com.martian.libmars.d.h.s;
    }

    private boolean a4() {
        if (this.J5 == null) {
            this.J5 = Boolean.valueOf(Y("pref_need_user_active", false));
        }
        return this.J5.booleanValue();
    }

    public void j2(final j1 mActivity) {
        new AlertDialog.Builder(mActivity).setTitle("环境:" + (com.martian.libmars.d.h.F().Q0() ? "TEST" : com.martian.libmars.d.h.F().G0() ? "BETA" : "RELEASE") + " 渠道：" + com.martian.libmars.d.h.F().m()).setCancelable(false).setItems(new String[]{"TEST", "BETA", "RELEASE", AdConfig.UnionType.CSJ, AdConfig.UnionType.GDT, "BAE", AdConfig.UnionType.DX, AdConfig.UnionType.MI, AdConfig.UnionType.HW, "KS", AdConfig.UnionType.API, AdConfig.UnionType.BOOK, "VIVO", "OPPO", "取消"}, new DialogInterface.OnClickListener() { // from class: com.martian.mibook.application.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MiConfigSingleton.this.o6(mActivity, dialogInterface, i5);
            }
        }).show();
    }

    private MiBookIdItem j3(String json) {
        return (MiBookIdItem) GsonUtils.a().fromJson(json, MiBookIdItem.class);
    }

    /* renamed from: n6 */
    public /* synthetic */ void o6(final j1 mActivity, DialogInterface dialog, int i5) {
        if (i5 == 0) {
            com.martian.libmars.d.h.F().p1(2);
            mActivity.k1("切换到test模式");
            return;
        }
        if (i5 == 1) {
            final String R = R();
            if (!R.equalsIgnoreCase(m())) {
                com.martian.libmars.utils.k0.P(mActivity, getString(R.string.confirm_message), "是否重置渠道号？", new k0.l() { // from class: com.martian.mibook.application.u
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        com.martian.libmars.d.h.F().m1(R);
                    }
                });
            }
            com.martian.libmars.d.h.F().p1(1);
            mActivity.k1("切换到beta模式");
            return;
        }
        if (i5 == 2) {
            final String R4 = R();
            if (!R4.equalsIgnoreCase(m())) {
                com.martian.libmars.utils.k0.P(mActivity, getString(R.string.confirm_message), "是否重置渠道号？", new k0.l() { // from class: com.martian.mibook.application.w
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        com.martian.libmars.d.h.F().m1(R4);
                    }
                });
            }
            com.martian.libmars.d.h.F().p1(0);
            mActivity.k1("切换到release模式");
            return;
        }
        if (i5 == 3) {
            com.martian.libmars.d.h.F().m1(s4);
            mActivity.k1("切换到CSJ模式");
            return;
        }
        if (i5 == 4) {
            com.martian.libmars.d.h.F().m1(t4);
            mActivity.k1("切换到GDT模式");
            return;
        }
        if (i5 == 5) {
            com.martian.libmars.d.h.F().m1(u4);
            mActivity.k1("切换到BAE模式");
            return;
        }
        if (i5 == 6) {
            com.martian.libmars.d.h.F().m1(v4);
            mActivity.k1("切换到DX模式");
            return;
        }
        if (i5 == 7) {
            com.martian.libmars.d.h.F().m1(w4);
            mActivity.k1("切换到MI模式");
            return;
        }
        if (i5 == 8) {
            com.martian.libmars.d.h.F().m1(x4);
            mActivity.k1("切换到Hw模式");
            return;
        }
        if (i5 == 9) {
            com.martian.libmars.d.h.F().m1(y4);
            mActivity.k1("切换到KS模式");
            return;
        }
        if (i5 == 10) {
            com.martian.libmars.d.h.F().m1(z4);
            mActivity.k1("切换到API模式");
            return;
        }
        if (i5 == 11) {
            com.martian.libmars.d.h.F().m1(A4);
            mActivity.k1("切换到Book模式");
        } else if (i5 == 12) {
            com.martian.libmars.d.h.F().m1(B4);
            mActivity.k1("切换到Vivo模式");
        } else if (i5 == 13) {
            com.martian.libmars.d.h.F().m1(C4);
            mActivity.k1("切换到Oppo模式");
        }
    }

    private boolean p5(int weight) {
        if (weight <= 0) {
            return false;
        }
        return weight >= 100 || Math.abs(t().hashCode()) % 100 <= weight;
    }

    /* renamed from: p6 */
    public /* synthetic */ void q6() {
        try {
            Uri parse = Uri.parse("content://com.miui.systemAdSolution.adSwitch/adPrivacySwitch");
            ContentValues contentValues = new ContentValues();
            contentValues.put("adPackage", getPackageName());
            contentValues.put("adPrivacyStatus", Boolean.valueOf(!j5()));
            getContentResolver().acquireContentProviderClient(parse).update(parse, contentValues, null, null);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void s2() {
        com.martian.mipush.c.i().l(this, k0.f11479g, k0.f11480h, k0.f11482j, k0.k, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PushChannelInfo(getString(R.string.tts_channel_id), getString(R.string.tts_channel_name), getString(R.string.tts_channel_description), false));
        arrayList.add(new PushChannelInfo(getString(R.string.reading_record_channel_id), getString(R.string.reading_record_channel_name), getString(R.string.reading_record_channel_description), false));
        arrayList.add(new PushChannelInfo(getString(R.string.push_activity_channel_id), getString(R.string.push_activity_channel_name), getString(R.string.push_activity_channel_description), true));
        arrayList.add(new PushChannelInfo(getString(R.string.push_book_channel_id), getString(R.string.push_book_channel_name), getString(R.string.push_book_channel_description), true));
        com.martian.mipush.c.i().h(arrayList);
    }

    public int v4() {
        if (this.K5 < 0) {
            this.K5 = Z("pref_user_active_sec", 0);
        }
        return this.K5;
    }

    private boolean v5() {
        return Calendar.getInstance(TimeZone.getDefault()).get(11) >= 8;
    }

    public boolean A2() {
        return com.martian.libsupport.h.d(this, M3, false);
    }

    public String A3() {
        StringBuilder sb = new StringBuilder();
        sb.append(v());
        String str = File.separator;
        sb.append(str);
        sb.append("mibook");
        sb.append(str);
        sb.append(s0);
        sb.append(str);
        return sb.toString();
    }

    public String A4() {
        String j5 = com.martian.libsupport.h.j(getApplicationContext(), A3);
        if (!com.martian.libsupport.k.p(j5) && new File(j5).exists()) {
            return j5;
        }
        return null;
    }

    public boolean A5() {
        return j5() && (this.S4 || this.V4 || this.U4 || this.Q4);
    }

    public boolean A6() {
        if (v3() <= 0) {
            return true;
        }
        return com.martian.libsupport.h.d(this, S3, false);
    }

    public void A7(int isCleanAdChannel) {
        this.M5 = isCleanAdChannel;
    }

    public boolean A8() {
        return com.martian.libsupport.h.h(this, a3, -1L) < MartianRPUserManager.t();
    }

    public boolean B2() {
        return h6() || g0() < W3().getAdsRunTimes().intValue() - 1;
    }

    public String B3() {
        return y() + File.separator + A0;
    }

    public Boolean B4() {
        return Boolean.valueOf(com.martian.libsupport.h.d(getApplicationContext(), z3, true));
    }

    public boolean B5() {
        Boolean bool = this.P5;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(MartianRPUserManager.t() - com.martian.libsupport.h.h(this, D4, -1L) <= 86400000);
        this.P5 = valueOf;
        return valueOf.booleanValue();
    }

    public boolean B6() {
        int oppoSplashDestroy = W3().getOppoSplashDestroy();
        if (oppoSplashDestroy <= 0) {
            return false;
        }
        return oppoSplashDestroy >= 100 || new Random().nextInt(100) <= oppoSplashDestroy;
    }

    public void B7(boolean systemBrightness) {
        com.martian.libsupport.h.p(this, V2, systemBrightness);
    }

    public boolean B8(Activity activity) {
        return h6() || (activity instanceof EnterActivity) || g0() <= 1 || O0() || System.currentTimeMillis() - this.l0 <= ((long) W3().getSplashRestartDelay().intValue());
    }

    public boolean C2() {
        if (J0()) {
            return true;
        }
        if (this.N5 == null) {
            this.N5 = Boolean.valueOf(!j5() && p5(W3().getEnableAdxWeight()));
        }
        return this.N5.booleanValue();
    }

    public String C3() {
        return y() + File.separator + y0;
    }

    public MiUser C4() {
        return (MiUser) this.M4.h();
    }

    public boolean C5() {
        return R0(com.martian.libsupport.h.h(this, o4, -1L));
    }

    public MiBookIdItem C6() throws IOException {
        return j3(com.martian.libsupport.e.B(getApplicationContext(), R2));
    }

    public void C7() {
        this.C5 = MartianRPUserManager.t();
    }

    public boolean C8() {
        return com.martian.libsupport.h.d(this, getResources().getString(R.string.pref_show_chapter_comment), true);
    }

    public boolean D2() {
        return u3() && com.martian.libsupport.f.d(this);
    }

    public String D3() {
        return y() + File.separator + z0;
    }

    public String D4() {
        MiCompoundUserManager miCompoundUserManager = this.M4;
        if (miCompoundUserManager == null || miCompoundUserManager.h() == null || this.M4.h().getUid() == null) {
            return "11";
        }
        return this.M4.h().getUid() + "";
    }

    public boolean D5() {
        return this.l5;
    }

    public boolean D6() {
        return com.martian.libsupport.h.d(this, J2, true);
    }

    public void D7() {
        long t5 = MartianRPUserManager.t();
        this.D5 = t5;
        com.martian.libsupport.h.n(this, h4, t5);
    }

    public boolean D8() {
        if (J0()) {
            return true;
        }
        return (j5() || !W3().getShowComments() || V3().F0()) ? false : true;
    }

    public boolean E2() {
        return com.martian.libsupport.l.r();
    }

    public String E3() {
        return y() + File.separator + x0;
    }

    public int E4() {
        return this.L4.u(106);
    }

    public boolean E5() {
        return this.U4 && j5();
    }

    public boolean E6() {
        return com.martian.libsupport.h.d(this, getString(R.string.record_bookrack_category_pref_key), false);
    }

    public void E7(String type, boolean repeat) {
        if (repeat && !R0(N3(type))) {
            k1(type);
        }
        B0(type);
        com.martian.libsupport.h.n(this, type, MartianRPUserManager.t());
    }

    public boolean E8() {
        return this.B5 <= 3 && Y1();
    }

    public boolean F2() {
        return E2() && J2();
    }

    public String F3() {
        return y() + File.separator + w0;
    }

    public String F4() {
        long h5 = com.martian.libsupport.h.h(this, c4, -1L);
        if (h5 == -1 || !R0(h5)) {
            k1(b4);
        }
        return q(b4) + "/" + this.L4.r(106);
    }

    public void F6(String packageName) {
        Iterator<AppTask> it = this.A5.iterator();
        while (it.hasNext()) {
            if (packageName.equals(it.next().packageName)) {
                it.remove();
            }
        }
    }

    public void F7(String category) {
        com.martian.libsupport.h.o(this, E3, category);
    }

    public boolean F8() {
        if (!L0("pref_menu_entrance")) {
            return com.martian.libsupport.h.d(this, getResources().getString(R.string.pref_show_menu), true);
        }
        boolean z5 = g0() <= 1;
        l8(z5);
        return z5;
    }

    public int G3() {
        if (j5()) {
            return 0;
        }
        return W3().getFlowJointEcpm();
    }

    public long G4() {
        MartianRPAccount s42 = s4();
        if (s42 == null || s42.getVipEnd() == null) {
            return -1L;
        }
        return s42.getVipEnd().longValue();
    }

    public boolean G5() {
        MartianRPAccount s42 = s4();
        return s42 != null && s42.isPaymentUser();
    }

    public void G6(final Activity activity, final int requestCode, final z l5) {
        if (ContextCompat.checkSelfPermission(this, com.kuaishou.weapon.p0.g.f9325j) != 0) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, com.kuaishou.weapon.p0.g.f9325j)) {
                l5.a();
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{com.kuaishou.weapon.p0.g.f9325j}, requestCode);
            }
        }
    }

    public void G7(int position) {
        com.martian.libsupport.h.m(this, D3, position);
    }

    public void G8(final Activity activity, String imgUrl, String title, String content, String shareLink) {
        QQAPIInstance.getInstance().startQQShare(activity, title, content, shareLink, imgUrl, new w());
    }

    @Override // com.martian.mibook.lib.model.a
    public MiTheme H1() {
        return this.I4.e();
    }

    public boolean H2() {
        if (this.V4) {
            return true;
        }
        return x5() && g0() > 5 && !this.L4.d0();
    }

    public int H3() {
        if (this.w5 == -1) {
            this.w5 = com.martian.libsupport.h.f(getApplicationContext(), u3, F5(this) ? 28 : 24);
        }
        return this.w5;
    }

    public w0 H4() {
        return this.O4;
    }

    public boolean H5() {
        return com.martian.libsupport.h.d(this, M2, false);
    }

    public void H6() {
        k1(q3);
        this.u5 = -1L;
    }

    public void H7(float val) {
        int i5 = (int) (val * 100.0f);
        this.y5 = i5;
        com.martian.libsupport.h.m(this, x3, i5);
    }

    public void H8(final Activity activity) {
        QQAPIInstance.getInstance().startQQShare(activity, getString(R.string.wxshare_friend_title), getString(R.string.wxshare_friend_content), W3().getShareLink(), "https://mmbiz.qlogo.cn/mmbiz/IPClZDxPF3hIFIiat84GWhKiaBLdYB2TFJaZK2g7ib6UdP2kH4CdKLpC24ribbtZMYdB3bMV64Kn9pGoMCLV2MVW0g/0?wx_fmt=png", new v());
    }

    public boolean I2() {
        return com.martian.mipush.d.g() && com.martian.libsupport.l.n() && !j5();
    }

    public boolean I3() {
        return com.martian.libsupport.h.d(this, N3, false);
    }

    public int I4() {
        if (Q2()) {
            return W3().getWblAdWeight();
        }
        return 0;
    }

    public boolean I5() {
        return com.martian.libsupport.h.e(n3, this, m3, false);
    }

    public void I6() {
        this.K5 = 0;
        w1("pref_user_active_sec", 0);
    }

    public void I7() {
        com.martian.libsupport.h.n(this, j4, MartianRPUserManager.t());
    }

    public void I8(final Activity activity) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://mmbiz.qlogo.cn/mmbiz/IPClZDxPF3hIFIiat84GWhKiaBLdYB2TFJaZK2g7ib6UdP2kH4CdKLpC24ribbtZMYdB3bMV64Kn9pGoMCLV2MVW0g/0?wx_fmt=png");
        arrayList.add("https://mmbiz.qlogo.cn/mmbiz/IPClZDxPF3hIFIiat84GWhKiaBLdYB2TFJno9gLPwlVYWFZic3cPiacJ70QE0bEBUGYVPE9GpJ8hM9oFicof2vGXMibQ/0?wx_fmt=png");
        QQAPIInstance.getInstance().startQzoneShare(activity, getString(R.string.wxshare_friend_title), getString(R.string.wxshare_friend_content), W3().getShareLink(), arrayList, new a());
    }

    public boolean J2() {
        return !j5();
    }

    public String J3() {
        return x5() ? this.M4.h().getHeader() : "http://p16.qhimg.com/t01c09ef2e39f16c2c5.png";
    }

    public boolean J4() {
        return com.martian.libsupport.h.d(this, J3, false);
    }

    public boolean J5() {
        return com.martian.libsupport.h.d(this, q4, false);
    }

    public boolean J6(String filepath) {
        try {
            BookWrapperList bookWrapperList = (BookWrapperList) new GsonBuilder().registerTypeAdapter(Book.class, new InterfaceAdapter()).create().fromJson(com.martian.libsupport.e.A(filepath), BookWrapperList.class);
            if (bookWrapperList == null) {
                return false;
            }
            l3().Q0(bookWrapperList.bookWrappers);
            l3().P0(bookWrapperList.archiveBooks);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void J7(boolean needGenderGuide) {
        com.martian.libsupport.h.p(this, S3, needGenderGuide);
    }

    public void J8(final Activity activity, String imgUrl, String title, String content, String shareLink) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(imgUrl);
        QQAPIInstance.getInstance().startQzoneShare(activity, title, content, shareLink, arrayList, new b());
    }

    public boolean K2() {
        return com.martian.mipush.d.i() && com.martian.libsupport.l.p() && !j5();
    }

    public String K3() {
        return W3().getHelpLink();
    }

    public boolean K4() {
        int H32 = H3();
        if (H32 >= 36) {
            return false;
        }
        v7(H32 + 2);
        return true;
    }

    public boolean K5(long time) {
        return com.martian.libsupport.h.d(this, "rp_share_" + time, false);
    }

    public void K6() {
        com.martian.libsupport.h.p(this, S2, !M5());
    }

    public void K7(boolean neeActivated) {
        this.J5 = Boolean.valueOf(neeActivated);
        v1("pref_need_user_active", neeActivated);
    }

    public void K8(String title, final long redpaperTime) {
        com.maritan.libweixin.c.g().v(title, title, W3().getShareLink(), R.drawable.ic_launcher, new i(redpaperTime));
    }

    public boolean L2() {
        return com.martian.libsupport.l.p() && !j5();
    }

    public long L3() {
        return this.F5;
    }

    public void L4(int times) {
        this.B5 += times;
    }

    public boolean L5() {
        return com.martian.libsupport.h.d(this, H3, false);
    }

    public void L6() {
        Z6(this.x5);
    }

    public void L7() {
        if (J0()) {
            com.martian.libsupport.h.n(this, g4, MartianRPUserManager.t() + 30000);
            D7();
        } else {
            com.martian.libsupport.h.n(this, g4, MartianRPUserManager.t() + (W3().getVideoMissionInterval().intValue() * 60 * 1000));
            D7();
        }
    }

    public void L8(final Activity activity) {
        com.maritan.libweixin.c.g().y(getString(R.string.wxshare_friend_title), getString(R.string.wxshare_friend_content), W3().getShareLink(), R.drawable.ic_launcher_80x80, new c(activity));
        w6(true);
    }

    public boolean M2() {
        return (!com.martian.libsupport.l.r() || z5(false) || com.martian.libsupport.k.p(W3().getQplayLink())) ? false : true;
    }

    public long M3() {
        return this.M4.d();
    }

    public long M4() {
        this.u5 = U3() + 1;
        return B0(q3);
    }

    public boolean M5() {
        return com.martian.libsupport.h.d(this, S2, true);
    }

    public void M6(MiBookIdItem items) {
        try {
            com.martian.libsupport.e.E(getApplicationContext(), R2, new Gson().toJson(items));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void M7(int minutes) {
        if (Q0()) {
            this.s5 = MartianRPUserManager.t() + 60000;
            com.martian.libsupport.h.n(this, Z2, MartianRPUserManager.t() + 60000);
        } else {
            long j5 = minutes * 60 * 1000;
            this.s5 = MartianRPUserManager.t() + j5;
            com.martian.libsupport.h.n(this, Z2, MartianRPUserManager.t() + j5);
        }
    }

    public void M8(String title, String content, Bitmap cover, String shareLink) {
        com.maritan.libweixin.c.g().z(title, content, shareLink, cover, new d());
        w6(true);
    }

    public boolean N2() {
        return !j5() && W3().getEnableUpgrade();
    }

    public long N3(String type) {
        return com.martian.libsupport.h.h(this, type, -1L);
    }

    public boolean N5() {
        return com.martian.libsupport.h.d(this, t3, false);
    }

    public void N6(int speed) {
        com.martian.libsupport.h.m(this, w3, speed);
    }

    public long N7(long leftSeconds) {
        if (Q0()) {
            com.martian.libsupport.h.n(this, p4, MartianRPUserManager.t() + 60000);
            return MartianRPUserManager.t() + 60000;
        }
        long t5 = MartianRPUserManager.t() + (leftSeconds * 1000);
        com.martian.libsupport.h.n(this, p4, t5);
        return t5;
    }

    public void N8(String title, String content, String shareLink) {
        com.maritan.libweixin.c.g().y(title, content, shareLink, R.drawable.ic_launcher_80x80, new e());
        w6(true);
    }

    public boolean O2() {
        return E4() > 0;
    }

    public String O3() {
        return com.martian.libsupport.h.j(this, E3);
    }

    public void O4() {
        try {
            BuglyStrategy buglyStrategy = new BuglyStrategy();
            buglyStrategy.setAppChannel(m());
            buglyStrategy.setAppVersion(x0());
            Beta.initDelay = 1000L;
            Beta.upgradeDialogLayoutId = R.layout.activity_upgrade;
            Beta.autoDownloadOnWifi = true;
            Bugly.init(getApplicationContext(), k0.f11481i, Q0(), buglyStrategy);
            if (x5()) {
                CrashReport.setUserId(D4());
            }
            CrashReport.setDeviceId(this, t());
        } catch (Exception unused) {
        }
    }

    public boolean O5() {
        return this.O5;
    }

    public void O6(com.martian.rpauth.b user) {
        this.M4.C(user);
    }

    public void O7() {
        com.martian.libsupport.h.n(this, o4, MartianRPUserManager.t());
    }

    public void O8(final Activity activity) {
        P8(getString(R.string.wxshare_friend_title), getString(R.string.wxshare_friend_content));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P1(int totalDuration) {
        if (a4()) {
            int v42 = (totalDuration - v4()) - this.L5;
            if (v42 < 0 || v42 >= 120) {
                this.L5 = totalDuration - v4();
                return;
            }
            if (v42 >= 60) {
                int v43 = v4() + 60;
                if (v43 > 300 && v43 % 300 != 0) {
                    g8();
                    return;
                }
                this.J5 = Boolean.FALSE;
                m mVar = new m(UserCommentParams.class, Integer.class, this);
                try {
                    ((UserCommentParams) mVar.k()).setS(com.martian.libsupport.b.a(D4() + "_" + W3().getUserCommentSeconds(), k0.u));
                } catch (Exception unused) {
                }
                ((UserCommentParams) mVar.k()).setSec(Integer.valueOf(v43));
                ((UserCommentParams) mVar.k()).setOaid(V());
                ((UserCommentParams) mVar.k()).setImei(z());
                mVar.j();
            }
        }
    }

    public boolean P2() {
        return com.martian.libsupport.l.p() && !j5();
    }

    public int P3() {
        return com.martian.libsupport.h.f(this, D3, 0);
    }

    public void P4() {
        String m5 = m();
        if (m5.equalsIgnoreCase("Vivo")) {
            this.Q4 = true;
            return;
        }
        if (m5.equalsIgnoreCase("XiaoMi")) {
            this.S4 = true;
            return;
        }
        if (m5.equalsIgnoreCase("OPPO")) {
            this.U4 = true;
            return;
        }
        if (m5.equalsIgnoreCase("HuaWei")) {
            this.V4 = true;
            return;
        }
        if (m5.equalsIgnoreCase("BAE")) {
            this.W4 = true;
            return;
        }
        if (m5.equalsIgnoreCase("Anzhi")) {
            this.R4 = true;
            return;
        }
        if (m5.equalsIgnoreCase("Tencent")) {
            this.X4 = true;
            return;
        }
        if (m5.equalsIgnoreCase("QiHu")) {
            this.Y4 = true;
            return;
        }
        if (m5.equalsIgnoreCase("PP")) {
            this.Z4 = true;
        } else if (m5.equalsIgnoreCase("Flyme")) {
            this.T4 = true;
        } else if (m5.startsWith("HH")) {
            this.a5 = true;
        }
    }

    public boolean P5() {
        return R0(com.martian.libsupport.h.h(this, Z3, -1L));
    }

    public boolean P6() {
        return com.martian.libsupport.h.d(this, getString(R.string.send_book_info_pref_key), true);
    }

    public void P7(String books) {
        com.martian.libsupport.h.o(this, l4, books);
    }

    public void P8(String title, String content) {
        com.maritan.libweixin.c.g().v(title, content, W3().getShareLink(), R.drawable.ic_launcher_80x80, new f());
        w6(true);
    }

    public void Q1(j1 activity) {
        l lVar = new l(activity);
        lVar.n();
        lVar.j();
    }

    public boolean Q2() {
        if (J0()) {
            return true;
        }
        return g0() >= 10 && E2() && !j5() && !h6() && p5(W3().getEnableWblAdWeight());
    }

    public MiReadingRecord Q3() {
        List<MiReadingRecord> miReadingRecords = l3().F0().getMiReadingRecords();
        if (miReadingRecords == null || miReadingRecords.isEmpty()) {
            return null;
        }
        return miReadingRecords.get(0);
    }

    public void Q4() {
        if (this.e5) {
            return;
        }
        this.e5 = true;
        if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c)) {
            MobadsPermissionSettings.setPermissionReadDeviceID(true);
        }
        if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9325j)) {
            MobadsPermissionSettings.setPermissionStorage(true);
        }
        MobadsPermissionSettings.setPermissionAppList(true);
        new BDAdConfig.Builder().setAppName(k0.f11473a).setAppsid(k0.p).setWXAppid(k0.f11476d).build(this).init();
    }

    public boolean Q5() {
        return com.martian.libsupport.h.d(this, d3, false);
    }

    public boolean Q6() {
        return com.martian.libsupport.h.d(this, getString(R.string.send_ad_info_pref_key), true);
    }

    public void Q7() {
        com.martian.libsupport.h.p(this, n4, true);
    }

    public void Q8(String title, String content, Bitmap cover, String shareLink) {
        com.maritan.libweixin.c.g().w(title, content, shareLink, cover, new g());
        w6(true);
    }

    public void R1(Activity activity) {
        if (activity instanceof j1) {
            if (this.o5 == null) {
                this.o5 = new SparseBooleanArray();
            }
            if (!this.o5.get(activity.hashCode())) {
                View view = new View(activity);
                view.setId(activity.hashCode());
                view.setBackgroundColor(ContextCompat.getColor(activity, R.color.black));
                view.setAlpha(0.5f);
                activity.getWindow().addContentView(view, new ViewGroup.LayoutParams(-1, -1));
                this.o5.put(activity.hashCode(), true);
            }
            D1(activity);
        }
    }

    public boolean R2() {
        return (k5() || z5(false) || !W3().getEnablexianPlay().booleanValue()) ? false : true;
    }

    public long R3() {
        return com.martian.libsupport.h.h(this, K3, MartianRPUserManager.t());
    }

    public void R4() {
        if (this.g5) {
            return;
        }
        this.g5 = true;
        if (F2()) {
            try {
                AdRequest.init(this, new SdkConfiguration.Builder().setAppName(getPackageName()).build());
            } catch (Exception unused) {
            }
        }
    }

    public boolean R5() {
        if (this.t5 == null) {
            this.t5 = Boolean.valueOf(com.martian.libsupport.h.d(this, e3, true));
        }
        return this.t5.booleanValue();
    }

    public void R6() {
        com.martian.libsupport.h.n(this, D4, MartianRPUserManager.t());
    }

    public void R7(String teenagerModeKeyword) {
        com.martian.libsupport.h.o(this, l3, teenagerModeKeyword);
    }

    public void R8(String title, String content, String shareLink) {
        com.maritan.libweixin.c.g().v(title, content, shareLink, R.drawable.ic_launcher_80x80, new h());
        w6(true);
    }

    public boolean S1() {
        return com.martian.libsupport.h.d(this, getResources().getString(R.string.pref_show_bonus_key), !m6());
    }

    public boolean S2() {
        if (z2()) {
            return true;
        }
        return System.currentTimeMillis() - com.martian.libsupport.h.h(this, com.martian.libmars.d.h.L, -1L) > ((long) ((W3().getBookmallInterval() * 60) * 60)) * 1000;
    }

    public float S3() {
        if (this.y5 == -1) {
            this.y5 = com.martian.libsupport.h.f(this, x3, 145);
        }
        int i5 = this.y5;
        if (i5 < 100) {
            this.y5 = i5 * 10;
        }
        return this.y5 / 100.0f;
    }

    public void S4() {
        if (this.f5) {
            return;
        }
        this.f5 = true;
        GDTAdSdk.init(this, k0.q);
    }

    public boolean S5() {
        return com.martian.libsupport.h.d(this, V2, true);
    }

    public void S6(boolean known) {
        com.martian.libsupport.h.p(getApplicationContext(), B3, known);
    }

    public void S7(int index) {
        com.martian.libsupport.h.m(this, s3, index);
    }

    public void S8(j1 mActivity) {
        mActivity.k1("停停停");
        new Handler().postDelayed(new n(mActivity), 1000L);
    }

    public boolean T1() {
        return com.martian.libsupport.h.d(this, getResources().getString(R.string.always_show_virtual_key_pref_key), false);
    }

    public long T2() {
        return this.r5;
    }

    public String T3(String hint, int type) {
        switch (type) {
            case 1000:
                return hint + "-奖金池-签到";
            case 1001:
                return hint + "-首页-点击侧滑充值";
            case 1002:
                return hint + "-首页-点击书架同步";
            case 1003:
                return hint + "-首页-点击时段奖励";
            case 1004:
                return hint + "-评论-发表评论";
            case 1005:
                return hint + "-阅读页-点击登录";
            case 1006:
                return hint + "-阅读页-点击时长悬浮";
            case 1007:
                return hint + "-任务中心-小说分销";
            case 1008:
                return hint + "-任务中心-幂动CPA";
            case 1009:
                return hint + "-任务中心-点击登录";
            case 1010:
                return hint + "-任务中心-佣金收入";
            case 1011:
                return hint + "-任务中心-签到";
            case 1012:
                return hint + "-任务中心-互动红包";
            case 1013:
                return hint + "-任务中心-好评";
            case 1014:
                return hint + "-任务中心-视频赚书币";
            case 1015:
                return hint + "-任务中心-闲玩";
            case 1016:
                return hint + "-任务中心-加粉";
            case 1017:
                return hint + "-首页-新手红包";
            case 1018:
                return hint + "-Q玩任务";
            case 1019:
                return hint + "-视频解锁章节";
            case 1020:
                return hint + "-购买章节";
            case 1021:
                return hint + "-打开赚钱模式";
            case 1022:
                return hint + "-点击头像进行登录";
            case 1023:
                return hint + "-0.3元提现";
            case 1024:
                return hint + "-同步阅读记录";
            default:
                return "";
        }
    }

    public void T4() {
        if (this.j5 || !I2()) {
            return;
        }
        try {
            this.j5 = true;
            Class<?> cls = Class.forName("com.huawei.hms.ads.HwAds");
            cls.getDeclaredMethod("init", Context.class).invoke(cls, this);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public boolean T5() {
        return !com.martian.libsupport.k.p(y4());
    }

    public void T6(int minutes) {
        if (J0()) {
            minutes = 1;
        }
        M7(minutes);
        long max = Math.max(this.r5, MartianRPUserManager.t()) + (minutes * 60 * 1000);
        this.r5 = max;
        com.martian.libsupport.h.n(this, Y2, max);
    }

    public void T7(int seconds) {
        com.martian.libsupport.h.o(this, getString(R.string.pref_push_interval_time), String.valueOf(seconds));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void T8(j1 activity, final y listener) {
        j jVar = new j(BookSyncInfoParams.class, MiBookShelfItemList.class, activity, listener, activity);
        ((BookSyncInfoParams) jVar.k()).setBook_shelf_ops(l3().f0());
        jVar.j();
    }

    public boolean U1(String filename) {
        BookWrapperList bookWrapperList = new BookWrapperList();
        l3().J0(bookWrapperList);
        bookWrapperList.bookWrappers = l3().e0();
        bookWrapperList.archiveBooks = l3().A0();
        try {
            com.martian.libsupport.e.D(d3() + filename, new GsonBuilder().registerTypeAdapter(Book.class, new InterfaceAdapter()).create().toJson(bookWrapperList));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public long U3() {
        if (this.u5 == -1) {
            this.u5 = q(q3);
        }
        return this.u5;
    }

    public void U4() {
        if (J2()) {
            if (this.i5 && k0.s.equalsIgnoreCase(KsAdSDK.getAppId())) {
                return;
            }
            try {
                this.i5 = true;
                KsAdSDK.init(this, new SdkConfig.Builder().appId(k0.s).appName(k0.f11473a).showNotification(true).debug(Q0()).build());
            } catch (Exception unused) {
            }
        }
    }

    public boolean U5() {
        return !com.martian.libsupport.k.p(m()) && m().startsWith("Test");
    }

    public void U6(int times) {
        com.martian.libsupport.h.m(this, k4, times);
    }

    public void U7(int finished) {
        com.martian.libsupport.h.m(this, f4, finished);
    }

    public void U8() {
        com.martian.libsupport.h.n(this, K3, MartianRPUserManager.t());
    }

    public boolean V1() {
        return com.martian.libsupport.h.d(this, L2, false);
    }

    public boolean V2() {
        return com.martian.libsupport.h.d(getApplicationContext(), B3, false);
    }

    public void V4() {
        if (this.h5 || !K2()) {
            return;
        }
        try {
            this.h5 = true;
            Class<?> cls = Class.forName("com.miui.zeus.mimo.sdk.MimoSdk");
            cls.getDeclaredMethod("init", Context.class).invoke(cls, this);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public boolean V5() {
        return !z4.equalsIgnoreCase(m());
    }

    public void V6(boolean show) {
        com.martian.libsupport.h.p(this, getResources().getString(R.string.pref_show_bonus_key), show);
    }

    public void V7(String shareLink) {
        com.martian.libsupport.h.o(this, U3, shareLink);
    }

    public void V8(int money, int coins) {
        MiTaskAccount x42;
        if ((money > 0 || coins > 0) && (x42 = x4()) != null) {
            if (coins > 0) {
                x42.setCoins(Integer.valueOf(x42.getCoins() + coins));
            }
            if (money > 0) {
                x42.setMoney(Integer.valueOf(x42.getMoney() + money));
            }
            this.M4.f10762b.l(x42);
        }
    }

    public void W1(AppTask appTask) {
        if (this.A5.size() < 10) {
            this.A5.add(appTask);
            return;
        }
        if (this.A5.size() > 100) {
            this.A5.clear();
        }
        Iterator<AppTask> it = this.A5.iterator();
        while (it.hasNext()) {
            if (System.currentTimeMillis() - it.next().createdOn > TTAdConstant.AD_MAX_EVENT_TIME) {
                it.remove();
            }
        }
        this.A5.add(appTask);
    }

    public int W2(boolean secondTime) {
        if (J0()) {
            return secondTime ? 2 : 1;
        }
        return (secondTime ? W3().getAdsHideSecondIntervalMinutes() : W3().getAdsHideIntervalMinutes()).intValue();
    }

    public synchronized MiOptions W3() {
        return e4().f();
    }

    public void W4() {
        if (!com.martian.mipush.d.i() || h6()) {
            return;
        }
        new Thread(new Runnable() { // from class: com.martian.mibook.application.v
            @Override // java.lang.Runnable
            public final void run() {
                MiConfigSingleton.this.q6();
            }
        }).start();
    }

    public boolean W5() {
        return !u4.equalsIgnoreCase(m());
    }

    public void W6(boolean show) {
        com.martian.libsupport.h.p(this, getResources().getString(R.string.always_show_virtual_key_pref_key), show);
    }

    public void W7(boolean randomTheme) {
        com.martian.libsupport.h.p(this, M2, randomTheme);
    }

    public void W8() {
        com.martian.libsupport.h.n(this, L3, MartianRPUserManager.t());
    }

    public boolean X1() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(getString(R.string.auto_fullscreen_pref_key), true);
    }

    public int X2() {
        return com.martian.libsupport.h.f(this, k4, 0);
    }

    public MiBookIdItem X3() {
        try {
            return C6();
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public void X4() {
        if (this.l5 || !L2()) {
            return;
        }
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("initialOppoAdSdk", Context.class, x.class).invoke(cls, this, new s());
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public boolean X5() {
        return !A4.equalsIgnoreCase(m());
    }

    public void X6(long time) {
        com.martian.libsupport.h.p(this, "rp_share_" + time, true);
    }

    public void X7(boolean isReadingDestroy) {
        com.martian.libsupport.h.p(this, q4, isReadingDestroy);
    }

    public void X8() {
        com.martian.libsupport.h.n(this, I3, System.currentTimeMillis());
    }

    public boolean Y1() {
        if (M0()) {
            L4(4);
            return false;
        }
        MiTaskAccount x42 = x4();
        return x42 != null && x42.isFreshVideoWithdraw() && x42.getFreshRedpaper() <= 0;
    }

    public AdxManager Y2() {
        return this.P4;
    }

    public int Y3(String type, boolean repeat) {
        if (repeat && !R0(N3(type))) {
            k1(type);
        }
        return q(type);
    }

    public void Y4() {
        if (com.martian.mipush.d.j()) {
            boolean b5 = SplashSwitchClient.b(this);
            com.martian.libmars.utils.q0.e("hasOppoSplashService:" + b5);
            if (b5) {
                new p(this).bindService(!h6());
            }
        }
    }

    public boolean Y5() {
        return (F2() && v4.equalsIgnoreCase(m())) ? false : true;
    }

    public void Y6() {
        com.martian.libsupport.h.n(this, b3, MartianRPUserManager.t() + 86400000);
    }

    public void Y7(int index) {
        com.martian.libsupport.h.o(this, f3, "" + index);
    }

    public String Y8() {
        return W3().getVerifyPhoneHint();
    }

    public boolean Z1() {
        int t32;
        if (!v5() || (t32 = t3()) == 0) {
            return false;
        }
        if (t32 == 1) {
            return true;
        }
        return U0();
    }

    public int Z2() {
        if (this.x5 == -1) {
            this.x5 = com.martian.libsupport.h.f(getApplicationContext(), v3, 48);
        }
        return this.x5;
    }

    public String Z3(j1 activity) {
        return W3().getMplistPackageName(activity);
    }

    public void Z4() {
        if (this.d5) {
            return;
        }
        try {
            if (E2()) {
                s0.d(this, new k());
            } else {
                this.d5 = true;
            }
        } catch (Exception unused) {
        }
    }

    public boolean Z5() {
        return !t4.equalsIgnoreCase(m());
    }

    public void Z6(int fontSize) {
        com.martian.libsupport.h.m(getApplicationContext(), v3, fontSize);
        this.x5 = fontSize;
    }

    public void Z7(boolean receivedRedpaperNotify) {
        com.martian.libsupport.h.p(this, J2, receivedRedpaperNotify);
    }

    public boolean Z8() {
        long h5 = com.martian.libsupport.h.h(this, c4, -1L);
        if (h5 == -1 || !R0(h5)) {
            k1(b4);
        }
        return q(b4) >= this.L4.r(106);
    }

    public boolean a2() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(getString(R.string.screen_sensor_rotate_pref_key), false);
    }

    public String a3() {
        return b3() + ".tbs";
    }

    public void a5(boolean init) {
        try {
            com.maritan.libweixin.c.g().i(this, y0());
            QQAPIInstance.getInstance().init(e0(), this);
            if (init) {
                UMConfigure.init(this, 1, "");
            }
            s2();
            c5();
            W4();
        } catch (Exception unused) {
        }
    }

    public boolean a6() {
        return (I2() && x4.equalsIgnoreCase(m())) ? false : true;
    }

    public void a7() {
        com.martian.libsupport.h.m(this, Q2, g0());
    }

    public void a8(int type) {
        com.martian.libsupport.h.m(this, Y3, type);
    }

    public boolean b2() {
        long j5 = this.s5;
        if (j5 > 0) {
            return j5 < MartianRPUserManager.t();
        }
        if (W3().getAdsDialogIntervalMinutes().intValue() <= 0) {
            return false;
        }
        long h5 = com.martian.libsupport.h.h(this, Z2, -1L);
        this.s5 = h5;
        if (h5 == -1) {
            this.s5 = MartianRPUserManager.t() + com.alipay.mobilesecuritysdk.constant.a.k;
            if (Q0()) {
                this.s5 = MartianRPUserManager.t() + 10000;
            }
            com.martian.libsupport.h.n(this, Z2, this.s5);
        }
        return this.s5 < MartianRPUserManager.t();
    }

    public String b3() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    }

    public long b4() {
        return com.martian.libsupport.h.h(this, g4, -1L);
    }

    public void b5() {
        if (this.k5 || !P2()) {
            return;
        }
        try {
            VivoAdManager.getInstance().init(this, new VAdConfig.Builder().setMediaId(k0.n).setDebug(J0()).setCustomController(new q(com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c), com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9325j))).build(), new r());
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public boolean b6() {
        return (J2() && y4.equalsIgnoreCase(m())) ? false : true;
    }

    public void b7(boolean bonusPollCheckined) {
        com.martian.libsupport.h.p(this, L2, bonusPollCheckined);
    }

    public void b8(boolean record) {
        com.martian.libsupport.h.p(this, getString(R.string.record_bookrack_category_pref_key), record);
    }

    public boolean c2() {
        return MartianRPUserManager.t() - this.C5 > 3600000;
    }

    public String c3() {
        return d3() + a3();
    }

    public long c4() {
        return com.martian.libsupport.h.h(this, p4, -1L);
    }

    public void c5() {
        if (this.m5 || !Q2()) {
            return;
        }
        AdInitialize.getInstance().initialize(this);
        AdInitialize.getInstance().setAdEventListener(new o());
        this.m5 = true;
    }

    public boolean c6() {
        return (K2() && w4.equalsIgnoreCase(m())) ? false : true;
    }

    public void c7(boolean isBookCoinsType) {
        com.martian.libsupport.h.p(this, e4, isBookCoinsType);
    }

    public void c8(boolean shared) {
        com.martian.libsupport.h.p(this, H3, shared);
    }

    public boolean d2() {
        if (this.D5 < 0) {
            long h5 = com.martian.libsupport.h.h(this, h4, 0L);
            this.D5 = h5;
            if (h5 <= 0) {
                D7();
            }
        }
        int authorVideoCountdownInterval = V3().W3().getAuthorVideoCountdownInterval();
        return authorVideoCountdownInterval > 0 && MartianRPUserManager.t() - this.D5 > ((long) (authorVideoCountdownInterval * SdkConfigData.DEFAULT_REQUEST_INTERVAL)) * 1000;
    }

    public String d3() {
        return B3();
    }

    public long d4() {
        return com.martian.libsupport.h.h(this, L3, -1L);
    }

    public boolean d5() {
        return com.martian.libsupport.h.d(this, e4, false);
    }

    public boolean d6() {
        return (L2() && C4.equalsIgnoreCase(m())) ? false : true;
    }

    public void d7(long time) {
        this.q5 = time;
        com.martian.libsupport.h.n(this, X2, time);
    }

    public void d8(int index) {
        com.martian.libsupport.h.m(this, r4, index);
    }

    @Override // com.martian.libmars.d.h
    public com.martian.libmars.d.i e0() {
        return new com.martian.libmars.d.i(k0.f11478f);
    }

    public boolean e2() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(getString(R.string.show_image_pref_key), true) || U0();
    }

    public String e3() {
        return com.martian.libsupport.h.j(this, l4);
    }

    public p0 e4() {
        if (this.K4 == null) {
            this.K4 = new p0(getApplicationContext());
        }
        return this.K4;
    }

    public boolean e5() {
        return com.martian.libsupport.h.d(this, N2, false);
    }

    public boolean e6() {
        return (E2() && s4.equalsIgnoreCase(m())) ? false : true;
    }

    public void e7(int type) {
        com.martian.libsupport.h.m(this, O3, type);
    }

    public void e8(boolean isPortrait) {
        com.martian.libsupport.h.p(this, S2, isPortrait);
    }

    @Override // com.martian.libmars.d.h
    public com.martian.libmars.d.g f() {
        return new com.martian.libmars.d.g(k0.f11474b, k0.f11475c);
    }

    @Override // com.martian.libmars.d.h
    public String f0() {
        String channel = HumeSDK.getChannel(this);
        return com.martian.libsupport.k.p(channel) ? R() : channel;
    }

    public boolean f2() {
        return System.currentTimeMillis() - com.martian.libsupport.h.h(this, I3, 0L) > 86400000;
    }

    public int f3() {
        if (j5()) {
            return 0;
        }
        return W3().getBannerJointEcpm();
    }

    public int f4() {
        return com.martian.libsupport.h.f(this, s3, 0);
    }

    public boolean f5() {
        if (z2()) {
            return true;
        }
        if (this.n5 == -1) {
            this.n5 = com.martian.libsupport.h.h(this, O2, -1L);
        }
        return R0(this.n5);
    }

    public boolean f6() {
        return (P2() && B4.equalsIgnoreCase(m())) ? false : true;
    }

    public void f7(int mode) {
        this.z5 = mode;
        com.martian.libsupport.h.m(getApplicationContext(), C3, mode);
    }

    public void f8(long timeout, boolean save) {
        this.p5 = timeout;
        if (save) {
            com.martian.libsupport.h.o(this, W2, String.valueOf(timeout));
        }
    }

    public boolean g2() {
        return com.martian.libsupport.h.d(this, K2, true);
    }

    public String[] g3() {
        return W3().getBlockAppNameList() == null ? this.E5 : W3().getBlockAppNameList();
    }

    public int g4() {
        String j5 = com.martian.libsupport.h.j(this, getString(R.string.pref_push_interval_time));
        return TextUtils.isEmpty(j5) ? com.cdo.oaps.ad.p.f6558j : Integer.parseInt(j5) / 1000;
    }

    public boolean g5() {
        return com.martian.libsupport.h.d(this, i4, true);
    }

    public boolean g6() {
        return this.G5;
    }

    public void g7() {
        com.martian.libsupport.h.n(this, c3, MartianRPUserManager.t());
    }

    public void g8() {
        int i5 = this.K5 + 60;
        this.K5 = i5;
        w1("pref_user_active_sec", i5);
    }

    public boolean h2() {
        return x5() && MartianRPUserManager.t() - R3() > bj.f5599d;
    }

    public int h3() {
        return I0() ? R.drawable.book_cover_empty_night : R.drawable.book_cover_empty_day;
    }

    public int h4() {
        return com.martian.libsupport.h.f(this, f4, 0);
    }

    public boolean h5() {
        return com.martian.libsupport.h.d(this, m4, false);
    }

    public boolean h6() {
        MartianRPAccount s42 = s4();
        return s42 != null && s42.getIsVip() > 0;
    }

    public void h7(boolean initialed) {
        com.martian.libsupport.h.p(this, N2, initialed);
    }

    public void h8(boolean record) {
        com.martian.libsupport.h.p(this, getString(R.string.send_book_info_pref_key), record);
    }

    public boolean i2() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(getString(R.string.volume_slide_page_pref_key), true);
    }

    public int i3() {
        return I0() ? R.drawable.cover_loading_default_night : R.drawable.cover_loading_default_day;
    }

    public String i4() {
        return com.martian.libsupport.h.j(this, U3);
    }

    public boolean i5() {
        return R0(com.martian.libsupport.h.h(this, V3, -1L));
    }

    public boolean i6() {
        MartianRPAccount s42 = s4();
        return s42 != null && s42.getVipEnd() != null && s42.getVipEnd().longValue() > 0 && MartianRPUserManager.t() > s42.getVipEnd().longValue();
    }

    public void i7() {
        this.n5 = System.currentTimeMillis();
        com.martian.libsupport.h.n(this, O2, System.currentTimeMillis());
    }

    public void i8(boolean record) {
        com.martian.libsupport.h.p(this, getString(R.string.send_ad_info_pref_key), record);
    }

    public int j4() {
        return this.J4.E() ? getResources().getColor(R.color.theme_text_color_4) : this.J4.r().getTextColorPrimary();
    }

    public boolean j5() {
        int i5 = this.M5;
        if (i5 >= 0) {
            return i5 > 0;
        }
        if (J0()) {
            this.M5 = 0;
            return false;
        }
        if (V3().F0()) {
            this.M5 = 1;
            return true;
        }
        if (!W3().isAdCompliance()) {
            this.M5 = 0;
            V3().D0("PREF_MARKET_AD_COMPLIANCE");
        } else if (W3().getAdComplianceControlable()) {
            this.M5 = 1;
        } else if (V3().H("PREF_MARKET_AD_COMPLIANCE")) {
            this.M5 = 0;
        } else {
            this.M5 = 1;
        }
        return this.M5 > 0;
    }

    public boolean j6() {
        MartianRPAccount s42 = s4();
        return s42 != null && s42.getIsVip() <= 0 && s42.getVipEnd() == null;
    }

    public void j7(int brightness) {
        com.martian.libsupport.h.m(this, U2, brightness);
    }

    public void j8(boolean showAdCloseIcon) {
        this.O5 = showAdCloseIcon;
    }

    @Override // com.martian.libmars.d.h
    public int k() {
        int v32 = v3();
        if (v32 != 0) {
            return v32;
        }
        if (!x5() || C4() == null) {
            return I3() ? 2 : 1;
        }
        if (C4().getGender().charValue() == 'M') {
            return 1;
        }
        return (C4().getGender().charValue() == 'F' || I3()) ? 2 : 1;
    }

    public boolean k2(Activity mActivity) {
        return l2(mActivity, 10001);
    }

    public int k3() {
        int f5 = com.martian.libsupport.h.f(this, O3, -1);
        return f5 == -1 ? k() : f5;
    }

    public com.martian.libsliding.slider.g k4() {
        return l4(m4());
    }

    public boolean k5() {
        return this.Q4 && g0() < W3().getCommissionBlockRunTimes().intValue();
    }

    public boolean k6() {
        return this.Q4 && j5();
    }

    public void k7(boolean show) {
        com.martian.libsupport.h.p(this, getString(R.string.show_image_pref_key), show);
    }

    public void k8(boolean show) {
        com.martian.libsupport.h.p(this, getResources().getString(R.string.pref_show_chapter_comment), show);
    }

    public boolean l2(Activity mActivity, int loginType) {
        if (x5()) {
            return true;
        }
        com.martian.mibook.lib.model.g.b.K(mActivity, T3("提示登录", loginType));
        com.martian.mibook.lib.account.e.d.b(mActivity, loginType, !j5());
        return false;
    }

    public MiBookManager l3() {
        if (this.E4 == null) {
            this.E4 = new MiBookManager(getApplicationContext());
        }
        return this.E4;
    }

    public com.martian.libsliding.slider.g l4(int index) {
        if (index == 0) {
            return new com.martian.libsliding.slider.e();
        }
        if (index == 1) {
            return new com.martian.libsliding.slider.d();
        }
        if (index == 2) {
            return new com.martian.libsliding.slider.f();
        }
        if (index == 3) {
            return new com.martian.libsliding.slider.h();
        }
        if (index == 4) {
            return new SimSlider();
        }
        throw new IllegalStateException("Unknown reading slider index: " + index);
    }

    public boolean l5(int type) {
        return type == 101;
    }

    public boolean l6() {
        return this.M4.k() && !this.M4.f10762b.z();
    }

    public void l7(boolean canShowTuia) {
        com.martian.libsupport.h.p(this, K2, canShowTuia);
    }

    public void l8(boolean show) {
        com.martian.libsupport.h.p(this, getResources().getString(R.string.pref_show_menu), show);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m2(j1 activity, boolean force) {
        if (N2()) {
            t tVar = new t(CheckUpgradeParams.class, UpgradeInfo.class, this, activity, force);
            ((CheckUpgradeParams) tVar.k()).setForce(Boolean.valueOf(force));
            tVar.j();
        }
    }

    public String m3(j1 activity, int brType) {
        if (!com.martian.libmars.utils.n0.C(activity)) {
            return "";
        }
        if (brType >= 10) {
            brType /= 10;
        }
        switch (brType) {
            case 1:
                return activity.getString(R.string.category_hot);
            case 2:
                return activity.getString(R.string.category_favorite);
            case 3:
                return activity.getString(R.string.category_read);
            case 4:
                return activity.getString(R.string.category_clicked);
            case 5:
                return activity.getString(R.string.category_potential);
            case 6:
            case 10:
                return activity.getString(R.string.category_recommend);
            case 7:
                return activity.getString(R.string.category_up);
            case 8:
                return activity.getString(R.string.category_search);
            case 9:
            default:
                return activity.getString(R.string.category_sell_well);
            case 11:
                return activity.getString(R.string.category_finished);
        }
    }

    public int m4() {
        String j5 = com.martian.libsupport.h.j(this, f3);
        if (com.martian.libsupport.k.p(j5)) {
            return 1;
        }
        return Integer.parseInt(j5);
    }

    public boolean m5() {
        MiUser C42;
        return V3().x5() && (C42 = V3().C4()) != null && C42.getUid().longValue() % 2 == 0;
    }

    public boolean m6() {
        return this.S4 && j5();
    }

    public void m7() {
        com.martian.libsupport.h.p(this, m4, true);
    }

    public void m8() {
        com.martian.libsupport.h.n(this, Z3, MartianRPUserManager.t());
    }

    public boolean n2(j1 mActivity) {
        return o2(mActivity, 10001);
    }

    public int n3() {
        if (this.z5 < 0) {
            this.z5 = com.martian.libsupport.h.f(getApplicationContext(), C3, 1);
        }
        return this.z5;
    }

    public int n4() {
        return this.J4.E() ? getResources().getColor(R.color.night_text_color_primary) : getResources().getColor(R.color.dark_text_color);
    }

    public boolean n5() {
        return com.martian.libsupport.h.d(this, G3, false);
    }

    public void n7(int val) {
        com.martian.libsupport.h.o(this, getString(R.string.check_update_push_pref_key), String.valueOf(val));
    }

    public void n8(boolean enabled) {
        com.martian.libsupport.h.p(this, d3, enabled);
    }

    public boolean o2(j1 mActivity, int loginType) {
        if (l6()) {
            return true;
        }
        com.martian.mibook.lib.model.g.b.K(mActivity, T3("提示登录", loginType));
        PopupLoginActivity.x0(mActivity, loginType, !j5());
        return false;
    }

    public int o3() {
        return I0() ? R.drawable.border_button_line_grey_night : R.drawable.border_button_line_grey_day;
    }

    public int o4() {
        return this.J4.E() ? getResources().getColor(R.color.night_text_color_secondary) : getResources().getColor(R.color.heavy_grey);
    }

    public boolean o5() {
        return com.martian.libsupport.h.d(this, n4, false);
    }

    public void o7(boolean enable) {
        com.martian.libsupport.h.p(this, o3, enable);
    }

    public void o8(boolean enabled) {
        this.t5 = Boolean.valueOf(enabled);
        com.martian.libsupport.h.p(this, e3, enabled);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle savedInstanceState) {
        t2(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        if (activity instanceof ReadingActivity) {
            X7(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        if (O5() && BaseAd.showCloseAdIcon(activity)) {
            j8(false);
        }
        com.martian.mibook.d.a.a().c(activity.getLocalClassName());
        this.L4.M0(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        R1(activity);
        int i5 = this.b5 + 1;
        this.b5 = i5;
        if (i5 == 1) {
            try {
                l1(true);
                p2(activity);
                NotificationManagerCompat.from(activity).cancel(888);
                V3().Y2().z();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        int i5 = this.b5 - 1;
        this.b5 = i5;
        if (i5 == 0) {
            if (activity instanceof ReadingActivity) {
                X7(true);
            }
            this.H4.a(this);
            l1(false);
            if (h1()) {
                if (G2()) {
                    this.c5 = System.currentTimeMillis();
                    com.martian.libugrowth.b.k().u(this);
                    l3().u3(this);
                }
                this.N4.R(activity);
                com.martian.mibook.lib.model.g.b.P(this, "通知栏-阅读记录-推送");
            }
            this.M5 = -1;
            V3().Y2().A();
        }
    }

    @Override // com.martian.libmars.d.h, android.app.Application
    public void onCreate() {
        super.onCreate();
        if (N0()) {
            Context applicationContext = getApplicationContext();
            P4();
            com.martian.mibook.d.a.a().b();
            UMConfigure.preInit(this, k0.y, m());
            this.K4 = new p0(applicationContext);
            this.J4 = new MiReaderThemeManager(applicationContext);
            this.I4 = new t0();
            this.H4 = new q0();
            this.L4 = new o0(applicationContext);
            this.M4 = new MiCompoundUserManager(applicationContext);
            this.N4 = new g0();
            this.O4 = new w0();
            this.P4 = new AdxManager(this);
            CookieSyncManager.createInstance(applicationContext);
            com.martian.libugrowth.b.k().l(applicationContext);
            l3();
            N4();
            registerActivityLifecycleCallbacks(this);
            if (h1()) {
                a5(true);
            }
        }
    }

    public void p2(Activity activity) {
        if (B8(activity)) {
            return;
        }
        activity.startActivity(new Intent(activity, (Class<?>) EnterRestartActivity.class));
    }

    public int p3() {
        return com.martian.libsupport.h.f(this, U2, 127);
    }

    public int p4() {
        return com.martian.libsupport.h.f(this, Y3, 0);
    }

    public void p7() {
        com.martian.libsupport.h.n(this, V3, MartianRPUserManager.t());
    }

    public String p8(String imei) {
        String w42 = w4();
        if (!com.martian.libsupport.k.p(w42)) {
            if (w42.contains(imei)) {
                return "";
            }
            if (w42.contains(",")) {
                String str = w42 + "," + imei;
                com.martian.libsupport.h.o(this, T2, str);
                return str;
            }
            imei = w42 + "," + imei;
        }
        com.martian.libsupport.h.o(this, T2, imei);
        return "";
    }

    public boolean q2(String type) {
        return R0(N3(type));
    }

    public n0 q3() {
        if (this.G4 == null) {
            this.G4 = new n0(l3());
        }
        return this.G4;
    }

    public int q4() {
        return k() == 2 ? 1 : 2;
    }

    public boolean q5() {
        if (this.v5) {
            this.v5 = L0(r3);
        }
        return this.v5;
    }

    public void q7(int gender) {
        com.martian.libsupport.h.m(this, R3, gender);
    }

    public void q8() {
        com.martian.libsupport.h.n(this, a3, MartianRPUserManager.t() + 21600000);
    }

    public final String[] r2() {
        return W3().getCommentKeywords();
    }

    public AppTask r3(String filename) {
        for (AppTask appTask : this.A5) {
            if (filename.equals(appTask.filename)) {
                return appTask;
            }
        }
        return null;
    }

    public int r4() {
        return com.martian.libsupport.h.f(this, r4, 0);
    }

    public boolean r5() {
        MiTaskAccount x42;
        return (A5() || (x42 = x4()) == null || !x42.isFreshVideoWithdraw()) ? false : true;
    }

    public void r7(boolean isReverseOrder) {
        com.martian.libsupport.h.p(this, G3, isReverseOrder);
    }

    public void r8(String directoryPath) {
        com.martian.libsupport.h.o(getApplicationContext(), A3, directoryPath);
    }

    public AppTask s3(String packageName) {
        for (AppTask appTask : this.A5) {
            if (packageName.equals(appTask.packageName)) {
                return appTask;
            }
        }
        return null;
    }

    public MartianRPAccount s4() {
        return (MartianRPAccount) this.M4.e();
    }

    public boolean s5() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(getString(R.string.global_slide_next_pref_key), false);
    }

    public void s7(String directoryPath) {
        com.martian.libsupport.h.o(getApplicationContext(), y3, directoryPath);
    }

    public void s8(Boolean systemDefault) {
        com.martian.libsupport.h.p(getApplicationContext(), z3, systemDefault.booleanValue());
    }

    @Override // com.martian.libmars.d.h
    public int t0() {
        return R.color.theme_default;
    }

    public void t2(Activity activity) {
        if (activity instanceof j1) {
            if (this.o5 == null) {
                this.o5 = new SparseBooleanArray();
            }
            if (this.o5.get(activity.hashCode())) {
                return;
            }
            this.o5.put(activity.hashCode(), false);
        }
    }

    public int t3() {
        String j5 = com.martian.libsupport.h.j(this, getString(R.string.check_update_push_pref_key));
        if (TextUtils.isEmpty(j5)) {
            return 2;
        }
        return Integer.parseInt(j5);
    }

    public long t4() {
        long j5 = this.p5;
        if (j5 >= -1) {
            return j5;
        }
        String j6 = com.martian.libsupport.h.j(this, W2);
        if (com.martian.libsupport.k.p(j6)) {
            this.p5 = com.alipay.mobilesecuritysdk.constant.a.k;
            return com.alipay.mobilesecuritysdk.constant.a.k;
        }
        long parseLong = Long.parseLong(j6);
        this.p5 = parseLong;
        return parseLong;
    }

    public boolean t5() {
        return this.M4.k() && this.M4.f10762b.z();
    }

    public void t6(j1 activity, MiCompoundUserManager.e listener) {
        this.M4.A();
        y7(-1L);
        this.M4.c(activity, listener);
    }

    public void t7(boolean disable) {
        com.martian.libsupport.h.p(this, P2, disable);
    }

    public void t8(boolean userActivated) {
        this.G5 = userActivated;
    }

    public int u2(int val) {
        int Z22 = Z2();
        if (Z22 < 20) {
            return -1;
        }
        int i5 = Z22 - val;
        this.x5 = i5;
        return i5;
    }

    public boolean u3() {
        return com.martian.libsupport.h.d(this, o3, true);
    }

    public MiSearchManager u4() {
        if (this.F4 == null) {
            this.F4 = new MiSearchManager(getApplicationContext());
        }
        return this.F4;
    }

    public boolean u5() {
        return this.V4 && j5();
    }

    public void u6(boolean donated) {
        com.martian.libsupport.h.p(this, t3, donated);
    }

    public void u7(boolean disable) {
        com.martian.libsupport.h.p(this, M3, disable);
    }

    public void u8() {
        com.martian.libsupport.h.n(this, c4, MartianRPUserManager.t());
        B0(b4);
    }

    public boolean v2() {
        int H32 = H3();
        if (H32 <= 10) {
            return false;
        }
        v7(H32 - 2);
        return true;
    }

    public int v3() {
        return com.martian.libsupport.h.f(this, R3, -1);
    }

    public void v6() {
        com.martian.libsupport.h.t(n3, this, m3, true);
    }

    public void v7(int fontSize) {
        com.martian.libsupport.h.m(getApplicationContext(), u3, fontSize);
        this.w5 = fontSize;
    }

    public void v8(boolean value) {
        com.martian.libsupport.h.p(this, getString(R.string.volume_slide_page_pref_key), value);
    }

    public boolean w2() {
        return MartianRPUserManager.t() < com.martian.libsupport.h.h(this, g4, -1L);
    }

    public String w3() {
        return k0.f11474b + "_" + D4();
    }

    public String w4() {
        return com.martian.libsupport.h.j(this, T2);
    }

    public boolean w5() {
        return com.martian.libsupport.h.d(this, p3, false);
    }

    public void w6(boolean shared) {
        com.martian.libsupport.h.p(this, t3, shared);
    }

    public void w7(boolean value) {
        com.martian.libsupport.h.p(this, getString(R.string.global_slide_next_pref_key), value);
    }

    public boolean w8() {
        return com.martian.libsupport.h.d(this, F3, false);
    }

    public boolean x2() {
        return MartianRPUserManager.t() < c4();
    }

    public AppTask x3(String adsPosition) {
        AppTask k22 = l3().k2(adsPosition);
        if (k22 != null) {
            return k22;
        }
        AppTask appTask = new AppTask();
        appTask.title = "Q玩小游戏";
        appTask.desc = "上千爆款小游戏，即点即玩黑科技，快来下载试玩！";
        appTask.iconUrl = "https://qplay-1251592799.file.myqcloud.com/ic_launcher.png";
        appTask.source = AdConfig.UnionType.DEFAULT;
        appTask.appPromote = "+2000金币";
        appTask.adsPosition = adsPosition;
        appTask.buttonText = "立即前往";
        return appTask;
    }

    public MiTaskAccount x4() {
        return (MiTaskAccount) this.M4.g();
    }

    public boolean x5() {
        return this.M4.k();
    }

    public void x6(boolean changed) {
        com.martian.libsupport.h.p(this, i4, changed);
    }

    public void x7(boolean hasInviter) {
        com.martian.libsupport.h.p(this, J3, hasInviter);
    }

    public boolean x8() {
        if (this.r5 < 0) {
            this.r5 = com.martian.libsupport.h.h(this, Y2, 0L);
        }
        long j5 = this.r5;
        return j5 > 0 && j5 >= MartianRPUserManager.t();
    }

    @Override // com.martian.libmars.d.h
    public com.maritan.libweixin.g y0() {
        return new com.maritan.libweixin.g(k0.f11476d, k0.f11477e, null);
    }

    public boolean y2() {
        return g0() < W3().getAdsRunTimes().intValue();
    }

    public String y3() {
        String j5 = com.martian.libsupport.h.j(getApplicationContext(), y3);
        return com.martian.libsupport.k.p(j5) ? B0 : !new File(j5).exists() ? B0 : com.martian.libsupport.h.j(getApplicationContext(), y3);
    }

    public String y4() {
        return com.martian.libsupport.h.j(this, l3);
    }

    public boolean y5() {
        return R0(com.martian.libsupport.h.h(this, j4, -1L));
    }

    public boolean y6() {
        int f5 = com.martian.libsupport.h.f(this, Q2, 0);
        return f5 == 0 || g0() - f5 > 10;
    }

    public void y7(long leftSeconds) {
        if (leftSeconds >= 0) {
            this.F5 = MartianRPUserManager.t() + leftSeconds;
        } else {
            this.F5 = leftSeconds;
        }
    }

    public boolean y8() {
        long h5 = com.martian.libsupport.h.h(this, c3, -1L);
        return h5 > 0 && S0(h5, true);
    }

    public boolean z2() {
        return com.martian.libsupport.h.d(this, P2, false);
    }

    public int z3() {
        return this.I4.e().dotBackground;
    }

    public int z4() {
        return com.martian.libsupport.h.f(this, w3, 100);
    }

    public boolean z5(boolean needAuth) {
        MiCompoundUserManager miCompoundUserManager;
        if (j5()) {
            return true;
        }
        if (!needAuth || ((miCompoundUserManager = this.M4) != null && miCompoundUserManager.k())) {
            return (this.R4 || this.Q4 || this.S4 || this.U4 || this.V4 || this.W4) && g0() < W3().getMissionBlockRunTimes().intValue();
        }
        return true;
    }

    public boolean z6() {
        int intValue = W3().getAdChapterMinutes().intValue();
        if (intValue <= 0) {
            return true;
        }
        if (this.q5 < 0) {
            this.q5 = com.martian.libsupport.h.h(this, X2, -1L);
        }
        if (R0(this.q5) || Q0()) {
            return MartianRPUserManager.t() - this.q5 > ((long) ((intValue * 60) * 1000));
        }
        d7(MartianRPUserManager.t() - 3000000);
        return false;
    }

    public void z7() {
        com.martian.libsupport.h.p(this, p3, true);
    }

    public boolean z8() {
        return com.martian.libsupport.h.h(this, b3, -1L) < MartianRPUserManager.t();
    }
}
