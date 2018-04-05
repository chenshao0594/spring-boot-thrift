package com.snow.thrift.ext;

import com.snow.thrift.ext.trace.TraceSpan;

public class ThreadTraceSpan {
	// 线程本地变量，子线程也能读取父线程设置变量，服务调用子线程调用其他的服务场景
	@SuppressWarnings("rawtypes")
	private static ThreadLocal threadLocal = new InheritableThreadLocal();

	@SuppressWarnings("unchecked")
	public static <T> void set(T traceID) {
		threadLocal.set(traceID);
	}

	@SuppressWarnings("unchecked")
	public static <T> T get() {
		return (T) threadLocal.get();
	}

	public static TraceSpan genTraceID(TraceSpanGenerator func) {
		return func.generate();
	}

}
