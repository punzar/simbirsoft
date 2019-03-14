package com.simbirsoft.itplace;

import com.simbirsoft.itplace.service.api.SummaryService;
import com.simbirsoft.itplace.service.impl.SummaryServiceImpl;
import org.apache.log4j.Logger;

/**
 * Точка входа в программу
 *
 * @author a.stratonov and m.pynzar
 * @version 1.0
 */
public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        SummaryService summaryService = new SummaryServiceImpl("person.properties");
        summaryService.createHtmlFile("src/main/webapp/summary.html");
        log.info("Это информационное сообщение в мои логи!");
        log.error("Это сообщение об ошибке, на всякий.");
    }

    }

