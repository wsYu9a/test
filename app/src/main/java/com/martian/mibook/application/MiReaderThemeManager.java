package com.martian.mibook.application;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.ttbookhd.R;

/* loaded from: classes.dex */
public class MiReaderThemeManager {

    /* renamed from: a */
    public static final String f11339a = "pref_reading_theme";

    /* renamed from: b */
    public static final String f11340b = "pref_reading_night_theme";

    /* renamed from: c */
    private static final String f11341c = "pref_reading_theme_new";

    /* renamed from: d */
    private static final String f11342d = "pref_reading_night_theme_new";

    /* renamed from: e */
    private final Context f11343e;

    /* renamed from: f */
    public final MiReadingTheme[] f11344f;

    /* renamed from: g */
    public final MiReadingTheme[] f11345g;

    /* renamed from: h */
    private int f11346h = -1;

    /* renamed from: i */
    private int f11347i = -1;

    public MiReaderThemeManager(Context context) {
        this.f11343e = context;
        MiReadingTheme round4DpBgRes = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_default_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_default_item_color_primary_alpha8)).setBackgroundPrimary(ContextCompat.getColor(context, R.color.reader_default_background_primary)).setBackgroundSecondary(R.color.reader_default_background_secondary).setTextColorPrimary(ContextCompat.getColor(context, R.color.reader_default_text_color_primary)).setTextColorThirdly(ContextCompat.getColor(context, R.color.reader_default_text_color_thirdly)).setTheme_text(MiReadingTheme.WHITE_THEME_TEXT).setIsColorBackground(true).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_default_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_default_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_default_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_default_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_day).setBorderBackgroundLightButton(R.drawable.reader_theme_default_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_default_line_background).setProgressBarBackground(R.drawable.reader_theme_default_progressbar_float).setTextColorAux(context.getResources().getColor(R.color.transparent_grey)).setVipHintColor(context.getResources().getColor(R.color.transparent_grey)).setFreeHintColor(context.getResources().getColor(R.color.transparent_grey)).setNavigationBarBackground(R.color.reader_default_background_primary).setNavigationBarBackgroundNight(R.color.reader_default_background_primary_night).setNavigationBarBackgroundSecondaryNight(R.color.reader_default_background_secondary_night).setReadingClaimColor(context.getResources().getColor(R.color.transparent_grey)).setSelectorRes(R.drawable.selector_default_day).setTopRoundBgRes(R.drawable.reader_theme_default_top_round).setRoundBgRes(R.drawable.reader_theme_default_round_button).setRound4DpBgRes(R.drawable.reader_theme_default_round_4dp);
        MiReadingTheme round4DpBgRes2 = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_cow_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_cow_item_color_primary_alpha8)).setBackgroundPrimary(ContextCompat.getColor(context, R.color.reader_cow_background_primary)).setNavigationBarBackground(R.color.reader_cow_background_primary).setNavigationBarBackgroundNight(R.color.reader_cow_background_primary_night).setNavigationBarBackgroundSecondaryNight(R.color.reader_cow_background_secondary_night).setBackgroundSecondary(R.color.reader_cow_background_secondary).setTextColorPrimary(ContextCompat.getColor(context, R.color.reader_cow_text_color_primary)).setTextColorThirdly(ContextCompat.getColor(context, R.color.reader_cow_text_color_thirdly)).setTheme_text(MiReadingTheme.COW_THEME_TEXT).setBackgroundImagePath("bg_style_yellow.webp").setIsColorBackground(false).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_cow_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_cow_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_cow_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_cow_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_day).setBorderBackgroundLightButton(R.drawable.reader_theme_cow_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_cow_line_background).setProgressBarBackground(R.drawable.reader_theme_cow_progressbar_float).setTextColorAux(context.getResources().getColor(R.color.transparent_grey)).setVipHintColor(context.getResources().getColor(R.color.transparent_grey)).setFreeHintColor(context.getResources().getColor(R.color.transparent_grey)).setReadingClaimColor(context.getResources().getColor(R.color.transparent_grey)).setSelectorRes(R.drawable.reader_theme_cow_selector).setTopRoundBgRes(R.drawable.reader_theme_cow_top_round).setRoundBgRes(R.drawable.reader_theme_cow_round_button).setRound4DpBgRes(R.drawable.reader_theme_cow_round_4dp);
        MiReadingTheme round4DpBgRes3 = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_green_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_green_item_color_primary_alpha8)).setBackgroundPrimary(ContextCompat.getColor(context, R.color.reader_green_background_primary)).setBackgroundSecondary(R.color.reader_green_background_secondary).setTextColorPrimary(ContextCompat.getColor(context, R.color.reader_green_text_color_primary)).setTextColorThirdly(ContextCompat.getColor(context, R.color.reader_green_text_color_thirdly)).setTheme_text(MiReadingTheme.GREEN_THEME_TEXT).setIsColorBackground(true).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_green_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_green_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_green_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_green_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_day).setBorderBackgroundLightButton(R.drawable.reader_theme_green_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_green_line_background).setProgressBarBackground(R.drawable.reader_theme_green_progressbar_float).setTextColorAux(context.getResources().getColor(R.color.transparent_grey)).setVipHintColor(context.getResources().getColor(R.color.transparent_grey)).setFreeHintColor(context.getResources().getColor(R.color.transparent_grey)).setNavigationBarBackground(R.color.reader_green_background_primary).setNavigationBarBackgroundNight(R.color.reader_green_background_primary_night).setNavigationBarBackgroundSecondaryNight(R.color.reader_green_background_secondary_night).setReadingClaimColor(context.getResources().getColor(R.color.transparent_grey)).setSelectorRes(R.drawable.reader_theme_green_selector).setTopRoundBgRes(R.drawable.reader_theme_green_top_round).setRoundBgRes(R.drawable.reader_theme_green_round_button).setRound4DpBgRes(R.drawable.reader_theme_green_round_4dp);
        MiReadingTheme round4DpBgRes4 = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_pink_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_pink_item_color_primary_alpha8)).setBackgroundPrimary(ContextCompat.getColor(context, R.color.reader_pink_background_primary)).setBackgroundSecondary(R.color.reader_pink_background_secondary).setTextColorPrimary(ContextCompat.getColor(context, R.color.reader_pink_text_color_primary)).setTextColorThirdly(ContextCompat.getColor(context, R.color.reader_pink_text_color_thirdly)).setTheme_text(MiReadingTheme.PINK_THEME_TEXT).setBackgroundImagePath("pink_mode_bg.webp").setIsColorBackground(false).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_pink_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_pink_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_pink_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_pink_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_day).setBorderBackgroundLightButton(R.drawable.reader_theme_pink_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_pink_line_background).setProgressBarBackground(R.drawable.reader_theme_pink_progressbar_float).setTextColorAux(context.getResources().getColor(R.color.transparent_grey)).setVipHintColor(context.getResources().getColor(R.color.transparent_grey)).setFreeHintColor(context.getResources().getColor(R.color.transparent_grey)).setNavigationBarBackground(R.color.reader_pink_background_primary).setNavigationBarBackgroundNight(R.color.reader_pink_background_primary_night).setNavigationBarBackgroundSecondaryNight(R.color.reader_pink_background_secondary_night).setReadingClaimColor(context.getResources().getColor(R.color.transparent_grey)).setSelectorRes(R.drawable.reader_theme_pink_selector).setTopRoundBgRes(R.drawable.reader_theme_pink_top_round).setRoundBgRes(R.drawable.reader_theme_pink_round_button).setRound4DpBgRes(R.drawable.reader_theme_pink_round_4dp);
        MiReadingTheme round4DpBgRes5 = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_night2_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_night2_item_color_primary_alpha8)).setBackgroundPrimary(ContextCompat.getColor(context, R.color.reader_night2_background_primary)).setBackgroundSecondary(R.color.reader_night2_background_secondary).setTextColorPrimary(ContextCompat.getColor(context, R.color.reader_night2_text_color_primary)).setTextColorThirdly(ContextCompat.getColor(context, R.color.reader_night2_text_color_thirdly)).setTheme_text(MiReadingTheme.NIGHT1_THEME_TEXT).setIsColorBackground(true).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_night2_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_night2_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_night2_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_night2_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_night).setBorderBackgroundLightButton(R.drawable.reader_theme_night2_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_night2_line_background).setProgressBarBackground(R.drawable.reader_theme_night2_progressbar_float).setTextColorAux(context.getResources().getColor(R.color.transparent_grey)).setVipHintColor(context.getResources().getColor(R.color.transparent_grey)).setFreeHintColor(context.getResources().getColor(R.color.transparent_grey)).setNavigationBarBackground(R.color.reader_night2_background_primary).setNavigationBarBackgroundNight(R.color.reader_night2_background_primary_night).setNavigationBarBackgroundSecondaryNight(R.color.reader_night2_background_secondary_night).setReadingClaimColor(context.getResources().getColor(R.color.transparent_grey)).setSelectorRes(R.drawable.selector_default_night).setTopRoundBgRes(R.drawable.reader_theme_night2_top_round).setRoundBgRes(R.drawable.reader_theme_night2_round_button).setRound4DpBgRes(R.drawable.reader_theme_night2_round_4dp);
        MiReadingTheme round4DpBgRes6 = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_night1_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_night1_item_color_primary_alpha8)).setBackgroundPrimary(ContextCompat.getColor(context, R.color.reader_night1_background_primary)).setBackgroundSecondary(R.color.reader_night1_background_secondary).setTextColorPrimary(ContextCompat.getColor(context, R.color.reader_night1_text_color_primary)).setTextColorThirdly(ContextCompat.getColor(context, R.color.reader_night1_text_color_thirdly)).setTheme_text(MiReadingTheme.BLACK_THEME_TEXT).setIsColorBackground(true).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_night1_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_night1_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_night1_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_night1_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_night).setBorderBackgroundLightButton(R.drawable.reader_theme_night1_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_night1_line_background).setProgressBarBackground(R.drawable.reader_theme_night1_progressbar_float).setTextColorAux(context.getResources().getColor(R.color.transparent_grey)).setVipHintColor(context.getResources().getColor(R.color.transparent_grey)).setFreeHintColor(context.getResources().getColor(R.color.transparent_grey)).setNavigationBarBackground(R.color.reader_night1_background_primary).setNavigationBarBackgroundNight(R.color.reader_night1_background_primary_night).setNavigationBarBackgroundSecondaryNight(R.color.reader_night1_background_secondary_night).setReadingClaimColor(context.getResources().getColor(R.color.transparent_grey)).setSelectorRes(R.drawable.selector_default_night).setTopRoundBgRes(R.drawable.reader_theme_night1_top_round).setRoundBgRes(R.drawable.reader_theme_night1_round_button).setRound4DpBgRes(R.drawable.reader_theme_night1_round_4dp);
        MiReadingTheme round4DpBgRes7 = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_night3_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_night3_item_color_primary_alpha8)).setBackgroundPrimary(ContextCompat.getColor(context, R.color.reader_night3_background_primary)).setBackgroundSecondary(R.color.reader_night3_background_secondary).setTextColorPrimary(ContextCompat.getColor(context, R.color.reader_night3_text_color_primary)).setTextColorThirdly(ContextCompat.getColor(context, R.color.reader_night3_text_color_thirdly)).setTheme_text(MiReadingTheme.NIGHT2_THEME_TEXT).setIsColorBackground(true).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_night3_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_night3_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_night3_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_night3_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_night).setBorderBackgroundLightButton(R.drawable.reader_theme_night3_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_night3_line_background).setProgressBarBackground(R.drawable.reader_theme_night3_progressbar_float).setTextColorAux(context.getResources().getColor(R.color.transparent_grey)).setVipHintColor(context.getResources().getColor(R.color.transparent_grey)).setFreeHintColor(context.getResources().getColor(R.color.transparent_grey)).setNavigationBarBackground(R.color.reader_night3_background_primary).setNavigationBarBackgroundNight(R.color.reader_night3_background_primary_night).setNavigationBarBackgroundSecondaryNight(R.color.reader_night3_background_secondary_night).setReadingClaimColor(context.getResources().getColor(R.color.transparent_grey)).setSelectorRes(R.drawable.reader_theme_night3_selector).setTopRoundBgRes(R.drawable.reader_theme_night3_top_round).setRoundBgRes(R.drawable.reader_theme_night3_round_button).setRound4DpBgRes(R.drawable.reader_theme_night3_round_4dp);
        MiReadingTheme round4DpBgRes8 = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_default_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_default_item_color_primary_alpha8)).setTheme_text(MiReadingTheme.CUSTOM_THEME_TEXT).setBackgroundPrimary(g()).setBackgroundSecondary(R.color.reader_default_background_secondary).setBackgroundImagePath(h()).setTextColorPrimary(j()).setTextColorThirdly(j()).setIsColorBackground(!C()).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_default_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_default_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_default_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_default_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_day).setBorderBackgroundLightButton(R.drawable.reader_theme_default_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_default_line_background).setProgressBarBackground(R.drawable.reader_theme_default_progressbar_float).setTextColorAux(j()).setVipHintColor(j()).setFreeHintColor(j()).setNavigationBarBackground(i()).setNavigationBarBackgroundNight(R.color.reader_default_background_primary_night).setNavigationBarBackgroundSecondaryNight(R.color.reader_default_background_secondary_night).setReadingClaimColor(j()).setSelectorRes(R.drawable.selector_default_day).setTopRoundBgRes(R.drawable.reader_theme_default_top_round).setRoundBgRes(R.drawable.reader_theme_default_round_button).setRound4DpBgRes(R.drawable.reader_theme_default_round_4dp);
        MiReadingTheme round4DpBgRes9 = new MiReadingTheme().setItemColorPrimary(ContextCompat.getColor(context, R.color.reader_night1_item_color_primary)).setItemColorPrimaryLight(ContextCompat.getColor(context, R.color.reader_night1_item_color_primary_alpha8)).setTheme_text(MiReadingTheme.CUSTOM_THEME_TEXT).setBackgroundPrimary(l()).setBackgroundSecondary(R.color.reader_night1_background_secondary).setBackgroundImagePath(m()).setTextColorPrimary(o()).setTextColorThirdly(o()).setIsColorBackground(!D()).setBorderLineBackgroundNormalRes(R.drawable.reader_theme_night1_line_background_selected).setBorderLineBackgroundLayoutRes(R.drawable.reader_theme_night1_line_background_unselected).setBorderLineBackgroundSelectedRes(R.drawable.reader_theme_night1_background_selected).setSeekBarProgressBackground(R.drawable.reader_theme_night1_progressbar).setSeekBarThumb(R.drawable.reader_bar_icon_night).setBorderBackgroundLightButton(R.drawable.reader_theme_night1_border_background_light).setSelectableLineBackground(R.drawable.reader_theme_night1_line_background).setProgressBarBackground(R.drawable.reader_theme_night1_progressbar_float).setTextColorAux(o()).setVipHintColor(o()).setFreeHintColor(o()).setNavigationBarBackground(R.color.reader_night2_background_primary).setNavigationBarBackgroundNight(n()).setNavigationBarBackgroundSecondaryNight(R.color.reader_night2_background_secondary_night).setReadingClaimColor(o()).setSelectorRes(R.drawable.selector_default_night).setTopRoundBgRes(R.drawable.reader_theme_night2_top_round).setRoundBgRes(R.drawable.reader_theme_night2_round_button).setRound4DpBgRes(R.drawable.reader_theme_night2_round_4dp);
        this.f11344f = new MiReadingTheme[]{round4DpBgRes, round4DpBgRes2, round4DpBgRes3, round4DpBgRes4, round4DpBgRes5, round4DpBgRes6, round4DpBgRes7, round4DpBgRes8};
        this.f11345g = new MiReadingTheme[]{round4DpBgRes5, round4DpBgRes6, round4DpBgRes7, round4DpBgRes, round4DpBgRes2, round4DpBgRes3, round4DpBgRes4, round4DpBgRes9};
    }

    private int u(int index) {
        switch (index) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return 4;
            case 9:
                return 7;
            default:
                return 1;
        }
    }

    private int v(int index) {
        switch (index) {
            case 0:
            case 4:
            case 6:
            case 8:
                return 4;
            case 1:
            case 7:
                return 3;
            case 2:
                return 5;
            case 3:
                return 6;
            case 5:
                return 2;
            case 9:
                return 7;
            default:
                return 0;
        }
    }

    public int A() {
        return r().getTextColorThirdly();
    }

    public int B() {
        if (E()) {
            return 0;
        }
        int s = s();
        return MiConfigSingleton.V3().I0() ? s - 3 : s;
    }

    public boolean C() {
        return com.martian.libsupport.h.d(this.f11343e, MiReadingTheme.PREF_IS_CUSTOM_IMAGE_BACKGROUND, false);
    }

    public boolean D() {
        return com.martian.libsupport.h.d(this.f11343e, MiReadingTheme.PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND, false);
    }

    public boolean E() {
        int s = s();
        return MiConfigSingleton.V3().I0() ? s == 0 || s == 1 || s == 2 || s == 7 : s == 4 || s == 5 || s == 6;
    }

    public void F(boolean isCustomImage) {
        if (MiConfigSingleton.V3().I0()) {
            com.martian.libsupport.h.p(this.f11343e, MiReadingTheme.PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND, isCustomImage);
        } else {
            com.martian.libsupport.h.p(this.f11343e, MiReadingTheme.PREF_IS_CUSTOM_IMAGE_BACKGROUND, isCustomImage);
        }
    }

    public void G(int index) {
        if (MiConfigSingleton.V3().I0()) {
            this.f11347i = index;
            com.martian.libsupport.h.m(this.f11343e, f11342d, index);
        } else {
            this.f11346h = index;
            com.martian.libsupport.h.m(this.f11343e, f11341c, index);
        }
    }

    public int a() {
        return r().getBackgroundPrimary();
    }

    public int b() {
        return ContextCompat.getColor(this.f11343e, r().getBackgroundSecondary());
    }

    public int c() {
        return r().getBorderLineBackgroundLayoutRes();
    }

    public int d() {
        return r().getBorderLineBackgroundSelectedRes();
    }

    public MiReadingTheme e() {
        if (MiConfigSingleton.V3().I0()) {
            return this.f11345g[r0.length - 1];
        }
        return this.f11344f[r0.length - 1];
    }

    public int f() {
        return this.f11344f.length - 1;
    }

    public int g() {
        Context context = this.f11343e;
        return com.martian.libsupport.h.f(context, MiReadingTheme.PREF_CUSTOM_THEME_BACKGROUND_COLOR, ContextCompat.getColor(context, R.color.material_grey_050));
    }

    public String h() {
        return com.martian.libsupport.h.j(this.f11343e, MiReadingTheme.PREF_CUSTOM_THEME_BACKGROUND_IMAGE);
    }

    public int i() {
        return com.martian.libsupport.h.f(this.f11343e, MiReadingTheme.PREF_CUSTOM_THEME_NAVIGATIONBAR_BACKGROUND_COLOR, R.color.reader_default_background_primary);
    }

    public int j() {
        Context context = this.f11343e;
        return com.martian.libsupport.h.f(context, MiReadingTheme.PREF_CUSTOM_THEME_TEXT_COLOR, ContextCompat.getColor(context, R.color.material_grey_850));
    }

    public int k() {
        return r().getItemColorPrimary();
    }

    public int l() {
        Context context = this.f11343e;
        return com.martian.libsupport.h.f(context, MiReadingTheme.PREF_CUSTOM_NIGHT_THEME_BACKGROUND_COLOR, ContextCompat.getColor(context, R.color.material_black));
    }

    public String m() {
        return com.martian.libsupport.h.j(this.f11343e, MiReadingTheme.PREF_CUSTOM_NIGHT_THEME_BACKGROUND_IMAGE);
    }

    public int n() {
        return com.martian.libsupport.h.f(this.f11343e, MiReadingTheme.PREF_CUSTOM_NIGHT_THEME_NAVIGATIONBAR_BACKGROUND_COLOR, R.color.reader_night2_background_primary_night);
    }

    public int o() {
        Context context = this.f11343e;
        return com.martian.libsupport.h.f(context, MiReadingTheme.PREF_CUSTOM_NIGHT_THEME_TEXT_COLOR, ContextCompat.getColor(context, R.color.material_grey_350));
    }

    public int p() {
        int i2 = this.f11346h;
        if (i2 >= 0) {
            return i2;
        }
        int f2 = com.martian.libsupport.h.f(this.f11343e, f11341c, -1);
        this.f11346h = f2;
        if (f2 >= 0) {
            return f2;
        }
        int f3 = com.martian.libsupport.h.f(this.f11343e, f11339a, -1);
        this.f11346h = f3;
        int u = u(f3);
        this.f11346h = u;
        G(u);
        if (this.f11346h >= this.f11344f.length) {
            this.f11346h = 1;
        }
        return this.f11346h;
    }

    public int q() {
        int i2 = this.f11347i;
        if (i2 >= 0) {
            return i2;
        }
        int f2 = com.martian.libsupport.h.f(this.f11343e, f11342d, -1);
        this.f11347i = f2;
        if (f2 >= 0) {
            return f2;
        }
        int f3 = com.martian.libsupport.h.f(this.f11343e, f11340b, -1);
        this.f11347i = f3;
        int v = v(f3);
        this.f11347i = v;
        G(v);
        if (this.f11347i >= this.f11345g.length) {
            this.f11347i = 0;
        }
        return this.f11347i;
    }

    public MiReadingTheme r() {
        return MiConfigSingleton.V3().I0() ? this.f11345g[s()] : this.f11344f[s()];
    }

    public int s() {
        return MiConfigSingleton.V3().I0() ? q() : p();
    }

    public MiReadingTheme[] t() {
        return MiConfigSingleton.V3().I0() ? this.f11345g : this.f11344f;
    }

    public int w() {
        return r().getSeekBarProgressBackground();
    }

    public int x() {
        return r().getSeekBarThumb();
    }

    public int y() {
        return r().getSelectableLineBackground();
    }

    public int z() {
        return r().getTextColorPrimary();
    }
}
