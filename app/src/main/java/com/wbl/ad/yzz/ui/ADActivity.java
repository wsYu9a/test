package com.wbl.ad.yzz.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.adapter.d.a;
import com.wbl.ad.yzz.adapter.quick.ScrollLinearLayoutManager;
import com.wbl.ad.yzz.base.BaseActivity;
import com.wbl.ad.yzz.bean.AdPageNeedData;
import com.wbl.ad.yzz.c.b.a;
import com.wbl.ad.yzz.c.c.a;
import com.wbl.ad.yzz.config.PageOptions;
import com.wbl.ad.yzz.counttimer.b;
import com.wbl.ad.yzz.dialog.d;
import com.wbl.ad.yzz.feedback.b;
import com.wbl.ad.yzz.network.b.b.a0;
import com.wbl.ad.yzz.network.b.b.j0;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.network.bean.request.UploadFeedbackReq;
import com.wbl.ad.yzz.network.c.d;
import com.wbl.ad.yzz.util.o;
import com.wbl.ad.yzz.view.a;
import com.wbl.ad.yzz.wigdet.h.d;
import com.wbl.ad.yzz.wigdet.h.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ADActivity extends BaseActivity implements com.wbl.ad.yzz.d.d.a {
    private static final int HANDLER_BG = 3002;
    private static final int HANDLER_FINISH = 3001;
    private static final int HANDLER_FIRST_INIT_PLAY = 3010;
    private static final int HANDLER_RETRY_AD = 3013;
    private static final int MSG_STOP_TURN_AROUND_REDPACKET = 3004;
    private static final int MSG_UPDATE_TURN_AROUND_REDPACKET = 3003;
    private static final String TAG = "ADActivity";
    private static long TEN_SECONDS = 20000;

    /* renamed from: a */
    public static String f33887a;
    private View cashOutView;
    private ConstraintLayout feedbackBigCl;
    private ConstraintLayout feedbackSmallCl;
    private boolean isCanStartInstallCounting;
    private int loadingIndex;
    private FrameLayout mAdLayout;
    private AdPageNeedData mAdPageNeedData;
    private com.wbl.ad.yzz.title.a mAdTitle;
    private g0 mAppReceiver;
    private int mCanLeavePageTime;
    private ConstraintLayout mClGuideMask;
    private com.wbl.ad.yzz.dialog.d mClickAdYouLikeDialog;
    private com.wbl.ad.yzz.network.b.b.k mConfBean;
    private CountDownTimer mCountDownTimerInstallApk;
    private CountDownTimer mCountDownTimerLuoDiYe;
    private int mCurrentInvalidType;
    private com.wbl.ad.yzz.wigdet.h.d mDownloadTipsDialog;
    private com.wbl.ad.yzz.feedback.a mFeedbackDialog;
    private RelativeLayout mFloatingBtn;
    private View mGuideContainer;
    private com.wbl.ad.yzz.gudie.d mGuideDailog;
    private View mHeaderView;
    private com.wbl.ad.yzz.counttimer.b mIGuideCustomCountDownTimer;
    private ImageView mIvAdBg;
    private ImageView mIvClose;
    private ImageView mIvFloatingBtn;
    private ImageView mIvGuideAnimation1;
    private ImageView mIvGuideAnimation2;
    private ImageView mIvGuideMask;
    private ImageView mIvMoreIcon;
    private LinearLayout mLlMoreInfoPopupTip;
    private TextView mLoadingTipTextView;
    private CountDownTimer mLoadingTipTimer;
    private h0 mMyHandler;
    private CountDownTimer mPagerCountDownTimer;
    private com.wbl.ad.yzz.d.b.d.b<com.wbl.ad.yzz.d.d.a, com.wbl.ad.yzz.d.a.a> mPresenter;
    private RecyclerView mRecyclerView;
    private int mStartType;
    private TextView mTvGuideMask;
    private TextView mTvGuideMaskDismiss;
    private TextView mTvMoreInfoPopupTip;
    private int mUserId;
    private com.wbl.ad.yzz.adapter.d.a quickAdapter;
    private ScrollLinearLayoutManager scrollLinearLayoutManager;
    private com.wbl.ad.yzz.wigdet.k.d wblPlayerRecyclerPlayControl;
    private List<com.wbl.ad.yzz.adapter.d.b> multipleItemList = new ArrayList();
    private boolean hasStatFirstAdClick = false;
    private boolean hasStatLeaveBtnChange = false;
    private final List<HashMap<String, String>> pointShowData = new ArrayList();
    private final HashSet<String> pointShowDataHistory = new HashSet<>();
    private final List<HashMap<String, String>> pointClickData = new ArrayList();
    private com.wbl.ad.yzz.ui.d mFeedHelper = null;
    private final com.wbl.ad.yzz.innerconfig.d.j mSceneDataInfoWrap = new com.wbl.ad.yzz.innerconfig.d.j();
    private final com.wbl.ad.yzz.ui.f.f mWorker = new com.wbl.ad.yzz.ui.f.f();
    private int stayLuoDiYeTime = 0;
    private int stayInstallApkTime = 0;
    private int mLeaveTotalRp = 0;
    private int stayAdPageTotalTime = 0;
    private boolean isCanClick = true;
    private boolean isCanLeave = false;
    private boolean isClickItem = false;
    private boolean isAlreadyShowToast = false;
    private boolean hasShowInitHandGuide = false;
    private boolean isLeavePageSuccess = false;
    private boolean isLeavePage = false;
    private boolean isInitBg = true;
    private boolean isLoadMore = true;
    private boolean isShowingGuideMask = false;
    private boolean mIsResume = true;
    private final com.wbl.ad.yzz.innerconfig.a mADActivityGrayscaleConfig = new com.wbl.ad.yzz.innerconfig.a();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final com.wbl.ad.yzz.adapter.a mRepeatDownloadWrap = new com.wbl.ad.yzz.adapter.a();
    private final com.wbl.ad.yzz.c.c.a mMembersEntranceWrap = new com.wbl.ad.yzz.c.c.a();
    private final com.wbl.ad.yzz.c.b.a mGoldIncomeWrap = new com.wbl.ad.yzz.c.b.a();
    private final boolean showQuikToast = true;
    private Dialog mLeaveDialog = null;
    private com.wbl.ad.yzz.ui.f.j mCardHandler = new com.wbl.ad.yzz.ui.f.j();
    private b.a mOnFeedbackListener = new q();
    private d.c mOonDownloadTipsDialog = new s();
    private Runnable mCanClickRunnable = new u();
    private boolean hasFinishCalled = false;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9812, this, view);
        }
    }

    public class a0 extends CountDownTimer {
        public a0(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9810, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9809, this, Long.valueOf(j2));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9900, this, view);
        }
    }

    public class b0 implements a.InterfaceGestureDetectorOnGestureListenerC0795a {
        public b0() {
        }

        @Override // com.wbl.ad.yzz.view.a.InterfaceGestureDetectorOnGestureListenerC0795a
        public void a(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9811, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9902, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9901, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9904, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9903, this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3));
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9898, this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9897, this, motionEvent);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9896, this, view);
        }
    }

    public class c0 implements RecyclerView.OnItemTouchListener {

        /* renamed from: a */
        public final /* synthetic */ GestureDetector f33893a;

        public c0(GestureDetector gestureDetector) {
            this.f33893a = gestureDetector;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9899, this, recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9894, this, Boolean.valueOf(z));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9893, this, recyclerView, motionEvent);
        }
    }

    public class d implements com.wbl.ad.yzz.adapter.c.b {
        public d() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9890, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9889, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9892, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9891, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9918, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9917, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9920, this, str, str2, bVar);
        }
    }

    public class d0 implements a.InterfaceC0679a {
        public d0() {
        }

        @Override // com.wbl.ad.yzz.adapter.d.a.InterfaceC0679a
        public void a(View view, com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9895, this, view, bVar, Integer.valueOf(i2));
        }
    }

    public class e implements com.wbl.ad.yzz.adapter.b.d.f {
        public e() {
        }

        @Override // com.wbl.ad.yzz.adapter.b.d.f
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9915, this, null);
        }
    }

    public class e0 implements a.InterfaceC0679a {

        public class a implements a.InterfaceC0697a {

            /* renamed from: a */
            public final /* synthetic */ int f33899a;

            /* renamed from: b */
            public final /* synthetic */ com.wbl.ad.yzz.bean.b f33900b;

            public a(int i2, com.wbl.ad.yzz.bean.b bVar) {
                this.f33899a = i2;
                this.f33900b = bVar;
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void a() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9919, this, null);
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void b() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9914, this, null);
            }

            @Override // com.wbl.ad.yzz.c.c.a.InterfaceC0697a
            public void c() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9913, this, null);
            }
        }

        public e0() {
        }

        @Override // com.wbl.ad.yzz.adapter.d.a.InterfaceC0679a
        public void a(View view, com.wbl.ad.yzz.bean.b bVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9916, this, view, bVar, Integer.valueOf(i2));
        }
    }

    public class f extends com.wbl.ad.yzz.adapter.c.a {
        public f() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.a
        public void a(int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9906, this, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // com.wbl.ad.yzz.adapter.c.a
        public void a(int[] iArr) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9905, this, iArr);
        }
    }

    public class f0 implements com.wbl.ad.yzz.wigdet.d {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9910, this, null);
            }
        }

        public f0() {
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9909, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void a(boolean z, boolean z2, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9912, this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.wigdet.d
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9911, this, null);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9870, this, view);
        }
    }

    public static class g0 extends BroadcastReceiver {

        /* renamed from: a */
        public WeakReference<ADActivity> f33906a;

        public void a(ADActivity aDActivity) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9908, this, aDActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9907, this, context, intent);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9872, this, view);
        }
    }

    public static class h0 extends Handler {

        /* renamed from: a */
        public final WeakReference<ADActivity> f33908a;

        public h0(ADActivity aDActivity) {
            this.f33908a = new WeakReference<>(aDActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9869, this, message);
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9871, this, view);
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9866, this, view);
        }
    }

    public class k implements o.a {

        /* renamed from: a */
        public final /* synthetic */ Handler f33911a;

        public k(ADActivity aDActivity, Handler handler) {
            this.f33911a = handler;
        }

        @Override // com.wbl.ad.yzz.util.o.a
        public void a(Bitmap bitmap) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9865, this, bitmap);
        }
    }

    public class l implements f.InterfaceC0800f {
        public l() {
        }

        @Override // com.wbl.ad.yzz.wigdet.h.f.InterfaceC0800f
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9868, this, null);
        }
    }

    public class m implements f.e {
        public m() {
        }

        @Override // com.wbl.ad.yzz.wigdet.h.f.e
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9867, this, null);
        }
    }

    public class n implements f.d {
        public n() {
        }

        @Override // com.wbl.ad.yzz.wigdet.h.f.d
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9862, this, null);
        }
    }

    public class o implements d.b0<com.wbl.ad.yzz.network.b.b.n> {
        public o() {
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.n nVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9861, this, str, nVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9864, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.n nVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9863, this, str, nVar);
        }
    }

    public class p implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f33916a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9858, this, null);
            }
        }

        public p(boolean z) {
            this.f33916a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9857, this, null);
        }
    }

    public class q implements b.a {
        public q() {
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9860, this, null);
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9859, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.feedback.b.a
        public void a(UploadFeedbackReq uploadFeedbackReq) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9886, this, uploadFeedbackReq);
        }
    }

    public class r implements com.wbl.ad.yzz.adapter.c.b {
        public r() {
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9885, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9888, this, bVar, str, str2, str3, str4);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9887, this, bVar, str, str2, str3, str4, str5);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9882, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9881, this, str, str2, bVar);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void a(boolean z, boolean z2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9884, this, Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }

        @Override // com.wbl.ad.yzz.adapter.c.b
        public void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9883, this, str, str2, bVar);
        }
    }

    public class s implements d.c {
        public s() {
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9878, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9877, this, null);
        }

        @Override // com.wbl.ad.yzz.wigdet.h.d.c
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9880, this, null);
        }
    }

    public class t implements b.a {
        public t() {
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void a(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9879, this, Long.valueOf(j2));
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9874, this, null);
        }

        @Override // com.wbl.ad.yzz.counttimer.b.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9873, this, null);
        }
    }

    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9876, this, null);
        }
    }

    public class v extends CountDownTimer {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.u f33924a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(long j2, long j3, com.wbl.ad.yzz.network.b.b.u uVar) {
            super(j2, j3);
            this.f33924a = uVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9875, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9966, this, Long.valueOf(j2));
        }
    }

    public class w implements d.b {
        public w() {
        }

        @Override // com.wbl.ad.yzz.dialog.d.b
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9965, this, null);
        }
    }

    public class x extends CountDownTimer {
        public x(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9968, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9967, this, Long.valueOf(j2));
        }
    }

    public class y implements a.b {
        public y() {
        }

        @Override // com.wbl.ad.yzz.c.b.a.b
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9962, this, null);
        }

        @Override // com.wbl.ad.yzz.c.b.a.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9961, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.c.b.a.b
        public void a(int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9964, this, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // com.wbl.ad.yzz.c.b.a.b
        public void finish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9963, this, null);
        }
    }

    public class z extends CountDownTimer {
        public z(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9958, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9957, this, Long.valueOf(j2));
        }
    }

    public static /* synthetic */ com.wbl.ad.yzz.innerconfig.d.j E(ADActivity aDActivity) {
        return (com.wbl.ad.yzz.innerconfig.d.j) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9956, null, aDActivity);
    }

    public static /* synthetic */ com.wbl.ad.yzz.c.c.a F(ADActivity aDActivity) {
        return (com.wbl.ad.yzz.c.c.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9955, null, aDActivity);
    }

    public static /* synthetic */ Handler H(ADActivity aDActivity) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9981, null, aDActivity);
    }

    public static /* synthetic */ RelativeLayout K(ADActivity aDActivity) {
        return (RelativeLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9978, null, aDActivity);
    }

    public static /* synthetic */ ImageView L(ADActivity aDActivity) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9977, null, aDActivity);
    }

    public static /* synthetic */ ScrollLinearLayoutManager P(ADActivity aDActivity) {
        return (ScrollLinearLayoutManager) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9973, null, aDActivity);
    }

    public static /* synthetic */ RecyclerView Q(ADActivity aDActivity) {
        return (RecyclerView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9976, null, aDActivity);
    }

    public static /* synthetic */ com.wbl.ad.yzz.wigdet.k.d R(ADActivity aDActivity) {
        return (com.wbl.ad.yzz.wigdet.k.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9975, null, aDActivity);
    }

    public static /* synthetic */ ImageView T(ADActivity aDActivity) {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9969, null, aDActivity);
    }

    public static /* synthetic */ LinearLayout U(ADActivity aDActivity) {
        return (LinearLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9972, null, aDActivity);
    }

    public static /* synthetic */ com.wbl.ad.yzz.ui.d X(ADActivity aDActivity) {
        return (com.wbl.ad.yzz.ui.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9933, null, aDActivity);
    }

    public static /* synthetic */ com.wbl.ad.yzz.d.b.d.b Z(ADActivity aDActivity) {
        return (com.wbl.ad.yzz.d.b.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9935, null, aDActivity);
    }

    public static /* synthetic */ CountDownTimer a(ADActivity aDActivity, CountDownTimer countDownTimer) {
        return (CountDownTimer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9930, null, aDActivity, countDownTimer);
    }

    public static /* synthetic */ com.wbl.ad.yzz.dialog.d a(ADActivity aDActivity, com.wbl.ad.yzz.dialog.d dVar) {
        return (com.wbl.ad.yzz.dialog.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9929, null, aDActivity, dVar);
    }

    public static /* synthetic */ TextView e0(ADActivity aDActivity) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9940, null, aDActivity);
    }

    public static /* synthetic */ com.wbl.ad.yzz.title.a f0(ADActivity aDActivity) {
        return (com.wbl.ad.yzz.title.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10029, null, aDActivity);
    }

    public static /* synthetic */ com.wbl.ad.yzz.c.b.a g0(ADActivity aDActivity) {
        return (com.wbl.ad.yzz.c.b.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10026, null, aDActivity);
    }

    public static /* synthetic */ AdPageNeedData k(ADActivity aDActivity) {
        return (AdPageNeedData) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10020, null, aDActivity);
    }

    public static /* synthetic */ List m(ADActivity aDActivity) {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10046, null, aDActivity);
    }

    public static /* synthetic */ FrameLayout o(ADActivity aDActivity) {
        return (FrameLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10048, null, aDActivity);
    }

    public static /* synthetic */ List p(ADActivity aDActivity) {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10047, null, aDActivity);
    }

    public static /* synthetic */ HashSet q(ADActivity aDActivity) {
        return (HashSet) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10042, null, aDActivity);
    }

    public static /* synthetic */ List r(ADActivity aDActivity) {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10041, null, aDActivity);
    }

    public static /* synthetic */ com.wbl.ad.yzz.adapter.d.a z(ADActivity aDActivity) {
        return (com.wbl.ad.yzz.adapter.d.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10033, null, aDActivity);
    }

    public final void A() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10036, this, null);
    }

    public final void B() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10035, this, null);
    }

    public final void C() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9998, this, null);
    }

    public final void D() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9997, this, null);
    }

    public final void E() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10000, this, null);
    }

    public final void F() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9999, this, null);
    }

    public final boolean G() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9994, this, null);
    }

    public final boolean H() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9993, this, null);
    }

    public final void I() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9996, this, null);
    }

    public final boolean J() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9995, this, null);
    }

    public final void K() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9990, this, null);
    }

    public final void L() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9989, this, null);
    }

    public final void M() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9992, this, null);
    }

    public final void N() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9991, this, null);
    }

    public final void O() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9986, this, null);
    }

    public final void P() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9985, this, null);
    }

    public final void Q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9988, this, null);
    }

    public final void R() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9987, this, null);
    }

    public final void S() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10014, this, null);
    }

    public final void T() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10013, this, null);
    }

    public final void U() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10016, this, null);
    }

    public final void V() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10015, this, null);
    }

    public final void W() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10010, this, null);
    }

    public final void X() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10009, this, null);
    }

    public final void Y() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10012, this, null);
    }

    public final void Z() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10011, this, null);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10006, this, null);
    }

    public final void a(int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10005, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void a(int i2, int i3, k0 k0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10008, this, Integer.valueOf(i2), Integer.valueOf(i3), k0Var);
    }

    public final void a(int i2, int i3, k0 k0Var, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10007, this, Integer.valueOf(i2), Integer.valueOf(i3), k0Var, Boolean.valueOf(z2));
    }

    public final void a(int i2, k0 k0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10002, this, Integer.valueOf(i2), k0Var);
    }

    public final void a(int i2, String str, String str2, String str3, String str4, String str5, String str6, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10001, this, Integer.valueOf(i2), str, str2, str3, str4, str5, str6, bVar);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity
    public void a(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10004, this, bundle);
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, String str, String str2, String str3, String str4, String str5, com.wbl.ad.yzz.bean.b bVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10003, this, bVar, str, str2, str3, str4, str5, bVar2);
    }

    public final void a(a0.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10094, this, bVar);
    }

    public final void a(j0 j0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10093, this, j0Var);
    }

    public final void a(u.g gVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10096, this, gVar);
    }

    public final void a(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10095, this, uVar);
    }

    public final void a(com.wbl.ad.yzz.network.b.b.v vVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10090, this, vVar);
    }

    public final void a(Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10089, this, obj);
    }

    public final void a(String str, ImageView imageView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10092, this, str, imageView);
    }

    public final void a(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10091, this, str, str2, bVar);
    }

    public final void a(String str, Map<String, String> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10086, this, str, map);
    }

    public final void a(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10085, this, Boolean.valueOf(z2));
    }

    public final void a(boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10088, this, Boolean.valueOf(z2), str, str2, str3, str4, str5, str6, str7, str8, str9, Integer.valueOf(i2));
    }

    public final void a(boolean z2, String str, boolean z3, int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10087, this, Boolean.valueOf(z2), str, Boolean.valueOf(z3), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void a(boolean z2, boolean z3, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10082, this, Boolean.valueOf(z2), Boolean.valueOf(z3), str);
    }

    public final boolean a(int i2, com.wbl.ad.yzz.network.b.b.u uVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10081, this, Integer.valueOf(i2), uVar);
    }

    public final void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10084, this, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity
    public void b(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10083, this, activity);
    }

    public final void b(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10110, this, uVar);
    }

    public final void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10109, this, str);
    }

    public final void b(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10112, this, str, str2);
    }

    public final void b(String str, String str2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10111, this, str, str2, bVar);
    }

    public final void b(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10106, this, Boolean.valueOf(z2));
    }

    public final void c(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10105, this, Integer.valueOf(i2));
    }

    public final void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10108, this, str);
    }

    public final void c(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10107, this, Boolean.valueOf(z2));
    }

    public final boolean c(com.wbl.ad.yzz.network.b.b.u uVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10102, this, uVar);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity
    public int d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10101, this, null);
    }

    public final void d(com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10104, this, uVar);
    }

    public final void d(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10103, this, str);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10098, this, keyEvent);
    }

    public final int e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10097, this, null);
    }

    public final void e(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10100, this, str);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10099, this, null);
    }

    @Override // android.app.Activity
    public void finish() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10062, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10061, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void getConfErr(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10064, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void getConfSucess(com.wbl.ad.yzz.network.b.b.k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10063, this, kVar);
    }

    public void getGlideCacheBitmap(Handler handler, u.g gVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10058, this, handler, gVar);
    }

    public com.wbl.ad.yzz.innerconfig.d.d getSceneCache() {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10057, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10060, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10059, this, null);
    }

    public final void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10054, this, null);
    }

    public final void k() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10053, this, null);
    }

    public final void l() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10056, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadAdError(com.wbl.ad.yzz.d.c.a<Object> aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10055, this, aVar);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10050, this, list);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadLeaveError(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10049, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadLeaveSuccess(com.wbl.ad.yzz.network.b.b.a0 a0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10052, this, a0Var);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadPageMsgError(boolean z2, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10051, this, Boolean.valueOf(z2), str, str2);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadPageMsgSuccess(boolean z2, Object obj, com.wbl.ad.yzz.network.b.b.u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10078, this, Boolean.valueOf(z2), obj, uVar);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadUpRpError(int i2, String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10077, this, Integer.valueOf(i2), str, str2);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void loadUpRpSuccess(k0 k0Var, int i2, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10080, this, k0Var, Integer.valueOf(i2), bVar);
    }

    public final void m() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10079, this, null);
    }

    public final void n() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10074, this, null);
    }

    public final void o() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10073, this, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10076, this, configuration);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10075, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10070, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10069, this, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10072, this, null);
    }

    public final void p() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10071, this, null);
    }

    public final com.wbl.ad.yzz.ui.d q() {
        return (com.wbl.ad.yzz.ui.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10066, this, null);
    }

    public final PageOptions r() {
        return (PageOptions) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10065, this, null);
    }

    public void retryLoadAdPageInfo(Object obj) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10068, this, obj);
    }

    public final com.wbl.ad.yzz.innerconfig.d.e s() {
        return (com.wbl.ad.yzz.innerconfig.d.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10067, this, null);
    }

    public void showMoreAdPopupView(boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10158, this, Boolean.valueOf(z2));
    }

    public void stopLoadingTipTimer() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10157, this, null);
    }

    public void stopTurnAroundRedPacket() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10160, this, null);
    }

    public final boolean t() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10159, this, null);
    }

    public final boolean u() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10154, this, null);
    }

    public void updateTurnAroundRedPacket() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10153, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void uploadFeedbackError(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10156, this, str);
    }

    @Override // com.wbl.ad.yzz.d.d.a
    public void uploadFeedbackSuccess() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10155, this, null);
    }

    public final void v() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10150, this, null);
    }

    public final void w() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10149, this, null);
    }

    public final void x() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10152, this, null);
    }

    public final void y() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10151, this, null);
    }

    public final void z() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10146, this, null);
    }
}
