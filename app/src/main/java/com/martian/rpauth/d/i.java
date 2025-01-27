package com.martian.rpauth.d;

import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.martian.libsupport.k;
import com.martian.rpauth.MartianRPUserManager;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes4.dex */
public class i {
    public static Spanned A(String money, int duration) {
        if (duration < 60) {
            return Html.fromHtml("<font color='red'><big><big>" + money + "</big></big></font>元 + <font color='red'><big><big>" + duration + "</big></big></font>秒");
        }
        return Html.fromHtml("<font color='red'><big><big>" + money + "</big></big></font>元 + <font color='red'><big><big>" + j(duration) + "</big></big></font>分钟");
    }

    public static Spanned B(String number, String unit) {
        return Html.fromHtml("<font <big><big><big><big><big>" + number + "</big></big></big></big></big></font>" + unit);
    }

    public static Spanned C(int money, int duration, int bookCoins) {
        if (money <= 0) {
            if (duration <= 0) {
                if (bookCoins <= 0) {
                    return Html.fromHtml("");
                }
                return Html.fromHtml("<font color='red'><big><big><big>" + bookCoins + "</big></big></big></font> 淘书币");
            }
            if (bookCoins <= 0) {
                return Html.fromHtml("<font color='red'><big><big><big>" + j(duration) + "</big></big></big></font> 分钟");
            }
            return Html.fromHtml("<font color='red'><big><big><big>" + j(duration) + "</big></big></big></font>分钟 + <font color='red'><big><big><big>" + bookCoins + "</big></big></big></font>淘书币");
        }
        if (duration <= 0) {
            if (bookCoins <= 0) {
                return Html.fromHtml("<font color='red'><big><big><big>" + m(Integer.valueOf(money)) + "</big></big></big></font> 元");
            }
            return Html.fromHtml("<font color='red'><big><big><big>" + m(Integer.valueOf(money)) + "</big></big></big></font>元 + <font color='red'><big><big><big>" + bookCoins + "</big></big></big></font>淘书币");
        }
        if (bookCoins <= 0) {
            return Html.fromHtml("<font color='red'><big><big><big>" + m(Integer.valueOf(money)) + "</big></big></big></font>元 + <font color='red'><big><big><big>" + j(duration) + "</big></big></big></font>分钟");
        }
        return Html.fromHtml("<font color='red'><big><big><big>" + m(Integer.valueOf(money)) + "</big></big></big></font>元 + <font color='red'><big><big>" + j(duration) + "</big></big></big></font>分钟 + <font color='red'><big><big><big>" + bookCoins + "</big></big></big></font>淘书币");
    }

    public static String D(int paymentType) {
        return paymentType != 1 ? paymentType != 2 ? paymentType != 3 ? paymentType != 4 ? "支付宝" : "微信" : "淘书币" : "Q币" : "话费";
    }

    public static boolean E(long deadline) {
        return MartianRPUserManager.t() > deadline;
    }

    public static boolean F(String url) {
        if (k.p(url) || !url.contains(".")) {
            return false;
        }
        String substring = url.substring(url.lastIndexOf("."));
        return substring.equalsIgnoreCase(".mp4") || substring.equalsIgnoreCase(".3gp") || substring.equalsIgnoreCase(".AVI") || substring.equalsIgnoreCase(".WMV") || substring.equalsIgnoreCase(".rmvb") || substring.equalsIgnoreCase(".flv");
    }

