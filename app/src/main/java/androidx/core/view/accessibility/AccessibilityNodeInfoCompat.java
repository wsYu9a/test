package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;

    /* renamed from: a */
    private static final String f2116a = "AccessibilityNodeInfo.roleDescription";

    /* renamed from: b */
    private static final String f2117b = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";

    /* renamed from: c */
    private static final String f2118c = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";

    /* renamed from: d */
    private static final String f2119d = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";

    /* renamed from: e */
    private static final String f2120e = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";

    /* renamed from: f */
    private static final String f2121f = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";

    /* renamed from: g */
    private static final String f2122g = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";

    /* renamed from: h */
    private static final String f2123h = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";

    /* renamed from: i */
    private static final String f2124i = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";

    /* renamed from: j */
    private static final String f2125j = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final int k = 1;
    private static final int l = 2;
    private static final int m = 4;
    private static final int n = 8;
    private static int o;
    private final AccessibilityNodeInfo p;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId = -1;
    private int q = -1;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_UP;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;

        /* renamed from: a */
        private static final String f2126a = "A11yActionCompat";

        /* renamed from: b */
        final Object f2127b;

        /* renamed from: c */
        private final int f2128c;

        /* renamed from: d */
        private final Class<? extends AccessibilityViewCommand.CommandArguments> f2129d;

        /* renamed from: e */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final AccessibilityViewCommand f2130e;
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, null);
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, null);
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, null);
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetTextArguments.class);

        static {
            int i2 = Build.VERSION.SDK_INT;
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            ACTION_PAGE_UP = new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        }

        public AccessibilityActionCompat(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.f2128c, charSequence, accessibilityViewCommand, this.f2129d);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.f2127b;
            return obj2 == null ? accessibilityActionCompat.f2127b == null : obj2.equals(accessibilityActionCompat.f2127b);
        }

        public int getId() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2127b).getId();
            }
            return 0;
        }

        public CharSequence getLabel() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2127b).getLabel();
            }
            return null;
        }

        public int hashCode() {
            Object obj = this.f2127b;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(View view, Bundle bundle) {
            if (this.f2130e == null) {
                return false;
            }
            AccessibilityViewCommand.CommandArguments commandArguments = null;
            Class<? extends AccessibilityViewCommand.CommandArguments> cls = this.f2129d;
            if (cls != null) {
                try {
                    AccessibilityViewCommand.CommandArguments newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        newInstance.setBundle(bundle);
                        commandArguments = newInstance;
                    } catch (Exception e2) {
                        e = e2;
                        commandArguments = newInstance;
                        Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = this.f2129d;
                        Log.e(f2126a, "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                        return this.f2130e.perform(view, commandArguments);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            return this.f2130e.perform(view, commandArguments);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int i2, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i2, charSequence, accessibilityViewCommand, null);
        }

        AccessibilityActionCompat(Object obj) {
            this(obj, 0, null, null, null);
        }

        private AccessibilityActionCompat(int i2, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this(null, i2, charSequence, null, cls);
        }

        AccessibilityActionCompat(Object obj, int i2, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.f2128c = i2;
            this.f2130e = accessibilityViewCommand;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f2127b = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.f2127b = obj;
            }
            this.f2129d = cls;
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;

        /* renamed from: a */
        final Object f2133a;

        RangeInfoCompat(Object obj) {
            this.f2133a = obj;
        }

        public static RangeInfoCompat obtain(int i2, float f2, float f3, float f4) {
            return Build.VERSION.SDK_INT >= 19 ? new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4)) : new RangeInfoCompat(null);
        }

        public float getCurrent() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.RangeInfo) this.f2133a).getCurrent();
            }
            return 0.0f;
        }

        public float getMax() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.RangeInfo) this.f2133a).getMax();
            }
            return 0.0f;
        }

        public float getMin() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.RangeInfo) this.f2133a).getMin();
            }
            return 0.0f;
        }

        public int getType() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.RangeInfo) this.f2133a).getType();
            }
            return 0;
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.p = (AccessibilityNodeInfo) obj;
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        c(f2122g).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        c(f2123h).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        c(f2124i).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        c(f2121f).add(Integer.valueOf(i2));
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.getExtras().remove(f2122g);
            this.p.getExtras().remove(f2123h);
            this.p.getExtras().remove(f2124i);
            this.p.getExtras().remove(f2121f);
        }
    }

    private List<Integer> c(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.p.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.p.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String d(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    private boolean e(int i2) {
        Bundle extras = getExtras();
        return extras != null && (extras.getInt(f2120e, 0) & i2) == i2;
    }

    private SparseArray<WeakReference<ClickableSpan>> f(View view) {
        SparseArray<WeakReference<ClickableSpan>> g2 = g(view);
        if (g2 != null) {
            return g2;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> g(View view) {
        return (SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private boolean h() {
        return !c(f2122g).isEmpty();
    }

    private int i(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals(sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = o;
        o = i3 + 1;
        return i3;
    }

    private void j(View view) {
        SparseArray<WeakReference<ClickableSpan>> g2 = g(view);
        if (g2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < g2.size(); i2++) {
                if (g2.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                g2.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    private void k(int i2, boolean z) {
        Bundle extras = getExtras();
        if (extras != null) {
            int i3 = extras.getInt(f2120e, 0) & (i2 ^ (-1));
            if (!z) {
                i2 = 0;
            }
            extras.putInt(f2120e, i2 | i3);
        }
    }

    static AccessibilityNodeInfoCompat l(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrap(AccessibilityNodeInfo.obtain(view));
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public void addAction(int i2) {
        this.p.addAction(i2);
    }

    public void addChild(View view) {
        this.p.addChild(view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence charSequence, View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 26) {
            return;
        }
        b();
        j(view);
        ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
        if (clickableSpans == null || clickableSpans.length <= 0) {
            return;
        }
        getExtras().putInt(f2125j, androidx.core.R.id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> f2 = f(view);
        for (int i3 = 0; i3 < clickableSpans.length; i3++) {
            int i4 = i(clickableSpans[i3], f2);
            f2.put(i4, new WeakReference<>(clickableSpans[i3]));
            a(clickableSpans[i3], (Spanned) charSequence, i4);
        }
    }

    public boolean canOpenPopup() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.p.canOpenPopup();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.p;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.p != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.p)) {
            return false;
        }
        return this.q == accessibilityNodeInfoCompat.q && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.p.findAccessibilityNodeInfosByText(str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(wrap(findAccessibilityNodeInfosByText.get(i2)));
        }
        return arrayList;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        if (Build.VERSION.SDK_INT < 18) {
            return Collections.emptyList();
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.p.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        Iterator<AccessibilityNodeInfo> it = findAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(wrap(it.next()));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat findFocus(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return l(this.p.findFocus(i2));
        }
        return null;
    }

    public AccessibilityNodeInfoCompat focusSearch(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return l(this.p.focusSearch(i2));
        }
        return null;
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.p.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i2)));
        }
        return arrayList;
    }

    public int getActions() {
        return this.p.getActions();
    }

    @Deprecated
    public void getBoundsInParent(Rect rect) {
        this.p.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(Rect rect) {
        this.p.getBoundsInScreen(rect);
    }

    public AccessibilityNodeInfoCompat getChild(int i2) {
        return l(this.p.getChild(i2));
    }

    public int getChildCount() {
        return this.p.getChildCount();
    }

    public CharSequence getClassName() {
        return this.p.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionInfo = this.p.getCollectionInfo()) == null) {
            return null;
        }
        return new CollectionInfoCompat(collectionInfo);
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.p.getCollectionItemInfo()) == null) {
            return null;
        }
        return new CollectionItemInfoCompat(collectionItemInfo);
    }

    public CharSequence getContentDescription() {
        return this.p.getContentDescription();
    }

    public int getDrawingOrder() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.p.getDrawingOrder();
        }
        return 0;
    }

    public CharSequence getError() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.p.getError();
        }
        return null;
    }

    public Bundle getExtras() {
        return Build.VERSION.SDK_INT >= 19 ? this.p.getExtras() : new Bundle();
    }

    @Nullable
    public CharSequence getHintText() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.p.getHintText();
        }
        if (i2 >= 19) {
            return this.p.getExtras().getCharSequence(f2119d);
        }
        return null;
    }

    @Deprecated
    public Object getInfo() {
        return this.p;
    }

    public int getInputType() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.p.getInputType();
        }
        return 0;
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        if (Build.VERSION.SDK_INT >= 17) {
            return l(this.p.getLabelFor());
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        if (Build.VERSION.SDK_INT >= 17) {
            return l(this.p.getLabeledBy());
        }
        return null;
    }

    public int getLiveRegion() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.p.getLiveRegion();
        }
        return 0;
    }

    public int getMaxTextLength() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.p.getMaxTextLength();
        }
        return -1;
    }

    public int getMovementGranularities() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.p.getMovementGranularities();
        }
        return 0;
    }

    public CharSequence getPackageName() {
        return this.p.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return this.p.getPaneTitle();
        }
        if (i2 >= 19) {
            return this.p.getExtras().getCharSequence(f2117b);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getParent() {
        return l(this.p.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo;
        if (Build.VERSION.SDK_INT < 19 || (rangeInfo = this.p.getRangeInfo()) == null) {
            return null;
        }
        return new RangeInfoCompat(rangeInfo);
    }

    @Nullable
    public CharSequence getRoleDescription() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.p.getExtras().getCharSequence(f2116a);
        }
        return null;
    }

    public CharSequence getText() {
        if (!h()) {
            return this.p.getText();
        }
        List<Integer> c2 = c(f2122g);
        List<Integer> c3 = c(f2123h);
        List<Integer> c4 = c(f2124i);
        List<Integer> c5 = c(f2121f);
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.p.getText(), 0, this.p.getText().length()));
        for (int i2 = 0; i2 < c2.size(); i2++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(c5.get(i2).intValue(), this, getExtras().getInt(f2125j)), c2.get(i2).intValue(), c3.get(i2).intValue(), c4.get(i2).intValue());
        }
        return spannableString;
    }

    public int getTextSelectionEnd() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.p.getTextSelectionEnd();
        }
        return -1;
    }

    public int getTextSelectionStart() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.p.getTextSelectionStart();
        }
        return -1;
    }

    @Nullable
    public CharSequence getTooltipText() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return this.p.getTooltipText();
        }
        if (i2 >= 19) {
            return this.p.getExtras().getCharSequence(f2118c);
        }
        return null;
    }

    @Nullable
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (Build.VERSION.SDK_INT < 29 || (touchDelegateInfo = this.p.getTouchDelegateInfo()) == null) {
            return null;
        }
        return new TouchDelegateInfoCompat(touchDelegateInfo);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        if (Build.VERSION.SDK_INT >= 22) {
            return l(this.p.getTraversalAfter());
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        if (Build.VERSION.SDK_INT >= 22) {
            return l(this.p.getTraversalBefore());
        }
        return null;
    }

    public String getViewIdResourceName() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.p.getViewIdResourceName();
        }
        return null;
    }

    public AccessibilityWindowInfoCompat getWindow() {
        if (Build.VERSION.SDK_INT >= 21) {
            return AccessibilityWindowInfoCompat.b(this.p.getWindow());
        }
        return null;
    }

    public int getWindowId() {
        return this.p.getWindowId();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.p;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.p.isAccessibilityFocused();
        }
        return false;
    }

    public boolean isCheckable() {
        return this.p.isCheckable();
    }

    public boolean isChecked() {
        return this.p.isChecked();
    }

    public boolean isClickable() {
        return this.p.isClickable();
    }

    public boolean isContentInvalid() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.p.isContentInvalid();
        }
        return false;
    }

    public boolean isContextClickable() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.p.isContextClickable();
        }
        return false;
    }

    public boolean isDismissable() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.p.isDismissable();
        }
        return false;
    }

    public boolean isEditable() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.p.isEditable();
        }
        return false;
    }

    public boolean isEnabled() {
        return this.p.isEnabled();
    }

    public boolean isFocusable() {
        return this.p.isFocusable();
    }

    public boolean isFocused() {
        return this.p.isFocused();
    }

    public boolean isHeading() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.p.isHeading();
        }
        if (e(2)) {
            return true;
        }
        CollectionItemInfoCompat collectionItemInfo = getCollectionItemInfo();
        return collectionItemInfo != null && collectionItemInfo.isHeading();
    }

    public boolean isImportantForAccessibility() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.p.isImportantForAccessibility();
        }
        return true;
    }

    public boolean isLongClickable() {
        return this.p.isLongClickable();
    }

    public boolean isMultiLine() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.p.isMultiLine();
        }
        return false;
    }

    public boolean isPassword() {
        return this.p.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        return Build.VERSION.SDK_INT >= 28 ? this.p.isScreenReaderFocusable() : e(1);
    }

    public boolean isScrollable() {
        return this.p.isScrollable();
    }

    public boolean isSelected() {
        return this.p.isSelected();
    }

    public boolean isShowingHintText() {
        return Build.VERSION.SDK_INT >= 26 ? this.p.isShowingHintText() : e(4);
    }

    public boolean isTextEntryKey() {
        return Build.VERSION.SDK_INT >= 29 ? this.p.isTextEntryKey() : e(8);
    }

    public boolean isVisibleToUser() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.p.isVisibleToUser();
        }
        return false;
    }

    public boolean performAction(int i2) {
        return this.p.performAction(i2);
    }

    public void recycle() {
        this.p.recycle();
    }

    public boolean refresh() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.p.refresh();
        }
        return false;
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.p.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f2127b);
        }
        return false;
    }

    public boolean removeChild(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.p.removeChild(view);
        }
        return false;
    }

    public void setAccessibilityFocused(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.p.setAccessibilityFocused(z);
        }
    }

    @Deprecated
    public void setBoundsInParent(Rect rect) {
        this.p.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(Rect rect) {
        this.p.setBoundsInScreen(rect);
    }

    public void setCanOpenPopup(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setCanOpenPopup(z);
        }
    }

    public void setCheckable(boolean z) {
        this.p.setCheckable(z);
    }

    public void setChecked(boolean z) {
        this.p.setChecked(z);
    }

    public void setClassName(CharSequence charSequence) {
        this.p.setClassName(charSequence);
    }

    public void setClickable(boolean z) {
        this.p.setClickable(z);
    }

    public void setCollectionInfo(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).f2131a);
        }
    }

    public void setCollectionItemInfo(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f2132a);
        }
    }

    public void setContentDescription(CharSequence charSequence) {
        this.p.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setContentInvalid(z);
        }
    }

    public void setContextClickable(boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.p.setContextClickable(z);
        }
    }

    public void setDismissable(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setDismissable(z);
        }
    }

    public void setDrawingOrder(int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.p.setDrawingOrder(i2);
        }
    }

    public void setEditable(boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.p.setEditable(z);
        }
    }

    public void setEnabled(boolean z) {
        this.p.setEnabled(z);
    }

    public void setError(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.p.setError(charSequence);
        }
    }

    public void setFocusable(boolean z) {
        this.p.setFocusable(z);
    }

    public void setFocused(boolean z) {
        this.p.setFocused(z);
    }

    public void setHeading(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.p.setHeading(z);
        } else {
            k(2, z);
        }
    }

    public void setHintText(@Nullable CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.p.setHintText(charSequence);
        } else if (i2 >= 19) {
            this.p.getExtras().putCharSequence(f2119d, charSequence);
        }
    }

    public void setImportantForAccessibility(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.p.setImportantForAccessibility(z);
        }
    }

    public void setInputType(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setInputType(i2);
        }
    }

    public void setLabelFor(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.p.setLabelFor(view);
        }
    }

    public void setLabeledBy(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.p.setLabeledBy(view);
        }
    }

    public void setLiveRegion(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setLiveRegion(i2);
        }
    }

    public void setLongClickable(boolean z) {
        this.p.setLongClickable(z);
    }

    public void setMaxTextLength(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.p.setMaxTextLength(i2);
        }
    }

    public void setMovementGranularities(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.p.setMovementGranularities(i2);
        }
    }

    public void setMultiLine(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setMultiLine(z);
        }
    }

    public void setPackageName(CharSequence charSequence) {
        this.p.setPackageName(charSequence);
    }

    public void setPaneTitle(@Nullable CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.p.setPaneTitle(charSequence);
        } else if (i2 >= 19) {
            this.p.getExtras().putCharSequence(f2117b, charSequence);
        }
    }

    public void setParent(View view) {
        this.mParentVirtualDescendantId = -1;
        this.p.setParent(view);
    }

    public void setPassword(boolean z) {
        this.p.setPassword(z);
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.f2133a);
        }
    }

    public void setRoleDescription(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.getExtras().putCharSequence(f2116a, charSequence);
        }
    }

    public void setScreenReaderFocusable(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.p.setScreenReaderFocusable(z);
        } else {
            k(1, z);
        }
    }

    public void setScrollable(boolean z) {
        this.p.setScrollable(z);
    }

    public void setSelected(boolean z) {
        this.p.setSelected(z);
    }

    public void setShowingHintText(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.p.setShowingHintText(z);
        } else {
            k(4, z);
        }
    }

    public void setSource(View view) {
        this.q = -1;
        this.p.setSource(view);
    }

    public void setText(CharSequence charSequence) {
        this.p.setText(charSequence);
    }

    public void setTextEntryKey(boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.p.setTextEntryKey(z);
        } else {
            k(8, z);
        }
    }

    public void setTextSelection(int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.p.setTextSelection(i2, i3);
        }
    }

    public void setTooltipText(@Nullable CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.p.setTooltipText(charSequence);
        } else if (i2 >= 19) {
            this.p.getExtras().putCharSequence(f2118c, charSequence);
        }
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.p.setTouchDelegateInfo(touchDelegateInfoCompat.f2134a);
        }
    }

    public void setTraversalAfter(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.p.setTraversalAfter(view);
        }
    }

    public void setTraversalBefore(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.p.setTraversalBefore(view);
        }
    }

    public void setViewIdResourceName(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.p.setViewIdResourceName(str);
        }
    }

    public void setVisibleToUser(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.p.setVisibleToUser(z);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(getPackageName());
        sb.append("; className: ");
        sb.append(getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; contentDescription: ");
        sb.append(getContentDescription());
        sb.append("; viewId: ");
        sb.append(getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(isCheckable());
        sb.append("; checked: ");
        sb.append(isChecked());
        sb.append("; focusable: ");
        sb.append(isFocusable());
        sb.append("; focused: ");
        sb.append(isFocused());
        sb.append("; selected: ");
        sb.append(isSelected());
        sb.append("; clickable: ");
        sb.append(isClickable());
        sb.append("; longClickable: ");
        sb.append(isLongClickable());
        sb.append("; enabled: ");
        sb.append(isEnabled());
        sb.append("; password: ");
        sb.append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<AccessibilityActionCompat> actionList = getActionList();
            for (int i2 = 0; i2 < actionList.size(); i2++) {
                AccessibilityActionCompat accessibilityActionCompat = actionList.get(i2);
                String d2 = d(accessibilityActionCompat.getId());
                if (d2.equals("ACTION_UNKNOWN") && accessibilityActionCompat.getLabel() != null) {
                    d2 = accessibilityActionCompat.getLabel().toString();
                }
                sb.append(d2);
                if (i2 != actionList.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int actions = getActions();
            while (actions != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
                actions &= numberOfTrailingZeros ^ (-1);
                sb.append(d(numberOfTrailingZeros));
                if (actions != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.p;
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return l(AccessibilityNodeInfo.obtain(view, i2));
        }
        return null;
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.p.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f2127b);
        }
    }

    public void addChild(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.p.addChild(view, i2);
        }
    }

    public boolean performAction(int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.p.performAction(i2, bundle);
        }
        return false;
    }

    public boolean removeChild(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.p.removeChild(view, i2);
        }
        return false;
    }

    public void setLabelFor(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.p.setLabelFor(view, i2);
        }
    }

    public void setLabeledBy(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.p.setLabeledBy(view, i2);
        }
    }

    public void setParent(View view, int i2) {
        this.mParentVirtualDescendantId = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.p.setParent(view, i2);
        }
    }

    public void setSource(View view, int i2) {
        this.q = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.p.setSource(view, i2);
        }
    }

    public void setTraversalAfter(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.p.setTraversalAfter(view, i2);
        }
    }

    public void setTraversalBefore(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.p.setTraversalBefore(view, i2);
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;

        /* renamed from: a */
        final Object f2131a;

        CollectionInfoCompat(Object obj) {
            this.f2131a = obj;
        }

        public static CollectionInfoCompat obtain(int i2, int i3, boolean z, int i4) {
            int i5 = Build.VERSION.SDK_INT;
            return i5 >= 21 ? new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4)) : i5 >= 19 ? new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z)) : new CollectionInfoCompat(null);
        }

        public int getColumnCount() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionInfo) this.f2131a).getColumnCount();
            }
            return -1;
        }

        public int getRowCount() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionInfo) this.f2131a).getRowCount();
            }
            return -1;
        }

        public int getSelectionMode() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionInfo) this.f2131a).getSelectionMode();
            }
            return 0;
        }

        public boolean isHierarchical() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionInfo) this.f2131a).isHierarchical();
            }
            return false;
        }

        public static CollectionInfoCompat obtain(int i2, int i3, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z));
            }
            return new CollectionInfoCompat(null);
        }
    }

    public static class CollectionItemInfoCompat {

        /* renamed from: a */
        final Object f2132a;

        CollectionItemInfoCompat(Object obj) {
            this.f2132a = obj;
        }

        public static CollectionItemInfoCompat obtain(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            int i6 = Build.VERSION.SDK_INT;
            return i6 >= 21 ? new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2)) : i6 >= 19 ? new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z)) : new CollectionItemInfoCompat(null);
        }

        public int getColumnIndex() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2132a).getColumnIndex();
            }
            return 0;
        }

        public int getColumnSpan() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2132a).getColumnSpan();
            }
            return 0;
        }

        public int getRowIndex() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2132a).getRowIndex();
            }
            return 0;
        }

        public int getRowSpan() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2132a).getRowSpan();
            }
            return 0;
        }

        @Deprecated
        public boolean isHeading() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2132a).isHeading();
            }
            return false;
        }

        public boolean isSelected() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f2132a).isSelected();
            }
            return false;
        }

        public static CollectionItemInfoCompat obtain(int i2, int i3, int i4, int i5, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
            }
            return new CollectionItemInfoCompat(null);
        }
    }

    public static final class TouchDelegateInfoCompat {

        /* renamed from: a */
        final AccessibilityNodeInfo.TouchDelegateInfo f2134a;

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> map) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2134a = new AccessibilityNodeInfo.TouchDelegateInfo(map);
            } else {
                this.f2134a = null;
            }
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f2134a.getRegionAt(i2);
            }
            return null;
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f2134a.getRegionCount();
            }
            return 0;
        }

        @Nullable
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region region) {
            AccessibilityNodeInfo targetForRegion;
            if (Build.VERSION.SDK_INT < 29 || (targetForRegion = this.f2134a.getTargetForRegion(region)) == null) {
                return null;
            }
            return AccessibilityNodeInfoCompat.wrap(targetForRegion);
        }

        TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.f2134a = touchDelegateInfo;
        }
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.p = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrap(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.p));
    }
}
