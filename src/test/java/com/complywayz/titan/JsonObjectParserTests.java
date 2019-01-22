package com.complywayz.titan;

import com.complywayz.titan.document.SpecDocument;
import com.complywayz.titan.document.SpecDocumentAttribute;
import com.complywayz.titan.document.common.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonObjectParserTests
{
    private Logger logger = LoggerFactory.getLogger(JsonObjectParserTests.class);
    private final String JSON_OUT_FOLDER="./build/json-out";
    @Autowired
    private ObjectMapper mapper;


    @Before
    public void setup() throws Exception
    {
        FileUtils.forceMkdir(new File(JSON_OUT_FOLDER));
    }
    @Test
    public void testGenricDataParser() throws Exception
    {
        GenericData<SpecDocumentAttribute> data = new GenericData<>();
        SpecDocumentAttribute attribute = new SpecDocumentAttribute();
        attribute.setDescription("test description");
        attribute.setTitle("test");
        attribute.setVersion("191380938093109");
        attribute.setVariant(new String[]{"Variant1","Variant2"});
        attribute.setUpdatets(new Date());

        data.setId("292389238832");
        data.setTitle("aranga");
        data.setType(DataType.text);
        data.setAttributes(attribute);
        logger.info(mapper.writeValueAsString(data));
        Links links = new Links();
        links.setSelf("http://example.com/mylinks/1");
        System.out.println(mapper.writeValueAsString(links));

    }

    @Test
    public void testDeserialise() throws Exception
    {
        GenericData<SpecDocumentAttribute> documentData = new GenericData<>();
        SpecDocumentAttribute attributes = new SpecDocumentAttribute();
        documentData.setAttributes(attributes);
        documentData.setType(DataType.specification);
        documentData.setTitle("Instant Noodles");
        documentData.setId("0");
        attributes.setDescription("This applies to instant noodles packaged with or without noodle seasonings, or in the form of seasoned\n" +
                "noodle and with or without noodle garnishing(s) in separate pouches, or sprayed on noodle, dehydrated\n" +
                "by frying or other means and ready for consumption or cooking. Product characterized by the use of\n" +
                "pregelatinization process. Pasta excluded.");
        attributes.setGenralRequirment("Needs to be acceptable in terms of appearance, texture, aroma, flavour and colour\n" +
                "Needs to be free from any undesirable off-flavours and odors\n" +
                "Shall be free from moulds, insect infestation, impurities, any other foreign matter and evidence of staleness\n" +
                "Product shall not contain more than 10% of broken and mishappen units\n" +
                "Needs to be absent of any extraneous flour or starch or any extraneous matter\n" +
                "Cooking time:\n" +
                "Not more than four minutes in boiling water (as per the method given in SLS 1534)");
        attributes.setTitle("Instant Noodles");
        attributes.setVersion("001");
        attributes.setVariant(new String[]{"Fried Noodles","Non Fried Noodles"});
        attributes.setUpdatets(new Date());

        //
        DocumentRelations relations = new DocumentRelations();
        relations.getReference().add(new Releation("/titan/reference/1",new GenericData<>("1",DataType.reference,"Food Act No 26 of 1980",null)));
        relations.getReference().add(new Releation("/titan/reference/2",new GenericData<>("2",DataType.reference,"Food (Standards) Regulation of 1989/1990",null)));
        relations.getReference().add(new Releation("/titan/reference/3",new GenericData<>("3",DataType.reference,"SLS 1534:2016 Specification for Instant Noodles",null)));

        relations.getBasicIngredients().add(new Releation("/titan/specification/4",new GenericData<>("4",DataType.reference,"Wheat Flour",null)));
        relations.getBasicIngredients().add(new Releation("/titan/specification/5",new GenericData<>("5",DataType.reference,"Rice Flour",null)));
        relations.getBasicIngredients().add(new Releation("/titan/specification/6",new GenericData<>("6",DataType.reference,"Edible Flour",null)));
        relations.getBasicIngredients().add(new Releation("/titan/specification/7",new GenericData<>("7",DataType.reference,"Starches",null)));
        relations.getBasicIngredients().add(new Releation("/titan/specification/8",new GenericData<>("8",DataType.reference,"Potable water",null)));
        SpecDocument document = new SpecDocument();
        document.setData(documentData);
        document.setRelations(relations);
        FileUtils.write(new File(JSON_OUT_FOLDER+"/instance-noodle.json"),mapper.writeValueAsString(document),"utf-8");




    }

}
