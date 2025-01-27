package com.martian.mibook.application;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.martian.mibook.lib.model.data.MiTheme;
import com.martian.ttbookhd.R;

/* loaded from: classes.dex */
public class t0 {

    /* renamed from: a */
    public final MiTheme f11590a = new MiTheme().setNormalTheme(2131820833).setBackableTheme(2131820824).setFullScreenTheme(2131820838).setNoActionBarTheme(2131820839).setAlertDialogTheme(2131820829).setColorPrimary(R.color.night_background).setThemeName("夜间模式").setSelectableBackground(R.drawable.theme_black_selectable_background).setDotBackground(R.drawable.border_mark_dot_night);

    /* renamed from: b */
    public final MiTheme f11591b = new MiTheme().setNormalTheme(2131820825).setBackableTheme(2131820823).setFullScreenTheme(2131820837).setNoActionBarTheme(2131820835).setAlertDialogTheme(2131820828).setColorPrimary(R.color.theme_default).setThemeName("默认").setSelectableBackground(R.drawable.theme_default_selectable_background).setDotBackground(R.drawable.border_mark_dot_default);

    t0() {
    }

    public static int a() {
        return MiConfigSingleton.V3().I0() ? R.color.night_background : R.color.white;
    }

    public static int c(Context context) {
        return MiConfigSingleton.V3().I0() ? ContextCompat.getColor(context, R.color.night_text_color_primary) : ContextCompat.getColor(context, R.color.day_text_color_primary);
    }

    public static int d(Context context) {
        return MiConfigSingleton.V3().I0() ? ContextCompat.getColor(context, R.color.night_text_color_secondary) : ContextCompat.getColor(context, R.color.day_text_color_secondary);
    }

    public int b() {
        return e().colorPrimary;
    }

    public MiTheme e() {
        return MiConfigSingleton.V3().I0() ? this.f11590a : this.f11591b;
    }
}
