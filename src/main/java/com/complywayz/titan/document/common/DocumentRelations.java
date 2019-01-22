package com.complywayz.titan.document.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class DocumentRelations
{

    @JsonProperty
    private List<Releation> reference = new ArrayList<>();
    @JsonProperty
    private List<Releation> basicIngredients= new ArrayList<>();
    @JsonProperty
    private List<Releation> optionalIngredients= new ArrayList<>();
    @JsonProperty
    private List<Releation> additives= new ArrayList<>();
    @JsonProperty
    private List<Releation> packaging= new ArrayList<>();
    @JsonProperty
    private List<Releation> labeling= new ArrayList<>();


}
