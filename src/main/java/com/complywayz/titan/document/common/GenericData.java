package com.complywayz.titan.document.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GenericData<T>
{
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonProperty
    @NonNull
    private DataType type;
    @JsonProperty
    @NonNull
    private String title;
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T attributes;
}
