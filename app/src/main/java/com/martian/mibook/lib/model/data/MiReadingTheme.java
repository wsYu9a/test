package com.martian.mibook.lib.model.data;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.maritan.mibook.lib.model.R;
import com.martian.libmars.d.h;

/* loaded from: classes.dex */
public class MiReadingTheme {
    public static String BLACK_THEME_TEXT = "黑色";
    public static String COW_THEME_TEXT = "牛皮";
    public static String CUSTOM_THEME_TEXT = "长按\n编辑";
    public static String GREEN_THEME_TEXT = "护眼";
    public static String NIGHT1_THEME_TEXT = "夜间";
    public static String NIGHT2_THEME_TEXT = "夜间2";
    public static String PINK_THEME_TEXT = "粉色";
    public static final String PREF_CUSTOM_NIGHT_THEME_BACKGROUND_COLOR = "PREF_CUSTOM_NIGHT_THEME_BACKGROUND_COLOR";
    public static final String PREF_CUSTOM_NIGHT_THEME_BACKGROUND_IMAGE = "PREF_CUSTOM_NIGHT_THEME_BACKGROUND_IMAGE";
    public static final String PREF_CUSTOM_NIGHT_THEME_NAVIGATIONBAR_BACKGROUND_COLOR = "PREF_CUSTOM_NIGHT_THEME_NAVIGATIONBAR_BACKGROUND_COLOR";
    public static final String PREF_CUSTOM_NIGHT_THEME_TEXT_COLOR = "PREF_CUSTOM_NIGHT_THEME_TEXT_COLOR";
    public static final String PREF_CUSTOM_THEME_BACKGROUND_COLOR = "PREF_CUSTOM_THEME_BACKGROUND_COLOR";
    public static final String PREF_CUSTOM_THEME_BACKGROUND_IMAGE = "PREF_CUSTOM_THEME_BACKGROUND_IMAGE";
    public static final String PREF_CUSTOM_THEME_NAVIGATIONBAR_BACKGROUND_COLOR = "PREF_CUSTOM_THEME_NAVIGATIONBAR_BACKGROUND_COLOR";
    public static final String PREF_CUSTOM_THEME_TEXT_COLOR = "PREF_CUSTOM_THEME_TEXT_COLOR";
    public static final String PREF_IS_CUSTOM_IMAGE_BACKGROUND = "PREF_IS_CUSTOM_IMAGE_BACKGROUND";
    public static final String PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND = "PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND";
    public static String WHITE_THEME_TEXT = "白色";
    private String backgroundImagePath;
    private int backgroundPrimary;
    private int backgroundSecondary;
    private int borderBackgroundLightButton;
    private int borderLineBackgroundLayoutRes;
    private int borderLineBackgroundNormalRes;
    private int borderLineBackgroundSelectedRes;
    private int buttonBackground;
    private int freeHintColor;
    private boolean isColorBackground = true;
    private int itemColorPrimary;
    private int itemColorPrimaryLight;
    private int navigationBarBackground;
    private int navigationBarBackgroundNight;
    private int navigationBarBackgroundSecondaryNight;
    private int progressBarBackground;
    private int readingClaimColor;
    private int round4DpBgRes;
    private int roundBgRes;
    private int seekBarProgressBackground;
    private int seekBarThumb;
    private int selectableLineBackground;
    private int selectorRes;
    private int textColorAux;
    private int textColorPrimary;
    private int textColorThirdly;
    private String theme_text;
    private int topRoundBgRes;
    private int vipHintColor;

    public String getBackgroundImagePath() {
        String str = this.backgroundImagePath;
        return str == null ? "" : str;
    }

    public int getBackgroundPrimary() {
        return this.backgroundPrimary;
    }

    public int getBackgroundSecondary() {
        return this.backgroundSecondary;
    }

    public int getBorderBackgroundLightButton() {
        return this.borderBackgroundLightButton;
    }

    public int getBorderLineBackgroundLayoutRes() {
        return this.borderLineBackgroundLayoutRes;
    }

    public int getBorderLineBackgroundNormalRes() {
        return this.borderLineBackgroundNormalRes;
    }

    public int getBorderLineBackgroundSelectedRes() {
        return this.borderLineBackgroundSelectedRes;
    }

    public int getButtonBackground() {
        return this.buttonBackground;
    }

    public int getFreeHintColor() {
        return this.freeHintColor;
    }

    public int getItemColorPrimary() {
        return this.itemColorPrimary;
    }

    public int getItemColorPrimaryLight() {
        return this.itemColorPrimaryLight;
    }

    public int getNavigationBarBackground() {
        return this.navigationBarBackground;
    }

    public int getNavigationBarBackgroundNight() {
        return this.navigationBarBackgroundNight;
    }

    public int getNavigationBarBackgroundSecondaryNight() {
        return this.navigationBarBackgroundSecondaryNight;
    }

    public int getProgressBarBackground() {
        return this.progressBarBackground;
    }

