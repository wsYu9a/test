package o5;

import b5.u;
import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import e5.w;
import e5.z1;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.CheckForNull;

@a5.a
@d
/* loaded from: classes2.dex */
public final class h implements AnnotatedElement {

    /* renamed from: a */
    public final com.google.common.reflect.a<?, ?> f29059a;

    /* renamed from: b */
    public final int f29060b;

    /* renamed from: c */
    public final TypeToken<?> f29061c;

    /* renamed from: d */
    public final ImmutableList<Annotation> f29062d;

    public h(com.google.common.reflect.a<?, ?> aVar, int i10, TypeToken<?> typeToken, Annotation[] annotationArr) {
        this.f29059a = aVar;
        this.f29060b = i10;
        this.f29061c = typeToken;
        this.f29062d = ImmutableList.copyOf(annotationArr);
    }

    public com.google.common.reflect.a<?, ?> a() {
        return this.f29059a;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f29060b == hVar.f29060b && this.f29059a.equals(hVar.f29059a);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        u.E(cls);
        z1<Annotation> it = this.f29062d.iterator();
        while (it.hasNext()) {
            Annotation next = it.next();
            if (cls.isInstance(next)) {
                return cls.cast(next);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return (A[]) getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        u.E(cls);
        return (A) w.r(this.f29062d).n(cls).o().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) this.f29062d.toArray(new Annotation[0]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (A[]) ((Annotation[]) w.r(this.f29062d).n(cls).B(cls));
    }

    public TypeToken<?> getType() {
        return this.f29061c;
    }

    public int hashCode() {
        return this.f29060b;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f29061c);
        int i10 = this.f29060b;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 15);
        sb2.append(valueOf);
        sb2.append(" arg");
        sb2.append(i10);
        return sb2.toString();
    }
}
