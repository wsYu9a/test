package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b
@DoNotMock("Use ImmutableClassToInstanceMap or MutableClassToInstanceMap")
@m
/* loaded from: classes2.dex */
public interface h<B> extends Map<Class<? extends B>, B> {
    @CheckForNull
    <T extends B> T getInstance(Class<T> cls);

    @CanIgnoreReturnValue
    @CheckForNull
    <T extends B> T putInstance(Class<T> cls, T t10);
}
