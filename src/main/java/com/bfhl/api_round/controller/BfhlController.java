package com.bfhl.api_round.controller;

import com.bfhl.api_round.dto.BfhlRequest;
import com.bfhl.api_round.dto.BfhlResponse;
import com.bfhl.api_round.service.BfhlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BfhlController {

    private final BfhlService bfhlService;

    @PostMapping
    public ResponseEntity<BfhlResponse> processData(@RequestBody BfhlRequest request) {
        try {
            BfhlResponse response = bfhlService.processData(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            BfhlResponse errorResponse = BfhlResponse.builder()
                    .is_success(false)
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (Exception e) {
            BfhlResponse errorResponse = BfhlResponse.builder()
                    .is_success(false)
                    .build();
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getOperationCode() {
        Map<String, Object> response = new HashMap<>();
        response.put("operation_code", 1);
        return ResponseEntity.ok(response);
    }
}
