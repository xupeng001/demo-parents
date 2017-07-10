package com.state.config;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.statemachine.config.StateMachineBuilder.Builder;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

public class BuilderMachine {

	public StateMachine<String, String> buildMachine() throws Exception {
		Builder<String, String> builder = StateMachineBuilder.builder();
		builder.configureStates()
				.withStates()
				.initial("S1")
				.end("SF")
				.states(new HashSet<String>(Arrays.asList("S1", "S2", "S3",
						"S4")));
		return builder.build();
	}
}
