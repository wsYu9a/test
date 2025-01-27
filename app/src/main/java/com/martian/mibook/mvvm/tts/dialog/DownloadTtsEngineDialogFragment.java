package com.martian.mibook.mvvm.tts.dialog;

import ac.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import ba.m;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.dialog.MartianDialogFragment;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogDownloadTtsEngineBinding;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment;
import com.martian.mibook.mvvm.tts.viewmodel.AudiobookViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import i8.g;
import java.io.File;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import lc.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/martian/mibook/mvvm/tts/dialog/DownloadTtsEngineDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianDialogFragment;", "<init>", "()V", "", "B", "Landroid/view/View;", "view", "n", "(Landroid/view/View;)V", "k", "()Landroid/view/View;", "I", "", "percent", "K", "(Ljava/lang/Integer;)V", "Lcom/martian/mibook/databinding/DialogDownloadTtsEngineBinding;", "f", "Lcom/martian/mibook/databinding/DialogDownloadTtsEngineBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "g", "Lkotlin/Lazy;", "y", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Lcom/martian/mibook/mvvm/tts/viewmodel/AudiobookViewModel;", "h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/martian/mibook/mvvm/tts/viewmodel/AudiobookViewModel;", "mViewModel", "i", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class DownloadTtsEngineDialogFragment extends MartianDialogFragment {

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j */
    @k
    public static final String f15138j = "http://scdn.taoyuewenhua.net/app/tts/google-speech-tts-signed-cn-en.apk";

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public DialogDownloadTtsEngineBinding mViewBinding;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment$appViewModel$2
        public DownloadTtsEngineDialogFragment$appViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return b.a(DownloadTtsEngineDialogFragment.this.getContext());
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<AudiobookViewModel>() { // from class: com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment$mViewModel$2
        public DownloadTtsEngineDialogFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AudiobookViewModel invoke() {
            FragmentActivity activity = DownloadTtsEngineDialogFragment.this.getActivity();
            if (activity == null) {
                return null;
            }
            return (AudiobookViewModel) new ViewModelProvider(activity).get(AudiobookViewModel.class);
        }
    });

    /* renamed from: com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(Companion companion, Context context, AppViewModel appViewModel, Function0 function0, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                function0 = null;
            }
            companion.a(context, appViewModel, function0);
        }

        @JvmStatic
        public final void a(@k Context context, @l AppViewModel appViewModel, @l Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(c());
            if (file.exists() && file.canRead()) {
                a.W(context, "Google下载弹窗-安装");
                g.k(context, file);
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            if (MiConfigSingleton.b2().K2()) {
                a.W(context, "Google下载弹窗-下载");
                if (appViewModel != null) {
                    AppViewModel.L(appViewModel, DownloadTtsEngineDialogFragment.f15138j, c(), null, 4, null);
                    return;
                }
                return;
            }
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
                Book a10 = readAloudBook.a();
                String sourceName = a10 != null ? a10.getSourceName() : null;
                Book a11 = readAloudBook.a();
                i.e0(activity, "听书-谷歌", sourceName, a11 != null ? a11.getSourceId() : null);
            }
        }

        @JvmStatic
        @k
        public final String c() {
            return ba.b.f() + "google-speech-tts.apk";
        }

        @JvmStatic
        public final boolean d() {
            File file = new File(c());
            return file.exists() && file.canRead();
        }

        @JvmStatic
        @k
        public final DownloadTtsEngineDialogFragment e(@k FragmentActivity fragmentActivity, @l DialogInterface.OnDismissListener onDismissListener) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
            com.martian.libmars.widget.dialog.b a10 = MartianDialogFragment.INSTANCE.a();
            DownloadTtsEngineDialogFragment downloadTtsEngineDialogFragment = new DownloadTtsEngineDialogFragment();
            com.martian.libmars.widget.dialog.b.H(a10.J(true).I(true).L(onDismissListener), fragmentActivity, downloadTtsEngineDialogFragment, "DownloadTtsEngineDialogFragment", false, 8, null);
            return downloadTtsEngineDialogFragment;
        }

        public Companion() {
        }
    }

    private final AudiobookViewModel A() {
        return (AudiobookViewModel) this.mViewModel.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    private final void B() {
        ThemeTextView themeTextView;
        NonStickyLiveData<Pair<Integer, Object>> S;
        RelativeLayout relativeLayout;
        if (INSTANCE.d()) {
            DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding = this.mViewBinding;
            themeTextView = dialogDownloadTtsEngineBinding != null ? dialogDownloadTtsEngineBinding.tvDownload : null;
            if (themeTextView != null) {
                themeTextView.setText(ExtKt.c("安装听书插件"));
            }
        } else {
            DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding2 = this.mViewBinding;
            themeTextView = dialogDownloadTtsEngineBinding2 != null ? dialogDownloadTtsEngineBinding2.tvDownload : null;
            if (themeTextView != null) {
                themeTextView.setText(ExtKt.c("下载听书插件"));
            }
        }
        DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding3 = this.mViewBinding;
        if (dialogDownloadTtsEngineBinding3 != null && (relativeLayout = dialogDownloadTtsEngineBinding3.rlDownload) != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: ld.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadTtsEngineDialogFragment.C(DownloadTtsEngineDialogFragment.this, view);
                }
            });
        }
        AppViewModel y10 = y();
        if (y10 == null || (S = y10.S()) == null) {
            return;
        }
        S.observe(this, new Observer() { // from class: ld.b
            public /* synthetic */ b() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DownloadTtsEngineDialogFragment.G(Function1.this, obj);
            }
        });
    }

    public static final void C(DownloadTtsEngineDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            AudiobookViewModel A = this$0.A();
            if (A != null) {
                A.I(Boolean.valueOf(MiConfigSingleton.b2().K2()));
            }
            INSTANCE.a(context, this$0.y(), new Function0<Unit>() { // from class: com.martian.mibook.mvvm.tts.dialog.DownloadTtsEngineDialogFragment$initListener$1$1$1
                public DownloadTtsEngineDialogFragment$initListener$1$1$1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke */
                public final void invoke2() {
                    DownloadTtsEngineDialogFragment.this.dismiss();
                }
            });
        }
    }

    public static final void G(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @JvmStatic
    public static final boolean H() {
        return INSTANCE.d();
    }

    @JvmStatic
    @k
    public static final DownloadTtsEngineDialogFragment M(@k FragmentActivity fragmentActivity, @l DialogInterface.OnDismissListener onDismissListener) {
        return INSTANCE.e(fragmentActivity, onDismissListener);
    }

    @JvmStatic
    public static final void x(@k Context context, @l AppViewModel appViewModel, @l Function0<Unit> function0) {
        INSTANCE.a(context, appViewModel, function0);
    }

    private final AppViewModel y() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    @JvmStatic
    @k
    public static final String z() {
        return INSTANCE.c();
    }

    @SuppressLint({"SetTextI18n"})
    public final void I() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(m()), Dispatchers.getMain(), null, new DownloadTtsEngineDialogFragment$setFinished$1(this, null), 2, null);
    }

    @SuppressLint({"SetTextI18n"})
    public final void K(Integer percent) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(m()), Dispatchers.getMain(), null, new DownloadTtsEngineDialogFragment$setProgress$1(this, percent, null), 2, null);
    }

    @Override // com.martian.libmars.widget.dialog.MartianDialogFragment
    @l
    public View k() {
        DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding = this.mViewBinding;
        if (dialogDownloadTtsEngineBinding != null) {
            return dialogDownloadTtsEngineBinding.getRoot();
        }
        return null;
    }

    @Override // com.martian.libmars.widget.dialog.MartianDialogFragment
    @SuppressLint({"SetTextI18n"})
    public void n(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getLayoutParams().width = m.i(getContext());
        this.mViewBinding = DialogDownloadTtsEngineBinding.inflate(getLayoutInflater());
        super.n(view);
        DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding = this.mViewBinding;
        TextView textView = dialogDownloadTtsEngineBinding != null ? dialogDownloadTtsEngineBinding.tvTitle : null;
        if (textView != null) {
            textView.setText(ExtKt.c("缺少听书插件"));
        }
        DialogDownloadTtsEngineBinding dialogDownloadTtsEngineBinding2 = this.mViewBinding;
        TextView textView2 = dialogDownloadTtsEngineBinding2 != null ? dialogDownloadTtsEngineBinding2.tvDescription : null;
        if (textView2 != null) {
            textView2.setText(ExtKt.c("开通会员，下载听书插件，以修复听书功能(90.6M)"));
        }
        View k10 = k();
        ViewGroup.LayoutParams layoutParams = k10 != null ? k10.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            int i10 = ConfigSingleton.i(50.0f);
            marginLayoutParams.leftMargin = i10;
            marginLayoutParams.rightMargin = i10;
        }
        B();
    }
}
