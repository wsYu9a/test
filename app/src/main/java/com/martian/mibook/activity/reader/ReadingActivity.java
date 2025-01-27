package com.martian.mibook.activity.reader;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.BaseAd;
import com.martian.ads.ad.DXAd;
import com.martian.ads.ad.DefaultAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.VivoAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.h1;
import com.martian.libmars.activity.j1;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.libmars.utils.v0;
import com.martian.libmars.widget.ScrollTabWidget;
import com.martian.libsliding.SlidingLayout;
import com.martian.libsliding.f;
import com.martian.libsupport.permission.TipInfo;
import com.martian.mibook.activity.Homepage;
import com.martian.mibook.activity.TtsOptimizeActivity;
import com.martian.mibook.activity.account.IncomeActivity;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.martian.mibook.activity.book.comment.WholeCommentActivity;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.TypefaceManager;
import com.martian.mibook.application.n0;
import com.martian.mibook.data.book.ChapterCommentCount;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.e.b6;
import com.martian.mibook.e.c5;
import com.martian.mibook.e.d6;
import com.martian.mibook.e.e5;
import com.martian.mibook.e.e6;
import com.martian.mibook.e.f6;
import com.martian.mibook.e.f7;
import com.martian.mibook.e.g7;
import com.martian.mibook.e.k6;
import com.martian.mibook.e.l6;
import com.martian.mibook.e.n6;
import com.martian.mibook.e.o6;
import com.martian.mibook.e.p5;
import com.martian.mibook.e.p6;
import com.martian.mibook.e.q5;
import com.martian.mibook.e.q6;
import com.martian.mibook.e.t5;
import com.martian.mibook.e.u6;
import com.martian.mibook.e.v5;
import com.martian.mibook.e.x5;
import com.martian.mibook.e.y5;
import com.martian.mibook.f.q3;
import com.martian.mibook.f.z3;
import com.martian.mibook.h.g;
import com.martian.mibook.j.s2;
import com.martian.mibook.j.v2;
import com.martian.mibook.j.x2;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.e.c;
import com.martian.mibook.lib.account.request.BookAlertParams;
import com.martian.mibook.lib.account.request.auth.RtParams;
import com.martian.mibook.lib.account.response.Bonus;
import com.martian.mibook.lib.account.response.BookAdsInfo;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.MiReadingContent;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.service.TtsService;
import com.martian.mibook.tts.TTSController;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.mibook.ui.colorpicker.LineColorPicker;
import com.martian.mibook.ui.o.i4;
import com.martian.mibook.ui.o.o4;
import com.martian.mibook.ui.o.q4;
import com.martian.mibook.ui.reader.ReaderRoundColorView;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import com.martian.ttbookhd.R;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import me.jessyan.autosize.internal.CancelAdapt;

/* loaded from: classes.dex */
public class ReadingActivity extends com.martian.libmars.activity.f1 implements n0.b, f.a, com.martian.mibook.g.c, i4.w, CancelAdapt, g.a {
    public static final String C = "INTENT_READING_BOOK_INFO";
    private static final int D = 5;
    public static String E = "INTENT_READING_BONUS";
    public static String F = "INTENT_READING_NIGHT_MODE";
    public static float G = 1.2f;
    public static float H = 1.45f;
    public static float I = 1.7f;
    private com.martian.mibook.application.f0 A0;
    private com.martian.mibook.h.g B0;
    private boolean G0;
    private com.martian.mibook.e.p J;
    private f6 K;
    private l6 L;
    private int L0;
    private p6 M;
    private p5 N;
    private n6 O;
    private boolean O0;
    private v5 P;
    private b6 Q;
    private q5 R;
    private e6 S;
    private o6 T;
    private t5 U;
    private f7 V;
    private g7 W;
    private ObjectAnimator X;
    private y5 Y;
    private k6 Z;
    private u6 a0;
    private q6 b0;
    private o4 b1;
    private c5 c0;
    private com.martian.mibook.ui.n c1;
    private d6 d0;
    private com.martian.mibook.b.b d1;
    private x5 e0;
    private AppTaskList e1;
    private ReadingInfo f0;
    private Handler f1;
    private Book g0;
    private ChapterList h0;
    private AdConfig.AdInfo h1;
    private List<MiReadingRecord> i0;
    private boolean i1;
    private i4 j0;
    private PopupWindow j1;
    private q4 k1;
    private List<TYBookItem> m0;
    private MiBookManager.m0 m1;
    private com.martian.mibook.ui.j n0;
    private BottomSheetBehavior<View> n1;
    private com.martian.mibook.tts.b o0;
    private BottomSheetBehavior<View> o1;
    private int u0;
    private int x0;
    private int y0;
    private Fragment[] z0;
    private boolean k0 = true;
    private boolean l0 = false;
    private boolean p0 = false;
    private String q0 = "";
    private int r0 = 0;
    private boolean s0 = false;
    private long t0 = -1;
    private int v0 = -1;
    private String w0 = "";
    private final BroadcastReceiver C0 = new a0();
    private final Handler D0 = new Handler();
    private final Runnable F0 = new Runnable() { // from class: com.martian.mibook.activity.reader.m
        @Override // java.lang.Runnable
        public final void run() {
            ReadingActivity.this.f8();
        }
    };
    private boolean H0 = true;
    private boolean I0 = false;
    private boolean J0 = true;
    private CacheStatus K0 = CacheStatus.None;
    private final Handler M0 = new Handler();
    private final Runnable N0 = new Runnable() { // from class: com.martian.mibook.activity.reader.b1
        @Override // java.lang.Runnable
        public final void run() {
            ReadingActivity.this.h7();
        }
    };
    private int P0 = 0;
    private long Q0 = System.currentTimeMillis();
    private boolean R0 = false;
    private boolean S0 = false;
    private boolean T0 = false;
    private int U0 = 0;
    private int V0 = 0;
    private int W0 = 0;
    private final int X0 = 300;
    private final int Y0 = 3;
    private final Runnable Z0 = new i();
    private boolean a1 = false;
    private final Runnable g1 = new n();
    private final int l1 = 2;

    /* loaded from: classes3.dex */
    public enum CacheStatus {
        None,
        Caching,
        Finished,
        Error,
        Abort
    }

    /* loaded from: classes3.dex */
    class a implements DrawerLayout.DrawerListener {
        a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(@NonNull View view) {
            ReadingActivity.this.J.f12502b.setDrawerLockMode(1);
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(@NonNull View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(@NonNull View view, float v) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int i2) {
        }
    }

    /* loaded from: classes3.dex */
    class a0 extends BroadcastReceiver {
        a0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context arg0, Intent intent) {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            ReadingActivity.this.r0 = intExtra2 > 0 ? (intExtra * 100) / intExtra2 : 50;
            ReadingActivity.this.R7();
        }
    }

    /* loaded from: classes3.dex */
    class b extends com.martian.libmars.utils.tablayout.f {

        /* renamed from: b */
        final /* synthetic */ List f11092b;

        b(final List val$fragmentSections) {
            this.f11092b = val$fragmentSections;
        }

