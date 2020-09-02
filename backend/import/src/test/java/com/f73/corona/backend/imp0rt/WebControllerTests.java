package com.f73.corona.backend.imp0rt;

import com.f73.corona.backend.imp0rt.models.Dataset;
import com.f73.corona.backend.imp0rt.models.Province;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureDataJpa
public class WebControllerTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeAll
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testProvince() throws Exception {
        Dataset set = new Dataset();
        set.setProvince(Province.BAVARIA);
        ResultActions actions = mvc.perform(MockMvcRequestBuilders.put("/province").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "  \"province\": \"MECKLENBURG_WEST_POMERANIA\",\n" +
                "  \"personsIndoor\": 12,\n" +
                "  \"personsOutdoor\": 50,\n" +
                "  \"householdsIndoor\": 5,\n" +
                "  \"householdsOutdoor\": 10,\n" +
                "  \"maskMandatory\": true,\n" +
                "  \"buildingTypesClosed\": [{\n" +
                "    \"name\":\"Biergärten\"\n" +
                "  }],\n" +
                "  \"personsPsmIndoor\": 4,\n" +
                "  \"personsPsmOutdoor\": 6,\n" +
                "  \"other\": \"\"\n" +
                "}"));
        log.info(String.valueOf(actions.andReturn().getResponse().getStatus()));
        log.info(actions.andReturn().getResponse().getContentAsString());
    }
}
