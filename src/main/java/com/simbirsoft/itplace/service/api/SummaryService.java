package com.simbirsoft.itplace.service.api;

/**
 * Сервес для создания HTML файла для резюме
 *
 * @author a.stratonov
 * @version 1.0
 */
public interface SummaryService {

    /**
     * Метод для содздания html-файла
     * @param Path - путь для сохранения html-файла
     */
    void createHtmlFile(String Path);
}
