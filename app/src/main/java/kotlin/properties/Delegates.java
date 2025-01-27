package kotlin.properties;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u007f\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00028\u00002Q\b\u0004\u0010\u000f\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J\u007f\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00028\u00002Q\b\u0004\u0010\u000f\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00120\u0007H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lkotlin/properties/Delegates;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/properties/ReadWriteProperty;", "notNull", "()Lkotlin/properties/ReadWriteProperty;", "initialValue", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", "name", "property", "oldValue", "newValue", "", "onChange", "observable", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "", "vetoable", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class Delegates {
    public static final Delegates INSTANCE = new Delegates();

    private Delegates() {
    }

    @d
    public final <T> ReadWriteProperty<Object, T> notNull() {
        return new NotNullVar();
    }

    @d
    public final <T> ReadWriteProperty<Object, T> observable(final T initialValue, @d final Function3<? super KProperty<?>, ? super T, ? super T, Unit> onChange) {
        Intrinsics.checkParameterIsNotNull(onChange, "onChange");
        return new ObservableProperty<T>(initialValue) { // from class: kotlin.properties.Delegates$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(@d KProperty<?> property, T oldValue, T newValue) {
                Intrinsics.checkParameterIsNotNull(property, "property");
                Function3.this.invoke(property, oldValue, newValue);
            }
        };
    }

    @d
    public final <T> ReadWriteProperty<Object, T> vetoable(final T initialValue, @d final Function3<? super KProperty<?>, ? super T, ? super T, Boolean> onChange) {
        Intrinsics.checkParameterIsNotNull(onChange, "onChange");
        return new ObservableProperty<T>(initialValue) { // from class: kotlin.properties.Delegates$vetoable$1
            @Override // kotlin.properties.ObservableProperty
            protected boolean beforeChange(@d KProperty<?> property, T oldValue, T newValue) {
                Intrinsics.checkParameterIsNotNull(property, "property");
                return ((Boolean) Function3.this.invoke(property, oldValue, newValue)).booleanValue();
            }
        };
    }
}
