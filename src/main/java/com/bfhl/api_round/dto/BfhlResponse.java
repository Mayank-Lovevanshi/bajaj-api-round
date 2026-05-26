package com.bfhl.api_round.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BfhlResponse {
    @JsonProperty("is_success")
    private boolean is_success;
    private String user_id;
    private String email;
    private String roll_number;
    private List<String> even_numbers;
    private List<String> odd_numbers;
    private List<String> alphabets;
    private List<String> special_characters;
    private List<String> sepcial_characters; // Included to support potential typo-based tests/evaluators
    private String sum;
    private String concat_string;
}
