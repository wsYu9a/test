package kotlin.jvm;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import f.b.a.d;
import f.b.a.e;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001b\n\u0002\b\n\u001a!\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068G@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"/\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00078G@\u0006¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\f\")\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0012*\u00028\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0016\"/\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\f\"=\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078Ç\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001a\u0010\f¨\u0006\u001c"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "", "isArrayOf", "([Ljava/lang/Object;)Z", "Ljava/lang/Class;", "Lkotlin/reflect/KClass;", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "kotlin", "getJavaObjectType", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaObjectType", "getJavaClass", "java$annotations", "(Lkotlin/reflect/KClass;)V", "java", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "annotationClass", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass", "getJavaPrimitiveType", "javaPrimitiveType", "getRuntimeClassOfKClassInstance", "javaClass$annotations", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "JvmClassMappingKt")
/* loaded from: classes.dex */
public final class JvmClassMappingKt {
    @d
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@d T annotationClass) {
        Intrinsics.checkParameterIsNotNull(annotationClass, "$this$annotationClass");
        Class<? extends Annotation> annotationType = annotationClass.annotationType();
        Intrinsics.checkExpressionValueIsNotNull(annotationType, "(this as java.lang.annot…otation).annotationType()");
        KClass<? extends T> kotlinClass = getKotlinClass(annotationType);
        if (kotlinClass != null) {
            return kotlinClass;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }

    @d
    @JvmName(name = "getJavaClass")
    public static final <T> Class<T> getJavaClass(@d KClass<T> java) {
        Intrinsics.checkParameterIsNotNull(java, "$this$java");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) java).getJClass();
        if (cls != null) {
            return cls;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @d
    public static final <T> Class<T> getJavaObjectType(@d KClass<T> javaObjectType) {
        Intrinsics.checkParameterIsNotNull(javaObjectType, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) javaObjectType).getJClass();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                }
                break;
            case 104431:
                if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                }
                break;
        }
        return cls;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @e
    public static final <T> Class<T> getJavaPrimitiveType(@d KClass<T> javaPrimitiveType) {
        Intrinsics.checkParameterIsNotNull(javaPrimitiveType, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) javaPrimitiveType).getJClass();
        if (cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    @d
    @JvmName(name = "getKotlinClass")
    public static final <T> KClass<T> getKotlinClass(@d Class<T> kotlin2) {
        Intrinsics.checkParameterIsNotNull(kotlin2, "$this$kotlin");
        return Reflection.getOrCreateKotlinClass(kotlin2);
    }

    @d
    @JvmName(name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@d KClass<T> javaClass) {
        Intrinsics.checkParameterIsNotNull(javaClass, "$this$javaClass");
        Class<KClass<T>> cls = (Class<KClass<T>>) javaClass.getClass();
        if (cls != null) {
            return cls;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
    }

    public static final /* synthetic */ <T> boolean isArrayOf(@d Object[] isArrayOf) {
        Intrinsics.checkParameterIsNotNull(isArrayOf, "$this$isArrayOf");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(isArrayOf.getClass().getComponentType());
    }

    public static /* synthetic */ void java$annotations(KClass kClass) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void javaClass$annotations(KClass kClass) {
    }

    @d
    public static final <T> Class<T> getJavaClass(@d T javaClass) {
        Intrinsics.checkParameterIsNotNull(javaClass, "$this$javaClass");
        Class<T> cls = (Class<T>) javaClass.getClass();
        if (cls != null) {
            return cls;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }
}
