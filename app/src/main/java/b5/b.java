package b5;

import java.util.Arrays;
import java.util.BitSet;

@a5.b(emulated = true)
@b5.g
/* loaded from: classes2.dex */
public abstract class b implements b5.v<Character> {

    /* renamed from: b */
    public static final int f1206b = 65536;

    public class a extends x {

        /* renamed from: d */
        public final /* synthetic */ String f1207d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, b bVar2, String str) {
            super(bVar2);
            this.f1207d = str;
        }

        @Override // b5.b.w, b5.b
        public String toString() {
            return this.f1207d;
        }
    }

    public static class a0 extends b {

        /* renamed from: c */
        public final String f1208c;

        /* renamed from: d */
        public final char[] f1209d;

        /* renamed from: e */
        public final char[] f1210e;

        public a0(String str, char[] cArr, char[] cArr2) {
            this.f1208c = str;
            this.f1209d = cArr;
            this.f1210e = cArr2;
            b5.u.d(cArr.length == cArr2.length);
            int i10 = 0;
            while (i10 < cArr.length) {
                b5.u.d(cArr[i10] <= cArr2[i10]);
                int i11 = i10 + 1;
                if (i11 < cArr.length) {
                    b5.u.d(cArr2[i10] < cArr[i11]);
                }
                i10 = i11;
            }
        }

        @Override // b5.b
        public boolean B(char c10) {
            int binarySearch = Arrays.binarySearch(this.f1209d, c10);
            if (binarySearch >= 0) {
                return true;
            }
            int i10 = (~binarySearch) - 1;
            return i10 >= 0 && c10 <= this.f1210e[i10];
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            return this.f1208c;
        }
    }

    /* renamed from: b5.b$b */
    public static final class C0014b extends b {

        /* renamed from: c */
        public final b f1211c;

        /* renamed from: d */
        public final b f1212d;

        public C0014b(b bVar, b bVar2) {
            this.f1211c = (b) b5.u.E(bVar);
            this.f1212d = (b) b5.u.E(bVar2);
        }

        @Override // b5.b
        public boolean B(char c10) {
            return this.f1211c.B(c10) && this.f1212d.B(c10);
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f1211c.Q(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.f1212d.Q(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            String valueOf = String.valueOf(this.f1211c);
            String valueOf2 = String.valueOf(this.f1212d);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 19 + valueOf2.length());
            sb2.append("CharMatcher.and(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class b0 extends a0 {

        /* renamed from: f */
        public static final b0 f1213f = new b0();

        public b0() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    public static final class c extends v {

        /* renamed from: d */
        public static final c f1214d = new c();

        public c() {
            super("CharMatcher.any()");
        }

        @Override // b5.b
        public int A(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // b5.b
        public boolean B(char c10) {
            return true;
        }

        @Override // b5.b
        public boolean C(CharSequence charSequence) {
            b5.u.E(charSequence);
            return true;
        }

        @Override // b5.b
        public boolean E(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // b5.b.i, b5.b
        public b F() {
            return b.G();
        }

        @Override // b5.b
        public b I(b bVar) {
            b5.u.E(bVar);
            return this;
        }

        @Override // b5.b
        public String M(CharSequence charSequence) {
            b5.u.E(charSequence);
            return "";
        }

        @Override // b5.b
        public String N(CharSequence charSequence, char c10) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c10);
            return new String(cArr);
        }

        @Override // b5.b
        public String O(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb2 = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i10 = 0; i10 < charSequence.length(); i10++) {
                sb2.append(charSequence2);
            }
            return sb2.toString();
        }

        @Override // b5.b
        public String U(CharSequence charSequence) {
            b5.u.E(charSequence);
            return "";
        }

        @Override // b5.b
        public b b(b bVar) {
            return (b) b5.u.E(bVar);
        }

        @Override // b5.b
        public String h(CharSequence charSequence, char c10) {
            return charSequence.length() == 0 ? "" : String.valueOf(c10);
        }

        @Override // b5.b
        public int i(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // b5.b
        public int n(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // b5.b
        public int o(CharSequence charSequence, int i10) {
            int length = charSequence.length();
            b5.u.d0(i10, length);
            if (i10 == length) {
                return -1;
            }
            return i10;
        }
    }

    @a5.d
    public static final class c0 extends v {

        /* renamed from: d */
        public static final String f1215d = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000";

        /* renamed from: e */
        public static final int f1216e = 1682554634;

        /* renamed from: f */
        public static final int f1217f = Integer.numberOfLeadingZeros(31);

        /* renamed from: g */
        public static final c0 f1218g = new c0();

        public c0() {
            super("CharMatcher.whitespace()");
        }

        @Override // b5.b
        public boolean B(char c10) {
            return f1215d.charAt((f1216e * c10) >>> f1217f) == c10;
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            for (int i10 = 0; i10 < 32; i10++) {
                bitSet.set(f1215d.charAt(i10));
            }
        }
    }

    public static final class d extends b {

        /* renamed from: c */
        public final char[] f1219c;

        public d(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f1219c = charArray;
            Arrays.sort(charArray);
        }

        @Override // b5.b
        public boolean B(char c10) {
            return Arrays.binarySearch(this.f1219c, c10) >= 0;
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            for (char c10 : this.f1219c) {
                bitSet.set(c10);
            }
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            StringBuilder sb2 = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c10 : this.f1219c) {
                sb2.append(b.R(c10));
            }
            sb2.append("\")");
            return sb2.toString();
        }
    }

    public static final class e extends v {

        /* renamed from: d */
        public static final e f1220d = new e();

        public e() {
            super("CharMatcher.ascii()");
        }

        @Override // b5.b
        public boolean B(char c10) {
            return c10 <= 127;
        }
    }

    @a5.c
    public static final class f extends v {

        /* renamed from: d */
        public final BitSet f1221d;

        public /* synthetic */ f(BitSet bitSet, String str, a aVar) {
            this(bitSet, str);
        }

        @Override // b5.b
        public boolean B(char c10) {
            return this.f1221d.get(c10);
        }

        @Override // b5.b
        public void Q(BitSet bitSet) {
            bitSet.or(this.f1221d);
        }

        public f(BitSet bitSet, String str) {
            super(str);
            this.f1221d = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
        }
    }

    public static final class g extends b {

        /* renamed from: c */
        public static final b f1222c = new g();

        @Override // b5.b
        public boolean B(char c10) {
            if (c10 != ' ' && c10 != 133 && c10 != 5760) {
                if (c10 == 8199) {
                    return false;
                }
                if (c10 != 8287 && c10 != 12288 && c10 != 8232 && c10 != 8233) {
                    switch (c10) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c10 >= 8192 && c10 <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    public static final class h extends a0 {

        /* renamed from: f */
        public static final String f1223f = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";

        /* renamed from: g */
        public static final h f1224g = new h();

        public h() {
            super("CharMatcher.digit()", Z(), Y());
        }

        public static char[] Y() {
            char[] cArr = new char[37];
            for (int i10 = 0; i10 < 37; i10++) {
                cArr[i10] = (char) (f1223f.charAt(i10) + '\t');
            }
            return cArr;
        }

        public static char[] Z() {
            return f1223f.toCharArray();
        }
    }

    public static final class j extends b {

        /* renamed from: c */
        public final b5.v<? super Character> f1225c;

        public j(b5.v<? super Character> vVar) {
            this.f1225c = (b5.v) b5.u.E(vVar);
        }

        @Override // b5.b
        public boolean B(char c10) {
            return this.f1225c.apply(Character.valueOf(c10));
        }

        @Override // b5.b, b5.v
        /* renamed from: e */
        public boolean apply(Character ch2) {
            return this.f1225c.apply(b5.u.E(ch2));
        }

        @Override // b5.b
        public String toString() {
            String valueOf = String.valueOf(this.f1225c);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 26);
            sb2.append("CharMatcher.forPredicate(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class k extends i {

        /* renamed from: c */
        public final char f1226c;

        /* renamed from: d */
        public final char f1227d;

        public k(char c10, char c11) {
            b5.u.d(c11 >= c10);
            this.f1226c = c10;
            this.f1227d = c11;
        }

        @Override // b5.b
        public boolean B(char c10) {
            return this.f1226c <= c10 && c10 <= this.f1227d;
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            bitSet.set(this.f1226c, this.f1227d + 1);
        }

        @Override // b5.b
        public String toString() {
            String R = b.R(this.f1226c);
            String R2 = b.R(this.f1227d);
            StringBuilder sb2 = new StringBuilder(String.valueOf(R).length() + 27 + String.valueOf(R2).length());
            sb2.append("CharMatcher.inRange('");
            sb2.append(R);
            sb2.append("', '");
            sb2.append(R2);
            sb2.append("')");
            return sb2.toString();
        }
    }

    public static final class l extends a0 {

        /* renamed from: f */
        public static final String f1228f = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u0890\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9";

        /* renamed from: g */
        public static final String f1229g = "  \u00ad\u0605\u061c\u06dd\u070f\u0891\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb";

        /* renamed from: h */
        public static final l f1230h = new l();

        public l() {
            super("CharMatcher.invisible()", f1228f.toCharArray(), f1229g.toCharArray());
        }
    }

    public static final class m extends i {

        /* renamed from: c */
        public final char f1231c;

        public m(char c10) {
            this.f1231c = c10;
        }

        @Override // b5.b
        public boolean B(char c10) {
            return c10 == this.f1231c;
        }

        @Override // b5.b.i, b5.b
        public b F() {
            return b.s(this.f1231c);
        }

        @Override // b5.b
        public b I(b bVar) {
            return bVar.B(this.f1231c) ? bVar : super.I(bVar);
        }

        @Override // b5.b
        public String N(CharSequence charSequence, char c10) {
            return charSequence.toString().replace(this.f1231c, c10);
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            bitSet.set(this.f1231c);
        }

        @Override // b5.b
        public b b(b bVar) {
            return bVar.B(this.f1231c) ? this : b.G();
        }

        @Override // b5.b
        public String toString() {
            String R = b.R(this.f1231c);
            StringBuilder sb2 = new StringBuilder(String.valueOf(R).length() + 18);
            sb2.append("CharMatcher.is('");
            sb2.append(R);
            sb2.append("')");
            return sb2.toString();
        }
    }

    public static final class n extends i {

        /* renamed from: c */
        public final char f1232c;

        /* renamed from: d */
        public final char f1233d;

        public n(char c10, char c11) {
            this.f1232c = c10;
            this.f1233d = c11;
        }

        @Override // b5.b
        public boolean B(char c10) {
            return c10 == this.f1232c || c10 == this.f1233d;
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            bitSet.set(this.f1232c);
            bitSet.set(this.f1233d);
        }

        @Override // b5.b
        public String toString() {
            String R = b.R(this.f1232c);
            String R2 = b.R(this.f1233d);
            StringBuilder sb2 = new StringBuilder(String.valueOf(R).length() + 21 + String.valueOf(R2).length());
            sb2.append("CharMatcher.anyOf(\"");
            sb2.append(R);
            sb2.append(R2);
            sb2.append("\")");
            return sb2.toString();
        }
    }

    public static final class o extends i {

        /* renamed from: c */
        public final char f1234c;

        public o(char c10) {
            this.f1234c = c10;
        }

        @Override // b5.b
        public boolean B(char c10) {
            return c10 != this.f1234c;
        }

        @Override // b5.b.i, b5.b
        public b F() {
            return b.q(this.f1234c);
        }

        @Override // b5.b
        public b I(b bVar) {
            return bVar.B(this.f1234c) ? b.c() : this;
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            bitSet.set(0, this.f1234c);
            bitSet.set(this.f1234c + 1, 65536);
        }

        @Override // b5.b
        public b b(b bVar) {
            return bVar.B(this.f1234c) ? super.b(bVar) : bVar;
        }

        @Override // b5.b
        public String toString() {
            String R = b.R(this.f1234c);
            StringBuilder sb2 = new StringBuilder(String.valueOf(R).length() + 21);
            sb2.append("CharMatcher.isNot('");
            sb2.append(R);
            sb2.append("')");
            return sb2.toString();
        }
    }

    public static final class p extends b {

        /* renamed from: c */
        public static final p f1235c = new p();

        @Override // b5.b
        public boolean B(char c10) {
            return Character.isDigit(c10);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    public static final class q extends v {

        /* renamed from: d */
        public static final q f1236d = new q();

        public q() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // b5.b
        public boolean B(char c10) {
            return c10 <= 31 || (c10 >= 127 && c10 <= 159);
        }
    }

    public static final class r extends b {

        /* renamed from: c */
        public static final r f1237c = new r();

        @Override // b5.b
        public boolean B(char c10) {
            return Character.isLetter(c10);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    public static final class s extends b {

        /* renamed from: c */
        public static final s f1238c = new s();

        @Override // b5.b
        public boolean B(char c10) {
            return Character.isLetterOrDigit(c10);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    public static final class t extends b {

        /* renamed from: c */
        public static final t f1239c = new t();

        @Override // b5.b
        public boolean B(char c10) {
            return Character.isLowerCase(c10);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    public static final class u extends b {

        /* renamed from: c */
        public static final u f1240c = new u();

        @Override // b5.b
        public boolean B(char c10) {
            return Character.isUpperCase(c10);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    public static abstract class v extends i {

        /* renamed from: c */
        public final String f1241c;

        public v(String str) {
            this.f1241c = (String) b5.u.E(str);
        }

        @Override // b5.b
        public final String toString() {
            return this.f1241c;
        }
    }

    public static class w extends b {

        /* renamed from: c */
        public final b f1242c;

        public w(b bVar) {
            this.f1242c = (b) b5.u.E(bVar);
        }

        @Override // b5.b
        public boolean B(char c10) {
            return !this.f1242c.B(c10);
        }

        @Override // b5.b
        public boolean C(CharSequence charSequence) {
            return this.f1242c.E(charSequence);
        }

        @Override // b5.b
        public boolean E(CharSequence charSequence) {
            return this.f1242c.C(charSequence);
        }

        @Override // b5.b
        public b F() {
            return this.f1242c;
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f1242c.Q(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public int i(CharSequence charSequence) {
            return charSequence.length() - this.f1242c.i(charSequence);
        }

        @Override // b5.b
        public String toString() {
            String valueOf = String.valueOf(this.f1242c);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
            sb2.append(valueOf);
            sb2.append(".negate()");
            return sb2.toString();
        }
    }

    public static final class y extends v {

        /* renamed from: d */
        public static final y f1243d = new y();

        public y() {
            super("CharMatcher.none()");
        }

        @Override // b5.b
        public int A(CharSequence charSequence) {
            b5.u.E(charSequence);
            return -1;
        }

        @Override // b5.b
        public boolean B(char c10) {
            return false;
        }

        @Override // b5.b
        public boolean C(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // b5.b
        public boolean E(CharSequence charSequence) {
            b5.u.E(charSequence);
            return true;
        }

        @Override // b5.b.i, b5.b
        public b F() {
            return b.c();
        }

        @Override // b5.b
        public b I(b bVar) {
            return (b) b5.u.E(bVar);
        }

        @Override // b5.b
        public String M(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // b5.b
        public String N(CharSequence charSequence, char c10) {
            return charSequence.toString();
        }

        @Override // b5.b
        public String O(CharSequence charSequence, CharSequence charSequence2) {
            b5.u.E(charSequence2);
            return charSequence.toString();
        }

        @Override // b5.b
        public String U(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // b5.b
        public String V(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // b5.b
        public String W(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // b5.b
        public b b(b bVar) {
            b5.u.E(bVar);
            return this;
        }

        @Override // b5.b
        public String h(CharSequence charSequence, char c10) {
            return charSequence.toString();
        }

        @Override // b5.b
        public int i(CharSequence charSequence) {
            b5.u.E(charSequence);
            return 0;
        }

        @Override // b5.b
        public int n(CharSequence charSequence) {
            b5.u.E(charSequence);
            return -1;
        }

        @Override // b5.b
        public int o(CharSequence charSequence, int i10) {
            b5.u.d0(i10, charSequence.length());
            return -1;
        }
    }

    public static final class z extends b {

        /* renamed from: c */
        public final b f1244c;

        /* renamed from: d */
        public final b f1245d;

        public z(b bVar, b bVar2) {
            this.f1244c = (b) b5.u.E(bVar);
            this.f1245d = (b) b5.u.E(bVar2);
        }

        @Override // b5.b
        public boolean B(char c10) {
            return this.f1244c.B(c10) || this.f1245d.B(c10);
        }

        @Override // b5.b
        @a5.c
        public void Q(BitSet bitSet) {
            this.f1244c.Q(bitSet);
            this.f1245d.Q(bitSet);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public String toString() {
            String valueOf = String.valueOf(this.f1244c);
            String valueOf2 = String.valueOf(this.f1245d);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 18 + valueOf2.length());
            sb2.append("CharMatcher.or(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static b G() {
        return y.f1243d;
    }

    public static b H(CharSequence charSequence) {
        return d(charSequence).F();
    }

    @a5.c
    public static b L(int i10, BitSet bitSet, String str) {
        if (i10 == 0) {
            return G();
        }
        if (i10 == 1) {
            return q((char) bitSet.nextSetBit(0));
        }
        if (i10 != 2) {
            return t(i10, bitSet.length()) ? b5.w.a0(bitSet, str) : new f(bitSet, str, null);
        }
        char nextSetBit = (char) bitSet.nextSetBit(0);
        return r(nextSetBit, (char) bitSet.nextSetBit(nextSetBit + 1));
    }

    public static String R(char c10) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            cArr[5 - i10] = "0123456789ABCDEF".charAt(c10 & 15);
            c10 = (char) (c10 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static b S() {
        return b0.f1213f;
    }

    public static b X() {
        return c0.f1218g;
    }

    public static b c() {
        return c.f1214d;
    }

    public static b d(CharSequence charSequence) {
        int length = charSequence.length();
        return length != 0 ? length != 1 ? length != 2 ? new d(charSequence) : r(charSequence.charAt(0), charSequence.charAt(1)) : q(charSequence.charAt(0)) : G();
    }

    public static b f() {
        return e.f1220d;
    }

    public static b g() {
        return g.f1222c;
    }

    @Deprecated
    public static b j() {
        return h.f1224g;
    }

    public static b l(b5.v<? super Character> vVar) {
        return vVar instanceof b ? (b) vVar : new j(vVar);
    }

    public static b m(char c10, char c11) {
        return new k(c10, c11);
    }

    @Deprecated
    public static b p() {
        return l.f1230h;
    }

    public static b q(char c10) {
        return new m(c10);
    }

    public static n r(char c10, char c11) {
        return new n(c10, c11);
    }

    public static b s(char c10) {
        return new o(c10);
    }

    @a5.c
    public static boolean t(int i10, int i11) {
        return i10 <= 1023 && i11 > i10 * 64;
    }

    @Deprecated
    public static b u() {
        return p.f1235c;
    }

    public static b v() {
        return q.f1236d;
    }

    @Deprecated
    public static b w() {
        return r.f1237c;
    }

    @Deprecated
    public static b x() {
        return s.f1238c;
    }

    @Deprecated
    public static b y() {
        return t.f1239c;
    }

    @Deprecated
    public static b z() {
        return u.f1240c;
    }

    public int A(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (B(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean B(char c10);

    public boolean C(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!B(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean D(CharSequence charSequence) {
        return !E(charSequence);
    }

    public boolean E(CharSequence charSequence) {
        return n(charSequence) == -1;
    }

    public b F() {
        return new w(this);
    }

    public b I(b bVar) {
        return new z(this, bVar);
    }

    public b J() {
        return com.google.common.base.b.j(this);
    }

    @a5.c
    public b K() {
        BitSet bitSet = new BitSet();
        Q(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= 65536) {
            return L(cardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i10 = 65536 - cardinality;
        String bVar = toString();
        return new a(this, L(i10, bitSet, bVar.endsWith(".negate()") ? bVar.substring(0, bVar.length() - 9) : ".negate()".length() != 0 ? bVar.concat(".negate()") : new String(bVar)), bVar);
    }

    public String M(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int n10 = n(charSequence2);
        if (n10 == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        int i10 = 1;
        while (true) {
            n10++;
            while (n10 != charArray.length) {
                if (B(charArray[n10])) {
                    break;
                }
                charArray[n10 - i10] = charArray[n10];
                n10++;
            }
            return new String(charArray, 0, n10 - i10);
            i10++;
        }
    }

    public String N(CharSequence charSequence, char c10) {
        String charSequence2 = charSequence.toString();
        int n10 = n(charSequence2);
        if (n10 == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        charArray[n10] = c10;
        while (true) {
            n10++;
            if (n10 >= charArray.length) {
                return new String(charArray);
            }
            if (B(charArray[n10])) {
                charArray[n10] = c10;
            }
        }
    }

    public String O(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return M(charSequence);
        }
        int i10 = 0;
        if (length == 1) {
            return N(charSequence, charSequence2.charAt(0));
        }
        String charSequence3 = charSequence.toString();
        int n10 = n(charSequence3);
        if (n10 == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        StringBuilder sb2 = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb2.append((CharSequence) charSequence3, i10, n10);
            sb2.append(charSequence2);
            i10 = n10 + 1;
            n10 = o(charSequence3, i10);
        } while (n10 != -1);
        sb2.append((CharSequence) charSequence3, i10, length2);
        return sb2.toString();
    }

    public String P(CharSequence charSequence) {
        return F().M(charSequence);
    }

    @a5.c
    public void Q(BitSet bitSet) {
        for (int i10 = 65535; i10 >= 0; i10--) {
            if (B((char) i10)) {
                bitSet.set(i10);
            }
        }
    }

    public String T(CharSequence charSequence, char c10) {
        int length = charSequence.length();
        int i10 = length - 1;
        int i11 = 0;
        while (i11 < length && B(charSequence.charAt(i11))) {
            i11++;
        }
        int i12 = i10;
        while (i12 > i11 && B(charSequence.charAt(i12))) {
            i12--;
        }
        if (i11 == 0 && i12 == i10) {
            return h(charSequence, c10);
        }
        int i13 = i12 + 1;
        return k(charSequence, i11, i13, c10, new StringBuilder(i13 - i11), false);
    }

    public String U(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && B(charSequence.charAt(i10))) {
            i10++;
        }
        int i11 = length - 1;
        while (i11 > i10 && B(charSequence.charAt(i11))) {
            i11--;
        }
        return charSequence.subSequence(i10, i11 + 1).toString();
    }

    public String V(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!B(charSequence.charAt(i10))) {
                return charSequence.subSequence(i10, length).toString();
            }
        }
        return "";
    }

    public String W(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!B(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public b b(b bVar) {
        return new C0014b(this, bVar);
    }

    @Override // b5.v
    @Deprecated
    /* renamed from: e */
    public boolean apply(Character ch2) {
        return B(ch2.charValue());
    }

    public String h(CharSequence charSequence, char c10) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (B(charAt)) {
                if (charAt != c10 || (i10 != length - 1 && B(charSequence.charAt(i10 + 1)))) {
                    StringBuilder sb2 = new StringBuilder(length);
                    sb2.append(charSequence, 0, i10);
                    sb2.append(c10);
                    return k(charSequence, i10 + 1, length, c10, sb2, true);
                }
                i10++;
            }
            i10++;
        }
        return charSequence.toString();
    }

    public int i(CharSequence charSequence) {
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (B(charSequence.charAt(i11))) {
                i10++;
            }
        }
        return i10;
    }

    public final String k(CharSequence charSequence, int i10, int i11, char c10, StringBuilder sb2, boolean z10) {
        while (i10 < i11) {
            char charAt = charSequence.charAt(i10);
            if (!B(charAt)) {
                sb2.append(charAt);
                z10 = false;
            } else if (!z10) {
                sb2.append(c10);
                z10 = true;
            }
            i10++;
        }
        return sb2.toString();
    }

    public int n(CharSequence charSequence) {
        return o(charSequence, 0);
    }

    public int o(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        b5.u.d0(i10, length);
        while (i10 < length) {
            if (B(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public String toString() {
        return super.toString();
    }

    public static abstract class i extends b {
        @Override // b5.b
        public b F() {
            return new x(this);
        }

        @Override // b5.b, b5.v
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // b5.b
        public final b J() {
            return this;
        }
    }

    public static class x extends w {
        public x(b bVar) {
            super(bVar);
        }

        @Override // b5.b
        public final b J() {
            return this;
        }
    }
}
