package com.opos.exoplayer.core.f.f;

import android.text.Layout;
import com.cdo.oaps.ad.OapsKey;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.i.v;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.advv.virtualview.common.StringBase;
import com.vivo.google.android.exoplayer3.C;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes4.dex */
public final class a extends com.opos.exoplayer.core.f.c {

    /* renamed from: a */
    private static final Pattern f18708a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: b */
    private static final Pattern f18709b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: c */
    private static final Pattern f18710c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: d */
    private static final Pattern f18711d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: e */
    private static final C0414a f18712e = new C0414a(30.0f, 1, 1);

    /* renamed from: f */
    private final XmlPullParserFactory f18713f;

    /* renamed from: com.opos.exoplayer.core.f.f.a$a */
    private static final class C0414a {

        /* renamed from: a */
        final float f18714a;

        /* renamed from: b */
        final int f18715b;

        /* renamed from: c */
        final int f18716c;

        C0414a(float f2, int i2, int i3) {
            this.f18714a = f2;
            this.f18715b = i2;
            this.f18716c = i3;
        }
    }

    public a() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f18713f = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bb, code lost:
    
        if (r0.equals("ms") == false) goto L78;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x00e9. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(java.lang.String r17, com.opos.exoplayer.core.f.f.a.C0414a r18) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.f.a.a(java.lang.String, com.opos.exoplayer.core.f.f.a$a):long");
    }

    private C0414a a(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f2 = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (attributeValue2.split(" ").length != 2) {
                throw new com.opos.exoplayer.core.f.f("frameRateMultiplier doesn't have 2 parts");
            }
            f2 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        }
        C0414a c0414a = f18712e;
        int i2 = c0414a.f18715b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = c0414a.f18716c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new C0414a(parseInt * f2, i2, i3);
    }

    private b a(b bVar) {
        return bVar == null ? new b() : bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private b a(XmlPullParser xmlPullParser, b bVar) {
        char c2;
        StringBuilder sb;
        String str;
        b a2;
        Layout.Alignment alignment;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            String attributeName = xmlPullParser.getAttributeName(i2);
            char c3 = 65535;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case StringBase.STR_ID_id /* 3355 */:
                    if (attributeName.equals("id")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case StringBase.STR_ID_color /* 94842723 */:
                    if (attributeName.equals("color")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (!OapsKey.KEY_STYLE.equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        bVar = a(bVar).b(attributeValue);
                        continue;
                    }
                case 1:
                    bVar = a(bVar);
                    try {
                        bVar.b(com.opos.exoplayer.core.i.d.a(attributeValue));
                        continue;
                    } catch (IllegalArgumentException unused) {
                        sb = new StringBuilder();
                        str = "Failed parsing background value: ";
                        break;
                    }
                case 2:
                    bVar = a(bVar);
                    try {
                        bVar.a(com.opos.exoplayer.core.i.d.a(attributeValue));
                        continue;
                    } catch (IllegalArgumentException unused2) {
                        sb = new StringBuilder();
                        str = "Failed parsing color value: ";
                        break;
                    }
                case 3:
                    bVar = a(bVar).a(attributeValue);
                    continue;
                case 4:
                    try {
                        bVar = a(bVar);
                        a(attributeValue, bVar);
                        continue;
                    } catch (com.opos.exoplayer.core.f.f unused3) {
                        sb = new StringBuilder();
                        str = "Failed parsing fontSize value: ";
                        break;
                    }
                case 5:
                    bVar = a(bVar).c("bold".equalsIgnoreCase(attributeValue));
                    continue;
                case 6:
                    bVar = a(bVar).d("italic".equalsIgnoreCase(attributeValue));
                    continue;
                case 7:
                    String d2 = u.d(attributeValue);
                    switch (d2.hashCode()) {
                        case -1364013995:
                            if (d2.equals("center")) {
                                c3 = 4;
                                break;
                            }
                            break;
                        case 100571:
                            if (d2.equals("end")) {
                                c3 = 3;
                                break;
                            }
                            break;
                        case 3317767:
                            if (d2.equals("left")) {
                                c3 = 0;
                                break;
                            }
                            break;
                        case 108511772:
                            if (d2.equals("right")) {
                                c3 = 2;
                                break;
                            }
                            break;
                        case 109757538:
                            if (d2.equals("start")) {
                                c3 = 1;
                                break;
                            }
                            break;
                    }
                    if (c3 == 0 || c3 == 1) {
                        a2 = a(bVar);
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                    } else if (c3 == 2 || c3 == 3) {
                        a2 = a(bVar);
                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    } else if (c3 != 4) {
                        break;
                    } else {
                        a2 = a(bVar);
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    }
                    bVar = a2.a(alignment);
                    continue;
                case '\b':
                    String d3 = u.d(attributeValue);
                    switch (d3.hashCode()) {
                        case -1461280213:
                            if (d3.equals("nounderline")) {
                                c3 = 3;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (d3.equals("underline")) {
                                c3 = 2;
                                break;
                            }
                            break;
                        case 913457136:
                            if (d3.equals("nolinethrough")) {
                                c3 = 1;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (d3.equals("linethrough")) {
                                c3 = 0;
                                break;
                            }
                            break;
                    }
                    if (c3 == 0) {
                        bVar = a(bVar).a(true);
                        break;
                    } else if (c3 == 1) {
                        bVar = a(bVar).a(false);
                        break;
                    } else if (c3 == 2) {
                        bVar = a(bVar).b(true);
                        break;
                    } else if (c3 != 3) {
                        break;
                    } else {
                        bVar = a(bVar).b(false);
                        continue;
                    }
            }
            sb.append(str);
            sb.append(attributeValue);
            com.opos.cmn.an.f.a.c("TtmlDecoder", sb.toString());
        }
        return bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private c a(XmlPullParser xmlPullParser, c cVar, Map<String, d> map, C0414a c0414a) {
        long j2;
        long j3;
        char c2;
        int attributeCount = xmlPullParser.getAttributeCount();
        b a2 = a(xmlPullParser, (b) null);
        String[] strArr = null;
        String str = "";
        long j4 = C.TIME_UNSET;
        long j5 = C.TIME_UNSET;
        long j6 = C.TIME_UNSET;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case StringBase.STR_ID_style /* 109780401 */:
                    if (attributeName.equals(OapsKey.KEY_STYLE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str = attributeValue;
                        continue;
                    }
                case 1:
                    j6 = a(attributeValue, c0414a);
                    break;
                case 2:
                    j5 = a(attributeValue, c0414a);
                    break;
                case 3:
                    j4 = a(attributeValue, c0414a);
                    break;
                case 4:
                    String[] a3 = a(attributeValue);
                    if (a3.length > 0) {
                        strArr = a3;
                        break;
                    }
                    break;
            }
        }
        if (cVar != null) {
            long j7 = cVar.f18730d;
            j2 = C.TIME_UNSET;
            if (j7 != C.TIME_UNSET) {
                if (j4 != C.TIME_UNSET) {
                    j4 += j7;
                }
                if (j5 != C.TIME_UNSET) {
                    j5 += j7;
                }
            }
        } else {
            j2 = C.TIME_UNSET;
        }
        long j8 = j4;
        if (j5 == j2) {
            if (j6 != j2) {
                j3 = j8 + j6;
            } else if (cVar != null) {
                long j9 = cVar.f18731e;
                if (j9 != j2) {
                    j3 = j9;
                }
            }
            return c.a(xmlPullParser.getName(), j8, j3, a2, strArr, str);
        }
        j3 = j5;
        return c.a(xmlPullParser.getName(), j8, j3, a2, strArr, str);
    }

    private Map<String, b> a(XmlPullParser xmlPullParser, Map<String, b> map, Map<String, d> map2) {
        d b2;
        do {
            xmlPullParser.next();
            if (v.b(xmlPullParser, OapsKey.KEY_STYLE)) {
                String c2 = v.c(xmlPullParser, OapsKey.KEY_STYLE);
                b a2 = a(xmlPullParser, new b());
                if (c2 != null) {
                    for (String str : a(c2)) {
                        a2.a(map.get(str));
                    }
                }
                if (a2.i() != null) {
                    map.put(a2.i(), a2);
                }
            } else if (v.b(xmlPullParser, "region") && (b2 = b(xmlPullParser)) != null) {
                map2.put(b2.f18737a, b2);
            }
        } while (!v.a(xmlPullParser, MonitorConstants.CONNECT_TYPE_HEAD));
        return map;
    }

    private static void a(String str, b bVar) {
        Matcher matcher;
        String group;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = f18710c.matcher(str);
        } else {
            if (split.length != 2) {
                throw new com.opos.exoplayer.core.f.f("Invalid number of entries for fontSize: " + split.length + ".");
            }
            matcher = f18710c.matcher(split[1]);
            com.opos.cmn.an.f.a.c("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new com.opos.exoplayer.core.f.f("Invalid expression for fontSize: '" + str + "'.");
        }
        group = matcher.group(3);
        group.hashCode();
        switch (group) {
            case "%":
                bVar.c(3);
                break;
            case "em":
                bVar.c(2);
                break;
            case "px":
                bVar.c(1);
                break;
            default:
                throw new com.opos.exoplayer.core.f.f("Invalid unit for fontSize: '" + group + "'.");
        }
        bVar.a(Float.valueOf(matcher.group(1)).floatValue());
    }

    private String[] a(String str) {
        return str.split("\\s+");
    }

    private d b(XmlPullParser xmlPullParser) {
        String str;
        StringBuilder sb;
        String str2;
        float f2;
        String c2 = v.c(xmlPullParser, "id");
        if (c2 == null) {
            return null;
        }
        String c3 = v.c(xmlPullParser, "origin");
        if (c3 != null) {
            Pattern pattern = f18711d;
            Matcher matcher = pattern.matcher(c3);
            if (matcher.matches()) {
                int i2 = 1;
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String c4 = v.c(xmlPullParser, "extent");
                    if (c4 != null) {
                        Matcher matcher2 = pattern.matcher(c4);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String c5 = v.c(xmlPullParser, "displayAlign");
                                if (c5 != null) {
                                    String d2 = u.d(c5);
                                    d2.hashCode();
                                    if (d2.equals("center")) {
                                        f2 = parseFloat2 + (parseFloat4 / 2.0f);
                                    } else if (d2.equals("after")) {
                                        f2 = parseFloat2 + parseFloat4;
                                        i2 = 2;
                                    }
                                    return new d(c2, parseFloat, f2, 0, i2, parseFloat3);
                                }
                                f2 = parseFloat2;
                                i2 = 0;
                                return new d(c2, parseFloat, f2, 0, i2, parseFloat3);
                            } catch (NumberFormatException unused) {
                                sb = new StringBuilder();
                                str2 = "Ignoring region with malformed extent: ";
                            }
                        } else {
                            sb = new StringBuilder();
                            str2 = "Ignoring region with unsupported extent: ";
                        }
                    } else {
                        str = "Ignoring region without an extent";
                    }
                } catch (NumberFormatException unused2) {
                    sb = new StringBuilder();
                    str2 = "Ignoring region with malformed origin: ";
                }
            } else {
                sb = new StringBuilder();
                str2 = "Ignoring region with unsupported origin: ";
            }
            sb.append(str2);
            sb.append(c3);
            str = sb.toString();
        } else {
            str = "Ignoring region without an origin";
        }
        com.opos.cmn.an.f.a.c("TtmlDecoder", str);
        return null;
    }

    private static boolean b(String str) {
        return str.equals("tt") || str.equals(MonitorConstants.CONNECT_TYPE_HEAD) || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals(OapsKey.KEY_STYLE) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public f a(byte[] bArr, int i2, boolean z) {
        try {
            XmlPullParser newPullParser = this.f18713f.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            f fVar = null;
            hashMap2.put("", new d(null));
            int i3 = 0;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i2), null);
            LinkedList linkedList = new LinkedList();
            C0414a c0414a = f18712e;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                c cVar = (c) linkedList.peekLast();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            c0414a = a(newPullParser);
                        }
                        if (!b(name)) {
                            com.opos.cmn.an.f.a.a("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                        } else if (MonitorConstants.CONNECT_TYPE_HEAD.equals(name)) {
                            a(newPullParser, hashMap, hashMap2);
                        } else {
                            try {
                                c a2 = a(newPullParser, cVar, hashMap2, c0414a);
                                linkedList.addLast(a2);
                                if (cVar != null) {
                                    cVar.a(a2);
                                }
                            } catch (com.opos.exoplayer.core.f.f e2) {
                                com.opos.cmn.an.f.a.c("TtmlDecoder", "Suppressing parser error", e2);
                            }
                        }
                        i3++;
                    } else if (eventType == 4) {
                        cVar.a(c.a(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            fVar = new f((c) linkedList.getLast(), hashMap, hashMap2);
                        }
                        linkedList.removeLast();
                    }
                } else {
                    if (eventType != 2) {
                        if (eventType == 3) {
                            i3--;
                        }
                    }
                    i3++;
                }
                newPullParser.next();
            }
            return fVar;
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        } catch (XmlPullParserException e4) {
            throw new com.opos.exoplayer.core.f.f("Unable to decode source", e4);
        }
    }
}
