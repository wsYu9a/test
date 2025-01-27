package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.WrappedDrawableApi14;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.util.Log;
import com.google.gason.internal.C0104;
import com.tencent.a.C0521;
import com.tencent.a.model.C0519;
import com.tencent.as.C0523;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static final String TAG;
    private static Method sIsProjectedDrawableMethod;

    /* renamed from: short */
    private static final short[] f15short;

    private static class DrawableWrapperStateLollipop extends WrappedDrawableApi14.DrawableWrapperState {
        DrawableWrapperStateLollipop(WrappedDrawableApi14.DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new WrappedDrawableApi21(this, resources);
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(3135039)}[0]).intValue() ^ 3135133];
        sArr[0] = 1554;
        sArr[1] = 1591;
        sArr[2] = 1572;
        sArr[3] = 1589;
        sArr[4] = 1589;
        sArr[5] = 1568;
        sArr[6] = 1569;
        sArr[7] = 1537;
        sArr[8] = 1591;
        sArr[9] = 1572;
        sArr[10] = 1586;
        sArr[11] = 1572;
        sArr[12] = 1575;
        sArr[13] = 1577;
        sArr[14] = 1568;
        sArr[15] = 1540;
        sArr[16] = 1589;
        sArr[17] = 1580;
        sArr[18] = 1655;
        sArr[19] = 1652;
        sArr[20] = 657;
        sArr[21] = 651;
        sArr[22] = 680;
        sArr[23] = 650;
        sArr[24] = 663;
        sArr[25] = 658;
        sArr[26] = 669;
        sArr[27] = 667;
        sArr[28] = 652;
        sArr[29] = 669;
        sArr[30] = 668;
        sArr[31] = 1422;
        sArr[32] = 1451;
        sArr[33] = 1464;
        sArr[34] = 1449;
        sArr[35] = 1449;
        sArr[36] = 1468;
        sArr[37] = 1469;
        sArr[38] = 1437;
        sArr[39] = 1451;
        sArr[40] = 1464;
        sArr[41] = 1454;
        sArr[42] = 1464;
        sArr[43] = 1467;
        sArr[44] = 1461;
        sArr[45] = 1468;
        sArr[46] = 1432;
        sArr[47] = 1449;
        sArr[48] = 1456;
        sArr[49] = 1515;
        sArr[50] = 1512;
        sArr[51] = 2684;
        sArr[52] = 2651;
        sArr[53] = 2643;
        sArr[54] = 2646;
        sArr[55] = 2655;
        sArr[56] = 2654;
        sArr[57] = 2586;
        sArr[58] = 2638;
        sArr[59] = 2645;
        sArr[60] = 2586;
        sArr[61] = 2632;
        sArr[62] = 2655;
        sArr[63] = 2638;
        sArr[64] = 2632;
        sArr[65] = 2643;
        sArr[66] = 2655;
        sArr[67] = 2636;
        sArr[68] = 2655;
        sArr[69] = 2586;
        sArr[70] = 2686;
        sArr[71] = 2632;
        sArr[72] = 2651;
        sArr[73] = 2637;
        sArr[74] = 2651;
        sArr[75] = 2648;
        sArr[76] = 2646;
        sArr[77] = 2655;
        sArr[78] = 2585;
        sArr[79] = 2643;
        sArr[80] = 2633;
        sArr[81] = 2666;
        sArr[82] = 2632;
        sArr[83] = 2645;
        sArr[84] = 2640;
        sArr[85] = 2655;
        sArr[86] = 2649;
        sArr[87] = 2638;
        sArr[88] = 2655;
        sArr[89] = 2654;
        sArr[90] = 2578;
        sArr[91] = 2579;
        sArr[92] = 2586;
        sArr[93] = 2647;
        sArr[94] = 2655;
        sArr[95] = 2638;
        sArr[96] = 2642;
        sArr[97] = 2645;
        sArr[98] = 2654;
        sArr[99] = 676;
        sArr[100] = 641;
        sArr[101] = 658;
        sArr[102] = 643;
        sArr[103] = 643;
        sArr[104] = 662;
        sArr[105] = 663;
        sArr[106] = 695;
        sArr[107] = 641;
        sArr[108] = 658;
        sArr[109] = 644;
        sArr[110] = 658;
        sArr[111] = 657;
        sArr[112] = 671;
        sArr[113] = 662;
        sArr[114] = 690;
        sArr[115] = 643;
        sArr[116] = 666;
        sArr[117] = 705;
        sArr[118] = 706;
        sArr[119] = 3024;
        sArr[120] = 3047;
        sArr[121] = 3047;
        sArr[122] = 3066;
        sArr[123] = 3047;
        sArr[124] = 2997;
        sArr[125] = 3062;
        sArr[126] = 3060;
        sArr[127] = 3065;
        sArr[128] = 3065;
        sArr[129] = 3068;
        sArr[130] = 3067;
        sArr[131] = 3058;
        sArr[132] = 2997;
        sArr[133] = 3025;
        sArr[134] = 3047;
        sArr[135] = 3060;
        sArr[136] = 3042;
        sArr[137] = 3060;
        sArr[138] = 3063;
        sArr[139] = 3065;
        sArr[140] = 3056;
        sArr[141] = 2998;
        sArr[142] = 3068;
        sArr[143] = 3046;
        sArr[144] = 3013;
        sArr[145] = 3047;
        sArr[146] = 3066;
        sArr[147] = 3071;
        sArr[148] = 3056;
        sArr[149] = 3062;
        sArr[150] = 3041;
        sArr[151] = 3056;
        sArr[152] = 3057;
        sArr[153] = 3005;
        sArr[154] = 3004;
        sArr[155] = 2997;
        sArr[156] = 3064;
        sArr[157] = 3056;
        sArr[158] = 3041;
        sArr[159] = 3069;
        sArr[160] = 3066;
        sArr[161] = 3057;
        f15short = sArr;
        TAG = C0005.m17(f15short, 1755591 ^ C0008.m27((Object) "ۨۧۦ"), 1748822 ^ C0008.m27((Object) "ۡۥۦ"), C0008.m27((Object) "ۦۡۤ") ^ 1755084);
    }

    WrappedDrawableApi21(Drawable drawable) {
        super(drawable);
        findAndCacheIsProjectedDrawableMethod();
    }

    WrappedDrawableApi21(WrappedDrawableApi14.DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
        findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        if (sIsProjectedDrawableMethod == null) {
            try {
                sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod(C0521.m71(f15short, 1747956 ^ C0008.m27((Object) "۠ۨۨ"), 1747732 ^ C0008.m27((Object) "۠ۢۡ"), C0008.m27((Object) "ۢۤۡ") ^ 1749031), new Class[0]);
            } catch (Exception e2) {
                Log.w(C0006.m19(f15short, 1754488 ^ C0008.m27((Object) "ۧۢۢ"), 1755410 ^ C0008.m27((Object) "ۨۡ۟"), C0008.m27((Object) "ۤۤۨ") ^ 1753009), C0104.m40(f15short, 56488 ^ C0008.m27((Object) "ۥ۠"), 1752593 ^ C0008.m27((Object) "ۥۤ۠"), C0008.m27((Object) "ۢ۠ۧ") ^ 1751123), e2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14
    protected boolean isCompatTintEnabled() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.mDrawable;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        if (this.mDrawable != null && (method = sIsProjectedDrawableMethod) != null) {
            try {
                return ((Boolean) method.invoke(this.mDrawable, new Object[0])).booleanValue();
            } catch (Exception e2) {
                Log.w(C0519.m65(f15short, 1748961 ^ C0008.m27((Object) "ۡۧۨ"), 1751666 ^ C0008.m27((Object) "ۤۤۦ"), C0008.m27((Object) "۠ۦۧ") ^ 1747282), C0523.m77(f15short, 1748853 ^ C0008.m27((Object) "ۣۡۤ"), 1754605 ^ C0008.m27((Object) "ۧۥۤ"), C0008.m27((Object) "ۤۧۢ") ^ 1749290), e2);
            }
        }
        return false;
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14
    WrappedDrawableApi14.DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateLollipop(this.mState, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        this.mDrawable.setHotspot(f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.mDrawable.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i2) {
        if (isCompatTintEnabled()) {
            super.setTint(i2);
        } else {
            this.mDrawable.setTint(i2);
        }
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (isCompatTintEnabled()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (isCompatTintEnabled()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }
}
