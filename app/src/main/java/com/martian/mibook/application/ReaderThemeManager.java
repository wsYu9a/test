package com.martian.mibook.application;

import android.content.Context;
import ba.j;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.data.theme.ReaderThemeType;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\r\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u0011J\r\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001d¢\u0006\u0004\b \u0010\u001fJ\r\u0010!\u001a\u00020\u001d¢\u0006\u0004\b!\u0010\u001fJ\r\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b\"\u0010\u001fJ\r\u0010#\u001a\u00020\u001d¢\u0006\u0004\b#\u0010\u001fJ\r\u0010$\u001a\u00020\u001d¢\u0006\u0004\b$\u0010\u001fJ\u000f\u0010%\u001a\u00020\u000fH\u0002¢\u0006\u0004\b%\u0010\u0011J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\bJ\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010-R\u0018\u00103\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00102R\u0018\u00104\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00102R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00108R\u001d\u0010=\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010;\u001a\u0004\b0\u0010<¨\u0006>"}, d2 = {"Lcom/martian/mibook/application/ReaderThemeManager;", "", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "Lcom/martian/mibook/data/theme/MiReadingTheme;", "f", "()Lcom/martian/mibook/data/theme/MiReadingTheme;", "k", "", t.f11204d, "()Ljava/util/List;", "n", "m", "", "c", "()V", bt.aO, "readingTheme", "", "isDarkMode", IAdInterListener.AdReqParam.WIDTH, "(Lcom/martian/mibook/data/theme/MiReadingTheme;Ljava/lang/Boolean;)V", "v", "(Lcom/martian/mibook/data/theme/MiReadingTheme;)V", "b", "s", "()Z", "", "o", "()I", "p", "q", "g", e.TAG, "h", t.f11211k, "i", "j", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "Ljava/util/List;", "readerDayThemes", "readerNightThemes", "d", "vipThemes", "Lcom/martian/mibook/data/theme/MiReadingTheme;", "editCustomDayReadingTheme", "editCustomNightReadingTheme", "mCurrentReadingDayTheme", "mCurrentReadingNightTheme", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "delayCheckVipJob", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "Lkotlin/Lazy;", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReaderThemeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReaderThemeManager.kt\ncom/martian/mibook/application/ReaderThemeManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,658:1\n1855#2,2:659\n1855#2,2:661\n766#2:663\n857#2,2:664\n766#2:666\n857#2,2:667\n350#2,7:669\n350#2,7:677\n378#2,7:684\n378#2,7:691\n1#3:676\n*S KotlinDebug\n*F\n+ 1 ReaderThemeManager.kt\ncom/martian/mibook/application/ReaderThemeManager\n*L\n403#1:659,2\n415#1:661,2\n424#1:663\n424#1:664,2\n428#1:666\n428#1:667,2\n486#1:669,7\n564#1:677,7\n599#1:684,7\n604#1:691,7\n*E\n"})
/* loaded from: classes3.dex */
public final class ReaderThemeManager {

    /* renamed from: l */
    public static final int f13345l = 1;

    /* renamed from: m */
    public static final int f13346m = 0;

    /* renamed from: n */
    @k
    public static final String f13347n = "pref_reading_day_theme_id";

    /* renamed from: o */
    @k
    public static final String f13348o = "pref_reading_night_theme_id";

    /* renamed from: p */
    @k
    public static final String f13349p = "pref_reading_theme_new";

    /* renamed from: q */
    @k
    public static final String f13350q = "pref_reading_night_theme_new";

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public final Context com.umeng.analytics.pro.f.X java.lang.String;

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final List<MiReadingTheme> readerDayThemes;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final List<MiReadingTheme> readerNightThemes;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final List<MiReadingTheme> vipThemes;

    /* renamed from: e */
    @l
    public MiReadingTheme editCustomDayReadingTheme;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public MiReadingTheme editCustomNightReadingTheme;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public MiReadingTheme mCurrentReadingDayTheme;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public MiReadingTheme mCurrentReadingNightTheme;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public Job delayCheckVipJob;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel;

    public ReaderThemeManager(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.com.umeng.analytics.pro.f.X java.lang.String = context;
        this.readerDayThemes = new ArrayList();
        this.readerNightThemes = new ArrayList();
        this.vipThemes = new ArrayList();
        this.appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.application.ReaderThemeManager$appViewModel$2
            public ReaderThemeManager$appViewModel$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final AppViewModel invoke() {
                return lc.b.a(ReaderThemeManager.this.getCom.umeng.analytics.pro.f.X java.lang.String());
            }
        });
        r();
    }

    public static final void u(ReaderThemeManager readerThemeManager, MiReadingTheme miReadingTheme, MiReadingTheme miReadingTheme2, boolean z10) {
        if (miReadingTheme != null) {
            if ((!miReadingTheme.isVipDownloadTheme() || (miReadingTheme.isDownloadFinishTheme() && MiConfigSingleton.b2().K2())) && (!miReadingTheme.isCustomTheme() || MiConfigSingleton.b2().K2())) {
                return;
            }
            readerThemeManager.w(miReadingTheme2, Boolean.valueOf(z10));
        }
    }

    public static /* synthetic */ void x(ReaderThemeManager readerThemeManager, MiReadingTheme miReadingTheme, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = null;
        }
        readerThemeManager.w(miReadingTheme, bool);
    }

    public final void b() {
        this.editCustomDayReadingTheme = null;
        this.editCustomNightReadingTheme = null;
    }

    public final void c() {
        Job launch$default;
        Job job = this.delayCheckVipJob;
        if (job == null || job == null || !job.isActive()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ReaderThemeManager$delayCheckVipStatus$1(this, null), 3, null);
            this.delayCheckVipJob = launch$default;
        }
    }

    public final AppViewModel d() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public final int e() {
        return k().getBackgroundColor();
    }

    @k
    public final MiReadingTheme f() {
        if (MiConfigSingleton.b2().A0()) {
            List<MiReadingTheme> list = this.readerNightThemes;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((MiReadingTheme) obj).isCustomTheme()) {
                    arrayList.add(obj);
                }
            }
            return (MiReadingTheme) arrayList.get(0);
        }
        List<MiReadingTheme> list2 = this.readerDayThemes;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (((MiReadingTheme) obj2).isCustomTheme()) {
                arrayList2.add(obj2);
            }
        }
        return (MiReadingTheme) arrayList2.get(0);
    }

    public final int g() {
        return k().getItemColorPrimary();
    }

    @k
    /* renamed from: getContext, reason: from getter */
    public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
        return this.com.umeng.analytics.pro.f.X java.lang.String;
    }

    public final int h() {
        return k().getPopupBackgroundColor();
    }

    public final MiReadingTheme i() {
        int i10 = -1;
        int f10 = j.f(this.com.umeng.analytics.pro.f.X java.lang.String, f13347n, -1);
        if (f10 == -1) {
            MiReadingTheme miReadingTheme = this.readerDayThemes.get(1);
            int f11 = j.f(this.com.umeng.analytics.pro.f.X java.lang.String, f13349p, -1);
            if (f11 >= 0 && this.readerDayThemes.size() > f11) {
                miReadingTheme = this.readerDayThemes.get(f11);
            }
            w(miReadingTheme, Boolean.FALSE);
            return miReadingTheme;
        }
        Iterator<MiReadingTheme> it = this.readerDayThemes.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().getThemeId() == f10) {
                i10 = i11;
                break;
            }
            i11++;
        }
        Integer valueOf = Integer.valueOf(i10);
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        MiReadingTheme miReadingTheme2 = this.readerDayThemes.get(valueOf != null ? valueOf.intValue() : 1);
        if ((miReadingTheme2.isVipTheme() || miReadingTheme2.isCustomTheme()) && !MiConfigSingleton.b2().K2()) {
            AppViewModel d10 = d();
            if (d10 != null) {
                d10.D0(Boolean.FALSE);
            }
        } else if (miReadingTheme2.isVipDownloadTheme() && !miReadingTheme2.isDownloadFinishTheme()) {
            miReadingTheme2 = this.readerDayThemes.get(1);
            w(miReadingTheme2, Boolean.FALSE);
        }
        this.mCurrentReadingDayTheme = miReadingTheme2;
        return miReadingTheme2;
    }

    public final MiReadingTheme j() {
        int i10 = -1;
        int f10 = j.f(this.com.umeng.analytics.pro.f.X java.lang.String, f13348o, -1);
        if (f10 == -1) {
            MiReadingTheme miReadingTheme = this.readerNightThemes.get(0);
            int f11 = j.f(this.com.umeng.analytics.pro.f.X java.lang.String, f13350q, -1);
            if (f11 >= 0 && this.readerNightThemes.size() > f11) {
                miReadingTheme = this.readerNightThemes.get(f11);
            }
            w(miReadingTheme, Boolean.TRUE);
            return miReadingTheme;
        }
        Iterator<MiReadingTheme> it = this.readerNightThemes.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().getThemeId() == f10) {
                i10 = i11;
                break;
            }
            i11++;
        }
        Integer valueOf = Integer.valueOf(i10);
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        MiReadingTheme miReadingTheme2 = this.readerNightThemes.get(valueOf != null ? valueOf.intValue() : 0);
        if ((miReadingTheme2.isVipTheme() || miReadingTheme2.isCustomTheme()) && !MiConfigSingleton.b2().K2()) {
            AppViewModel d10 = d();
            if (d10 != null) {
                d10.D0(Boolean.FALSE);
            }
        } else if (miReadingTheme2.isVipDownloadTheme() && !miReadingTheme2.isDownloadFinishTheme()) {
            miReadingTheme2 = this.readerNightThemes.get(0);
            w(miReadingTheme2, Boolean.TRUE);
        }
        this.mCurrentReadingNightTheme = miReadingTheme2;
        return miReadingTheme2;
    }

    @k
    public final MiReadingTheme k() {
        if (this.mCurrentReadingNightTheme == null) {
            j();
        }
        if (this.mCurrentReadingDayTheme == null) {
            i();
        }
        if (MiConfigSingleton.b2().A0()) {
            MiReadingTheme miReadingTheme = this.editCustomNightReadingTheme;
            if (miReadingTheme != null) {
                return miReadingTheme;
            }
            MiReadingTheme miReadingTheme2 = this.mCurrentReadingNightTheme;
            return miReadingTheme2 == null ? j() : miReadingTheme2;
        }
        MiReadingTheme miReadingTheme3 = this.editCustomDayReadingTheme;
        if (miReadingTheme3 != null) {
            return miReadingTheme3;
        }
        MiReadingTheme miReadingTheme4 = this.mCurrentReadingDayTheme;
        return miReadingTheme4 == null ? i() : miReadingTheme4;
    }

    @k
    public final List<MiReadingTheme> l() {
        return MiConfigSingleton.b2().A0() ? this.readerNightThemes : this.readerDayThemes;
    }

    @k
    public final List<MiReadingTheme> m() {
        return this.vipThemes;
    }

    @k
    public final List<MiReadingTheme> n() {
        return MiConfigSingleton.b2().A0() ? CollectionsKt.take(this.readerNightThemes, 7) : CollectionsKt.take(this.readerDayThemes, 7);
    }

    public final int o() {
        return k().getTextColorPrimary();
    }

    public final int p() {
        return k().getTextColorSecondary();
    }

    public final int q() {
        return k().getTextColorThirdly();
    }

    public final void r() {
        ReaderThemeType readerThemeType = ReaderThemeType.THEME_DEFAULT;
        MiReadingTheme miReadingTheme = new MiReadingTheme(10001, "白色", readerThemeType);
        miReadingTheme.setItemColorPrimaryColorRes(R.color.reader_default_item_color_primary);
        miReadingTheme.setTextColorPrimaryColorRes(R.color.reader_default_text_color_primary);
        miReadingTheme.setTextColorSecondaryColorRes(R.color.reader_default_text_color_secondary);
        miReadingTheme.setTextColorThirdlyColorRes(R.color.reader_default_text_color_thirdly);
        miReadingTheme.setBackgroundColorRes(R.color.reader_default_background_color);
        miReadingTheme.setPopupBackgroundColorRes(R.color.reader_default_popup_background_color);
        miReadingTheme.setBackgroundNavigationBarColorRes(R.color.reader_default_background_navigation_bar_color);
        miReadingTheme.setSelectBackgroundColorRes(R.color.reader_default_highlight_bg_color);
        MiReadingTheme miReadingTheme2 = new MiReadingTheme(10002, "牛皮", readerThemeType);
        miReadingTheme2.setItemColorPrimaryColorRes(R.color.reader_cow_item_color_primary);
        miReadingTheme2.setTextColorPrimaryColorRes(R.color.reader_cow_text_color_primary);
        miReadingTheme2.setTextColorSecondaryColorRes(R.color.reader_cow_text_color_secondary);
        miReadingTheme2.setTextColorThirdlyColorRes(R.color.reader_cow_text_color_thirdly);
        miReadingTheme2.setBackgroundColorRes(R.color.reader_cow_background_color);
        miReadingTheme2.setPopupBackgroundColorRes(R.color.reader_cow_popup_background_color);
        miReadingTheme2.setBackgroundNavigationBarColorRes(R.color.reader_cow_background_navigation_bar_color);
        miReadingTheme2.setSelectBackgroundColorRes(R.color.reader_cow_highlight_bg_color);
        miReadingTheme2.setBackgroundImagePath("bg_style_yellow.webp");
        miReadingTheme2.setColorBackground(false);
        MiReadingTheme miReadingTheme3 = new MiReadingTheme(10003, "绿色", readerThemeType);
        miReadingTheme3.setItemColorPrimaryColorRes(R.color.reader_green_item_color_primary);
        miReadingTheme3.setTextColorPrimaryColorRes(R.color.reader_green_text_color_primary);
        miReadingTheme3.setTextColorSecondaryColorRes(R.color.reader_green_text_color_secondary);
        miReadingTheme3.setTextColorThirdlyColorRes(R.color.reader_green_text_color_thirdly);
        miReadingTheme3.setBackgroundColorRes(R.color.reader_green_background_color);
        miReadingTheme3.setPopupBackgroundColorRes(R.color.reader_green_popup_background_color);
        miReadingTheme3.setBackgroundNavigationBarColorRes(R.color.reader_green_background_navigation_bar_color);
        miReadingTheme3.setSelectBackgroundColorRes(R.color.reader_green_highlight_bg_color);
        MiReadingTheme miReadingTheme4 = new MiReadingTheme(10004, "粉色", readerThemeType);
        miReadingTheme4.setItemColorPrimaryColorRes(R.color.reader_pink_item_color_primary);
        miReadingTheme4.setTextColorPrimaryColorRes(R.color.reader_pink_text_color_primary);
        miReadingTheme4.setTextColorSecondaryColorRes(R.color.reader_pink_text_color_secondary);
        miReadingTheme4.setTextColorThirdlyColorRes(R.color.reader_pink_text_color_thirdly);
        miReadingTheme4.setBackgroundColorRes(R.color.reader_pink_background_color);
        miReadingTheme4.setPopupBackgroundColorRes(R.color.reader_pink_popup_background_color);
        miReadingTheme4.setBackgroundNavigationBarColorRes(R.color.reader_pink_background_navigation_bar_color);
        miReadingTheme4.setSelectBackgroundColorRes(R.color.reader_pink_highlight_bg_color);
        miReadingTheme4.setBackgroundImagePath("pink_mode_bg.webp");
        miReadingTheme4.setColorBackground(false);
        MiReadingTheme miReadingTheme5 = new MiReadingTheme(10005, "夜间", readerThemeType);
        miReadingTheme5.setDarkTheme(true);
        miReadingTheme5.setItemColorPrimaryColorRes(R.color.reader_night2_item_color_primary);
        miReadingTheme5.setTextColorPrimaryColorRes(R.color.reader_night2_text_color_primary);
        miReadingTheme5.setTextColorSecondaryColorRes(R.color.reader_night2_text_color_secondary);
        miReadingTheme5.setTextColorThirdlyColorRes(R.color.reader_night2_text_color_thirdly);
        miReadingTheme5.setBackgroundColorRes(R.color.reader_night2_background_color);
        miReadingTheme5.setPopupBackgroundColorRes(R.color.reader_night2_popup_background_color);
        miReadingTheme5.setBackgroundNavigationBarColorRes(R.color.reader_night2_background_navigation_bar_color);
        miReadingTheme5.setSelectBackgroundColorRes(R.color.reader_night2_highlight_bg_color);
        MiReadingTheme miReadingTheme6 = new MiReadingTheme(10006, "黑色", readerThemeType);
        miReadingTheme6.setDarkTheme(true);
        miReadingTheme6.setItemColorPrimaryColorRes(R.color.reader_night1_item_color_primary);
        miReadingTheme6.setTextColorPrimaryColorRes(R.color.reader_night1_text_color_primary);
        miReadingTheme6.setTextColorSecondaryColorRes(R.color.reader_night1_text_color_secondary);
        miReadingTheme6.setTextColorThirdlyColorRes(R.color.reader_night1_text_color_thirdly);
        miReadingTheme6.setBackgroundColorRes(R.color.reader_night1_background_color);
        miReadingTheme6.setPopupBackgroundColorRes(R.color.reader_night1_popup_background_color);
        miReadingTheme6.setBackgroundNavigationBarColorRes(R.color.reader_night1_background_navigation_bar_color);
        miReadingTheme6.setSelectBackgroundColorRes(R.color.reader_night1_highlight_bg_color);
        MiReadingTheme miReadingTheme7 = new MiReadingTheme(10007, "夜间2", readerThemeType);
        miReadingTheme7.setDarkTheme(true);
        miReadingTheme7.setItemColorPrimaryColorRes(R.color.reader_night3_item_color_primary);
        miReadingTheme7.setTextColorPrimaryColorRes(R.color.reader_night3_text_color_primary);
        miReadingTheme7.setTextColorSecondaryColorRes(R.color.reader_night3_text_color_secondary);
        miReadingTheme7.setTextColorThirdlyColorRes(R.color.reader_night3_text_color_thirdly);
        miReadingTheme7.setBackgroundColorRes(R.color.reader_night3_background_color);
        miReadingTheme7.setPopupBackgroundColorRes(R.color.reader_night3_popup_background_color);
        miReadingTheme7.setBackgroundNavigationBarColorRes(R.color.reader_night3_background_navigation_bar_color);
        miReadingTheme7.setSelectBackgroundColorRes(R.color.reader_night3_highlight_bg_color);
        ReaderThemeType readerThemeType2 = ReaderThemeType.THEME_CUSTOM;
        MiReadingTheme miReadingTheme8 = new MiReadingTheme(JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_FEED9_16_SINGLE_VIDEO, "自定义日间", readerThemeType2);
        miReadingTheme8.setItemColorPrimaryColorRes(R.color.reader_default_item_color_primary);
        miReadingTheme8.setTextColorPrimaryColorRes(R.color.reader_default_text_color_primary);
        miReadingTheme8.setTextColorSecondaryColorRes(R.color.reader_default_text_color_secondary);
        miReadingTheme8.setTextColorThirdlyColorRes(R.color.reader_default_text_color_thirdly);
        miReadingTheme8.setBackgroundColorRes(R.color.reader_default_background_color);
        miReadingTheme8.setPopupBackgroundColorRes(R.color.reader_default_popup_background_color);
        miReadingTheme8.setBackgroundNavigationBarColorRes(R.color.reader_default_background_color);
        miReadingTheme8.setSelectBackgroundColorRes(R.color.reader_default_highlight_bg_color);
        miReadingTheme8.refreshCustomThemeBackgroundInfo(miReadingTheme8.getDayCustomBackgroundColor(this.com.umeng.analytics.pro.f.X java.lang.String));
        miReadingTheme8.refreshCustomThemeTextInfo(miReadingTheme8.getDayCustomTextColor(this.com.umeng.analytics.pro.f.X java.lang.String));
        miReadingTheme8.setColorBackground(!miReadingTheme8.isDayCustomImageBackground(this.com.umeng.analytics.pro.f.X java.lang.String));
        miReadingTheme8.setBackgroundImagePath(miReadingTheme8.getDayCustomBackgroundImage(this.com.umeng.analytics.pro.f.X java.lang.String));
        MiReadingTheme miReadingTheme9 = new MiReadingTheme(JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_SPLASH9_16_SINGLE_VIDEO, "自定义夜间", readerThemeType2);
        miReadingTheme9.setItemColorPrimaryColorRes(R.color.reader_night1_item_color_primary);
        miReadingTheme9.setTextColorPrimaryColorRes(R.color.reader_night1_text_color_primary);
        miReadingTheme9.setTextColorSecondaryColorRes(R.color.reader_night1_text_color_secondary);
        miReadingTheme9.setTextColorThirdlyColorRes(R.color.reader_night1_text_color_thirdly);
        miReadingTheme9.setBackgroundColorRes(R.color.reader_night1_background_color);
        miReadingTheme9.setPopupBackgroundColorRes(R.color.reader_night1_popup_background_color);
        miReadingTheme9.setBackgroundNavigationBarColorRes(R.color.reader_night1_background_navigation_bar_color);
        miReadingTheme9.setSelectBackgroundColorRes(R.color.reader_night1_highlight_bg_color);
        miReadingTheme9.refreshCustomThemeBackgroundInfo(miReadingTheme9.getNightCustomBackgroundColor(this.com.umeng.analytics.pro.f.X java.lang.String));
        miReadingTheme9.refreshCustomThemeTextInfo(miReadingTheme9.getNightCustomTextColor(this.com.umeng.analytics.pro.f.X java.lang.String));
        miReadingTheme9.setColorBackground(!miReadingTheme9.isNightCustomImageBackground(this.com.umeng.analytics.pro.f.X java.lang.String));
        miReadingTheme9.setBackgroundImagePath(miReadingTheme9.getNightCustomBackgroundImage(this.com.umeng.analytics.pro.f.X java.lang.String));
        ReaderThemeType readerThemeType3 = ReaderThemeType.THEME_VIP_DOWNLOADED;
        MiReadingTheme miReadingTheme10 = new MiReadingTheme(JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_FEED9_16_SINGLE, "烟雨江南", readerThemeType3);
        miReadingTheme10.setItemColorPrimaryColorRes(R.color.reader_swordsman_item_color_primary);
        miReadingTheme10.setTextColorPrimaryColorRes(R.color.reader_swordsman_text_color_primary);
        miReadingTheme10.setTextColorSecondaryColorRes(R.color.reader_swordsman_text_color_secondary);
        miReadingTheme10.setTextColorThirdlyColorRes(R.color.reader_swordsman_text_color_thirdly);
        miReadingTheme10.setBackgroundColorRes(R.color.reader_swordsman_background_color);
        miReadingTheme10.setPopupBackgroundColorRes(R.color.reader_swordsman_popup_background_color);
        miReadingTheme10.setBackgroundNavigationBarColorRes(R.color.reader_swordsman_background_navigation_bar_color);
        miReadingTheme10.setSelectBackgroundColorRes(R.color.reader_swordsman_highlight_bg_color);
        miReadingTheme10.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/Swordsman.webp");
        miReadingTheme10.setPreviewImageRes(R.drawable.bg_theme_swordsman);
        miReadingTheme10.setUnlockByCoins(1);
        MiReadingTheme miReadingTheme11 = new MiReadingTheme(JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_INTERSTITIAL9_16_SINGLE, "云上都市", readerThemeType3);
        miReadingTheme11.setItemColorPrimaryColorRes(R.color.reader_cloud_item_color_primary);
        miReadingTheme11.setTextColorPrimaryColorRes(R.color.reader_cloud_text_color_primary);
        miReadingTheme11.setTextColorSecondaryColorRes(R.color.reader_cloud_text_color_secondary);
        miReadingTheme11.setTextColorThirdlyColorRes(R.color.reader_cloud_text_color_thirdly);
        miReadingTheme11.setBackgroundColorRes(R.color.reader_cloud_background_color);
        miReadingTheme11.setPopupBackgroundColorRes(R.color.reader_cloud_popup_background_color);
        miReadingTheme11.setBackgroundNavigationBarColorRes(R.color.reader_cloud_background_navigation_bar_color);
        miReadingTheme11.setSelectBackgroundColorRes(R.color.reader_cloud_highlight_bg_color);
        miReadingTheme11.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/city.webp");
        miReadingTheme11.setPreviewImageRes(R.drawable.bg_theme_cloud);
        miReadingTheme11.setUnlockByCoins(8);
        MiReadingTheme miReadingTheme12 = new MiReadingTheme(10012, "大漠沙丘", readerThemeType3);
        miReadingTheme12.setItemColorPrimaryColorRes(R.color.reader_dune_item_color_primary);
        miReadingTheme12.setTextColorPrimaryColorRes(R.color.reader_dune_text_color_primary);
        miReadingTheme12.setTextColorSecondaryColorRes(R.color.reader_dune_text_color_secondary);
        miReadingTheme12.setTextColorThirdlyColorRes(R.color.reader_dune_text_color_thirdly);
        miReadingTheme12.setBackgroundColorRes(R.color.reader_dune_background_color);
        miReadingTheme12.setPopupBackgroundColorRes(R.color.reader_dune_popup_background_color);
        miReadingTheme12.setBackgroundNavigationBarColorRes(R.color.reader_dune_background_navigation_bar_color);
        miReadingTheme12.setSelectBackgroundColorRes(R.color.reader_dune_highlight_bg_color);
        miReadingTheme12.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/dune.webp");
        miReadingTheme12.setPreviewImageRes(R.drawable.bg_theme_dune);
        miReadingTheme12.setUnlockByCoins(4);
        MiReadingTheme miReadingTheme13 = new MiReadingTheme(VlionAdBaseError.LOAD_AD_CONTEXT_IS_NULL_CODE, "冉冉秋光", readerThemeType3);
        miReadingTheme13.setItemColorPrimaryColorRes(R.color.reader_autumn_item_color_primary);
        miReadingTheme13.setTextColorPrimaryColorRes(R.color.reader_autumn_text_color_primary);
        miReadingTheme13.setTextColorSecondaryColorRes(R.color.reader_autumn_text_color_secondary);
        miReadingTheme13.setTextColorThirdlyColorRes(R.color.reader_autumn_text_color_thirdly);
        miReadingTheme13.setBackgroundColorRes(R.color.reader_autumn_background_color);
        miReadingTheme13.setPopupBackgroundColorRes(R.color.reader_autumn_popup_background_color);
        miReadingTheme13.setBackgroundNavigationBarColorRes(R.color.reader_autumn_background_navigation_bar_color);
        miReadingTheme13.setSelectBackgroundColorRes(R.color.reader_autumn_highlight_bg_color);
        miReadingTheme13.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/autumn.webp");
        miReadingTheme13.setPreviewImageRes(R.drawable.bg_theme_autumn);
        miReadingTheme13.setUnlockExpLevel(10);
        MiReadingTheme miReadingTheme14 = new MiReadingTheme(VlionAdBaseError.LOAD_AD_SLOT_IS_NULL_CODE, "梦境星辰", readerThemeType3);
        miReadingTheme14.setDarkTheme(true);
        miReadingTheme14.setItemColorPrimaryColorRes(R.color.reader_dreamstar_item_color_primary);
        miReadingTheme14.setTextColorPrimaryColorRes(R.color.reader_dreamstar_text_color_primary);
        miReadingTheme14.setTextColorSecondaryColorRes(R.color.reader_dreamstar_text_color_secondary);
        miReadingTheme14.setTextColorThirdlyColorRes(R.color.reader_dreamstar_text_color_thirdly);
        miReadingTheme14.setBackgroundColorRes(R.color.reader_dreamstar_background_color);
        miReadingTheme14.setPopupBackgroundColorRes(R.color.reader_dreamstar_popup_background_color);
        miReadingTheme14.setBackgroundNavigationBarColorRes(R.color.reader_dreamstar_background_navigation_bar_color);
        miReadingTheme14.setSelectBackgroundColorRes(R.color.reader_dreamstar_highlight_bg_color);
        miReadingTheme14.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/dreamstar.webp");
        miReadingTheme14.setPreviewImageRes(R.drawable.bg_theme_dreamstar);
        MiReadingTheme miReadingTheme15 = new MiReadingTheme(VlionAdBaseError.AD_APP_ID_IS_EMPTY_CODE, "幽蓝夜空", readerThemeType3);
        miReadingTheme15.setDarkTheme(true);
        miReadingTheme15.setItemColorPrimaryColorRes(R.color.reader_nightsky_item_color_primary);
        miReadingTheme15.setTextColorPrimaryColorRes(R.color.reader_nightsky_text_color_primary);
        miReadingTheme15.setTextColorSecondaryColorRes(R.color.reader_nightsky_text_color_secondary);
        miReadingTheme15.setTextColorThirdlyColorRes(R.color.reader_nightsky_text_color_thirdly);
        miReadingTheme15.setBackgroundColorRes(R.color.reader_nightsky_background_color);
        miReadingTheme15.setPopupBackgroundColorRes(R.color.reader_nightsky_popup_background_color);
        miReadingTheme15.setBackgroundNavigationBarColorRes(R.color.reader_nightsky_background_navigation_bar_color);
        miReadingTheme15.setSelectBackgroundColorRes(R.color.reader_nightsky_highlight_bg_color);
        miReadingTheme15.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/nightsky.webp");
        miReadingTheme15.setPreviewImageRes(R.drawable.bg_theme_nightsky);
        MiReadingTheme miReadingTheme16 = new MiReadingTheme(VlionAdBaseError.AD_TAG_ID_IS_EMPTY_CODE, "白雪物语", readerThemeType3);
        miReadingTheme16.setItemColorPrimaryColorRes(R.color.reader_snow_item_color_primary);
        miReadingTheme16.setTextColorPrimaryColorRes(R.color.reader_snow_text_color_primary);
        miReadingTheme16.setTextColorSecondaryColorRes(R.color.reader_snow_text_color_secondary);
        miReadingTheme16.setTextColorThirdlyColorRes(R.color.reader_snow_text_color_thirdly);
        miReadingTheme16.setBackgroundColorRes(R.color.reader_snow_background_color);
        miReadingTheme16.setPopupBackgroundColorRes(R.color.reader_snow_popup_background_color);
        miReadingTheme16.setBackgroundNavigationBarColorRes(R.color.reader_snow_background_navigation_bar_color);
        miReadingTheme16.setSelectBackgroundColorRes(R.color.reader_snow_highlight_bg_color);
        miReadingTheme16.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/snow.webp");
        miReadingTheme16.setPreviewImageRes(R.drawable.bg_theme_snow);
        miReadingTheme16.setUnlockByCoins(2);
        MiReadingTheme miReadingTheme17 = new MiReadingTheme(VlionAdBaseError.AD_NOT_LOAD_WIN_PRICE_ERROR_CODE, "踏青逐梦", readerThemeType3);
        miReadingTheme17.setItemColorPrimaryColorRes(R.color.reader_pursuedreams_item_color_primary);
        miReadingTheme17.setTextColorPrimaryColorRes(R.color.reader_pursuedreams_text_color_primary);
        miReadingTheme17.setTextColorSecondaryColorRes(R.color.reader_pursuedreams_text_color_secondary);
        miReadingTheme17.setTextColorThirdlyColorRes(R.color.reader_pursuedreams_text_color_thirdly);
        miReadingTheme17.setBackgroundColorRes(R.color.reader_pursuedreams_background_color);
        miReadingTheme17.setPopupBackgroundColorRes(R.color.reader_pursuedreams_popup_background_color);
        miReadingTheme17.setBackgroundNavigationBarColorRes(R.color.reader_pursuedreams_background_navigation_bar_color);
        miReadingTheme17.setSelectBackgroundColorRes(R.color.reader_pursuedreams_highlight_bg_color);
        miReadingTheme17.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/pursuedreams.webp");
        miReadingTheme17.setPreviewImageRes(R.drawable.bg_theme_pursuedreams);
        miReadingTheme17.setUnlockExpLevel(40);
        MiReadingTheme miReadingTheme18 = new MiReadingTheme(VlionAdBaseError.AD_NOT_READY_WIN_PRICE_FAIL_CODE, "猫影夕阳", readerThemeType3);
        miReadingTheme18.setItemColorPrimaryColorRes(R.color.reader_catsunset_item_color_primary);
        miReadingTheme18.setTextColorPrimaryColorRes(R.color.reader_catsunset_text_color_primary);
        miReadingTheme18.setTextColorSecondaryColorRes(R.color.reader_catsunset_text_color_secondary);
        miReadingTheme18.setTextColorThirdlyColorRes(R.color.reader_catsunset_text_color_thirdly);
        miReadingTheme18.setBackgroundColorRes(R.color.reader_catsunset_background_color);
        miReadingTheme18.setPopupBackgroundColorRes(R.color.reader_catsunset_popup_background_color);
        miReadingTheme18.setBackgroundNavigationBarColorRes(R.color.reader_catsunset_background_navigation_bar_color);
        miReadingTheme18.setSelectBackgroundColorRes(R.color.reader_catsunset_highlight_bg_color);
        miReadingTheme18.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/catsunset.webp");
        miReadingTheme18.setPreviewImageRes(R.drawable.bg_theme_catsunset);
        miReadingTheme18.setUnlockExpLevel(30);
        MiReadingTheme miReadingTheme19 = new MiReadingTheme(VlionAdBaseError.AD_NOT_LOAD_ERROR_CODE, "星愿之旅", readerThemeType3);
        miReadingTheme19.setDarkTheme(true);
        miReadingTheme19.setItemColorPrimaryColorRes(R.color.reader_wishstar_item_color_primary);
        miReadingTheme19.setTextColorPrimaryColorRes(R.color.reader_wishstar_text_color_primary);
        miReadingTheme19.setTextColorSecondaryColorRes(R.color.reader_wishstar_text_color_secondary);
        miReadingTheme19.setTextColorThirdlyColorRes(R.color.reader_wishstar_text_color_thirdly);
        miReadingTheme19.setBackgroundColorRes(R.color.reader_wishstar_background_color);
        miReadingTheme19.setPopupBackgroundColorRes(R.color.reader_wishstar_popup_background_color);
        miReadingTheme19.setBackgroundNavigationBarColorRes(R.color.reader_wishstar_background_navigation_bar_color);
        miReadingTheme19.setSelectBackgroundColorRes(R.color.reader_wishstar_highlight_bg_color);
        miReadingTheme19.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/wishstar.webp");
        miReadingTheme19.setPreviewImageRes(R.drawable.bg_theme_wishstar);
        MiReadingTheme miReadingTheme20 = new MiReadingTheme(VlionAdBaseError.AD_NOT_READY_ERROR_CODE, "山谷夜语", readerThemeType3);
        miReadingTheme20.setDarkTheme(true);
        miReadingTheme20.setItemColorPrimaryColorRes(R.color.reader_valleynight_item_color_primary);
        miReadingTheme20.setTextColorPrimaryColorRes(R.color.reader_valleynight_text_color_primary);
        miReadingTheme20.setTextColorSecondaryColorRes(R.color.reader_valleynight_text_color_secondary);
        miReadingTheme20.setTextColorThirdlyColorRes(R.color.reader_valleynight_text_color_thirdly);
        miReadingTheme20.setBackgroundColorRes(R.color.reader_valleynight_background_color);
        miReadingTheme20.setPopupBackgroundColorRes(R.color.reader_valleynight_popup_background_color);
        miReadingTheme20.setBackgroundNavigationBarColorRes(R.color.reader_valleynight_background_navigation_bar_color);
        miReadingTheme20.setSelectBackgroundColorRes(R.color.reader_valleynight_highlight_bg_color);
        miReadingTheme20.setDownloadUrl("http://scdn.taoyuewenhua.net/app/reading_background/valleynight.webp");
        miReadingTheme20.setPreviewImageRes(R.drawable.bg_theme_valleynight);
        miReadingTheme20.setUnlockExpLevel(20);
        this.vipThemes.clear();
        this.vipThemes.add(miReadingTheme10);
        this.vipThemes.add(miReadingTheme11);
        this.vipThemes.add(miReadingTheme16);
        this.vipThemes.add(miReadingTheme12);
        this.vipThemes.add(miReadingTheme13);
        this.vipThemes.add(miReadingTheme17);
        this.vipThemes.add(miReadingTheme18);
        this.vipThemes.add(miReadingTheme20);
        this.vipThemes.add(miReadingTheme15);
        this.vipThemes.add(miReadingTheme19);
        this.vipThemes.add(miReadingTheme14);
        this.readerDayThemes.clear();
        this.readerDayThemes.add(miReadingTheme);
        this.readerDayThemes.add(miReadingTheme2);
        this.readerDayThemes.add(miReadingTheme3);
        this.readerDayThemes.add(miReadingTheme4);
        this.readerDayThemes.add(miReadingTheme5);
        this.readerDayThemes.add(miReadingTheme6);
        this.readerDayThemes.add(miReadingTheme7);
        this.readerDayThemes.add(miReadingTheme8);
        Iterator<T> it = this.vipThemes.iterator();
        while (it.hasNext()) {
            this.readerDayThemes.add((MiReadingTheme) it.next());
        }
        this.readerNightThemes.clear();
        this.readerNightThemes.add(miReadingTheme5);
        this.readerNightThemes.add(miReadingTheme6);
        this.readerNightThemes.add(miReadingTheme7);
        this.readerNightThemes.add(miReadingTheme);
        this.readerNightThemes.add(miReadingTheme2);
        this.readerNightThemes.add(miReadingTheme3);
        this.readerNightThemes.add(miReadingTheme4);
        this.readerNightThemes.add(miReadingTheme9);
        Iterator<T> it2 = this.vipThemes.iterator();
        while (it2.hasNext()) {
            this.readerNightThemes.add((MiReadingTheme) it2.next());
        }
    }

    public final boolean s() {
        return k().getIsDarkTheme();
    }

    public final void t() {
        u(this, this.mCurrentReadingNightTheme, this.readerNightThemes.get(0), true);
        u(this, this.mCurrentReadingDayTheme, this.readerDayThemes.get(1), false);
    }

    public final void v(@k MiReadingTheme readingTheme) {
        Intrinsics.checkNotNullParameter(readingTheme, "readingTheme");
        if (MiConfigSingleton.b2().A0()) {
            this.editCustomNightReadingTheme = readingTheme;
        } else {
            this.editCustomDayReadingTheme = readingTheme;
        }
    }

    public final void w(@k MiReadingTheme readingTheme, @l Boolean bool) {
        int i10;
        Integer num;
        int i11;
        Intrinsics.checkNotNullParameter(readingTheme, "readingTheme");
        if (bool != null ? bool.booleanValue() : MiConfigSingleton.b2().A0()) {
            this.mCurrentReadingNightTheme = readingTheme;
            j.m(this.com.umeng.analytics.pro.f.X java.lang.String, f13348o, readingTheme.getThemeId());
            List<MiReadingTheme> list = this.readerNightThemes;
            ListIterator<MiReadingTheme> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    i11 = -1;
                    break;
                } else {
                    if (listIterator.previous().getThemeId() == readingTheme.getThemeId()) {
                        i11 = listIterator.nextIndex();
                        break;
                    }
                }
            }
            Integer valueOf = Integer.valueOf(i11);
            num = valueOf.intValue() != -1 ? valueOf : null;
            if (num != null) {
                this.readerNightThemes.set(num.intValue(), readingTheme);
                return;
            }
            return;
        }
        this.mCurrentReadingDayTheme = readingTheme;
        j.m(this.com.umeng.analytics.pro.f.X java.lang.String, f13347n, readingTheme.getThemeId());
        List<MiReadingTheme> list2 = this.readerDayThemes;
        ListIterator<MiReadingTheme> listIterator2 = list2.listIterator(list2.size());
        while (true) {
            if (!listIterator2.hasPrevious()) {
                i10 = -1;
                break;
            } else {
                if (listIterator2.previous().getThemeId() == readingTheme.getThemeId()) {
                    i10 = listIterator2.nextIndex();
                    break;
                }
            }
        }
        Integer valueOf2 = Integer.valueOf(i10);
        num = valueOf2.intValue() != -1 ? valueOf2 : null;
        if (num != null) {
            this.readerDayThemes.set(num.intValue(), readingTheme);
        }
    }
}
