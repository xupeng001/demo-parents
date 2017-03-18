package org.demo.mapper.restful;

/**
 * 类ICallback.java的实现描述：TODO 类实现描述 
 * @author wb199502 2017年3月9日 上午10:22:48
 */
public interface ICallback<T extends Object> {

    /**
     * @param t
     */
    void callback(T t);
}
