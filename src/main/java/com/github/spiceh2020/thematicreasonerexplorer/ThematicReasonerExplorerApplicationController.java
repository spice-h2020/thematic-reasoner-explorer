package com.github.spiceh2020.thematicreasonerexplorer;

import com.github.spiceh2020.thematicreasonerexplorer.model.Theme;
import com.google.gson.JsonArray;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ThematicReasonerExplorerApplicationController {
    @Value("${endpoint}")
    private  String endpoint;
    private static  final Logger logger = LoggerFactory.getLogger(ThematicReasonerExplorerApplicationController.class);

    @GetMapping(value = "/getTopicallyAssociatedStories", produces = "application/json")
    public String dmh(@RequestParam(value = "theme") String theme) throws TemplateException, IOException {
        System.out.println("request " + theme);
        InputStream is = getClass().getClassLoader().getResourceAsStream("selectStoriesByTheme.sparql");
        String selectStoriesByTheme = IOUtils.toString(is, "UTF-8");
        ParameterizedSparqlString pss = new ParameterizedSparqlString(selectStoriesByTheme);
        pss.setIri("theme", theme);

        JsonArray arr = new JsonArray();

        try (RDFConnection conn = RDFConnection.connect(endpoint)) {
            conn.querySelect(pss.asQuery(), (qs) -> arr.add(qs.getLiteral("storyContent").getValue().toString()));
        }

        return arr.toString();
    }

}
