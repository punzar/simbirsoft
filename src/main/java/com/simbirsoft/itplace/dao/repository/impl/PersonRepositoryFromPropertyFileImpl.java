package com.simbirsoft.itplace.dao.repository.impl;

import com.simbirsoft.itplace.common.constants.PersonPropertyKeys;
import com.simbirsoft.itplace.dao.repository.PersonRepository;
import com.simbirsoft.itplace.domain.entity.PersonalData;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Реализация репозитория @see {@link PersonRepository}
 *
 * @author an.stratonov and m.punzar
 * @version 1.0
 */
public class PersonRepositoryFromPropertyFileImpl implements PersonRepository {
    private static final Logger log = Logger.getLogger(PersonRepositoryFromPropertyFileImpl.class);

    /**
     * Свойство - опыт работы
     */
    private Properties personDataFile;

    public PersonRepositoryFromPropertyFileImpl(InputStream configFileInput){
        this.personDataFile = getProperties(configFileInput);
    }

    /**
     * Возвращает объект файла найстроек
     *
     * @param configFileInput - поток файла настроек
     * @return - объект Properties
     */
    private Properties getProperties(InputStream configFileInput) {
        Properties property = new Properties();
        try {
            property.load(new InputStreamReader(configFileInput, Charset.forName("UTF-8")));
            log.info("открыл properties");
            return property;
        } catch (FileNotFoundException e) {
            log.error("can't find file");
            System.out.println("Не найден файл настроек");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("can't find file");
        }
        return null;
    }

    /**
     * @see PersonRepository
     */
    @Override
    public PersonalData getPersonalData() {
        PersonalData personalData = null;
        if(this.personDataFile != null){
            personalData = new PersonalData(
                    personDataFile.getProperty(PersonPropertyKeys.FIO),
                    personDataFile.getProperty(PersonPropertyKeys.DOB),
                    personDataFile.getProperty(PersonPropertyKeys.PHONE),
                    personDataFile.getProperty(PersonPropertyKeys.EMAIL),
                    personDataFile.getProperty(PersonPropertyKeys.SKYPE),
                    personDataFile.getProperty(PersonPropertyKeys.AVATAR),
                    personDataFile.getProperty(PersonPropertyKeys.TARGET),
                    personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES),
                    personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS),
                    personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS),
                    personDataFile.getProperty(PersonPropertyKeys.SKILLS),
                    personDataFile.getProperty(PersonPropertyKeys.EXAMPLES_CODE)
            );
        }
        return personalData;
    }
}
