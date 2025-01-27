package oe;

import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import ba.l;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import l9.o0;

/* loaded from: classes3.dex */
public class f {
    public static Spanned A(int i10, int i11) {
        if (i10 <= 0) {
            if (i11 <= 0) {
                return Html.fromHtml("");
            }
            return Html.fromHtml("<font><big><big>+" + i11 + "</big></big></font>金币");
        }
        if (i11 <= 0) {
            return Html.fromHtml("<font><big><big>+" + n(Integer.valueOf(i10)) + "</big></big></font>元");
        }
        return Html.fromHtml("<font><big><big>" + n(Integer.valueOf(i10)) + "</big></big></font>元 + <font color='red'><big><big>" + i11 + "</big></big></font>金币");
    }

    public static Spanned B(String str, int i10) {
        if (i10 < 60) {
            return Html.fromHtml("<font color='red'><big><big>" + str + "</big></big></font>元 + <font color='red'><big><big>" + i10 + "</big></big></font>秒");
        }
        return Html.fromHtml("<font color='red'><big><big>" + str + "</big></big></font>元 + <font color='red'><big><big>" + k(i10) + "</big></big></font>分钟");
    }

    public static Spanned C(String str, String str2) {
        return Html.fromHtml("<font <big><big><big><big><big>" + str + "</big></big></big></big></big></font>" + str2);
    }

    public static Spanned D(int i10, int i11, int i12) {
        if (i10 <= 0) {
            if (i11 <= 0) {
                if (i12 <= 0) {
                    return Html.fromHtml("");
                }
                return Html.fromHtml("<font color='red'><big><big><big>" + i12 + "</big></big></big></font> 淘书币");
            }
            if (i12 <= 0) {
                return Html.fromHtml("<font color='red'><big><big><big>" + k(i11) + "</big></big></big></font> 分钟");
            }
            return Html.fromHtml("<font color='red'><big><big><big>" + k(i11) + "</big></big></big></font>分钟 + <font color='red'><big><big><big>" + i12 + "</big></big></big></font>淘书币");
        }
        if (i11 <= 0) {
            if (i12 <= 0) {
                return Html.fromHtml("<font color='red'><big><big><big>" + n(Integer.valueOf(i10)) + "</big></big></big></font> 元");
            }
            return Html.fromHtml("<font color='red'><big><big><big>" + n(Integer.valueOf(i10)) + "</big></big></big></font>元 + <font color='red'><big><big><big>" + i12 + "</big></big></big></font>淘书币");
        }
        if (i12 <= 0) {
            return Html.fromHtml("<font color='red'><big><big><big>" + n(Integer.valueOf(i10)) + "</big></big></big></font>元 + <font color='red'><big><big><big>" + k(i11) + "</big></big></big></font>分钟");
        }
        return Html.fromHtml("<font color='red'><big><big><big>" + n(Integer.valueOf(i10)) + "</big></big></big></font>元 + <font color='red'><big><big>" + k(i11) + "</big></big></big></font>分钟 + <font color='red'><big><big><big>" + i12 + "</big></big></big></font>淘书币");
    }

    public static String E(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "支付宝" : "微信" : "淘书币" : "Q币" : "话费";
    }

    public static boolean F(String str) {
        if (l.q(str) || !str.contains(p1.b.f29697h)) {
            return false;
        }
        String substring = str.substring(str.lastIndexOf(p1.b.f29697h));
        return substring.equalsIgnoreCase(".mp4") || substring.equalsIgnoreCase(".3gp") || substring.equalsIgnoreCase(".AVI") || substring.equalsIgnoreCase(".WMV") || substring.equalsIgnoreCase(".rmvb") || substring.equalsIgnoreCase(".flv");
    }

