package com.smartpay.thrift.monitor;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.ServerContext;
import org.apache.thrift.server.TServerEventHandler;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TServerMonitorHandler implements TServerEventHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(TServerMonitorHandler.class);

	@Override
	public void preServe() {
		LOGGER.info("preServer ..... ");
	}

	@Override
	public ServerContext createContext(TProtocol input, TProtocol output) {

		LOGGER.info("createContext  ..... ");
		return null;
	}

	@Override
	public void deleteContext(ServerContext serverContext, TProtocol input, TProtocol output) {
		LOGGER.info("deleteContext  ..... ");
	}

	@Override
	public void processContext(ServerContext serverContext, TTransport inputTransport, TTransport outputTransport) {
		LOGGER.info("processContext  ..... ");
	}

}
