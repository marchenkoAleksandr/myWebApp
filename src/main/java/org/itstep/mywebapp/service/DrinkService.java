package org.itstep.mywebapp.service;

import org.itstep.mywebapp.model.Drink;

public interface DrinkService {

    Drink get(Integer userId, Integer id);

}
