package com.complywayz.titan.document.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
public class Releation
{

    public Releation(String url,GenericData<?> data)
    {
        this.links.setSelf(url);
        this.data=data;
    }
    @JsonProperty
    private Links links = new Links();

    @JsonProperty
    private GenericData<?> data;
}
