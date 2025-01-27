package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libsliding.SlidingLayout;
import com.martian.mibook.R;
import com.martian.mibook.application.EventManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReaderTypefaceManager;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.application.RewardVideoAdManager;
import com.martian.mibook.application.d;
import com.martian.mibook.data.RecordReadType;
import com.martian.mibook.data.TypoItem;
import com.martian.mibook.data.book.CommentCount;
import com.martian.mibook.data.book.MiReadingContent;
import com.martian.mibook.data.book.ReadingInfo;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.LoadingBookActiveBinding;
import com.martian.mibook.databinding.LoadingFailureBinding;
import com.martian.mibook.databinding.LoadingPurchaseBinding;
import com.martian.mibook.databinding.ReaderSlideBookCoverLayoutBinding;
import com.martian.mibook.databinding.ReaderSlideBookLastPageLayoutBinding;
import com.martian.mibook.databinding.ReadingAdsLayoutBinding;
import com.martian.mibook.databinding.ReadingBottomStatusBinding;
import com.martian.mibook.databinding.ReadingChapterCommentBinding;
import com.martian.mibook.databinding.ReadingContentLayoutBinding;
import com.martian.mibook.databinding.ReadingLayoutBinding;
import com.martian.mibook.databinding.ReadingLinkAdBinding;
import com.martian.mibook.fragment.dialog.TypoFeedbackFragment;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.MiChapter;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReaderBookCoverLayout;
import com.martian.mibook.mvvm.read.widget.ReaderBookLastPageLayout;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.mibook.ui.reader.page.ActionMenu;
import com.martian.mibook.ui.reader.page.ReaderPageView;
import com.martian.rpauth.response.MartianRPAccount;
import ge.b;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CancellationException;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import l9.i0;
import l9.m0;
import l9.o0;
import l9.t0;
import lb.c;
import xb.e;
import xi.k;
import xi.l;
import ya.e2;

