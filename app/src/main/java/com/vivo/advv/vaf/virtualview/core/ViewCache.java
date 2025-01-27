package com.vivo.advv.vaf.virtualview.core;

import android.view.View;
import com.vivo.advv.TextUtils;
import com.vivo.advv.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ViewCache {
    private static final String TAG = "ViewCache_TMTEST";
    private Object mComponentData;
    private View mHoldView;
    private List<ViewBase> mCacheView = new ArrayList();
    private ConcurrentHashMap<ViewBase, List<Item>> mCacheItem = new ConcurrentHashMap<>();

    public static class Item {
        private static final Object EMPTY = new Object();
        public static final String FLAG_INVALIDATE = "_flag_invalidate_";
        protected static final String RP = "rp";
        public static final int TYPE_BOOLEAN = 4;
        public static final int TYPE_COLOR = 3;
        public static final int TYPE_FLOAT = 1;
        public static final int TYPE_GRAVITY = 6;
        public static final int TYPE_INT = 0;
        public static final int TYPE_OBJECT = 7;
        public static final int TYPE_STRING = 2;
        public static final int TYPE_TEXT_STYLE = 8;
        public static final int TYPE_VISIBILITY = 5;
        private ConcurrentHashMap<Integer, Object> cacheTargetValue;
        public String mAttrEL;
        public int mKey;
        private Parser mParser;
        private int mValueType;
        public ViewBase mView;

        public Item(ViewBase viewBase) {
            this(viewBase, 0);
        }

        public void bind(Object obj, boolean z) {
            Object obj2 = this.cacheTargetValue.get(Integer.valueOf(obj.hashCode()));
            if (obj2 == null) {
                obj2 = this.mParser.getValueFromEL(obj);
                if (obj2 == null) {
                    obj2 = EMPTY;
                    this.mView.onFailGetValueFromEl(this.mKey, this.mAttrEL);
                } else {
                    String utils = Utils.toString(obj2);
                    int i2 = this.mValueType;
                    if (i2 == 3) {
                        obj2 = Integer.valueOf(Utils.parseColor(utils));
                    } else if (i2 == 8) {
                        String[] split = utils.split("\\|");
                        int i3 = 0;
                        for (String str : split) {
                            String trim = str.trim();
                            if (TextUtils.equals("bold", trim)) {
                                i3 |= 1;
                            } else if (TextUtils.equals("italic", trim)) {
                                i3 |= 2;
                            } else if (TextUtils.equals("styleStrike", trim)) {
                                i3 |= 8;
                            }
                        }
                        obj2 = Integer.valueOf(i3);
                    } else if (i2 == 5) {
                        obj2 = "invisible".equals(utils) ? 0 : "gone".equals(utils) ? 2 : 1;
                    } else if (i2 == 6) {
                        String[] split2 = utils.split("\\|");
                        int i4 = 0;
                        for (String str2 : split2) {
                            String trim2 = str2.trim();
                            if (TextUtils.equals("left", trim2)) {
                                i4 |= 1;
                            } else if (TextUtils.equals("right", trim2)) {
                                i4 |= 2;
                            } else if (TextUtils.equals("h_center", trim2)) {
                                i4 |= 4;
                            } else if (TextUtils.equals("top", trim2)) {
                                i4 |= 8;
                            } else if (TextUtils.equals("bottom", trim2)) {
                                i4 |= 16;
                            } else {
                                if (!TextUtils.equals("v_center", trim2)) {
                                    if (!TextUtils.equals("center", trim2)) {
                                        break;
                                    } else {
                                        i4 |= 4;
                                    }
                                }
                                i4 |= 32;
                            }
                        }
                        obj2 = Integer.valueOf(i4);
                    }
                }
                this.cacheTargetValue.put(Integer.valueOf(obj.hashCode()), obj2);
            }
            if (obj2 != EMPTY) {
                switch (this.mValueType) {
                    case 0:
                        if (obj2 instanceof Number) {
                            Integer integer = Utils.toInteger(obj2);
                            if (integer != null) {
                                this.mView.setAttribute(this.mKey, integer.intValue());
                                break;
                            }
                        } else {
                            String obj3 = obj2.toString();
                            if (obj3.endsWith(RP)) {
                                Integer integer2 = Utils.toInteger(obj3.substring(0, obj3.length() - 2));
                                if (integer2 != null) {
                                    this.mView.setRPAttribute(this.mKey, integer2.intValue());
                                    break;
                                }
                            } else {
                                Integer integer3 = Utils.toInteger(obj2);
                                if (integer3 != null) {
                                    this.mView.setAttribute(this.mKey, integer3.intValue());
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        if (obj2 instanceof Number) {
                            Float f2 = Utils.toFloat(obj2);
                            if (f2 != null) {
                                this.mView.setAttribute(this.mKey, f2.floatValue());
                                break;
                            }
                        } else {
                            String obj4 = obj2.toString();
                            if (obj4.endsWith(RP)) {
                                Float f3 = Utils.toFloat(obj4.substring(0, obj4.length() - 2));
                                if (f3 != null) {
                                    this.mView.setRPAttribute(this.mKey, f3.floatValue());
                                    break;
                                }
                            } else {
                                Float f4 = Utils.toFloat(obj2);
                                if (f4 != null) {
                                    this.mView.setAttribute(this.mKey, f4.floatValue());
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        this.mView.setAttribute(this.mKey, Utils.toString(obj2));
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                        Integer integer4 = Utils.toInteger(obj2);
                        if (integer4 != null) {
                            this.mView.setAttribute(this.mKey, integer4.intValue());
                            break;
                        }
                        break;
                    case 4:
                        Boolean bool = Utils.toBoolean(obj2);
                        if (bool != null) {
                            this.mView.setAttribute(this.mKey, bool.booleanValue() ? 1 : 0);
                            break;
                        } else {
                            this.mView.setAttribute(this.mKey, 0);
                            break;
                        }
                    case 7:
                        if (!this.mView.setAttribute(this.mKey, obj2)) {
                            if (z) {
                                this.mView.appendData(obj2);
                                break;
                            } else {
                                this.mView.setData(obj2);
                                break;
                            }
                        }
                        break;
                }
            }
        }

        public void clear() {
            this.cacheTargetValue.clear();
        }

        public void invalidate(int i2) {
            this.cacheTargetValue.remove(Integer.valueOf(i2));
        }

        public Item(ViewBase viewBase, int i2) {
            this.cacheTargetValue = new ConcurrentHashMap<>();
            this.mValueType = 0;
            this.mView = viewBase;
            this.mKey = i2;
        }

        public Item(ViewBase viewBase, int i2, String str, int i3) {
            this.cacheTargetValue = new ConcurrentHashMap<>();
            this.mValueType = 0;
            this.mView = viewBase;
            this.mKey = i2;
            this.mAttrEL = str;
            this.mValueType = i3;
            if (str != null) {
                if (Utils.isThreeUnknown(str)) {
                    ThreeUnknownELParser threeUnknownELParser = new ThreeUnknownELParser();
                    this.mParser = threeUnknownELParser;
                    threeUnknownELParser.compile(this.mAttrEL);
                } else {
                    SimpleELParser simpleELParser = new SimpleELParser();
                    this.mParser = simpleELParser;
                    simpleELParser.compile(this.mAttrEL);
                }
            }
        }
    }

    private interface Parser {
        boolean compile(String str);

        String getValue();

        Object getValueFromEL(Object obj);
    }

    private static class ThreeUnknownELParser implements Parser {
        private static final char AT = '@';
        private static final char COLON = ':';
        private static final char LEFT_BRACE = '{';
        private static final char QUESTION = '?';
        private static final char RIGHT_BRACE = '}';
        private static final int STATE_CONDITION = 1;
        private static final int STATE_RESULT_1 = 2;
        private static final int STATE_RESULT_2 = 3;
        private SimpleELParser condition;
        private SimpleELParser result1;
        private SimpleELParser result2;
        private int state;
        private String value;

        private ThreeUnknownELParser() {
        }

        @Override // com.vivo.advv.vaf.virtualview.core.ViewCache.Parser
        public boolean compile(String str) {
            if (str != null && str.length() != 0) {
                this.value = str;
                int length = str.length();
                if (str.charAt(0) == '@' && str.charAt(1) == '{') {
                    int i2 = length - 1;
                    if (str.charAt(i2) == '}') {
                        StringBuilder sb = new StringBuilder();
                        this.state = 1;
                        for (int i3 = 2; i3 < i2; i3++) {
                            char charAt = str.charAt(i3);
                            if (charAt != ':') {
                                if (charAt != '?') {
                                    sb.append(charAt);
                                } else if (this.state == 1) {
                                    SimpleELParser simpleELParser = new SimpleELParser();
                                    this.condition = simpleELParser;
                                    simpleELParser.compile(sb.toString().trim());
                                    sb.delete(0, sb.length());
                                    this.state = 2;
                                }
                            } else if (this.state == 2) {
                                SimpleELParser simpleELParser2 = new SimpleELParser();
                                this.result1 = simpleELParser2;
                                simpleELParser2.compile(sb.toString().trim());
                                sb.delete(0, sb.length());
                                this.state = 3;
                            }
                        }
                        if (this.state == 3) {
                            SimpleELParser simpleELParser3 = new SimpleELParser();
                            this.result2 = simpleELParser3;
                            simpleELParser3.compile(sb.toString().trim());
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.ViewCache.Parser
        public String getValue() {
            return this.value;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        
            if (java.lang.String.valueOf(r4).equals(java.lang.String.valueOf(r0)) != false) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
        
            if (com.vivo.advv.TextUtils.equals(r0.toLowerCase(), "false") != false) goto L73;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00bc  */
        @Override // com.vivo.advv.vaf.virtualview.core.ViewCache.Parser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object getValueFromEL(java.lang.Object r8) {
            /*
                r7 = this;
                com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser r0 = r7.condition
                r1 = 0
                if (r0 == 0) goto Lc3
                com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser r2 = r7.result1
                if (r2 == 0) goto Lc3
                com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser r2 = r7.result2
                if (r2 == 0) goto Lc3
                if (r8 == 0) goto Lc5
                java.lang.Object r0 = r0.getValueFromEL(r8)
                r2 = 1
                r3 = 0
                if (r0 != 0) goto L18
                goto L31
            L18:
                boolean r4 = r0 instanceof java.lang.Boolean
                if (r4 == 0) goto L24
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r2 = r0.booleanValue()
                goto Lb3
            L24:
                boolean r4 = r0 instanceof java.lang.String
                if (r4 == 0) goto L8f
                r4 = r0
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r5 = com.vivo.advv.TextUtils.isEmpty(r4)
                if (r5 == 0) goto L34
            L31:
                r2 = 0
                goto Lb3
            L34:
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r5 = "=="
                boolean r6 = r0.contains(r5)
                if (r6 == 0) goto L79
                com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser r4 = new com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser
                r4.<init>()
                int r6 = r0.indexOf(r5)
                java.lang.String r6 = r0.substring(r3, r6)
                r4.compile(r6)
                java.lang.Object r4 = r4.getValueFromEL(r8)
                com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser r6 = new com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser
                r6.<init>()
                int r1 = r0.indexOf(r5)
                int r1 = r1 + 2
                java.lang.String r0 = r0.substring(r1)
                r6.compile(r0)
                java.lang.Object r0 = r6.getValueFromEL(r8)
                if (r4 == 0) goto L31
                java.lang.String r1 = java.lang.String.valueOf(r4)
                java.lang.String r0 = java.lang.String.valueOf(r0)
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L31
                goto Lb3
            L79:
                java.lang.String r1 = "null"
                boolean r1 = com.vivo.advv.TextUtils.equals(r4, r1)
                if (r1 == 0) goto L82
                goto Lb1
            L82:
                java.lang.String r0 = r0.toLowerCase()
                java.lang.String r1 = "false"
                boolean r0 = com.vivo.advv.TextUtils.equals(r0, r1)
                if (r0 == 0) goto Lb3
                goto Lb1
            L8f:
                boolean r1 = r0 instanceof org.json.JSONObject
                if (r1 == 0) goto L9c
                org.json.JSONObject r0 = (org.json.JSONObject) r0
                int r0 = r0.length()
                if (r0 != 0) goto Lb3
                goto Lb1
            L9c:
                boolean r1 = r0 instanceof org.json.JSONArray
                if (r1 == 0) goto La9
                org.json.JSONArray r0 = (org.json.JSONArray) r0
                int r0 = r0.length()
                if (r0 != 0) goto Lb3
                goto Lb1
            La9:
                java.lang.Object r1 = org.json.JSONObject.NULL
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto Lb3
            Lb1:
                goto L31
            Lb3:
                if (r2 == 0) goto Lbc
                com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser r0 = r7.result1
                java.lang.Object r1 = r0.getValueFromEL(r8)
                goto Lc5
            Lbc:
                com.vivo.advv.vaf.virtualview.core.ViewCache$SimpleELParser r0 = r7.result2
                java.lang.Object r1 = r0.getValueFromEL(r8)
                goto Lc5
            Lc3:
                java.lang.String r1 = r7.value
            Lc5:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.core.ViewCache.ThreeUnknownELParser.getValueFromEL(java.lang.Object):java.lang.Object");
        }

        /* synthetic */ ThreeUnknownELParser(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static int parseInt(String str) {
        return parseInt(str, 10);
    }

    public void destroy() {
        List<ViewBase> list = this.mCacheView;
        if (list != null) {
            list.clear();
            this.mCacheView = null;
        }
        ConcurrentHashMap<ViewBase, List<Item>> concurrentHashMap = this.mCacheItem;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<ViewBase, List<Item>>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                List<Item> value = it.next().getValue();
                if (value != null) {
                    int size = value.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        value.get(i2).clear();
                    }
                }
            }
            this.mCacheItem.clear();
            this.mCacheItem = null;
        }
    }

    public List<Item> getCacheItem(ViewBase viewBase) {
        return this.mCacheItem.get(viewBase);
    }

    public List<ViewBase> getCacheView() {
        return this.mCacheView;
    }

    public Object getComponentData() {
        return this.mComponentData;
    }

    public View getHolderView() {
        return this.mHoldView;
    }

    public void put(ViewBase viewBase) {
        put(viewBase, 0, null, 0);
    }

    public void setComponentData(Object obj) {
        this.mComponentData = obj;
    }

    public void setHoldView(View view) {
        this.mHoldView = view;
    }

    private static class SimpleELParser implements Parser {
        private static final char ARRAY_END = ']';
        private static final char ARRAY_START = '[';
        private static final char DOLLAR = '$';
        private static final char DOT = '.';
        private static final char LEFT_BRACE = '{';
        private static final char RIGHT_BRACE = '}';
        private static final int STATE_ARRAY_END = 4;
        private static final int STATE_ARRAY_START = 3;
        private static final int STATE_COMMON = 2;
        private List<Object> exprFragment;
        private int state;
        private String value;

        private SimpleELParser() {
            this.exprFragment = new LinkedList();
        }

        @Override // com.vivo.advv.vaf.virtualview.core.ViewCache.Parser
        public boolean compile(String str) {
            if (str != null && str.length() != 0) {
                this.value = str;
                int length = str.length();
                this.exprFragment.clear();
                if (str.charAt(0) == '$' && str.charAt(1) == '{') {
                    int i2 = length - 1;
                    if (str.charAt(i2) == '}') {
                        StringBuilder sb = new StringBuilder();
                        this.state = 2;
                        for (int i3 = 2; i3 < i2; i3++) {
                            char charAt = str.charAt(i3);
                            if (charAt == '.') {
                                int i4 = this.state;
                                if (i4 == 3) {
                                    sb.append(charAt);
                                } else if (i4 == 4) {
                                    this.state = 2;
                                } else {
                                    String sb2 = sb.toString();
                                    int parseInt = ViewCache.parseInt(sb2);
                                    if (parseInt != Integer.MIN_VALUE) {
                                        this.exprFragment.add(Integer.valueOf(parseInt));
                                    } else {
                                        this.exprFragment.add(sb2);
                                    }
                                    sb.delete(0, sb.length());
                                }
                            } else if (charAt == '[') {
                                if (this.state != 2) {
                                    return false;
                                }
                                if (sb.length() > 0) {
                                    String sb3 = sb.toString();
                                    int parseInt2 = ViewCache.parseInt(sb3);
                                    if (parseInt2 != Integer.MIN_VALUE) {
                                        this.exprFragment.add(Integer.valueOf(parseInt2));
                                    } else {
                                        this.exprFragment.add(sb3);
                                    }
                                    sb.delete(0, sb.length());
                                }
                                this.state = 3;
                            } else if (charAt != ']') {
                                sb.append(charAt);
                            } else {
                                if (this.state != 3) {
                                    return false;
                                }
                                String sb4 = sb.toString();
                                int parseInt3 = Integer.parseInt(sb4);
                                if (parseInt3 != Integer.MIN_VALUE) {
                                    this.exprFragment.add(Integer.valueOf(parseInt3));
                                } else {
                                    this.exprFragment.add(sb4);
                                }
                                sb.delete(0, sb.length());
                                this.state = 4;
                            }
                        }
                        if (this.state == 2) {
                            String sb5 = sb.toString();
                            int parseInt4 = ViewCache.parseInt(sb5);
                            if (parseInt4 != Integer.MIN_VALUE) {
                                this.exprFragment.add(Integer.valueOf(parseInt4));
                            } else {
                                this.exprFragment.add(sb5);
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.ViewCache.Parser
        public String getValue() {
            return this.value;
        }

        @Override // com.vivo.advv.vaf.virtualview.core.ViewCache.Parser
        public Object getValueFromEL(Object obj) {
            Object obj2 = null;
            if (this.exprFragment.size() <= 0) {
                return this.value;
            }
            if (obj == null) {
                return null;
            }
            int i2 = 0;
            int size = this.exprFragment.size();
            while (i2 < size) {
                Object obj3 = this.exprFragment.get(i2);
                if (obj3 instanceof String) {
                    String obj4 = obj3.toString();
                    if (!obj4.equalsIgnoreCase("this")) {
                        if (!(obj instanceof JSONObject)) {
                            return obj2;
                        }
                        obj = ((JSONObject) obj).opt(obj4);
                    }
                } else if (!(obj3 instanceof Integer)) {
                    continue;
                    i2++;
                    obj = obj2;
                } else {
                    if (!(obj instanceof JSONArray)) {
                        return obj2;
                    }
                    obj = ((JSONArray) obj).opt(((Integer) obj3).intValue());
                }
                obj2 = obj;
                i2++;
                obj = obj2;
            }
            return obj2;
        }

        /* synthetic */ SimpleELParser(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static int parseInt(String str, int i2) {
        boolean z;
        int i3;
        if (str == null || i2 < 2 || i2 > 36) {
            return Integer.MIN_VALUE;
        }
        int length = str.length();
        int i4 = -2147483647;
        if (length <= 0) {
            return Integer.MIN_VALUE;
        }
        int i5 = 0;
        char charAt = str.charAt(0);
        int i6 = 1;
        if (charAt < '0') {
            if (charAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (charAt != '+') {
                    return Integer.MIN_VALUE;
                }
                z = false;
            }
            if (length == 1) {
                return Integer.MIN_VALUE;
            }
        } else {
            z = false;
            i6 = 0;
        }
        int i7 = i4 / i2;
        while (i6 < length) {
            int i8 = i6 + 1;
            int digit = Character.digit(str.charAt(i6), i2);
            if (digit < 0 || i5 < i7 || (i3 = i5 * i2) < i4 + digit) {
                return Integer.MIN_VALUE;
            }
            i5 = i3 - digit;
            i6 = i8;
        }
        return z ? i5 : -i5;
    }

    public void put(ViewBase viewBase, int i2, String str, int i3) {
        List<Item> list = this.mCacheItem.get(viewBase);
        if (list == null) {
            list = new ArrayList<>();
            this.mCacheItem.put(viewBase, list);
            this.mCacheView.add(viewBase);
        }
        list.add(new Item(viewBase, i2, str, i3));
    }
}