        /* renamed from: i */
        public /* synthetic */ void j(final int index, View v) {
            ReadingActivity.this.Q.f11763c.setCurrentItem(index);
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public int a() {
            return this.f11092b.size();
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.h b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.g(2).j(com.martian.libmars.d.h.b(5.0f)).e(com.martian.libmars.d.h.b(2.0f)).f(com.martian.libmars.d.h.b(16.0f)).h(com.martian.libmars.d.h.b(2.0f)).i(new AccelerateInterpolator()).d(new DecelerateInterpolator(2.0f)).c(Integer.valueOf(ContextCompat.getColor(context, R.color.theme_default)));
            return linePagerIndicator;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.j c(Context context, final int index) {
            com.martian.libmars.utils.tablayout.d dVar = new com.martian.libmars.utils.tablayout.d(context, false);
            dVar.setText(((v0.a) this.f11092b.get(index)).b());
            dVar.setTextSize(16.0f);
            dVar.setNormalColor(com.martian.libmars.d.h.F().r0());
            dVar.setSelectedColor(ContextCompat.getColor(ReadingActivity.this, R.color.theme_default));
            dVar.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.b.this.j(index, view);
                }
            });
            return dVar;
        }
    }

    /* loaded from: classes3.dex */
    class b0 extends com.martian.mibook.lib.model.d.f {
        b0() {
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void a(boolean loading) {
            ReadingActivity.this.i2(loading);
        }

        @Override // com.martian.mibook.lib.model.d.f
        @SuppressLint({"SetTextI18n"})
        public void b(int n) {
            ReadingActivity.this.J.z.setText(ReadingActivity.this.getString(R.string.already_load) + n + "章...");
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void c(ChapterList chapterList) {
            if (chapterList == null || chapterList.getCount() == 0) {
                ReadingActivity.this.R3(true);
                return;
            }
            ReadingActivity.this.f7(chapterList);
            ReadingActivity.this.C4();
            ReadingActivity.this.R3(false);
            MiConfigSingleton.V3().l3().t3(ReadingActivity.this.g0);
            ReadingActivity.this.Z3();
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void d(b.d.c.b.c errorResult) {
            ReadingActivity.this.R3(true);
        }
    }

    /* loaded from: classes3.dex */
    class c implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        final /* synthetic */ CommonNavigator f11095a;

        c(final CommonNavigator val$commonNavigator) {
            this.f11095a = val$commonNavigator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float v, int i1) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (i2 == this.f11095a.getTitleCount() - 1) {
                ReadingActivity.this.J.f12502b.setDrawerLockMode(0);
                ReadingActivity.this.Q.f11769i.setVisibility(8);
                ReadingActivity.this.Q.f11768h.setVisibility(8);
            } else {
                ReadingActivity.this.J.f12502b.setDrawerLockMode(2);
                ReadingActivity.this.Q.f11769i.setVisibility(0);
                ReadingActivity.this.Q.f11768h.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    class c0 extends com.martian.mibook.lib.model.d.f {

        /* renamed from: a */
        final /* synthetic */ boolean f11097a;

        c0(final boolean val$fromLocalFailure) {
            this.f11097a = val$fromLocalFailure;
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void a(boolean loading) {
            if (this.f11097a) {
                ReadingActivity.this.i2(loading);
            }
        }

        @Override // com.martian.mibook.lib.model.d.f
        @SuppressLint({"SetTextI18n"})
        public void b(int n) {
            if (this.f11097a) {
                ReadingActivity.this.J.z.setText(ReadingActivity.this.getString(R.string.already_load) + n + "章...");
            }
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void c(ChapterList chapterList) {
            if (chapterList == null || chapterList.getCount() == 0) {
                if (this.f11097a) {
                    ReadingActivity.this.g4("章节列表为空");
                }
            } else {
                ReadingActivity.this.f7(chapterList);
                if (this.f11097a) {
                    ReadingActivity.this.C4();
                    ReadingActivity.this.Z3();
                }
            }
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void d(b.d.c.b.c errorResult) {
            if (this.f11097a) {
                ReadingActivity.this.g4("获取章节列表失败，请重试~");
            }
        }
    }

    /* loaded from: classes3.dex */
    class d implements com.martian.libsupport.permission.f {
        d() {
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            ReadingActivity.this.k1("缺少存储权限");
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            ReadingActivity.this.S0();
        }
    }

    /* loaded from: classes3.dex */
    class d0 implements i4.u {
        d0() {
        }

        @Override // com.martian.mibook.ui.o.i4.u
        public void a(boolean hide) {
            ReadingActivity.this.p0 = hide;
            ReadingActivity readingActivity = ReadingActivity.this;
            readingActivity.o7(readingActivity.J.k.getRoot(), !hide, com.martian.libmars.utils.h0.f10146c);
            if (!hide) {
                ReadingActivity.this.A7();
            }
            b(hide);
        }

        @Override // com.martian.mibook.ui.o.i4.u
        public void b(boolean hide) {
            if (ReadingActivity.this.R == null || ReadingActivity.this.q7() || ReadingActivity.this.N4() || ReadingActivity.this.l0) {
                return;
            }
            ReadingActivity readingActivity = ReadingActivity.this;
            readingActivity.o7(readingActivity.R.getRoot(), !hide, com.martian.libmars.utils.h0.f10144a);
            ReadingActivity.this.G0 = hide;
        }
    }

    /* loaded from: classes3.dex */
    class e implements h1.a {

        /* renamed from: a */
        final /* synthetic */ MiReadingTheme f11101a;

        e(final MiReadingTheme val$customTheme) {
            this.f11101a = val$customTheme;
        }

        @Override // com.martian.libmars.activity.h1.a
        public void a(Uri uri, String filepath) {
            this.f11101a.setCustomBackgroundImage(filepath);
            ReadingActivity.this.P3();
        }

        @Override // com.martian.libmars.activity.h1.a
        public void onCancelled() {
        }
    }

    /* loaded from: classes3.dex */
    class e0 implements v2.x {
        e0() {
        }

        @Override // com.martian.mibook.j.v2.x
        public void a() {
            ReadingActivity.this.b7();
        }

        @Override // com.martian.mibook.j.v2.x
        public void b() {
            ReadingActivity.this.U3();
        }
    }

    /* loaded from: classes3.dex */
    class f implements com.martian.libsupport.permission.f {

        /* renamed from: a */
        final /* synthetic */ int f11104a;

        class a extends b.d.c.c.g<Void, Integer> {

            /* renamed from: a */
            final /* synthetic */ int f11106a;

            /* renamed from: b */
            final /* synthetic */ Source f11107b;

            a(final int val$source, final Source val$index) {
                this.f11106a = val$source;
                this.f11107b = val$index;
            }

            @Override // b.d.c.c.g
            /* renamed from: f */
            public Integer doInBackground(Void... params) {
                for (int i2 = this.f11106a; i2 < ReadingActivity.this.h0.getCount(); i2++) {
                    if (!MiConfigSingleton.V3().l3().o0(this.f11107b, ReadingActivity.this.h0.getItem(i2))) {
                        return Integer.valueOf(i2);
                    }
                }
                return Integer.valueOf(ReadingActivity.this.h0.getCount() - 1);
            }

            @Override // b.d.c.c.g
            /* renamed from: g */
            public void onPostExecute(Integer startIndex) {
                super.onPostExecute(startIndex);
                MiConfigSingleton.V3().q3().A(ReadingActivity.this.g0, ReadingActivity.this);
                MiConfigSingleton.V3().q3().y(ReadingActivity.this.g0, ReadingActivity.this.h0, startIndex.intValue(), MiConfigSingleton.V3().h6() ? 200 : 50, ReadingActivity.this);
            }

            @Override // b.d.c.c.g
            protected void showLoading(boolean show) {
            }
        }

        f(final int val$start) {
            this.f11104a = val$start;
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            ReadingActivity.this.k1("缺少存储权限");
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            if (ReadingActivity.this.h0 == null) {
                ReadingActivity.this.k1("章节信息加载失败");
                return;
            }
            int max = Math.max(this.f11104a, ReadingActivity.this.L0);
            ReadingActivity.this.U.f12739b.setVisibility(0);
            if (max >= ReadingActivity.this.h0.getCount()) {
                ReadingActivity.this.U.s.setText(MiConfigSingleton.V3().n("全部章节已缓存"));
                ReadingActivity.this.U.r.setText("");
                ReadingActivity.this.U.t.setText("");
            } else {
                ReadingActivity.this.U.s.setText(MiConfigSingleton.V3().n("正在缓存: "));
                ReadingActivity.this.U.r.setText(ReadingActivity.this.j4());
                ReadingActivity.this.U.t.setText("(计算中...)");
                ReadingActivity.this.K0 = CacheStatus.Caching;
                new a(max, new Source(ReadingActivity.this.g0.getSourceName(), ReadingActivity.this.g0.getSourceId())).execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    class f0 implements v2.x {
        f0() {
        }

        @Override // com.martian.mibook.j.v2.x
        public void a() {
            MiConfigSingleton.V3().L4.B0(ReadingActivity.this, null);
        }

        @Override // com.martian.mibook.j.v2.x
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    class g implements c.e {
        g() {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void a(b.d.c.b.c errorResult) {
            if (ReadingActivity.this.j0 != null) {
                ReadingActivity.this.j0.q3(ReadingActivity.this.j0.A0());
                ReadingActivity.this.j0.q3(ReadingActivity.this.j0.G0());
            }
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void b(MartianRPAccount rpAccount) {
            if (ReadingActivity.this.j0 != null) {
                ReadingActivity.this.j0.q3(ReadingActivity.this.j0.A0());
                ReadingActivity.this.j0.q3(ReadingActivity.this.j0.G0());
            }
        }
    }

    /* loaded from: classes3.dex */
    class g0 implements SlidingLayout.a {
        g0() {
        }

        @Override // com.martian.libsliding.SlidingLayout.a
        public void a(Object obj) {
            if (obj == null) {
                return;
            }
            MiReadingContent.MiContentCursor miContentCursor = (MiReadingContent.MiContentCursor) obj;
            int chapterIndex = miContentCursor.getContent().getChapterIndex();
            int contentIndex = miContentCursor.getContentIndex();
            if (ReadingActivity.this.T4()) {
                TtsService.W(ReadingActivity.this, TtsService.f14109j, chapterIndex, contentIndex, miContentCursor.getContent().getEndPosSize(), false);
            }
            ReadingActivity.this.f0.getRecord().setChapterIndex(Integer.valueOf(chapterIndex));
            if (miContentCursor.getContent().isReady()) {
                ReadingActivity.this.f0.getRecord().setContentIndex(Integer.valueOf(contentIndex));
                ReadingActivity.this.f0.getRecord().setContentSize(0);
                if (miContentCursor.getContent().getChapter() != null) {
                    ReadingActivity.this.f0.getRecord().setChapterTitle(miContentCursor.getContent().getChapter().getTitle());
                }
                if (ReadingActivity.this.N4()) {
                    ReadingActivity.this.o0.e(miContentCursor);
                }
            }
        }

        @Override // com.martian.libsliding.SlidingLayout.a
        public void b(int touchResult) {
            if (touchResult <= 1) {
                ReadingActivity.this.D7(false);
                ReadingActivity.this.Q0 = System.currentTimeMillis();
                MiConfigSingleton.V3().P1(ReadingActivity.this.U0);
                if (ReadingActivity.this.f0 == null || !ReadingActivity.this.f0.isFirstSlide()) {
                    return;
                }
                ReadingActivity.this.f0.setFirstSlide(false);
                if (!com.martian.libmars.d.h.F().H("first_slide")) {
                    com.martian.libmars.d.h.F().D0("first_slide");
                    com.martian.mibook.lib.model.g.b.H(ReadingActivity.this, "滑动翻页");
                }
                if (ReadingActivity.this.Z != null) {
                    ReadingActivity.this.Z.getRoot().setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class h extends com.martian.mibook.lib.account.d.q.i0 {

        /* renamed from: j */
        final /* synthetic */ boolean f11112j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(j1 x0, final boolean val$fromLogin) {
            super(x0);
            this.f11112j = val$fromLogin;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            ReadingActivity.this.S0 = false;
            ReadingActivity.this.W3();
            ReadingActivity.this.W0 = 0;
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Bonus bonus) {
            ReadingActivity.this.S0 = false;
            ReadingActivity.this.W0 = 0;
            if (com.martian.libmars.utils.n0.c(ReadingActivity.this)) {
                return;
            }
            if (bonus != null && bonus.getCoins() > 0) {
                if (this.f11112j) {
                    com.martian.libmars.utils.w0.b(ReadingActivity.this, "    阅读奖励    ", "+" + bonus.getCoins() + ReadingActivity.this.getString(R.string.bonus_unit), null);
                }
                ReadingActivity.this.P0 += bonus.getCoins();
                ReadingActivity.this.A7();
            }
            if (ReadingActivity.this.U0 < 400 && ReadingActivity.this.S4()) {
                ReadingActivity.this.S3(false);
            }
            if (ReadingActivity.this.f0 != null) {
                ReadingActivity.this.f0.setReadingHint(MiConfigSingleton.V3().l3().t2(ReadingActivity.this.f0.isFirstSlide()));
                ReadingActivity.this.f0.setEnableWblAd(MiConfigSingleton.V3().Q2());
            }
            if (MiConfigSingleton.V3().B5()) {
                com.martian.libugrowth.b.k().t(ReadingActivity.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ReadingActivity.this.a1 && System.currentTimeMillis() - ReadingActivity.this.Q0 <= 25000) {
                ReadingActivity.this.W0 += 3;
                ReadingActivity.this.U0 += 3;
                if (ReadingActivity.this.W0 >= 300) {
                    ReadingActivity.this.J3(false);
                }
                ReadingActivity.this.J.k.f12627j.setProgress(ReadingActivity.this.W0);
            }
            ReadingActivity.this.M0.postDelayed(ReadingActivity.this.Z0, 3000L);
        }
    }

    /* loaded from: classes3.dex */
    class j implements SeekBar.OnSeekBarChangeListener {
        j() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        @SuppressLint({"SetTextI18n"})
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (ReadingActivity.this.h0 == null) {
                ReadingActivity.this.k1("请等待数据加载完毕");
                return;
            }
            if (progress >= ReadingActivity.this.h0.getCount()) {
                ReadingActivity.this.k1("检索失败");
                return;
            }
            Chapter item = ReadingActivity.this.h0.getItem(progress);
            if (item != null) {
                ReadingActivity.this.U.f12744g.setText(item.getTitle());
                ReadingActivity.this.U.f12741d.setText((progress + 1) + "/" + ReadingActivity.this.h0.getCount());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            ReadingActivity.this.U.f12743f.setVisibility(0);
            if (ReadingActivity.this.i0 == null) {
                ReadingActivity.this.i0 = new ArrayList();
            }
            MiReadingRecord miReadingRecord = new MiReadingRecord();
            miReadingRecord.setChapterIndex(Integer.valueOf(ReadingActivity.this.f0.getRecord().getChapterIndex()));
            miReadingRecord.setContentIndex(ReadingActivity.this.f0.getRecord().getContentIndex());
            miReadingRecord.setContentSize(ReadingActivity.this.f0.getRecord().getContentSize());
            ReadingActivity.this.i0.add(0, miReadingRecord);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (ReadingActivity.this.j0 == null || ReadingActivity.this.h0 == null) {
                ReadingActivity.this.k1("请等待数据加载完毕");
                return;
            }
            ReadingActivity.this.U6("章节进度条-拖动");
            ReadingActivity.this.z4(Integer.valueOf(seekBar.getProgress()), 0, 0);
            ReadingActivity.this.T7();
        }
    }

    /* loaded from: classes3.dex */
    class k implements com.martian.mibook.lib.model.c.g {

        /* renamed from: a */
        final /* synthetic */ String f11115a;

        /* renamed from: b */
        final /* synthetic */ String f11116b;

        k(final String val$sourceId, final String val$sourceName) {
            this.f11115a = val$sourceId;
            this.f11116b = val$sourceName;
        }

        @Override // com.martian.mibook.lib.model.c.g
        public String getSourceId() {
            return this.f11116b;
        }

        @Override // com.martian.mibook.lib.model.c.g
        public String getSourceName() {
            return this.f11115a;
        }
    }

    /* loaded from: classes3.dex */
    class l implements SeekBar.OnSeekBarChangeListener {
        l() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            ReadingActivity.this.V0(progress + 5);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (MiConfigSingleton.V3().S5()) {
                ReadingActivity.this.b8(false);
            }
            MiConfigSingleton.V3().j7(seekBar.getProgress() + 5);
        }
    }

    /* loaded from: classes3.dex */
    class m implements SeekBar.OnSeekBarChangeListener {
        m() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ReadingActivity.this.Q3(seekBar.getProgress());
        }
    }

    /* loaded from: classes3.dex */
    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ReadingActivity.this.s0) {
                if (ReadingActivity.this.u0 > 0) {
                    ReadingActivity readingActivity = ReadingActivity.this;
                    readingActivity.c4(readingActivity.u0);
                    ReadingActivity.this.u0 = 0;
                } else {
                    if (ReadingActivity.this.R.getRoot().getVisibility() != 0) {
                        ReadingActivity.this.c4(5000);
                        return;
                    }
                    if (System.currentTimeMillis() - ReadingActivity.this.t0 >= ReadingActivity.this.i4()) {
                        ReadingActivity.this.t0 = System.currentTimeMillis();
                        ReadingActivity.this.A0.l(ReadingActivity.this.g0 == null ? "" : ReadingActivity.this.g0.getSourceString(), ReadingActivity.this.h1);
                    }
                    ReadingActivity readingActivity2 = ReadingActivity.this;
                    readingActivity2.c4(readingActivity2.i4());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class o extends b.d.a.k.b {
        o() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void j(AdConfig config) {
            ReadingActivity.this.R6(config.getAdTag());
        }
    }

    /* loaded from: classes3.dex */
    class p implements v2.x {
        p() {
        }

        @Override // com.martian.mibook.j.v2.x
        public void a() {
            if (ReadingActivity.this.j0 != null) {
                ReadingActivity.this.j0.v2(i4.p);
            }
        }

        @Override // com.martian.mibook.j.v2.x
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    class q implements v2.x {
        q() {
        }

        @Override // com.martian.mibook.j.v2.x
        public void a() {
            ReadingActivity.this.j0.v2(i4.m);
        }

        @Override // com.martian.mibook.j.v2.x
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    class r implements v2.x {
        r() {
        }

        @Override // com.martian.mibook.j.v2.x
        public void a() {
            if (ReadingActivity.this.j0 != null) {
                ReadingActivity.this.j0.v2(i4.s);
            }
        }

        @Override // com.martian.mibook.j.v2.x
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    class s implements SeekBar.OnSeekBarChangeListener {
        s() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean b2) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ReadingActivity.this.O3(seekBar.getProgress());
        }
    }

    /* loaded from: classes3.dex */
    class t implements v2.x {
        t() {
        }

        @Override // com.martian.mibook.j.v2.x
        public void a() {
            if (ReadingActivity.this.j0 != null) {
                ReadingActivity.this.j0.v2(i4.n);
            }
        }

        @Override // com.martian.mibook.j.v2.x
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    class u extends com.martian.mibook.lib.model.d.h {

        /* renamed from: a */
        final /* synthetic */ boolean f11127a;

        u(final boolean val$switchMore) {
            this.f11127a = val$switchMore;
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void c(List<TYBookItem> books) {
            ReadingActivity.this.m1.h();
            if (ReadingActivity.this.m0 == null) {
                ReadingActivity.this.m0 = books;
            } else {
                ReadingActivity.this.m0.addAll(books);
            }
            if (!this.f11127a || ReadingActivity.this.m0.size() < ReadingActivity.this.o4()) {
                return;
            }
            ReadingActivity.this.K3(true);
        }

        @Override // com.martian.mibook.lib.model.d.h
        public void d(b.d.c.b.c errorResult) {
        }
    }

    /* loaded from: classes3.dex */
    class v implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ int f11129a;

        v(final int val$chapterIndex) {
            this.f11129a = val$chapterIndex;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            if (book == null) {
                ReadingActivity.this.g4("");
            } else {
                ReadingActivity.this.L4(book, this.f11129a);
            }
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            ReadingActivity.this.g4("");
        }
    }

    /* loaded from: classes3.dex */
    class w extends BottomSheetBehavior.f {
        w() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(@NonNull View bottomSheet, float slideOffset) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View bottomSheet, int newState) {
            if (newState == 5) {
                ReadingActivity.this.e0.getRoot().setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    class x implements c.e {

        /* renamed from: a */
        final /* synthetic */ boolean f11132a;

        x(final boolean val$retry) {
            this.f11132a = val$retry;
        }

        /* renamed from: c */
        public /* synthetic */ void d() {
            ReadingActivity.this.Y7(false);
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.account.e.c.e
        public void b(MartianRPAccount rpAccount) {
            if (rpAccount != null && rpAccount.getIsVip() > 0) {
                if (ReadingActivity.this.f0 != null) {
                    ReadingActivity.this.f0.setDisableAd(true);
                    ReadingActivity.this.f0.setEnableWblAd(false);
                    ReadingActivity.this.f0.setVideoAdWatched(false);
                }
                if (ReadingActivity.this.j0 != null) {
                    ReadingActivity.this.j0.L2();
                    ReadingActivity.this.j0.P2();
                    ReadingActivity.this.j0.i0();
                }
                ReadingActivity.this.Q7();
            } else if (this.f11132a) {
                new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadingActivity.x.this.d();
                    }
                }, 5000L);
            }
            ReadingActivity.this.k8();
        }
    }

    /* loaded from: classes3.dex */
    class y extends com.martian.mibook.lib.account.d.g<BookAlertParams, Integer> {
        y(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<Integer> types) {
            int intValue;
            if (types == null || types.isEmpty() || types.get(0) == null || com.martian.libmars.utils.n0.c(ReadingActivity.this) || (intValue = types.get(0).intValue()) <= 0 || intValue > 4) {
                return;
            }
            ReadingActivity readingActivity = ReadingActivity.this;
            v2.N0(readingActivity, intValue, readingActivity.S4());
            MiConfigSingleton.V3().l3().G1(ReadingActivity.this.g0.getSourceString());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class z extends BottomSheetBehavior.f {
        z() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(@NonNull View bottomSheet, float slideOffset) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View bottomSheet, int newState) {
            if (newState == 5) {
                ReadingActivity.this.d0.getRoot().setVisibility(8);
            }
        }
    }

    private void A4() {
        if (this.K == null) {
            this.J.f12506f.setLayoutResource(R.layout.reading_page_setting);
            f6 a2 = f6.a(this.J.f12506f.inflate());
            this.K = a2;
            a2.f11969h.setMax(250);
            int p3 = MiConfigSingleton.V3().p3();
            this.K.f11969h.setProgress(p3 >= 5 ? p3 - 5 : 5);
            this.K.f11969h.setOnSeekBarChangeListener(new l());
            this.K.f11971j.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.t5(view);
                }
            });
            this.K.f11970i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.v5(view);
                }
            });
            b8(MiConfigSingleton.V3().S5());
        }
        c8();
        e8();
        B7();
    }

    /* renamed from: A5 */
    public /* synthetic */ void B5(View v2) {
        D7(false);
    }

    public void A7() {
        if (!MiConfigSingleton.V3().S1() || O4() || MiConfigSingleton.V3().m6() || MiConfigSingleton.V3().u5()) {
            o7(this.J.k.l, false, com.martian.libmars.utils.h0.f10146c);
            return;
        }
        MiReadingTheme r2 = MiConfigSingleton.V3().J4.r();
        o7(this.J.k.l, true, com.martian.libmars.utils.h0.f10146c);
        this.J.k.f12625h.b(r2.getTextColorThirdly(this), 10);
        this.J.k.f12620c.setVisibility(0);
        this.J.k.f12623f.setVisibility(8);
        this.J.k.f12624g.setImageResource(R.drawable.icon_reading_coins);
        if (MiConfigSingleton.V3().O0()) {
            this.J.k.f12624g.setImageResource(R.drawable.icon_reading_coins_hint);
            this.J.k.f12620c.setText(getString(R.string.wait_network));
        } else {
            if (!MiConfigSingleton.V3().x5()) {
                this.J.k.f12620c.setText(getString(R.string.login_click));
                return;
            }
            if (this.P0 <= 0) {
                this.J.k.f12620c.setText(getString(R.string.bonus_opened));
                return;
            }
            this.J.k.f12620c.setVisibility(8);
            this.J.k.f12623f.setVisibility(0);
            this.J.k.f12621d.setNumberText(this.P0);
            this.J.k.f12622e.setVisibility(this.P0 >= 1000 ? 8 : 0);
        }
    }

    private void B4(Bundle savedInstanceState) {
        if (q4(getIntent())) {
            return;
        }
        ReadingInfo readingInfo = (ReadingInfo) GsonUtils.b().fromJson(savedInstanceState != null ? savedInstanceState.getString(C) : getIntent() != null ? getIntent().getStringExtra(C) : "", ReadingInfo.class);
        this.f0 = readingInfo;
        if (readingInfo == null || readingInfo.getRecord() == null || this.f0.getMiBook() == null || com.martian.libsupport.k.p(this.f0.getMiBook().getBookId())) {
            g4("");
            return;
        }
        this.f0.initReadingSetting(this);
        Book T = MiConfigSingleton.V3().l3().T(this.f0.getRecord().getSourceString());
        this.g0 = T;
        if (T == null) {
            g4("");
            return;
        }
        if (T4()) {
            J4();
        }
        if (this.g0.isLocal()) {
            this.f0.setShowChapterComment(false);
        }
        this.f0.setAdBook(this.g0.isLocal() || this.g0.isFreeBook());
        MiConfigSingleton.V3().l3().l2(this, this.g0, new MiBookManager.y() { // from class: com.martian.mibook.activity.reader.x0
            @Override // com.martian.mibook.application.MiBookManager.y
            public final void a(BookAdsInfo bookAdsInfo) {
                ReadingActivity.this.x5(bookAdsInfo);
            }
        });
        this.A0.z(MiConfigSingleton.V3().l3().j2(this.g0));
        h4();
    }

    /* renamed from: B6 */
    public /* synthetic */ void C6(View v2) {
        n7(this.L.getRoot(), false);
    }

    @SuppressLint({"SetTextI18n"})
    private void B7() {
        this.K.k.setText(MiConfigSingleton.V3().H3() + "");
    }

    public void C4() {
        if (com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        boolean z2 = this.j0 != null;
        this.j0 = null;
        if (z2) {
            N3(this.f0.getRecord(), this.h0);
        }
        int intValue = this.f0.getRecord().getContentIndex().intValue();
        if (!this.f0.shouldHideAd() && !T4() && this.f0.getAdInterval() > 0 && intValue >= this.f0.getAdInterval()) {
            int i2 = intValue + 1;
            int adInterval = i2 / (this.f0.getAdInterval() + 1);
            if (intValue == ((this.f0.getAdInterval() * adInterval) + adInterval) - 1) {
                intValue = i2;
            }
        }
        z4(Integer.valueOf(this.f0.getRecord().getChapterIndex()), Integer.valueOf(intValue), this.f0.getRecord().getContentSize());
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.N2(this.f0.getRecord().isWithAd());
        }
        com.martian.mibook.e.p pVar = this.J;
        if (pVar != null) {
            pVar.k.k.post(new Runnable() { // from class: com.martian.mibook.activity.reader.i1
                @Override // java.lang.Runnable
                public final void run() {
                    ReadingActivity.this.l0();
                }
            });
        }
    }

    /* renamed from: C5 */
    public /* synthetic */ void D5() {
        Q6(1);
    }

    private void D4() {
        ReadingInfo readingInfo;
        if (this.Z == null && (readingInfo = this.f0) != null && readingInfo.isFirstSlide()) {
            U6("左滑引导-展示");
            this.J.w.setLayoutResource(R.layout.reading_slide_guide);
            this.Z = k6.a(this.J.w.inflate());
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.k
                @Override // java.lang.Runnable
                public final void run() {
                    ReadingActivity.this.z5();
                }
            }, 10000L);
        }
    }

    /* renamed from: D6 */
    public /* synthetic */ void E6() {
        M3("弹窗-点击");
    }

    public void D7(boolean showMenu) {
        if (this.k0 == showMenu) {
            E7(showMenu, false);
        }
    }

    private void E4() {
        g8();
        this.J.q.f12206i.setAdapter(this.j0);
        this.J.q.f12206i.setSlider(MiConfigSingleton.V3().k4());
        this.J.q.f12206i.setOnSlideChangeListener(new g0());
        this.J.q.f12206i.setOnTapListener(this);
    }

    /* renamed from: E5 */
    public /* synthetic */ void F5() {
        MiConfigSingleton.V3().s8(Boolean.TRUE);
        Q6(1);
    }

    private void F4() {
        boolean z2 = 2 == MiConfigSingleton.V3().m4();
        this.l0 = z2;
        if (z2) {
            x4();
        }
        S7();
    }

    /* renamed from: F6 */
    public /* synthetic */ void G6() {
        super.finish();
    }

    private boolean F7() {
        i4 i4Var = this.j0;
        if (i4Var == null || !i4Var.f0()) {
            return false;
        }
        MiConfigSingleton.V3().N4.s(this, b.d.a.j.b.f4372e, null);
        return true;
    }

    private void G4() {
        if (this.T == null) {
            this.J.t.setLayoutResource(R.layout.reading_top_bar);
            this.T = o6.a(this.J.t.inflate());
            ImmersionBar.with(this).statusBarView(this.T.f12492b).init();
            Book book = this.g0;
            if (book == null || !book.isLocal()) {
                this.T.f12495e.setVisibility(0);
            } else {
                this.T.f12495e.setVisibility(8);
            }
            Book book2 = this.g0;
            if (book2 == null || com.martian.libsupport.k.p(book2.getSourceId()) || !this.g0.getSourceId().contains("xmly")) {
                this.T.f12497g.setVisibility(0);
            } else {
                this.T.f12497g.setVisibility(8);
            }
            if (MiConfigSingleton.V3().u5()) {
                this.T.f12500j.setVisibility(8);
            }
            r4();
        }
        k8();
    }

    /* renamed from: G5 */
    public /* synthetic */ void H5(View v2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        i4 i4Var;
        if ((top == oldTop && bottom == oldBottom) || (i4Var = this.j0) == null) {
            return;
        }
        i4Var.L2();
    }

    private void H4() {
        if (this.M == null) {
            this.J.f12507g.setLayoutResource(R.layout.reading_tts_setting);
            this.M = p6.a(this.J.f12507g.inflate());
            this.M.f12537e.setProgress(MiConfigSingleton.V3().z4() - 50);
            this.M.f12537e.setOnSeekBarChangeListener(new m());
            this.M.f12542j.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.B5(view);
                }
            });
        }
        this.M.f12536d.setVisibility(com.martian.libsupport.f.d(this) ? 8 : 0);
        this.M.f12541i.setTextColor(MiConfigSingleton.V3().J4.r().getTextColorPrimary());
    }

    /* renamed from: H6 */
    public /* synthetic */ void I6() {
        onExitTtsClick(null);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.w0
            @Override // java.lang.Runnable
            public final void run() {
                ReadingActivity.this.L5();
            }
        }, 500L);
    }

    private void H7() {
        s4();
        U6("自动阅读");
        g8();
        this.o0.f();
        E7(false, true);
        A7();
        c7(3600000L);
    }

    private void I4() {
        if (!MiConfigSingleton.V3().B4().booleanValue() && com.martian.libsupport.k.p(MiConfigSingleton.V3().A4())) {
            MiConfigSingleton.V3().s8(Boolean.TRUE);
            Q6(1);
        }
        q4 q4Var = this.k1;
        if (q4Var == null) {
            q4 q4Var2 = new q4(this, new q4.d() { // from class: com.martian.mibook.activity.reader.t
                @Override // com.martian.mibook.ui.o.q4.d
                public final void a() {
                    ReadingActivity.this.D5();
                }
            }, new q4.e() { // from class: com.martian.mibook.activity.reader.h
                @Override // com.martian.mibook.ui.o.q4.e
                public final void a() {
                    ReadingActivity.this.F5();
                }
            });
            this.k1 = q4Var2;
            this.b0.f12578c.setAdapter((ListAdapter) q4Var2);
            this.k1.p(new TypefaceManager(this).d());
        } else {
            q4Var.notifyDataSetChanged();
        }
        this.b0.f12578c.smoothScrollToPosition(this.k1.g());
    }

    /* renamed from: I5 */
    public /* synthetic */ void J5(BookAdsInfo bookAdsInfo) {
        this.f0.setInterstitial(bookAdsInfo.getInterstitial());
        this.f0.setVideoUnlock(bookAdsInfo.getVideoUnlock());
    }

    private void I7(final int start) {
        com.martian.libsupport.permission.g.h(this, new f(start), new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo("权限申请", "需要存储权限才能下载缓存章节\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。", "取消", "前往开启"), true);
    }

    private void J4() {
        A7();
        if (this.B0 == null) {
            com.martian.mibook.h.g gVar = new com.martian.mibook.h.g();
            this.B0 = gVar;
            gVar.a(this, this);
        }
        H4();
        TtsService.U(this, TtsService.f14108i);
    }

    /* renamed from: J6 */
    public /* synthetic */ void K6() {
        i4 i4Var = this.j0;
        if (i4Var == null || i4Var.v0() > 0) {
            this.U.o.setEnabled(true);
            this.U.o.setAlpha(1.0f);
            p6 p6Var = this.M;
            if (p6Var != null) {
                p6Var.f12540h.setEnabled(true);
                this.M.f12540h.setAlpha(1.0f);
            }
        } else {
            this.U.o.setEnabled(false);
            this.U.o.setAlpha(0.4f);
            p6 p6Var2 = this.M;
            if (p6Var2 != null) {
                p6Var2.f12540h.setEnabled(false);
                this.M.f12540h.setAlpha(0.4f);
            }
        }
        i4 i4Var2 = this.j0;
        if (i4Var2 == null || i4Var2.v0() < this.j0.w0() - 1) {
            this.U.n.setEnabled(true);
            this.U.n.setAlpha(1.0f);
            p6 p6Var3 = this.M;
            if (p6Var3 != null) {
                p6Var3.f12539g.setEnabled(true);
                this.M.f12539g.setAlpha(1.0f);
                return;
            }
            return;
        }
        this.U.n.setEnabled(false);
        this.U.n.setAlpha(0.4f);
        p6 p6Var4 = this.M;
        if (p6Var4 != null) {
            p6Var4.f12539g.setEnabled(false);
            this.M.f12539g.setAlpha(0.4f);
        }
    }

    private void J7() {
        M7();
        this.M0.postDelayed(this.Z0, 3000L);
    }

    public void K3(boolean switchMore) {
        boolean M5 = MiConfigSingleton.V3().M5();
        int i2 = M5 ? 3 : 6;
        List<TYBookItem> list = this.m0;
        if (list == null || list.size() < i2) {
            S3(switchMore);
            return;
        }
        if (this.e0 == null) {
            this.J.n.setLayoutResource(R.layout.reading_exit_dialog);
            x5 a2 = x5.a(this.J.n.inflate());
            this.e0 = a2;
            BottomSheetBehavior<View> s2 = BottomSheetBehavior.s(a2.f12944e);
            this.n1 = s2;
            s2.T(5);
            this.n1.i(new w());
            this.e0.f12943d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.X4(view);
                }
            });
        }
        if (this.n0 == null) {
            com.martian.mibook.ui.j jVar = new com.martian.mibook.ui.j(this);
            this.n0 = jVar;
            jVar.j(M5);
            this.e0.f12942c.setNumColumns(M5 ? 1 : 6);
            this.e0.f12942c.setAdapter((ListAdapter) this.n0);
        }
        if (M5 != this.n0.a()) {
            this.n0.j(M5);
            this.e0.f12942c.setNumColumns(M5 ? 1 : 6);
            this.e0.f12942c.setAdapter((ListAdapter) this.n0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TYBookItem> it = this.m0.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            it.remove();
            if (arrayList.size() >= i2) {
                break;
            }
        }
        this.n0.i(arrayList);
        if (switchMore) {
            return;
        }
        this.e0.getRoot().setVisibility(0);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.m0
            @Override // java.lang.Runnable
            public final void run() {
                ReadingActivity.this.Z4();
            }
        }, 100L);
    }

    /* renamed from: K5 */
    public /* synthetic */ void L5() {
        TTSController.i(this);
    }

    private void K7() {
        if (this.j0 == null) {
            return;
        }
        E7(false, true);
        c7(-1L);
        boolean m0 = this.j0.m0();
        int x0 = this.j0.x0();
        if (x0 < 0) {
            x0 = 0;
        } else if (m0) {
            x0 = Math.max(0, x0 - (x0 / (this.f0.getAdInterval() + 1)));
        }
        MiConfigSingleton.V3().H4.b(this, this.g0.getSourceString(), this.J.q.f12200c.w.getContentProperty().setChapterIndex(Math.max(0, this.j0.v0())).setContentIndex(x0));
        this.j0.N2(m0);
        J4();
    }

    private void L3(String source) {
        if (S4()) {
            k1("已在书架");
            return;
        }
        MiConfigSingleton.V3().l3().d(this, this.f0.getMiBook(), this.g0);
        MiConfigSingleton.V3().l3().I1(3, this.g0.getSourceName(), this.g0.getSourceId(), this.f0.getRecommendId(), this.f0.getRecommend(), "阅读加书架");
        k1("已加入书架");
        U6("加入书架-" + source);
    }

    public void L4(Book book, int chapterIndex) {
        this.g0 = book;
        if (this.f0.getMiBook() == null) {
            this.f0.setMiBook(book.buildMibook());
            MiConfigSingleton.V3().l3().T0(this.f0.getMiBook());
        }
        this.f0.setSourceString(this.g0.getSourceString());
        this.f0.setRecord(MiConfigSingleton.V3().l3().V(book));
        MiConfigSingleton.V3().l3().l2(this, this.g0, new MiBookManager.y() { // from class: com.martian.mibook.activity.reader.e1
            @Override // com.martian.mibook.application.MiBookManager.y
            public final void a(BookAdsInfo bookAdsInfo) {
                ReadingActivity.this.J5(bookAdsInfo);
            }
        });
        if (this.f0.getRecord() == null) {
            this.f0.setRecord(new MiReadingRecord());
            this.f0.getRecord().setSourceString(com.martian.mibook.lib.model.manager.d.j(book.getSourceName(), book.getSourceId()));
            this.f0.getRecord().setChapterIndex(Integer.valueOf(chapterIndex));
            this.f0.getRecord().setContentIndex(0);
            this.f0.getRecord().setBookName(book.getBookName());
        }
        h4();
    }

    /* renamed from: L6 */
    public /* synthetic */ boolean M6(View v2) {
        z7();
        return true;
    }

    private void M3(String source) {
        L3(source);
        super.finish();
    }

    private void M4(@NonNull String sourceName, @NonNull String sourceId, final int chapterIndex) {
        MiConfigSingleton.V3().l3().m(new Source(sourceName, sourceId), new v(chapterIndex));
    }

    /* renamed from: M5 */
    public /* synthetic */ void N5() {
        if (com.martian.libsupport.f.d(this)) {
            com.martian.mibook.lib.model.g.b.P(this, "未完待续:" + this.f0.getNotificationStatus() + "-开启");
            this.f0.setNotificationStatus("打开");
            k1("开启成功");
            i4 i4Var = this.j0;
            if (i4Var != null) {
                i4Var.u();
            }
        } else {
            com.martian.mibook.lib.model.g.b.P(this, "未完待续:" + this.f0.getNotificationStatus() + "-关闭");
            this.f0.setNotificationStatus("关闭");
            k1("开启失败");
        }
        W7();
        MiConfigSingleton.V3().L4.N0(this);
    }

    private void M7() {
        this.M0.removeCallbacks(this.Z0);
    }

    private void N3(MiReadingRecord readingRecord, ChapterList chapterList) {
        Chapter item;
        if (readingRecord == null || com.martian.libsupport.k.p(readingRecord.getChapterTitle()) || chapterList == null) {
            return;
        }
        int count = chapterList.getCount();
        int chapterIndex = readingRecord.getChapterIndex();
        int i2 = 0;
        if (chapterIndex < 0) {
            chapterIndex = 0;
        } else if (chapterIndex >= count) {
            chapterIndex = count - 1;
        }
        Chapter item2 = chapterList.getItem(chapterIndex);
        if (item2 != null && readingRecord.getChapterTitle().equalsIgnoreCase(item2.getTitle())) {
            readingRecord.setChapterIndex(Integer.valueOf(chapterIndex));
            return;
        }
        float f2 = 0.0f;
        String chapterTitle = readingRecord.getChapterTitle();
        int i3 = chapterIndex;
        while (true) {
            if (i2 >= 50) {
                break;
            }
            int i4 = chapterIndex - i2;
            if (i4 >= 0) {
                Chapter item3 = chapterList.getItem(i4);
                if (item3 == null) {
                    continue;
                    i2++;
                } else {
                    float d2 = com.martian.libsupport.k.d(item3.getTitle(), chapterTitle);
                    if (d2 > f2) {
                        i3 = i4;
                        if (d2 >= 0.99f) {
                            break;
                        } else {
                            f2 = d2;
                        }
                    }
                }
            }
            int i5 = chapterIndex + i2;
            if (i5 != i4 && i5 < count && (item = chapterList.getItem(i5)) != null) {
                float d3 = com.martian.libsupport.k.d(item.getTitle(), chapterTitle);
                if (d3 <= f2) {
                    continue;
                } else if (d3 >= 0.99f) {
                    i3 = i5;
                    break;
                } else {
                    f2 = d3;
                    i3 = i5;
                }
            }
            i2++;
        }
        readingRecord.setChapterIndex(Integer.valueOf(i3));
    }

    /* renamed from: N6 */
    public /* synthetic */ void O6(int tabIndex, boolean clicked) {
        j7(MiConfigSingleton.V3().J4.s(), tabIndex);
        MiConfigSingleton.V3().J4.G(tabIndex);
        P3();
        a8();
        e8();
        A7();
    }

    private void N7() {
        List<TYBookItem> list = this.m0;
        if (list == null || (list.size() < o4() && this.n1 == null)) {
            if (this.h0 == null || this.U0 < 30 || S4()) {
                super.finish();
                return;
            } else if (this.U0 > 1200) {
                M3("自动");
                return;
            } else {
                U6("加入书架-弹窗-展示");
                com.martian.libmars.utils.k0.Q(this, getResources().getString(R.string.save_information), getResources().getString(R.string.save_information_hint), getResources().getString(R.string.search_close), getResources().getString(R.string.add_to_book_store), true, new k0.l() { // from class: com.martian.mibook.activity.reader.t0
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        ReadingActivity.this.E6();
                    }
                }, new k0.j() { // from class: com.martian.mibook.activity.reader.q0
                    @Override // com.martian.libmars.utils.k0.j
                    public final void a() {
                        ReadingActivity.this.G6();
                    }
                });
                return;
            }
        }
        BottomSheetBehavior<View> bottomSheetBehavior = this.n1;
        if (bottomSheetBehavior == null) {
            D7(false);
            K3(false);
        } else if (bottomSheetBehavior.z() == 3) {
            super.finish();
        } else {
            this.e0.getRoot().setVisibility(0);
            this.n1.T(3);
        }
    }

    public void O3(int progress) {
        int i2 = progress < 10 ? 20 : progress * 2;
        this.J.q.f12206i.x(i2, false);
        MiConfigSingleton.V3().Z6(i2);
    }

    private boolean O4() {
        return T4() || N4();
    }

    /* renamed from: O5 */
    public /* synthetic */ void P5(View v1) {
        this.o1.T(5);
    }

    private void O7(TextView clickGuideView, @NonNull AppTask appTask) {
        ReadingInfo readingInfo = this.f0;
        if (readingInfo == null || !readingInfo.enableBannerAdClickGuide() || clickGuideView == null || appTask.getEcpm() < this.f0.getAdBannerOptimizeEcpm() || !p7()) {
            return;
        }
        clickGuideView.setVisibility(0);
        this.w0 = appTask.getAdTag();
        com.martian.mibook.lib.model.g.b.J(this, "点击引导-Banner-曝光-新");
    }

    public void P3() {
        j0();
        this.J.x.setBackgroundColor(MiConfigSingleton.V3().J4.b());
        ImmersionBar.with(this).statusBarDarkFont(!MiConfigSingleton.V3().J4.E()).init();
        i4 i4Var = this.j0;
        if (i4Var != null) {
            if (this.l0) {
                i4Var.X2(this.J.q.f12199b);
            } else if (MiConfigSingleton.V3().m4() == 4) {
                this.j0.X2(this.J.v);
            }
            this.j0.B2();
        }
        this.j1 = null;
    }

    private boolean P4() {
        return this.k0 && q7();
    }

    private void P6() {
        if (this.d1 == null) {
            com.martian.mibook.b.b bVar = new com.martian.mibook.b.b(this, com.martian.mibook.b.b.w, b.d.a.j.b.f4369b);
            this.d1 = bVar;
            bVar.T0(new o());
        }
        c4(100);
    }

    private void P7() {
        if (MiConfigSingleton.V3().H4.e()) {
            com.martian.libmars.utils.k0.P(this, getString(R.string.confirm_message), getString(R.string.tts_another), new k0.l() { // from class: com.martian.mibook.activity.reader.w
                @Override // com.martian.libmars.utils.k0.l
                public final void a() {
                    ReadingActivity.this.I6();
                }
            });
        } else {
            TTSController.i(this);
        }
    }

    public void Q3(int progress) {
        TtsService.V(this, TtsService.f14105f, progress + 50);
    }

    private boolean Q4() {
        return MiConfigSingleton.V3().L4.b0();
    }

    /* renamed from: Q5 */
    public /* synthetic */ void R5() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.o1;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.T(3);
        }
    }

    private void Q6(int type) {
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.A2(type);
        }
    }

    public void R3(final boolean fromLocalFailure) {
        MiConfigSingleton.V3().l3().o(this.g0, fromLocalFailure, false, new c0(fromLocalFailure));
    }

    private boolean R4() {
        if (com.martian.libsupport.l.I(this)) {
            return false;
        }
        t5 t5Var = this.U;
        return t5Var == null || t5Var.getRoot().getVisibility() == 8;
    }

    public void R6(String adTag) {
        if (com.martian.libsupport.k.p(this.w0) || !this.w0.equalsIgnoreCase(adTag)) {
            return;
        }
        this.w0 = "";
        com.martian.mibook.lib.model.g.b.J(this, "点击引导-Banner-点击-新");
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.I0(5);
        }
    }

    public void R7() {
        if (this.l0) {
            this.J.q.f12204g.setProgress(this.r0);
            return;
        }
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.v3(this.r0);
        }
    }

    public void S3(boolean switchMore) {
        if (this.m1 == null) {
            MiBookManager.m0 m0Var = new MiBookManager.m0();
            this.m1 = m0Var;
            m0Var.l(0);
            this.m1.n(8);
            this.m1.o(new Random().nextInt(10000));
            Book book = this.g0;
            if (book != null) {
                this.m1.q(book.getSourceName());
                this.m1.p(this.g0.getSourceId());
                this.m1.j(this.g0.getSourceName());
            }
        }
        this.m1.m(o4());
        MiConfigSingleton.V3().l3().T1(this.m1, new u(switchMore));
    }

    public boolean S4() {
        return this.f0 == null || MiConfigSingleton.V3().l3().v0(this.f0.getMiBook());
    }

    /* renamed from: S5 */
    public /* synthetic */ void T5(View v1) {
        n7(this.b0.getRoot(), false);
    }

    private void S7() {
        if (MiConfigSingleton.V3().m4() == 4) {
            com.martian.libsliding.slider.g slider = this.J.q.f12206i.getSlider();
            if (slider instanceof com.martian.libsliding.slider.b) {
                ((com.martian.libsliding.slider.b) slider).v(MiConfigSingleton.V3().Q5());
            }
        }
    }

    private void T3() {
        if (S4()) {
            return;
        }
        MiConfigSingleton.V3().l3().d(this, this.f0.getMiBook(), this.g0);
        k1("已自动将本书加入书架");
    }

    private void T6() {
        com.martian.mibook.lib.model.g.b.I(this, MiConfigSingleton.V3().H3());
    }

    public void T7() {
        if (this.U == null || this.M == null) {
            return;
        }
        new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.reader.c1
            @Override // java.lang.Runnable
            public final void run() {
                ReadingActivity.this.K6();
            }
        });
    }

    public void U3() {
        int X2 = MiConfigSingleton.V3().X2() + 1;
        MiConfigSingleton.V3().M7(MiConfigSingleton.V3().W3().getAdsDialogIntervalMinutes().intValue() * X2);
        MiConfigSingleton.V3().U6(X2);
        this.f0.setVideoAdWatched(false);
        X7();
        Q7();
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.N2(false);
        }
    }

    /* renamed from: U5 */
    public /* synthetic */ void V5(View view) {
        startActivityForResult(TypefaceScanActivity.class, 205);
    }

    public void U6(String event) {
        com.martian.mibook.lib.model.g.b.V(this, event);
    }

    private void U7(int sliderIndex) {
        MiReadingTheme r2 = MiConfigSingleton.V3().J4.r();
        int textColorPrimary = r2.getTextColorPrimary();
        int borderLineBackgroundSelectedRes = r2.getBorderLineBackgroundSelectedRes();
        this.d0.u.setBackgroundResource(r2.getBorderBackgroundLightButton());
        this.d0.n.setTextColor(textColorPrimary);
        this.d0.m.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.d0.w.setTextColor(textColorPrimary);
        this.d0.v.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.d0.r.setTextColor(textColorPrimary);
        this.d0.q.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.d0.t.setTextColor(textColorPrimary);
        this.d0.s.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.d0.p.setTextColor(textColorPrimary);
        this.d0.o.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        if (sliderIndex == 0) {
            this.d0.n.setTextColor(ContextCompat.getColor(this, R.color.white));
            this.d0.m.setBackgroundResource(borderLineBackgroundSelectedRes);
        } else if (sliderIndex == 1) {
            this.d0.w.setTextColor(ContextCompat.getColor(this, R.color.white));
            this.d0.v.setBackgroundResource(borderLineBackgroundSelectedRes);
        } else if (sliderIndex == 2) {
            this.d0.r.setTextColor(ContextCompat.getColor(this, R.color.white));
            this.d0.q.setBackgroundResource(borderLineBackgroundSelectedRes);
        } else if (sliderIndex == 3) {
            this.d0.t.setTextColor(ContextCompat.getColor(this, R.color.white));
            this.d0.s.setBackgroundResource(borderLineBackgroundSelectedRes);
        } else {
            this.d0.p.setTextColor(ContextCompat.getColor(this, R.color.white));
            this.d0.o.setBackgroundResource(borderLineBackgroundSelectedRes);
        }
        X3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V3() {
        if (Q4() || !MiConfigSingleton.V3().l3().j3(this.g0)) {
            return;
        }
        y yVar = new y(BookAlertParams.class, Integer.class, this);
        ((BookAlertParams) yVar.k()).setSourceName(this.g0.getSourceName());
        ((BookAlertParams) yVar.k()).setSourceId(this.g0.getSourceId());
        yVar.j();
    }

    private void V6() {
        if (this.f0.getThemeIndex() != MiConfigSingleton.V3().J4.s()) {
            StringBuilder sb = new StringBuilder();
            sb.append(MiConfigSingleton.V3().I0() ? "夜间" : "日间");
            sb.append(MiConfigSingleton.V3().J4.r().getTheme_text());
            U6(sb.toString());
        }
        if (this.f0.getSlideIndex() != MiConfigSingleton.V3().m4()) {
            int m4 = MiConfigSingleton.V3().m4();
            if (m4 == 0) {
                U6("翻页模式-平移");
            } else if (m4 == 1) {
                U6("翻页模式-覆盖");
            } else if (m4 == 2) {
                U6("翻页模式-上下");
            } else if (m4 == 3) {
                U6("翻页模式-无");
            } else if (m4 == 4) {
                U6("翻页模式-仿真");
            }
        }
        if (this.f0.getFontSize() != MiConfigSingleton.V3().H3()) {
            U6("字号-" + MiConfigSingleton.V3().H3());
        }
        String A4 = MiConfigSingleton.V3().A4();
        if (com.martian.libsupport.k.p(A4) || A4.equalsIgnoreCase(this.f0.getTypeface())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("字体路径-");
        if (this.f0.getTypeface().length() > 14) {
            A4 = A4.substring(A4.length() - 14, A4.length() - 4);
        }
        sb2.append(A4);
        U6(sb2.toString());
    }

    private void V7() {
        if (this.U != null) {
            if (MiConfigSingleton.V3().P0()) {
                this.U.l.setImageResource(R.drawable.reader_night_moded_icon);
            } else {
                this.U.l.setImageResource(R.drawable.reader_night_mode_icon);
            }
        }
    }

    /* renamed from: W4 */
    public /* synthetic */ void X4(View v2) {
        this.n1.T(5);
    }

    private void W6() {
        f7 f7Var = this.V;
        if (f7Var != null) {
            f7Var.getRoot().setVisibility(8);
        }
        ObjectAnimator objectAnimator = this.X;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.X = null;
        }
    }

    private void W7() {
        if (this.d0 != null) {
            if (com.martian.libsupport.f.d(this)) {
                this.d0.K.setVisibility(8);
                this.d0.L.setVisibility(8);
                this.d0.M.setText(getString(R.string.push_notification_opened));
            } else {
                this.d0.K.setVisibility(0);
                this.d0.L.setVisibility(0);
                this.d0.M.setText(getString(R.string.push_notification_closed));
            }
        }
        p6 p6Var = this.M;
        if (p6Var != null) {
            p6Var.f12536d.setVisibility(com.martian.libsupport.f.d(this) ? 8 : 0);
        }
    }

    private void X3() {
        long t4 = MiConfigSingleton.V3().t4();
        if (t4 <= 0) {
            return;
        }
        if (!this.O0) {
            getWindow().addFlags(128);
            this.O0 = true;
        }
        this.M0.removeCallbacks(this.N0);
        this.M0.postDelayed(this.N0, t4);
    }

    /* renamed from: X5 */
    public /* synthetic */ void Y5(final AppTask appTask, View v2) {
        this.d1.d(appTask);
        R6(appTask.getAdTag());
    }

    private void X6() {
        f7 f7Var = this.V;
        if (f7Var != null) {
            f7Var.f11975d.setImageResource(R.drawable.icon_tts_float_play);
            a7();
        }
    }

    private void Y3(long targetTime) {
        TtsService.V(this, TtsService.f14106g, targetTime);
        this.M.f12541i.s();
        if (targetTime > 0) {
            this.M.f12541i.p(targetTime, getString(R.string.ting_shu_clock));
        } else {
            this.M.f12541i.setText(getString(R.string.ting_shu_clock));
        }
    }

    /* renamed from: Y4 */
    public /* synthetic */ void Z4() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.n1;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.T(3);
        }
    }

    private void Y6() {
        f7 f7Var = this.V;
        if (f7Var != null) {
            f7Var.f11975d.setImageResource(R.drawable.icon_tts_float_pause);
            if (com.martian.libsupport.l.p() && this.V.getRoot().getVisibility() == 0) {
                ObjectAnimator objectAnimator = this.X;
                if (objectAnimator == null) {
                    this.X = com.martian.libmars.utils.h0.b(this.V.f11974c);
                } else {
                    objectAnimator.resume();
                }
            }
        }
    }

    public void Y7(boolean retry) {
        com.martian.mibook.lib.account.e.c.k(this, new x(retry));
        if (MiConfigSingleton.V3().x4() == null) {
            com.martian.mibook.lib.account.e.c.l(this, null);
        }
    }

    /* renamed from: Z5 */
    public /* synthetic */ void a6(View v2) {
        v7();
    }

    private void Z6() {
        Handler handler = this.f1;
        if (handler != null) {
            handler.removeCallbacks(this.g1);
        }
    }

    private void Z7() {
        if (this.l0) {
            this.J.q.f12205h.setText(this.q0);
            return;
        }
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.A3(this.q0);
        }
    }

    private boolean a4(int x2, int y2) {
        int B0 = B0();
        int z0 = z0();
        if (!this.l0) {
            return x2 > B0 / 3 && x2 < (B0 * 2) / 3 && y2 > z0 / 3 && y2 < (z0 * 2) / 3;
        }
        if (MiConfigSingleton.V3().R5()) {
            return y2 > z0 / 3 && y2 < (z0 * 2) / 3;
        }
        return true;
    }

    /* renamed from: a5 */
    public /* synthetic */ void b5() {
        this.S.getRoot().setVisibility(8);
    }

    private void a7() {
        if (this.X == null || !com.martian.libsupport.l.p()) {
            return;
        }
        this.X.pause();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[Catch: NotFoundException -> 0x007e, TryCatch #0 {NotFoundException -> 0x007e, blocks: (B:2:0x0000, B:4:0x000e, B:7:0x0015, B:10:0x002c, B:11:0x0041, B:13:0x0047, B:15:0x004d, B:18:0x005b, B:21:0x0034), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a8() {
        /*
            r3 = this;
            boolean r0 = r3.R4()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            boolean r1 = r3.f4()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            r2 = 0
            r3.Y0(r0, r1, r2)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            if (r0 != 0) goto L34
            boolean r0 = com.martian.libsupport.l.p()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            if (r0 != 0) goto L15
            goto L34
        L15:
            com.gyf.barlibrary.ImmersionBar r0 = com.gyf.barlibrary.ImmersionBar.with(r3)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.BarHide r1 = com.gyf.barlibrary.BarHide.FLAG_SHOW_BAR     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.ImmersionBar r0 = r0.hideBar(r1)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.martian.mibook.application.MiConfigSingleton r1 = com.martian.mibook.application.MiConfigSingleton.V3()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.martian.mibook.application.MiReaderThemeManager r1 = r1.J4     // Catch: android.content.res.Resources.NotFoundException -> L7e
            boolean r1 = r1.E()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            if (r1 != 0) goto L2c
            r2 = 1
        L2c:
            com.gyf.barlibrary.ImmersionBar r0 = r0.statusBarDarkFont(r2)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            r0.init()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            goto L41
        L34:
            com.gyf.barlibrary.ImmersionBar r0 = com.gyf.barlibrary.ImmersionBar.with(r3)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.BarHide r1 = com.gyf.barlibrary.BarHide.FLAG_HIDE_BAR     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.ImmersionBar r0 = r0.hideBar(r1)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            r0.init()     // Catch: android.content.res.Resources.NotFoundException -> L7e
        L41:
            boolean r0 = com.gyf.barlibrary.ImmersionBar.hasNavigationBar(r3)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            if (r0 == 0) goto L7e
            boolean r0 = r3.f4()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            if (r0 == 0) goto L5b
            com.gyf.barlibrary.ImmersionBar r0 = com.gyf.barlibrary.ImmersionBar.with(r3)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.BarHide r1 = com.gyf.barlibrary.BarHide.FLAG_HIDE_NAVIGATION_BAR     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.ImmersionBar r0 = r0.hideBar(r1)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            r0.init()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            goto L7e
        L5b:
            com.martian.mibook.application.MiConfigSingleton r0 = com.martian.mibook.application.MiConfigSingleton.V3()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.martian.mibook.application.MiReaderThemeManager r0 = r0.J4     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.martian.mibook.lib.model.data.MiReadingTheme r0 = r0.r()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.ImmersionBar r1 = com.gyf.barlibrary.ImmersionBar.with(r3)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.BarHide r2 = com.gyf.barlibrary.BarHide.FLAG_SHOW_BAR     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.ImmersionBar r1 = r1.hideBar(r2)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            boolean r2 = r3.P4()     // Catch: android.content.res.Resources.NotFoundException -> L7e
            int r0 = r0.getNavigationBarBackground(r2)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            com.gyf.barlibrary.ImmersionBar r0 = r1.navigationBarColor(r0)     // Catch: android.content.res.Resources.NotFoundException -> L7e
            r0.init()     // Catch: android.content.res.Resources.NotFoundException -> L7e
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.activity.reader.ReadingActivity.a8():void");
    }

    private void b4() {
        PopupWindow popupWindow = this.j1;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* renamed from: b6 */
    public /* synthetic */ void c6(final AppTaskList appTaskList, final int intervalExtra) {
        AppTask appTask;
        if (this.R == null || !com.martian.libmars.utils.n0.C(this) || (appTask = appTaskList.getApps().get(0)) == null) {
            return;
        }
        if (appTaskList.getApps().size() > 1) {
            this.R.f12573c.setVisibility(0);
            t7(appTask, this.R.f12572b, true, true);
            t7(appTaskList.getApps().get(1), this.R.f12573c, true, false);
            U6("底通拼接");
        } else {
            this.R.f12573c.setVisibility(8);
            t7(appTask, this.R.f12572b, false, false);
        }
        this.u0 = intervalExtra;
        ReadingInfo readingInfo = this.f0;
        if (readingInfo != null && readingInfo.isEnableBaeAdInfo() && appTask.getEcpm() > 30) {
            if (this.h1 == null) {
                this.h1 = new AdConfig.AdInfo();
            }
            this.h1.setSource(appTask.source);
            this.h1.setEcpm(appTask.getEcpm());
        }
        d4();
        this.e1 = appTaskList;
    }

    public void b7() {
        i4 i4Var = this.j0;
        if (i4Var != null) {
            ReadingInfo readingInfo = this.f0;
            i4Var.i3(readingInfo != null && readingInfo.isVideoAdWatched(), v2.n());
        }
    }

    public void b8(boolean isChecked) {
        MiConfigSingleton.V3().B7(isChecked);
        if (isChecked) {
            U6("亮度-跟谁系统");
            p0();
            this.K.f11963b.setAlpha(1.0f);
        } else {
            U6("亮度-自定义");
            V0(MiConfigSingleton.V3().p3());
            this.K.f11963b.setAlpha(0.2f);
        }
    }

    public void c4(final int interval) {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.reader.d0
            @Override // java.lang.Runnable
            public final void run() {
                ReadingActivity.this.d5(interval);
            }
        });
    }

    /* renamed from: c5 */
    public /* synthetic */ void d5(final int interval) {
        if (this.f1 == null) {
            this.f1 = new Handler();
        } else {
            Z6();
        }
        this.f1.postDelayed(this.g1, interval);
    }

    private void c7(long timeout) {
        h7();
        MiConfigSingleton.V3().f8(timeout, false);
        X3();
    }

    @SuppressLint({"InflateParams"})
    private void c8() {
        MiReadingTheme[] t2 = MiConfigSingleton.V3().J4.t();
        int s2 = MiConfigSingleton.V3().J4.s();
        for (int i2 = 0; i2 < t2.length; i2++) {
            MiReadingTheme miReadingTheme = t2[i2];
            View findViewWithTag = this.K.f11968g.findViewWithTag(Integer.valueOf(i2));
            if (findViewWithTag == null) {
                findViewWithTag = getLayoutInflater().inflate(R.layout.reading_theme_view, (ViewGroup) null);
                findViewWithTag.setTag(Integer.valueOf(i2));
                this.K.f11968g.b(findViewWithTag);
            }
            ((ReaderRoundColorView) findViewWithTag.findViewById(R.id.ccv_circle)).b(miReadingTheme.getBackgroundPrimary(), 17);
            FrameLayout frameLayout = (FrameLayout) findViewWithTag.findViewById(R.id.ccv_theme_view);
            if (i2 == 0) {
                frameLayout.setPadding(0, 0, 0, 0);
            } else if (MiConfigSingleton.V3().M5()) {
                frameLayout.setPadding(com.martian.libmars.d.h.b(20.0f), 0, 0, 0);
            } else {
                frameLayout.setPadding(com.martian.libmars.d.h.b(40.0f), 0, 0, 0);
            }
            LinearLayout linearLayout = (LinearLayout) findViewWithTag.findViewById(R.id.ll_theme_circle);
            linearLayout.setBackgroundResource(miReadingTheme.getSelectableLineBackground());
            linearLayout.setSelected(false);
            TextView textView = (TextView) findViewWithTag.findViewById(R.id.tv_theme_view_text);
            textView.setTextColor(miReadingTheme.getItemColorPrimary());
            if (i2 == t2.length - 1) {
                textView.setVisibility(0);
                textView.setText(MiConfigSingleton.V3().n(miReadingTheme.getTheme_text()));
                if (miReadingTheme.isColorBackground()) {
                    textView.setTextColor(miReadingTheme.getTextColorPrimary());
                } else {
                    textView.setTextColor(miReadingTheme.getTextColorPrimary(this));
                }
            } else if (MiConfigSingleton.V3().I0() && s2 == i2) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        }
        ((ViewGroup) this.K.f11968g.c(s2)).getChildAt(1).setSelected(true);
        this.K.f11968g.smoothScrollTo(0, 0);
        this.K.f11968g.c(t2.length - 1).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.activity.reader.a1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ReadingActivity.this.M6(view);
            }
        });
        this.K.f11968g.setTabSelectionListener(new ScrollTabWidget.b() { // from class: com.martian.mibook.activity.reader.q
            @Override // com.martian.libmars.widget.ScrollTabWidget.b
            public final void a(int i3, boolean z2) {
                ReadingActivity.this.O6(i3, z2);
            }
        });
    }

    private void d4() {
        com.martian.mibook.application.g0.q(this.e1);
    }

    /* renamed from: d6 */
    public /* synthetic */ void e6(final TYBookItem tyBookItem, final e5 adsBookBinding, View v2) {
        String deeplink = tyBookItem.getDeeplink();
        if (!com.martian.libsupport.k.p(deeplink) && com.martian.apptask.g.g.b(this, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this, "Banner-deeplink");
            com.martian.apptask.g.g.t(this, deeplink);
            return;
        }
        com.martian.mibook.lib.model.g.b.w(this, "Banner-加入书架");
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.W(tyBookItem);
        }
        adsBookBinding.f11912d.setText("已在书架");
        adsBookBinding.f11912d.setEnabled(false);
        adsBookBinding.f11912d.setBackgroundResource(R.drawable.border_button_bonus_mission_item_checked);
    }

    private void d7() {
        if (this.f0 == null || T4()) {
            return;
        }
        try {
            if (this.p0 && this.f0.getFirstRead()) {
                this.f0.getRecord().setRecordRead((Integer) 3);
            }
            MiReadingRecord record = this.f0.getRecord();
            i4 i4Var = this.j0;
            record.setWithAd(i4Var != null && i4Var.m0());
            MiConfigSingleton.V3().l3().V0(this.g0, this.f0.getRecord());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d8(String event, float space) {
        U6(event);
        MiConfigSingleton.V3().H7(space);
        e8();
        Q6(2);
    }

    private boolean e4() {
        return !O4();
    }

    /* renamed from: e5 */
    public /* synthetic */ void f5() {
        super.finish();
    }

    private void e7(int count) {
        int progress = this.N.f12529c.getProgress();
        if (progress <= 0 && count < 0) {
            k1("已调到最慢速度");
            return;
        }
        int i2 = 200;
        if (progress >= 200 && count > 0) {
            k1("已调到最快速度");
            return;
        }
        int i3 = progress + count;
        if (i3 < 0) {
            i2 = 0;
        } else if (i3 <= 200) {
            i2 = i3;
        }
        this.N.f12529c.setProgress(i2);
        O3(i2);
    }

    private void e8() {
        if (this.d0 == null) {
            return;
        }
        MiReadingTheme r2 = MiConfigSingleton.V3().J4.r();
        float S3 = MiConfigSingleton.V3().S3();
        this.d0.k.setColorFilter(r2.getTextColorPrimary());
        this.d0.l.setBackgroundResource(r2.getBorderLineBackgroundLayoutRes());
        this.d0.f11866i.setColorFilter(r2.getTextColorPrimary());
        this.d0.f11867j.setBackgroundResource(r2.getBorderLineBackgroundLayoutRes());
        this.d0.f11864g.setColorFilter(r2.getTextColorPrimary());
        this.d0.f11865h.setBackgroundResource(r2.getBorderLineBackgroundLayoutRes());
        if (S3 == I) {
            this.d0.f11864g.setColorFilter(r2.getItemColorPrimary());
            this.d0.f11865h.setBackgroundResource(r2.getBorderLineBackgroundNormalRes());
        } else if (S3 == H) {
            this.d0.f11866i.setColorFilter(r2.getItemColorPrimary());
            this.d0.f11867j.setBackgroundResource(r2.getBorderLineBackgroundNormalRes());
        } else {
            this.d0.k.setColorFilter(r2.getItemColorPrimary());
            this.d0.l.setBackgroundResource(r2.getBorderLineBackgroundNormalRes());
        }
    }

    private boolean f4() {
        return !MiConfigSingleton.V3().T1();
    }

    /* renamed from: f6 */
    public /* synthetic */ void g6(final TYBookItem tyBookItem, View v2) {
        String deeplink = tyBookItem.getDeeplink();
        if (com.martian.libsupport.k.p(deeplink) || !com.martian.apptask.g.g.b(this, deeplink)) {
            com.martian.mibook.lib.model.g.b.w(this, "Banner-书籍详情");
            s2.U(this, tyBookItem);
        } else {
            com.martian.mibook.lib.model.g.b.w(this, "Banner-deeplink");
            com.martian.apptask.g.g.t(this, deeplink);
        }
    }

    public void f7(ChapterList chapterList) {
        this.h0 = chapterList;
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.S2(chapterList);
        }
    }

    public void f8() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(13);
        this.q0 = String.format(Locale.CHINA, "%02d:%02d", Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)));
        Z7();
        this.D0.removeCallbacks(this.F0);
        this.D0.postDelayed(this.F0, (60 - i2) * 1000);
    }

    public void g4(String errMsg) {
        if (com.martian.libsupport.k.p(errMsg)) {
            errMsg = "无效的小说信息";
        }
        k1(errMsg);
        super.finish();
    }

    /* renamed from: g5 */
    public /* synthetic */ void h5(View v2) {
        D7(false);
    }

    private void g8() {
        if (this.l0) {
            this.J.q.m.setVisibility(0);
            this.J.q.k.setVisibility(0);
            this.J.q.f12200c.y.setVisibility(8);
            this.J.q.f12200c.r.getRoot().setVisibility(8);
            return;
        }
        this.J.q.m.setVisibility(8);
        this.J.q.k.setVisibility(8);
        this.J.q.f12200c.y.setVisibility(0);
        this.J.q.f12200c.r.getRoot().setVisibility(0);
    }

    private void h4() {
        MiConfigSingleton.V3().l3().p(this.g0, new b0());
    }

    /* renamed from: h6 */
    public /* synthetic */ void i6(AdapterView parent, View view, int position, long id) {
        int i2;
        if (position != 1) {
            i2 = position != 2 ? position != 3 ? position != 4 ? position != 5 ? 0 : 7200000 : 5400000 : BaseConstants.Time.HOUR : 1800000;
        } else {
            i2 = 900000;
            if (com.martian.libmars.d.h.F().J0()) {
                i2 = 20000;
            }
        }
        Y3(i2 > 0 ? System.currentTimeMillis() + i2 : -1L);
        this.b1.b(position);
        o7(this.O.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
    }

    public void h7() {
        if (MiConfigSingleton.V3().t4() <= 0) {
            return;
        }
        this.M0.removeCallbacks(this.N0);
        if (this.O0) {
            getWindow().clearFlags(128);
            this.O0 = false;
        }
    }

    private void h8(int color) {
        b6 b6Var = this.Q;
        if (b6Var != null) {
            com.martian.libmars.utils.tablayout.i navigator = b6Var.f11762b.getNavigator();
            if (navigator instanceof CommonNavigator) {
                ((CommonNavigator) navigator).w(color);
            }
        }
    }

    public int i4() {
        ReadingInfo readingInfo = this.f0;
        if (readingInfo == null) {
            return 30000;
        }
        return readingInfo.getBannerAdInterval();
    }

    /* renamed from: i5 */
    public /* synthetic */ void j5(IntervalCountdownTextView textView) {
        this.U.k.setVisibility(8);
    }

    private void i8(int normalColor, int selectedColor) {
        b6 b6Var = this.Q;
        if (b6Var == null) {
            return;
        }
        com.martian.libmars.utils.tablayout.i navigator = b6Var.f11762b.getNavigator();
        if (navigator instanceof CommonNavigator) {
            ((CommonNavigator) navigator).x(normalColor, selectedColor);
        }
    }

    public String j4() {
        Book book = this.g0;
        return book == null ? this.f0.getRecord().getBookName() : book.getBookName();
    }

    /* renamed from: j6 */
    public /* synthetic */ void k6(View v2) {
        o7(this.O.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
    }

    private void j7(int oldTabIndex, int tabIndex) {
        TextView textView;
        TextView textView2;
        ((ViewGroup) this.K.f11968g.c(oldTabIndex)).getChildAt(1).setSelected(false);
        if (oldTabIndex != this.K.f11968g.getTabCount() - 1 && (textView2 = (TextView) ((ViewGroup) this.K.f11968g.c(oldTabIndex)).getChildAt(2)) != null) {
            textView2.setVisibility(4);
        }
        if (tabIndex != this.K.f11968g.getTabCount() - 1 && (textView = (TextView) ((ViewGroup) this.K.f11968g.c(tabIndex)).getChildAt(2)) != null) {
            if (MiConfigSingleton.V3().I0()) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        }
        ((ViewGroup) this.K.f11968g.c(tabIndex)).getChildAt(1).setSelected(true);
    }

    private void j8() {
        P3();
        a8();
        V7();
        e8();
    }

    private String k4() {
        Book book = this.g0;
        if (book == null || this.h0 == null) {
            return "";
        }
        if (com.martian.libsupport.k.p(book.getStatus()) || this.g0.getStatus().contains(Book.STATUS_FINISHED)) {
            return "完结 共" + this.h0.getCount() + "章";
        }
        return "连载至" + this.h0.getCount() + "章";
    }

    /* renamed from: k5 */
    public /* synthetic */ boolean l5(View v2, MotionEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        this.J.f12502b.closeDrawers();
        return false;
    }

    public void k8() {
        if (this.T != null) {
            if (MiConfigSingleton.V3().h6()) {
                this.T.f12498h.setText(getString(R.string.vip_open));
            } else {
                this.T.f12498h.setText(getString(R.string.free_ads));
            }
        }
    }

    private List<v0.a> l4() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.z0.length; i2++) {
            arrayList.add(new v0.a().d(m4(i2)).c(this.z0[i2]));
        }
        return arrayList;
    }

    /* renamed from: l6 */
    public /* synthetic */ void m6(final MiReadingTheme customTheme, int c2) {
        if (this.H0) {
            customTheme.setCustomBackgroundColor(this, c2);
        } else {
            customTheme.setCustomTextColor(this, c2);
        }
        P3();
        a8();
    }

    private void l7() {
        if (!MiConfigSingleton.V3().H4.e() || T4()) {
            return;
        }
        if (this.B0 == null) {
            com.martian.mibook.h.g gVar = new com.martian.mibook.h.g();
            this.B0 = gVar;
            gVar.a(this, this);
        }
        if (this.V == null) {
            this.U.q.setLayoutResource(R.layout.tts_float_view);
            this.V = f7.a(this.U.q.inflate());
            Book T = MiConfigSingleton.V3().l3().T(MiConfigSingleton.V3().H4.d());
            if (T != null) {
                com.martian.libmars.utils.n0.f(this, T.getCover(), this.V.f11974c, R.drawable.cover_default, R.drawable.cover_default);
            }
        }
        this.V.getRoot().setVisibility(0);
        TtsService.U(this, TtsService.f14108i);
    }

    /* renamed from: m5 */
    public /* synthetic */ void n5(View v2) {
        D7(true);
        this.Y.getRoot().setVisibility(8);
    }

    private void m7(int count) {
        int progress = this.M.f12537e.getProgress();
        if (progress <= 0 && count < 0) {
            k1("已调到最慢速度");
            return;
        }
        int i2 = 300;
        if (progress >= 300 && count > 0) {
            k1("已调到最快速度");
            return;
        }
        int i3 = progress + count;
        if (i3 < 0) {
            i2 = 0;
        } else if (i3 <= 300) {
            i2 = i3;
        }
        this.M.f12537e.setProgress(i2);
        Q3(i2);
    }

    /* renamed from: n6 */
    public /* synthetic */ void o6(final MiReadingTheme customTheme, View view) {
        i7(true, customTheme);
    }

    private void n7(View view, boolean show) {
        o7(view, show, com.martian.libmars.utils.h0.f10144a);
    }

    public int o4() {
        return MiConfigSingleton.V3().M5() ? 3 : 6;
    }

    /* renamed from: o5 */
    public /* synthetic */ void p5(View v2) {
        this.a0.getRoot().setVisibility(8);
    }

    public void o7(View view, boolean show, int animation) {
        com.martian.libmars.utils.h0.a(this, view, show, animation);
    }

    private String p4() {
        int m4 = MiConfigSingleton.V3().m4();
        if (m4 == 0) {
            return getString(R.string.page_slider);
        }
        if (m4 == 1) {
            return getString(R.string.overlapped_slider);
        }
        if (m4 == 2) {
            return getString(R.string.scroll_slider);
        }
        if (m4 == 3) {
            return getString(R.string.static_slider);
        }
        if (m4 == 4) {
            return getString(R.string.sim_slider);
        }
        throw new IllegalStateException("Unknown reading slider index: " + MiConfigSingleton.V3().m4());
    }

    /* renamed from: p6 */
    public /* synthetic */ void q6(final MiReadingTheme customTheme, View view) {
        i7(false, customTheme);
    }

    private boolean p7() {
        int i2 = this.x0;
        if (i2 == 0 || i2 >= this.f0.getAdBannerClickGuideInterval()) {
            this.x0 = 1;
            this.v0 = new Random().nextInt(this.f0.getAdBannerClickGuideInterval()) + 1;
        } else {
            this.x0++;
        }
        return this.x0 == this.v0;
    }

    private boolean q4(Intent intent) {
        int i2 = 0;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(com.martian.mibook.application.q0.f11578a);
            if (!com.martian.libsupport.k.p(stringExtra)) {
                Book book = this.g0;
                if (book != null && stringExtra.equalsIgnoreCase(book.getSourceString())) {
                    return false;
                }
                if (MiConfigSingleton.V3().H4.e()) {
                    onTtsBookClick(null);
                } else {
                    MiReadingRecord k0 = MiConfigSingleton.V3().l3().k0();
                    if (k0 != null && stringExtra.equalsIgnoreCase(k0.getSourceString())) {
                        com.martian.mibook.lib.model.g.b.P(this, "通知栏-阅读记录-阅读");
                        s2.j0(this, k0);
                    }
                }
                if (this.g0 == null) {
                    finish();
                }
                return true;
            }
            Uri data = intent.getData();
            if (data != null) {
                String scheme = data.getScheme();
                if (!com.martian.libsupport.k.p(scheme) && getString(R.string.scheme).equalsIgnoreCase(scheme)) {
                    String queryParameter = data.getQueryParameter("sourceId");
                    String queryParameter2 = data.getQueryParameter("sourceName");
                    if (!com.martian.libsupport.k.p(queryParameter) && !com.martian.libsupport.k.p(queryParameter2)) {
                        String queryParameter3 = data.getQueryParameter("chapterIndex");
                        if (!com.martian.libsupport.k.p(queryParameter3)) {
                            try {
                                i2 = Integer.parseInt(queryParameter3);
                            } catch (NumberFormatException e2) {
                                e2.printStackTrace();
                            }
                        }
                        String a2 = com.martian.mibook.lib.model.manager.d.a(new k(queryParameter2, queryParameter));
                        ReadingInfo readingInfo = new ReadingInfo();
                        this.f0 = readingInfo;
                        readingInfo.setRecContext(data.getQueryParameter("recContext"));
                        this.f0.setRecommend(data.getQueryParameter("recommend"));
                        this.f0.setRecommendId(data.getQueryParameter("recommendId"));
                        this.f0.setFromIntent(true);
                        this.f0.initReadingSetting(this);
                        MiBook Q = MiConfigSingleton.V3().l3().Q(a2);
                        if (Q == null || com.martian.libsupport.k.p(Q.getSourceString())) {
                            M4(queryParameter2, queryParameter, i2);
                            return true;
                        }
                        this.f0.setMiBook(Q);
                        Book R = MiConfigSingleton.V3().l3().R(Q);
                        if (R == null) {
                            M4(queryParameter2, queryParameter, i2);
                        } else {
                            L4(R, i2);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: q5 */
    public /* synthetic */ void r5() {
        this.J.f12502b.openDrawer(8388611);
    }

    private void r4() {
        if (this.c0 != null || S4()) {
            return;
        }
        this.J.f12510j.setLayoutResource(R.layout.reading_add_rack_view);
        c5 a2 = c5.a(this.J.f12510j.inflate());
        this.c0 = a2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.getRoot().getLayoutParams();
        this.T.f12494d.measure(0, 0);
        layoutParams.setMargins(0, this.T.f12494d.getMeasuredHeight() + com.martian.libmars.d.h.b(24.0f), 0, 0);
    }

    /* renamed from: r6 */
    public /* synthetic */ void s6(final MiReadingTheme customTheme, final MiReadingTheme preTheme, final int oldIndex, View v2) {
        customTheme.updateTheme(preTheme);
        this.K.f11968g.c(oldIndex).performClick();
        o7(this.P.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
        o7(this.K.getRoot(), true, com.martian.libmars.utils.h0.f10144a);
    }

    private void r7(boolean isShow) {
        c5 c5Var;
        if (S4() || (c5Var = this.c0) == null) {
            return;
        }
        o7(c5Var.getRoot(), isShow, com.martian.libmars.utils.h0.f10147d);
    }

    private void s4() {
        if (this.N == null) {
            this.J.f12505e.setLayoutResource(R.layout.reading_auto_sliding);
            p5 a2 = p5.a(this.J.f12505e.inflate());
            this.N = a2;
            a2.f12529c.setProgress(MiConfigSingleton.V3().Z2() / 2);
            this.N.f12529c.setOnSeekBarChangeListener(new s());
            this.N.f12532f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.h5(view);
                }
            });
        }
    }

    /* renamed from: s5 */
    public /* synthetic */ void t5(View v2) {
        int progress = this.K.f11969h.getProgress();
        if (progress > 5) {
            if (MiConfigSingleton.V3().S5()) {
                b8(false);
            }
            this.K.f11969h.setProgress(progress - 5);
        }
    }

    private boolean s7() {
        if (MiConfigSingleton.V3().u5() || !MiConfigSingleton.V3().O2() || !MiConfigSingleton.V3().c2() || MiConfigSingleton.V3().Z8() || MiConfigSingleton.V3().w2()) {
            return false;
        }
        v2.M0(this, new f0());
        return true;
    }

    private void t4() {
        if (this.U == null) {
            this.J.l.setLayoutResource(R.layout.reading_bottom_bar);
            t5 a2 = t5.a(this.J.l.inflate());
            this.U = a2;
            a2.p.setOnSeekBarChangeListener(new j());
            l7();
        }
        int i2 = 8;
        this.U.f12743f.setVisibility(8);
        this.U.f12740c.g();
        List<MiReadingRecord> list = this.i0;
        if (list != null) {
            list.clear();
        }
        if (this.K0 == CacheStatus.None) {
            this.U.f12739b.setVisibility(8);
        }
        if (this.j0 != null) {
            this.U.p.setMax(r0.w0() - 1);
            this.U.p.setProgress(this.j0.v0());
        }
        long T2 = MiConfigSingleton.V3().T2();
        if (T2 <= 0 || T2 <= MartianRPUserManager.t()) {
            this.U.k.setVisibility(8);
            this.U.f12746i.s();
        } else {
            this.U.k.setVisibility(0);
            this.U.f12746i.o(T2);
            this.U.f12746i.setOnCountDownFinishListener(new IntervalCountdownTextView.b() { // from class: com.martian.mibook.activity.reader.a0
                @Override // com.martian.mibook.ui.IntervalCountdownTextView.b
                public final void a(IntervalCountdownTextView intervalCountdownTextView) {
                    ReadingActivity.this.j5(intervalCountdownTextView);
                }
            });
            ThemeTextView themeTextView = this.U.f12747j;
            ReadingInfo readingInfo = this.f0;
            if (readingInfo != null && readingInfo.isEnableWblAd()) {
                i2 = 0;
            }
            themeTextView.setVisibility(i2);
        }
        V7();
        T7();
    }

    /* renamed from: t6 */
    public /* synthetic */ void u6(final MiReadingTheme customTheme, View v2) {
        customTheme.saveCustomTheme(this);
        o7(this.P.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
    }

    private void t7(final AppTask appTask, ViewGroup parentView, boolean isJoint, boolean hideClose) {
        TextView textView;
        View view;
        if (appTask == null) {
            return;
        }
        parentView.removeAllViews();
        int i2 = this.y0;
        this.y0 = i2 + 1;
        appTask.setAdTag(String.valueOf(i2));
        if (MiBookManager.B2(appTask)) {
            x7((TYBookItem) appTask.origin, parentView, isJoint);
            return;
        }
        ViewGroup viewGroup = null;
        if (appTask.customView == null) {
            boolean isDxFlowAd = DXAd.isDxFlowAd(appTask);
            boolean isGdtFlowAd = GDTAd.isGdtFlowAd(appTask);
            boolean isHwFlowAd = BaseAd.isHwFlowAd(appTask);
            boolean isVivoAd = VivoAd.isVivoAd(appTask);
            boolean isOppoFlowAd = BaseAd.isOppoFlowAd(appTask);
            boolean isBaeFlowAd = BaeAd.isBaeFlowAd(appTask);
            LayoutInflater layoutInflater = getLayoutInflater();
            if (!isDxFlowAd && !isGdtFlowAd && !isHwFlowAd && !isVivoAd && !isOppoFlowAd) {
                viewGroup = parentView;
            }
            view = layoutInflater.inflate(R.layout.reading_ads_banner, viewGroup);
            view.setMinimumWidth(B0());
            view.setMinimumHeight(com.martian.libmars.d.h.b(64.0f));
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_native_image);
            TextView textView2 = (TextView) view.findViewById(R.id.tv_native_ad_title);
            TextView textView3 = (TextView) view.findViewById(R.id.tv_native_ad_desc);
            View findViewById = view.findViewById(R.id.btn_native_creative_view);
            TextView textView4 = (TextView) view.findViewById(R.id.btn_native_creative);
            View findViewById2 = view.findViewById(R.id.btn_native_creative_button);
            TextView textView5 = (TextView) view.findViewById(R.id.tv_ads_logo_desc);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_native_logo);
            TextView textView6 = (TextView) view.findViewById(R.id.banner_click_guide);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_native_close_icon);
            imageView2.setImageResource(appTask.adsIconRes());
            if (VivoAd.isVivoAd(appTask)) {
                View findViewById3 = view.findViewById(R.id.tv_ads_logo_view);
                if (findViewById3 != null) {
                    findViewById3.setVisibility(8);
                }
            } else if (DefaultAd.isDefaultAd(appTask)) {
                textView5.setText(getString(R.string.recommend));
            } else if (MiConfigSingleton.V3().J0()) {
                textView5.setText(String.valueOf(appTask.getEcpm()));
            }
            imageView3.setVisibility(hideClose ? 8 : 0);
            findViewById.setVisibility(isJoint ? 8 : 0);
            textView4.setText(appTask.buttonText);
            textView2.setText(appTask.getTitle());
            textView3.setText(appTask.getDesc());
            com.martian.libmars.utils.n0.k(this, appTask.getPosterUrl(), imageView);
            if (!isHwFlowAd && !isDxFlowAd && !isVivoAd && !isOppoFlowAd && !isBaeFlowAd) {
                view.setClickable(true);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.n0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ReadingActivity.this.Y5(appTask, view2);
                    }
                });
            }
            if (appTask.isHorizontalPicAd()) {
                View findViewById4 = view.findViewById(R.id.desc_text_view);
                View findViewById5 = view.findViewById(R.id.pic_view);
                findViewById.setVisibility(8);
                findViewById4.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById5.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                layoutParams.leftMargin = com.martian.libmars.d.h.b(12.0f);
            }
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReadingActivity.this.a6(view2);
                }
            });
            if (!isHwFlowAd && !isJoint && !isVivoAd) {
                O7(textView6, appTask);
            }
            if (this.f0 != null && appTask.getEcpm() >= this.f0.getAdBannerOptimizeEcpm()) {
                com.martian.libmars.utils.h0.d(findViewById2);
            }
            textView = textView4;
        } else {
            textView = null;
            view = parentView;
        }
        this.d1.g(this, appTask, parentView, view, null, textView, false);
    }

    private void u4() {
        if (MiConfigSingleton.V3().S5()) {
            p0();
        } else {
            V0(MiConfigSingleton.V3().p3());
        }
    }

    /* renamed from: u5 */
    public /* synthetic */ void v5(View v2) {
        int progress = this.K.f11969h.getProgress();
        if (progress < 245) {
            if (MiConfigSingleton.V3().S5()) {
                b8(false);
            }
            this.K.f11969h.setProgress(progress + 5);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void v4() {
        this.J.f12502b.setDrawerLockMode(1);
        this.J.f12502b.addDrawerListener(new a());
        this.J.f12502b.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.activity.reader.f0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ReadingActivity.this.l5(view, motionEvent);
            }
        });
    }

    /* renamed from: v6 */
    public /* synthetic */ void w6(View view) {
        com.martian.libsupport.permission.g.h(this, new d(), new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo("权限申请", "需要存储权限才能读取图片背景\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。", "取消", "前往开启"), true);
    }

    private void v7() {
        if (MiConfigSingleton.V3().j5()) {
            this.R.f12572b.removeAllViews();
            this.R.f12573c.removeAllViews();
            return;
        }
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.H2(i4.p, AdConfig.ActionString.SHOW);
        }
        boolean isVideoAdWatched = this.f0.isVideoAdWatched();
        Book book = this.g0;
        String sourceName = book == null ? "" : book.getSourceName();
        Book book2 = this.g0;
        v2.S0(this, isVideoAdWatched, sourceName, book2 != null ? book2.getSourceId() : "", new p());
    }

    private void w4() {
        if (MiConfigSingleton.V3().B0("READING_PAGE") != 2) {
            D4();
            return;
        }
        h1(true);
        if (this.Y == null) {
            U6("阅读引导-展示");
            g7();
            this.J.f12504d.setLayoutResource(R.layout.reading_first_guide);
            y5 a2 = y5.a(this.J.f12504d.inflate());
            this.Y = a2;
            com.martian.libmars.utils.h0.c(a2.f12994b);
            this.Y.f12995c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.g1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.n5(view);
                }
            });
        }
    }

    /* renamed from: w5 */
    public /* synthetic */ void x5(BookAdsInfo bookAdsInfo) {
        if (bookAdsInfo != null) {
            this.f0.setInterstitial(bookAdsInfo.getInterstitial());
            this.f0.setVideoUnlock(bookAdsInfo.getVideoUnlock());
            if (bookAdsInfo.getReadingAdsInterval() != null) {
                this.f0.setAdInterval(bookAdsInfo.getReadingAdsInterval().intValue());
            }
        }
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    private void w7() {
        if (!MiConfigSingleton.V3().b2() || com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        g7();
        i4 i4Var = this.j0;
        ReadingInfo readingInfo = this.f0;
        v2.J0(this, i4Var, readingInfo != null && readingInfo.isVideoAdWatched(), new e0());
    }

    private void x4() {
        if (MiConfigSingleton.V3().L0("SCROLL_SLIDER")) {
            g7();
            h1(true);
            if (this.a0 == null) {
                this.J.f12503c.setLayoutResource(R.layout.scroll_reading_first_guide);
                u6 a2 = u6.a(this.J.f12503c.inflate());
                this.a0 = a2;
                a2.f12799b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.g0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingActivity.this.p5(view);
                    }
                });
            }
        }
    }

    /* renamed from: x6 */
    public /* synthetic */ void y6(int c2) {
        v5 v5Var = this.P;
        v5Var.f12839c.setColors(com.martian.mibook.ui.colorpicker.a.b(v5Var.f12838b.getColor()));
        if (this.I0) {
            return;
        }
        v5 v5Var2 = this.P;
        v5Var2.f12839c.setSelectedColor(v5Var2.f12838b.getColor());
    }

    private void x7(final TYBookItem tyBookItem, ViewGroup parentView, boolean isJoint) {
        final e5 a2 = e5.a(getLayoutInflater().inflate(R.layout.reading_ads_book, (ViewGroup) null));
        MiBookManager.d2(this, tyBookItem, a2.f11910b);
        MiBookManager.d2(this, tyBookItem, a2.f11911c);
        a2.f11914f.setText(tyBookItem.getTitle());
        a2.f11913e.setText(tyBookItem.getRecDesc());
        if (com.martian.libsupport.k.p(tyBookItem.getDeeplink())) {
            a2.f11912d.setText(getString(R.string.add_to_book_store));
        } else {
            a2.f11912d.setText(getString(R.string.free_read));
        }
        a2.f11912d.setVisibility(isJoint ? 8 : 0);
        a2.f11912d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingActivity.this.e6(tyBookItem, a2, view);
            }
        });
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingActivity.this.g6(tyBookItem, view);
            }
        });
        parentView.addView(a2.getRoot());
        MiConfigSingleton.V3().l3().I1(0, tyBookItem.getSourceName(), tyBookItem.getSourceId(), tyBookItem.getRecommendId(), "", "展示");
        com.martian.mibook.lib.model.g.b.w(this, "Banner-曝光");
    }

    private void y4() {
        if (this.Q == null) {
            this.J.o.setLayoutResource(R.layout.reading_left_drawer);
            this.Q = b6.a(this.J.o.inflate());
            this.z0 = new Fragment[]{z3.m(k4(), this.g0.getSourceName(), this.g0.getSourceId(), this.f0.getRecord().getChapterIndex()), q3.l(com.martian.mibook.lib.model.manager.d.j(this.g0.getSourceName(), this.g0.getSourceId()))};
            com.martian.libmars.utils.v0 v0Var = new com.martian.libmars.utils.v0(getSupportFragmentManager(), l4());
            this.Q.f11763c.setAdapter(v0Var);
            this.Q.f11766f.setPadding(0, com.martian.libsupport.l.w(this) && MiConfigSingleton.V3().M5() ? ImmersionBar.getStatusBarHeight(this) : com.martian.libmars.d.h.b(8.0f), 0, 0);
            List<v0.a> b2 = v0Var.b();
            CommonNavigator commonNavigator = new CommonNavigator(this);
            commonNavigator.setAdapter(new b(b2));
            commonNavigator.setAdjustMode(true);
            this.Q.f11762b.setNavigator(commonNavigator);
            b6 b6Var = this.Q;
            com.martian.libmars.utils.tablayout.p.a(b6Var.f11762b, b6Var.f11763c);
            this.Q.f11763c.addOnPageChangeListener(new c(commonNavigator));
            Book book = this.g0;
            if (book != null) {
                MiBookManager.d2(this, book, this.Q.f11765e);
                this.Q.f11767g.setText(this.g0.getBookName());
                this.Q.f11764d.setText(this.g0.getAuthor());
            }
        } else {
            Fragment[] fragmentArr = this.z0;
            if (fragmentArr != null) {
                ((z3) fragmentArr[0]).p(this.f0.getRecord().getChapterIndex());
                ((q3) this.z0[1]).n();
            }
        }
        MiReadingTheme r2 = MiConfigSingleton.V3().J4.r();
        this.Q.f11767g.setTextColor(r2.getTextColorPrimary(this));
        this.Q.f11764d.setTextColor(r2.getTextColorThirdly(this));
        new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.reader.j0
            @Override // java.lang.Runnable
            public final void run() {
                ReadingActivity.this.r5();
            }
        });
    }

    /* renamed from: y5 */
    public /* synthetic */ void z5() {
        k6 k6Var = this.Z;
        if (k6Var != null) {
            try {
                k6Var.getRoot().setVisibility(8);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void z4(Integer chapterIndex, Integer contentIndex, Integer contentSize) {
        if (chapterIndex == null) {
            chapterIndex = 0;
        }
        if (contentIndex == null) {
            contentIndex = 0;
        }
        if (contentSize == null) {
            contentSize = 0;
        }
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.V2(this.l0);
            if (this.j0.v0() == chapterIndex.intValue()) {
                return;
            }
            this.j0.U2(contentIndex.intValue(), contentSize.intValue());
            this.j0.R2(chapterIndex.intValue());
            this.j0.O2();
            return;
        }
        this.j0 = new i4(this.g0, this.h0, this, this.J, this.f0);
        w4();
        R7();
        Z7();
        X7();
        this.j0.V2(this.l0);
        this.j0.U2(contentIndex.intValue(), contentSize.intValue());
        if (this.j0.R2(chapterIndex.intValue()) && this.Y == null) {
            this.f0.setFirstSlide(true);
            g7();
            D7(true);
            D4();
        } else {
            E7(false, true);
        }
        if (this.j0.v0() < 0) {
            o7(this.J.k.getRoot(), false, com.martian.libmars.utils.h0.f10146c);
        }
        this.j0.W2(new d0());
        E4();
        P3();
        Q7();
    }

    /* renamed from: z6 */
    public /* synthetic */ void A6(AdapterView parent, View view, int position, long id) {
        int m4 = MiConfigSingleton.V3().m4();
        if (position == 0) {
            MiConfigSingleton.V3().Y7(1);
        } else if (position == 1) {
            MiConfigSingleton.V3().Y7(4);
        } else if (position == 2) {
            MiConfigSingleton.V3().Y7(0);
        } else if (position == 3) {
            MiConfigSingleton.V3().Y7(2);
            x4();
        } else if (position == 4) {
            MiConfigSingleton.V3().Y7(3);
        }
        if (m4 == MiConfigSingleton.V3().m4()) {
            return;
        }
        E7(false, true);
        this.c1.b(p4());
        F4();
        C4();
    }

    private void z7() {
        final int s2 = MiConfigSingleton.V3().J4.s();
        this.K.f11968g.c(MiConfigSingleton.V3().J4.f()).performClick();
        final MiReadingTheme e2 = MiConfigSingleton.V3().J4.e();
        final MiReadingTheme miReadingTheme = new MiReadingTheme();
        miReadingTheme.updateTheme(e2);
        if (this.P == null) {
            this.J.m.setLayoutResource(R.layout.reading_colorpicker);
            this.P = v5.a(this.J.m.inflate());
        }
        this.P.f12843g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingActivity.this.s6(e2, miReadingTheme, s2, view);
            }
        });
        this.P.f12844h.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingActivity.this.u6(e2, view);
            }
        });
        this.P.f12840d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingActivity.this.w6(view);
            }
        });
        this.P.f12838b.setColors(com.martian.mibook.ui.colorpicker.a.a());
        this.P.f12838b.setOnColorChangedListener(new LineColorPicker.b() { // from class: com.martian.mibook.activity.reader.r
            @Override // com.martian.mibook.ui.colorpicker.LineColorPicker.b
            public final void a(int i2) {
                ReadingActivity.this.y6(i2);
            }
        });
        this.P.f12839c.setOnColorChangedListener(new LineColorPicker.b() { // from class: com.martian.mibook.activity.reader.x
            @Override // com.martian.mibook.ui.colorpicker.LineColorPicker.b
            public final void a(int i2) {
                ReadingActivity.this.m6(e2, i2);
            }
        });
        i7(this.H0, e2);
        this.P.f12841e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingActivity.this.o6(e2, view);
            }
        });
        this.P.f12842f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingActivity.this.q6(e2, view);
            }
        });
        b1(new e(e2));
        o7(this.P.getRoot(), true, com.martian.libmars.utils.h0.f10144a);
        o7(this.K.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
    }

    public void C7() {
        D7(this.k0);
    }

    public void E7(boolean showMenu, boolean force) {
        p5 p5Var;
        p5 p5Var2;
        v5 v5Var = this.P;
        if (v5Var != null && v5Var.getRoot().getVisibility() == 0) {
            this.a1 = true;
            return;
        }
        this.a1 = showMenu || O4();
        if (showMenu) {
            G4();
            t4();
            if (T4()) {
                H4();
                n7(this.M.getRoot(), true);
            } else if (!N4() || (p5Var2 = this.N) == null) {
                o7(this.T.getRoot(), true, com.martian.libmars.utils.h0.f10145b);
                o7(this.J.x, true, com.martian.libmars.utils.h0.f10145b);
                n7(this.U.getRoot(), true);
                r7(true);
            } else {
                n7(p5Var2.getRoot(), true);
                this.o0.c();
            }
        } else {
            if (T4() || this.M != null) {
                H4();
                n7(this.M.getRoot(), false);
            }
            if (N4() && (p5Var = this.N) != null) {
                n7(p5Var.getRoot(), false);
                this.o0.d();
            }
            n6 n6Var = this.O;
            if (n6Var != null && n6Var.getRoot().getVisibility() == 0) {
                n7(this.O.getRoot(), false);
                if (!force) {
                    return;
                }
            }
            o7(this.J.x, false, com.martian.libmars.utils.h0.f10145b);
            o6 o6Var = this.T;
            if (o6Var != null) {
                o7(o6Var.getRoot(), false, com.martian.libmars.utils.h0.f10145b);
            }
            t5 t5Var = this.U;
            if (t5Var != null) {
                o7(t5Var.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
                this.U.f12746i.s();
            }
            f6 f6Var = this.K;
            if (f6Var != null) {
                o7(f6Var.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
            }
            l6 l6Var = this.L;
            if (l6Var != null) {
                o7(l6Var.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
            }
            q6 q6Var = this.b0;
            if (q6Var != null) {
                n7(q6Var.getRoot(), false);
            }
            d6 d6Var = this.d0;
            if (d6Var != null) {
                n7(d6Var.getRoot(), false);
            }
            r7(false);
        }
        this.k0 = !showMenu;
        a8();
    }

    public void G7() {
        if (this.L == null) {
            this.J.r.setLayoutResource(R.layout.reading_slide_mode);
            l6 a2 = l6.a(this.J.r.inflate());
            this.L = a2;
            a2.f12314c.setDividerHeight(0);
            com.martian.mibook.ui.n nVar = new com.martian.mibook.ui.n(this, p4());
            this.c1 = nVar;
            this.L.f12314c.setAdapter((ListAdapter) nVar);
            this.L.f12314c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.activity.reader.v0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    ReadingActivity.this.A6(adapterView, view, i2, j2);
                }
            });
            this.L.f12316e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.o0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.C6(view);
                }
            });
        } else {
            this.c1.notifyDataSetChanged();
        }
        n7(this.L.getRoot(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void J3(boolean z2) {
        String str;
        if (!MiConfigSingleton.V3().x5()) {
            this.R0 = true;
            return;
        }
        if (this.S0) {
            return;
        }
        this.R0 = false;
        if (e4()) {
            this.S0 = true;
            h hVar = new h(this, z2);
            hVar.n();
            ((RtParams) hVar.k()).setD(300);
            ((RtParams) hVar.k()).setS(this.g0.getSourceString());
            try {
                str = com.martian.libsupport.b.a("60_" + this.g0.getSourceString(), com.martian.libmars.d.h.F().d0());
            } catch (Exception unused) {
                str = "";
            }
            if (this.h0 != null) {
                ((RtParams) hVar.k()).setCs(Integer.valueOf(this.h0.getCount()));
            }
            if (this.f0.getRecord() != null) {
                ((RtParams) hVar.k()).setCi(Integer.valueOf(this.f0.getRecord().getChapterIndex()));
            }
            i4 i4Var = this.j0;
            if (i4Var != null) {
                ((RtParams) hVar.k()).setV(Integer.valueOf(i4Var.Q0() ? 1 : 0));
                ((RtParams) hVar.k()).setCcid(this.j0.s0(null));
            }
            ((RtParams) hVar.k()).setC(str);
            ((RtParams) hVar.k()).setSeq(Integer.valueOf((int) (this.f0.getTimeStamp() / 1000)));
            hVar.j();
        }
    }

    public void K4() {
        this.J.x.getLayoutParams().height = ImmersionBar.getStatusBarHeight(this);
        ReadingInfo readingInfo = this.f0;
        if (readingInfo != null) {
            readingInfo.setReadingHint(MiConfigSingleton.V3().l3().t2(this.f0.isFirstSlide()));
        }
        this.o0 = new com.martian.mibook.tts.b(this.J.q.f12206i);
        u4();
        this.J.q.f12200c.w.setTextSize(MiConfigSingleton.V3().H3());
        this.J.q.f12200c.w.t();
        this.J.q.f12200c.w.v();
        this.J.q.f12200c.w.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.martian.mibook.activity.reader.u
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                ReadingActivity.this.H5(view, i2, i3, i4, i5, i6, i7, i8, i9);
            }
        });
        this.J.k.k.setVisibility(MiConfigSingleton.V3().F8() ? 0 : 8);
        F4();
        v4();
    }

    public void L7() {
        onStopAutoSlidingClick(null);
    }

    public boolean N4() {
        com.martian.mibook.tts.b bVar = this.o0;
        return bVar != null && bVar.b();
    }

    public void PrefChapterCommentClick(View view) {
        Book book;
        boolean isChecked = this.d0.z.isChecked();
        StringBuilder sb = new StringBuilder();
        sb.append("章评-");
        sb.append(isChecked ? "显示" : "隐藏");
        U6(sb.toString());
        MiConfigSingleton.V3().k8(isChecked);
        if (this.f0 != null && (book = this.g0) != null && !book.isLocal()) {
            this.f0.setShowChapterComment(!MiConfigSingleton.V3().j5() && MiConfigSingleton.V3().C8());
        }
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.u();
        }
    }

    public void Q7() {
        if (q7()) {
            q5 q5Var = this.R;
            if (q5Var != null) {
                o7(q5Var.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
            }
            this.G0 = false;
            d4();
            Z6();
            return;
        }
        if (this.R == null) {
            this.J.q.f12201d.setLayoutResource(R.layout.reading_banner);
            q5 a2 = q5.a(this.J.q.f12201d.inflate());
            this.R = a2;
            a2.f12574d.getLayoutParams().width = MiConfigSingleton.V3().M5() ? B0() : z0();
        }
        if (!this.G0) {
            this.R.getRoot().setVisibility(0);
        }
        P6();
    }

    public void S6(AppTaskList appTaskList) {
        if (appTaskList != null && appTaskList.getApps() != null && appTaskList.getApps().size() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("插页");
            sb.append(appTaskList.getApps().size() == 2 ? "双拼" : "三拼");
            U6(sb.toString());
        }
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.F2(appTaskList);
        }
    }

    public boolean T4() {
        ReadingInfo readingInfo = this.f0;
        return readingInfo != null && readingInfo.isTtsMode();
    }

    @Override // com.martian.libmars.activity.j1
    protected void U1(boolean darkMode) {
        super.U1(darkMode);
        j8();
        if (this.J.f12502b.isDrawerOpen(8388611)) {
            this.J.f12502b.closeDrawer(8388611);
        }
    }

    public void W3() {
        if (this.T0 || com.martian.libmars.utils.n0.c(this)) {
            return;
        }
        if (MiConfigSingleton.V3().O0()) {
            com.martian.mibook.lib.model.g.b.O(this, "无网络-展示");
            if (this.S == null) {
                this.J.f12508h.setLayoutResource(R.layout.reading_network_offline);
                e6 a2 = e6.a(this.J.f12508h.inflate());
                this.S = a2;
                a2.f11917c.setText(MiConfigSingleton.V3().n("网络连接发生问题，请检查您的网络设置"));
            }
            this.S.getRoot().setVisibility(0);
            new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.r0
                @Override // java.lang.Runnable
                public final void run() {
                    ReadingActivity.this.b5();
                }
            }, 30000L);
        } else {
            e6 e6Var = this.S;
            if (e6Var != null) {
                e6Var.getRoot().setVisibility(8);
            }
        }
        A7();
    }

    public void X7() {
        this.J.q.f12200c.q.setPadding(0, 0, 0, q7() ? 0 : com.martian.libmars.d.h.b(64.0f));
    }

    public void Z3() {
        i4 i4Var = this.j0;
        if (i4Var == null) {
            return;
        }
        i4Var.g0(i4Var.v0());
    }

    @Override // com.martian.mibook.h.g.a
    public void a(long targetTime) {
        if (!T4() || this.M == null || targetTime <= 0 || targetTime <= System.currentTimeMillis()) {
            return;
        }
        this.M.f12541i.o(targetTime);
    }

    @Override // com.martian.mibook.ui.o.i4.w
    public void a0() {
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.H2(i4.m, "观看成功");
        }
        T3();
        if (this.f0.getRecord() != null) {
            I7(this.f0.getRecord().getChapterIndex());
        }
    }

    public void autoBuyNextChapterClick(View view) {
        U6("自动购买下一章");
        MiUserManager.s().C(this.d0.f11861d.isChecked());
    }

    @Override // com.martian.mibook.application.n0.b
    public void b(Book book, b.d.c.b.c errorResult) {
        this.U.t.setText("");
        this.U.s.setText(MiConfigSingleton.V3().n("缓存失败: "));
        this.K0 = CacheStatus.Error;
        k1(errorResult.d());
    }

    @Override // com.martian.mibook.h.g.a
    public void b0() {
        p6 p6Var = this.M;
        if (p6Var != null) {
            p6Var.f12538f.setImageResource(R.drawable.reader_icon_ting_start);
        }
        X6();
    }

    @Override // com.martian.mibook.h.g.a
    public void d0(int chapterIndex, int contentIndex, String sourceString) {
        i4 i4Var;
        W6();
        if (this.f0 == null || com.martian.libsupport.k.p(sourceString) || !sourceString.equalsIgnoreCase(this.f0.getSourceString())) {
            return;
        }
        A7();
        this.k0 = true;
        p6 p6Var = this.M;
        if (p6Var != null) {
            n7(p6Var.getRoot(), false);
        }
        c7(-100L);
        if (contentIndex >= 0 && (i4Var = this.j0) != null) {
            i4Var.R2(chapterIndex);
            this.j0.T2(contentIndex);
            this.j0.N2(false);
        }
        k1("已退出语音朗读");
    }

    @Override // com.martian.mibook.ui.o.i4.w
    public void dismissDialog() {
    }

    @Override // com.martian.mibook.application.n0.b
    public void e(Book book) {
        k1("缓存已取消");
    }

    @Override // com.martian.mibook.h.g.a
    public void e0(boolean hide) {
        if (T4() && this.J0 != hide) {
            this.J0 = hide;
            if (hide && this.W == null) {
                return;
            }
            if (this.W == null) {
                this.J.q.f12202e.setLayoutResource(R.layout.tts_position_control_view);
                this.W = g7.a(this.J.q.f12202e.inflate());
            }
            this.W.getRoot().setVisibility(hide ? 8 : 0);
        }
    }

    @Override // com.martian.mibook.application.n0.b
    public void f(Book book) {
        this.U.s.setText(MiConfigSingleton.V3().n("正在缓存: "));
        this.U.r.setText(j4());
        this.K0 = CacheStatus.Caching;
        D7(true);
    }

    @Override // com.martian.mibook.ui.o.i4.w
    public void f0() {
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.I0(MiConfigSingleton.V3().W2(this.f0.isVideoAdWatched()));
        }
    }

    @Override // com.martian.libmars.activity.h1, android.app.Activity
    public void finish() {
        ActivityManager activityManager;
        if (this.P0 > 0 || this.i1) {
            Intent intent = new Intent();
            intent.putExtra(E, this.P0);
            intent.putExtra(F, this.i1);
            setResult(-1, intent);
        }
        ReadingInfo readingInfo = this.f0;
        if (readingInfo != null && readingInfo.isFromIntent() && (activityManager = (ActivityManager) getSystemService(TTDownloadField.TT_ACTIVITY)) != null && activityManager.getRunningTasks(1) != null && !activityManager.getRunningTasks(1).isEmpty()) {
            String className = activityManager.getRunningTasks(1).get(0).baseActivity.getClassName();
            if (!com.martian.libsupport.k.p(className) && !className.contains("Homepage")) {
                L3("intent");
                startActivity(Homepage.class);
                new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadingActivity.this.f5();
                    }
                }, 500L);
                return;
            }
        }
        N7();
    }

    @Override // com.martian.mibook.g.c
    public void g0() {
    }

    @Override // com.martian.libmars.activity.f1
    public View g2() {
        return this.J.f12509i;
    }

    public void g7() {
        MiConfigSingleton.V3().L4.y0();
    }

    @Override // com.martian.mibook.ui.o.i4.w
    public void h0() {
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.H2(i4.s, "观看成功");
        }
        MiConfigSingleton.V3().Y6();
        H7();
    }

    public void i7(boolean selectBackground, MiReadingTheme customTheme) {
        if (selectBackground) {
            this.H0 = true;
            this.P.f12845i.setBackgroundResource(R.drawable.border_button_theme_default);
            this.P.f12846j.setBackgroundColor(getResources().getColor(R.color.transparent));
            this.P.f12841e.setTypeface(Typeface.DEFAULT_BOLD);
            this.P.f12842f.setTypeface(Typeface.DEFAULT);
        } else {
            this.H0 = false;
            this.P.f12845i.setBackgroundColor(getResources().getColor(R.color.transparent));
            this.P.f12846j.setBackgroundResource(R.drawable.border_button_theme_default);
            this.P.f12841e.setTypeface(Typeface.DEFAULT);
            this.P.f12842f.setTypeface(Typeface.DEFAULT_BOLD);
        }
        int backgroundPrimary = this.H0 ? customTheme.getBackgroundPrimary() : customTheme.getTextColorPrimary();
        this.I0 = this.H0 && !customTheme.isColorBackground();
        for (int i2 : com.martian.mibook.ui.colorpicker.a.a()) {
            for (int i3 : com.martian.mibook.ui.colorpicker.a.b(i2)) {
                if (ContextCompat.getColor(this, i3) == backgroundPrimary) {
                    this.P.f12838b.setSelectedColor(i2);
                    this.P.f12839c.setColors(com.martian.mibook.ui.colorpicker.a.b(i2));
                    if (this.I0) {
                        this.I0 = false;
                        return;
                    } else {
                        this.P.f12839c.setSelectedColor(i3);
                        return;
                    }
                }
            }
        }
        this.P.f12838b.setSelectedColor(5);
        this.P.f12839c.setColors(com.martian.mibook.ui.colorpicker.a.b(5));
    }

    @Override // com.martian.mibook.application.n0.b
    public void j(Book book) {
        this.U.s.setText(MiConfigSingleton.V3().n("缓存完成: "));
        this.K0 = CacheStatus.Finished;
    }

    @Override // com.martian.mibook.g.c
    public void k0(int chapterIndex, int contentPos, int contentSize, int resultCode) {
        z4(Integer.valueOf(chapterIndex), Integer.valueOf(contentPos), Integer.valueOf(contentSize));
        this.J.f12502b.closeDrawer(8388611);
        A7();
    }

    public void k7(View titleView, int paddingBottom) {
        titleView.setPadding(com.martian.libmars.d.h.b(24.0f), F1(), com.martian.libmars.d.h.b(152.0f), com.martian.libmars.d.h.b(paddingBottom));
    }

    @Override // com.martian.mibook.ui.o.i4.w
    public void l0() {
        if (MiConfigSingleton.V3().h6() || O4() || MiConfigSingleton.V3().g0() <= 1) {
            return;
        }
        if (!Q4() || this.f0.isVideoAdWatched()) {
            if (this.f0.isVideoAdWatched()) {
                w7();
                return;
            }
            if (q7()) {
                return;
            }
            if (F7()) {
                g7();
            } else if (s7()) {
                g7();
            } else {
                w7();
            }
        }
    }

    @Override // com.martian.mibook.application.n0.b
    public void m(Book book) {
        this.U.s.setText(MiConfigSingleton.V3().n("正在缓存: "));
        this.U.r.setText(j4());
        this.K0 = CacheStatus.Caching;
        D7(true);
        if (this.Q != null) {
            this.J.f12502b.closeDrawers();
        }
    }

    @Override // com.martian.mibook.ui.o.i4.w
    public void m0() {
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.H2(i4.n, "观看成功");
        }
        MiConfigSingleton.V3().q8();
        P7();
    }

    public String m4(int position) {
        return position == 0 ? getString(R.string.open_dir) : getString(R.string.bookmark_name);
    }

    @Override // com.martian.mibook.application.n0.b
    public void n(Book book, int failedSize) {
        this.U.s.setText(MiConfigSingleton.V3().n("缓存完成: "));
        k1(failedSize + " 个章节缓存失败");
        this.K0 = CacheStatus.Finished;
    }

    @Override // com.martian.mibook.h.g.a
    public void n0() {
        p6 p6Var = this.M;
        if (p6Var != null) {
            p6Var.f12538f.setImageResource(R.drawable.reader_icon_ting_pause);
        }
        Y6();
    }

    public int n4() {
        int t4 = (int) MiConfigSingleton.V3().t4();
        if (t4 == -1) {
            return 0;
        }
        if (t4 == 120000) {
            return 1;
        }
        if (t4 != 300000) {
            return t4 != 600000 ? 4 : 3;
        }
        return 2;
    }

    @Override // com.martian.mibook.application.n0.b
    @SuppressLint({"SetTextI18n"})
    public void o(Book book, int index, int size, boolean cachedBefore) {
        this.U.t.setText("(" + (index + 1) + "/" + size + ")");
        this.L0 = index;
        if (this.K0 == CacheStatus.Abort) {
            MiConfigSingleton.V3().q3().i(this.g0);
        }
    }

    @Override // com.martian.mibook.h.g.a
    public void o0(int chapterIndex, int contentIndex) {
        i4 i4Var;
        if (T4() && (i4Var = this.j0) != null) {
            if (i4Var.v0() == chapterIndex) {
                this.j0.T2(contentIndex);
                return;
            }
            this.j0.R2(chapterIndex);
            this.j0.U2(contentIndex, 0);
            this.j0.O2();
            if (contentIndex == 0) {
                T7();
            }
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, final int resultCode, final Intent data) {
        if (requestCode == 5873) {
            K7();
            return;
        }
        if ((requestCode == 10001 || requestCode == 10003 || requestCode == 1005 || requestCode == 1006 || requestCode == 1019 || requestCode == 1020) && resultCode == -1) {
            com.martian.mibook.lib.model.g.b.K(this, MiConfigSingleton.V3().T3("登录成功", requestCode));
            if (this.R0) {
                J3(true);
            }
            if (requestCode == 10003) {
                i4 i4Var = this.j0;
                if (i4Var != null) {
                    i4Var.q3(i4Var.A0());
                }
                A7();
            } else {
                D7(true);
            }
            Y7(false);
        } else if (requestCode == 100 && resultCode == -1) {
            com.martian.mibook.lib.account.e.c.k(this, new g());
        } else if (requestCode == 10006 && resultCode == -1) {
            com.martian.mibook.lib.model.g.b.r(this, "视频解锁 : api_complete");
            i4 i4Var2 = this.j0;
            if (i4Var2 != null) {
                i4Var2.I2(true);
            }
        } else if (requestCode == 1001) {
            new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.reader.f1
                @Override // java.lang.Runnable
                public final void run() {
                    ReadingActivity.this.N5();
                }
            });
        } else if (requestCode == 10024) {
            Y7(resultCode == -1);
        } else if (requestCode == 205 && resultCode == -1) {
            q4 q4Var = this.k1;
            if (q4Var != null) {
                q4Var.p(new TypefaceManager(this).d());
            }
        } else if (requestCode == 777 && resultCode == -1) {
            setResult(205);
            i4 i4Var3 = this.j0;
            if (i4Var3 != null) {
                i4Var3.r3(true);
            }
        } else if (requestCode == 1012 && resultCode == -1 && this.j0 != null && data != null) {
            String stringExtra = data.getStringExtra(ChapterCommentActivity.H);
            if (!com.martian.libsupport.k.p(stringExtra)) {
                try {
                    ChapterCommentCount chapterCommentCount = (ChapterCommentCount) GsonUtils.b().fromJson(stringExtra, ChapterCommentCount.class);
                    if (chapterCommentCount != null) {
                        this.j0.w3(chapterCommentCount);
                    }
                } catch (Exception unused) {
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onAddBookMark(View view) {
        i4 i4Var = this.j0;
        if (i4Var == null) {
            k1("加载过程中不能加书签");
            return;
        }
        MiReadingContent A0 = i4Var.A0();
        if (A0 == null || !A0.isReady()) {
            k1("加载过程中不能加书签");
            return;
        }
        U6("添加书签");
        d7();
        MiBookMark miBookMark = new MiBookMark();
        int chapterIndex = this.f0.getRecord().getChapterIndex();
        Chapter item = this.h0.getItem(chapterIndex);
        miBookMark.setChapterIndex(Integer.valueOf(chapterIndex));
        miBookMark.setSourceString(this.f0.getRecord().getSourceString());
        if (item != null) {
            miBookMark.setChapterTitle(item.getTitle());
        }
        miBookMark.setMarkTime(Long.valueOf(new Date().getTime()));
        int contentLength = A0.getChapterContent().getContentLength();
        miBookMark.setContentSize(Integer.valueOf(contentLength));
        int contentPos = A0.getContentPos(this.f0.getRecord().getContentIndex().intValue() - 1);
        miBookMark.setContentPos(Integer.valueOf(contentPos));
        miBookMark.setDimiPercent(Integer.valueOf((contentPos * 10000) / contentLength));
        int min = Math.min(contentPos + 100, miBookMark.getContentSize().intValue());
        miBookMark.setSummary(A0.getChapterContent().getContent(Math.max(0, Math.min(min - 100, contentPos)), min));
        if (MiConfigSingleton.V3().l3().b(miBookMark)) {
            k1("书签保存成功");
        } else {
            k1("书签保存失败");
        }
        b4();
    }

    public void onAddToBookrackClick(View view) {
        L3("手动");
        this.J.f12510j.getRootView().setVisibility(8);
    }

    public void onAlwaysShowVirtualKeyClick(View view) {
        boolean isChecked = this.d0.f11859b.isChecked();
        StringBuilder sb = new StringBuilder();
        sb.append("虚拟键-");
        sb.append(isChecked ? "显示" : "隐藏");
        U6(sb.toString());
        MiConfigSingleton.V3().W6(isChecked);
        new Handler().post(new Runnable() { // from class: com.martian.mibook.activity.reader.i0
            @Override // java.lang.Runnable
            public final void run() {
                ReadingActivity.this.a8();
            }
        });
    }

    public void onAutoSlideSpeedDownClick(View v2) {
        e7(-1);
    }

    public void onAutoSlideSpeedUpClick(View v2) {
        e7(1);
    }

    public void onBackClick(View view) {
        finish();
    }

    public void onBonusModeClick(View view) {
        if (MiConfigSingleton.V3().l2(this, 1021)) {
            U6("点击赚钱模式");
            IncomeActivity.w2(this, 0, com.martian.mibook.b.b.y);
        }
    }

    public void onBookCommentClick(View view) {
        BookInfoActivity.o bookInfo = this.f0.toBookInfo();
        Book book = this.g0;
        if (book != null) {
            bookInfo.H(book.getSourceId()).I(this.g0.getSourceName()).u(this.g0.getBookName()).s(this.g0.getAuthor());
        }
        U6("查看评论-菜单");
        WholeCommentActivity.r2(this, bookInfo);
        b4();
    }

    public void onBookMallClick(View view) {
        U6("去书城");
        com.martian.apptask.g.g.t(this, getString(R.string.scheme) + "://m.taoyuewenhua.com/homepage?tid=0&tab=1");
    }

    public void onBookRackClick(View view) {
        U6("去书架");
        com.martian.apptask.g.g.t(this, getString(R.string.scheme) + "://m.taoyuewenhua.com/homepage?tab=0");
    }

    public void onBookReportClick(View view) {
        U6("举报");
        Book book = this.g0;
        i4 i4Var = this.j0;
        Chapter chapter = null;
        if (i4Var != null && i4Var.A0() != null) {
            chapter = this.j0.A0().getChapter();
        }
        s2.Z(this, book, chapter);
        b4();
    }

    public void onCacheClick(View v2) {
        if (this.h0 == null) {
            return;
        }
        U6("缓存");
        Book book = this.g0;
        if (book != null && book.isLocal()) {
            k1("本地书籍不支持缓存");
            return;
        }
        Chapter item = this.h0.getItem(this.f0.getRecord().getChapterIndex());
        if (item instanceof YWChapter) {
            YWChapter yWChapter = (YWChapter) item;
            if (yWChapter.getVipflag().intValue() == 1 && yWChapter.getFreeStatus().intValue() == 0) {
                k1("限免书籍不支持缓存");
                return;
            }
        }
        if (MiConfigSingleton.V3().h6() || MiConfigSingleton.V3().J0()) {
            T3();
            if (this.f0.getRecord() != null) {
                I7(this.f0.getRecord().getChapterIndex());
                return;
            }
            return;
        }
        this.j0.H2(i4.m, AdConfig.ActionString.SHOW);
        String string = getString(R.string.cache_chapter);
        String string2 = getString(R.string.cache_chapter_video);
        String string3 = getString(R.string.vip_for_cache);
        Book book2 = this.g0;
        String sourceName = book2 == null ? "" : book2.getSourceName();
        Book book3 = this.g0;
        v2.Q0(this, string, string2, string3, "缓存章节-vip", sourceName, book3 == null ? "" : book3.getSourceId(), new q());
    }

    @Override // com.martian.libmars.activity.f1, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d(false);
        com.martian.mibook.e.p c2 = com.martian.mibook.e.p.c(getLayoutInflater());
        this.J = c2;
        setContentView(c2.getRoot());
        U6("阅读界面-展示");
        this.J.k.f12619b.setPadding(0, F1() - 8, 0, 0);
        k7(this.J.q.f12200c.y, 12);
        k7(this.J.q.m, 0);
        s2.E(this);
        this.A0 = new com.martian.mibook.application.f0(this);
        B4(savedInstanceState);
        K4();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (this.K0 != CacheStatus.None) {
                MiConfigSingleton.V3().q3().B(this.g0, this);
            }
            this.M0.removeCallbacks(this.Z0);
            com.martian.mibook.tts.b bVar = this.o0;
            if (bVar != null) {
                bVar.a();
            }
            this.J.q.f12206i.q();
            i4 i4Var = this.j0;
            if (i4Var != null) {
                i4Var.M2();
            }
            this.A0.i();
            d4();
            V6();
            x2.a();
            com.martian.mibook.h.g gVar = this.B0;
            if (gVar != null) {
                gVar.c(this);
            }
            W6();
        } catch (Exception unused) {
        }
    }

    public void onDetailClick(View view) {
        Book book = this.g0;
        if (book != null && book.isLocal()) {
            k1("本地书籍不支持详情");
            return;
        }
        U6("书籍详情");
        s2.R(this, this.g0);
        b4();
    }

    public void onDirClick(View v2) {
        U6("目录tab");
        y4();
        E7(false, true);
        h8(MiConfigSingleton.V3().J4.k());
        if (this.Q.f11763c.getCurrentItem() != 0) {
            this.J.f12502b.setDrawerLockMode(0);
        } else {
            this.J.f12502b.setDrawerLockMode(2);
        }
        MiReadingTheme r2 = MiConfigSingleton.V3().J4.r();
        i8(r2.getTextColorThirdly(this), r2.getItemColorPrimary());
    }

    public void onExitDialogCloseClick(View view) {
        BottomSheetBehavior<View> bottomSheetBehavior = this.n1;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.T(5);
        }
    }

    public void onExitReadingClick(View view) {
        super.finish();
    }

    public void onExitTtsClick(View view) {
        U6("退出听书");
        TtsService.U(this, TtsService.f14104e);
        this.J0 = true;
        g7 g7Var = this.W;
        if (g7Var != null) {
            g7Var.getRoot().setVisibility(8);
        }
    }

    public void onFontDownClick(View v2) {
        if (MiConfigSingleton.V3().v2()) {
            B7();
            Q6(0);
        }
        T6();
    }

    public void onFontUpClick(View v2) {
        if (MiConfigSingleton.V3().K4()) {
            B7();
            Q6(0);
        }
        T6();
    }

    public void onGlobalSlideClick(View view) {
        U6("全屏翻下页");
        MiConfigSingleton.V3().w7(this.d0.f11863f.isChecked());
    }

    @Override // com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 82 && this.j0 != null) {
            D7(this.k0);
            return true;
        }
        if (keyCode == 24 && MiConfigSingleton.V3().i2() && !O4()) {
            if (this.j0 != null) {
                this.J.q.f12206i.A(false);
            }
            return true;
        }
        if (keyCode == 25 && MiConfigSingleton.V3().i2() && !O4()) {
            if (this.j0 != null) {
                this.J.q.f12206i.z(false);
            }
            return true;
        }
        if (keyCode == 4) {
            if (this.J.f12502b.isDrawerOpen(8388611)) {
                this.J.f12502b.closeDrawer(8388611);
                return true;
            }
            if (this.j0 != null && N4()) {
                L7();
                return true;
            }
        } else if (keyCode == 79) {
            onTingshuActionClick(null);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if ((keyCode == 25 || keyCode == 24) && !O4() && MiConfigSingleton.V3().i2()) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    public void onLightAlwaysClick(View view) {
        com.martian.mibook.lib.model.g.b.W(this, "屏幕关闭-常亮");
        MiConfigSingleton.V3().f8(3600000L, true);
        U7(4);
    }

    public void onLightFiveMinutesClick(View view) {
        com.martian.mibook.lib.model.g.b.W(this, "屏幕关闭-5分钟");
        MiConfigSingleton.V3().f8(com.alipay.mobilesecuritysdk.constant.a.k, true);
        U7(2);
    }

    public void onLightSystemClick(View view) {
        h7();
        com.martian.mibook.lib.model.g.b.W(this, "屏幕关闭-系统");
        MiConfigSingleton.V3().f8(-1L, true);
        U7(0);
    }

    public void onLightTenMinutesClick(View view) {
        com.martian.mibook.lib.model.g.b.W(this, "屏幕关闭-10分钟");
        MiConfigSingleton.V3().f8(TTAdConstant.AD_MAX_EVENT_TIME, true);
        U7(3);
    }

    public void onLightTwoMinutesClick(View view) {
        com.martian.mibook.lib.model.g.b.W(this, "屏幕关闭-2分钟");
        MiConfigSingleton.V3().f8(120000L, true);
        U7(1);
    }

    public void onMenuClick(View view) {
        D7(true);
    }

    public void onMoreItemClick(View view) {
        if (this.j1 == null) {
            U6("查看更多");
            View inflate = getLayoutInflater().inflate(R.layout.reading_menu_bar, (ViewGroup) null);
            if (!MiConfigSingleton.V3().D8()) {
                View findViewById = inflate.findViewById(R.id.book_comment_view);
                View findViewById2 = inflate.findViewById(R.id.book_comment_view_divider);
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
            }
            PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
            this.j1 = popupWindow;
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            this.j1.setOutsideTouchable(true);
            this.j1.setFocusable(true);
        }
        this.j1.showAsDropDown(this.T.f12493c, 0, 0);
    }

    public void onMoreSettingCloseClick(View view) {
        BottomSheetBehavior<View> bottomSheetBehavior = this.o1;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.T(5);
        }
    }

    public void onMoreSettingsClick(View v2) {
        U6("更多设置");
        if (this.d0 == null) {
            this.J.p.setLayoutResource(R.layout.reading_more_setting);
            this.d0 = d6.a(this.J.p.inflate());
            if (ImmersionBar.hasNavigationBar(this)) {
                this.d0.f11859b.setVisibility(0);
                this.d0.f11860c.setVisibility(0);
                this.d0.f11859b.setChecked(MiConfigSingleton.V3().T1());
            } else {
                this.d0.f11859b.setVisibility(8);
                this.d0.f11860c.setVisibility(8);
            }
            this.d0.N.setChecked(MiConfigSingleton.V3().i2());
            this.d0.f11863f.setChecked(MiConfigSingleton.V3().s5());
            this.d0.F.setChecked(MiConfigSingleton.V3().Q5());
            if (MiConfigSingleton.V3().m4() != 4) {
                this.d0.F.setVisibility(8);
                this.d0.G.setVisibility(8);
            }
            this.d0.I.setChecked(MiConfigSingleton.V3().R5());
            if (MiConfigSingleton.V3().m4() != 2) {
                this.d0.I.setVisibility(8);
                this.d0.H.setVisibility(8);
            }
            this.d0.f11861d.setVisibility(MiConfigSingleton.V3().G5() ? 0 : 8);
            this.d0.f11862e.setVisibility(MiConfigSingleton.V3().G5() ? 0 : 8);
            this.d0.f11861d.setChecked(MiUserManager.s().A());
            this.d0.J.setChecked(MiConfigSingleton.V3().T0());
            this.d0.D.setChecked(MiConfigSingleton.V3().S1());
            if (MiConfigSingleton.V3().D8()) {
                this.d0.z.setChecked(MiConfigSingleton.V3().C8());
            } else {
                this.d0.z.setVisibility(8);
                this.d0.A.setVisibility(8);
            }
            this.d0.B.setChecked(!MiConfigSingleton.V3().M5());
            if (MiConfigSingleton.F5(this) || !MiConfigSingleton.V3().M5() || MiConfigSingleton.V3().J0()) {
                this.d0.B.setVisibility(0);
                this.d0.C.setVisibility(0);
            } else {
                this.d0.B.setVisibility(8);
                this.d0.C.setVisibility(8);
            }
            this.d0.E.setChecked(MiConfigSingleton.V3().F8());
            BottomSheetBehavior<View> s2 = BottomSheetBehavior.s(this.d0.y);
            this.o1 = s2;
            s2.T(5);
            this.o1.i(new z());
            this.d0.x.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.P5(view);
                }
            });
        }
        this.d0.getRoot().setVisibility(0);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.activity.reader.s
            @Override // java.lang.Runnable
            public final void run() {
                ReadingActivity.this.R5();
            }
        }, 100L);
        W7();
        U7(n4());
        e8();
    }

    public void onNetworkCheckClick(View view) {
        com.martian.mibook.lib.model.g.b.O(this, "无网络-点击");
        startActivity(new Intent("android.settings.SETTINGS"));
    }

    public void onNetworkOfflineClose(View view) {
        com.martian.mibook.lib.model.g.b.O(this, "无网络-关闭");
        this.T0 = true;
        this.S.getRoot().setVisibility(8);
    }

    @Override // com.martian.libmars.activity.j1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        q4(intent);
    }

    public void onNextChapterClick(View view) {
        U6("下一章");
        if (this.h0 == null) {
            k1("请等待数据加载完毕");
            return;
        }
        if (this.f0.getRecord().getChapterIndex() >= this.h0.getCount() - 1) {
            k1("已经是最后一章了哦");
        } else if (T4()) {
            TtsService.U(this, TtsService.f14103d);
        } else {
            z4(Integer.valueOf(this.f0.getRecord().getChapterIndex() + 1), 0, 0);
            T7();
        }
    }

    public void onNightModeClick(View view) {
        boolean z2 = !com.martian.libmars.d.h.F().P0();
        StringBuilder sb = new StringBuilder();
        sb.append("切换日夜间-");
        sb.append(z2 ? "夜间" : "日间");
        U6(sb.toString());
        com.martian.libmars.d.h.F().t1(z2);
        com.martian.libmars.d.h.F().F1();
        j8();
        this.i1 = !this.i1;
    }

    public void onNotificationCloseClick(View view) {
        U6("设置听书通知-关闭");
        p6 p6Var = this.M;
        if (p6Var != null) {
            p6Var.f12536d.setVisibility(8);
        }
    }

    public void onNotificationSettingClick(View view) {
        U6("设置听书通知");
        com.martian.libsupport.f.a(this);
    }

    public void onPageSettingClick(View v2) {
        U6("设置tab");
        A4();
        o7(this.K.getRoot(), true, com.martian.libmars.utils.h0.f10144a);
        o7(this.U.getRoot(), false, com.martian.libmars.utils.h0.f10144a);
        o7(this.T.getRoot(), false, com.martian.libmars.utils.h0.f10145b);
        r7(false);
        o7(this.J.x, false, com.martian.libmars.utils.h0.f10145b);
        a8();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        int i2;
        int i3;
        super.onPause();
        if (this.g0 != null && (i2 = this.U0) > (i3 = this.V0)) {
            if (this.p0) {
                U6("封面退出");
            } else {
                int i4 = i2 - i3;
                MiBookManager l3 = MiConfigSingleton.V3().l3();
                String sourceName = this.g0.getSourceName();
                String sourceId = this.g0.getSourceId();
                String recommendId = this.f0.getRecommendId();
                i4 i4Var = this.j0;
                l3.J1(6, sourceName, sourceId, recommendId, "", "", i4, i4Var == null ? 0 : i4Var.v0(), "", this.f0.getFirstRead());
                this.V0 = this.U0;
            }
        }
        a7();
        this.s0 = false;
        d7();
        this.D0.removeCallbacks(this.F0);
        this.M0.removeCallbacks(this.N0);
        M7();
        h7();
        Z6();
        if (N4()) {
            D7(true);
        }
        try {
            unregisterReceiver(this.C0);
        } catch (Exception unused) {
        }
    }

    public void onPrefShowMenuClick(View view) {
        boolean isChecked = this.d0.E.isChecked();
        StringBuilder sb = new StringBuilder();
        sb.append("菜单入口-");
        sb.append(isChecked ? "显示" : "隐藏");
        U6(sb.toString());
        MiConfigSingleton.V3().l8(isChecked);
        this.J.k.k.setVisibility(isChecked ? 0 : 8);
    }

    public void onPreviousChapterClick(View view) {
        U6("上一章");
        if (this.h0 == null) {
            k1("请等待数据加载完毕");
            return;
        }
        if (this.f0.getRecord().getChapterIndex() <= 0) {
            k1("已经是第一章了哦");
        } else if (T4()) {
            TtsService.U(this, TtsService.f14102c);
        } else {
            z4(Integer.valueOf(this.f0.getRecord().getChapterIndex() - 1), 0, 0);
            T7();
        }
    }

    public void onPreviousSeekClick(View view) {
        if (this.i0.size() > 0) {
            U6("章节进度条-后退");
            MiReadingRecord miReadingRecord = this.i0.get(0);
            this.U.p.setProgress(miReadingRecord.getChapterIndex());
            z4(Integer.valueOf(miReadingRecord.getChapterIndex()), miReadingRecord.getContentIndex(), miReadingRecord.getContentSize());
            this.i0.remove(0);
        } else {
            U6("章节进度条-后退-到底");
            k1("没有更多记录了");
        }
        T7();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        q6 q6Var = this.b0;
        if (q6Var == null || q6Var.getRoot().getVisibility() != 0) {
            return;
        }
        I4();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.s0 = true;
        registerReceiver(this.C0, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        f8();
        X3();
        J7();
        A7();
        Q7();
        if (N4()) {
            D7(false);
        }
        W3();
        com.martian.mibook.e.p pVar = this.J;
        if (pVar != null) {
            pVar.q.f12206i.setTouchable(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(C, GsonUtils.b().toJson(this.f0));
    }

    public void onScrollSlideClick(View view) {
        U6("上下-点击屏幕翻页");
        MiConfigSingleton.V3().o8(this.d0.I.isChecked());
    }

    public void onSlideModeSettingClick(View view) {
        U6("翻页设置");
        G7();
    }

    public void onSliderCacheClick(View view) {
        boolean isChecked = this.d0.F.isChecked();
        StringBuilder sb = new StringBuilder();
        sb.append("翻页优化-");
        sb.append(isChecked ? "开" : "关");
        U6(sb.toString());
        MiConfigSingleton.V3().n8(isChecked);
        S7();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    public void onStartTtsClick(View v2) {
        U6("听书");
        if (this.j0 == null || this.h0 == null) {
            k1("请等待数据加载完毕");
            return;
        }
        if (com.martian.libmars.d.h.F().J0()) {
            P7();
            return;
        }
        if (MiConfigSingleton.V3().h6() || MiConfigSingleton.V3().z0("function_tingshu") <= 3 || !MiConfigSingleton.V3().A8()) {
            P7();
            return;
        }
        this.j0.H2(i4.n, AdConfig.ActionString.SHOW);
        String string = getString(R.string.tingshu);
        String string2 = getString(R.string.ting_shu_video);
        String string3 = getString(R.string.vip_for_tts);
        Book book = this.g0;
        String sourceName = book == null ? "" : book.getSourceName();
        Book book2 = this.g0;
        v2.Q0(this, string, string2, string3, "听书-vip", sourceName, book2 == null ? "" : book2.getSourceId(), new t());
    }

    public void onStopAutoSlidingClick(View v2) {
        if (!this.o0.h() || this.j0 == null) {
            return;
        }
        g8();
        k1("已退出自动阅读模式");
        p5 p5Var = this.N;
        if (p5Var != null) {
            n7(p5Var.getRoot(), false);
        }
        A7();
        c7(-100L);
    }

    public void onSwitchBookClick(View view) {
        K3(true);
    }

    public void onSystemBrightnessClick(View view) {
        b8(!MiConfigSingleton.V3().S5());
    }

    public void onTextLooseSpaceClick(View v2) {
        d8("行距宽", I);
    }

    public void onTextNormalSpaceClick(View v2) {
        d8("行距正常", H);
    }

    public void onTextTightSpaceClick(View v2) {
        d8("行距紧", G);
    }

    public void onTingshuActionClick(View view) {
        U6("听书暂停/开始");
        TtsService.U(this, TtsService.f14101b);
    }

    public void onTtsBookClick(View view) {
        MiReadingRecord W;
        String d2 = MiConfigSingleton.V3().H4.d();
        if (com.martian.libsupport.k.p(d2) || (W = MiConfigSingleton.V3().l3().W(d2)) == null) {
            return;
        }
        s2.j0(this, W);
    }

    public void onTtsBreakClick(View view) {
        startActivity(TtsOptimizeActivity.class);
    }

    public void onTtsClockSettingClick(View view) {
        U6("听书定时");
        y7();
    }

    public void onTtsPositionBackClick(View view) {
        TtsService.U(this, TtsService.m);
    }

    public void onTtsReadClick(View view) {
        i4 i4Var = this.j0;
        if (i4Var == null || i4Var.A0() == null) {
            return;
        }
        TtsService.W(this, TtsService.f14109j, this.j0.v0(), this.j0.x0(), this.j0.A0().getEndPosSize(), true);
        e0(true);
    }

    public void onTtsSettingClick(View view) {
        U6("听书设置");
        TtsService.U(this, TtsService.f14107h);
    }

    public void onTtsSpeedDownClick(View view) {
        m7(-10);
    }

    public void onTtsSpeedUpClick(View view) {
        m7(10);
    }

    public void onTypefaceChangeClick(View v2) {
        if (this.b0 == null) {
            this.J.u.setLayoutResource(R.layout.reading_typeface);
            q6 a2 = q6.a(this.J.u.inflate());
            this.b0 = a2;
            a2.f12580e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.T5(view);
                }
            });
            this.b0.f12581f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.V5(view);
                }
            });
        }
        I4();
        n7(this.b0.getRoot(), true);
        U6("字体");
    }

    public void onUpdateNotificationClick(View view) {
        U6("追更推送");
        com.martian.libsupport.f.a(this);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        X3();
    }

    public void onVipMemberClick(View v2) {
        Book book = this.g0;
        String sourceName = book == null ? "" : book.getSourceName();
        Book book2 = this.g0;
        s2.q0(this, "阅读页-顶部", true, sourceName, book2 != null ? book2.getSourceId() : "");
    }

    public void onVolumeSettingClick(View view) {
        U6("音量键翻页");
        MiConfigSingleton.V3().v8(this.d0.N.isChecked());
    }

    public void onWblAdClick(View view) {
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.l3(1, "菜单");
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        a8();
    }

    public void orientationClick(View view) {
        U6("切换横竖屏");
        MiConfigSingleton.V3().K6();
        s2.E(this);
    }

    public boolean q7() {
        i4 i4Var = this.j0;
        return i4Var == null ? this.f0.shouldHideAd() || !this.f0.isAdBook() : i4Var.a3();
    }

    @Override // com.martian.libsliding.f.a
    public void r(Point point) {
        if (this.j0.N0() || !this.j0.o() || O4()) {
            D7(this.k0);
            return;
        }
        if (!this.k0) {
            D7(false);
            return;
        }
        if (a4(point.x, point.y)) {
            if (this.f0.isFirstMenu()) {
                com.martian.mibook.lib.model.g.b.H(this, "显示菜单");
                this.f0.setFirstMenu(false);
            }
            if (MiConfigSingleton.V3().q(ReadingInfo.COUNTER_MENU) < 5) {
                MiConfigSingleton.V3().B0(ReadingInfo.COUNTER_MENU);
            }
            com.martian.mibook.lib.model.g.b.U(this, "展示");
            D7(true);
            return;
        }
        if (MiConfigSingleton.V3().s5()) {
            this.J.q.f12206i.z(true);
            return;
        }
        if ((this.l0 || point.x <= B0() / 2) && (!this.l0 || point.y <= (z0() * 2) / 3)) {
            this.J.q.f12206i.A(true);
            return;
        }
        this.J.q.f12206i.z(true);
        if (this.f0.isFirstTap()) {
            this.f0.setFirstTap(false);
            com.martian.mibook.lib.model.g.b.H(this, "点击翻页");
        }
    }

    @Override // com.martian.mibook.application.n0.b
    public void s(Book book) {
        this.U.t.setText("");
        this.U.s.setText("缓存完成: ");
        this.K0 = CacheStatus.Finished;
    }

    public void showBonusFloatClick(View view) {
        boolean isChecked = this.d0.D.isChecked();
        StringBuilder sb = new StringBuilder();
        sb.append("计时悬浮-");
        sb.append(isChecked ? "显示" : "隐藏");
        U6(sb.toString());
        MiConfigSingleton.V3().V6(isChecked);
        A7();
    }

    public void showCloseAdsDialog(View view) {
        if (this.j0 != null) {
            if (MiConfigSingleton.V3().u5()) {
                this.J.q.f12206i.z(false);
                return;
            }
            Book book = this.g0;
            String sourceName = book == null ? "" : book.getSourceName();
            Book book2 = this.g0;
            s2.q0(this, "阅读页-关闭广告-vip-点击", true, sourceName, book2 != null ? book2.getSourceId() : "");
        }
    }

    public void showRewardVideoAd(View view) {
        com.martian.mibook.lib.model.g.b.V(this, "广告-看视频免广告-点击");
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.j3();
        }
    }

    public void startAutoSlideClick(View v2) {
        if (MiConfigSingleton.V3().h6() || MiConfigSingleton.V3().z0("function_auto_read") <= 3 || !MiConfigSingleton.V3().z8() || MiConfigSingleton.V3().J0()) {
            H7();
            return;
        }
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.H2(i4.s, AdConfig.ActionString.SHOW);
        }
        String string = getString(R.string.auto_sliding);
        String string2 = getString(R.string.auto_read_video);
        String string3 = getString(R.string.vip_for_auto_read);
        Book book = this.g0;
        String sourceName = book == null ? "" : book.getSourceName();
        Book book2 = this.g0;
        v2.Q0(this, string, string2, string3, "自动阅读-vip", sourceName, book2 == null ? "" : book2.getSourceId(), new r());
    }

    public void traditionalChineseClick(View view) {
        boolean isChecked = this.d0.J.isChecked();
        StringBuilder sb = new StringBuilder();
        sb.append("字体-");
        sb.append(isChecked ? "繁体" : "简体");
        U6(sb.toString());
        MiConfigSingleton.V3().A1(isChecked);
        i4 i4Var = this.j0;
        if (i4Var != null) {
            i4Var.L2();
        }
    }

    public void u7(final AppTaskList appTaskList, final int intervalExtra) {
        runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.reader.h1
            @Override // java.lang.Runnable
            public final void run() {
                ReadingActivity.this.c6(appTaskList, intervalExtra);
            }
        });
    }

    public void y7() {
        if (this.O == null) {
            this.J.s.setLayoutResource(R.layout.reading_timing);
            n6 a2 = n6.a(this.J.s.inflate());
            this.O = a2;
            a2.f12442b.setDividerHeight(0);
            o4 o4Var = new o4(this, 0);
            this.b1 = o4Var;
            this.O.f12442b.setAdapter((ListAdapter) o4Var);
            this.O.f12442b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.activity.reader.n
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    ReadingActivity.this.i6(adapterView, view, i2, j2);
                }
            });
            this.O.f12443c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.reader.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingActivity.this.k6(view);
                }
            });
        } else if (this.M.f12541i.m()) {
            this.b1.b(0);
        }
        o7(this.O.getRoot(), true, com.martian.libmars.utils.h0.f10144a);
    }
}
