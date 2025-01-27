package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f.b.a.d;
import f.b.a.e;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\b\u0012\u0004\u0012\u00028\u00020\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005:\u0001\u0010J\u001f\u0010\b\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H&¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H'¢\u0006\u0004\b\u000b\u0010\tR(\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/KProperty2;", "D", ExifInterface.LONGITUDE_EAST, "R", "Lkotlin/reflect/KProperty;", "Lkotlin/Function2;", "receiver1", "receiver2", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", "Lkotlin/reflect/KProperty2$Getter;", "getGetter", "()Lkotlin/reflect/KProperty2$Getter;", "getter", "Getter", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public interface KProperty2<D, E, R> extends KProperty<R>, Function2<D, E, R> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0006\b\u0005\u0010\u0003 \u00012\b\u0012\u0004\u0012\u00028\u00050\u00042\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/KProperty2$Getter;", "D", ExifInterface.LONGITUDE_EAST, "R", "Lkotlin/reflect/KProperty$Getter;", "Lkotlin/Function2;", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    public interface Getter<D, E, R> extends KProperty.Getter<R>, Function2<D, E, R> {
    }

    R get(D d2, E e2);

    @e
    @SinceKotlin(version = "1.1")
    Object getDelegate(D receiver1, E receiver2);

    @Override // kotlin.reflect.KProperty
    @d
    Getter<D, E, R> getGetter();
}
