package com.martian.mibook.mvvm.tts.fragment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.m;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.libmars.widget.DownLoadButton;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.MartianDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.libmars.widget.scroller.FastScrollRecyclerView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogAudioBookChapterListBinding;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.viewmodel.CacheStatus;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.tts.activity.AudiobookActivity;
import com.martian.mibook.mvvm.tts.adapter.AudiobookChapterAdapter;
import com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.martian.mibook.mvvm.widget.SmartScrollLayoutManager;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import l9.t0;
import lc.b;
import xi.k;
import xi.l;
import ya.b1;
import ya.s;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ1\u0010!\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b#\u0010\u001bJ\u0019\u0010$\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b$\u0010\u001bJ#\u0010'\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b)\u0010\u001bJ!\u0010+\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00107R\u0016\u0010;\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010A\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010G¨\u0006L"}, d2 = {"Lcom/martian/mibook/mvvm/tts/fragment/AudiobookChapterListFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "Lya/b1$b;", "<init>", "()V", "", "h0", "f0", "e0", "v0", "u0", "", "start", "z0", "(I)V", bq.f10843g, "q0", "t0", "r0", "Landroid/view/View;", "view", "p", "(Landroid/view/View;)Landroid/view/View;", "onDestroy", "Lcom/martian/mibook/lib/model/data/abs/Book;", "book", "f", "(Lcom/martian/mibook/lib/model/data/abs/Book;)V", "c", "index", "size", "", "cachedBefore", "h", "(Lcom/martian/mibook/lib/model/data/abs/Book;IIZ)V", "a", "i", "Lx8/c;", "errorResult", "d", "(Lcom/martian/mibook/lib/model/data/abs/Book;Lx8/c;)V", com.kwad.sdk.m.e.TAG, "failedSize", "g", "(Lcom/martian/mibook/lib/model/data/abs/Book;I)V", "Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter;", "Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter;", "chapterListAdapter", "Lcom/martian/mibook/databinding/DialogAudioBookChapterListBinding;", "Lcom/martian/mibook/databinding/DialogAudioBookChapterListBinding;", "binding", "Lya/s;", "Lya/s;", "videoAdManager", "Lcom/martian/libmars/widget/dialog/MartianDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianDialogFragment;", "cacheAdsDialogFragment", "j", "Z", "isAutoPause", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "k", "Lkotlin/Lazy;", "g0", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Lcom/martian/mibook/mvvm/read/viewmodel/CacheStatus;", t.f11204d, "Lcom/martian/mibook/mvvm/read/viewmodel/CacheStatus;", "mCacheStatus", "m", "I", "cacheIndex", "n", "cacheStartIndex", "o", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AudiobookChapterListFragment extends MartianBottomSheetDialogFragment implements b1.b {

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: p */
    @k
    public static final String f15147p = "AudioBookChapterListFragment";

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public AudiobookChapterAdapter chapterListAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public DialogAudioBookChapterListBinding binding;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public s videoAdManager;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public MartianDialogFragment cacheAdsDialogFragment;

    /* renamed from: j, reason: from kotlin metadata */
    public boolean isAutoPause;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$appViewModel$2
        public AudiobookChapterListFragment$appViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return b.a(AudiobookChapterListFragment.this.getActivity());
        }
    });

    /* renamed from: l */
    @k
    public CacheStatus mCacheStatus = CacheStatus.None;

    /* renamed from: m, reason: from kotlin metadata */
    public int cacheIndex;

    /* renamed from: n, reason: from kotlin metadata */
    public int cacheStartIndex;

    /* renamed from: com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$a$a */
        public static final class C0542a implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                boolean A0 = MiConfigSingleton.b2().A0();
                com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@k FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            a10.k0(true).j0(true).n0(m.h(activity) - ConfigSingleton.i(88.0f)).s0(new C0542a());
            a10.c0(activity, new AudiobookChapterListFragment(), AudiobookChapterListFragment.f15147p, true);
        }

        public Companion() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15157a;

        static {
            int[] iArr = new int[ReadAloudBook.ReadAloudPlayerStatus.values().length];
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15157a = iArr;
        }
    }

    public static final class c implements AudiobookChapterAdapter.a {
        public c() {
        }

        @Override // com.martian.mibook.mvvm.tts.adapter.AudiobookChapterAdapter.a
        public void a(int i10) {
            Context context = AudiobookChapterListFragment.this.getContext();
            if (context != null) {
                AudiobookChapterAdapter audiobookChapterAdapter = AudiobookChapterListFragment.this.chapterListAdapter;
                if (audiobookChapterAdapter != null) {
                    audiobookChapterAdapter.z(i10);
                }
                TTSReadManager.f(context, i10, 0);
            }
        }
    }

    public static final class d implements s.b {

        /* renamed from: b */
        public final /* synthetic */ AudiobookActivity f15160b;

        public d(AudiobookActivity audiobookActivity) {
            this.f15160b = audiobookActivity;
        }

        @Override // ya.s.b
        public void a() {
            MartianDialogFragment martianDialogFragment = AudiobookChapterListFragment.this.cacheAdsDialogFragment;
            if (martianDialogFragment != null) {
                martianDialogFragment.dismiss();
            }
            if (TTSReadManager.p()) {
                AudiobookChapterListFragment.this.isAutoPause = true;
                TTSReadManager.d(this.f15160b);
            }
        }

        @Override // ya.s.b
        public void onRewardVerify(boolean z10) {
            if (AudiobookChapterListFragment.this.isAutoPause) {
                TTSReadManager.h(this.f15160b);
            }
            AudiobookChapterListFragment.this.isAutoPause = false;
            if (z10) {
                AudiobookChapterListFragment audiobookChapterListFragment = AudiobookChapterListFragment.this;
                audiobookChapterListFragment.z0(audiobookChapterListFragment.cacheIndex);
            }
        }
    }

    public static final class e implements MartianDialogFragment.b {
        @Override // com.martian.libmars.widget.dialog.MartianDialogFragment.b
        public void a(@k DialogFragment dialogFragment) {
            Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
            boolean A0 = MiConfigSingleton.b2().A0();
            com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
        }
    }

    private final AppViewModel g0() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    private final void h0() {
        MutableLiveData<Unit> h02;
        DownLoadButton downLoadButton;
        DownLoadButton downLoadButton2;
        LoadingTip loadingTip;
        BookCoverImageView bookCoverImageView;
        ThemeTextView themeTextView;
        LinearLayout linearLayout;
        FloatingActionButton floatingActionButton;
        FastScrollRecyclerView fastScrollRecyclerView;
        FastScrollRecyclerView fastScrollRecyclerView2;
        Context context = getContext();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
        MiBookManager.u1(context, a10, dialogAudioBookChapterListBinding != null ? dialogAudioBookChapterListBinding.ivBookCover : null);
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2 = this.binding;
        ThemeTextView themeTextView2 = dialogAudioBookChapterListBinding2 != null ? dialogAudioBookChapterListBinding2.tvBookName : null;
        if (themeTextView2 != null) {
            Book a11 = readAloudBook.a();
            themeTextView2.setText(ExtKt.c(a11 != null ? a11.getBookName() : null));
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding3 = this.binding;
        ThemeTextView themeTextView3 = dialogAudioBookChapterListBinding3 != null ? dialogAudioBookChapterListBinding3.tvBookDes : null;
        if (themeTextView3 != null) {
            Book a12 = readAloudBook.a();
            themeTextView3.setText(ExtKt.c(a12 != null ? a12.getBookInfo() : null));
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding4 = this.binding;
        ThemeTextView themeTextView4 = dialogAudioBookChapterListBinding4 != null ? dialogAudioBookChapterListBinding4.dirNumbers : null;
        if (themeTextView4 != null) {
            themeTextView4.setText(ExtKt.c(readAloudBook.k()));
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding5 = this.binding;
        FastScrollRecyclerView fastScrollRecyclerView3 = dialogAudioBookChapterListBinding5 != null ? dialogAudioBookChapterListBinding5.rvChapterList : null;
        if (fastScrollRecyclerView3 != null) {
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2);
            fastScrollRecyclerView3.setLayoutManager(new SmartScrollLayoutManager(context2, 0, false, 6, null));
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding6 = this.binding;
        if (dialogAudioBookChapterListBinding6 != null && (fastScrollRecyclerView2 = dialogAudioBookChapterListBinding6.rvChapterList) != null) {
            fastScrollRecyclerView2.setHandleDrawable(R.drawable.icon_fastscroll_day);
        }
        this.chapterListAdapter = new AudiobookChapterAdapter();
        t0();
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding7 = this.binding;
        if (dialogAudioBookChapterListBinding7 != null && (fastScrollRecyclerView = dialogAudioBookChapterListBinding7.rvChapterList) != null) {
            fastScrollRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment$initData$1
                public AudiobookChapterListFragment$initData$1() {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@k RecyclerView recyclerView, int newState) {
                    DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding8;
                    FloatingActionButton floatingActionButton2;
                    DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding9;
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState != 0) {
                        if (newState == 1 || newState == 2) {
                            dialogAudioBookChapterListBinding9 = AudiobookChapterListFragment.this.binding;
                            floatingActionButton2 = dialogAudioBookChapterListBinding9 != null ? dialogAudioBookChapterListBinding9.floatingAction : null;
                            if (floatingActionButton2 == null) {
                                return;
                            }
                            floatingActionButton2.setAlpha(0.4f);
                            return;
                        }
                        return;
                    }
                    dialogAudioBookChapterListBinding8 = AudiobookChapterListFragment.this.binding;
                    floatingActionButton2 = dialogAudioBookChapterListBinding8 != null ? dialogAudioBookChapterListBinding8.floatingAction : null;
                    if (floatingActionButton2 != null) {
                        floatingActionButton2.setAlpha(1.0f);
                    }
                    AudiobookChapterAdapter audiobookChapterAdapter = AudiobookChapterListFragment.this.chapterListAdapter;
                    if (audiobookChapterAdapter != null) {
                        AudiobookChapterAdapter.q(audiobookChapterAdapter, recyclerView, 0L, 2, null);
                    }
                }
            });
        }
        AudiobookChapterAdapter audiobookChapterAdapter = this.chapterListAdapter;
        if (audiobookChapterAdapter != null) {
            audiobookChapterAdapter.B(new c());
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding8 = this.binding;
        if (dialogAudioBookChapterListBinding8 != null && (floatingActionButton = dialogAudioBookChapterListBinding8.floatingAction) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: md.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterListFragment.i0(AudiobookChapterListFragment.this, view);
                }
            });
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding9 = this.binding;
        FastScrollRecyclerView fastScrollRecyclerView4 = dialogAudioBookChapterListBinding9 != null ? dialogAudioBookChapterListBinding9.rvChapterList : null;
        if (fastScrollRecyclerView4 != null) {
            fastScrollRecyclerView4.setAdapter(this.chapterListAdapter);
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding10 = this.binding;
        if (dialogAudioBookChapterListBinding10 != null && (linearLayout = dialogAudioBookChapterListBinding10.dirCategoryView) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: md.c
                public /* synthetic */ c() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterListFragment.j0(AudiobookChapterListFragment.this, view);
                }
            });
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding11 = this.binding;
        if (dialogAudioBookChapterListBinding11 != null && (themeTextView = dialogAudioBookChapterListBinding11.tvBookName) != null) {
            themeTextView.setOnClickListener(new View.OnClickListener() { // from class: md.d
                public /* synthetic */ d() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterListFragment.k0(AudiobookChapterListFragment.this, view);
                }
            });
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding12 = this.binding;
        if (dialogAudioBookChapterListBinding12 != null && (bookCoverImageView = dialogAudioBookChapterListBinding12.ivBookCover) != null) {
            bookCoverImageView.setOnClickListener(new View.OnClickListener() { // from class: md.e
                public /* synthetic */ e() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterListFragment.l0(AudiobookChapterListFragment.this, view);
                }
            });
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding13 = this.binding;
        if (dialogAudioBookChapterListBinding13 != null && (loadingTip = dialogAudioBookChapterListBinding13.loadedTip) != null) {
            loadingTip.setBackgroundType(-1);
        }
        p0();
        TTSReadManager.v(this, new Observer() { // from class: md.f
            public /* synthetic */ f() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookChapterListFragment.m0(AudiobookChapterListFragment.this, (ReadAloudBook.ReadAloudPlayerStatus) obj);
            }
        });
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding14 = this.binding;
        if (dialogAudioBookChapterListBinding14 != null && (downLoadButton2 = dialogAudioBookChapterListBinding14.downloadBtn) != null) {
            downLoadButton2.setStateText(CollectionsKt.arrayListOf(ExtKt.c("下载"), ExtKt.c("暂停"), ExtKt.c("继续"), ExtKt.c("已缓存")));
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding15 = this.binding;
        if (dialogAudioBookChapterListBinding15 != null && (downLoadButton = dialogAudioBookChapterListBinding15.downloadBtn) != null) {
            downLoadButton.setOnClickListener(new View.OnClickListener() { // from class: md.g
                public /* synthetic */ g() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterListFragment.n0(AudiobookChapterListFragment.this, view);
                }
            });
        }
        AppViewModel g02 = g0();
        if (g02 == null || (h02 = g02.h0()) == null) {
            return;
        }
        h02.observe(this, new Observer() { // from class: md.h
            public /* synthetic */ h() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookChapterListFragment.o0(Function1.this, obj);
            }
        });
    }

    public static final void i0(AudiobookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r0();
    }

    public static final void j0(AudiobookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q0();
    }

    public static final void k0(AudiobookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.H(this$0.getActivity(), ReadAloudBook.f15003a.a());
    }

    public static final void l0(AudiobookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.H(this$0.getActivity(), ReadAloudBook.f15003a.a());
    }

    public static final void m0(AudiobookChapterListFragment this$0, ReadAloudBook.ReadAloudPlayerStatus readAloudPlayerStatus) {
        AudiobookChapterAdapter audiobookChapterAdapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i10 = readAloudPlayerStatus == null ? -1 : b.f15157a[readAloudPlayerStatus.ordinal()];
        if ((i10 == 1 || i10 == 2) && (audiobookChapterAdapter = this$0.chapterListAdapter) != null) {
            AudiobookChapterAdapter.A(audiobookChapterAdapter, 0, 1, null);
        }
    }

    public static final void n0(AudiobookChapterListFragment this$0, View view) {
        DownLoadButton downLoadButton;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this$0.binding;
        if (dialogAudioBookChapterListBinding == null || (downLoadButton = dialogAudioBookChapterListBinding.downloadBtn) == null || downLoadButton.getMCurrentState() != DownLoadButton.INSTANCE.a()) {
            return;
        }
        this$0.f0();
    }

    public static final void o0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void q0() {
        ThemeTextView themeTextView;
        ThemeImageView themeImageView;
        FastScrollRecyclerView fastScrollRecyclerView;
        ThemeImageView themeImageView2;
        FastScrollRecyclerView fastScrollRecyclerView2;
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
        RecyclerView.LayoutManager layoutManager = (dialogAudioBookChapterListBinding == null || (fastScrollRecyclerView2 = dialogAudioBookChapterListBinding.rvChapterList) == null) ? null : fastScrollRecyclerView2.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        AudiobookChapterAdapter audiobookChapterAdapter = this.chapterListAdapter;
        if (audiobookChapterAdapter == null || !audiobookChapterAdapter.getIsReverseOrder()) {
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2 = this.binding;
            themeTextView = dialogAudioBookChapterListBinding2 != null ? dialogAudioBookChapterListBinding2.dirCategory : null;
            if (themeTextView != null) {
                themeTextView.setText(getString(com.martian.mibook.R.string.sequence_positive));
            }
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding3 = this.binding;
            if (dialogAudioBookChapterListBinding3 != null && (themeImageView = dialogAudioBookChapterListBinding3.dirCategoryIconLeft) != null) {
                themeImageView.setImageResource(com.martian.mibook.R.drawable.reader_icon_order_up);
            }
            AudiobookChapterAdapter audiobookChapterAdapter2 = this.chapterListAdapter;
            if (audiobookChapterAdapter2 != null) {
                audiobookChapterAdapter2.C(true);
            }
            linearLayoutManager.setReverseLayout(true);
            linearLayoutManager.setStackFromEnd(true);
        } else {
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding4 = this.binding;
            themeTextView = dialogAudioBookChapterListBinding4 != null ? dialogAudioBookChapterListBinding4.dirCategory : null;
            if (themeTextView != null) {
                themeTextView.setText(getString(com.martian.mibook.R.string.sequence_negative));
            }
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding5 = this.binding;
            if (dialogAudioBookChapterListBinding5 != null && (themeImageView2 = dialogAudioBookChapterListBinding5.dirCategoryIconLeft) != null) {
                themeImageView2.setImageResource(com.martian.mibook.R.drawable.reader_icon_order_down);
            }
            AudiobookChapterAdapter audiobookChapterAdapter3 = this.chapterListAdapter;
            if (audiobookChapterAdapter3 != null) {
                audiobookChapterAdapter3.C(false);
            }
            linearLayoutManager.setReverseLayout(false);
            linearLayoutManager.setStackFromEnd(false);
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding6 = this.binding;
        if (dialogAudioBookChapterListBinding6 == null || (fastScrollRecyclerView = dialogAudioBookChapterListBinding6.rvChapterList) == null) {
            return;
        }
        fastScrollRecyclerView.requestLayout();
    }

    public final void r0() {
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding;
        FastScrollRecyclerView fastScrollRecyclerView;
        if (this.chapterListAdapter == null || (dialogAudioBookChapterListBinding = this.binding) == null || (fastScrollRecyclerView = dialogAudioBookChapterListBinding.rvChapterList) == null) {
            return;
        }
        fastScrollRecyclerView.post(new Runnable() { // from class: md.i
            public /* synthetic */ i() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AudiobookChapterListFragment.s0(AudiobookChapterListFragment.this);
            }
        });
    }

    public static final void s0(AudiobookChapterListFragment this$0) {
        FastScrollRecyclerView fastScrollRecyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int c10 = ReadAloudBook.f15003a.c();
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this$0.binding;
        if (dialogAudioBookChapterListBinding == null || (fastScrollRecyclerView = dialogAudioBookChapterListBinding.rvChapterList) == null) {
            return;
        }
        fastScrollRecyclerView.smoothScrollToPosition(c10);
    }

    public final void t0() {
        FloatingActionButton floatingActionButton;
        int n10 = ConfigSingleton.D().n();
        int argb = Color.argb(128, Color.red(n10), Color.green(n10), Color.blue(n10));
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
        Drawable drawable = null;
        FloatingActionButton floatingActionButton2 = dialogAudioBookChapterListBinding != null ? dialogAudioBookChapterListBinding.floatingAction : null;
        if (floatingActionButton2 != null) {
            floatingActionButton2.setBackgroundTintList(ColorStateList.valueOf(argb));
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2 = this.binding;
        if (dialogAudioBookChapterListBinding2 != null && (floatingActionButton = dialogAudioBookChapterListBinding2.floatingAction) != null) {
            drawable = floatingActionButton.getDrawable();
        }
        if (drawable == null) {
            return;
        }
        drawable.setColorFilter(new PorterDuffColorFilter(ConfigSingleton.D().h0(), PorterDuff.Mode.SRC_ATOP));
    }

    private final void v0() {
        MartianDialogFragment martianDialogFragment = this.cacheAdsDialogFragment;
        if (martianDialogFragment == null || martianDialogFragment == null || !martianDialogFragment.isVisible()) {
            com.martian.libmars.widget.dialog.b a10 = MartianDialogFragment.INSTANCE.a();
            View inflate = getLayoutInflater().inflate(com.martian.mibook.R.layout.fragment_audio_book_cache_ads_dialog, (ViewGroup) null);
            ((ImageView) inflate.findViewById(com.martian.mibook.R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: md.j
                public /* synthetic */ j() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterListFragment.x0(AudiobookChapterListFragment.this, view);
                }
            });
            ((TextView) inflate.findViewById(com.martian.mibook.R.id.tv_activate_vip)).setOnClickListener(new View.OnClickListener() { // from class: md.k
                public /* synthetic */ k() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterListFragment.y0(AudiobookChapterListFragment.this, view);
                }
            });
            ((RelativeLayout) inflate.findViewById(com.martian.mibook.R.id.rl_show_ad)).setOnClickListener(new View.OnClickListener() { // from class: md.b

                /* renamed from: b */
                public final /* synthetic */ ProgressBar f28621b;

                /* renamed from: c */
                public final /* synthetic */ AudiobookChapterListFragment f28622c;

                public /* synthetic */ b(ProgressBar progressBar, AudiobookChapterListFragment this) {
                    progressBar = progressBar;
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterListFragment.w0(progressBar, this, view);
                }
            });
            this.cacheAdsDialogFragment = com.martian.libmars.widget.dialog.b.G(a10.Q(inflate).I(false).J(false).P(R.style.MartianDialogFragmentFullScreenStyle).M(new e()), this, null, "audio_book_cache_ads_dialog", false, 10, null);
        }
    }

    public static final void w0(ProgressBar progressBar, AudiobookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (progressBar == null || progressBar.getVisibility() != 4) {
            return;
        }
        progressBar.setVisibility(0);
        this$0.u0();
    }

    public static final void x0(AudiobookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.cacheAdsDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
    }

    public static final void y0(AudiobookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.cacheAdsDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
        FragmentActivity activity = this$0.getActivity();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        String sourceName = a10 != null ? a10.getSourceName() : null;
        Book a11 = readAloudBook.a();
        i.e0(activity, "听书-缓存", sourceName, a11 != null ? a11.getSourceId() : null);
    }

    @Override // ya.b1.b
    public void a(@l Book book) {
        DownLoadButton downLoadButton;
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
        if (dialogAudioBookChapterListBinding != null && (downLoadButton = dialogAudioBookChapterListBinding.downloadBtn) != null) {
            downLoadButton.setState(DownLoadButton.INSTANCE.a());
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2 = this.binding;
        DownLoadButton downLoadButton2 = dialogAudioBookChapterListBinding2 != null ? dialogAudioBookChapterListBinding2.downloadBtn : null;
        if (downLoadButton2 != null) {
            downLoadButton2.setAlpha(1.0f);
        }
        t0.b(getContext(), "缓存取消");
    }

    @Override // ya.b1.b
    public void c(@l Book book) {
    }

    @Override // ya.b1.b
    public void d(@l Book book, @l x8.c errorResult) {
        DownLoadButton downLoadButton;
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
        if (dialogAudioBookChapterListBinding != null && (downLoadButton = dialogAudioBookChapterListBinding.downloadBtn) != null) {
            downLoadButton.setState(DownLoadButton.INSTANCE.a());
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2 = this.binding;
        DownLoadButton downLoadButton2 = dialogAudioBookChapterListBinding2 != null ? dialogAudioBookChapterListBinding2.downloadBtn : null;
        if (downLoadButton2 != null) {
            downLoadButton2.setAlpha(1.0f);
        }
        t0.b(getContext(), "缓存失败");
    }

    @Override // ya.b1.b
    public void e(@l Book book) {
        DownLoadButton downLoadButton;
        DownLoadButton downLoadButton2;
        ChapterList d10 = ReadAloudBook.f15003a.d();
        if ((d10 != null ? d10.getCount() : 0) > this.cacheIndex + 1) {
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
            if (dialogAudioBookChapterListBinding != null && (downLoadButton2 = dialogAudioBookChapterListBinding.downloadBtn) != null) {
                downLoadButton2.setState(DownLoadButton.INSTANCE.a());
            }
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2 = this.binding;
            DownLoadButton downLoadButton3 = dialogAudioBookChapterListBinding2 != null ? dialogAudioBookChapterListBinding2.downloadBtn : null;
            if (downLoadButton3 != null) {
                downLoadButton3.setAlpha(1.0f);
            }
            t0.b(getContext(), (this.cacheStartIndex + 1) + "至" + (this.cacheIndex + 1) + "章节缓存完成");
        } else {
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding3 = this.binding;
            if (dialogAudioBookChapterListBinding3 != null && (downLoadButton = dialogAudioBookChapterListBinding3.downloadBtn) != null) {
                downLoadButton.setState(DownLoadButton.INSTANCE.c());
            }
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding4 = this.binding;
            DownLoadButton downLoadButton4 = dialogAudioBookChapterListBinding4 != null ? dialogAudioBookChapterListBinding4.downloadBtn : null;
            if (downLoadButton4 != null) {
                downLoadButton4.setAlpha(0.4f);
            }
            t0.b(getContext(), "全部章节已缓存");
        }
        AudiobookChapterAdapter audiobookChapterAdapter = this.chapterListAdapter;
        if (audiobookChapterAdapter != null) {
            audiobookChapterAdapter.r(this.cacheStartIndex, this.cacheIndex);
        }
        AudiobookChapterAdapter audiobookChapterAdapter2 = this.chapterListAdapter;
        if (audiobookChapterAdapter2 != null) {
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding5 = this.binding;
            audiobookChapterAdapter2.p(dialogAudioBookChapterListBinding5 != null ? dialogAudioBookChapterListBinding5.rvChapterList : null, 500L);
        }
    }

    public final void e0() {
        MiBookManager M1 = MiConfigSingleton.b2().M1();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        if (M1.i0(a10 != null ? a10.getSourceString() : null)) {
            return;
        }
        MiConfigSingleton.b2().M1().g(getActivity(), readAloudBook.a());
        t0.b(getContext(), "已自动将本书加入书架");
    }

    @Override // ya.b1.b
    public void f(@l Book book) {
    }

    public final void f0() {
        YWChapter yWChapter;
        Integer vipflag;
        Integer freeStatus;
        Book a10;
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        if (readAloudBook.d() == null) {
            return;
        }
        if (readAloudBook.a() != null && (a10 = readAloudBook.a()) != null && a10.isLocal()) {
            t0.b(getContext(), "本地书籍不支持缓存");
            return;
        }
        ChapterList d10 = readAloudBook.d();
        int i10 = 0;
        if (d10 != null && readAloudBook.c() >= 0 && d10.getCount() != 0) {
            i10 = readAloudBook.c() < d10.getCount() ? readAloudBook.c() : d10.getCount() - 1;
        }
        ChapterList d11 = readAloudBook.d();
        Chapter item = d11 != null ? d11.getItem(i10) : null;
        if (item != null && (item instanceof YWChapter) && (vipflag = (yWChapter = (YWChapter) item).getVipflag()) != null && vipflag.intValue() == 1 && (freeStatus = yWChapter.getFreeStatus()) != null && freeStatus.intValue() == 0) {
            t0.b(getContext(), "限免书籍不支持缓存");
            return;
        }
        this.cacheIndex = i10;
        if (!MiConfigSingleton.b2().K2() && !MiConfigSingleton.b2().B0() && !MiConfigSingleton.b2().C2()) {
            v0();
        } else {
            e0();
            z0(this.cacheIndex);
        }
    }

    @Override // ya.b1.b
    public void g(@l Book book, int failedSize) {
        DownLoadButton downLoadButton;
        DownLoadButton downLoadButton2;
        ChapterList d10 = ReadAloudBook.f15003a.d();
        if ((d10 != null ? d10.getCount() : 0) > this.cacheIndex + 1) {
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
            if (dialogAudioBookChapterListBinding != null && (downLoadButton2 = dialogAudioBookChapterListBinding.downloadBtn) != null) {
                downLoadButton2.setState(DownLoadButton.INSTANCE.a());
            }
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2 = this.binding;
            DownLoadButton downLoadButton3 = dialogAudioBookChapterListBinding2 != null ? dialogAudioBookChapterListBinding2.downloadBtn : null;
            if (downLoadButton3 != null) {
                downLoadButton3.setAlpha(1.0f);
            }
            t0.b(getContext(), (this.cacheStartIndex + 1) + "至" + (this.cacheIndex + 1) + "章节缓存完成");
        } else {
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding3 = this.binding;
            if (dialogAudioBookChapterListBinding3 != null && (downLoadButton = dialogAudioBookChapterListBinding3.downloadBtn) != null) {
                downLoadButton.setState(DownLoadButton.INSTANCE.c());
            }
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding4 = this.binding;
            DownLoadButton downLoadButton4 = dialogAudioBookChapterListBinding4 != null ? dialogAudioBookChapterListBinding4.downloadBtn : null;
            if (downLoadButton4 != null) {
                downLoadButton4.setAlpha(0.4f);
            }
            t0.b(getContext(), "全部章节已缓存");
        }
        AudiobookChapterAdapter audiobookChapterAdapter = this.chapterListAdapter;
        if (audiobookChapterAdapter != null) {
            audiobookChapterAdapter.r(this.cacheStartIndex, this.cacheIndex);
        }
        AudiobookChapterAdapter audiobookChapterAdapter2 = this.chapterListAdapter;
        if (audiobookChapterAdapter2 != null) {
            DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding5 = this.binding;
            audiobookChapterAdapter2.p(dialogAudioBookChapterListBinding5 != null ? dialogAudioBookChapterListBinding5.rvChapterList : null, 500L);
        }
    }

    @Override // ya.b1.b
    public void h(@l Book book, int index, int size, boolean cachedBefore) {
        this.cacheIndex = index;
        double d10 = ((index + 1) / size) * 100;
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
        DownLoadButton downLoadButton = dialogAudioBookChapterListBinding != null ? dialogAudioBookChapterListBinding.downloadBtn : null;
        if (downLoadButton == null) {
            return;
        }
        downLoadButton.setProgress((int) d10);
    }

    @Override // ya.b1.b
    public void i(@l Book book) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MartianDialogFragment martianDialogFragment = this.cacheAdsDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
        this.cacheAdsDialogFragment = null;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    @l
    public View p(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_audio_book_chapter_list, (ViewGroup) null);
        this.binding = DialogAudioBookChapterListBinding.bind(inflate);
        h0();
        return inflate;
    }

    public final void p0() {
        Coroutine.onError$default(Coroutine.onSuccess$default(Coroutine.onStart$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new AudiobookChapterListFragment$refreshChapterList$1(null), 15, null), null, new AudiobookChapterListFragment$refreshChapterList$2(this, null), 1, null), null, new AudiobookChapterListFragment$refreshChapterList$3(this, null), 1, null), null, new AudiobookChapterListFragment$refreshChapterList$4(this, null), 1, null);
    }

    public final void u0() {
        FragmentActivity activity = getActivity();
        AudiobookActivity audiobookActivity = activity instanceof AudiobookActivity ? (AudiobookActivity) activity : null;
        if (audiobookActivity != null) {
            if (this.videoAdManager == null) {
                this.videoAdManager = new s(audiobookActivity, new d(audiobookActivity));
            }
            s sVar = this.videoAdManager;
            if (sVar != null) {
                sVar.h();
            }
        }
    }

    public final void z0(int start) {
        ChapterList d10;
        DownLoadButton downLoadButton;
        DownLoadButton downLoadButton2;
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        if (readAloudBook.d() == null || ((d10 = readAloudBook.d()) != null && d10.getCount() == 0)) {
            t0.b(getContext(), "章节信息加载失败");
            return;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(start, this.cacheIndex);
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding = this.binding;
        if (dialogAudioBookChapterListBinding != null && (downLoadButton2 = dialogAudioBookChapterListBinding.downloadBtn) != null) {
            downLoadButton2.r();
        }
        ChapterList d11 = readAloudBook.d();
        Intrinsics.checkNotNull(d11);
        int count = d11.getCount();
        if (coerceAtLeast < count) {
            this.mCacheStatus = CacheStatus.Caching;
            Coroutine.onSuccess$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new AudiobookChapterListFragment$startCacheContents$1(coerceAtLeast, count, null), 15, null), null, new AudiobookChapterListFragment$startCacheContents$2(this, null), 1, null);
            return;
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding2 = this.binding;
        if (dialogAudioBookChapterListBinding2 != null && (downLoadButton = dialogAudioBookChapterListBinding2.downloadBtn) != null) {
            downLoadButton.setState(DownLoadButton.INSTANCE.c());
        }
        DialogAudioBookChapterListBinding dialogAudioBookChapterListBinding3 = this.binding;
        DownLoadButton downLoadButton3 = dialogAudioBookChapterListBinding3 != null ? dialogAudioBookChapterListBinding3.downloadBtn : null;
        if (downLoadButton3 != null) {
            downLoadButton3.setAlpha(0.4f);
        }
        t0.b(getContext(), "全部章节已缓存");
    }
}
