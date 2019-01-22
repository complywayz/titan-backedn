package com.complywayz.titan.document.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Links
{
    @JsonProperty("_self")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String self;

}
