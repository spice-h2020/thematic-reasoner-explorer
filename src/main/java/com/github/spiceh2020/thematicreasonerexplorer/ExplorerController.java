package com.github.spiceh2020.thematicreasonerexplorer;

import com.github.spiceh2020.thematicreasonerexplorer.model.Theme;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.apache.jena.rdfconnection.RDFConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class ExplorerController {

    private static final Logger logger = LoggerFactory.getLogger(ExplorerController.class);
    @Value("${endpoint}")
    private  String endpoint;

    @GetMapping(value = "/explorer")
    public void explorer(Model model) throws TemplateException, IOException {

        String selectThemes = IOUtils.toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("selectThemes.sparql")), StandardCharsets.UTF_8);

        List<Theme> themes = new ArrayList<>();
        try (RDFConnection conn = RDFConnection.connect(endpoint)) {
            conn.querySelect(selectThemes, (qs) -> {
                String topicURI = qs.getResource("t").getURI();
                String topicLabel = qs.getLiteral("tLabel").getValue().toString();
                logger.trace("Topic URI {}, {}", topicURI, topicLabel);
                themes.add(new Theme(topicURI, topicLabel));
            });
        }

        model.addAttribute("themes", themes);

//        if (theme != null) {
//            System.out.println("request " + theme);
//            String selectStoriesByTheme = IOUtils.toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("selectStoriesByTheme.sparql")), StandardCharsets.UTF_8);
//            ParameterizedSparqlString pss = new ParameterizedSparqlString(selectStoriesByTheme);
//            pss.setIri("theme", theme);
//
//            List<Story> arr = new ArrayList<>();
//            AtomicInteger ai = new AtomicInteger(0);
//            try (RDFConnection conn = RDFConnection.connect(endpoint)) {
//                conn.querySelect(pss.asQuery(), (qs) -> arr.add(new Story(qs.getLiteral("storyContent").getValue().toString(), "Story #" + ai.incrementAndGet())));
//            }
//            model.addAttribute("stories", arr);
//
//        }


    }
}
