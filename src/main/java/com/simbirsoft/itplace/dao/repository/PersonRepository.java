package com.simbirsoft.itplace.dao.repository;

import com.simbirsoft.itplace.domain.entity.PersonalData;

/**
 * Репозиторий для получения персональных данных. Прочитайте про Data Access Layer
 *
 * @author a.stratonov
 * @version 1.0
 */
public interface PersonRepository {

    /**
     * получение персональных данных из хранилища
     * @return {@link PersonalData}
     */
    PersonalData getPersonalData();
}
