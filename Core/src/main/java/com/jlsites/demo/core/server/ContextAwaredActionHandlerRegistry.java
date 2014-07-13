package com.jlsites.demo.core.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.DefaultActionHandlerRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextAwaredActionHandlerRegistry extends
		DefaultActionHandlerRegistry implements ApplicationContextAware {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ContextAwaredActionHandlerRegistry() {
	}

	@SuppressWarnings("rawtypes")
	public void setApplicationContext(ApplicationContext context) {
		// load all action handlers from the app context
		Map<String, ActionHandler> beansMap = context
				.getBeansOfType(ActionHandler.class);

		List<ActionHandler<?, ?>> handlers = new ArrayList<ActionHandler<?, ?>>();

		for (ActionHandler handler : beansMap.values()) {
			logger.info("Apply action {} with handler {}", handler
					.getActionType().getName(), handler.getClass().getName());
			handlers.add(handler);
		}

		setActionHandlers(handlers);
	}
}