    public static SpannableString G(String text, int numSize, int wordSize) {
        if (TextUtils.isEmpty(text)) {
            return new SpannableString(text);
        }
        int indexOf = text.indexOf("金");
        if (indexOf == -1) {
            return new SpannableString(text);
        }
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new AbsoluteSizeSpan(numSize, true), 0, indexOf, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(wordSize, true), indexOf, indexOf + 1, 33);
        return spannableString;
    }

    public static SpannableString H(String text, int numSize, int wordSize) {
        if (TextUtils.isEmpty(text)) {
            return new SpannableString(text);
        }
        int indexOf = text.indexOf("元");
        if (indexOf == -1) {
            return new SpannableString(text);
        }
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new AbsoluteSizeSpan(numSize, true), 0, indexOf, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(wordSize, true), indexOf, indexOf + 1, 33);
        return spannableString;
    }

    public static SpannableString I(String text, int numSize, int wordSize) {
        if (TextUtils.isEmpty(text)) {
            return new SpannableString(text);
        }
        int indexOf = text.indexOf("元");
        if (indexOf == -1) {
            return new SpannableString(text);
        }
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new AbsoluteSizeSpan(numSize, true), 0, indexOf, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), 0, indexOf, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(wordSize, true), indexOf, indexOf + 1, 33);
        return spannableString;
    }

    public static SpannableString J(String text, int numSize, int wordSize) {
        if (TextUtils.isEmpty(text)) {
            return new SpannableString(text);
        }
        int indexOf = text.indexOf("元");
        int indexOf2 = text.indexOf("金");
        if (indexOf == -1 || indexOf2 == -1) {
            return new SpannableString(text);
        }
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new AbsoluteSizeSpan(numSize, true), 0, indexOf, 33);
        int i2 = indexOf + 1;
        spannableString.setSpan(new AbsoluteSizeSpan(wordSize, true), indexOf, i2, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(numSize, true), i2, indexOf2, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(wordSize, true), indexOf2, indexOf2 + 2, 33);
        return spannableString;
    }

    public static String a(int money, int duration) {
        if (money > 0 && duration > 0) {
            return "" + ((Object) A(p(Integer.valueOf(money)), duration));
        }
        if (money > 0) {
            return "+" + ((Object) x(p(Integer.valueOf(money))));
        }
        if (duration <= 0) {
            return "";
        }
        return "+" + ((Object) w(duration));
    }

    public static String b() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return String.valueOf(calendar.get(1)) + String.valueOf(calendar.get(2) + 1) + String.valueOf(calendar.get(5));
    }

    public static String c() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return String.valueOf(calendar.get(1)) + String.valueOf(calendar.get(2) + 1) + String.valueOf(calendar.get(5)) + "click";
    }

    public static String d(Long time) {
        long t = MartianRPUserManager.t() - time.longValue();
        if (t > 36000000) {
            try {
                return com.martian.libsupport.d.i(time.longValue(), "yyyy/MM/dd HH:mm");
            } catch (Exception unused) {
                return "刚刚";
            }
        }
        long j2 = t / 3600000;
        if (j2 != 0) {
            return j2 + "小时前";
        }
        long j3 = t / 60000;
        if (j3 == 0) {
            return "刚刚";
        }
        return j3 + "分钟前";
    }

    public static String e(int discount) {
        if (discount % 10 == 0) {
            return "限时" + (discount / 10) + "折";
        }
        double d2 = discount;
        Double.isNaN(d2);
        return "限时" + String.format(Locale.getDefault(), "%.1f", Double.valueOf(d2 / 10.0d)) + "折";
    }

    public static Spanned f(String number, String unit) {
        return Html.fromHtml("<font <big><big><big>" + number + "</big></big></big></font>" + unit);
    }

    public static String g(int duration) {
        if (duration <= 60) {
            return duration + "秒";
        }
        if (duration >= 3600) {
            double d2 = duration;
            Double.isNaN(d2);
            return String.format(Locale.getDefault(), "%.1f", Double.valueOf(d2 / 3600.0d)) + "小时";
        }
        if (duration % 60 == 0 || duration >= 600) {
            return (duration / 60) + "分钟";
        }
        double d3 = duration;
        Double.isNaN(d3);
        return String.format(Locale.getDefault(), "%.1f", Double.valueOf(d3 / 60.0d)) + "分钟";
    }

    public static float h(int duration) {
        double d2 = duration;
        Double.isNaN(d2);
        return (float) (d2 / 60.0d);
    }

    public static String i(int duration) {
        if (duration <= 60) {
            return duration + "秒";
        }
        if (duration < 3600) {
            return ((duration / 60) + (duration % 60 != 0 ? 1 : 0)) + "分钟";
        }
        return ((duration / SdkConfigData.DEFAULT_REQUEST_INTERVAL) + (duration % 3660 != 0 ? 1 : 0)) + "小时";
    }

    public static String j(int duration) {
        if (duration % 60 != 0) {
            double d2 = duration;
            Double.isNaN(d2);
            return String.format(Locale.getDefault(), "%.1f", Double.valueOf(d2 / 60.0d));
        }
        return (duration / 60) + "";
    }

    public static String k(int duration) {
        if (duration < 60) {
            return duration + "秒";
        }
        if (duration < 3600) {
            return (duration / 60) + "分钟";
        }
        if (duration < 86400) {
            return (duration / SdkConfigData.DEFAULT_REQUEST_INTERVAL) + "小时" + ((duration % SdkConfigData.DEFAULT_REQUEST_INTERVAL) / 60) + "分钟";
        }
        return (duration / 86400) + "天" + ((duration % 86400) / SdkConfigData.DEFAULT_REQUEST_INTERVAL) + "小时" + ((duration % SdkConfigData.DEFAULT_REQUEST_INTERVAL) / 60) + "分钟";
    }

    public static float l(Integer money) {
        if (money == null) {
            return 0.0f;
        }
        double intValue = money.intValue();
        Double.isNaN(intValue);
        return (float) (intValue / 100.0d);
    }

    public static String m(Integer money) {
        if (money == null) {
            return "0";
        }
        if (money.intValue() % 100 != 0) {
            double intValue = money.intValue();
            Double.isNaN(intValue);
            return String.format(Locale.getDefault(), "%.2f", Double.valueOf(intValue / 100.0d));
        }
        return (money.intValue() / 100) + "";
    }

    public static String n(Integer money) {
        if (money == null) {
            return "0";
        }
        if (money.intValue() % 100 != 0) {
            double intValue = money.intValue();
            Double.isNaN(intValue);
            return String.format(Locale.getDefault(), "%.2f", Double.valueOf(intValue / 100.0d));
        }
        return (money.intValue() / 100) + ".00";
    }

    public static String o(Integer money) {
        if (money == null) {
            return "0";
        }
        if (money.intValue() % 100 != 0) {
            double intValue = money.intValue();
            Double.isNaN(intValue);
            return String.format(Locale.getDefault(), "%.2f", Double.valueOf(intValue / 100.0d));
        }
        int intValue2 = money.intValue() / 100;
        int i2 = intValue2 / 1000;
        int i3 = intValue2 / 10000;
        if (i3 > 0) {
            return i3 + "万";
        }
        if (i2 > 0) {
            return i2 + "千";
        }
        return intValue2 + "";
    }

    public static String p(Integer money) {
        if (money == null) {
            return "0";
        }
        double intValue = money.intValue();
        Double.isNaN(intValue);
        return String.format(Locale.getDefault(), "%.2f", Double.valueOf(intValue / 100.0d));
    }

    public static String q(int num) {
        if (num <= 10000) {
            return num + "";
        }
        double d2 = num;
        Double.isNaN(d2);
        return String.format(Locale.getDefault(), "%.2f", Double.valueOf(d2 / 10000.0d)) + "万";
    }

    public static String r(int number) {
        int i2 = number / 1000;
        int i3 = number / 10000;
        if (i3 > 0) {
            return i3 + "万";
        }
        if (i2 > 0) {
            return i2 + "千";
        }
        return number + "";
    }

    public static String s(Long time) {
        long t = MartianRPUserManager.t() - time.longValue();
        try {
            return t <= 36000000 ? com.martian.libsupport.d.i(time.longValue(), "HH:mm") : t <= 72000000 ? "昨天" : t <= 144000000 ? "前天" : com.martian.libsupport.d.i(time.longValue(), "MM/dd");
        } catch (Exception unused) {
            return "刚刚";
        }
    }

    public static Spanned t(int coins) {
        return Html.fromHtml("<font color='red'><big><big>" + coins + "</big></big></font>淘书币");
    }

    public static Spanned u(String coins) {
        return Html.fromHtml("<font color='red'><big><big>" + coins + "</big></big></font>金币");
    }

    public static Spanned v(int money, int coins, int bookCoins) {
        if (money <= 0) {
            if (coins <= 0) {
                if (bookCoins <= 0) {
                    return Html.fromHtml("");
                }
                return Html.fromHtml("<font color='red'><big><big><big><big><big>" + bookCoins + "</big></big></big></big></big></font>淘书币");
            }
            if (bookCoins <= 0) {
                return Html.fromHtml("<font color='red'><big><big><big><big><big>" + coins + "</big></big></big></big></big></font>金币");
            }
            return Html.fromHtml("<font color='red'><big><big><big><big><big>" + coins + "</big></big></big></big></big></font>金币 + <font color='red'><big><big><big><big><big>" + bookCoins + "</big></big></big></big></big></font>淘书币");
        }
        if (coins <= 0) {
            if (bookCoins <= 0) {
                return Html.fromHtml("<font color='red'><big><big><big><big><big>" + m(Integer.valueOf(money)) + "</big></big></big></big></big></font>元");
            }
            return Html.fromHtml("<font color='red'><big><big><big><big><big>" + m(Integer.valueOf(money)) + "</big></big></big></big></big></font>元 + <font color='red'><big><big><big><big><big>" + bookCoins + "</big></big></big></big></big></font>淘书币");
        }
        if (bookCoins <= 0) {
            return Html.fromHtml("<font color='red'><big><big><big><big><big>" + m(Integer.valueOf(money)) + "</big></big></big></big></big></font>元 + <font color='red'><big><big><big><big><big>" + coins + "</big></big></big></big></big></font>金币");
        }
        return Html.fromHtml("<font color='red'><big><big><big><big><big>" + m(Integer.valueOf(money)) + "</big></big></big></big></big></font>元 + <font color='red'><big><big><big><big><big>" + coins + "</big></big></big></big></big></font>金币 + <font color='red'><big><big><big><big><big>" + bookCoins + "</big></big></big></big></big></font>淘书币");
    }

    public static Spanned w(int duration) {
        if (duration < 60) {
            return Html.fromHtml("<font color='red'><big><big>" + duration + "</big></big></font>秒");
        }
        return Html.fromHtml("<font color='red'><big><big>" + j(duration) + "</big></big></font>分钟");
    }

    public static Spanned x(String money) {
        return Html.fromHtml("<font color='red'><big><big>" + money + "</big></big></font>元");
    }

    public static Spanned y(int money, int coins) {
        if (money <= 0) {
            if (coins <= 0) {
                return Html.fromHtml("");
            }
            return Html.fromHtml("<font color='red'><big><big>+" + coins + "</big></big></font>金币");
        }
        if (coins <= 0) {
            return Html.fromHtml("<font color='red'><big><big>+" + m(Integer.valueOf(money)) + "</big></big></font>元");
        }
        return Html.fromHtml("<font color='red'><big><big>" + m(Integer.valueOf(money)) + "</big></big></font>元 + <font color='red'><big><big>" + coins + "</big></big></font>金币");
    }

    public static Spanned z(int money, int coins) {
        if (money <= 0) {
            if (coins <= 0) {
                return Html.fromHtml("");
            }
            return Html.fromHtml("<font><big><big>+" + coins + "</big></big></font>金币");
        }
        if (coins <= 0) {
            return Html.fromHtml("<font><big><big>+" + m(Integer.valueOf(money)) + "</big></big></font>元");
        }
        return Html.fromHtml("<font><big><big>" + m(Integer.valueOf(money)) + "</big></big></font>元 + <font color='red'><big><big>" + coins + "</big></big></font>金币");
    }
}
