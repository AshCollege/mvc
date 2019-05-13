package com.dev.Aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Aspect
@Component
public class CalculateMethodsExecutionTimeAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateMethodsExecutionTimeAspect.class);

//    @Around("(execution(* com.dev.Controllers.BaseController.*(..))) || " +
//            "(execution(* com.dev.Controllers.CandidateDashboardController.*(..))) && " +
//            "!(execution(* com.dev.Controllers.BaseController.initBinder(..)))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object retVal = null;
        if (isDebugEnabled()) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            retVal = joinPoint.proceed();
            stopWatch.stop();
            LOGGER.info(joinPoint.getSignature() + " [execution time: " + stopWatch.getTotalTimeMillis() + " ms / " + stopWatch.getTotalTimeSeconds() + " sec");
        } else {
            retVal = joinPoint.proceed();
        }
        return retVal;
    }

    private boolean isDebugEnabled() {
        return false;
    }


}
