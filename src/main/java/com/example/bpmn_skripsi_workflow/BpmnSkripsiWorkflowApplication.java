
package com.example.bpmn_skripsi_workflow;

import io.camunda.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath:pengajuan-proposal.bpmn")
public class BpmnSkripsiWorkflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BpmnSkripsiWorkflowApplication.class, args);
	}
}