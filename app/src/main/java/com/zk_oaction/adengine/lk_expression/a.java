package com.zk_oaction.adengine.lk_expression;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;
import kotlin.text.Typography;

/* loaded from: classes5.dex */
public class a implements com.zk_oaction.adengine.lk_variable.f {

    /* renamed from: a */
    private static final char[][] f34836a = {new char[]{Typography.greater, Typography.greater, Typography.less, Typography.less, Typography.less, Typography.less, Typography.greater, Typography.greater}, new char[]{Typography.greater, Typography.greater, Typography.less, Typography.less, Typography.less, Typography.less, Typography.greater, Typography.greater}, new char[]{Typography.greater, Typography.greater, Typography.greater, Typography.greater, Typography.greater, Typography.less, Typography.greater, Typography.greater}, new char[]{Typography.greater, Typography.greater, Typography.greater, Typography.greater, Typography.greater, Typography.less, Typography.greater, Typography.greater}, new char[]{Typography.greater, Typography.greater, Typography.greater, Typography.greater, Typography.greater, Typography.less, Typography.greater, Typography.greater}, new char[]{Typography.less, Typography.less, Typography.less, Typography.less, Typography.less, Typography.less, '=', '!'}, new char[]{Typography.greater, Typography.greater, Typography.greater, Typography.greater, Typography.greater, '!', Typography.greater, Typography.greater}, new char[]{Typography.less, Typography.less, Typography.less, Typography.less, Typography.less, Typography.less, '!', '='}};

    /* renamed from: b */
    private static HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float>> f34837b;

    /* renamed from: c */
    public String f34838c;

    /* renamed from: d */
    public String f34839d;

    /* renamed from: e */
    public HashSet<String> f34840e = new HashSet<>();

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_sdk.c f34841f;

    /* renamed from: g */
    private w f34842g;

    /* renamed from: h */
    private boolean f34843h;

    /* renamed from: i */
    private float f34844i;

