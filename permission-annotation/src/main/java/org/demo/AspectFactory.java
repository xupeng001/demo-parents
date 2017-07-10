package org.demo;

import java.util.Map;

public interface AspectFactory {
	public Aspector getAspector(String name);

	public interface Aspector {
		public void process(Map<String, Object> paramValueMap);
	}
}
