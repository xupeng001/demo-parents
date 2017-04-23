package com.state.controller;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


import com.state.config.SimpleStateMachineConfig;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.config.model.StateMachineModelFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.statemachine.config.model.ConfigurationData;
import org.springframework.statemachine.config.model.StatesData;
import org.springframework.statemachine.config.model.TransitionsData;
import org.springframework.statemachine.config.model.StateMachineModel;
import org.springframework.statemachine.config.model.StateMachineModel;
import org.springframework.statemachine.config.ObjectStateMachineFactory;
import org.springframework.statemachine.config.AbstractStateMachineFactory;
import org.springframework.statemachine.config.AbstractStateMachineFactory;
import org.springframework.statemachine.state.State;
import com.state.config.Events;
import com.state.config.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private StateMachine<States, Events> stateMachine;
	StateMachineFactory<States, Events> factory;

	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createOrder(HttpServletRequest request) {

		stateMachine.start();
		System.out.println(stateMachine);
		ServletContext context = request.getSession().getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(context);

		StateMachine bean = ctx.getBean(StateMachine.class);
 		System.out.println(bean);
		// stateMachine = new ObjectStateMachineFactory(
		// new StateMachineModel<States, Events>() {
		//
		// @Override
		// public ConfigurationData<States, Events> getConfigurationData() {
		// // TODO Auto-generated method stub
		// return null;
		// }
		//
		// @Override
		// public StatesData<States, Events> getStatesData() {
		// // TODO Auto-generated method stub
		// return null;
		// }
		//
		// @Override
		// public TransitionsData<States, Events> getTransitionsData() {
		// // TODO Auto-generated method stub
		// return null;
		// }
		//
		// }).
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/pay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String payOrder() {
		stateMachine.sendEvent(Events.PAY);
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/receive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String receiveOrder() {
		stateMachine.sendEvent(Events.RECEIVE);
		stateMachine.stop();
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/state", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String stateOrder() {
		State<States, Events> state = stateMachine.getState();
		System.out.println(state);
		return UUID.randomUUID().toString();
	}
}
