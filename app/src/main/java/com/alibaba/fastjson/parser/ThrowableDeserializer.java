package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r2) != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d3, code lost:
    
        if (r2 != null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d5, code lost:
    
        r3 = (T) new java.lang.Exception(r13, r12);
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x016f, code lost:
    
        if (r14 == null) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0171, code lost:
    
        ((java.lang.Throwable) r3).setStackTrace(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0174, code lost:
    
        if (r10 == null) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0176, code lost:
    
        if (r2 == null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x017a, code lost:
    
        if (r2 != r17.clazz) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x017c, code lost:
    
        r8 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x017e, code lost:
    
        r0 = r18.config.getDeserializer(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0186, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0188, code lost:
    
        r8 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x018b, code lost:
    
        if (r8 == null) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x018d, code lost:
    
        r0 = r10.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0199, code lost:
    
        if (r0.hasNext() == false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x019b, code lost:
    
        r2 = (java.util.Map.Entry) r0.next();
        r4 = (java.lang.String) r2.getKey();
        r2 = r2.getValue();
        r4 = r8.getFieldDeserializer(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01af, code lost:
    
        if (r4 == null) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b1, code lost:
    
        r4.setValue(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01b5, code lost:
    
        return (T) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dd, code lost:
    
        r3 = r2.getConstructors();
        r5 = r3.length;
        r6 = null;
        r8 = null;
        r9 = null;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e6, code lost:
    
        if (r11 >= r5) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e8, code lost:
    
        r15 = r3[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ef, code lost:
    
        if (r15.getParameterTypes().length != 0) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f1, code lost:
    
        r19 = r3;
        r16 = r5;
        r9 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0130, code lost:
    
        r11 = r11 + 1;
        r3 = r19;
        r5 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fd, code lost:
    
        r19 = r3;
        r16 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0104, code lost:
    
        if (r15.getParameterTypes().length != 1) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010d, code lost:
    
        if (r15.getParameterTypes()[0] != java.lang.String.class) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010f, code lost:
    
        r6 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x011a, code lost:
    
        if (r15.getParameterTypes().length != 2) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0123, code lost:
    
        if (r15.getParameterTypes()[0] != java.lang.String.class) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012c, code lost:
    
        if (r15.getParameterTypes()[1] != java.lang.Throwable.class) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012e, code lost:
    
        r8 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0137, code lost:
    
        if (r8 == null) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0139, code lost:
    
        r8 = (java.lang.Throwable) r8.newInstance(r13, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0149, code lost:
    
        r3 = (T) r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0168, code lost:
    
        if (r3 != null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x016a, code lost:
    
        r3 = (T) new java.lang.Exception(r13, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x014c, code lost:
    
        if (r6 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x014e, code lost:
    
        r8 = (java.lang.Throwable) r6.newInstance(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x015c, code lost:
    
        if (r9 == null) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x015e, code lost:
    
        r8 = null;
        r3 = (java.lang.Throwable) r9.newInstance(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0166, code lost:
    
        r8 = null;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0111, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01bd, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    @Override // com.alibaba.fastjson.parser.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r18, java.lang.reflect.Type r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
