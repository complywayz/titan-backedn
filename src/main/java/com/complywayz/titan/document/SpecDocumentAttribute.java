package com.complywayz.titan.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class SpecDocumentAttribute
{
    @JsonProperty
    private String title;
    @JsonProperty
    private String version;
    @JsonProperty
    private String description;
    @JsonProperty
    private String genralRequirment;
    @JsonProperty
    private String[] variant = new String[]{};
    @JsonProperty
    private Date updatets;
}
