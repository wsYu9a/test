package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.compat.R;
import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import com.google.gason.C0108;
import com.google.gason.internal.C0104;
import com.google.gason.reflect.C0105;
import com.google.gason.stream.C0106;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.as.C0523;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;

    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG;
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    /* renamed from: short */
    private static final short[] f38short;

    /* renamed from: android.support.v4.view.ViewCompat$1 */
    static final class AnonymousClass1 implements View.OnApplyWindowInsetsListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return (WindowInsets) WindowInsetsCompat.unwrap(OnApplyWindowInsetsListener.this.onApplyWindowInsets(view, WindowInsetsCompat.wrap(windowInsets)));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    private static class OnUnhandledKeyEventListenerWrapper implements View.OnUnhandledKeyEventListener {
        private OnUnhandledKeyEventListenerCompat mCompatListener;

        OnUnhandledKeyEventListenerWrapper(OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            this.mCompatListener = onUnhandledKeyEventListenerCompat;
        }

        @Override // android.view.View.OnUnhandledKeyEventListener
        public boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            return this.mCompatListener.onUnhandledKeyEvent(view, keyEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();
        private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys = null;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;

        UnhandledKeyEventManager() {
        }

        static UnhandledKeyEventManager at(View view) {
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
            view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager2);
            return unhandledKeyEventManager2;
        }

        private View dispatchInOrder(View view, KeyEvent keyEvent) {
            Object[] objArr = {new Integer(-315544), new Integer(-1993845)};
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int intValue = (((Integer) objArr[0]).intValue() ^ 315543) + viewGroup.getChildCount(); intValue >= 0; intValue = (((Integer) objArr[1]).intValue() ^ 1993844) + intValue) {
                    View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(intValue), keyEvent);
                    if (dispatchInOrder != null) {
                        return dispatchInOrder;
                    }
                }
            }
            if (onUnhandledKeyEvent(view, keyEvent)) {
                return view;
            }
            return null;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray<>();
            }
            return this.mCapturedKeys;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            Object[] objArr = {new Integer(-4917772), new Integer(2324219)};
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                int size = arrayList.size();
                boolean intValue = 2324218 ^ ((Integer) objArr[1]).intValue();
                for (int i2 = size - (intValue ? 1 : 0); i2 >= 0; i2 = (((Integer) objArr[0]).intValue() ^ 4917771) + i2) {
                    if (((OnUnhandledKeyEventListenerCompat) arrayList.get(i2)).onUnhandledKeyEvent(view, keyEvent)) {
                        return intValue;
                    }
                }
            }
            return false;
        }

        private void recalcViewsWithUnhandled() {
            Object[] objArr = {new Integer(-3345324), new Integer(-5461066)};
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.mViewsContainingListeners == null) {
                    this.mViewsContainingListeners = new WeakHashMap<>();
                }
                for (int intValue = (((Integer) objArr[1]).intValue() ^ 5461065) + arrayList.size(); intValue >= 0; intValue = (((Integer) objArr[0]).intValue() ^ 3345323) + intValue) {
                    ArrayList<WeakReference<View>> arrayList2 = sViewsWithListeners;
                    View view = arrayList2.get(intValue).get();
                    if (view == null) {
                        arrayList2.remove(intValue);
                    } else {
                        this.mViewsContainingListeners.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        static void registerListeningView(View view) {
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                Iterator<WeakReference<View>> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == view) {
                        return;
                    }
                }
                sViewsWithListeners.add(new WeakReference<>(view));
            }
        }

        static void unregisterListeningView(View view) {
            Integer num = new Integer(7855728);
            synchronized (sViewsWithListeners) {
                int i2 = 0;
                while (true) {
                    ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
                    if (i2 >= arrayList.size()) {
                        return;
                    }
                    if (arrayList.get(i2).get() == view) {
                        arrayList.remove(i2);
                        return;
                    }
                    i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 7855729) + i2;
                }
            }
        }

        boolean dispatch(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                recalcViewsWithUnhandled();
            }
            View dispatchInOrder = dispatchInOrder(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                    getCapturedKeys().put(keyCode, new WeakReference<>(dispatchInOrder));
                }
            }
            return dispatchInOrder != null;
        }

        boolean preDispatch(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.mLastDispatchedPreViewKeyEvent;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.mLastDispatchedPreViewKeyEvent = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference2 = null;
            SparseArray<WeakReference<View>> capturedKeys = getCapturedKeys();
            if (keyEvent.getAction() == 1 && (indexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = capturedKeys.valueAt(indexOfKey);
                capturedKeys.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = capturedKeys.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = weakReference2.get();
            if (view != null && ViewCompat.isAttachedToWindow(view)) {
                onUnhandledKeyEvent(view, keyEvent);
            }
            return true;
        }
    }

    static {
        Object[] objArr = {new Integer(5627172), new Integer(1936172)};
        short[] sArr = new short[((Integer) objArr[0]).intValue() ^ 5627008];
        sArr[0] = 2138;
        sArr[1] = 2149;
        sArr[2] = 2153;
        sArr[3] = 2171;
        sArr[4] = 2127;
        sArr[5] = 2147;
        sArr[6] = 2145;
        sArr[7] = 2172;
        sArr[8] = 2157;
        sArr[9] = 2168;
        sArr[10] = 672;
        sArr[11] = 685;
        sArr[12] = 695;
        sArr[13] = 692;
        sArr[14] = 677;
        sArr[15] = 688;
        sArr[16] = 679;
        sArr[17] = 684;
        sArr[18] = 663;
        sArr[19] = 688;
        sArr[20] = 677;
        sArr[21] = 694;
        sArr[22] = 688;
        sArr[23] = 656;
        sArr[24] = 673;
        sArr[25] = 681;
        sArr[26] = 692;
        sArr[27] = 683;
        sArr[28] = 694;
        sArr[29] = 677;
        sArr[30] = 694;
        sArr[31] = 701;
        sArr[32] = 640;
        sArr[33] = 673;
        sArr[34] = 688;
        sArr[35] = 677;
        sArr[36] = 679;
        sArr[37] = 684;
        sArr[38] = 1785;
        sArr[39] = 1780;
        sArr[40] = 1774;
        sArr[41] = 1773;
        sArr[42] = 1788;
        sArr[43] = 1769;
        sArr[44] = 1790;
        sArr[45] = 1781;
        sArr[46] = 1755;
        sArr[47] = 1780;
        sArr[48] = 1779;
        sArr[49] = 1780;
        sArr[50] = 1774;
        sArr[51] = 1781;
        sArr[52] = 1737;
        sArr[53] = 1784;
        sArr[54] = 1776;
        sArr[55] = 1773;
        sArr[56] = 1778;
        sArr[57] = 1775;
        sArr[58] = 1788;
        sArr[59] = 1775;
        sArr[60] = 1764;
        sArr[61] = 1753;
        sArr[62] = 1784;
        sArr[63] = 1769;
        sArr[64] = 1788;
        sArr[65] = 1790;
        sArr[66] = 1781;
        sArr[67] = 879;
        sArr[68] = 848;
        sArr[69] = 860;
        sArr[70] = 846;
        sArr[71] = 890;
        sArr[72] = 854;
        sArr[73] = 852;
        sArr[74] = 841;
        sArr[75] = 856;
        sArr[76] = 845;
        sArr[77] = 2772;
        sArr[78] = 2808;
        sArr[79] = 2786;
        sArr[80] = 2811;
        sArr[81] = 2803;
        sArr[82] = 2809;
        sArr[83] = 2736;
        sArr[84] = 2787;
        sArr[85] = 2743;
        sArr[86] = 2801;
        sArr[87] = 2814;
        sArr[88] = 2809;
        sArr[89] = 2803;
        sArr[90] = 2743;
        sArr[91] = 2810;
        sArr[92] = 2802;
        sArr[93] = 2787;
        sArr[94] = 2815;
        sArr[95] = 2808;
        sArr[96] = 2803;
        sArr[97] = 296;
        sArr[98] = 279;
        sArr[99] = 283;
        sArr[100] = 265;
        sArr[101] = 317;
        sArr[102] = 273;
        sArr[103] = 275;
        sArr[104] = 270;
        sArr[105] = 287;
        sArr[106] = 266;
        sArr[107] = 1482;
        sArr[108] = 1533;
        sArr[109] = 1533;
        sArr[110] = 1504;
        sArr[111] = 1533;
        sArr[112] = 1455;
        sArr[113] = 1516;
        sArr[114] = 1518;
        sArr[115] = 1507;
        sArr[116] = 1507;
        sArr[117] = 1510;
        sArr[118] = 1505;
        sArr[119] = 1512;
        sArr[120] = 1455;
        sArr[121] = 1515;
        sArr[122] = 1510;
        sArr[123] = 1532;
        sArr[124] = 1535;
        sArr[125] = 1518;
        sArr[126] = 1531;
        sArr[127] = 1516;
        sArr[128] = 1511;
        sArr[129] = 1481;
        sArr[130] = 1510;
        sArr[131] = 1505;
        sArr[132] = 1510;
        sArr[133] = 1532;
        sArr[134] = 1511;
        sArr[135] = 1499;
        sArr[136] = 1514;
        sArr[137] = 1506;
        sArr[138] = 1535;
        sArr[139] = 1504;
        sArr[140] = 1533;
        sArr[141] = 1518;
        sArr[142] = 1533;
        sArr[143] = 1526;
        sArr[144] = 1483;
        sArr[145] = 1514;
        sArr[146] = 1531;
        sArr[147] = 1518;
        sArr[148] = 1516;
        sArr[149] = 1511;
        sArr[150] = 1245;
        sArr[151] = 1250;
        sArr[152] = 1262;
        sArr[153] = 1276;
        sArr[154] = 1224;
        sArr[155] = 1252;
        sArr[156] = 1254;
        sArr[157] = 1275;
        sArr[158] = 1258;
        sArr[159] = 1279;
        sArr[160] = 2077;
        sArr[161] = 2090;
        sArr[162] = 2090;
        sArr[163] = 2103;
        sArr[164] = 2090;
        sArr[165] = 2168;
        sArr[166] = 2107;
        sArr[167] = 2105;
        sArr[168] = 2100;
        sArr[169] = 2100;
        sArr[170] = 2097;
        sArr[171] = 2102;
        sArr[172] = 2111;
        sArr[173] = 2168;
        sArr[174] = 2108;
        sArr[175] = 2097;
        sArr[176] = 2091;
        sArr[177] = 2088;
        sArr[178] = 2105;
        sArr[179] = 2092;
        sArr[180] = 2107;
        sArr[181] = 2096;
        sArr[182] = 2059;
        sArr[183] = 2092;
        sArr[184] = 2105;
        sArr[185] = 2090;
        sArr[186] = 2092;
        sArr[187] = 2060;
        sArr[188] = 2109;
        sArr[189] = 2101;
        sArr[190] = 2088;
        sArr[191] = 2103;
        sArr[192] = 2090;
        sArr[193] = 2105;
        sArr[194] = 2090;
        sArr[195] = 2081;
        sArr[196] = 2076;
        sArr[197] = 2109;
        sArr[198] = 2092;
        sArr[199] = 2105;
        sArr[200] = 2107;
        sArr[201] = 2096;
        sArr[202] = 2664;
        sArr[203] = 2678;
        sArr[204] = 2673;
        sArr[205] = 2683;
        sArr[206] = 2672;
        sArr[207] = 2664;
        sArr[208] = 1155;
        sArr[209] = 1187;
        sArr[210] = 1159;
        sArr[211] = 1152;
        sArr[212] = 1190;
        sArr[213] = 1163;
        sArr[214] = 1159;
        sArr[215] = 1161;
        sArr[216] = 1158;
        sArr[217] = 1178;
        sArr[218] = 2236;
        sArr[219] = 2204;
        sArr[220] = 2232;
        sArr[221] = 2239;
        sArr[222] = 2182;
        sArr[223] = 2232;
        sArr[224] = 2229;
        sArr[225] = 2213;
        sArr[226] = 2233;
        sArr[227] = 2125;
        sArr[228] = 2145;
        sArr[229] = 2115;
        sArr[230] = 2115;
        sArr[231] = 2117;
        sArr[232] = 2131;
        sArr[233] = 2131;
        sArr[234] = 2121;
        sArr[235] = 2114;
        sArr[236] = 2121;
        sArr[237] = 2124;
        sArr[238] = 2121;
        sArr[239] = 2132;
        sArr[240] = 2137;
        sArr[241] = 2148;
        sArr[242] = 2117;
        sArr[243] = 2124;
        sArr[244] = 2117;
        sArr[245] = 2119;
        sArr[246] = 2113;
        sArr[247] = 2132;
        sArr[248] = 2117;
        sArr[249] = 1614;
        sArr[250] = 1603;
        sArr[251] = 1575;
        sArr[252] = 1635;
        sArr[253] = 1640;
        sArr[254] = 1634;
        sArr[255] = 1652;
        sArr[256] = 1575;
        sArr[257] = 1641;
        sArr[258] = 1640;
        sArr[259] = 1651;
        sArr[260] = 1575;
        sArr[261] = 1653;
        sArr[262] = 1634;
        sArr[263] = 1633;
        sArr[264] = 1634;
        sArr[265] = 1653;
        sArr[266] = 1634;
        sArr[267] = 1641;
        sArr[268] = 1636;
        sArr[269] = 1634;
        sArr[270] = 1575;
        sArr[271] = 1638;
        sArr[272] = 1575;
        sArr[273] = 1617;
        sArr[274] = 1646;
        sArr[275] = 1634;
        sArr[276] = 1648;
        sArr[277] = 1575;
        sArr[278] = 1646;
        sArr[279] = 1641;
        sArr[280] = 1652;
        sArr[281] = 1646;
        sArr[282] = 1635;
        sArr[283] = 1634;
        sArr[284] = 1575;
        sArr[285] = 1651;
        sArr[286] = 1647;
        sArr[287] = 1646;
        sArr[288] = 1652;
        sArr[289] = 1575;
        sArr[290] = 1617;
        sArr[291] = 1646;
        sArr[292] = 1634;
        sArr[293] = 1648;
        sArr[294] = 455;
        sArr[295] = 508;
        sArr[296] = 499;
        sArr[297] = 496;
        sArr[298] = 510;
        sArr[299] = 503;
        sArr[300] = 434;
        sArr[301] = 486;
        sArr[302] = 509;
        sArr[303] = 434;
        sArr[304] = 507;
        sArr[305] = 508;
        sArr[306] = 484;
        sArr[307] = 509;
        sArr[308] = 505;
        sArr[309] = 503;
        sArr[310] = 434;
        sArr[311] = 497;
        sArr[312] = 506;
        sArr[313] = 507;
        sArr[314] = 510;
        sArr[315] = 502;
        sArr[316] = 480;
        sArr[317] = 503;
        sArr[318] = 508;
        sArr[319] = 470;
        sArr[320] = 480;
        sArr[321] = 499;
        sArr[322] = 485;
        sArr[323] = 507;
        sArr[324] = 508;
        sArr[325] = 501;
        sArr[326] = 477;
        sArr[327] = 480;
        sArr[328] = 502;
        sArr[329] = 503;
        sArr[330] = 480;
        sArr[331] = 471;
        sArr[332] = 508;
        sArr[333] = 499;
        sArr[334] = 496;
        sArr[335] = 510;
        sArr[336] = 503;
        sArr[337] = 502;
        sArr[338] = 597;
        sArr[339] = 618;
        sArr[340] = 614;
        sArr[341] = 628;
        sArr[342] = 576;
        sArr[343] = 620;
        sArr[344] = 622;
        sArr[345] = 627;
        sArr[346] = 610;
        sArr[347] = 631;
        sArr[348] = 1834;
        sArr[349] = 1852;
        sArr[350] = 1837;
        sArr[351] = 1818;
        sArr[352] = 1841;
        sArr[353] = 1840;
        sArr[354] = 1845;
        sArr[355] = 1853;
        sArr[356] = 1835;
        sArr[357] = 1852;
        sArr[358] = 1847;
        sArr[359] = 1821;
        sArr[360] = 1835;
        sArr[361] = 1848;
        sArr[362] = 1838;
        sArr[363] = 1840;
        sArr[364] = 1847;
        sArr[365] = 1854;
        sArr[366] = 1814;
        sArr[367] = 1835;
        sArr[368] = 1853;
        sArr[369] = 1852;
        sArr[370] = 1835;
        sArr[371] = 1820;
        sArr[372] = 1847;
        sArr[373] = 1848;
        sArr[374] = 1851;
        sArr[375] = 1845;
        sArr[376] = 1852;
        sArr[377] = 1853;
        sArr[378] = 622;
        sArr[379] = 597;
        sArr[380] = 602;
        sArr[381] = 601;
        sArr[382] = 599;
        sArr[383] = 606;
        sArr[384] = 539;
        sArr[385] = 591;
        sArr[386] = 596;
        sArr[387] = 539;
        sArr[388] = 605;
        sArr[389] = 594;
        sArr[390] = 597;
        sArr[391] = 607;
        sArr[392] = 539;
        sArr[393] = 600;
        sArr[394] = 595;
        sArr[395] = 594;
        sArr[396] = 599;
        sArr[397] = 607;
        sArr[398] = 585;
        sArr[399] = 606;
        sArr[400] = 597;
        sArr[401] = 639;
        sArr[402] = 585;
        sArr[403] = 602;
        sArr[404] = 588;
        sArr[405] = 594;
        sArr[406] = 597;
        sArr[407] = 604;
        sArr[408] = 628;
        sArr[409] = 585;
        sArr[410] = 607;
        sArr[411] = 606;
        sArr[412] = 585;
        sArr[413] = 638;
        sArr[414] = 597;
        sArr[415] = 602;
        sArr[416] = 601;
        sArr[417] = 599;
        sArr[418] = 606;
        sArr[419] = 607;
        f38short = sArr;
        TAG = C0104.m40(f38short, 1753639 ^ C0008.m27((Object) "ۦۦۧ"), 1754375 ^ C0008.m27((Object) "ۧ۟ۥ"), C0008.m27((Object) "ۥۢ۠") ^ 1750511);
        sNextGeneratedId = new AtomicInteger(((Integer) objArr[1]).intValue() ^ 1936173);
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
    }

    protected ViewCompat() {
    }

    public static void addKeyboardNavigationClusters(View view, Collection<View> collection, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.addKeyboardNavigationClusters(collection, i2);
        }
    }

    public static void addOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayMap arrayMap = (Map) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayMap == null) {
                arrayMap = new ArrayMap();
                view.setTag(R.id.tag_unhandled_key_listeners, arrayMap);
            }
            OnUnhandledKeyEventListenerWrapper onUnhandledKeyEventListenerWrapper = new OnUnhandledKeyEventListenerWrapper(onUnhandledKeyEventListenerCompat);
            arrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListenerWrapper);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListenerWrapper);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(R.id.tag_unhandled_key_listeners, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            UnhandledKeyEventManager.registerListeningView(view);
        }
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    private static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = View.class.getDeclaredMethod(C0001.m3(f38short, 1747791 ^ C0008.m27((Object) "ۣ۠ۨ"), 1750759 ^ C0008.m27((Object) "ۣۧ۟"), C0008.m27((Object) "ۥۤۤ") ^ 1752289), new Class[0]);
            sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod(C0521.m71(f38short, 1748827 ^ C0008.m27((Object) "ۣۡۧ"), 1754448 ^ C0008.m27((Object) "ۧۡۧ"), C0008.m27((Object) "ۣۢۨ") ^ 1749236), new Class[0]);
        } catch (NoSuchMethodException e2) {
            Log.e(C0108.m52(f38short, 1748930 ^ C0008.m27((Object) "ۡۧۧ"), 1747850 ^ C0008.m27((Object) "۠ۥۥ"), C0008.m27((Object) "۟ۤۧ") ^ 1746075), C0522.m72(f38short, 1750767 ^ C0008.m27((Object) "ۣۣۤ"), 1747854 ^ C0008.m27((Object) "۠ۦ۠"), C0008.m27((Object) "ۣۤۧ") ^ 1752113), e2);
        }
        sTempDetachBound = true;
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i2) {
        return view.canScrollHorizontally(i2);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    public static void cancelDragAndDrop(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.cancelDragAndDrop();
        }
    }

    @Deprecated
    public static int combineMeasuredStates(int i2, int i3) {
        return View.combineMeasuredStates(i2, i3);
    }

    private static void compatOffsetLeftAndRight(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT < 21) {
            return windowInsetsCompat;
        }
        WindowInsets windowInsets = (WindowInsets) WindowInsetsCompat.unwrap(windowInsetsCompat);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(dispatchApplyWindowInsets);
        }
        return WindowInsetsCompat.wrap(windowInsets);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchFinishTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchFinishTemporaryDetach;
        if (method == null) {
            view.onFinishTemporaryDetach();
            return;
        }
        try {
            method.invoke(view, new Object[0]);
        } catch (Exception e2) {
            Log.d(C0005.m17(f38short, 56197 ^ C0008.m27((Object) "ۣ۟"), 1750697 ^ C0008.m27((Object) "ۣۤۤ"), C0008.m27((Object) "۟ۥۨ") ^ 1746620), C0006.m19(f38short, 1752680 ^ C0008.m27((Object) "ۥۣۡ"), 56564 ^ C0008.m27((Object) "ۧۦ"), C0008.m27((Object) "ۡ") ^ 878), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedFling(View view, float f2, float f3, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedFling(f2, f3, z);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).dispatchNestedFling(f2, f3, z);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreFling(View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedPreFling(f2, f3);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).dispatchNestedPreFling(f2, f3);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(View view, int i2, int i3, int[] iArr, int[] iArr2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(View view, int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
        }
        if (i4 == 0) {
            return dispatchNestedPreScroll(view, i2, i3, iArr, iArr2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(View view, int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
        }
        if (i6 == 0) {
            return dispatchNestedScroll(view, i2, i3, i4, i5, iArr);
        }
        return false;
    }

    public static void dispatchStartTemporaryDetach(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchStartTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchStartTemporaryDetach;
        if (method == null) {
            view.onStartTemporaryDetach();
            return;
        }
        try {
            method.invoke(view, new Object[0]);
        } catch (Exception e2) {
            Log.d(C0000.m1(f38short, 1754579 ^ C0008.m27((Object) "ۧۡ۟"), 1750668 ^ C0008.m27((Object) "ۣۣۦ"), C0008.m27((Object) "۠۟ۧ") ^ 1748547), C0105.m44(f38short, 56549 ^ C0008.m27((Object) "ۢۧ"), 1746868 ^ C0008.m27((Object) "ۣ۟ۤ"), C0008.m27((Object) "ۢۡ") ^ 54375), e2);
        }
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view).dispatch(view, keyEvent);
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view).preDispatch(keyEvent);
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i2;
        int intValue;
        Integer num = new Integer(9919351);
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = sNextGeneratedId;
            i2 = atomicInteger.get();
            intValue = (((Integer) new Object[]{num}[0]).intValue() ^ 9919350) + i2;
            if (intValue > 16777215) {
                intValue = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, intValue));
        return i2;
    }

    public static int getAccessibilityLiveRegion(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = view.getAccessibilityNodeProvider()) == null) {
            return null;
        }
        return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList getBackgroundTintList(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static Rect getClipBounds(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static Display getDisplay(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (!isAttachedToWindow(view)) {
            return null;
        }
        return ((WindowManager) view.getContext().getSystemService(C0000.m1(f38short, 56436 ^ C0008.m27((Object) "ۦۤ"), 1753604 ^ C0008.m27((Object) "ۦۥۡ"), C0008.m27((Object) "ۢ۠۠") ^ 1751165))).getDefaultDisplay();
    }

    public static float getElevation(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal<>();
        }
        Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean getFitsSystemWindows(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int getImportantForAccessibility(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static int getImportantForAutofill(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int getLabelFor(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLabelFor();
        }
        return 0;
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!sMinHeightFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField(C0003.m11(f38short, 1751349 ^ C0008.m27((Object) "ۤ۠ۡ"), 1751723 ^ C0008.m27((Object) "ۤۦۣ"), C0008.m27((Object) "۠۟ۤ") ^ 1748523));
                sMinHeightField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            sMinHeightFieldFetched = true;
        }
        Field field = sMinHeightField;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception e3) {
            }
        }
        return 0;
    }

    public static int getMinimumWidth(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!sMinWidthFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField(C0008.m24(f38short, 56410 ^ C0008.m27((Object) "ۤۤ"), 1752513 ^ C0008.m27((Object) "ۥۡۤ"), C0008.m27((Object) "ۤۡ۟") ^ 1749715));
                sMinWidthField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            sMinWidthFieldFetched = true;
        }
        Field field = sMinWidthField;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception e3) {
            }
        }
        return 0;
    }

    public static int getNextClusterForwardId(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getNextClusterForwardId();
        }
        return -1;
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    public static int getPaddingEnd(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static int getPaddingStart(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static ViewParent getParentForAccessibility(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getScrollIndicators();
        }
        return 0;
    }

    public static String getTransitionName(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = sTransitionNameMap;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static int getWindowSystemUiVisibility(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean hasAccessibilityDelegate(View view) {
        if (sAccessibilityDelegateCheckFailed) {
            return false;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField(C0005.m17(f38short, 1753382 ^ C0008.m27((Object) "ۦۣۢ"), 1754374 ^ C0008.m27((Object) "ۧ۟ۨ"), C0008.m27((Object) "ۧۡۥ") ^ 1756523));
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                sAccessibilityDelegateCheckFailed = true;
                return false;
            }
        }
        try {
            return sAccessibilityDelegateField.get(view) != null;
        } catch (Throwable th2) {
            sAccessibilityDelegateCheckFailed = true;
            return false;
        }
    }

    public static boolean hasExplicitFocusable(View view) {
        return Build.VERSION.SDK_INT >= 26 ? view.hasExplicitFocusable() : view.hasFocusable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.hasNestedScrollingParent();
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).hasNestedScrollingParent();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(View view, int i2) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i2);
        } else if (i2 == 0) {
            return hasNestedScrollingParent(view);
        }
        return false;
    }

    public static boolean hasOnClickListeners(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean hasOverlappingRendering(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean hasTransientState(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean isAttachedToWindow(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean isFocusedByDefault(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isFocusedByDefault();
        }
        return false;
    }

    public static boolean isImportantForAccessibility(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isImportantForAccessibility();
        }
        return true;
    }

    public static boolean isImportantForAutofill(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isImportantForAutofill();
        }
        return true;
    }

    public static boolean isInLayout(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.isInLayout();
        }
        return false;
    }

    public static boolean isKeyboardNavigationCluster(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isKeyboardNavigationCluster();
        }
        return false;
    }

    public static boolean isLaidOut(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean isLayoutDirectionResolved(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLayoutDirectionResolved();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isNestedScrollingEnabled(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).isNestedScrollingEnabled();
        }
        return false;
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view, View view2, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.keyboardNavigationClusterSearch(view2, i2);
        }
        return null;
    }

    public static void offsetLeftAndRight(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            compatOffsetLeftAndRight(view, i2);
            return;
        }
        Rect emptyTempRect = getEmptyTempRect();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        compatOffsetLeftAndRight(view, i2);
        if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(emptyTempRect);
        }
    }

    public static void offsetTopAndBottom(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            compatOffsetTopAndBottom(view, i2);
            return;
        }
        Rect emptyTempRect = getEmptyTempRect();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        compatOffsetTopAndBottom(view, i2);
        if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(emptyTempRect);
        }
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT < 21) {
            return windowInsetsCompat;
        }
        WindowInsets windowInsets = (WindowInsets) WindowInsetsCompat.unwrap(windowInsetsCompat);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(onApplyWindowInsets);
        }
        return WindowInsetsCompat.wrap(windowInsets);
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public static boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void postInvalidateOnAnimation(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void postInvalidateOnAnimation(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        if (Build.VERSION.SDK_INT >= 28) {
            Map map = (Map) view.getTag(R.id.tag_unhandled_key_listeners);
            if (map == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) map.get(onUnhandledKeyEventListenerCompat)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(view);
            }
        }
    }

    public static void requestApplyInsets(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static <T extends View> T requireViewById(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) view.requireViewById(i2);
        }
        T t = (T) view.findViewById(i2);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(C0106.m46(f38short, 1749922 ^ C0008.m27((Object) "ۢۨۡ"), 1752453 ^ C0008.m27((Object) "ۥۣ۠"), C0008.m27((Object) "ۣۨۡ") ^ 1749275));
    }

    @Deprecated
    public static int resolveSizeAndState(int i2, int i3, int i4) {
        return View.resolveSizeAndState(i2, i3, i4);
    }

    public static boolean restoreDefaultFocus(View view) {
        return Build.VERSION.SDK_INT >= 26 ? view.restoreDefaultFocus() : view.requestFocus();
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
    }

    public static void setAccessibilityLiveRegion(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean z) {
        view.setActivated(z);
    }

    @Deprecated
    public static void setAlpha(View view, float f2) {
        view.setAlpha(f2);
    }

    public static void setAutofillHints(View view, String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setAutofillHints(strArr);
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT < 21) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        view.setBackgroundTintList(colorStateList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT < 21) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        view.setBackgroundTintMode(mode);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        Integer num = new Integer(4293841);
        String m46 = C0106.m46(f38short, 1750788 ^ C0008.m27((Object) "ۣ۠۟"), 1752717 ^ C0008.m27((Object) "ۥۨۤ"), C0008.m27((Object) "۠ۧ۟") ^ 1747498);
        Method method = sChildrenDrawingOrderMethod;
        int intValue = 4293840 ^ ((Integer) new Object[]{num}[0]).intValue();
        String m72 = C0522.m72(f38short, 1748876 ^ C0008.m27((Object) "ۡۢ۟"), 1750743 ^ C0008.m27((Object) "ۣۦ۠"), C0008.m27((Object) "ۣ۟ۦ") ^ 1746305);
        if (method == null) {
            try {
                String m19 = C0006.m19(f38short, 1755323 ^ C0008.m27((Object) "ۨۨۧ"), 1747804 ^ C0008.m27((Object) "ۣ۠ۥ"), C0008.m27((Object) "ۧۨۨ") ^ 1753470);
                Class[] clsArr = new Class[intValue];
                clsArr[0] = Boolean.TYPE;
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod(m19, clsArr);
            } catch (NoSuchMethodException e2) {
                Log.e(m72, C0523.m77(f38short, 1749593 ^ C0008.m27((Object) "ۢۦۧ"), 1749866 ^ C0008.m27((Object) "ۢۧۥ"), C0008.m27((Object) "ۢۧۢ") ^ 1749254), e2);
            }
            sChildrenDrawingOrderMethod.setAccessible(intValue);
        }
        try {
            Method method2 = sChildrenDrawingOrderMethod;
            Object[] objArr = new Object[intValue];
            objArr[0] = Boolean.valueOf(z);
            method2.invoke(viewGroup, objArr);
        } catch (IllegalAccessException e3) {
            Log.e(m72, m46, e3);
        } catch (IllegalArgumentException e4) {
            Log.e(m72, m46, e4);
        } catch (InvocationTargetException e5) {
            Log.e(m72, m46, e5);
        }
    }

    public static void setClipBounds(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void setElevation(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setFocusedByDefault(z);
        }
    }

    public static void setHasTransientState(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void setImportantForAccessibility(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static void setImportantForAutofill(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static void setKeyboardNavigationCluster(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setKeyboardNavigationCluster(z);
        }
    }

    public static void setLabelFor(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLabelFor(i2);
        }
    }

    public static void setLayerPaint(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
        } else {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    @Deprecated
    public static void setLayerType(View view, int i2, Paint paint) {
        view.setLayerType(i2, paint);
    }

    public static void setLayoutDirection(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayoutDirection(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setNestedScrollingEnabled(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z);
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
        }
    }

    public static void setNextClusterForwardId(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setNextClusterForwardId(i2);
        }
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewCompat.1
                    AnonymousClass1() {
                    }

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return (WindowInsets) WindowInsetsCompat.unwrap(OnApplyWindowInsetsListener.this.onApplyWindowInsets(view2, WindowInsetsCompat.wrap(windowInsets)));
                    }
                });
            }
        }
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i2) {
        view.setOverScrollMode(i2);
    }

    public static void setPaddingRelative(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    @Deprecated
    public static void setPivotX(View view, float f2) {
        view.setPivotX(f2);
    }

    @Deprecated
    public static void setPivotY(View view, float f2) {
        view.setPivotY(f2);
    }

    public static void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
        }
    }

    @Deprecated
    public static void setRotation(View view, float f2) {
        view.setRotation(f2);
    }

    @Deprecated
    public static void setRotationX(View view, float f2) {
        view.setRotationX(f2);
    }

    @Deprecated
    public static void setRotationY(View view, float f2) {
        view.setRotationY(f2);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @Deprecated
    public static void setScaleX(View view, float f2) {
        view.setScaleX(f2);
    }

    @Deprecated
    public static void setScaleY(View view, float f2) {
        view.setScaleY(f2);
    }

    public static void setScrollIndicators(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2);
        }
    }

    public static void setScrollIndicators(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        }
    }

    public static void setTransitionName(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (sTransitionNameMap == null) {
            sTransitionNameMap = new WeakHashMap<>();
        }
        sTransitionNameMap.put(view, str);
    }

    @Deprecated
    public static void setTranslationX(View view, float f2) {
        view.setTranslationX(f2);
    }

    @Deprecated
    public static void setTranslationY(View view, float f2) {
        view.setTranslationY(f2);
    }

    public static void setTranslationZ(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    @Deprecated
    public static void setX(View view, float f2) {
        view.setX(f2);
    }

    @Deprecated
    public static void setY(View view, float f2) {
        view.setY(f2);
    }

    public static void setZ(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(f2);
        }
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? view.startDragAndDrop(clipData, dragShadowBuilder, obj, i2) : view.startDrag(clipData, dragShadowBuilder, obj, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.startNestedScroll(i2);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).startNestedScroll(i2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(View view, int i2, int i3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i2, i3);
        }
        if (i3 == 0) {
            return startNestedScroll(view, i2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).stopNestedScroll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(View view, int i2) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i2);
        } else if (i2 == 0) {
            stopNestedScroll(view);
        }
    }

    private static void tickleInvalidationFlag(View view) {
        Float f2 = new Float(1.0f);
        float translationY = view.getTranslationY();
        view.setTranslationY(((Float) new Object[]{f2}[0]).floatValue() + translationY);
        view.setTranslationY(translationY);
    }

    public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }
}
