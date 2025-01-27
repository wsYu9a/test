package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0001H¦\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8&@'X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b \u0010!R\u001e\u0010(\u001a\u0004\u0018\u00010$8&@'X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0017\u001a\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00018\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0017\u001a\u0004\b,\u0010\u0015R\u001c\u0010.\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0017\u001a\u0004\b.\u0010\u0015R\u001c\u00100\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0017\u001a\u0004\b0\u0010\u0015R \u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0012R*\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000\u001e8&@'X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0017\u001a\u0004\b4\u0010!R\u001c\u00107\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0017\u001a\u0004\b7\u0010\u0015R\u001c\u00109\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0017\u001a\u0004\b9\u0010\u0015R\"\u0010>\u001a\b\u0012\u0004\u0012\u00020;0\u001e8&@'X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0017\u001a\u0004\b<\u0010!R\u0018\u0010@\u001a\u0004\u0018\u00010\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u001cR \u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030A0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0012¨\u0006D"}, d2 = {"Lkotlin/reflect/KClass;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", Downloads.RequestHeaders.COLUMN_VALUE, "", "isInstance", "(Ljava/lang/Object;)Z", AdnName.OTHER, "equals", "", TTDownloadField.TT_HASHCODE, "()I", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "constructors", "isAbstract", "()Z", "isAbstract$annotations", "()V", "isSealed", "isSealed$annotations", "", "getSimpleName", "()Ljava/lang/String;", "simpleName", "", "Lkotlin/reflect/KType;", "getSupertypes", "()Ljava/util/List;", "supertypes$annotations", "supertypes", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility$annotations", Downloads.Column.VISIBILITY, "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "isFinal", "isFinal$annotations", "isData", "isData$annotations", "isOpen", "isOpen$annotations", "getNestedClasses", "nestedClasses", "getSealedSubclasses", "sealedSubclasses$annotations", "sealedSubclasses", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$annotations", "typeParameters", "getQualifiedName", "qualifiedName", "Lkotlin/reflect/KCallable;", "getMembers", "members", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isAbstract$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isCompanion$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isData$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isFinal$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isInner$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isOpen$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isSealed$annotations() {
        }

        @SinceKotlin(version = "1.3")
        public static /* synthetic */ void sealedSubclasses$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void supertypes$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void typeParameters$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void visibility$annotations() {
        }
    }

    boolean equals(@e Object r1);

    @d
    Collection<KFunction<T>> getConstructors();

    @Override // kotlin.reflect.KDeclarationContainer
    @d
    Collection<KCallable<?>> getMembers();

    @d
    Collection<KClass<?>> getNestedClasses();

    @e
    T getObjectInstance();

    @e
    String getQualifiedName();

    @d
    List<KClass<? extends T>> getSealedSubclasses();

    @e
    String getSimpleName();

    @d
    List<KType> getSupertypes();

    @d
    List<KTypeParameter> getTypeParameters();

    @e
    KVisibility getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isInner();

    @SinceKotlin(version = "1.1")
    boolean isInstance(@e Object r1);

    boolean isOpen();

    boolean isSealed();
}
