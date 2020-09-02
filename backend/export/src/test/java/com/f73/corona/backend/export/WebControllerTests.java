package com.f73.corona.backend.export;

import com.f73.corona.backend.export.controller.DataController;
import com.f73.corona.backend.export.models.Dataset;
import com.f73.corona.backend.export.models.Province;
import com.f73.corona.backend.export.persistence.DatasetRepository;
import com.f73.corona.backend.export.persistence.PersistentBuildingType;
import com.f73.corona.backend.export.persistence.PersistentDataSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
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

    @Autowired
    private DatasetRepository datasetRepository;

    @BeforeAll
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        /*PersistentBuildingType b1 = new PersistentBuildingType();
        b1.setBuildingType("haus");
        PersistentDataSet d1 = new PersistentDataSet();
        d1.setProvince(Province.BERLIN);
        d1.setHouseholdsIndoor(5);
        d1.setHouseholdsOutdoor(2);
        d1.setMaskMandatory(false);
        d1.setOther("other");
        d1.setPersonsIndoor(14);
        d1.setPersonsOutdoor(133);
        d1.setPersonsPsmIndoor(0.2);
        d1.setPersonsPsmOutdoor(0.5);
        d1.addClosedBuildingType(b1);
        datasetRepository.save(d1);*/
    }

    @Test
    public void testProvinceData() throws Exception {
        ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/province/BERLIN"));
        log.info(actions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void testProvinceList() throws Exception {
        ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/provinces"));
        log.info(actions.andReturn().getResponse().getContentAsString());
    }
}
