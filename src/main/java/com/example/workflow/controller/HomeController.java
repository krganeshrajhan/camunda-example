package com.example.workflow.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home() {
        return "hello";
    }

    @RequestMapping(value="/execute/{processKey}", method = RequestMethod.GET)
    public String execute(@PathVariable("processKey") String processKey) {
        ProcessInstantiationBuilder instance = getProcessInstantiationBuilder(processKey);

        String item = "Computer";

        instance.setVariable("itemName", item);

        instance.businessKey("execute-endpoint");

        instance.executeWithVariablesInReturn();
        return "BPMN has executed";
    }

    @RequestMapping(value="/tasks", method = RequestMethod.GET)
    public String tasks() {
        ProcessInstantiationBuilder instance = getProcessInstantiationBuilder("all_tasks");

        instance.executeWithVariablesInReturn();

        return "Task BPMN has executed";
    }

    private static ProcessInstantiationBuilder getProcessInstantiationBuilder(String bpmId) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService()
                .createProcessInstanceByKey(bpmId);
        return instance;
    }

}
