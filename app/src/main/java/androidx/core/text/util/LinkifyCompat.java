package androidx.core.text.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class LinkifyCompat {

    /* renamed from: a */
    private static final String[] f1971a = new String[0];

    /* renamed from: b */
    private static final Comparator<LinkSpec> f1972b = new Comparator<LinkSpec>() { // from class: androidx.core.text.util.LinkifyCompat.1
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
            int i2;
            int i3;
            int i4 = linkSpec.f1975c;
            int i5 = linkSpec2.f1975c;
            if (i4 < i5) {
                return -1;
            }
            if (i4 <= i5 && (i2 = linkSpec.f1976d) >= (i3 = linkSpec2.f1976d)) {
                return i2 > i3 ? -1 : 0;
            }
            return 1;
        }
    };

    /* renamed from: androidx.core.text.util.LinkifyCompat$1 */
    class AnonymousClass1 implements Comparator<LinkSpec> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
            int i2;
            int i3;
            int i4 = linkSpec.f1975c;
            int i5 = linkSpec2.f1975c;
            if (i4 < i5) {
                return -1;
            }
            if (i4 <= i5 && (i2 = linkSpec.f1976d) >= (i3 = linkSpec2.f1976d)) {
                return i2 > i3 ? -1 : 0;
            }
            return 1;
        }
    }

    private static class LinkSpec {

        /* renamed from: a */
        URLSpan f1973a;

        /* renamed from: b */
        String f1974b;

        /* renamed from: c */
        int f1975c;

        /* renamed from: d */
        int f1976d;

        LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }

    private static void a(@NonNull TextView textView) {
        if ((textView.getMovementMethod() instanceof LinkMovementMethod) || !textView.getLinksClickable()) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static boolean addLinks(@NonNull Spannable spannable, int i2) {
        if (h()) {
            return Linkify.addLinks(spannable, i2);
        }
        if (i2 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i2 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i2 & 1) != 0) {
            d(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i2 & 2) != 0) {
            d(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i2 & 8) != 0) {
            e(arrayList, spannable);
        }
        g(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            if (linkSpec.f1973a == null) {
                b(linkSpec.f1974b, linkSpec.f1975c, linkSpec.f1976d, spannable);
            }
        }
        return true;
    }

    private static void b(String str, int i2, int i3, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i2, i3, 33);
    }

    private static String c(String str) {
        return Build.VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : FindAddress.c(str);
    }

    private static void d(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.f1974b = f(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.f1975c = start;
                linkSpec.f1976d = end;
                arrayList.add(linkSpec);
            }
        }
    }

    private static void e(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int indexOf;
        String obj = spannable.toString();
        int i2 = 0;
        while (true) {
            try {
                String c2 = c(obj);
                if (c2 != null && (indexOf = obj.indexOf(c2)) >= 0) {
                    LinkSpec linkSpec = new LinkSpec();
                    int length = c2.length() + indexOf;
                    linkSpec.f1975c = indexOf + i2;
                    i2 += length;
                    linkSpec.f1976d = i2;
                    obj = obj.substring(length);
                    try {
                        linkSpec.f1974b = "geo:0,0?q=" + URLEncoder.encode(c2, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static String f(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int i2 = 0;
        while (true) {
            z = true;
            if (i2 >= strArr.length) {
                z = false;
                break;
            }
            if (str.regionMatches(true, 0, strArr[i2], 0, strArr[i2].length())) {
                if (!str.regionMatches(false, 0, strArr[i2], 0, strArr[i2].length())) {
                    str = strArr[i2] + str.substring(strArr[i2].length());
                }
            } else {
                i2++;
            }
        }
        if (z || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void g(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i2;
        int i3 = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i4 = 0; i4 < uRLSpanArr.length; i4++) {
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.f1973a = uRLSpanArr[i4];
            linkSpec.f1975c = spannable.getSpanStart(uRLSpanArr[i4]);
            linkSpec.f1976d = spannable.getSpanEnd(uRLSpanArr[i4]);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, f1972b);
        int size = arrayList.size();
        while (i3 < size - 1) {
            LinkSpec linkSpec2 = arrayList.get(i3);
            int i5 = i3 + 1;
            LinkSpec linkSpec3 = arrayList.get(i5);
            int i6 = linkSpec2.f1975c;
            int i7 = linkSpec3.f1975c;
            if (i6 <= i7 && (i2 = linkSpec2.f1976d) > i7) {
                int i8 = linkSpec3.f1976d;
                int i9 = (i8 > i2 && i2 - i6 <= i8 - i7) ? i2 - i6 < i8 - i7 ? i3 : -1 : i5;
                if (i9 != -1) {
                    Object obj = arrayList.get(i9).f1973a;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i9);
                    size--;
                }
            }
            i3 = i5;
        }
    }

    private static boolean h() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean addLinks(@NonNull TextView textView, int i2) {
        if (h()) {
            return Linkify.addLinks(textView, i2);
        }
        if (i2 == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (!addLinks((Spannable) text, i2)) {
                return false;
            }
            a(textView);
            return true;
        }
        SpannableString valueOf = SpannableString.valueOf(text);
        if (!addLinks(valueOf, i2)) {
            return false;
        }
        a(textView);
        textView.setText(valueOf);
        return true;
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        if (h()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (h()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    @SuppressLint({"NewApi"})
    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (h()) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            a(textView);
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        if (h()) {
            return Linkify.addLinks(spannable, pattern, str);
        }
        return addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (h()) {
            return Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter);
        }
        return addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    @SuppressLint({"NewApi"})
    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (h()) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = f1971a;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i2 = 0;
        while (i2 < strArr.length) {
            String str2 = strArr[i2];
            i2++;
            strArr2[i2] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) {
                b(f(matcher.group(0), strArr2, matcher, transformFilter), start, end, spannable);
                z = true;
            }
        }
        return z;
    }
}
