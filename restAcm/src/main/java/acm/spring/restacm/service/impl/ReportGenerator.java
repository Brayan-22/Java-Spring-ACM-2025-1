package acm.spring.restacm.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class ReportGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);
    private String reportType;
    private String reportData;
    private final String instanceId;

    public ReportGenerator() {
        this.instanceId = UUID.randomUUID().toString().substring(0,8);
        logger.info("ReportGenerator instanceId: {}", instanceId);
    }

    public void configure(String reportType,String reportData){
        this.reportType = reportType;
        this.reportData = reportData;
        logger.info("ReportGenerator reportType: {}", reportType);
        logger.info("ReportGenerator reportData: {}", reportData);
    }

    public String generateReport() {
        logger.info("Generating report of type: {}", reportType);
        logger.info("Report data: {}", reportData);
        String report = "";
        try{
            Thread.sleep(1000);
            // Simulate report generation
            report = "Report of type " + reportType + " with data: " + reportData;
            logger.info("Generated report: {}", report);
        }catch (InterruptedException e){
            logger.error("Report generation interrupted", e);
            Thread.currentThread().interrupt();
        }
        return report;
    }
}
