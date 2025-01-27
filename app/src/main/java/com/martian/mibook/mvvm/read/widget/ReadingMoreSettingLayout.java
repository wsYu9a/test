package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import ba.h;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.ClipPagerTitleView;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ReaderMoreSettingLayoutBinding;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReadingMoreSettingLayout;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.ui.reader.ReaderThemeSwitchButton;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import m9.b;
import m9.d;
import m9.g;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\nJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\nJ\r\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\nR$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010(\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0004\u0018\u0001028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0004\u0018\u0001068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingMoreSettingLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "v", "()V", bt.aO, "u", "N", "L", "M", "J", t.f11211k, "Q", "O", "q", "P", "", "index", "K", "(I)V", "s", "R", ExifInterface.LATITUDE_SOUTH, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "lightTimesStrings", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "c", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Landroidx/fragment/app/FragmentActivity;", "d", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/martian/mibook/databinding/ReaderMoreSettingLayoutBinding;", e.TAG, "Lcom/martian/mibook/databinding/ReaderMoreSettingLayoutBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "Lgd/a;", "getSlidingCallBack", "()Lgd/a;", "slidingCallBack", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingMoreSettingLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingMoreSettingLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingMoreSettingLayout\n+ 2 Ext.kt\ncom/martian/mibook/mvvm/extensions/ExtKt\n*L\n1#1,400:1\n26#2:401\n*S KotlinDebug\n*F\n+ 1 ReadingMoreSettingLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingMoreSettingLayout\n*L\n47#1:401\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingMoreSettingLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final ArrayList<String> lightTimesStrings;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Lazy com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: e */
    @k
    public final ReaderMoreSettingLayoutBinding mViewBinding;

    public static final class a extends b {

        /* renamed from: c */
        public final /* synthetic */ d f14966c;

        public a(d dVar) {
            this.f14966c = dVar;
        }

        public static final void j(d helper, int i10, ReadingMoreSettingLayout this$0, View view) {
            Intrinsics.checkNotNullParameter(helper, "$helper");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            helper.j(i10, true);
            this$0.K(i10);
        }

        @Override // m9.b
        public int a() {
            return ReadingMoreSettingLayout.this.lightTimesStrings.size();
        }

        @Override // m9.b
        @k
        public m9.e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setXOffset(ConfigSingleton.i(2.0f));
            linePagerIndicator.h(ConfigSingleton.i(2.0f)).j(ConfigSingleton.i(16.0f)).d(Integer.valueOf(MiConfigSingleton.b2().h2().k().getPopupBackgroundColor()));
            return linePagerIndicator;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
            clipPagerTitleView.setTypeFace(MiConfigSingleton.b2().i2().g());
            int i11 = ConfigSingleton.i(8.0f);
            clipPagerTitleView.setTextSize(ConfigSingleton.i(12.0f));
            clipPagerTitleView.setPadding(0, i11, 0, i11);
            Object obj = ReadingMoreSettingLayout.this.lightTimesStrings.get(i10);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            clipPagerTitleView.setText((String) obj);
            int textColorPrimary = MiConfigSingleton.b2().h2().k().getTextColorPrimary();
            clipPagerTitleView.setTextColor(textColorPrimary);
            clipPagerTitleView.setSelectTextColor(textColorPrimary);
            clipPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: hd.u2

                /* renamed from: c */
                public final /* synthetic */ int f26659c;

                /* renamed from: d */
                public final /* synthetic */ ReadingMoreSettingLayout f26660d;

                public /* synthetic */ u2(int i102, ReadingMoreSettingLayout readingMoreSettingLayout) {
                    i10 = i102;
                    readingMoreSettingLayout = readingMoreSettingLayout;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingMoreSettingLayout.a.j(m9.d.this, i10, readingMoreSettingLayout, view);
                }
            });
            return clipPagerTitleView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingMoreSettingLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void A(ReadingMoreSettingLayout this$0, CompoundButton compoundButton, boolean z10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z10 || MiConfigSingleton.b2().K2()) {
            this$0.N();
            return;
        }
        this$0.mViewBinding.volumeSlidePagePrefKey.post(new Runnable() { // from class: hd.k2
            public /* synthetic */ k2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReadingMoreSettingLayout.B(ReadingMoreSettingLayout.this);
            }
        });
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.F0("音量键翻页");
        }
    }

    public static final void B(ReadingMoreSettingLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mViewBinding.volumeSlidePagePrefKey.setChecked(false);
    }

    public static final void C(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L();
    }

    public static final void D(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
    }

    public static final void E(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
    }

    public static final void F(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
    }

    public static final void G(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q();
    }

    public static final void H(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O();
    }

    public static final void I(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getValue();
    }

    private final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    private final com.martian.mibook.mvvm.read.widget.a getReadMenuCallBack() {
        Object context = getContext();
        if (context instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) context;
        }
        return null;
    }

    private final gd.a getSlidingCallBack() {
        Object context = getContext();
        if (context instanceof gd.a) {
            return (gd.a) context;
        }
        return null;
    }

    public static final void w(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s();
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.q0();
        }
    }

    public static final void x(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P();
    }

    public static final void y(ReadingMoreSettingLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.M();
        }
    }

    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void J() {
        boolean isChecked = this.mViewBinding.alwaysShowVirtualKeyPrefKey.isChecked();
        ac.a.L(getContext(), "虚拟键-" + (isChecked ? "显示" : "隐藏"));
        ReadingInstance.z().b0(getContext(), isChecked);
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            a.C0540a.d(readMenuCallBack, false, 1, null);
        }
    }

    public final void K(int index) {
        if (index == 0) {
            ac.a.M(getContext(), "屏幕关闭-系统");
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
            if (readMenuCallBack != null) {
                readMenuCallBack.j0(ReadingInstance.ScreenOffTime.System, true);
                return;
            }
            return;
        }
        if (index == 1) {
            ac.a.M(getContext(), "屏幕关闭-5分钟");
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack2 = getReadMenuCallBack();
            if (readMenuCallBack2 != null) {
                readMenuCallBack2.j0(ReadingInstance.ScreenOffTime.FiveMinutes, true);
                return;
            }
            return;
        }
        if (index == 2) {
            ac.a.M(getContext(), "屏幕关闭-10分钟");
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack3 = getReadMenuCallBack();
            if (readMenuCallBack3 != null) {
                readMenuCallBack3.j0(ReadingInstance.ScreenOffTime.TenMinutes, true);
                return;
            }
            return;
        }
        if (index != 3) {
            return;
        }
        ac.a.M(getContext(), "屏幕关闭-常亮");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack4 = getReadMenuCallBack();
        if (readMenuCallBack4 != null) {
            readMenuCallBack4.j0(ReadingInstance.ScreenOffTime.AlwaysLight, true);
        }
    }

    public final void L() {
        ac.a.L(getContext(), "下拉页面快捷添加书签");
        boolean isChecked = this.mViewBinding.prefPullDownAddBookmarkEnable.isChecked();
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null) {
            mViewModel.U2(isChecked, 1);
        }
        ReadingInstance.z().n0(getContext(), isChecked);
        gd.a slidingCallBack = getSlidingCallBack();
        if (slidingCallBack != null) {
            slidingCallBack.f0();
        }
    }

    public final void M() {
        boolean isChecked = this.mViewBinding.prefSliderCacheEnable.isChecked();
        ac.a.L(getContext(), "翻页优化-" + (isChecked ? "开" : "关"));
        ReadingInstance.z().u0(getContext(), isChecked);
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.v0();
        }
    }

    public final void N() {
        ac.a.L(getContext(), "音量键翻页");
        ReadingInstance.z().x0(getContext(), this.mViewBinding.volumeSlidePagePrefKey.isChecked());
    }

    public final void O() {
        ac.a.L(getContext(), "切换横竖屏");
        ReadingInstance.z().X(getContext());
        i.B(getActivity());
    }

    public final void P() {
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.f(!ReadingInstance.z().B0(getContext()), false);
        }
    }

    public final void Q() {
        boolean isChecked = this.mViewBinding.prefTraditionalChinese.isChecked();
        ac.a.L(getContext(), "字体-" + (isChecked ? "繁体" : "简体"));
        MiConfigSingleton.b2().l1(isChecked);
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.L0();
        }
    }

    public final void R() {
        if (h.e(getContext())) {
            this.mViewBinding.pushNotification.setVisibility(8);
            this.mViewBinding.pushNotificationDivider.setVisibility(8);
            this.mViewBinding.pushNotificationStatus.setText(getContext().getString(R.string.push_notification_opened));
        } else {
            this.mViewBinding.pushNotification.setVisibility(0);
            this.mViewBinding.pushNotificationDivider.setVisibility(0);
            this.mViewBinding.pushNotificationStatus.setText(getContext().getString(R.string.push_notification_closed));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r0.getIsScrollMode() == true) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S() {
        /*
            r5 = this;
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r0 = r5.getMViewModel()
            r1 = 0
            if (r0 == 0) goto Lf
            boolean r0 = r0.getIsScrollMode()
            r2 = 1
            if (r0 != r2) goto Lf
            goto L10
        Lf:
            r2 = 0
        L10:
            com.martian.mibook.databinding.ReaderMoreSettingLayoutBinding r0 = r5.mViewBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.clPullDownAddBookmark
            r3 = 8
            if (r2 == 0) goto L1b
            r4 = 8
            goto L1c
        L1b:
            r4 = 0
        L1c:
            r0.setVisibility(r4)
            com.martian.mibook.databinding.ReaderMoreSettingLayoutBinding r0 = r5.mViewBinding
            com.martian.libmars.ui.theme.ThemeImageView r0 = r0.pullDownAddBookmarkDivider
            if (r2 == 0) goto L27
            r1 = 8
        L27:
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.widget.ReadingMoreSettingLayout.S():void");
    }

    public final void q() {
        ac.a.L(getContext(), "自动加入书架");
        ReadingInstance.z().c0(getContext(), this.mViewBinding.prefAutoAddBookshelf.isChecked());
    }

    public final void r() {
        ac.a.L(getContext(), "自动购买下一章");
        MiUserManager.q().y(this.mViewBinding.autoBuyNextChapterPrefKey.isChecked());
    }

    public final void s() {
        Object parent = this.mViewBinding.getRoot().getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setTag(Boolean.FALSE);
            BottomSheetBehavior from = BottomSheetBehavior.from(view);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(5);
        }
    }

    public final void t() {
        if (com.gyf.immersionbar.d.Q0(getContext())) {
            this.mViewBinding.clAlwaysShowVirtualKey.setVisibility(0);
            this.mViewBinding.alwaysShowVirtualKeyPrefKeyDivider.setVisibility(0);
            this.mViewBinding.alwaysShowVirtualKeyPrefKey.setChecked(ReadingInstance.z().f(getContext()));
        } else {
            this.mViewBinding.clAlwaysShowVirtualKey.setVisibility(8);
            this.mViewBinding.alwaysShowVirtualKeyPrefKeyDivider.setVisibility(8);
        }
        this.mViewBinding.volumeSlidePagePrefKey.setChecked(ReadingInstance.z().i(getContext()) && MiConfigSingleton.b2().K2());
        ReaderThemeSwitchButton readerThemeSwitchButton = this.mViewBinding.prefPullDownAddBookmarkEnable;
        ReadingViewModel mViewModel = getMViewModel();
        readerThemeSwitchButton.setChecked(mViewModel != null ? mViewModel.n1(1) : false);
        this.mViewBinding.prefSliderCacheEnable.setChecked(ReadingInstance.z().T(getContext()));
        if (!ReadingInstance.z().S(getContext())) {
            this.mViewBinding.clSliderCacheEnable.setVisibility(8);
            this.mViewBinding.prefSliderCacheEnableDivider.setVisibility(8);
        }
        S();
        boolean I2 = MiConfigSingleton.b2().I2();
        this.mViewBinding.clAutoBuyNextChapter.setVisibility(I2 ? 0 : 8);
        this.mViewBinding.autoBuyNextChapterPrefKeyLine.setVisibility(I2 ? 0 : 8);
        this.mViewBinding.autoBuyNextChapterPrefKey.setChecked(MiUserManager.q().v());
        this.mViewBinding.prefTraditionalChinese.setChecked(MiConfigSingleton.b2().M0());
        this.mViewBinding.prefAutoAddBookshelf.setChecked(ReadingInstance.z().K(getContext()));
        ReadingViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 == null || !mViewModel2.getShowChapterComment()) {
            this.mViewBinding.clChapterComment.setVisibility(8);
            this.mViewBinding.prefChapterCommentDivider.setVisibility(8);
        } else {
            this.mViewBinding.prefChapterComment.setChecked(ReadingInstance.z().B0(getContext()));
        }
        this.mViewBinding.prefOrientation.setChecked(!ReadingInstance.z().O(getContext()));
        if (ReadingInstance.z().M(getContext()) || !ReadingInstance.z().O(getContext()) || MiConfigSingleton.b2().B0()) {
            this.mViewBinding.clOrientation.setVisibility(0);
            this.mViewBinding.prefOrientationDivider.setVisibility(0);
        } else {
            this.mViewBinding.clOrientation.setVisibility(8);
            this.mViewBinding.prefOrientationDivider.setVisibility(8);
        }
        R();
        u();
    }

    public final void u() {
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setMarginHorizontal(0);
        d dVar = new d();
        commonNavigator.setAdapter(new a(dVar));
        this.mViewBinding.magicIndicatorLightTimes.setBackground(MiConfigSingleton.b2().h2().k().getRoundBgResTextThirdlyDrawable(getContext()));
        this.mViewBinding.magicIndicatorLightTimes.setNavigator(commonNavigator);
        dVar.d(this.mViewBinding.magicIndicatorLightTimes);
        dVar.j(ReadingInstance.z().y(getContext()), false);
    }

    @SuppressLint({"NotifyDataSetChanged", "ClickableViewAccessibility", "SetTextI18n"})
    public final void v() {
        AppViewModel l12;
        MutableLiveData<Unit> i02;
        this.mViewBinding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: hd.h2
            public /* synthetic */ h2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.w(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.volumeSlidePagePrefKey.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: hd.n2
            public /* synthetic */ n2() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ReadingMoreSettingLayout.A(ReadingMoreSettingLayout.this, compoundButton, z10);
            }
        });
        this.mViewBinding.prefPullDownAddBookmarkEnable.setOnClickListener(new View.OnClickListener() { // from class: hd.o2
            public /* synthetic */ o2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.C(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.prefSliderCacheEnable.setOnClickListener(new View.OnClickListener() { // from class: hd.p2
            public /* synthetic */ p2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.D(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.alwaysShowVirtualKeyPrefKey.setOnClickListener(new View.OnClickListener() { // from class: hd.q2
            public /* synthetic */ q2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.E(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.autoBuyNextChapterPrefKey.setOnClickListener(new View.OnClickListener() { // from class: hd.r2
            public /* synthetic */ r2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.F(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.prefTraditionalChinese.setOnClickListener(new View.OnClickListener() { // from class: hd.s2
            public /* synthetic */ s2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.G(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.prefOrientation.setOnClickListener(new View.OnClickListener() { // from class: hd.t2
            public /* synthetic */ t2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.H(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.prefAutoAddBookshelf.setOnClickListener(new View.OnClickListener() { // from class: hd.i2
            public /* synthetic */ i2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.I(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.prefChapterComment.setOnClickListener(new View.OnClickListener() { // from class: hd.j2
            public /* synthetic */ j2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.x(ReadingMoreSettingLayout.this, view);
            }
        });
        this.mViewBinding.pushNotification.setOnClickListener(new View.OnClickListener() { // from class: hd.l2
            public /* synthetic */ l2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreSettingLayout.y(ReadingMoreSettingLayout.this, view);
            }
        });
        FragmentActivity activity = getActivity();
        BaseMVVMActivity baseMVVMActivity = activity instanceof BaseMVVMActivity ? (BaseMVVMActivity) activity : null;
        if (baseMVVMActivity == null || (l12 = baseMVVMActivity.l1()) == null || (i02 = l12.i0()) == null) {
            return;
        }
        i02.observe(baseMVVMActivity, new Observer() { // from class: hd.m2
            public /* synthetic */ m2() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingMoreSettingLayout.z(Function1.this, obj);
            }
        });
    }

    public /* synthetic */ ReadingMoreSettingLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingMoreSettingLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lightTimesStrings = CollectionsKt.arrayListOf("系统", "5分钟", "10分钟", "常亮");
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingMoreSettingLayout$special$$inlined$activityViewModel$1
            final /* synthetic */ View $this_activityViewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingMoreSettingLayout$special$$inlined$activityViewModel$1(View this) {
                super(0);
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                Context context2 = this.getContext();
                FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null;
                if (fragmentActivity == null || !(fragmentActivity instanceof BaseMVVMActivity)) {
                    return null;
                }
                BaseViewModel m12 = ((BaseMVVMActivity) fragmentActivity).m1();
                return (ReadingViewModel) (m12 instanceof ReadingViewModel ? m12 : null);
            }
        });
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingMoreSettingLayout$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingMoreSettingLayout$activity$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final FragmentActivity invoke() {
                Context context2 = context;
                if (context2 instanceof FragmentActivity) {
                    return (FragmentActivity) context2;
                }
                return null;
            }
        });
        ReaderMoreSettingLayoutBinding inflate = ReaderMoreSettingLayoutBinding.inflate(LayoutInflater.from(context2), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        v();
        t();
    }
}
