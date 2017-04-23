package org.sample.serivce.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

import org.springframework.stereotype.Component;

@Activate(group = Constants.PROVIDER, value = "ProviderFilter")
public class ProviderFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = invoker.invoke(invocation);
        /**
         * TODO
         */
        System.err.println("=========ProviderFilter===========");
        return result;
    }

}
