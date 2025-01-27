package com.google.common.graph;

import h5.s;

@s
/* loaded from: classes2.dex */
public final class GraphConstants {

    /* renamed from: a, reason: collision with root package name */
    public static final int f9983a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static final int f9984b = 10;

    /* renamed from: c, reason: collision with root package name */
    public static final int f9985c = 20;

    /* renamed from: d, reason: collision with root package name */
    public static final float f9986d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    public static final int f9987e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final String f9988f = "Node %s is not an element of this graph.";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9989g = "Edge %s is not an element of this graph.";

    /* renamed from: h, reason: collision with root package name */
    public static final String f9990h = "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.";

    /* renamed from: i, reason: collision with root package name */
    public static final String f9991i = "Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.";

    /* renamed from: j, reason: collision with root package name */
    public static final String f9992j = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.";

    /* renamed from: k, reason: collision with root package name */
    public static final String f9993k = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";

    /* renamed from: l, reason: collision with root package name */
    public static final String f9994l = "Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.";

    /* renamed from: m, reason: collision with root package name */
    public static final String f9995m = "Edge %s already exists in the graph.";

    /* renamed from: n, reason: collision with root package name */
    public static final String f9996n = "Mismatch: unordered endpoints cannot be used with directed graphs";

    public enum Presence {
        EDGE_EXISTS
    }
}
