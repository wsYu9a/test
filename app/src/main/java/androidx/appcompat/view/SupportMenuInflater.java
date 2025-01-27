package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: a */
    static final String f417a = "SupportMenuInflater";

    /* renamed from: b */
    private static final String f418b = "menu";

    /* renamed from: c */
    private static final String f419c = "group";

    /* renamed from: d */
    private static final String f420d = "item";

    /* renamed from: e */
    static final int f421e = 0;

    /* renamed from: f */
    static final Class<?>[] f422f;

    /* renamed from: g */
    static final Class<?>[] f423g;

    /* renamed from: h */
    final Object[] f424h;

    /* renamed from: i */
    final Object[] f425i;

    /* renamed from: j */
    Context f426j;
    private Object k;

    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private static final Class<?>[] f427a = {MenuItem.class};

        /* renamed from: b */
        private Object f428b;

        /* renamed from: c */
        private Method f429c;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f428b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f429c = cls.getMethod(str, f427a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f429c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f429c.invoke(this.f428b, menuItem)).booleanValue();
                }
                this.f429c.invoke(this.f428b, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class MenuState {

        /* renamed from: a */
        private static final int f430a = 0;

        /* renamed from: b */
        private static final int f431b = 0;

        /* renamed from: c */
        private static final int f432c = 0;

        /* renamed from: d */
        private static final int f433d = 0;

        /* renamed from: e */
        private static final int f434e = 0;

        /* renamed from: f */
        private static final boolean f435f = false;

        /* renamed from: g */
        private static final boolean f436g = true;

        /* renamed from: h */
        private static final boolean f437h = true;
        private boolean A;
        private boolean B;
        private boolean C;
        private int D;
        private int E;
        private String F;
        private String G;
        private String H;
        ActionProvider I;
        private CharSequence J;
        private CharSequence K;
        private ColorStateList L = null;
        private PorterDuff.Mode M = null;

        /* renamed from: i */
        private Menu f438i;

        /* renamed from: j */
        private int f439j;
        private int k;
        private int l;
        private int m;
        private boolean n;
        private boolean o;
        private boolean p;
        private int q;
        private int r;
        private CharSequence s;
        private CharSequence t;
        private int u;
        private char v;
        private int w;
        private char x;
        private int y;
        private int z;

        public MenuState(Menu menu) {
            this.f438i = menu;
            resetGroup();
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T b(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f426j.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w(SupportMenuInflater.f417a, "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void c(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.A).setVisible(this.B).setEnabled(this.C).setCheckable(this.z >= 1).setTitleCondensed(this.t).setIcon(this.u);
            int i2 = this.D;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.H != null) {
                if (SupportMenuInflater.this.f426j.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.b(), this.H));
            }
            boolean z2 = menuItem instanceof MenuItemImpl;
            if (z2) {
            }
            if (this.z >= 2) {
                if (z2) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.F;
            if (str != null) {
                menuItem.setActionView((View) b(str, SupportMenuInflater.f422f, SupportMenuInflater.this.f424h));
                z = true;
            }
            int i3 = this.E;
            if (i3 > 0) {
                if (z) {
                    Log.w(SupportMenuInflater.f417a, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i3);
                }
            }
            ActionProvider actionProvider = this.I;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.J);
            MenuItemCompat.setTooltipText(menuItem, this.K);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.v, this.w);
            MenuItemCompat.setNumericShortcut(menuItem, this.x, this.y);
            PorterDuff.Mode mode = this.M;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.L;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }

        public void addItem() {
            this.p = true;
            c(this.f438i.add(this.f439j, this.q, this.r, this.s));
        }

        public SubMenu addSubMenuItem() {
            this.p = true;
            SubMenu addSubMenu = this.f438i.addSubMenu(this.f439j, this.q, this.r, this.s);
            c(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean hasAddedItem() {
            return this.p;
        }

        public void readGroup(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f426j.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f439j = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.k = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.l = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.m = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.n = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.o = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void readItem(AttributeSet attributeSet) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(SupportMenuInflater.this.f426j, attributeSet, R.styleable.MenuItem);
            this.q = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.r = (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.k) & (-65536)) | (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.l) & 65535);
            this.s = obtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.t = obtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.u = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.v = a(obtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.w = obtainStyledAttributes.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.x = a(obtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
            this.y = obtainStyledAttributes.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            int i2 = R.styleable.MenuItem_android_checkable;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.z = obtainStyledAttributes.getBoolean(i2, false) ? 1 : 0;
            } else {
                this.z = this.m;
            }
            this.A = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.B = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.n);
            this.C = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.o);
            this.D = obtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.H = obtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.E = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.F = obtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            String string = obtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            this.G = string;
            boolean z = string != null;
            if (z && this.E == 0 && this.F == null) {
                this.I = (ActionProvider) b(string, SupportMenuInflater.f423g, SupportMenuInflater.this.f425i);
            } else {
                if (z) {
                    Log.w(SupportMenuInflater.f417a, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.I = null;
            }
            this.J = obtainStyledAttributes.getText(R.styleable.MenuItem_contentDescription);
            this.K = obtainStyledAttributes.getText(R.styleable.MenuItem_tooltipText);
            int i3 = R.styleable.MenuItem_iconTintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.M = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), this.M);
            } else {
                this.M = null;
            }
            int i4 = R.styleable.MenuItem_iconTint;
            if (obtainStyledAttributes.hasValue(i4)) {
                this.L = obtainStyledAttributes.getColorStateList(i4);
            } else {
                this.L = null;
            }
            obtainStyledAttributes.recycle();
            this.p = false;
        }

        public void resetGroup() {
            this.f439j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = true;
            this.o = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f422f = clsArr;
        f423g = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f426j = context;
        Object[] objArr = {context};
        this.f424h = objArr;
        this.f425i = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals(androidx.appcompat.view.SupportMenuInflater.f419c) == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.resetGroup();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals(androidx.appcompat.view.SupportMenuInflater.f420d) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.hasAddedItem() != false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.I;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.hasSubMenu() == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.addSubMenuItem();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.addItem();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals(androidx.appcompat.view.SupportMenuInflater.f418b) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals(androidx.appcompat.view.SupportMenuInflater.f419c) == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.readGroup(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals(androidx.appcompat.view.SupportMenuInflater.f420d) == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.readItem(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals(androidx.appcompat.view.SupportMenuInflater.f418b) == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.addSubMenuItem());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L136;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            androidx.appcompat.view.SupportMenuInflater$MenuState r0 = new androidx.appcompat.view.SupportMenuInflater$MenuState
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r4
            r6 = 0
            r7 = 0
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r8 = r4
            r7 = 0
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.resetGroup()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.hasAddedItem()
            if (r15 != 0) goto Lb9
            androidx.core.view.ActionProvider r15 = r0.I
            if (r15 == 0) goto L82
            boolean r15 = r15.hasSubMenu()
            if (r15 == 0) goto L82
            r0.addSubMenuItem()
            goto Lb9
        L82:
            r0.addItem()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = 1
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.readGroup(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.readItem(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.addSubMenuItem()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = 1
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object b() {
        if (this.k == null) {
            this.k = a(this.f426j);
        }
        return this.k;
    }

    @Override // android.view.MenuInflater
    public void inflate(@LayoutRes int i2, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f426j.getResources().getLayout(i2);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
