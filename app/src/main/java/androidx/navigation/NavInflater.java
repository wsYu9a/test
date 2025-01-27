package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class NavInflater {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";

    /* renamed from: a */
    private static final String f3022a = "argument";

    /* renamed from: b */
    private static final String f3023b = "deepLink";

    /* renamed from: c */
    private static final String f3024c = "action";

    /* renamed from: d */
    private static final String f3025d = "include";

    /* renamed from: e */
    private static final ThreadLocal<TypedValue> f3026e = new ThreadLocal<>();

    /* renamed from: f */
    private Context f3027f;

    /* renamed from: g */
    private NavigatorProvider f3028g;

    public NavInflater(@NonNull Context context, @NonNull NavigatorProvider navigatorProvider) {
        this.f3027f = context;
        this.f3028g = navigatorProvider;
    }

    private static NavType a(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) throws XmlPullParserException {
        if (navType == null || navType == navType2) {
            return navType != null ? navType : navType2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    @NonNull
    private NavDestination b(@NonNull Resources resources, @NonNull XmlResourceParser xmlResourceParser, @NonNull AttributeSet attributeSet, int i2) throws XmlPullParserException, IOException {
        int depth;
        NavDestination createDestination = this.f3028g.getNavigator(xmlResourceParser.getName()).createDestination();
        createDestination.onInflate(this.f3027f, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if (f3022a.equals(name)) {
                    f(resources, createDestination, attributeSet, i2);
                } else if (f3023b.equals(name)) {
                    g(resources, createDestination, attributeSet);
                } else if ("action".equals(name)) {
                    c(resources, createDestination, attributeSet, xmlResourceParser, i2);
                } else if (f3025d.equals(name) && (createDestination instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                    ((NavGraph) createDestination).addDestination(inflate(obtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                    obtainAttributes.recycle();
                } else if (createDestination instanceof NavGraph) {
                    ((NavGraph) createDestination).addDestination(b(resources, xmlResourceParser, attributeSet, i2));
                }
            }
        }
        return createDestination;
    }

    private void c(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i2) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavAction);
        int resourceId = obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_destination, 0));
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_launchSingleTop, false));
        builder.setPopUpTo(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popUpTo, -1), obtainAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToInclusive, false));
        builder.setEnterAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && f3022a.equals(xmlResourceParser.getName())) {
                e(resources, bundle, attributeSet, i2);
            }
        }
        if (!bundle.isEmpty()) {
            navAction.setDefaultArguments(bundle);
        }
        navDestination.putAction(resourceId, navAction);
        obtainAttributes.recycle();
    }

    @NonNull
    private NavArgument d(@NonNull TypedArray typedArray, @NonNull Resources resources, int i2) throws XmlPullParserException {
        NavArgument.Builder builder = new NavArgument.Builder();
        builder.setIsNullable(typedArray.getBoolean(androidx.navigation.common.R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = f3026e;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.common.R.styleable.NavArgument_argType);
        Object obj = null;
        NavType<?> fromArgType = string != null ? NavType.fromArgType(string, resources.getResourcePackageName(i2)) : null;
        int i3 = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue;
        if (typedArray.getValue(i3, typedValue)) {
            NavType<Integer> navType = NavType.ReferenceType;
            if (fromArgType == navType) {
                int i4 = typedValue.resourceId;
                if (i4 != 0) {
                    obj = Integer.valueOf(i4);
                } else {
                    if (typedValue.type != 16 || typedValue.data != 0) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + fromArgType.getName() + ". Must be a reference to a resource.");
                    }
                    obj = 0;
                }
            } else {
                int i5 = typedValue.resourceId;
                if (i5 != 0) {
                    if (fromArgType != null) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + fromArgType.getName() + ". You must use a \"" + navType.getName() + "\" type to reference other resources.");
                    }
                    fromArgType = navType;
                    obj = Integer.valueOf(i5);
                } else if (fromArgType == NavType.StringType) {
                    obj = typedArray.getString(i3);
                } else {
                    int i6 = typedValue.type;
                    if (i6 == 3) {
                        String charSequence = typedValue.string.toString();
                        if (fromArgType == null) {
                            fromArgType = NavType.a(charSequence);
                        }
                        obj = fromArgType.parseValue(charSequence);
                    } else if (i6 == 4) {
                        fromArgType = a(typedValue, fromArgType, NavType.FloatType, string, "float");
                        obj = Float.valueOf(typedValue.getFloat());
                    } else if (i6 == 5) {
                        fromArgType = a(typedValue, fromArgType, NavType.IntType, string, "dimension");
                        obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i6 == 18) {
                        fromArgType = a(typedValue, fromArgType, NavType.BoolType, string, "boolean");
                        obj = Boolean.valueOf(typedValue.data != 0);
                    } else {
                        if (i6 < 16 || i6 > 31) {
                            throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                        }
                        fromArgType = a(typedValue, fromArgType, NavType.IntType, string, "integer");
                        obj = Integer.valueOf(typedValue.data);
                    }
                }
            }
        }
        if (obj != null) {
            builder.setDefaultValue(obj);
        }
        if (fromArgType != null) {
            builder.setType(fromArgType);
        }
        return builder.build();
    }

    private void e(@NonNull Resources resources, @NonNull Bundle bundle, @NonNull AttributeSet attributeSet, int i2) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        NavArgument d2 = d(obtainAttributes, resources, i2);
        if (d2.isDefaultValuePresent()) {
            d2.a(string, bundle);
        }
        obtainAttributes.recycle();
    }

    private void f(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet, int i2) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        navDestination.addArgument(string, d(obtainAttributes, resources, i2));
        obtainAttributes.recycle();
    }

    private void g(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavDeepLink);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_mimeType);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            builder.setUriPattern(string.replace(APPLICATION_ID_PLACEHOLDER, this.f3027f.getPackageName()));
        }
        if (!TextUtils.isEmpty(string2)) {
            builder.setAction(string2.replace(APPLICATION_ID_PLACEHOLDER, this.f3027f.getPackageName()));
        }
        if (string3 != null) {
            builder.setMimeType(string3.replace(APPLICATION_ID_PLACEHOLDER, this.f3027f.getPackageName()));
        }
        navDestination.addDeepLink(builder.build());
        obtainAttributes.recycle();
    }

    @NonNull
    @SuppressLint({"ResourceType"})
    public NavGraph inflate(@NavigationRes int i2) {
        int next;
        Resources resources = this.f3027f.getResources();
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i2) + " line " + xml.getLineNumber(), e2);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        NavDestination b2 = b(resources, xml, asAttributeSet, i2);
        if (b2 instanceof NavGraph) {
            return (NavGraph) b2;
        }
        throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
    }
}
