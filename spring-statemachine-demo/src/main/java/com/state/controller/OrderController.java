package com.state.controller;

import java.util.HashMap;
import java.util.Map;
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

	private StateMachine<States, Events> stateMachine;
	@Autowired
	private StateMachineFactory<States, Events> factory;

	private final Map<String, StateMachine<States, Events>> machines = new HashMap<>();

	private String orderId = UUID.randomUUID().toString();

	private synchronized StateMachine<States, Events> getMachine(String id) {
		orderId = UUID.randomUUID().toString();
		StateMachine<States, Events> machine = machines.get(id);
		if (machine == null) {
			machine = factory.getStateMachine(id);
			machines.put(id, machine);
		}
		return machine;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createOrder(HttpServletRequest request) {
		stateMachine = getMachine(orderId);
		stateMachine.start();
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/pay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String payOrder() {
		stateMachine = getMachine(orderId);
		stateMachine.sendEvent(Events.PAY);
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/receive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String receiveOrder() {
		stateMachine = getMachine(orderId);
		stateMachine.sendEvent(Events.RECEIVE);
		stateMachine.stop();
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/state", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String stateOrder() {
		stateMachine = getMachine(orderId);
		State<States, Events> state = stateMachine.getState();
		System.out.println(state);
		return UUID.randomUUID().toString();
	}
}
