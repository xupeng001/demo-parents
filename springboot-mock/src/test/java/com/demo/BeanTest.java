package com.demo;

import com.demo.interf.ActionService;
import com.demo.interf.MessageService;
import com.demo.interf.MessageUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@PrepareForTest({ MessageUtil.class })
public class BeanTest {

	@Autowired
	@InjectMocks
	MessageService messageService;

	@Mock
	private ActionService actionService;

	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(MessageUtil.class);
		PowerMockito.when(MessageUtil.name()).thenReturn("static-->name");

		Mockito.when(actionService.doSay("name")).thenReturn("name");
	}

	@Test
	public void test() {
		// 和上面的before 2选1
		// when(actionService.doSay(anyString())).thenReturn("helloworld");
		System.out.println(messageService.say("name"));
		verify(actionService, times(1));

	}
}
