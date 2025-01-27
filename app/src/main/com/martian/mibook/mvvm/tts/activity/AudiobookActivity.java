package com.martian.mibook.mvvm.tts.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.GridLayoutManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.MartianDialogFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityAudioBookBinding;
import com.martian.mibook.databinding.AudioBookDownloadGoogleTtsEngineBinding;
import com.martian.mibook.databinding.AudiobookAdLayoutBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.activity.ReadingNewActivity;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.tts.TtsEnginesUtil;
import com.martian.mibook.mvvm.tts.TtsTimeController;
import com.martian.mibook.mvvm.tts.activity.AudiobookActivity;
import com.martian.mibook.mvvm.tts.adapter.AudiobookRecommendAdapter;
import com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment;
import com.martian.mibook.mvvm.tts.dialog.TtsSoundSettingDialogFragment;
import com.martian.mibook.mvvm.tts.fragment.AudiobookChapterListFragment;
import com.martian.mibook.mvvm.tts.viewmodel.AudiobookViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.widget.GridSpaceItemDecoration;
import com.martian.mibook.ui.AudiobookAdFrameLayout;
import com.martian.rpauth.response.MartianRPAccount;
import com.umeng.analytics.pro.bt;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import l9.t0;
import xi.k;
import xi.l;
import ya.n0;
import ya.r;
import ya.s;

