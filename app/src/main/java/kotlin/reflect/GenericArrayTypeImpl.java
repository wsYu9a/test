package kotlin.reflect;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/GenericArrayTypeImpl;", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/TypeImpl;", "elementType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "equals", "", AdnName.OTHER, "", "getGenericComponentType", "getTypeName", "", TTDownloadField.TT_HASHCODE, "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ExperimentalStdlibApi
/* loaded from: classes4.dex */
final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl {

    @k
    private final Type elementType;

    public GenericArrayTypeImpl(@k Type elementType) {
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        this.elementType = elementType;
    }

    public boolean equals(@l Object r22) {
        return (r22 instanceof GenericArrayType) && Intrinsics.areEqual(getElementType(), ((GenericArrayType) r22).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @k
    /* renamed from: getGenericComponentType, reason: from getter */
    public Type getElementType() {
        return this.elementType;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    @k
    public String getTypeName() {
        String typeToString;
        StringBuilder sb2 = new StringBuilder();
        typeToString = TypesJVMKt.typeToString(this.elementType);
        sb2.append(typeToString);
        sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return sb2.toString();
    }

    public int hashCode() {
        return getElementType().hashCode();
    }

    @k
    public String toString() {
        return getTypeName();
    }
}
