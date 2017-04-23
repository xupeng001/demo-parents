package org.sample.portal.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

import org.springframework.stereotype.Component;

@Activate(group = Constants.CONSUMER, value = "ConsumerFilter")
public class ConsumerFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = invoker.invoke(invocation);
        /**
         * TODO
         */
        System.err.println("=========ConsumerFilter===========");
        return result;
    }

}
