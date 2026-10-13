
package com.example.bpmn_skripsi_workflow;

import io.camunda.client.CamundaClient;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class WorkflowController {

    private final CamundaClient camundaClient;

    public WorkflowController(CamundaClient camundaClient) {
        this.camundaClient = camundaClient;
    }

    @PostMapping("/api/proposals/start")
    public Map<String, Object> startProposal(
            @RequestBody Map<String, Object> proposal) {

        var result = camundaClient
                .newCreateInstanceCommand()
                .bpmnProcessId("pengajuan_proposal")
                .latestVersion()
                .variables(proposal)
                .send()
                .join();

        return Map.of(
                "message", "Pengajuan proposal berhasil dikirim",
                "processInstanceKey", result.getProcessInstanceKey(),
                "proposal", proposal
        );
    }
}