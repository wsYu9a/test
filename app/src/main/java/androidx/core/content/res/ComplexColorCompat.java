package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ComplexColorCompat {

    /* renamed from: a */
    private static final String f1692a = "ComplexColorCompat";

    /* renamed from: b */
    private final Shader f1693b;

    /* renamed from: c */
    private final ColorStateList f1694c;

    /* renamed from: d */
    private int f1695d;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, @ColorInt int i2) {
        this.f1693b = shader;
        this.f1694c = colorStateList;
        this.f1695d = i2;
    }

    @NonNull
    private static ComplexColorCompat a(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(GradientColorInflaterCompat.c(resources, xml, asAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static ComplexColorCompat b(@ColorInt int i2) {
        return new ComplexColorCompat(null, null, i2);
    }

    static ComplexColorCompat c(@NonNull ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    static ComplexColorCompat d(@NonNull Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    @Nullable
    public static ComplexColorCompat inflate(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) {
        try {
            return a(resources, i2, theme);
        } catch (Exception e2) {
            Log.e(f1692a, "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    @ColorInt
    public int getColor() {
        return this.f1695d;
    }

    @Nullable
    public Shader getShader() {
        return this.f1693b;
    }

    public boolean isGradient() {
        return this.f1693b != null;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return this.f1693b == null && (colorStateList = this.f1694c) != null && colorStateList.isStateful();
    }

    public boolean onStateChanged(int[] iArr) {
        if (isStateful()) {
            ColorStateList colorStateList = this.f1694c;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f1695d) {
                this.f1695d = colorForState;
                return true;
            }
        }
        return false;
    }

    public void setColor(@ColorInt int i2) {
        this.f1695d = i2;
    }

    public boolean willDraw() {
        return isGradient() || this.f1695d != 0;
    }
}
