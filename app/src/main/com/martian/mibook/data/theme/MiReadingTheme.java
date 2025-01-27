package com.martian.mibook.data.theme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import ba.j;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.ThemeItem;
import com.noober.background.drawable.DrawableCreator;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import t8.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\bH\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010j\u001a\u00020\u00032\b\b\u0001\u0010k\u001a\u00020\u00032\b\b\u0001\u0010l\u001a\u00020mH\u0003J\u0012\u0010n\u001a\u00020\u00032\b\b\u0001\u0010k\u001a\u00020\u0003H\u0002J\u001c\u0010o\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010k\u001a\u00020\u0003H\u0002J\u0012\u0010p\u001a\u00020\u00052\b\b\u0001\u0010k\u001a\u00020\u0003H\u0002J\u0012\u0010q\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u0003H\u0002J\u0012\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0012\u0010v\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0012\u0010w\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0012\u0010x\u001a\u00020\u00032\b\b\u0001\u0010y\u001a\u00020\u0003H\u0003J\u000e\u0010z\u001a\u00020\u00032\u0006\u0010t\u001a\u00020uJ\u000e\u0010{\u001a\u00020\u00052\u0006\u0010t\u001a\u00020uJ\u000e\u0010|\u001a\u00020\u00032\u0006\u0010t\u001a\u00020uJ\u0010\u0010}\u001a\u00020\u00032\u0006\u0010~\u001a\u00020$H\u0007J\u000e\u0010\u007f\u001a\u00020\u00032\u0006\u0010t\u001a\u00020uJ\u000f\u0010\u0080\u0001\u001a\u00020\u00052\u0006\u0010t\u001a\u00020uJ\u000f\u0010\u0081\u0001\u001a\u00020\u00032\u0006\u0010t\u001a\u00020uJ\u0013\u0010\u0082\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0013\u0010\u0083\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0013\u0010\u0084\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0013\u0010\u0085\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0013\u0010\u0086\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0013\u0010\u0087\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0013\u0010\u0088\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0013\u0010\u0089\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0015\u0010\u008a\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uH\u0007J\u0013\u0010\u008b\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0013\u0010\u008c\u0001\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uJ\u0007\u0010\u008d\u0001\u001a\u00020$J\u000f\u0010\u008e\u0001\u001a\u00020$2\u0006\u0010t\u001a\u00020uJ\u0007\u0010\u008f\u0001\u001a\u00020$J\u000f\u0010\u0090\u0001\u001a\u00020$2\u0006\u0010t\u001a\u00020uJ\u0007\u0010\u0091\u0001\u001a\u00020$J\u0007\u0010\u0092\u0001\u001a\u00020$J\u0012\u0010\u0093\u0001\u001a\u00030\u0094\u00012\b\b\u0001\u0010\n\u001a\u00020\u0003J\u0013\u0010\u0095\u0001\u001a\u00030\u0094\u00012\t\b\u0001\u0010\u0096\u0001\u001a\u00020\u0003J\u0010\u0010\u0097\u0001\u001a\u00030\u0094\u00012\u0006\u0010t\u001a\u00020uJ\u001a\u0010\u0098\u0001\u001a\u00030\u0094\u00012\u0006\u0010t\u001a\u00020u2\b\b\u0001\u0010k\u001a\u00020\u0003J\u0013\u0010\u0099\u0001\u001a\u00030\u0094\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u009b\u0001\u001a\u00030\u0094\u00012\u0006\u0010t\u001a\u00020u2\b\b\u0001\u0010k\u001a\u00020\u0003J\u0013\u0010\u009c\u0001\u001a\u00030\u0094\u00012\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0000R+\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR+\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR+\u0010\u001b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR+\u0010\u001f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R+\u0010*\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0010\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001e\u0010.\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eR+\u00101\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0010\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR+\u00105\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0010\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR\u001e\u00109\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR+\u0010<\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010\u0010\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR+\u0010@\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\u0010\u001a\u0004\bA\u0010\f\"\u0004\bB\u0010\u000eR\u001e\u0010D\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR+\u0010G\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u0010\u0010\u001a\u0004\bH\u0010\f\"\u0004\bI\u0010\u000eR\u001e\u0010K\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\f\"\u0004\bM\u0010\u000eR+\u0010N\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010\u0010\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000eR\u001e\u0010R\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\f\"\u0004\bT\u0010\u000eR+\u0010U\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bX\u0010\u0010\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR+\u0010Y\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u0010\u001a\u0004\bZ\u0010\f\"\u0004\b[\u0010\u000eR+\u0010]\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010\u0010\u001a\u0004\b^\u0010\f\"\u0004\b_\u0010\u000eR\u001e\u0010a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\f\"\u0004\bc\u0010\u000eR\u001a\u0010d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\f\"\u0004\bf\u0010\u000eR\u001a\u0010g\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\f\"\u0004\bi\u0010\u000e¨\u0006\u009e\u0001"}, d2 = {"Lcom/martian/mibook/data/theme/MiReadingTheme;", "Lcom/martian/mibook/data/theme/ThemeItem;", "themeId", "", "themeName", "", "type", "Lcom/martian/mibook/data/theme/ReaderThemeType;", "(ILjava/lang/String;Lcom/martian/mibook/data/theme/ReaderThemeType;)V", "<set-?>", "backgroundColor", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "backgroundColor$delegate", "Lcom/martian/mibook/data/theme/ThemeItem$ColorDelegate;", "backgroundColorRes", "getBackgroundColorRes", "setBackgroundColorRes", "backgroundNavigationBarColor", "getBackgroundNavigationBarColor", "setBackgroundNavigationBarColor", "backgroundNavigationBarColor$delegate", "backgroundNavigationBarColorRes", "getBackgroundNavigationBarColorRes", "setBackgroundNavigationBarColorRes", "backgroundNavigationBarNightColor", "getBackgroundNavigationBarNightColor", "setBackgroundNavigationBarNightColor", "backgroundNavigationBarNightColor$delegate", "highLightSelectBackground", "getHighLightSelectBackground", "setHighLightSelectBackground", "highLightSelectBackground$delegate", "isColorBackground", "", "()Z", "setColorBackground", "(Z)V", "isDarkTheme", "setDarkTheme", "itemColorPrimary", "getItemColorPrimary", "setItemColorPrimary", "itemColorPrimary$delegate", "itemColorPrimaryColorRes", "getItemColorPrimaryColorRes", "setItemColorPrimaryColorRes", "itemColorPrimaryLight", "getItemColorPrimaryLight", "setItemColorPrimaryLight", "itemColorPrimaryLight$delegate", "popupBackgroundColor", "getPopupBackgroundColor", "setPopupBackgroundColor", "popupBackgroundColor$delegate", "popupBackgroundColorRes", "getPopupBackgroundColorRes", "setPopupBackgroundColorRes", "popupBackgroundNavigationBarColor", "getPopupBackgroundNavigationBarColor", "setPopupBackgroundNavigationBarColor", "popupBackgroundNavigationBarColor$delegate", "popupBackgroundNavigationBarNightColor", "getPopupBackgroundNavigationBarNightColor", "setPopupBackgroundNavigationBarNightColor", "popupBackgroundNavigationBarNightColor$delegate", "selectBackgroundColorRes", "getSelectBackgroundColorRes", "setSelectBackgroundColorRes", "textColorPrimary", "getTextColorPrimary", "setTextColorPrimary", "textColorPrimary$delegate", "textColorPrimaryColorRes", "getTextColorPrimaryColorRes", "setTextColorPrimaryColorRes", "textColorSecondary", "getTextColorSecondary", "setTextColorSecondary", "textColorSecondary$delegate", "textColorSecondaryColorRes", "getTextColorSecondaryColorRes", "setTextColorSecondaryColorRes", "textColorThirdly", "getTextColorThirdly", "setTextColorThirdly", "textColorThirdly$delegate", "textColorThirdlyAlpha10", "getTextColorThirdlyAlpha10", "setTextColorThirdlyAlpha10", "textColorThirdlyAlpha10$delegate", "textColorThirdlyAlpha20", "getTextColorThirdlyAlpha20", "setTextColorThirdlyAlpha20", "textColorThirdlyAlpha20$delegate", "textColorThirdlyColorRes", "getTextColorThirdlyColorRes", "setTextColorThirdlyColorRes", "unlockByCoins", "getUnlockByCoins", "setUnlockByCoins", "unlockExpLevel", "getUnlockExpLevel", "setUnlockExpLevel", "applyAlphaToColor", "color", "alpha", "", "applyNightModeOverlaySimple", "applyTextOverlay", "colorIntToHex", "generateBrighterColor", "getBorderBackgroundLightButtonDrawable", "Landroid/graphics/drawable/Drawable;", f.X, "Landroid/content/Context;", "getBorderLineBackgroundLayoutDrawable", "getBorderLineBackgroundSelectedDrawable", "getColorFromRes", "colorResId", "getDayCustomBackgroundColor", "getDayCustomBackgroundImage", "getDayCustomTextColor", "getNavigationBarBackgroundColor", "fullscreen", "getNightCustomBackgroundColor", "getNightCustomBackgroundImage", "getNightCustomTextColor", "getProgressBarBackgroundDrawable", "getRound12dpBgDrawable", "getRound4DpBgDrawable", "getRound8DpBgResTextThirdlyDrawable", "getRoundBgResTextThirdlyDrawable", "getSeekBarProgressBackgroundDrawable", "getSeekBarThumbDrawable", "getSwitchButtonSelectedDrawable", "getSwitchButtonSelectorDrawable", "getSwitchButtonUnSelectedDrawable", "getTopRoundBgDrawable", "isCustomTheme", "isDayCustomImageBackground", "isDownloadFinishTheme", "isNightCustomImageBackground", "isVipDownloadTheme", "isVipTheme", "refreshCustomThemeBackgroundInfo", "", "refreshCustomThemeTextInfo", "customTextColor", "saveCustomTheme", "setCustomBackgroundColor", "setCustomBackgroundImage", a.f30751f, "setCustomTextColor", "updateTheme", "theme", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MiReadingTheme extends ThemeItem {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "itemColorPrimary", "getItemColorPrimary()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "textColorPrimary", "getTextColorPrimary()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "textColorSecondary", "getTextColorSecondary()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "textColorThirdly", "getTextColorThirdly()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "backgroundColor", "getBackgroundColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "popupBackgroundColor", "getPopupBackgroundColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "backgroundNavigationBarColor", "getBackgroundNavigationBarColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "popupBackgroundNavigationBarColor", "getPopupBackgroundNavigationBarColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "backgroundNavigationBarNightColor", "getBackgroundNavigationBarNightColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "popupBackgroundNavigationBarNightColor", "getPopupBackgroundNavigationBarNightColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "highLightSelectBackground", "getHighLightSelectBackground()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "itemColorPrimaryLight", "getItemColorPrimaryLight()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "textColorThirdlyAlpha10", "getTextColorThirdlyAlpha10()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MiReadingTheme.class, "textColorThirdlyAlpha20", "getTextColorThirdlyAlpha20()I", 0))};

    /* renamed from: backgroundColor$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate backgroundColor;

    @ColorRes
    private int backgroundColorRes;

    /* renamed from: backgroundNavigationBarColor$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate backgroundNavigationBarColor;

    @ColorRes
    private int backgroundNavigationBarColorRes;

    /* renamed from: backgroundNavigationBarNightColor$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate backgroundNavigationBarNightColor;

    /* renamed from: highLightSelectBackground$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate highLightSelectBackground;
    private boolean isColorBackground;
    private boolean isDarkTheme;

    /* renamed from: itemColorPrimary$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate itemColorPrimary;

    @ColorRes
    private int itemColorPrimaryColorRes;

    /* renamed from: itemColorPrimaryLight$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate itemColorPrimaryLight;

    /* renamed from: popupBackgroundColor$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate popupBackgroundColor;

    @ColorRes
    private int popupBackgroundColorRes;

    /* renamed from: popupBackgroundNavigationBarColor$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate popupBackgroundNavigationBarColor;

    /* renamed from: popupBackgroundNavigationBarNightColor$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate popupBackgroundNavigationBarNightColor;

    @ColorRes
    private int selectBackgroundColorRes;

    /* renamed from: textColorPrimary$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate textColorPrimary;

    @ColorRes
    private int textColorPrimaryColorRes;

    /* renamed from: textColorSecondary$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate textColorSecondary;

    @ColorRes
    private int textColorSecondaryColorRes;

    /* renamed from: textColorThirdly$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate textColorThirdly;

    /* renamed from: textColorThirdlyAlpha10$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate textColorThirdlyAlpha10;

    /* renamed from: textColorThirdlyAlpha20$delegate, reason: from kotlin metadata */
    @k
    private final ThemeItem.ColorDelegate textColorThirdlyAlpha20;

    @ColorRes
    private int textColorThirdlyColorRes;
    private int unlockByCoins;
    private int unlockExpLevel;

    public MiReadingTheme(int i10, @l String str, @l ReaderThemeType readerThemeType) {
        super(i10, str, readerThemeType);
        this.isColorBackground = readerThemeType != ReaderThemeType.THEME_VIP_DOWNLOADED;
        this.itemColorPrimary = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$itemColorPrimary$2
            public MiReadingTheme$itemColorPrimary$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getItemColorPrimaryColorRes());
                return Integer.valueOf(colorFromRes);
            }
        });
        this.textColorPrimary = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$textColorPrimary$2
            public MiReadingTheme$textColorPrimary$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getTextColorPrimaryColorRes());
                return Integer.valueOf(colorFromRes);
            }
        });
        this.textColorSecondary = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$textColorSecondary$2
            public MiReadingTheme$textColorSecondary$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getTextColorSecondaryColorRes());
                return Integer.valueOf(colorFromRes);
            }
        });
        this.textColorThirdly = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$textColorThirdly$2
            public MiReadingTheme$textColorThirdly$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getTextColorThirdlyColorRes());
                return Integer.valueOf(colorFromRes);
            }
        });
        this.backgroundColor = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$backgroundColor$2
            public MiReadingTheme$backgroundColor$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getBackgroundColorRes());
                return Integer.valueOf(colorFromRes);
            }
        });
        this.popupBackgroundColor = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$popupBackgroundColor$2
            public MiReadingTheme$popupBackgroundColor$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getPopupBackgroundColorRes());
                return Integer.valueOf(colorFromRes);
            }
        });
        this.backgroundNavigationBarColor = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$backgroundNavigationBarColor$2
            public MiReadingTheme$backgroundNavigationBarColor$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getBackgroundNavigationBarColorRes());
                return Integer.valueOf(colorFromRes);
            }
        });
        this.popupBackgroundNavigationBarColor = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$popupBackgroundNavigationBarColor$2
            public MiReadingTheme$popupBackgroundNavigationBarColor$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getPopupBackgroundColorRes());
                return Integer.valueOf(colorFromRes);
            }
        });
        this.backgroundNavigationBarNightColor = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$backgroundNavigationBarNightColor$2
            public MiReadingTheme$backgroundNavigationBarNightColor$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int backgroundNavigationBarColor;
                int applyNightModeOverlaySimple;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                backgroundNavigationBarColor = miReadingTheme.getBackgroundNavigationBarColor();
                applyNightModeOverlaySimple = miReadingTheme.applyNightModeOverlaySimple(backgroundNavigationBarColor);
                return Integer.valueOf(applyNightModeOverlaySimple);
            }
        });
        this.popupBackgroundNavigationBarNightColor = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$popupBackgroundNavigationBarNightColor$2
            public MiReadingTheme$popupBackgroundNavigationBarNightColor$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int popupBackgroundNavigationBarColor;
                int applyNightModeOverlaySimple;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                popupBackgroundNavigationBarColor = miReadingTheme.getPopupBackgroundNavigationBarColor();
                applyNightModeOverlaySimple = miReadingTheme.applyNightModeOverlaySimple(popupBackgroundNavigationBarColor);
                return Integer.valueOf(applyNightModeOverlaySimple);
            }
        });
        this.highLightSelectBackground = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$highLightSelectBackground$2
            public MiReadingTheme$highLightSelectBackground$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int colorFromRes;
                int applyAlphaToColor;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                colorFromRes = miReadingTheme.getColorFromRes(miReadingTheme.getSelectBackgroundColorRes());
                applyAlphaToColor = miReadingTheme.applyAlphaToColor(colorFromRes, 0.2f);
                return Integer.valueOf(applyAlphaToColor);
            }
        });
        this.itemColorPrimaryLight = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$itemColorPrimaryLight$2
            public MiReadingTheme$itemColorPrimaryLight$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int applyAlphaToColor;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                applyAlphaToColor = miReadingTheme.applyAlphaToColor(miReadingTheme.getItemColorPrimary(), 0.08f);
                return Integer.valueOf(applyAlphaToColor);
            }
        });
        this.textColorThirdlyAlpha10 = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$textColorThirdlyAlpha10$2
            public MiReadingTheme$textColorThirdlyAlpha10$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int applyAlphaToColor;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                applyAlphaToColor = miReadingTheme.applyAlphaToColor(miReadingTheme.getTextColorThirdly(), 0.1f);
                return Integer.valueOf(applyAlphaToColor);
            }
        });
        this.textColorThirdlyAlpha20 = new ThemeItem.ColorDelegate(new Function0<Integer>() { // from class: com.martian.mibook.data.theme.MiReadingTheme$textColorThirdlyAlpha20$2
            public MiReadingTheme$textColorThirdlyAlpha20$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Integer invoke() {
                int applyAlphaToColor;
                MiReadingTheme miReadingTheme = MiReadingTheme.this;
                applyAlphaToColor = miReadingTheme.applyAlphaToColor(miReadingTheme.getTextColorThirdly(), 0.2f);
                return Integer.valueOf(applyAlphaToColor);
            }
        });
        this.unlockExpLevel = 50;
    }

    @ColorInt
    public final int applyAlphaToColor(@ColorInt int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        return (color & 16777215) | (RangesKt.coerceIn((int) (alpha * 255), 0, 255) << 24);
    }

    public final int applyNightModeOverlaySimple(@ColorInt int color) {
        if (color == 0) {
            return 0;
        }
        int blendARGB = ColorUtils.blendARGB(color, Color.parseColor("#80000000"), 0.5f);
        return Color.rgb(Color.red(blendARGB), Color.green(blendARGB), Color.blue(blendARGB));
    }

    private final int applyTextOverlay(@ColorInt int backgroundColor, @ColorInt int color) {
        if (color == 0) {
            return 0;
        }
        int blendARGB = ColorUtils.blendARGB(color, backgroundColor, Color.alpha(color) / 255.0f);
        return Color.rgb(Color.red(blendARGB), Color.green(blendARGB), Color.blue(blendARGB));
    }

    private final String colorIntToHex(@ColorInt int color) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(color)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final int generateBrighterColor(@ColorInt int backgroundColor) {
        float[] fArr = new float[3];
        Color.colorToHSV(backgroundColor, fArr);
        return Color.HSVToColor(new float[]{fArr[0], fArr[1], RangesKt.coerceAtMost(fArr[2] + 0.1f, 1.0f)});
    }

    public final int getBackgroundNavigationBarColor() {
        return this.backgroundNavigationBarColor.getValue((Object) this, $$delegatedProperties[6]).intValue();
    }

    private final int getBackgroundNavigationBarNightColor() {
        return this.backgroundNavigationBarNightColor.getValue((Object) this, $$delegatedProperties[8]).intValue();
    }

    @ColorInt
    public final int getColorFromRes(@ColorRes int colorResId) {
        Context applicationContext = MiConfigSingleton.b2().getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        return ContextCompat.getColor(applicationContext, colorResId);
    }

    public final int getPopupBackgroundNavigationBarColor() {
        return this.popupBackgroundNavigationBarColor.getValue((Object) this, $$delegatedProperties[7]).intValue();
    }

    private final int getPopupBackgroundNavigationBarNightColor() {
        return this.popupBackgroundNavigationBarNightColor.getValue((Object) this, $$delegatedProperties[9]).intValue();
    }

    private final int getTextColorThirdlyAlpha10() {
        return this.textColorThirdlyAlpha10.getValue((Object) this, $$delegatedProperties[12]).intValue();
    }

    private final void setBackgroundNavigationBarColor(int i10) {
        this.backgroundNavigationBarColor.setValue(this, $$delegatedProperties[6], i10);
    }

    private final void setBackgroundNavigationBarNightColor(int i10) {
        this.backgroundNavigationBarNightColor.setValue(this, $$delegatedProperties[8], i10);
    }

    private final void setPopupBackgroundNavigationBarColor(int i10) {
        this.popupBackgroundNavigationBarColor.setValue(this, $$delegatedProperties[7], i10);
    }

    private final void setPopupBackgroundNavigationBarNightColor(int i10) {
        this.popupBackgroundNavigationBarNightColor.setValue(this, $$delegatedProperties[9], i10);
    }

    private final void setTextColorThirdlyAlpha10(int i10) {
        this.textColorThirdlyAlpha10.setValue(this, $$delegatedProperties[12], i10);
    }

    public final int getBackgroundColor() {
        return this.backgroundColor.getValue((Object) this, $$delegatedProperties[4]).intValue();
    }

    public final int getBackgroundColorRes() {
        return this.backgroundColorRes;
    }

    public final int getBackgroundNavigationBarColorRes() {
        return this.backgroundNavigationBarColorRes;
    }

    @l
    public final Drawable getBorderBackgroundLightButtonDrawable(@l Context r32) {
        if (r32 == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSolidColor(getTextColorThirdlyAlpha10()).setCornersRadius(dp2px(r32, 100.0f)).build();
    }

    @l
    public final Drawable getBorderLineBackgroundLayoutDrawable(@l Context r32) {
        if (r32 == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSolidColor(ContextCompat.getColor(r32, R.color.transparent)).setCornersRadius(dp2px(r32, 100.0f)).setStrokeColor(getTextColorThirdlyAlpha20()).setStrokeWidth(dp2px(r32, 1.0f)).build();
    }

    @l
    public final Drawable getBorderLineBackgroundSelectedDrawable(@l Context r32) {
        if (r32 == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSolidColor(getItemColorPrimary()).setCornersRadius(dp2px(r32, 100.0f)).build();
    }

    public final int getDayCustomBackgroundColor(@k Context r32) {
        Intrinsics.checkNotNullParameter(r32, "context");
        return j.f(r32, ThemeItem.PREF_CUSTOM_THEME_BACKGROUND_COLOR, ContextCompat.getColor(r32, com.martian.mibook.R.color.material_grey_050));
    }

    @k
    public final String getDayCustomBackgroundImage(@k Context r22) {
        Intrinsics.checkNotNullParameter(r22, "context");
        String j10 = j.j(r22, ThemeItem.PREF_CUSTOM_THEME_BACKGROUND_IMAGE);
        return j10 == null ? "" : j10;
    }

    public final int getDayCustomTextColor(@k Context r32) {
        Intrinsics.checkNotNullParameter(r32, "context");
        return j.f(r32, ThemeItem.PREF_CUSTOM_THEME_TEXT_COLOR, ContextCompat.getColor(r32, com.martian.mibook.R.color.material_grey_850));
    }

    public final int getHighLightSelectBackground() {
        return this.highLightSelectBackground.getValue((Object) this, $$delegatedProperties[10]).intValue();
    }

    public final int getItemColorPrimary() {
        return this.itemColorPrimary.getValue((Object) this, $$delegatedProperties[0]).intValue();
    }

    public final int getItemColorPrimaryColorRes() {
        return this.itemColorPrimaryColorRes;
    }

    public final int getItemColorPrimaryLight() {
        return this.itemColorPrimaryLight.getValue((Object) this, $$delegatedProperties[11]).intValue();
    }

    @ColorInt
    public final int getNavigationBarBackgroundColor(boolean fullscreen) {
        return ConfigSingleton.D().H0() ? fullscreen ? getBackgroundNavigationBarNightColor() : getPopupBackgroundNavigationBarNightColor() : fullscreen ? getBackgroundNavigationBarColor() : getPopupBackgroundNavigationBarColor();
    }

    public final int getNightCustomBackgroundColor(@k Context r32) {
        Intrinsics.checkNotNullParameter(r32, "context");
        return j.f(r32, ThemeItem.PREF_CUSTOM_NIGHT_THEME_BACKGROUND_COLOR, ContextCompat.getColor(r32, com.martian.mibook.R.color.material_black));
    }

    @k
    public final String getNightCustomBackgroundImage(@k Context r22) {
        Intrinsics.checkNotNullParameter(r22, "context");
        String j10 = j.j(r22, ThemeItem.PREF_CUSTOM_NIGHT_THEME_BACKGROUND_IMAGE);
        return j10 == null ? "" : j10;
    }

    public final int getNightCustomTextColor(@k Context r32) {
        Intrinsics.checkNotNullParameter(r32, "context");
        return j.f(r32, ThemeItem.PREF_CUSTOM_NIGHT_THEME_TEXT_COLOR, ContextCompat.getColor(r32, com.martian.mibook.R.color.material_grey_350));
    }

    public final int getPopupBackgroundColor() {
        return this.popupBackgroundColor.getValue((Object) this, $$delegatedProperties[5]).intValue();
    }

    public final int getPopupBackgroundColorRes() {
        return this.popupBackgroundColorRes;
    }

    @l
    public final Drawable getProgressBarBackgroundDrawable(@l Context r12) {
        if (r12 == null) {
            return null;
        }
        float dp2px = dp2px(r12, 12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px});
        gradientDrawable.setColor(getTextColorThirdlyAlpha10());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px});
        gradientDrawable2.setColor(getTextColorThirdlyAlpha20());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, GravityCompat.START, 1)});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.progress);
        return layerDrawable;
    }

    @l
    public final Drawable getRound12dpBgDrawable(@l Context r32) {
        if (r32 == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSolidColor(getPopupBackgroundColor()).setCornersRadius(dp2px(r32, 12.0f)).build();
    }

    @l
    public final Drawable getRound4DpBgDrawable(@l Context r32) {
        if (r32 == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSolidColor(getTextColorThirdlyAlpha10()).setCornersRadius(dp2px(r32, 4.0f)).build();
    }

    @l
    public final Drawable getRound8DpBgResTextThirdlyDrawable(@l Context r32) {
        if (r32 == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSolidColor(getTextColorThirdlyAlpha10()).setCornersRadius(dp2px(r32, 8.0f)).build();
    }

    @l
    public final Drawable getRoundBgResTextThirdlyDrawable(@l Context r32) {
        if (r32 == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSolidColor(getTextColorThirdlyAlpha10()).setCornersRadius(dp2px(r32, 100.0f)).build();
    }

    @l
    public final Drawable getSeekBarProgressBackgroundDrawable(@l Context r20) {
        if (r20 == null) {
            return null;
        }
        float dp2px = dp2px(r20, 16.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px});
        gradientDrawable.setColor(getTextColorThirdlyAlpha10());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadii(new float[]{dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f, dp2px, dp2px});
        gradientDrawable2.setColor(getTextColorThirdlyAlpha10());
        int i10 = (int) dp2px;
        gradientDrawable2.setSize(i10, -1);
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        if (Build.VERSION.SDK_INT >= 23) {
            layerDrawable.setLayerGravity(1, GravityCompat.START);
        }
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setColor(getTextColorThirdlyAlpha10());
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable3, GravityCompat.START, 1);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setColor(getTextColorThirdlyAlpha10());
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{layerDrawable, clipDrawable, new ClipDrawable(gradientDrawable4, GravityCompat.START, 1)});
        int i11 = -i10;
        layerDrawable2.setLayerInset(0, i11, 0, i11, 0);
        layerDrawable2.setId(0, android.R.id.background);
        layerDrawable2.setId(1, android.R.id.secondaryProgress);
        layerDrawable2.setId(2, android.R.id.progress);
        return layerDrawable2;
    }

    @l
    public final Drawable getSeekBarThumbDrawable(@l Context r13) {
        if (r13 == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float dp2px = dp2px(r13, 16.0f);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f});
        gradientDrawable.setColor(getTextColorThirdlyAlpha10());
        int i10 = (int) dp2px;
        gradientDrawable.setSize(i10, i10);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(this.isDarkTheme ? ContextCompat.getColor(r13, R.color.white) : getPopupBackgroundColor());
        int dp2px2 = (int) dp2px(r13, 28.0f);
        gradientDrawable2.setSize(dp2px2, dp2px2);
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        if (Build.VERSION.SDK_INT >= 23) {
            layerDrawable.setLayerGravity(0, GravityCompat.END);
            layerDrawable.setLayerGravity(1, 17);
        }
        int dp2px3 = (int) dp2px(r13, 2.0f);
        layerDrawable.setLayerInset(1, dp2px3, dp2px3, dp2px3, dp2px3);
        return layerDrawable;
    }

    public final int getSelectBackgroundColorRes() {
        return this.selectBackgroundColorRes;
    }

    @l
    public final Drawable getSwitchButtonSelectedDrawable(@l Context r13) {
        if (r13 == null) {
            return null;
        }
        float dp2px = dp2px(r13, 100.0f);
        int dp2px2 = (int) dp2px(r13, 18.0f);
        int dp2px3 = (int) dp2px(r13, 2.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px});
        gradientDrawable.setColor(getItemColorPrimary());
        int i10 = (dp2px3 * 2) + dp2px2;
        gradientDrawable.setSize(i10 * 2, i10);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(ContextCompat.getColor(r13, R.color.white));
        gradientDrawable2.setSize(dp2px2, dp2px2);
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        if (Build.VERSION.SDK_INT >= 23) {
            layerDrawable.setLayerGravity(1, GravityCompat.END);
        }
        layerDrawable.setLayerInset(1, dp2px3, dp2px3, dp2px3, dp2px3);
        return layerDrawable;
    }

    @l
    @SuppressLint({"NewApi"})
    public final Drawable getSwitchButtonSelectorDrawable(@l Context r32) {
        if (r32 == null) {
            return null;
        }
        Drawable switchButtonSelectedDrawable = getSwitchButtonSelectedDrawable(r32);
        Drawable switchButtonUnSelectedDrawable = getSwitchButtonUnSelectedDrawable(r32);
        if (switchButtonSelectedDrawable == null || switchButtonUnSelectedDrawable == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSelectedDrawable(switchButtonSelectedDrawable).setUnSelectedDrawable(switchButtonUnSelectedDrawable).build();
    }

    @l
    public final Drawable getSwitchButtonUnSelectedDrawable(@l Context r13) {
        if (r13 == null) {
            return null;
        }
        float dp2px = dp2px(r13, 100.0f);
        int dp2px2 = (int) dp2px(r13, 18.0f);
        int dp2px3 = (int) dp2px(r13, 2.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px});
        gradientDrawable.setColor(getTextColorThirdlyAlpha20());
        int i10 = (dp2px3 * 2) + dp2px2;
        gradientDrawable.setSize(i10 * 2, i10);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(ContextCompat.getColor(r13, R.color.white));
        gradientDrawable2.setSize(dp2px2, dp2px2);
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        if (Build.VERSION.SDK_INT >= 23) {
            layerDrawable.setLayerGravity(1, GravityCompat.START);
        }
        layerDrawable.setLayerInset(1, dp2px3, dp2px3, dp2px3, dp2px3);
        return layerDrawable;
    }

    public final int getTextColorPrimary() {
        return this.textColorPrimary.getValue((Object) this, $$delegatedProperties[1]).intValue();
    }

    public final int getTextColorPrimaryColorRes() {
        return this.textColorPrimaryColorRes;
    }

    public final int getTextColorSecondary() {
        return this.textColorSecondary.getValue((Object) this, $$delegatedProperties[2]).intValue();
    }

    public final int getTextColorSecondaryColorRes() {
        return this.textColorSecondaryColorRes;
    }

    public final int getTextColorThirdly() {
        return this.textColorThirdly.getValue((Object) this, $$delegatedProperties[3]).intValue();
    }

    public final int getTextColorThirdlyAlpha20() {
        return this.textColorThirdlyAlpha20.getValue((Object) this, $$delegatedProperties[13]).intValue();
    }

    public final int getTextColorThirdlyColorRes() {
        return this.textColorThirdlyColorRes;
    }

    @l
    public final Drawable getTopRoundBgDrawable(@l Context r42) {
        if (r42 == null) {
            return null;
        }
        return new DrawableCreator.Builder().setSolidColor(getPopupBackgroundColor()).setCornersRadius(0.0f, 0.0f, dp2px(r42, 12.0f), dp2px(r42, 12.0f)).build();
    }

    public final int getUnlockByCoins() {
        return this.unlockByCoins;
    }

    public final int getUnlockExpLevel() {
        return this.unlockExpLevel;
    }

    /* renamed from: isColorBackground, reason: from getter */
    public final boolean getIsColorBackground() {
        return this.isColorBackground;
    }

    public final boolean isCustomTheme() {
        return getType() == ReaderThemeType.THEME_CUSTOM;
    }

    /* renamed from: isDarkTheme, reason: from getter */
    public final boolean getIsDarkTheme() {
        return this.isDarkTheme;
    }

    public final boolean isDayCustomImageBackground(@k Context r32) {
        Intrinsics.checkNotNullParameter(r32, "context");
        return j.d(r32, ThemeItem.PREF_IS_CUSTOM_IMAGE_BACKGROUND, false);
    }

    public final boolean isDownloadFinishTheme() {
        if (getDownLoadStatus() == 0) {
            return !isVipDownloadTheme() || (!TextUtils.isEmpty(getBackgroundImagePath()) && new File(getBackgroundImagePath()).exists());
        }
        return false;
    }

    public final boolean isNightCustomImageBackground(@k Context r32) {
        Intrinsics.checkNotNullParameter(r32, "context");
        return j.d(r32, ThemeItem.PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND, false);
    }

    public final boolean isVipDownloadTheme() {
        return getType() == ReaderThemeType.THEME_VIP_DOWNLOADED;
    }

    public final boolean isVipTheme() {
        if (MiConfigSingleton.b2().W1() >= this.unlockExpLevel) {
            return false;
        }
        if (this.unlockByCoins <= 0 || (MiConfigSingleton.b2().l2() & this.unlockByCoins) <= 0) {
            return isVipDownloadTheme();
        }
        return false;
    }

    public final void refreshCustomThemeBackgroundInfo(@ColorInt int backgroundColor) {
        setBackgroundColor(backgroundColor);
        setPopupBackgroundColor(generateBrighterColor(backgroundColor));
        setBackgroundNavigationBarColor(getBackgroundColor());
        setPopupBackgroundNavigationBarColor(getPopupBackgroundColor());
        setBackgroundNavigationBarNightColor(applyNightModeOverlaySimple(getBackgroundColor()));
        setPopupBackgroundNavigationBarNightColor(applyNightModeOverlaySimple(getPopupBackgroundColor()));
        this.isDarkTheme = ColorUtils.calculateLuminance(backgroundColor) <= 0.5d;
    }

    public final void refreshCustomThemeTextInfo(@ColorInt int customTextColor) {
        setTextColorPrimary(customTextColor);
        setTextColorSecondary(applyTextOverlay(getBackgroundColor(), applyAlphaToColor(customTextColor, 0.3f)));
        setTextColorThirdly(applyTextOverlay(getBackgroundColor(), applyAlphaToColor(customTextColor, 0.6f)));
        setTextColorThirdlyAlpha10(applyAlphaToColor(getTextColorThirdly(), 0.05f));
        setTextColorThirdlyAlpha20(applyAlphaToColor(getTextColorThirdly(), 0.1f));
        setHighLightSelectBackground(applyAlphaToColor(getItemColorPrimary(), 0.2f));
    }

    public final void saveCustomTheme(@k Context r32) {
        Intrinsics.checkNotNullParameter(r32, "context");
        if (ConfigSingleton.D().H0()) {
            j.m(r32, ThemeItem.PREF_CUSTOM_NIGHT_THEME_BACKGROUND_COLOR, getBackgroundColor());
            j.m(r32, ThemeItem.PREF_CUSTOM_NIGHT_THEME_TEXT_COLOR, getTextColorPrimary());
            j.o(r32, ThemeItem.PREF_CUSTOM_NIGHT_THEME_BACKGROUND_IMAGE, getBackgroundImagePath());
            j.p(r32, ThemeItem.PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND, !this.isColorBackground);
            j.m(r32, ThemeItem.PREF_CUSTOM_NIGHT_THEME_NAVIGATIONBAR_BACKGROUND_COLOR, getBackgroundNavigationBarNightColor());
            return;
        }
        j.m(r32, ThemeItem.PREF_CUSTOM_THEME_BACKGROUND_COLOR, getBackgroundColor());
        j.m(r32, ThemeItem.PREF_CUSTOM_THEME_TEXT_COLOR, getTextColorPrimary());
        j.o(r32, ThemeItem.PREF_CUSTOM_THEME_BACKGROUND_IMAGE, getBackgroundImagePath());
        j.p(r32, ThemeItem.PREF_IS_CUSTOM_IMAGE_BACKGROUND, !this.isColorBackground);
        j.m(r32, ThemeItem.PREF_CUSTOM_THEME_NAVIGATIONBAR_BACKGROUND_COLOR, getBackgroundNavigationBarColor());
    }

    public final void setBackgroundColor(int i10) {
        this.backgroundColor.setValue(this, $$delegatedProperties[4], i10);
    }

    public final void setBackgroundColorRes(int i10) {
        this.backgroundColorRes = i10;
    }

    public final void setBackgroundNavigationBarColorRes(int i10) {
        this.backgroundNavigationBarColorRes = i10;
    }

    public final void setColorBackground(boolean z10) {
        this.isColorBackground = z10;
    }

    public final void setCustomBackgroundColor(@k Context r22, @ColorRes int color) {
        Intrinsics.checkNotNullParameter(r22, "context");
        if (color != this.backgroundColorRes) {
            this.backgroundColorRes = color;
            this.popupBackgroundColorRes = color;
            refreshCustomThemeBackgroundInfo(ContextCompat.getColor(r22, color));
            refreshCustomThemeTextInfo(getTextColorPrimary());
        }
    }

    public final void setCustomBackgroundImage(@l String r12) {
        if (r12 == null) {
            r12 = "";
        }
        setBackgroundImagePath(r12);
        this.isColorBackground = false;
    }

    public final void setCustomTextColor(@k Context r22, @ColorRes int color) {
        Intrinsics.checkNotNullParameter(r22, "context");
        if (color != this.textColorPrimaryColorRes) {
            this.textColorPrimaryColorRes = color;
            this.textColorSecondaryColorRes = color;
            this.textColorThirdlyColorRes = color;
            this.selectBackgroundColorRes = color;
            refreshCustomThemeTextInfo(ContextCompat.getColor(r22, color));
        }
    }

    public final void setDarkTheme(boolean z10) {
        this.isDarkTheme = z10;
    }

    public final void setHighLightSelectBackground(int i10) {
        this.highLightSelectBackground.setValue(this, $$delegatedProperties[10], i10);
    }

    public final void setItemColorPrimary(int i10) {
        this.itemColorPrimary.setValue(this, $$delegatedProperties[0], i10);
    }

    public final void setItemColorPrimaryColorRes(int i10) {
        this.itemColorPrimaryColorRes = i10;
    }

    public final void setItemColorPrimaryLight(int i10) {
        this.itemColorPrimaryLight.setValue(this, $$delegatedProperties[11], i10);
    }

    public final void setPopupBackgroundColor(int i10) {
        this.popupBackgroundColor.setValue(this, $$delegatedProperties[5], i10);
    }

    public final void setPopupBackgroundColorRes(int i10) {
        this.popupBackgroundColorRes = i10;
    }

    public final void setSelectBackgroundColorRes(int i10) {
        this.selectBackgroundColorRes = i10;
    }

    public final void setTextColorPrimary(int i10) {
        this.textColorPrimary.setValue(this, $$delegatedProperties[1], i10);
    }

    public final void setTextColorPrimaryColorRes(int i10) {
        this.textColorPrimaryColorRes = i10;
    }

    public final void setTextColorSecondary(int i10) {
        this.textColorSecondary.setValue(this, $$delegatedProperties[2], i10);
    }

    public final void setTextColorSecondaryColorRes(int i10) {
        this.textColorSecondaryColorRes = i10;
    }

    public final void setTextColorThirdly(int i10) {
        this.textColorThirdly.setValue(this, $$delegatedProperties[3], i10);
    }

    public final void setTextColorThirdlyAlpha20(int i10) {
        this.textColorThirdlyAlpha20.setValue(this, $$delegatedProperties[13], i10);
    }

    public final void setTextColorThirdlyColorRes(int i10) {
        this.textColorThirdlyColorRes = i10;
    }

    public final void setUnlockByCoins(int i10) {
        this.unlockByCoins = i10;
    }

    public final void setUnlockExpLevel(int i10) {
        this.unlockExpLevel = i10;
    }

    public final void updateTheme(@l MiReadingTheme theme) {
        if (theme != null) {
            setItemColorPrimary(theme.getItemColorPrimary());
            setTextColorPrimary(theme.getTextColorPrimary());
            setTextColorSecondary(theme.getTextColorSecondary());
            setTextColorThirdly(theme.getTextColorThirdly());
            setTextColorThirdlyAlpha10(theme.getTextColorThirdlyAlpha10());
            setTextColorThirdlyAlpha20(theme.getTextColorThirdlyAlpha20());
            setBackgroundColor(theme.getBackgroundColor());
            setPopupBackgroundColor(theme.getPopupBackgroundColor());
            setBackgroundNavigationBarColor(theme.getBackgroundNavigationBarColor());
            setPopupBackgroundNavigationBarColor(theme.getPopupBackgroundNavigationBarColor());
            setBackgroundNavigationBarNightColor(theme.getBackgroundNavigationBarNightColor());
            setPopupBackgroundNavigationBarNightColor(theme.getPopupBackgroundNavigationBarNightColor());
            setHighLightSelectBackground(theme.getHighLightSelectBackground());
            this.isColorBackground = theme.isColorBackground;
            setBackgroundImagePath(theme.getBackgroundImagePath());
            this.isDarkTheme = theme.isDarkTheme;
        }
    }

    public /* synthetic */ MiReadingTheme(int i10, String str, ReaderThemeType readerThemeType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, (i11 & 4) != 0 ? null : readerThemeType);
    }
}
