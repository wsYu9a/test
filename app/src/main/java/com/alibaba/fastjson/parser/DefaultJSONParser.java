package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import m5.d;

/* loaded from: classes.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    protected ParseContext contex;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    protected List<ExtraProcessor> extraProcessors;
    protected List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public static class ResolveTask {
        private final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        private final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
    }

    public final void accept(int i10) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == i10) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i10) + ", actual " + JSONToken.name(this.lexer.token));
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.contex;
            this.resolveStatus = 0;
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public void checkMapResolve(Map map, Object obj) {
        ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
        ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            JSONLexer jSONLexer = this.lexer;
            if (jSONLexer.token == 20) {
                jSONLexer.close();
                return;
            }
            throw new JSONException("not close json text, token : " + JSONToken.name(this.lexer.token));
        } catch (Throwable th2) {
            this.lexer.close();
            throw th2;
        }
    }

    public void config(Feature feature, boolean z10) {
        this.lexer.config(feature, z10);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(r0.size() - 1);
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i10);
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                ParseContext parseContext = resolveTask.ownerContext;
                Object obj2 = null;
                Object obj3 = parseContext != null ? parseContext.object : null;
                String str = resolveTask.referenceValue;
                if (str.startsWith("$")) {
                    for (int i11 = 0; i11 < this.contextArrayIndex; i11++) {
                        if (str.equals(this.contextArray[i11].toString())) {
                            obj2 = this.contextArray[i11].object;
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class<?>) type2, (Collection) arrayList);
            return arrayList;
        }
        if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (!Object.class.equals(type3)) {
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class<?>) type3, (Collection) arrayList2);
                return arrayList2;
            }
            if (wildcardType.getLowerBounds().length == 0) {
                return parse();
            }
            throw new JSONException("not support type : " + type);
        }
        if (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 1) {
                throw new JSONException("not support : " + typeVariable);
            }
            Type type4 = bounds[0];
            if (type4 instanceof Class) {
                ArrayList arrayList3 = new ArrayList();
                parseArray((Class<?>) type4, (Collection) arrayList3);
                return arrayList3;
            }
        }
        if (type2 instanceof ParameterizedType) {
            ArrayList arrayList4 = new ArrayList();
            parseArray((ParameterizedType) type2, arrayList4);
            return arrayList4;
        }
        throw new JSONException("TODO : " + type);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0295, code lost:
    
        r5.setValue(r3, r4.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02a0, code lost:
    
        if (r3 != null) goto L1083;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02a4, code lost:
    
        if (r7 != java.lang.Cloneable.class) goto L1079;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02a6, code lost:
    
        r3 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02b2, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L1082;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02b4, code lost:
    
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02b9, code lost:
    
        r3 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02bd, code lost:
    
        if (r14 != false) goto L1085;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02bf, code lost:
    
        r19.contex = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02c1, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x029f, code lost:
    
        r3 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x029d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02c9, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02ca, code lost:
    
        r19.resolveStatus = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02cf, code lost:
    
        if (r19.contex == null) goto L1093;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02d3, code lost:
    
        if ((r21 instanceof java.lang.Integer) != false) goto L1093;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02d5, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02dc, code lost:
    
        if (r20.size() <= 0) goto L1099;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02de, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r20, (java.lang.Class<java.lang.Object>) r7, r19.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02e7, code lost:
    
        if (r14 != false) goto L1098;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02e9, code lost:
    
        r19.contex = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02eb, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02ec, code lost:
    
        r0 = r19.config.getDeserializer(r7);
        r2 = r0.deserialze(r19, r7, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02f8, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.MapDeserializer) == false) goto L1102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02fa, code lost:
    
        r19.resolveStatus = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02fd, code lost:
    
        if (r14 != false) goto L1104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02ff, code lost:
    
        r19.contex = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0301, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0255, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x025c, code lost:
    
        if (r4.token != 13) goto L1088;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x025e, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0261, code lost:
    
        r2 = r19.config.getDeserializer(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0269, code lost:
    
        if ((r2 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L1074;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x026b, code lost:
    
        r2 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r2;
        r3 = r2.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r19, r7);
        r0 = r20.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x027d, code lost:
    
        if (r0.hasNext() == false) goto L1364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x027f, code lost:
    
        r4 = (java.util.Map.Entry) r0.next();
        r5 = r4.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x028b, code lost:
    
        if ((r5 instanceof java.lang.String) == false) goto L1367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x028d, code lost:
    
        r5 = r2.getFieldDeserializer((java.lang.String) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0293, code lost:
    
        if (r5 == null) goto L1368;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03dc A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05a0 A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x05b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x04f8 A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0507 A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0510 A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0519 A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0522 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0514 A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0203 A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c7 A[Catch: all -> 0x0076, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0066, B:22:0x0070, B:26:0x007d, B:30:0x0090, B:32:0x009a, B:36:0x00a2, B:37:0x00c0, B:41:0x01c7, B:44:0x01da, B:60:0x01f9, B:63:0x0208, B:65:0x020e, B:67:0x0216, B:68:0x021f, B:70:0x0225, B:74:0x0232, B:79:0x023a, B:81:0x0248, B:85:0x0255, B:87:0x025e, B:89:0x0261, B:91:0x026b, B:92:0x0279, B:94:0x027f, B:97:0x028d, B:100:0x0295, B:109:0x02a6, B:110:0x02ac, B:112:0x02b4, B:113:0x02b9, B:120:0x02c2, B:121:0x02c9, B:122:0x02ca, B:124:0x02d1, B:126:0x02d5, B:127:0x02d8, B:129:0x02de, B:133:0x02ec, B:135:0x02fa, B:146:0x0309, B:149:0x0311, B:151:0x0318, B:153:0x0327, B:155:0x032f, B:158:0x0334, B:160:0x0338, B:161:0x0382, B:163:0x0386, B:167:0x0390, B:168:0x03a8, B:171:0x033b, B:173:0x0343, B:175:0x0349, B:176:0x0355, B:179:0x035e, B:183:0x0364, B:186:0x036a, B:187:0x0376, B:188:0x03a9, B:189:0x03c5, B:192:0x03ca, B:197:0x03dc, B:199:0x03e2, B:201:0x03ee, B:202:0x03f4, B:204:0x03f9, B:206:0x058d, B:210:0x0597, B:213:0x05a0, B:216:0x05b3, B:221:0x05ad, B:225:0x05bb, B:228:0x05ce, B:230:0x05d7, B:233:0x05ea, B:235:0x0632, B:239:0x05e4, B:242:0x05f5, B:245:0x0608, B:246:0x0602, B:249:0x0613, B:252:0x0626, B:253:0x0620, B:254:0x062d, B:255:0x05c8, B:256:0x063c, B:257:0x0654, B:258:0x03fd, B:263:0x0410, B:268:0x041c, B:271:0x0433, B:273:0x043c, B:276:0x0448, B:278:0x0452, B:279:0x0459, B:288:0x045d, B:285:0x0473, B:286:0x048b, B:292:0x0456, B:293:0x0445, B:294:0x042d, B:297:0x0490, B:300:0x04a3, B:302:0x04b4, B:305:0x04c8, B:306:0x04ce, B:309:0x04d4, B:310:0x04de, B:312:0x04e6, B:314:0x04f8, B:317:0x0500, B:318:0x0502, B:320:0x0507, B:322:0x0510, B:324:0x0519, B:325:0x051c, B:333:0x0522, B:335:0x0529, B:330:0x0536, B:331:0x054e, B:339:0x0514, B:344:0x04bf, B:345:0x049d, B:348:0x0555, B:350:0x0561, B:353:0x0574, B:355:0x0580, B:356:0x0655, B:358:0x0666, B:359:0x066a, B:367:0x0673, B:364:0x0685, B:365:0x069d, B:376:0x01d4, B:377:0x0203, B:439:0x00c8, B:442:0x00d9, B:446:0x00d3, B:382:0x00ec, B:384:0x00f6, B:385:0x00f9, B:389:0x00fe, B:390:0x0114, B:399:0x012b, B:401:0x0130, B:403:0x0135, B:405:0x0142, B:406:0x0146, B:410:0x014c, B:411:0x0164, B:412:0x013a, B:414:0x0165, B:415:0x017d, B:424:0x0187, B:427:0x0196, B:429:0x019c, B:430:0x01ba, B:431:0x01bb, B:433:0x069e, B:434:0x06b6, B:436:0x06b7, B:437:0x06cf), top: B:18:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r7v60, types: [java.util.Date] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 1749
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public String parseString() {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 != 4) {
            if (i10 == 2) {
                String numberString = jSONLexer.numberString();
                this.lexer.nextToken(16);
                return numberString;
            }
            Object parse = parse();
            if (parse == null) {
                return null;
            }
            return parse.toString();
        }
        String stringVal = jSONLexer.stringVal();
        JSONLexer jSONLexer2 = this.lexer;
        char c10 = jSONLexer2.f6309ch;
        char c11 = JSONLexer.EOI;
        if (c10 == ',') {
            int i11 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i11;
            if (i11 < jSONLexer2.len) {
                c11 = jSONLexer2.text.charAt(i11);
            }
            jSONLexer2.f6309ch = c11;
            this.lexer.token = 16;
        } else if (c10 == ']') {
            int i12 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i12;
            if (i12 < jSONLexer2.len) {
                c11 = jSONLexer2.text.charAt(i12);
            }
            jSONLexer2.f6309ch = c11;
            this.lexer.token = 15;
        } else if (c10 == '}') {
            int i13 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i13;
            if (i13 < jSONLexer2.len) {
                c11 = jSONLexer2.text.charAt(i13);
            }
            jSONLexer2.f6309ch = c11;
            this.lexer.token = 13;
        } else {
            jSONLexer2.nextToken();
        }
        return stringVal;
    }

    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i10 = this.contextArrayIndex;
        parseContextArr[i10 - 1] = null;
        this.contextArrayIndex = i10 - 1;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.disableCircularReferenceDetect) {
            return;
        }
        this.contex = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(new JSONLexer(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 2) {
            Number integerValue = jSONLexer.integerValue();
            this.lexer.nextToken();
            return integerValue;
        }
        if (i10 == 3) {
            Number decimalValue = jSONLexer.decimalValue((jSONLexer.features & Feature.UseBigDecimal.mask) != 0);
            this.lexer.nextToken();
            return decimalValue;
        }
        if (i10 == 4) {
            String stringVal = jSONLexer.stringVal();
            this.lexer.nextToken(16);
            if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                JSONLexer jSONLexer2 = new JSONLexer(stringVal);
                try {
                    if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                        return jSONLexer2.calendar.getTime();
                    }
                } finally {
                    jSONLexer2.close();
                }
            }
            return stringVal;
        }
        if (i10 == 12) {
            return parseObject((jSONLexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), obj);
        }
        if (i10 == 14) {
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONArray;
        }
        switch (i10) {
            case 6:
                jSONLexer.nextToken(16);
                return Boolean.TRUE;
            case 7:
                jSONLexer.nextToken(16);
                return Boolean.FALSE;
            case 8:
                break;
            case 9:
                jSONLexer.nextToken(18);
                JSONLexer jSONLexer3 = this.lexer;
                if (jSONLexer3.token != 18) {
                    throw new JSONException("syntax error, " + this.lexer.info());
                }
                jSONLexer3.nextToken(10);
                accept(10);
                long longValue = this.lexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new Date(longValue);
            default:
                switch (i10) {
                    case 20:
                        if (jSONLexer.isBlankInput()) {
                            return null;
                        }
                        throw new JSONException("syntax error, " + this.lexer.info());
                    case 21:
                        jSONLexer.nextToken();
                        HashSet hashSet = new HashSet();
                        parseArray(hashSet, obj);
                        return hashSet;
                    case 22:
                        jSONLexer.nextToken();
                        TreeSet treeSet = new TreeSet();
                        parseArray(treeSet, obj);
                        return treeSet;
                    case 23:
                        break;
                    default:
                        throw new JSONException("syntax error, " + this.lexer.info());
                }
        }
        jSONLexer.nextToken();
        return null;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i10) {
        this(new JSONLexer(str, i10), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new ParseContext(parseContext, obj, obj2);
        int i10 = this.contextArrayIndex;
        this.contextArrayIndex = i10 + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i10 >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        ParseContext[] parseContextArr3 = this.contextArray;
        ParseContext parseContext2 = this.contex;
        parseContextArr3[i10] = parseContext2;
        return parseContext2;
    }

    public DefaultJSONParser(char[] cArr, int i10, ParserConfig parserConfig, int i11) {
        this(new JSONLexer(cArr, i10, i11), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.global);
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        String str;
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 21 || i10 == 22) {
            jSONLexer.nextToken();
        }
        JSONLexer jSONLexer2 = this.lexer;
        if (jSONLexer2.token == 14) {
            if (Integer.TYPE == type) {
                deserializer = IntegerCodec.instance;
                jSONLexer2.nextToken(2);
            } else if (String.class == type) {
                deserializer = StringCodec.instance;
                jSONLexer2.nextToken(4);
            } else {
                deserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(12);
            }
            ParseContext parseContext = this.contex;
            if (!this.lexer.disableCircularReferenceDetect) {
                setContext(parseContext, collection, obj);
            }
            int i11 = 0;
            while (true) {
                try {
                    JSONLexer jSONLexer3 = this.lexer;
                    int i12 = jSONLexer3.token;
                    if (i12 == 16) {
                        jSONLexer3.nextToken();
                    } else {
                        if (i12 == 15) {
                            this.contex = parseContext;
                            jSONLexer3.nextToken(16);
                            return;
                        }
                        Object obj2 = null;
                        String obj3 = null;
                        if (Integer.TYPE == type) {
                            collection.add(IntegerCodec.instance.deserialze(this, null, null));
                        } else if (String.class == type) {
                            if (i12 == 4) {
                                str = jSONLexer3.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    obj3 = parse.toString();
                                }
                                str = obj3;
                            }
                            collection.add(str);
                        } else {
                            if (i12 == 8) {
                                jSONLexer3.nextToken();
                            } else {
                                obj2 = deserializer.deserialze(this, type, Integer.valueOf(i11));
                            }
                            collection.add(obj2);
                            if (this.resolveStatus == 1) {
                                checkListResolve(collection);
                            }
                        }
                        JSONLexer jSONLexer4 = this.lexer;
                        if (jSONLexer4.token == 16) {
                            jSONLexer4.nextToken();
                        }
                        i11++;
                    }
                } catch (Throwable th2) {
                    this.contex = parseContext;
                    throw th2;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token) + ", " + this.lexer.info());
        }
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c10 = jSONLexer.f6309ch;
        char c11 = JSONLexer.EOI;
        if (c10 == '{') {
            int i10 = jSONLexer.bp + 1;
            jSONLexer.bp = i10;
            jSONLexer.f6309ch = i10 < jSONLexer.len ? jSONLexer.text.charAt(i10) : c11;
            jSONLexer.token = 12;
            return;
        }
        if (c10 == '[') {
            int i11 = jSONLexer.bp + 1;
            jSONLexer.bp = i11;
            jSONLexer.f6309ch = i11 < jSONLexer.len ? jSONLexer.text.charAt(i11) : c11;
            jSONLexer.token = 14;
            return;
        }
        jSONLexer.nextToken();
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z10;
        int i10;
        JSONLexer jSONLexer = this.lexer;
        int i11 = jSONLexer.token;
        int i12 = 8;
        if (i11 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i11 != 14) {
            throw new JSONException("syntax error, " + this.lexer.info());
        }
        Object[] objArr = new Object[typeArr.length];
        if (typeArr.length == 0) {
            jSONLexer.nextToken(15);
            JSONLexer jSONLexer2 = this.lexer;
            if (jSONLexer2.token != 15) {
                throw new JSONException("syntax error, " + this.lexer.info());
            }
            jSONLexer2.nextToken(16);
            return new Object[0];
        }
        jSONLexer.nextToken(2);
        int i13 = 0;
        while (i13 < typeArr.length) {
            JSONLexer jSONLexer3 = this.lexer;
            int i14 = jSONLexer3.token;
            if (i14 == i12) {
                jSONLexer3.nextToken(16);
                cast = null;
            } else {
                Type type = typeArr[i13];
                if (type == Integer.TYPE || type == Integer.class) {
                    if (i14 == 2) {
                        cast = Integer.valueOf(jSONLexer3.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                } else if (type != String.class) {
                    if (i13 == typeArr.length - 1 && (type instanceof Class)) {
                        Class cls2 = (Class) type;
                        z10 = cls2.isArray();
                        cls = cls2.getComponentType();
                    } else {
                        cls = null;
                        z10 = false;
                    }
                    if (z10 && this.lexer.token != 14) {
                        ArrayList arrayList = new ArrayList();
                        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                        if (this.lexer.token != 15) {
                            while (true) {
                                arrayList.add(deserializer.deserialze(this, type, null));
                                JSONLexer jSONLexer4 = this.lexer;
                                i10 = jSONLexer4.token;
                                if (i10 != 16) {
                                    break;
                                }
                                jSONLexer4.nextToken(12);
                            }
                            if (i10 != 15) {
                                throw new JSONException("syntax error, " + this.lexer.info());
                            }
                        }
                        cast = TypeUtils.cast(arrayList, type, this.config);
                    } else {
                        cast = this.config.getDeserializer(type).deserialze(this, type, null);
                    }
                } else if (i14 == 4) {
                    cast = jSONLexer3.stringVal();
                    this.lexer.nextToken(16);
                } else {
                    cast = TypeUtils.cast(parse(), type, this.config);
                }
            }
            objArr[i13] = cast;
            JSONLexer jSONLexer5 = this.lexer;
            int i15 = jSONLexer5.token;
            if (i15 == 15) {
                break;
            }
            if (i15 != 16) {
                throw new JSONException("syntax error, " + this.lexer.info());
            }
            if (i13 == typeArr.length - 1) {
                jSONLexer5.nextToken(15);
            } else {
                jSONLexer5.nextToken(2);
            }
            i13++;
            i12 = 8;
        }
        JSONLexer jSONLexer6 = this.lexer;
        if (jSONLexer6.token != 15) {
            throw new JSONException("syntax error, " + this.lexer.info());
        }
        jSONLexer6.nextToken(16);
        return objArr;
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0231 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d9 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004e, B:24:0x0060, B:28:0x007e, B:30:0x0084, B:32:0x0090, B:35:0x00a2, B:37:0x00ab, B:42:0x00b3, B:43:0x009c, B:47:0x00bc, B:50:0x00ce, B:52:0x00d7, B:53:0x00da, B:58:0x00c8, B:45:0x00e4, B:59:0x00e7, B:61:0x00ed, B:83:0x011c, B:85:0x01e7, B:87:0x01ee, B:88:0x01f1, B:90:0x01f7, B:92:0x01fb, B:98:0x020b, B:102:0x0217, B:105:0x022b, B:107:0x0225, B:108:0x022e, B:112:0x0124, B:117:0x012e, B:118:0x013b, B:120:0x0143, B:121:0x014a, B:122:0x014b, B:124:0x0158, B:125:0x0168, B:126:0x0163, B:127:0x0171, B:128:0x0179, B:129:0x0183, B:130:0x018d, B:132:0x01a5, B:134:0x01b0, B:135:0x01b6, B:136:0x01bb, B:138:0x01c8, B:139:0x01d3, B:140:0x01ce, B:141:0x01d9, B:142:0x005a, B:143:0x0067, B:144:0x006c, B:147:0x0077), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004e, B:24:0x0060, B:28:0x007e, B:30:0x0084, B:32:0x0090, B:35:0x00a2, B:37:0x00ab, B:42:0x00b3, B:43:0x009c, B:47:0x00bc, B:50:0x00ce, B:52:0x00d7, B:53:0x00da, B:58:0x00c8, B:45:0x00e4, B:59:0x00e7, B:61:0x00ed, B:83:0x011c, B:85:0x01e7, B:87:0x01ee, B:88:0x01f1, B:90:0x01f7, B:92:0x01fb, B:98:0x020b, B:102:0x0217, B:105:0x022b, B:107:0x0225, B:108:0x022e, B:112:0x0124, B:117:0x012e, B:118:0x013b, B:120:0x0143, B:121:0x014a, B:122:0x014b, B:124:0x0158, B:125:0x0168, B:126:0x0163, B:127:0x0171, B:128:0x0179, B:129:0x0183, B:130:0x018d, B:132:0x01a5, B:134:0x01b0, B:135:0x01b6, B:136:0x01bb, B:138:0x01c8, B:139:0x01d3, B:140:0x01ce, B:141:0x01d9, B:142:0x005a, B:143:0x0067, B:144:0x006c, B:147:0x0077), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ed A[Catch: all -> 0x0049, LOOP:1: B:60:0x00eb->B:61:0x00ed, LOOP_END, TryCatch #0 {all -> 0x0049, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004e, B:24:0x0060, B:28:0x007e, B:30:0x0084, B:32:0x0090, B:35:0x00a2, B:37:0x00ab, B:42:0x00b3, B:43:0x009c, B:47:0x00bc, B:50:0x00ce, B:52:0x00d7, B:53:0x00da, B:58:0x00c8, B:45:0x00e4, B:59:0x00e7, B:61:0x00ed, B:83:0x011c, B:85:0x01e7, B:87:0x01ee, B:88:0x01f1, B:90:0x01f7, B:92:0x01fb, B:98:0x020b, B:102:0x0217, B:105:0x022b, B:107:0x0225, B:108:0x022e, B:112:0x0124, B:117:0x012e, B:118:0x013b, B:120:0x0143, B:121:0x014a, B:122:0x014b, B:124:0x0158, B:125:0x0168, B:126:0x0163, B:127:0x0171, B:128:0x0179, B:129:0x0183, B:130:0x018d, B:132:0x01a5, B:134:0x01b0, B:135:0x01b6, B:136:0x01bb, B:138:0x01c8, B:139:0x01d3, B:140:0x01ce, B:141:0x01d9, B:142:0x005a, B:143:0x0067, B:144:0x006c, B:147:0x0077), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ee A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004e, B:24:0x0060, B:28:0x007e, B:30:0x0084, B:32:0x0090, B:35:0x00a2, B:37:0x00ab, B:42:0x00b3, B:43:0x009c, B:47:0x00bc, B:50:0x00ce, B:52:0x00d7, B:53:0x00da, B:58:0x00c8, B:45:0x00e4, B:59:0x00e7, B:61:0x00ed, B:83:0x011c, B:85:0x01e7, B:87:0x01ee, B:88:0x01f1, B:90:0x01f7, B:92:0x01fb, B:98:0x020b, B:102:0x0217, B:105:0x022b, B:107:0x0225, B:108:0x022e, B:112:0x0124, B:117:0x012e, B:118:0x013b, B:120:0x0143, B:121:0x014a, B:122:0x014b, B:124:0x0158, B:125:0x0168, B:126:0x0163, B:127:0x0171, B:128:0x0179, B:129:0x0183, B:130:0x018d, B:132:0x01a5, B:134:0x01b0, B:135:0x01b6, B:136:0x01bb, B:138:0x01c8, B:139:0x01d3, B:140:0x01ce, B:141:0x01d9, B:142:0x005a, B:143:0x0067, B:144:0x006c, B:147:0x0077), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f7 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004e, B:24:0x0060, B:28:0x007e, B:30:0x0084, B:32:0x0090, B:35:0x00a2, B:37:0x00ab, B:42:0x00b3, B:43:0x009c, B:47:0x00bc, B:50:0x00ce, B:52:0x00d7, B:53:0x00da, B:58:0x00c8, B:45:0x00e4, B:59:0x00e7, B:61:0x00ed, B:83:0x011c, B:85:0x01e7, B:87:0x01ee, B:88:0x01f1, B:90:0x01f7, B:92:0x01fb, B:98:0x020b, B:102:0x0217, B:105:0x022b, B:107:0x0225, B:108:0x022e, B:112:0x0124, B:117:0x012e, B:118:0x013b, B:120:0x0143, B:121:0x014a, B:122:0x014b, B:124:0x0158, B:125:0x0168, B:126:0x0163, B:127:0x0171, B:128:0x0179, B:129:0x0183, B:130:0x018d, B:132:0x01a5, B:134:0x01b0, B:135:0x01b6, B:136:0x01bb, B:138:0x01c8, B:139:0x01d3, B:140:0x01ce, B:141:0x01d9, B:142:0x005a, B:143:0x0067, B:144:0x006c, B:147:0x0077), top: B:10:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void parseArray(java.util.Collection r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(java.util.Collection, java.lang.Object):void");
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type, Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i10 == 4) {
            if (type == byte[].class) {
                T t10 = (T) jSONLexer.bytesValue();
                this.lexer.nextToken();
                return t10;
            }
            if (type == char[].class) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        int i10 = this.lexer.token;
        if (i10 != 12 && i10 != 16) {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i10));
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                JSONLexer jSONLexer = this.lexer;
                int i11 = jSONLexer.token;
                if (i11 == 13) {
                    jSONLexer.nextToken(16);
                    return;
                } else if (i11 == 16) {
                    continue;
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                JSONLexer jSONLexer2 = this.lexer;
                if ((jSONLexer2.features & Feature.IgnoreNotMatch.mask) != 0) {
                    jSONLexer2.nextTokenWithChar(d.f28378d);
                    parse();
                    JSONLexer jSONLexer3 = this.lexer;
                    if (jSONLexer3.token == 13) {
                        jSONLexer3.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithChar(d.f28378d);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithChar(d.f28378d);
                    deserialze = parseString();
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithChar(d.f28378d);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithChar(d.f28378d);
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                JSONLexer jSONLexer4 = this.lexer;
                int i12 = jSONLexer4.token;
                if (i12 != 16 && i12 == 13) {
                    jSONLexer4.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), (Object) null);
    }
}
