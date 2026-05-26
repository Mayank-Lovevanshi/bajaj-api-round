package com.bfhl.api_round.service;

import com.bfhl.api_round.dto.BfhlRequest;
import com.bfhl.api_round.dto.BfhlResponse;

public interface BfhlService {
    BfhlResponse processData(BfhlRequest request);
}
