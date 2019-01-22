package com.complywayz.titan.document;

import com.complywayz.titan.document.common.DocumentRelations;
import com.complywayz.titan.document.common.GenericData;
import com.complywayz.titan.document.common.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class SpecDocument
{

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String,Object> meta;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Links links;

    @JsonProperty
    @NonNull
    private GenericData<SpecDocumentAttribute> data;
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DocumentRelations relations;



}
