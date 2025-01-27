package com.alimm.tanx.ui.image.glide.load;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MultiTransformation<T> implements Transformation<T> {

    /* renamed from: id */
    private String f6325id;
    private final Collection<? extends Transformation<T>> transformations;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = Arrays.asList(transformationArr);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        if (this.f6325id == null) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<? extends Transformation<T>> it = this.transformations.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().getId());
            }
            this.f6325id = sb2.toString();
        }
        return this.f6325id;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<T> transform(Resource<T> resource, int i10, int i11) {
        Iterator<? extends Transformation<T>> it = this.transformations.iterator();
        Resource<T> resource2 = resource;
        while (it.hasNext()) {
            Resource<T> transform = it.next().transform(resource2, i10, i11);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform)) {
                resource2.recycle();
            }
            resource2 = transform;
        }
        return resource2;
    }

    public MultiTransformation(Collection<? extends Transformation<T>> collection) {
        if (collection.size() >= 1) {
            this.transformations = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
