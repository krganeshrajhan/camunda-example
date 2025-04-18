package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FetchEmail implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Coming from FetchEmail Delegate");

        System.out.println("userIdInput in FetchEmail Delegate :: "  + delegateExecution.getVariable("userIdInput"));

        delegateExecution.setVariable("userEmailIdFromDelegate", "ganesh@gmail.com");
    }

}
