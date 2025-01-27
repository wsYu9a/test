package androidx.appcompat.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class StateListDrawable extends DrawableContainer {
    private static final String q = "StateListDrawable";
    private static final boolean r = false;
    private StateListState s;
    private boolean t;

    static class StateListState extends DrawableContainer.DrawableContainerState {
        int[][] J;

        StateListState(StateListState stateListState, StateListDrawable stateListDrawable, Resources resources) {
            super(stateListState, stateListDrawable, resources);
            if (stateListState != null) {
                this.J = stateListState.J;
            } else {
                this.J = new int[e()][];
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        void g() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void growArray(int i2, int i3) {
            super.growArray(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.J, 0, iArr, 0, i2);
            this.J = iArr;
        }

        int k(int[] iArr, Drawable drawable) {
            int addChild = addChild(drawable);
            this.J[addChild] = iArr;
            return addChild;
        }

        int l(int[] iArr) {
            int[][] iArr2 = this.J;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawable(this, resources);
        }
    }

    StateListDrawable() {
        this(null, null);
    }

    private void s(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        StateListState stateListState = this.s;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                int resourceId = obtainAttributes.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                Drawable drawable = resourceId > 0 ? ResourceManagerInternal.get().getDrawable(context, resourceId) : null;
                obtainAttributes.recycle();
                int[] m = m(attributeSet);
                if (drawable == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    drawable = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
                stateListState.k(m, drawable);
            }
        }
    }

    private void t(TypedArray typedArray) {
        StateListState stateListState = this.s;
        if (Build.VERSION.SDK_INT >= 21) {
            stateListState.f382d |= typedArray.getChangingConfigurations();
        }
        stateListState.f387i = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, stateListState.f387i);
        stateListState.l = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, stateListState.l);
        stateListState.A = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, stateListState.A);
        stateListState.B = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, stateListState.B);
        stateListState.x = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, stateListState.x);
    }

    public void addState(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.s.k(iArr, drawable);
            onStateChange(getState());
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    void b() {
        super.b();
        this.t = false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    void i(@NonNull DrawableContainer.DrawableContainerState drawableContainerState) {
        super.i(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.s = (StateListState) drawableContainerState;
        }
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        t(obtainAttributes);
        k(resources);
        obtainAttributes.recycle();
        s(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public StateListState l() {
        return new StateListState(this.s, this, null);
    }

    int[] m(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.t && super.mutate() == this) {
            this.s.g();
            this.t = true;
        }
        return this;
    }

    int n() {
        return this.s.getChildCount();
    }

    Drawable o(int i2) {
        return this.s.getChild(i2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int l = this.s.l(iArr);
        if (l < 0) {
            l = this.s.l(StateSet.WILD_CARD);
        }
        return h(l) || onStateChange;
    }

    int p(int[] iArr) {
        return this.s.l(iArr);
    }

    StateListState q() {
        return this.s;
    }

    int[] r(int i2) {
        return this.s.J[i2];
    }

    StateListDrawable(StateListState stateListState, Resources resources) {
        i(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    StateListDrawable(@Nullable StateListState stateListState) {
        if (stateListState != null) {
            i(stateListState);
        }
    }
}