    public int getReadingClaimColor() {
        return this.readingClaimColor;
    }

    public int getRound4DpBgRes() {
        return this.round4DpBgRes;
    }

    public int getRoundBgRes() {
        return this.roundBgRes;
    }

    public int getSeekBarProgressBackground() {
        return this.seekBarProgressBackground;
    }

    public int getSeekBarThumb() {
        return this.seekBarThumb;
    }

    public int getSelectableLineBackground() {
        return this.selectableLineBackground;
    }

    public int getSelectorRes() {
        return this.selectorRes;
    }

    public int getTextColorAux() {
        return this.textColorAux;
    }

    public int getTextColorPrimary() {
        return this.textColorPrimary;
    }

    public int getTextColorThirdly() {
        return this.textColorThirdly;
    }

    public String getTheme_text() {
        return this.theme_text;
    }

    public int getTopRoundBgRes() {
        return this.topRoundBgRes;
    }

    public int getVipHintColor() {
        return this.vipHintColor;
    }

    public boolean isColorBackground() {
        return this.isColorBackground;
    }

    public boolean isCowTheme() {
        return COW_THEME_TEXT.equalsIgnoreCase(this.theme_text);
    }

    public boolean isDefaultTheme() {
        return WHITE_THEME_TEXT.equalsIgnoreCase(this.theme_text);
    }

    public void saveCustomTheme(Context context) {
        if (h.F().I0()) {
            com.martian.libsupport.h.m(context, PREF_CUSTOM_NIGHT_THEME_BACKGROUND_COLOR, this.backgroundPrimary);
            com.martian.libsupport.h.m(context, PREF_CUSTOM_NIGHT_THEME_TEXT_COLOR, this.textColorPrimary);
            com.martian.libsupport.h.o(context, PREF_CUSTOM_NIGHT_THEME_BACKGROUND_IMAGE, this.backgroundImagePath);
            com.martian.libsupport.h.p(context, PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND, !this.isColorBackground);
            com.martian.libsupport.h.m(context, PREF_CUSTOM_NIGHT_THEME_NAVIGATIONBAR_BACKGROUND_COLOR, this.navigationBarBackgroundNight);
            return;
        }
        com.martian.libsupport.h.m(context, PREF_CUSTOM_THEME_BACKGROUND_COLOR, this.backgroundPrimary);
        com.martian.libsupport.h.m(context, PREF_CUSTOM_THEME_TEXT_COLOR, this.textColorPrimary);
        com.martian.libsupport.h.o(context, PREF_CUSTOM_THEME_BACKGROUND_IMAGE, this.backgroundImagePath);
        com.martian.libsupport.h.p(context, PREF_IS_CUSTOM_IMAGE_BACKGROUND, !this.isColorBackground);
        com.martian.libsupport.h.m(context, PREF_CUSTOM_THEME_NAVIGATIONBAR_BACKGROUND_COLOR, this.navigationBarBackground);
    }

    public MiReadingTheme setBackgroundImagePath(String backgroundImagePath) {
        this.backgroundImagePath = backgroundImagePath;
        return this;
    }

    public MiReadingTheme setBackgroundPrimary(int background) {
        this.backgroundPrimary = background;
        return this;
    }

    public MiReadingTheme setBackgroundSecondary(int backgroundSecondary) {
        this.backgroundSecondary = backgroundSecondary;
        return this;
    }

    public MiReadingTheme setBorderBackgroundLightButton(int borderBackgroundLightButton) {
        this.borderBackgroundLightButton = borderBackgroundLightButton;
        return this;
    }

    public MiReadingTheme setBorderLineBackgroundLayoutRes(int borderLineBackgroundLayoutRes) {
        this.borderLineBackgroundLayoutRes = borderLineBackgroundLayoutRes;
        return this;
    }

    public MiReadingTheme setBorderLineBackgroundNormalRes(int borderLineBackgroundNormalRes) {
        this.borderLineBackgroundNormalRes = borderLineBackgroundNormalRes;
        return this;
    }

    public MiReadingTheme setBorderLineBackgroundSelectedRes(int borderLineBackgroundSelectedRes) {
        this.borderLineBackgroundSelectedRes = borderLineBackgroundSelectedRes;
        return this;
    }

    public MiReadingTheme setButtonBackground(int buttonBackground) {
        this.buttonBackground = buttonBackground;
        return this;
    }

    public void setColorBackground(boolean colorBackground) {
        this.isColorBackground = colorBackground;
    }

    public void setCustomBackgroundColor(Context context, int color) {
        this.backgroundPrimary = ContextCompat.getColor(context, color);
        if (h.F().I0()) {
            this.navigationBarBackgroundNight = color;
        } else {
            this.navigationBarBackground = color;
        }
        this.isColorBackground = true;
    }

    public void setCustomBackgroundImage(String path) {
        this.backgroundImagePath = path;
        this.isColorBackground = false;
    }

