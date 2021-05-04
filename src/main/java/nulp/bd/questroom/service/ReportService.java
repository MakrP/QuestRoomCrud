package nulp.bd.questroom.service;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import nulp.bd.questroom.entity.Actor;
import nulp.bd.questroom.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private ActorRepository repository;


    public String exportReport() throws FileNotFoundException, JRException {
        String path = "D:\\Reports";
        List<Actor> actors = repository.findAll();
        InputStream employeeReportStream
                = getClass().getResourceAsStream("/actors.jrxml");
        JasperReport jasperReport
                = JasperCompileManager.compileReport(employeeReportStream);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(actors);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\actors.pdf");

        return "report generated in path : " + path;
    }
}
