package org.threeten.bp.format;

import com.sigmob.sdk.archives.d;
import ij.f;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;

/* loaded from: classes4.dex */
public final class c extends org.threeten.bp.format.b {

    /* renamed from: c */
    public static final Comparator<Map.Entry<String, Long>> f29612c = new a();

    /* renamed from: b */
    public final ConcurrentMap<Map.Entry<f, Locale>, Object> f29613b = new ConcurrentHashMap(16, 0.75f, 2);

    public class a implements Comparator<Map.Entry<String, Long>> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            return entry2.getKey().length() - entry.getKey().length();
        }
    }

    public static final class b {

        /* renamed from: a */
        public final Map<TextStyle, Map<Long, String>> f29614a;

        /* renamed from: b */
        public final Map<TextStyle, List<Map.Entry<String, Long>>> f29615b;

        public b(Map<TextStyle, Map<Long, String>> map) {
            this.f29614a = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (TextStyle textStyle : map.keySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry<Long, String> entry : map.get(textStyle).entrySet()) {
                    hashMap2.put(entry.getValue(), c.h(entry.getValue(), entry.getKey()));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort(arrayList2, c.f29612c);
                hashMap.put(textStyle, arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put(null, arrayList);
            }
            Collections.sort(arrayList, c.f29612c);
            this.f29615b = hashMap;
        }

        public String a(long j10, TextStyle textStyle) {
            Map<Long, String> map = this.f29614a.get(textStyle);
            if (map != null) {
                return map.get(Long.valueOf(j10));
            }
            return null;
        }

        public Iterator<Map.Entry<String, Long>> b(TextStyle textStyle) {
            List<Map.Entry<String, Long>> list = this.f29615b.get(textStyle);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
    }

    public static <A, B> Map.Entry<A, B> h(A a10, B b10) {
        return new AbstractMap.SimpleImmutableEntry(a10, b10);
    }

    public static b i(Map<TextStyle, Map<Long, String>> map) {
        map.put(TextStyle.FULL_STANDALONE, map.get(TextStyle.FULL));
        map.put(TextStyle.SHORT_STANDALONE, map.get(TextStyle.SHORT));
        TextStyle textStyle = TextStyle.NARROW;
        if (map.containsKey(textStyle)) {
            TextStyle textStyle2 = TextStyle.NARROW_STANDALONE;
            if (!map.containsKey(textStyle2)) {
                map.put(textStyle2, map.get(textStyle));
            }
        }
        return new b(map);
    }

    @Override // org.threeten.bp.format.b
    public String c(f fVar, long j10, TextStyle textStyle, Locale locale) {
        Object k10 = k(fVar, locale);
        if (k10 instanceof b) {
            return ((b) k10).a(j10, textStyle);
        }
        return null;
    }

    @Override // org.threeten.bp.format.b
    public Iterator<Map.Entry<String, Long>> d(f fVar, TextStyle textStyle, Locale locale) {
        Object k10 = k(fVar, locale);
        if (k10 instanceof b) {
            return ((b) k10).b(textStyle);
        }
        return null;
    }

    public final Object j(f fVar, Locale locale) {
        if (fVar == ChronoField.MONTH_OF_YEAR) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            HashMap hashMap = new HashMap();
            String[] months = dateFormatSymbols.getMonths();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(1L, months[0]);
            hashMap2.put(2L, months[1]);
            hashMap2.put(3L, months[2]);
            hashMap2.put(4L, months[3]);
            hashMap2.put(5L, months[4]);
            hashMap2.put(6L, months[5]);
            hashMap2.put(7L, months[6]);
            hashMap2.put(8L, months[7]);
            hashMap2.put(9L, months[8]);
            hashMap2.put(10L, months[9]);
            hashMap2.put(11L, months[10]);
            hashMap2.put(12L, months[11]);
            hashMap.put(TextStyle.FULL, hashMap2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(1L, m(1, months[0], locale));
            hashMap3.put(2L, m(2, months[1], locale));
            hashMap3.put(3L, m(3, months[2], locale));
            hashMap3.put(4L, m(4, months[3], locale));
            hashMap3.put(5L, m(5, months[4], locale));
            hashMap3.put(6L, m(6, months[5], locale));
            hashMap3.put(7L, m(7, months[6], locale));
            hashMap3.put(8L, m(8, months[7], locale));
            hashMap3.put(9L, m(9, months[8], locale));
            hashMap3.put(10L, m(10, months[9], locale));
            hashMap3.put(11L, m(11, months[10], locale));
            hashMap3.put(12L, m(12, months[11], locale));
            hashMap.put(TextStyle.NARROW, hashMap3);
            String[] shortMonths = dateFormatSymbols.getShortMonths();
            HashMap hashMap4 = new HashMap();
            hashMap4.put(1L, shortMonths[0]);
            hashMap4.put(2L, shortMonths[1]);
            hashMap4.put(3L, shortMonths[2]);
            hashMap4.put(4L, shortMonths[3]);
            hashMap4.put(5L, shortMonths[4]);
            hashMap4.put(6L, shortMonths[5]);
            hashMap4.put(7L, shortMonths[6]);
            hashMap4.put(8L, shortMonths[7]);
            hashMap4.put(9L, shortMonths[8]);
            hashMap4.put(10L, shortMonths[9]);
            hashMap4.put(11L, shortMonths[10]);
            hashMap4.put(12L, shortMonths[11]);
            hashMap.put(TextStyle.SHORT, hashMap4);
            return i(hashMap);
        }
        if (fVar == ChronoField.DAY_OF_WEEK) {
            DateFormatSymbols dateFormatSymbols2 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap5 = new HashMap();
            String[] weekdays = dateFormatSymbols2.getWeekdays();
            HashMap hashMap6 = new HashMap();
            hashMap6.put(1L, weekdays[2]);
            hashMap6.put(2L, weekdays[3]);
            hashMap6.put(3L, weekdays[4]);
            hashMap6.put(4L, weekdays[5]);
            hashMap6.put(5L, weekdays[6]);
            hashMap6.put(6L, weekdays[7]);
            hashMap6.put(7L, weekdays[1]);
            hashMap5.put(TextStyle.FULL, hashMap6);
            HashMap hashMap7 = new HashMap();
            hashMap7.put(1L, l(1, weekdays[2], locale));
            hashMap7.put(2L, l(2, weekdays[3], locale));
            hashMap7.put(3L, l(3, weekdays[4], locale));
            hashMap7.put(4L, l(4, weekdays[5], locale));
            hashMap7.put(5L, l(5, weekdays[6], locale));
            hashMap7.put(6L, l(6, weekdays[7], locale));
            hashMap7.put(7L, l(7, weekdays[1], locale));
            hashMap5.put(TextStyle.NARROW, hashMap7);
            String[] shortWeekdays = dateFormatSymbols2.getShortWeekdays();
            HashMap hashMap8 = new HashMap();
            hashMap8.put(1L, shortWeekdays[2]);
            hashMap8.put(2L, shortWeekdays[3]);
            hashMap8.put(3L, shortWeekdays[4]);
            hashMap8.put(4L, shortWeekdays[5]);
            hashMap8.put(5L, shortWeekdays[6]);
            hashMap8.put(6L, shortWeekdays[7]);
            hashMap8.put(7L, shortWeekdays[1]);
            hashMap5.put(TextStyle.SHORT, hashMap8);
            return i(hashMap5);
        }
        if (fVar == ChronoField.AMPM_OF_DAY) {
            DateFormatSymbols dateFormatSymbols3 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap9 = new HashMap();
            String[] amPmStrings = dateFormatSymbols3.getAmPmStrings();
            HashMap hashMap10 = new HashMap();
            hashMap10.put(0L, amPmStrings[0]);
            hashMap10.put(1L, amPmStrings[1]);
            hashMap9.put(TextStyle.FULL, hashMap10);
            hashMap9.put(TextStyle.SHORT, hashMap10);
            return i(hashMap9);
        }
        if (fVar != ChronoField.ERA) {
            if (fVar != IsoFields.f29617b) {
                return "";
            }
            HashMap hashMap11 = new HashMap();
            HashMap hashMap12 = new HashMap();
            hashMap12.put(1L, "Q1");
            hashMap12.put(2L, "Q2");
            hashMap12.put(3L, "Q3");
            hashMap12.put(4L, "Q4");
            hashMap11.put(TextStyle.SHORT, hashMap12);
            HashMap hashMap13 = new HashMap();
            hashMap13.put(1L, "1st quarter");
            hashMap13.put(2L, "2nd quarter");
            hashMap13.put(3L, "3rd quarter");
            hashMap13.put(4L, "4th quarter");
            hashMap11.put(TextStyle.FULL, hashMap13);
            return i(hashMap11);
        }
        DateFormatSymbols dateFormatSymbols4 = DateFormatSymbols.getInstance(locale);
        HashMap hashMap14 = new HashMap();
        String[] eras = dateFormatSymbols4.getEras();
        HashMap hashMap15 = new HashMap();
        hashMap15.put(0L, eras[0]);
        hashMap15.put(1L, eras[1]);
        hashMap14.put(TextStyle.SHORT, hashMap15);
        if (locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
            HashMap hashMap16 = new HashMap();
            hashMap16.put(0L, "Before Christ");
            hashMap16.put(1L, "Anno Domini");
            hashMap14.put(TextStyle.FULL, hashMap16);
        } else {
            hashMap14.put(TextStyle.FULL, hashMap15);
        }
        HashMap hashMap17 = new HashMap();
        hashMap17.put(0L, eras[0].substring(0, 1));
        hashMap17.put(1L, eras[1].substring(0, 1));
        hashMap14.put(TextStyle.NARROW, hashMap17);
        return i(hashMap14);
    }

    public final Object k(f fVar, Locale locale) {
        Map.Entry<f, Locale> h10 = h(fVar, locale);
        Object obj = this.f29613b.get(h10);
        if (obj != null) {
            return obj;
        }
        this.f29613b.putIfAbsent(h10, j(fVar, locale));
        return this.f29613b.get(h10);
    }

    public final String l(int i10, String str, Locale locale) {
        if (locale.getLanguage().equals("zh") && locale.getCountry().equals("CN")) {
            switch (i10) {
                case 1:
                    return "一";
                case 2:
                    return "二";
                case 3:
                    return "三";
                case 4:
                    return "四";
                case 5:
                    return "五";
                case 6:
                    return "六";
                case 7:
                    return "日";
            }
        }
        if (locale.getLanguage().equals(d.f17511a)) {
            switch (i10) {
                case 1:
                    return "ن";
                case 2:
                    return "ث";
                case 3:
                    return "ر";
                case 4:
                    return "خ";
                case 5:
                    return "ج";
                case 6:
                    return "س";
                case 7:
                    return "ح";
            }
        }
        return str.substring(0, 1);
    }

    public final String m(int i10, String str, Locale locale) {
        if (locale.getLanguage().equals("zh") && locale.getCountry().equals("CN")) {
            switch (i10) {
                case 1:
                    return "一";
                case 2:
                    return "二";
                case 3:
                    return "三";
                case 4:
                    return "四";
                case 5:
                    return "五";
                case 6:
                    return "六";
                case 7:
                    return "七";
                case 8:
                    return "八";
                case 9:
                    return "九";
                case 10:
                    return "十";
                case 11:
                    return "十一";
                case 12:
                    return "十二";
            }
        }
        if (locale.getLanguage().equals(d.f17511a)) {
            switch (i10) {
                case 1:
                    return "ي";
                case 2:
                    return "ف";
                case 3:
                    return "م";
                case 4:
                    return "أ";
                case 5:
                    return "و";
                case 6:
                    return "ن";
                case 7:
                    return "ل";
                case 8:
                    return "غ";
                case 9:
                    return "س";
                case 10:
                    return "ك";
                case 11:
                    return "ب";
                case 12:
                    return "د";
            }
        }
        return (locale.getLanguage().equals("ja") && locale.getCountry().equals("JP")) ? Integer.toString(i10) : str.substring(0, 1);
    }
}
