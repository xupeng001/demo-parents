package spring.demo.filter;

import org.springframework.beans.factory.xml.NamespaceHandler;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.scheduling.config.AnnotationDrivenBeanDefinitionParser;
import org.springframework.web.servlet.config.CorsBeanDefinitionParser;
import org.springframework.web.servlet.config.FreeMarkerConfigurerBeanDefinitionParser;
import org.springframework.web.servlet.config.GroovyMarkupConfigurerBeanDefinitionParser;
import org.springframework.web.servlet.config.ScriptTemplateConfigurerBeanDefinitionParser;
import org.springframework.web.servlet.config.TilesConfigurerBeanDefinitionParser;
import org.springframework.web.servlet.config.VelocityConfigurerBeanDefinitionParser;
import org.springframework.web.servlet.config.ViewResolversBeanDefinitionParser;

/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * {@link NamespaceHandler} for Spring MVC configuration namespace.
 *
 * @author Keith Donald
 * @author Jeremy Grelle
 * @author Sebastien Deleuze
 * @since 3.0
 */
public class ValuesNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("annotation-driven", new AnnotationDrivenBeanDefinitionParser());
//        registerBeanDefinitionParser("default-servlet-handler", new DefaultServletHandlerBeanDefinitionParser());
//        registerBeanDefinitionParser("interceptors", new InterceptorsBeanDefinitionParser());
//        registerBeanDefinitionParser("resources", new ResourcesBeanDefinitionParser());
//        registerBeanDefinitionParser("view-controller", new ViewControllerBeanDefinitionParser());
//        registerBeanDefinitionParser("redirect-view-controller", new ViewControllerBeanDefinitionParser());
//        registerBeanDefinitionParser("status-controller", new ViewControllerBeanDefinitionParser());
        registerBeanDefinitionParser("view-resolvers", new ViewResolversBeanDefinitionParser());
        registerBeanDefinitionParser("tiles-configurer", new TilesConfigurerBeanDefinitionParser());
        registerBeanDefinitionParser("freemarker-configurer", new FreeMarkerConfigurerBeanDefinitionParser());
        registerBeanDefinitionParser("velocity-configurer", new VelocityConfigurerBeanDefinitionParser());
        registerBeanDefinitionParser("groovy-configurer", new GroovyMarkupConfigurerBeanDefinitionParser());
        registerBeanDefinitionParser("script-template-configurer", new ScriptTemplateConfigurerBeanDefinitionParser());
        registerBeanDefinitionParser("cors", new CorsBeanDefinitionParser());
    }

}