@SourceDebugExtension({"SMAP\nReaderSlidingAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReaderSlidingAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/ReaderSlidingAdapter\n+ 2 ArraySet.kt\nandroidx/collection/ArraySetKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2363:1\n22#2:2364\n1#3:2365\n262#4,2:2366\n262#4,2:2368\n262#4,2:2370\n262#4,2:2372\n1855#5,2:2374\n1855#5,2:2376\n*S KotlinDebug\n*F\n+ 1 ReaderSlidingAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/ReaderSlidingAdapter\n*L\n131#1:2364\n1664#1:2366,2\n1666#1:2368,2\n1768#1:2370,2\n1770#1:2372,2\n1977#1:2374,2\n1988#1:2376,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ReaderSlidingAdapter extends z9.d<MiReadingContent.MiCursor> {

    @k
    public static final a E = new a(null);
    public static final int F = -1;
    public static final int G = -2;
    public long A;

    @k
    public final BroadcastReceiver B;
    public boolean C;
    public boolean D;

    /* renamed from: d */
    @k
    public final FragmentActivity f14481d;

    /* renamed from: e */
    @k
    public final Lazy f14482e;

    /* renamed from: f */
    @k
    public final Lazy f14483f;

    /* renamed from: g */
    @k
    public MiReadingContent f14484g;

    /* renamed from: h */
    @k
    public MiReadingContent f14485h;

    /* renamed from: i */
    @k
    public MiReadingContent f14486i;

    /* renamed from: j */
    public boolean f14487j;

    /* renamed from: k */
    public int f14488k;

    /* renamed from: l */
    public int f14489l;

    /* renamed from: m */
    @l
    public ge.b f14490m;

    /* renamed from: n */
    @k
    public ArraySet<a.C0533a> f14491n;

    /* renamed from: o */
    @l
    public e2 f14492o;

    /* renamed from: p */
    @l
    public Drawable f14493p;

    /* renamed from: q */
    @l
    public String f14494q;

    /* renamed from: r */
    @l
    public MiReadingContent.MiCursor f14495r;

    /* renamed from: s */
    @l
    public Job f14496s;

    /* renamed from: t */
    @k
    public final SimpleDateFormat f14497t;

    /* renamed from: u */
    public int f14498u;

    /* renamed from: v */
    public int f14499v;

    /* renamed from: w */
    public long f14500w;

    /* renamed from: x */
    public boolean f14501x;

    /* renamed from: y */
    public boolean f14502y;

    /* renamed from: z */
    public boolean f14503z;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/martian/mibook/mvvm/read/adapter/ReaderSlidingAdapter$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$1 */
    public static final class AnonymousClass1 implements LifecycleEventObserver {

        /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$1$a */
        public /* synthetic */ class a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f14505a;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f14505a = iArr;
            }
        }

        public AnonymousClass1() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@k LifecycleOwner source, @k Lifecycle.Event r52) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(r52, "event");
            int i10 = a.f14505a[r52.ordinal()];
            if (i10 == 1) {
                if (!ReaderSlidingAdapter.this.C) {
                    ReaderSlidingAdapter.this.getActivity().registerReceiver(ReaderSlidingAdapter.this.B, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    ReaderSlidingAdapter.this.C = true;
                }
                ReaderSlidingAdapter.this.w2();
                com.martian.mibook.application.d Z0 = ReaderSlidingAdapter.this.Z0();
                if (Z0 != null) {
                    Z0.k0();
                    return;
                }
                return;
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                ReaderSlidingAdapter.this.B1();
            } else {
                if (ReaderSlidingAdapter.this.C) {
                    ReaderSlidingAdapter.this.getActivity().unregisterReceiver(ReaderSlidingAdapter.this.B);
                    ReaderSlidingAdapter.this.C = false;
                }
                ReaderSlidingAdapter.this.x2();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/martian/mibook/data/book/ReadingInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$2 */
    public static final class AnonymousClass2 extends Lambda implements Function1<ReadingInfo, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReadingInfo readingInfo) {
            invoke2(readingInfo);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(@l ReadingInfo readingInfo) {
            ReaderSlidingAdapter.this.f14502y = false;
            ReaderSlidingAdapter.this.u();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$3 */
    public static final class AnonymousClass3 extends Lambda implements Function1<ErrorResult, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ErrorResult errorResult) {
            invoke2(errorResult);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(@l ErrorResult errorResult) {
            ReaderSlidingAdapter.this.f14502y = false;
        }
    }

    public static final class a {

        /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$a$a */
        public static final class C0533a {

            /* renamed from: a */
            @l
            public ReadingLayoutBinding f14506a;

            /* renamed from: b */
            @l
            public ReadingAdsLayoutBinding f14507b;

            /* renamed from: c */
            @l
            public ReadingLinkAdBinding f14508c;

            /* renamed from: d */
            @l
            public ReaderSlideBookCoverLayoutBinding f14509d;

            /* renamed from: e */
            @l
            public ReaderSlideBookLastPageLayoutBinding f14510e;

            /* renamed from: f */
            @l
            public LoadingBookActiveBinding f14511f;

            /* renamed from: g */
            @l
            public LoadingPurchaseBinding f14512g;

            /* renamed from: h */
            @l
            public LoadingFailureBinding f14513h;

            /* renamed from: i */
            @l
            public ReadingChapterCommentBinding f14514i;

            @l
            public final ReadingAdsLayoutBinding a() {
                return this.f14507b;
            }

            @l
            public final ReadingLayoutBinding b() {
                return this.f14506a;
            }

            @l
            public final LoadingBookActiveBinding c() {
                return this.f14511f;
            }

            @l
            public final ReaderSlideBookCoverLayoutBinding d() {
                return this.f14509d;
            }

            @l
            public final ReadingChapterCommentBinding e() {
                return this.f14514i;
            }

            @l
            public final LoadingFailureBinding f() {
                return this.f14513h;
            }

            @l
            public final ReaderSlideBookLastPageLayoutBinding g() {
                return this.f14510e;
            }

            @l
            public final ReadingLinkAdBinding h() {
                return this.f14508c;
            }

            @l
            public final LoadingPurchaseBinding i() {
                return this.f14512g;
            }

            public final void j(@l ReadingAdsLayoutBinding readingAdsLayoutBinding) {
                this.f14507b = readingAdsLayoutBinding;
            }

            public final void k(@l ReadingLayoutBinding readingLayoutBinding) {
                this.f14506a = readingLayoutBinding;
            }

            public final void l(@l LoadingBookActiveBinding loadingBookActiveBinding) {
                this.f14511f = loadingBookActiveBinding;
            }

            public final void m(@l ReaderSlideBookCoverLayoutBinding readerSlideBookCoverLayoutBinding) {
                this.f14509d = readerSlideBookCoverLayoutBinding;
            }

            public final void n(@l ReadingChapterCommentBinding readingChapterCommentBinding) {
                this.f14514i = readingChapterCommentBinding;
            }

            public final void o(@l LoadingFailureBinding loadingFailureBinding) {
                this.f14513h = loadingFailureBinding;
            }

            public final void p(@l ReaderSlideBookLastPageLayoutBinding readerSlideBookLastPageLayoutBinding) {
                this.f14510e = readerSlideBookLastPageLayoutBinding;
            }

            public final void q(@l ReadingLinkAdBinding readingLinkAdBinding) {
                this.f14508c = readingLinkAdBinding;
            }

            public final void r(@l LoadingPurchaseBinding loadingPurchaseBinding) {
                this.f14512g = loadingPurchaseBinding;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements xb.c {

        /* renamed from: a */
        public final /* synthetic */ MiReadingContent f14515a;

        /* renamed from: b */
        public final /* synthetic */ ReaderSlidingAdapter f14516b;

        public static final class a implements c.i {

            /* renamed from: a */
            public final /* synthetic */ ReaderSlidingAdapter f14517a;

            public a(ReaderSlidingAdapter readerSlidingAdapter) {
                this.f14517a = readerSlidingAdapter;
            }

            @Override // lb.c.i
            public void a(@k x8.c errorResult) {
                Intrinsics.checkNotNullParameter(errorResult, "errorResult");
                this.f14517a.u();
            }

            @Override // lb.c.i
            public void b(@k MartianRPAccount rpAccount) {
                Intrinsics.checkNotNullParameter(rpAccount, "rpAccount");
                this.f14517a.u();
            }
        }

        public b(MiReadingContent miReadingContent, ReaderSlidingAdapter readerSlidingAdapter) {
            this.f14515a = miReadingContent;
            this.f14516b = readerSlidingAdapter;
        }

        @Override // xb.c
        public void a() {
            this.f14516b.J1(this.f14515a);
            this.f14516b.u();
            ac.a.L(this.f14516b.getActivity(), "充值书币");
            i.X(this.f14516b.getActivity());
        }

        @Override // xb.c
        public void b(int i10, int i11) {
            lb.c.v(-i11);
            MiReadingContent miReadingContent = this.f14515a;
            if (miReadingContent != null) {
                miReadingContent.setStartFromFirstPage(true);
            }
            this.f14516b.q1(this.f14515a);
            if (i10 > 1) {
                ReaderSlidingAdapter readerSlidingAdapter = this.f14516b;
                readerSlidingAdapter.A2(readerSlidingAdapter.f14486i);
            }
            EventManager V1 = MiConfigSingleton.b2().V1();
            String sourceName = this.f14516b.T0().getSourceName();
            String sourceId = this.f14516b.T0().getSourceId();
            String recommendId = this.f14516b.T0().getRecommendId();
            String recommend = this.f14516b.T0().getRecommend();
            MiReadingContent miReadingContent2 = this.f14515a;
            V1.h(7, sourceName, sourceId, recommendId, recommend, "章节购买", i11, miReadingContent2 != null ? miReadingContent2.getChapterIndex() : 0, "", false);
        }

        @Override // xb.c
        public void c() {
        }

        @Override // xb.c
        public void d(@k String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (this.f14515a == this.f14516b.f14485h && !ba.l.q(errMsg)) {
                t0.b(this.f14516b.getActivity(), errMsg);
            }
            this.f14516b.J1(this.f14515a);
            this.f14516b.u();
        }

        @Override // xb.c
        public void e(int i10) {
            gd.a a12;
            if (i10 != 0 || (a12 = this.f14516b.a1()) == null) {
                return;
            }
            a12.J0(RewardVideoAdManager.VideoType.UNLOCK_CHAPTER);
        }

        @Override // xb.c
        public void f() {
            this.f14516b.J1(this.f14515a);
            MiConfigSingleton.b2().G1().C(this.f14516b.getActivity(), true, new a(this.f14516b));
        }
    }

    public static final class c implements ActionMenu.a {

        public /* synthetic */ class a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f14519a;

            static {
                int[] iArr = new int[ActionMenu.ActionType.values().length];
                try {
                    iArr[ActionMenu.ActionType.COMMENT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ActionMenu.ActionType.TTS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ActionMenu.ActionType.COPY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ActionMenu.ActionType.UNDERLINE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ActionMenu.ActionType.DEL_UNDERLINE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ActionMenu.ActionType.TYPO_FEEDBACK.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f14519a = iArr;
            }
        }

        public c() {
        }

        @Override // com.martian.mibook.ui.reader.page.ActionMenu.a
        public void a(@l ReaderPageView readerPageView) {
            gd.a a12 = ReaderSlidingAdapter.this.a1();
            if (a12 != null) {
                a12.h0(false);
            }
        }

        @Override // com.martian.mibook.ui.reader.page.ActionMenu.a
        public void b(@l ReaderPageView readerPageView, @l ActionMenu.ActionType actionType, @l ActionMenu.b bVar, @l ActionMenu.b bVar2, int i10, int i11) {
            Object tag = readerPageView != null ? readerPageView.getTag() : null;
            MiReadingContent.MiContentCursor miContentCursor = tag instanceof MiReadingContent.MiContentCursor ? (MiReadingContent.MiContentCursor) tag : null;
            if (miContentCursor == null) {
            }
            switch (actionType == null ? -1 : a.f14519a[actionType.ordinal()]) {
                case 1:
                    StringBuilder sb2 = new StringBuilder();
                    if (bVar != null) {
                        sb2.append(bVar.c());
                    }
                    if (bVar2 != null) {
                        sb2.append(bVar2.c());
                    }
                    int paragraphForTextEnd = miContentCursor.getContent().getParagraphForTextEnd(i11);
                    String paragraphText = miContentCursor.getContent().getParagraphText(paragraphForTextEnd);
                    e2 O0 = ReaderSlidingAdapter.this.O0();
                    if (O0 != null) {
                        O0.s(miContentCursor.getContent(), Integer.valueOf(paragraphForTextEnd), sb2.toString(), paragraphText, true);
                        break;
                    }
                    break;
                case 2:
                    int b10 = bVar2 != null ? bVar2.b() : 0;
                    gd.a a12 = ReaderSlidingAdapter.this.a1();
                    if (a12 != null) {
                        a12.Q0(ReaderSlidingAdapter.this.T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String(), b10);
                        break;
                    }
                    break;
                case 3:
                    Object systemService = ReaderSlidingAdapter.this.getActivity().getSystemService("clipboard");
                    ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
                    StringBuilder sb3 = new StringBuilder();
                    if (bVar != null) {
                        sb3.append(bVar.c());
                    }
                    if (bVar2 != null) {
                        sb3.append(bVar2.c());
                    }
                    ClipData newPlainText = ClipData.newPlainText("content", sb3.toString());
                    if (clipboardManager != null) {
                        clipboardManager.setPrimaryClip(newPlainText);
                    }
                    t0.b(ReaderSlidingAdapter.this.getActivity(), "复制成功");
                    break;
                case 4:
                    miContentCursor.getContent().addBookUnderline(bVar, bVar2, i10, i11);
                    readerPageView.f(i10, i11);
                    break;
                case 5:
                    miContentCursor.getContent().removeBookUnderline(i10, i11);
                    readerPageView.J(i10, i11);
                    break;
                case 6:
                    StringBuilder sb4 = new StringBuilder();
                    if (bVar != null) {
                        sb4.append(bVar.c());
                    }
                    if (bVar2 != null) {
                        sb4.append(bVar2.c());
                    }
                    if (!TextUtils.isEmpty(sb4)) {
                        if (sb4.length() <= 5) {
                            TypoItem typoItem = new TypoItem();
                            typoItem.setCid(ReaderSlidingAdapter.this.M0(null));
                            typoItem.setpIdx(Integer.valueOf(miContentCursor.getContent().getParagraphForTextEnd(i11)));
                            typoItem.setStart(Integer.valueOf(i10));
                            typoItem.setEnd(Integer.valueOf(i11));
                            typoItem.setTypo(sb4.toString());
                            TypoFeedbackFragment.K(ReaderSlidingAdapter.this.getActivity(), typoItem);
                            break;
                        } else {
                            t0.b(ReaderSlidingAdapter.this.getActivity(), ExtKt.c("最多选中5个字进行反馈"));
                            break;
                        }
                    } else {
                        t0.b(ReaderSlidingAdapter.this.getActivity(), ExtKt.c("至少选中一个字"));
                        break;
                    }
            }
        }
    }

    public static final class d implements e {

        /* renamed from: b */
        public final /* synthetic */ MiReadingContent f14521b;

        public d(MiReadingContent miReadingContent) {
            this.f14521b = miReadingContent;
        }

        @Override // xb.e
        public void a(@l Chapter chapter, @l String str) {
            if (m0.c(ReaderSlidingAdapter.this.getActivity())) {
                return;
            }
            this.f14521b.setChapter(chapter);
            if (!TextUtils.isEmpty(str)) {
                this.f14521b.setShortContent(str);
            }
            this.f14521b.setUnBounght();
            if (this.f14521b == ReaderSlidingAdapter.this.f14485h || this.f14521b == ReaderSlidingAdapter.this.f14486i) {
                ReaderSlidingAdapter.this.C2(this.f14521b);
            }
            ReaderSlidingAdapter.this.u();
        }

        @Override // xb.e
        public void b(@l ChapterContent chapterContent) {
        }

        @Override // xb.e
        public void c(@l ChapterContent chapterContent) {
            if (m0.c(ReaderSlidingAdapter.this.getActivity())) {
                return;
            }
            if (chapterContent != null) {
                this.f14521b.setTitle(chapterContent.getTitle());
            }
            this.f14521b.setChapterContent(chapterContent);
            ReaderSlidingAdapter.this.y2(this.f14521b);
        }

        @Override // xb.e
        public void onLoading(boolean z10) {
            if (z10) {
                this.f14521b.setLoading();
            }
        }

        @Override // xb.e
        public void onResultError(@l x8.c cVar) {
            if (m0.c(ReaderSlidingAdapter.this.getActivity())) {
                return;
            }
            this.f14521b.setError();
            MiReadingContent miReadingContent = this.f14521b;
            Intrinsics.checkNotNull(cVar);
            miReadingContent.setErrCode(Integer.valueOf(cVar.c()));
            this.f14521b.setErrMsg(cVar.d());
            this.f14521b.setStackTrace(cVar.e());
            ReaderSlidingAdapter.this.u();
        }
    }

    public ReaderSlidingAdapter(@k FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f14481d = activity;
        this.f14482e = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$mViewModel$2
            public ReaderSlidingAdapter$mViewModel$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final ReadingViewModel invoke() {
                return (ReadingViewModel) new ViewModelProvider(ReaderSlidingAdapter.this.getActivity()).get(ReadingViewModel.class);
            }
        });
        this.f14483f = LazyKt.lazy(new ReaderSlidingAdapter$readerAdManager$2(this));
        this.f14484g = new MiReadingContent(T0().getBook());
        this.f14485h = new MiReadingContent(T0().getBook());
        this.f14486i = new MiReadingContent(T0().getBook());
        this.f14489l = -1;
        this.f14491n = new ArraySet<>();
        this.f14497t = new SimpleDateFormat("HH:mm", Locale.getDefault());
        this.f14498u = 50;
        this.f14499v = 1;
        this.A = System.currentTimeMillis();
        this.B = new BroadcastReceiver() { // from class: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$mBatInfoReceiver$1
            public ReaderSlidingAdapter$mBatInfoReceiver$1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@k Context arg0, @k Intent intent) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
                Intrinsics.checkNotNullParameter(intent, "intent");
                int intExtra = intent.getIntExtra("level", -1);
                int intExtra2 = intent.getIntExtra("scale", -1);
                int intExtra3 = intent.getIntExtra("status", 1);
                ReaderSlidingAdapter.this.f14498u = intExtra2 > 0 ? (intExtra * 100) / intExtra2 : 50;
                ReaderSlidingAdapter.this.f14499v = intExtra3;
                ReaderSlidingAdapter.I1(ReaderSlidingAdapter.this, null, 1, null);
            }
        };
        activity.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.1

            /* renamed from: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$1$a */
            public /* synthetic */ class a {

                /* renamed from: a */
                public static final /* synthetic */ int[] f14505a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f14505a = iArr;
                }
            }

            public AnonymousClass1() {
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@k LifecycleOwner source, @k Lifecycle.Event r52) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(r52, "event");
                int i10 = a.f14505a[r52.ordinal()];
                if (i10 == 1) {
                    if (!ReaderSlidingAdapter.this.C) {
                        ReaderSlidingAdapter.this.getActivity().registerReceiver(ReaderSlidingAdapter.this.B, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                        ReaderSlidingAdapter.this.C = true;
                    }
                    ReaderSlidingAdapter.this.w2();
                    com.martian.mibook.application.d Z0 = ReaderSlidingAdapter.this.Z0();
                    if (Z0 != null) {
                        Z0.k0();
                        return;
                    }
                    return;
                }
                if (i10 != 2) {
                    if (i10 != 3) {
                        return;
                    }
                    ReaderSlidingAdapter.this.B1();
                } else {
                    if (ReaderSlidingAdapter.this.C) {
                        ReaderSlidingAdapter.this.getActivity().unregisterReceiver(ReaderSlidingAdapter.this.B);
                        ReaderSlidingAdapter.this.C = false;
                    }
                    ReaderSlidingAdapter.this.x2();
                }
            }
        });
        T0().Y0().observe(activity, new Observer() { // from class: cd.r0
            public /* synthetic */ r0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderSlidingAdapter.e0(Function1.this, obj);
            }
        });
        T0().X0().observe(activity, new Observer() { // from class: cd.c1
            public /* synthetic */ c1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderSlidingAdapter.f0(Function1.this, obj);
            }
        });
    }

    public static /* synthetic */ void H2(ReaderSlidingAdapter readerSlidingAdapter, a.C0533a c0533a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c0533a = null;
        }
        readerSlidingAdapter.G2(c0533a);
    }

    public static /* synthetic */ void I1(ReaderSlidingAdapter readerSlidingAdapter, a.C0533a c0533a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c0533a = null;
        }
        readerSlidingAdapter.H1(c0533a);
    }

    public static /* synthetic */ void J0(ReaderSlidingAdapter readerSlidingAdapter, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        readerSlidingAdapter.I0(z10);
    }

    public static final void K0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void P2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Q1(ReaderSlidingAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gd.a a12 = this$0.a1();
        if (a12 != null) {
            a12.I();
        }
    }

    public static final void Q2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void R1(ReaderSlidingAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gd.a a12 = this$0.a1();
        if (a12 != null) {
            a12.q();
        }
    }

    public static final void T1(ReaderSlidingAdapter this$0, View view) {
        gd.a a12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!MiConfigSingleton.b2().G1().g(this$0.f14481d, 1019) || (a12 = this$0.a1()) == null) {
            return;
        }
        a12.J0(RewardVideoAdManager.VideoType.BOOK_ACTIVATE);
    }

    public static final void U1(ReaderSlidingAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t2("解锁章节");
    }

    public static final void Y1(ReaderSlidingAdapter this$0, View view) {
        gd.a a12;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!MiConfigSingleton.b2().G1().g(this$0.f14481d, 1019) || (a12 = this$0.a1()) == null) {
            return;
        }
        a12.J0(RewardVideoAdManager.VideoType.UNLOCK_CHAPTER);
    }

    public static final void Z1(MiReadingContent miReadingContent, ReaderSlidingAdapter this$0, MartianRPAccount martianRPAccount, boolean z10, View view) {
        int intValue;
        int intValue2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().g(this$0.f14481d, 1020)) {
            boolean z11 = true;
            miReadingContent.setStartFromFirstPage(true);
            Unit unit = null;
            if (martianRPAccount != null) {
                Book book = this$0.T0().getBook();
                YWBook yWBook = book instanceof YWBook ? (YWBook) book : null;
                Integer totalPrice = yWBook != null ? yWBook.getTotalPrice() : null;
                if (totalPrice == null) {
                    intValue = 0;
                } else {
                    Intrinsics.checkNotNull(totalPrice);
                    intValue = totalPrice.intValue();
                }
                Chapter chapter = miReadingContent.getChapter();
                Integer price = chapter != null ? chapter.getPrice() : null;
                if (price == null) {
                    intValue2 = 0;
                } else {
                    Intrinsics.checkNotNull(price);
                    intValue2 = price.intValue();
                }
                if ((!z10 || intValue <= martianRPAccount.getBookCoins()) && intValue2 <= martianRPAccount.getBookCoins()) {
                    z11 = false;
                }
                if (miReadingContent.isBuying()) {
                    t0.b(this$0.f14481d, "购买中，请稍候");
                    unit = Unit.INSTANCE;
                } else if (z11) {
                    Book book2 = this$0.T0().getBook();
                    if (book2 != null) {
                        ac.a.L(this$0.f14481d, "充值书币");
                        i.W(this$0.f14481d, book2, miReadingContent.getChapter());
                        unit = Unit.INSTANCE;
                    }
                } else {
                    this$0.y0(miReadingContent, miReadingContent.getChapter(), false);
                    unit = Unit.INSTANCE;
                }
            }
            if (unit == null) {
                t0.b(this$0.f14481d, "获取信息失败");
            }
        }
    }

    public static final void a2(ReaderSlidingAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().g(this$0.f14481d, 1019)) {
            J0(this$0, false, 1, null);
        }
    }

    public static final void b2(LoadingPurchaseBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        MiUserManager q10 = MiUserManager.q();
        q10.y(!q10.v());
        this_apply.tvBuyAuto.setImageResource(q10.v() ? R.drawable.btn_check_on_default_holo : R.drawable.btn_check_off_default);
    }

    public static final void c2(ReaderSlidingAdapter this$0, Chapter chapter, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t2("会员解锁-" + chapter.getChargeType());
    }

    public static final void d2(ReaderSlidingAdapter this$0, Integer num, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().g(this$0.f14481d, 1019)) {
            if (num != null && num.intValue() == 4) {
                J0(this$0, false, 1, null);
                return;
            }
            gd.a a12 = this$0.a1();
            if (a12 != null) {
                a12.J0(RewardVideoAdManager.VideoType.UNLOCK_CHAPTER);
            }
        }
    }

    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void e1(a.C0533a c0533a, ReaderSlidingAdapter this$0, View view) {
        gd.a a12;
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ReaderThemeTextView readerThemeTextView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().C2()) {
            return;
        }
        ReadingLayoutBinding b10 = c0533a.b();
        Object tag = (b10 == null || (readingBottomStatusBinding = b10.lyReadingBottomStatus) == null || (readerThemeTextView = readingBottomStatusBinding.rbsTvHint) == null) ? null : readerThemeTextView.getTag();
        MiReadingContent.MiContentCursor miContentCursor = tag instanceof MiReadingContent.MiContentCursor ? (MiReadingContent.MiContentCursor) tag : null;
        if (miContentCursor != null) {
            e2 O0 = this$0.O0();
            this$0.x1(O0 != null ? O0.n(miContentCursor.getContent()) : null, miContentCursor.getContent().getTitle(), false);
        } else {
            if (this$0.T0().getIsVip() || (a12 = this$0.a1()) == null) {
                return;
            }
            a12.Z();
        }
    }

    public static final void e2(ReaderSlidingAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().g(this$0.f14481d, 1019)) {
            J0(this$0, false, 1, null);
        }
    }

    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void f2(ReaderSlidingAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiConfigSingleton.b2().G1().g(this$0.f14481d, 1020);
    }

    public static final ge.d g1(MiBookMark miBookMark, MiReadingContent miReadingContent) {
        Map<Integer, MiBookMark> bookMarks;
        MiBookMark miBookMark2;
        List<ge.d> pageLayouts;
        if (miReadingContent == null || (bookMarks = miReadingContent.getBookMarks()) == null || (miBookMark2 = bookMarks.get(miBookMark.getContentPos())) == null || (pageLayouts = miReadingContent.getPageLayouts()) == null) {
            return null;
        }
        Intrinsics.checkNotNull(pageLayouts);
        for (ge.d dVar : pageLayouts) {
            Integer contentPos = miBookMark2.getContentPos();
            Intrinsics.checkNotNullExpressionValue(contentPos, "getContentPos(...)");
            if (contentPos.intValue() >= dVar.g()) {
                Integer contentPos2 = miBookMark2.getContentPos();
                Intrinsics.checkNotNullExpressionValue(contentPos2, "getContentPos(...)");
                if (contentPos2.intValue() < dVar.d()) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public static final ge.d h1(MiBookMark miBookMark, MiReadingContent miReadingContent) {
        List<ge.d> pageLayouts;
        if (miReadingContent == null || (pageLayouts = miReadingContent.getPageLayouts()) == null) {
            return null;
        }
        for (ge.d dVar : pageLayouts) {
            Integer start = miBookMark.getStart();
            Intrinsics.checkNotNullExpressionValue(start, "getStart(...)");
            if (start.intValue() >= dVar.g()) {
                Integer start2 = miBookMark.getStart();
                Intrinsics.checkNotNullExpressionValue(start2, "getStart(...)");
                if (start2.intValue() < dVar.d()) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public static final void i1(MiBookMark miBookMark, MiReadingContent.MiCursor miCursor, ReaderSlidingAdapter readerSlidingAdapter, MiReadingContent miReadingContent, ge.d dVar) {
        Map<Integer, MiBookMark> bookMarks = miReadingContent.getBookMarks();
        if (bookMarks != null) {
            bookMarks.remove(miBookMark.getContentPos());
        }
        dVar.O(false);
        if (miCursor.isCurrentPage() && (miCursor instanceof MiReadingContent.MiContentCursor)) {
            MiReadingContent.MiContentCursor miContentCursor = (MiReadingContent.MiContentCursor) miCursor;
            if (Intrinsics.areEqual(miContentCursor.getPageLayout(), dVar)) {
                View e10 = readerSlidingAdapter.e();
                Object tag = e10 != null ? e10.getTag() : null;
                a.C0533a c0533a = tag instanceof a.C0533a ? (a.C0533a) tag : null;
                if (c0533a == null) {
                    return;
                }
                readerSlidingAdapter.F2(c0533a, miContentCursor);
            }
        }
    }

    public static final void i2(ReaderSlidingAdapter this$0, CommentCount commentCount, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x1(commentCount, str, false);
    }

    public static final void j1(MiBookMark miBookMark, MiReadingContent miReadingContent, ge.d dVar) {
        Integer start = miBookMark.getStart();
        Intrinsics.checkNotNullExpressionValue(start, "getStart(...)");
        int intValue = start.intValue();
        Integer end = miBookMark.getEnd();
        Intrinsics.checkNotNullExpressionValue(end, "getEnd(...)");
        miReadingContent.removeBookUnderline(intValue, end.intValue());
        Integer start2 = miBookMark.getStart();
        Intrinsics.checkNotNullExpressionValue(start2, "getStart(...)");
        int intValue2 = start2.intValue();
        Integer end2 = miBookMark.getEnd();
        Intrinsics.checkNotNullExpressionValue(end2, "getEnd(...)");
        dVar.M(intValue2, end2.intValue());
    }

    public static final void j2(ReaderSlidingAdapter this$0, CommentCount commentCount, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x1(commentCount, str, true);
    }

    public static final void k2(ReaderSlidingAdapter this$0, CommentCount commentCount, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x1(commentCount, str, false);
    }

    public static final void l1(ReaderSlidingAdapter this$0, ReaderPageView readerPageView, int i10) {
        MiReadingContent content;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(readerPageView, "readerPageView");
        Object tag = readerPageView.getTag();
        MiReadingContent.MiContentCursor miContentCursor = tag instanceof MiReadingContent.MiContentCursor ? (MiReadingContent.MiContentCursor) tag : null;
        String paragraphText = (miContentCursor == null || (content = miContentCursor.getContent()) == null) ? null : content.getParagraphText(i10);
        e2 O0 = this$0.O0();
        if (O0 != null) {
            O0.s(miContentCursor != null ? miContentCursor.getContent() : null, Integer.valueOf(i10), paragraphText, paragraphText, false);
        }
    }

    public static final void n2(ReaderSlidingAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.L(this$0.f14481d, "举报");
        i.L(this$0.f14481d);
    }

    public static final void o2(ReaderSlidingAdapter this$0, MiReadingContent miReadingContent, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.f14500w <= 3000) {
            t0.b(this$0.f14481d, "太快啦，稍后重试...");
            return;
        }
        this$0.f14500w = System.currentTimeMillis();
        t0.b(this$0.f14481d, "加载中...");
        if (miReadingContent.isError()) {
            if (miReadingContent == this$0.f14485h || miReadingContent == this$0.f14486i) {
                miReadingContent.setStartFromFirstPage(true);
            } else if (miReadingContent == this$0.f14484g) {
                miReadingContent.setStartFromFirstPage(false);
            }
            this$0.A2(miReadingContent);
        }
    }

    public static final void p2(ReaderSlidingAdapter this$0, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity fragmentActivity = this$0.f14481d;
        i0.z0(fragmentActivity, fragmentActivity.getString(com.martian.libmars.R.string.prompt), "是否上报该章节存在错误信息？", new i0.l() { // from class: cd.d1

            /* renamed from: b */
            public final /* synthetic */ String f1797b;

            public /* synthetic */ d1(String str2) {
                str = str2;
            }

            @Override // l9.i0.l
            public final void a() {
                ReaderSlidingAdapter.q2(ReaderSlidingAdapter.this, str);
            }
        });
    }

    public static final void q2(ReaderSlidingAdapter this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G0(str, true);
    }

    public static final void r1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z2(ReaderSlidingAdapter this$0, MiReadingContent miReadingContent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y2(miReadingContent);
    }

    public final boolean A0() {
        return T0().getInterstitialInterval() > 0 && T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() > 20 && T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() % T0().getInterstitialInterval() == 0;
    }

    public final synchronized void A1() {
        try {
            if (this.f14485h.isReady()) {
                this.f14485h.setLoading();
                y2(this.f14485h);
            }
            if (this.f14484g.isReady()) {
                this.f14484g.setLoading();
                y2(this.f14484g);
            }
            if (this.f14486i.isReady()) {
                this.f14486i.setLoading();
                y2(this.f14486i);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void A2(@l MiReadingContent miReadingContent) {
        if (miReadingContent == null) {
            return;
        }
        if (miReadingContent.getChapter() == null && T0().getChapterList() != null) {
            ChapterList chapterList = T0().getChapterList();
            Intrinsics.checkNotNull(chapterList);
            if (chapterList.getCount() > 0) {
                ChapterList chapterList2 = T0().getChapterList();
                Intrinsics.checkNotNull(chapterList2);
                int count = chapterList2.getCount();
                int chapterIndex = miReadingContent.getChapterIndex();
                if (chapterIndex < 0 || chapterIndex >= count) {
                    ChapterList chapterList3 = T0().getChapterList();
                    miReadingContent.setChapter(chapterList3 != null ? chapterList3.getItem(count - 1) : null);
                } else {
                    ChapterList chapterList4 = T0().getChapterList();
                    miReadingContent.setChapter(chapterList4 != null ? chapterList4.getItem(miReadingContent.getChapterIndex()) : null);
                }
            }
        }
        MiConfigSingleton.b2().M1().l(T0().getBook(), T0().getChapterList(), miReadingContent.getChapterIndex(), new d(miReadingContent));
    }

    public final void B0() {
        ReadingContentLayoutBinding readingContentLayoutBinding;
        ReaderPageView readerPageView;
        Iterator<a.C0533a> it = this.f14491n.iterator();
        while (it.hasNext()) {
            ReadingLayoutBinding b10 = it.next().b();
            if (b10 != null && (readingContentLayoutBinding = b10.llReadingContent) != null && (readerPageView = readingContentLayoutBinding.rtvPage) != null) {
                readerPageView.cancelLongPress();
            }
        }
    }

    public final void B1() {
        Drawable drawable = this.f14493p;
        if (drawable instanceof BitmapDrawable) {
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
            System.gc();
        }
    }

    public final void B2(boolean z10) {
        if (this.f14502y) {
            return;
        }
        if (!z10) {
            ReadingInfo readingInfo = T0().getReadingInfo();
            if ((readingInfo != null ? readingInfo.getTagList() : null) != null) {
                return;
            }
        }
        this.f14502y = true;
        T0().o1();
    }

    public final void C0() {
        ReadingContentLayoutBinding readingContentLayoutBinding;
        ReaderPageView readerPageView;
        Iterator<a.C0533a> it = this.f14491n.iterator();
        while (it.hasNext()) {
            ReadingLayoutBinding b10 = it.next().b();
            if (b10 != null && (readingContentLayoutBinding = b10.llReadingContent) != null && (readerPageView = readingContentLayoutBinding.rtvPage) != null) {
                readerPageView.j();
            }
        }
    }

    public final void C1() {
        I1(this, null, 1, null);
        H2(this, null, 1, null);
    }

    public final void C2(@l MiReadingContent miReadingContent) {
        Chapter chapter = miReadingContent != null ? miReadingContent.getChapter() : null;
        if (chapter == null || chapter.isFree() || miReadingContent.isBuying()) {
            return;
        }
        boolean z10 = this.f14485h != miReadingContent;
        if (z10 && miReadingContent.isPrebuyError()) {
            return;
        }
        if (MiConfigSingleton.b2().u2().v()) {
            if (MiUserManager.q().v()) {
                y0(miReadingContent, chapter, z10);
                return;
            } else {
                J1(miReadingContent);
                return;
            }
        }
        if (!z10) {
            t0.b(this.f14481d, "请先登录");
            lb.d.b(this.f14481d, 10003, false);
        }
        J1(miReadingContent);
    }

    public final Drawable D0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intrinsics.checkNotNull(str);
        if (!StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
            return o0.K(this.f14481d, str);
        }
        Bitmap n10 = l9.b.n(str, this.f14481d.getResources().getDisplayMetrics().widthPixels, this.f14481d.getResources().getDisplayMetrics().heightPixels);
        if (n10 == null) {
            return null;
        }
        return new BitmapDrawable(this.f14481d.getResources(), n10);
    }

    public final void D1() {
        I2(this.f14485h, -1, 0, 0);
        I2(this.f14484g, -1, 0, 0);
        I2(this.f14486i, -1, 0, 0);
        MiReadingContent.MiCursor miCursor = this.f14495r;
        if (miCursor instanceof MiReadingContent.MiContentCursor) {
            Intrinsics.checkNotNull(miCursor, "null cannot be cast to non-null type com.martian.mibook.data.book.MiReadingContent.MiContentCursor");
            ((MiReadingContent.MiContentCursor) miCursor).removeSelection();
        }
    }

    public final void D2() {
        if (System.currentTimeMillis() - this.A <= 120000 || T0().getRecord() == null) {
            return;
        }
        this.A = System.currentTimeMillis();
        MiConfigSingleton.b2().M1().D0(T0().getRecord(), true);
    }

    public final void E0() {
        com.martian.mibook.application.d Z0 = Z0();
        if (Z0 != null) {
            Z0.m();
        }
    }

    public final void E1() {
        this.f14487j = false;
    }

    public final void E2(boolean z10) {
        if (z10) {
            t0.b(this.f14481d, ExtKt.c("解锁成功！"));
        }
        this.f14485h.setStartFromFirstPage(true);
        A2(this.f14485h);
        A2(this.f14484g);
        A2(this.f14486i);
    }

    public final boolean F0() {
        gd.a a12 = a1();
        if (a12 == null || !a12.m0()) {
            return z0();
        }
        return false;
    }

    public final synchronized void F1() {
        this.f14484g.reset();
        this.f14485h.reset();
        this.f14485h.setChapterIndex(T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String());
        this.f14486i.reset();
        u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001b, code lost:
    
        if (r0.z() == true) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void F2(com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.a.C0533a r4, com.martian.mibook.data.book.MiReadingContent.MiContentCursor r5) {
        /*
            r3 = this;
            if (r5 != 0) goto L3
            return
        L3:
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r0 = r3.T0()
            boolean r0 = r0.getIsScrollMode()
            r1 = 0
            if (r0 == 0) goto L10
        Le:
            r2 = 0
            goto L1d
        L10:
            ge.d r0 = r5.getPageLayout()
            if (r0 == 0) goto Le
            boolean r0 = r0.z()
            r2 = 1
            if (r0 != r2) goto Le
        L1d:
            com.martian.mibook.databinding.ReadingLayoutBinding r4 = r4.b()
            if (r4 == 0) goto L26
            com.martian.mibook.ui.reader.ReaderThemeImageView r4 = r4.ivMark
            goto L27
        L26:
            r4 = 0
        L27:
            if (r4 != 0) goto L2a
            goto L32
        L2a:
            if (r2 == 0) goto L2d
            goto L2f
        L2d:
            r1 = 8
        L2f:
            r4.setVisibility(r1)
        L32:
            boolean r4 = r5.isCurrentPage()
            if (r4 == 0) goto L3f
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r4 = r3.T0()
            r4.d2(r2)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.F2(com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$a$a, com.martian.mibook.data.book.MiReadingContent$MiContentCursor):void");
    }

    public final void G0(String str, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        String e02 = T0().e0();
        String sourceId = T0().getSourceId();
        String M0 = M0(null);
        if (!TextUtils.isEmpty(e02)) {
            sb2.append(e02);
        }
        if (!TextUtils.isEmpty(sourceId)) {
            sb2.append("-");
            sb2.append(sourceId);
        }
        if (!TextUtils.isEmpty(M0)) {
            sb2.append("-");
            sb2.append(M0);
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append("-");
            sb2.append(str);
            sb2.append(z10 ? "_manual" : "_silent");
        }
        ReadingInstance.z().p(this.f14481d, sb2.toString(), "", 1, 10003, z10);
    }

    public final void G1() {
        this.f14488k = 0;
        F1();
    }

    public final void G2(a.C0533a c0533a) {
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ReadingBottomStatusBinding readingBottomStatusBinding2;
        if (o1()) {
            return;
        }
        String format = this.f14497t.format(Long.valueOf(System.currentTimeMillis()));
        ReaderThemeTextView readerThemeTextView = null;
        if (c0533a == null) {
            Iterator<a.C0533a> it = this.f14491n.iterator();
            while (it.hasNext()) {
                ReadingLayoutBinding b10 = it.next().b();
                ReaderThemeTextView readerThemeTextView2 = (b10 == null || (readingBottomStatusBinding = b10.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding.rbsTvTime;
                if (readerThemeTextView2 != null) {
                    readerThemeTextView2.setText(format);
                }
            }
            return;
        }
        ReadingLayoutBinding b11 = c0533a.b();
        if (b11 != null && (readingBottomStatusBinding2 = b11.lyReadingBottomStatus) != null) {
            readerThemeTextView = readingBottomStatusBinding2.rbsTvTime;
        }
        if (readerThemeTextView == null) {
            return;
        }
        readerThemeTextView.setText(format);
    }

    public final void H0(int i10) {
        if (T0().c2()) {
            String M0 = M0(null);
            Map<String, Long> m02 = T0().m0();
            Long l10 = m02 != null ? m02.get(M0) : null;
            if (l10 != null) {
                if (l10.longValue() < 0 || System.currentTimeMillis() - l10.longValue() > i10 * 3000) {
                    EventManager V1 = MiConfigSingleton.b2().V1();
                    String sourceName = T0().getSourceName();
                    String sourceId = T0().getSourceId();
                    String recommendId = T0().getRecommendId();
                    int i11 = T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String();
                    MiReadingRecord record = T0().getRecord();
                    V1.h(6, sourceName, sourceId, recommendId, "", "", 0, i11, M0, record != null && record.isFirstRead());
                }
                Map<String, Long> m03 = T0().m0();
                if (m03 != null) {
                    m03.remove(M0);
                }
            }
            if (T0().getRecordReadType() == RecordReadType.RECORD_HALFWAY) {
                T0().c3(RecordReadType.RECORD);
            }
        }
    }

    public final void H1(a.C0533a c0533a) {
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ReadingBottomStatusBinding readingBottomStatusBinding2;
        ReaderThemeImageView readerThemeImageView;
        ReadingBottomStatusBinding readingBottomStatusBinding3;
        ReaderThemeProgressBar readerThemeProgressBar;
        ReadingBottomStatusBinding readingBottomStatusBinding4;
        ReadingBottomStatusBinding readingBottomStatusBinding5;
        ReaderThemeImageView readerThemeImageView2;
        ReadingBottomStatusBinding readingBottomStatusBinding6;
        ReaderThemeProgressBar readerThemeProgressBar2;
        if (o1()) {
            return;
        }
        if (c0533a == null) {
            Iterator<a.C0533a> it = this.f14491n.iterator();
            while (it.hasNext()) {
                a.C0533a next = it.next();
                if (next != null) {
                    H1(next);
                }
            }
            return;
        }
        ReaderThemeProgressBar readerThemeProgressBar3 = null;
        if (this.f14499v == 2) {
            ReadingLayoutBinding b10 = c0533a.b();
            if (b10 != null && (readingBottomStatusBinding6 = b10.lyReadingBottomStatus) != null && (readerThemeProgressBar2 = readingBottomStatusBinding6.rbsTvBattery) != null) {
                readerThemeProgressBar2.setProgressBarStyleType(2);
            }
            ReadingLayoutBinding b11 = c0533a.b();
            if (b11 != null && (readingBottomStatusBinding5 = b11.lyReadingBottomStatus) != null && (readerThemeImageView2 = readingBottomStatusBinding5.rivCharging) != null) {
                readerThemeImageView2.setVisibility(0);
            }
            ReadingLayoutBinding b12 = c0533a.b();
            if (b12 != null && (readingBottomStatusBinding4 = b12.lyReadingBottomStatus) != null) {
                readerThemeProgressBar3 = readingBottomStatusBinding4.rbsTvBattery;
            }
            if (readerThemeProgressBar3 == null) {
                return;
            }
            readerThemeProgressBar3.setProgress(100);
            return;
        }
        ReadingLayoutBinding b13 = c0533a.b();
        if (b13 != null && (readingBottomStatusBinding3 = b13.lyReadingBottomStatus) != null && (readerThemeProgressBar = readingBottomStatusBinding3.rbsTvBattery) != null) {
            readerThemeProgressBar.setProgressBarStyleType(this.f14498u <= 10 ? 3 : 2);
        }
        ReadingLayoutBinding b14 = c0533a.b();
        if (b14 != null && (readingBottomStatusBinding2 = b14.lyReadingBottomStatus) != null && (readerThemeImageView = readingBottomStatusBinding2.rivCharging) != null) {
            readerThemeImageView.setVisibility(8);
        }
        ReadingLayoutBinding b15 = c0533a.b();
        if (b15 != null && (readingBottomStatusBinding = b15.lyReadingBottomStatus) != null) {
            readerThemeProgressBar3 = readingBottomStatusBinding.rbsTvBattery;
        }
        if (readerThemeProgressBar3 == null) {
            return;
        }
        readerThemeProgressBar3.setProgress(this.f14498u);
    }

    public final void I0(boolean z10) {
        T0().M0().observe(this.f14481d, new Observer() { // from class: cd.n1
            public /* synthetic */ n1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderSlidingAdapter.K0(Function1.this, obj);
            }
        });
        T0().X(this.f14481d, 0);
    }

    public final void I2(MiReadingContent miReadingContent, int i10, int i11, int i12) {
        if (miReadingContent == null) {
            return;
        }
        if (miReadingContent.getChapterIndex() == i10) {
            miReadingContent.setHighlightSelection(i11, i12);
        } else {
            miReadingContent.removeHighlightSelection();
        }
    }

    public final void J1(MiReadingContent miReadingContent) {
        if (Intrinsics.areEqual(this.f14485h, miReadingContent)) {
            miReadingContent.setBuyingError();
        } else if (miReadingContent != null) {
            miReadingContent.setPrebuyError();
        }
    }

    public final void J2(ReaderPageView readerPageView, MiReadingContent.MiContentCursor miContentCursor) {
        MiReadingContent content;
        if (readerPageView != null) {
            readerPageView.setPageLayout(miContentCursor != null ? miContentCursor.getPageLayout() : null);
        }
        if (readerPageView != null) {
            readerPageView.setVisibility(0);
        }
        if (o1()) {
            if (readerPageView != null) {
                readerPageView.setPadding(readerPageView.getPaddingLeft(), readerPageView.getPaddingTop(), readerPageView.getPaddingRight(), ((int) readerPageView.getPageLayout().j()) - readerPageView.getPaddingTop());
            }
        } else if (readerPageView != null) {
            readerPageView.setPadding(readerPageView.getPaddingLeft(), readerPageView.getPaddingTop(), readerPageView.getPaddingRight(), ConfigSingleton.i(20.0f));
        }
        MiReadingContent content2 = miContentCursor != null ? miContentCursor.getContent() : null;
        if ((content2 != null ? content2.getHighlightSelection() : null) != null) {
            if (!(readerPageView != null ? readerPageView.L(content2.getHighlightSelection().f26278a, content2.getHighlightSelection().f26279b) : false) && readerPageView != null) {
                readerPageView.H();
            }
        }
        if (readerPageView != null) {
            readerPageView.k();
        }
        List<MiBookMark> bookUnderlinesBy = (miContentCursor == null || (content = miContentCursor.getContent()) == null) ? null : content.getBookUnderlinesBy(readerPageView != null ? readerPageView.getPageLayout() : null);
        List<MiBookMark> list = bookUnderlinesBy;
        if (!(list == null || list.isEmpty())) {
            for (MiBookMark miBookMark : bookUnderlinesBy) {
                if (readerPageView != null) {
                    Integer contentPos = miBookMark.getContentPos();
                    Intrinsics.checkNotNullExpressionValue(contentPos, "getContentPos(...)");
                    int intValue = contentPos.intValue();
                    Integer contentEnd = miBookMark.getContentEnd();
                    Intrinsics.checkNotNullExpressionValue(contentEnd, "getContentEnd(...)");
                    readerPageView.f(intValue, contentEnd.intValue());
                }
            }
        }
        if (T0().getShowChapterComment()) {
            e2 O0 = O0();
            TreeMap<Integer, CommentCount> o10 = O0 != null ? O0.o(content2) : null;
            if ((o10 == null || o10.isEmpty()) || readerPageView == null) {
                return;
            }
            readerPageView.G(o10);
        }
    }

    public final void K1(int i10, int i11) {
        if (i11 == 0) {
            this.f14489l = -1;
            this.f14488k = i10;
            return;
        }
        this.f14489l = i10;
        if (this.f14485h.isReady()) {
            this.f14488k = this.f14485h.findContentIndex(i10);
            this.f14489l = -1;
        }
    }

    public final void K2(TextView textView, TextView textView2) {
        int x10 = ReadingInstance.z().x(this.f14481d);
        if (textView != null) {
            textView.setTextSize(x10);
        }
        if (textView != null) {
            textView.setLineSpacing(0.0f, ReadingInstance.z().A(this.f14481d));
        }
        MiConfigSingleton.b2().i2().t(textView);
        if (textView2 != null) {
            MiConfigSingleton.b2().i2().t(textView2);
            textView2.setTextSize(x10 + 4);
        }
    }

    public final Chapter L0(int i10) {
        if (i10 < 0 || T0().getChapterList() == null) {
            return null;
        }
        ChapterList chapterList = T0().getChapterList();
        Intrinsics.checkNotNull(chapterList);
        if (i10 >= chapterList.getCount()) {
            return null;
        }
        ChapterList chapterList2 = T0().getChapterList();
        Intrinsics.checkNotNull(chapterList2);
        Chapter item = chapterList2.getItem(i10);
        if (item != null) {
            return item;
        }
        t0.b(this.f14481d, "加载出错，请重试");
        MiChapter miChapter = new MiChapter();
        miChapter.setTitle("未知");
        miChapter.setLink("未知");
        return miChapter;
    }

    public final void L1() {
        com.martian.mibook.application.d Z0 = Z0();
        if (Z0 != null) {
            Z0.f0();
        }
    }

    public final void L2(ReaderPageView readerPageView) {
        if (readerPageView != null) {
            readerPageView.setTypeface(MiConfigSingleton.b2().i2().g());
        }
    }

    @k
    public final String M0(@l Chapter chapter) {
        if (chapter == null) {
            if (T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() < 0) {
                return "";
            }
            chapter = L0(T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String());
        }
        String chapterId = chapter != null ? chapter.getChapterId() : null;
        return chapterId == null ? "" : chapterId;
    }

    public final void M1(@l View view) {
        if (view == null) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        if (k10.getIsColorBackground()) {
            view.setBackgroundColor(k10.getBackgroundColor());
            return;
        }
        if (this.f14493p == null || !StringsKt.equals(k10.getBackgroundImagePath(), this.f14494q, true)) {
            String backgroundImagePath = k10.getBackgroundImagePath();
            this.f14494q = backgroundImagePath;
            this.f14493p = D0(backgroundImagePath);
        }
        Drawable drawable = this.f14493p;
        if (drawable == null) {
            view.setBackgroundColor(k10.getBackgroundColor());
            return;
        }
        try {
            view.setBackground(drawable);
        } catch (Exception unused) {
            view.setBackgroundColor(k10.getBackgroundColor());
        }
    }

    public final void M2(ReaderPageView readerPageView, View view) {
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        if (readerPageView != null) {
            readerPageView.setTextColor(k10.getTextColorPrimary());
            readerPageView.setHighlightBgColor(k10.getHighLightSelectBackground());
            readerPageView.setUnderlineColor(k10.getItemColorPrimary());
            readerPageView.setSelectionCursorColor(k10.getItemColorPrimary());
            readerPageView.setParagraphCommentCountColor(k10.getTextColorThirdly());
        }
        if (view == null || o1()) {
            return;
        }
        M1(view);
    }

    public final int N0() {
        if (T0().getChapterList() == null) {
            return 0;
        }
        ChapterList chapterList = T0().getChapterList();
        Intrinsics.checkNotNull(chapterList);
        return chapterList.getCount();
    }

    public final void N1(TextView textView, TextView textView2, String str) {
        if (o1()) {
            if (textView2 == null) {
                return;
            }
            textView2.setText(str);
        } else {
            if (textView == null) {
                return;
            }
            textView.setText(str);
        }
    }

    public final void N2() {
        ReadingContentLayoutBinding readingContentLayoutBinding;
        Iterator<a.C0533a> it = this.f14491n.iterator();
        while (it.hasNext()) {
            a.C0533a next = it.next();
            gd.a a12 = a1();
            if (a12 != null) {
                ReadingLayoutBinding b10 = next.b();
                a12.h((b10 == null || (readingContentLayoutBinding = b10.llReadingContent) == null) ? null : readingContentLayoutBinding.tvReadingTitleView, 13);
            }
        }
    }

    public final e2 O0() {
        if (this.f14492o == null) {
            this.f14492o = new e2(this.f14481d, T0().getSourceName(), T0().getSourceId(), T0().getChapterList());
        }
        return this.f14492o;
    }

    public final void O1(int i10, int i11, int i12) {
        I2(this.f14485h, i10, i11, i12);
        I2(this.f14484g, i10, i11, i12);
        I2(this.f14486i, i10, i11, i12);
        if (i11 < 0) {
            I2(this.f14485h, i10, i11, i12);
        }
        if (i10 == T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() && n1(i11)) {
            MiReadingContent.MiCursor miCursor = this.f14495r;
            Intrinsics.checkNotNull(miCursor, "null cannot be cast to non-null type com.martian.mibook.data.book.MiReadingContent.MiContentCursor");
            ((MiReadingContent.MiContentCursor) miCursor).setHighlight(i11, i12);
        }
    }

    public final void O2() {
        Chapter chapter;
        String title = (this.f14485h.getChapter() == null || (chapter = this.f14485h.getChapter()) == null) ? null : chapter.getTitle();
        T0().d1().observe(this.f14481d, new Observer() { // from class: cd.e1
            public /* synthetic */ e1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderSlidingAdapter.P2(Function1.this, obj);
            }
        });
        T0().c1().observe(this.f14481d, new Observer() { // from class: cd.f1
            public /* synthetic */ f1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderSlidingAdapter.Q2(Function1.this, obj);
            }
        });
        T0().z3(M0(null), title);
    }

    @Override // z9.d
    @l
    /* renamed from: P0 */
    public MiReadingContent.MiCursor d() {
        com.martian.mibook.application.d Z0 = Z0();
        d.C0528d T0 = Z0 != null ? Z0.T0() : null;
        if (T0 != null) {
            return T0;
        }
        MiReadingContent.MiCursor R0 = R0();
        if (R0 != null) {
            R0.setCurrentPage(true);
        }
        return R0;
    }

    public final void P1(a.C0533a c0533a, d.C0528d c0528d) {
        ViewStub viewStub;
        View inflate;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ViewStub viewStub2;
        View inflate2;
        ReadingContentLayoutBinding readingContentLayoutBinding;
        ReadingContentLayoutBinding readingContentLayoutBinding2;
        LinearLayout root;
        ReadingContentLayoutBinding readingContentLayoutBinding3;
        ReadingLayoutBinding b10 = c0533a.b();
        ReadingLinkAdBinding readingLinkAdBinding = null;
        LinearLayout root2 = (b10 == null || (readingContentLayoutBinding3 = b10.llReadingContent) == null) ? null : readingContentLayoutBinding3.getRoot();
        if (root2 != null) {
            root2.setVisibility(0);
        }
        ReadingLayoutBinding b11 = c0533a.b();
        if (b11 != null && (root = b11.getRoot()) != null) {
            root.setPadding(0, 0, 0, 0);
        }
        ReadingLayoutBinding b12 = c0533a.b();
        ReaderPageView readerPageView = (b12 == null || (readingContentLayoutBinding2 = b12.llReadingContent) == null) ? null : readingContentLayoutBinding2.rtvPage;
        if (readerPageView != null) {
            readerPageView.setVisibility(4);
        }
        if (!o1()) {
            ReadingLayoutBinding b13 = c0533a.b();
            ReaderThemeTextView readerThemeTextView = (b13 == null || (readingContentLayoutBinding = b13.llReadingContent) == null) ? null : readingContentLayoutBinding.tvReadingTitle;
            if (readerThemeTextView != null) {
                readerThemeTextView.setText(this.f14481d.getString(R.string.ad_for_novel));
            }
        }
        if (c0533a.a() == null) {
            ReadingLayoutBinding b14 = c0533a.b();
            ViewStub viewStub3 = b14 != null ? b14.readingAdsViewStub : null;
            if (viewStub3 != null) {
                viewStub3.setLayoutResource(R.layout.reading_ads_layout);
            }
            ReadingLayoutBinding b15 = c0533a.b();
            c0533a.j((b15 == null || (viewStub2 = b15.readingAdsViewStub) == null || (inflate2 = viewStub2.inflate()) == null) ? null : ReadingAdsLayoutBinding.bind(inflate2));
            ReadingAdsLayoutBinding a10 = c0533a.a();
            if (a10 != null && (linearLayout2 = a10.flCloseAdsIcon) != null) {
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: cd.o1
                    public /* synthetic */ o1() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReaderSlidingAdapter.Q1(ReaderSlidingAdapter.this, view);
                    }
                });
            }
            ReadingAdsLayoutBinding a11 = c0533a.a();
            if (a11 != null && (linearLayout = a11.flCloseAdsVideo) != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: cd.p1
                    public /* synthetic */ p1() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReaderSlidingAdapter.R1(ReaderSlidingAdapter.this, view);
                    }
                });
            }
        }
        gd.a a12 = a1();
        SlidingLayout D0 = a12 != null ? a12.D0() : null;
        com.martian.mibook.application.d Z0 = Z0();
        if (Z0 != null) {
            Z0.t1(c0533a.a(), c0528d, D0, o1());
        }
        if (c0533a.h() == null) {
            ReadingLayoutBinding b16 = c0533a.b();
            ViewStub viewStub4 = b16 != null ? b16.readingLinkAdViewStub : null;
            if (viewStub4 != null) {
                viewStub4.setLayoutResource(R.layout.reading_link_ad);
            }
            ReadingLayoutBinding b17 = c0533a.b();
            if (b17 != null && (viewStub = b17.readingLinkAdViewStub) != null && (inflate = viewStub.inflate()) != null) {
                readingLinkAdBinding = ReadingLinkAdBinding.bind(inflate);
            }
            c0533a.q(readingLinkAdBinding);
        }
        com.martian.mibook.application.d Z02 = Z0();
        if (Z02 != null) {
            Z02.u1(c0533a.h(), c0528d, T0().getSourceString(), T0().getAdHiding());
        }
    }

    @k
    public final MiReadingContent Q0() {
        return this.f14485h;
    }

    public final MiReadingContent.MiCursor R0() {
        if (T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() < 0) {
            return new MiReadingContent.MiCoverCursor();
        }
        if (T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() == N0()) {
            return new MiReadingContent.MiLastPageCursor();
        }
        if (this.f14485h.isEmpty()) {
            this.f14485h.setChapterIndex(T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String());
            this.f14485h.setChapter(L0(T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String()));
            A2(this.f14485h);
        }
        if (this.f14485h.isLoading()) {
            return new MiReadingContent.MiLoadingCursor(this.f14488k, this.f14485h);
        }
        if (this.f14485h.isContentError()) {
            if (this.f14485h.getErrCode() != null) {
                Integer errCode = this.f14485h.getErrCode();
                int i10 = MiReadingContent.ERRCODE_BOOK_OFFLINE;
                if (errCode == null || errCode.intValue() != i10) {
                    return new MiReadingContent.MiErrorCursor(this.f14485h);
                }
            }
            return new MiReadingContent.MiOfflineCursor(this.f14485h);
        }
        if (this.f14485h.isBuyingStatus()) {
            return new MiReadingContent.MiBuyingCursor(this.f14485h);
        }
        if (this.f14485h.isReady()) {
            int i11 = this.f14488k;
            if (i11 == -1) {
                this.f14488k = this.f14485h.getEndPosSize() - 1;
            } else if (i11 == -2) {
                this.f14488k = 0;
            }
            z1();
            return this.f14485h.getContentCursor(this.f14488k, this.f14487j);
        }
        if (!ConfigSingleton.R.J0()) {
            return new MiReadingContent.MiErrorCursor(this.f14485h);
        }
        throw new UnsupportedOperationException("Unknown content status: " + this.f14485h.getStatus());
    }

    public final int S0() {
        MiReadingContent.MiCursor miCursor = this.f14495r;
        if (miCursor instanceof MiReadingContent.MiContentCursor) {
            return ((MiReadingContent.MiContentCursor) miCursor).getStartContentPos();
        }
        return 0;
    }

    public final void S1(a.C0533a c0533a, MiReadingContent.MiContentCursor miContentCursor) {
        String str;
        ReaderThemeItemTextView readerThemeItemTextView;
        ReaderThemeItemTextView readerThemeItemTextView2;
        String string;
        int i10;
        ReaderThemeTextView readerThemeTextView;
        ReaderThemeTextView readerThemeTextView2;
        ReaderThemeTextView readerThemeTextView3;
        LinearLayout linearLayout;
        ViewStub viewStub;
        View inflate;
        if (c0533a.c() == null) {
            ReadingLayoutBinding b10 = c0533a.b();
            ViewStub viewStub2 = b10 != null ? b10.bookActiveViewStub : null;
            if (viewStub2 != null) {
                viewStub2.setLayoutResource(R.layout.loading_book_active);
            }
            ReadingLayoutBinding b11 = c0533a.b();
            c0533a.l((b11 == null || (viewStub = b11.bookActiveViewStub) == null || (inflate = viewStub.inflate()) == null) ? null : LoadingBookActiveBinding.bind(inflate));
        }
        LoadingBookActiveBinding c10 = c0533a.c();
        LinearLayout root = c10 != null ? c10.getRoot() : null;
        int i11 = 0;
        if (root != null) {
            root.setVisibility(0);
        }
        LoadingBookActiveBinding c11 = c0533a.c();
        if (c11 != null && (linearLayout = c11.tvActiveReadingTitleView) != null) {
            linearLayout.setPadding(0, b1() + ConfigSingleton.i(12.0f), 0, ConfigSingleton.i(12.0f));
        }
        LoadingBookActiveBinding c12 = c0533a.c();
        LinearLayout linearLayout2 = c12 != null ? c12.tvActiveReadingTitleView : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(o1() ? 4 : 0);
        }
        LoadingBookActiveBinding c13 = c0533a.c();
        ReaderThemeTextView readerThemeTextView4 = c13 != null ? c13.tvActiveReadingContent : null;
        LoadingBookActiveBinding c14 = c0533a.c();
        K2(readerThemeTextView4, c14 != null ? c14.tvActiveReadingTitle : null);
        if (T0().getBook() != null) {
            LoadingBookActiveBinding c15 = c0533a.c();
            Intrinsics.checkNotNull(c15);
            N1(c15.tvActiveReadingBookName, c1(), T0().e0());
        }
        if ((miContentCursor != null ? miContentCursor.getContent() : null) != null) {
            str = miContentCursor.getContent().getContent(miContentCursor.getContentIndex());
            LoadingBookActiveBinding c16 = c0533a.c();
            ReaderThemeTextView readerThemeTextView5 = c16 != null ? c16.tvActiveReadingTitle : null;
            if (readerThemeTextView5 != null) {
                readerThemeTextView5.setText(miContentCursor.getContent().getTitle());
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            LoadingBookActiveBinding c17 = c0533a.c();
            ReaderThemeTextView readerThemeTextView6 = c17 != null ? c17.tvActiveReadingContent : null;
            if (readerThemeTextView6 != null) {
                readerThemeTextView6.setVisibility(4);
            }
        } else {
            LoadingBookActiveBinding c18 = c0533a.c();
            ReaderThemeTextView readerThemeTextView7 = c18 != null ? c18.tvActiveReadingContent : null;
            if (readerThemeTextView7 != null) {
                readerThemeTextView7.setVisibility(0);
            }
            LoadingBookActiveBinding c19 = c0533a.c();
            ReaderThemeTextView readerThemeTextView8 = c19 != null ? c19.tvActiveReadingContent : null;
            if (readerThemeTextView8 != null) {
                readerThemeTextView8.setText(str);
            }
            LoadingBookActiveBinding c20 = c0533a.c();
            int lineHeight = (c20 == null || (readerThemeTextView3 = c20.tvActiveReadingContent) == null) ? 0 : readerThemeTextView3.getLineHeight();
            if (lineHeight > 0) {
                LoadingBookActiveBinding c21 = c0533a.c();
                if (c21 != null && (readerThemeTextView2 = c21.tvActiveReadingContent) != null) {
                    i11 = readerThemeTextView2.getMeasuredHeight();
                }
                i10 = i11 / lineHeight;
            } else {
                i10 = 2;
            }
            LoadingBookActiveBinding c22 = c0533a.c();
            if (c22 != null && (readerThemeTextView = c22.tvActiveReadingContent) != null) {
                readerThemeTextView.setMaxLines(i10);
            }
        }
        Integer adChapterMinutes = MiConfigSingleton.b2().c2().getAdChapterMinutes();
        LoadingBookActiveBinding c23 = c0533a.c();
        ReaderThemeItemTextView readerThemeItemTextView3 = c23 != null ? c23.tvActiveReadingPurchaseVideo : null;
        if (readerThemeItemTextView3 != null) {
            Intrinsics.checkNotNull(adChapterMinutes);
            if (adChapterMinutes.intValue() > 0) {
                string = this.f14481d.getString(R.string.active_by_video_duration) + adChapterMinutes + "分钟";
            } else {
                string = this.f14481d.getString(R.string.active_by_video);
            }
            readerThemeItemTextView3.setText(string);
        }
        LoadingBookActiveBinding c24 = c0533a.c();
        if (c24 != null && (readerThemeItemTextView2 = c24.tvActiveReadingPurchaseVideo) != null) {
            readerThemeItemTextView2.setOnClickListener(new View.OnClickListener() { // from class: cd.j1
                public /* synthetic */ j1() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderSlidingAdapter.T1(ReaderSlidingAdapter.this, view);
                }
            });
        }
        LoadingBookActiveBinding c25 = c0533a.c();
        if (c25 == null || (readerThemeItemTextView = c25.tvActiveReadingVip) == null) {
            return;
        }
        readerThemeItemTextView.setOnClickListener(new View.OnClickListener() { // from class: cd.k1
            public /* synthetic */ k1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderSlidingAdapter.U1(ReaderSlidingAdapter.this, view);
            }
        });
    }

    public final ReadingViewModel T0() {
        return (ReadingViewModel) this.f14482e.getValue();
    }

    @Override // z9.d
    @l
    /* renamed from: U0 */
    public MiReadingContent.MiCursor f() {
        gd.a a12;
        com.martian.mibook.application.d Z0 = Z0();
        d.C0528d W0 = Z0 != null ? Z0.W0() : null;
        if (W0 != null) {
            return W0;
        }
        boolean z10 = this.f14487j || ((a12 = a1()) != null && a12.r());
        if (this.f14485h.isReady() && this.f14488k < this.f14485h.getEndPosSize() - 1) {
            return this.f14485h.getContentCursor(this.f14488k + 1, z10);
        }
        int i10 = T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() + 1;
        if (i10 == N0()) {
            return new MiReadingContent.MiLastPageCursor();
        }
        if (this.f14486i.isEmpty()) {
            this.f14486i.setChapterIndex(i10);
            this.f14486i.setChapter(L0(i10));
            A2(this.f14486i);
        }
        if (this.f14486i.isLoading()) {
            return new MiReadingContent.MiLoadingCursor(-2, this.f14486i);
        }
        if (this.f14486i.isContentError()) {
            if (this.f14486i.getErrCode() != null) {
                Integer errCode = this.f14486i.getErrCode();
                int i11 = MiReadingContent.ERRCODE_BOOK_OFFLINE;
                if (errCode == null || errCode.intValue() != i11) {
                    return new MiReadingContent.MiErrorCursor(this.f14486i);
                }
            }
            return new MiReadingContent.MiOfflineCursor(this.f14486i);
        }
        if (this.f14486i.isBuyingStatus()) {
            return new MiReadingContent.MiBuyingCursor(this.f14486i);
        }
        if (this.f14486i.isReady()) {
            return this.f14486i.getContentCursor(0, z10);
        }
        if (!ConfigSingleton.D().J0()) {
            return new MiReadingContent.MiErrorCursor(this.f14486i);
        }
        throw new UnsupportedOperationException("Unknown content status: " + this.f14486i.getStatus());
    }

    public final ge.b V0() {
        ReaderPageView E0;
        ReaderPageView E02;
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        gd.a a12 = a1();
        int i10 = 0;
        int pageHeight = (a12 == null || (E02 = a12.E0()) == null) ? 0 : E02.getPageHeight();
        gd.a a13 = a1();
        if (a13 != null && (E0 = a13.E0()) != null) {
            i10 = E0.getPageWidth();
        }
        ge.b bVar = this.f14490m;
        if (bVar == null) {
            this.f14490m = new b.a(this.f14481d.getResources()).i(ReadingInstance.z().G(this.f14481d)).e(pageHeight).f(i10).a();
        } else if (bVar != null) {
            bVar.n(ReadingInstance.z().G(this.f14481d));
            bVar.k(pageHeight);
            bVar.l(i10);
        }
        ge.b bVar2 = this.f14490m;
        if (bVar2 != null) {
            bVar2.m(k10.getTextColorPrimary());
            bVar2.o(MiConfigSingleton.b2().i2().g());
            bVar2.j(k10.getHighLightSelectBackground());
            bVar2.p(k10.getItemColorPrimary());
        }
        return this.f14490m;
    }

    @SuppressLint({"SetTextI18n"})
    public final void V1(a.C0533a c0533a) {
        ReadingBottomStatusBinding readingBottomStatusBinding;
        LinearLayout root;
        ViewStub viewStub;
        View inflate;
        if (c0533a.d() == null) {
            ReadingLayoutBinding b10 = c0533a.b();
            ViewStub viewStub2 = b10 != null ? b10.bookCoverViewStub : null;
            if (viewStub2 != null) {
                viewStub2.setLayoutResource(R.layout.reader_slide_book_cover_layout);
            }
            ReadingLayoutBinding b11 = c0533a.b();
            c0533a.m((b11 == null || (viewStub = b11.bookCoverViewStub) == null || (inflate = viewStub.inflate()) == null) ? null : ReaderSlideBookCoverLayoutBinding.bind(inflate));
        }
        ReadingLayoutBinding b12 = c0533a.b();
        if (b12 != null && (root = b12.getRoot()) != null) {
            root.setPadding(0, 0, 0, 0);
        }
        ReadingLayoutBinding b13 = c0533a.b();
        LinearLayout root2 = (b13 == null || (readingBottomStatusBinding = b13.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding.getRoot();
        if (root2 != null) {
            root2.setVisibility(8);
        }
        ReaderSlideBookCoverLayoutBinding d10 = c0533a.d();
        ReaderBookCoverLayout root3 = d10 != null ? d10.getRoot() : null;
        if (root3 == null) {
            return;
        }
        root3.setVisibility(0);
    }

    @Override // z9.d
    @l
    /* renamed from: W0 */
    public MiReadingContent.MiCursor h() {
        int i10;
        com.martian.mibook.application.d Z0 = Z0();
        d.C0528d X0 = Z0 != null ? Z0.X0() : null;
        if (X0 != null) {
            return X0;
        }
        com.martian.mibook.application.d Z02 = Z0();
        if ((Z02 != null ? Z02.T0() : null) != null) {
            return R0();
        }
        if (this.f14485h.isReady() && (i10 = this.f14488k) > 0) {
            return this.f14485h.getContentCursor(i10 - 1, this.f14487j);
        }
        if (T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() <= 0) {
            return new MiReadingContent.MiCoverCursor();
        }
        int i11 = T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() - 1;
        if (this.f14484g.isEmpty()) {
            this.f14484g.setChapterIndex(i11);
            this.f14484g.setChapter(L0(i11));
            A2(this.f14484g);
        }
        if (this.f14484g.isLoading()) {
            return new MiReadingContent.MiLoadingCursor(-1, this.f14484g);
        }
        if (this.f14484g.isContentError()) {
            if (this.f14484g.getErrCode() != null) {
                Integer errCode = this.f14484g.getErrCode();
                int i12 = MiReadingContent.ERRCODE_BOOK_OFFLINE;
                if (errCode == null || errCode.intValue() != i12) {
                    return new MiReadingContent.MiErrorCursor(this.f14484g);
                }
            }
            return new MiReadingContent.MiOfflineCursor(this.f14484g);
        }
        if (this.f14484g.isBuyingStatus()) {
            return new MiReadingContent.MiBuyingCursor(this.f14484g);
        }
        if (this.f14484g.isReady()) {
            return this.f14484g.getContentCursor(r0.getEndPosSize() - 1, this.f14487j);
        }
        if (!ConfigSingleton.D().J0()) {
            return new MiReadingContent.MiErrorCursor(this.f14484g);
        }
        throw new UnsupportedOperationException("Unknown content status: " + this.f14484g.getStatus());
    }

    public final void W1(boolean z10) {
        ReadingBottomStatusBinding readingBottomStatusBinding;
        Iterator<a.C0533a> it = this.f14491n.iterator();
        while (it.hasNext()) {
            ReadingLayoutBinding b10 = it.next().b();
            ReaderThemeTextView readerThemeTextView = (b10 == null || (readingBottomStatusBinding = b10.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding.rbsTvHint;
            if (readerThemeTextView != null) {
                readerThemeTextView.setVisibility(z10 ? 0 : 4);
            }
        }
    }

    @k
    public final MiReadingContent X0() {
        return this.f14484g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0476, code lost:
    
        if (r3 <= r7.getBookCoins()) goto L911;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0478, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0490, code lost:
    
        r3 = r8.tvBuyReadingPurchase;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0492, code lost:
    
        if (r6 != 0) goto L922;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0494, code lost:
    
        v2(r2, r18.getChapterIndex());
        r2 = r16.f14481d.getResources().getString(com.martian.mibook.R.string.purchase_coins_no_enough);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x04c3, code lost:
    
        r3.setText(r2);
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x04a8, code lost:
    
        if (r4 == false) goto L924;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x04aa, code lost:
    
        r2 = r16.f14481d.getResources().getString(com.martian.mibook.R.string.whole_purchase);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x04b7, code lost:
    
        r2 = r16.f14481d.getResources().getString(com.martian.mibook.R.string.chapter_purchase);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x048d, code lost:
    
        if (r3 <= r7.getBookCoins()) goto L911;
     */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void X1(com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.a.C0533a r17, com.martian.mibook.data.book.MiReadingContent r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.X1(com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$a$a, com.martian.mibook.data.book.MiReadingContent, boolean):void");
    }

    public final String Y0(MiReadingContent.MiContentCursor miContentCursor) {
        if (miContentCursor == null) {
            return "";
        }
        int chapterIndex = miContentCursor.getContent().getChapterIndex();
        int contentIndex = miContentCursor.getContentIndex();
        int endPosSize = miContentCursor.getContent().getEndPosSize();
        int N0 = N0();
        if (N0 <= 0) {
            return "";
        }
        if (chapterIndex >= N0) {
            return "99.99%";
        }
        double d10 = chapterIndex;
        double d11 = (endPosSize == 0 || contentIndex < 0) ? l5.c.f27899e : ((contentIndex + 1) * 1.0f) / endPosSize;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(((d10 + d11) * 100.0f) / N0)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format + "%";
    }

    public final com.martian.mibook.application.d Z0() {
        return (com.martian.mibook.application.d) this.f14483f.getValue();
    }

    public final gd.a a1() {
        KeyEventDispatcher.Component component = this.f14481d;
        if (component instanceof gd.a) {
            return (gd.a) component;
        }
        return null;
    }

    @Override // z9.d
    public void b() {
        gd.a a12;
        com.martian.mibook.application.d Z0 = Z0();
        if (Z0 == null || !Z0.M0(F0(), T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String(), this.f14488k)) {
            if (!this.f14487j && (a12 = a1()) != null && a12.r()) {
                this.f14487j = true;
            }
            if (this.f14485h.isReady() && this.f14488k < this.f14485h.getEndPosSize() - 1) {
                this.f14488k++;
                return;
            }
            ReadingViewModel T0 = T0();
            T0.x2(T0.getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() + 1);
            this.f14488k = -2;
            this.f14484g.reset();
            MiReadingContent miReadingContent = this.f14485h;
            MiReadingContent miReadingContent2 = this.f14486i;
            this.f14485h = miReadingContent2;
            this.f14486i = this.f14484g;
            this.f14484g = miReadingContent;
            if (miReadingContent2.isReady()) {
                this.f14488k = 0;
            }
        }
    }

    public final int b1() {
        gd.a a12 = a1();
        if (a12 != null) {
            return a12.l0();
        }
        return 0;
    }

    @Override // z9.d
    public void c() {
        int i10;
        if (Z0() != null) {
            com.martian.mibook.application.d Z0 = Z0();
            if (Z0 == null || !Z0.N0()) {
                if (this.f14485h.isReady() && (i10 = this.f14488k) > 0) {
                    this.f14488k = i10 - 1;
                    return;
                }
                T0().x2(r0.getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() - 1);
                this.f14488k = -1;
                this.f14486i.reset();
                MiReadingContent miReadingContent = this.f14485h;
                MiReadingContent miReadingContent2 = this.f14484g;
                this.f14485h = miReadingContent2;
                this.f14484g = this.f14486i;
                this.f14486i = miReadingContent;
                if (miReadingContent2.isReady()) {
                    this.f14488k = this.f14485h.getEndPosSize() - 1;
                }
            }
        }
    }

    public final TextView c1() {
        gd.a a12 = a1();
        if (a12 != null) {
            return a12.z0();
        }
        return null;
    }

    @Override // z9.d
    @l
    @SuppressLint({"InflateParams", "SetTextI18n"})
    /* renamed from: d1 */
    public View o(@l View view, @l MiReadingContent.MiCursor miCursor) {
        a.C0533a c0533a;
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ReadingBottomStatusBinding readingBottomStatusBinding2;
        ReaderThemeTextView readerThemeTextView;
        ReadingBottomStatusBinding readingBottomStatusBinding3;
        ReadingBottomStatusBinding readingBottomStatusBinding4;
        ReadingBottomStatusBinding readingBottomStatusBinding5;
        ReadingBottomStatusBinding readingBottomStatusBinding6;
        ReadingBottomStatusBinding readingBottomStatusBinding7;
        ReadingBottomStatusBinding readingBottomStatusBinding8;
        LinearLayout root;
        ReadingBottomStatusBinding readingBottomStatusBinding9;
        ReadingBottomStatusBinding readingBottomStatusBinding10;
        ReadingContentLayoutBinding readingContentLayoutBinding;
        ReadingContentLayoutBinding readingContentLayoutBinding2;
        LinearLayout root2;
        ReadingContentLayoutBinding readingContentLayoutBinding3;
        ReadingContentLayoutBinding readingContentLayoutBinding4;
        ReaderPageView readerPageView;
        ReadingContentLayoutBinding readingContentLayoutBinding5;
        ReadingContentLayoutBinding readingContentLayoutBinding6;
        ReadingBottomStatusBinding readingBottomStatusBinding11;
        ReaderThemeTextView readerThemeTextView2;
        ReaderThemeTextView readerThemeTextView3 = null;
        readerThemeTextView3 = null;
        if (view == null) {
            view = LayoutInflater.from(this.f14481d).inflate(R.layout.reading_layout, (ViewGroup) null);
            c0533a = new a.C0533a();
            view.setTag(c0533a);
            this.f14491n.add(c0533a);
            c0533a.k(ReadingLayoutBinding.bind(view));
            ReadingLayoutBinding b10 = c0533a.b();
            if (b10 != null && (readingBottomStatusBinding11 = b10.lyReadingBottomStatus) != null && (readerThemeTextView2 = readingBottomStatusBinding11.rbsTvHint) != null) {
                readerThemeTextView2.setOnClickListener(new View.OnClickListener() { // from class: cd.m1

                    /* renamed from: c */
                    public final /* synthetic */ ReaderSlidingAdapter f1854c;

                    public /* synthetic */ m1(ReaderSlidingAdapter this) {
                        this = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ReaderSlidingAdapter.e1(ReaderSlidingAdapter.a.C0533a.this, this, view2);
                    }
                });
            }
            gd.a a12 = a1();
            if (a12 != null) {
                ReadingLayoutBinding b11 = c0533a.b();
                a12.h(b11 != null ? b11.ivMark : null, 20);
            }
            gd.a a13 = a1();
            if (a13 != null) {
                ReadingLayoutBinding b12 = c0533a.b();
                a13.h((b12 == null || (readingContentLayoutBinding6 = b12.llReadingContent) == null) ? null : readingContentLayoutBinding6.tvReadingTitleView, 13);
            }
            ReadingLayoutBinding b13 = c0533a.b();
            ReaderPageView readerPageView2 = (b13 == null || (readingContentLayoutBinding5 = b13.llReadingContent) == null) ? null : readingContentLayoutBinding5.rtvPage;
            ReadingLayoutBinding b14 = c0533a.b();
            M2(readerPageView2, b14 != null ? b14.getRoot() : null);
            ReadingLayoutBinding b15 = c0533a.b();
            if (b15 != null && (readingContentLayoutBinding4 = b15.llReadingContent) != null && (readerPageView = readingContentLayoutBinding4.rtvPage) != null) {
                readerPageView.setActionMenuConfig(T0().U1());
            }
            ReadingLayoutBinding b16 = c0533a.b();
            k1((b16 == null || (readingContentLayoutBinding3 = b16.llReadingContent) == null) ? null : readingContentLayoutBinding3.rtvPage, miCursor);
            H1(c0533a);
            G2(c0533a);
        } else {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.Companion.ViewHolder");
            c0533a = (a.C0533a) tag;
        }
        boolean U = T0().U();
        boolean withBannerPadding = miCursor != null ? miCursor.withBannerPadding() : false;
        ReadingLayoutBinding b17 = c0533a.b();
        if (b17 != null && (root2 = b17.getRoot()) != null) {
            root2.setPadding(0, 0, 0, (U || !withBannerPadding) ? 0 : ConfigSingleton.i(64.0f));
        }
        ReadingLayoutBinding b18 = c0533a.b();
        ReaderThemeTextView readerThemeTextView4 = b18 != null ? b18.pbContentLoading : null;
        int i10 = 8;
        if (readerThemeTextView4 != null) {
            readerThemeTextView4.setVisibility(8);
        }
        ReadingAdsLayoutBinding a10 = c0533a.a();
        RelativeLayout root3 = a10 != null ? a10.getRoot() : null;
        if (root3 != null) {
            root3.setVisibility(8);
        }
        ReadingLinkAdBinding h10 = c0533a.h();
        ThemeLinearLayout root4 = h10 != null ? h10.getRoot() : null;
        if (root4 != null) {
            root4.setVisibility(8);
        }
        ReadingChapterCommentBinding e10 = c0533a.e();
        LinearLayout root5 = e10 != null ? e10.getRoot() : null;
        if (root5 != null) {
            root5.setVisibility(8);
        }
        ReaderSlideBookCoverLayoutBinding d10 = c0533a.d();
        ReaderBookCoverLayout root6 = d10 != null ? d10.getRoot() : null;
        if (root6 != null) {
            root6.setVisibility(8);
        }
        ReaderSlideBookLastPageLayoutBinding g10 = c0533a.g();
        ReaderBookLastPageLayout root7 = g10 != null ? g10.getRoot() : null;
        if (root7 != null) {
            root7.setVisibility(8);
        }
        LoadingPurchaseBinding i11 = c0533a.i();
        LinearLayout root8 = i11 != null ? i11.getRoot() : null;
        if (root8 != null) {
            root8.setVisibility(8);
        }
        LoadingFailureBinding f10 = c0533a.f();
        LinearLayout root9 = f10 != null ? f10.getRoot() : null;
        if (root9 != null) {
            root9.setVisibility(8);
        }
        ReadingLayoutBinding b19 = c0533a.b();
        ReaderThemeImageView readerThemeImageView = b19 != null ? b19.ivMark : null;
        if (readerThemeImageView != null) {
            readerThemeImageView.setVisibility(8);
        }
        ReadingLayoutBinding b20 = c0533a.b();
        LinearLayout root10 = (b20 == null || (readingContentLayoutBinding2 = b20.llReadingContent) == null) ? null : readingContentLayoutBinding2.getRoot();
        if (root10 != null) {
            root10.setVisibility(4);
        }
        ReadingLayoutBinding b21 = c0533a.b();
        LinearLayout linearLayout = (b21 == null || (readingContentLayoutBinding = b21.llReadingContent) == null) ? null : readingContentLayoutBinding.tvReadingTitleView;
        if (linearLayout != null) {
            linearLayout.setVisibility(o1() ? 8 : 0);
        }
        com.martian.mibook.application.d Z0 = Z0();
        boolean z10 = ((Z0 != null ? Z0.W0() : null) == null || miCursor == null || !miCursor.notAdCursor()) ? false : true;
        ReadingLayoutBinding b22 = c0533a.b();
        ReaderThemeTextView readerThemeTextView5 = (b22 == null || (readingBottomStatusBinding10 = b22.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding10.rbsTvHint;
        if (readerThemeTextView5 != null) {
            readerThemeTextView5.setTag(null);
        }
        ReadingLayoutBinding b23 = c0533a.b();
        LinearLayout root11 = (b23 == null || (readingBottomStatusBinding9 = b23.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding9.getRoot();
        if (root11 != null) {
            if (!o1()) {
                if (miCursor == null || !miCursor.notAdCursor()) {
                    i10 = 4;
                } else {
                    ReadingLayoutBinding b24 = c0533a.b();
                    if (b24 != null && (readingBottomStatusBinding8 = b24.lyReadingBottomStatus) != null && (root = readingBottomStatusBinding8.getRoot()) != null) {
                        root.setBackgroundColor(0);
                    }
                    ReadingLayoutBinding b25 = c0533a.b();
                    LinearLayout linearLayout2 = (b25 == null || (readingBottomStatusBinding7 = b25.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding7.llBottomStatusContent;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    boolean prefShowBottomStatus = T0().getPrefShowBottomStatus();
                    ReadingLayoutBinding b26 = c0533a.b();
                    RelativeLayout relativeLayout = (b26 == null || (readingBottomStatusBinding6 = b26.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding6.batteryView;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(prefShowBottomStatus ? 0 : 4);
                    }
                    ReadingLayoutBinding b27 = c0533a.b();
                    ReaderThemeTextView readerThemeTextView6 = (b27 == null || (readingBottomStatusBinding5 = b27.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding5.rbsTvTime;
                    if (readerThemeTextView6 != null) {
                        readerThemeTextView6.setVisibility(prefShowBottomStatus ? 0 : 4);
                    }
                    ReadingLayoutBinding b28 = c0533a.b();
                    ReaderThemeTextView readerThemeTextView7 = (b28 == null || (readingBottomStatusBinding4 = b28.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding4.rbsTvRightContent;
                    if (readerThemeTextView7 != null) {
                        readerThemeTextView7.setVisibility(prefShowBottomStatus ? 0 : 4);
                    }
                    ReadingLayoutBinding b29 = c0533a.b();
                    ReaderThemeTextView readerThemeTextView8 = (b29 == null || (readingBottomStatusBinding3 = b29.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding3.rbsTvHint;
                    if (readerThemeTextView8 != null) {
                        readerThemeTextView8.setVisibility(T0().getPrefShowBottomTips() ? 0 : 4);
                    }
                    i10 = 0;
                }
            }
            root11.setVisibility(i10);
        }
        boolean z11 = miCursor != null && miCursor.isCurrentPage();
        ReadingLayoutBinding b30 = c0533a.b();
        if (b30 != null && (readingBottomStatusBinding2 = b30.lyReadingBottomStatus) != null && (readerThemeTextView = readingBottomStatusBinding2.rbsTvHint) != null) {
            if (z11) {
                readerThemeTextView.setPaintFlags(readerThemeTextView.getPaintFlags() & (-9));
            }
            readerThemeTextView.setText((MiConfigSingleton.b2().C2() || !ReadingInstance.z().y0(this.f14481d)) ? z10 ? ExtKt.c("下一页将展示广告") : T0().getReadingHint() : this.f14481d.getString(R.string.click_for_ad_block));
        }
        if (z11 && miCursor != null) {
            gd.a a14 = a1();
            if (a14 != null) {
                a14.C(miCursor.withBannerPadding());
            }
            gd.a a15 = a1();
            if (a15 != null) {
                a15.x(miCursor.withFloatMenu());
            }
            this.f14495r = miCursor;
            if (miCursor.notAdCursor()) {
                gd.a a16 = a1();
                if (a16 != null) {
                    a16.s(SlidingLayout.TouchBlockType.DEFAULT);
                }
                com.martian.mibook.application.d Z02 = Z0();
                if (Z02 != null) {
                    Z02.o1(c0533a.a());
                }
                com.martian.mibook.application.d Z03 = Z0();
                if (Z03 != null) {
                    Z03.r1(0L);
                }
            }
            T0().U2(miCursor instanceof MiReadingContent.MiContentCursor, 2);
            gd.a a17 = a1();
            if (a17 != null) {
                a17.f0();
            }
        }
        if (miCursor instanceof MiReadingContent.MiContentCursor) {
            if (t1()) {
                S1(c0533a, (MiReadingContent.MiContentCursor) miCursor);
            } else {
                l2(c0533a, (MiReadingContent.MiContentCursor) miCursor, z11);
            }
        } else if (miCursor instanceof d.C0528d) {
            P1(c0533a, miCursor instanceof d.C0528d ? (d.C0528d) miCursor : null);
        } else if (miCursor instanceof MiReadingContent.MiLoadingCursor) {
            ReadingLayoutBinding b31 = c0533a.b();
            ReaderThemeTextView readerThemeTextView9 = b31 != null ? b31.pbContentLoading : null;
            if (readerThemeTextView9 != null) {
                readerThemeTextView9.setVisibility(0);
            }
            ReadingLayoutBinding b32 = c0533a.b();
            if (b32 != null && (readingBottomStatusBinding = b32.lyReadingBottomStatus) != null) {
                readerThemeTextView3 = readingBottomStatusBinding.rbsTvRightContent;
            }
            if (readerThemeTextView3 != null) {
                readerThemeTextView3.setText("");
            }
        } else if (miCursor instanceof MiReadingContent.MiErrorCursor) {
            m2(c0533a, ((MiReadingContent.MiErrorCursor) miCursor).getReadingContent());
        } else if (miCursor instanceof MiReadingContent.MiOfflineCursor) {
            r2(c0533a, true);
        } else if (miCursor instanceof MiReadingContent.MiBuyingCursor) {
            X1(c0533a, ((MiReadingContent.MiBuyingCursor) miCursor).getReadingContent(), z11);
        } else if (miCursor instanceof MiReadingContent.MiCoverCursor) {
            V1(c0533a);
        } else if (miCursor instanceof MiReadingContent.MiLastPageCursor) {
            r2(c0533a, false);
        }
        return view;
    }

    public final boolean f1(boolean z10, @l MiBookMark miBookMark) {
        MiBookMark miBookMark2;
        ReadingLayoutBinding b10;
        ReadingLayoutBinding b11;
        MiReadingContent.MiCursor miCursor = this.f14495r;
        if (miCursor == null) {
            return false;
        }
        if (!z10 && miBookMark != null) {
            Integer type = miBookMark.getType();
            if (type == null || type.intValue() != 0) {
                ge.d h12 = h1(miBookMark, this.f14485h);
                if (h12 != null) {
                    j1(miBookMark, this.f14485h, h12);
                } else {
                    ge.d h13 = h1(miBookMark, this.f14484g);
                    if (h13 != null) {
                        j1(miBookMark, this.f14484g, h13);
                    } else {
                        ge.d h14 = h1(miBookMark, this.f14486i);
                        if (h14 != null) {
                            j1(miBookMark, this.f14486i, h14);
                        }
                    }
                }
                return true;
            }
            boolean V = T0().V(miBookMark);
            if (V) {
                ge.d g12 = g1(miBookMark, this.f14485h);
                if (g12 != null) {
                    i1(miBookMark, miCursor, this, this.f14485h, g12);
                } else {
                    ge.d g13 = g1(miBookMark, this.f14484g);
                    if (g13 != null) {
                        i1(miBookMark, miCursor, this, this.f14484g, g13);
                    } else {
                        ge.d g14 = g1(miBookMark, this.f14486i);
                        if (g14 != null) {
                            i1(miBookMark, miCursor, this, this.f14486i, g14);
                        }
                    }
                }
            }
            t0.b(this.f14481d, ExtKt.c(V ? "移除书签成功" : "移除书签失败"));
            return V;
        }
        if (T0().getIsScrollMode() || !(miCursor instanceof MiReadingContent.MiContentCursor)) {
            return false;
        }
        MiReadingContent.MiContentCursor miContentCursor = (MiReadingContent.MiContentCursor) miCursor;
        int g10 = miContentCursor.getPageLayout().g();
        int d10 = miContentCursor.getPageLayout().d();
        ReaderThemeImageView readerThemeImageView = null;
        if (!z10) {
            Iterator<Map.Entry<Integer, MiBookMark>> it = miContentCursor.getContent().getBookMarks().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    miBookMark2 = null;
                    break;
                }
                Integer key = it.next().getKey();
                Intrinsics.checkNotNull(key);
                int intValue = key.intValue();
                if (g10 <= intValue && intValue < d10) {
                    miBookMark2 = miContentCursor.getContent().getBookMarks().get(key);
                    break;
                }
            }
            boolean V2 = T0().V(miBookMark2);
            if (V2) {
                Map<Integer, MiBookMark> bookMarks = miContentCursor.getContent().getBookMarks();
                Intrinsics.checkNotNull(miBookMark2);
                bookMarks.remove(miBookMark2.getContentPos());
                miContentCursor.getPageLayout().O(false);
                T0().d2(false);
                View e10 = e();
                Object tag = e10 != null ? e10.getTag() : null;
                a.C0533a c0533a = tag instanceof a.C0533a ? (a.C0533a) tag : null;
                if (c0533a != null && (b10 = c0533a.b()) != null) {
                    readerThemeImageView = b10.ivMark;
                }
                if (readerThemeImageView != null) {
                    readerThemeImageView.setVisibility(8);
                }
            }
            t0.b(this.f14481d, ExtKt.c(V2 ? "移除书签成功" : "移除书签失败"));
            return V2;
        }
        MiReadingContent Q0 = Q0();
        if (g10 < 0 || d10 <= g10) {
            t0.b(this.f14481d, ExtKt.c("添加书签内容为空"));
            return false;
        }
        ac.a.L(this.f14481d, "添加书签");
        int min = (int) Math.min(g10 + 100, d10);
        String pageText = miContentCursor.getPageText();
        if (pageText != null) {
            String substring = pageText.substring(g10, min);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if (substring != null) {
                MiBookMark O = T0().O(T0().getBook(), Q0.getChapter(), Q0.getChapterIndex(), substring, g10, d10);
                boolean z11 = (O == null || O.get_id() == null) ? false : true;
                if (z11) {
                    if (miContentCursor.getContent().getBookMarks() == null) {
                        miContentCursor.getContent().setBookMarks(new LinkedHashMap());
                    }
                    Map<Integer, MiBookMark> bookMarks2 = miContentCursor.getContent().getBookMarks();
                    Intrinsics.checkNotNullExpressionValue(bookMarks2, "getBookMarks(...)");
                    Intrinsics.checkNotNull(O);
                    bookMarks2.put(O.getContentPos(), O);
                    miContentCursor.getPageLayout().O(true);
                    View e11 = e();
                    Object tag2 = e11 != null ? e11.getTag() : null;
                    a.C0533a c0533a2 = tag2 instanceof a.C0533a ? (a.C0533a) tag2 : null;
                    if (c0533a2 != null && (b11 = c0533a2.b()) != null) {
                        readerThemeImageView = b11.ivMark;
                    }
                    if (readerThemeImageView != null) {
                        readerThemeImageView.setVisibility(0);
                    }
                    T0().d2(true);
                }
                t0.b(this.f14481d, ExtKt.c(z11 ? "添加书签成功" : "添加书签失败"));
                return z11;
            }
        }
        return false;
    }

    @SuppressLint({"SetTextI18n"})
    public final void g2(a.C0533a c0533a, CommentCount commentCount, boolean z10) {
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ReaderThemeTextView readerThemeTextView;
        String string;
        ReadingLayoutBinding b10 = c0533a.b();
        if (b10 == null || (readingBottomStatusBinding = b10.lyReadingBottomStatus) == null || (readerThemeTextView = readingBottomStatusBinding.rbsTvHint) == null) {
            return;
        }
        if (z10) {
            readerThemeTextView.setPaintFlags(readerThemeTextView.getPaintFlags() | 8);
        }
        if ((commentCount != null ? commentCount.getNComments() : 0) > 0) {
            string = this.f14481d.getString(R.string.chapter_comments) + "（" + (commentCount != null ? commentCount.getNComments() : 0) + "条）";
        } else {
            string = this.f14481d.getString(R.string.chapter_comment_sofa);
        }
        readerThemeTextView.setText(string);
    }

    @k
    public final FragmentActivity getActivity() {
        return this.f14481d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d1, code lost:
    
        if ((!r8.isEmpty()) == true) goto L446;
     */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h2(com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.a.C0533a r7, com.martian.mibook.ui.reader.page.ReaderPageView r8, com.martian.mibook.data.book.CommentCount r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter.h2(com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter$a$a, com.martian.mibook.ui.reader.page.ReaderPageView, com.martian.mibook.data.book.CommentCount, java.lang.String):void");
    }

    public final void k1(ReaderPageView readerPageView, MiReadingContent.MiCursor miCursor) {
        ReaderPageView E0;
        L2(readerPageView);
        if (readerPageView != null) {
            readerPageView.setOnParagraphCommentClickListener(new ReaderPageView.a() { // from class: cd.r1
                public /* synthetic */ r1() {
                }

                @Override // com.martian.mibook.ui.reader.page.ReaderPageView.a
                public final void a(ReaderPageView readerPageView2, int i10) {
                    ReaderSlidingAdapter.l1(ReaderSlidingAdapter.this, readerPageView2, i10);
                }
            });
        }
        if (readerPageView != null) {
            readerPageView.setActionMenuCallBack(new c());
        }
        if (ConfigSingleton.D().B0()) {
            gd.a a12 = a1();
            int height = (a12 == null || (E0 = a12.E0()) == null) ? 0 : E0.getHeight();
            int height2 = readerPageView != null ? readerPageView.getHeight() : 0;
            if (height == height2 - ((miCursor == null || !miCursor.withBannerPadding()) ? ConfigSingleton.i(64.0f) : 0) || height2 == 0) {
                return;
            }
            throw new IllegalStateException("阅读界面fake布局与content布局不一致" + height + " vs " + (readerPageView != null ? Integer.valueOf(readerPageView.getHeight()) : null));
        }
    }

    public final void l2(a.C0533a c0533a, MiReadingContent.MiContentCursor miContentCursor, boolean z10) {
        String title;
        MiReadingContent content;
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ReadingBottomStatusBinding readingBottomStatusBinding2;
        ReadingContentLayoutBinding readingContentLayoutBinding;
        ReadingContentLayoutBinding readingContentLayoutBinding2;
        ReaderPageView readerPageView;
        ReadingContentLayoutBinding readingContentLayoutBinding3;
        ReaderPageView readerPageView2;
        ReadingBottomStatusBinding readingBottomStatusBinding3;
        ReadingContentLayoutBinding readingContentLayoutBinding4;
        ReadingContentLayoutBinding readingContentLayoutBinding5;
        MiReadingContent content2;
        ReadingContentLayoutBinding readingContentLayoutBinding6;
        ReadingContentLayoutBinding readingContentLayoutBinding7;
        ReadingLayoutBinding b10 = c0533a.b();
        ReaderThemeTextView readerThemeTextView = null;
        r1 = null;
        ReaderPageView readerPageView3 = null;
        readerThemeTextView = null;
        ReaderPageView readerPageView4 = (b10 == null || (readingContentLayoutBinding7 = b10.llReadingContent) == null) ? null : readingContentLayoutBinding7.rtvPage;
        if (readerPageView4 != null) {
            readerPageView4.setTag(miContentCursor);
        }
        ReadingLayoutBinding b11 = c0533a.b();
        LinearLayout root = (b11 == null || (readingContentLayoutBinding6 = b11.llReadingContent) == null) ? null : readingContentLayoutBinding6.getRoot();
        if (root != null) {
            root.setVisibility(0);
        }
        int endPosSize = (miContentCursor == null || (content2 = miContentCursor.getContent()) == null) ? 0 : content2.getEndPosSize();
        if (miContentCursor != null && miContentCursor.getContentIndex() == -1) {
            miContentCursor.setContentIndex(endPosSize - 1);
        } else if (miContentCursor != null && miContentCursor.getContentIndex() == -2) {
            miContentCursor.setContentIndex(0);
        }
        F2(c0533a, miContentCursor);
        ReadingLayoutBinding b12 = c0533a.b();
        J2((b12 == null || (readingContentLayoutBinding5 = b12.llReadingContent) == null) ? null : readingContentLayoutBinding5.rtvPage, miContentCursor);
        if (miContentCursor == null || !miContentCursor.isFirstPage() || TextUtils.isEmpty(T0().e0())) {
            title = (miContentCursor == null || (content = miContentCursor.getContent()) == null) ? null : content.getTitle();
        } else {
            title = "《" + T0().e0() + "》";
        }
        ReadingLayoutBinding b13 = c0533a.b();
        N1((b13 == null || (readingContentLayoutBinding4 = b13.llReadingContent) == null) ? null : readingContentLayoutBinding4.tvReadingTitle, c1(), ExtKt.c(title));
        ReadingLayoutBinding b14 = c0533a.b();
        N1((b14 == null || (readingBottomStatusBinding3 = b14.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding3.rbsTvRightContent, null, Y0(miContentCursor));
        if (miContentCursor != null && miContentCursor.isLastPage() && T0().getShowChapterComment()) {
            e2 O0 = O0();
            CommentCount n10 = O0 != null ? O0.n(miContentCursor.getContent()) : null;
            if (n10 != null) {
                String title2 = miContentCursor.getContent().getTitle();
                ReadingLayoutBinding b15 = c0533a.b();
                int height = (b15 == null || (readingContentLayoutBinding3 = b15.llReadingContent) == null || (readerPageView2 = readingContentLayoutBinding3.rtvPage) == null) ? 0 : readerPageView2.getHeight();
                ReadingLayoutBinding b16 = c0533a.b();
                if (height - ((b16 == null || (readingContentLayoutBinding2 = b16.llReadingContent) == null || (readerPageView = readingContentLayoutBinding2.rtvPage) == null) ? 0 : readerPageView.getLayoutHeight()) >= ConfigSingleton.i(68.0f)) {
                    ReadingLayoutBinding b17 = c0533a.b();
                    if (b17 != null && (readingContentLayoutBinding = b17.llReadingContent) != null) {
                        readerPageView3 = readingContentLayoutBinding.rtvPage;
                    }
                    h2(c0533a, readerPageView3, n10, title2);
                } else {
                    ReadingLayoutBinding b18 = c0533a.b();
                    ReaderThemeTextView readerThemeTextView2 = (b18 == null || (readingBottomStatusBinding2 = b18.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding2.rbsTvHint;
                    if (readerThemeTextView2 != null) {
                        readerThemeTextView2.setTag(miContentCursor);
                    }
                    if (z10) {
                        ReadingLayoutBinding b19 = c0533a.b();
                        if (b19 != null && (readingBottomStatusBinding = b19.lyReadingBottomStatus) != null) {
                            readerThemeTextView = readingBottomStatusBinding.rbsTvHint;
                        }
                        if (readerThemeTextView != null) {
                            readerThemeTextView.setVisibility(0);
                        }
                    }
                    g2(c0533a, n10, z10);
                }
            }
        }
        if (z10) {
            if (T0().getIsFreshUserFirstIn()) {
                T0().E2(false);
                MiConfigSingleton.b2().G1().A(this.f14481d, 0);
            }
            if (miContentCursor != null && miContentCursor.isFirstPage()) {
                u2(true);
                D2();
                gd.a a12 = a1();
                if (a12 != null) {
                    a12.H0();
                    return;
                }
                return;
            }
            if (miContentCursor != null && miContentCursor.isLastPage()) {
                H0(endPosSize);
                this.D = false;
            } else if (T0().getRecordReadType() == RecordReadType.RECORD_HALFWAY) {
                u2(false);
            }
        }
    }

    public final boolean m1() {
        return this.f14485h.isContentError() || this.f14485h.isBuying() || this.f14485h.isUnBounght() || this.f14485h.isPrebuyError() || this.f14485h.isBuyingError();
    }

    public final void m2(a.C0533a c0533a, MiReadingContent miReadingContent) {
        String str;
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ReadingBottomStatusBinding readingBottomStatusBinding2;
        ReaderThemeItemTextView readerThemeItemTextView;
        LinearLayout linearLayout;
        ReaderThemeItemTextView readerThemeItemTextView2;
        ReaderThemeItemTextView readerThemeItemTextView3;
        ViewStub viewStub;
        View inflate;
        if (miReadingContent == null) {
            return;
        }
        ReaderThemeTextView readerThemeTextView = null;
        if (c0533a.f() == null) {
            ReadingLayoutBinding b10 = c0533a.b();
            ViewStub viewStub2 = b10 != null ? b10.loadFailViewStub : null;
            if (viewStub2 != null) {
                viewStub2.setLayoutResource(R.layout.loading_failure);
            }
            ReadingLayoutBinding b11 = c0533a.b();
            c0533a.o((b11 == null || (viewStub = b11.loadFailViewStub) == null || (inflate = viewStub.inflate()) == null) ? null : LoadingFailureBinding.bind(inflate));
        }
        LoadingFailureBinding f10 = c0533a.f();
        LinearLayout root = f10 != null ? f10.getRoot() : null;
        if (root != null) {
            root.setVisibility(0);
        }
        LoadingFailureBinding f11 = c0533a.f();
        if (f11 != null && (readerThemeItemTextView3 = f11.tvFeedback) != null) {
            readerThemeItemTextView3.setOnClickListener(new View.OnClickListener() { // from class: cd.z0
                public /* synthetic */ z0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderSlidingAdapter.n2(ReaderSlidingAdapter.this, view);
                }
            });
        }
        LoadingFailureBinding f12 = c0533a.f();
        if (f12 != null && (readerThemeItemTextView2 = f12.tvRefresh) != null) {
            readerThemeItemTextView2.setOnClickListener(new View.OnClickListener() { // from class: cd.a1

                /* renamed from: c */
                public final /* synthetic */ MiReadingContent f1774c;

                public /* synthetic */ a1(MiReadingContent miReadingContent2) {
                    miReadingContent = miReadingContent2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderSlidingAdapter.o2(ReaderSlidingAdapter.this, miReadingContent, view);
                }
            });
        }
        if (!TextUtils.isEmpty(T0().e0())) {
            LoadingFailureBinding f13 = c0533a.f();
            N1(f13 != null ? f13.tvFailBookName : null, c1(), T0().e0());
        }
        LoadingFailureBinding f14 = c0533a.f();
        if (f14 != null && (linearLayout = f14.tvFailTitleView) != null) {
            linearLayout.setPadding(ConfigSingleton.i(24.0f), b1() + ConfigSingleton.i(12.0f), ConfigSingleton.i(120.0f), ConfigSingleton.i(12.0f));
        }
        LoadingFailureBinding f15 = c0533a.f();
        LinearLayout linearLayout2 = f15 != null ? f15.tvFailTitleView : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(o1() ? 4 : 0);
        }
        LoadingFailureBinding f16 = c0533a.f();
        ReaderThemeTextView readerThemeTextView2 = f16 != null ? f16.tvFailingReadingTitle : null;
        if (readerThemeTextView2 != null) {
            Chapter chapter = miReadingContent2.getChapter();
            readerThemeTextView2.setText(chapter != null ? chapter.getTitle() : null);
        }
        ReaderTypefaceManager i22 = MiConfigSingleton.b2().i2();
        LoadingFailureBinding f17 = c0533a.f();
        i22.t(f17 != null ? f17.tvFailingReadingTitle : null);
        LoadingFailureBinding f18 = c0533a.f();
        ReaderThemeTextView readerThemeTextView3 = f18 != null ? f18.tvFailingReadingTitle : null;
        if (readerThemeTextView3 != null) {
            readerThemeTextView3.setTextSize(ReadingInstance.z().x(this.f14481d) + 6);
        }
        String errMsg = miReadingContent2.getErrMsg();
        if (StringsKt.equals("章节未购买", errMsg, true)) {
            LoadingFailureBinding f19 = c0533a.f();
            ReaderThemeItemTextView readerThemeItemTextView4 = f19 != null ? f19.tvChapterFeedback : null;
            if (readerThemeItemTextView4 != null) {
                readerThemeItemTextView4.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(miReadingContent2.getStackTrace())) {
            str = errMsg;
        } else {
            str = errMsg + "\n" + miReadingContent2.getStackTrace();
        }
        LoadingFailureBinding f20 = c0533a.f();
        if (f20 != null && (readerThemeItemTextView = f20.tvChapterFeedback) != null) {
            readerThemeItemTextView.setOnClickListener(new View.OnClickListener() { // from class: cd.b1

                /* renamed from: c */
                public final /* synthetic */ String f1780c;

                public /* synthetic */ b1(String str2) {
                    str = str2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderSlidingAdapter.p2(ReaderSlidingAdapter.this, str, view);
                }
            });
        }
        if (!TextUtils.isEmpty(errMsg)) {
            LoadingFailureBinding f21 = c0533a.f();
            ReaderThemeTextView readerThemeTextView4 = f21 != null ? f21.tvErrorMsg : null;
            if (readerThemeTextView4 != null) {
                readerThemeTextView4.setText(errMsg);
            }
        }
        ReadingLayoutBinding b12 = c0533a.b();
        ReaderThemeTextView readerThemeTextView5 = (b12 == null || (readingBottomStatusBinding2 = b12.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding2.rbsTvRightContent;
        if (readerThemeTextView5 != null) {
            readerThemeTextView5.setText("");
        }
        ReadingLayoutBinding b13 = c0533a.b();
        if (b13 != null && (readingBottomStatusBinding = b13.lyReadingBottomStatus) != null) {
            readerThemeTextView = readingBottomStatusBinding.rbsTvHint;
        }
        if (readerThemeTextView != null) {
            readerThemeTextView.setText("");
        }
        if (this.f14501x || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f14501x = true;
        G0(str2, false);
    }

    public final boolean n1(int i10) {
        if (!(this.f14495r instanceof MiReadingContent.MiContentCursor) || !this.f14485h.isReady()) {
            return false;
        }
        MiReadingContent.MiCursor miCursor = this.f14495r;
        Intrinsics.checkNotNull(miCursor, "null cannot be cast to non-null type com.martian.mibook.data.book.MiReadingContent.MiContentCursor");
        return ((MiReadingContent.MiContentCursor) miCursor).isPosIn(i10);
    }

    public final boolean o1() {
        return T0().getIsScrollMode();
    }

    @Override // z9.d
    public boolean p() {
        if (this.f14485h.isLoading()) {
            return false;
        }
        if (this.f14485h.isReady()) {
            int i10 = this.f14488k;
            if (i10 == -2) {
                return false;
            }
            if (i10 < this.f14485h.getEndPosSize() - 1) {
                return true;
            }
        }
        int i11 = T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String();
        ChapterList chapterList = T0().getChapterList();
        int count = chapterList != null ? chapterList.getCount() : 0;
        return count > 0 && i11 < count;
    }

    public final boolean p1() {
        Chapter chapter = this.f14485h.getChapter();
        return chapter != null && chapter.isVipChapter();
    }

    @Override // z9.d
    public boolean q() {
        int i10 = T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String();
        if (i10 == -1) {
            return false;
        }
        if (i10 == 0 && T0().U1()) {
            return true;
        }
        if (this.f14485h.isLoading()) {
            return false;
        }
        if (this.f14485h.isReady()) {
            int i11 = this.f14488k;
            if (i11 == -1) {
                return false;
            }
            if (i11 > 0) {
                return true;
            }
        }
        return i10 > 0;
    }

    public final void q1(MiReadingContent miReadingContent) {
        if (T0().getChapterList() == null) {
            T0().S0().observe(this.f14481d, new Observer() { // from class: cd.l1
                public /* synthetic */ l1() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReaderSlidingAdapter.r1(Function1.this, obj);
                }
            });
            T0().W();
        } else {
            A2(miReadingContent);
            u();
        }
    }

    public final void r2(a.C0533a c0533a, boolean z10) {
        ReaderBookLastPageLayout root;
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ViewStub viewStub;
        View inflate;
        if (c0533a.g() == null) {
            ReadingLayoutBinding b10 = c0533a.b();
            ViewStub viewStub2 = b10 != null ? b10.readingLastPageViewStub : null;
            if (viewStub2 != null) {
                viewStub2.setLayoutResource(R.layout.reader_slide_book_last_page_layout);
            }
            ReadingLayoutBinding b11 = c0533a.b();
            c0533a.p((b11 == null || (viewStub = b11.readingLastPageViewStub) == null || (inflate = viewStub.inflate()) == null) ? null : ReaderSlideBookLastPageLayoutBinding.bind(inflate));
        }
        ReadingLayoutBinding b12 = c0533a.b();
        LinearLayout root2 = (b12 == null || (readingBottomStatusBinding = b12.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding.getRoot();
        if (root2 != null) {
            root2.setVisibility(8);
        }
        ReaderSlideBookLastPageLayoutBinding g10 = c0533a.g();
        ReaderBookLastPageLayout root3 = g10 != null ? g10.getRoot() : null;
        if (root3 != null) {
            root3.setVisibility(0);
        }
        ReaderSlideBookLastPageLayoutBinding g11 = c0533a.g();
        if (g11 == null || (root = g11.getRoot()) == null) {
            return;
        }
        root.setView(z10);
    }

    public final void s1(int i10, int i11) {
        com.martian.mibook.application.d Z0 = Z0();
        if (Z0 == null || !Z0.Y0()) {
            if (T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() == i10 && this.f14485h.isReady()) {
                int findContentIndex = this.f14485h.findContentIndex(i11);
                int i12 = this.f14488k;
                if (findContentIndex == i12) {
                    return;
                }
                if (i12 + 1 != findContentIndex) {
                    this.f14488k = findContentIndex;
                    u();
                } else if (!j().getSlider().e()) {
                    j().D(false);
                }
            } else if (T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() + 1 == i10 && this.f14486i.isReady()) {
                if (this.f14486i.findContentIndex(i11) != 0 || !this.f14485h.isReady() || this.f14488k != this.f14485h.getEndPosSize() - 1) {
                    T0().x2(i10);
                    this.f14489l = i11;
                    this.f14488k = -1;
                    F1();
                } else if (!j().getSlider().e()) {
                    j().D(false);
                }
            } else if (T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() - 1 != i10 || !this.f14484g.isReady()) {
                T0().x2(i10);
                this.f14489l = i11;
                this.f14488k = -1;
                F1();
            } else if (this.f14484g.findContentIndex(i11) != this.f14484g.getEndPosSize() - 1 || this.f14488k != 0) {
                T0().x2(i10);
                this.f14489l = i11;
                this.f14488k = -1;
                F1();
            } else if (!j().getSlider().e()) {
                j().E(false);
            }
            B0();
        }
    }

    public final void s2(boolean z10) {
        ReadingBottomStatusBinding readingBottomStatusBinding;
        ReadingBottomStatusBinding readingBottomStatusBinding2;
        ReadingBottomStatusBinding readingBottomStatusBinding3;
        Iterator<a.C0533a> it = this.f14491n.iterator();
        while (it.hasNext()) {
            a.C0533a next = it.next();
            ReadingLayoutBinding b10 = next.b();
            ReaderThemeTextView readerThemeTextView = null;
            RelativeLayout relativeLayout = (b10 == null || (readingBottomStatusBinding3 = b10.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding3.batteryView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(z10 ? 0 : 4);
            }
            ReadingLayoutBinding b11 = next.b();
            ReaderThemeTextView readerThemeTextView2 = (b11 == null || (readingBottomStatusBinding2 = b11.lyReadingBottomStatus) == null) ? null : readingBottomStatusBinding2.rbsTvTime;
            if (readerThemeTextView2 != null) {
                readerThemeTextView2.setVisibility(z10 ? 0 : 4);
            }
            ReadingLayoutBinding b12 = next.b();
            if (b12 != null && (readingBottomStatusBinding = b12.lyReadingBottomStatus) != null) {
                readerThemeTextView = readingBottomStatusBinding.rbsTvRightContent;
            }
            if (readerThemeTextView != null) {
                readerThemeTextView.setVisibility(z10 ? 0 : 4);
            }
        }
    }

    public final boolean t1() {
        return T0().J1() > 0 && T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() >= T0().J1() && !T0().getIsVip() && !MiConfigSingleton.b2().F(T0().getSourceString());
    }

    public final void t2(String str) {
        i.e0(this.f14481d, str, T0().getSourceName(), T0().getSourceId());
    }

    public final void u1() {
        ReadingContentLayoutBinding readingContentLayoutBinding;
        Iterator<a.C0533a> it = this.f14491n.iterator();
        while (it.hasNext()) {
            ReadingLayoutBinding b10 = it.next().b();
            L2((b10 == null || (readingContentLayoutBinding = b10.llReadingContent) == null) ? null : readingContentLayoutBinding.rtvPage);
        }
        A1();
    }

    public final void u2(boolean z10) {
        Map<String, Long> m02;
        Map<String, Long> m03;
        if (T0().c2()) {
            String M0 = M0(null);
            if (!ba.l.q(M0) && (((m02 = T0().m0()) == null || !m02.containsKey(M0)) && (m03 = T0().m0()) != null)) {
                m03.put(M0, Long.valueOf(z10 ? System.currentTimeMillis() : -1L));
            }
            if (T0().getRecordReadType() == RecordReadType.RECORD_HALFWAY) {
                T0().c3(RecordReadType.RECORD);
            }
        }
    }

    @Override // z9.d
    public void v() {
        super.v();
        x2();
        E0();
    }

    public final void v1() {
        Iterator<a.C0533a> it = this.f14491n.iterator();
        while (it.hasNext()) {
            a.C0533a next = it.next();
            if (o1()) {
                ReadingLayoutBinding b10 = next.b();
                LinearLayout root = b10 != null ? b10.getRoot() : null;
                if (root != null) {
                    root.setBackground(null);
                }
            } else {
                ReadingLayoutBinding b11 = next.b();
                M1(b11 != null ? b11.getRoot() : null);
            }
        }
    }

    public final void v2(Chapter chapter, int i10) {
        if (this.f14503z || T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() != i10) {
            return;
        }
        this.f14503z = true;
        i.W(this.f14481d, T0().getBook(), chapter);
    }

    public final void w1() {
        ReadingContentLayoutBinding readingContentLayoutBinding;
        Iterator<a.C0533a> it = this.f14491n.iterator();
        while (it.hasNext()) {
            a.C0533a next = it.next();
            ReadingLayoutBinding b10 = next.b();
            LinearLayout linearLayout = null;
            ReaderPageView readerPageView = (b10 == null || (readingContentLayoutBinding = b10.llReadingContent) == null) ? null : readingContentLayoutBinding.rtvPage;
            ReadingLayoutBinding b11 = next.b();
            if (b11 != null) {
                linearLayout = b11.getRoot();
            }
            M2(readerPageView, linearLayout);
        }
        u();
    }

    public final void w2() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(T0()), Dispatchers.getDefault(), null, new ReaderSlidingAdapter$startUpdatingClock$1(this, null), 2, null);
        this.f14496s = launch$default;
    }

    public final void x1(CommentCount commentCount, String str, boolean z10) {
        e2 O0 = O0();
        if (O0 != null) {
            O0.r(commentCount, str, z10);
        }
    }

    public final void x2() {
        Job job = this.f14496s;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f14496s = null;
    }

    public final void y0(MiReadingContent miReadingContent, Chapter chapter, boolean z10) {
        if (miReadingContent != null) {
            miReadingContent.setBuying();
        }
        MiConfigSingleton.b2().M1().i(this.f14481d, T0().getBook(), chapter, miReadingContent != null ? miReadingContent.getChapterContent() : null, z10, new b(miReadingContent, this));
    }

    public final synchronized void y1(MiReadingContent miReadingContent) {
        if (miReadingContent != null) {
            try {
                if (T0().getChapterList() != null) {
                    ChapterList chapterList = T0().getChapterList();
                    if ((chapterList != null ? chapterList.getCount() : 0) > 0 && miReadingContent.isLoading()) {
                        miReadingContent.setReady();
                        if (miReadingContent == this.f14485h) {
                            int i10 = this.f14489l;
                            if (i10 >= 0) {
                                this.f14488k = miReadingContent.findContentIndex(i10);
                                this.f14489l = -1;
                            }
                            if (this.f14488k >= miReadingContent.getEndPosSize()) {
                                this.f14488k = miReadingContent.getEndPosSize() - 1;
                            }
                            int i11 = this.f14488k;
                            if (i11 == -2) {
                                this.f14488k = 0;
                            } else if (i11 == -1) {
                                if (!miReadingContent.isStartFromFirstPage() && !o1()) {
                                    this.f14488k = miReadingContent.getEndPosSize() - 1;
                                }
                                this.f14488k = 0;
                                miReadingContent.setStartFromFirstPage(false);
                            }
                            u();
                        }
                    }
                }
            } finally {
            }
        }
    }

    public final synchronized void y2(MiReadingContent miReadingContent) {
        try {
            gd.a a12 = a1();
            List<ge.d> list = null;
            ReaderPageView E0 = a12 != null ? a12.E0() : null;
            if (E0 != null && E0.getHeight() == 0) {
                E0.postDelayed(new Runnable() { // from class: cd.q1

                    /* renamed from: c */
                    public final /* synthetic */ MiReadingContent f1873c;

                    public /* synthetic */ q1(MiReadingContent miReadingContent2) {
                        miReadingContent = miReadingContent2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        ReaderSlidingAdapter.z2(ReaderSlidingAdapter.this, miReadingContent);
                    }
                }, 10L);
                return;
            }
            if (miReadingContent2 != null) {
                miReadingContent2.clearEndPos();
            }
            if (miReadingContent2 != null) {
                miReadingContent2.setBookMarkList(MiConfigSingleton.b2().M1().U(T0().getSourceString(), miReadingContent2.getChapter()));
            }
            if (miReadingContent2 != null) {
                ge.b V0 = V0();
                if (V0 != null) {
                    String title = miReadingContent2.getTitle();
                    ChapterContent chapterContent = miReadingContent2.getChapterContent();
                    list = V0.e(title, chapterContent != null ? chapterContent.getContent() : null, miReadingContent2.getBookMarks());
                }
                miReadingContent2.setPageLayouts(list);
            }
            if (miReadingContent2 != null) {
                miReadingContent2.setBookUnderlines(MiConfigSingleton.b2().M1().V(T0().getSourceString(), miReadingContent2.getChapter()));
            }
            y1(miReadingContent2);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean z0() {
        if (T0().u3(this.f14481d)) {
            return false;
        }
        if (T0().getAdBook()) {
            return true;
        }
        MiReadingContent Q0 = Q0();
        return Q0.getChapter() == null || !Q0.getChapter().isVipChapter();
    }

    public final void z1() {
        int i10 = T0().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String() + 1;
        if (!this.f14486i.isEmpty() || i10 >= N0()) {
            return;
        }
        this.f14486i.setChapterIndex(i10);
        this.f14486i.setChapter(L0(i10));
        A2(this.f14486i);
    }
}
