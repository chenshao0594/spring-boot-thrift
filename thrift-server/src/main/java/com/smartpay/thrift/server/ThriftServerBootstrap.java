package com.smartpay.thrift.server;

import org.apache.thrift.server.TServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Configuration;

import com.smartpay.thrift.server.config.ThriftRegisterConfiguration;

/**
 * Created by dragon on 16/4/12.
 */

@Configuration
@ConditionalOnBean(TServer.class)
@AutoConfigureAfter({ThriftRegisterConfiguration.class})
public class ThriftServerBootstrap implements SmartLifecycle {

	@Autowired
	private TServer server;

	private int phase = Integer.MAX_VALUE;

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable runnable) {
		if (isRunning()) {
			server.setShouldStop(true);
			server.stop();
			if (runnable != null) {
				runnable.run();
			}
		}
	}

	@Override
	public void start() {
		if (server == null) {
			return;
		}
		ThriftServer thriftServer = new ThriftServer(server);
		Thread runnerThread = new Thread(thriftServer, "thrift server");
		runnerThread.start();
	}


	@Override
	public void stop() {
		stop(null);
	}

	@Override
	public boolean isRunning() {
		if (server != null) {
			return server.isServing();
		}
		return false;
	}

	@Override
	public int getPhase() {
		return this.phase;
	}

	class ThriftServer implements Runnable {

		private TServer server;

		ThriftServer(TServer server) {
			this.server = server;
		}

		@Override
		public void run() {
			if (server != null) {
				this.server.serve();
			}
		}
	}
}
