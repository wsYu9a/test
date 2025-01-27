package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    protected int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    protected final String typeKey;
    protected final String typeName;
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    private static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d8, code lost:
    
        if (r10.parent != null) goto L547;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03b4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03f6 A[Catch: all -> 0x0185, Exception -> 0x018b, TryCatch #7 {Exception -> 0x018b, all -> 0x0185, blocks: (B:77:0x0158, B:79:0x0173, B:81:0x0177, B:88:0x0191, B:90:0x0195, B:94:0x019e, B:95:0x01a2, B:97:0x01a8, B:103:0x01ba, B:105:0x01c0, B:107:0x01c5, B:110:0x0212, B:112:0x0218, B:114:0x0233, B:115:0x0237, B:117:0x023d, B:127:0x0261, B:129:0x0265, B:131:0x026c, B:133:0x0270, B:134:0x0275, B:136:0x0279, B:137:0x027e, B:138:0x0285, B:140:0x028b, B:145:0x02a5, B:147:0x02a9, B:149:0x02b0, B:151:0x02b4, B:152:0x02b9, B:154:0x02bd, B:155:0x02c2, B:156:0x02c9, B:158:0x02cf, B:166:0x02f2, B:168:0x0300, B:170:0x030d, B:172:0x0311, B:175:0x0316, B:177:0x0319, B:183:0x03b8, B:185:0x03bc, B:187:0x03c0, B:189:0x03c4, B:191:0x03c8, B:193:0x03cc, B:195:0x03de, B:197:0x03e2, B:199:0x03e6, B:201:0x03d0, B:203:0x03d4, B:207:0x03f6, B:209:0x03ff, B:211:0x0403, B:212:0x0407, B:213:0x040b, B:215:0x041e, B:218:0x0428, B:219:0x042c, B:225:0x0436, B:226:0x0439, B:229:0x0441, B:231:0x044c, B:233:0x0450, B:235:0x0455, B:239:0x0471, B:242:0x047b, B:245:0x0482, B:249:0x048c, B:253:0x0498, B:257:0x049e, B:259:0x04a2, B:260:0x04a4, B:262:0x04ac, B:264:0x04b0, B:265:0x04b4, B:267:0x04c3, B:255:0x04cd, B:270:0x04d0, B:272:0x04d4, B:273:0x04dd, B:276:0x04e3, B:277:0x04ee, B:280:0x04fd, B:282:0x0504, B:284:0x050d, B:286:0x0513, B:288:0x0518, B:289:0x051d, B:291:0x0521, B:292:0x0526, B:293:0x052d, B:296:0x0535, B:298:0x053e, B:302:0x0552, B:303:0x0557, B:305:0x055c, B:306:0x0567, B:307:0x056c, B:308:0x0571, B:310:0x031d, B:313:0x0325, B:315:0x0330, B:317:0x0334, B:320:0x0339, B:322:0x033c, B:325:0x0344, B:327:0x034c, B:329:0x0357, B:331:0x035b, B:334:0x0362, B:336:0x0365, B:338:0x036a, B:339:0x0370, B:341:0x0378, B:343:0x0383, B:345:0x0387, B:348:0x038e, B:350:0x0391, B:352:0x0396, B:354:0x039d, B:356:0x03a1, B:364:0x021f, B:366:0x0223, B:367:0x0228, B:369:0x022c, B:372:0x01d5, B:374:0x01d9, B:376:0x01e9, B:378:0x01ed, B:379:0x01fd, B:381:0x0209, B:407:0x059c, B:408:0x05a0, B:410:0x05a6, B:416:0x05b8, B:418:0x05c1, B:421:0x05d0, B:423:0x05d4, B:424:0x05d8), top: B:76:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04c3 A[Catch: all -> 0x0185, Exception -> 0x018b, TryCatch #7 {Exception -> 0x018b, all -> 0x0185, blocks: (B:77:0x0158, B:79:0x0173, B:81:0x0177, B:88:0x0191, B:90:0x0195, B:94:0x019e, B:95:0x01a2, B:97:0x01a8, B:103:0x01ba, B:105:0x01c0, B:107:0x01c5, B:110:0x0212, B:112:0x0218, B:114:0x0233, B:115:0x0237, B:117:0x023d, B:127:0x0261, B:129:0x0265, B:131:0x026c, B:133:0x0270, B:134:0x0275, B:136:0x0279, B:137:0x027e, B:138:0x0285, B:140:0x028b, B:145:0x02a5, B:147:0x02a9, B:149:0x02b0, B:151:0x02b4, B:152:0x02b9, B:154:0x02bd, B:155:0x02c2, B:156:0x02c9, B:158:0x02cf, B:166:0x02f2, B:168:0x0300, B:170:0x030d, B:172:0x0311, B:175:0x0316, B:177:0x0319, B:183:0x03b8, B:185:0x03bc, B:187:0x03c0, B:189:0x03c4, B:191:0x03c8, B:193:0x03cc, B:195:0x03de, B:197:0x03e2, B:199:0x03e6, B:201:0x03d0, B:203:0x03d4, B:207:0x03f6, B:209:0x03ff, B:211:0x0403, B:212:0x0407, B:213:0x040b, B:215:0x041e, B:218:0x0428, B:219:0x042c, B:225:0x0436, B:226:0x0439, B:229:0x0441, B:231:0x044c, B:233:0x0450, B:235:0x0455, B:239:0x0471, B:242:0x047b, B:245:0x0482, B:249:0x048c, B:253:0x0498, B:257:0x049e, B:259:0x04a2, B:260:0x04a4, B:262:0x04ac, B:264:0x04b0, B:265:0x04b4, B:267:0x04c3, B:255:0x04cd, B:270:0x04d0, B:272:0x04d4, B:273:0x04dd, B:276:0x04e3, B:277:0x04ee, B:280:0x04fd, B:282:0x0504, B:284:0x050d, B:286:0x0513, B:288:0x0518, B:289:0x051d, B:291:0x0521, B:292:0x0526, B:293:0x052d, B:296:0x0535, B:298:0x053e, B:302:0x0552, B:303:0x0557, B:305:0x055c, B:306:0x0567, B:307:0x056c, B:308:0x0571, B:310:0x031d, B:313:0x0325, B:315:0x0330, B:317:0x0334, B:320:0x0339, B:322:0x033c, B:325:0x0344, B:327:0x034c, B:329:0x0357, B:331:0x035b, B:334:0x0362, B:336:0x0365, B:338:0x036a, B:339:0x0370, B:341:0x0378, B:343:0x0383, B:345:0x0387, B:348:0x038e, B:350:0x0391, B:352:0x0396, B:354:0x039d, B:356:0x03a1, B:364:0x021f, B:366:0x0223, B:367:0x0228, B:369:0x022c, B:372:0x01d5, B:374:0x01d9, B:376:0x01e9, B:378:0x01ed, B:379:0x01fd, B:381:0x0209, B:407:0x059c, B:408:0x05a0, B:410:0x05a6, B:416:0x05b8, B:418:0x05c1, B:421:0x05d0, B:423:0x05d4, B:424:0x05d8), top: B:76:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0601 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x05b8 A[Catch: all -> 0x0185, Exception -> 0x018b, TRY_ENTER, TryCatch #7 {Exception -> 0x018b, all -> 0x0185, blocks: (B:77:0x0158, B:79:0x0173, B:81:0x0177, B:88:0x0191, B:90:0x0195, B:94:0x019e, B:95:0x01a2, B:97:0x01a8, B:103:0x01ba, B:105:0x01c0, B:107:0x01c5, B:110:0x0212, B:112:0x0218, B:114:0x0233, B:115:0x0237, B:117:0x023d, B:127:0x0261, B:129:0x0265, B:131:0x026c, B:133:0x0270, B:134:0x0275, B:136:0x0279, B:137:0x027e, B:138:0x0285, B:140:0x028b, B:145:0x02a5, B:147:0x02a9, B:149:0x02b0, B:151:0x02b4, B:152:0x02b9, B:154:0x02bd, B:155:0x02c2, B:156:0x02c9, B:158:0x02cf, B:166:0x02f2, B:168:0x0300, B:170:0x030d, B:172:0x0311, B:175:0x0316, B:177:0x0319, B:183:0x03b8, B:185:0x03bc, B:187:0x03c0, B:189:0x03c4, B:191:0x03c8, B:193:0x03cc, B:195:0x03de, B:197:0x03e2, B:199:0x03e6, B:201:0x03d0, B:203:0x03d4, B:207:0x03f6, B:209:0x03ff, B:211:0x0403, B:212:0x0407, B:213:0x040b, B:215:0x041e, B:218:0x0428, B:219:0x042c, B:225:0x0436, B:226:0x0439, B:229:0x0441, B:231:0x044c, B:233:0x0450, B:235:0x0455, B:239:0x0471, B:242:0x047b, B:245:0x0482, B:249:0x048c, B:253:0x0498, B:257:0x049e, B:259:0x04a2, B:260:0x04a4, B:262:0x04ac, B:264:0x04b0, B:265:0x04b4, B:267:0x04c3, B:255:0x04cd, B:270:0x04d0, B:272:0x04d4, B:273:0x04dd, B:276:0x04e3, B:277:0x04ee, B:280:0x04fd, B:282:0x0504, B:284:0x050d, B:286:0x0513, B:288:0x0518, B:289:0x051d, B:291:0x0521, B:292:0x0526, B:293:0x052d, B:296:0x0535, B:298:0x053e, B:302:0x0552, B:303:0x0557, B:305:0x055c, B:306:0x0567, B:307:0x056c, B:308:0x0571, B:310:0x031d, B:313:0x0325, B:315:0x0330, B:317:0x0334, B:320:0x0339, B:322:0x033c, B:325:0x0344, B:327:0x034c, B:329:0x0357, B:331:0x035b, B:334:0x0362, B:336:0x0365, B:338:0x036a, B:339:0x0370, B:341:0x0378, B:343:0x0383, B:345:0x0387, B:348:0x038e, B:350:0x0391, B:352:0x0396, B:354:0x039d, B:356:0x03a1, B:364:0x021f, B:366:0x0223, B:367:0x0228, B:369:0x022c, B:372:0x01d5, B:374:0x01d9, B:376:0x01e9, B:378:0x01ed, B:379:0x01fd, B:381:0x0209, B:407:0x059c, B:408:0x05a0, B:410:0x05a6, B:416:0x05b8, B:418:0x05c1, B:421:0x05d0, B:423:0x05d4, B:424:0x05d8), top: B:76:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x05d0 A[Catch: all -> 0x0185, Exception -> 0x018b, TRY_ENTER, TryCatch #7 {Exception -> 0x018b, all -> 0x0185, blocks: (B:77:0x0158, B:79:0x0173, B:81:0x0177, B:88:0x0191, B:90:0x0195, B:94:0x019e, B:95:0x01a2, B:97:0x01a8, B:103:0x01ba, B:105:0x01c0, B:107:0x01c5, B:110:0x0212, B:112:0x0218, B:114:0x0233, B:115:0x0237, B:117:0x023d, B:127:0x0261, B:129:0x0265, B:131:0x026c, B:133:0x0270, B:134:0x0275, B:136:0x0279, B:137:0x027e, B:138:0x0285, B:140:0x028b, B:145:0x02a5, B:147:0x02a9, B:149:0x02b0, B:151:0x02b4, B:152:0x02b9, B:154:0x02bd, B:155:0x02c2, B:156:0x02c9, B:158:0x02cf, B:166:0x02f2, B:168:0x0300, B:170:0x030d, B:172:0x0311, B:175:0x0316, B:177:0x0319, B:183:0x03b8, B:185:0x03bc, B:187:0x03c0, B:189:0x03c4, B:191:0x03c8, B:193:0x03cc, B:195:0x03de, B:197:0x03e2, B:199:0x03e6, B:201:0x03d0, B:203:0x03d4, B:207:0x03f6, B:209:0x03ff, B:211:0x0403, B:212:0x0407, B:213:0x040b, B:215:0x041e, B:218:0x0428, B:219:0x042c, B:225:0x0436, B:226:0x0439, B:229:0x0441, B:231:0x044c, B:233:0x0450, B:235:0x0455, B:239:0x0471, B:242:0x047b, B:245:0x0482, B:249:0x048c, B:253:0x0498, B:257:0x049e, B:259:0x04a2, B:260:0x04a4, B:262:0x04ac, B:264:0x04b0, B:265:0x04b4, B:267:0x04c3, B:255:0x04cd, B:270:0x04d0, B:272:0x04d4, B:273:0x04dd, B:276:0x04e3, B:277:0x04ee, B:280:0x04fd, B:282:0x0504, B:284:0x050d, B:286:0x0513, B:288:0x0518, B:289:0x051d, B:291:0x0521, B:292:0x0526, B:293:0x052d, B:296:0x0535, B:298:0x053e, B:302:0x0552, B:303:0x0557, B:305:0x055c, B:306:0x0567, B:307:0x056c, B:308:0x0571, B:310:0x031d, B:313:0x0325, B:315:0x0330, B:317:0x0334, B:320:0x0339, B:322:0x033c, B:325:0x0344, B:327:0x034c, B:329:0x0357, B:331:0x035b, B:334:0x0362, B:336:0x0365, B:338:0x036a, B:339:0x0370, B:341:0x0378, B:343:0x0383, B:345:0x0387, B:348:0x038e, B:350:0x0391, B:352:0x0396, B:354:0x039d, B:356:0x03a1, B:364:0x021f, B:366:0x0223, B:367:0x0228, B:369:0x022c, B:372:0x01d5, B:374:0x01d9, B:376:0x01e9, B:378:0x01ed, B:379:0x01fd, B:381:0x0209, B:407:0x059c, B:408:0x05a0, B:410:0x05a6, B:416:0x05b8, B:418:0x05c1, B:421:0x05d0, B:423:0x05d4, B:424:0x05d8), top: B:76:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103 A[Catch: all -> 0x0091, Exception -> 0x0096, TRY_ENTER, TryCatch #8 {Exception -> 0x0096, all -> 0x0091, blocks: (B:458:0x0089, B:460:0x008d, B:461:0x009b, B:33:0x00aa, B:35:0x00b3, B:39:0x00c4, B:42:0x00cb, B:44:0x00d2, B:46:0x00d6, B:51:0x0103, B:52:0x0107, B:54:0x010d, B:61:0x0126, B:448:0x00e0, B:451:0x00e9, B:453:0x00f0, B:454:0x00f8, B:456:0x00e5), top: B:457:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0126 A[Catch: all -> 0x0091, Exception -> 0x0096, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0096, all -> 0x0091, blocks: (B:458:0x0089, B:460:0x008d, B:461:0x009b, B:33:0x00aa, B:35:0x00b3, B:39:0x00c4, B:42:0x00cb, B:44:0x00d2, B:46:0x00d6, B:51:0x0103, B:52:0x0107, B:54:0x010d, B:61:0x0126, B:448:0x00e0, B:451:0x00e9, B:453:0x00f0, B:454:0x00f8, B:456:0x00e5), top: B:457:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r38, java.lang.Object r39, java.lang.Object r40, java.lang.reflect.Type r41) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }

    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    public JavaBeanSerializer(Class<?> cls, int i10, Map<String, String> map, boolean z10, boolean z11, boolean z12, boolean z13, PropertyNamingStrategy propertyNamingStrategy) {
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        String str2;
        this.features = 0;
        JSONType jSONType = z11 ? (JSONType) cls.getAnnotation(JSONType.class) : null;
        if (jSONType != null) {
            this.features = SerializerFeature.of(jSONType.serialzeFeatures());
            str = jSONType.typeName();
            if (str.length() == 0) {
                str = null;
                str2 = null;
            } else {
                str2 = null;
                for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    JSONType jSONType2 = (JSONType) superclass.getAnnotation(JSONType.class);
                    if (jSONType2 == null) {
                        break;
                    }
                    str2 = jSONType2.typeKey();
                    if (str2.length() != 0) {
                        break;
                    }
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    JSONType jSONType3 = (JSONType) cls2.getAnnotation(JSONType.class);
                    if (jSONType3 != null) {
                        str2 = jSONType3.typeKey();
                        if (str2.length() != 0) {
                            break;
                        }
                    }
                }
                if (str2 != null && str2.length() == 0) {
                    str2 = null;
                }
            }
            if (propertyNamingStrategy != null || (propertyNamingStrategy2 = jSONType.naming()) == PropertyNamingStrategy.CamelCase) {
                propertyNamingStrategy2 = propertyNamingStrategy;
            }
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            str = null;
            str2 = null;
        }
        this.typeName = str;
        this.typeKey = str2;
        List<FieldInfo> computeGetters = TypeUtils.computeGetters(cls, i10, z10, jSONType, map, false, z12, z13, propertyNamingStrategy2);
        ArrayList arrayList = new ArrayList();
        Iterator<FieldInfo> it = computeGetters.iterator();
        while (it.hasNext()) {
            arrayList.add(new FieldSerializer(it.next()));
        }
        FieldSerializer[] fieldSerializerArr = (FieldSerializer[]) arrayList.toArray(new FieldSerializer[arrayList.size()]);
        this.getters = fieldSerializerArr;
        String[] orders = jSONType != null ? jSONType.orders() : null;
        if (orders != null && orders.length != 0) {
            List<FieldInfo> computeGetters2 = TypeUtils.computeGetters(cls, i10, z10, jSONType, map, true, z12, z13, propertyNamingStrategy2);
            ArrayList arrayList2 = new ArrayList();
            Iterator<FieldInfo> it2 = computeGetters2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new FieldSerializer(it2.next()));
            }
            this.sortedGetters = (FieldSerializer[]) arrayList2.toArray(new FieldSerializer[arrayList2.size()]);
            return;
        }
        FieldSerializer[] fieldSerializerArr2 = new FieldSerializer[fieldSerializerArr.length];
        System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
        Arrays.sort(fieldSerializerArr2);
        if (Arrays.equals(fieldSerializerArr2, fieldSerializerArr)) {
            this.sortedGetters = fieldSerializerArr;
        } else {
            this.sortedGetters = fieldSerializerArr2;
        }
    }
}
