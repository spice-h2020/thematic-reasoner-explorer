package com.github.spiceh2020.thematicreasonerexplorer.controller;

import com.google.gson.JsonArray;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.rdfconnection.RDFConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class ThematicReasonerExplorerApplicationController {
    private static final Logger logger = LoggerFactory.getLogger(ThematicReasonerExplorerApplicationController.class);
    @Value("${endpoint}")
    private String endpoint;

    @GetMapping(value = "/getTopicallyAssociatedStories", produces = "application/json")
    public String dmh(@RequestParam(value = "theme") String theme) throws TemplateException, IOException {
        System.out.println("request " + theme);
        InputStream is = getClass().getClassLoader().getResourceAsStream("selectStoriesByTheme.sparql");
        String selectStoriesByTheme = IOUtils.toString(is, StandardCharsets.UTF_8);
        ParameterizedSparqlString pss = new ParameterizedSparqlString(selectStoriesByTheme);
        pss.setIri("theme", theme);

        JsonArray arr = new JsonArray();

        try (RDFConnection conn = RDFConnection.connect(endpoint)) {
            conn.querySelect(pss.asQuery(), (qs) -> arr.add(qs.getLiteral("storyContent").getValue().toString()));
        }

        return arr.toString();
    }


    @GetMapping(value = "/sparql")
    public String getEndpoint(@RequestParam(value = "query") String query) {
        return new RestTemplate().getForObject(endpoint + "?query={query}", String.class, query);
    }

    @PostMapping(value = "/sparql")
    public String postEndpoint(@RequestParam(value = "query") String query) {
        return new RestTemplate().getForObject(endpoint + "?query={query}", String.class, query);
    }

}
