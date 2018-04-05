package com.snow.thrift.ext;

import com.snow.thrift.ext.trace.TraceSpan;

public final class TraceSpanGenerator {

	public static TraceSpanGenerator instance() {
		return new TraceSpanGenerator();
	}

	public static TraceSpan generate() {
		TraceSpan ts = new TraceSpan();
		ts.setTraceID(Long.toString(System.currentTimeMillis()));
		ts.setCallInfo("Service");
		return ts;
	}
}
