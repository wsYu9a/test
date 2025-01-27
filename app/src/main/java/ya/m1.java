package ya;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiTheme;

/* loaded from: classes3.dex */
public class m1 {

    /* renamed from: a */
    public final MiTheme f33309a = new MiTheme().setNormalTheme(R.style.MibookTheme_Night).setBackableTheme(R.style.MibookTheme_Backable_Night).setFullScreenTheme(R.style.MibookTheme_NoActionBar_FullScreen_Night).setNoActionBarTheme(R.style.MibookTheme_NoActionBar_Night).setTranslucentTheme(R.style.MibookTheme_Transparent_Night).setAlertDialogTheme(R.style.MibookTheme_Dialog_Alert_Night).setColorPrimary(com.martian.libmars.R.color.night_background).setThemeName("夜间模式").setSelectableBackground(com.martian.libmars.R.drawable.theme_black_selectable_background).setDotBackground(R.drawable.border_mark_dot_night);

    /* renamed from: b */
    public final MiTheme f33310b = new MiTheme().setNormalTheme(R.style.MibookTheme_Default).setBackableTheme(R.style.MibookTheme_Backable_Default).setFullScreenTheme(R.style.MibookTheme_NoActionBar_FullScreen_Default).setNoActionBarTheme(R.style.MibookTheme_NoActionBar_Default).setTranslucentTheme(R.style.MibookTheme_Transparent_Default).setAlertDialogTheme(R.style.MibookTheme_Dialog_Alert_Default).setColorPrimary(com.martian.libmars.R.color.theme_default).setThemeName("默认").setSelectableBackground(com.martian.libmars.R.drawable.theme_default_selectable_background).setDotBackground(R.drawable.border_mark_dot_default);

    public static int a() {
        return MiConfigSingleton.b2().A0() ? com.martian.libmars.R.color.night_background : com.martian.libmars.R.color.white;
    }

    public static int c(Context context) {
        return MiConfigSingleton.b2().A0() ? ContextCompat.getColor(context, com.martian.libmars.R.color.night_text_color_primary) : ContextCompat.getColor(context, com.martian.libmars.R.color.day_text_color_primary);
    }

    public static int d(Context context) {
        return MiConfigSingleton.b2().A0() ? ContextCompat.getColor(context, com.martian.libmars.R.color.night_text_color_secondary) : ContextCompat.getColor(context, com.martian.libmars.R.color.day_text_color_secondary);
    }

    public int b() {
        return e().colorPrimary;
    }

    public MiTheme e() {
        return MiConfigSingleton.b2().A0() ? this.f33309a : this.f33310b;
    }
}
