package com.martian.mibook.mvvm.read.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.ScaleTransitionPagerTitleView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReaderThemeManager;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ReaderColorPickerLayoutBinding;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReadingColorPickerLayout;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.ui.colorpicker.LineColorPicker;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.m0;
import m9.d;
import m9.g;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ)\u0010\u001a\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010/\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0004\u0018\u0001048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingColorPickerLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "isBackgroundPictureMode", "", "setSelectTheme", "(Z)V", "x", "()V", bt.aJ, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "n", "m", IAdInterListener.AdReqParam.WIDTH, "y", "", "color", "Lcom/martian/mibook/ui/colorpicker/LineColorPicker;", "colorPicker", "colorPicker2", "B", "(Ljava/lang/Integer;Lcom/martian/mibook/ui/colorpicker/LineColorPicker;Lcom/martian/mibook/ui/colorpicker/LineColorPicker;)V", TTDownloadField.TT_TAG, "k", "(Ljava/lang/Boolean;)V", "b", "Z", "Lcom/martian/mibook/data/theme/MiReadingTheme;", "c", "Lcom/martian/mibook/data/theme/MiReadingTheme;", "preCustomBackgroundTheme", "d", "preCustomColorTheme", e.TAG, "Ljava/lang/Boolean;", "confirm", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "f", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/databinding/ReaderColorPickerLayoutBinding;", "g", "Lcom/martian/mibook/databinding/ReaderColorPickerLayoutBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingColorPickerLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    public boolean isBackgroundPictureMode;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public MiReadingTheme preCustomBackgroundTheme;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public MiReadingTheme preCustomColorTheme;

    /* renamed from: e */
    @l
    public Boolean confirm;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final ReaderColorPickerLayoutBinding mViewBinding;

    public static final class a implements ea.b {
        public a() {
        }

        @Override // ea.b
        public void permissionDenied() {
            ReadingColorPickerLayout.l(ReadingColorPickerLayout.this, null, 1, null);
        }

        @Override // ea.b
        public void permissionGranted() {
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack = ReadingColorPickerLayout.this.getReadMenuCallBack();
            if (readMenuCallBack != null) {
                readMenuCallBack.P0();
            }
        }
    }

    public static final class b implements ea.b {
        public b() {
        }

        @Override // ea.b
        public void permissionDenied() {
            ReadingColorPickerLayout.l(ReadingColorPickerLayout.this, null, 1, null);
        }

        @Override // ea.b
        public void permissionGranted() {
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack = ReadingColorPickerLayout.this.getReadMenuCallBack();
            if (readMenuCallBack != null) {
                readMenuCallBack.P0();
            }
        }
    }

    public static final class c extends m9.b {

        /* renamed from: b */
        public final /* synthetic */ CommonNavigator f14950b;

        /* renamed from: c */
        public final /* synthetic */ d f14951c;

        /* renamed from: d */
        public final /* synthetic */ ReadingColorPickerLayout f14952d;

        public c(CommonNavigator commonNavigator, d dVar, ReadingColorPickerLayout readingColorPickerLayout) {
            this.f14950b = commonNavigator;
            this.f14951c = dVar;
            this.f14952d = readingColorPickerLayout;
        }

        public static final void k(CommonNavigator commonNavigator, int i10, d helper, ReadingColorPickerLayout this$0, View view) {
            Intrinsics.checkNotNullParameter(commonNavigator, "$commonNavigator");
            Intrinsics.checkNotNullParameter(helper, "$helper");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (commonNavigator.getSelectedPosition() != i10) {
                helper.j(i10, true);
                view.postDelayed(new Runnable() { // from class: hd.z1

                    /* renamed from: b */
                    public final /* synthetic */ int f26681b;

                    /* renamed from: c */
                    public final /* synthetic */ ReadingColorPickerLayout f26682c;

                    public /* synthetic */ z1(int i102, ReadingColorPickerLayout this$02) {
                        i10 = i102;
                        this$0 = this$02;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadingColorPickerLayout.c.l(i10, this$0);
                    }
                }, 150L);
            }
        }

        public static final void l(int i10, ReadingColorPickerLayout this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i10 == 0) {
                this$0.setSelectTheme(true);
            } else {
                this$0.setSelectTheme(false);
            }
        }

        @Override // m9.b
        public int a() {
            return 2;
        }

        @Override // m9.b
        @l
        public m9.e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ScaleTransitionPagerTitleView scaleTransitionPagerTitleView = new ScaleTransitionPagerTitleView(context, false);
            scaleTransitionPagerTitleView.setText(context.getResources().getString(i10 == 0 ? R.string.picture : R.string.solid_color));
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setMaxScale(1.15f);
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            scaleTransitionPagerTitleView.setNormalColor(k10.getTextColorThirdly());
            scaleTransitionPagerTitleView.setSelectedColor(k10.getTextColorPrimary());
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: hd.a2

                /* renamed from: c */
                public final /* synthetic */ int f26550c;

                /* renamed from: d */
                public final /* synthetic */ m9.d f26551d;

                /* renamed from: e */
                public final /* synthetic */ ReadingColorPickerLayout f26552e;

                public /* synthetic */ a2(int i102, m9.d dVar, ReadingColorPickerLayout readingColorPickerLayout) {
                    i10 = i102;
                    dVar = dVar;
                    readingColorPickerLayout = readingColorPickerLayout;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingColorPickerLayout.c.k(CommonNavigator.this, i10, dVar, readingColorPickerLayout, view);
                }
            });
            return scaleTransitionPagerTitleView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingColorPickerLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    public final com.martian.mibook.mvvm.read.widget.a getReadMenuCallBack() {
        Object context = getContext();
        if (context instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) context;
        }
        return null;
    }

    public static /* synthetic */ void l(ReadingColorPickerLayout readingColorPickerLayout, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        readingColorPickerLayout.k(bool);
    }

    public static final void o(ReadingColorPickerLayout this$0, View view) {
        MiReadingTheme customTheme;
        MiReadingTheme customTheme2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.confirm = Boolean.FALSE;
        if (this$0.isBackgroundPictureMode) {
            ReadingViewModel mViewModel = this$0.getMViewModel();
            if (mViewModel != null && (customTheme2 = mViewModel.getCustomTheme()) != null) {
                customTheme2.updateTheme(this$0.preCustomBackgroundTheme);
            }
        } else {
            ReadingViewModel mViewModel2 = this$0.getMViewModel();
            if (mViewModel2 != null && (customTheme = mViewModel2.getCustomTheme()) != null) {
                customTheme.updateTheme(this$0.preCustomColorTheme);
            }
        }
        MiConfigSingleton.b2().h2().b();
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            a.C0540a.a(readMenuCallBack, false, 1, null);
        }
        l(this$0, null, 1, null);
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack2 = this$0.getReadMenuCallBack();
        if (readMenuCallBack2 != null) {
            readMenuCallBack2.u();
        }
    }

    public static final void p(ReadingColorPickerLayout this$0, View view) {
        MiReadingTheme customTheme;
        MiReadingTheme customTheme2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!MiConfigSingleton.b2().K2() && !MiConfigSingleton.b2().B0()) {
            Context context = this$0.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            ReadingViewModel mViewModel = this$0.getMViewModel();
            String sourceName = mViewModel != null ? mViewModel.getSourceName() : null;
            ReadingViewModel mViewModel2 = this$0.getMViewModel();
            i.e0(activity, "自定义背景", sourceName, mViewModel2 != null ? mViewModel2.getSourceId() : null);
            return;
        }
        ReadingViewModel mViewModel3 = this$0.getMViewModel();
        String backgroundImagePath = (mViewModel3 == null || (customTheme2 = mViewModel3.getCustomTheme()) == null) ? null : customTheme2.getBackgroundImagePath();
        if (this$0.isBackgroundPictureMode && TextUtils.isEmpty(backgroundImagePath)) {
            this$0.mViewBinding.tvUploadPictureTips.setVisibility(0);
            return;
        }
        this$0.confirm = Boolean.TRUE;
        ReadingViewModel mViewModel4 = this$0.getMViewModel();
        if (mViewModel4 != null && (customTheme = mViewModel4.getCustomTheme()) != null) {
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            customTheme.saveCustomTheme(context2);
            ReaderThemeManager h22 = MiConfigSingleton.b2().h2();
            Intrinsics.checkNotNullExpressionValue(h22, "getReaderThemeMgr(...)");
            ReaderThemeManager.x(h22, customTheme, null, 2, null);
        }
        MiConfigSingleton.b2().h2().b();
        this$0.k(null);
    }

    public static final void q(ReadingColorPickerLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isBackgroundPictureMode) {
            ea.c.m(this$0.getContext(), "图片读取", this$0.new a());
        }
    }

    public static final void r(ReadingColorPickerLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isBackgroundPictureMode) {
            ea.c.m(this$0.getContext(), "图片读取", this$0.new b());
        }
    }

    public static final void s(ReadingColorPickerLayout this$0, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReaderColorPickerLayoutBinding readerColorPickerLayoutBinding = this$0.mViewBinding;
        readerColorPickerLayoutBinding.colorPickerPrimary2.setColors(ee.a.b(readerColorPickerLayoutBinding.colorPickerPrimary.getColor()));
        ReaderColorPickerLayoutBinding readerColorPickerLayoutBinding2 = this$0.mViewBinding;
        readerColorPickerLayoutBinding2.colorPickerPrimary2.setSelectedColor(readerColorPickerLayoutBinding2.colorPickerPrimary.getColor());
    }

    public final void setSelectTheme(boolean isBackgroundPictureMode) {
        MiReadingTheme customTheme;
        this.isBackgroundPictureMode = isBackgroundPictureMode;
        if (isBackgroundPictureMode) {
            ReadingViewModel mViewModel = getMViewModel();
            if (mViewModel != null) {
                mViewModel.B2(this.preCustomBackgroundTheme);
            }
        } else {
            ReadingViewModel mViewModel2 = getMViewModel();
            if (mViewModel2 != null) {
                mViewModel2.B2(this.preCustomColorTheme);
            }
        }
        ReadingViewModel mViewModel3 = getMViewModel();
        if (mViewModel3 == null || (customTheme = mViewModel3.getCustomTheme()) == null) {
            return;
        }
        MiConfigSingleton.b2().h2().v(customTheme);
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            a.C0540a.a(readMenuCallBack, false, 1, null);
        }
        if (!isBackgroundPictureMode) {
            this.mViewBinding.tvStar.setVisibility(4);
            this.mViewBinding.ivImport.setImageResource(R.drawable.icon_no_import);
            this.mViewBinding.tvImportText.setText(getContext().getString(R.string.no_picture));
            this.mViewBinding.tvUploadPictureTips.setVisibility(8);
            this.mViewBinding.llSelectedPicture.setVisibility(8);
            this.mViewBinding.llWaitSelect.setVisibility(0);
            this.mViewBinding.llItemBackgroundPicture.setAlpha(0.4f);
            this.mViewBinding.llItemBackgroundPicture.setEnabled(false);
            this.mViewBinding.tvPrimary.setText(getContext().getString(R.string.background_color));
            this.mViewBinding.tvPrimary2.setText(getContext().getString(R.string.background_dark_light));
            this.mViewBinding.tvSecondary.setText(getContext().getString(R.string.text_color));
            this.mViewBinding.tvSecondary2.setText(getContext().getString(R.string.text_dark_light));
            Integer valueOf = Integer.valueOf(customTheme.getBackgroundColor());
            LineColorPicker colorPickerPrimary = this.mViewBinding.colorPickerPrimary;
            Intrinsics.checkNotNullExpressionValue(colorPickerPrimary, "colorPickerPrimary");
            LineColorPicker colorPickerPrimary2 = this.mViewBinding.colorPickerPrimary2;
            Intrinsics.checkNotNullExpressionValue(colorPickerPrimary2, "colorPickerPrimary2");
            B(valueOf, colorPickerPrimary, colorPickerPrimary2);
            Integer valueOf2 = Integer.valueOf(customTheme.getTextColorPrimary());
            LineColorPicker colorPickerSecondary = this.mViewBinding.colorPickerSecondary;
            Intrinsics.checkNotNullExpressionValue(colorPickerSecondary, "colorPickerSecondary");
            LineColorPicker colorPickerSecondary2 = this.mViewBinding.colorPickerSecondary2;
            Intrinsics.checkNotNullExpressionValue(colorPickerSecondary2, "colorPickerSecondary2");
            B(valueOf2, colorPickerSecondary, colorPickerSecondary2);
            return;
        }
        this.mViewBinding.tvStar.setVisibility(0);
        this.mViewBinding.ivImport.setImageResource(R.drawable.icon_album_import);
        this.mViewBinding.tvImportText.setText(getContext().getString(R.string.album_import));
        this.mViewBinding.llItemBackgroundPicture.setAlpha(1.0f);
        this.mViewBinding.llItemBackgroundPicture.setEnabled(true);
        this.mViewBinding.tvPrimary.setText(getContext().getString(R.string.text_color));
        this.mViewBinding.tvPrimary2.setText(getContext().getString(R.string.text_dark_light));
        this.mViewBinding.tvSecondary.setText(getContext().getString(R.string.pop_background_color));
        this.mViewBinding.tvSecondary2.setText(getContext().getString(R.string.pop_background_dark_light));
        if (customTheme.isExitCustomBackgroundPicture()) {
            this.mViewBinding.llWaitSelect.setVisibility(8);
            this.mViewBinding.llSelectedPicture.setVisibility(0);
            m0.k(getContext(), customTheme.getBackgroundImagePath(), this.mViewBinding.ivPicture);
            this.mViewBinding.tvPictureName.setText(StringsKt.substringAfterLast$default(customTheme.getBackgroundImagePath(), "/", (String) null, 2, (Object) null));
        } else {
            this.mViewBinding.llSelectedPicture.setVisibility(8);
            this.mViewBinding.llWaitSelect.setVisibility(0);
        }
        Integer valueOf3 = Integer.valueOf(customTheme.getTextColorPrimary());
        LineColorPicker colorPickerPrimary3 = this.mViewBinding.colorPickerPrimary;
        Intrinsics.checkNotNullExpressionValue(colorPickerPrimary3, "colorPickerPrimary");
        LineColorPicker colorPickerPrimary22 = this.mViewBinding.colorPickerPrimary2;
        Intrinsics.checkNotNullExpressionValue(colorPickerPrimary22, "colorPickerPrimary2");
        B(valueOf3, colorPickerPrimary3, colorPickerPrimary22);
        Integer valueOf4 = Integer.valueOf(customTheme.getBackgroundColor());
        LineColorPicker colorPickerSecondary3 = this.mViewBinding.colorPickerSecondary;
        Intrinsics.checkNotNullExpressionValue(colorPickerSecondary3, "colorPickerSecondary");
        LineColorPicker colorPickerSecondary22 = this.mViewBinding.colorPickerSecondary2;
        Intrinsics.checkNotNullExpressionValue(colorPickerSecondary22, "colorPickerSecondary2");
        B(valueOf4, colorPickerSecondary3, colorPickerSecondary22);
    }

    public static final void t(ReadingColorPickerLayout this$0, int i10) {
        MiReadingTheme customTheme;
        MiReadingTheme customTheme2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isBackgroundPictureMode) {
            ReadingViewModel mViewModel = this$0.getMViewModel();
            if (mViewModel != null && (customTheme2 = mViewModel.getCustomTheme()) != null) {
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                customTheme2.setCustomTextColor(context, i10);
            }
        } else {
            ReadingViewModel mViewModel2 = this$0.getMViewModel();
            if (mViewModel2 != null && (customTheme = mViewModel2.getCustomTheme()) != null) {
                Context context2 = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                customTheme.setCustomBackgroundColor(context2, i10);
            }
        }
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            a.C0540a.a(readMenuCallBack, false, 1, null);
        }
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack2 = this$0.getReadMenuCallBack();
        if (readMenuCallBack2 != null) {
            a.C0540a.d(readMenuCallBack2, false, 1, null);
        }
    }

    public static final void u(ReadingColorPickerLayout this$0, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReaderColorPickerLayoutBinding readerColorPickerLayoutBinding = this$0.mViewBinding;
        readerColorPickerLayoutBinding.colorPickerSecondary2.setColors(ee.a.b(readerColorPickerLayoutBinding.colorPickerSecondary.getColor()));
        ReaderColorPickerLayoutBinding readerColorPickerLayoutBinding2 = this$0.mViewBinding;
        readerColorPickerLayoutBinding2.colorPickerSecondary2.setSelectedColor(readerColorPickerLayoutBinding2.colorPickerSecondary.getColor());
    }

    public static final void v(ReadingColorPickerLayout this$0, int i10) {
        MiReadingTheme customTheme;
        MiReadingTheme customTheme2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isBackgroundPictureMode) {
            ReadingViewModel mViewModel = this$0.getMViewModel();
            if (mViewModel != null && (customTheme2 = mViewModel.getCustomTheme()) != null) {
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                customTheme2.setCustomBackgroundColor(context, i10);
            }
        } else {
            ReadingViewModel mViewModel2 = this$0.getMViewModel();
            if (mViewModel2 != null && (customTheme = mViewModel2.getCustomTheme()) != null) {
                Context context2 = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                customTheme.setCustomTextColor(context2, i10);
            }
        }
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            a.C0540a.a(readMenuCallBack, false, 1, null);
        }
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack2 = this$0.getReadMenuCallBack();
        if (readMenuCallBack2 != null) {
            a.C0540a.d(readMenuCallBack2, false, 1, null);
        }
    }

    public final void A() {
        MiReadingTheme customTheme;
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel == null || (customTheme = mViewModel.getCustomTheme()) == null) {
            return;
        }
        if (!customTheme.isExitCustomBackgroundPicture()) {
            this.mViewBinding.llSelectedPicture.setVisibility(8);
            this.mViewBinding.llWaitSelect.setVisibility(0);
            this.mViewBinding.tvUploadPictureTips.setVisibility(0);
        } else {
            this.mViewBinding.llWaitSelect.setVisibility(8);
            this.mViewBinding.llSelectedPicture.setVisibility(0);
            m0.k(getContext(), customTheme.getBackgroundImagePath(), this.mViewBinding.ivPicture);
            this.mViewBinding.tvPictureName.setText(StringsKt.substringAfterLast$default(customTheme.getBackgroundImagePath(), "/", (String) null, 2, (Object) null));
        }
    }

    public final void B(Integer color, LineColorPicker colorPicker, LineColorPicker colorPicker2) {
        int[] a10 = ee.a.a();
        Intrinsics.checkNotNullExpressionValue(a10, "getBaseColors(...)");
        for (int i10 : a10) {
            int[] b10 = ee.a.b(i10);
            Intrinsics.checkNotNullExpressionValue(b10, "getColors(...)");
            for (int i11 : b10) {
                Context context = getContext();
                if (Intrinsics.areEqual(context != null ? Integer.valueOf(ExtKt.e(context, i11)) : null, color)) {
                    colorPicker.setSelectedColor(i10);
                    colorPicker2.setColors(ee.a.b(i10));
                    colorPicker2.setSelectedColor(i11);
                    return;
                }
            }
        }
    }

    public final void k(Boolean r32) {
        Object parent = this.mViewBinding.getRoot().getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setTag(r32);
            BottomSheetBehavior from = BottomSheetBehavior.from(view);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(5);
        }
    }

    public final void m() {
        this.confirm = null;
        this.mViewBinding.colorPickerPrimary.setColors(ee.a.a());
        this.mViewBinding.colorPickerSecondary.setColors(ee.a.a());
        y();
        w();
    }

    public final void n() {
        this.mViewBinding.tvCancel.setOnClickListener(new View.OnClickListener() { // from class: hd.r1
            public /* synthetic */ r1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingColorPickerLayout.o(ReadingColorPickerLayout.this, view);
            }
        });
        this.mViewBinding.llConfirm.setOnClickListener(new View.OnClickListener() { // from class: hd.s1
            public /* synthetic */ s1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingColorPickerLayout.p(ReadingColorPickerLayout.this, view);
            }
        });
        this.mViewBinding.llUploadPicture.setOnClickListener(new View.OnClickListener() { // from class: hd.t1
            public /* synthetic */ t1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingColorPickerLayout.q(ReadingColorPickerLayout.this, view);
            }
        });
        this.mViewBinding.llSelectedPicture.setOnClickListener(new View.OnClickListener() { // from class: hd.u1
            public /* synthetic */ u1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingColorPickerLayout.r(ReadingColorPickerLayout.this, view);
            }
        });
        this.mViewBinding.colorPickerPrimary.setOnColorChangedListener(new LineColorPicker.a() { // from class: hd.v1
            public /* synthetic */ v1() {
            }

            @Override // com.martian.mibook.ui.colorpicker.LineColorPicker.a
            public final void a(int i10) {
                ReadingColorPickerLayout.s(ReadingColorPickerLayout.this, i10);
            }
        });
        this.mViewBinding.colorPickerPrimary2.setOnColorChangedListener(new LineColorPicker.a() { // from class: hd.w1
            public /* synthetic */ w1() {
            }

            @Override // com.martian.mibook.ui.colorpicker.LineColorPicker.a
            public final void a(int i10) {
                ReadingColorPickerLayout.t(ReadingColorPickerLayout.this, i10);
            }
        });
        this.mViewBinding.colorPickerSecondary.setOnColorChangedListener(new LineColorPicker.a() { // from class: hd.x1
            public /* synthetic */ x1() {
            }

            @Override // com.martian.mibook.ui.colorpicker.LineColorPicker.a
            public final void a(int i10) {
                ReadingColorPickerLayout.u(ReadingColorPickerLayout.this, i10);
            }
        });
        this.mViewBinding.colorPickerSecondary2.setOnColorChangedListener(new LineColorPicker.a() { // from class: hd.y1
            public /* synthetic */ y1() {
            }

            @Override // com.martian.mibook.ui.colorpicker.LineColorPicker.a
            public final void a(int i10) {
                ReadingColorPickerLayout.v(ReadingColorPickerLayout.this, i10);
            }
        });
    }

    public final void w() {
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setMarginHorizontal(ConfigSingleton.i(10.0f));
        d dVar = new d();
        commonNavigator.setAdapter(new c(commonNavigator, dVar, this));
        this.mViewBinding.magicIndicator.setNavigator(commonNavigator);
        dVar.d(this.mViewBinding.magicIndicator);
        dVar.i(!this.isBackgroundPictureMode ? 1 : 0);
    }

    public final void x() {
        m();
    }

    public final void y() {
        MiReadingTheme f10 = MiConfigSingleton.b2().h2().f();
        this.isBackgroundPictureMode = !f10.getIsColorBackground();
        MiReadingTheme miReadingTheme = new MiReadingTheme(f10.getThemeId(), f10.getThemeName(), f10.getType());
        this.preCustomBackgroundTheme = miReadingTheme;
        miReadingTheme.updateTheme(f10);
        MiReadingTheme miReadingTheme2 = this.preCustomBackgroundTheme;
        if (miReadingTheme2 != null) {
            miReadingTheme2.setColorBackground(false);
        }
        MiReadingTheme miReadingTheme3 = new MiReadingTheme(f10.getThemeId(), f10.getThemeName(), f10.getType());
        this.preCustomColorTheme = miReadingTheme3;
        miReadingTheme3.updateTheme(f10);
        MiReadingTheme miReadingTheme4 = this.preCustomColorTheme;
        if (miReadingTheme4 != null) {
            miReadingTheme4.setColorBackground(true);
        }
        MiReadingTheme miReadingTheme5 = this.preCustomColorTheme;
        if (miReadingTheme5 != null) {
            miReadingTheme5.setBackgroundImagePath("");
        }
        setSelectTheme(this.isBackgroundPictureMode);
    }

    public final void z() {
        MiReadingTheme customTheme;
        MiReadingTheme customTheme2;
        if (this.confirm == null) {
            if (this.isBackgroundPictureMode) {
                ReadingViewModel mViewModel = getMViewModel();
                if (mViewModel != null && (customTheme2 = mViewModel.getCustomTheme()) != null) {
                    customTheme2.updateTheme(this.preCustomBackgroundTheme);
                }
            } else {
                ReadingViewModel mViewModel2 = getMViewModel();
                if (mViewModel2 != null && (customTheme = mViewModel2.getCustomTheme()) != null) {
                    customTheme.updateTheme(this.preCustomColorTheme);
                }
            }
            MiConfigSingleton.b2().h2().b();
            com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
            if (readMenuCallBack != null) {
                a.C0540a.a(readMenuCallBack, false, 1, null);
            }
        }
    }

    public /* synthetic */ ReadingColorPickerLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingColorPickerLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isBackgroundPictureMode = true;
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingColorPickerLayout$mViewModel$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingColorPickerLayout$mViewModel$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                Object obj = context;
                if (obj instanceof FragmentActivity) {
                    return (ReadingViewModel) new ViewModelProvider((ViewModelStoreOwner) obj).get(ReadingViewModel.class);
                }
                return null;
            }
        });
        ReaderColorPickerLayoutBinding inflate = ReaderColorPickerLayoutBinding.inflate(LayoutInflater.from(context2), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        n();
    }
}
