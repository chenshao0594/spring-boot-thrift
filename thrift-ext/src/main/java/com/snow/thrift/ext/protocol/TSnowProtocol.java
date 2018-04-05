package com.snow.thrift.ext.protocol;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolDecorator;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransport;

import com.snow.thrift.ext.ThreadTraceSpan;
import com.snow.thrift.ext.TraceSpanGenerator;
import com.snow.thrift.ext.trace.TraceSpan;

public class TSnowProtocol extends TProtocolDecorator {
	private TraceSpanGenerator func;// 跟踪ID产生函数

	public static class Factory implements TProtocolFactory {
		private static final long serialVersionUID = 1L;
		private TProtocolFactory protocolFactory;
		private TraceSpanGenerator func;

		public Factory(TProtocolFactory protocolFactory) {
			this.protocolFactory = protocolFactory;
		}

		public Factory(TProtocolFactory protocolFactory, TraceSpanGenerator func) {
			this.protocolFactory = protocolFactory;
			this.func = func;

		}

		@Override
		public TProtocol getProtocol(TTransport trans) {
			if (this.func != null) {
				return new TSnowProtocol(this.protocolFactory.getProtocol(trans), this.func);
			} else {
				return new TSnowProtocol(this.protocolFactory.getProtocol(trans));
			}
		}

	}

	public TSnowProtocol(TProtocol protocol) {
		super(protocol);
		this.func = TraceSpanGenerator.instance();
	}

	public TSnowProtocol(TProtocol protocol, TraceSpanGenerator func) {
		super(protocol);
		this.func = func;

	}

	@Override
	public void writeMessageEnd() throws TException {
		TraceSpan trace = ThreadTraceSpan.get();
		if (trace == null) {
			trace = ThreadTraceSpan.genTraceID(this.func);
			ThreadTraceSpan.set(trace);
		}
		trace.write(this);
		super.writeMessageEnd();
	}

	@Override
	public void readMessageEnd() throws TException {
		TraceSpan trace = new TraceSpan();
		trace.read(this);
		if (!trace.isSetTraceID()) {
			throw new TProtocolException(TProtocolException.INVALID_DATA, "Expected traceID is null");
		}
		ThreadTraceSpan.set(trace);
		super.readMessageEnd();
	}
}
