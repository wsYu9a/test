package com.vivo.google.android.exoplayer3;

import com.cdo.oaps.ad.OapsKey;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.advv.virtualview.common.StringBase;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes4.dex */
public final class p4 extends w3 {
    public static final Pattern o = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern p = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern q = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    public static final a s = new a(30.0f, 1, 1);
    public final XmlPullParserFactory n;

    public static final class a {

        /* renamed from: a */
        public final float f27933a;

        /* renamed from: b */
        public final int f27934b;

        /* renamed from: c */
        public final int f27935c;

        public a(float f2, int i2, int i3) {
            this.f27933a = f2;
            this.f27934b = i2;
            this.f27935c = i3;
        }
    }

    public p4() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.n = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ce, code lost:
    
        if (r14.equals("s") != false) goto L120;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long a(java.lang.String r14, com.vivo.google.android.exoplayer3.p4.a r15) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.p4.a(java.lang.String, com.vivo.google.android.exoplayer3.p4$a):long");
    }

    public static boolean a(String str) {
        return str.equals("tt") || str.equals(MonitorConstants.CONNECT_TYPE_HEAD) || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals(OapsKey.KEY_STYLE) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    public final a a(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f2 = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (attributeValue2.split(" ").length != 2) {
                throw new a4("frameRateMultiplier doesn't have 2 parts");
            }
            f2 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        }
        a aVar = s;
        int i2 = aVar.f27934b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = aVar.f27935c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new a(parseInt * f2, i2, i3);
    }

    public final s4 a(s4 s4Var) {
        return s4Var == null ? new s4() : s4Var;
    }

    @Override // com.vivo.google.android.exoplayer3.w3
    public y3 a(byte[] bArr, int i2, boolean z) {
        try {
            XmlPullParser newPullParser = this.n.newPullParser();
            Map<String, s4> hashMap = new HashMap<>();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new r4(null, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
            int i3 = 0;
            t4 t4Var = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i2), null);
            LinkedList linkedList = new LinkedList();
            a aVar = s;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                q4 q4Var = (q4) linkedList.peekLast();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            aVar = a(newPullParser);
                        }
                        if (!a(name)) {
                            String str = "Ignoring unsupported tag: " + newPullParser.getName();
                        } else if (MonitorConstants.CONNECT_TYPE_HEAD.equals(name)) {
                            a(newPullParser, hashMap, hashMap2);
                        } else {
                            try {
                                q4 a2 = a(newPullParser, q4Var, hashMap2, aVar);
                                linkedList.addLast(a2);
                                if (q4Var != null) {
                                    q4Var.a(a2);
                                }
                            } catch (a4 unused) {
                            }
                        }
                        i3++;
                    } else if (eventType == 4) {
                        q4 q4Var2 = new q4(null, newPullParser.getText().replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), C.TIME_UNSET, C.TIME_UNSET, null, null, "");
                        if (q4Var.k == null) {
                            q4Var.k = new ArrayList();
                        }
                        q4Var.k.add(q4Var2);
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            t4Var = new t4((q4) linkedList.getLast(), hashMap, hashMap2);
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
            return t4Var;
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new a4("Unable to decode source", e3);
        }
    }

    public static void a(String str, s4 s4Var) {
        Matcher matcher;
        String group;
        String[] split = str.split("\\s+");
        int i2 = 2;
        if (split.length == 1) {
            matcher = q.matcher(str);
        } else {
            if (split.length != 2) {
                throw new a4("Invalid number of entries for fontSize: " + split.length + ".");
            }
            matcher = q.matcher(split[1]);
        }
        if (matcher.matches()) {
            group = matcher.group(3);
            group.hashCode();
            switch (group) {
                case "%":
                    i2 = 3;
                    break;
                case "em":
                    break;
                case "px":
                    i2 = 1;
                    break;
                default:
                    throw new a4("Invalid unit for fontSize: '" + group + "'.");
            }
            s4Var.f28056j = i2;
            s4Var.k = Float.valueOf(matcher.group(1)).floatValue();
            return;
        }
        throw new a4("Invalid expression for fontSize: '" + str + "'.");
    }

    public final Map<String, s4> a(XmlPullParser xmlPullParser, Map<String, s4> map, Map<String, r4> map2) {
        boolean z;
        String a2;
        StringBuilder sb;
        String str;
        float f2;
        do {
            xmlPullParser.next();
            z = false;
            if (g1.b(xmlPullParser, OapsKey.KEY_STYLE)) {
                String a3 = g1.a(xmlPullParser, OapsKey.KEY_STYLE);
                s4 a4 = a(xmlPullParser, new s4());
                if (a3 != null) {
                    for (String str2 : a3.split("\\s+")) {
                        a4.a(map.get(str2));
                    }
                }
                String str3 = a4.l;
                if (str3 != null) {
                    map.put(str3, a4);
                }
            } else if (g1.b(xmlPullParser, "region")) {
                String a5 = g1.a(xmlPullParser, "id");
                r4 r4Var = null;
                if (a5 != null && (a2 = g1.a(xmlPullParser, "origin")) != null) {
                    Pattern pattern = r;
                    Matcher matcher = pattern.matcher(a2);
                    if (matcher.matches()) {
                        try {
                            float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                            int i2 = 2;
                            float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                            String a6 = g1.a(xmlPullParser, "extent");
                            if (a6 != null) {
                                Matcher matcher2 = pattern.matcher(a6);
                                if (matcher2.matches()) {
                                    try {
                                        float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                        float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                        String a7 = g1.a(xmlPullParser, "displayAlign");
                                        if (a7 != null) {
                                            String lowerCase = a7.toLowerCase();
                                            lowerCase.hashCode();
                                            if (lowerCase.equals("after")) {
                                                f2 = parseFloat2 + parseFloat4;
                                            } else if (lowerCase.equals("center")) {
                                                f2 = parseFloat2 + (parseFloat4 / 2.0f);
                                                i2 = 1;
                                            }
                                            r4Var = new r4(a5, parseFloat, f2, 0, i2, parseFloat3);
                                        }
                                        f2 = parseFloat2;
                                        i2 = 0;
                                        r4Var = new r4(a5, parseFloat, f2, 0, i2, parseFloat3);
                                    } catch (NumberFormatException unused) {
                                        sb = new StringBuilder();
                                        str = "Ignoring region with malformed extent: ";
                                    }
                                } else {
                                    sb = new StringBuilder();
                                    str = "Ignoring region with unsupported extent: ";
                                }
                            }
                        } catch (NumberFormatException unused2) {
                            sb = new StringBuilder();
                            str = "Ignoring region with malformed origin: ";
                        }
                    } else {
                        sb = new StringBuilder();
                        str = "Ignoring region with unsupported origin: ";
                    }
                    sb.append(str);
                    sb.append(a2);
                    sb.toString();
                }
                if (r4Var != null) {
                    map2.put(r4Var.f28010a, r4Var);
                }
            }
            if ((xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(MonitorConstants.CONNECT_TYPE_HEAD)) {
                z = true;
            }
        } while (!z);
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final q4 a(XmlPullParser xmlPullParser, q4 q4Var, Map<String, r4> map, a aVar) {
        long j2;
        char c2;
        int attributeCount = xmlPullParser.getAttributeCount();
        s4 a2 = a(xmlPullParser, (s4) null);
        String[] strArr = null;
        String str = "";
        long j3 = C.TIME_UNSET;
        long j4 = C.TIME_UNSET;
        long j5 = C.TIME_UNSET;
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
                    j5 = a(attributeValue, aVar);
                    break;
                case 2:
                    j4 = a(attributeValue, aVar);
                    break;
                case 3:
                    j3 = a(attributeValue, aVar);
                    break;
                case 4:
                    String[] split = attributeValue.split("\\s+");
                    if (split.length > 0) {
                        strArr = split;
                        break;
                    }
                    break;
            }
        }
        if (q4Var != null) {
            long j6 = q4Var.f27962d;
            j2 = C.TIME_UNSET;
            if (j6 != C.TIME_UNSET) {
                if (j3 != C.TIME_UNSET) {
                    j3 += j6;
                }
                if (j4 != C.TIME_UNSET) {
                    j4 += j6;
                }
            }
        } else {
            j2 = C.TIME_UNSET;
        }
        if (j4 == j2) {
            if (j5 != j2) {
                j4 = j3 + j5;
            } else if (q4Var != null) {
                long j7 = q4Var.f27963e;
                if (j7 != j2) {
                    j4 = j7;
                }
            }
        }
        return new q4(xmlPullParser.getName(), null, j3, j4, a2, strArr, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012a, code lost:
    
        if (r3.equals("linethrough") == false) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0198, code lost:
    
        if (r3.equals("start") == false) goto L234;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.vivo.google.android.exoplayer3.s4 a(org.xmlpull.v1.XmlPullParser r12, com.vivo.google.android.exoplayer3.s4 r13) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.p4.a(org.xmlpull.v1.XmlPullParser, com.vivo.google.android.exoplayer3.s4):com.vivo.google.android.exoplayer3.s4");
    }
}
