package com.example.workflow.delegates;

import com.jcraft.jsch.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

public class JumpHostScriptExecutor implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Get connection parameters from process variables or configuration
        String jumpHostName = (String) execution.getVariable("jumpHostName");
        int jumpHostPort = Integer.parseInt((String) execution.getVariable("jumpHostPort"));
        String jumpHostUser = (String) execution.getVariable("jumpHostUser");
        String jumpHostPassword = (String) execution.getVariable("jumpHostPassword");
        String scriptToExecute = (String) execution.getVariable("scriptToExecute");

        JSch jsch = new JSch();
        Session session = null;
        Channel channel = null;

        try {
            // Establish connection to jump host
            session = jsch.getSession(jumpHostUser, jumpHostName, jumpHostPort);
            session.setPassword(jumpHostPassword);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();

            // Execute command
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(scriptToExecute);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
            ((ChannelExec) channel).setOutputStream(outputStream);
            ((ChannelExec) channel).setErrStream(errorStream);

            channel.connect();

            // Wait for command to complete
            while (!channel.isClosed()) {
                Thread.sleep(100);
            }

            // Store results in process variables
            execution.setVariable("scriptOutput", outputStream.toString());
            execution.setVariable("scriptError", errorStream.toString());
            execution.setVariable("scriptExitCode", ((ChannelExec) channel).getExitStatus());

        } finally {
            // Clean up resources
            if (channel != null) channel.disconnect();
            if (session != null) session.disconnect();
        }
    }
}
