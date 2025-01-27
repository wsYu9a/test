package android.support.v4.graphics;

import android.graphics.Typeface;
import android.support.v4.view.C0008;
import com.google.gason.C0108;
import com.tencent.a.model.C0519;
import com.tencent.a.utils.C0520;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD;
    private static final String DEFAULT_FAMILY;
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f9short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(1821748)}[0]).intValue() ^ 1821777];
        sArr[0] = 2855;
        sArr[1] = 2870;
        sArr[2] = 2849;
        sArr[3] = 2853;
        sArr[4] = 2864;
        sArr[5] = 2849;
        sArr[6] = 2818;
        sArr[7] = 2870;
        sArr[8] = 2859;
        sArr[9] = 2857;
        sArr[10] = 2818;
        sArr[11] = 2853;
        sArr[12] = 2857;
        sArr[13] = 2861;
        sArr[14] = 2856;
        sArr[15] = 2861;
        sArr[16] = 2849;
        sArr[17] = 2871;
        sArr[18] = 2835;
        sArr[19] = 2861;
        sArr[20] = 2864;
        sArr[21] = 2860;
        sArr[22] = 2816;
        sArr[23] = 2849;
        sArr[24] = 2850;
        sArr[25] = 2853;
        sArr[26] = 2865;
        sArr[27] = 2856;
        sArr[28] = 2864;
        sArr[29] = 1013;
        sArr[30] = 999;
        sArr[31] = 1000;
        sArr[32] = 1013;
        sArr[33] = 939;
        sArr[34] = 1013;
        sArr[35] = 995;
        sArr[36] = 1012;
        sArr[37] = 1007;
        sArr[38] = 992;
        sArr[39] = 2400;
        sArr[40] = 2381;
        sArr[41] = 2372;
        sArr[42] = 2385;
        sArr[43] = 2386;
        sArr[44] = 2389;
        sArr[45] = 2391;
        sArr[46] = 2385;
        sArr[47] = 2423;
        sArr[48] = 2395;
        sArr[49] = 2393;
        sArr[50] = 2372;
        sArr[51] = 2389;
        sArr[52] = 2368;
        sArr[53] = 2421;
        sArr[54] = 2372;
        sArr[55] = 2397;
        sArr[56] = 2310;
        sArr[57] = 2316;
        sArr[58] = 2429;
        sArr[59] = 2393;
        sArr[60] = 2372;
        sArr[61] = 2392;
        sArr[62] = 2815;
        sArr[63] = 2797;
        sArr[64] = 2786;
        sArr[65] = 2815;
        sArr[66] = 2721;
        sArr[67] = 2815;
        sArr[68] = 2793;
        sArr[69] = 2814;
        sArr[70] = 2789;
        sArr[71] = 2794;
        sArr[72] = 1078;
        sArr[73] = 1063;
        sArr[74] = 1072;
        sArr[75] = 1076;
        sArr[76] = 1057;
        sArr[77] = 1072;
        sArr[78] = 1043;
        sArr[79] = 1063;
        sArr[80] = 1082;
        sArr[81] = 1080;
        sArr[82] = 1043;
        sArr[83] = 1076;
        sArr[84] = 1080;
        sArr[85] = 1084;
        sArr[86] = 1081;
        sArr[87] = 1084;
        sArr[88] = 1072;
        sArr[89] = 1062;
        sArr[90] = 1026;
        sArr[91] = 1084;
        sArr[92] = 1057;
        sArr[93] = 1085;
        sArr[94] = 1041;
        sArr[95] = 1072;
        sArr[96] = 1075;
        sArr[97] = 1076;
        sArr[98] = 1056;
        sArr[99] = 1081;
        sArr[100] = 1057;
        f9short = sArr;
        CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = C0519.m65(f9short, 1747834 ^ C0008.m27((Object) "۠ۥ۟"), 1751618 ^ C0008.m27((Object) "ۤۤ۟"), C0008.m27((Object) "ۧۢۡ") ^ 1756706);
        DEFAULT_FAMILY = C0519.m65(f9short, 56408 ^ C0008.m27((Object) "ۢۧ"), 1754633 ^ C0008.m27((Object) "ۣۧۧ"), C0008.m27((Object) "۠۟ۥ") ^ 1747264);
        TAG = C0520.m66(f9short, 1748743 ^ C0008.m27((Object) "ۣۡۤ"), 1755357 ^ C0008.m27((Object) "ۨ۟ۡ"), C0008.m27((Object) "ۢۡ۠") ^ 1751989);
    }

    @Override // android.support.v4.graphics.TypefaceCompatApi26Impl
    protected Typeface createFromFamiliesWithDefault(Object obj) {
        Object[] objArr = {new Integer(7944985), new Integer(3854250), new Integer(6852020), new Integer(-4872244), new Integer(3551213)};
        try {
            Class cls = this.mFontFamily;
            int intValue = 3551212 ^ ((Integer) objArr[4]).intValue();
            Object newInstance = Array.newInstance((Class<?>) cls, intValue);
            Array.set(newInstance, 0, obj);
            Method method = this.mCreateFromFamiliesWithDefault;
            Object[] objArr2 = new Object[((Integer) objArr[2]).intValue() ^ 6852016];
            objArr2[0] = newInstance;
            objArr2[intValue] = C0519.m65(f9short, 1751546 ^ C0008.m27((Object) "ۤ۟۟"), 1754370 ^ C0008.m27((Object) "ۧ۟۠"), C0008.m27((Object) "۠۠ۡ") ^ 1745005);
            int intValue2 = ((Integer) objArr[1]).intValue();
            int intValue3 = 4872243 ^ ((Integer) objArr[3]).intValue();
            objArr2[3854248 ^ intValue2] = Integer.valueOf(intValue3);
            objArr2[((Integer) objArr[0]).intValue() ^ 7944986] = Integer.valueOf(intValue3);
            return (Typeface) method.invoke(null, objArr2);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.graphics.TypefaceCompatApi26Impl
    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class cls) throws NoSuchMethodException {
        Object[] objArr = {new Integer(3481207), new Integer(5558322), new Integer(7458233), new Integer(1966619)};
        boolean intValue = 1966618 ^ ((Integer) objArr[3]).intValue();
        Object newInstance = Array.newInstance((Class<?>) cls, intValue ? 1 : 0);
        Class[] clsArr = new Class[((Integer) objArr[0]).intValue() ^ 3481203];
        clsArr[0] = newInstance.getClass();
        clsArr[intValue ? 1 : 0] = String.class;
        clsArr[((Integer) objArr[1]).intValue() ^ 5558320] = Integer.TYPE;
        clsArr[((Integer) objArr[2]).intValue() ^ 7458234] = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod(C0108.m52(f9short, 56531 ^ C0008.m27((Object) "ۥ۠"), 1746716 ^ C0008.m27((Object) "۟۟ۡ"), C0008.m27((Object) "ۥۤۦ") ^ 1751666), clsArr);
        declaredMethod.setAccessible(intValue);
        return declaredMethod;
    }
}