@Route(path = kc.a.f27751g)
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u009a\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u009b\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\bH\u0003¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020\b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0003¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\bH\u0003¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\bH\u0003¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\bH\u0003¢\u0006\u0004\b)\u0010\u0005J!\u0010.\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020,H\u0003¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020\u0017H\u0003¢\u0006\u0004\b2\u00103J!\u00106\u001a\u00020\b2\u0006\u00104\u001a\u00020,2\b\b\u0001\u00105\u001a\u00020\u0011H\u0003¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u0010\u0005J\u001f\u0010<\u001a\u00020\b2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0011H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\bH\u0003¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\bH\u0002¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010@\u001a\u00020\bH\u0016¢\u0006\u0004\b@\u0010\u0005J\u000f\u0010A\u001a\u00020\bH\u0016¢\u0006\u0004\bA\u0010\u0005J\u0019\u0010B\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\bB\u0010\nJ\u000f\u0010C\u001a\u00020\bH\u0016¢\u0006\u0004\bC\u0010\u0005J\u0019\u0010F\u001a\u00020\b2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bF\u0010GJ\u0019\u0010J\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\bH\u0014¢\u0006\u0004\bL\u0010\u0005J\u000f\u0010M\u001a\u00020\bH\u0014¢\u0006\u0004\bM\u0010\u0005J\u0015\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u000209¢\u0006\u0004\bO\u0010PJ)\u0010T\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u00112\b\u0010S\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010XR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010{R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0089\u0001\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R(\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0090\u00010\u008f\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R(\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u008f\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0092\u0001\u001a\u0006\b\u0098\u0001\u0010\u0094\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/tts/activity/AudiobookActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityAudioBookBinding;", "Lcom/martian/mibook/mvvm/tts/viewmodel/AudiobookViewModel;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "W2", "(Landroid/content/Intent;)V", "h4", "c3", "V2", "g3", "l3", "d3", "", "percent", "e3", "(Ljava/lang/Integer;)V", "X3", "a3", "", "timeSecond", "k4", "(J)V", "T3", "time", "K3", "(I)V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", "k3", "(Ljava/util/List;)V", "b3", "i4", "Q2", "j4", "c4", "Y3", "Landroid/widget/SeekBar;", "seekBar", "Landroid/widget/TextView;", "tvSpeedTitle", "G3", "(Landroid/widget/SeekBar;Landroid/widget/TextView;)V", "timerSeconds", "", "R2", "(J)Ljava/lang/String;", "view", "drawableResId", "f3", "(Landroid/widget/TextView;I)V", "O3", "", "show", "adHeight", "H3", "(ZI)V", "I3", "U2", "r1", "u1", "onNewIntent", r3.c.f30241d, "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "onResume", "onDestroy", "loading", "g4", "(Z)V", "requestCode", "resultCode", h3.e.f26408m, "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "h", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "timerDialogFragment", "i", "speechSpeedDialogFragment", "Lcom/martian/mibook/mvvm/tts/dialog/DownloadTtsEngineDialogFragment;", "j", "Lcom/martian/mibook/mvvm/tts/dialog/DownloadTtsEngineDialogFragment;", "downloadTtsEngineDialogFragment", "Lcom/martian/mibook/databinding/AudioBookDownloadGoogleTtsEngineBinding;", "k", "Lcom/martian/mibook/databinding/AudioBookDownloadGoogleTtsEngineBinding;", "downloadGoogleTtsEngineBinding", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", t.f11204d, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "Lcom/martian/mibook/mvvm/tts/adapter/AudiobookRecommendAdapter;", "m", "Lcom/martian/mibook/mvvm/tts/adapter/AudiobookRecommendAdapter;", "bookAdapter", "Lce/t;", "n", "Lce/t;", "tingShuClockAdapter", "Lya/s;", "o", "Lya/s;", "videoAdManager", "Lcom/martian/mibook/databinding/AudiobookAdLayoutBinding;", "p", "Lcom/martian/mibook/databinding/AudiobookAdLayoutBinding;", "audiobookAdLayoutBinding", "Lcom/martian/libmars/widget/dialog/MartianDialogFragment;", "q", "Lcom/martian/libmars/widget/dialog/MartianDialogFragment;", "noneAvailableTimeDialogFragment", t.f11211k, "replenishmentTimeDialogFragment", "Lya/r;", "s", "Lya/r;", "audiobookAdManager", "Lkotlinx/coroutines/Job;", bt.aO, "Lkotlinx/coroutines/Job;", "postDelayJob", "u", "Z", "isAudioPause", "v", "Ljava/lang/String;", "systemDefaultEngine", IAdInterListener.AdReqParam.WIDTH, "J", "Landroidx/lifecycle/Observer;", "Lcom/martian/mibook/mvvm/tts/ReadAloudBook$a;", "x", "Lkotlin/Lazy;", "S2", "()Landroidx/lifecycle/Observer;", "readAloudEventObserver", "Lcom/martian/mibook/mvvm/tts/ReadAloudBook$ReadAloudPlayerStatus;", "y", "T2", "readAloudPlayerStatusObserver", bt.aJ, "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AudiobookActivity extends BaseMVVMActivity<ActivityAudioBookBinding, AudiobookViewModel> {

    @k
    public static final String A = "intent_book";

    @k
    public static final String B = "intent_book_chapter_index";

    @k
    public static final String C = "intent_book_content_position";

    @k
    public static final String D = "intent_is_restart_audiobook";

    @k
    public static final String E = "intent_book_source_string";

    /* renamed from: z */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public MartianBottomSheetDialogFragment timerDialogFragment;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public MartianBottomSheetDialogFragment speechSpeedDialogFragment;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public DownloadTtsEngineDialogFragment downloadTtsEngineDialogFragment;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public AudioBookDownloadGoogleTtsEngineBinding downloadGoogleTtsEngineBinding;

    /* renamed from: l */
    @l
    public BottomSheetBehavior<View> bottomSheetBehavior;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public AudiobookRecommendAdapter bookAdapter;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public ce.t tingShuClockAdapter;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public s videoAdManager;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public AudiobookAdLayoutBinding audiobookAdLayoutBinding;

    /* renamed from: q, reason: from kotlin metadata */
    @l
    public MartianDialogFragment noneAvailableTimeDialogFragment;

    /* renamed from: r */
    @l
    public MartianDialogFragment replenishmentTimeDialogFragment;

    /* renamed from: s, reason: from kotlin metadata */
    @l
    public r audiobookAdManager;

    /* renamed from: t */
    @l
    public Job postDelayJob;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean isAudioPause;

    /* renamed from: v, reason: from kotlin metadata */
    @l
    public String systemDefaultEngine;

    /* renamed from: w */
    public long timeSecond;

    /* renamed from: x, reason: from kotlin metadata */
    @k
    public final Lazy readAloudEventObserver = LazyKt.lazy(new AudiobookActivity$readAloudEventObserver$2(this));

    /* renamed from: y, reason: from kotlin metadata */
    @k
    public final Lazy readAloudPlayerStatusObserver = LazyKt.lazy(new AudiobookActivity$readAloudPlayerStatusObserver$2(this));

    /* renamed from: com.martian.mibook.mvvm.tts.activity.AudiobookActivity$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final class b extends CustomTarget<Drawable> {

        /* renamed from: b */
        public final /* synthetic */ int f15098b;

        /* renamed from: c */
        public final /* synthetic */ AudiobookActivity f15099c;

        /* renamed from: d */
        public final /* synthetic */ int f15100d;

        public b(int i10, AudiobookActivity audiobookActivity, int i11) {
            this.f15098b = i10;
            this.f15099c = audiobookActivity;
            this.f15100d = i11;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(@k Drawable resource, @l Transition<? super Drawable> transition) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            Drawable current = resource.getCurrent();
            Intrinsics.checkNotNullExpressionValue(current, "getCurrent(...)");
            current.setColorFilter(new PorterDuffColorFilter(this.f15098b, PorterDuff.Mode.MULTIPLY));
            AudiobookActivity.A2(this.f15099c).llContent.setBackground(current);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@l Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@l Drawable drawable) {
            super.onLoadFailed(drawable);
            AudiobookActivity.A2(this.f15099c).llContent.setBackgroundColor(this.f15100d);
        }
    }

    public static final class c extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a */
        public float f15101a;

        public c() {
        }

        public final float a() {
            return this.f15101a;
        }

        public final void b(float f10) {
            this.f15101a = f10;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@k View bottomSheet, float f10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            this.f15101a = f10;
            Window window = AudiobookActivity.this.getWindow();
            if (window != null) {
                window.setDimAmount((f10 + 1) * 0.25f);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@k View bottomSheet, int i10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (i10 != 1) {
                if (this.f15101a >= 0.8d) {
                    BottomSheetBehavior bottomSheetBehavior = AudiobookActivity.this.bottomSheetBehavior;
                    if (bottomSheetBehavior == null) {
                        return;
                    }
                    bottomSheetBehavior.setState(3);
                    return;
                }
                if (i10 == 5) {
                    AudiobookActivity.this.finish();
                    return;
                }
                BottomSheetBehavior bottomSheetBehavior2 = AudiobookActivity.this.bottomSheetBehavior;
                if (bottomSheetBehavior2 == null) {
                    return;
                }
                bottomSheetBehavior2.setState(5);
            }
        }
    }

    public static final class d implements SeekBar.OnSeekBarChangeListener {
        public d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@l SeekBar seekBar, int i10, boolean z10) {
            if (seekBar != null) {
                AudiobookActivity audiobookActivity = AudiobookActivity.this;
                if (seekBar.getMax() <= 0 || seekBar.getProgress() > seekBar.getMax()) {
                    return;
                }
                TextView textView = AudiobookActivity.A2(audiobookActivity).tvContent;
                ChapterContent i11 = ReadAloudBook.f15003a.i();
                textView.setText(ba.l.x(i11 != null ? i11.getContent() : null, i10));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@l SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@l SeekBar seekBar) {
            if (seekBar != null) {
                AudiobookActivity audiobookActivity = AudiobookActivity.this;
                if (seekBar.getMax() <= 0 || seekBar.getProgress() > seekBar.getMax()) {
                    return;
                }
                TTSReadManager.f(audiobookActivity, ReadAloudBook.f15003a.c(), seekBar.getProgress());
            }
        }
    }

    public static final class e implements s.b {
        public e() {
        }

        @Override // ya.s.b
        public void a() {
            TTSReadManager.d(AudiobookActivity.this);
        }

        @Override // ya.s.b
        public void onRewardVerify(boolean z10) {
            if (!z10) {
                t0.b(AudiobookActivity.this, ExtKt.c("领取失败"));
            } else {
                TtsTimeController.c(AudiobookActivity.this, true);
                TTSReadManager.h(AudiobookActivity.this);
            }
        }
    }

    public static final class f implements MartianDialogFragment.b {
        @Override // com.martian.libmars.widget.dialog.MartianDialogFragment.b
        public void a(@k DialogFragment dialogFragment) {
            Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
            boolean A0 = MiConfigSingleton.b2().A0();
            com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
        }
    }

    public static final class g implements MartianDialogFragment.b {
        @Override // com.martian.libmars.widget.dialog.MartianDialogFragment.b
        public void a(@k DialogFragment dialogFragment) {
            Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
            boolean A0 = MiConfigSingleton.b2().A0();
            com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
        }
    }

    public static final class h implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: b */
        public final /* synthetic */ TextView f15105b;

        /* renamed from: c */
        public final /* synthetic */ AudiobookActivity f15106c;

        /* renamed from: d */
        public final /* synthetic */ TextView f15107d;

        public h(TextView textView, AudiobookActivity audiobookActivity, TextView textView2) {
            this.f15105b = textView;
            this.f15106c = audiobookActivity;
            this.f15107d = textView2;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@l SeekBar seekBar, int i10, boolean z10) {
            float p10 = ReadAloudBook.f15003a.p(seekBar != null ? Integer.valueOf(seekBar.getProgress()) : null);
            this.f15105b.setText(this.f15106c.getString(R.string.speech_speed_setting) + "·" + p10 + "x");
            TextView textView = this.f15107d;
            textView.setEnabled(i10 != 5);
            textView.setAlpha(textView.isEnabled() ? 1.0f : 0.4f);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@l SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@l SeekBar seekBar) {
            AudiobookActivity audiobookActivity = this.f15106c;
            TextView tvSpeedTitle = this.f15105b;
            Intrinsics.checkNotNullExpressionValue(tvSpeedTitle, "$tvSpeedTitle");
            audiobookActivity.G3(seekBar, tvSpeedTitle);
        }
    }

    public static final class i implements MartianBottomSheetDialogFragment.b {
        @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
        public void a(@k DialogFragment dialogFragment) {
            Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
            boolean A0 = MiConfigSingleton.b2().A0();
            com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
        }
    }

    public static final class j implements MartianBottomSheetDialogFragment.b {
        @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
        public void a(@k DialogFragment dialogFragment) {
            Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
            boolean A0 = MiConfigSingleton.b2().A0();
            com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityAudioBookBinding A2(AudiobookActivity audiobookActivity) {
        return (ActivityAudioBookBinding) audiobookActivity.a1();
    }

    public static final void A3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void C3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void D3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void E3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        je.i.H(this$0, ReadAloudBook.f15003a.a());
    }

    public static final void F3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        String sourceName = a10 != null ? a10.getSourceName() : null;
        Book a11 = readAloudBook.a();
        je.i.e0(this$0, "听书", sourceName, a11 != null ? a11.getSourceId() : null);
    }

    public static final void J3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m1().I(Boolean.valueOf(MiConfigSingleton.b2().K2()));
        DownloadTtsEngineDialogFragment.INSTANCE.a(this$0, this$0.l1(), new Function0<Unit>() { // from class: com.martian.mibook.mvvm.tts.activity.AudiobookActivity$showDownloadGoogleTtsEngineTipView$1$1
            public AudiobookActivity$showDownloadGoogleTtsEngineTipView$1$1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                AudioBookDownloadGoogleTtsEngineBinding audioBookDownloadGoogleTtsEngineBinding;
                audioBookDownloadGoogleTtsEngineBinding = AudiobookActivity.this.downloadGoogleTtsEngineBinding;
                RelativeLayout root = audioBookDownloadGoogleTtsEngineBinding != null ? audioBookDownloadGoogleTtsEngineBinding.getRoot() : null;
                if (root == null) {
                    return;
                }
                root.setVisibility(8);
            }
        });
    }

    public static final void L3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.replenishmentTimeDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void M3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.replenishmentTimeDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
        ((ActivityAudioBookBinding) this$0.a1()).tvGoUnlock.callOnClick();
    }

    public static final void N3(AudiobookActivity this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAudioPause) {
            this$0.isAudioPause = false;
            TTSReadManager.h(this$0);
        }
    }

    public static final void P3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        String sourceName = a10 != null ? a10.getSourceName() : null;
        Book a11 = readAloudBook.a();
        je.i.e0(this$0, "听书广告", sourceName, a11 != null ? a11.getSourceId() : null);
    }

    public static final void Q3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudiobookAdLayoutBinding audiobookAdLayoutBinding = this$0.audiobookAdLayoutBinding;
        RelativeLayout root = audiobookAdLayoutBinding != null ? audiobookAdLayoutBinding.getRoot() : null;
        if (root != null) {
            root.setVisibility(8);
        }
        r rVar = this$0.audiobookAdManager;
        if (rVar != null) {
            rVar.m();
        }
        this$0.H3(false, 0);
    }

    public static final void R3(AudiobookActivity this$0, int i10, int i11) {
        Job launch$default;
        CountdownNumberTextView countdownNumberTextView;
        AudiobookAdFrameLayout audiobookAdFrameLayout;
        AudiobookAdFrameLayout audiobookAdFrameLayout2;
        AudiobookAdFrameLayout audiobookAdFrameLayout3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TTSReadManager.B();
        AudiobookAdLayoutBinding audiobookAdLayoutBinding = this$0.audiobookAdLayoutBinding;
        ViewGroup.LayoutParams layoutParams = (audiobookAdLayoutBinding == null || (audiobookAdFrameLayout3 = audiobookAdLayoutBinding.audiobookAdContainer) == null) ? null : audiobookAdFrameLayout3.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i10 + i11;
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding2 = this$0.audiobookAdLayoutBinding;
        if (audiobookAdLayoutBinding2 != null && (audiobookAdFrameLayout2 = audiobookAdLayoutBinding2.audiobookAdContainer) != null) {
            audiobookAdFrameLayout2.setTouched(false);
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding3 = this$0.audiobookAdLayoutBinding;
        if (audiobookAdLayoutBinding3 != null && (audiobookAdFrameLayout = audiobookAdLayoutBinding3.audiobookAdContainer) != null) {
            audiobookAdFrameLayout.setAdHeight(i10);
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding4 = this$0.audiobookAdLayoutBinding;
        RelativeLayout root = audiobookAdLayoutBinding4 != null ? audiobookAdLayoutBinding4.getRoot() : null;
        if (root != null) {
            root.setVisibility(0);
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding5 = this$0.audiobookAdLayoutBinding;
        LinearLayout linearLayout = audiobookAdLayoutBinding5 != null ? audiobookAdLayoutBinding5.audiobookAdCloseView : null;
        if (linearLayout != null) {
            linearLayout.setEnabled(false);
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding6 = this$0.audiobookAdLayoutBinding;
        TextView textView = audiobookAdLayoutBinding6 != null ? audiobookAdLayoutBinding6.audiobookAdCloseTitle : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding7 = this$0.audiobookAdLayoutBinding;
        CountdownNumberTextView countdownNumberTextView2 = audiobookAdLayoutBinding7 != null ? audiobookAdLayoutBinding7.audiobookAdCloseCountdown : null;
        if (countdownNumberTextView2 != null) {
            countdownNumberTextView2.setVisibility(0);
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding8 = this$0.audiobookAdLayoutBinding;
        if (audiobookAdLayoutBinding8 != null && (countdownNumberTextView = audiobookAdLayoutBinding8.audiobookAdCloseCountdown) != null) {
            countdownNumberTextView.m(3);
        }
        this$0.H3(true, i10);
        if (i11 > 0) {
            TTSReadManager.d(this$0);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new AudiobookActivity$showNativeAd$3$1(this$0, i11, null), 2, null);
        this$0.postDelayJob = launch$default;
    }

    public static final void S3(AudiobookActivity this$0, CountdownNumberTextView countdownNumberTextView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudiobookAdLayoutBinding audiobookAdLayoutBinding = this$0.audiobookAdLayoutBinding;
        LinearLayout linearLayout = audiobookAdLayoutBinding != null ? audiobookAdLayoutBinding.audiobookAdCloseView : null;
        if (linearLayout != null) {
            linearLayout.setEnabled(true);
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding2 = this$0.audiobookAdLayoutBinding;
        TextView textView = audiobookAdLayoutBinding2 != null ? audiobookAdLayoutBinding2.audiobookAdCloseTitle : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        AudiobookAdLayoutBinding audiobookAdLayoutBinding3 = this$0.audiobookAdLayoutBinding;
        CountdownNumberTextView countdownNumberTextView2 = audiobookAdLayoutBinding3 != null ? audiobookAdLayoutBinding3.audiobookAdCloseCountdown : null;
        if (countdownNumberTextView2 == null) {
            return;
        }
        countdownNumberTextView2.setVisibility(8);
    }

    public static final void U3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.noneAvailableTimeDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void V2() {
        String cover;
        Book a10;
        if (m1().getBook() != null) {
            Book book = m1().getBook();
            cover = book != null ? book.getCover() : null;
            a10 = m1().getBook();
        } else {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            Book a11 = readAloudBook.a();
            cover = a11 != null ? a11.getCover() : null;
            a10 = readAloudBook.a();
        }
        if (a10 == null) {
            return;
        }
        ((ActivityAudioBookBinding) a1()).llContent.setBackgroundColor(-10921639);
        Glide.with((FragmentActivity) this).load2(cover).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new th.b(5, 10))).placeholder(new ColorDrawable(-10921639)).into((RequestBuilder) new b(-4210753, this, -10921639));
        MiBookManager.u1(this, a10, ((ActivityAudioBookBinding) a1()).ivCover);
        String c10 = ExtKt.c(a10.getBookName());
        if (a10.isLocal()) {
            ((ActivityAudioBookBinding) a1()).tvCoverBookName.setText(c10);
            ((ActivityAudioBookBinding) a1()).tvCoverBookName.setVisibility(0);
        } else {
            ((ActivityAudioBookBinding) a1()).tvCoverBookName.setVisibility(8);
        }
        ((ActivityAudioBookBinding) a1()).tvChapter.setText(c10);
        ((ActivityAudioBookBinding) a1()).audioVideo.setText(ExtKt.c("看视频解锁" + TtsTimeController.j() + "分钟"));
        if (!m1().getIsRestartAudiobook()) {
            a3();
        }
        m1().o();
        O3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void V3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.noneAvailableTimeDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
        ((ActivityAudioBookBinding) this$0.a1()).rlBuyVip.callOnClick();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void W3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianDialogFragment martianDialogFragment = this$0.noneAvailableTimeDialogFragment;
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
        ((ActivityAudioBookBinding) this$0.a1()).tvGoUnlock.callOnClick();
    }

    public static final void X2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Y2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Z2(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void Z3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment = this$0.speechSpeedDialogFragment;
        if (martianBottomSheetDialogFragment != null) {
            martianBottomSheetDialogFragment.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void a3() {
        TextView textView = ((ActivityAudioBookBinding) a1()).tvPlayerSpeechSpeed;
        String string = getString(R.string.speech_speed_text);
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        textView.setText(string + ReadAloudBook.q(readAloudBook, null, 1, null) + "x");
        if (MiConfigSingleton.b2().M1().i0(readAloudBook.b())) {
            TextView tvPlayerAddBookshelf = ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf;
            Intrinsics.checkNotNullExpressionValue(tvPlayerAddBookshelf, "tvPlayerAddBookshelf");
            f3(tvPlayerAddBookshelf, R.drawable.icon_player_already_bookshelf);
            ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setText(ExtKt.c("已在书架"));
            ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setEnabled(false);
            ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setAlpha(0.4f);
        } else {
            TextView tvPlayerAddBookshelf2 = ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf;
            Intrinsics.checkNotNullExpressionValue(tvPlayerAddBookshelf2, "tvPlayerAddBookshelf");
            f3(tvPlayerAddBookshelf2, R.drawable.icon_player_add_bookshelf);
            ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setText(ExtKt.c("加入书架"));
            ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setEnabled(true);
            ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setAlpha(1.0f);
        }
        b3();
    }

    public static final void a4(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment = this$0.speechSpeedDialogFragment;
        if (martianBottomSheetDialogFragment != null) {
            martianBottomSheetDialogFragment.dismiss();
        }
    }

    public static final void b4(SeekBar seekBar, AudiobookActivity this$0, TextView textView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        seekBar.setProgress(5);
        Intrinsics.checkNotNull(textView);
        this$0.G3(seekBar, textView);
    }

    public static final void d4(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment = this$0.timerDialogFragment;
        if (martianBottomSheetDialogFragment != null) {
            martianBottomSheetDialogFragment.dismiss();
        }
    }

    public static final void e4(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment = this$0.timerDialogFragment;
        if (martianBottomSheetDialogFragment != null) {
            martianBottomSheetDialogFragment.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f4(AudiobookActivity this$0, AdapterView adapterView, View view, int i10, long j10) {
        long j11;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (i10) {
            case 1:
                ((ActivityAudioBookBinding) this$0.a1()).tvPlayerTimer.setText(this$0.getString(R.string.listened_current_chapter));
                j11 = -1;
                break;
            case 2:
                if (!ConfigSingleton.D().B0()) {
                    j11 = 900;
                    break;
                } else {
                    j11 = 20;
                    break;
                }
            case 3:
                j11 = 1800;
                break;
            case 4:
                j11 = 3600;
                break;
            case 5:
                j11 = 5400;
                break;
            case 6:
                j11 = TtsTimeController.f15072g;
                break;
            default:
                j11 = 0;
                break;
        }
        ReadAloudBook.f15003a.J(i10);
        TTSReadManager.m(this$0, j11);
        ce.t tVar = this$0.tingShuClockAdapter;
        if (tVar != null) {
            tVar.c(i10);
        }
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment = this$0.timerDialogFragment;
        if (martianBottomSheetDialogFragment != null) {
            martianBottomSheetDialogFragment.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h3(AudiobookActivity this$0, Boolean bool) {
        String content;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        String e10 = readAloudBook.e();
        String str = null;
        String c10 = ExtKt.c(e10 != null ? StringsKt.trim((CharSequence) e10).toString() : null);
        ((ActivityAudioBookBinding) this$0.a1()).tvChapter.setText(c10);
        ((ActivityAudioBookBinding) this$0.a1()).ivContentEnlarge.setVisibility(0);
        ChapterContent i10 = readAloudBook.i();
        int contentLength = i10 != null ? i10.getContentLength() : 0;
        if (bool == null) {
            ((ActivityAudioBookBinding) this$0.a1()).seekBar.setProgress(contentLength);
            return;
        }
        if (contentLength == 0) {
            ((ActivityAudioBookBinding) this$0.a1()).seekBar.setProgress(0);
        } else {
            ((ActivityAudioBookBinding) this$0.a1()).seekBar.setMax(contentLength);
            ((ActivityAudioBookBinding) this$0.a1()).seekBar.setProgress(RangesKt.coerceAtLeast(readAloudBook.f(), 0));
        }
        if (bool.booleanValue()) {
            ((ActivityAudioBookBinding) this$0.a1()).tvContent.setText(c10);
            return;
        }
        ChapterContent i11 = readAloudBook.i();
        int contentLength2 = (i11 != null ? i11.getContentLength() : 1) - 1;
        ChapterContent i12 = readAloudBook.i();
        if (i12 != null && (content = i12.getContent(RangesKt.coerceIn(readAloudBook.f(), 0, contentLength2), RangesKt.coerceIn(readAloudBook.l(), 0, contentLength2))) != null) {
            str = StringsKt.trim((CharSequence) content).toString();
        }
        ((ActivityAudioBookBinding) this$0.a1()).tvContent.setText(ExtKt.c(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i3(AudiobookActivity this$0, Long l10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        if (readAloudBook.s() == 0) {
            ((ActivityAudioBookBinding) this$0.a1()).tvPlayerTimer.setText(this$0.getString(R.string.ting_shu_clock));
            return;
        }
        if (readAloudBook.s() == 1) {
            ((ActivityAudioBookBinding) this$0.a1()).tvPlayerTimer.setText(this$0.getString(R.string.listened_current_chapter));
        } else if (l10 == null || l10.longValue() <= 0) {
            ((ActivityAudioBookBinding) this$0.a1()).tvPlayerTimer.setText(this$0.getString(R.string.ting_shu_clock));
        } else {
            ((ActivityAudioBookBinding) this$0.a1()).tvPlayerTimer.setText(this$0.R2(l10.longValue()));
        }
    }

    public static final void j3(AudiobookActivity this$0, Long l10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(l10);
        this$0.k4(l10.longValue());
    }

    public static final void m3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!TtsTimeController.r(this$0.timeSecond)) {
            t0.b(this$0, "当前听书可用时长已达上限");
            return;
        }
        ac.a.W(this$0, "看视频解锁");
        if (this$0.videoAdManager == null) {
            this$0.videoAdManager = new s(this$0, this$0.new e());
        }
        s sVar = this$0.videoAdManager;
        if (sVar != null) {
            sVar.h();
        }
    }

    public static final void n3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c4();
    }

    public static final void o3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y3();
    }

    public static final void p3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.W(this$0, "声音设置");
        this$0.X3();
    }

    public static final void q3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i4();
    }

    public static final void r3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i4();
    }

    public static final void s3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q2();
    }

    public static final void t3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j4();
    }

    public static final void u3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TTSReadManager.p()) {
            this$0.O3();
        }
        TTSReadManager.i(this$0);
    }

    public static final void v3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TTSReadManager.c(this$0);
    }

    public static final void w3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TTSReadManager.g(this$0);
    }

    public static final void x3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kc.b.z(this$0);
    }

    public static final void y3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void z3(AudiobookActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ActivityAudioBookBinding) this$0.a1()).ivRefresh.setVisibility(8);
        ((ActivityAudioBookBinding) this$0.a1()).bookMoreProgressbar.setVisibility(0);
        this$0.m1().o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void G3(SeekBar seekBar, TextView tvSpeedTitle) {
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        float p10 = readAloudBook.p(seekBar != null ? Integer.valueOf(seekBar.getProgress()) : null);
        TTSReadManager.j(this, readAloudBook.n(seekBar != null ? Integer.valueOf(seekBar.getProgress()) : null));
        ((ActivityAudioBookBinding) a1()).tvPlayerSpeechSpeed.setText(getString(R.string.speech_speed_text) + p10 + "x");
        tvSpeedTitle.setText(getString(R.string.speech_speed_setting) + "·" + p10 + "x");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H3(boolean show, int adHeight) {
        if (show) {
            ((ActivityAudioBookBinding) a1()).audiobookCoverView.setVisibility(8);
        } else {
            ((ActivityAudioBookBinding) a1()).audiobookCoverView.setVisibility(0);
            Job job = this.postDelayJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        ((ActivityAudioBookBinding) a1()).audiobookAdPlaceholder.getLayoutParams().height = adHeight;
    }

    @SuppressLint({"SetTextI18n"})
    public final void I3() {
        ThemeTextView themeTextView;
        DownloadTtsEngineDialogFragment downloadTtsEngineDialogFragment = this.downloadTtsEngineDialogFragment;
        if (downloadTtsEngineDialogFragment != null && downloadTtsEngineDialogFragment != null && downloadTtsEngineDialogFragment.isVisible()) {
            U2();
            return;
        }
        if (TtsEnginesUtil.i(this)) {
            U2();
            return;
        }
        AudioBookDownloadGoogleTtsEngineBinding audioBookDownloadGoogleTtsEngineBinding = this.downloadGoogleTtsEngineBinding;
        if (audioBookDownloadGoogleTtsEngineBinding != null) {
            RelativeLayout root = audioBookDownloadGoogleTtsEngineBinding != null ? audioBookDownloadGoogleTtsEngineBinding.getRoot() : null;
            if (root == null) {
                return;
            }
            root.setVisibility(0);
            return;
        }
        this.downloadGoogleTtsEngineBinding = AudioBookDownloadGoogleTtsEngineBinding.bind(View.inflate(this, R.layout.audio_book_download_google_tts_engine, null));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams.bottomMargin = ConfigSingleton.i(28.0f);
        int i10 = ConfigSingleton.i(12.0f);
        layoutParams.leftMargin = i10;
        layoutParams.rightMargin = i10;
        Window window = getWindow();
        if (window != null) {
            AudioBookDownloadGoogleTtsEngineBinding audioBookDownloadGoogleTtsEngineBinding2 = this.downloadGoogleTtsEngineBinding;
            window.addContentView(audioBookDownloadGoogleTtsEngineBinding2 != null ? audioBookDownloadGoogleTtsEngineBinding2.getRoot() : null, layoutParams);
        }
        if (DownloadTtsEngineDialogFragment.INSTANCE.d()) {
            AudioBookDownloadGoogleTtsEngineBinding audioBookDownloadGoogleTtsEngineBinding3 = this.downloadGoogleTtsEngineBinding;
            ThemeTextView themeTextView2 = audioBookDownloadGoogleTtsEngineBinding3 != null ? audioBookDownloadGoogleTtsEngineBinding3.tvDownload : null;
            if (themeTextView2 != null) {
                themeTextView2.setText(ExtKt.c("安装插件"));
            }
        } else {
            AudioBookDownloadGoogleTtsEngineBinding audioBookDownloadGoogleTtsEngineBinding4 = this.downloadGoogleTtsEngineBinding;
            ThemeTextView themeTextView3 = audioBookDownloadGoogleTtsEngineBinding4 != null ? audioBookDownloadGoogleTtsEngineBinding4.tvDownload : null;
            if (themeTextView3 != null) {
                themeTextView3.setText(ExtKt.c("下载插件"));
            }
        }
        AudioBookDownloadGoogleTtsEngineBinding audioBookDownloadGoogleTtsEngineBinding5 = this.downloadGoogleTtsEngineBinding;
        if (audioBookDownloadGoogleTtsEngineBinding5 == null || (themeTextView = audioBookDownloadGoogleTtsEngineBinding5.tvDownload) == null) {
            return;
        }
        themeTextView.setOnClickListener(new View.OnClickListener() { // from class: jd.g0
            public /* synthetic */ g0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.J3(AudiobookActivity.this, view);
            }
        });
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    public final void K3(int time) {
        MartianDialogFragment martianDialogFragment = this.replenishmentTimeDialogFragment;
        if (martianDialogFragment == null || martianDialogFragment == null || !martianDialogFragment.isVisible()) {
            com.martian.libmars.widget.dialog.b a10 = MartianDialogFragment.INSTANCE.a();
            View inflate = getLayoutInflater().inflate(R.layout.fragment_audio_book_everyday_replenishment_time, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: jd.d0
                public /* synthetic */ d0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookActivity.L3(AudiobookActivity.this, view);
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.tv_time);
            if (textView != null) {
                textView.setText(String.valueOf(time));
            }
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_tips);
            if (textView2 != null) {
                textView2.setText(ExtKt.c("温馨提示：明日听书得" + TtsTimeController.i() + "分钟赠送时长"));
            }
            ((TextView) inflate.findViewById(R.id.tv_show_ad)).setText(ExtKt.c("看视频再加" + TtsTimeController.j() + "分钟"));
            ((TextView) inflate.findViewById(R.id.tv_show_ad)).setOnClickListener(new View.OnClickListener() { // from class: jd.e0
                public /* synthetic */ e0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookActivity.M3(AudiobookActivity.this, view);
                }
            });
            if (MiConfigSingleton.b2().A0()) {
                ((ImageView) inflate.findViewById(R.id.ll_bg)).setVisibility(8);
            }
            this.replenishmentTimeDialogFragment = com.martian.libmars.widget.dialog.b.H(a10.Q(inflate).I(false).J(false).P(com.martian.libmars.R.style.MartianDialogFragmentFullScreenStyle).M(new f()).L(new DialogInterface.OnDismissListener() { // from class: jd.f0
                public /* synthetic */ f0() {
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudiobookActivity.N3(AudiobookActivity.this, dialogInterface);
                }
            }), this, null, "every_day_replenishment_time", false, 10, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O3() {
        CountdownNumberTextView countdownNumberTextView;
        CountdownNumberTextView countdownNumberTextView2;
        LinearLayout linearLayout;
        TextView textView;
        if (TTSReadManager.b()) {
            if (this.audiobookAdLayoutBinding == null) {
                ((ActivityAudioBookBinding) a1()).audiobookAdViewStub.setLayoutResource(R.layout.audiobook_ad_layout);
                this.audiobookAdLayoutBinding = AudiobookAdLayoutBinding.bind(((ActivityAudioBookBinding) a1()).audiobookAdViewStub.inflate());
            }
            AudiobookAdLayoutBinding audiobookAdLayoutBinding = this.audiobookAdLayoutBinding;
            if (audiobookAdLayoutBinding != null && (textView = audiobookAdLayoutBinding.audiobookAdVip) != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: jd.z
                    public /* synthetic */ z() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AudiobookActivity.P3(AudiobookActivity.this, view);
                    }
                });
            }
            AudiobookAdLayoutBinding audiobookAdLayoutBinding2 = this.audiobookAdLayoutBinding;
            if (audiobookAdLayoutBinding2 != null && (linearLayout = audiobookAdLayoutBinding2.audiobookAdCloseView) != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: jd.a0
                    public /* synthetic */ a0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AudiobookActivity.Q3(AudiobookActivity.this, view);
                    }
                });
            }
            if (this.audiobookAdManager == null) {
                String b10 = ReadAloudBook.f15003a.b();
                AudiobookAdLayoutBinding audiobookAdLayoutBinding3 = this.audiobookAdLayoutBinding;
                this.audiobookAdManager = new r(this, b10, audiobookAdLayoutBinding3 != null ? audiobookAdLayoutBinding3.audiobookAdContainer : null, new r.b() { // from class: jd.b0
                    public /* synthetic */ b0() {
                    }

                    @Override // ya.r.b
                    public final void a(int i10, int i11) {
                        AudiobookActivity.R3(AudiobookActivity.this, i10, i11);
                    }
                });
            }
            AudiobookAdLayoutBinding audiobookAdLayoutBinding4 = this.audiobookAdLayoutBinding;
            if (audiobookAdLayoutBinding4 != null && (countdownNumberTextView2 = audiobookAdLayoutBinding4.audiobookAdCloseCountdown) != null) {
                countdownNumberTextView2.setSufText("s");
            }
            AudiobookAdLayoutBinding audiobookAdLayoutBinding5 = this.audiobookAdLayoutBinding;
            if (audiobookAdLayoutBinding5 != null && (countdownNumberTextView = audiobookAdLayoutBinding5.audiobookAdCloseCountdown) != null) {
                countdownNumberTextView.setOnCountDownFinishListener(new CountdownNumberTextView.b() { // from class: jd.c0
                    public /* synthetic */ c0() {
                    }

                    @Override // com.martian.apptask.widget.CountdownNumberTextView.b
                    public final void a(CountdownNumberTextView countdownNumberTextView3) {
                        AudiobookActivity.S3(AudiobookActivity.this, countdownNumberTextView3);
                    }
                });
            }
            r rVar = this.audiobookAdManager;
            if (rVar != null) {
                rVar.v0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void Q2() {
        Book a10;
        MiBookManager M1 = MiConfigSingleton.b2().M1();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        if (!M1.i0(readAloudBook.b()) && (a10 = readAloudBook.a()) != null) {
            MiConfigSingleton.b2().M1().g(this, a10);
        }
        TextView tvPlayerAddBookshelf = ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf;
        Intrinsics.checkNotNullExpressionValue(tvPlayerAddBookshelf, "tvPlayerAddBookshelf");
        f3(tvPlayerAddBookshelf, R.drawable.icon_player_already_bookshelf);
        ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setText(ExtKt.c("已在书架"));
        ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setEnabled(false);
        ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setAlpha(0.4f);
    }

    @SuppressLint({"DefaultLocale"})
    public final String R2(long timerSeconds) {
        long j10 = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        long j11 = timerSeconds / j10;
        long j12 = 60;
        long j13 = (timerSeconds % j10) / j12;
        long j14 = timerSeconds % j12;
        if (j11 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j11), Long.valueOf(j13), Long.valueOf(j14)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j13), Long.valueOf(j14)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    public final Observer<ReadAloudBook.a> S2() {
        return (Observer) this.readAloudEventObserver.getValue();
    }

    public final Observer<ReadAloudBook.ReadAloudPlayerStatus> T2() {
        return (Observer) this.readAloudPlayerStatusObserver.getValue();
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    public final void T3() {
        MartianDialogFragment martianDialogFragment = this.noneAvailableTimeDialogFragment;
        if (martianDialogFragment == null || martianDialogFragment == null || !martianDialogFragment.isVisible()) {
            com.martian.libmars.widget.dialog.b a10 = MartianDialogFragment.INSTANCE.a();
            View inflate = getLayoutInflater().inflate(R.layout.fragment_audio_book_none_available_time, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: jd.t
                public /* synthetic */ t() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookActivity.U3(AudiobookActivity.this, view);
                }
            });
            ((TextView) inflate.findViewById(R.id.tv_activate_vip)).setOnClickListener(new View.OnClickListener() { // from class: jd.u
                public /* synthetic */ u() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookActivity.V3(AudiobookActivity.this, view);
                }
            });
            ((RelativeLayout) inflate.findViewById(R.id.rl_show_ad)).setOnClickListener(new View.OnClickListener() { // from class: jd.v
                public /* synthetic */ v() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookActivity.W3(AudiobookActivity.this, view);
                }
            });
            ((TextView) inflate.findViewById(R.id.tv_show_ad)).setText(ExtKt.c("看视频解锁" + TtsTimeController.j() + "分钟"));
            this.noneAvailableTimeDialogFragment = com.martian.libmars.widget.dialog.b.H(a10.Q(inflate).I(false).J(false).P(com.martian.libmars.R.style.MartianDialogFragmentFullScreenStyle).M(new g()), this, null, "none_audio_book_available_time", false, 10, null);
        }
    }

    public final void U2() {
        AudioBookDownloadGoogleTtsEngineBinding audioBookDownloadGoogleTtsEngineBinding = this.downloadGoogleTtsEngineBinding;
        RelativeLayout root = audioBookDownloadGoogleTtsEngineBinding != null ? audioBookDownloadGoogleTtsEngineBinding.getRoot() : null;
        if (root == null) {
            return;
        }
        root.setVisibility(8);
    }

    public final void W2(Intent intent) {
        this.systemDefaultEngine = TtsEnginesUtil.a(this);
        m1().G(intent.getBooleanExtra(D, false));
        if (!m1().getIsRestartAudiobook()) {
            m1().D(ReadAloudBook.f15003a.a());
            TtsTimeController.d(this, false, 2, null);
            return;
        }
        AudiobookViewModel m12 = m1();
        Serializable serializableExtra = intent.getSerializableExtra("intent_book");
        m12.D(serializableExtra instanceof Book ? (Book) serializableExtra : null);
        if (m1().getBook() != null) {
            h4();
            return;
        }
        String stringExtra = intent.getStringExtra(E);
        m1().t().observe(this, new Observer() { // from class: jd.x
            public /* synthetic */ x() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity.X2(Function1.this, obj);
            }
        });
        m1().s().observe(this, new Observer() { // from class: jd.y
            public /* synthetic */ y() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity.Y2(Function1.this, obj);
            }
        });
        m1().B(vb.e.d(stringExtra), vb.e.e(stringExtra));
    }

    public final void X3() {
        if (ke.e.c() || MiConfigSingleton.b2().C2() || !TtsEnginesUtil.i(this)) {
            TtsEnginesUtil.m(this);
        } else {
            TtsSoundSettingDialogFragment.INSTANCE.a(this);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: jd.s.<init>(android.widget.SeekBar, com.martian.mibook.mvvm.tts.activity.AudiobookActivity, android.widget.TextView):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"MissingInflatedId", "SetTextI18n", "InflateParams"})
    public final void Y3() {
        /*
            r10 = this;
            com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment r0 = r10.speechSpeedDialogFragment
            r1 = 1
            if (r0 == 0) goto L14
            if (r0 == 0) goto L14
            boolean r0 = r0.isVisible()
            if (r0 != r1) goto L14
            com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment r0 = r10.speechSpeedDialogFragment
            if (r0 == 0) goto L14
            r0.dismiss()
        L14:
            com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment$a r0 = com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.INSTANCE
            com.martian.libmars.widget.dialog.a r0 = r0.a()
            android.view.LayoutInflater r2 = r10.getLayoutInflater()
            int r3 = com.martian.mibook.R.layout.fragment_audio_book_speed_layout
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)
            int r3 = com.martian.mibook.R.id.tv_speed_title
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r5 = com.martian.mibook.R.id.seekBar
            android.view.View r5 = r2.findViewById(r5)
            android.widget.SeekBar r5 = (android.widget.SeekBar) r5
            int r6 = com.martian.mibook.R.id.tv_reset
            android.view.View r6 = r2.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = com.martian.mibook.R.id.tv_close
            android.view.View r7 = r2.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            jd.q r8 = new jd.q
            r8.<init>()
            r7.setOnClickListener(r8)
            int r7 = com.martian.mibook.R.id.timing_window_close
            android.view.View r7 = r2.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            jd.r r8 = new jd.r
            r8.<init>()
            r7.setOnClickListener(r8)
            com.martian.mibook.mvvm.tts.ReadAloudBook r7 = com.martian.mibook.mvvm.tts.ReadAloudBook.f15003a
            int r8 = r7.r()
            r9 = 5
            if (r8 == r9) goto L68
            r9 = 1
            goto L69
        L68:
            r9 = 0
        L69:
            r6.setEnabled(r9)
            boolean r9 = r6.isEnabled()
            if (r9 == 0) goto L75
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L78
        L75:
            r9 = 1053609165(0x3ecccccd, float:0.4)
        L78:
            r6.setAlpha(r9)
            r5.setProgress(r8)
            jd.s r8 = new jd.s
            r8.<init>()
            r6.setOnClickListener(r8)
            int r8 = com.martian.mibook.R.string.speech_speed_setting
            java.lang.String r8 = r10.getString(r8)
            float r4 = com.martian.mibook.mvvm.tts.ReadAloudBook.q(r7, r4, r1, r4)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r8)
            java.lang.String r8 = "·"
            r7.append(r8)
            r7.append(r4)
            java.lang.String r4 = "x"
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r3.setText(r4)
            com.martian.mibook.mvvm.tts.activity.AudiobookActivity$h r4 = new com.martian.mibook.mvvm.tts.activity.AudiobookActivity$h
            r4.<init>(r3, r10, r6)
            r5.setOnSeekBarChangeListener(r4)
            com.martian.libmars.widget.dialog.a r0 = r0.y0(r2)
            com.martian.libmars.widget.dialog.a r0 = r0.k0(r1)
            com.martian.libmars.widget.dialog.a r0 = r0.j0(r1)
            com.martian.libmars.widget.dialog.a r0 = r0.w0(r1)
            com.martian.mibook.mvvm.tts.activity.AudiobookActivity$i r1 = new com.martian.mibook.mvvm.tts.activity.AudiobookActivity$i
            r1.<init>()
            com.martian.libmars.widget.dialog.a r2 = r0.s0(r1)
            r7 = 2
            r8 = 0
            r4 = 0
            java.lang.String r5 = "listen_book_speech_speed"
            r6 = 1
            r3 = r10
            com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment r0 = com.martian.libmars.widget.dialog.a.g0(r2, r3, r4, r5, r6, r7, r8)
            r10.speechSpeedDialogFragment = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.tts.activity.AudiobookActivity.Y3():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void b3() {
        if (!TTSReadManager.q()) {
            ((ActivityAudioBookBinding) a1()).ivPlayerPlay.setVisibility(4);
            ((ActivityAudioBookBinding) a1()).ivPlayerPlay.setEnabled(false);
            ((ActivityAudioBookBinding) a1()).pbLoading.setVisibility(0);
            return;
        }
        ((ActivityAudioBookBinding) a1()).pbLoading.setVisibility(8);
        ((ActivityAudioBookBinding) a1()).ivPlayerPlay.setVisibility(0);
        ((ActivityAudioBookBinding) a1()).ivPlayerPlay.setEnabled(true);
        if (TTSReadManager.p()) {
            ((ActivityAudioBookBinding) a1()).ivPlayerPlay.setImageResource(R.drawable.icon_player_pause);
        } else {
            ((ActivityAudioBookBinding) a1()).ivPlayerPlay.setImageResource(R.drawable.icon_player_play);
        }
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        ChapterList d10 = readAloudBook.d();
        int count = d10 != null ? d10.getCount() : 0;
        int i10 = count - 1;
        if (readAloudBook.c() == 0) {
            ((ActivityAudioBookBinding) a1()).ivPlayerPrev.setAlpha(0.4f);
            ((ActivityAudioBookBinding) a1()).ivPlayerPrev.setEnabled(false);
        } else {
            ((ActivityAudioBookBinding) a1()).ivPlayerPrev.setAlpha(1.0f);
            ((ActivityAudioBookBinding) a1()).ivPlayerPrev.setEnabled(true);
        }
        if (readAloudBook.c() == i10 || i10 <= 0) {
            ((ActivityAudioBookBinding) a1()).ivPlayerNext.setAlpha(0.4f);
            ((ActivityAudioBookBinding) a1()).ivPlayerNext.setEnabled(false);
        } else {
            ((ActivityAudioBookBinding) a1()).ivPlayerNext.setAlpha(1.0f);
            ((ActivityAudioBookBinding) a1()).ivPlayerNext.setEnabled(true);
        }
        ((ActivityAudioBookBinding) a1()).tvPlayerChapter.setText(count + "章");
        if (readAloudBook.s() == 1) {
            ((ActivityAudioBookBinding) a1()).tvPlayerTimer.setText(getString(R.string.listened_current_chapter));
        } else if (readAloudBook.s() == 0) {
            ((ActivityAudioBookBinding) a1()).tvPlayerTimer.setText(getString(R.string.ting_shu_clock));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        W2(intent);
        g(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(((ActivityAudioBookBinding) a1()).bottomSheet);
        this.bottomSheetBehavior = from;
        if (from != null) {
            from.setDraggable(true);
        }
        BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setSkipCollapsed(true);
        }
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.bottomSheetBehavior;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.setPeekHeight(0);
        }
        BottomSheetBehavior<View> bottomSheetBehavior3 = this.bottomSheetBehavior;
        if (bottomSheetBehavior3 != null) {
            bottomSheetBehavior3.setHideable(true);
        }
        BottomSheetBehavior<View> bottomSheetBehavior4 = this.bottomSheetBehavior;
        if (bottomSheetBehavior4 != null) {
            bottomSheetBehavior4.setState(3);
        }
        BottomSheetBehavior<View> bottomSheetBehavior5 = this.bottomSheetBehavior;
        if (bottomSheetBehavior5 != null) {
            bottomSheetBehavior5.addBottomSheetCallback(new c());
        }
        V2();
        l3();
    }

    public final void c3() {
        AppViewModel l12;
        DownloadTtsEngineDialogFragment downloadTtsEngineDialogFragment = this.downloadTtsEngineDialogFragment;
        if (downloadTtsEngineDialogFragment != null) {
            downloadTtsEngineDialogFragment.dismiss();
        }
        this.downloadTtsEngineDialogFragment = null;
        if (TtsEnginesUtil.i(this) && (l12 = l1()) != null) {
            l12.I0();
        }
        m1().C(this);
    }

    @SuppressLint({"InflateParams"})
    public final void c4() {
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment;
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment2 = this.timerDialogFragment;
        if (martianBottomSheetDialogFragment2 != null && martianBottomSheetDialogFragment2 != null && martianBottomSheetDialogFragment2.isVisible() && (martianBottomSheetDialogFragment = this.timerDialogFragment) != null) {
            martianBottomSheetDialogFragment.dismiss();
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        View inflate = getLayoutInflater().inflate(R.layout.fragment_audio_book_timer_layout, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.timing_listview);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.timing_window_close);
        ((TextView) inflate.findViewById(R.id.tv_close)).setOnClickListener(new View.OnClickListener() { // from class: jd.i0
            public /* synthetic */ i0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.d4(AudiobookActivity.this, view);
            }
        });
        listView.setDividerHeight(0);
        ce.t tVar = new ce.t(ReadAloudBook.f15003a.s());
        this.tingShuClockAdapter = tVar;
        tVar.b(false);
        listView.setAdapter((ListAdapter) this.tingShuClockAdapter);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: jd.j0
            public /* synthetic */ j0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.e4(AudiobookActivity.this, view);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: jd.k0
            public /* synthetic */ k0() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                AudiobookActivity.f4(AudiobookActivity.this, adapterView, view, i10, j10);
            }
        });
        this.timerDialogFragment = com.martian.libmars.widget.dialog.a.g0(a10.y0(inflate).k0(true).j0(true).w0(true).s0(new j()), this, null, "listen_book_timer", true, 2, null);
    }

    public final void d3() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(m1()), Dispatchers.getMain(), null, new AudiobookActivity$setDownloadFinished$1(this, null), 2, null);
    }

    @SuppressLint({"SetTextI18n"})
    public final void e3(Integer percent) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(m1()), Dispatchers.getMain(), null, new AudiobookActivity$setDownloadProgress$1(this, percent, null), 2, null);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void f3(TextView view, @DrawableRes int drawableResId) {
        view.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(drawableResId, null), (Drawable) null, (Drawable) null);
    }

    public final void g3() {
        TTSReadManager.u(S2());
        TTSReadManager.t(T2());
        TTSReadManager.x(this, new Observer() { // from class: jd.n
            public /* synthetic */ n() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity.h3(AudiobookActivity.this, (Boolean) obj);
            }
        });
        TTSReadManager.y(this, new Observer() { // from class: jd.o
            public /* synthetic */ o() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity.i3(AudiobookActivity.this, (Long) obj);
            }
        });
        TTSReadManager.s(this, new Observer() { // from class: jd.p
            public /* synthetic */ p() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity.j3(AudiobookActivity.this, (Long) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g4(boolean loading) {
        if (loading) {
            ((ActivityAudioBookBinding) a1()).progressBar.setVisibility(0);
        } else {
            ((ActivityAudioBookBinding) a1()).progressBar.setVisibility(8);
        }
    }

    public final void h4() {
        if (m1().getBook() != null) {
            Book book = m1().getBook();
            if (TextUtils.isEmpty(book != null ? book.getSourceString() : null)) {
                return;
            }
            m1().E(getIntent().getIntExtra(B, 0));
            m1().F(getIntent().getIntExtra(C, 0));
            if (TTSReadManager.q()) {
                m1().H(true);
            }
            Book book2 = m1().getBook();
            String sourceString = book2 != null ? book2.getSourceString() : null;
            Intrinsics.checkNotNull(sourceString);
            TTSReadManager.k(this, sourceString, m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String(), m1().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.y java.lang.String());
        }
    }

    public final void i4() {
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        if (readAloudBook.a() != null) {
            Book a10 = readAloudBook.a();
            if (TextUtils.isEmpty(a10 != null ? a10.getSourceString() : null)) {
                return;
            }
            readAloudBook.y();
            n0 n0Var = n0.f33313a;
            WeakReference<Activity> e10 = n0Var.e(this);
            Activity activity = e10 != null ? e10.get() : null;
            if (activity != null && (activity instanceof ReadingNewActivity)) {
                ReadingNewActivity readingNewActivity = (ReadingNewActivity) activity;
                if (StringsKt.equals(readAloudBook.b(), readingNewActivity.g3(), true)) {
                    readingNewActivity.i4();
                    finish();
                    return;
                }
            }
            List<WeakReference<Activity>> d10 = n0Var.d(ReadingNewActivity.class);
            List<WeakReference<Activity>> list = d10;
            if (list != null && !list.isEmpty()) {
                Iterator<WeakReference<Activity>> it = d10.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Activity activity2 = it.next().get();
                    if (activity2 != null && (activity2 instanceof ReadingNewActivity)) {
                        ReadingNewActivity readingNewActivity2 = (ReadingNewActivity) activity2;
                        if (StringsKt.equals(ReadAloudBook.f15003a.b(), readingNewActivity2.g3(), true)) {
                            readingNewActivity2.finish();
                            break;
                        }
                    }
                }
            }
            ReadAloudBook readAloudBook2 = ReadAloudBook.f15003a;
            Book a11 = readAloudBook2.a();
            Integer valueOf = Integer.valueOf(readAloudBook2.c());
            Integer valueOf2 = Integer.valueOf(readAloudBook2.f());
            ChapterContent i10 = readAloudBook2.i();
            je.i.S(this, a11, valueOf, valueOf2, i10 != null ? Integer.valueOf(i10.getContentLength()) : null, true);
        }
    }

    public final void j4() {
        AudiobookChapterListFragment.INSTANCE.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k3(List<? extends TYBookItem> bookList) {
        int i10 = 8;
        ((ActivityAudioBookBinding) a1()).bookMoreProgressbar.setVisibility(8);
        ((ActivityAudioBookBinding) a1()).ivRefresh.setVisibility(0);
        if (this.bookAdapter == null) {
            if (((ActivityAudioBookBinding) a1()).rvGridBooks.getLayoutManager() == null) {
                AudiobookRecommendAdapter.Companion companion = AudiobookRecommendAdapter.INSTANCE;
                ((ActivityAudioBookBinding) a1()).rvGridBooks.setLayoutManager(new GridLayoutManager(this, companion.a()));
                ((ActivityAudioBookBinding) a1()).rvGridBooks.addItemDecoration(new GridSpaceItemDecoration(companion.a(), 0.0f, (((getResources().getDisplayMetrics().widthPixels - ConfigSingleton.i(48.0f)) - ConfigSingleton.i(r3 * 69.0f)) / r3) - 1));
            }
            this.bookAdapter = new AudiobookRecommendAdapter();
            ((ActivityAudioBookBinding) a1()).rvGridBooks.setAdapter(this.bookAdapter);
        }
        AudiobookRecommendAdapter audiobookRecommendAdapter = this.bookAdapter;
        if (audiobookRecommendAdapter != null) {
            audiobookRecommendAdapter.o(bookList);
        }
        LinearLayout linearLayout = ((ActivityAudioBookBinding) a1()).llRecommendRoot;
        List<? extends TYBookItem> list = bookList;
        if (list != null && !list.isEmpty()) {
            i10 = 0;
        }
        linearLayout.setVisibility(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void k4(long timeSecond) {
        this.timeSecond = timeSecond;
        if (timeSecond <= -1 || MiConfigSingleton.b2().E2()) {
            ((ActivityAudioBookBinding) a1()).clAvailableTime.setVisibility(8);
            return;
        }
        ((ActivityAudioBookBinding) a1()).clAvailableTime.setVisibility(0);
        if (MiConfigSingleton.b2().C2()) {
            ((ActivityAudioBookBinding) a1()).tvGoUnlock.setVisibility(8);
        } else {
            ((ActivityAudioBookBinding) a1()).tvGoUnlock.setVisibility(0);
        }
        if (timeSecond == 0) {
            ((ActivityAudioBookBinding) a1()).tvAvailableTime.setText(ExtKt.c("听书时长用完了"));
            return;
        }
        String R2 = R2(timeSecond);
        if (TtsTimeController.f15066a.h() == TtsTimeController.TimeMode.MODE_ACCUMULATED_DURATION) {
            ((ActivityAudioBookBinding) a1()).tvAvailableTime.setText(ExtKt.c("听书可用时长：") + R2);
            return;
        }
        ((ActivityAudioBookBinding) a1()).tvAvailableTime.setText(ExtKt.c("听书到期还有： ") + R2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l3() {
        NonStickyLiveData<Pair<Integer, Object>> S;
        NonStickyLiveData<MartianRPAccount> Y;
        MutableLiveData<Boolean> c02;
        AppViewModel l12 = l1();
        if (l12 != null && (c02 = l12.c0()) != null) {
            c02.observe(this, new Observer() { // from class: jd.a
                public /* synthetic */ a() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AudiobookActivity.D3(Function1.this, obj);
                }
            });
        }
        ((ActivityAudioBookBinding) a1()).rlCover.setOnClickListener(new View.OnClickListener() { // from class: jd.c
            public /* synthetic */ c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.E3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).rlBuyVip.setOnClickListener(new View.OnClickListener() { // from class: jd.d
            public /* synthetic */ d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.F3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).tvGoUnlock.setOnClickListener(new View.OnClickListener() { // from class: jd.e
            public /* synthetic */ e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.m3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).tvPlayerTimer.setOnClickListener(new View.OnClickListener() { // from class: jd.f
            public /* synthetic */ f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.n3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).tvPlayerSpeechSpeed.setOnClickListener(new View.OnClickListener() { // from class: jd.g
            public /* synthetic */ g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.o3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).tvPlayerSoundSettings.setOnClickListener(new View.OnClickListener() { // from class: jd.h
            public /* synthetic */ h() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.p3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).ivContentEnlarge.setOnClickListener(new View.OnClickListener() { // from class: jd.i
            public /* synthetic */ i() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.q3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).tvPlayerListenAndRead.setOnClickListener(new View.OnClickListener() { // from class: jd.j
            public /* synthetic */ j() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.r3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).tvPlayerAddBookshelf.setOnClickListener(new View.OnClickListener() { // from class: jd.k
            public /* synthetic */ k() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.s3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).tvPlayerChapter.setOnClickListener(new View.OnClickListener() { // from class: jd.l
            public /* synthetic */ l() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.t3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).ivPlayerPlay.setOnClickListener(new View.OnClickListener() { // from class: jd.w
            public /* synthetic */ w() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.u3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).ivPlayerNext.setOnClickListener(new View.OnClickListener() { // from class: jd.h0
            public /* synthetic */ h0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.v3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).ivPlayerPrev.setOnClickListener(new View.OnClickListener() { // from class: jd.l0
            public /* synthetic */ l0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.w3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).tvListenBookInterrupt.setOnClickListener(new View.OnClickListener() { // from class: jd.m0
            public /* synthetic */ m0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.x3(AudiobookActivity.this, view);
            }
        });
        ((ActivityAudioBookBinding) a1()).seekBar.setOnSeekBarChangeListener(new d());
        m1().w().observe(this, new Observer() { // from class: jd.n0
            public /* synthetic */ n0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity.y3(Function1.this, obj);
            }
        });
        ((ActivityAudioBookBinding) a1()).rlRefresh.setOnClickListener(new View.OnClickListener() { // from class: jd.o0
            public /* synthetic */ o0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.z3(AudiobookActivity.this, view);
            }
        });
        AppViewModel l13 = l1();
        if (l13 != null && (Y = l13.Y()) != null) {
            Y.observe(this, new Observer() { // from class: jd.p0
                public /* synthetic */ p0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AudiobookActivity.A3(Function1.this, obj);
                }
            });
        }
        AppViewModel l14 = l1();
        if (l14 != null && (S = l14.S()) != null) {
            S.observe(this, new Observer() { // from class: jd.q0
                public /* synthetic */ q0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AudiobookActivity.B3(Function1.this, obj);
                }
            });
        }
        m1().v().observe(this, new Observer() { // from class: jd.b
            public /* synthetic */ b() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity.C3(Function1.this, obj);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @l Intent r32) {
        super.onActivityResult(requestCode, resultCode, r32);
        if (resultCode == 1001) {
            TtsEnginesUtil.k(this, TtsEnginesUtil.EngineMode.GOOGLE);
            if (Intrinsics.areEqual(TtsEnginesUtil.f15064c, TtsEnginesUtil.a(this))) {
                return;
            }
            m1().C(this);
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment = this.timerDialogFragment;
        if (martianBottomSheetDialogFragment != null && martianBottomSheetDialogFragment.isVisible()) {
            MartianBottomSheetDialogFragment martianBottomSheetDialogFragment2 = this.timerDialogFragment;
            if (martianBottomSheetDialogFragment2 != null) {
                martianBottomSheetDialogFragment2.dismiss();
            }
            this.timerDialogFragment = null;
        }
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment3 = this.speechSpeedDialogFragment;
        if (martianBottomSheetDialogFragment3 != null && martianBottomSheetDialogFragment3.isVisible()) {
            MartianBottomSheetDialogFragment martianBottomSheetDialogFragment4 = this.speechSpeedDialogFragment;
            if (martianBottomSheetDialogFragment4 != null) {
                martianBottomSheetDialogFragment4.dismiss();
            }
            this.speechSpeedDialogFragment = null;
        }
        MartianDialogFragment martianDialogFragment = this.noneAvailableTimeDialogFragment;
        if (martianDialogFragment != null && martianDialogFragment.isVisible()) {
            MartianDialogFragment martianDialogFragment2 = this.noneAvailableTimeDialogFragment;
            if (martianDialogFragment2 != null) {
                martianDialogFragment2.dismiss();
            }
            this.noneAvailableTimeDialogFragment = null;
        }
        TtsTimeController.u(this);
        TTSReadManager.z(T2());
        TTSReadManager.A(S2());
        r rVar = this.audiobookAdManager;
        if (rVar != null) {
            rVar.m();
        }
        this.audiobookAdManager = null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@l Intent intent) {
        super.onNewIntent(intent);
        overridePendingTransition(com.martian.libmars.R.anim.activity_pop_in, com.martian.libmars.R.anim.activity_fade_out);
        if (intent != null) {
            if ((intent.getFlags() | 131072) > 0 && !isTaskRoot()) {
                Object systemService = getSystemService(TTDownloadField.TT_ACTIVITY);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                ((ActivityManager) systemService).moveTaskToFront(getTaskId(), 2);
            }
            W2(intent);
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String a10 = TtsEnginesUtil.a(this);
        String str = this.systemDefaultEngine;
        if (str != null && !Intrinsics.areEqual(str, a10)) {
            this.systemDefaultEngine = a10;
            TtsEnginesUtil.EngineMode d10 = TtsEnginesUtil.d(this);
            TtsEnginesUtil.EngineMode engineMode = TtsEnginesUtil.EngineMode.SYSTEM;
            if (d10 == engineMode || (d10 == TtsEnginesUtil.EngineMode.GOOGLE && !Intrinsics.areEqual(TtsEnginesUtil.f15064c, a10))) {
                TtsEnginesUtil.k(this, engineMode);
                c3();
                ac.a.W(this, "切换引擎-重启听书");
                return;
            }
        }
        TtsEnginesUtil ttsEnginesUtil = TtsEnginesUtil.f15062a;
        if (ttsEnginesUtil.h()) {
            if (TtsEnginesUtil.i(this)) {
                ttsEnginesUtil.j(false);
                ac.a.W(this, "安装Google引擎-重启听书");
                c3();
            }
            I3();
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void r1() {
        setTheme(MiConfigSingleton.b2().r2().e().themeTranslucent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        super.s1(toolbarBinding);
        com.gyf.immersionbar.d.l2(this, ((ActivityAudioBookBinding) a1()).actionbarTopView);
        ((ActivityAudioBookBinding) a1()).ivClose.setOnClickListener(new View.OnClickListener() { // from class: jd.m
            public /* synthetic */ m() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiobookActivity.Z2(AudiobookActivity.this, view);
            }
        });
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void u1() {
        overridePendingTransition(com.martian.libmars.R.anim.activity_pop_in, com.martian.libmars.R.anim.activity_fade_out);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void v1() {
        overridePendingTransition(0, com.martian.libmars.R.anim.activity_pop_out);
    }
}