    public void setCustomTextColor(Context context, int color) {
        int color2 = ContextCompat.getColor(context, color);
        this.textColorAux = color2;
        this.textColorPrimary = color2;
        this.textColorThirdly = color2;
        this.vipHintColor = color2;
        this.freeHintColor = color2;
        this.readingClaimColor = color2;
    }

    public MiReadingTheme setFreeHintColor(int freeHintColor) {
        this.freeHintColor = freeHintColor;
        return this;
    }

    public MiReadingTheme setIsColorBackground(boolean colorBackground) {
        this.isColorBackground = colorBackground;
        return this;
    }

    public MiReadingTheme setItemColorPrimary(int itemColorPrimary) {
        this.itemColorPrimary = itemColorPrimary;
        return this;
    }

    public MiReadingTheme setItemColorPrimaryLight(int itemColorPrimaryLight) {
        this.itemColorPrimaryLight = itemColorPrimaryLight;
        return this;
    }

    public MiReadingTheme setNavigationBarBackground(int navigationBarBackground) {
        this.navigationBarBackground = navigationBarBackground;
        return this;
    }

    public MiReadingTheme setNavigationBarBackgroundNight(int navigationBarBackgroundNight) {
        this.navigationBarBackgroundNight = navigationBarBackgroundNight;
        return this;
    }

    public MiReadingTheme setNavigationBarBackgroundSecondaryNight(int navigationBarBackgroundSecondaryNight) {
        this.navigationBarBackgroundSecondaryNight = navigationBarBackgroundSecondaryNight;
        return this;
    }

    public MiReadingTheme setProgressBarBackground(int progressBarBackground) {
        this.progressBarBackground = progressBarBackground;
        return this;
    }

    public MiReadingTheme setReadingClaimColor(int readingClaimColor) {
        this.readingClaimColor = readingClaimColor;
        return this;
    }

    public MiReadingTheme setRound4DpBgRes(int round4DpBgRes) {
        this.round4DpBgRes = round4DpBgRes;
        return this;
    }

    public MiReadingTheme setRoundBgRes(int roundBgRes) {
        this.roundBgRes = roundBgRes;
        return this;
    }

    public MiReadingTheme setSeekBarProgressBackground(int seekBarProgressBackground) {
        this.seekBarProgressBackground = seekBarProgressBackground;
        return this;
    }

    public MiReadingTheme setSeekBarThumb(int seekBarThumb) {
        this.seekBarThumb = seekBarThumb;
        return this;
    }

    public MiReadingTheme setSelectableLineBackground(int selectableLineBackground) {
        this.selectableLineBackground = selectableLineBackground;
        return this;
    }

    public MiReadingTheme setSelectorRes(int selectorRes) {
        this.selectorRes = selectorRes;
        return this;
    }

    public MiReadingTheme setTextColorAux(int textColorAux) {
        this.textColorAux = textColorAux;
        return this;
    }

    public MiReadingTheme setTextColorPrimary(int textColorPrimary) {
        this.textColorPrimary = textColorPrimary;
        return this;
    }

    public MiReadingTheme setTextColorThirdly(int textColorThirdly) {
        this.textColorThirdly = textColorThirdly;
        return this;
    }

    public MiReadingTheme setTheme_text(String theme_text) {
        this.theme_text = theme_text;
        return this;
    }

    public MiReadingTheme setTopRoundBgRes(int topRoundBgRes) {
        this.topRoundBgRes = topRoundBgRes;
        return this;
    }

    public MiReadingTheme setVipHintColor(int vipHintColor) {
        this.vipHintColor = vipHintColor;
        return this;
    }

    public void updateTheme(MiReadingTheme theme) {
        this.backgroundPrimary = theme.backgroundPrimary;
        this.textColorPrimary = theme.textColorPrimary;
        this.textColorThirdly = theme.textColorThirdly;
        this.backgroundImagePath = theme.backgroundImagePath;
        this.isColorBackground = theme.isColorBackground;
        this.navigationBarBackground = theme.navigationBarBackground;
        this.navigationBarBackgroundNight = theme.navigationBarBackgroundNight;
    }

    public int getNavigationBarBackground(boolean fullscreen) {
        return h.F().P0() ? fullscreen ? getNavigationBarBackgroundNight() : getNavigationBarBackgroundSecondaryNight() : fullscreen ? getNavigationBarBackground() : getBackgroundSecondary();
    }

    public int getTextColorPrimary(Context context) {
        return CUSTOM_THEME_TEXT.equalsIgnoreCase(this.theme_text) ? h.F().I0() ? ContextCompat.getColor(context, R.color.night_text_color_secondary) : ContextCompat.getColor(context, R.color.day_text_color_secondary) : this.textColorPrimary;
    }

    public int getTextColorThirdly(Context context) {
        return CUSTOM_THEME_TEXT.equalsIgnoreCase(this.theme_text) ? h.F().I0() ? ContextCompat.getColor(context, R.color.night_text_color_thirdly) : ContextCompat.getColor(context, R.color.day_text_color_thirdly) : this.textColorThirdly;
    }
}