    /* renamed from: com.zk_oaction.adengine.lk_expression.a$a */
    static final class C0807a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        C0807a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(Math.min(fArr[0], fArr[1]));
        }
    }

    static final class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(Math.max(fArr[0], fArr[1]));
        }
    }

    static final class c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(Math.round(fArr[0]) * 1.0f);
        }
    }

    static final class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(((int) fArr[0]) * 1.0f);
        }
    }

    static final class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            String str = ((int) fArr[0]) + "";
            return Float.valueOf((str.charAt(str.length() - ((int) fArr[1])) - '0') * 1.0f);
        }
    }

    static final class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(new Random().nextFloat());
        }
    }

    static final class g implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        g() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.sqrt(fArr[0]));
        }
    }

    static final class h implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.sin(fArr[0]));
        }
    }

    static final class i implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        i() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.cos(fArr[0]));
        }
    }

    static final class j implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        j() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.tan(fArr[0]));
        }
    }

    static final class k implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        k() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return fArr[0] != 0.0f ? Float.valueOf(0.0f) : Float.valueOf(1.0f);
        }
    }

    static final class l implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        l() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.asin(fArr[0]));
        }
    }

    static final class m implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        m() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.acos(fArr[0]));
        }
    }

    static final class n implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        n() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf((float) Math.atan(fArr[0]));
        }
    }

    static final class o implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        o() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(Math.abs(fArr[0]));
        }
    }

    static final class p implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        p() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] == fArr[1] ? 1.0f : 0.0f);
        }
    }

    static final class q implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        q() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] != fArr[1] ? 1.0f : 0.0f);
        }
    }

    static final class r implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        r() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] >= fArr[1] ? 1.0f : 0.0f);
        }
    }

    static final class s implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        s() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] > fArr[1] ? 1.0f : 0.0f);
        }
    }

    static final class t implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        t() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] <= fArr[1] ? 1.0f : 0.0f);
        }
    }

    static final class u implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        u() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            return Float.valueOf(fArr[0] < fArr[1] ? 1.0f : 0.0f);
        }
    }

    static final class v implements com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> {
        v() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(float[] fArr) {
            float f2;
            int length = fArr.length - 1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    f2 = fArr[length];
                    break;
                }
                if (fArr[i2] > 0.0f) {
                    f2 = fArr[i2 + 1];
                    break;
                }
                i2 += 2;
            }
            return Float.valueOf(f2);
        }
    }

    public interface w {
        void a(String str, float f2);
    }

    static {
        n();
    }

    public a(com.zk_oaction.adengine.lk_sdk.c cVar, String str, String str2, float f2, w wVar, boolean z) {
        float f3;
        this.f34841f = cVar;
        this.f34838c = str;
        this.f34842g = wVar;
        if (str2 == null) {
            h(f2);
            return;
        }
        String replace = str2.replace(" ", "");
        this.f34839d = replace;
        if (replace.equals("true")) {
            f3 = 1.0f;
        } else {
            if (!this.f34839d.equals("false")) {
                this.f34843h = z;
                if (this.f34839d.contains("#")) {
                    String str3 = this.f34839d + "~";
                    int length = str3.length();
                    String str4 = null;
                    for (int i2 = 0; i2 < length; i2++) {
                        char charAt = str3.charAt(i2);
                        if (j(charAt) || charAt == ',' || charAt == ')') {
                            if (str4 != null) {
                                this.f34841f.t(str4, this);
                                this.f34840e.add(str4);
                                str4 = null;
                            }
                        } else if (charAt == '#') {
                            str4 = "";
                        } else if (str4 != null) {
                            str4 = str4 + charAt;
                        }
                    }
                }
                a((String) null, (String) null);
                return;
            }
            f3 = 0.0f;
        }
        h(f3);
    }

    private static char a(char c2, char c3) {
        return f34836a[m(c2)][m(c3)];
    }

    private static float c(float f2, char c2, float f3) {
        if (c2 == '%') {
            return f2 % f3;
        }
        if (c2 == '-') {
            return f2 - f3;
        }
        if (c2 == '/') {
            return f2 / f3;
        }
        if (c2 == '*') {
            return f2 * f3;
        }
        if (c2 != '+') {
            return 0.0f;
        }
        return f2 + f3;
    }

    public static float d(com.zk_oaction.adengine.lk_sdk.c cVar, String str) {
        float c2;
        float f2 = 0.0f;
        if (str == null) {
            return 0.0f;
        }
        try {
            Stack stack = new Stack();
            Stack stack2 = new Stack();
            stack2.add('~');
            String str2 = str + '~';
            int i2 = 0;
            char charAt = str2.charAt(0);
            if (charAt == '-') {
                stack.push(Float.valueOf(0.0f));
            }
            String str3 = null;
            while (true) {
                if (charAt == '~' && ((Character) stack2.peek()).charValue() == '~') {
                    if (str3 != null) {
                        stack.push(Float.valueOf(e(cVar.J.h(str3), 0.0f)));
                    }
                    f2 = ((Float) stack.peek()).floatValue();
                    return f2;
                }
                if (k(str3, charAt)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (!j(charAt)) {
                        stringBuffer.append(charAt);
                        i2++;
                        charAt = str2.charAt(i2);
                    }
                    c2 = Float.parseFloat(stringBuffer.toString());
                } else {
                    if (j(charAt)) {
                        if (str3 != null) {
                            stack.push(Float.valueOf(e(cVar.J.h(str3), 0.0f)));
                            str3 = null;
                        }
                        char a2 = a(((Character) stack2.peek()).charValue(), charAt);
                        if (a2 == '!') {
                            return -1.0f;
                        }
                        switch (a2) {
                            case '<':
                                stack2.push(Character.valueOf(charAt));
                                i2++;
                                break;
                            case '=':
                                stack2.pop();
                                i2++;
                                break;
                            case '>':
                                c2 = c(((Float) stack.pop()).floatValue(), ((Character) stack2.pop()).charValue(), ((Float) stack.pop()).floatValue());
                                break;
                        }
                    } else if (charAt == '#') {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("");
                        while (true) {
                            i2++;
                            char charAt2 = str2.charAt(i2);
                            if (j(charAt2)) {
                                str3 = stringBuffer2.toString();
                            } else {
                                stringBuffer2.append(charAt2);
                            }
                        }
                    } else {
                        String f3 = f(str, i2);
                        stack.push(Float.valueOf(l(cVar, f3)));
                        i2 += f3.length();
                    }
                    charAt = str2.charAt(i2);
                }
                stack.push(Float.valueOf(c2));
                charAt = str2.charAt(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return f2;
        }
    }

    private static float e(String str, float f2) {
        try {
            return TextUtils.isEmpty(str) ? f2 : Float.parseFloat(str);
        } catch (Exception unused) {
            return f2;
        }
    }

    private static String f(String str, int i2) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
        boolean z = false;
        int i3 = 0;
        while (!z) {
            char charAt = str.charAt(i2);
            stringBuffer.append(charAt);
            if (charAt == '(') {
                i3++;
            } else if (charAt == ')' && i3 - 1 == 0) {
                z = true;
            }
            i2++;
            if (i2 == length) {
                break;
            }
        }
        return stringBuffer.toString();
    }

    public static ArrayList<String> g(String str) {
        StringBuilder sb;
        ArrayList<String> arrayList = new ArrayList<>();
        int length = str.length();
        String str2 = "";
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '(') {
                i2++;
                sb = new StringBuilder();
            } else if (charAt == ')') {
                i2--;
                sb = new StringBuilder();
            } else if (charAt == ',' && i2 == 0) {
                arrayList.add(str2);
                str2 = "";
            } else {
                sb = new StringBuilder();
            }
            sb.append(str2);
            sb.append(charAt);
            str2 = sb.toString();
        }
        if (!str2.equals("")) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    public static boolean j(char c2) {
        return c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/' || c2 == '%' || c2 == '(' || c2 == ')' || c2 == '~';
    }

    private static boolean k(String str, char c2) {
        return str == null && c2 >= '0' && c2 <= '9';
    }

    private static float l(com.zk_oaction.adengine.lk_sdk.c cVar, String str) {
        int indexOf = str.indexOf(40);
        if (indexOf < 0 || indexOf > str.length()) {
            return 0.0f;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1, str.length() - 1);
        if (substring.equals("isnull")) {
            return (cVar.J.a(substring2.substring(1)) == null || cVar.J.a(substring2.substring(1)).e() == null) ? 1.0f : 0.0f;
        }
        ArrayList<String> g2 = g(substring2);
        float[] fArr = new float[g2.size()];
        for (int i2 = 0; i2 < g2.size(); i2++) {
            fArr[i2] = d(cVar, g2.get(i2));
        }
        com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float> cVar2 = f34837b.get(substring);
        if (cVar2 != null) {
            return cVar2.a(fArr).floatValue();
        }
        return 0.0f;
    }

    private static int m(char c2) {
        if (c2 == '%') {
            return 4;
        }
        if (c2 == '-') {
            return 1;
        }
        if (c2 == '/') {
            return 3;
        }
        if (c2 == '~') {
            return 7;
        }
        switch (c2) {
            case '(':
                return 5;
            case ')':
                return 6;
            case '*':
                return 2;
            case '+':
                return 0;
            default:
                return -1;
        }
    }

    private static void n() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<float[], Float>> hashMap = new HashMap<>();
        f34837b = hashMap;
        hashMap.put("not", new k());
        f34837b.put("abs", new o());
        f34837b.put("eq", new p());
        f34837b.put("ne", new q());
        f34837b.put("ge", new r());
        f34837b.put("gt", new s());
        f34837b.put("le", new t());
        f34837b.put("lt", new u());
        f34837b.put("ifelse", new v());
        f34837b.put("min", new C0807a());
        f34837b.put("max", new b());
        f34837b.put("round", new c());
        f34837b.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, new d());
        f34837b.put("digit", new e());
        f34837b.put("rand", new f());
        f34837b.put("sqrt", new g());
        f34837b.put("sin", new h());
        f34837b.put("cos", new i());
        f34837b.put("tan", new j());
        f34837b.put("asin", new l());
        f34837b.put("acos", new m());
        f34837b.put("atan", new n());
    }

    @Override // com.zk_oaction.adengine.lk_variable.f
    public void a(String str, String str2) {
        String str3 = this.f34839d;
        if (str3 != null) {
            this.f34844i = this.f34843h ? d(this.f34841f, str3) * this.f34841f.P : d(this.f34841f, str3);
            w wVar = this.f34842g;
            if (wVar != null) {
                wVar.a(this.f34838c, this.f34844i);
            }
        }
    }

    public float b() {
        return this.f34844i;
    }

    public void h(float f2) {
        this.f34844i = f2;
        w wVar = this.f34842g;
        if (wVar != null) {
            wVar.a(this.f34838c, f2);
        }
    }

    public void i(w wVar) {
        this.f34842g = wVar;
        if (wVar != null) {
            wVar.a(this.f34838c, this.f34844i);
        }
    }
}
