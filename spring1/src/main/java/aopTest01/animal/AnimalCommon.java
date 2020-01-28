package aopTest01.animal;

import org.aspectj.lang.ProceedingJoinPoint;

public class AnimalCommon {
	
	public void printAround(ProceedingJoinPoint joinpoint) { 
		try {
		System.out.println("점심 뭐 먹었어요?");
		Object val = joinpoint.proceed();
		System.out.println(joinpoint.getTarget().getClass().getSimpleName()+"님은 "+val+" 먹었군요.");
		}catch(Throwable e) {}
	}

}
