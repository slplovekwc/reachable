package com.slp.reachable.service;

import com.slp.reachable.common.ErrorCode;
import com.slp.reachable.exception.BusinessException;

/**
 * @author 孙乐平
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        try {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        } catch (RuntimeException e) {
            //可以抓住RuntimeException及其子类异常
            System.out.println("lalal");
        } finally {
        }
    }
}