    public static SpannableString G(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString(str);
        }
        int indexOf = str.indexOf("金");
        if (indexOf == -1) {
            return new SpannableString(str);
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i10, true), 0, indexOf, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i11, true), indexOf, indexOf + 1, 33);
        return spannableString;
    }

    public static SpannableString H(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString(str);
        }
        int indexOf = str.indexOf("元");
        if (indexOf == -1) {
            return new SpannableString(str);
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i10, true), 0, indexOf, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i11, true), indexOf, indexOf + 1, 33);
        return spannableString;
    }

    public static SpannableString I(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString(str);
        }
        int indexOf = str.indexOf("元");
        if (indexOf == -1) {
            return new SpannableString(str);
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i10, true), 0, indexOf, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), 0, indexOf, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i11, true), indexOf, indexOf + 1, 33);
        return spannableString;
    }

    public static SpannableString J(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString(str);
        }
        int indexOf = str.indexOf("元");
        int indexOf2 = str.indexOf("金");
        if (indexOf == -1 || indexOf2 == -1) {
            return new SpannableString(str);
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i10, true), 0, indexOf, 33);
        int i12 = indexOf + 1;
        spannableString.setSpan(new AbsoluteSizeSpan(i11, true), indexOf, i12, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i10, true), i12, indexOf2, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i11, true), indexOf2, indexOf2 + 2, 33);
        return spannableString;
    }

    public static String a(int i10) {
        if (i10 < 60) {
            return i10 + "秒";
        }
        if (i10 < 3600) {
            return (i10 / 60) + "分钟";
        }
        return (i10 / SdkConfigData.DEFAULT_REQUEST_INTERVAL) + "小时";
    }

    public static String b(int i10, int i11) {
        if (i10 > 0 && i11 > 0) {
            return "" + ((Object) B(q(Integer.valueOf(i10)), i11));
        }
        if (i10 > 0) {
            return "+" + ((Object) y(q(Integer.valueOf(i10))));
        }
        if (i11 <= 0) {
            return "";
        }
        return "+" + ((Object) x(i11));
    }

    public static String c() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return String.valueOf(calendar.get(1)) + String.valueOf(calendar.get(2) + 1) + String.valueOf(calendar.get(5));
    }

    public static String d() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return String.valueOf(calendar.get(1)) + String.valueOf(calendar.get(2) + 1) + String.valueOf(calendar.get(5)) + "click";
    }

    public static String e(Long l10) {
        long l11 = o0.l() - l10.longValue();
        if (l11 > 36000000) {
            try {
                return ba.f.i(l10.longValue(), "yyyy/MM/dd HH:mm");
            } catch (Exception e10) {
                e10.printStackTrace();
                return "刚刚";
            }
        }
        long j10 = l11 / 3600000;
        if (j10 != 0) {
            return j10 + "小时前";
        }
        long j11 = l11 / 60000;
        if (j11 == 0) {
            return "刚刚";
        }
        return j11 + "分钟前";
    }

    public static String f(int i10) {
        if (i10 % 10 == 0) {
            return "限时" + (i10 / 10) + "折";
        }
        return "限时" + String.format(Locale.getDefault(), "%.1f", Double.valueOf(i10 / 10.0d)) + "折";
    }

    public static Spanned g(String str, String str2) {
        return Html.fromHtml("<font <big><big><big>" + str + "</big></big></big></font>" + str2);
    }

    public static String h(int i10) {
        if (i10 <= 60) {
            return i10 + "秒";
        }
        if (i10 >= 3600) {
            return String.format(Locale.getDefault(), "%.1f", Double.valueOf(i10 / 3600.0d)) + "小时";
        }
        if (i10 % 60 == 0 || i10 >= 600) {
            return (i10 / 60) + "分钟";
        }
        return String.format(Locale.getDefault(), "%.1f", Double.valueOf(i10 / 60.0d)) + "分钟";
    }

    public static float i(int i10) {
        return (float) (i10 / 60.0d);
    }

    public static String j(int i10) {
        if (i10 <= 60) {
            return i10 + "秒";
        }
        if (i10 < 3600) {
            return ((i10 / 60) + (i10 % 60 == 0 ? 0 : 1)) + "分钟";
        }
        return ((i10 / SdkConfigData.DEFAULT_REQUEST_INTERVAL) + (i10 % 3660 == 0 ? 0 : 1)) + "小时";
    }

    public static String k(int i10) {
        if (i10 % 60 != 0) {
            return String.format(Locale.getDefault(), "%.1f", Double.valueOf(i10 / 60.0d));
        }
        return (i10 / 60) + "";
    }

    public static String l(int i10) {
        if (i10 < 60) {
            return i10 + "秒";
        }
        if (i10 < 3600) {
            return (i10 / 60) + "分钟";
        }
        if (i10 < 86400) {
            return (i10 / SdkConfigData.DEFAULT_REQUEST_INTERVAL) + "小时" + ((i10 % SdkConfigData.DEFAULT_REQUEST_INTERVAL) / 60) + "分钟";
        }
        return (i10 / 86400) + "天" + ((i10 % 86400) / SdkConfigData.DEFAULT_REQUEST_INTERVAL) + "小时" + ((i10 % SdkConfigData.DEFAULT_REQUEST_INTERVAL) / 60) + "分钟";
    }

    public static float m(Integer num) {
        if (num == null) {
            return 0.0f;
        }
        return (float) (num.intValue() / 100.0d);
    }

    public static String n(Integer num) {
        if (num == null) {
            return "0";
        }
        if (num.intValue() % 100 != 0) {
            return String.format(Locale.getDefault(), "%.2f", Double.valueOf(num.intValue() / 100.0d));
        }
        return (num.intValue() / 100) + "";
    }

    public static String o(Integer num) {
        if (num == null) {
            return "0";
        }
        if (num.intValue() % 100 != 0) {
            return String.format(Locale.getDefault(), "%.2f", Double.valueOf(num.intValue() / 100.0d));
        }
        return (num.intValue() / 100) + ".00";
    }

    public static String p(Integer num) {
        if (num == null) {
            return "0";
        }
        if (num.intValue() % 100 != 0) {
            return String.format(Locale.getDefault(), "%.2f", Double.valueOf(num.intValue() / 100.0d));
        }
        int intValue = num.intValue() / 100;
        int i10 = intValue / 1000;
        int i11 = intValue / 10000;
        if (i11 > 0) {
            return i11 + "万";
        }
        if (i10 > 0) {
            return i10 + "千";
        }
        return intValue + "";
    }

    public static String q(Integer num) {
        if (num == null) {
            return "0";
        }
        return String.format(Locale.getDefault(), "%.2f", Double.valueOf(num.intValue() / 100.0d));
    }

    public static String r(int i10) {
        if (i10 <= 10000) {
            return i10 + "";
        }
        return String.format(Locale.getDefault(), "%.2f", Double.valueOf(i10 / 10000.0d)) + "万";
    }

    public static String s(int i10) {
        int i11 = i10 / 1000;
        int i12 = i10 / 10000;
        if (i12 > 0) {
            return i12 + "万";
        }
        if (i11 > 0) {
            return i11 + "千";
        }
        return i10 + "";
    }

    public static String t(Long l10) {
        long l11 = o0.l() - l10.longValue();
        if (l11 <= 36000000) {
            try {
                return ba.f.i(l10.longValue(), "HH:mm");
            } catch (Exception e10) {
                e10.printStackTrace();
                return "刚刚";
            }
        }
        if (l11 <= 72000000) {
            return "昨天";
        }
        if (l11 <= 144000000) {
            return "前天";
        }
        try {
            return ba.f.i(l10.longValue(), "MM/dd");
        } catch (Exception unused) {
            return "刚刚";
        }
    }

    public static Spanned u(int i10) {
        return Html.fromHtml("<font color='red'><big><big>" + i10 + "</big></big></font>淘书币");
    }

    public static Spanned v(String str) {
        return Html.fromHtml("<font color='red'><big><big>" + str + "</big></big></font>金币");
    }

    public static Spanned w(int i10, int i11, int i12) {
        if (i10 <= 0) {
            if (i11 <= 0) {
                if (i12 <= 0) {
                    return Html.fromHtml("");
                }
                return Html.fromHtml("<font color='red'><big><big><big><big><big>" + i12 + "</big></big></big></big></big></font>淘书币");
            }
            if (i12 <= 0) {
                return Html.fromHtml("<font color='red'><big><big><big><big><big>" + i11 + "</big></big></big></big></big></font>金币");
            }
            return Html.fromHtml("<font color='red'><big><big><big><big><big>" + i11 + "</big></big></big></big></big></font>金币 + <font color='red'><big><big><big><big><big>" + i12 + "</big></big></big></big></big></font>淘书币");
        }
        if (i11 <= 0) {
            if (i12 <= 0) {
                return Html.fromHtml("<font color='red'><big><big><big><big><big>" + n(Integer.valueOf(i10)) + "</big></big></big></big></big></font>元");
            }
            return Html.fromHtml("<font color='red'><big><big><big><big><big>" + n(Integer.valueOf(i10)) + "</big></big></big></big></big></font>元 + <font color='red'><big><big><big><big><big>" + i12 + "</big></big></big></big></big></font>淘书币");
        }
        if (i12 <= 0) {
            return Html.fromHtml("<font color='red'><big><big><big><big><big>" + n(Integer.valueOf(i10)) + "</big></big></big></big></big></font>元 + <font color='red'><big><big><big><big><big>" + i11 + "</big></big></big></big></big></font>金币");
        }
        return Html.fromHtml("<font color='red'><big><big><big><big><big>" + n(Integer.valueOf(i10)) + "</big></big></big></big></big></font>元 + <font color='red'><big><big><big><big><big>" + i11 + "</big></big></big></big></big></font>金币 + <font color='red'><big><big><big><big><big>" + i12 + "</big></big></big></big></big></font>淘书币");
    }

    public static Spanned x(int i10) {
        if (i10 < 60) {
            return Html.fromHtml("<font color='red'><big><big>" + i10 + "</big></big></font>秒");
        }
        return Html.fromHtml("<font color='red'><big><big>" + k(i10) + "</big></big></font>分钟");
    }

    public static Spanned y(String str) {
        return Html.fromHtml("<font color='red'><big><big>" + str + "</big></big></font>元");
    }

    public static Spanned z(int i10, int i11) {
        if (i10 <= 0) {
            if (i11 <= 0) {
                return Html.fromHtml("");
            }
            return Html.fromHtml("<font color='red'><big><big>+" + i11 + "</big></big></font>金币");
        }
        if (i11 <= 0) {
            return Html.fromHtml("<font color='red'><big><big>+" + n(Integer.valueOf(i10)) + "</big></big></font>元");
        }
        return Html.fromHtml("<font color='red'><big><big>" + n(Integer.valueOf(i10)) + "</big></big></font>元 + <font color='red'><big><big>" + i11 + "</big></big></font>金币");
    }
}
