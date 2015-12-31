package com.example.shenzhenyuan.myapplication;

/**
 * Created by shenzhenyuan on 12/24/15.
 */
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;
public interface MyInterface {
    /**
     * Invoke the Lambda function "AndroidBackendLambdaFunction".
     * The function name is the method name.
     */
    @LambdaFunction
    //ResponseClass abc(RequestClass request);
    Object abc(RequestClass request);
}